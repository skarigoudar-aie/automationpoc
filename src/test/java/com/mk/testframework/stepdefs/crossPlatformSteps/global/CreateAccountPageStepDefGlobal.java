
package com.mk.testframework.stepdefs.crossPlatformSteps.global;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_EuGlobal;
import com.mk.testframework.dt.popup.MkEditProfileModal_NA;
import cucumber.api.java.en.Then;


/**
 * @author Raja
 *
 */
@SuppressWarnings("deprecation")
public class CreateAccountPageStepDefGlobal {

	private MkMyAccountPage_EuGlobal mkMyAccountPageEuGlobal;
	private TestData testData;

	@Inject
	public CreateAccountPageStepDefGlobal(TestData testData, MkMyAccountPage_EuGlobal mkMyAccountPageEuGlobal, MkEditProfileModal_NA mkEditProfileModalNA) {
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
