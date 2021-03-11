package com.mk.testframework.stepdefs.crossPlatformSteps.na.allNaRegions;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.dt.popup.MkCheckoutSignInModal_NA;
import cucumber.api.java.en.And;
import org.junit.Assert;

/**
 * @author MLinderman
 *
 */
public class CheckoutLoginStepDefNA {

    private MkCheckoutSignInModal_NA mkCheckoutSignInModalNa;
    private TestData testData;

    @Inject
    public CheckoutLoginStepDefNA(MkCheckoutSignInModal_NA mkCheckoutSignInModalNa, TestData testData) {
        this.mkCheckoutSignInModalNa = mkCheckoutSignInModalNa;
        this.testData = testData;
    }

    @And("CHECKOUT LOGIN MODAL: I verify the checkout login modal is displayed")
    public void checkoutLOGINMODALIVerifyTheCheckoutLoginModalIsDisplayed() {
        Assert.assertTrue("Sign in modal not displayed",mkCheckoutSignInModalNa.verifySignInModal());
    }

    @And("CHECKOUT LOGIN MODAL: I enter email address")
    public void checkoutLOGINMODALIEnterEmailAddress() {
        mkCheckoutSignInModalNa.enterEmailAddress(testData.getUser().getEmail());
    }

    @And("CHECKOUT LOGIN MODAL: I enter password")
    public void checkoutLOGINMODALIEnterPassword() {
        mkCheckoutSignInModalNa.enterPassword(testData.getUser().getPassword());
    }

    @And("CHECKOUT LOGIN MODAL: I click Sign In button")
    public void checkoutLOGINMODALIClickSignInButton() {
        mkCheckoutSignInModalNa.clickSignIn();
    }
   
}
