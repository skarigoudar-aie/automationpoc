
package com.mk.testframework.stepdefs.desktopSteps.allRegions;

import org.junit.Assert;

import com.google.inject.Inject;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_Common;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_NA;

import cucumber.api.java.en.And;


/**
 * @author Nagarjuna Polisetty
 *
 */

@SuppressWarnings("deprecation")
public class MyAccountPageStepDef {

	private MkMyAccountPage_Common mkMyAccountPage_Common;
	private MkMyAccountPage_NA mkMyAccountPage_NA;

	@Inject
	public MyAccountPageStepDef(MkMyAccountPage_Common mkMyAccountPage_Common, MkMyAccountPage_NA mkMyAccountPage_NA) {
		this.mkMyAccountPage_Common = mkMyAccountPage_Common;
		this.mkMyAccountPage_NA = mkMyAccountPage_NA;
	}
	
	@And("Profile: I click on {string} link")
	public void iClickOnWishlistLink(String text) {
		mkMyAccountPage_Common.clickOnWishlistOrFavoritesLink(text);
	}
}

