package com.mk.testframework.stepdefs.desktopSteps.allRegions;

import com.google.inject.Inject;
import com.mk.testframework.dt.page.home.PracticeVidyaHomePage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class PracticeVidyaStepDef {
	
	private PracticeVidyaHomePage mkhomepage;
	
	@Inject
	public PracticeVidyaStepDef(PracticeVidyaHomePage mkhomepage) {
		this.mkhomepage=mkhomepage;
		
	}
	@Given("Go to homepage1")
	public void Gotohomepage1() {
		mkhomepage.clickonMklogo();
	}
	
	@And("Click on Sign in1 link")
	public void clickonSignIn1() {
		mkhomepage.clickonSigninlink();
	}
	
	@And("Enter user name1 {string}")
	public void enterusername(String username) {
		mkhomepage.enterusername(username);
		
	}
	
	@And("I enter password1 {string}")
	public void enterpassword(String password) {
		mkhomepage.enterpassword(password);
		
	}
	
	@And("I click on Sing in1 button")
	public void clickonsignbtn() {
		mkhomepage.clickonsigninbtn();	
		
	}

}
