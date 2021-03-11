package com.mk.testframework.stepdefs.mobileSteps.eu;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.mobile.MkMobileHamburgerMenu;
import com.mk.testframework.dt.page.account.MkCreateAccountPage_Common;
import com.mk.testframework.dt.page.account.MkCreateAccountPage_EU;
import com.mk.testframework.dt.util.MkPageNavigator;
import com.mk.testframework.stepdefs.mobileSteps.allRegions.MainMenuStepDefMobile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * @author VThipperudrappa
 *
 */
@SuppressWarnings("deprecation")
public class LoginStepDefMobileEU {
	private TestData testData;
	private MkCreateAccountPage_Common mkCreateAccountPageCommon;
	private MkMobileHamburgerMenu mkMobileHamburgerMenu;
	private MkPageNavigator mkPageNavigator;
	private MainMenuStepDefMobile mainMenuStepDefMobile;
	private MkCreateAccountPage_EU mkCreateAccountPageEU;
	private Context context;

	@Inject
	public LoginStepDefMobileEU(MainMenuStepDefMobile mainMenuStepDefMobile, MkCreateAccountPage_Common mkCreateAccountPageCommon, TestData testData,
								MkPageNavigator mkPageNavigator, MkMobileHamburgerMenu mkMobileHamburgerMenu, Context context, MkCreateAccountPage_EU mkCreateAccountPageEU) {
		this.testData = testData;
		this.mkCreateAccountPageCommon = mkCreateAccountPageCommon;
		this.mainMenuStepDefMobile = mainMenuStepDefMobile;
		this.mkMobileHamburgerMenu = mkMobileHamburgerMenu;
		this.mkPageNavigator = mkPageNavigator;
		this.mkCreateAccountPageEU = mkCreateAccountPageEU;
		this.context = context;
	}

	@Given("Login: I enter email address")
	public void i_enter_username() {
		mkCreateAccountPageCommon.enterEmailAddress(testData.getUser().getEmail());
	}

	@Given("Login: I enter password")
	public void i_enter_password() {
		mkCreateAccountPageCommon.enterPassword(testData.getUser().getPassword());
	}

	@When("Login: I click Sign In button")
	public void i_click_Sign_In_button() {
		mkCreateAccountPageCommon.clickSignIn();
	}

	
	@Given("Login: I Log In")
	public void i_log_in() {
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		mainMenuStepDefMobile.i_click_on_Sign_In_link();
		i_enter_username();
		i_enter_password();
		i_click_Sign_In_button();
		i_should_be_successfully_logged_in();
	}

	@Given("Login: I Log Out")
	public void i_log_out() {
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		mainMenuStepDefMobile.i_click_Sign_Out_link();
		i_should_be_successfully_logged_out();
	}

	@Then("I should be successfully logged in")
	public void i_should_be_successfully_logged_in() {
		mkPageNavigator.goToAccountInfoPage();
		mkMobileHamburgerMenu.closeHamburgerMenuIfOpen();
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();

		Assert.assertTrue("Expecting accounts link to ensure user is logged in",
				mkMobileHamburgerMenu.myAccountLinkIsPresent());
	}

	@Then("I should be successfully logged out")
	public void i_should_be_successfully_logged_out() {
		mkPageNavigator.goToAccountInfoPage();
		mkMobileHamburgerMenu.closeHamburgerMenuIfOpen();
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();

		Assert.assertTrue("Expecting sign in link to ensure user is logged out",
				mkMobileHamburgerMenu.signInLinkIsPresent());
	}
	
	
	@And("Login: I enter new created email address")
	public void i_enter_new_created_user() {
		mkCreateAccountPageCommon.enterCreatedEmailAddress(context.getSavedData("email"));
		
	}
		
	
	@And ("Login: I enter changed password")
	public void i_enter_changed_password() {
		mkCreateAccountPageCommon.enterPassword(testData.getUser().getPassword()+"234");
	}
	
	@Given("Login: I remote Log In")
	public void i_remote_log_in() {

		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		mainMenuStepDefMobile.i_click_on_Sign_In_link();
		i_enter_username();
		i_enter_password();
		i_click_Sign_In_button();
	}

	@Then("I verify the user is unable to login")
	public void user_unable_to_login() {
		mkMobileHamburgerMenu.validateErrorMessage();

	}
	
	@And("Login: I Verify Account locked after {int}th Unsuccessful Login Attemps") 
	  public void iVerifyAccountlockedforUnsuccessfulLoginAttemps(int numAttemps) {
	  Assert.assertTrue("Account locked message not matched",  mkCreateAccountPageEU.unsuccessfulLoginSteps(numAttemps));
	  }
}
