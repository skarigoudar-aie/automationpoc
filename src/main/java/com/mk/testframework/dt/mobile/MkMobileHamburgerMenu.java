package com.mk.testframework.dt.mobile;

import java.util.Currency;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.apache.commons.lang.WordUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.dt.util.PageUtils.Resource;

/**
 * @author VThipperudrappa
 *
 */
public class MkMobileHamburgerMenu {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@FindBy(xpath = "(//*[@class='utility-nav-mobile']//*[@class='mk-sign-in']/*//button)[1] | (//*[@class='utility-nav-mobile']//*[@class='mk-sign-in']/*//a)[1]")
	private WebElement signInLink;

	@FindBy(css = ".utility-nav-mobile .mk-sign-in .header-my-account button")
	private WebElement signInLink2;
	
	@FindBy(css = ".utility-nav-mobile .my-account")
	private WebElement myAccountLink;

	@FindBy(css = ".utility-nav-mobile .my-account a")
	private WebElement myAccountLinka;
	
	@FindBy(css = ".utility-nav-mobile .my-account button")
	private WebElement myAccountLinka2;

	@FindBy(css = ".utility-nav-mobile .countrySelector")
	private WebElement countrySelector;

	@FindBy(css = ".utility-nav-mobile .region-select-wrap li a")
	private List<WebElement> userLinks;

	@FindBy(css = ".utility-nav-mobile .language-selected .countrySelector .countrySelector__svg")
	private WebElement countryFlagSvg;

	@FindBy(css = ".utility-nav-mobile .language-selected .countrySelector .countrySelected")
	private WebElement countrySelectedSpan;

	@FindBy(css = ".store-locator a .icon")
	private WebElement storeLocatorIcon;

	@FindBy(css = ".hamburger-container button")
	private WebElement hamburgerButton;

	@FindBy(css = ".mob-menu-expanded")
	private WebElement hamburgerMenuExpanded;

	@FindBy(xpath = "(//*[@class='utility-nav-mobile']//*[@class='signout-link'])[2]")
	private WebElement signoutLink;

	@FindBy(css = ".main-nav-menu .l1flyout")
	private List<WebElement> l1Flyout;

	@FindBy(css = ".error")
	private WebElement invalidcredentials;

	@FindBy(css = ".form-level-error")
	private WebElement invalidcredentialsna;

	@FindBy(css = ".nav-menu-item.flyout-container.open .explore a")
	private WebElement exploreLink;

	@FindBy(css = ".utility-nav-mobile .countrySelected")
	private WebElement selectedCountryCurrency;

	@FindBy(xpath = "(//*[@class='store-locator']/a)[2]")
	private WebElement storeLocatorLink;
	
	@FindBy(id = "errorPageContainer")
	public WebElement errorPage;

	private Actions actionBuilder;
	private WebDriver webDriver;
	private PageUtils pageUtils;
	private Context context;
	private JavascriptExecutor jsExecutor;
	private Environment env;

	@Inject
	public MkMobileHamburgerMenu(WebDriver webDriver, PageUtils pageUtils, Environment env, Context context) {
		PageFactory.initElements(webDriver, this);
		this.actionBuilder = new Actions(webDriver);
		this.webDriver = webDriver;
		this.pageUtils = pageUtils;
		this.context = context;
		this.env = env;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
	}

	public void clickSignInLink() {
		try {
			pageUtils.scrollToElement(signInLink);
			jsExecutor.executeScript("arguments[0].click();", signInLink);
			pageUtils.waitForPageToLoad();
		} catch (Exception e) {
			pageUtils.waitForWebElement(signInLink);
			pageUtils.scrollToElement(signInLink);
			jsExecutor.executeScript("arguments[0].click();", signInLink);
			pageUtils.waitForPageToLoad();
		}
	}

	public void clickCountrySelector() {
		pageUtils.scrollToElement(countrySelector);
		actionBuilder.moveToElement(countrySelector).click().build().perform();

		pageUtils.waitForPageToLoad();
	}

	public boolean myAccountLinkIsPresent() {
		pageUtils.waitForWebElement(myAccountLink);
		boolean linkPresent = pageUtils.verifyIfDisplayed(myAccountLink);
		try {
			if (!linkPresent) {
				context.writeOut("Retrying check for my account link");
				pageUtils.refresh();
				openHamburgerMenuIfNotOpen();
				pageUtils.waitForWebElement(myAccountLink);
				return pageUtils.verifyIfDisplayed(myAccountLink);
			}
		} catch (Exception e) {
			//modalUtils.acceptCountryChangePopupIfPresented();
			if (!linkPresent) {
				context.writeOut("Retrying check for my account link 2nd time");
				pageUtils.refresh();
				openHamburgerMenuIfNotOpen();
				pageUtils.waitForWebElement(myAccountLink);
				return pageUtils.verifyIfDisplayed(myAccountLink);
			}
		}
		return linkPresent;
	}

	public List<String> getUserLinks() {
		List<String> links = Lists.newArrayList();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "1 sec wait for ajax load");

		List<WebElement> filteredUserLinks = userLinks.stream().filter(s -> s.isDisplayed())
				.collect(Collectors.toList());
		for (WebElement link : filteredUserLinks) {
			if (link.getAttribute("title").isBlank()) {
				links.add(link.getText());
			} else {
				links.add(link.getAttribute("title"));
			}
		}
		return links;
	}

	public boolean isCountryFlagPresent() {
		return pageUtils.verifyIfDisplayed(countryFlagSvg);
	}

	public boolean isCountrySelectedPresent() {
		return pageUtils.verifyIfDisplayed(countrySelectedSpan);
	}

	public List<String> translate(List<String> userLinks) {
		List<String> translatedUserLinks = Lists.newArrayList();
		ResourceBundle menuResource = pageUtils.getResourceBundle(Resource.LINKS);
		userLinks.stream()
				.forEach(s -> translatedUserLinks.add(menuResource.getString(pageUtils.buildResourceLookupKey(s))));
		return translatedUserLinks;
	}

	public void clickHamburgerButton() {
		jsExecutor.executeScript("arguments[0].click();", hamburgerButton);
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "Wait for menu to open");
	}

	public boolean isHamburgerMenuOpen() {
		boolean menuOpen = false;
		try {
			if (hamburgerMenuExpanded.isDisplayed()) {
				menuOpen = true;
			}
		} catch (Exception e) {
		}

		return menuOpen;
	}

	public void openHamburgerMenuIfNotOpen() {
		if (!isHamburgerMenuOpen()) {
			clickHamburgerButton();
		}
	}

	public void closeHamburgerMenuIfOpen() {
		waitForTopHeaderToLoad();

		if (isHamburgerMenuOpen()) {
			clickHamburgerButton();
		}
	}

	public boolean isTopHeaderDisplayed() {
		pageUtils.waitForWebElement(hamburgerButton);
		return pageUtils.verifyIfDisplayed(hamburgerButton);
	}

	public void waitForTopHeaderToLoad() {
		if (!isTopHeaderDisplayed()) {
			pageUtils.refresh();
			log.debug("Refreshing for top header menu");
			pageUtils.waitForWebElement(hamburgerButton);
		}
	}

	public boolean signInLinkIsPresent() {
		boolean linkPresent = false;
		try {
				context.writeOut("Retrying check for signInLink link");
				pageUtils.refresh();
				openHamburgerMenuIfNotOpen();
				linkPresent = pageUtils.waitForWebElement(signInLink);
		} catch (Exception e) {
				context.writeOut("Retrying check for signInLink link2");
				pageUtils.refresh();
				openHamburgerMenuIfNotOpen();
				linkPresent= pageUtils.waitForWebElement(signInLink2);
		}
		return linkPresent;
	}

	public void clickSignOutLink() {
		try {
			pageUtils.waitForWebElement(signoutLink);
			pageUtils.scrollToElement(signoutLink);
			jsExecutor.executeScript("arguments[0].click();", signoutLink);
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(1, "1 sec wait for ajax load");
		} catch (Exception e) {
			pageUtils.refresh();
			openHamburgerMenuIfNotOpen();
			pageUtils.waitForWebElement(signoutLink);
			pageUtils.scrollToElement(signoutLink);
			jsExecutor.executeScript("arguments[0].click();", signoutLink);
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(1, "1 sec wait for ajax load");
		}
	}

	public boolean isStoreLocatorIconDisplayed() {
		return pageUtils.verifyIfDisplayed(storeLocatorIcon);
	}

	public void clickMenu(String menuTitle) {
		String translatedMenuTitle = WordUtils.capitalizeFully(getTranslation(menuTitle).toLowerCase());
		WebElement menuLink = l1Flyout.stream()
				.filter(s -> s.getText().toLowerCase().equals(translatedMenuTitle.toLowerCase())).findFirst().get();
		this.context.saveData("menu-href", menuLink.getAttribute("href"));
		jsExecutor.executeScript("arguments[0].click();", menuLink);
		pageUtils.sleepSeconds(1, "Wait for menu to open");
	}

	public void clickMenu(String submenuTitle, String menuTitle) {
		clickMenu(menuTitle);
		new FlyoutMenu().clickMenu(getTranslation(menuTitle + "." + submenuTitle));
	}

	public void clickMenu(String subsubmenuTitle, String submenuTitle, String menuTitle) {
		clickMenu(menuTitle);
		new FlyoutMenu().clickMenu(getTranslation(menuTitle + "." + submenuTitle),
				getTranslation(menuTitle + "." + submenuTitle + "." + subsubmenuTitle));
	}

	public void clickExplore() {
		this.context.saveData("menu-href", exploreLink.getAttribute("href"));
		jsExecutor.executeScript("arguments[0].click();", exploreLink);
		pageUtils.sleepSeconds(1, "page load");
		pageUtils.waitForPageToLoad();
	}

	private String getTranslation(String menu) {
		ResourceBundle menuResource = pageUtils.getResourceBundle(Resource.MENU);
		return menuResource.getString(pageUtils.buildResourceLookupKey(menu));
	}

	public String translateMenuTitle(String menu) {
		return getTranslation(menu);
	}

	public void clickTrendsMenuInNewTab(String submenuTitle, String menuTitle) {
		clickMenu(menuTitle);
		new FlyoutMenu().clickTrendsMenuInNewTab(getTranslation(menuTitle + "." + submenuTitle));
	}

	public class FlyoutMenu {
		public void clickMenu(String l2MenuTitle) {
			pageUtils.waitForAjaxToComplete();
			List<WebElement> l2Flyout = webDriver.findElements(By.cssSelector(".nav-menu-item.open li a"));

			WebElement menuLink = l2Flyout.stream()
					.filter(s -> s.getText().toLowerCase().equals(l2MenuTitle.toLowerCase())).findFirst().get();
			context.saveData("menu-href", menuLink.getAttribute("href"));
			menuLink.click();
			pageUtils.waitForAjaxToComplete();
		}

		public void clickMenu(String l2MenuTitle, String l3MenuTitle) {
			clickMenu(l2MenuTitle);

			List<WebElement> l3Menus = webDriver.findElements(By.cssSelector(".nav-menu-item.open li a"));
			WebElement l3menu = l3Menus.stream()
					.filter(s -> s.getText().toLowerCase().equals(l3MenuTitle.toLowerCase())).findFirst().get();
			context.saveData("menu-href", l3menu.getAttribute("href"));
			l3menu.click();
			pageUtils.waitForAjaxToComplete();
			pageUtils.waitForPageToLoad();
		}

		
		public void clickTrendsMenu(String trendMenuTitle) {
			List<WebElement> trendsLinks = webDriver.findElements(By.cssSelector(
					".nav-menu-item.open li a"));
			WebElement menuLink = trendsLinks.stream()
					.filter(s -> s.getText().toLowerCase().equals(trendMenuTitle.toLowerCase())).findFirst().get();
			context.saveData("menu-href", menuLink.getAttribute("href"));
			jsExecutor.executeScript("arguments[0].click();", menuLink);
			pageUtils.waitForPageToLoad();
		}
		
		public void clickTrendsMenuInNewTab(String trendMenuTitle) {
			List<WebElement> trendsLinks = webDriver
					.findElements(By.cssSelector(".nav-menu-item.flyout-container.open .trend-categories a"));
			WebElement menuLink = trendsLinks.stream()
					.filter(s -> s.getText().toLowerCase().equals(trendMenuTitle.toLowerCase())).findFirst().get();
			context.saveData("menu-href", menuLink.getAttribute("href"));
			((JavascriptExecutor) webDriver)
					.executeScript("window.open('" + menuLink.getAttribute("href") + "', '-blank')");
			List<String> handles = Lists.newArrayList(webDriver.getWindowHandles());
			webDriver.switchTo().window(handles.get(1));
			pageUtils.sleepSeconds(1, "waiting for tab load");
			pageUtils.waitForAjaxToComplete();
			pageUtils.waitForPageToLoad();
		}
	}

	public void clickTrendsMenu(String submenuTitle, String menuTitle) {
		pageUtils.waitForAjaxToComplete();
		clickMenu(menuTitle);
		new FlyoutMenu().clickTrendsMenu(getTranslation(menuTitle + "." + submenuTitle));
	}
	
	public void clickProfileLink() {
		try {
			pageUtils.waitForWebElement(myAccountLinka);
			pageUtils.scrollToElement(myAccountLinka);
			jsExecutor.executeScript("arguments[0].click();", myAccountLinka);
			context.writeOut("Clicked on Profile link");
			pageUtils.waitForPageToLoad();
			pageUtils.sleepSeconds(3, "page load");
		} catch (Exception e) {
			pageUtils.waitForWebElement(myAccountLinka2);
			pageUtils.scrollToElement(myAccountLinka2);
			jsExecutor.executeScript("arguments[0].click();", myAccountLinka2);
			context.writeOut("Clicked on Profile link");
			pageUtils.waitForPageToLoad();
			pageUtils.sleepSeconds(3, "page load");
		}
	}

	public void validateErrorMessage() {

		if (env.getCountry().equalsIgnoreCase("US")) {
			Assert.assertNotNull(invalidcredentialsna);
		} else if (env.getCountry().equalsIgnoreCase("CA")) {
			Assert.assertNotNull(invalidcredentialsna);
		} else
			Assert.assertNotNull(invalidcredentials);

	}
	
	public void clickL1Menu(String menuTitle) {
		WebElement menuLink = l1Flyout.stream()
				.filter(s -> s.getText().toLowerCase().equals(menuTitle.toLowerCase())).findFirst().get();
		this.context.saveData("menu-href", menuLink.getAttribute("href"));
		jsExecutor.executeScript("arguments[0].click();", menuLink);
		pageUtils.sleepSeconds(1, "Wait for menu to open");
	}
	
	public void clickL2Menu(String submenuTitle, String menuTitle) {
		clickL1Menu(menuTitle);
		new FlyoutMenu().clickMenu(submenuTitle);
	}

	public boolean isFindAStoreIconDisplayed() {
		openHamburgerMenuIfNotOpen();
		pageUtils.waitForWebElement(storeLocatorLink);
		return pageUtils.verifyIfDisplayed(storeLocatorLink);
	}

	public boolean isSignInLinkDisplayed() {
		boolean flag =false;
		if(signInLink.isDisplayed()) {
			flag = true;
		}
		return flag;
	}

	public boolean isCountrySelectorDisplayed() {
		return pageUtils.verifyIfDisplayed(countrySelector);
	}

	public boolean verifyCountrySelectedAndCurrency() {
		String actualCurrency = selectedCountryCurrency.getText().trim();
		boolean flag = false;
		Currency currency = Currency.getInstance(env.getCurrentLocale());
		String expectedCurrency = currency.getSymbol();
		if (actualCurrency.contains(expectedCurrency)||actualCurrency.contains("AU$")) {
			flag = true;
			context.writeOut("Expected currency symbol: " + env.getCountry() + " " + expectedCurrency
					+ " Actual currency symbol: " + actualCurrency);
		}
		return flag;
	}

	public boolean verifyCountryNameSelected() {
		String actualContryName = selectedCountryCurrency.getText().trim().toLowerCase();
		boolean flag = false;
		Currency currency = Currency.getInstance(env.getCurrentLocale());
		String expectedCurrency = currency.getSymbol();
		if(actualContryName.contains(env.getCountry().toLowerCase())) {
			flag = true;
			context.writeOut("Expected country name: "+ env.getCountry() + " " +expectedCurrency +" Actual country name: "+actualContryName);
		}
		return flag;		
	}
	
	public void clickMenuL1(String menuTitle) {
		//String translatedMenuTitle = WordUtils.capitalizeFully(getTranslation(menuTitle).toLowerCase());
		try {
			WebElement menuLink = l1Flyout.stream()
					.filter(s -> s.getText().toLowerCase().equals(menuTitle.toLowerCase())).findFirst().get();
			this.context.saveData("menu-href", menuLink.getAttribute("href"));
			jsExecutor.executeScript("arguments[0].click();", menuLink);
			pageUtils.sleepSeconds(5, "Wait for menu to open");
			context.writeOut("Clicked on L1 menu: "+menuTitle);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void clickMenuL2(String submenuTitle, String menuTitle) {
		clickMenuL1(menuTitle);
		new FlyoutMenuMobile().clickMenu(submenuTitle);
	}

	public void clickL3Menu(String subsubmenuTitle, String submenuTitle, String menuTitle) {
		clickMenuL1(menuTitle);
		new FlyoutMenuMobile().clickMenu(submenuTitle,subsubmenuTitle);
	}
	
	public class FlyoutMenuMobile {
		public void clickL2Menu(String l2MenuTitle) {
			try {
				pageUtils.waitForAjaxToComplete();
				List<WebElement> l2Flyout = webDriver.findElements(By.cssSelector(".nav-menu-item.open li a"));

				WebElement menuLink = l2Flyout.stream()
						.filter(s -> s.getText().toLowerCase().equals(l2MenuTitle.toLowerCase())).findFirst().get();
				context.saveData("menu-href", menuLink.getAttribute("href"));
				menuLink.click();
				pageUtils.waitForAjaxToComplete();
				context.writeOut("Clicked on L2 menu: "+l2MenuTitle);

			} catch (Exception e) {
				System.out.println();

			}
		}
		
		public void clickMenu(String l2MenuTitle) {
			try {
				pageUtils.waitForAjaxToComplete();
				List<WebElement> l2Flyout = webDriver.findElements(By.cssSelector(".nav-menu-item.open li a"));

				WebElement menuLink = l2Flyout.stream()
						.filter(s -> s.getText().toLowerCase().equals(l2MenuTitle.toLowerCase())).findFirst().get();
				context.saveData("menu-href", menuLink.getAttribute("href"));
				((JavascriptExecutor) webDriver)
						.executeScript("window.open('" + menuLink.getAttribute("href") + "', '-blank')");

				String winHandleBefore = webDriver.getWindowHandle();
				for (String winHandle : webDriver.getWindowHandles()) {
					webDriver.switchTo().window(winHandle);
				}
				pageUtils.sleepSeconds(5, "");
				String pageTitle = webDriver.getTitle();
				if (!pageTitle.isBlank() || !pageTitle.isEmpty() || !pageUtils.verifyIfDisplayed(errorPage)) {
					context.writeOut("L2 Category Name is: " + l2MenuTitle + " || Page title is: " + pageTitle);
				} 
				pageUtils.sleepSeconds(5, "");
				webDriver.close();
				webDriver.switchTo().window(winHandleBefore);
				pageUtils.sleepSeconds(5, "");
				//menuLink.click();
				pageUtils.waitForAjaxToComplete();
			} catch (Exception e) {
				System.out.println();
			}
		}

		public void clickMenu(String l2MenuTitle, String l3MenuTitle) {
			try {
				clickL2Menu(l2MenuTitle);

			List<WebElement> l3Menus = webDriver.findElements(By.cssSelector(".nav-menu-item.open li a"));
			WebElement l3menu = l3Menus.stream()
					.filter(s -> s.getText().toLowerCase().equals(l3MenuTitle.toLowerCase())).findFirst().get();
			context.saveData("menu-href", l3menu.getAttribute("href"));
			((JavascriptExecutor) webDriver)
					.executeScript("window.open('" + l3menu.getAttribute("href") + "', '-blank')");

			String winHandleBefore = webDriver.getWindowHandle();
			for (String winHandle : webDriver.getWindowHandles()) {
				webDriver.switchTo().window(winHandle);
			}
			pageUtils.sleepSeconds(5, "");
			String pageTitle = webDriver.getTitle();
			if (!pageTitle.isBlank() || !pageTitle.isEmpty() || !pageUtils.verifyIfDisplayed(errorPage)) {
				context.writeOut("L3 Category Name is: " + l3MenuTitle + " || Page title is: " + pageTitle);
			}
			pageUtils.sleepSeconds(5, "");
			webDriver.close();
			webDriver.switchTo().window(winHandleBefore);
			pageUtils.sleepSeconds(5, "");
			//l3menu.click();
			pageUtils.waitForAjaxToComplete();
			pageUtils.waitForPageToLoad();
			} catch (Exception e) {
				System.out.println();
			}
		}
	}

}
