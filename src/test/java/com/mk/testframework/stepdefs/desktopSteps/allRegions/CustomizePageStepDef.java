package com.mk.testframework.stepdefs.desktopSteps.allRegions;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.page.product.MkCustomizePage;
import com.mk.testframework.stepdefs.crossPlatformSteps.allRegions.CustomizePageStepDefCommon;
import cucumber.api.java.en.And;
import org.junit.Assert;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class CustomizePageStepDef {
    private MkCustomizePage mkCustomizePage;
    private Context context;
    private CustomizePageStepDefCommon customizePageStepDefCommon;

    @Inject
    public CustomizePageStepDef(MkCustomizePage mkCustomizePage, Context context,
                                CustomizePageStepDefCommon customizePageStepDefCommon) {
        this.mkCustomizePage = mkCustomizePage;
        this.context = context;
        this.customizePageStepDefCommon = customizePageStepDefCommon;
    }

    @And("I am on the customize page")
    public void i_am_on_the_customize_page() {
        if (mkCustomizePage.monogramTabDisplayed()) {
            Assert.assertFalse(
                    "Customize page is expected to contain color values to choose from, unable to add customized item to bag",
                    mkCustomizePage.verifyNoValuesLabel());
        }
    }

    @And("CUSTOMIZE: I click the monogram tab link")
    public void customizeIClickTheMonogramTabLink() {
        mkCustomizePage.clickMonogramTabLink();
    }

    @And("CUSTOMIZE: I type {string} into the monogram message field and press key tab")
    public void customizeITypeStringIntoTheMonogramMessageFieldAndPressKeyTab(String message) {
        context.writeOut("monogram message : " + message);
        mkCustomizePage.typeIntoCustomMessageField(message);
        mkCustomizePage.pressTab();
		Assert.assertTrue("Failed verifying monogram message", mkCustomizePage.verifyMonogramCharacters(message));
    }

    @And("CUSTOMIZE: I monogram {string} and click add to bag")
    public void customizeIMonogramAndClickAddToBag(String customValue) {
        customizeIClickTheMonogramTabLink();
        customizeITypeStringIntoTheMonogramMessageFieldAndPressKeyTab(customValue);
        customizePageStepDefCommon.customizeIClickAddToBag();
    }
    
    @And("ENGRAVE: I engrave {string} and click add to bag")
    public void iEngraveAndClickAddToBag(String customValue) {
    	 customizeIClickTheMonogramTabLink();
        customizeITypeStringIntoTheMonogramMessageFieldAndPressKeyTab(customValue);
        customizePageStepDefCommon.customizeIClickAddToBag();
    }
}
