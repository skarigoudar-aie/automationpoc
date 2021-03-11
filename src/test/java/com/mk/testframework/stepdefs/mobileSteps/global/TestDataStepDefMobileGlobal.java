package com.mk.testframework.stepdefs.mobileSteps.global;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.mobile.MkMobileHamburgerMenu;
import com.mk.testframework.stepdefs.crossPlatformSteps.allRegions.PageNavigationStepdef;
import cucumber.api.java.en.Given;

/**
 * @author VThipperudrappa
 *
 */
@SuppressWarnings("deprecation")
public class TestDataStepDefMobileGlobal {

	private TestData testData;
	private Context context;
	private PageNavigationStepdef pageNavigationStepdef;
	private LoginStepDefMobileGlobal loginStepDefMobileEU;
	private MkHamburgerMenu mkHamburgerMenu;
	private MkMobileHamburgerMenu mkMobileHamburgerMenu;

	@Inject
	public TestDataStepDefMobileGlobal(MkHamburgerMenu mkHamburgerMenu, TestData testData, Context context,
									   PageNavigationStepdef pageNavigationStepdef, LoginStepDefMobileGlobal loginStepDefMobileEU,
									   MkMobileHamburgerMenu mkMobileHamburgerMenu) {
		this.testData = testData;
		this.context = context;
		this.pageNavigationStepdef = pageNavigationStepdef;
		this.loginStepDefMobileEU = loginStepDefMobileEU;
		this.mkHamburgerMenu = mkHamburgerMenu;
		this.mkMobileHamburgerMenu = mkMobileHamburgerMenu;
	}

	@Given("I am a mk customer")
	public void i_am_a_mk_customer() {
		testData.addUser("registered");
		context.writeOut(testData.getUserInfo());
		pageNavigationStepdef.i_navigate_to_MK_HomePage();
		try {
			mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
			mkHamburgerMenu.isSignInLinkDisplayed();
		} catch (Exception e) {
			if (alreadyLoggedin()) {
				pageNavigationStepdef.i_navigate_to_MK_HomePage();
				loginStepDefMobileEU.i_log_out();
			}
		}
	}

	@Given("I am a logged-in mk customer")
	public void iAmALoggedInMkCustomer() {
		testData.addUser("registered");
		context.writeOut(testData.getUserInfo());
		pageNavigationStepdef.i_navigate_to_MK_HomePage();

		try {	
			if (!alreadyLoggedin()) {
				pageNavigationStepdef.i_navigate_to_MK_HomePage();
				loginStepDefMobileEU.i_log_in();
			}

		} catch (Exception e) {
			mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
			mkHamburgerMenu.isSignInLinkDisplayed();
			pageNavigationStepdef.i_navigate_to_MK_HomePage();
			loginStepDefMobileEU.i_log_in();
		}
	}

	private boolean alreadyLoggedin() {
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		return mkHamburgerMenu.myAccountLinkIsPresent();
	}
	
	@Given("Login: I am mk logged in customer verifying {string}")
	public void i_am_a_mk_customer(String scenario) {
		testData.addUser(scenario+"_mobile");
		context.writeOut(testData.getUserInfo());
	}
}
