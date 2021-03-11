package com.mk.testframework.stepdefs.mobileSteps.allRegions;

import com.google.common.base.Splitter;
import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.core.exceptions.TestEnvironmentException;
import com.mk.testframework.core.exceptions.TestException;
import com.mk.testframework.dt.header.MkBanner;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.mobile.MkMobileCountrySelectorMenu;
import com.mk.testframework.dt.mobile.MkMobileHamburgerMenu;
import com.mk.testframework.dt.util.MkPageNavigator;
import com.mk.testframework.dt.util.PageUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.LocaleUtils;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Random;

/**
 * @author VThipperudrappa
 *
 */
@SuppressWarnings("deprecation")
public class MainMenuStepDefMobile {

	private final Logger log = LoggerFactory.getLogger(getClass());
	private MkBanner mkBanner;
	private MkMobileHamburgerMenu mkMobileHamburgerMenu;
	private MkHamburgerMenu mkHamburgerMenu;
	private MkMobileCountrySelectorMenu mkMobileCountrySelectorMenu;
	private Environment env;
	private Context context;
	private PageUtils pageUtils;
	private MkPageNavigator mkPageNavigator;

	@Inject
	public MainMenuStepDefMobile(MkMobileCountrySelectorMenu mkMobileCountrySelectorMenu, MkBanner mkBanner,
			MkHamburgerMenu mkHamburgerMenu, Environment env, Context context, PageUtils pageUtils,
			MkPageNavigator mkPageNavigator, MkMobileHamburgerMenu mkMobileHamburgerMenu) {
		this.mkHamburgerMenu = mkHamburgerMenu;
		this.mkMobileHamburgerMenu = mkMobileHamburgerMenu;
		this.mkMobileCountrySelectorMenu = mkMobileCountrySelectorMenu;
		this.mkBanner = mkBanner;
		this.env = env;
		this.context = context;
		this.pageUtils = pageUtils;
		this.mkPageNavigator = mkPageNavigator;
	}

	@Given("MENU: I select random dedicated country from the country selector")
	public void i_select_random_dedicated_country_from_the_country_selector() {
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		mkMobileHamburgerMenu.clickCountrySelector();
		String targetLocale = env.getRandomDedicatedCountryLocale();
		context.writeOut(env.getMkUrl(LocaleUtils.toLocale(targetLocale)));
		context.saveData("targetLocale", targetLocale);
		log.debug("Switching to {}", targetLocale);
		mkMobileCountrySelectorMenu.selectCountry(targetLocale);
	}

	@Given("MENU: I select random catch all country from the country selector")
	public void i_select_random_catch_all_country_from_the_country_selector() {
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		mkMobileHamburgerMenu.clickCountrySelector();
		String targetLocale = env.getRandomCatchAllCountryLocale();
		context.writeOut(env.getMkUrl(LocaleUtils.toLocale(targetLocale)));
		context.saveData("targetLocale", targetLocale);
		log.debug("Switching to {}", targetLocale);
		mkMobileCountrySelectorMenu.selectCountry(targetLocale);
	}

	@Given("MENU: I select random global country from the country selector")
	public void i_select_random_global_country_from_the_country_selector() {
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		mkMobileHamburgerMenu.clickCountrySelector();
		String targetLocale = env.getRandomGlobalCountryLocale();
		context.writeOut(env.getMkUrl(LocaleUtils.toLocale(targetLocale)));
		context.saveData("targetLocale", targetLocale);
		log.debug("Switching to {}", targetLocale);
		mkMobileCountrySelectorMenu.selectCountry(targetLocale);
	}

	@Given("MENU: I select random NA country from the country selector")
	public void i_select_random_NA_country_from_the_country_selector() {
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		mkMobileHamburgerMenu.clickCountrySelector();
		String targetLocale = env.getRandomNaCountryLocale();
		context.writeOut(env.getMkUrl(LocaleUtils.toLocale(targetLocale)));
		context.saveData("targetLocale", targetLocale);
		log.debug("Switching to {}", targetLocale);
		mkMobileCountrySelectorMenu.selectCountry(targetLocale);
	}

	@Given("MENU: I click on search link")
	public void i_click_on_search_link() {
			mkBanner.moveToBanner();
			mkHamburgerMenu.clickSearchLink();
	}

	@Given("MENU: I click on Sign In link")
	public void i_click_on_Sign_In_link() {
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		mkMobileHamburgerMenu.clickSignInLink();
	}

	@When("MENU: I click User Profile link")
	public void i_click_user_profile_link() {
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		mkMobileHamburgerMenu.clickProfileLink();
	}

	@Given("MENU: I click on Sign Up link")
	public void i_click_on_Sign_Up_link() {
		mkHamburgerMenu.clickSignUpLink();
	}

	@And("MENU: I select Sign In link")
	public void i_select_Sign_In_link() {
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		mkMobileHamburgerMenu.clickSignInLink();
	}

	@When("MENU: I click Sign Out link")
	public void i_click_Sign_Out_link() {
		try {
			mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
			mkMobileHamburgerMenu.clickSignOutLink();
		} catch (TestEnvironmentException e) {
			mkPageNavigator.goToHomePage();
			log.debug("Trying log out second time");
			mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
			pageUtils.refresh();
			pageUtils.waitForPageToLoad();
			mkMobileHamburgerMenu.clickSignOutLink();
		}
	}

	@When("MENU: I click a random menu from following category")
	public void i_click_random_menu_from_following_category(List<String> menus) {
		i_click(menus.get(new Random().nextInt(menus.size())));
	}

	@When("MENU: I click menu {string}")
	public void i_click(String menu) {
		List<String> menulList = Splitter.on(">").trimResults().splitToList(menu);
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		if (menulList.size() == 1) {
			mkMobileHamburgerMenu.clickMenu(menulList.get(0));
		} else if (menulList.size() == 2) {
			mkMobileHamburgerMenu.clickMenu(menulList.get(1), menulList.get(0));
		} else if (menulList.size() == 3) {
			mkMobileHamburgerMenu.clickMenu(menulList.get(2), menulList.get(1), menulList.get(0));
		} else {
			throw new TestEnvironmentException("Can't understand this menu pattern " + menu);
		}
	}

	@When("MENU: I click explore link")
	public void i_click_explore_link() {
		mkMobileHamburgerMenu.clickExplore();
	}

	@When("MENU: I click trends {string}")
	public void i_click_trends(String menu) {
		List<String> menulList = Splitter.on(">").trimResults().splitToList(menu);
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		if (menulList.size() == 2) {
			mkMobileHamburgerMenu.clickTrendsMenu(menulList.get(1), menulList.get(0));
		} else {
			throw new TestEnvironmentException("Can't understand this menu pattern " + menu);
		}
	}

	@When("MENU: I verify the url contains {string}")
	public void i_verify_the_url_contains(String menu) {
		String translatedMenuTitle = mkMobileHamburgerMenu.translateMenuTitle(menu);
		String currentUrl = pageUtils.getCurrentUrl();

		Assert.assertTrue(currentUrl + "does not contain " + translatedMenuTitle,
				currentUrl.toLowerCase().contains(translatedMenuTitle.toLowerCase()));
	}

	@When("MENU: I click a random category in L2 menu")
	public void i_click_a_random_category_in_l2_menu() {
		mkHamburgerMenu.clickRandomL2Menu();
	}

	@When("MENU: I click a random category in L3 menu")
	public void i_click_a_random_category_in_l3_menu() {
		try {
			mkHamburgerMenu.clickRandomL3Menu();
		} catch (TestException e) {
			log.debug("retrying random l3 click");
			mkPageNavigator.goToHomePage();
			mkHamburgerMenu.clickRandomL3Menu();
		}
	}

	@And("MENU: I click on Bag link")
	public void menuIClickOnBagLink() {
		mkHamburgerMenu.clickShoppingBagIcon();
	}

	@And("MENU: I verify the shopping bag counter is updated to {int}")
	public void menuIVerifyTheShoppingBagCounterIsUpdatedTo(int expectedCount) {
		Assert.assertEquals("Failed to update shopping bag counter", expectedCount, mkHamburgerMenu.getBagCount());
	}

	@And("MENU: I open trends {string} in new tab")
	public void i_open_trends_new_tab(String menu) {
		List<String> menulList = Splitter.on(">").trimResults().splitToList(menu);
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		if (menulList.size() == 2) {
			mkMobileHamburgerMenu.clickTrendsMenuInNewTab(menulList.get(1), menulList.get(0));
		} else {
			throw new TestEnvironmentException("Can't understand this menu pattern " + menu);
		}
	}

	@When("MENU: I select locale {string} from the country selector")
	public void menuISelectLocaleFromTheCountrySelector(String targetLocale) {
		mkHamburgerMenu.clickCountrySelector();
		context.writeOut(env.getMkUrl(LocaleUtils.toLocale(targetLocale)));
		context.saveData("targetLocale", targetLocale);
		log.debug("Switching to {}", targetLocale);
		mkMobileCountrySelectorMenu.selectCountry(targetLocale);
	}
	
	@When("MENU: I click on each L1 menu and verify the title tag and product display")
	public void i_click_on_each_L1_category_menu() {
		Assert.assertTrue("L1 Categories not Displyed", mkHamburgerMenu.clickOnL1CategoryAndVerifyPageTitleMobile());
	}
	
	@When("MENU: I verify the title tag for {string} {string} and product display")
	public void i_click_on_each_L2_category_menu(String cat, String menus) {
		mkHamburgerMenu.clickOnL2CategoryAndVerifyPageTitle(cat, menus);
	}
	
	@When("MENU: I click on each L2 menu and verify the title tag and product displayed")
	public void i_click_on_each_l2_category_menu() {
		Assert.assertTrue("L2 Categories not Displyed", mkHamburgerMenu.clickOnL2CategoryAndVerifyPageTitleMobile());
	}
	
	@When("MENU: I click on each L3 menu and verify the title tag and product displayed")
	public void i_click_on_each_l3_category_menu() {
		Assert.assertTrue("L3 Categories not Displyed", mkHamburgerMenu.clickOnL3CategoryAndVerifyPageTitleMobile());
	}

	@And("MENU: I verify Find A Store icon")
	public void iVerifyFindAStoreIcon() {
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		Assert.assertTrue("Find A Store icon not displayed", mkMobileHamburgerMenu.isFindAStoreIconDisplayed());
		;
	}

	@And("MENU: I verify Sign In link")
	public void iVerifySignInLink() {
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		Assert.assertTrue("Sign In link not displayed", mkMobileHamburgerMenu.isSignInLinkDisplayed());
	}
	
	@And("HEADER: I verfiy country selector")
	public void iVerifyCountrySelector() {
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		Assert.assertTrue("Country selector not displayed", mkMobileHamburgerMenu.isCountrySelectorDisplayed());
	}
	
}
