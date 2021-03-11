package com.mk.testframework.stepdefs.mobileSteps.na.allNaRegions;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.mobile.MkMobileHamburgerMenu;
import com.mk.testframework.dt.page.account.MkCreateAccountPage_Common;
import com.mk.testframework.dt.popup.MkSignInModal_NA;
import com.mk.testframework.dt.util.MkPageNavigator;
import com.mk.testframework.dt.util.ModalUtils;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.stepdefs.mobileSteps.allRegions.MainMenuStepDefMobile;
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
public class LoginStepDefMobileNA {
	private TestData testData;
	private MkSignInModal_NA mkSignInModalNA;
	private MainMenuStepDefMobile mainMenuStepDefMobile;
	private ModalUtils modalUtils;
	private MkMobileHamburgerMenu mkMobileHamburgerMenu;
	private MkCreateAccountPage_Common mkCreateAccountPageCommon;
	private MkPageNavigator mkPageNavigator;
	private Context context;
	private PageUtils pageUtils;


	@Inject
	public LoginStepDefMobileNA(MainMenuStepDefMobile mainMenuStepDefMobile, MkSignInModal_NA mkSignInModalNA, TestData testData,PageUtils pageUtils,

								ModalUtils modalUtils, MkMobileHamburgerMenu mkMobileHamburgerMenu, MkCreateAccountPage_Common mkCreateAccountPageCommon, MkPageNavigator mkPageNavigator, Context context) {
					
		this.testData = testData;
		this.mkCreateAccountPageCommon = mkCreateAccountPageCommon;
		this.mainMenuStepDefMobile = mainMenuStepDefMobile;
		this.mkSignInModalNA = mkSignInModalNA;
		this.modalUtils = modalUtils;
		this.mkMobileHamburgerMenu = mkMobileHamburgerMenu;
		this.mkPageNavigator = mkPageNavigator;
		this.context = context;
		this.pageUtils=pageUtils;
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
	
	
	@And("Login: I enter new user")
	public void i_enter_new_user() {
		mkCreateAccountPageCommon.enterEmailAddress(testData.getRandomEmail());
			
	}
	

	@When("Login: I close zip code modal")
	public void i_close_zip_code_modal() {
		modalUtils.closeZipCodePopupIfPresented();
	}

	@Given("Login: I Log In")
	public void i_log_in() {
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		mainMenuStepDefMobile.i_click_on_Sign_In_link();
		i_enter_username();
		i_enter_password();
		i_click_Sign_In_button();
		i_close_zip_code_modal();
		i_should_be_successfully_logged_in();
	}

	@Given("Login: I Log Out")
	public void i_log_out() {
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		mainMenuStepDefMobile.i_click_Sign_Out_link();
		pageUtils.refresh();
		pageUtils.sleepSeconds(5, null);
		i_should_be_successfully_logged_out();
	}

	@Then("I should be successfully logged in")
	public void i_should_be_successfully_logged_in() {
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		Assert.assertTrue("Expecting accounts link to ensure user is logged in",
				mkMobileHamburgerMenu.myAccountLinkIsPresent());
	}

	@Then("I should be successfully logged out")
	public void i_should_be_successfully_logged_out() {
		mkPageNavigator.goToHomePage();
		//mkMobileHamburgerMenu.closeHamburgerMenuIfOpen();
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		Assert.assertTrue("Expecting sign in link to ensure user is logged out",
				mkMobileHamburgerMenu.signInLinkIsPresent());
	}
	
	
	@And("Login: I enter new created email address")
	public void i_enter_new_created_user() {
		mkSignInModalNA.enterCreatedEmailAddress(context.getSavedData("email"));
		
	}
	
	@And ("Login: I enter changed password")
	public void i_enter_changed_password() {
		mkSignInModalNA.enterPassword(testData.getUser().getPassword()+"234");
	}
	
	
	@Then("I verify I am successfully logged in")
	public void i_verify_Iam_successfully_logged_in() {
		mkPageNavigator.goToHomePage();
		Assert.assertTrue("Expecting accounts link to ensure user is logged in",
				mkMobileHamburgerMenu.myAccountLinkIsPresent());
	}
	
	
	@Given("Login: I remote Log In")
	public void i_remote_log_in(){

		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		mainMenuStepDefMobile.i_click_on_Sign_In_link();
		i_enter_username();
		i_enter_password();
		i_click_Sign_In_button();
		pageUtils.sleepSeconds(1, "waiting for error message");
		}
	
	@Then("I verify the user is unable to login")
	public void user_unable_to_login() {
	mkMobileHamburgerMenu.validateErrorMessage();
		
	}
	
	@And("Login: I Verify Account locked after {int}th Unsuccessful Login Attemps")
	public void iVerifyAccountlockedforUnsuccessfulLoginAttemps(int numAttemps)
	{
		Assert.assertTrue("Account locked message not matched",mkSignInModalNA.unsuccessfulLoginAttemps(numAttemps));
	}

}
