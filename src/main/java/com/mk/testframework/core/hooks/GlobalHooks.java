package com.mk.testframework.core.hooks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.core.env.Environment.Region;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.header.MkMyAccountMenu;
import com.mk.testframework.dt.mobile.MkMobileHamburgerMenu;
import com.mk.testframework.dt.page.account.MkCreateAccountPage_Common;
import com.mk.testframework.dt.page.home.MkHomePage;
import com.mk.testframework.dt.page.searchlisting.MkProductListing;
import com.mk.testframework.dt.page.searchlisting.MkSearchBox;
import com.mk.testframework.dt.page.searchlisting.MkSortResultCountPanel;
import com.mk.testframework.dt.popup.MkSignInModal_NA;
import com.mk.testframework.dt.util.ExcelUtils;
import com.mk.testframework.dt.util.MkPageNavigator;
import com.mk.testframework.dt.util.ModalUtils;
import com.mk.testframework.dt.util.PageUtils;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

/**
 * @author VThipperudrappa
 *
 */
public class GlobalHooks {
	private final Logger log = LoggerFactory.getLogger(getClass());
	private Context context;
	private MkPageNavigator mkPageNavigator;
	private MkHamburgerMenu mkHamburgerMenu;
	private Environment env;
	private ModalUtils modalUtils;
	private MkHomePage mkHomePage;
	private MkSearchBox mkSearchBox;
	private MkProductListing mkProductListing;
	private MkSortResultCountPanel mkSortResultCountPanel;
	private PageUtils pageUtils;
	private ExcelUtils excelUtils;
	private MkMobileHamburgerMenu mkMobileHamburgerMenu;
	private MkCreateAccountPage_Common mkCreateAccountPageCommon;
	private MkSignInModal_NA mkSignInModalNA;
	private MkMyAccountMenu mkMyAccountMenu;

	@Inject
	public GlobalHooks(final Context context, MkPageNavigator mkPageNavigator, MkHamburgerMenu mkHamburgerMenu,
			MkSearchBox mkSearchBox, MkProductListing mkProductListing, ModalUtils modalUtils, Environment env,
			MkSortResultCountPanel mkSortResultCountPanel, MkHomePage mkHomePage, PageUtils pageUtils,
			ExcelUtils excelUtils, MkMobileHamburgerMenu mkMobileHamburgerMenu,
			MkCreateAccountPage_Common mkCreateAccountPageCommon, MkSignInModal_NA mkSignInModalNA,
			MkMyAccountMenu mkMyAccountMenu) {
		this.context = context;
		this.mkPageNavigator = mkPageNavigator;
		this.env = env;
		this.mkHamburgerMenu = mkHamburgerMenu;
		this.modalUtils = modalUtils;
		this.mkHomePage = mkHomePage;
		this.mkSearchBox = mkSearchBox;
		this.mkProductListing = mkProductListing;
		this.mkSortResultCountPanel = mkSortResultCountPanel;
		this.pageUtils = pageUtils;
		this.excelUtils = excelUtils;
		this.mkMobileHamburgerMenu = mkMobileHamburgerMenu;
		this.mkCreateAccountPageCommon = mkCreateAccountPageCommon;
		this.mkSignInModalNA = mkSignInModalNA;
		this.mkMyAccountMenu = mkMyAccountMenu;
	}

	@After(order = 1)
	public void afterAll(final Scenario scenario) {
		log.info("-----TEST END: {}", scenario.getName());
		if (scenario.isFailed()) {
			context.embedScreenshots();
			pageUtils.sleepSeconds(5, "Waiting for adding screen shot");
			mkPageNavigator.goToHomePage();
		}
	}

	@Before(order = 1)
	public void beforeAll(final Scenario scenario) {
		context.initilizeLogFile(scenario);
		log.info("-----TEST BEGIN: {}", scenario.getName());
	}

	@Before("@guestOrderPlacement")
	public void beforeOrderPlacementScenarios() {
		if (!context.getOrderZipStatus()) {
			log.info("--ziping old order files to archaive folders for reference ---");
			excelUtils.setEnvExcelFile();
			excelUtils.zipOrderFile();
		} else {
			log.info("--old order files are zipped to archaive folders already for reference ---");
		}
	}

	@After("@guestOrderPlacement, @guestCheckout")
	public void afterOrderPlacement(final Scenario scenario) {
		if (scenario.isFailed()) {
			context.embedScreenshots();
			log.info("Guest Order placement related scenario failed deleting cookies");
			mkPageNavigator.goToHomePage();
			iLoginToTheApplication();
		}
	}

	@After("@guestCheckout")
	public void afterOrderPlacementPass(final Scenario scenario) {
		if (!scenario.isFailed()) {
			log.info("Guest Order placement related scenario Passed deleting cookies");
			mkPageNavigator.goToHomePage();
			iLoginToTheApplication();
		}
	}

	@Before
	public void beforeScenarios() {
		context.writeOut("Pop up dismissed status: " + context.getpopUpDismissedStatus());
		if (!context.getpopUpDismissedStatus()) {
			log.info("Popup not dismissed");
			mkPageNavigator.goToHomePage();
			pageUtils.sleepSeconds(10, null);
			if (env.getCountryRegion().equals(Region.NA)) {
				mkHamburgerMenu.clickMkLogo();
				if (env.getCountry().equalsIgnoreCase("US")) {
					modalUtils.closeKorsVipModalIfPresented();
				} else if (env.getCountry().equalsIgnoreCase("CA")) {
					modalUtils.closeNeverMissABeatPopupIfPresented();
				}
			} else {
				mkHomePage.acceptCookieBannerIfPresented();
				modalUtils.acceptCountryChangePopupIfPresented();
				mkHamburgerMenu.clickSearchLink();
				mkSearchBox.waitForSearchBox();
				mkSearchBox.typeIntoSearchBox("handbags");
				mkSearchBox.pressEnter();
				if (mkPageNavigator.onSearchPage()) {
					if (mkSortResultCountPanel.getProductCount() > 0) {
						mkProductListing.clickProductAtPosition(1);
					}
					modalUtils.closeStayInTouchModalIfPresented();
					mkPageNavigator.goToHomePage();
				}
			}
		} else {
			log.info("Popup already dismissed");
		}

	}

	public void iLoginToTheApplication() {
		String email="mktester.int.us@gmail.com";
		String password="Tester1*";
		if (env.isSysPropsSpecified(Environment.SysProps.MOBILE)) {
			if (env.getCountryRegion().toString().equals("NA")) {
				try {
					mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
					mkMobileHamburgerMenu.clickSignInLink();
					mkSignInModalNA.enterEmailAddress(email);
					mkSignInModalNA.enterPassword(password);
					mkSignInModalNA.clickSignIn();
				} catch (Exception e) {
					return;
				}
			} else {
				try {
					mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
					mkMobileHamburgerMenu.clickSignInLink();
					mkCreateAccountPageCommon.enterEmailAddress(email);
					mkCreateAccountPageCommon.enterPassword(password);
					mkCreateAccountPageCommon.clickSignIn();
				} catch (Exception e) {
					mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
					mkMobileHamburgerMenu.clickSignInLink();
					mkCreateAccountPageCommon.enterEmailAddress(email);
					mkCreateAccountPageCommon.enterPassword(password);
					mkCreateAccountPageCommon.clickSignIn();
				}

			}
		} else {
			if (env.getCountryRegion().toString().equals("NA")) {
				try {
					mkHamburgerMenu.clickSignInLink();
					mkSignInModalNA.enterEmailAddress(email);
					mkSignInModalNA.enterPassword(password);
					mkSignInModalNA.clickSignIn();
					modalUtils.closeZipCodePopupIfPresented();
				} catch (Exception e) {
					mkHamburgerMenu.clickSignInLink();
					mkSignInModalNA.enterEmailAddress(email);
					mkSignInModalNA.enterPassword(password);
					mkSignInModalNA.clickSignIn();
					modalUtils.closeZipCodePopupIfPresented();
				}
			} else {
				try {
					mkHamburgerMenu.clickSignInLink();
					mkCreateAccountPageCommon.enterEmailAddress(email);
					mkCreateAccountPageCommon.enterPassword(password);
					mkCreateAccountPageCommon.clickSignIn();
				} catch (Exception e) {
					mkHamburgerMenu.clickSignInLink();
					mkCreateAccountPageCommon.enterEmailAddress(email);
					mkCreateAccountPageCommon.enterPassword(password);
					mkCreateAccountPageCommon.clickSignIn();
				}
			}
		}
	}

	public void iLogOutFromTheApplication() {
		if (env.isSysPropsSpecified(Environment.SysProps.MOBILE)) {
			try {
				mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
				mkMobileHamburgerMenu.clickSignOutLink();
			} catch (Exception e) {
				mkPageNavigator.goToHomePage();
				log.debug("Trying log out second time");
				mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
				pageUtils.refresh();
				pageUtils.waitForPageToLoad();
				mkMobileHamburgerMenu.clickSignOutLink();
			}
		} else {
			try {
				mkMyAccountMenu.flyOutMenu().clickSignOut();
			} catch (Exception e) {
				mkPageNavigator.goToHomePage();
				log.debug("Trying log out second time");
				mkMyAccountMenu.flyOutMenu().clickSignOut();
			}
		}

	}
}
