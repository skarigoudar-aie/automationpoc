package com.mk.testframework.stepdefs.crossPlatformSteps.allRegions;

import com.mk.testframework.dt.page.product.MkProductDetailPage;
import com.mk.testframework.dt.popup.MkBVReviewsPopUp;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import com.google.common.base.Splitter;
import com.google.inject.Inject;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.page.product.MkClickAndCollectContainer;
import com.mk.testframework.dt.page.product.MkProductContainer;
import cucumber.api.java.en.And;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class ProductDetailPageStepDef {

    private MkProductContainer mkProductContainer;
    private MkClickAndCollectContainer mkClickAndCollectContainer;
    private MkBVReviewsPopUp mkBVReviewsPopUp;
    private MkHamburgerMenu mkHamburgerMenu;
	private MkProductDetailPage mkProductDetailPage;

    @Inject
    public ProductDetailPageStepDef(MkProductContainer mkProductContainer, MkClickAndCollectContainer mkClickAndCollectContainer,
                                    MkProductDetailPage mkProductDetailPage, MkBVReviewsPopUp mkBVReviewsPopUp, MkHamburgerMenu mkHamburgerMenu) {
        this.mkProductContainer = mkProductContainer;
        this.mkClickAndCollectContainer = mkClickAndCollectContainer;
        this.mkProductDetailPage = mkProductDetailPage;
        this.mkBVReviewsPopUp = mkBVReviewsPopUp;
        this.mkHamburgerMenu = mkHamburgerMenu;
    }

    @And("PDP: I click on click and collect")
    public void pdpIClickOnClickAndCollect() {
        if (mkProductContainer.waitForButtonsContainer()) {
            mkProductContainer.clickOnClickAndCollect();
        }
        Assert.assertTrue(mkClickAndCollectContainer.waitForClickAndCollectContainer());
    }
    
    @And("PDP: I verify item name field is displayed")
    public void i_verify_item_name_is_displayed() {
        Assert.assertTrue("Name field missing", mkProductContainer.isNameDisplayed());
    }

    @And("PDP: I verify item style ID field is displayed")
    public void i_verify_item_style_id_is_displayed() {
        Assert.assertTrue("Style id field missing", mkProductContainer.isStyleIdDisplayed());
    }

    @And("PDP: I verify item price field is displayed")
    public void i_verify_item_price_is_displayed() {
        Assert.assertTrue("Price field missing", mkProductContainer.isPriceDisplayed());
    }

    @And("PDP: I verify list and sale price displayed")
    public void i_verify_item_List_Sale_price_is_displayed() {
        Assert.assertTrue("Sale Price and list price field missing", mkProductContainer.isSaleAndListPriceDisplayed());
    }
    
    @And("PDP: I verify item color field is displayed")
    public void i_verify_item_color_is_displayed() {
        Assert.assertTrue("Color field missing", mkProductContainer.isColorDisplayed());
    }

    @And("PDP: I click on Monogram It")
    public void pdpIClickOnMonogramIt() {
        mkProductContainer.clickCustomizeLink();
    }

    @And("PDP: I capture the product name on PDP")
    public void I_capture_the_product_name_on_PDP() {
        mkProductContainer.captureProductNameOnPdp();
    }

    @Then("PDP: I verify Klarna widget text displayed on product detail page")
    public void pdpIVerifyKlarnaWidgetTextDisplayedOnProductDetailPage() {
        Assert.assertTrue("Klarna widget not displayed on PDP page", mkProductDetailPage.isKlarnaWidgetDisplayed());
    }

    @When("I click the Write a review link from ratings section")
    public void iClickTheWriteAReviewLinkFromRatingsSection() {
        if(mkProductDetailPage.isRatingsContainerDisplayed()){
            mkProductDetailPage.clickRatingWriteReviewLink();
        }
    }

    @When("I click the product's star rating")
    public void iClickTheProductSStarRating() {
        if(mkProductDetailPage.isRatingsContainerDisplayed()){
            mkProductDetailPage.clickRatingStars();
        }
    }

    @When("I click the Write a review link from Reviews section")
    public void iClickTheWriteAReviewLinkFromReviewsSection() {
        mkProductDetailPage.clickReviewsWriteReviewButton();
    }

    @Then("I verify the submit button in the Post Review lightbox")
    public void iVerifyTheSubmitButtonInThePostReviewLightbox() {
        Assert.assertTrue("Submit button not available in Post Review lightbox", mkBVReviewsPopUp.postReviewButtonIsDisplayed());
    }
    
    @And("PDP: I click on size guide")
	public void pdpIClickOnSizeGuide() {
		mkProductContainer.clickOnSizeGuide();
	}
    
    @And("PDP: I can see size guide pop up")
    public void pdpICanSeeSizeGuidePopUp() {
    	Assert.assertTrue("Size guide pop up not displayed", mkProductContainer.isSizeGuidePopUpDisplayed());	
    }
    
    @And("PDP: I verify defalut selected region in the dropdown")
    public void pdpIVerifyDefalutSelectedRegionInTheDropdown() {
    	Assert.assertTrue("In correct default region selected in the size guide country dropdown", mkProductContainer.verifyDefaultSelectedRegionInSizeGuide());
    }
    
    @And("PDP: I verify default size measure")
    public void pdpI_verify_default_size_measure() {
    	Assert.assertTrue("In correct default size measure in the size guide pop up", mkProductContainer.verifyDefaultsizeMeasure());
    }
    
    @And("PDP: I change the size measure from default and verify the changes are reflecting")
    public void I_change_size_measure_from_default() {
		Assert.assertTrue("Not able to toggle between the Inches and Centimeters", mkProductContainer.verifyChangeSizeMeasureFromDefault());
    }
    
    @And("PDP: I change the size measure to default and verify the changes are reflecting")
    public void I_change_size_measure_to_default() {
		Assert.assertTrue("Not able to toggle between the Inches and Centimeters", mkProductContainer.verifyChangeSizeMeasureToDefault());
    }  
    
    @And("PDP: I verify Close mark and close the pop up")
	public void I_Verify_Close_Mark_And_Close_The_Popup() {	
		Assert.assertTrue("Close mark not displayed in size guide", mkProductContainer.isSizeGuideCloseMarkDisplayed());
		mkProductContainer.closeSizeGuide();
	}
    
    @And("PDP: I verify the size guide pop up regions {string} for shoes")
    public void pdpIVerifyTheSizeGuidePopUpForShoes(String regions) {
    	List<String> expectedRegionsInChart = Splitter.on(">").trimResults().splitToList(regions);
    	List<String> actualRegionsInChart= mkProductContainer.verifySizeGuidePopUpForShoes();
    	Collections.sort(actualRegionsInChart);
    	Assert.assertTrue("Regions not matched in the size guide of shoes", actualRegionsInChart.equals(expectedRegionsInChart));
    }
    
    @And("PDP: I Verify product recommendation container is displaying")
	public void iVerifyProductRecommendationWidgetIsDisplaying() {
		Assert.assertTrue("Product recommendation widget not available on PDP", mkProductDetailPage.productRecommendationRFKIsDisplayed());
	}
    
    @And("PDP: I verify slider recommendations is displaying and is Functional")
	public void iVerifySliderWidgetIsDisplaying_and_functional() {
		Assert.assertTrue("Slider on Product recommendations widget not available on PDP", mkProductDetailPage.sliderRecommendationsIsDisplayed());
		Assert.assertTrue("Slider on Product recommendations widget not Functional on PDP", mkProductDetailPage.sliderRecommendationsIsFunctional());
	}
    
    @And("PDP: I verify Product Name is displaying and is clickable for all the products in product recommendation")
	public void iVerifyProductNameIsDisplaying_and_Clickable() {
		mkProductDetailPage.verifyProductsNameInRecommendationContainer();
	}
    
    @And("PDP: I verify Quick View is displaying and is clickable for all the products in product recommendation")
	public void iVerifyQuickViewIsDisplaying_and_Clickable() {
		mkProductDetailPage.verifyQuickViewInRecommendationContainer();
	}
    
    @And("PDP: I verify color option is displaying and is clickable for all the products in product recommendation")
	public void iVerifyColorOptionIsDisplaying_and_Clickable() {
		mkProductDetailPage.verifyColorOptionInRecommendationContainer();
	}
    
    @And("PDP: I verify product price is displaying for all the products in product recommendation")
	public void iVerifyProductPriceIsDisplaying_and_Clickable() {
		mkProductDetailPage.verifyProductPriceInRecommendationContainer();
    }
    
    @And("PDP: I Verify for all the members product message is displayed for quantity limit {int}")
    public void pdpIVerifyForAllTheMembersProductMessageIsDisplayedForQuantityLimit(int maxLimit) {
    	int memberProductsCount= mkProductContainer.getMemberProductsCount();
    	if(memberProductsCount>0) {
    		for (int i = 0; i <memberProductsCount; i++) {
    			mkProductContainer.addMemberProductToCart(i);
    			Assert.assertEquals("Failed to update shopping bag counter", i+1 , mkHamburgerMenu.getBagCount());
    			mkProductContainer.selectMemberProductQuantityValue(maxLimit, i);
    			mkProductContainer.addMemberProductToCart(i);
    			Assert.assertTrue("More than 5 products added to cart", mkProductContainer.getErrorMsgForMaxLimit());		
    		}
    	}else {
			Assert.assertTrue("Member PDP not loaded", false);
		}
    	
    }
    
    @And("PDP: I Verify for all the non member product message is displayed for quantity limit {int}")
    public void pdpIVerifyForAllTheNonMemberProductMessageIsDisplayedForQuantityLimit(int maxLimit) {	
    	for (int i = 0; i <= maxLimit; i++)
    		mkProductContainer.clickOnAddToBag();
		Assert.assertTrue("More than 5 products added to cart", mkProductContainer.getErrorMsgForMaxLimit());		

    }
    
	@And("PDP: I click on breadcrumb link and verify the breadcrumb link navigation to {string}")
	public void iClickOnBreadcrumbLinkAndVerifyNavigation(String page) {
		if(page.equalsIgnoreCase("plp")) {
			Assert.assertTrue("Breadcrumb link not navigated to respective page",
					mkProductDetailPage.verifyBreadCrumbNavigationPDP());
		}else if(page.equalsIgnoreCase("slp")) {
			Assert.assertTrue("Breadcrumb link not navigated to respective page",
					mkProductDetailPage.verifyBreadCrumbNavigationToSLP());
        }
	}
	
    @Then("PDP: I verify size guide link and size option displayed")
	public void iVerifySizeGuideLink() {
    	Assert.assertTrue("Size guide link not displayed", mkProductContainer.verifySizeGuideLinkDisplayed());
    	Assert.assertTrue("Size Option not displayed", mkProductContainer.verifyZiseOptionIsDisplayed());
	}
    
    @Then("PDP: I verify Add To Bag button displayed")
  	public void iVerifyAddToBagButtonk() {
      	Assert.assertTrue("Add To Bag button not displayed", mkProductContainer.isAddToCartButtonDisplayed());
  	}
    
    @Then("PDP: I verify click and collect button displayed")
  	public void iVerifCnCButton() {
      	Assert.assertTrue("Click and collect button not displayed", mkProductContainer.isPickupInStoreButtonDisplayed());
  	}
    
    @Then("PDP: I verify Quantity drop down displayed")
  	public void iVerifQtyDropDown() {
      	Assert.assertTrue("Quantity drop down not displayed", mkProductContainer.qtyDropDown());
  	}
    
    @Then("PDP: I verify Brand Name is displayed")
    public void iVerifyBrandNameIsDisplayed()
    {
    	Assert.assertTrue("Product Style Id is missing", mkProductContainer.isBrandNameDisplayed());
    }
    
    @Then("PDP: I select color and verify the color name")
    public void verifyColorNameOnSelect() {
    	Assert.assertTrue("Color name selected is not displayed",mkProductContainer.changeColorSwatch());
    }
    
    @Then("PDP: I verify first color selected as default color")
    public void isDefaultColorIsFirstColor() {
    	Assert.assertTrue("Default Color name selected is not displayed",mkProductContainer.defaultColorSwatchSelected());
    }
    
    @And("PDP: I verify favorite or wishlist link is displayed")
    public void isFavoriteLinkDisplayed() {
    	Assert.assertTrue("Favorite/Wishlist link is not present ", mkProductContainer.isFavoriteLinkDisplayed());
    }
    
    @Then("PDP: I verify Customize section is displayed")
    public void iVerifyCustomizeSectionIsDisplayed() {
    	Assert.assertTrue("Favorite/Wishlist link is not present ", mkProductContainer.verifyCustomizeSection());
    }

    @Then("PDP: I verify clicking on the arrow changes the image")
    public void isProductImageChangedOnClickingArrow() {
    	Assert.assertTrue("Image not changed on clicking arrow", mkProductContainer.verifyImageNavigationViachevrons());
    }
    
	@Then("PDP: I select {string} size of the product")
	public void iSelectSizeOfTheProduct(String size) {
		mkProductContainer.selectSize(size);
	}

	@Then("PDP: I select {string} Color of the product")
	public void iSelectColorOfTheProduct(String colorName) {
		mkProductContainer.selectColor(colorName);
	}
    
    @And("PDP: I Select color {string}")
    public void iSelectColor(String color) {
        mkProductContainer.selectColor(color);
    }
    
    @And("PDP: I click on Add to Wishlist or Favorites link")
	public void iClickOnAddToWishlistOrFavoritesLink() {
		mkProductContainer.clickOnAddToWishlistOrFavoritesLink();
	}
    
    @And("PDP: I select size position {int}")
	public void iSelectSizePosition(int position) {
		mkProductContainer.selectSize(position);
	}
}
