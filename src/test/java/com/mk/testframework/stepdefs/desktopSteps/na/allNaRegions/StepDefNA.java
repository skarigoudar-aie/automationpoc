package com.mk.testframework.stepdefs.desktopSteps.na.allNaRegions;

import com.google.inject.Inject;

import com.mk.testframework.dt.header.TestStepDef;
import com.mk.testframework.dt.util.PageUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertTrue;


@SuppressWarnings("deprecation")
public class StepDefNA {
	
	private TestStepDef teststepdef;
	private PageUtils pageUtils;
	
	@Inject
	public StepDefNA(TestStepDef teststepdef, PageUtils pageUtils ) {
		// TODO Auto-generated constructor stub
		this.teststepdef = teststepdef;
		this.pageUtils = pageUtils;
	}
	
	@Given("Go to MK Home page")
  	public void Go_to_Mk_Homepage(){
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		teststepdef.clickMKLogo();
		
  	}
      
    @And("Click on MK Signin button from header")
  	public void click_on_Signin_button(){
    	pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
    	teststepdef.signinlink();
  	} 
    
    @And("Enter username {string} in the Signin poup")
  	public void enter_username_in_Signin(String username) {
    	teststepdef.enterUsername(username);
  	} 
    
    @And("Enter Password {string} in the Signin poup")
  	public void enter_password_in_Signin(String password) {
    	teststepdef.enterPassword(password);
  	} 
    
    
    @Then("Click on Signin button to login on the MK Site")
  	public void click_on_Sigin_button(){
    	pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
    	teststepdef.clickOnSignin();
  	} 
    
    @And("I have signed in successfully")
    public void signed_in_succesfully() {
    	pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
    	assertTrue(true, "Hello");
    }

}