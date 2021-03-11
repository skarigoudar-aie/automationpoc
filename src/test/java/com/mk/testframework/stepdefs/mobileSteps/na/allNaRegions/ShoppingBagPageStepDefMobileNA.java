package com.mk.testframework.stepdefs.mobileSteps.na.allNaRegions;

import org.junit.Assert;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.mobile.MkMobileShoppingBagPage_NA;
import com.mk.testframework.dt.page.shoppingbag.MkShoppingBagPage_Common;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class ShoppingBagPageStepDefMobileNA {
	private MkMobileShoppingBagPage_NA mkMobileShoppingBagPageNA;
	private MkShoppingBagPage_Common mkShoppingBagPageCommon;
	private Context context;

	@Inject
	public ShoppingBagPageStepDefMobileNA(MkMobileShoppingBagPage_NA mkMobileShoppingBagPageNA, MkShoppingBagPage_Common mkShoppingBagPageCommon, Context context) {
		this.mkMobileShoppingBagPageNA = mkMobileShoppingBagPageNA;
		this.mkShoppingBagPageCommon = mkShoppingBagPageCommon;
		this.context = context;
	}
	
	@And("SBP: I click on Checkout")
	public void i_click_on_checkout() {
		mkMobileShoppingBagPageNA.clickCheckout();
	}
	
	@Then("SBP: I verify Total Price Before Update the quantity")
	public void iVerifyTotalPriceBeforeUpdateQuantity() {
		System.out.println(mkMobileShoppingBagPageNA.getBagTotalMobile() + "before qty updated");
		System.out.println(context.getSavedData("productPrice") + "price from context");
	}

	@Then("SBP: I Verify Bag SubTotal price after updating product quantity")
	public void iVerifyBagTotalpriceAndSubTotalPrice() {
		boolean flag = false;
		try {
			String totalPrice1 = context.getSavedData("totalPrice");
			double orderTotal2 = Double.parseDouble(totalPrice1.toString());
			double expected = orderTotal2 * 3;
			String actTotalprice = mkMobileShoppingBagPageNA.getBagTotalMobile();
			double actTotalprice1 = Double.parseDouble(actTotalprice.toString());
			if (expected == actTotalprice1) {
				flag = true;
			}
		} catch (Exception e) {	
		}
		Assert.assertTrue("Price not matched", flag);
	}
	
	@And("SBP: I verify subtotal is sum of all product price")
	public void iVerifySubtotalIsSumOfAllProductPrice() {
		Assert.assertTrue(mkMobileShoppingBagPageNA.shoppingBagProductPriceCalculator());
	}

	@And("SBP: I verify product name displayed")
	public void i_verify_product_name_displayed() {
		mkMobileShoppingBagPageNA.verifyProductNameDisplayed();
	}
	
	@And("SBP: I verify the color is displayed")
	public void i_verify_product_color_displayed() {
		mkMobileShoppingBagPageNA.verifyProductColorDisplayed();
	}

	@And("SBP: I verify size is displayed")
	public void i_verify_product_size_displayed() {
		mkMobileShoppingBagPageNA.verifyProductSizeDisplayed();
	}
	
	@And("SBP: I verify price is displayed")
	public void i_verify_product_price_displayed() {
		mkMobileShoppingBagPageNA.verifyProductPriceDisplayed();
	}
	
	@And("SBP: I verify product image is displayed")
	public void i_verify_product_image_displayed() {
		mkMobileShoppingBagPageNA.verifyProductImageDisplayed();
	}
	
	@And("SBP: I verify product qty is displayed")
	public void i_verify_product_qty_displayed() {
		mkMobileShoppingBagPageNA.verifyProductQtyDisplayed();
	}
	
	@And("SBP: I verify product style is displayed")
	public void i_verify_product_style_displayed() {
		mkMobileShoppingBagPageNA.verifyProductStyleDisplayed();
	}

}