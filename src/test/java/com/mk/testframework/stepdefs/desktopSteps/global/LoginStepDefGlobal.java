package com.mk.testframework.stepdefs.desktopSteps.global;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.page.account.MkCreateAccountPage_Common;
import com.mk.testframework.dt.page.account.MkCreateAccountPage_Global;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_EuGlobal;
import com.mk.testframework.dt.util.MkPageNavigator;
import com.mk.testframework.stepdefs.desktopSteps.allRegions.MainMenuStepDef;
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
public class LoginStepDefGlobal {

	private TestData testData;
	private MkCreateAccountPage_Common mkCreateAccountPageCommon;
	private MkCreateAccountPage_Global mkCreateAccountPageGlobal;
	private MainMenuStepDef mainMenuStepDef;
	private MkHamburgerMenu mkHamburgerMenu;
	private MkPageNavigator mkPageNavigator;
	private Context context;
	private MkMyAccountPage_EuGlobal mkMyAccountPage_EuGlobal;

	@Inject
	public LoginStepDefGlobal(MainMenuStepDef mainMenuStepDef, MkCreateAccountPage_Common mkCreateAccountPageCommon, TestData testData,
							  MkHamburgerMenu mkHamburgerMenu, MkPageNavigator mkPageNavigator,
							  MkCreateAccountPage_Global mkCreateAccountPageGlobal, Context context, MkMyAccountPage_EuGlobal mkMyAccountPage_EuGlobal) {
		this.testData = testData;
		this.mkCreateAccountPageCommon = mkCreateAccountPageCommon;
		this.mainMenuStepDef = mainMenuStepDef;
		this.mkHamburgerMenu = mkHamburgerMenu;
		this.mkPageNavigator = mkPageNavigator;
		this.mkCreateAccountPageGlobal = mkCreateAccountPageGlobal;
		this.context = context;
		this.mkMyAccountPage_EuGlobal = mkMyAccountPage_EuGlobal;
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
	
	
	@And("Login: I enter new user")
	public void i_enter_new_user() {
		mkCreateAccountPageCommon.enterEmailAddress(testData.getRandomEmail());
			
	}
	
	

	@Given("Login: I Log In")
	public void i_log_in() {
		mainMenuStepDef.i_click_on_Sign_In_link();
		i_enter_username();
		i_enter_password();
		i_click_Sign_In_button();
		i_should_be_successfully_logged_in();
	}

	@Given("Login: I Log Out")
	public void i_log_out() {
		mainMenuStepDef.i_click_Sign_Out_link();
		i_should_be_successfully_logged_out();
	}

	@Then("I should be successfully logged in")
	public void i_should_be_successfully_logged_in() {
		mkPageNavigator.goToHomePage();
		Assert.assertTrue("Expecting accounts link to ensure user is logged in",
				mkHamburgerMenu.myAccountLinkIsPresent());
	}

	@Then("I should be successfully logged out")
	public void i_should_be_successfully_logged_out() {
		mkPageNavigator.goToHomePage();
		Assert.assertTrue("Expecting sign in link to ensure user is logged out",
				mkHamburgerMenu.signInLinkIsPresent());
	}
	
	  @And("Login: I enter new created email address") 
	  public void i_enter_new_created_user() {
	  mkCreateAccountPageGlobal.enterCreatedEmailAddress(context.getSavedData("email"));
	  
	  }
	 
	
	@And ("Login: I enter changed password")
	public void i_enter_changed_password() {
		mkCreateAccountPageGlobal.enterPassword(testData.getUser().getPassword()+"234");
	}
	
	@Given("Login: I Log In from flyout")
	public void i_log_in_from_flyout() {
		mainMenuStepDef.i_select_Sign_In_link();
		i_enter_flyout_username();
		i_enter_flyout_password();
		i_click_flyout_Sign_In_button();
		Assert.assertTrue("Expecting accounts link to ensure user is logged in",
				mkHamburgerMenu.myAccountLinkIsPresent());
	}
			
	@Given("Login: I enter flyout email address")
	public void i_enter_flyout_username() {
		mkMyAccountPage_EuGlobal.enterFlyoutEmailAddress(testData.getUser().getEmail());
	}
			
	@Given("Login: I enter flyout password")
	public void i_enter_flyout_password() {
		mkMyAccountPage_EuGlobal.enterFlyoutPassword(testData.getUser().getPassword());
	}

	@When("Login: I click Flyout Sign In button")
	public void i_click_flyout_Sign_In_button() {
		mkMyAccountPage_EuGlobal.clickSignIn();
	}
	@And("Login: I Verify Account locked after {int}th Unsuccessful Login Attemps") 
	public void iVerifyAccountlockedforUnsuccessfulLoginAttemps(int numAttemps) {
	  Assert.assertTrue("Account locked message not matched",  mkCreateAccountPageGlobal.unsuccessfulLoginSteps(numAttemps));
	  }
}

