package com.mk.testframework.stepdefs.desktopSteps.na.allNaRegions;

import com.google.inject.Inject;
import com.mk.testframework.dt.page.checkout.MkCheckoutPage_NA;
import com.mk.testframework.dt.page.checkout.MkCheckoutShipping_NA;
import com.mk.testframework.dt.page.checkout.MkCheckoutBilling_NA;
import com.mk.testframework.dt.page.checkout.MkCheckoutConfirmation;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class CheckoutPageStepDef {
	private MkCheckoutPage_NA mkCheckoutPageNA;
	private MkCheckoutShipping_NA mkCheckoutShippingNA;
	private MkCheckoutBilling_NA mkCheckoutBillingNA;
	private PageUtils pageUtils;
	private TestData testData;
	private Environment env;
	private Context context;
	private MkCheckoutConfirmation mkCheckoutConfirmation;

	@Inject
	public CheckoutPageStepDef(MkCheckoutPage_NA mkCheckoutPageNA,Environment env,Context context, 
	MkCheckoutBilling_NA mkCheckoutBillingNA, PageUtils pageUtils, TestData testData, 
	MkCheckoutConfirmation mkCheckoutConfirmation,MkCheckoutShipping_NA mkCheckoutShippingNA) {
		this.mkCheckoutPageNA = mkCheckoutPageNA;
		this.mkCheckoutShippingNA = mkCheckoutShippingNA;
		this.mkCheckoutBillingNA = mkCheckoutBillingNA;
		this.pageUtils = pageUtils;
		this.testData = testData;
		this.env = env;
		this.context = context;
		this.mkCheckoutConfirmation = mkCheckoutConfirmation;
		this.mkCheckoutShippingNA = mkCheckoutShippingNA;
		
	}

	@And("I am on the Checkout page")
	public void iAmOnTheCheckoutPage() {
		Assert.assertTrue("not on checkout page", mkCheckoutPageNA.onCheckoutPage());
	}

	@And("BILLING: I click on Apply a promo code link")
	public void i_click_on_Apply_promo_code() {

		pageUtils.sleepSeconds(5, "page load");
		mkCheckoutBillingNA.clickOnPromoCodeLink();
	}

	@And("BILLING: I enter promo code")
	public void i_enter_promo_code() {

		pageUtils.sleepSeconds(5, "page load");
		mkCheckoutBillingNA.enterPromoCode(testData.getUser().getpromocode());
	}

	@And("BILLING: I click on Apply button")
	public void I_click_on_Apply_button() {

		pageUtils.sleepSeconds(2, "page load");
		mkCheckoutBillingNA.clickOnApplyPromo();
	}

	@And("BILLING: I verified promo is applied succesfully")
	public void I_verified_promo_is_applied_succesfully() {
		Assert.assertTrue("Expected Display Promotions Container", mkCheckoutBillingNA.PromoApplied());
	}

	@And("SHIPPING: I verify the order summary pricing details")
	public void iVerifyOrderSummaryDetails() throws Exception {
		Assert.assertTrue("Order Summary not matched", mkCheckoutPageNA.isOrderSummaryPricingDetailsDisplayed());
	}

	@And("BILLING: I apply promo code {string}")
	public void iApplyPromoCode(String promo) {
		mkCheckoutBillingNA.clickOnPromoCodeLink();
		mkCheckoutBillingNA.enterPromoCode(promo);
		mkCheckoutBillingNA.clickOnApplyPromo();
		mkCheckoutBillingNA.PromoApplied();
	}

	@And("Billing: Save giftwrap amount before applying promocode")
	public void verifyGiftWrapAmountBeforeApplyingPromocode() {
		String giftWrapAmountBeforePromo = mkCheckoutBillingNA.getGiftWrapAmountBeforePromoApplied();
		context.saveData("giftWrapAmount", giftWrapAmountBeforePromo);
	}

	@And("BILLING: I verify the promo code not applied to the gift wrap amount")
	public void iVerifyThePromoCodeNotAppliedToTheGiftWrapAmount() {
		Assert.assertEquals("domain do not match", context.getSavedData("giftWrapAmount"),
				mkCheckoutBillingNA.getGiftWrapAmountAfterPromoApplied());
	}
	
	@And("BILLING: I verify order total is zero")
	public void iVerifyOrderTotalIsZero() {
		Assert.assertTrue("Order Total is not zero", mkCheckoutBillingNA.isOrderTotalZero());
	}

	@And("BILLING: I click on continue with paypal button")
	 public void iClcikOnContinueWithPaypalButton()
	 {
		 mkCheckoutBillingNA.continueWithPaypalButton();
	 }
	 
	@And("BILLING: I get Order Total amount in Order summary")
	public void iGetOrderTotalAmountInOrderSummary() {
		mkCheckoutBillingNA.getBagTotal();

	}

	@Then("Order Confirmation: I verify Order Total amount in order details")
	public void iVerifyOrderTotalAmountInOrderDetails() {
		boolean flag = false;
		try {
			String getTotalAmount = mkCheckoutBillingNA.getBagTotal();
			double getTotalAmount1 = Double.parseDouble(getTotalAmount.toString());

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

	 @And("BILLING: I click on edit payment Link")
		public void iClickOnEditPaymentLink()
		{
			mkCheckoutBillingNA.clickOnEditPaymentLink();
		}
		
		/*
		 * @And("Place Order: I click on Place Order button") public void
		 * IClickOnPlcaeOrderButton() { mkCheckoutBillingNA.clickOnPlaceOrderButton(); }
		 */
	
	@When("SHIPPING: I click on Edit shopping bag link")
	public void iClickOnEditShopingBagLink() {
		mkCheckoutShippingNA.clickOnEDitShoppingBagLink();
	}

	@And("SHIPPING: I get the order summary detail before edit cart")
	public void iGetTheOrderTotalBeforeEditCart() {
		mkCheckoutShippingNA.getItemSubTotalAmount();
	}

	@Then("SHIPPING: I verify the order summary section with the modified cart")
	public void iVerifyTheOrderSummaryWithModifiedCart() {
		boolean flag = false;
		try {
			String orderSummaryBeforeEditCart = context.getSavedData("OrderTotalBeforeEditCArt");
			context.writeOut("Before Edit Cart is: " + orderSummaryBeforeEditCart);
			String orderSummaryWithEditCart = mkCheckoutShippingNA.getItemSubTotalAmount();
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
		mkCheckoutBillingNA.clickEditShippingSection();
	}
	
	@And("SHIPPING: I Verify Selected Shipping Address")
	public void verifySelectedShippingAddress() {
		mkCheckoutShippingNA.selectedShippingAddress();
	}
	
	@And("SHIPPING: I verify the shipping charge in order summary is updated according to shipping method selected")
	public void iVerifyShippingChargeInOrderSummary(){
		Assert.assertTrue("Shipping Charge details not displayed", mkCheckoutPageNA.isShippingChargesInOrderSummaryMatchesAccordingToShippingMethod());
	}

}
