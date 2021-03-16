package com.mk.testframework.stepdefs.crossPlatformSteps.allRegions;

import org.junit.Assert;
import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_Common;
import com.mk.testframework.core.env.Context;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Raja
 *
 */
@SuppressWarnings("deprecation")
public class MyAccountPageStepDef {
	
	private MkMyAccountPage_Common mkMyAccountPageCommon;
	private TestData testData;
	private Context context;
	
	@Inject
	public MyAccountPageStepDef(TestData testData, Context context, MkMyAccountPage_Common mkMyAccountPageCommon) {
		this.mkMyAccountPageCommon = mkMyAccountPageCommon;
		this.testData = testData;
		this.context =context;
	}

			
	@Then("I navigate to the profile Page")
	public void i_navigate_to_the_profile_page() {
		Assert.assertTrue("Expected to be on Profile Page", mkMyAccountPageCommon.waitForMyAccountWelcome());
	
	}

	@Then("Profile : I navigate to the Address book page")
	public void i_navigate_to_the_address_book_page() {
		Assert.assertTrue("Expected to be on Address book Page", mkMyAccountPageCommon.waitForAddressBookTitle());
	
	}
	
	@And("Address Book: I enter City")
	public void i_enter_city() {
		mkMyAccountPageCommon.enterCity(testData.getUser().address.getCity());
	}
	
	
	@And("Address Book: I enter Postal code")
	public void i_enter_postal_code() {
		mkMyAccountPageCommon.enterPostalCode(testData.getUser().address.getPostalCode());
	}
	
		
	@And("Address Book: I enter Address first Name")
	public void i_enter_Address_first_name() {
		mkMyAccountPageCommon.enterAddressFirstName(testData.getUser().getFirstname());
	}
	
	
	@And("Address Book: I enter Address last Name")
	public void i_enter_Address_last_name() {
		mkMyAccountPageCommon.enterAddressLastName(testData.getUser().getLastname());
	}
	
	
	@And("Address Book: I enter Address Phone number")
	public void i_enter_Address_phone_number() {
		mkMyAccountPageCommon.enterAddressPhoneNumber(testData.getUser().getPhoneNumber());
	}
	
	
	@And("Address Book:I select make this my default Shipping address")
	public void i_select_default_shipping_address() {
		mkMyAccountPageCommon.defaultShippingAddress();
	
	}
	
	
	@And("Address Book: I verify new address is saved")
	public void i_verify_new_address_is_saved() {
			//Assert.assertTrue(mkMyAccountPageCommon.verifyAddressSaved().toLowerCase().contains(testData.getUser().address.getStreetAddress1().toLowerCase()));
			String address=testData.getUser().address.getStreetAddress1().toLowerCase();
			String addedAdd=mkMyAccountPageCommon.verifyAddressSaved().toLowerCase();
			String addedAdd2=mkMyAccountPageCommon.verifyDefaultShippingAddressSaved().toLowerCase();

				if(addedAdd.contains(address) ||addedAdd2.contains(address) ) {
					Assert.assertTrue(true);
				}else {
					Assert.assertTrue(false);
				}
	}
		
	@And("Address Book: I edit City")
	public void i_edit_city() {
		mkMyAccountPageCommon.enterCity(testData.getUser().address2.getCity());
	}
	
	@And("Address Book: I edit county or state")
	public void i_edit_county_state() {
		mkMyAccountPageCommon.enterCountyState(testData.getUser().address2.getProvince());
	}
	
	
	@And("Address Book: I edit Postal code")
	public void i_edit_postal_code() {
		mkMyAccountPageCommon.enterPostalCode(testData.getUser().address2.getPostalCode());
	}
	
	
	@And("Address Book: I verify new edited address is saved")
	public void i_verify_new_edited_address_is_saved() {
		String address=testData.getUser().address2.getStreetAddress1().toLowerCase();
		String addedAdd=mkMyAccountPageCommon.verifyAddressSaved().toLowerCase();
		String addedAdd2=mkMyAccountPageCommon.verifyDefaultShippingAddressSaved().toLowerCase();
			if(addedAdd.contains(address) ||addedAdd2.contains(address) ) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
	}
	
	
	@Then("Profile: I click on change password link")
	public void i_click_on_edit_link() {
		mkMyAccountPageCommon.clickChangePassword();
    }
	
	
	@Then("Sign in flyout: I click on forgot password link")
	public void i_click_forget_password_link() {
		mkMyAccountPageCommon.clickOnForgotPassword();
	}
	
	 @And("Forgot password: I verify forgot password page is displayed")
	public void i_verify_forgot_password_page() {
		mkMyAccountPageCommon.verifyForgotPasswordPageConfirmation();
	
	 }
	 
	@And("I verify the Product is added to Favorites")
	public void i_verify_product_details_of_the_favorite_added() {
		mkMyAccountPageCommon.getfavProductDetails();

		}

		@And("Address Book: I enter Fname Lname with special character and verify Error displayed")
		public void iEnterFnameLnameAndVerifyErrordisplayed() {
			mkMyAccountPageCommon.enterAccountFnameLnameWithSPLchar();
		}
		
	@Then("Profile: I add a product position {int} in the Wishlist or Favorites to bag")
	public void iAddAProductPositionInTheWishlistOrFavoritesToBag(int position) {
		mkMyAccountPageCommon.addWishlitOrFavProductToCartFromProfile(position);
	}

	@And("Profile: I click Remove Link on Favorites Page")
	public void favIClickOnRemove() {
		mkMyAccountPageCommon.favClickRemove();
	}
	
	@And("Profile: I click On Order History Link")
	public void iClickOnOrderHistory() {
		mkMyAccountPageCommon.clickOrderHistoryLink();
	}
	
	@And("Order Details: I verify Order Number is displayed and same as Order Confirmation page")
	public void i_verify_oder_number_displayed() {
		Assert.assertTrue("Order Number Label is not present", mkMyAccountPageCommon.isOrderNumberLabelDisplayed());
		Assert.assertEquals("OrderNumer is not same as Order Confirmation Page", context.getSavedData("orderNumber"), mkMyAccountPageCommon.verifyOrderNumber());
	}
	
	@And("Order Details: I verify Shipping Address is displayed and same as Order Confirmation Page")
	public void i_verify_Shipping_Address_displayed() {
		Assert.assertTrue("Shipping Address Label is not present", mkMyAccountPageCommon.isShippingAddressLabelDisplayed());
		Assert.assertTrue("Shipping Address is not same as Order Confirmation Page", mkMyAccountPageCommon.verifyShippingAddress());
	}
	
	@And("Order Details: I verify Billing Address is displayed and same as Order Confirmation Page")
	public void i_verify_Billing_Address_displayed() {
		Assert.assertTrue("Billing Address Label is not present", mkMyAccountPageCommon.isBillingAddressLabelDisplayed());
		Assert.assertTrue("Billing Address is not same as Order Confirmation Page", mkMyAccountPageCommon.verifyBillingAddress());
	}
	
	@And("Order Details: I verify order summary container is displayed")
	public void i_verify_order_summary_container_displayed() {
		Assert.assertTrue("Order Summary is not present", mkMyAccountPageCommon.isOrderSummaryContainerDisplayed());
	}
	
	@Then("Order History: I verify order history title is displayed")
	public void i_verify_order_history_title() {
		Assert.assertTrue("Order History Title is not present", mkMyAccountPageCommon.isOrderHistoryTitleDisplayed());
	}
	
	@And("Order History: I verify Order submission date is displayed")
	public void i_verify_date_in_order_history() {
		Assert.assertTrue("Order Date is not present", mkMyAccountPageCommon.isDateDisplayedInOrderHistory());
	}
	
	@And("Order History: I verify Order Number is displayed and clickable")
	public void i_verify_Order_Number_in_order_history() {
		Assert.assertTrue("Order Date is not present", mkMyAccountPageCommon.isOrderNumberDisplayedInOrderHistory());
	}
	
	@And("Order History: I verify order status is displayed")
	public void i_verify_Order_status_in_order_history() {
		Assert.assertTrue("Order Date is not present", mkMyAccountPageCommon.isOrderStatusDisplayedInOrderHistory());
	}
	
	@And("Order History: I verify store is displayed")
	public void i_verify_store_in_order_history() {
		Assert.assertTrue("Order Date is not present", mkMyAccountPageCommon.isStoreDisplayedInOrderHistory());
	}
	
	@And("Order History: I verify order total is displayed")
	public void i_verify_order_total_in_order_history() {
		Assert.assertTrue("Order Date is not present", mkMyAccountPageCommon.isOrderTotalDisplayedInOrderHistory());
	}
	
	@And("Order History: I verify order submission date, order number, order status, store and order total is displayed")
	public void i_verify_order_row_details_in_order_history() {
		Assert.assertTrue("Order related details is not present", mkMyAccountPageCommon.isOrderdetailsDisplayedInOrderHistory());
	}
	
	@And("Address Book: I enter Address {string} and {string} with special charecters")
	public void i_enter_Address_first_name_Last_Name_Special(String fname, String lname) {
		mkMyAccountPageCommon.enterAddressFirstNameSpeci(fname);
		mkMyAccountPageCommon.enterAddressLastNameSpecial(lname);
	}
	
	@Given("I have {string} and {string} special characters")
	public void getSpecialCharecterFnameLname(String fname, String lname) {
		mkMyAccountPageCommon.saveFnameSpecialChar(fname);
		mkMyAccountPageCommon.saveLnameSpecialChar(lname);
	}

		@When("Profile: I click on breadCrumb link")
		public void iClickOnBreadCrumbLink() {
			Assert.assertTrue("BreadCurmb link not displayed", mkMyAccountPageCommon.isBreadCrumLinkDisplayed());
			mkMyAccountPageCommon.clickOnBreadCrumbLink();
		}
		
	@And("Profile: I verify product is added to the wishlist or favorites")
	public void iVerifyProductIsAddedToWishlist() {
		Assert.assertEquals("Product not added to wishlist", mkMyAccountPageCommon.getWishlistCount(),1);
	}

		@And("Profile: I click on Add New default shipping address")
		public void iClickOnAddNewDefaultShippingAddress() {
			mkMyAccountPageCommon.clickAddNewShippingAddressOnProfilePage();
		}

		@And("Address book: I verify all saved address displayed")
		public void iVerifyAllSavedAddressDisplayed() {
			Assert.assertTrue("Saved address not displayed", mkMyAccountPageCommon.verifySavedAddress());
		}

		@When("Profile: I click on Profile link")
		public void iClickOnProfilelink() {
			mkMyAccountPageCommon.clickOnProfileLink();
		}

		@And("Profile: I click on ViewAll Billing address link under Payment Information section")
		public void iClickOnViewAllShippingAddressLink() {
			mkMyAccountPageCommon.clickViewAllBillingAddressOnProfilePage();
		}

		@And("Profile: I click on Add New Billing address under Payment Information section")
		public void iClickOnAddNewDefaultBillingAddress() {
			mkMyAccountPageCommon.clickAddNewBillingAddressOnProfilePage();
		}
		
		@And("Enter user name {string}")
		public void enterusername(String username) {
			mkMyAccountPageCommon.enterusername(username);
			
		}
		
		@And("I enter password {string}")
		public void enterpassword(String password) {
			mkMyAccountPageCommon.enterpassword(password);
			
		}
		
		@And("I click on Sing in button")
		public void clickonsignbtn() {
			mkMyAccountPageCommon.clickonsigninbtn();	
			
		}
		
		
		
		    
}
