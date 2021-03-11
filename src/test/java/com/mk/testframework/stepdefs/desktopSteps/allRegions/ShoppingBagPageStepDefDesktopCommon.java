package com.mk.testframework.stepdefs.desktopSteps.allRegions;

import org.junit.Assert;

import com.google.inject.Inject;
import com.mk.testframework.dt.page.shoppingbag.MkShoppingBagPage_Common;
import com.mk.testframework.dt.page.shoppingbag.MkShoppingBagPage_EuGlobal;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * 
 * @author Shiva
 *
 */

@SuppressWarnings("deprecation")
public class ShoppingBagPageStepDefDesktopCommon {

	private MkShoppingBagPage_Common mkShoppingBagPage_Common;
	
	@Inject
	public ShoppingBagPageStepDefDesktopCommon(MkShoppingBagPage_Common mkShoppingBagPage_Common) {
		this.mkShoppingBagPage_Common = mkShoppingBagPage_Common;
	}
	
	@Then("I verify the {int} {string} item level promotion got applied")
	public void iVerifyItemLevelPromotionGotApplied(int amount, String promoType) {
		Assert.assertTrue("promotion not applied", mkShoppingBagPage_Common.verifyItemLevelPromoApplied(amount, promoType));
	}
	
	@And("SBP: I get the item total price")
	public void iGetTheItemTotalPrice() {
		mkShoppingBagPage_Common.getTheItemPrice();
	}
}
