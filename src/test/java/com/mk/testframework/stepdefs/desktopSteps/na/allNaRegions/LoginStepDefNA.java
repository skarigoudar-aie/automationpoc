package com.mk.testframework.stepdefs.desktopSteps.na.allNaRegions;

import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.util.MkPageNavigator;
import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.popup.MkSignInModal_NA;
import com.mk.testframework.dt.util.ModalUtils;
import com.mk.testframework.stepdefs.desktopSteps.allRegions.MainMenuStepDef;
import com.mk.testframework.dt.page.account.MkCreateAccountPage_NA;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * @author Mlinderman
 *
 */
@SuppressWarnings("deprecation")
public class LoginStepDefNA {
	private TestData testData;
	private MkSignInModal_NA mkSignInModalNA;
	private MkCreateAccountPage_NA mkCreateAccountPageNA;
	private MainMenuStepDef mainMenuStepDef;
	private ModalUtils modalUtils;
	private MkHamburgerMenu mkHamburgerMenu;
	private MkPageNavigator mkPageNavigator;
	private Context context;

	@Inject
	public LoginStepDefNA(MainMenuStepDef mainMenuStepDef, MkSignInModal_NA mkSignInModalNA, TestData testData,
                          ModalUtils modalUtils, MkHamburgerMenu mkHamburgerMenu,
                          MkPageNavigator mkPageNavigator, Context context, MkCreateAccountPage_NA mkCreateAccountPageNA) {
		this.testData = testData;
		this.mainMenuStepDef = mainMenuStepDef;
		this.mkSignInModalNA = mkSignInModalNA;
		this.modalUtils = modalUtils;
		this.mkHamburgerMenu = mkHamburgerMenu;
		this.mkPageNavigator = mkPageNavigator;
		this.mkCreateAccountPageNA = mkCreateAccountPageNA;
		this.context = context;
	}

	@Given("Login: I enter email address")
	public void i_enter_username() {
		mkSignInModalNA.enterEmailAddress(testData.getUser().getEmail());
	}

	@Given("Login: I enter password")
	public void i_enter_password() {
		mkSignInModalNA.enterPassword(testData.getUser().getPassword());
	}

	@When("Login: I click Sign In button")
	public void i_click_Sign_In_button() {
		mkSignInModalNA.clickSignIn();
	}

	@When("Login: I close zip code modal")
	public void i_close_zip_code_modal() {
		modalUtils.closeZipCodePopupIfPresented();
	}

	@Given("Login: I Log In")
	public void i_log_in() {
		mainMenuStepDef.i_click_on_Sign_In_link();
		i_enter_username();
		i_enter_password();
		i_click_Sign_In_button();
		i_close_zip_code_modal();
		i_should_be_successfully_logged_in();
	}

	@Given("Login: I Log Out")
	public void i_log_out() {
		mainMenuStepDef.i_click_Sign_Out_link();
		i_should_be_successfully_logged_out();
	}

	@Then("I should be successfully logged in")
	public void i_should_be_successfully_logged_in() {
		mkPageNavigator.goToAccountInfoPage();
		Assert.assertTrue("Expecting accounts link to ensure user is logged in",
				mkHamburgerMenu.myAccountLinkIsPresent());
	}

	@Then("I should be successfully logged out")
	public void i_should_be_successfully_logged_out() {
		mkPageNavigator.goToAccountInfoPage();
		Assert.assertTrue("Expecting sign in link to ensure user is logged out",
				mkHamburgerMenu.signInLinkIsPresent());
	}
	
	@Then("I verify I am successfully logged in")
	public void i_verify_Iam_successfully_logged_in() {
		mkPageNavigator.goToHomePage();
		Assert.assertTrue("Expecting accounts link to ensure user is logged in",
				mkHamburgerMenu.myAccountLinkIsPresent());
	}
	
	@And("Login: I enter new created email address")
	public void i_enter_new_created_user() {
		mkCreateAccountPageNA.enterCreatedEmailAddress(context.getSavedData("email"));
		
	}
	
	@And ("Login: I enter changed password")
	public void i_enter_changed_password() {
		mkCreateAccountPageNA.enterPassword(testData.getUser().getPassword()+"234");
	}

	
	@Given("Login: I remote Log In")
	public void i_remote_log_in(){

		    mainMenuStepDef.i_click_on_Sign_In_link();
		    i_enter_username();
			i_enter_password();
			i_click_Sign_In_button();
			
		}
	
	@Then("I verify the user is unable to login")
	public void user_unable_to_login() {
	mkCreateAccountPageNA.validateErrorMessage();
	}
	
	@And("Login: I Verify Account locked after {int}th Unsuccessful Login Attemps")
	public void iVerifyAccountlockedforUnsuccessfulLoginAttemps(int numAttemps)
	{
		Assert.assertTrue("Account locked message not matched",mkSignInModalNA.unsuccessfulLoginAttemps(numAttemps));
	}

}


