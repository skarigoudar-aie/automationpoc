package com.mk.testframework.stepdefs.crossPlatformSteps.allRegions;

import com.mk.testframework.core.env.Context;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import org.junit.Assert;
import com.google.inject.Inject;
import com.mk.testframework.dt.page.searchlisting.MkProductListing;
import com.mk.testframework.dt.page.searchlisting.MkSortResultCountPanel;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

/**
 * @author VThipperudrappa
 *
 */
@SuppressWarnings("deprecation")
public class ProductListingPageStepDefCommon {
	private MkSortResultCountPanel mkSortResultCountPanel;
	private MkProductListing mkProductListing;
	private Context context;

	@Inject
	public ProductListingPageStepDefCommon(WebDriver webDriver, MkProductListing mkProductListing, MkSortResultCountPanel mkSortResultCountPanel,
										   Context context) {
		this.mkSortResultCountPanel = mkSortResultCountPanel;
		this.mkProductListing = mkProductListing;
		this.context = context;
	}

	@Given("PLP: I verify there are at least {int} products displayed")
	public void i_verify_there_are_at_least_products_displayed(Integer expectedProductCount) {
		int actualProductCount = mkSortResultCountPanel.getProductCount();
		Assert.assertTrue("Expected number of products displayed incorrect",
				actualProductCount >= expectedProductCount.intValue());
	}

	@Given("PLP: I click on the product name")
	public void i_click_on_the_product_name() {
		if(mkProductListing.waitForProductTile()){
			mkProductListing.descriptionPanel().clickOnProductName();
		}
	}
	
	@Given("PLP: I click on the product name which has list and sale price")
	public void i_click_on_the_product_name_which_has_sale_Price() {
		if(mkProductListing.waitForProductTile()){
			mkProductListing.descriptionPanel().clickOnProductWhichHasSalePrice();
		}
	}

	@Given("PLP: I click on the product price")
	public void i_click_on_the_product_price() {
		if(mkProductListing.waitForProductTile()){
			mkProductListing.descriptionPanel().clickOnProductPrice();
		}
	}

	@Given("PLP: I click on the product image")
	public void i_click_on_the() {
		if(mkProductListing.waitForProductTile()){
			mkProductListing.descriptionPanel().clickOnProductImage();
		}
	}

	@Given("PLP: I verify that promo sections are displayed")
	public void i_verify_that_promo_sections_are_displayed() {
		Assert.assertTrue("Promo sections not displayed",
				mkProductListing.hasPromoSections() || mkProductListing.hasMkAccessPromoSections());
	}

	@Given("PLP: I click a random product in the product list")
	public void i_click_a_random_product_in_the_product_list() {
		mkProductListing.clickRandomProduct();
	}

	@Given("PLP: I click a product position {int} in the product list")
	public void i_click_a_product_in_the_product_list(int number) {
		mkProductListing.clickProductAtPosition(number);
	}

	@And("PLP: I get the count of products for the selected filter facet")
	public void plpIGetTheCountOfProductsForTheSelectedFilterFacet() {
		int productCount = mkSortResultCountPanel.getProductCount();
		context.setListingPageProductCount(productCount);
	}

	@Then("PLP: I verify the count of products is updated on adding the next filter facet")
	public void plpIVerifyTheCountOfProductsIsUpdatedOnAddingTheNextFilterFacet() {
		int beforeCount = context.getListingPageProductCount();
		int afterCount = mkSortResultCountPanel.getProductCount();
		
		if (beforeCount==afterCount) {
			mkProductListing.ReloadPage();
			afterCount = mkSortResultCountPanel.getProductCount();
		}
		
		Assert.assertFalse("Before filter: "+beforeCount+", After filter: "+afterCount, beforeCount==afterCount);
	}
	
	@Then("PLP: I verify list and sale price displayed")
	public void plpVerifySaleAndListPriceDisplay() {
		Assert.assertTrue("Was and now price not present", mkProductListing.descriptionPanel().isPriceLabelDisplayed());
	}

	@And("PLP: I click on the product quick view")
	public void plpIClickOnTheProductQuickView() {
		if (mkProductListing.waitForProductTile()) {
			mkProductListing.descriptionPanel().clickOnProductQuickView();
		}
	}
	
	@And("PLP: I verify product names displayed for all the products")
	public void i_verify_product_names_displayed_for_all_products_on_plp() {
		Assert.assertTrue("Product names are not displayed", mkProductListing.isProductNameDisplayedForAllProduct());
	}

	@And("PLP: I verify Color Swatches when multiple colors are available")
	public void i_verify_product_color_swatches_displayed_on_plp() {
		Assert.assertTrue("Product Color swatches are not displayed", mkProductListing.isColorSwatchDisplayedOnPLP());

		}
	
	@And("PLP: Load all the products")
	public void i_load_all_products() {
		mkProductListing.loadAllProducts();
	}
	
	@And("PLP: I verify all links {string} are functional in hero banner")
	public void iVerifyAllLinksAreFunctionalInHeroBanner(String links) throws MalformedURLException, UnsupportedEncodingException {
	
		Assert.assertTrue("Links are not functional in Hero Banner",mkProductListing.isLinksFunctionalInHeroBanner());
	}
	
	@Then("PLP: I verify the page name and url")
	public void plpIVerifyThePageNameAndURL() {
		mkProductListing.getPageNameAndURL();
	}

}
