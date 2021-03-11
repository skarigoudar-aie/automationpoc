package com.mk.testframework.stepdefs.crossPlatformSteps.allRegions;

import java.io.IOException;
import org.junit.Assert;
import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.page.searchlisting.MkProductListing;
import com.mk.testframework.dt.page.searchlisting.MkSearchBox;
import com.mk.testframework.dt.page.searchlisting.MkSearchListing;
import com.mk.testframework.dt.page.searchlisting.MkSortResultCountPanel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * @author VThipperudrappa
 *
 */
@SuppressWarnings("deprecation")
public class SearchListingPageStepDef {
	private MkSearchBox mkSearchBox;
	private TestData testData;
	private Context context;
	private MkProductListing mkProductListing;
	private MkSortResultCountPanel mkSortResultCountPanel;
	private MkSearchListing mkSearchListing;

	@Inject
	public SearchListingPageStepDef(MkSortResultCountPanel mkSortResultCountPanel, MkSearchBox mkSearchBox,
									MkProductListing mkProductListing, TestData testData, Context context, MkSearchListing mkSearchListing) {
		this.mkSearchBox = mkSearchBox;
		this.mkProductListing = mkProductListing;
		this.testData = testData;
		this.context = context;
		this.mkSortResultCountPanel = mkSortResultCountPanel;
		this.mkSearchListing = mkSearchListing;
	}

	@Given("SLP: I type {string} into the search box and press key enter")
	public void i_type_into_the_search_box(String testDataLookup) {
		String value = testData.getProductProperty(testDataLookup);
		context.writeOut("lookup : " + value);
		mkSearchBox.waitForSearchBox();
		mkSearchBox.typeIntoSearchBox(value);
		mkSearchBox.pressEnter();
		
	}

	@Then("SLP: the product name displayed should match product {string}")
	public void the_product_name_should_match_should_be_displayed(String alias) throws IOException {
		String expectedProductName = testData.getProduct(alias).getProductName();
		context.writeOut("Expected : " + expectedProductName);
		Assert.assertEquals("Product name comparison failed", expectedProductName,
				mkProductListing.descriptionPanel().getProductName());
	}

	@Given("SLP: I click on the product name")
	public void i_click_on_the_product_name() {
		if(mkProductListing.waitForProductTile()){
			mkProductListing.descriptionPanel().clickOnProductName();
		}
	}

	@Given("SLP: I click on the product price")
	public void i_click_on_the_product_price() {
		if(mkProductListing.waitForProductTile()){
			mkProductListing.descriptionPanel().clickOnProductPrice();
		}
	}

	@Given("SLP: I click on the product image")
	public void i_click_on_the() {
		if(mkProductListing.waitForProductTile()){
			mkProductListing.descriptionPanel().clickOnProductImage();
		}
	}

	@And("SLP: I click on the product quick view")
	public void slpIClickOnTheProductQuickView() {
		if(mkProductListing.waitForProductTile()){
			mkProductListing.descriptionPanel().clickOnProductQuickView();
		}
	}

	@Given("SLP: I verify there are at least {int} products displayed")
	public void i_verify_there_are_at_least_products_displayed(Integer expectedProductCount) {
		int actualProductCount = mkSortResultCountPanel.getProductCount();
		try{
			Assert.assertTrue("Expected number of products wrong", actualProductCount >= expectedProductCount.intValue());
		}catch (Exception e) {
			Assert.assertTrue("Expected number of products wrong", actualProductCount >= expectedProductCount.intValue());
		}
	}

	@And("SLP: I get the count of products for the selected filter facet")
	public void slpIGetTheCountOfProductsForTheSelectedFilterFacet() {
		int productCount = mkSortResultCountPanel.getProductCount();
		context.setListingPageProductCount(productCount);
	}

	@Given("SLP: I click a product position {int} in the product list")
	public void i_click_a_product_in_the_product_list(int number) {
		mkProductListing.clickProductAtPosition(number);
	}

	@Then("SLP: I verify the count of products is updated on adding the next filter facet")
	public void slpIVerifyTheCountOfProductsIsUpdatedOnAddingTheNextFilterFacet() {
		int beforeCount = context.getListingPageProductCount();
		int afterCount = mkSortResultCountPanel.getProductCount();

		if (beforeCount==afterCount) {
			mkProductListing.ReloadPage();
			afterCount = mkSortResultCountPanel.getProductCount();
		}
		
		Assert.assertFalse("Before filter: "+beforeCount+", After filter: "+afterCount, beforeCount==afterCount);
	}
	
	@Then("SLP: I verify No Results Found For message is displaying")
	public void No_Results_Found_For_message_is_displaying(){
		mkSearchBox.getSearchResultMessage();	
	}
	
	@Then("SLP: Verify search field is displaying")
	 public void Verify_search_field_is_displaying() {
	  mkSearchBox.searchBoxIsDisplaying();
	 }
	 
	 @And("SLP: Verify close button is displaying")
	 public void close_button_is_displaying() {
	  mkSearchBox.closeButtonIsDisplaying();
	 }
	 
	 @And("SLP: I capture the product name on SLP")
	    public String I_capture_the_product_name_on_SLP() {
	     return mkProductListing.captureProductName();
	 }
	    
	 @Then("SLP: I Verify same product is displaying on SLP as on PDP page")
	    public void same_productis_displaying_on_SLP_as_on_PDP_page() {
	    String expected=context.getPdpProductName().toLowerCase(); 
	    String actual=I_capture_the_product_name_on_SLP().toLowerCase();  
	    Assert.assertTrue("Product name doesn't match", expected.equalsIgnoreCase(actual));  
	}
	 
	@And("SLP: I verify product names displayed for all the products")
	public void i_verify_product_names_displayed_for_all_products_on_plp() {
		Assert.assertTrue("Product names are not displayed", mkProductListing.isProductNameDisplayedForAllProduct());
	}
				
    @And("SLP: I Verify product recommendation container is displaying")
	public void iVerifyProductRecommendationWidgetIsDisplaying() {
		Assert.assertTrue("Product recommendation widget not available on PDP", mkSearchListing.productRecommendationRFKIsDisplayed());
	}
    
    @And("SLP: I verify slider recommendations is displaying and is Functional")
	public void iVerifySliderWidgetIsDisplaying_and_functional() {
		Assert.assertTrue("Slider on Product recommendations widget not available on PDP", mkSearchListing.sliderRecommendationsIsDisplayed());
		Assert.assertTrue("Slider on Product recommendations widget not Functional on PDP", mkSearchListing.sliderRecommendationsIsFunctional());
	}
    
    @And("SLP: I verify Product Name is displaying and is clickable for all the products in product recommendation")
	public void iVerifyProductNameIsDisplaying_and_Clickable() {
    	mkSearchListing.verifyProductsNameInRecommendationContainer();
	}
    
    @And("SLP: I verify Quick View is displaying and is clickable for all the products in product recommendation")
	public void iVerifyQuickViewIsDisplaying_and_Clickable() {
    	mkSearchListing.verifyQuickViewInRecommendationContainer();
	}
    
    @And("SLP: I verify color option is displaying and is clickable for all the products in product recommendation")
	public void iVerifyColorOptionIsDisplaying_and_Clickable() {
    	mkSearchListing.verifyColorOptionInRecommendationContainer();
	}
    
    @And("SLP: I verify product price is displaying for all the products in product recommendation")
	public void iVerifyProductPriceIsDisplaying_and_Clickable() {
		mkSearchListing.verifyProductPriceInRecommendationContainer();
	}
	
	 	
	@And("SLP: I search for {string} click and collect product")
	public void iHoldACCProduct(String ccProductType) {
		testData.addCCProduct(ccProductType);
		String value = testData.getCCProduct().getStyleName();
		context.writeOut("lookup : " + value);
		mkSearchBox.waitForSearchBox();
		mkSearchBox.typeIntoSearchBox(value);
		mkSearchBox.pressEnter();
	}
	 @And("I click on purchase now button for VGC PGC product")
	    public void IClickOnPurchaseNowButtonForVGCAndPGCProduct() {
	     mkProductListing.clickOnPurchaseNowButton_Gc();
	 }
}

