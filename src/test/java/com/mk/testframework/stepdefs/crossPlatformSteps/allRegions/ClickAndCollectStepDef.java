package com.mk.testframework.stepdefs.crossPlatformSteps.allRegions;

import org.junit.Assert;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.exceptions.TestException;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.page.product.MkClickAndCollectContainer;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class ClickAndCollectStepDef {
private TestData testData;
private MkClickAndCollectContainer mkClickAndCollectContainer;
private MkHamburgerMenu mkHamburgerMenu;
private ProductDetailPageStepDef productDetailPageStepDef;

@Inject
public ClickAndCollectStepDef(TestData testData, MkClickAndCollectContainer mkClickAndCollectContainer,
        MkHamburgerMenu mkHamburgerMenu, ProductDetailPageStepDef productDetailPageStepDef) {
    this.testData = testData;
    this.mkClickAndCollectContainer = mkClickAndCollectContainer;
    this.mkHamburgerMenu = mkHamburgerMenu;
    this.productDetailPageStepDef = productDetailPageStepDef;
}
    
    @Then("CC: I verify store key text is displayed")
    public void isStoreKeyTextDisplayed() {
    	Assert.assertTrue("Store key not displayed", mkClickAndCollectContainer.isStoreKeyTextDisplayed());
    }
    
    @Then("CC: I verify product Image is displayed") 
    public void isProductImageDisplayed() {
    	Assert.assertTrue("product Image not displayed",mkClickAndCollectContainer.isProductImageDisplayed());
    }
    
    @Then("CC: I verify style No is displayed")
    public void isStyleNumberDisplayed() {
    	Assert.assertTrue("style No not displayed",mkClickAndCollectContainer.isStyleNumberDisplayed());
    }
    
    @Then("CC: I verify currency Code as per the country is displayed")
    public void isPriceCurrencyFormatDisplayedInCountrySelectedCurrency() {
    	Assert.assertTrue("currency Code as per the country not displayed",mkClickAndCollectContainer.isPriceCurrencyFormatDisplayedInCountrySelectedCurrency());
    }
    
    @Then("CC: I verify product Price with WAS and NOW lable is displayed")
    public void isProductSaleAndListPriceDisplayed() {
    	Assert.assertTrue("product Price with WAS and NOW lable not displayed",mkClickAndCollectContainer.isProductSaleAndListPriceDisplayed());
    }
    
    @Then("CC: I verify color is displayed")
    public void isProductColorDisplayed() {
    	Assert.assertTrue("color not displayed",mkClickAndCollectContainer.isProductColorDisplayed());
    }
    
    @Then("CC: I verify quantity drop down is displayed")
    public void isQtyDisplayed() {
    	Assert.assertTrue("quantity drop down not displayed",mkClickAndCollectContainer.isQtyDisplayed());
    }
    
    @Then("CC: I verify distance Dropdown is displayed")
    public void isDistanceDropdownDisplayed() {
    	Assert.assertTrue("distance Dropdown not displayed",mkClickAndCollectContainer.isDistanceDropdownDisplayed());
    }
    
    @Then("CC: I verify city or Postcode Text box is displayed")
    public void isStoreSearchTextBoxDisplayed() {
    	Assert.assertTrue("city or Postcode Text box not displayed",mkClickAndCollectContainer.isStoreSearchTextBoxDisplayed());
    }
    
    @Then("CC: I verify find Stores Button is displayed")
    public void isFindStoresButtonDisplayed() {
    	Assert.assertTrue("find Stores Button not displayed",mkClickAndCollectContainer.isFindStoresButtonDisplayed());
    }
    
    @Then("CC: I verify exit button is displayed")
    public void isExitOptionDisplayed() {
    	Assert.assertTrue("Exit option not present",mkClickAndCollectContainer.isExitOptionDisplayed());
    }
    
    @Then("CC: I verify the translations for the translated Locales are as expected is displayed")
    public void isTextAreInCountrySpecificLanguage() {
    	Assert.assertTrue("Text Not translated",mkClickAndCollectContainer.isTextAreInCountrySpecificLanguage());
    }
	

	/*
	 * @And("CC: I enter postcode and click find store") public void
	 * ccIEnterPostcodeAndClickFindStore() {
	 * mkClickAndCollectContainer.enterSearchLocation(testData.getUser().address.
	 * getPostalCode()); mkClickAndCollectContainer.clickSearchButton(); }
	 */

	@And("CC: I enter city and click find store")
	public void ccIEnterCityAndClickFindStore() {
		mkClickAndCollectContainer.enterSearchLocation(testData.getUser().address.getStoreId());
		mkClickAndCollectContainer.clickSearchButton();
	}

	@And("CC: I click on Add to Bag & Collect from the first available store")
	public void ccIClickOnAddToBagCollectFromTheFirstAvailableStore() {
		try {
			if (mkClickAndCollectContainer.waitForStoreListSection()) {
				if (mkClickAndCollectContainer.canBeCollected()) {
					mkClickAndCollectContainer.clickFirstAvailableStoreForCollection();
				} else {
					throw new TestException("Product unavailable for click and collect");
				}
			}
		} catch (Exception e) {
			mkClickAndCollectContainer.clickSecondAvailableStoreForCollection();		}
	}

	@And("CC: I select checkbox to collect item from store")
	public void iSelectCheckboxToCollectItemFromsTORE() {
		mkClickAndCollectContainer.iSelectCheckboxToCollectItem();
	}

	@And("CC: I apply click and collect Gift Wrap")
	public void iapplyClickandCollectGiftWrap() {
		mkClickAndCollectContainer.iApplyCnCGiftWrap();
	}

	@And("CC: I click on Add to Bag & Collect from the second available store")
	public void ccIClickOnAddToBagCollectFromTheSecondAvailableStore() {
		if (mkClickAndCollectContainer.waitForStoreListSection()) {
			if (mkClickAndCollectContainer.canBeCollected()) {
				mkClickAndCollectContainer.clickSecondAvailableStoreForCollection();
			} else {
				throw new TestException("Product unavailable for click and collect");
			}
		}
	}

}
