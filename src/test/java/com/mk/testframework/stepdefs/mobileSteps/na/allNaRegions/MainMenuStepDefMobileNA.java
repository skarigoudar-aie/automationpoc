package com.mk.testframework.stepdefs.mobileSteps.na.allNaRegions;

import com.mk.testframework.dt.util.ExcelUtils;
import com.mk.testframework.dt.util.MkPageNavigator;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Splitter;
import com.google.inject.Inject;
import com.mk.testframework.core.exceptions.TestEnvironmentException;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.mobile.MkMobileHamburgerMenu;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

/**
 * @author VThipperudrappa
 *
 */
@SuppressWarnings("deprecation")
public class MainMenuStepDefMobileNA {
	private final Logger log = LoggerFactory.getLogger(getClass());
	private ExcelUtils excelUtils;
	private MkMobileHamburgerMenu mkMobileHamburgerMenu;
	private MkPageNavigator mkPageNavigator;
	private MkHamburgerMenu mkHamburgerMenu;

	@Inject
	public MainMenuStepDefMobileNA(MkPageNavigator mkPageNavigator, MkMobileHamburgerMenu mkMobileHamburgerMenu, ExcelUtils excelUtils, MkHamburgerMenu mkHamburgerMenu) {
		this.mkMobileHamburgerMenu= mkMobileHamburgerMenu;
		this.mkPageNavigator = mkPageNavigator;
		this.excelUtils = excelUtils;
		this.mkHamburgerMenu = mkHamburgerMenu;
	}


	@When("MENU: I tap Sign Out link")
	public void i_tap_Sign_OutM_link() {
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
		Assert.assertTrue("Country selector not displayed", mkMobileHamburgerMenu.verifyCountryNameSelected());
	}
	
	@When("MENU: I verify title tag and navigation of each category")
	public void i_click() throws IOException {
		mkHamburgerMenu.verifyEachCategoryMobile();
	}
}

