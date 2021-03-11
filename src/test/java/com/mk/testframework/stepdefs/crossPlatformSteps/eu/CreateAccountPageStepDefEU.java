
package com.mk.testframework.stepdefs.crossPlatformSteps.eu;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_EuGlobal;
import cucumber.api.java.en.Then;


/**
 * @author Raja
 *
 */
@SuppressWarnings("deprecation")
public class CreateAccountPageStepDefEU {

	private MkMyAccountPage_EuGlobal mkMyAccountPageEuGlobal;
	private TestData testData;


	@Inject
	public CreateAccountPageStepDefEU(TestData testData, MkMyAccountPage_EuGlobal mkMyAccountPageEuGlobal) {
		this.mkMyAccountPageEuGlobal = mkMyAccountPageEuGlobal;
		this.testData = testData;
	}

	@Then("Edit Profile: I modify lastname")
	public void i_modify_last_name() {
		testData.setRandomLastName();
		String lastName = testData.getRandomLastName();

		mkMyAccountPageEuGlobal.editLastName(lastName);
	}

	@Then("Edit Profile: I resetback lastname")
	public void i_change_resetback_name() {
		mkMyAccountPageEuGlobal.resetLastName(testData.getUser().getLastname());
	}
	

}
