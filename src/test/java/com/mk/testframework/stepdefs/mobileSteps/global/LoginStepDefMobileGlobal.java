package com.mk.testframework.stepdefs.mobileSteps.global;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.mobile.MkMobileHamburgerMenu;
import com.mk.testframework.dt.page.account.MkCreateAccountPage_Common;
import com.mk.testframework.dt.page.account.MkCreateAccountPage_Global;
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
public class LoginStepDefMobileGlobal {
	private TestData testData;
	private MkCreateAccountPage_Common mkCreateAccountPageCommon;
	private MkCreateAccountPage_Global mkCreateAccountPageGlobal;
	private MkMobileHamburgerMenu mkMobileHamburgerMenu;
	private MkPageNavigator mkPageNavigator;
	private MainMenuStepDefMobile mainMenuStepDefMobile;
	private Context context;

	@Inject
	public LoginStepDefMobileGlobal(MainMenuStepDefMobile mainMenuStepDefMobile, MkCreateAccountPage_Common mkCreateAccountPageCommon, TestData testData,
									MkPageNavigator mkPageNavigator, MkMobileHamburgerMenu mkMobileHamburgerMenu, Context context, MkCreateAccountPage_Global mkCreateAccountPageGlobal) {
		this.testData = testData;
		this.mkCreateAccountPageCommon = mkCreateAccountPageCommon;
		this.mainMenuStepDefMobile = mainMenuStepDefMobile;
		this.mkMobileHamburgerMenu = mkMobileHamburgerMenu;
		this.mkCreateAccountPageGlobal = mkCreateAccountPageGlobal;
		this.mkPageNavigator = mkPageNavigator;
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
	
	@And("Login: I Verify Account locked after {int}th Unsuccessful Login Attemps") 
	public void iVerifyAccountlockedforUnsuccessfulLoginAttemps(int numAttemps) {
	  Assert.assertTrue("Account locked message not matched",  mkCreateAccountPageGlobal.unsuccessfulLoginSteps(numAttemps));
	  }
}
