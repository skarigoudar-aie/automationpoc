package com.mk.testframework.stepdefs.mobileSteps.global;

import com.google.inject.Inject;
import com.mk.testframework.dt.mobile.MkMobileHamburgerMenu;
import cucumber.api.java.en.And;
import org.junit.Assert;

/**
 * @author Nagarjuna Polisetty
 *
 */
@SuppressWarnings("deprecation")
public class MainMenuStepDefMobileGlobal {

	private MkMobileHamburgerMenu mkMobileHamburgerMenu;

	@Inject
	public MainMenuStepDefMobileGlobal(MkMobileHamburgerMenu mkMobileHamburgerMenu) {
		this.mkMobileHamburgerMenu = mkMobileHamburgerMenu;
	}

	@And("HEADER: I verify selected country and currency")
	public void iVerifyCountrySelectorAndCurrency() {
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		Assert.assertTrue("Country selector not displayed", mkMobileHamburgerMenu.verifyCountrySelectedAndCurrency());
	}

}
