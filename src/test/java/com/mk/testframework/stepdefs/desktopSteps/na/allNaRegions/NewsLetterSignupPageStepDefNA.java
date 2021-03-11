
package com.mk.testframework.stepdefs.desktopSteps.na.allNaRegions;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.page.home.MkHomePage;
import com.mk.testframework.dt.popup.MkYouAreOnTheListModal_US;
import com.mk.testframework.dt.util.MkPageNavigator;
import com.mk.testframework.dt.util.PageUtils;

import cucumber.api.java.en.And;

@SuppressWarnings("deprecation")
public class NewsLetterSignupPageStepDefNA {
	private MkHomePage mkHomePage;
	private TestData testData;

	@Inject
	public NewsLetterSignupPageStepDefNA(MkHomePage mkHomePage, TestData testData) {
		this.mkHomePage = mkHomePage;
		this.testData = testData;
	}
	
	@And("NEWS LETTER SIGNUP: I enter postcode")
	public void I_enter_postcode() {
		mkHomePage.enterPostcode(testData.getUser().address.getPostalCode());
	}

	@And("NEWS LETTER SIGNUP: I enter Password")
	public void I_enter_Password() {
		mkHomePage.enterPassword(testData.getUser().getPassword());
	}

	@And("NEWS LETTER SIGNUP: I enter Confirm Password")
	public void I_enter_Confirm_Password() {
		mkHomePage.enterConfirmPassword(testData.getUser().getPassword());
	}

	@And("NEWS LETTER SIGNUP: I click on Create Account button")
	public void I_click_on_Create_Account_button() {
		mkHomePage.clickOnCreateAccountbutton();
	}

}
