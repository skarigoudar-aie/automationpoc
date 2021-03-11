package com.mk.testframework.stepdefs.desktopSteps.allRegions;

import com.google.inject.Inject;
import com.mk.testframework.core.exceptions.TestException;
import com.mk.testframework.dt.header.MkHamburgerMenu;
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
public class ProductDetailPageStepDef {
	private final Logger log = LoggerFactory.getLogger(getClass());

    private MkProductContainer mkProductContainer;
	private PageUtils pageUtils;
	private MkHamburgerMenu mkHamburgerMenu;

    @Inject
    public ProductDetailPageStepDef(MkProductContainer mkProductContainer, PageUtils pageUtils,
                                    MkHamburgerMenu mkHamburgerMenu) {
        this.mkProductContainer = mkProductContainer;
        this.pageUtils = pageUtils;
        this.mkHamburgerMenu = mkHamburgerMenu;
    }

    @And("PDP: I select {int} from the quantity dropdown")
    public void pdpISelectFromTheQuantityDropdown(int quantityValue) {
        try {
        	mkProductContainer.selectQuantityValue(quantityValue);
		} catch (TestException e) {
			pageUtils.refresh();
			log.debug("Re-trying quantity select");
			mkProductContainer.selectQuantityValue(quantityValue);
		}
    }

    @And("PDP: I click on add to bag")
    public void pdpIClickOnAddToBag() {
        if (mkProductContainer.waitForButtonsContainer()) {
            mkProductContainer.clickOnAddToBag();
            mkHamburgerMenu.shoppingBagHasItems();
        }
    }
    @Then("PDP: I verify product image displayed")
  	public void iVerifProductImage() {
      	Assert.assertTrue("Product image not displayed", mkProductContainer.verifyProductImageDisplayed());
  	}
}
