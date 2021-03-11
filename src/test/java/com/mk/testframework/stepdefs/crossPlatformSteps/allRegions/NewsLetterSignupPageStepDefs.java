
package com.mk.testframework.stepdefs.crossPlatformSteps.allRegions;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.dt.page.home.MkHomePage;
import com.mk.testframework.dt.util.MkPageNavigator;
import com.mk.testframework.dt.util.ModalUtils;
import com.mk.testframework.dt.util.PageUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

@SuppressWarnings("deprecation")
public class NewsLetterSignupPageStepDefs {
	private MkHomePage mkHomePage;
	private TestData testData;
	private MkPageNavigator mkPageNavigator;
	private PageUtils pageUtils;
	private ModalUtils modalUtils;

	@Inject
	public NewsLetterSignupPageStepDefs(MkHomePage mkHomePage, TestData testData,
			MkPageNavigator mkPageNavigator, PageUtils pageUtils, ModalUtils modalUtils) {
		this.mkHomePage = mkHomePage;
		this.testData = testData;
		this.mkPageNavigator = mkPageNavigator;
		this.pageUtils = pageUtils;
		this.modalUtils = modalUtils;
	}

	@Then("I am on newsletter signup page")
	public void I_am_on_newsletter_signup_page() {
		mkPageNavigator.onNewsLetterPage();
	}
	
	@And("NEWS LETTER SIGNUP: I enter confirm email address")
	public void I_enter_confirm_email_address() {
		mkHomePage.footerEnterConfirmEmailId(testData.getUser().getEmail());
	}

	@And("NEWS LETTER SIGNUP: I enter first name")
	public void I_enter_first_name() {
		mkHomePage.footerEnterFirstName(testData.getUser().getFirstname());
	}

	@And("NEWS LETTER SIGNUP: I enter last name")
	public void I_enter_last_name() {
		mkHomePage.footerEnterLastName(testData.getUser().getLastname());
	}

	@And("I verify user is on Thanks for signing up page")
	public void I_verify_user_is_on_Thanks_for_signing_up_page() {
		mkPageNavigator.thanksForSignUpPage();
	}

	@And("I clear browser cache")
	public void I_clear_browser_cache() {
		pageUtils.deleteAllCookies();
	}
    
	@And("I Check cookie message is displaying")
	public void I_Check_cookie_message_is_displaying() {
		modalUtils.acceptCountryChangePopupIfPresented();
		mkPageNavigator.isCookiemessageDisplayed();	
	}
	
	@And("I Accept cookie message")
	public void I_Accept_cookie_message() {
		mkHomePage.acceptCookies();
	}
	
	@And("I accept cookie message and country change popup")
	public void I_Accept_cookie_message_and_Change_Country_pop_up() {
		mkHomePage.acceptCookieBannerIfPresented();
	    modalUtils.acceptCountryChangePopupIfPresented();

	}
    
	
}
