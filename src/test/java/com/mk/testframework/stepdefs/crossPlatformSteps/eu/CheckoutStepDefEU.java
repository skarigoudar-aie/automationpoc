package com.mk.testframework.stepdefs.crossPlatformSteps.eu;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.page.account.MkCreateAccountPage_Common;
import com.mk.testframework.dt.page.checkout.MkCheckoutBilling_EU;
import com.mk.testframework.dt.page.checkout.MkCheckoutConfirmation;
import com.mk.testframework.dt.page.checkout.MkCheckoutShipping_EU;
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
public class CheckoutStepDefEU {

	private MkCheckoutShipping_EU mkCheckoutShippingEU;
	private MkCheckoutBilling_EU mkCheckoutBillingEU;
	private MkCheckoutConfirmation mkCheckoutConfirmation;
	private MkCreateAccountPage_Common mkCreateAccountPageCommon;
	private TestData testData;
	private PageUtils pageUtils;
	private MkPayment mkPayment;
	private Context context;

	@Inject
	public CheckoutStepDefEU(MkCheckoutShipping_EU mkCheckoutShippingEU, MkCheckoutBilling_EU mkCheckoutBillingEU,
							 MkCheckoutConfirmation mkCheckoutConfirmation, TestData testData, PageUtils pageUtils, 
							 MkCreateAccountPage_Common mkCreateAccountPageCommon, Context context, MkPayment mkPayment) {
		this.mkCheckoutShippingEU = mkCheckoutShippingEU;
		this.mkCheckoutBillingEU = mkCheckoutBillingEU;
		this.mkCheckoutConfirmation = mkCheckoutConfirmation;
		this.mkCreateAccountPageCommon = mkCreateAccountPageCommon;
		this.testData = testData;
		this.pageUtils = pageUtils;
		this.mkPayment = mkPayment;
		this.context = context;
	}

	@And("SHIPPING: I input all required fields")
	public void shipping_i_input_all_required_fields() {
		mkCheckoutShippingEU.fillUpRequiredFields();
	}
	
	@And("SHIPPING: I input all required fields for logged in user")
	public void shipping_i_input_all_required_fields_for_logged_in_user() {
		mkCheckoutShippingEU.fillUpRequiredFieldsForLoggedInUser();
	}
	
	@And("SHIPPING: I want to change the country from the dropdown")
	public void changeCountry() {
		mkCheckoutShippingEU.changeCountryToRandomCountry();
	}

	@And("SHIPPING: I click on YES, CONTINUE button")
	public void clickOnYesContinueBtn() {
		mkCheckoutShippingEU.clickYesContinueBtn();
	}

	@And("SHIPPING: I select language and click on continue")
	public void selectLanguage() {
		mkCheckoutShippingEU.selectLanguage();
	}

	@And("SHIPPING: I click Ship to this address")
	public void i_click_ship_to_this_address() {
		mkCheckoutShippingEU.clickShipToThisAddress();
	}

	@And("SHIPPING: I click Continue to review and pay")
	public void i_click_continue_to_review_and_pay() {
		mkCheckoutShippingEU.clickContinueToReviewAndPay();
	}

	@And("SHIPPING: I click Make billing address")
	public void shippingIClickMakeBillingAddress() {
		mkCheckoutShippingEU.clickMakeBillingAddressLink();
	}

	@And("BILLING: I click Apply a Giftcard")
	public void billingIClickApplyAGiftcard() {
		mkCheckoutBillingEU.clickApplyGiftCardHeader();
	}

	@And("BILLING: I click on cancel link")
	public void iClickOnCancelLink() {
		mkCheckoutBillingEU.closeGiftCardPopUp();
	}

	@And("BILLING: I enter gift card number and pin")
	public void billingIEnterGiftcardNumberAndPin() {
		mkCheckoutBillingEU.enterGiftCardNumber();
		mkCheckoutBillingEU.enterGiftCardPin();
	}

	@And("BILLING: I click on apply button")
	public void billingIClickApplyGiftcard() {
		mkCheckoutBillingEU.clickOnUseItBtn();
		;
	}

	@And("BILLING: I verify gift card applied to the cart")
	public void billingICheckGiftcardApplied() {
		Assert.assertTrue("Gift Card not applied", mkCheckoutBillingEU.isGiftCardManagePanelDisplayed());
	}

	@And("BILLING: I click on remove gift card")
	public void billingIRemoveGiftcard() {
		mkCheckoutBillingEU.clickOnRemoveGiftCardLink();
	}

	@And("BILLING: I verify gift card removed successfully")
	public void billingICheckGiftcardRemoved() {
		Assert.assertFalse("Gift Card not removed", mkCheckoutBillingEU.isGiftCardManagePanelDisplayed());
	}

	@And("SHIPPING: I click add new address link")
	public void shippingIClickAddNewAddressLink() {
		pageUtils.waitForPageToLoad();
		mkCheckoutShippingEU.clickAddNewAddressLink();
	}
	
	@And("BILLING: I click add new address link")
	public void billingIClickAddNewAddressLink() {
		pageUtils.waitForPageToLoad();
		mkCheckoutBillingEU.clickAddNewBillingAddressLink();
	}

	@And("SHIPPING: I click Enter Address Manually link")
	public void shippingIClickEnterAddressManuallyLink() {
		mkCheckoutShippingEU.clickEnterAddressManually();
	}

	@And("BILLING: I click on card payment option")
	public void billingIClickOnCardPaymentOption() {
		mkCheckoutBillingEU.clickCardPaymentOption();
	}

	@And("BILLING: I input all required fields")
	public void billingIInputAllRequiredFields() {
		if (mkCheckoutBillingEU.isCardPaymentPanelOpen()) {
			mkCheckoutBillingEU.fillUpRequiredCreditCardFields();
		}
	}

	@And("BILLING: I input all required card fields for Loggedin")
	public void billingIInputAllRequiredCardFieldsForLoggedin() {
		if (mkCheckoutBillingEU.isCardPaymentPanelOpen()) {
			mkCheckoutBillingEU.fillUpRequiredCreditCardFieldsLoggedin();
		}
	}
		
	@And("BILLING: I verify card Payment panel is open")
	public void iVerifyCardPaymentPanelOpened()
	{
		Assert.assertTrue("Credit card payment panel is not opened", mkCheckoutBillingEU.isCardPaymentPanelOpen());
	}

	
	@And("BILLING: I input all required fields for New card")
	public void billingIInputAllRequiredFieldsForNewCard() {
		if(mkCheckoutBillingEU.isCardPaymentPanelOpen()){
			mkCheckoutBillingEU.fillUpRequiredNewCreditCardFields_loggedIn();
		}
	}
	
	@And("SHIPPING: I verify Edit Shipping Address link is displayed")
	public void shippingIVerifyEditShippingAddressLinkIsDisplayed() {
		Assert.assertTrue("Link to edit shipping address is not displayed",
				mkCheckoutShippingEU.isEditShippingAddressLinkDisplayed());
	}

	@And("BILLING: I verify Edit Billing Address link is displayed")
	public void billingIVerifyEditBillingAddressLinkIsDisplayed() {
		Assert.assertTrue("Link to edit billing address is not displayed",
				mkCheckoutBillingEU.isEditBillingAddressLinkDisplayed());
	}

	@And("BILLING: I Verify Add New Billing Address link is Displayed")
	public void iVerifyAddNewBillingAddresslinkisDisplayed() {
		Assert.assertTrue("Link to add billing address is not displayed",
				mkCheckoutBillingEU.isAddNewBillingAddressLinkDisplayed());
	}

	@And("SHIPPING: I verify the Email address field is displayed")
	public void shippingIVerifyTheEmailAddressFieldIsDisplayed() {
		Assert.assertTrue("Email address field is not displayed", mkCheckoutShippingEU.isEmailAddressFieldDisplayed());
	}
	
	@And("BILLING: I verify the Email address field is displayed")
	public void billingIVerifyTheEmailAddressFieldIsDisplayed() {
		Assert.assertTrue("Email address field is not displayed", mkCheckoutShippingEU.isEmailAddressFieldDisplayed());
	}

	@Then("BILLING: I verify Check Gift Card Balance is not displayed")
	public void billingIVerifyCheckGiftCardBalanceIsNotDisplayed() {
		Assert.assertFalse("Check gift card balance link exists",
				mkCheckoutBillingEU.doesGiftCardCheckBalanceLinkExist());
		Assert.assertFalse("Check gift card balance button exists",
				mkCheckoutBillingEU.doesGiftCardCheckBalanceButtonExist());
	}

	@And("SHIPPING: I complete shipping section")
	public void shippingICompleteShippingSection() {
		try {
			shippingIClickEnterAddressManuallyLink();
			shipping_i_input_all_required_fields();
			shippingIClickMakeBillingAddress();
			i_click_ship_to_this_address();
		} catch (Exception e) {
		}
	}

	@And("BILLING: I verify gift card payment option is displayed")
	public void isBillingApplyAGiftcardDisplayed() {
		Assert.assertTrue("Link to edit billing address is not displayed",
				mkCheckoutBillingEU.isApplyAGiftcardDisplayed());
	}

	@And("BILLING: I verify close option displayed on the expanded gift card panel")
	public void isCancelLinkDisplayedOnGiftCardPanel() {
		Assert.assertTrue("Cancel Link on apply gift card panel is not displayed",
				mkCheckoutBillingEU.isCancelLinkDisplayedOnApplyGiftCardPanel());
	}

	@And("BILLING: I add new billing address")
	public void new_address_i_input_all_required_fields() {
		mkCheckoutBillingEU.addNewBillingAddress();
	}

	@And("BILLING: I add new billing address for guest")
	public void new_address_i_input_all_required_fields_guest() {
		mkCheckoutBillingEU.addNewBillingAddressGuest();
	}
	
	@And("BILLING: I add new billing address for guest {string} and {string} containing special charecters")
	public void new_address_i_input_all_required_fields_guest(String fname, String lname) {
		mkCheckoutBillingEU.addNewBillingAddressGuest(fname, lname);
	}
	
	@And("BILLING: I click save button to save new address")
	public void new_address_i_click_save() {
		mkCheckoutBillingEU.clickSave();
	}

	@Given("I verify Order confirmation page is displayed")
	public void i_am_able_to_see_the_confirmation_page() {
		Assert.assertTrue("Expected to be on Order Confirmation Page", mkCheckoutConfirmation.isOrderConfirmed());
	}

	@Given("Klarna: Enter additional details and continue")
	public void enter_additional_details_and_continue() {
		try {
			mkCheckoutBillingEU.enterAdditionalDetailsAndContinue();
		} catch (Exception e) {
		}
	}

	@And("BILLING: I complete billing address section")
	public void billingICompleteBillingAddressSection() {
		try {
			new_address_i_input_all_required_fields();
			new_address_i_click_save();
		} catch (Exception e) {
		}
	}

	@And("BILLING: I verify Billing Shipping Address is populated")
	public void billingIVerifyBillingShippingAddressIsPopulated() {
		Assert.assertFalse("not on checkout page", mkCheckoutBillingEU.getShippingAddress().isBlank());
	}

	@And("BILLING: I click on Apply a promo code link")
	public void i_click_on_Apply_promo_code() {
		pageUtils.sleepSeconds(5, "page load");
		mkCheckoutBillingEU.clickOnPromoCodeLink();
	}

	@And("BILLING: I enter promo code")
	public void i_enter_promo_code() {
		mkCheckoutBillingEU.enterPromoCode(testData.getUser().getpromocode());
	}

	@And("BILLING: I click on Apply button")
	public void I_click_on_Apply_button() {
		mkCheckoutBillingEU.clickOnApplyPromo();
	}

	@And("BILLING: I verified promo is applied succesfully")
	public void I_verified_promo_is_applied_succesfully() {
		Assert.assertTrue("Expected Display Promotions Container", mkCheckoutBillingEU.PromoApplied());
	}

	@When("SHIPPING: I enter postcode in Address field")
	public void iEnterPostCodeInAddressFeild() {
		mkCheckoutShippingEU.enterpostcode();
	}

	@When("SHIPPING: I enter key {string} in Address feild")
	public void iEnterKeyInAddressFeild(String key) {
		mkCheckoutShippingEU.enterKeyForSHippingAddress(key);
	}

	@And("SHIPPING: I select the Address from QAS Response")
	public void iSelectTheAddressFromQASResponse() {
		mkCheckoutShippingEU.selectAddressFromQAS();
	}

	@And("SHIPPING: I Fill Up Profile Details")
	public void iFillUpProfileDetails() {
		mkCheckoutShippingEU.fillUpProfileDetails();
	}

	@When("SHIPPING: I click on ship to this Address button")
	public void iClickOnShipToThisAddressButton() {
		mkCheckoutShippingEU.clickShipToThisAddress();
	}

	@When("SHIPPING: I Select Gift Wrap Note")
	public void iSelectGiftWrapNote() {
		Assert.assertTrue("Gift wrap is not selected", mkCheckoutShippingEU.selectGiftWrap());
	}

	@When("SHIPPING: I Remove Gift Wrap")
	public void iRemoveGiftWrap() {
		mkCheckoutShippingEU.removeGiftWrap();
	}

	@And("SHIPPING: I Remove the GiftWrap Note")
	public void iRemoveTheGiftWrapNote() {
		mkCheckoutShippingEU.removeGiftWrapNote();
	}
	
	@Then("SHIPPING: I Verify AddNote Link")
	public void iVerifyAddNoteLink() {
		mkCheckoutShippingEU.isAddNoteLinkDisplayed();
	}
	
	@And("SHIPPING: I ADD Gift Wrap Note")
	public void addGiftWrapNote() {
		Assert.assertTrue("Gift wrap note is not entered", mkCheckoutShippingEU.addGiftWrapNote());
	}

	@And("SHIPPING: I Verify RemoveNote Link")
	public void iVerifyRemoveNoteLink() {
		mkCheckoutShippingEU.isRemoveNoteLinkDisplayed();
	}

	@And("SHIPPING: I verify the QAS address result")
	public void IVerifyTheQASaddressResult() {
		mkCheckoutShippingEU.isResultDisplayedFromQAS();
	}

	@And("SHIPPING: I click on NO, I WANT TO STAY button")
	public void clickOnNoIWantToStayBtn() {
		mkCheckoutShippingEU.clickNoIWantToStayBtn();
	}

	@And("SHIPPING: I verify No I WANT TO STAY button displayed")
	public void checkNoIWantToStayBtn() {
		mkCheckoutShippingEU.isNoIWantToStayDisplayed();
	}
	
	@And("BILLING: I apply promo code {string}")
	public void iApplyPromoCode(String promo) {
		mkCheckoutBillingEU.applyPromocode(promo);
	}
	
	@And("SHIPPING: I input all required fields with new email")
	public void shipping_i_input_all_required_fields_with_new_email() {
		mkCheckoutShippingEU.fillUpRequiredFieldsWithNewEmail();
	}
	
	@And("BILLING: I enter card details as per employee code")
	public void iEnterCardDetailsAsPerEmployeeCode() {
		if (mkCheckoutBillingEU.isCardPaymentPanelOpen()) {
			mkCheckoutBillingEU.fillUpEmployeeCardDetails();
		}
	}
	
	@And("Order Confirmation: I Create an Account from Order Confrimation Page")
	public void i_create_account_from_order_confirmation_page() {
		mkCheckoutConfirmation.enterPasswordOnConfirmation(testData.getUser().getPassword());
		mkCheckoutConfirmation.enterConfirmPasswordOnConfirmation(testData.getUser().getPassword());
		mkCheckoutConfirmation.clickOnCreateAccountOnOrderConfirmationButton();
	}

	@And("Order Confirmation: I verify Account Creation Message Displayed on Order Confirmation Page")
	public void i_verify_account_created_from_order_confirmation_page() {
		Assert.assertTrue("Expected to be on Account Creation message on Order Confirmation Page",
				mkCheckoutConfirmation.isAccountCreated());
	}

	@And("Order Confirmation: I login after account creation from Oder Confirmation")
	public void i_click_Signin_after_account_creation_from_order_confirmation_page() {
		mkCheckoutConfirmation.clickOnSigninOrderConfirmation();
		mkCreateAccountPageCommon.enterEmailAddress(testData.getRandomEmail());
		mkCreateAccountPageCommon.enterPassword(testData.getUser().getPassword());
		mkCreateAccountPageCommon.clickSignIn();
	}
	
	@And("SHIPPING: I click on continue button for click & collect for Loggedin")
	public void iClickOnContinueButtonForLoggedinCC(){
		mkCheckoutShippingEU.clickOnContinueButtonLoggedinForCC();
	}

	@Then("SHIPPING: I verify Address details are Prepopulated as a {string}")
	public void iVerifyAddressDetailsArePrePopulated(String userType) {
		if (userType.equals("Guest")) {
			Assert.assertFalse("Postal code not matched", mkCheckoutShippingEU.verifAddressDetailsAreNotEmpty_Guest());
		} else {
			Assert.assertFalse("Postal code not matched",
					mkCheckoutShippingEU.verifAddressDetailsAreNotEmpty_Registered());
		}
	}

	@And("SHIPPING: I verify the Prepopulated Postcode is same as Address Lookup as a {string}")
	public void iVerifyPrepoPulatedPostcodeIsSameAsAddressLookUp(String userType) {
		if (userType.equals("Guest")) {
			Assert.assertTrue("Postal code not matched",
					mkCheckoutShippingEU.verifyPostCodeSameAsAddressLookUp_Guest());
		} else {
			Assert.assertTrue("Postal code not matched",
					mkCheckoutShippingEU.verifyPostCodeSameAsAddressLookUp_Registered());
		}
	}

	@And("SHIPPING: I verify Text field labels are displayed as a {string}")
	public void iVerifyProfileLabelsAreDisplayed(String userType) {
		if (userType.equalsIgnoreCase("Guest"))
			Assert.assertTrue("Lables is not displayed",
					mkCheckoutShippingEU.verifyMandatoryLabelsAreDisplayed_Guest());
		else {
			Assert.assertTrue("Lables is not displayed",
					mkCheckoutShippingEU.verifyMandatoryLabelsAreDisplayed_Registered());
		}
	}

	@And("SHIPPING: I verify text field of profile details as a {string}")
	public void iVerifyTextFeilsOfProfileDetails(String userType) {
		if (userType.equalsIgnoreCase("Guest")) {
			Assert.assertTrue("Form feilds are not displayed", mkCheckoutShippingEU.verifyDisplayOfFormFeilds_Guest());
		} else {
			Assert.assertTrue("Form feilds are not displayed",
					mkCheckoutShippingEU.verifyDisplayOfFormFeilds_Registered());
		}
	}

	@And("SHIPPING: I verify the Address fields max length no more than the 35 characters as a {string}")
	public void iVerifyTheAddressFieldsMaxLengthNoMoreThanThe35Characters(String userType) {
		if (userType.equalsIgnoreCase("Guest")) {
			Assert.assertTrue(mkCheckoutShippingEU.verifyAddressFieldsMaxLength_Guest());
		} else {
			Assert.assertTrue(mkCheckoutShippingEU.verifyAddressFieldsMaxLength_Registered());
		}
	}

	@And("SHIPPING: I enter address in QAS field")
	public void iEnterAddressInQASfield()
	{
		mkCheckoutShippingEU.enterAddressInQASfield();
	}

	@And("SHIPPING: I verify enter address manually link displayed")
	public void iEnterAddressManuallyLInk()
	{
		mkCheckoutShippingEU.verifyEnterAddressManullayLink();
	}

	@And("SHIPPING: I add new shipping address")
	public void iAddNewShippingAddress()
	{
		mkCheckoutShippingEU.fillUpProfileDetailsForAddNewShippingAddress();
	}
	
	@And("SHIPPING: I input all required fields for new user")
	public void iInputAllRequiredFieldsForNewUser()
	{
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();

		mkCheckoutShippingEU.fillAddressLine1(testData.getUser().address.getStreetAddress1());
		mkCheckoutShippingEU.fillAddressLine2(testData.getUser().address.getStreetAddress2());
		mkCheckoutShippingEU.fillCityLine(testData.getUser().address.getCity());
		mkCheckoutShippingEU.fillPostalCode(testData.getUser().address.getPostalCode());
		mkCheckoutShippingEU.selectTitle(3);
		mkCheckoutShippingEU.fillFirstName(testData.getUser().getFirstname());
		mkCheckoutShippingEU.fillLastName(testData.getUser().getLastname());
		mkCheckoutShippingEU.fillPhone(testData.getUser().getPhoneNumber());
	}
	
	@And("SHIPPING: I verify New shipping address added")
	public void iVerifyNewShippingAddressAdded()
	{
		Assert.assertTrue(mkCheckoutShippingEU.verifyNewShippingAddressAdded().toLowerCase().contains("AutoTest".toLowerCase()));
	}
	
	@And("SHIPPING: I Verify Selected Shipping Option")
	public void verifySelectedShippingOption() {
		Assert.assertTrue("Shipping Method is not displayed", mkCheckoutShippingEU.selectedShippingMethod());
	}

	@And("SHIPPING: I Verify Selected Shipping Address")
	public void verifySelectedShippingAddress() {
		Assert.assertTrue("Shipping Address is not displayed", mkCheckoutShippingEU.selectedShippingAddress());
	}

	@And("SHIPPING: I Verify Selected Shipping Address for Guest User")
	public void verifySelectedShippingAddressForGuestUser() {
		Assert.assertTrue("Shipping Address is not displayed", mkCheckoutShippingEU.selectedShippingAddressGuestUser());
	}

	@And("Order Confirmation: I verify Shipping Address in Order Confirmation Page")
	public void i_verify_Shipping_address_in_order_confirmation_page() {
		Assert.assertTrue("Shipping Address on Order Confirmation Page is not visible",
				mkCheckoutConfirmation.verifyShippingAddressOnOrderConfirmationEU());
	}

	@And("Order Confirmation: I verify Billing Address in Order Confirmation Page")
	public void i_verify_billing_address_in_order_confirmation_page() {
		Assert.assertTrue("Billing Address on Order Confirmation Page is not visible",
				mkCheckoutConfirmation.verifyBillingAddressOnOrderConfirmationEU());
	}

	@And("Order Confirmation: I verify Payment Method in Order Confirmation Page")
	public void i_verify_payment_method_in_order_confirmation_page() {
		Assert.assertTrue("Payment Method is on Order Confirmation Page is not visible", mkCheckoutConfirmation.verifyPaymentMethodOnOrderConfirmationEU());
	}
	
	@And("SHIPPING: I click on continue button for click & collect")
	public void iClickOnContinueButtonForCC() {
		mkCheckoutShippingEU.clickOnContinueButtonForCC();
	}
	
	@And("SHIPPING: I click on continue button for click & collect as a logged-in user")
	public void iClickOnContinueButtonForCCAsALoggedInUser() {
		mkCheckoutShippingEU.clickOnContinueButtonForCC_loggedInUser();
	}

	@And("BILLING: I add new billing address with new email")
	public void new_address_i_input_all_required_fields_with_new_email() {
		mkCheckoutBillingEU.addNewBillingAddressWithNewEmail();
	}

	@And("BILLING: I fill up billing address section")
	public void billingIFillUpBillingAddressSection() {
		try {
			new_address_i_input_all_required_fields_with_new_email();
			new_address_i_click_save();
		} catch (Exception e) {
		}
	}

	@And("BILLING: I verify new billing address is saved with special characters first name and last name for {string}")
	public void iVerifyBillingAddressSavedWithSpecialCharecter(String guest) {
		Assert.assertTrue( mkCheckoutBillingEU.iVerifySpecialCharecterInBillingAddress(guest).toLowerCase().trim().contains(context.getSavedData("FirstName").trim()));
	}
	
	@And("SHIPPING: I verify new shipping address is saved with special characters first name and last name for {string}")
	public void iVerifyShippingAddressSavedWithSpecialCharecter(String guest) {
		String actual=mkCheckoutShippingEU.iVerifySpecialCharecterInShippingAddress(guest).toLowerCase().trim();
		String expected= context.getSavedData("FirstName").toLowerCase().trim();
		Assert.assertTrue("Expected first name ",actual.contains(expected));

	}
	@And("SHIPPING: I enter Fname Lname with special character and verify Error displayed")
	public void iEnterFnameLnameWithSpecialCharacterAndVerifyErrorDisplayed()
	{
		mkCheckoutShippingEU.enterCheckoutFnameLnameWithSPLchar();
		pageUtils.clickBrowserBackButton();
		pageUtils.waitForPageToLoad();
	}
	
	 @And("BILLING: I enter Fname Lname with special character and verify Error displayed")
	   public void iEnterBillingFnameLnameWithSpecialCharacterAndVerifyErrorDisplayed() {
		 
		 mkCheckoutBillingEU.enterCheckoutBillingFnameLnameWithSPLchar();
		 
	  }
	 
	@And("Order Confirmation: I verify Your header has been placed header message")
	public void i_verify_header_message_in_order_confirmation_page() {
		Assert.assertTrue("Order confirmation title is not present", mkCheckoutConfirmation.verifyConfirmationTitleOnOrderConfirmationEU());
	}
	
	@And("Order Confirmation: I verify Thank you for shipping with Michael kors message")
	public void i_verify_thanks_message_in_order_confirmation_page() {
		Assert.assertTrue("Thanks message is not present", mkCheckoutConfirmation.verifyThanksMessageOnOrderConfirmationEU());
	}
	
	@And("Order Confirmation: I verify Create an account container is displayed")
	public void i_verify_create_an_account_in_order_confirmation_page() {
		Assert.assertTrue("Thanks message is not present", mkCheckoutConfirmation.verifyCreateAccountOnOrderConfirmationEU());
	}
	
	@And("Order Confirmation: I verify password, confirm password, and create account button is displayed")
	public void i_verify_password_confirm_password_createa_account_button_in_order_confirmation_page() {
		Assert.assertTrue("Thanks message is not present", mkCheckoutConfirmation.verifyPasswordConfirmPasswordAndCreateAccountButtonEU());
	}
	
	@And("Order Confirmation: I verify Shipping Method in Order Confirmation Page")
	public void i_verify_shipping_method_in_order_confirmation_page() {
		Assert.assertTrue("Shipping Method is on Order Confirmation Page is not visible", mkCheckoutConfirmation.verifyShippingMethodOnOrderConfirmationEU());
	}
	
	@And("Order Confirmation: I verify estimated delivery date in Order Confirmation Page")
	public void i_verify_expected_delivery_date_in_order_confirmation_page() {
		Assert.assertTrue("Expected delivery date is on Order Confirmation Page is not visible", mkCheckoutConfirmation.verifyExpectedDeliveryOnOrderConfirmationEU());
	}
	
	@And("Order Confirmation: I verify product image, product title, store style, color, size, quantity and price was and now for SHIP to home product")
	public void i_verify_details_for_STH_product_date_in_order_confirmation_page() {
		Assert.assertTrue("Expected delivery date is on Order Confirmation Page is not visible", mkCheckoutConfirmation.verifyDetailsForSTHProductOnOrderConfirmationEU());
	}
	
	@And("Order Confirmation: I verify product image, product title, store style, color, size, quantity and price was and now for click and collect product")
	public void i_verify_details_for_CnC_product_date_in_order_confirmation_page() {
		Assert.assertTrue("Expected delivery date is on Order Confirmation Page is not visible", 
		mkCheckoutConfirmation.verifyDetailsForCnCProductOnOrderConfirmationEU());
	}
	
	@Then("PAYMENT: I enter paypal Required details")
	public void iEnterpaypalRequireddetails() {
		mkPayment.fillUpPaypalPaymentDetais();
	}
	
	@And("SHIPPING: I click continue button")
	public void iClickContinueBtn() {
		mkCheckoutShippingEU.clickOnContinueButton();
	}
	
	@And("SHIPPING: I click continue guest CIS button")
	public void iClickContinueGuestCISBtn() {
		mkCheckoutShippingEU.clickOnContinueCISButton();
	}
	
	@Then("PAYMENT: I click on Pay Now button")
	public void iClickOnPayNowButton() {
		mkPayment.clickOnPayNowButton();
	}
	
	@And("BILLING: I click on add a new gift card link")
	public void iClickOnAddANewGiftCardLink() {
		pageUtils.sleepSeconds(2, "page load");
		mkCheckoutBillingEU.clickOnAddNewGiftCard();
		pageUtils.sleepSeconds(2, "page load");
	}
	
	@And("BILLING: I enter CVV")
	public void iEnterCVV() {
		mkCheckoutBillingEU.fillCardSecurityCodeField();
	}

	@And("BILLING: Add card details if no saved card, else enter CVV")
	public void addCardDetailsIfNoSavedCardElseEnterCVV() {
		mkCheckoutBillingEU.enterCVVIfCardAvailableElseAddCard();
	}
	
	@And("SHIPPING: I Select Shipping Address from Drop Down")
	public void i_select_shipping_Address_from_drop_down() {
		mkCheckoutShippingEU.selectShippingAddressFromDropDown();
	}
	
	@And("SHIPPING: I input all required address field for Loggedin User")
	public void shipping_i_input_all_required_fieldsLoggedin() {
		mkCheckoutShippingEU.fillUpRequiredFieldsLoggedin();
	}
	
	@And("SHIPPING: I input all required edit address field for Loggedin User")
	public void shipping_i_clear_all_required_fields() {
		mkCheckoutShippingEU.fillUpRequiredFieldsForEditLoggedin();
	}
	
	@And("SHIPPING: I input all required edit address field for Anonymous User")
	public void shipping_i_input_all_required_edit_Address_fields() {
		mkCheckoutShippingEU.fillUpRequiredFieldsForEditAnonymous();
	}
	
	@And("SHIPPING: I click on save after editing the address")
	public void shipping_i_save_edited_Address() {
		mkCheckoutShippingEU.clickSaveAddressAfterEdit();
	}
	
	@And("BILLING: I click on save card details check box")
	public void billing_i_click_on_save_card_details() {
		mkCheckoutBillingEU.clickSaveCardDetails();
	}
	
	@And("BILLING: I input card holder name as {string}")
	public void cardHolderNameInCardFieldsForLoggedin(String cardHolderName) {
		if(mkCheckoutBillingEU.isCardPaymentPanelOpen()){
			mkCheckoutBillingEU.fillCardholderNameField(cardHolderName);
		}
	}
	
	@And("BILLING: I input card number")
	public void cardNumberInCardFieldsForLoggedin() {
		if(mkCheckoutBillingEU.isCardPaymentPanelOpen()){
			mkCheckoutBillingEU.fillCardNumberField();;
		}
	}
	
	@And("BILLING: I select Card Expiration Date")
	public void cardExpirationInCardFieldsForLoggedin() {
		if(mkCheckoutBillingEU.isCardPaymentPanelOpen()){
			mkCheckoutBillingEU.selectCardExpirationMM();
			mkCheckoutBillingEU.selectCardExpirationYYYY();
		}
	}
	
	@And("BILLING: I input card security code")
	public void cardSecurityCodeInCardFieldsForLoggedin() {
		if(mkCheckoutBillingEU.isCardPaymentPanelOpen()){
			mkCheckoutBillingEU.fillCardSecurityCodeFieldLoggedin();
		}
	}

	@And("BILLING: I click Add a new Giftcard")
	public void i_click_on_add_a_new_gift_card() {
		Assert.assertTrue("Unable to click on the add a new gift card link",
				mkCheckoutBillingEU.isNewGiftCardPanelOpen());
	}

	@And("BILLING: I verify last four digits of applied gift card is displayed for {string} and {string}")
	public void i_verify_last_four_digits_of_gift_card_displayed(String card1, String card2) {
		Assert.assertTrue("Last four digits not displayed",
				mkCheckoutBillingEU.isLastFourDigitsOfAppliedGiftCardDisplayed(card1, card2));
	}

	@And("BILLING: I verify remove link displayed")
	public void i_verify_remove_gift_card_displayed() {
		Assert.assertTrue("Remove gift card not displayed", mkCheckoutBillingEU.isRemoveGiftCardLinkDisplayed());
	}

	@And("BILLING: I verify gift card amount displayed")
	public void i_verify_gift_card_amount_displayed() {
		Assert.assertTrue("Applied gift card amount not displayed", mkCheckoutBillingEU.isAppliedGiftAmountDisplayed());
	}

	@And("BILLING: I click on remove gift cards")
	public void billingIRemoveGiftcards() {
		mkCheckoutBillingEU.clickOnRemoveGiftCardsLink();
	}

	@Given("Klarna Pay Later: Enter additional details and continue")
	public void enter_additional_details_and_continue_klarna_pay_later() {
		try {
			mkCheckoutBillingEU.enterAdditionalDetailsAndContinueKlarnaPayLater();
		} catch (Exception e) {
		}
	}
	
	@And("SHIPPING: I click on edit shipping address link")
	public void shippingIClickEditShippingAddressLink() {
		mkCheckoutShippingEU.clickEditShippingAddressLink();
	}
	
	@And("SHIPPING: I verify new edited shipping address is saved")
	public void i_verify_new_edited_shipping_address_is_saved() {
		Assert.assertTrue(context.getSavedData("shippingAddressText").toLowerCase().contains(testData.getUser().address2.getStreetAddress1().toLowerCase()));
	}
	
	@And("SHIPPING: I input all required fields for logged in user with {string} and {string} containing special charecters")
	public void shipping_i_input_all_required_fields_for_logged_in_user_Special(String fname, String lname) {
		mkCheckoutShippingEU.fillUpRequiredFieldsForLoggedInUserWithSplChar(fname, lname);
	}
	
	@And("SHIPPING: I input all required fields with {string} and {string} having special charecters")
	public void shipping_i_input_all_required_fields(String fname, String lname) {
		mkCheckoutShippingEU.fillUpRequiredFields(fname, lname);
	}
	
	@And("BILLING: I input all required fields with firstname and lastname having special charecters")
	public void new_address_i_input_all_required_fields_WithSplChar() {
		mkCheckoutBillingEU.addNewBillingAddressWithSplChar();
	}
	
	@And("SHIPPING: I get shipping charge from shipping option")
	public void verifyShippingChargeFromSelectedShippingOption() {
		mkCheckoutShippingEU.shipingChargeFromSelectedShippingMethod();
	}
	
	@And("BILLING: I change the Shipping Option to {string}")
	public void i_change_shipping_method(String shipOption) {
		mkCheckoutBillingEU.selectShippingOption(shipOption);
	}
}
