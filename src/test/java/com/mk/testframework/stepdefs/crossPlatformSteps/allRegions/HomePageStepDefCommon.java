package com.mk.testframework.stepdefs.crossPlatformSteps.allRegions;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.page.home.MkHomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * @author VThipperudrappa
 *
 */
@SuppressWarnings("deprecation")
public class HomePageStepDefCommon {
	private MkHamburgerMenu mkHamburgerMenu;
	private MkHomePage mkHomePage;
	private PageNavigationStepdef pageNavigationStepdef;
	private TestData testData;
	private Environment env;

	@Inject
	public HomePageStepDefCommon(MkHomePage mkHomePage, MkHamburgerMenu mkHamburgerMenu, PageNavigationStepdef pageNavigationStepdef,
								 TestData testData, Environment env) {
		this.mkHamburgerMenu = mkHamburgerMenu;
		this.mkHomePage = mkHomePage;
		this.pageNavigationStepdef = pageNavigationStepdef;
		this.testData = testData;
		this.env = env;
	}

	@Given("HEADER: I can see mk logo")
	public void i_can_see_mk_logo() {
		Assert.assertTrue("MK Logo missing", mkHamburgerMenu.isMkLogoPresent());
	}

	@Given("HEADER: I can see magnifying glass icon")
	public void i_can_see_magnifying_glass_icon() {
		Assert.assertTrue("magnifying glass missing", mkHamburgerMenu.isMagnifyingGlassIconDisplayed());
	}

	@Given("HEADER: I can see shopping bag icon")
	public void i_can_see_shopping_bag_icon() {
		Assert.assertTrue("Shopping bag icon missing", mkHamburgerMenu.isShoppingBagIconDisplayed());
	}

	@Given("HP: I verify content exists")
	public void i_verify_content_exists() {
		Assert.assertTrue("Promo sections missing on the page", mkHomePage.hasPromoSections());
	}

	@And("HomePage: I click on search link")
	public void homepageIClickOnSearchLink() {
		pageNavigationStepdef.i_navigate_to_MK_HomePage();
		mkHamburgerMenu.clickSearchLink();
	}

	@And("FOOTER: I click on find a store link")
	public void I_click_on_find_a_store_link() {
		mkHamburgerMenu.clickStoreLocator();
	}

	@When("FOOTER: I populate the email id for signup")
	public void I_populate_the_email_id_for_signup() {
		mkHomePage.enterEmailid(testData.getUser().getEmail());
	}

	@And("FOOTER: I click on signup button")
	public void I_click_on_signup_button() {
		mkHomePage.clickOnfooterSignUp();
	}
	
	@When("FOOTER: I enter the email id for signup")
	public void I_enter_the_email_id_for_signup() {
		mkHomePage.enterEmailid(testData.getUser().getEmail());
	}

	@And("Login: I enter email address in account page")
	public void i_enter_email_address_in_account_page() {
		mkHomePage.enterEmailidInAccountPage(testData.getUser().getEmail());
	}
	
	@And("Login: I enter password in account page")
	public void i_enter_password_in_account_page() {
		mkHomePage.enterPasswordInAccountPage(testData.getUser().getPassword());
	}
	
	@When("Login: I click Sign In button in account page")
	public void i_click_0n_signIn_button_in_account_page() {
		mkHomePage.clickOnSignInInAccountPage();
	}
	
	@Then("I verify Order History page is displayed")
	public void i_check_Order_History_Page_Isdisplaying() {
		mkHomePage.isOrderHistoryPageDisplayed();
	}
	
	@Then("I verify that canonical url for the accessed site exists")
	public void iVerifyThatCanonicalUrlForTheAccessedSiteExists() {
		String expected = env.getMkUrl();
		String actual = mkHomePage.getCanonicalLink();

		Assert.assertTrue("SEO url doesn't match. Expected: "+expected+" | Actual: "+actual, expected.contains(actual));
	}
	
	@Then("HEADER: I Verify that shopping bag has item")
	public void i_verify_that_shopping_bag_has_item() {
		Assert.assertTrue("Shopping bag has no item", mkHamburgerMenu.shoppingBagHasItems());
	}
	
	@Then("HEADER: I Verify that shopping bag has no item")
	public void i_verify_that_shopping_bag_has_no_item() {
		Assert.assertFalse("Shopping bag has item", mkHamburgerMenu.shoppingBagHasItems());
	}
	
	@And("HEADER: I verify PPH banner")
	public void iVerifyPPHBanner() {
		Assert.assertTrue("PPH banner not displayed", mkHamburgerMenu.isPPHDisplayed());
	}
	
	@And("HEADER: I verify MK Logo")
	public void iVerifyMKLogo() {
		Assert.assertTrue("MK Logo not displayed", mkHamburgerMenu.isMkLogoPresent());
	}
	
	@And("MENU: I verify search icon")
	public void iVerifySearchIcon() {
		Assert.assertTrue("Search icon not displayed", mkHamburgerMenu.isSearchIconDisplayed());
	}
	
	@And("HEADER: I verify Mini Cart icon")
	public void iVerifyMiniCartIcon() {
		Assert.assertTrue("Mini cart icon not displayed", mkHamburgerMenu.isMiniCartIconDisplayed());
	}
	
	@And("I verify page redirection")
	public void iVerifyPageRedirection() {
    	Assert.assertTrue("Page redirection not happened", mkHomePage.verifyPageRedirection());
	}
	
	@And("I Click bottom footer links")
	public void iClickBottomFooterLinks() {
		mkHomePage.clickBottomFooterLinks();
	}
	
	@Then("FOOTER: I click on gift card link")
	public void iClickOnGiftCardLink() {
		mkHomePage.cliclkOnGiftCardLinkFromFooter();
	}
	
	@And("Go to homepage")
	public void Gotohomepage() {
		mkHomePage.clickonMklogo();
	}
	
	
}
