package com.mk.testframework.stepdefs.desktopSteps.na.allNaRegions;


import com.mk.testframework.dt.util.MkPageNavigator;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.inject.Inject;
import com.mk.testframework.core.exceptions.TestEnvironmentException;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.mobile.MkMobileHamburgerMenu;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * @author VThipperudrappa
 *
 */
@SuppressWarnings("deprecation")
public class MainMenuStepDefNA {
	private final Logger log = LoggerFactory.getLogger(getClass());

	private MkHamburgerMenu mkHamburgerMenu;
	private MkMobileHamburgerMenu mkMobileHamburgerMenu;
	private MkPageNavigator mkPageNavigator;

	@Inject
	public MainMenuStepDefNA(MkHamburgerMenu mkHamburgerMenu, MkPageNavigator mkPageNavigator, MkMobileHamburgerMenu mkMobileHamburgerMenu) {
		this.mkHamburgerMenu = mkHamburgerMenu;
		this.mkMobileHamburgerMenu= mkMobileHamburgerMenu;
		this.mkPageNavigator = mkPageNavigator;
	}


	@Given("MENU: I click on Sign Up link")
	public void i_click_on_Sign_Up_link() {
		mkHamburgerMenu.clickSignUpLink();
	}

	@When("MENU: I tap Sign Out link")
	public void i_tap_Sign_OutD_link() {
		try {
			mkMobileHamburgerMenu.clickSignOutLink();
		} catch (TestEnvironmentException e) {
			mkPageNavigator.goToHomePage();
			log.debug("Trying log out second time");
			mkMobileHamburgerMenu.clickSignOutLink();
		}
	}

	@And("HEADER: I verify selected country and currency")
	public void iVerifyCountrySelectorAndCurrency() {
		Assert.assertTrue("Country selector not displayed", mkHamburgerMenu.verifyCountryNameSelected());
	}
}
