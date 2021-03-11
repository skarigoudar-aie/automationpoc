package com.mk.testframework.stepdefs.mobileSteps.allRegions;

import com.google.inject.Inject;
import com.mk.testframework.core.exceptions.TestException;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.mobile.MkMobileProductContainer;
import com.mk.testframework.dt.page.product.MkProductContainer;
import com.mk.testframework.dt.util.PageUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class ProductDetailPageStepDefMobile {

    private final Logger log = LoggerFactory.getLogger(getClass());
	private MkProductContainer mkProductContainer;
    private MkMobileProductContainer mkMobileProductContainer;
	private PageUtils pageUtils;
	private MkHamburgerMenu mkHamburgerMenu;

    @Inject
    public ProductDetailPageStepDefMobile(MkMobileProductContainer mkMobileProductContainer, PageUtils pageUtils,
                                          MkProductContainer mkProductContainer, MkHamburgerMenu mkHamburgerMenu) {
        this.mkMobileProductContainer = mkMobileProductContainer;
        this.pageUtils = pageUtils;
        this.mkProductContainer = mkProductContainer;
        this.mkHamburgerMenu = mkHamburgerMenu;
    }

    @And("PDP: I select {int} from the quantity dropdown")
    public void pdpISelectFromTheQuantityDropdown(int quantityValue) {
        try {
			mkMobileProductContainer.selectQuantityValue(quantityValue);
		} catch (TestException e) {
			pageUtils.refresh();
			log.debug("Re-trying quantity select");
			mkMobileProductContainer.selectQuantityValue(quantityValue);
		}
    }
    
    @And("PDP: I select {int} from the quantity dropdown in PDP Page for Mobile")
    public void pdpISelectFromTheQuantityDropdownInPDPPageForMobile(int quantityValue) {
        try {
			mkMobileProductContainer.selectQuantityValue_PDP_Page(quantityValue);
		} catch (TestException e) {
			pageUtils.refresh();
			log.debug("Re-trying quantity select");
			mkMobileProductContainer.selectQuantityValue_PDP_Page(quantityValue);
		}
    }

    @And("PDP: I click on add to bag")
    public void pdpIClickOnAddToBag() {
        if (mkProductContainer.waitForButtonsContainer()) {
            mkMobileProductContainer.clickOnAddToBag();
            mkHamburgerMenu.shoppingBagHasItems();
        }
    }
    @Then("PDP: I verify product image displayed")
  	public void iVerifProductImage() {
      	Assert.assertTrue("Product image not displayed", mkMobileProductContainer.verifyProductImageDisplayed());
  	}
}
