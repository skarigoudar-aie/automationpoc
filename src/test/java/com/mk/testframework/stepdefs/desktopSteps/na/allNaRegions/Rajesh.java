package com.mk.testframework.stepdefs.desktopSteps.na.allNaRegions;


import com.google.inject.Inject;
import com.mk.testframework.dt.page.home.TestSignIn;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class Rajesh {
	
	
	private TestSignIn mkSignInModalNA;
	
	@Inject
	public Rajesh(TestSignIn mkSignInModalNA) 
	{
		this.mkSignInModalNA=mkSignInModalNA;
	}
	
	@Given("Go to Home page")
	public void goTohomepage() {
		mkSignInModalNA.GotoHomePage();
		
	}
	
	@And("Click on Signin link")
	public void clickonSignInlink() {
		mkSignInModalNA.clickOnSigninLink();
	}
	
	@And("I Enter username {string}")
	public void i_enter_username(String usename) {
		mkSignInModalNA.enterUserName(usename);
		
	}

	@And("I Enter password {string}")
	public void i_enter_password(String password) {
		mkSignInModalNA.enterPwd(password);
		
	}

	@And("I Click on sign in button")
	public void i_click_Sign_In_button() {
		mkSignInModalNA.signButton();
	}
	
	

}
