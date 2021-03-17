package com.mk.testframework.stepdefs.desktopSteps.allRegions;

import com.google.inject.Inject;
import com.mk.testframework.dt.page.home.PracticeTNHomePage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class PracticeTNStepDef {

	private PracticeTNHomePage practicehomepage;
	
	@Inject
	public PracticeTNStepDef(PracticeTNHomePage practicehomepage)
		{
		this.practicehomepage=practicehomepage;
		
	}

		@Given("Go to Mk Home page1")
		  	public void GotoMkHomepage1() {
			 practicehomepage.clickLogo();
		  	}
		      
		    @And("click on Signin link1")
		  	public void clickSigninlink1() {
		    	practicehomepage.signinlink();
		  	} 
		    
		    @And("Enter usernme {string}")
		  	public void enterUsrname1(String uname) {
		    	practicehomepage.enterUserName(uname);
		  	} 
		    
		    @And("Enter pssword {string}")
		  	public void enterPwd1(String pwd) {
		    	practicehomepage.enterPword(pwd);
		  	} 
		    
		    
		    @When("click on Signin btn")
		  	public void clickSigninButton1() {
		    	practicehomepage.clickSigninBtn();
		  	} 
}
