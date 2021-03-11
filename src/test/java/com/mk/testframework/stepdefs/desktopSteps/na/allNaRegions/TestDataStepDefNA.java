package com.mk.testframework.stepdefs.desktopSteps.na.allNaRegions;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.stepdefs.crossPlatformSteps.allRegions.PageNavigationStepdef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

/**
 * @author VThipperudrappa
 *
 */
@SuppressWarnings("deprecation")
public class TestDataStepDefNA {
	private TestData testData;
	private Context context;
	private PageNavigationStepdef pageNavigationStepdef;
	private LoginStepDefNA loginStepDefNA;
	private MkHamburgerMenu mkHamburgerMenu;
	private PageUtils pageUtils;

	@Inject
	public TestDataStepDefNA(MkHamburgerMenu mkHamburgerMenu, TestData testData, Context context, PageNavigationStepdef pageNavigationStepdef,
							 LoginStepDefNA loginStepDefNA, PageUtils pageUtils) {
		this.testData = testData;
		this.context = context;
		this.pageNavigationStepdef = pageNavigationStepdef;
		this.loginStepDefNA = loginStepDefNA;
		this.mkHamburgerMenu = mkHamburgerMenu;
		this.pageUtils = pageUtils;
	}

	@Given("I am a mk customer")
	public void iAmAMkCustomer() {
		testData.addUser("registered");
		context.writeOut(testData.getUserInfo());
		pageNavigationStepdef.i_navigate_to_MK_HomePage();
		try {
			mkHamburgerMenu.isSignInLinkDisplayed();
		} catch (Exception e) {
			if (alreadyLoggedin()) {
				pageNavigationStepdef.i_navigate_to_MK_HomePage();
				loginStepDefNA.i_log_out();
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
			loginStepDefNA.i_log_out();
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
				loginStepDefNA.i_log_in();
			}
		} catch (Exception e) {
			pageUtils.refresh();
			mkHamburgerMenu.isSignInLinkDisplayed();
			pageNavigationStepdef.i_navigate_to_MK_HomePage();
			loginStepDefNA.i_log_in();
		}
	}

	private boolean alreadyLoggedin() {
		return mkHamburgerMenu.myAccountLinkIsPresent();
	}
	

	@Given("I am a remote logged-in mk customer")
	 public void iAmARemoteLoggedInMkCustomer() {
		testData.addUser("remote");
        context.writeOut(testData.getUserInfo());
        pageNavigationStepdef.i_navigate_to_MK_HomePage();

        if (!alreadyLoggedin()) {
         pageNavigationStepdef.i_navigate_to_MK_HomePage();
         loginStepDefNA.i_remote_log_in();
        }
		
	}
	
	@Given("Login: I am mk logged in customer verifying {string}")
	public void iAmAMkCustomer(String scenario) {
		testData.addUser(scenario+"_desktop");
		context.writeOut(testData.getUserInfo());
	}
}
