package com.mk.testframework.stepdefs.mobileSteps.allRegions;

import com.google.inject.Inject;
import com.mk.testframework.dt.mobile.MkMobileMyAccountPage_Common;
import cucumber.api.java.en.And;

/**
 * @author Nagarjuna Polisetty
 *
 */

@SuppressWarnings("deprecation")
public class MyAccountPageStepDefMobile {


	private MkMobileMyAccountPage_Common mkMobileMyAccountPage_Common;

	@Inject
	public MyAccountPageStepDefMobile( MkMobileMyAccountPage_Common mkMobileMyAccountPage_Common) {
		this.mkMobileMyAccountPage_Common = mkMobileMyAccountPage_Common;
		
	}
	
	@And("Profile: I click on {string} link")
	public void iClickOnWishlistLink(String text) {
		mkMobileMyAccountPage_Common.clickOnWishlistOrFavoritesLink(text);
	}
}
	

