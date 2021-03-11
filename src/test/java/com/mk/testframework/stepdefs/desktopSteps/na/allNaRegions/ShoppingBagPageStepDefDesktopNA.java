package com.mk.testframework.stepdefs.desktopSteps.na.allNaRegions;

import org.junit.Assert;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.page.shoppingbag.MkShoppingBagPage_Common;
import com.mk.testframework.dt.page.shoppingbag.MkShoppingBagPage_NA;
import com.mk.testframework.dt.popup.MkMiniBagMenuPopup;
import com.mk.testframework.dt.util.PageUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class ShoppingBagPageStepDefDesktopNA {
	private MkShoppingBagPage_NA mkShoppingBagPageNA;
	private MkShoppingBagPage_Common mkShoppingBagPageCommon;
	private Context context;
	private PageUtils pageUtils;
	private MkMiniBagMenuPopup mkMiniBagMenuPopup;

	@Inject
	public ShoppingBagPageStepDefDesktopNA(MkShoppingBagPage_NA mkShoppingBagPageNA, MkShoppingBagPage_Common mkShoppingBagPageCommon, Context context, PageUtils pageUtils, MkMiniBagMenuPopup mkMiniBagMenuPopup) {
		this.mkShoppingBagPageNA = mkShoppingBagPageNA;
		this.context = context;
		this.pageUtils = pageUtils;
		this.mkMiniBagMenuPopup = mkMiniBagMenuPopup;
		this.mkShoppingBagPageCommon = mkShoppingBagPageCommon;
	}
	
	@And("SBP: I click on Checkout")
	public void i_click_on_checkout() {
		mkShoppingBagPageNA.clickCheckout();
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
			System.out.println(expected + "expected data");
			String actTotalprice = mkShoppingBagPageCommon.getBagTotal();
			double actTotalprice1 = Double.parseDouble(actTotalprice.toString());

			if (expected == actTotalprice1) {
				flag = true;
			}
		} catch (Exception e) {

		}
		Assert.assertTrue("Price not matched", flag);
	}
	
	@And("SBP: I verify subtotal in miniBag")
	public void iverifySubtotalPriceInMiniBag() {
		mkMiniBagMenuPopup.miniBagSubTotalPriceNA();
		System.out.println(mkMiniBagMenuPopup.miniBagSubTotalPriceNA() + "from the Mini bag");
		System.out.println(context.getSavedData("minisubtotal") + "from the context");
	}
	
	@And("SBP: I verify Cart Total and MiniBag total price")
	public void iVerifyCartTotalAndMinibagTotalprice() {
		pageUtils.sleepSeconds(3, "wait for page load");
		String miniSubTotal = context.getSavedData("minisubtotal");
		System.out.println("minibag price " + miniSubTotal);
		String bagTotalPrice = mkShoppingBagPageNA.bagSubTotalPrice();
		System.out.println("cart price " + bagTotalPrice);
		Assert.assertEquals("cart total doesn't match with mini Bag", miniSubTotal, bagTotalPrice);
	}

	@And("SBP: I verify subtotal is sum of all product price")
	public void iVerifySubtotalIsSumOfAllProductPrice() {
		Assert.assertTrue(mkShoppingBagPageNA.shoppingBagProductPriceCalculator());
	}
	 
	@And("SBP: I verify product name displayed")
	public void i_verify_product_name_displayed() {
		Assert.assertTrue("Product name not displayed on cart", mkShoppingBagPageNA.verifyProductNameDisplayed());
	}
	
	@And("SBP: I verify the color is displayed")
	public void i_verify_product_color_displayed() {
		Assert.assertTrue("Product color not displayed on cart", mkShoppingBagPageNA.verifyProductColorDisplayed());
	}

	@And("SBP: I verify size is displayed")
	public void i_verify_product_size_displayed() {
		Assert.assertTrue("Product size not displayed on cart", mkShoppingBagPageNA.verifyProductSizeDisplayed());
	}
	
	@And("SBP: I verify price is displayed")
	public void i_verify_product_price_displayed() {
		Assert.assertTrue("Product price not displayed on cart", mkShoppingBagPageNA.verifyProductPriceDisplayed());
	}
	
	@And("SBP: I verify product image is displayed")
	public void i_verify_product_image_displayed() {
		Assert.assertTrue("Product image not displayed on cart", mkShoppingBagPageNA.verifyProductImageDisplayed());
	}
	
	@And("SBP: I verify product qty is displayed")
	public void i_verify_product_qty_displayed() {
		Assert.assertTrue("Product qty not displayed on cart", mkShoppingBagPageNA.verifyProductQtyDisplayed());
	}
	
	@And("SBP: I verify product style is displayed")
	public void i_verify_product_style_displayed() {
		Assert.assertTrue("Product style not displayed on cart", mkShoppingBagPageNA.verifyProductStyleDisplayed());
	}
}