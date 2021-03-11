package com.mk.testframework.stepdefs.desktopSteps.eu;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.page.checkout.*;
import com.mk.testframework.dt.page.shoppingbag.MkShoppingBagPage_EuGlobal;
import com.mk.testframework.dt.util.PageUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class CheckoutPageStepDef {
	private MkCheckoutPage_EU mkCheckoutPage_EU;
	private MkCheckoutBilling_EU mkCheckoutBilling_eu;
	private MkCheckoutConfirmation mkCheckoutConfirmation;
	private Context context;
	private MkPayment mkPayment;
	private  MkCheckoutShipping_EU mkCheckoutShippingEU;
	private MkShoppingBagPage_EuGlobal mkShoppingBagPage_euGlobal;


	@Inject
	public CheckoutPageStepDef(MkCheckoutPage_EU mkCheckoutPage_EU, MkCheckoutBilling_EU mkCheckoutBilling_eu, 
	MkPayment mkPayment, MkCheckoutShipping_EU mkCheckoutShippingEU, Context context, 
	MkShoppingBagPage_EuGlobal mkShoppingBagPage_euGlobal, MkCheckoutConfirmation mkCheckoutConfirmation) {
		this.mkCheckoutPage_EU = mkCheckoutPage_EU;
		this.mkCheckoutBilling_eu = mkCheckoutBilling_eu;
		this.mkCheckoutConfirmation = mkCheckoutConfirmation;
		this.mkPayment = mkPayment;
		this.mkCheckoutShippingEU = mkCheckoutShippingEU;
		this.context = context;
		this.mkShoppingBagPage_euGlobal = mkShoppingBagPage_euGlobal;		
	}

	@And("I am on the Checkout page")
	public void iAmOnTheCheckoutPage() {
		Assert.assertTrue("not on checkout page", mkCheckoutPage_EU.onCheckoutPage());
	}

	@And("Review & Pay: I click pay now")
	public void new_address_i_click_pay_now() {
		mkCheckoutBilling_eu.clickPayNow();

	}

	@Then("BILLING: I Expend View Order Details in Order Summary")
	public void iClickOnViewOrderDetails() {
		mkCheckoutBilling_eu.clickOnViewOrderDetails();
	}
	
	@And("SHIPPING: I verify the order summary pricing details")
	public void iVerifyOrderSummaryDetails() throws Exception {
		Assert.assertTrue("order summary pricing details not displayed",
				mkCheckoutPage_EU.isOrderSummaryPricingDetailsDisplayed());
	}

	@And("Review & Pay: Click on edit shopping bag link")
	public void clickOnEditShoppingBagLink() {
		mkCheckoutBilling_eu.editShoppingBag();

	}

	@And("Billing: Save giftwrap amount before applying promocode")
	public void verifyGiftWrapAmountBeforeApplyingPromocode() {
		String giftWrapAmountBeforePromo = mkCheckoutBilling_eu.getGiftWrapAmount();
		context.saveData("giftWrapAmount", giftWrapAmountBeforePromo);
	}

	@And("BILLING: I verify the promo code not applied to the gift wrap amount")
	public void iVerifyThePromoCodeNotAppliedToTheGiftWrapAmount() {
		String giftWrapAmountBeforePromo = context.getSavedData("giftWrapAmount");
		String giftWrapAmountAfterPromo = mkCheckoutBilling_eu.getGiftWrapAmount();
		Assert.assertEquals("Promo applied to gift wrap", giftWrapAmountBeforePromo, giftWrapAmountAfterPromo);
	}
	
	@And("Pay: I click on pay now button")
	public void new_address_i_click_pay_now_button() {
		mkCheckoutBilling_eu.clickPayNowButton();
	}	

	@And("PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as {string}")
	public void new_address_i_click_pay_now_and_authenticate(String otp) {
		mkCheckoutBilling_eu.clickPayNowButton();
		mkPayment.purchaseAuthenticationIfDisplaied(otp);
	}
	
	@And("Klarna Sofort: Click on Pay Now and Enter additional details to continue")
	public void enter_additional_details_for_sofort_and_continue() {
			mkCheckoutBilling_eu.clickPayNowButton();
			mkPayment.fillSofortPopUpInformationKlarna();
	}
	
	@And("Klarna DirectDebit: Click on Pay Now and Enter additional details to continue")
	public void enter_additional_details_for_direct_debit_and_continue() {
		mkCheckoutBilling_eu.clickPayNowButton();
		mkPayment.filldirectDebitPopUpInformationKlarna();
	}
	
	@And("Klarna Slice It: Click on Pay Now and Enter additional details to continue")
	public void enter_additional_details_for_slice_it_and_continue() {
		mkCheckoutBilling_eu.clickPayNowButton();
		mkPayment.fillSliceItPopUpInformationKlarna();
	}
	
	@And("Klarna Pay in 3: Click on Pay Now and Enter additional details to continue")
	public void enter_additional_details_for_pay_in_3_and_continue() {
		mkCheckoutBilling_eu.clickPayNowButton();
		mkPayment.fillPayIn3PopUpInformationKlarna();
	}

	@Then("BILLING: I Verify Shipping Address in Order Summary is Same as Selected Shipping Address in Shipping Page")
	public void iVerifyShippingAddressInOrderSummary() {
		mkCheckoutBilling_eu.verifyShippingAddressInOrderSummary();
	}
	
	@Then("BILLING: I Verify Shipping Method in Order Summary is Same as Selected Shipping Method in Shipping Page")
	public void iVerifyShippingMethodInOrderSummary() {
		mkCheckoutBilling_eu.verifyShippingMethodInOrderSummary();
	}

	@And("Order Confirmation: I verify Order Summary Prices in Order Confirmation Page")
	public void i_verify_order_summary_prices_in_order_confirmation_page() {
		Assert.assertTrue("Order Summary Prices on Order Confirmation Page is not visible",
				mkCheckoutConfirmation.verifyOrderSummaryPricesOnConfirmationEU());
	}

	@And("BILLING: I Verify Edit Shipping Address link is visible on Order Summary")
	public void i_verify_Edit_shipping_Address_link_is_visible() {
		Assert.assertTrue("Edit Shipping Address link in Order Summary is not visible",
				mkCheckoutBilling_eu.verifyEditShippingAddressLink());
	}

	@And("BILLING: I Verify Change Shipping Method link is visible on Order Summary")
	public void i_verify_change_shipping_method_link_is_visible() {
		Assert.assertTrue("Change Shipping Method link in Order Summary is not visible",
				mkCheckoutBilling_eu.verifyChangeShippingMethodLink());
	}

	@And("BILLING: I click on Change Shipping Method link and change the Shipping Option")
	public void i_change_shipping_method() {
		mkCheckoutBilling_eu.clickOnChangeShippingMethodLink();
		mkCheckoutBilling_eu.selectShippingOption();
	}

	@And("BILLING: I click on Change Shipping Method link and change the Shipping Option Anonymous")
	public void i_change_shipping_method_Anonymous() {
		mkCheckoutBilling_eu.clickOnChangeShippingMethodLink();
		mkCheckoutBilling_eu.selectShippingOptionAnonymous();
	}

	@And("BILLING: I click on Edit Shipping Address link")
	public void i_click_on_edit_shipping_Address() {
		mkCheckoutBilling_eu.clickOnEditShippingAddressLink();
	}
	
	@And("BILLING: I select paypal payment option")
	public void iSelectPaypalPaymentOption() {
		mkCheckoutBilling_eu.selectPaypalPaymemntOption();
		mkCheckoutBilling_eu.clickOnpalceOrderButton();
	}
	
	@And("Order Confirmation: I click on View order details link")
	public void iClickOnViewOrderDetailsLink() {
		mkCheckoutConfirmation.clickOnViewFullDetails();
	}

	@And("BILLING: I get Order Total amount in Order summary")
	public void iGetOrderTotalAmountInOrderSummary() {
		mkCheckoutBilling_eu.getTotalFromOrderSummary();
	}

	@Then("Order Confirmation: I verify Order Total amount in order details")
	public void iVerifyOrderTotalAmountInOrderDetails() {
		boolean flag = false;
		try {
			double getTotalAmount = mkCheckoutConfirmation.getOrderTotal_EU();
			context.writeOut("Otder Total On Order Confirmation is " + getTotalAmount);
			String BagTotalAmount = context.getSavedData("OrderTotalPrice");
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

	@Then("Order Confrimation: I Verify Custom Product displayed in Order summary")
	public void iVerifyCustomProductInOrderSummary() {
		Assert.assertTrue("Custom product is missing in order summary",
				mkCheckoutConfirmation.verifyCustomaProductInOrderSummary());
	}

	@Then("Order Confirmation: I verify split payment methods are displayed in Order summary")
	public void iVerifySplitPaymentMethodDsiplayed() {
		Assert.assertTrue("GC Payment name is missing", mkCheckoutConfirmation.isFirstlPaymentDisplayed_EU());
		Assert.assertTrue("Payment method name is missing", mkCheckoutConfirmation.isSecondPaymentDisplayed_EU());
	}
    
    @And("BILLING: I click on PayNow button")
    public void iClickOnPayNowButton()
    {
    	mkCheckoutBilling_eu.clickOnpalceOrderButton();
    }

	@And("BILLING: I verify order total is zero")
	public void iVerifyOrderTotalIsZero() {
		Assert.assertTrue("Order Total is not zero", mkCheckoutBilling_eu.isOrderTotalZero());
	}

	@Then("Order Confirmation: I verify Payment method displayed")
	public void iVerifyPaymentMethod() {
		Assert.assertTrue("Payment name is missing", mkCheckoutConfirmation.isFirstlPaymentDisplayed_EU());
	}
	
	@When("SHIPPING: I click on Edit shopping bag link")
	public void iClickOnEditShopingBagLink() {
		mkCheckoutShippingEU.clickOnEDitShoppingBagLink();
	}
	@And("SHIPPING: I get the order summary detail before edit cart")
	public void iGetTheOrderTotalBeforeEditCart()
	{
		mkCheckoutShippingEU.getOrderTotalAmount();
	}
	@Then("SHIPPING: I verify the order summary section with the modified cart")
	public void iVerifyTheOrderSummaryWithModifiedCart()
	{
		boolean flag = false;
		try {
			String orderSummaryBeforeEditCart = context.getSavedData("OrderTotalBeforeEditCArt");
			context.writeOut("Before Edit Cart is: " + orderSummaryBeforeEditCart);
			String orderSummaryWithEditCart = mkCheckoutShippingEU.getOrderTotalAmount();
			context.writeOut("After Edit Cart is: " + orderSummaryWithEditCart);
			if (Double.parseDouble(orderSummaryWithEditCart) > Double.parseDouble(orderSummaryBeforeEditCart)) {
				flag = true;
				context.writeOut("Order summary is verified with modified cart");
			} 
		} catch (Exception e) {
			
		}
		Assert.assertTrue("Price is same", flag);
		
	}

	@And("SHIPPING: I verify the shipping charge in order summary is updated according to shipping method selected")
	public void iVerifyShippingChargeInOrderSummary(){
		Assert.assertTrue("Shipping Charge details not displayed", mkCheckoutPage_EU.isShippingChargesInOrderSummaryMatchesAccordingToShippingMethod());
	}
	
	@And("BILLING: I click on Change Shipping Method link")
	public void i_click_change_shipping_method() {
		mkCheckoutBilling_eu.clickOnChangeShippingMethodLink();
	}
}
