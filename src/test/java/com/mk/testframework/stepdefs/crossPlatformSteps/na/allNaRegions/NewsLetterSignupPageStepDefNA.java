
package com.mk.testframework.stepdefs.crossPlatformSteps.na.allNaRegions;

import org.junit.Assert;
import com.google.inject.Inject;
import com.mk.testframework.dt.popup.MkYouAreOnTheListModal_US;
import cucumber.api.java.en.And;

@SuppressWarnings("deprecation")
public class NewsLetterSignupPageStepDefNA {

	private MkYouAreOnTheListModal_US mkYouAreOnTheListModalUS;

	@Inject
	public NewsLetterSignupPageStepDefNA(MkYouAreOnTheListModal_US mkYouAreOnTheListModalUS) {
		this.mkYouAreOnTheListModalUS = mkYouAreOnTheListModalUS;
	}


	@And("I verify You Are On The List Modal is dispalying")
	public void I_verify_You_Are_On_The_List_Modal_is_dispalying() {
		Assert.assertTrue(mkYouAreOnTheListModalUS.youAreOnTheSignUPList());
	}
}
