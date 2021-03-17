package com.mk.testframework.stepdefs.desktopSteps.na.allNaRegions;

import javax.sql.rowset.Joinable;

import org.junit.Assert;

import com.google.inject.Inject;
import com.mk.testframework.dt.page.myaccount.MyAccount_Asif;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

@SuppressWarnings("deprecation")

public class MyAccountStepDef_Asif {
	
	private MyAccount_Asif myAccount_Asif;
	
	@Inject
	public MyAccountStepDef_Asif(MyAccount_Asif myAccount_Asif) {
		this.myAccount_Asif = myAccount_Asif;
	}
	
	@Given("I click on Join link")
	public void i_click_on_Join_link() {
		myAccount_Asif.clickJoin();
		
	}

	@And("I enter First Name {string}")
	public void i_enter_First_Name(String fname) {
		myAccount_Asif.enterFirstName(fname);
	}
	
	@And("I enter Last Name {string}")
	public void i_enter_Last_Name(String lname) {
		myAccount_Asif.enterLastName(lname);
	}
	
	@And("I enter Email ID {string}")
	public void i_enter_Email_ID(String email) {
		myAccount_Asif.enterEmailAddress(email);
	}
	
	@And("I enter Password {string}")
	public void i_enter_Password(String pwd) {
		myAccount_Asif.enterPassword(pwd);
	}
	
	@And("I enter Confirm Password {string}")
	public void i_enter_Confirm_Password(String cpwd) {
		myAccount_Asif.enterConfirmPassword(cpwd);
	}
	
	@And("I enter Zipcode {string}")
	public void i_enter_Zipcode(String zipcode) {
		myAccount_Asif.enterPostalCode(zipcode);
	}
	
	@And("I click on Create account button")
	public void i_click_on_Create_account_Button() {
		myAccount_Asif.clickOnCreateAccountSubmitButton();
	}
	
	
	  @Then("I validate Successfully Created Account") 
	  public void i_validate_Successfully_Created_Account() throws InterruptedException { 
		Assert.assertTrue("Account not created", myAccount_Asif.displayMyAccountLink());  
		Thread.sleep(3000);
		
		  
	 //Assert.assertTrue("Account is created and Profile link to ensure user is logged in",
	 // myAccount_Asif.displayMyAccountLink()); 
	  
	  }
	 
	
	
	
}
