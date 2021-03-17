package com.mk.testframework.stepdefs.crossPlatformSteps.allRegions;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.page.home.MkHomePage;
import com.mk.testframework.dt.page.home.MkHomePage_Aswinipractice;

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
public class HomePageStepDefCommon_Aswini {
	
	private MkHomePage_Aswinipractice mkHomePage;


	@Inject
	public HomePageStepDefCommon_Aswini(MkHomePage_Aswinipractice mkHomePage) {
	
		this.mkHomePage = mkHomePage;
		
	}	
	
	@Given("Go to Homepage")
	public void goToHomepage() {
		mkHomePage.clickLogo();
}
	
	@And("Click on Sign in link")
	public void signInLink() {
		mkHomePage.clicksigninlink();
	}

	@And("Enter user name {string}")
	public void enterUserName(String Uname) {
	mkHomePage.enterUserName(Uname);
}

	@And("I enter password {string}")
	public void enterPassword(String pwd) {
	mkHomePage.enterPssword(pwd);
}
	@And("I click on Sign in button")
	public void signInButton() {
	mkHomePage.clicksigninbutton();
	
}
}
