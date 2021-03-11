package com.mk.testframework.stepdefs.mobileSteps.allRegions;

import org.junit.Assert;

import com.google.inject.Inject;
import com.mk.testframework.dt.mobile.MkMobileShoppingBagPage_EuGlobal;
import com.mk.testframework.dt.page.shoppingbag.MkShoppingBagPage_Common;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

@SuppressWarnings("deprecation")
public class ShoppingBagPageStepDefMobile {

	private MkShoppingBagPage_Common mkShoppingBagPageCommon;
	private MkMobileShoppingBagPage_EuGlobal mkMobileShoppingBagPage_EuGlobal;
	

	@Inject
	public ShoppingBagPageStepDefMobile(MkShoppingBagPage_Common mkShoppingBagPageCommon, MkMobileShoppingBagPage_EuGlobal mkMobileShoppingBagPage_EuGlobal) {
		this.mkShoppingBagPageCommon = mkShoppingBagPageCommon;
		this.mkMobileShoppingBagPage_EuGlobal = mkMobileShoppingBagPage_EuGlobal;
	}
	
	@Then("SBP: I verify list and sale price displayed on shopping bag for mobile")
	public void sbpIVerifyListAndSalePriceDisplayed() {
		Assert.assertTrue("Application not redirected to shopping bag", mkShoppingBagPageCommon.isSalePriceDisplayedMobile());		
	}

	@Then("I verify the {int} {string} item level promotion got applied")
	public void iVerifyItemLevelPromotionGotApplied(int amount, String promoType) {
		Assert.assertTrue("promotion not applied", mkMobileShoppingBagPage_EuGlobal.verifyItemLevelPromoApplied(amount, promoType));
	}
	
	@And("SBP: I get the item total price")
	public void iGetTheItemTotalPrice() {
		mkMobileShoppingBagPage_EuGlobal.getTheItemPrice();
	}
}
