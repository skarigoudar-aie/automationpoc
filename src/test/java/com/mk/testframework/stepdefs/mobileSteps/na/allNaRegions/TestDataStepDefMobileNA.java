package com.mk.testframework.stepdefs.mobileSteps.na.allNaRegions;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.mobile.MkMobileHamburgerMenu;
import com.mk.testframework.stepdefs.crossPlatformSteps.allRegions.PageNavigationStepdef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

/**
 * @author VThipperudrappa
 *
 */
@SuppressWarnings("deprecation")
public class TestDataStepDefMobileNA {
	private TestData testData;
	private Context context;
	private PageNavigationStepdef pageNavigationStepdef;
	private LoginStepDefMobileNA loginStepDefMobileNA;
	private MkMobileHamburgerMenu mkMobileHamburgerMenu;

	@Inject
	public TestDataStepDefMobileNA(TestData testData, Context context, PageNavigationStepdef pageNavigationStepdef,
			LoginStepDefMobileNA loginStepDefMobileNA, MkMobileHamburgerMenu mkMobileHamburgerMenu) {
		this.testData = testData;
		this.context = context;
		this.pageNavigationStepdef = pageNavigationStepdef;
		this.loginStepDefMobileNA = loginStepDefMobileNA;
		this.mkMobileHamburgerMenu = mkMobileHamburgerMenu;
	}

	@Given("I am a mk customer")
	public void i_am_a_mk_customer() {
		testData.addUser("registered");
		context.writeOut(testData.getUserInfo());
		pageNavigationStepdef.i_navigate_to_MK_HomePage();
		try {
			mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
			mkMobileHamburgerMenu.isSignInLinkDisplayed();
		} catch (Exception e) {
			if (alreadyLoggedin()) {
				loginStepDefMobileNA.i_log_out();
			}
		}
	}

	@Given("Login: I am mk logged in customer verifying {string}")
	public void i_am_a_mk_customer(String scenario) {
		testData.addUser(scenario + "_mobile");
		context.writeOut(testData.getUserInfo());
	}

	@Given("I am a logged-in mk customer")
	public void iAmALoggedInMkCustomer() {
		testData.addUser("registered");
		context.writeOut(testData.getUserInfo());
		pageNavigationStepdef.i_navigate_to_MK_HomePage();
		try {
			if (!alreadyLoggedin()) {
				pageNavigationStepdef.i_navigate_to_MK_HomePage();
				loginStepDefMobileNA.i_log_in();
			}
		} catch (Exception e) {
			mkMobileHamburgerMenu.isSignInLinkDisplayed();
			pageNavigationStepdef.i_navigate_to_MK_HomePage();
			loginStepDefMobileNA.i_log_in();
		}
	}

	@And("I am a mk customer having {string} in my first and last name")
	public void iHaveSpecialCharecterInMyName(String userType) {
		testData.addUser(userType);
		context.writeOut(testData.getUserInfo());

		pageNavigationStepdef.i_navigate_to_MK_HomePage();

		if (alreadyLoggedin()) {
			pageNavigationStepdef.i_navigate_to_MK_HomePage();
			loginStepDefMobileNA.i_log_in();
		}
	}

	private boolean alreadyLoggedin() {
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		return mkMobileHamburgerMenu.myAccountLinkIsPresent();
	}

	@Given("I am a remote logged-in mk customer")
	public void iAmARemoteLoggedInMkCustomer() {

		testData.addUser("remote");
		context.writeOut(testData.getUserInfo());

		pageNavigationStepdef.i_navigate_to_MK_HomePage();

		if (!alreadyLoggedin()) {
			loginStepDefMobileNA.i_remote_log_in();
		}

	}

}
