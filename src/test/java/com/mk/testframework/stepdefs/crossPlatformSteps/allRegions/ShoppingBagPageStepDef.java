package com.mk.testframework.stepdefs.crossPlatformSteps.allRegions;

import com.mk.testframework.dt.page.shoppingbag.MkEditProductLightbox;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import com.google.inject.Inject;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.page.shoppingbag.MkShoppingBagPage_Common;
import com.mk.testframework.dt.util.MkPageNavigator;
import com.mk.testframework.dt.util.ModalUtils;
import com.mk.testframework.dt.util.PageUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class ShoppingBagPageStepDef {
	private MkShoppingBagPage_Common mkShoppingBagPageCommon;
	private MkHamburgerMenu mkHamburgerMenu;
	private MkPageNavigator mkPageNavigator;
	private PageUtils pageUtils;
	private MkEditProductLightbox mkEditProductLightbox;
	private Environment env;
	private ModalUtils modalUtils;
	
	@Inject
	public ShoppingBagPageStepDef(MkShoppingBagPage_Common mkShoppingBagPageCommon, MkHamburgerMenu mkHamburgerMenu,
								  MkPageNavigator mkPageNavigator, PageUtils pageUtils,
								  MkEditProductLightbox mkEditProductLightbox, Environment env) {
		this.mkShoppingBagPageCommon = mkShoppingBagPageCommon;
		this.mkHamburgerMenu = mkHamburgerMenu;
		this.mkPageNavigator = mkPageNavigator;
		this.pageUtils = pageUtils;
		this.mkEditProductLightbox = mkEditProductLightbox;
		this.env = env;
		
	}

	@And("SBP: I can see {int} product in the bag")
	public void sbpICanSeeProductInTheBag(Integer expectedProductCount) {
		if(mkPageNavigator.onShoppingBagPage()){
			int actualProductCount = mkShoppingBagPageCommon.getProductCount();
			Assert.assertEquals("Expected number of products in the bag wrong", expectedProductCount.intValue(),
					actualProductCount);
		}
	}

	@And("SBP: I empty my Shopping Bag")
	public boolean iEmptyMyShoppingBag() {
		boolean shoppingBagEmpty = false;
		mkHamburgerMenu.clickShoppingBagIcon();
		try {
			System.out.println("");
			if (!mkHamburgerMenu.shoppingBagHasItems()) {
				shoppingBagEmpty = true;
			} else {
				int i = mkShoppingBagPageCommon.getProductCount();
				if (i == 0) {
					shoppingBagEmpty = true;
				} else {
					while (i > 0) {
						pageUtils.waitForAjaxToComplete();
						sbpIClickOnRemove();
						if (mkShoppingBagPageCommon.getProductCount() > 0) {
							i--;
						} else {
							shoppingBagEmpty = true;
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			try {
			
			if (!mkHamburgerMenu.shoppingBagHasItems()) {
				shoppingBagEmpty = true;
			} else {
				if (!mkPageNavigator.onShoppingBagPage() && mkHamburgerMenu.shoppingBagHasItems()) {
					mkHamburgerMenu.clickShoppingBagIcon();
				}
				int i = mkShoppingBagPageCommon.getProductCount();
				if (i == 0) {
					shoppingBagEmpty = true;
				} else {
					while (i > 0) {
						pageUtils.waitForAjaxToComplete();
						sbpIClickOnRemove();
						if (mkShoppingBagPageCommon.getProductCount() > 0) {
							i--;
						} else {
							shoppingBagEmpty = true;
							break;
						}
					}
				}
			}
		}catch(Exception e2) {
			if (!mkHamburgerMenu.shoppingBagHasItems()) {
				shoppingBagEmpty = true;
			} else {
				if (!mkPageNavigator.onShoppingBagPage() && mkHamburgerMenu.shoppingBagHasItems()) {
					mkHamburgerMenu.clickShoppingBagIcon();
				}
				int i = mkShoppingBagPageCommon.getProductCount();
				if (i == 0) {
					shoppingBagEmpty = true;
				} else {
					while (i > 0) {
						pageUtils.waitForAjaxToComplete();
						sbpIClickOnRemove();
						if (mkShoppingBagPageCommon.getProductCount() > 0) {
							i--;
						} else {
							shoppingBagEmpty = true;
							break;
						}
					}
				}
			}
		}
		}

		return shoppingBagEmpty;
	}

	@And("SBP: my Shopping Bag is empty")
	public void myShoppingBagIsEmpty() {
		Assert.assertTrue("Emptying shopping bag failed", iEmptyMyShoppingBag());
	}

	@And("SBP: I click on Edit")
	public void sbpIClickOnEdit() {
		mkShoppingBagPageCommon.clickEditLink();
	}

	@And("EDIT PRODUCT: I click update shopping bag")
	public void editPRODUCTIClickUpdateShoppingBag() {
		mkEditProductLightbox.clickUpdateBagButton();
	}

	@And("EDIT PRODUCT: I set the quantity to {int}")
	public void editPRODUCTISetTheQuantityTo(int quantityValue) {
		mkEditProductLightbox.selectQuantityValue(quantityValue);
	}

	@And("SBP: I click on Remove")
	public void sbpIClickOnRemove() {
		mkShoppingBagPageCommon.clickRemoveLink();
	}

	@And("SBP: I verify my custom monogrammed item has been added to the Shopping Bag")
	public void sbpIVerifyMyCustomMonogrammedItemHasBeenAddedToTheShoppingBag() {
		Assert.assertTrue("Failed to add Monogrammed item", mkShoppingBagPageCommon.monogramSectionIsPresent());
	}

	@When("SBP: I click header back link")
	public void sbpIClickHeaderBackLink() {
		mkShoppingBagPageCommon.clickHeaderBackLink();
	}

	@And("SBP: I verify You may also like widget is displaying")
	public void iVerifyYouMayAlsoLikeWidgetIsDisplaying() {
		Assert.assertTrue("'You May Also Like' widget not available on shopping bag", mkShoppingBagPageCommon.rfkSectionIsPresent());
	}

	@Then("SBP: I click product {int} from You may also like widget")
	public void iClickProductFromYouMayAlsoLikeWidget(int position) {
		mkShoppingBagPageCommon.selectRfkItem(position);
	}
	
	@Then("SBP: I verify i am on shopping bag page")
	public void sbpIVerifyIamOnShoppingBagPage() {
		Assert.assertTrue("Application not redirected to shopping bag", pageUtils.getCurrentUrl().contains("shoppingCart"));		
	}

	@Then("SBP: I verify list and sale price displayed")
	public void sbpIVerifyListAndSalePriceDisplayed() {
		Assert.assertTrue("Application not redirected to shopping bag", mkShoppingBagPageCommon.isSalePriceDisplayed());		
	}
	
	@And("SBP: I click on Apply Promo Code Link")
    public void iClickOnApplyPromoCodeLinkSBP()
    {
   	 mkShoppingBagPageCommon.clickOnApplyPromoCodeLink();
    }

	@And("SBP: I verify promo message displayed at item level")
	public void isItemLevelPromoMessageDisplayed() {
		Assert.assertTrue("promotion message not displayed", mkShoppingBagPageCommon.isPromoMessageDisplayed());
	}

	@Then("SBP: I verify {string} and {string} details are displayed")
	public void isShippingAndClickAndCollectDisplayed(String bopis, String shipto) {
		Assert.assertTrue("Shipping Options not displayed",
				mkShoppingBagPageCommon.isShippingOptionBopisOptionDisplayed(bopis, shipto));
	}
	
	@And("EDIT PRODUCT: I select different color")
	public void editPRODUCTIChangeTheColorTo() {
		mkEditProductLightbox.selectColorValue();
	}
	
	@And("EDIT PRODUCT: I select different size")
	public void editPRODUCTIChangeTheSizeTo() {
		mkEditProductLightbox.selectSizeValue();
	}
	
	@And("SBP: I click on Edit link position {int} and ship type {string}")
	public void sbpIClickOnEdit(int position, String shipType) {
		mkShoppingBagPageCommon.clickEditLink(position, shipType);
	}
	
	@Then ("SBP: I verify display of EDIT PRODUCT Header text")
	public void isEditProductLabelDisplayed() {
		Assert.assertTrue("EDIT PRODUCT Header text not displayed",mkEditProductLightbox.isEditProductLabelDisplayed());
	}
	
    @Then ("SBP: I verify display of Product Image and images displayed on clicking each thumbnail")
	public void isProductImageDisplayed() {
    	boolean deviceTypeMobile=env.isSysPropsSpecified(Environment.SysProps.MOBILE);
    	System.out.println("");
    	if(deviceTypeMobile) {
    		Assert.assertTrue("Product Image and images not displayed on clicking each thumbnail",mkEditProductLightbox.isMobileProductImageDisplayed());
    	}else {
    		Assert.assertTrue("Product Image and images not displayed on clicking each thumbnail",mkEditProductLightbox.isProductImageDisplayed());
    		Assert.assertTrue("Product Image and images not displayed on clicking each thumbnail",mkEditProductLightbox.isProductImageChangedOnClickingThumbnilImages());
    	}
	}
    
    @Then ("SBP: I verify display of Product Title")
	public void isProductTitleDisplayed() {
		Assert.assertTrue("Product Title not displayed",mkEditProductLightbox.isProductTitleDisplayed());
	}
    
    @Then ("SBP: I verify display of Store Style number")
	public void isStoreStyleDisplayed() {
		Assert.assertTrue("Store Style number not displayed",mkEditProductLightbox.isStoreStyleDisplayed());
	}
    
    @Then ("SBP: I verify display of COLOR selected color highlighted")
	public void isStyleColorDisplayed() {
		Assert.assertTrue("Selected color highlighted not displayed",mkEditProductLightbox.isStyleColorDisplayed());
	}
    
    @Then ("SBP: I verify display of Size Guide link is functional")
	public void isSizeGuideDisplayed() {
		Assert.assertTrue("Size Guide link is not functional",mkEditProductLightbox.isSizeGuideDisplayed());
	}
    
    @Then ("SBP: I verify display of Size grid with selected size highlighted")
	public void isSizeGuideWithSelectedIsHighlighted() {
		Assert.assertTrue("Size Guide link is not functional",mkEditProductLightbox.isSizeGuideWithSelectedIsHighlighted());
	}
    
    @Then ("SBP: I verify display of Quantity Dropdown with selected quantity displayed")
	public void isQuantiTyDropDownDisplayedWithSelectedQty() {
		Assert.assertTrue("Quantity Dropdown with selected quantity not displayed",mkEditProductLightbox.isQuantiTyDropDownDisplayedWithSelectedQty());
	}
    
    @Then ("SBP: I verify display of Ship to Address Radio button selected by defaults for Home delivery product")
	public void isShipToAddressRadiobuttonDisplayed() {
		Assert.assertTrue("Ship to Address Radio button not selected by defaults for Home delivery product",mkEditProductLightbox.isShipToAddressRadiobuttonDisplayed());
	}
    
    @Then ("SBP: I verify display of Collect in Store Details with Details link clickable selected by defaults for Home delivery product")
	public void isCollectInStoreDetailsWithDetailsLinkClickable() {
		Assert.assertTrue("Collect in Store Details with Details link clickable by defaults for Home delivery product",mkEditProductLightbox.isCollectInStoreDetailsWithDetailsLinkClickable());
	}
    
    @Then ("SBP: I verify display of UPDATE SHOPPING BAG button")
	public void isUpdateShoppingBagButtonDisplayed() {
		Assert.assertTrue("UPDATE SHOPPING BAG button not displayed",mkEditProductLightbox.isUpdateShoppingBagButtonDisplayed());
	}
    
    @Then ("SBP: I verify display of CANCEL button")
	public void isCancelLinkDisplayed() {
		Assert.assertTrue("CANCEL button not displayed",mkEditProductLightbox.isCancelLinkDisplayed());
	}
    
    @Then ("SBP: I verify display of View Full Details link")
	public void isFullDetailsLinkDisplayed() {
		Assert.assertTrue("View Full Details link not displayed",mkEditProductLightbox.isFullDetailsLinkDisplayed());
	}
    
    @Then ("SBP: I verify display of Close option button")	
    public void isCloseOptionDisplayed() {
		Assert.assertTrue("Close option button not displayed",mkEditProductLightbox.isCloseOptionDisplayed());
	}
    
    @Then ("SBP: I verify display of The Edit cart popup is closed")
	public void isPopUpClosedOnClickingClose() {
		Assert.assertTrue("Edit cart popup is not closed",mkEditProductLightbox.isPopUpClosedOnClickingClose());
	}
	
	
	@Then("SBP: I change the shipping option to {string}")
	public void changeShippingOption(String shiptoOption) {
		mkShoppingBagPageCommon.changeShippingOption(shiptoOption);
	}
	 
	@Then("SBP: I verify {string} is displayed")
	public void isShippingOptionUpdated(String shipto) {
		Assert.assertTrue("Shipping Option not updated to: "+shipto,
				mkShoppingBagPageCommon.ischangeShippingOptionChanged(shipto));
	}
	
	@And("PDP: I enter city and click find store")
	public void enterCityAndClickFindStore() {
		mkShoppingBagPageCommon.selectStoreDistance().enterPickUpInStoreDetails().clickOnFindStoreButton();
	}
}
