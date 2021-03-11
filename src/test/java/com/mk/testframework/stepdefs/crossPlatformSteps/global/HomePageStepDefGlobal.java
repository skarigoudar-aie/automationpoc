package com.mk.testframework.stepdefs.crossPlatformSteps.global;

import com.google.common.base.Splitter;
import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.dt.page.home.MkHomePage;
import com.mk.testframework.dt.popup.MkCheckoutSignInModal_EuGlobal;
import cucumber.api.java.en.And;
import java.util.List;
import org.junit.Assert;

/**
 * @author Nagarjuna Polisetty
 *
 */
public class HomePageStepDefGlobal {
    private MkHomePage mkHomePage;

    @Inject
    public HomePageStepDefGlobal(MkHomePage mkHomePage) {
    	this.mkHomePage = mkHomePage;
    }
    
    @And("COOKIE BANNER: I verify cookie banner")
    public void iVerifyCookieBanner() {
    	Assert.assertTrue("Cookie banner not displayed ", mkHomePage.isCookieBannerDispalyed());
    }
    
    @And("COOKIE BANNER: I verify Accept all button in cookie banner")
    public void iVerifyAcceptAllButtonInCookieBanner() {
    	Assert.assertTrue("Accept all button in Cookie banner not displayed ", mkHomePage.isCookieAcceptAllButtonDispalyed());
    }
    
    @And("COOKIE BANNER: I verify Manage cookie preferences button in cookie banner")
    public void iVerifyManageCookiePreferencesButtonInCookieBanner() {
    	Assert.assertTrue("Manage cookie preferences button in Cookie banner not displayed ", mkHomePage.isManageCookiePrefButtonDispalyed());
    }
    
    @And("COOKIE BANNER: I verify one trust policy text")
    public void iVerifyOneTrustPolicyText() {
    	Assert.assertTrue("One trust policy text not matched", mkHomePage.verifyOneTrustPolicyText());
    }
    
    @And("COOKIE BANNER: I accept cookies")
    public void iAcceptCookies() {
    	mkHomePage.iAcceptCookies();
    }
    
    @And("COOKIE BANNER: I verify saved cookies")
    public void iVerifySavedCookies() {
    	 Assert.assertTrue("Cookies not saved", mkHomePage.verifySavedCookies());
    }
    
    @And("COOKIE BANNER: I verify the oneTrustActiveGroups {string} in cookies")
    public void iVerifyTheOneTrustActiveGroupsInCookies(String oneTrustActiveGroup) {
    	List<String> groups = Splitter.on(">").trimResults().splitToList(oneTrustActiveGroup);
    	Assert.assertTrue("One trust active groups not stored in cookies", mkHomePage.verifyOneTrustActiveGroupsInCookies(groups));
    }
    
    @And("COOKIE BANNER: I Select Manage Preferences on the Cookie Banner")
    public void iSelectManagePreferencesOnTheCookieBanner() {
    	 Assert.assertTrue("Manage preferences not clicked", mkHomePage.clickOnManagePreferences());
    }
    
    @And("I Click on Accept All button in One Trust PC Panel")
    public void iClickOnAcceptAllButtonInOneTrustPCPanle() {
    	 mkHomePage.clickOnAcceptAllInOnetrustPCPanel();
    }
    
    @And("I Enable and Disable Target cookies")
    public void iEnableAndDisableTargetCookies() {
    	 Assert.assertTrue("Target cookies not enabled ", mkHomePage.enableTargetCookiesIfNot());
    	 Assert.assertFalse("Target cookies not disabled ", mkHomePage.disableTargetCookiesIfNot());
    }
    
    @And("I save the cookie preference changes")
    public void iSaveTheCookiePreferenceChanges() {
    	 mkHomePage.clickOnSavePreferences();
    }
    
    
    @And("COOKIE BANNER: I verify Cookie Banner is displayed in the respective Languages")
    public void iVerifyCookieBannerIsDisplayedInTheRespectiveLanguages() {
    	Assert.assertTrue("Accept all button text not matched", mkHomePage.verifyAcceptAllText());
    	Assert.assertTrue("Manage preferences text not matched", mkHomePage.verifyManagePreferencesText());
    	Assert.assertTrue("One trust policy text not matched", mkHomePage.verifyOneTrustPolicyText());
    }
    
}
