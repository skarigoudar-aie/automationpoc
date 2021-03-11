package com.mk.testframework.stepdefs.mobileSteps.allRegions;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.mobile.MkMobileCustomizePage;
import com.mk.testframework.dt.page.product.MkCustomizePage;
import com.mk.testframework.stepdefs.crossPlatformSteps.allRegions.CustomizePageStepDefCommon;
import cucumber.api.java.en.And;
import org.junit.Assert;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class CustomizePageStepDefMobile {
    private MkCustomizePage mkCustomizePage;
    private Context context;
    private MkMobileCustomizePage mkMobileCustomizePage;
    private CustomizePageStepDefCommon customizePageStepDefCommon;

    @Inject
    public CustomizePageStepDefMobile(MkCustomizePage mkCustomizePage, Context context,
                                      CustomizePageStepDefCommon customizePageStepDefCommon,
                                      MkMobileCustomizePage mkMobileCustomizePage) {
        this.mkCustomizePage = mkCustomizePage;
        this.context = context;
        this.customizePageStepDefCommon = customizePageStepDefCommon;
        this.mkMobileCustomizePage = mkMobileCustomizePage;
    }

    @And("I am on the customize page")
    public void i_am_on_the_customize_page() {
        if(mkMobileCustomizePage.verifyNavigationButtonPrev()||mkMobileCustomizePage.verifyNavigationButtonNext()){
            customizeIClickTheMonogramTabLink();
            Assert.assertFalse(
                    "Customize page is expected to contain color values to choose from, unable to add customized item to bag",
                    mkCustomizePage.verifyNoValuesLabel());
        }
    }

    @And("CUSTOMIZE: I click the monogram tab link")
    public void customizeIClickTheMonogramTabLink() {
        if(mkMobileCustomizePage.verifyColorwayTab()){
            mkMobileCustomizePage.clickNavigationNext();
        }
    }

    @And("Engrave: I click the monogram tab link")
    public void engraveIClickTheMonogramTabLink() {
        if(mkMobileCustomizePage.verifyColorSwatchesTab()){
            mkMobileCustomizePage.clickNavigationNext();
        }
    }
    
    @And("CUSTOMIZE: I type {string} into the monogram message field and press key tab")
    public void customizeITypeStringIntoTheMonogramMessageFieldAndPressKeyTab(String message) {
        context.writeOut("monogram message : " + message);
        mkMobileCustomizePage.typeIntoCustomMessageField(message);
        mkMobileCustomizePage.pressTab();
        Assert.assertTrue("Failed verifying monogram message", mkMobileCustomizePage.verifyMonogramCharacters(message));
    }

    @And("CUSTOMIZE: I monogram {string} and click add to bag")
    public void customizeIMonogramAndClickAddToBag(String customValue) {
        customizeIClickTheMonogramTabLink();
        customizeITypeStringIntoTheMonogramMessageFieldAndPressKeyTab(customValue);
        customizePageStepDefCommon.customizeIClickAddToBag();
    }
    
    @And("ENGRAVE: I engrave {string} and click add to bag")
    public void iEngraveAndClickAddToBag(String customValue) {
    	engraveIClickTheMonogramTabLink();
        customizeITypeStringIntoTheMonogramMessageFieldAndPressKeyTab(customValue);
        customizePageStepDefCommon.customizeIClickAddToBag();
    }

}
