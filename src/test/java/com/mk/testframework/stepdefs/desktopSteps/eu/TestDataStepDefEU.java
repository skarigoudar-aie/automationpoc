package com.mk.testframework.stepdefs.desktopSteps.eu;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.stepdefs.crossPlatformSteps.allRegions.PageNavigationStepdef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

/**
 * @author VThipperudrappa
 *
 */
@SuppressWarnings("deprecation")
public class TestDataStepDefEU {
	private TestData testData;
	private Context context;
	private PageNavigationStepdef pageNavigationStepdef;
	private LoginStepDefEU loginStepDefEU;
	private MkHamburgerMenu mkHamburgerMenu;
	

	@Inject
	public TestDataStepDefEU(MkHamburgerMenu mkHamburgerMenu, TestData testData, Context context,
							 PageNavigationStepdef pageNavigationStepdef, LoginStepDefEU loginStepDefEU) {
		this.testData = testData;
		this.context = context;
		this.pageNavigationStepdef = pageNavigationStepdef;
		this.loginStepDefEU = loginStepDefEU;
		this.mkHamburgerMenu = mkHamburgerMenu;
	
	}

	@Given("I am a mk customer")
	public void i_am_a_mk_customer() {
		testData.addUser("registered");
		context.writeOut(testData.getUserInfo());

		pageNavigationStepdef.i_navigate_to_MK_HomePage();
		try {
			mkHamburgerMenu.isSignInLinkDisplayed();
		}catch(Exception e) {
			if(alreadyLoggedin()) {
				context.writeOut("Logging out as already logged-in");
				loginStepDefEU.i_log_out();
			}
		}
		
	}

	@And("I am a mk customer having {string} in my first and last name")
	public void iHaveSpecialCharecterInMyName(String userType) {
		testData.addUser(userType);
		context.writeOut(testData.getUserInfo());
		
		pageNavigationStepdef.i_navigate_to_MK_HomePage();

		if (alreadyLoggedin()) {
			pageNavigationStepdef.i_navigate_to_MK_HomePage();
			loginStepDefEU.i_log_out();
		}
	}
	
	@Given("I am a mk customer with Klarna")
	public void i_am_a_mk_customer_with_klarna() {
		testData.addUser("klarna");
		context.writeOut(testData.getUserInfo());

		pageNavigationStepdef.i_navigate_to_MK_HomePage();
		try {
			if (alreadyLoggedin()) {
				pageNavigationStepdef.i_navigate_to_MK_HomePage();
				loginStepDefEU.i_log_out();
			}
		} catch (Exception e) {
			mkHamburgerMenu.isSignInLinkDisplayed();
			context.writeOut("Not Logged in");
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
				loginStepDefEU.i_log_in();
			}
		} catch (Exception e) {
			mkHamburgerMenu.isSignInLinkDisplayed();
			pageNavigationStepdef.i_navigate_to_MK_HomePage();
			loginStepDefEU.i_log_in();
		}
	}
	
	@Given("I am a logged-in mk customer with Klarna")
	public void iAmALoggedInMkCustomerWithKlarna() {
		testData.addUser("klarna");
		context.writeOut(testData.getUserInfo());

		pageNavigationStepdef.i_navigate_to_MK_HomePage();

		try {
			if (mkHamburgerMenu.isSignInLinkDisplayed()) {
				pageNavigationStepdef.i_navigate_to_MK_HomePage();
				loginStepDefEU.i_log_in();
			} else if (!alreadyLoggedin()) {
				pageNavigationStepdef.i_navigate_to_MK_HomePage();
				loginStepDefEU.i_log_in();
			}

		} catch (Exception e) {
			mkHamburgerMenu.isSignInLinkDisplayed();
			pageNavigationStepdef.i_navigate_to_MK_HomePage();
			loginStepDefEU.i_log_in();
		}
	}

	private boolean alreadyLoggedin() {
		//System.out.println(mkHamburgerMenu.myAccountLinkIsPresent());
		return mkHamburgerMenu.myAccountLinkIsPresent();
		
	}
	
	@Given("I am a remote logged-in mk customer")
	public void iAmARemoteLoggedInMkCustomer() {
		testData.addUser("remote");
        context.writeOut(testData.getUserInfo());
        pageNavigationStepdef.i_navigate_to_MK_HomePage();

        if (!alreadyLoggedin()) {
         pageNavigationStepdef.i_navigate_to_MK_HomePage();
         loginStepDefEU.i_remote_log_in();
        }
	}
	
	@Given("Login: I am mk logged in customer verifying {string}")
	public void i_am_a_mk_customer(String scenario) {
		testData.addUser(scenario+"_desktop");
		context.writeOut(testData.getUserInfo());
	}
}
