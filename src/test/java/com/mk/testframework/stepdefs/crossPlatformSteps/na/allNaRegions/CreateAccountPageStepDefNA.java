
package com.mk.testframework.stepdefs.crossPlatformSteps.na.allNaRegions;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_NA;
import cucumber.api.java.en.Then;


/**
 * @author Raja
 *
 */
@SuppressWarnings("deprecation")
public class CreateAccountPageStepDefNA {

	private MkMyAccountPage_NA mkMyAccountPageNA;
	private TestData testData;


	@Inject
	public CreateAccountPageStepDefNA(TestData testData, MkMyAccountPage_NA mkMyAccountPageNA) {
		this.mkMyAccountPageNA = mkMyAccountPageNA;
		this.testData = testData;
	}

	@Then("Edit Profile: I modify lastname")
	public void i_modify_last_name() {
		testData.setRandomLastName();
		String lastName = testData.getRandomLastName();

		mkMyAccountPageNA.editLastName(lastName);
	}

	@Then("Edit Profile: I resetback lastname")
	public void i_change_resetback_name() {
		mkMyAccountPageNA.resetLastName(testData.getUser().getLastname());
	}

}
