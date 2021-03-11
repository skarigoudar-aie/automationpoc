package com.mk.testframework.stepdefs.crossPlatformSteps.allRegions;

import java.net.MalformedURLException;
import java.net.URL;
import cucumber.api.java.en.And;
import org.apache.commons.lang3.LocaleUtils;
import org.junit.Assert;
import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.util.MkPageNavigator;
import com.mk.testframework.dt.util.PageUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


/**
 * @author VThipperudrappa
 *
 */
@SuppressWarnings("deprecation")
public class PageNavigationStepdef {
	private MkPageNavigator mkPageNavigator;
	private Context context;
	private Environment env;
	private PageUtils pageUtils;

	@Inject
	public PageNavigationStepdef(MkPageNavigator mkPageNavigator, Context context, Environment env, PageUtils pageUtils) {
		this.mkPageNavigator = mkPageNavigator;
		this.context = context;
		this.env = env;
		this.pageUtils = pageUtils;
	}

	@Given("I navigate to MK HomePage")
	public void i_navigate_to_MK_HomePage() {
			mkPageNavigator.goToHomePage();
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
	}
	
	@Given("I click on browser forward button")
	public void i_click_on_browser_forward_button() {
		pageUtils.clickBrowserForwardButton();
	}

	@Given("I click on browser back button")
	public void i_click_on_browser_back_button() {
		pageUtils.clickBrowserBackButton();
	}

	@Then("I can verify the switch to country")
	public void i_can_verify_the_switch_to_country() throws MalformedURLException {
		String targetLocale = context.getSavedData("targetLocale");
		URL currentUrl = new URL(pageUtils.getCurrentUrl());
		URL expectedUrl = new URL(env.getMkUrl(LocaleUtils.toLocale(targetLocale)));
		Assert.assertEquals("domain do not match", expectedUrl.getHost(), currentUrl.getHost());
		Assert.assertEquals("locale is not rendered", targetLocale, mkPageNavigator.getBodyIdAttribute());
		mkPageNavigator.goToHomePage();
	}

	@Given("I am on the product detail page")
	public void i_am_on_the_product_detail_page() {
		Assert.assertTrue("Not on product detail page", mkPageNavigator.onProductDetailPage());
	}

	@Given("I am on the product listing page")
	public void i_am_on_the_product_listing_page() {
		Assert.assertTrue("Not on product listing page", mkPageNavigator.onProductListingPage());
	}

	@And("I am on the search listing page")
	public void iAmOnTheSearchListingPage() {
		Assert.assertTrue("Not on search listing page", mkPageNavigator.onSearchPage());
	}
	
	@Then("I am able to see the Search Page")
	public void i_am_able_to_see_the_search_page() {
		Assert.assertTrue("Expected to be on Search Page", mkPageNavigator.onSearchPage());
	}
	
	@Given("I refresh the browser")
	public void i_refresh_browser() {
		pageUtils.refresh();
	}

	@And("I am on the Shopping Bag page")
	public void iAmOnTheShoppingBagPage() {
		Assert.assertTrue("not on Shopping Bag page", mkPageNavigator.onShoppingBagPage());
	}
	
	@And("SHIPPING: I am on the Shipping page")
	public void iAmOnTheShippingPage() {
		Assert.assertTrue("not on Shipping page", mkPageNavigator.onShippingPage());
	}
	
	@And("I am on The Fluid PDP")
	public void iAmOnTheFluidPDP() {
		Assert.assertTrue("not on The Fluid PDP", mkPageNavigator.onFluidPDP());
	}
	
    @Then("I navigate to the Payment information page")
	public void i_navigate_to_the_Payment_information_page() {
		Assert.assertTrue("Expected to be on Payment information Page", mkPageNavigator.onPaymentinformationPage());
	
	}
	@Then("I navigate to the Order history page")
	public void i_navigate_to_the_Order_history_page() {
		Assert.assertTrue("Expected to be on Order history Page", mkPageNavigator.onOrderHistoryPage());
		
	
	}
	@Then("I navigate to the Favorite page")
	public void i_navigate_to_the_Favorite_page() {
		Assert.assertTrue("Expected to be on Favorite Page", mkPageNavigator.onFavouritePage());
	}
	@Then("I am on Homepage")
	public void iAmOnHomePage()
	{
		Assert.assertTrue("Expected to be on homePage", mkPageNavigator.onHomePage());
		
	}
	@Then("Profile: I am on Profile Page")
	public void iAmOnProfilePage()
	{
	Assert.assertTrue("Expected to be on Profile page", mkPageNavigator.onProfileLandingPage());
	}
	
	@And("I am on the Gift Card landing page")
	public void iAmOnTheGiftCardLandingPage() {
		Assert.assertTrue("not on Gift Card Landing Page", mkPageNavigator.onGiftCardLandingPage());
	
	}
	
}
