package com.mk.testframework.stepdefs.mobileSteps.na.allNaRegions;

import com.google.inject.Inject;
import com.mk.testframework.dt.mobile.MkMobileCheckoutPage_NA;
import com.mk.testframework.dt.page.checkout.MkCheckoutBilling_NA;
import com.mk.testframework.dt.page.checkout.MkCheckoutShipping_NA;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class CheckoutPageStepDefMobile {
	private MkMobileCheckoutPage_NA mkMobileCheckoutPageNA;
	private MkCheckoutShipping_NA mkCheckoutShippingNA;
	private MkCheckoutBilling_NA mkCheckoutBillingNA;
	private PageUtils pageUtils;
	private TestData testData;
	private Environment env;
	private Context context;

	@Inject
	public CheckoutPageStepDefMobile(MkMobileCheckoutPage_NA mkMobileCheckoutPageNA,
			MkCheckoutBilling_NA mkCheckoutBillingNA, PageUtils pageUtils, TestData testData, Context context, 
			Environment env, MkCheckoutShipping_NA mkCheckoutShippingNA) {
		this.mkMobileCheckoutPageNA = mkMobileCheckoutPageNA;
		this.mkCheckoutShippingNA = mkCheckoutShippingNA;
		this.mkCheckoutBillingNA = mkCheckoutBillingNA;
		this.pageUtils = pageUtils;
		this.testData = testData;
		this.env = env;
		this.context = context;
	}

	@And("I am on the Checkout page")
	public void iAmOnTheCheckoutPage() {
		Assert.assertTrue("not on checkout page", mkMobileCheckoutPageNA.onCheckoutPage());
	}

	@And("BILLING: I click on Apply a promo code link")
	public void i_click_on_Apply_promo_code() {
		pageUtils.sleepSeconds(5, "page load");
		mkCheckoutBillingNA.clickOnPromoCodeLinkMob();
	}

	@And("SHIPPING: I verify the order summary pricing details")
	public void iVerifyOrderSummaryDetails() throws Exception {
		Assert.assertTrue("not on checkout page", mkMobileCheckoutPageNA.isOrderSummaryPricingDetailsDisplayed());
	}

	@And("BILLING: I enter promo code")
	public void i_enter_promo_code() {
		pageUtils.sleepSeconds(5, "page load");
		mkCheckoutBillingNA.enterPromoCodeOnMob(testData.getUser().getpromocode());
	}

	@And("BILLING: I click on Apply button")
	public void I_click_on_Apply_button() {
		pageUtils.sleepSeconds(2, "page load");
		mkCheckoutBillingNA.clickOnApplyPromoMob();
	}

	@And("BILLING: I verified promo is applied succesfully")
	public void I_verified_promo_is_applied_succesfully() {
		Assert.assertTrue("Expected Display Promotions Container", mkCheckoutBillingNA.PromoApplied());
	}

	@And("BILLING: I apply promo code {string}")
	public void iApplyPromoCode(String promo) {
		mkMobileCheckoutPageNA.clickOnPromoCodeLink();
		mkMobileCheckoutPageNA.enterPromoCode(promo);
		mkMobileCheckoutPageNA.clickOnApplyPromo();
		mkCheckoutBillingNA.PromoApplied();
	}

	@And("Billing: Save giftwrap amount before applying promocode")
	public void verifyGiftWrapAmountBeforeApplyingPromocode() {
		String giftWrapAmountBeforePromo = mkMobileCheckoutPageNA.getGiftWrapAmountBeforePromoApplied();
		context.saveData("giftWrapAmount", giftWrapAmountBeforePromo);
	}

	@And("BILLING: I verify the promo code not applied to the gift wrap amount")
	public void iVerifyThePromoCodeNotAppliedToTheGiftWrapAmount() {
		Assert.assertEquals("domain do not match", context.getSavedData("giftWrapAmount"),
				mkMobileCheckoutPageNA.getGiftWrapAmountAfterPromoApplied());
	}
	
	@And("BILLING: I click on continue with paypal button")
	 public void iClcikOnContinueWithPaypalButton()
	 {
		 mkMobileCheckoutPageNA.continueWithPaypalButton();
	 }

	@And("BILLING: I get Order Total amount in Order summary")
	public void iGetOrderTotalAmountInOrderSummary() {
		mkMobileCheckoutPageNA.getBagTotal_Billing();
	}
	

	/*
	 * @And("Place Order: I click on Place Order button") public void
	 * IClickOnPlcaeOrderButton() { mkCheckoutBillingNA.placeOrderMobile(); }
	 */
	
	@And("SHIPPING: I verify the shipping charge in order summary is updated according to shipping method selected")
	public void iVerifyShippingChargeInOrderSummary(){
		Assert.assertTrue("Shipping Charge details not displayed", mkMobileCheckoutPageNA.isShippingChargesInOrderSummaryMatchesAccordingToShippingMethod());
	}

	@Then("Order Confirmation: I verify Order Total amount in order details")
	public void iVerifyOrderTotalAmountInOrderDetails() {
		boolean flag = false;
		try {
			double getTotalAmount1 = mkMobileCheckoutPageNA.getBagTotal_Confirmation();
			String BagTotalAmount = context.getSavedData("totalPrice");
			String BagTotalAmount1 = BagTotalAmount.trim().replaceAll("[^0-9]", "");
			double BagTotalAmount2 = Double.parseDouble(BagTotalAmount1.toString());
			if (getTotalAmount1 == BagTotalAmount2) {
				flag = true;
				context.writeOut("Order total amount is verified in order summary detail");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		Assert.assertTrue("Price not matched", flag);
	}
	/*
	 * @And("BILLING: I get Order Total amount in Order summary") public void
	 * iGetOrderTotalAmountInOrderSummary() { mkMobileCheckoutPageNA.getBagTotal();
	 * }
	 */
	
	@And("BILLING: I verify order total is zero")
	public void iVerifyOrderTotalIsZero() {
		Assert.assertTrue("Order Total is not zero", mkMobileCheckoutPageNA.isOrderTotalZero());
	}

	@And("BILLING: I click on edit payment Link")
	public void iClickOnEditPaymentLink() {
		mkMobileCheckoutPageNA.clickOnEditPaymentLink();
	}
	
	/*
	 * @Then("Order Confirmation: I verify Order Total amount in order details")
	 * public void iVerifyOrderTotalAmountInOrderDetails() { boolean flag = false;
	 * try { String getTotalAmount = mkMobileCheckoutPageNA.getBagTotal(); double
	 * getTotalAmount1 = Double.parseDouble(getTotalAmount.toString());
	 * context.writeOut("Otder Total On Order Confirmation is " + getTotalAmount1);
	 * String BagTotalAmount = context.getSavedData("totalPrice"); String
	 * BagTotalAmount1 = BagTotalAmount.trim().replaceAll("[^0-9]", ""); double
	 * BagTotalAmount2 = Double.parseDouble(BagTotalAmount1.toString()); if
	 * (getTotalAmount1 == BagTotalAmount2) { flag = true;
	 * context.writeOut("Order total amount is verified in order summary detail"); }
	 * } catch (Exception e) { // TODO: handle exception }
	 * Assert.assertTrue("Price not matched", flag); }
	 */
	
	@When("SHIPPING: I click on Edit shopping bag link")
	public void iClickOnEditShopingBagLink() {
		mkMobileCheckoutPageNA.clickOnEDitShoppingBagLink();
	}

	@And("SHIPPING: I get the order summary detail before edit cart")
	public void iGetTheOrderTotalBeforeEditCart() {
		mkMobileCheckoutPageNA.getItemSubTotalAmount();
	}

	@Then("SHIPPING: I verify the order summary section with the modified cart")
	public void iVerifyTheOrderSummaryWithModifiedCart() {
		boolean flag = false;
		try {
			String orderSummaryBeforeEditCart = context.getSavedData("OrderTotalBeforeEditCArt");
			context.writeOut("Before Edit Cart is: " + orderSummaryBeforeEditCart);
			String orderSummaryWithEditCart = mkMobileCheckoutPageNA.getItemSubTotalAmount();
			context.writeOut("After Edit Cart is: " + orderSummaryWithEditCart);
			if (Double.parseDouble(orderSummaryWithEditCart) > Double.parseDouble(orderSummaryBeforeEditCart)) {
				flag = true;
				context.writeOut("Order summary is verified with modified cart");
			}
		} catch (Exception e) {

		}
		Assert.assertTrue("Price is same", flag);
	}
	
	@And("BILLING: I click on Edit shipping section from Payment page")
	public void iClickEditShippingSection() {
		mkCheckoutBillingNA.clickEditShippingSectionMobile();
	}
	
	@And("SHIPPING: I Verify Selected Shipping Address")
	public void verifySelectedShippingAddress() {
		mkCheckoutShippingNA.selectedShippingAddressMobile();
	}
}
