package com.mk.testframework.stepdefs.desktopSteps.allRegions;

import java.util.List;
import org.junit.Assert;
import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.page.home.MkHomePage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author VThipperudrappa
 *
 */
@SuppressWarnings("deprecation")
public class HomePageStepDef {
	private MkHamburgerMenu mkHamburgerMenu;
	private MkHomePage mkHomePage;
	
	@Inject
	public HomePageStepDef(MkHomePage mkHomePage, MkHamburgerMenu mkHamburgerMenu) {
		this.mkHamburgerMenu = mkHamburgerMenu;
		this.mkHomePage = mkHomePage;
	
	}

	@Given("HEADER: I can see following user links")
	public void i_can_see_following_user_links(List<String> userLinks) {
		List<String> expectedList;
		expectedList = mkHamburgerMenu.translate(userLinks);
		expectedList.replaceAll(String::toLowerCase);

		List<String> actualList;
		actualList = mkHamburgerMenu.getUserLinks();
		actualList.replaceAll(String::toLowerCase);

		boolean status = true;
		for (String expected : expectedList) {
			status = status && actualList.contains(expected);
		}
		Assert.assertTrue("Some expected links" + expectedList + " missing " + actualList, status);
	}

	@Given("HEADER: I can see country flag")
	public void i_can_see_country_flag() {
		Assert.assertTrue("Country flag missing", mkHamburgerMenu.isCountryFlagPresent());
	}

	@Given("HEADER: I can see country selected link")
	public void i_can_see_country_selected_link() {
		Assert.assertTrue("Country selected link missing", mkHamburgerMenu.isCountrySelectedPresent());
	}
	
	@Given("HEADER: I can see store locator icon")
	public void i_can_see_storelocator_icon() {
		Assert.assertTrue("Store locator icon missing", mkHamburgerMenu.isStoreLocatorIconDisplayed());
	}
    
    @Given("HEADER: I can see user icon")
	public void i_can_see_user_icon() {
		Assert.assertTrue("user icon missing", mkHamburgerMenu.isUserIconDisplayed());
	}
	
	@Given("FOOTER: I can see Find a Store section")
	public void i_can_see_find_a_store_sections() {
		Assert.assertTrue("Find a store secion missing", mkHomePage.hasFindAstoreSection());
	}

    @Given("FOOTER: I can see Newsletter signup section")
	public void i_can_see_news_letter_sections() {
		Assert.assertTrue("news letter signup section missing", mkHomePage.hasNewsLetterSection());
	}

    @Given("FOOTER: I can see Social media section")
	public void i_can_see_social_media_sections() {
		Assert.assertTrue("Social media secion missing", mkHomePage.hasSocialMediaSection());
	}

    @Given("FOOTER: I can see Footer links section")
	public void i_can_see_footer_links_sections() {
		Assert.assertTrue("Footer links section missing", mkHomePage.hasFooterLinksSection());
	}

    @Given("FOOTER: I can see Additional footer links section")
	public void i_can_see_additional_footer_links_sections() {
		Assert.assertTrue("Additional footer section missing", mkHomePage.hasAdditionalFooterLinkSection());
	}
    	
    @When("FOOTER: I click on the trackMyOrder link")
	public void i_click_on_trackMyOrder() {
     mkHomePage.clickOntrackMyOrder();
	}
    
    @And("FOOTER: I click on {string} link in footer")
	public void iClickOnlinkInFooter(String link) {
    	mkHomePage.clickOnFooterLink(link);
	}
    
    @And("I submit contact us form")
	public void iSubmitContactUsForm() {
 		Assert.assertTrue("Contact us form not submitted", mkHomePage.submitContactUsForm());
	}
    
    
    @Given("Go to Mk Home page")
  	public void GotoMkHomepage() {
    	mkHomePage.clickLogo();
  	}
      
    @And("click on Signin link")
  	public void clickSigninlink() {
    	mkHomePage.signinlink();
  	} 
    
    @And("Enter username {string}")
  	public void enterUsrname(String uname) {
    	mkHomePage.enterUserName(uname);
  	} 
    
    @And("Enter password {string}")
  	public void enterPwd(String pwd) {
    	mkHomePage.enterPword(pwd);
  	} 
    
    
    @When("click on Signin button")
  	public void clickSigninButton() {
    	mkHomePage.clickSigninBtn();
  	} 
    
    
    
    
}

