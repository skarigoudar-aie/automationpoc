
package com.mk.testframework.stepdefs.mobileSteps.eu;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.mobile.MkMobileMyAccountPage_EuGlobal;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_Common;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_EuGlobal;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_NA;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.core.exceptions.TestEnvironmentException;
import com.mk.testframework.stepdefs.crossPlatformSteps.allRegions.MyAccountPageStepDef;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;


/**
 * @author Nagarjuna Polisetty
 *
 */
@SuppressWarnings("deprecation")
public class MyAccountPageStepDefMobileEU {

	private MkMyAccountPage_EuGlobal mkMyAccountPage_EuGlobal;
	private MkMyAccountPage_Common mkMyAccountPageCommon;
	private MkMobileMyAccountPage_EuGlobal mkMobileMyAccountPage_EuGlobal;
	
	@Inject
	public MyAccountPageStepDefMobileEU(MkMyAccountPage_EuGlobal mkMyAccountPage_EuGlobal, MkMyAccountPage_Common mkMyAccountPageCommon, MkMobileMyAccountPage_EuGlobal mkMobileMyAccountPage_EuGlobal) {
		this.mkMyAccountPage_EuGlobal = mkMyAccountPage_EuGlobal;
		this.mkMyAccountPageCommon = mkMyAccountPageCommon;
		this.mkMobileMyAccountPage_EuGlobal = mkMobileMyAccountPage_EuGlobal;
	}
	
	@And("Wishlist: I edit product color or size and validate changes in favorites page")
	public void iEditProductColorOrSizeAndValdiateChangesInFavoritesPage() {
		boolean editWishlistStatus = false;
		String colorBeforeEdit = mkMyAccountPage_EuGlobal.getColorFromWishlistProduct(1);
		String sizeBeforeEdit = mkMyAccountPage_EuGlobal.getSizeFromWishlistProduct(1);
		mkMobileMyAccountPage_EuGlobal.clickOnEditLinkInFavorites();
		String colorAfterEdit = mkMyAccountPageCommon.changeColorInEditWishlistOrFavPopUp();
		String sizeAfterEdit = mkMyAccountPage_EuGlobal.changeSizeInEditFavPopUp();
		if(colorAfterEdit!=null && colorAfterEdit!=colorBeforeEdit)
			editWishlistStatus = true;
		else if(sizeAfterEdit!=null && sizeAfterEdit!= sizeBeforeEdit)
			editWishlistStatus = true;
		mkMyAccountPageCommon.clickOnSaveChanges();
		Assert.assertTrue("Edit wishlist failed", editWishlistStatus);
	}
	
}
	

