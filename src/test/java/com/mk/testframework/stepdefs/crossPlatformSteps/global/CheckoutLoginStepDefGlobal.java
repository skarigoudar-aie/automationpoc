package com.mk.testframework.stepdefs.crossPlatformSteps.global;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.dt.popup.MkCheckoutSignInModal_EuGlobal;
import cucumber.api.java.en.And;
import org.junit.Assert;

/**
 * @author MLinderman
 *
 */
public class CheckoutLoginStepDefGlobal {

    private MkCheckoutSignInModal_EuGlobal mkCheckoutSignInModalEu;
    private TestData testData;

    @Inject
    public CheckoutLoginStepDefGlobal(MkCheckoutSignInModal_EuGlobal mkCheckoutSignInModalEu, TestData testData) {
        this.mkCheckoutSignInModalEu = mkCheckoutSignInModalEu;
        this.testData = testData;
    }

    @And("CHECKOUT LOGIN MODAL: I verify the checkout login modal is displayed")
    public void checkoutLOGINMODALIVerifyTheCheckoutLoginModalIsDisplayed() {
        Assert.assertTrue("Sign in modal not displayed",mkCheckoutSignInModalEu.verifySignInModal());
    }

    @And("CHECKOUT LOGIN MODAL: I enter email address")
    public void checkoutLOGINMODALIEnterEmailAddress() {
        mkCheckoutSignInModalEu.enterEmailAddress(testData.getUser().getEmail());
    }

    @And("CHECKOUT LOGIN MODAL: I enter password")
    public void checkoutLOGINMODALIEnterPassword() {
        mkCheckoutSignInModalEu.enterPassword(testData.getUser().getPassword());
    }

    @And("CHECKOUT LOGIN MODAL: I click Sign In button")
    public void checkoutLOGINMODALIClickSignInButton() {
        mkCheckoutSignInModalEu.clickSignIn();
    }
}
