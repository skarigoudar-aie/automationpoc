package com.mk.testframework.stepdefs.crossPlatformSteps.allRegions;

import com.google.inject.Inject;
import com.mk.testframework.dt.page.product.MkCustomizePage;
import cucumber.api.java.en.And;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class CustomizePageStepDefCommon {
    private MkCustomizePage mkCustomizePage;

    @Inject
    public CustomizePageStepDefCommon(MkCustomizePage mkCustomizePage) {
        this.mkCustomizePage = mkCustomizePage;
    }

    @And("CUSTOMIZE: I click add to bag")
    public void customizeIClickAddToBag() {
        mkCustomizePage.clickAddToBagButton();
    }
}
