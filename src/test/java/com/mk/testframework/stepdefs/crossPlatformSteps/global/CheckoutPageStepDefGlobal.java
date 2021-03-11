package com.mk.testframework.stepdefs.crossPlatformSteps.global;

import com.google.inject.Inject;
import com.mk.testframework.dt.page.checkout.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import org.junit.Assert;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")

public class CheckoutPageStepDefGlobal {
	private MkCheckoutPage_Global mkCheckoutPageGlobal;
	private MkCheckoutShipping_Global mkCheckoutShippingGlobal;
	private MkCheckoutBilling_Global mkCheckoutBillingGlobal;
	private MkCheckoutConfirmation mkCheckoutConfirmation;
	private MkPayment mkPayment;

	@Inject
	public CheckoutPageStepDefGlobal(MkCheckoutPage_Global mkCheckoutPageGlobal, MkCheckoutShipping_Global mkCheckoutShippingGlobal,
									 MkCheckoutBilling_Global mkCheckoutBillingGlobal, MkCheckoutConfirmation mkCheckoutConfirmation, MkPayment mkPayment) {
		this.mkCheckoutPageGlobal = mkCheckoutPageGlobal;
		this.mkCheckoutShippingGlobal = mkCheckoutShippingGlobal;
		this.mkCheckoutBillingGlobal = mkCheckoutBillingGlobal;
		this.mkCheckoutConfirmation = mkCheckoutConfirmation;
		this.mkPayment = mkPayment;
	}

	@And("SHIPPING: I input all required fields")
	public void shipping_i_input_all_required_fields() {
		mkCheckoutShippingGlobal.fillUpRequiredFields();
	}

	@And("SHIPPING: I click Ship to this address")
	public void shipping_i_click_ship_to_this_address() {
		mkCheckoutShippingGlobal.clickShipToThisAddress();
	}

	@And("SHIPPING: I click Continue to review and pay")
	public void i_click_continue_to_review_and_pay() {
		mkCheckoutShippingGlobal.clickContinueToReviewAndPay();
	}

	@And("BILLING: I input all required fields")
	public void billingIInputAllRequiredFields() {
		mkCheckoutBillingGlobal.fillUpRequiredFields();
	}

	@And("BILLING: I complete shipping section")
	public void billingICompleteShippingSection() {
		try {
			billingIInputAllRequiredFields();
		} catch (Exception e) {
		}
	}

	@And("BILLING: I verify the Email address field is displayed")
	public void billingIVerifyTheEmailAddressFieldIsDisplayed() {
		Assert.assertTrue("Email address field is not displayed", mkCheckoutBillingGlobal.isEmailAddressFieldDisplayed());
	}

	@And("I am on the Checkout page")
	public void iAmOnTheCheckoutPage() {
		Assert.assertTrue("not on checkout page", mkCheckoutPageGlobal.onCheckoutPage());
	}
	
	@And("I enter all required Billing address details")
	public void i_Enter_Required_Billing_Address_Details() {
		mkCheckoutBillingGlobal.fillUpRequiredFields();
	}
	
	@And("I enter card payment details")
	public void i_Enter_card_Payment_Details() {
		mkCheckoutBillingGlobal.fillCardDetails();
	}

	@And("I click on use this button")
	public void iClickOnUseThisButton() {
		mkCheckoutBillingGlobal.clickOnUseThisButton();
	}
	
	@And("I click on Pay button")
	public void iClickOnPayButton() {
		mkCheckoutBillingGlobal.clickOnPay();
	}
	
	@And("I select Paypal payment")
	public void i_Select_Paypal_Payment() {

		mkCheckoutBillingGlobal.selectPaypal();
	}
	
	@And("BILLING: I enter CVV")
	public void iEnterCVV() {
		mkCheckoutBillingGlobal.fillCardSecurityCodeField();
	}
	
	@Then("PAYMENT: I enter paypal Required details")
	public void iEnterpaypalRequireddetails() {
		mkPayment.fillUpPaypalPaymentDetais();
	}
	
	@Given("Order Confirmation: I verify order confirmation page is displayed")
	public void i_am_able_to_see_the_confirmation_page() {
		Assert.assertTrue("Expected to be on Order Confirmation Page",
				mkCheckoutConfirmation.isOrderConfirmed_global());
	}
	
	
}
