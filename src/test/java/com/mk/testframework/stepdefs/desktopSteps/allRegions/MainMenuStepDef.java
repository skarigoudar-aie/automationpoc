package com.mk.testframework.stepdefs.desktopSteps.allRegions;

import java.util.List;
import com.mk.testframework.dt.util.MkPageNavigator;
import org.apache.commons.lang3.LocaleUtils;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.base.Splitter;
import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.core.exceptions.TestEnvironmentException;
import com.mk.testframework.core.exceptions.TestException;
import com.mk.testframework.dt.header.MkBanner;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.header.MkMyAccountMenu;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_Common;
import com.mk.testframework.dt.page.product.MkProductContainer;
import com.mk.testframework.dt.popup.MkCountrySelectorModal;
import com.mk.testframework.dt.popup.MkMiniBagMenuPopup;
import com.mk.testframework.dt.util.PageUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

/**
 * @author VThipperudrappa
 *
 */
@SuppressWarnings("deprecation")
public class MainMenuStepDef {
	private final Logger log = LoggerFactory.getLogger(getClass());

	private MkMyAccountMenu mkMyAccountMenu;
	private MkBanner mkBanner;
	private MkHamburgerMenu mkHamburgerMenu;
	private MkCountrySelectorModal mkCountrySelectorModal;
	private Environment env;
	private Context context;
	private PageUtils pageUtils;
	private MkPageNavigator mkPageNavigator;
	private MkMyAccountPage_Common mkMyAccountPageCommon;
	private MkProductContainer mkProductContainer;
	private MkMiniBagMenuPopup mkMiniBagMenuPopup;

	@Inject
	public MainMenuStepDef(MkCountrySelectorModal mkCountrySelectorModal, MkBanner mkBanner,
			MkHamburgerMenu mkHamburgerMenu, MkMyAccountMenu mkMyAccountMenu, Environment env, Context context,
			PageUtils pageUtils, MkPageNavigator mkPageNavigator, MkMyAccountPage_Common mkMyAccountPageCommon,
			MkProductContainer mkProductContainer, MkMiniBagMenuPopup mkMiniBagMenuPopup) {
		this.mkMyAccountMenu = mkMyAccountMenu;
		this.mkHamburgerMenu = mkHamburgerMenu;
		this.mkCountrySelectorModal = mkCountrySelectorModal;
		this.mkBanner = mkBanner;
		this.env = env;
		this.context = context;
		this.pageUtils = pageUtils;
		this.mkPageNavigator = mkPageNavigator;
		this.mkMyAccountPageCommon = mkMyAccountPageCommon;
		this.mkProductContainer = mkProductContainer;
		this.mkMiniBagMenuPopup = mkMiniBagMenuPopup;
	}

	@Given("MENU: I select random dedicated country from the country selector")
	public void i_select_random_dedicated_country_from_the_country_selector() {
		mkHamburgerMenu.clickCountrySelector();
		String targetLocale = env.getRandomDedicatedCountryLocale();
		context.writeOut(env.getMkUrl(LocaleUtils.toLocale(targetLocale)));
		context.saveData("targetLocale", targetLocale);
		log.debug("Switching to {}", targetLocale);
		mkCountrySelectorModal.selectCountry(targetLocale);
	}

	@Given("MENU: I select random catch all country from the country selector")
	public void i_select_random_catch_all_country_from_the_country_selector() {
		mkHamburgerMenu.clickCountrySelector();
		String targetLocale = env.getRandomCatchAllCountryLocale();
		context.writeOut(env.getMkUrl(LocaleUtils.toLocale(targetLocale)));
		context.saveData("targetLocale", targetLocale);
		log.debug("Switching to {}", targetLocale);
		mkCountrySelectorModal.selectCountry(targetLocale);
	}

	@Given("MENU: I select random global country from the country selector")
	public void i_select_random_global_country_from_the_country_selector() {
		mkHamburgerMenu.clickCountrySelector();
		String targetLocale = env.getRandomGlobalCountryLocale();
		context.writeOut(env.getMkUrl(LocaleUtils.toLocale(targetLocale)));
		context.saveData("targetLocale", targetLocale);
		log.debug("Switching to {}", targetLocale);
		mkCountrySelectorModal.selectCountry(targetLocale);
	}

	@Given("MENU: I select random NA country from the country selector")
	public void i_select_random_NA_country_from_the_country_selector() {
		mkHamburgerMenu.clickCountrySelector();
		String targetLocale = env.getRandomNaCountryLocale();
		context.writeOut(env.getMkUrl(LocaleUtils.toLocale(targetLocale)));
		context.saveData("targetLocale", targetLocale);
		log.debug("Switching to {}", targetLocale);
		mkCountrySelectorModal.selectCountry(targetLocale);
	}

	@Given("MENU: I click on search link")
	public void i_click_on_search_link() {
		if (!mkPageNavigator.onSearchPage()) {
			mkBanner.moveToBanner();
			mkHamburgerMenu.clickSearchLink();
		}
	}

	@Given("MENU: I click on Sign In link")
	public void i_click_on_Sign_In_link() {
		mkHamburgerMenu.clickSignInLink();

	}

	@And("MENU: I select Sign In link")
	public void i_select_Sign_In_link() {
		mkMyAccountPageCommon.ActionOnSignInLink();
	}

	@When("MENU: I click Sign Out link")
	public void i_click_Sign_Out_link() {
		try {
			mkMyAccountMenu.flyOutMenu().clickSignOut();
		} catch (TestEnvironmentException e) {
			mkPageNavigator.goToHomePage();
			log.debug("Trying log out second time");
			mkMyAccountMenu.flyOutMenu().clickSignOut();
		} catch(Exception e) {
			mkPageNavigator.goToHomePage();
			log.info("Trying log out second time");
			mkMyAccountMenu.flyOutMenu().clickSignOut();
		}
	}

	@When("MENU: I click User Profile link")
	public void i_click_user_profile_link() {
		try {
			mkHamburgerMenu.clickMyAccountIcon();
		} catch (TestEnvironmentException e) {
			mkPageNavigator.goToHomePage();
			log.debug("Trying My Account navigation second time");
			mkHamburgerMenu.clickMyAccountIcon();
		}
	}

	@When("MENU: I click menu {string}")
	public void i_click(String menu) {
		List<String> menulList = Splitter.on(">").trimResults().splitToList(menu);
		if (menulList.size() == 1) {
			mkHamburgerMenu.clickMenu(menulList.get(0));
		} else if (menulList.size() == 2) {
			mkHamburgerMenu.clickMenu(menulList.get(1), menulList.get(0));
		} else if (menulList.size() == 3) {
			mkHamburgerMenu.clickMenu(menulList.get(2), menulList.get(1), menulList.get(0));
		} else {
			throw new TestEnvironmentException("Can't understand this menu pattern " + menu);
		}
	}

	@When("MENU: I click trends {string}")
	public void i_click_trends(String menu) {
		List<String> menulList = Splitter.on(">").trimResults().splitToList(menu);
		if (menulList.size() == 2) {
			mkHamburgerMenu.clickTrendsMenu(menulList.get(1), menulList.get(0));
		} else {
			throw new TestEnvironmentException("Can't understand this menu pattern " + menu);
		}
	}

	@When("MENU: I verify the url contains {string}")
	public void i_verify_the_url_contains(String menu) {
		String translatedMenuTitle = mkHamburgerMenu.translateMenuTitle(menu);
		String currentUrl = pageUtils.getCurrentUrl();

		Assert.assertTrue(currentUrl + "does not contain " + translatedMenuTitle,
				currentUrl.toLowerCase().contains(translatedMenuTitle.toLowerCase()));
	}

	@When("MENU: I click a random category in L2 menu")
	public void i_click_a_random_category_in_l2_menu() {
		try {
			mkHamburgerMenu.clickRandomL2Menu();
		} catch (TestException e) {
			context.writeOut("Retrying random l2 click");
			pageUtils.refresh();
			mkHamburgerMenu.clickRandomL2Menu();
		}
	}

	@When("MENU: I click a random category in L3 menu")
	public void i_click_a_random_category_in_l3_menu() {
		try {
			mkHamburgerMenu.clickRandomL3Menu();
		} catch (TestException e) {
			context.writeOut("Retrying random l3 click");
			pageUtils.refresh();
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
		if (menulList.size() == 2) {
			mkHamburgerMenu.clickTrendsMenuInNewTab(menulList.get(1), menulList.get(0));
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
		mkCountrySelectorModal.selectCountry(targetLocale);
	}

	@And("MENU: I verify recently added product should display top of the list in mini cart")
	public void menuIVerifyRecentlyAddedProductShouldDisplayTopOfTheListInMiniCart() {
		String productNameinPDP = mkProductContainer.captureProductNameOnPdp();
		String productNameInMiniCart = mkMiniBagMenuPopup.getFirstProductNameInMinCart();
		Assert.assertTrue("Product name in PDP and mini cart not matched",
				productNameinPDP.equalsIgnoreCase(productNameInMiniCart));
	}
	
	@When("MENU: I click on each L1 menu and verify the title tag and product display")
	public void i_click_on_each_L1_category_menu() {
		Assert.assertTrue("L1 Categories not Displyed", mkHamburgerMenu.clickOnL1CategoryAndVerifyPageTitle());
	}
	
	@When("MENU: I verify the title tag for {string} {string} and product display")
	public void i_click_on_each_L2_category_menu(String cat, String menus) {
		mkHamburgerMenu.clickOnL2CategoryAndVerifyPageTitle(cat, menus);
	}
	
	@When("MENU: I click on each L2 menu and verify the title tag and product displayed")
	public void i_click_on_each_l2_category_menu() {
		Assert.assertTrue("L2 Categories not Displyed", mkHamburgerMenu.clickOnL2CategoryAndVerifyPageTitle());
	}
	
	@When("MENU: I click on each L3 menu and verify the title tag and product displayed")
	public void i_click_on_each_l3_category_menu() {
		Assert.assertTrue("L3 Categories not Displyed", mkHamburgerMenu.clickOnL3CategoryAndVerifyPageTitle());
	}
	
	@When("MENU: I click on each L2 menu under and verify the title tag and product displayed")
	public void i_click_on_each_l2_category_menu(DataTable menuList) {
		
		Assert.assertTrue("L2 Categories not Displyed", mkHamburgerMenu.clickOnL2CategoryAndVerifyPageTitleNA(menuList));
	}
	
	@When("MENU: I click on each L3 menu under and verify the title tag and product displayed")
	public void i_click_on_each_l3_category_menu(DataTable menuList) {
		Assert.assertTrue("L2 Categories not Displyed", mkHamburgerMenu.clickOnL3CategoryAndVerifyPageTitleNA(menuList));
	}


	@And("MENU: I verify Find A Store icon")
	public void iVerifyFindAStoreIcon() {
		Assert.assertTrue("Find A Store icon not displayed", mkHamburgerMenu.isFindAStoreIconDisplayed());
	}
	
	@And("MENU: I verify minicart product name displayed on mouse hover")
	public void verifyProductNameInMiniCart() {
		Assert.assertTrue("Product name in mini cart not displayed", mkMiniBagMenuPopup.isProductNameDisplayed());
	}
	
	@And("MENU: I verify the color is displayed on mini cart")
	public void verifyProductColorInMiniCart() {
		Assert.assertTrue("Product color in mini cart not displayed", mkMiniBagMenuPopup.isProductColorDisplayed());
	}
	
	@And("MENU: I verify size is displayed on mini cart")
	public void verifyProductSizeInMiniCart() {
		Assert.assertTrue("Product size in mini cart not displayed", mkMiniBagMenuPopup.isProductSizeDisplayed());
	}
	
	@And("MENU: I verify was and now labels are displayed on mini cart")
	public void verifyProductWasAndNowLabelInMiniCart() {
		Assert.assertTrue("Product was and now labels in mini cart not displayed", mkMiniBagMenuPopup.isWasAndNowLabelDisplayed());
	}
	    
	@And("MENU: I verify product price displayed on mini cart")
	public void verifyProductPriceInMiniCart() {
		Assert.assertTrue("Product was and now labels in mini cart not displayed", mkMiniBagMenuPopup.isPriceDisplayed());
	}
	
	@And("MENU: I verify product image is displayed on mini cart")
	public void verifyProductImageInMiniCart() {
		Assert.assertTrue("Product image in mini cart not displayed", mkMiniBagMenuPopup.isImageDisplayed());
	}     
	     
	@And("MENU: I verify product qty is displayed")
	public void verifyProductQtyInMiniCart() {
		Assert.assertTrue("Product qty in mini cart not displayed", mkMiniBagMenuPopup.isProductQuantityDisplayed());
	}        	     

	@And("MENU: I verify Sign In link")
	public void iVerifySignInLink() {
		Assert.assertTrue("Sign In link not displayed", mkHamburgerMenu.isSignInLinkDisplayed());
	}

	@And("HEADER: I verfiy country selector")
	public void iVerifyCountrySelector() {
		Assert.assertTrue("Country selector not displayed", mkHamburgerMenu.isCountrySelectorDisplayed());
	}
}
