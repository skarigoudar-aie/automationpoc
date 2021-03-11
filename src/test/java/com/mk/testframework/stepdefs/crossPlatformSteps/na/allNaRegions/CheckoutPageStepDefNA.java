package com.mk.testframework.stepdefs.crossPlatformSteps.na.allNaRegions;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.page.checkout.MkCheckoutBilling_NA;
import com.mk.testframework.dt.page.checkout.MkCheckoutConfirmation;
import com.mk.testframework.dt.page.checkout.MkCheckoutShipping_NA;
import com.mk.testframework.dt.page.checkout.MkPayment;
import com.mk.testframework.dt.util.PageUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")

public class CheckoutPageStepDefNA {
	private MkCheckoutShipping_NA mkCheckoutShippingNa;
	private MkCheckoutBilling_NA mkCheckoutBillingNA;
	private MkCheckoutConfirmation mkCheckoutConfirmation;
	private PageUtils pageUtils;
	private TestData testData;
	private Context context;
	private MkPayment mkPayment;
	
	@Inject
	public CheckoutPageStepDefNA(MkCheckoutShipping_NA mkCheckoutShippingNa, MkCheckoutBilling_NA mkCheckoutBillingNA
			, PageUtils pageUtils, MkCheckoutConfirmation mkCheckoutConfirmation, TestData testData, Context context, MkPayment mkPayment) {
		this.mkCheckoutShippingNa = mkCheckoutShippingNa;
		this.mkCheckoutBillingNA = mkCheckoutBillingNA;
		this.mkCheckoutConfirmation = mkCheckoutConfirmation;
		this.pageUtils = pageUtils;
		this.testData = testData;
		this.mkPayment = mkPayment;
		this.context = context;
	}

	@And("SHIPPING: I input all required fields")
	public void shipping_i_input_all_required_fields() {
		try {
			mkCheckoutShippingNa.selectSavedAddress();
		} catch (Exception e) {
			mkCheckoutShippingNa.fillUpRequiredFields();
		}
	}

	@And("SHIPPING: I click Continue to payment")
	public void i_click_continue_to_payment() {
		mkCheckoutShippingNa.clickContinueToPayment();
	}

	@And("SHIPPING: I verify Edit Shipping Address link is displayed")
	public void shippingIVerifyEditShippingAddressLinkIsDisplayed() {
		Assert.assertTrue("Link to edit shipping address is not displayed",
				mkCheckoutShippingNa.isEditShippingAddressLinkDisplayed());
	}

	@And("BILLING: I click on card payment option")
	public void billingIClickOnCardPaymentOption() {
		mkCheckoutBillingNA.clickCardPaymentOption();
	}
	
	@And("BILLING: I input all required fields")
	public void billingIInputAllRequiredFields() {
		if (mkCheckoutBillingNA.isCardPaymentPanelOpen()) {
			mkCheckoutBillingNA.fillUpRequiredFields();
		}
	}
	
	@And("BILLING: I input all required fields along with {string} and {string} containing special charecters")
	public void billingIInputAllRequiredFields(String fname, String lname) {
		if (mkCheckoutBillingNA.isCardPaymentPanelOpen()) {
			mkCheckoutBillingNA.fillUpRequiredFields(fname, lname);
		}
	}
		
	@And("BILLING: I input all required fields with new email")
	public void billingIInputAllRequiredFieldswithNewEmail() {
		if (mkCheckoutBillingNA.isCardPaymentPanelOpen()) {
			mkCheckoutBillingNA.fillUpRequiredFieldsWithNewEmail();
		}
	}

	@And("BILLING: I verify Edit Billing Address link is displayed")
	public void billingIVerifyEditBillingAddressLinkIsDisplayed() {
		Assert.assertTrue("Link to edit billing address is not displayed",
				mkCheckoutBillingNA.isEditBillingAddressLinkDisplayed());
	}
	
	@And("BILLING: I click on edit billing address link")
	public void iClickOnEditBillingAddress()
	{
		mkCheckoutBillingNA.clickOnEditBillingAddress();
	}
	
	@And("BILLING: I Verify Add New Billing Address link is Displayed")
	public void iVerifyAddNewBillingAddresslinkisDisplayed() {
		Assert.assertTrue("Link to edit billing address is not displayed",
				mkCheckoutBillingNA.isAddNewBillingAddressLinkDisplayed());
	}

	@And("BILLING: I click on Continue To Order Review button")
	public void billingIClickOnContinueToOrderReviewButton() {
		mkCheckoutBillingNA.clickContinueToReviewButton();
	}

	@Then("BILLIng: I select saved Card and enter card Security code")
	public void iSelectSavedCardAndEnterCardSecurityCode() {
		mkCheckoutBillingNA.selectSavedCard();
	}
	
	@And("SHIPPING: I complete shipping section")
	public void shippingICompleteShippingSection() {
		try {
			shipping_i_input_all_required_fields();
		} catch (Exception e) {
		}
	}

	@And("BILLING: I verify the Email address field is displayed")
	public void billingIVerifyTheEmailAddressFieldIsDisplayed() {
		Assert.assertTrue("Email address field is not displayed", mkCheckoutBillingNA.isEmailAddressFieldDisplayed());
	}

	@And("BILLING: I verify Billing Shipping Address is populated")
	public void billingIVerifyBillingShippingAddressIsPopulated() {
		Assert.assertFalse("not on checkout page", mkCheckoutBillingNA.getShippingAddress().isBlank());
	}

	@And("BILLING: I click Apply a Giftcard")
	public void billingIClickApplyAGiftcard() {
		mkCheckoutBillingNA.clickApplyGiftCardHeader();
	}

	@And("BILLING: I verify gift card payment option is displayed")
	public void isBillingApplyAGiftcardDisplayed() {
		Assert.assertTrue("Link to edit billing address is not displayed",
				mkCheckoutBillingNA.isApplyAGiftcardDisplayed());
	}

	@And("BILLING: I verify close option displayed on the expanded gift card panel")
	public void isCancelLinkDisplayedOnApplyGiftCardPopUp() {
		Assert.assertTrue("Cancel Link on apply gift card panel is not displayed",
				mkCheckoutBillingNA.isCloseLinkDisplayedOnApplyGiftCardPanel());
	}

	@And("BILLING: I click on cancel link")
	public void iClickOnCancelLink() {
		mkCheckoutBillingNA.closeGiftCardPopUp();
	}

	@And("BILLING: I enter gift card number and pin")
	public void billingIEnterGiftcardNumberAndPin() {
		mkCheckoutBillingNA.enterGiftCardNumber();
		mkCheckoutBillingNA.enterGiftCardPin();
	}

	@And("BILLING: I click on apply button")
	public void billingIClickApplyGiftcard() {
		mkCheckoutBillingNA.clickOnUseItBtn();
		;
	}

	@And("BILLING: I verify gift card applied to the cart")
	public void billingICheckGiftcardApplied() {
		Assert.assertTrue("Gift Card not applied", mkCheckoutBillingNA.isGiftCardAppliedMessageDisplayed());
	}

	@And("BILLING: I close the pop up")
	public void billingICloseGiftcardPopUp() {
		mkCheckoutBillingNA.closeGiftCardPopUp();
	}

	@And("BILLING: I click on remove gift card")
	public void billingIRemoveGiftcard() {
		mkCheckoutBillingNA.clickOnRemoveGiftCardLink();
	}

	@And("BILLING: I verify gift card removed successfully")
	public void billingICheckGiftcardRemoved() {
		Assert.assertTrue("Gift Card not applied", mkCheckoutBillingNA.isGiftCardCheckBalanceLinkDisplayed());
	}

	@When("SHIPPING: I Select Gift Wrap Note")
	public void iSelectGiftWrapNote() {
		mkCheckoutShippingNa.selectGiftWrap();
	}
	
	@When("SHIPPING: I Remove Gift Wrap")
	public void iRemoveGiftWrap() {
		mkCheckoutShippingNa.removeGiftWrap();
	}

	@And("SHIPPING: I ADD Gift Wrap Note")
	public void addGiftWrapNote() {
		mkCheckoutShippingNa.addGiftWrapNote();
	}

	@Then("SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed")
	public void iVerifyRemoveNoteLink() {
		mkCheckoutShippingNa.verifyUserEnterTextNote();
		mkCheckoutShippingNa.isRemoveNoteLinkDisplayed();
	}

	@And("SHIPPING: I Remove the GiftWrap Note")
	public void iRemoveTheGiftWrapNote() {
		mkCheckoutShippingNa.removeGiftWrapNote();
	}

	@Then("SHIPPING: I Verify Text is Removed")
	public void iVerifyTextisRemoved() {
		pageUtils.verifyIfDisplayed(mkCheckoutShippingNa.removeNoteLinkNotDisplayed);
	}
	
	@And("BILLING: I enter card details as per employee code")
	public void iEnterCardDetailsAsPerEmployeeCode() {
		if(mkCheckoutBillingNA.isCardPaymentPanelOpen()){
			mkCheckoutBillingNA.fillUpEmployeeCardDetails();
		}
	}
	
	@Given("Order Confirmation: I verify order confirmation page is displayed")
	public void i_am_able_to_see_the_confirmation_page() {
		Assert.assertTrue("Expected to be on Order Confirmation Page",
				mkCheckoutConfirmation.isOrderConfirmedForNARegion());
	}

	@And("Order Confirmation: I Create an Account from Order Confrimation Page")
	public void i_create_account_from_order_confirmation_page() {
		mkCheckoutConfirmation.enterPasswordNARegion(testData.getUser().getPassword());
		mkCheckoutConfirmation.enterConfirmPasswordNARegion(testData.getUser().getPassword());
		mkCheckoutConfirmation.clickOnJoinKorsVIPButton();
	}
	
	@And("BILLING: I fill up billing address")
	public void IFillUpBillingAddress() {
		try {
			mkCheckoutBillingNA.selectSavedBillingAddress();
		} catch (Exception e) {
			mkCheckoutBillingNA.fillUpBillingAddress();
		}
	}
	
	@And("Order Confirmation: I verify Account Creation Message Displayed on Order Confirmation Page")
	public void i_verify_account_created_from_order_confirmation_page() {
		Assert.assertTrue("Expected to be on Account Creation message on Order Confirmation Page",
				mkCheckoutConfirmation.isAccountCreationMessageDesplayedForNA());
	}
	
	@And("Order Confirmation: I verify Shipping Address in Order Confirmation Page")
	public void i_verify_Shipping_address_in_order_confirmation_page() {

		Assert.assertTrue("Expected to be on Order Confirmation Page",
				mkCheckoutConfirmation.verifyShippingAddressOnOrderConfirmationNA());
	}

	@And("Order Confirmation: I verify Billing Address in Order Confirmation Page")
	public void i_verify_billing_address_in_order_confirmation_page() {
		Assert.assertTrue("Expected to be on Order Confirmation Page",
				mkCheckoutConfirmation.verifyBillingAddressOnOrderConfirmationNA());
	}

	@And("Order Confirmation: I verify Payment Method in Order Confirmation Page")
	public void i_verify_payment_method_in_order_confirmation_page() {
		Assert.assertTrue("Expected to be on Order Confirmation Page",
				mkCheckoutConfirmation.verifyPaymentMethodOnOrderConfirmationNA());
	}

	@And("Order Confirmation: I verify Order Summary Prices in Order Confirmation Page")
	public void i_verify_order_summary_prices_in_order_confirmation_page() {
		Assert.assertTrue("Expected to be on Order Confirmation Page",
				mkCheckoutConfirmation.verifyOrderSummaryPricesOnConfirmationNA());
	}

	@And("BILLING: I click Add a new Giftcard")
	public void i_click_on_add_a_new_gift_card() {
		Assert.assertTrue("Unable to click on the add a new gift card link",
				mkCheckoutBillingNA.isApplyAGiftcardpopUpOpen());
	}

	@And("BILLING: I verify last four digits of applied gift card is displayed for {string} and {string}")
	public void i_verify_last_four_digits_of_gift_card_displayed(String card1, String card2) {
		Assert.assertTrue("Last four digits not displayed",
				mkCheckoutBillingNA.isLastFourDigitsOfAppliedGiftCardDisplayed(card1, card2));
	}

	@And("BILLING: I verify remove link displayed")
	public void i_verify_remove_gift_card_displayed() {
		Assert.assertTrue("Remove gift card not displayed", mkCheckoutBillingNA.isRemoveGiftCardLinkDisplayed());
	}

	@And("BILLING: I verify gift card amount displayed")
	public void i_verify_gift_card_amount_displayed() {
		Assert.assertTrue("Applied gift card amount not displayed", mkCheckoutBillingNA.isAppliedGiftAmountDisplayed());
	}

	@And("BILLING: I click on remove gift cards link")
	public void i_click_on_remove_gift_cards() {
		Assert.assertTrue("Applied gift card amount not displayed", mkCheckoutBillingNA.isAllGiftCardsRemoved());
	}
	
	@And("Place Order: I click on Place Order button")
	public void IClickOnPlcaeOrderButton() {
		mkCheckoutBillingNA.clickOnPlaceOrderButton();
	}

	@And("SHIPPING: I select shipping address for logged-in user")
	public void iSelectShippingAdddressForLoggedInUser() {
		try {
			mkCheckoutShippingNa.selectSavedShippingAddress();
		} catch (Exception e) {
			mkCheckoutShippingNa.fillUpRequiredFields();
		}
	}
	 
	@Given("Order Confirmation: I verify order confirmation message for NA")
	public void verify_order_confirmation_message_on_confirmation_page() {
		Assert.assertTrue("Order confirmation message is not displayed on Order Confirmation Page",
				mkCheckoutConfirmation.verifyOrderConfirmedMessageForNARegion());
	}
	
	@Given("Order Confirmation: I verify password, confirm password and JOINkORSVIP button is displayed")
	public void verify_password_confirmpwd_joinkorsVIPButton_message_on_confirmation_page() {
		Assert.assertTrue("Order confirmation message is not displayed on Order Confirmation Page",
				mkCheckoutConfirmation.verifyPasswordConfirmPasswordAndJOINKorsVIPButtonNA());
	}
	
	@Given("Order Confirmation: I verify Shipping Method in Order Confirmation Page for NA")
	public void verify_shipping_method_on_confirmation_pageNA() {
		Assert.assertTrue("Shipping method is not displayed on Order Confirmation Page",
				mkCheckoutConfirmation.verifyShippingMethodForNARegion());
	}
	
	@Given("Order Confirmation: I verify Selected Store in Order Confirmation Page for NA")
	public void verify_Selected_store_on_confirmation_pageNA() {
		Assert.assertTrue("Selected Store is not displayed on Order Confirmation Page",
				mkCheckoutConfirmation.verifySelectedStoreForNARegion());
	}
	
	@Given("Order Confirmation: I verify product image, product title, store style, color, size, quantity and price was and now for SHIP to home product")
	public void verify_sth_product_confirmation_pageNA() {
		Assert.assertTrue("Ship to home porduct is not displayed on Order Confirmation Page",
				mkCheckoutConfirmation.verifySTHDetailsForNARegion());
	}
	
	@Given("Order Confirmation: I verify product image, product title, store style, color, size, quantity and price was and now for click and collect product")
	public void verify_cNc_product_confirmation_pageNA() {
		Assert.assertTrue("click and collect porduct is not displayed on Order Confirmation Page",
				mkCheckoutConfirmation.verifyCNCDetailsForNARegion());
	}
	
	@And("BILLING: I select paypal payment option")
	public void iSelectPaypalPaymentOption()
	{
		mkCheckoutBillingNA.selectPaypalPaymentOption();
	}

	@Then("PAYMENT: I enter paypal required details")
	public void iEnterpaypalRequireddetails() {
		mkPayment.fillUpPaypalPaymentDetais_NA();
	}

	@Then("BILLING: I fill up email address field")
	public void iFillUpEmailAddressField() {
		mkCheckoutBillingNA.enterEmmialAndConfirmEmail();
	}
	
	@Then("PAYMENT: I click on Pay Now button")
	public void iClickOnPayNowButton() {
		mkPayment.clickOnPayNowButton_NA();
	}
	

	@Then("Order Confrimation: I Verify Custom Product displayed in Order summary")
	public void iVerifyCustomProductInOrderSummary() {
		Assert.assertTrue("Custom product is missing in order summary",
				mkCheckoutConfirmation.verifyCustomaProduct_NA());
	}

	@Then("Order Confirmation: I verify split payment methods are displayed in Order summary")
	public void iVerifySplitPaymentMathodsAreDisplayed() {
		Assert.assertTrue("Paypal payment not displayed", mkCheckoutConfirmation.isPaypalPaymentDisplayed_NA());
		Assert.assertTrue("Paypal payment not displayed", mkCheckoutConfirmation.isPaymentDisplayed_NA());
	}
	
	@And("BILLING: Add card details if no saved card, else enter CVV")
	public void addCardDetailsIfNoSavedCardElseEnterCVV() {
		mkCheckoutBillingNA.enterCVVIfCardAvailableElseAddCard();
	}
		
	@And("BILLING: I enter CVV")
	public void iEnterCVV() {
		mkCheckoutBillingNA.enterCVV();
	}
	
	@And("BILLING: I input card holder name as {string}")
	public void cardHolderNameInCardFieldsForLoggedin(String cardHolderName) {
		if(mkCheckoutBillingNA.isCardPaymentPanelOpen()){
			mkCheckoutBillingNA.fillCardholderNameField(cardHolderName);
		}
	}

	@Then("Order Confirmation: I verify Payment method displayed")
	public void iVerifyPaymentMethod() {
		Assert.assertTrue("Payment name is missing", mkCheckoutConfirmation.isPaymentDisplayed_NA());
	}
	
	@And("BILLING: I input card number")
	public void cardNumberInCardFieldsForLoggedin() {
		if(mkCheckoutBillingNA.isCardPaymentPanelOpen()){
			mkCheckoutBillingNA.fillCardNumberField(testData.getCard().getCardNumber());;
		}
	}
	
	@And("BILLING: I select Card Expiration Date")
	public void cardExpirationInCardFieldsForLoggedin() {
		if(mkCheckoutBillingNA.isCardPaymentPanelOpen()){
			String expirationYYYY = testData.getCard().getExpirationYYYY();
			String expirationYY = expirationYYYY.substring(expirationYYYY.length() - 2);
			String expirationDate = testData.getCard().getExpirationMM()+"/"+expirationYY;
			mkCheckoutBillingNA.fillExpirationDate(expirationDate);
		}
	}
	
	@And("BILLING: I input card security code")
	public void cardSecurityCodeInCardFieldsForLoggedin() {
		if(mkCheckoutBillingNA.isCardPaymentPanelOpen()){
			mkCheckoutBillingNA.fillCardSecurityCodeFieldAddNew(testData.getCard().getSecurityCode());
		}
	}
	
	@And("BILLING: I click on Add a new card button")
	public void billingIClickOnAddNewCardLink() {
		if(mkCheckoutBillingNA.isCardPaymentPanelOpen()){
			mkCheckoutBillingNA.clickOnAddNewCardLink();
		}
	}
	
	@And("SHIPPING: I click on edit shipping address link")
	public void shippingIClickEditShippingAddressLink() {
		mkCheckoutShippingNa.clickEditShippingAddressLink();
	}
	
	@And("SHIPPING: I input all required fields for Edit Address")
	public void shipping_i_input_all_required_fields_for_edit() {
		mkCheckoutShippingNa.fillUpRequiredFieldsEdit();
	}
	
	@And("SHIPPING: I verify new edited shipping address is saved")
	public void i_verify_new_edited_shipping_address_is_saved() {
		Assert.assertTrue(context.getSavedData("shippingAddressText").toLowerCase().contains(testData.getUser().address2.getStreetAddress1().toLowerCase()));
	}
	@And("SHIPPING: I click add new address link")
	public void shippingIClickAddNewAddressLink() {
		
		mkCheckoutShippingNa.clickAddNewAddressLink();
	}
	@And("SHIPPING: I enter Fname Lname with special character and verify Error displayed")
	public void iEnterFnameLnameWithSpecialCharacterAndVerifyErrorDisplayed()
	{
		mkCheckoutShippingNa.enterCheckoutFnameLnameWithSPLchar();
		pageUtils.clickBrowserBackButton();
	}
	@And("BILLING: I enter Fname Lname with special character and verify Error displayed")
	public void iEnterCheckoutFnameLnameWithSpecialCharacterAndVerifyErrorDisplayed()
	{
		mkCheckoutBillingNA.enterCheckoutFnameLnameWithSPLchar();
	}
	
	
	@And("BILLING: I verify new billing address is saved with special characters first name and last name for {string}")
	public void iVerifyBillingAddressSavedWithSpecialCharecter(String guest) {
		Assert.assertTrue( mkCheckoutBillingNA.iVerifySpecialCharecterInBillingAddress(guest).toLowerCase().trim().contains(context.getSavedData("LastName").toLowerCase().trim()));

	}
	
	@And("SHIPPING: I verify new shipping address is saved with special characters first name and last name for {string}")
	public void iVerifyShippingAddressSavedWithSpecialCharecter(String guest) {
		Assert.assertTrue(mkCheckoutShippingNa.iVerifySpecialCharecterInShippingAddress(guest).toLowerCase().contains(context.getSavedData("FirstName").toLowerCase()));
	}
	
	
	@And("SHIPPING: I Verify Selected Shipping Option")
	public void verifySelectedShippingOption() {
		mkCheckoutShippingNa.selectedShippingMethod();
	}
	
	@And("SHIPPING: I get shipping charge from shipping option")
	public void getShippingChargeFromShippingOption() {
		mkCheckoutShippingNa.shipingChargeFromSelectedShippingMethod();
	}
	
	@And("BILLING: I change the Shipping Option to {string}")
	public void i_change_shipping_method(String shipOption) {
		mkCheckoutShippingNa.selectShippingOption(shipOption);
	}
}
