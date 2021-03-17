package com.mk.testframework.stepdefs.desktopSteps.na.allNaRegions;

import org.junit.Assert;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.dt.popup.MkSignInModal_NA;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Rajesh {
	
	private TestData testData;
	private MkSignInModal_NA mkSignInModalNA;
	
	@Inject
	public Rajesh(MkSignInModal_NA mkSignInModalNA, TestData testData) 
	{
		this.mkSignInModalNA=mkSignInModalNA;
	}
	
	@Given("Go to Home page")
	public void goTohomepage() {
		
	}
	
	@Given("Click on Signin link")
	public void clickonSignInlink() {
		
	}
	
	@Given("I Enter username")
	public void i_enter_username() {
		mkSignInModalNA.enterEmailAddress(testData.getUser().getEmail());
	}

	@Given("I Enter password")
	public void i_enter_password() {
		mkSignInModalNA.enterPassword(testData.getUser().getPassword());
	}

	@When("I Click on sign in button")
	public void i_click_Sign_In_button() {
		mkSignInModalNA.clickSignIn();
	}
	
	@Then("I verify successfully sign in")
	public void i_should_be_successfully_logged_in() {
		
	}

}
