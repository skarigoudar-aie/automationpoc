package com.mk.testframework.stepdefs.mobileSteps.eu;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.mobile.MkMobileCheckoutPage_EU;
import com.mk.testframework.dt.page.checkout.MkCheckoutBilling_EU;
import com.mk.testframework.dt.page.checkout.MkCheckoutConfirmation;
import com.mk.testframework.dt.page.checkout.MkPayment;
import com.mk.testframework.dt.util.PageUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import org.junit.Assert;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class CheckoutPageStepDefMobile {
	private MkMobileCheckoutPage_EU mkMobileCheckoutPage_EU;
	private MkCheckoutBilling_EU mkCheckoutBilling_eu;
	private MkCheckoutConfirmation mkCheckoutConfirmation;
	private PageUtils pageUtils;
	private Context context;
	private MkPayment mkPayment;	

	@Inject
	public CheckoutPageStepDefMobile(MkMobileCheckoutPage_EU mkMobileCheckoutPage_EU, PageUtils pageUtils,
			MkCheckoutBilling_EU mkCheckoutBilling_eu, MkPayment mkPayment, MkCheckoutConfirmation mkCheckoutConfirmation, Context context) {
		this.mkMobileCheckoutPage_EU = mkMobileCheckoutPage_EU;
		this.mkCheckoutBilling_eu = mkCheckoutBilling_eu;
		this.pageUtils = pageUtils;
		this.mkPayment = mkPayment;
		this.mkCheckoutConfirmation = mkCheckoutConfirmation;
		this.context = context;
	}

	@And("I am on the Checkout page")
	public void iAmOnTheCheckoutPage() {
		Assert.assertTrue("not on checkout page", mkMobileCheckoutPage_EU.onCheckoutPage());
	}

	@And("Review & Pay: I click pay now")
	public void new_address_i_click_pay_now() {
		pageUtils.scrollToBottomOfPage();
		mkCheckoutBilling_eu.clickPayNow();
	}
	
	@And("Review & Pay: Click on edit shopping bag link")
	public void clickOnEditShoppingBagLink() {
		mkMobileCheckoutPage_EU.editShoppingBag();
	}
	
	@And("Pay: I click on pay now button")
	public void new_address_i_click_pay_now_button() {
		pageUtils.scrollToBottomOfPage();
		mkCheckoutBilling_eu.clickPayNow();
	}

	
	@And("Billing: Save giftwrap amount before applying promocode")
	public void verifyGiftWrapAmountBeforeApplyingPromocode() {
		String giftWrapAmountBeforePromo = mkMobileCheckoutPage_EU.getGiftWrapAmount();
		context.saveData("giftWrapAmount", giftWrapAmountBeforePromo);
	}
	
	@And("BILLING: I verify the promo code not applied to the gift wrap amount")
	public void iVerifyThePromoCodeNotAppliedToTheGiftWrapAmount() {
		Assert.assertEquals("domain do not match", context.getSavedData("giftWrapAmount"), mkMobileCheckoutPage_EU.getGiftWrapAmount());
	}
	
	@And("PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as {string}")
	public void i_click_pay_now_and_authenticate(String otp) {
		pageUtils.scrollToBottomOfPage();
		mkCheckoutBilling_eu.clickPayNow();
		mkPayment.purchaseAuthenticationIfDisplaied(otp);
	}
	
	@And("Order Confirmation: I click on View order details link")
	public void iClickOnViewOrderDetailsLink() {
		mkMobileCheckoutPage_EU.clickOnViewFullDetails();
	}
	
	@Then("Order Confirmation: I verify split payment methods are displayed in Order summary")
	public void iVerifySplitPaymentMethodDsiplayed() {
		Assert.assertTrue("GC Payment name is missing", mkMobileCheckoutPage_EU.isFirstlPaymentDisplayed_EU());
		Assert.assertTrue("Payment method name is missing", mkMobileCheckoutPage_EU.isSecondPaymentDisplayed_EU());
	}

	@And("BILLING: I click on PayNow button")
	public void iClickOnPayNowButton()
	{
		mkMobileCheckoutPage_EU.clickOnpalceOrderButton();
	}

	@And("SHIPPING: I verify the order summary pricing details")
	public void iVerifyOrderSummaryDetails() throws Exception {
		Assert.assertTrue("not on checkout page", mkMobileCheckoutPage_EU.isOrderSummaryPricingDetailsDisplayed());
	}

	@And("Order Confirmation: I verify Order Summary Prices in Order Confirmation Page")
	public void i_verify_order_summary_prices_in_order_confirmation_page() {
		Assert.assertTrue("Order Summary Prices on Order Confirmation Page is not visible",
				mkCheckoutConfirmation.verifyOrderSummaryPricesOnConfirmationEUMobile());
	}

	@Then("BILLING: I Verify Shipping Address in Order Summary is Same as Selected Shipping Address in Shipping Page")
	public void iVerifyShippingAddressInOrderSummary() {
		mkCheckoutBilling_eu.verifyShippingAddressInOrderSummaryMobile();
	}

	@Then("BILLING: I Verify Shipping Method in Order Summary is Same as Selected Shipping Method in Shipping Page")
	public void iVerifyShippingMethodInOrderSummary() {
		mkCheckoutBilling_eu.verifyShippingMethodInOrderSummaryMobile();
	}
	
	@And("BILLING: I select paypal payment option")
	public void iSelectPaypalPaymentOption()
	{
		mkCheckoutBilling_eu.selectPaypalPaymemntOption();
		mkMobileCheckoutPage_EU.clickOnpalceOrderButton();
	}
	
	@Then("Order Confrimation: I Verify Custom Product displayed in Order summary")
	public void iVerifyCustomProductInOrderSummary() {
		Assert.assertTrue("Custom product is missing in order summary",
				mkMobileCheckoutPage_EU.verifyCustomaProductInOrderSummary());
	}
	
	@Then("Order Confirmation: I verify Payment method displayed")
	public void iVerifyPaymentMethod()
	{
		Assert.assertTrue("Payment name is missing", mkMobileCheckoutPage_EU.isFirstlPaymentDisplayed_EU());
	}
	
	@And("BILLING: I get Order Total amount in Order summary")
	public void iGetOrderTotalAmountInOrderSummary() {
		mkMobileCheckoutPage_EU.getTotalFromOrderSummary_billing();
	}
	
	@Then("Order Confirmation: I verify Order Total amount in order details")
	public void iVerifyOrderTotalAmountInOrderDetails() {
		boolean flag = false;
		try {
			double getTotalAmount = mkMobileCheckoutPage_EU.getOrderTotalFromOrderSummary_Confirmation();
			context.writeOut("Otder Total On Order Confirmation is " + getTotalAmount);
			String BagTotalAmount = context.getSavedData("OrderTotal");
			String BagTotalAmount1 = BagTotalAmount.trim().replaceAll("[^0-9]", "");
			double BagTotalAmount2 = Double.parseDouble(BagTotalAmount1.toString());
			if (getTotalAmount == BagTotalAmount2) {
				flag = true;
				context.writeOut("Order total amount is verified in order summary detail");
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		Assert.assertTrue("Price not matched", flag);
	}
	
	@And("BILLING: I verify order total is zero")
	public void iVerifyOrderTotalIsZero() {
		Assert.assertTrue("Order Total is not zero", mkMobileCheckoutPage_EU.isOrderTotalZero());
	}
	
	@And("BILLING: I click on Edit Shipping Address link")
	public void i_click_on_edit_shipping_Address() {
		mkCheckoutBilling_eu.clickOnEditShippingAddressLinkMobile();
	}
	
	@And("BILLING: I click on Change Shipping Method link and change the Shipping Option")
	public void i_change_shipping_method() {
		mkCheckoutBilling_eu.clickOnChangeShippingMethodLinkMobile();
		mkCheckoutBilling_eu.selectShippingOption();
	}
	
	@And("BILLING: I click on Change Shipping Method link and change the Shipping Option Anonymous")
	public void i_change_shipping_method_Anonymous() {
		mkCheckoutBilling_eu.clickOnChangeShippingMethodLinkMobile();
		mkCheckoutBilling_eu.selectShippingOptionAnonymous();
	}
	
	@And("BILLING: I Verify Edit Shipping Address link is visible on Order Summary")
	public void i_verify_Edit_shipping_Address_link_is_visible() {
		Assert.assertTrue("Edit Shipping Address link in Order Summary is not visible", mkCheckoutBilling_eu.verifyEditShippingAddressLinkMobile());
	}
	
	@And("BILLING: I Verify Change Shipping Method link is visible on Order Summary")
	public void i_verify_change_shipping_method_link_is_visible() {
		Assert.assertTrue("Change Shipping Method link in Order Summary is not visible", 
		mkCheckoutBilling_eu.verifyChangeShippingMethodLinkMobile());
	}
	
	@And("Klarna Sofort: Click on Pay Now and Enter additional details to continue")
	public void enter_additional_details_for_sofort_and_continue() {
		pageUtils.scrollToBottomOfPage();
		mkCheckoutBilling_eu.clickPayNow();
		mkPayment.fillSofortPopUpInformationKlarna();

	}

	@Then("BILLING: I Expend View Order Details in Order Summary")
	public void iClickOnViewOrderDetails() {
		mkCheckoutBilling_eu.clickOnViewOrderDetailsMobile();
	}
	
	@And("Klarna DirectDebit: Click on Pay Now and Enter additional details to continue")
	public void enter_additional_details_for_direct_debit_and_continue() {
		pageUtils.scrollToBottomOfPage();
		mkCheckoutBilling_eu.clickPayNow();
		mkPayment.filldirectDebitPopUpInformationKlarna();
	}	
	
	@And("Klarna Slice It: Click on Pay Now and Enter additional details to continue")
	public void enter_additional_details_for_slice_it_and_continue() {
		mkCheckoutBilling_eu.clickPayNow();
		mkPayment.fillSliceItPopUpInformationKlarna();
	}
	
	@And("Klarna Pay in 3: Click on Pay Now and Enter additional details to continue")
	public void enter_additional_details_for_pay_in_3_and_continue() {
		mkCheckoutBilling_eu.clickPayNow();
		mkPayment.fillPayIn3PopUpInformationKlarna();
	}

	@And("SHIPPING: I verify the shipping charge in order summary is updated according to shipping method selected")
	public void iVerifyShippingChargeInOrderSummary(){
		Assert.assertTrue("Shipping Charge details not displayed", mkMobileCheckoutPage_EU.isShippingChargesInOrderSummaryMatchesAccordingToShippingMethod());
	}
	
	@And("BILLING: I click on Change Shipping Method link")
	public void i_click_change_shipping_method() {
		mkCheckoutBilling_eu.clickOnChangeShippingMethodLinkMobile();
	}
}
