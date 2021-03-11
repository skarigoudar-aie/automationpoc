
package com.mk.testframework.stepdefs.crossPlatformSteps.eu;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_EuGlobal;
import com.mk.testframework.core.exceptions.TestEnvironmentException;
import com.mk.testframework.stepdefs.crossPlatformSteps.allRegions.MyAccountPageStepDef;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_Common;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_EU;
import com.mk.testframework.dt.util.PageUtils;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Raja
 *
 */
@SuppressWarnings("deprecation")
public class MyAccountPageStepDefEU {

	private MyAccountPageStepDef myAccountPageStepDef;
	private final Logger log = LoggerFactory.getLogger(getClass());
	private MkMyAccountPage_EuGlobal mkMyAccountPageEuGlobal;
	private TestData testData;
	private MkMyAccountPage_Common mkMyAccountPageCommon;
	private PageUtils pageUtils;
	private Context context;
	private MkHamburgerMenu mkHamburgerMenu;
	private MkMyAccountPage_EU mkMyAccountPage_EU;

	@Inject
	public MyAccountPageStepDefEU(TestData testData, MkMyAccountPage_EuGlobal mkMyAccountPageEuGlobal,
			MyAccountPageStepDef myAccountPageStepDef, MkMyAccountPage_Common mkMyAccountPageCommon,
			PageUtils pageUtils, Context context, MkMyAccountPage_EU mkMyAccountPage_EU,
			MkHamburgerMenu mkHamburgerMenu) {
		this.mkMyAccountPageEuGlobal = mkMyAccountPageEuGlobal;
		this.mkMyAccountPage_EU = mkMyAccountPage_EU;
		this.testData = testData;
		this.myAccountPageStepDef = myAccountPageStepDef;
		this.mkMyAccountPageCommon = mkMyAccountPageCommon;
		this.pageUtils = pageUtils;
		this.context = context;
		this.mkHamburgerMenu = mkHamburgerMenu;
	}

	@And("Address Book: I enter Address line1")
	public void i_enter_address_line1() {
		mkMyAccountPageEuGlobal.enterAddressLine1(testData.getUser().address.getStreetAddress1());
	}

	@And("Address Book: I enter Address line2")
	public void i_enter_address_line2() {
		try {
			mkMyAccountPageEuGlobal.enterAddressLine2(testData.getUser().address.getStreetAddress2());
		} catch (Exception e) {
		}
	}

	@And("Address Book: I click on save address button")
	public void i_click_on_save_address_button() {
		mkMyAccountPageEuGlobal.saveAddressbuttonclick();

	}

	@And("Address Book: I click on edit save address button")
	public void i_click_on_edit_save_address_button() {
		mkMyAccountPageEuGlobal.saveEditAddressbuttonclick();

	}

	@Then("Profile Address:I click on edit shipping address")
	public void i_click_on_edit_shipping_address() {
		try {
			mkMyAccountPageEuGlobal.clickEditdefaultShippingAddress();
		} catch (TestEnvironmentException e) {
			log.debug("Trying log out second time");
			mkMyAccountPageEuGlobal.clickEditdefaultShippingAddress();
		}
	}

	@And("Address Book: I edit Address line1")
	public void i_edit_address_line1() {
		mkMyAccountPageEuGlobal.enterAddressLine1(testData.getUser().address2.getStreetAddress1());
	}

	@And("Address Book: I edit Address line2")
	public void i_edit_address_line2() {
		try {
			mkMyAccountPageEuGlobal.enterAddressLine2(testData.getUser().address2.getStreetAddress2());
		} catch (Exception e) {
		}
	}

	@Then("Address Book:I click on delete shipping address")
	public void i_click_on_delete_shipping_address() {
		try {
			mkMyAccountPageEuGlobal.clickDeletedefaultShippingAddress();
		} catch (TestEnvironmentException e) {
			log.debug("Trying second time");
			mkMyAccountPageEuGlobal.clickDeletedefaultShippingAddress();
		}
	}

	@Then("Address Book:I confirm delete shipping address")
	public void i_confirm_delete_shipping_address() {
		try {
			mkMyAccountPageEuGlobal.confirmDeletedefaultShippingAddress();
		} catch (TestEnvironmentException e) {
			log.debug("Trying second time");
			mkMyAccountPageEuGlobal.confirmDeletedefaultShippingAddress();
		}
	}

	@When("Profile : I click on address book link")
	public void i_click_address_book_link() {

		try {
			mkMyAccountPageEuGlobal.clickAddressBook();
		} catch (TestEnvironmentException e) {
			log.debug("Trying Address book link second time");
			mkMyAccountPageEuGlobal.clickAddressBook();
		}

	}

	@When("Address Book: I click on enter address manually")
	public void i_click_on_enter_address_manually() {

		try {
			mkMyAccountPageEuGlobal.clickEnterAddressManually();
		} catch (TestEnvironmentException e) {
			log.debug("Trying second time");
			mkMyAccountPageEuGlobal.clickEnterAddressManually();
		}
	}

	@And("Address Book: I select title")
	public void i_select_title() {
		mkMyAccountPageEuGlobal.SelectTitle(testData.getUser().getTitle());
	}

	@And("Address Book: I input all required fields")
	public void addressBookIInputAllRequiredFields() {
		i_enter_address_line1();
		i_enter_address_line2();
		myAccountPageStepDef.i_enter_city();
		;
		myAccountPageStepDef.i_enter_postal_code();
		;
		i_select_title();
		myAccountPageStepDef.i_enter_Address_first_name();
		myAccountPageStepDef.i_enter_Address_last_name();
		myAccountPageStepDef.i_enter_Address_phone_number();
	}
	
	@And("Address Book: I add new address")
	public void addressBookIAddNewAddress() {
		i_click_on_enter_address_manually();
		addressBookIInputAllRequiredFields();
	}

	@And("I select and submit on \"(.*?)\" language preference")
	public void i_select_on_language_preference(String language) {
		mkMyAccountPageCommon.SelectLanguage(language);
	}

	@And("Profile: I verify \"(.*?)\" as language preference")
	public void i_verify_on_language_preference(String language) {
		mkMyAccountPageCommon.verifySelectedLanguage(language);
	}

	@And("Profile: I click on Favorites Link")
	public void i_navigate_to_favorites_page() {
		pageUtils.waitForPageToLoad();
		mkMyAccountPageCommon.clickFavorites();

	}

	@When("Profile: I click on Payment Information link")
	public void iClickOnPaymentInformationlink() {
		mkMyAccountPageEuGlobal.clickOnPaymentInformationLink();
	}

	@And("Payment Info: I Enter the Card Holder Name {string}")
	public void iEntertheCradHolderName(String name) {
		mkMyAccountPageEuGlobal.cardHolderName(name);
	}

	@And("Payment info: I Enter the Card Number")
	public void iEnterCardNumber() {
		mkMyAccountPageEuGlobal.enterCardNumber();
	}

	@And("Payment Info: I select Card Expiration Date")
	public void iSelectCardExpirationDate() {
		mkMyAccountPageEuGlobal.selectDateOfCardExpiration();
	}

	@And("Payment Info: I Enter Security Code")
	public void iEnterSecurityCode() {
		mkMyAccountPageEuGlobal.enterSecurityCode();
		pageUtils.sleepSeconds(2, "wait for page load");
	}

	@And("Payment Info: I click on Make Default Payment checkbox")
	public void iClickOnMakeDefaultPaymentCehckBox() {
		mkMyAccountPageEuGlobal.makeDefaultPayment();
	}

	@And("Payment Info: I click On Save Card button")
	public void iClickOnSavecardButton() {
		mkMyAccountPageEuGlobal.clickSavePayment();
	}

	@And("Payment Info: I Verify card is saved in profile {string}")
	public void iVerifyCardIsSaved(String cardHolder) {
		Assert.assertTrue(mkMyAccountPageEuGlobal.verifyCardIsSaved(cardHolder));

	}

	@And("Payment Info: I Delete Saved Payment in profile")
	public void iDeleteSavedPaymentInProfile() {
		mkMyAccountPageCommon.deleteSavedPayment();
	}

	@And("Payment Info: I verify card is deleted")
	public void iverifyCardisdeleted() {
		mkMyAccountPageCommon.verifyCardisDeleted();
	}
	
	@And("Address Book: I verify new address is saved with special characters first name and last name")
	public void i_verify_new_address_is_saved_With_Specialcharecters() {
			Assert.assertTrue(mkMyAccountPageCommon.verifyAddressFirstNameSaved().toLowerCase().contains(context.getSavedData("FirstName")));
	}
	
	@And("Payment Info: I verify new billing address is saved with special characters first name and last name")
	public void i_verify_new_billing_address_is_saved_With_Specialcharecters() {
			Assert.assertTrue(mkMyAccountPageEuGlobal.verifyCardIsSaved(context.getSavedData("FirstName")));
	}
	
	@And("Payment Info: I input all required fields and Billing address with special characters")
	public void iinputAllPaymentDetails() {
		mkMyAccountPageEuGlobal.cardHolderNameWitSpecialChar();
		mkMyAccountPageEuGlobal.enterCardNumber();
		mkMyAccountPageEuGlobal.selectDateOfCardExpiration();
		mkMyAccountPageEuGlobal.enterSecurityCode();
		pageUtils.sleepSeconds(2, "wait for page load");
		mkMyAccountPageEuGlobal.makeDefaultPayment();
		mkMyAccountPageEuGlobal.clickAddNewBillingAddress();
		pageUtils.sleepSeconds(2, "wait for page load");
		addressBookIAddNewAddress();
		mkMyAccountPageEuGlobal.clickSavePayment();
	}
	

	@And("Order_History: I click {int} order in the Order History Table")
	public void i_click_a_product_in_the_product_list(int number) {
		mkMyAccountPageEuGlobal.clickOrderAtPosition(number);
	}

	@And("Order Details: I verify subtotal is displayed and amount is same as Order Confirmation Page")
	public void i_verify_subtotal_displayed() {
		Assert.assertTrue("Subtotal is not present", mkMyAccountPageEuGlobal.isSubtotalDisplayed());
		Assert.assertTrue("Subtotal Value is not matched with Order Confirmation Page",
				mkMyAccountPageEuGlobal.verifySubtotalAmount());
	}

	@And("Order Details: I verify shipping is displayed and amount is same as Order Confirmation Page")
	public void i_verify_shipping_displayed() {
		Assert.assertTrue("Shipping is not present", mkMyAccountPageEuGlobal.isShippingDisplayed());
		Assert.assertTrue("Shipping Value is not matched with Order Confirmation Page",
				mkMyAccountPageEuGlobal.verifyShippingAmount());
	}

	@And("Order Details: I verify gift warp is displayed and amount is same as Order Confirmation Page")
	public void i_verify_gift_wrap_displayed() {
		Assert.assertTrue("Gift Wrap is not present", mkMyAccountPageEuGlobal.isGiftWrapDisplayed());
		Assert.assertTrue("Gift Wrap Value is not matched with Order Confirmation Page",
				mkMyAccountPageEuGlobal.verifyGiftWrapAmount());
	}

	@And("Order Details: I verify discount is displayed and amount is same as Order Confirmation Page")
	public void i_verify_discount_displayed() {
		Assert.assertTrue("discount is not present", mkMyAccountPageEuGlobal.isDiscountDisplayed());
		Assert.assertTrue("discount Value is not matched with Order Confirmation Page",
				mkMyAccountPageEuGlobal.verifyDiscountAmount());
	}

	@And("Order Details: I verify total is displayed and amount is same as Order Confirmation Page")
	public void i_verify_total_displayed() {
		Assert.assertTrue("total is not present", mkMyAccountPageEuGlobal.isTotalDisplayed());
		Assert.assertTrue("total Value is not matched with Order Confirmation Page",
				mkMyAccountPageEuGlobal.verifyTotalAmount());
	}

	@And("Order Details: I verify Order submission date is displayed")
	public void i_verify_order_status_and_date_displayed() {
		Assert.assertTrue("Submission Date is not present", mkMyAccountPageEuGlobal.orderSubmissionDateDisplayed());
	}

	@And("Payment Info: I add card if not available")
	public void iAddCardIfNotAvailable() {
		mkMyAccountPageEuGlobal.addCardIfNotAvailable();
	}

	@And("Payment Info: I Verify credit card is saved in profile with card holder name as {string}")
	public void iVerifyCreditCardIsSaved(String cardHolderName) {
		Assert.assertTrue("Name on card is not matched", mkMyAccountPageEuGlobal.verifyCardIsSaved(cardHolderName));
	}

	@And("Payment Info: I Delete Saved Payment in profile with card holder name as {string} and verify if card deleted")
	public void ideleteCreditCard(String cardHolderName) {
		Assert.assertTrue("Credit card is not deleted", mkMyAccountPageEuGlobal.deleteSavedPayment(cardHolderName));
	}
	
	@And("Address Book: I input all required fields with specila character in fName and lName")
	public void addressBookIInputAllRequiredFieldsWithSplCharInFnameAndLanme() {
		i_enter_address_line1();
		i_enter_address_line2();
		myAccountPageStepDef.i_enter_city();
		myAccountPageStepDef.i_enter_postal_code();
		i_select_title();
		
		myAccountPageStepDef.i_enter_Address_phone_number();
	}
	

	@And("Profile: I empty my favorites")
	public void iEmptyMyFavorites() {
		mkMyAccountPageEuGlobal.emptyMyFavorites();
	}

	@And("Profile: I click on Add all to Bag button")
	public void iClickOnAddAllToBagButton() {
		mkMyAccountPageEuGlobal.clickAddAllToBagButton();
	}

	@And("Profile: I save the favorites products count")
	public void saveTheFavoritesProductsCount() {
		String countOfproducts = mkMyAccountPageEuGlobal.getActiveFavCountInProfile();
		context.saveData("favCount", countOfproducts);
	}

	@And("Profile: I click on view all link")
	public void iClickOnViewAllLink() {
		String favoritesCount = Integer.toString(mkMyAccountPageEuGlobal.getFavoritesCount());
		context.saveData("favoritesCount", favoritesCount);
		mkMyAccountPageEuGlobal.clickOnViewAllLink();
	}

	@And("Favorites: I verify favourites page displaying all Favorite items saved")
	public void iVerifyFavoritesPageDisplayingAllFavoriteItemsSaved() {
		Assert.assertTrue("Not favorites page", mkMyAccountPageEuGlobal.isFavoritesPage());
		int favoritesCount = Integer.parseInt(context.getSavedData("favoritesCount"));
		Assert.assertEquals("Favorites in profile and Favorites page count not matched", favoritesCount,
				mkMyAccountPageEuGlobal.getFavoritesCount());
	}

	@And("Favorites: I remove product positioned {int} in favorites and verify favorites count")
	public void iRemoveProductPositionedInFavoritesAndVerifyFavoritesCount(int position) {
		mkMyAccountPageEuGlobal.removeFavoriteItem(position);
		int favCountBeforeRemove = Integer.parseInt(context.getSavedData("favCount"));
		Assert.assertEquals("Product not removed from favorites", favCountBeforeRemove,
				mkMyAccountPageCommon.getWishlistOrFavProductsCount() + 1);
	}

	@When("Profile: I click on Order History link")
	public void iClickOnOrderHistorylink() {
		mkMyAccountPageEuGlobal.clickOnOrderHistoryLink();
	}

	@Then("Profile: I verify User name in LHS")
	public void iVerifyUserName() {
		Assert.assertTrue("Profie name not displayed", mkMyAccountPageEuGlobal.getWelcomeText());
	}

	@And("Profile: I click on Edit default shipping address")
	public void iClickOnEditDefaultShippingAddress() {
		mkMyAccountPageEuGlobal.clickEditShippingAddressOnProfilePage();
	}

	@And("Profile: I click on ViewAll shipping address link")
	public void iClickOnViewAllShippingAddressLink() {
		mkMyAccountPageEuGlobal.clickViewAllShippingAddressOnProfilePage();
	}

	@And("Profile: I click on Edit Billing address under Payment Information section")
	public void iClickOnEditDefaultBillingAddress() {
		mkMyAccountPageEuGlobal.clickEditBillingAddressOnProfilePage();
	}

	@And("Payment Info: I click on Add New Billing Address link")
	public void iClickOnAddNewBillingAddressLink() {
		mkMyAccountPageEuGlobal.clickAddNewBillingAddress();
	}

	@And("Payment Info: I verify new billing address is saved")
	public void i_verify_new_billing_address_is_saved() {
		Assert.assertTrue(mkMyAccountPageEuGlobal.verifyBillingAddressSavedOnPaymentInfo().toLowerCase()
				.contains(testData.getUser().address.getStreetAddress1().toLowerCase()));
	}

	@And("Profile: I verfiy all favorites products added to cart from profile")
	public void iVerifyAllFavoritesProductsAddedToCartFromProfile() {
		int favoritesCount = Integer.parseInt(context.getSavedData("favCount"));
		Assert.assertEquals("Wishlist and bag count not matched", favoritesCount, mkHamburgerMenu.getBagCount() - 1);
	}
}
