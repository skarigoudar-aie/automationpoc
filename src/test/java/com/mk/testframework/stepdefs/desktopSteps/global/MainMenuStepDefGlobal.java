package com.mk.testframework.stepdefs.desktopSteps.global;

import com.google.inject.Inject;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import cucumber.api.java.en.And;
import org.junit.Assert;

/**
 * @author Nagarjuna Polisetty
 *
 */
@SuppressWarnings("deprecation")
public class MainMenuStepDefGlobal {

	private MkHamburgerMenu mkHamburgerMenu;

	@Inject
	public MainMenuStepDefGlobal(MkHamburgerMenu mkHamburgerMenu) {
		this.mkHamburgerMenu = mkHamburgerMenu;
	}

	@And("HEADER: I verify selected country and currency")
	public void iVerifyCountrySelectorAndCurrency() {
		Assert.assertTrue("Country selector not displayed", mkHamburgerMenu.verifyCountrySelectedAndCurrency());
	}

}
