package com.mk.testframework.stepdefs.mobileSteps.allRegions;

import com.google.inject.Inject;
import com.mk.testframework.dt.mobile.MkMobileHamburgerMenu;
import com.mk.testframework.dt.page.home.MkHomePage;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.dt.mobile.MkMobileHomePage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import java.util.List;

/**
 * @author VThipperudrappa
 *
 */
@SuppressWarnings("deprecation")
public class HomePageStepDefMobile {
	private MkMobileHamburgerMenu mkMobileHamburgerMenu;
	private MkHomePage mkHomePage;
	private MkMobileHomePage mkMobileHomePage;
	private PageUtils pageUtils;

	@Inject
	public HomePageStepDefMobile(MkHomePage mkHomePage, MkMobileHamburgerMenu mkMobileHamburgerMenu,MkMobileHomePage mkMobileHomePage, PageUtils pageUtils) {
		this.mkMobileHamburgerMenu = mkMobileHamburgerMenu;
		this.mkHomePage = mkHomePage;
		this.mkMobileHomePage = mkMobileHomePage;
		this.pageUtils = pageUtils;
	}

	@Given("HEADER: I can see following user links")
	public void i_can_see_following_user_links(List<String> userLinks) {
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		List<String> expectedList;
		expectedList = mkMobileHamburgerMenu.translate(userLinks);
		expectedList.replaceAll(String::toLowerCase);
		pageUtils.sleepSeconds(5, "");
		List<String> actualList;
		actualList = mkMobileHamburgerMenu.getUserLinks();
		actualList.replaceAll(String::toLowerCase);

		boolean status = true;
		for (String expected : expectedList) {
			status = status && actualList.contains(expected);
		}
		Assert.assertTrue("Some expected links" + expectedList + " missing " + actualList, status);
	}

	@Given("HEADER: I can see country flag")
	public void i_can_see_country_flag() {
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		Assert.assertTrue("Country flag missing", mkMobileHamburgerMenu.isCountryFlagPresent());
	}

	@Given("HEADER: I can see country selected link")
	public void i_can_see_country_selected_link() {
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		Assert.assertTrue("Country selected link missing", mkMobileHamburgerMenu.isCountrySelectedPresent());
	}
	
	@Given("FOOTER: I can see Find a Store section")
	public void i_can_see_find_a_store_sections() {
		mkMobileHamburgerMenu.closeHamburgerMenuIfOpen();
		Assert.assertTrue("Find a store secion missing", mkHomePage.hasFindAstoreSection());
	}
    
    @Given("FOOTER: I can see Newsletter signup section")
	public void i_can_see_news_letter_sections() {
		mkMobileHamburgerMenu.closeHamburgerMenuIfOpen();
		Assert.assertTrue("news letter signup section missing", mkHomePage.hasNewsLetterSection());
	}
     
    @Given("FOOTER: I can see Social media section")
	public void i_can_see_social_media_sections() {
		mkMobileHamburgerMenu.closeHamburgerMenuIfOpen();
		Assert.assertTrue("Social media secion missing", mkHomePage.hasSocialMediaSection());
	}

    @Given("FOOTER: I can see Footer links section")
	public void i_can_see_footer_links_sections() {
		mkMobileHamburgerMenu.closeHamburgerMenuIfOpen();
		Assert.assertTrue("Footer links section missing", mkHomePage.hasFooterLinksSection());
	}
    
    @Given("FOOTER: I can see Additional footer links section")
	public void i_can_see_additional_footer_links_sections() {
		mkMobileHamburgerMenu.closeHamburgerMenuIfOpen();
		Assert.assertTrue("Additional footer section missing", mkHomePage.hasAdditionalFooterLinkSection());
	}
    
    @When("FOOTER: I click on the trackMyOrder link")
    public void i_click_the_trackmyorder_link() {
    	mkMobileHamburgerMenu.closeHamburgerMenuIfOpen();
    	mkMobileHomePage.clicktrackmyorderlink();
    }
    
 	@Given("HEADER: I can see store locator icon")
	public void i_can_see_storelocator_icon() {
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		Assert.assertTrue("Store locator icon missing", mkMobileHamburgerMenu.isStoreLocatorIconDisplayed());
	}
 	
 	@And("FOOTER: I click on {string} link in footer")
	public void iClickOnlinkInFooter(String link) {
 		mkMobileHomePage.clickOnFooterLink(link);
	}
 	
 	@And("I submit contact us form")
	public void iSubmitContactUsForm() {
 		Assert.assertTrue("Store locator icon missing", mkMobileHomePage.submitContactUsForm());
	}
 	
 	@And("Click on Sign in link")
	public void clickonSignIn() {
		mkHomePage.clickonSigninlink();
	}
}

