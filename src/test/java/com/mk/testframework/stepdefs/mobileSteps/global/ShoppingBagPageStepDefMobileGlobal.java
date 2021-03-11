package com.mk.testframework.stepdefs.mobileSteps.global;

import org.junit.Assert;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.mobile.MkMobileShoppingBagPage_EuGlobal;
import com.mk.testframework.dt.page.shoppingbag.MkShoppingBagPage_Common;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class ShoppingBagPageStepDefMobileGlobal {

	private MkMobileShoppingBagPage_EuGlobal mkMobileShoppingBagPage_euGlobal;
	private MkShoppingBagPage_Common mkShoppingBagPageCommon;
	private Context context;
	
	@Inject
	public ShoppingBagPageStepDefMobileGlobal(MkMobileShoppingBagPage_EuGlobal mkMobileShoppingBagPage_euGlobal, MkShoppingBagPage_Common mkShoppingBagPageCommon, Context context) {
		this.mkMobileShoppingBagPage_euGlobal = mkMobileShoppingBagPage_euGlobal;
		this.mkShoppingBagPageCommon = mkShoppingBagPageCommon;
		this.context = context;
	}
	
	@And("SBP: I click on Checkout")
	public void i_click_on_checkout() {
		mkMobileShoppingBagPage_euGlobal.clickCheckout();
	}
	
	@Then("SBP: I verify Total Price Before Update the quantity")
	public void iVerifyTotalPriceBeforeUpdateQuantity() {
		System.out.println(mkMobileShoppingBagPage_euGlobal.getBagTotalMobile() + "before qty updated");
		System.out.println(context.getSavedData("productPrice") + "price fom context");
	}

	@Then("SBP: I Verify Bag SubTotal price after updating product quantity")
	public void iVerifyBagTotalpriceAndSubTotalPrice() {
		boolean flag = false;
		try {
			String totalPrice1 = context.getSavedData("totalPrice");
			double orderTotal2 = Double.parseDouble(totalPrice1.toString());
			double expected = orderTotal2 * 3;
			String actTotalprice = mkMobileShoppingBagPage_euGlobal.getBagTotalMobile();
			double actTotalprice1 = Double.parseDouble(actTotalprice.toString());
			if (expected == actTotalprice1) {
				flag = true;
			}
		} catch (Exception e) {

		}
		Assert.assertTrue("Price not matched", flag);
	}
	@And("SBP: I verify subtotal is sum of all product price")
	 public void iVerifySubtotalIsSumOfAllProductPrice()
	 {
		 Assert.assertTrue(mkMobileShoppingBagPage_euGlobal.shoppingBagProductPriceCalculator());
	 }

	@And("SBP: I verify SubTotal and Total amount in Order summary detail")
	public void iVerifySubTotalAndTotalAmountInOrderSummaryDetail() {
		boolean flag = false;
		try {
			double getOrderTotal1 = mkMobileShoppingBagPage_euGlobal.getTotalFromOrderSummary_mobile();
			double orderSummarySuTotal = mkMobileShoppingBagPage_euGlobal.subTotalFromOrderSummary_mobile();
			if (getOrderTotal1 == orderSummarySuTotal)
				flag = true;
		} catch (Exception e) {
		}
		Assert.assertTrue("Order Total and SubTotal amount not matched", flag);
	}
	
	@And("SBP: I verify Order Summary details after applying promotion")
	public void iVerifyOrderSummaryDetailsAfterApplyingPromotion() {
		boolean flag = false;
		try {
			double orderSummarySuTotal = mkMobileShoppingBagPage_euGlobal.subTotalFromOrderSummary_mobile();
			double appliedPromotionPrice1 = mkMobileShoppingBagPage_euGlobal.getPromotionFromOrderSummary_mobile();
			double expectedTotalAmount = orderSummarySuTotal - appliedPromotionPrice1;
			System.out.println("expected amount " + expectedTotalAmount);
			double actTotalAmount = mkMobileShoppingBagPage_euGlobal.getTotalFromOrderSummary_mobile();
			System.out.println("actual amount " + actTotalAmount);
			if (expectedTotalAmount == actTotalAmount)
				flag = true;
		} catch (Exception e) {

		}
		Assert.assertTrue("Order Total and SubTotal amount not matched after applying Promotion", flag);
	}
	
	@And("SBP: I verify product name displayed")
	public void i_verify_product_name_displayed() {
		Assert.assertTrue("Product Name not displayed on cart", mkMobileShoppingBagPage_euGlobal.verifyProductNameDisplayed());
	}
	
	@And("SBP: I verify the color is displayed")
	public void i_verify_product_color_displayed() {
		Assert.assertTrue("Product Color not displayed on cart", mkMobileShoppingBagPage_euGlobal.verifyProductColorDisplayed());
	}

	@And("SBP: I verify size is displayed")
	public void i_verify_product_size_displayed() {
		Assert.assertTrue("Product Size not displayed on cart", mkMobileShoppingBagPage_euGlobal.verifyProductSizeDisplayed());
	}
	
	@And("SBP: I verify price is displayed")
	public void i_verify_product_price_displayed() {
		Assert.assertTrue("Product Price not displayed on cart", mkMobileShoppingBagPage_euGlobal.verifyProductPriceDisplayed());
	}
	
	@And("SBP: I verify product image is displayed")
	public void i_verify_product_image_displayed() {
		Assert.assertTrue("Product Image not displayed on cart", mkMobileShoppingBagPage_euGlobal.verifyProductImageDisplayed());
	}
	
	@And("SBP: I verify product qty is displayed")
	public void i_verify_product_qty_displayed() {
		Assert.assertTrue("Product qty not displayed on cart", mkMobileShoppingBagPage_euGlobal.verifyProductQtyDisplayed());
	}
	
	@And("SBP: I verify product style is displayed")
	public void i_verify_product_style_displayed() {
		Assert.assertTrue("Product style not displayed on cart", mkMobileShoppingBagPage_euGlobal.verifyProductStyleDisplayed());
	}
}