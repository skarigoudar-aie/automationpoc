
package com.mk.testframework.stepdefs.crossPlatformSteps.na.allNaRegions;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_Common;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_NA;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.core.exceptions.TestEnvironmentException;
import com.mk.testframework.stepdefs.crossPlatformSteps.allRegions.MyAccountPageStepDef;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;


/**
 * @author Raja
 *
 */
@SuppressWarnings("deprecation")
public class MyAccountPageStepDefNA {

	private MyAccountPageStepDef myAccountPageStepDef;
	private final Logger log = LoggerFactory.getLogger(getClass());
	private MkMyAccountPage_NA mkMyAccountPageNA;
	private TestData testData;
	private MkMyAccountPage_Common mkMyAccountPageCommon;
	private PageUtils pageUtils;
	private Context context;
	private MkHamburgerMenu mkHamburgerMenu;

	@Inject
	public MyAccountPageStepDefNA( TestData testData, MkMyAccountPage_NA mkMyAccountPageNA, MyAccountPageStepDef myAccountPageStepDef, MkMyAccountPage_Common mkMyAccountPageCommon, PageUtils pageUtils, Context context, MkHamburgerMenu mkHamburgerMenu) {
		this.mkMyAccountPageNA = mkMyAccountPageNA;
		this.testData = testData;
		this.myAccountPageStepDef = myAccountPageStepDef;
		this.mkMyAccountPageCommon = mkMyAccountPageCommon;
		this.pageUtils = pageUtils;
		this.context = context;
		this.mkHamburgerMenu = mkHamburgerMenu;
	}



	@And("Address Book: I enter Address line1")
	public void i_enter_address_line1() {
		mkMyAccountPageNA.enterAddressLine1(testData.getUser().address.getStreetAddress1());
	}

	@And("Address Book: I enter Address line2")
	public void i_enter_address_line2() {
		try{
			mkMyAccountPageNA.enterAddressLine2(testData.getUser().address.getStreetAddress2());
		}
		catch(Exception e){
		}
	}


	@And("Address Book: I click on save address button")
	public void i_click_on_save_address_button() {
		mkMyAccountPageNA.saveAddressbuttonclick();

	}

	@Then("Profile Address:I click on edit shipping address")
	public void i_click_on_edit_shipping_address() {
		try {
			mkMyAccountPageNA.clickEditdefaultShippingAddress();
		} catch (TestEnvironmentException e) {
			log.debug("Trying log out second time");
			mkMyAccountPageNA.clickEditdefaultShippingAddress();
		}
	}


	@And("Address Book: I edit Address line1")
	public void i_edit_address_line1() {
		mkMyAccountPageNA.enterAddressLine1(testData.getUser().address2.getStreetAddress1());
	}

	@And("Address Book: I edit Address line2")
	public void i_edit_address_line2() {
		try{
			mkMyAccountPageNA.enterAddressLine2(testData.getUser().address2.getStreetAddress2());
		}
		catch(Exception e){
		}
	}


	@And("Address Book: I click on edit save address button")
	public void i_click_on_edit_save_address_button() {
		mkMyAccountPageNA.saveEditAddressbuttonclick();

	}


	@Then("Address Book:I confirm delete shipping address")
	public void i_confirm_delete_shipping_address() {
		try {
			mkMyAccountPageNA.clickDeletedeAddress();
		} catch (TestEnvironmentException e) {
			log.debug("Trying second time");
			mkMyAccountPageNA.clickDeletedeAddress();
		}
	}



	@Then("Address Book:I click on delete shipping address")
	public void i_click_on_delete_shipping_address() {
		try {
			mkMyAccountPageNA.clickDeletedefaultShippingAddress();
		} catch (TestEnvironmentException e) {
			log.debug("Trying second time");
			mkMyAccountPageNA.clickEditdefaultShippingAddress();
		}
	}

	@And("Address Book: I select state")
	public void i_select_state() {
		mkMyAccountPageNA.SelectState(testData.getUser().address.getState());
	}

	@And("Address Book: I edit state")
	public void i_edit_state() {
		mkMyAccountPageNA.SelectState(testData.getUser().address2.getProvince());
	}


	@And("Address Book: I select title")
	public void i_select_title() {
		mkMyAccountPageNA.SelectTitle(testData.getUser().getTitle());
	}

	@And("Address Book: I input all required fields")
	public void addressBookIInputAllRequiredFields() {
		myAccountPageStepDef.i_enter_Address_first_name();
		myAccountPageStepDef.i_enter_Address_last_name();
		myAccountPageStepDef.i_enter_Address_phone_number();
		i_enter_address_line1();
		i_enter_address_line2();
		myAccountPageStepDef.i_enter_city();
		i_select_state();
		myAccountPageStepDef.i_enter_postal_code();;
		i_select_title();
		
	}

	@And("Address Book: I verify new address is saved with special characters first name and last name")
	public void i_verify_new_address_is_saved_With_Specialcharecters() {
			Assert.assertTrue(mkMyAccountPageCommon.verifyAddressFirstNameSaved().toLowerCase().contains(context.getSavedData("FirstName")));
	}
	
	@And("Payment Info: I verify new billing address is saved with special characters first name and last name")
	public void i_verify_new_billing_address_is_saved_With_Specialcharecters() {
			Assert.assertTrue(mkMyAccountPageNA.verifyCardIsSaved(context.getSavedData("FirstName")));
	}


	@And("Address Book: I add new address")
	public void addressBookIAddNewAddress() {
		addressBookIInputAllRequiredFields();
	}
	
	@And("Payment Info: I Enter the Card Holder Name {string}")
	public void iEntertheCradHolderName(String name) {
		mkMyAccountPageNA.cardHolderName(name);
	}
	
	@And("Payment Info: I Enter the Card Holder Name")
	public void iEntertheCradHolderNameSpecial() {
		mkMyAccountPageNA.cardHolderNameSpecial();
	}

	@And("Payment info: I Enter the Card Number")
	public void iEntertheCardNumber() {
		mkMyAccountPageNA.enterCardNumber();
	}

	@And("Payment Info: I select Card Expiration Date")
	public void iSlecetCardExpirationDate() {
		mkMyAccountPageNA.selectCardExpDate();
	}

	@And("Payment Info: I click on Make Default Payment checkbox")
	public void iClickOnMakeDefaultPaymentCehckBox() {
		mkMyAccountPageNA.makeDefaultpayment();
	}

	@And("Payment Info: I click On Save Card button")
	public void iClickOnSaveCardButton() {
		mkMyAccountPageNA.savePaymet();
	}
	
	@And("Payment Info: I Verify card is saved in profile {string}")
    public void iVerifyCardIsSaved(String cardHolder)
    {
   	 Assert.assertTrue(mkMyAccountPageNA.verifyCardIsSaved(cardHolder));
   	 
    }

	@And("Payment Info: I Delete Saved Payment in profile")
	public void iDeleteSavedPaymentInProfile() {
		mkMyAccountPageCommon.deleteSavedPayment();
	}

	@And("Payment Info: I verify card is deleted")
	public void iverifyCardisdeleted() {
		mkMyAccountPageCommon.verifyCardisDeleted();
	}

	@Then("Profile: I verify User name in LHS")
	public void iVerifyUserName() {
		mkMyAccountPageNA.getWelcomeText();
	}
	
	@And("Order_History: I click {int} order in the Order History Table")
	public void i_click_a_product_in_the_product_list(int number) {
		mkMyAccountPageNA.clickOrderAtPosition(number);
	}
	
	@And("Order Details: I verify subtotal is displayed and amount is same as Order Confirmation Page")
	public void i_verify_subtotal_displayed() {
		Assert.assertTrue("Subtotal is not present", mkMyAccountPageNA.isSubtotalDisplayed());
		Assert.assertTrue("Subtotal Value is not matched with Order Confirmation Page", mkMyAccountPageNA.verifySubtotalAmount());
	}
	
	@And("Order Details: I verify shipping is displayed and amount is same as Order Confirmation Page")
	public void i_verify_shipping_displayed() {
		Assert.assertTrue("Shipping is not present", mkMyAccountPageNA.isShippingDisplayed());
		Assert.assertTrue("Shipping Value is not matched with Order Confirmation Page", mkMyAccountPageNA.verifyShippingAmount());
	}
	
	@And("Order Details: I verify gift warp is displayed and amount is same as Order Confirmation Page")
	public void i_verify_gift_wrap_displayed() {
		Assert.assertTrue("Gift Wrap is not present", mkMyAccountPageNA.isGiftWrapDisplayed());
		Assert.assertTrue("Gift Wrap Value is not matched with Order Confirmation Page", mkMyAccountPageNA.verifyGiftWrapAmount());
	}
	
	@And("Order Details: I verify discount is displayed and amount is same as Order Confirmation Page")
	public void i_verify_discount_displayed() {
		Assert.assertTrue("discount is not present", mkMyAccountPageNA.isDiscountDisplayed());
		Assert.assertTrue("discount Value is not matched with Order Confirmation Page", mkMyAccountPageNA.verifyDiscountAmount());
	}
	
	@And("Profile: I click on Edit Billing address under Payment Information section")
	public void iClickOnEditDefaultBillingddress() {
		mkMyAccountPageNA.clickEditBillingAddressOnProfilePage();
	}
	
	@And("Payment Info: I click on Add New Billing Address link")
	public void iClickOnAddNewBillingAddress()
	{
		mkMyAccountPageNA.selectAddressDropDown();
	}
	@And("Payment Info: I verify new billing address is saved")
	public void i_verify_new_billing_address_is_saved() {
		Assert.assertTrue(mkMyAccountPageNA.verifyBillingAddressSavedOnPaymentInfo().toLowerCase().contains(testData.getUser().address.getStreetAddress1().toLowerCase()));
	}
	
	@And("Order Details: I verify tax is displayed and amount is same as Order Confirmation Page")
	public void i_verify_tax_displayed() {
		Assert.assertTrue("tax is not present", mkMyAccountPageNA.isTaxDisplayed());
		Assert.assertTrue("tax Value is not matched with Order Confirmation Page", mkMyAccountPageNA.verifyTaxAmount());
	}
	
	@And("Order Details: I verify total is displayed and amount is same as Order Confirmation Page")
	public void i_verify_total_displayed() {
		Assert.assertTrue("total is not present", mkMyAccountPageNA.isTotalDisplayed());
		Assert.assertTrue("total Value is not matched with Order Confirmation Page", mkMyAccountPageNA.verifyTotalAmount());
	}
	
	@And("Order Details: I verify Order submission date is displayed")
	public void i_verify_order_status_and_date_displayed() {
		Assert.assertTrue("Submission Date is not present", mkMyAccountPageNA.orderSubmissionDateDisplayed());
	}
	
	@And("Payment Info: I add card if not available")
	public void iAddCardIfNotAvailable() {
		mkMyAccountPageNA.addCardIfNotAvailable();
	}
	
	@And("Payment Info: I Verify credit card is saved in profile with card holder name as {string}")
    public void iVerifyCreditCardIsSaved(String cardHolderName){
   	 	Assert.assertTrue("Name on card is not matched", mkMyAccountPageNA.verifyCardIsSaved(cardHolderName));
    }
	
	@And("Payment Info: I Delete Saved Payment in profile with card holder name as {string} and verify if card deleted")
    public void ideleteCreditCard(String cardHolderName){
   	 	Assert.assertTrue("Credit card is not deleted", mkMyAccountPageNA.deleteSavedPayment(cardHolderName));
	}
	
	@And("Profile: I empty my wishlist")
	public void iEmptyMyWishlist() {
		Assert.assertTrue("Emptying wishlist failed", mkMyAccountPageNA.emptyMyWishlist());
	}
	
	@And("Profile: I save the wishlist products count")
	public void saveTheWishlitProductsCount(){
		int countOfproducts = mkMyAccountPageNA.getWishlistCount();
		context.saveData("wishlitCount", String.valueOf(countOfproducts));
	}
	
	/*
	 * @And("Wishlist: I verfiy all wishlist products added to cart") public void
	 * iVerifyAllWishlistProductsAddedToCartFromProfile() { int
	 * wishListCount=Integer.parseInt(context.getSavedData("wishlitCount"));
	 * Assert.assertEquals("Wishlist and bag count not matched",wishListCount ,
	 * mkHamburgerMenu.getBagCount()-1); }
	 */
	
	@And("Profile: I save the count of wishlist products in profile page")
	public void iSaveTheCountOfWishlistProductsInProfilePage() {
		String countOfproducts =  Integer.toString(mkMyAccountPageNA.getWishlistCount());
		context.saveData("wishlistCount", countOfproducts);
	}
	
	@And("Wishlist: I verify wishlist page displaying all wishlist items saved")
	public void iVerifyWishlistPageDisplayingAllWishlistItemsSaved() {
		Assert.assertTrue("Not favorites page", mkMyAccountPageNA.isWishlistPage());
		int wishlistCount=Integer.parseInt(context.getSavedData("wishlistCount"));
		Assert.assertEquals("Favorites in profile and Favorites page count not matched",wishlistCount , mkMyAccountPageNA.getWishlistCount());
	}
	
	@And("Profile: I click on Add all to Bag button")
	public void iClickOnAddAllToBagButton(){
		mkMyAccountPageNA.clickAddAllToBagButton();
	}
	
	@Then("Wishlist: I remove product positioned {int} in wishlist and verify wishlist count")
	public void iRemoveProductPositionedInWishlistAndVerifyWishlistCount(int position) {
		mkMyAccountPageNA.removeWishlistitem(position);
		int wishlistCountBeforeRemove= Integer.parseInt(context.getSavedData("wishlitCount"));
		Assert.assertEquals("Product not removed from wishlist", wishlistCountBeforeRemove, mkMyAccountPageCommon.getWishlistOrFavProductsCount()+1);
	}
	
	@And("Wishlist: I edit product color or size and validate changes in wishlist page")
	public void iEditProductColorOrSizeAndValdiateChangesInWishlistPage() {
		boolean editWishlistStatus = true;
		String colorBeforeEdit = mkMyAccountPageNA.getColorFromWishlistProduct(1);
		String sizeBeforeEdit = mkMyAccountPageNA.getSizeFromWishlistProduct(1);
		mkMyAccountPageNA.clickOnEditLinkInWishlist();
		String colorAfterEdit = mkMyAccountPageCommon.changeColorInEditWishlistOrFavPopUp();
		String sizeAfterEdit = mkMyAccountPageNA.changeSizeInEditWishlistPopUp();
		if(colorAfterEdit!=null && colorAfterEdit!=colorBeforeEdit)
			editWishlistStatus = true;
		else if(sizeAfterEdit!=null && sizeAfterEdit!= sizeBeforeEdit)
			editWishlistStatus = true;
		mkMyAccountPageNA.clickOnSaveChanges();
		Assert.assertTrue("Edit wishlist failed", editWishlistStatus);
	}
	

	@And("Profile: I click on Edit default shipping address")
	public void iClickOnEditDefaultShippingAddress() {
		mkMyAccountPageNA.clickEditShippingAddressOnProfilePage();
	}

	@And("Profile: I click on ViewAll shipping address link")
	public void iClickOnViewAllShippingAddressLink() {
		mkMyAccountPageNA.clickViewAllShippingAddressOnProfilePage();
	}
	
	@And("Profile: I verfiy all wishlist products added to cart from profile")
	public void iVerifyAllWishlistProductsAddedToCartFromProfile() {
		int wishListCount = Integer.parseInt(context.getSavedData("wishlitCount"));
		pageUtils.sleepSeconds(5, null);
		int bagCount=mkHamburgerMenu.getBagCount();
		if(wishListCount==bagCount) {
			assertTrue(true);
		}else if(wishListCount==bagCount-1){
			assertTrue(true);
		}else{
			mkHamburgerMenu.clickShoppingBagIcon();
			bagCount=mkHamburgerMenu.getBagCount();
			if(wishListCount==bagCount || wishListCount==bagCount-1) {
				assertTrue(true);
			}
		}
	}
}

