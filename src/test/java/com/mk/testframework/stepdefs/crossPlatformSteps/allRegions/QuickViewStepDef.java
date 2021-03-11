package com.mk.testframework.stepdefs.crossPlatformSteps.allRegions;

import org.junit.Assert;

import com.google.inject.Inject;
import com.mk.testframework.dt.page.product.MkProductContainer;
import com.mk.testframework.dt.page.product.MkProductQuickView;
import com.mk.testframework.dt.popup.MkMiniBagMenuPopup;
import cucumber.api.java.en.And;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class QuickViewStepDef {
    private MkProductQuickView mkProductQuickView;
    private MkProductContainer mkProductContainer;
    private MkMiniBagMenuPopup mkMiniBagMenuPopup;

    @Inject
    public QuickViewStepDef(MkProductQuickView mkProductQuickView, MkMiniBagMenuPopup mkMiniBagMenuPopup,
                            MkProductContainer mkProductContainer) {
        this.mkProductQuickView = mkProductQuickView;
        this.mkMiniBagMenuPopup = mkMiniBagMenuPopup;
        this.mkProductContainer = mkProductContainer;
    }

    @And("QV: I click on add to bag")
    public void qvIClickOnAddToBag() {
        if(mkProductQuickView.waitForProductQuickview()){
            if (mkProductContainer.waitForButtonsContainer()) {
                mkProductContainer.clickOnAddToBag();
                mkMiniBagMenuPopup.waitForMiniBagMenuPopup();
            }
        }
    }
    
    @And("QV: I verify Brand Name is displayed")
    public void isBrandNameDisplayed() {
    	Assert.assertTrue("Brand name not displayed", mkProductQuickView.isBrandNameDisplayed());
    }
    
    @And("QV: I verify product Name is displayed")
    public void isProductNameDisplayed() {
    	Assert.assertTrue("Product name not displayed",mkProductQuickView.isProductNameDisplayed());
    }
    
    @And("QV: I verify product strike price is displayed")
    public void isProductPriceDisplayed() {
    	Assert.assertTrue("Product Price not displayed",mkProductQuickView.isQuickViewProductPriceDisplayed());
    }
    
    @And("QV: I select color and verify the color name")
    public void verifyColorNameOnSelect() {
    	Assert.assertTrue("Color name selected is not displayed",mkProductQuickView.changeColorSwatch());
    }
    
    @And("QV: I verify first color selected as default color")
    public void isDefaultColorIsFirstColor() {
    	Assert.assertTrue("Default Color name selected is not displayed",mkProductQuickView.defaultColorSwatchSelected());
    }
    
    @And("QV: I verify favorite or wishlist link is displayed")
    public void isFavoriteLinkDisplayed() {
    	Assert.assertTrue("Favorite/Wishlist link is not present ", mkProductQuickView.isQuickViewFavoriteLinkDisplayed());
    }
    
    @And("QV: I verify Find a Store link is not present on the quick view")
    public void isFindInStoreDisplayed() {
    	Assert.assertFalse("Find a store link present", mkProductQuickView.isFindInStoreLinkDisplayed());
    }
    
    @And("QV: I verify the arrow on quick view")
    public void isCarouselArrowDisplayed() {
    	Assert.assertTrue("Carousel arrow not displayed", mkProductQuickView.isPrevNextButtonDisplayed());
    	
    }
    
    @And("QV: I verify clicking on the arrow changes the image")
    public void isProductImageChangedOnClickingArrow() {
    	Assert.assertTrue("Image not changed on clicking arrow", mkProductQuickView.clickOnNextArrow());
    	
    }
    
    @And("QV: I verify add to bag button is displayed")
    public void isAddToBagDisplayed() {
    	Assert.assertTrue("Add to cart button displayed", mkProductQuickView.isAddToCartButtonDisplayed());
    }
    
    @And("QV: I verify Collect in store button is displayed")
    public void isCollectInStoreDisplayed() {
    	Assert.assertTrue("Collect in store button displayed", mkProductQuickView.isAddToCartButtonDisplayed());
    }
    
    @And("QV: I close the quick view")
    public void closeQuickView() {
    	Assert.assertTrue("Close option not displayed", mkProductQuickView.isCloseOption());
    	mkProductQuickView.closeOption();
    }
}
