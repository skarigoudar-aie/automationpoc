
package com.mk.testframework.stepdefs.mobileSteps.na.allNaRegions;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.dt.page.account.MkCreateAccountPage_NA;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;


/**
 * @author Raja
 *
 */
@SuppressWarnings("deprecation")
public class CreateAccountPageStepDefMobileNA {
	
	private MkCreateAccountPage_NA mkCreateAccountPageNA;
	private TestData testData;
	
	@Inject
	public CreateAccountPageStepDefMobileNA(TestData testData, MkCreateAccountPage_NA mkCreateAccountPageNA) {
		this.mkCreateAccountPageNA = mkCreateAccountPageNA;
		this.testData = testData;
	}

	
	
	@And("SignUp: I enter birth Month")
	public void i_enter_birthm_month() {
		mkCreateAccountPageNA.EnterBirthMonth(testData.getUser().getBirthmonth());
	}
	
	
	
	@And("SignUp: I enter birth Day")
	public void i_enter_birthm_day() {
		mkCreateAccountPageNA.EnterBirthDay(testData.getUser().getBirthday());
	}
	
	
	@And("SignUp: I choose gender")
	public void i_choose_genderm() {
		mkCreateAccountPageNA.ChooseGender(testData.getUser().getGender());
	}
		
	
	@And("SignUp: I opt out marketing comms")
	public void i_opt_out_marketingm_comms() {
		mkCreateAccountPageNA.optOutMktgComms();
	
	}
	
	@When("SignUp: I click create account button")
	public void i_click_create_accountm_button() {
		mkCreateAccountPageNA.clickCreateAccount();
	
	}
	

	
	
}
