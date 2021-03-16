
package com.mk.testframework.stepdefs.crossPlatformSteps.allRegions;

import com.mk.testframework.dt.header.MkCheckoutMenu;
import org.junit.Assert;
import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.page.account.MkCreateAccountPage_Common;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_Common;
import com.mk.testframework.dt.popup.MkEditProfileModal_NA;
import com.mk.testframework.dt.util.MkPageNavigator;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

/**
 * @author Raja
 *
 */
@SuppressWarnings("deprecation")
public class CreateAccountPageStepDef {

	private MkCreateAccountPage_Common mkCreateAccountPageCommon;
	private MkMyAccountPage_Common mkMyAccountPageCommon;
	private TestData testData;
	private MkCheckoutMenu mkCheckoutMenu;
	private MkEditProfileModal_NA mkEditProfileModalNA;
	private MkPageNavigator mkPageNavigator;
	private Context context;

	@Inject
	public CreateAccountPageStepDef(MkCreateAccountPage_Common mkCreateAccountPageCommon, TestData testData,
			MkMyAccountPage_Common mkMyAccountPageCommon, MkCheckoutMenu mkCheckoutMenu,
			MkEditProfileModal_NA mkEditProfileModalNA, MkPageNavigator mkPageNavigator, Context context) {
		this.mkCreateAccountPageCommon = mkCreateAccountPageCommon;
		this.mkMyAccountPageCommon = mkMyAccountPageCommon;
		this.testData = testData;
		this.mkCheckoutMenu = mkCheckoutMenu;
		this.mkEditProfileModalNA = mkEditProfileModalNA;
		this.mkPageNavigator =mkPageNavigator;
		this.context = context;
	}

	@And("SignUp: I enter new email address")
	public void i_enter_new_email_address() {
		testData.createRandomEmail();
		mkCreateAccountPageCommon.enterSignUpEmailAddress(testData.getRandomEmail());

	}

	@And("SignUp: I enter confirm email address")
	public void i_enter_confirm_email_address() {
		mkCreateAccountPageCommon.enterConfirmEmailAddress(testData.getRandomEmail());
	}

	@And("SignUp: I enter first Name")
	public void i_enter_first_name() {
		mkCreateAccountPageCommon.enterFirstName(testData.getUser().getFirstname());
	}

	@And("SignUp: I enter last Name")
	public void i_enter_last_name() {
		mkCreateAccountPageCommon.enterLastName(testData.getUser().getLastname());
	}

	@And("SignUp: I enter phone Number")
	public void i_enter_phone_number() {
		mkCreateAccountPageCommon.enterPhoneNumber(testData.getUser().getPhoneNumber());
	}

	@And("SignUp: I enter postal Code")
	public void i_enter_postal_code() {
		mkCreateAccountPageCommon.enterPostalCode(testData.getUser().address.getPostalCode());
	}

	@And("SignUp: I select birth Month")
	public void i_select_birth_month() {
		mkCreateAccountPageCommon.SelectBirthMonth(testData.getUser().getBirthmonth());
	}

	@And("SignUp: I select birth Day")
	public void i_select_birth_day() {
		mkCreateAccountPageCommon.SelectBirthDay(testData.getUser().getBirthday());
	}

	@And("SignUp: I select Gender")
	public void i_select_gender() {
		mkCreateAccountPageCommon.SelectGender(testData.getUser().getGender());
	}

	@And("SignUp: I enter New Password")
	public void i_enter_new_password() {
		mkCreateAccountPageCommon.enterNPassword(testData.getUser().getPassword());
	}

	@And("SignUp: I enter Confirm Password")
	public void i_enter_confirm_password() {
		mkCreateAccountPageCommon.enterConfirmPassword(testData.getUser().getPassword());
	}

	@And("SignUp: I agree to the Terms and Conditions")
	public void i_agree_to_the_terms_and_conditions() {
		mkCreateAccountPageCommon.agreeTermsAndConditions();

	}

	@When("SignUp: I click Register button")
	public void i_click_register_button() {
		mkCreateAccountPageCommon.clickRegister();

	}

	@Then("I navigate to the Shopping bag Page")
	public void i_navigate_to_the_shopping_bag_page() {
		Assert.assertTrue("Expected to be on Shopping Bag Page", mkCheckoutMenu.myAccountLinkIsPresent());
	}

	@Then("I select myaccount link")
	public void i_select_myaccount_link() {
		mkMyAccountPageCommon.clickMyAccountLink();
	}

	@Then("Profile: I click on edit link")
	public void i_click_on_edit_link() {
		mkMyAccountPageCommon.clickEditProfile();
	}

	@Then("Edit Profile: I navigate to the edit profile Model")
	public void i_navigate_to_the_profile_model() {
		Assert.assertTrue("Expected to be on Edit Profile Page",
				mkEditProfileModalNA.myAccountEditProfileModelIsPresent());
	}

	@Then("Edit Profile: I click save changes")
	public void i_click_save_changes() {
		mkMyAccountPageCommon.clickSaveChangesButton();
	}

	@Then("Edit Profile: I verify lastname updated")
	public void i_verify_lastname_updated() {
		String actual = mkMyAccountPageCommon.getLastName().toLowerCase().strip();
		String expected = testData.getRandomLastName().toLowerCase();

		Assert.assertTrue("Last name is expected to be updated; expected: " + expected + "|actual: " + actual,
				actual.equalsIgnoreCase(expected));
	}

	@Then("Edit Profile: I reset lastname")
	public void i_change_reset_name() {
		mkMyAccountPageCommon.resetLastName(testData.getUser().getLastname());
	}

	@And("SignUp: I enter Current Password")
	public void i_enter_current_password() {
		mkCreateAccountPageCommon.enterCurrentPassword(testData.getUser().getPassword());
	}

	@And("SignUp: I enter New Change Password")
	public void i_enter_new_change_password() {
		mkCreateAccountPageCommon.enterNewChangePassword(testData.getUser().getPassword() + "234");
	}

	@And("Profile: I am on Profile page")
	public void i_am_on_profile_page() {
		mkPageNavigator.onProfileLandingPage();
	}
	
	@And("SignUp: I enter Confirm Change Password")
	public void i_enter_confirm_change_password() {
		mkCreateAccountPageCommon.enterConfirmPassword(testData.getUser().getPassword() + "234");
	}

	@When("SignUp: I click Save Password button")
	public void i_click_save_password_button() {
		mkCreateAccountPageCommon.clickSavePassword();

	}
	
	@Then("Profile: I verify lastname with special characters displayed")
	public void i_verify_lastname_updated_with_special_charecter() {
		String actual = mkMyAccountPageCommon.getLastName().toLowerCase().strip();
		String expected = context.getSavedData("LastName").toLowerCase().trim();
		Assert.assertTrue("Last name is expected to be updated; expected: " + expected + " | actual: " + actual,
				actual.equalsIgnoreCase(expected));

	}
	
	@Then("Profile: I verify firstname with special characters displayed")
	public void i_verify_firstname_updated_with_special_charecter() {
		
		String actual = mkMyAccountPageCommon.getName().toLowerCase().strip();
		String expected = context.getSavedData("FirstName").toLowerCase().trim();
		boolean status = actual.equalsIgnoreCase(expected);
		Assert.assertTrue("First name is expected to be updated; expected: " + expected + " | actual: " + actual,
				actual.equalsIgnoreCase(expected));
	}
	
	@And("SignUp: I enter {string} and {string} with special charecters")
	public void i_enter_first_name_with_Special_Char(String fname, String lname) {
		mkCreateAccountPageCommon.enterFirstNameWithSplChar(fname);
		mkCreateAccountPageCommon.enterLastNameWithSplChar(lname);
	}

	@And("SignUp: I create an account with special character")
	public void i_create_account_with_specialcharacter(DataTable table) {
		mkCreateAccountPageCommon.createAccountWithSplCharacter(table);
	}
	
	@And("Enter email address {string}")
	public void enteremail(String email){
		mkCreateAccountPageCommon.createAccountEmail(email);
	}
	
	@And("Enter confirm email address {string}")
	public void enterConfirmemail(String confemail){
		mkCreateAccountPageCommon.comfirmemail(confemail);
	}
	
	@And("Enter firstname {string}")
	public void enterFirstname(String fname){
		mkCreateAccountPageCommon.enterFName(fname);
	}
	
	@And("Enter lastname {string}")
	public void enterLastname(String Lname){
		mkCreateAccountPageCommon.enterLName(Lname);
	}
	
    @And("Enter password {string}")
    public void pssword(String pwd){
		mkCreateAccountPageCommon.createAccountPwd(pwd);
	}
    
    
    @And("Enter confirm password {string}")
    public void confirmPssword(String confmpwd){
		mkCreateAccountPageCommon.createAccountconfrmPwd(confmpwd);
	}
        
    @And("click on terms and condition")
    public void checkboxTandC(){
		mkCreateAccountPageCommon.clickTandC();
	}
    
    @When("click on register button")
    public void clickRgter(){
		mkCreateAccountPageCommon.clickRegiter();
	}
    
    //@Then(" verify email address already exist error message")
    
}