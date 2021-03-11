package com.mk.testframework.stepdefs.desktopSteps.eu;

import org.junit.Assert;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.page.shoppingbag.MkShoppingBagPage_Common;
import com.mk.testframework.dt.page.shoppingbag.MkShoppingBagPage_EuGlobal;
import com.mk.testframework.dt.popup.MkMiniBagMenuPopup;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class ShoppingBagPageStepDefDesktopEU {

	private MkShoppingBagPage_EuGlobal mkShoppingBagPage_euGlobal;
	private MkShoppingBagPage_Common mkShoppingBagPageCommon;
	private Context context;
	private MkMiniBagMenuPopup mkMiniBagMenuPopup;

	@Inject
	public ShoppingBagPageStepDefDesktopEU(MkShoppingBagPage_EuGlobal mkShoppingBagPage_euGlobal, MkShoppingBagPage_Common mkShoppingBagPageCommon, Context context, MkMiniBagMenuPopup mkMiniBagMenuPopup) {
		this.mkShoppingBagPage_euGlobal = mkShoppingBagPage_euGlobal;
		this.mkShoppingBagPageCommon = mkShoppingBagPageCommon;
		this.context = context;
		this.mkMiniBagMenuPopup = mkMiniBagMenuPopup;
	}

	@And("SBP: I click on Checkout")
	public void i_click_on_checkout() {
		mkShoppingBagPage_euGlobal.clickCheckout();
	}
	
	@Then("SBP: I verify Total Price Before Update the quantity")
	public void iVerifyTotalPriceBeforeUpdateQuantity() {

		System.out.println(mkShoppingBagPageCommon.getBagTotal() + "before qty updated");
		System.out.println(context.getSavedData("productPrice") + "price fom context");
	}

	@Then("SBP: I Verify Bag SubTotal price after updating product quantity")
	public void iVerifyBagTotalpriceAndSubTotalPrice() {
		boolean flag = false;
		try {

			String totalPrice1 = context.getSavedData("totalPrice");
			double orderTotal2 = Double.parseDouble(totalPrice1.toString());
			double expected = orderTotal2 * 3;
			System.out.println("Expected price after multiplication " + expected);
			String actTotalprice = mkShoppingBagPageCommon.getBagTotal();
			double actTotalprice1 = Double.parseDouble(actTotalprice.toString());
			System.out.println(actTotalprice1 + " Actual price");
			if (expected == actTotalprice1) {
				flag = true;
			}
		} catch (Exception e) {

		}
		Assert.assertTrue("Price not matched", flag);
	}

	@And("SBP: I verify SubTotal and Total amount in Order summary detail")
	public void iVerifySubTotalAndTotalAmountInOrderSummaryDetail()
	{
		boolean flag = false;
		try {
			double getOrderTotal1 = mkShoppingBagPage_euGlobal.getTotalFromOrderSummary();
			double orderSummarySuTotal = mkShoppingBagPage_euGlobal.subTotalFromOrderSummary();
			if(getOrderTotal1 == orderSummarySuTotal)
				flag = true;
		} catch (Exception e) {
		}
		Assert.assertTrue("Order Total and SubTotal amount not matched", flag);
	}
	
	@And("SBP: I verify Order Summary details after applying promotion")
	public void iVerifyOrderSummaryDetailsAfterApplyingPromotion()
	{
		boolean flag = false;
		try {
			double orderSummarySuTotal = mkShoppingBagPage_euGlobal.subTotalFromOrderSummary();
			double appliedPromotionPrice1 = mkShoppingBagPage_euGlobal.getPromotionFromOrderSummary();
			double expectedTotalAmount = orderSummarySuTotal - appliedPromotionPrice1;
			System.out.println("expected amount "+ expectedTotalAmount);
			double actTotalAmount = mkShoppingBagPage_euGlobal.getTotalFromOrderSummary();
			System.out.println("actual amount " + actTotalAmount);
			if(expectedTotalAmount == actTotalAmount)
				flag = true;
		} catch (Exception e) {
			
		}
		Assert.assertTrue("Order Total and SubTotal amount not matched after applying Promotion", flag);
	}

	@And("SBP: I verify subtotal in miniBag")
	public void iverifySubtotalInMiniBag()
	{
		mkMiniBagMenuPopup.miniBagSubTotalPriceEU();
		System.out.println(mkMiniBagMenuPopup.miniBagSubTotalPriceEU()+ "from the Mini bag");
		System.out.println(context.getSavedData("minisubtotal")+ "from the context");
		
	}

	@And("SBP: I verify Cart Total and MiniBag total price")
	public void iVerifyCartTotalAndMinibagTotalprice() {
		String miniSubTotal = context.getSavedData("minisubtotal");
		System.out.println("minibag " + miniSubTotal);
		String bagTotalPrice = mkShoppingBagPage_euGlobal.bagSubTotalPrice();
		System.out.println("cart price " + bagTotalPrice);
		Assert.assertEquals("cart total doesn't match with mini Bag", miniSubTotal, bagTotalPrice);
	}
	
	@And("SBP: I verify subtotal is sum of all product price")
	public void iVerifySubtotalIsSumOfAllProductPrice() {
		Assert.assertTrue(mkShoppingBagPage_euGlobal.shoppingBagProductPriceCalculator());
	}
	
	@Then("I verify the {int} {string} promotion got applied")
	public void iVerifyAllThePromotionGotApplied(int amount, String promoType) {
		Assert.assertTrue("promotion not applied", mkShoppingBagPage_euGlobal.verifyPromoApplied(amount, promoType));
	}
	
	@And("SBP: I verify product name displayed")
	public void i_verify_product_name_displayed() {
		Assert.assertTrue("Product Name not displayed on cart", mkShoppingBagPage_euGlobal.verifyProductNameDisplayed());
	}
	
	@And("SBP: I verify the color is displayed")
	public void i_verify_product_color_displayed() {
		Assert.assertTrue("Product color not displayed on cart", mkShoppingBagPage_euGlobal.verifyProductColorDisplayed());
	}

	@And("SBP: I verify size is displayed")
	public void i_verify_product_size_displayed() {
		Assert.assertTrue("Product size not displayed on cart", mkShoppingBagPage_euGlobal.verifyProductSizeDisplayed());
	}
	
	@And("SBP: I verify price is displayed")
	public void i_verify_product_price_displayed() {
		Assert.assertTrue("Product price not displayed on cart", mkShoppingBagPage_euGlobal.verifyProductPriceDisplayed());
	}
	
	@And("SBP: I verify product image is displayed")
	public void i_verify_product_image_displayed() {
		Assert.assertTrue("Product image not displayed on cart", mkShoppingBagPage_euGlobal.verifyProductImageDisplayed());
	}
	
	@And("SBP: I verify product qty is displayed")
	public void i_verify_product_qty_displayed() {
		Assert.assertTrue("Product qty not displayed on cart", mkShoppingBagPage_euGlobal.verifyProductQtyDisplayed());
	}
	
	@And("SBP: I verify product style is displayed")
	public void i_verify_product_style_displayed() {
		Assert.assertTrue("Product style not displayed on cart", mkShoppingBagPage_euGlobal.verifyProductStyleDisplayed());
	}
}