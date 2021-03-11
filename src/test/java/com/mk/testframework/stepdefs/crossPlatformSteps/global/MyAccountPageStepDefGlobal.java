
package com.mk.testframework.stepdefs.crossPlatformSteps.global;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_EuGlobal;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_Global;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.core.exceptions.TestEnvironmentException;
import com.mk.testframework.stepdefs.crossPlatformSteps.allRegions.MyAccountPageStepDef;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_Common;
import org.junit.Assert;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_EU;

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
public class MyAccountPageStepDefGlobal {

	private MyAccountPageStepDef myAccountPageStepDef;
	private final Logger log = LoggerFactory.getLogger(getClass());
	private MkMyAccountPage_EuGlobal mkMyAccountPageEuGlobal;
	private MkMyAccountPage_Global mkMyAccountPageGlobal;
	private MkMyAccountPage_Common mkMyAccountPageCommon;
	private MkMyAccountPage_EU mkMyAccountPage_EU;
	private TestData testData;
	private PageUtils pageUtils;
	private Context context;
	private MkHamburgerMenu mkHamburgerMenu;

	@Inject
	public MyAccountPageStepDefGlobal(TestData testData, MkMyAccountPage_EU mkMyAccountPage_EU, MkMyAccountPage_EuGlobal mkMyAccountPageEuGlobal,MkMyAccountPage_Global mkMyAccountPageGlobal, MyAccountPageStepDef myAccountPageStepDef, MkMyAccountPage_Common mkMyAccountPageCommon, PageUtils pageUtils, Context context, MkHamburgerMenu mkHamburgerMenu) {
		this.mkMyAccountPageEuGlobal = mkMyAccountPageEuGlobal;
		this.mkMyAccountPageGlobal = mkMyAccountPageGlobal;
		this.mkMyAccountPage_EU = mkMyAccountPage_EU;
		this.testData = testData;
		this.myAccountPageStepDef = myAccountPageStepDef;
		this.mkMyAccountPageCommon = mkMyAccountPageCommon;
		this.pageUtils = pageUtils;
		this.context = context;
		this.mkHamburgerMenu = mkHamburgerMenu;
	}

	@When("Profile : I click on address book link")
	public void i_click_Sign_Out_link() {

		try {
			mkMyAccountPageGlobal.clickAddressBookAU();
		} catch (TestEnvironmentException e) {
			log.debug("Trying Address book link second time");
			mkMyAccountPageGlobal.clickAddressBookAU();
		}

	}

	@And("Address Book: I select state")
	public void i_select_state() {
		mkMyAccountPageGlobal.SelectState(testData.getUser().address.getProvince());
	}


	@And("Address Book: I edit state")
	public void i_edit_state() {
		mkMyAccountPageGlobal.SelectState(testData.getUser().address2.getProvince());
	}


	@And("Address Book: I select title")
	public void i_select_title() {
		mkMyAccountPageGlobal.SelectTitle(testData.getUser().getTitle());
	}


	@And("Address Book: I click on save address button")
	public void i_click_on_save_address_button() {
		mkMyAccountPageGlobal.saveAddressbuttonclick();

	}

	@And("Address Book: I click on edit save address button")
	public void i_click_on_edit_save_address_button() {
		mkMyAccountPageEuGlobal.saveEditAddressbuttonclick();

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



	@And("Address Book: I enter Address line1")
	public void i_enter_address_line1() {
		mkMyAccountPageEuGlobal.enterAddressLine1(testData.getUser().address.getStreetAddress1());
	}

	@And("Address Book: I enter Address line2")
	public void i_enter_address_line2() {
		try{
			mkMyAccountPageEuGlobal.enterAddressLine2(testData.getUser().address.getStreetAddress2());
		}
		catch(Exception e){
		}
	}


	@And("Address Book: I edit Address line1")
	public void i_edit_address_line1() {
		mkMyAccountPageEuGlobal.enterAddressLine1(testData.getUser().address2.getStreetAddress1());
	}


	@And("Address Book: I edit Address line2")
	public void i_edit_address_line2() {
		try{
			mkMyAccountPageEuGlobal.enterAddressLine2(testData.getUser().address2.getStreetAddress2());
		}
		catch(Exception e){
		}
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

	@And("Address Book: I input all required fields")
	public void addressBookIInputAllRequiredFields() {
		i_enter_address_line1();
		i_enter_address_line2();
		myAccountPageStepDef.i_enter_city();
		i_select_state();
		myAccountPageStepDef.i_enter_postal_code();;
		i_select_title();
		myAccountPageStepDef.i_enter_Address_first_name();
		myAccountPageStepDef.i_enter_Address_last_name();
		myAccountPageStepDef.i_enter_Address_phone_number();
	}
	

	@And("Address Book: I add new address")
	public void addressBookIAddNewAddress() {
		addressBookIInputAllRequiredFields();
	}
	
	 @And("Profile: I navigate to Favorites Page")
	 public void i_navigate_to_favorites_page()  {
		 pageUtils.waitForPageToLoad();  
		 mkMyAccountPageCommon.clickFavoritesGlobale();
	
	}
	 
	@And("Profile: I empty my favorites")
	public void iEmptyMyFavorites() {
		mkMyAccountPageEuGlobal.emptyMyFavorites();
	}
	 
	@And("Profile: I click on Add all to Bag button")
	public void iClickOnAddAllToBagButton(){
		mkMyAccountPageEuGlobal.clickAddAllToBagButton();
	}
	
	@And("Profile: I save the favorites products count")
	public void saveTheFavoritesProductsCount(){
		String countOfproducts = mkMyAccountPageEuGlobal.getActiveFavCountInProfile();
		context.saveData("favCount", countOfproducts);
	}
	

	@And("Profile: I verfiy all favorites products added to cart from profile")
	public void iVerifyAllFavoritesProductsAddedToCartFromProfile() {
		int favoritesCount=Integer.parseInt(context.getSavedData("favCount"));
		Assert.assertEquals("Wishlist and bag count not matched",favoritesCount , mkHamburgerMenu.getBagCount()-1);
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
		int favoritesCount=Integer.parseInt(context.getSavedData("favoritesCount"));
		Assert.assertEquals("Favorites in profile and Favorites page count not matched",favoritesCount , mkMyAccountPageEuGlobal.getFavoritesCount());
	}
	 
	
	@And("Favorites: I remove product positioned {int} in favorites and verify favorites count")
	public void iRemoveProductPositionedInFavoritesAndVerifyFavoritesCount(int position) {
		mkMyAccountPageEuGlobal.removeFavoriteItem(position);
		int favCountBeforeRemove= Integer.parseInt(context.getSavedData("favCount"));
		Assert.assertEquals("Product not removed from favorites", favCountBeforeRemove, mkMyAccountPageCommon.getWishlistOrFavProductsCount()+1);
	}
	
	@When("Profile: I click on Order History link")
	public void iClickOnOrderHistorylink() {
		mkMyAccountPageGlobal.clickOnOrderHistoryLink();
	}

	@When("Profile: I click on Favorites Link")
	public void iClickOnFavoritelink() {
		mkMyAccountPageGlobal.clickOnFavoriteLink();
	}
	@Then("Profile: I verify User name in LHS")
	public void iVerifyUserName()
	{
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
}

