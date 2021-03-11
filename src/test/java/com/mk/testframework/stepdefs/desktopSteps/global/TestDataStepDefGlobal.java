package com.mk.testframework.stepdefs.desktopSteps.global;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.stepdefs.crossPlatformSteps.allRegions.PageNavigationStepdef;
import cucumber.api.java.en.Given;

/**
 * @author VThipperudrappa
 *
 */
@SuppressWarnings("deprecation")
public class TestDataStepDefGlobal {
	private TestData testData;
	private Context context;
	private PageNavigationStepdef pageNavigationStepdef;
	private LoginStepDefGlobal loginStepDefGlobal;
	private MkHamburgerMenu mkHamburgerMenu;

	@Inject
	public TestDataStepDefGlobal(MkHamburgerMenu mkHamburgerMenu, TestData testData, Context context,
								 PageNavigationStepdef pageNavigationStepdef, LoginStepDefGlobal loginStepDefGlobal) {
		this.testData = testData;
		this.context = context;
		this.pageNavigationStepdef = pageNavigationStepdef;
		this.loginStepDefGlobal = loginStepDefGlobal;
		this.mkHamburgerMenu = mkHamburgerMenu;
	}

	@Given("I am a mk customer")
	public void i_am_a_mk_customer() {
		testData.addUser("registered");
		context.writeOut(testData.getUserInfo());
		pageNavigationStepdef.i_navigate_to_MK_HomePage();
		try {
			mkHamburgerMenu.isSignInLinkDisplayed();
		} catch (Exception e) {
			if (alreadyLoggedin()) {
				pageNavigationStepdef.i_navigate_to_MK_HomePage();
				loginStepDefGlobal.i_log_out();
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
				loginStepDefGlobal.i_log_in();
			}
		} catch (Exception e) {
			mkHamburgerMenu.isSignInLinkDisplayed();
			pageNavigationStepdef.i_navigate_to_MK_HomePage();
			loginStepDefGlobal.i_log_in();
		}

	}

	private boolean alreadyLoggedin() {
		return mkHamburgerMenu.myAccountLinkIsPresent();
	}
	
	@Given("Login: I am mk logged in customer verifying {string}")
	public void i_am_a_mk_customer(String scenario) {
		testData.addUser(scenario+"_desktop");
		context.writeOut(testData.getUserInfo());
	}
}
