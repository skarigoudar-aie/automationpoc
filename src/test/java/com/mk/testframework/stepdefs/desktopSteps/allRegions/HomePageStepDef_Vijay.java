package com.mk.testframework.stepdefs.desktopSteps.allRegions;

import java.util.List;
import org.junit.Assert;
import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.page.home.MkHomePage;
import com.mk.testframework.dt.page.home.MkHomePage_Vijay;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class HomePageStepDef_Vijay {
	
	private MkHomePage_Vijay mkHomePage;
	
	@Inject
	public HomePageStepDef_Vijay(MkHomePage_Vijay mkHomePage) {
		this.mkHomePage = mkHomePage;
	}

    @Given("Go to homepage")
	public void goToHomepage() {
		mkHomePage.clickMKLogo();
	}
     
    
    @And("Click on Sign in link")
	public void clickOnSingInLink() {
    	mkHomePage.clickOnSignIn();
	}
    
    
    @And("Enter user name {string}")
	public void enterUserName(String username) {
    	mkHomePage.enterUserName(username);
	}
    
    @And("I enter password {string}")
   	public void iEnterPassword(String password) {
    	mkHomePage.enterPassword(password);
   	}
    
    @And("I click on Sign in button")
   	public void iClickOnSignInButton() {
    	mkHomePage.clickOnSignInButton();
   	}
    
    @And("I verify succesfully sign in")
   	public void iVerifySuccessfullySignIn() {
   		mkHomePage.verifyLogIn();
   	}
    
   
    
    
      
}

