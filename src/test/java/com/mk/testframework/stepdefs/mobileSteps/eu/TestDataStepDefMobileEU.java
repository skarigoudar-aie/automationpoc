package com.mk.testframework.stepdefs.mobileSteps.eu;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.mobile.MkMobileHamburgerMenu;
import com.mk.testframework.stepdefs.crossPlatformSteps.allRegions.PageNavigationStepdef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

/**
 * @author VThipperudrappa
 *
 */
@SuppressWarnings("deprecation")
public class TestDataStepDefMobileEU {

	private TestData testData;
	private Context context;
	private PageNavigationStepdef pageNavigationStepdef;
	private LoginStepDefMobileEU loginStepDefMobileEU;
	private MkHamburgerMenu mkHamburgerMenu;
	private MkMobileHamburgerMenu mkMobileHamburgerMenu;

	@Inject
	public TestDataStepDefMobileEU(MkHamburgerMenu mkHamburgerMenu, TestData testData, Context context,
								   PageNavigationStepdef pageNavigationStepdef, LoginStepDefMobileEU loginStepDefMobileEU,
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
			mkHamburgerMenu.isSignInLinkDisplayed();
 		} catch (Exception e) {
 			if (alreadyLoggedin()) {
				context.writeOut("Logging out as already logged in");
				pageNavigationStepdef.i_navigate_to_MK_HomePage();
				loginStepDefMobileEU.i_log_out();
			}
		}
	}

	@And("I am a mk customer having {string} in my first and last name")
	public void iHaveSpecialCharecterInMyName(String userType) {
		testData.addUser(userType);
		context.writeOut(testData.getUserInfo());
		
		pageNavigationStepdef.i_navigate_to_MK_HomePage();

		if (alreadyLoggedin()) {
			context.writeOut("Logging out as already logged in");
			pageNavigationStepdef.i_navigate_to_MK_HomePage();
			loginStepDefMobileEU.i_log_out();
		}
	}
	
	@Given("I am a mk customer with Klarna")
	public void i_am_a_mk_customer_with_klarna() {
		testData.addUser("klarna");
		context.writeOut(testData.getUserInfo());

		pageNavigationStepdef.i_navigate_to_MK_HomePage();
		try {
			mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
			mkHamburgerMenu.isSignInLinkDisplayed();
		} catch (Exception e) {
			if (alreadyLoggedin()) {
				context.writeOut("Logging out as already logged in");
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
				context.writeOut("Logging in as user not logged in");
				pageNavigationStepdef.i_navigate_to_MK_HomePage();
				loginStepDefMobileEU.i_log_in();
			}
		} catch (Exception e) {
			mkHamburgerMenu.isSignInLinkDisplayed();
			pageNavigationStepdef.i_navigate_to_MK_HomePage();
			loginStepDefMobileEU.i_log_in();
		}
	}

	@Given("I am a logged-in mk customer with Klarna")
	public void iAmALoggedInMkCustomerWithKlarna() {
		testData.addUser("klarna");
		context.writeOut(testData.getUserInfo());

		pageNavigationStepdef.i_navigate_to_MK_HomePage();

		if (!alreadyLoggedin()) {
			pageNavigationStepdef.i_navigate_to_MK_HomePage();
			loginStepDefMobileEU.i_log_in();
		}
	}

	private boolean alreadyLoggedin() {
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		return mkHamburgerMenu.myAccountLinkIsPresent();
	}
	
	@Given("I am a remote logged-in mk customer")
	 public void iAmARemoteLoggedInMkCustomer() {
		testData.addUser("remote");
       context.writeOut(testData.getUserInfo());
       pageNavigationStepdef.i_navigate_to_MK_HomePage();

       if (!alreadyLoggedin()) {
        pageNavigationStepdef.i_navigate_to_MK_HomePage();
        loginStepDefMobileEU.i_remote_log_in();
       }
		
	}
	
	@Given("Login: I am mk logged in customer verifying {string}")
	public void i_am_a_mk_customer(String scenario) {
		testData.addUser(scenario+"_mobile");
		context.writeOut(testData.getUserInfo());
	}
}
