package com.mk.testframework.dt.header;

import java.io.IOException;
import java.util.Currency;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.core.env.Environment.Region;
import com.mk.testframework.core.exceptions.TestEnvironmentException;
import com.mk.testframework.core.exceptions.TestException;
import com.mk.testframework.dt.mobile.MkMobileHamburgerMenu;
import com.mk.testframework.dt.util.ExcelUtils;
import com.mk.testframework.dt.util.MkPageNavigator;
import com.mk.testframework.dt.util.ModalUtils;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.dt.util.PageUtils.Resource;

import io.cucumber.datatable.DataTable;

/**
 * @author VThipperudrappa
 *
 */

public class MkHamburgerMenu {

	//private final Logger log = LoggerFactory.getLogger(getClass());

	@FindBy(css = ".search-link")
	private WebElement searchLink;

	@FindBy(css = ".mk-sign-in .header-my-account a")
	private WebElement signInLink;
	
	@FindBy(css = ".mk-sign-in .header-my-account button")
	private WebElement signInLink2;

	@FindBy(css = ".utility-sub-section .mk-join a")
	private WebElement signUpLink;

	@FindBy(css = ".my-account .header-my-account a")
	private WebElement myAccountLink;
	
	@FindBy(css = ".my-account .header-my-account button")
	private WebElement myAccountLink2;

	@FindBy(css = ".countrySelector")
	private WebElement countrySelector;

	@FindBy(css = ".store-locator")
	private WebElement storeLocatorLink;

	@FindBy(css = ".mklogo img")
	private WebElement mkLogo;

	@FindBy(css = ".header-cart span")
	private WebElement shoppingBagIcon;

	@FindBy(css = ".main-nav-menu .l1flyout")
	private List<WebElement> l1Flyout;

	@FindBy(css = ".header-my-account")
	private WebElement headerAccountLink;

	@FindBy(css = ".cart-counter")
	private WebElement populatedBagCounter;

	@FindBy(css = ".utility-nav li a")
	private List<WebElement> userLinks;

	@FindBy(css = ".store-locator a .icon")
	private WebElement storeLocatorIcon;

	@FindBy(css = ".header-my-account a .icon")
	private WebElement userIcon;

	@FindBy(css = ".language-selected .countrySelector .countrySelector__svg")
	private WebElement countryFlagSvg;

	@FindBy(css = ".language-selected .countrySelector .countrySelected")
	private WebElement countrySelectedSpan;

	@FindBy(css = ".hamburger button")
	private WebElement hamburgerButton;

	@FindBy(css = ".mob-menu-expanded")
	private WebElement hamburgerMenuExpanded;

	@FindBy(css = ".mk-store-locator span")
	private WebElement footerStoreLocatorLink;
	
	@FindBy(id = "errorPageContainer")
	private WebElement errorPage;
	
	@FindBy(css = ".promo-wrapper")
	private WebElement mkPPH;
	
	@FindBy(css = ".countrySelected")
	private WebElement selectedCountryCurrency;
	
	private Actions actionBuilder;
	private WebDriver webDriver;
	private PageUtils pageUtils;
	private Context context;
	private JavascriptExecutor jsExecutor;
	private Environment env;
	private MkPageNavigator mkPageNavigator;
	private MkMobileHamburgerMenu mkMobileHamburgerMenu;
	private ExcelUtils excelUtils;
	private ModalUtils modalUtils;
	@Inject
	public MkHamburgerMenu(WebDriver webDriver, PageUtils pageUtils, Context context, Environment env, MkPageNavigator mkPageNavigator, MkMobileHamburgerMenu mkMobileHamburgerMenu, ExcelUtils excelUtils, ModalUtils modalUtils) {
		PageFactory.initElements(webDriver, this);
		this.actionBuilder = new Actions(webDriver);
		this.webDriver = webDriver;
		this.pageUtils = pageUtils;
		this.context = context;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.env = env;
		this.mkPageNavigator = mkPageNavigator;
		this.mkMobileHamburgerMenu = mkMobileHamburgerMenu;
		this.excelUtils = excelUtils;
		this.modalUtils = modalUtils;
	}

	public void clickSearchLink() {
		try {
			pageUtils.waitForWebElement(searchLink);
			// searchLink.click();
			jsExecutor.executeScript("arguments[0].click();", searchLink);
		} catch (Exception e) {
			pageUtils.refresh();
			pageUtils.waitForWebElement(searchLink);
			// searchLink.click();
			jsExecutor.executeScript("arguments[0].click();", searchLink);
		}
	}

	public void clickSignInLink() {
		try {
			pageUtils.waitForWebElement(signInLink);
			jsExecutor.executeScript("arguments[0].click();", signInLink);
			pageUtils.waitForPageToLoad();
		} catch (Exception e) {
			pageUtils.waitForWebElement(signInLink2);
			jsExecutor.executeScript("arguments[0].click();", signInLink2);
			pageUtils.waitForPageToLoad();
		}
	}

	public void clickSignUpLink() {
		pageUtils.waitForWebElement(signUpLink);
		jsExecutor.executeScript("arguments[0].click();", signUpLink);
		pageUtils.waitForPageToLoad();
	}

	public void clickCountrySelector() {
		countrySelector.click();
		pageUtils.waitForPageToLoad();
	}

	public void clickStoreLocator() {
		jsExecutor.executeScript("arguments[0].click();", footerStoreLocatorLink);
		pageUtils.sleepSeconds(1, "page load");
		pageUtils.waitForPageToLoad();
	}

	public int getBagCount() {
		String bagCount = "0";
		if (shoppingBagHasItems()) {
			pageUtils.sleepSeconds(3, "page load");
			pageUtils.waitForPageToLoad();
			pageUtils.waitForWebElement(populatedBagCounter);
			bagCount = populatedBagCounter.getText().replaceAll("[^0-9,]", "");
		}
		return Integer.parseInt(bagCount);
	}

	public boolean isMkLogoPresent() {
		pageUtils.waitForPageToLoad();
		return pageUtils.verifyIfDisplayed(mkLogo);
	}

	public void clickMkLogo() {
		jsExecutor.executeScript("arguments[0].click();", mkLogo);
	}

	public void clickMenu(String menuTitle) {
		pageUtils.waitForAjaxToComplete();
		String translatedMenuTitle = getTranslation(menuTitle);
		WebElement menuLink = l1Flyout.stream()
				.filter(s -> s.getText().toLowerCase().equals(translatedMenuTitle.toLowerCase())).findFirst().get();
		this.context.saveData("menu-href", menuLink.getAttribute("href"));
		jsExecutor.executeScript("arguments[0].click();", menuLink);
		pageUtils.waitForAjaxToComplete();
	}

	public void clickMenu(String submenuTitle, String menuTitle) {
		pageUtils.waitForAjaxToComplete();
		String translatedMenuTitle = getTranslation(menuTitle);
		WebElement l1MenuElement = l1Flyout.stream()
						
				.filter(s -> s.getText().toLowerCase().equals(translatedMenuTitle.toLowerCase())).findFirst().get();
		actionBuilder.moveToElement(l1MenuElement).build().perform();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "1 sec wait for ajax load");
		new FlyoutMenu().clickMenu(getTranslation(menuTitle + "." + submenuTitle));
	}

	public void clickMenu(String subsubmenuTitle, String submenuTitle, String menuTitle) {
		pageUtils.waitForAjaxToComplete();
		String translatedMenuTitle = getTranslation(menuTitle);
		WebElement l1MenuElement = l1Flyout.stream()
				.filter(s -> s.getText().toLowerCase().equals(translatedMenuTitle.toLowerCase())).findFirst().get();
		actionBuilder.moveToElement(l1MenuElement).build().perform();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "1 sec wait for ajax load");
		new FlyoutMenu().clickMenu(getTranslation(menuTitle + "." + submenuTitle),
				getTranslation(menuTitle + "." + submenuTitle + "." + subsubmenuTitle));
	}

	public void clickRandomL2Menu() {
		WebElement l1MenuElement = l1Flyout.get(new Random().nextInt(l1Flyout.size()));
		context.writeOut("Hovering over menu : " + l1MenuElement.getText());
		actionBuilder.moveToElement(l1MenuElement).build().perform();
		pageUtils.sleepSeconds(1, "For the page to load");
		new FlyoutMenu().clickMenuRandomL2Menu();
	}

	public void clickRandomL3Menu() {
		List<String> excludes;
		if (env.getCountryRegion().equals(Region.NA)) {
			excludes = Lists.newArrayList(getTranslation("HANDBAGS"), getTranslation("SHOES"), getTranslation("SALE"),
					getTranslation("COLLECTION"), getTranslation("WALLETS"), getTranslation("GIFTS"));
		} else {
			excludes = Lists.newArrayList(getTranslation("HANDBAGS"), getTranslation("SHOES"), getTranslation("SALE"));
		}
		List<WebElement> filteredL1Flyout = l1Flyout.stream().filter(s -> !excludes.contains(s.getText()))
				.collect(Collectors.toList());
		WebElement l1MenuElement = filteredL1Flyout.get(new Random().nextInt(filteredL1Flyout.size()));
		context.writeOut("Hovering over menu : " + l1MenuElement.getText());
		actionBuilder.moveToElement(l1MenuElement).build().perform();
		pageUtils.sleepSeconds(1, "For the page to load");
		new FlyoutMenu().clickMenuRandomL3Menu();
	}

	public void clickTrendsMenuInNewTab(String submenuTitle, String menuTitle) {
		String translatedMenuTitle = getTranslation(menuTitle);
		WebElement l1MenuElement = l1Flyout.stream()
				.filter(s -> s.getText().toLowerCase().equals(translatedMenuTitle.toLowerCase())).findFirst().get();
		actionBuilder.moveToElement(l1MenuElement).build().perform();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "1 sec wait for ajax load");
		new FlyoutMenu().clickTrendsMenuInNewTab(getTranslation(menuTitle + "." + submenuTitle));
	}

	public void clickTrendsMenu(String submenuTitle, String menuTitle) {
		
		pageUtils.waitForAjaxToComplete();
		
		String translatedMenuTitle = getTranslation(menuTitle);
		WebElement l1MenuElement = l1Flyout.stream()
				.filter(s -> s.getText().toLowerCase().equals(translatedMenuTitle.toLowerCase())).findFirst().get();
		actionBuilder.moveToElement(l1MenuElement).build().perform();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "1 sec wait for ajax load");
		new FlyoutMenu().clickTrendsMenu(getTranslation(menuTitle + "." + submenuTitle));
	}

	private String getTranslation(String menu) {
		ResourceBundle menuResource = pageUtils.getResourceBundle(Resource.MENU);
		return menuResource.getString(pageUtils.buildResourceLookupKey(menu));
	}

	public String translateMenuTitle(String menu) {
		return getTranslation(menu);
	}

	public class FlyoutMenu {
		public void clickMenuRandomL2Menu() {
			List<WebElement> l2Flyout = webDriver
					.findElements(By.cssSelector(".nav-menu-item.flyout-container.active .menu-link.l2flyout"));
			List<WebElement> l2FlyoutDisplayed = l2Flyout.stream().filter(s -> s.isDisplayed())
					.collect(Collectors.toList());
			WebElement menu;
			try {
				menu = l2FlyoutDisplayed.get(new Random().nextInt(l2FlyoutDisplayed.size()));
			} catch (IllegalArgumentException e) {
				throw new TestException(e.getMessage());
			}
			context.writeOut("Clicking menu : " + menu.getText());
			jsExecutor.executeScript("arguments[0].click();", menu);
			pageUtils.sleepSeconds(2, "For the page to load");
			pageUtils.waitForPageToLoad();
		}

		public void clickMenuRandomL3Menu() {
			List<WebElement> l3Links = webDriver.findElements(By.cssSelector(
					".nav-menu-item.flyout-container.active .flyout-subcontainer .columns.link-container .inner-container > li .l3flyout"));
			List<WebElement> l3LinksDisplayed = l3Links.stream().filter(s -> s.isDisplayed())
					.collect(Collectors.toList());
			if (l3LinksDisplayed.size() == 0) {
				throw new TestException("There are no l3 menus here");
			}
			WebElement menuLink;
			try {
				menuLink = l3LinksDisplayed.get(new Random().nextInt(l3LinksDisplayed.size()));
			} catch (IllegalArgumentException e) {
				throw new TestException(e.getMessage());
			}
			context.writeOut("Clicking menu : " + menuLink.getText());
			jsExecutor.executeScript("arguments[0].click();", menuLink);
			pageUtils.sleepSeconds(5, "For the page to load");
			pageUtils.waitForPageToLoad();
		}

		public void clickMenu(String l2MenuTitle) {
			pageUtils.waitForAjaxToComplete();
			List<WebElement> l2Flyout = webDriver
					.findElements(By.cssSelector(".nav-menu-item.flyout-container.active .menu-link.l2flyout"));
			WebElement menuLink = l2Flyout.stream()
					.filter(s -> s.getText().toLowerCase().equals(l2MenuTitle.toLowerCase())).findFirst().get();
			context.saveData("menu-href", menuLink.getAttribute("href"));
			jsExecutor.executeScript("arguments[0].click();", menuLink);
			pageUtils.waitForPageToLoad();
		}

		public void clickMenu(String l2MenuTitle, String l3MenuTitle) {
			List<WebElement> l3SectionActiveList = webDriver.findElements(By.cssSelector(
					".nav-menu-item.flyout-container.active .flyout-subcontainer .columns.link-container > li"));
			WebElement l3Section = l3SectionActiveList.stream().filter(s -> s.findElement(By.cssSelector(".l2flyout"))
					.getText().toLowerCase().equals(l2MenuTitle.toLowerCase())).findFirst().get();
			List<WebElement> l3Links = l3Section.findElements(By.cssSelector(".l3flyout"));
			WebElement menuLink = l3Links.stream()
					.filter(p -> p.getText().toLowerCase().equals(l3MenuTitle.toLowerCase())).findFirst().get();
			if (menuLink.getTagName().equals("span")) {
				menuLink = menuLink.findElement(By.cssSelector("a"));
			}
			context.saveData("menu-href", menuLink.getAttribute("href"));
			jsExecutor.executeScript("arguments[0].click();", menuLink);
			pageUtils.waitForPageToLoad();
		}

		public void clickTrendsMenu(String trendMenuTitle) {
			List<WebElement> trendsLinks = webDriver.findElements(By.cssSelector(
					".nav-menu-item.flyout-container.active .flyout-subcontainer .columns.content-container .inner-container a"));
			WebElement menuLink = trendsLinks.stream()
					.filter(s -> s.getText().toLowerCase().equals(trendMenuTitle.toLowerCase())).findFirst().get();
			context.saveData("menu-href", menuLink.getAttribute("href"));
			jsExecutor.executeScript("arguments[0].click();", menuLink);
			pageUtils.waitForPageToLoad();
		}

		public void clickTrendsMenuInNewTab(String trendMenuTitle) {
			List<WebElement> trendsLinks = webDriver.findElements(By.cssSelector(
					".nav-menu-item.flyout-container.active .flyout-subcontainer .columns.content-container .inner-container a"));
			WebElement menuLink = trendsLinks.stream()
					.filter(s -> s.getText().toLowerCase().equals(trendMenuTitle.toLowerCase())).findFirst().get();
			context.saveData("menu-href", menuLink.getAttribute("href"));
			((JavascriptExecutor) webDriver)
					.executeScript("window.open('" + menuLink.getAttribute("href") + "', '-blank')");
			List<String> handles = Lists.newArrayList(webDriver.getWindowHandles());
			webDriver.switchTo().window(handles.get(1));
			pageUtils.sleepSeconds(1, "waiting for tab load");
			pageUtils.waitForPageToLoad();
		}
	}

	public void clickShoppingBagIcon() {
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", shoppingBagIcon);
		pageUtils.sleepSeconds(5, "wait for page load");
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}

	public boolean signInLinkIsPresent() {
		boolean linkPresent = pageUtils.waitForWebElement(signInLink) || pageUtils.waitForWebElement(signInLink);
		try {
			if (!linkPresent) {
				context.writeOut("Retrying check for signInLink link");
				pageUtils.refresh();
				return signInLink2.isDisplayed() || signInLink2.isEnabled();
			}
		} catch (Exception e) {
			linkPresent = pageUtils.waitForWebElement(signInLink2);
			if (!linkPresent) {
				context.writeOut("Retrying check for signInLink link");
				pageUtils.refresh();
				return signInLink2.isDisplayed() || signInLink2.isEnabled();
			}
		}
		return linkPresent;
	}

	public boolean myAccountLinkIsPresent() {
		boolean linkPresent = false;
		try {
			pageUtils.waitForWebElement(myAccountLink);
			pageUtils.sleepSeconds(1, "wait for page load");
			linkPresent = pageUtils.verifyIfDisplayed(myAccountLink);
			if (!linkPresent) {
				context.writeOut("Retrying check for my accounts link");
				pageUtils.refresh();
				pageUtils.waitForWebElement(myAccountLink);
				return pageUtils.verifyIfDisplayed(myAccountLink);
			}
		} catch (ElementClickInterceptedException e) {
			pageUtils.waitForWebElement(myAccountLink);
			pageUtils.waitTillWebElementIsVisible(myAccountLink, 10);
			pageUtils.sleepSeconds(1, "wait for page load");
			linkPresent = pageUtils.verifyIfDisplayed(myAccountLink);
		} catch (ElementNotInteractableException e) {
			pageUtils.waitForWebElement(myAccountLink);
			pageUtils.waitTillWebElementIsVisible(myAccountLink, 10);
			pageUtils.sleepSeconds(1, "wait for page load");
			linkPresent = pageUtils.verifyIfDisplayed(myAccountLink);
		}
		return linkPresent;
	}

	public boolean shoppingBagHasItems() {
		boolean flag = false;
		pageUtils.waitForPageToLoad();
		try {
			if (populatedBagCounter.isDisplayed() || populatedBagCounter.isEnabled()) {
				flag = true;
			}
		} catch (Exception e) {
			flag =false;
		}
		return flag;
	}

	public List<String> getUserLinks() {
		List<String> links = Lists.newArrayList();
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

	public boolean isMagnifyingGlassIconDisplayed() {
		return pageUtils.verifyIfDisplayed(searchLink);
	}

	public boolean isShoppingBagIconDisplayed() {
		return pageUtils.verifyIfDisplayed(shoppingBagIcon);
	}

	public boolean isStoreLocatorIconDisplayed() {
		return pageUtils.verifyIfDisplayed(storeLocatorIcon);
	}

	public boolean isUserIconDisplayed() {
		return pageUtils.verifyIfDisplayed(userIcon);
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
		hamburgerButton.click();
	}

	public boolean isHamburgerMenuOpen() {
		return pageUtils.verifyIfDisplayed(hamburgerMenuExpanded);
	}

	public void openHamburgerMenuIfNotOpen() {
		if (!isHamburgerMenuOpen()) {
			clickHamburgerButton();
		}
	}

	public void clickMyAccountIcon() {
		try {
			pageUtils.waitForPageToLoad();
			pageUtils.sleepSeconds(5, "wait for page load");
			((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", myAccountLink);
			pageUtils.sleepSeconds(5, "wait for page load");
			pageUtils.waitForPageToLoad();
		} catch (Exception e) {
			try {
				pageUtils.waitForPageToLoad();
				pageUtils.sleepSeconds(5, "wait for page load");
				((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", myAccountLink2);
				pageUtils.sleepSeconds(5, "wait for page load");
				pageUtils.waitForPageToLoad();
			} catch (Exception e2) {
				pageUtils.waitForPageToLoad();
				pageUtils.sleepSeconds(5, "wait for page load");
				((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", myAccountLink);
				pageUtils.sleepSeconds(5, "wait for page load");
				pageUtils.waitForPageToLoad();
			}
		}
	}
	
	public void clickOnL2CategoryAndVerifyPageTitle(String cat1, String menus1) {
		boolean flag = false;
		String cat ="";
		String menus="";
		pageUtils.waitForPageToLoad();

	    int size = l1Flyout.size();
	    for(WebElement l1menu:l1Flyout) {
	    	context.writeOut("Hovering over menu : " + l1menu.getText());
			actionBuilder.moveToElement(l1menu).build().perform();
	    	List<WebElement> l2Flyout = webDriver
					.findElements(By.cssSelector(".nav-menu-item.flyout-container.active .menu-link.l2flyout"));
			List<WebElement> l2FlyoutDisplayed = l2Flyout.stream().filter(s -> s.isDisplayed())
					.collect(Collectors.toList());
			WebElement menu;
			try {
				menu = l2FlyoutDisplayed.get(new Random().nextInt(l2FlyoutDisplayed.size()));
				for(WebElement l2menu:l2FlyoutDisplayed) {
					context.writeOut("Clicking on the L2 menu: "+l2menu);
					cat=l2menu.getText();
					String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
					l2menu.sendKeys(selectLinkOpeninNewTab);
					String winHandleBefore = webDriver.getWindowHandle();
					for(String winHandle : webDriver.getWindowHandles()){
						webDriver.switchTo().window(winHandle);
					}
					pageUtils.sleepSeconds(5, "");
					String urlOfPage=webDriver.getCurrentUrl();
					String pageTitle = webDriver.getTitle();
					context.writeOut(" Category Name is: "+cat+" || Page title is: "+pageTitle);
					if(!pageTitle.isBlank() || !pageTitle.isEmpty() || !pageUtils.verifyIfDisplayed(errorPage)) {
						flag = true;
					}
					pageUtils.sleepSeconds(5, "");
					webDriver.close();
					webDriver.switchTo().window(winHandleBefore);
				}
			} catch (IllegalArgumentException e) {
				throw new TestException(e.getMessage());
			}

	    }
		
	}
	
	public boolean clickOnL2CategoryAndVerifyPageTitle() {
		boolean flag = true;
		String cat = "";
		pageUtils.waitForPageToLoad();
		List<WebElement> l1FlyoutDisplayed = l1Flyout.stream().filter(s -> s.isDisplayed())
				.collect(Collectors.toList());
		for (WebElement l1menu : l1FlyoutDisplayed) {
			context.writeOut("Hovering over menu : " + l1menu.getText());
			pageUtils.sleepSeconds(5, "");
			actionBuilder.moveToElement(l1menu).build().perform();
			pageUtils.sleepSeconds(5, "");
			actionBuilder.moveToElement(l1FlyoutDisplayed.get(new Random().nextInt(l1FlyoutDisplayed.size()))).build().perform();
			pageUtils.sleepSeconds(5, "");
			actionBuilder.moveToElement(l1menu).build().perform();
			List<WebElement> l2Flyout = webDriver
					.findElements(By.cssSelector(".nav-menu-item.flyout-container.active .menu-link.l2flyout"));
			List<WebElement> l2FlyoutDisplayed = l2Flyout.stream().filter(s -> s.isDisplayed())
					.collect(Collectors.toList());
			try {
				for (WebElement l2menu : l2FlyoutDisplayed) {
					cat = l2menu.getText();
					context.writeOut("Clicking on the L2 menu: " + l2menu.getText());
					((JavascriptExecutor) webDriver)
							.executeScript("window.open('" + l2menu.getAttribute("href") + "', '-blank')");
					String winHandleBefore = webDriver.getWindowHandle();
					for (String winHandle : webDriver.getWindowHandles()) {
						webDriver.switchTo().window(winHandle);
					}
					pageUtils.sleepSeconds(5, "");
					String pageTitle = webDriver.getTitle();
					if (!pageTitle.isBlank() || !pageTitle.isEmpty() || !pageUtils.verifyIfDisplayed(errorPage)) {
						context.writeOut("L2 Category Name is: " + cat + " || Page title is: " + pageTitle);
					} else {
						flag = false;
					}
					pageUtils.sleepSeconds(5, "");
					webDriver.close();
					webDriver.switchTo().window(winHandleBefore);
				}
			} catch (IllegalArgumentException e) {
				throw new TestException(e.getMessage());
			}

		}
		return flag;
	}
	
	
	
	public boolean clickOnL2CategoryAndVerifyPageTitleMobile() {
		boolean flag = true;
		String categoryName = "";
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		List<WebElement> l1FlyoutDisplayed = l1Flyout.stream().filter(s -> s.isDisplayed())
				.collect(Collectors.toList());
		int size = l1FlyoutDisplayed.size();
		for (int i = 0; i < size; i++) {
			context.writeOut("Clicking on the L1 menu: " + l1FlyoutDisplayed.get(i).getText());
			mkMobileHamburgerMenu.clickL1Menu(l1FlyoutDisplayed.get(i).getText().trim());
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(5, "");
			List<WebElement> l2Flyout = webDriver
					.findElements(By.cssSelector(".nav-menu-item.flyout-container.open .menu-link.l2flyout"));
			List<WebElement> l2FlyoutDisplayed = l2Flyout.stream().filter(s -> s.isDisplayed())
					.collect(Collectors.toList());
			try {
				for (WebElement l2menu : l2FlyoutDisplayed) {
					categoryName = l2menu.getText();
					context.writeOut("Clicking on the L2 menu: " + l2menu.getText());
					((JavascriptExecutor) webDriver)
							.executeScript("window.open('" + l2menu.getAttribute("href") + "', '-blank')");
					String winHandleBefore = webDriver.getWindowHandle();
					for (String winHandle : webDriver.getWindowHandles()) {
						webDriver.switchTo().window(winHandle);
					}
					pageUtils.sleepSeconds(5, "");
					String pageTitle = webDriver.getTitle();
					if (!pageTitle.isBlank() || !pageTitle.isEmpty() || !pageUtils.verifyIfDisplayed(errorPage)) {
						context.writeOut("L2 Category Name is: " + categoryName + " || Page title is: " + pageTitle);
					} else {
						flag = true;
					}
					pageUtils.sleepSeconds(5, "");
					webDriver.close();
					webDriver.switchTo().window(winHandleBefore);
				}
			} catch (Exception e) {
				throw new TestException(e.getMessage());
			}
			jsExecutor.executeScript("arguments[0].click();", webDriver.findElement(By.xpath("//*[@class ='menu-link main-menu']")));
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(5, "");
			l1FlyoutDisplayed = l1Flyout.stream().filter(s -> s.isDisplayed())
					.collect(Collectors.toList());
		}
		return flag;
	}
	
	public boolean clickOnL1CategoryAndVerifyPageTitle() {
		boolean flag = true;
		List<WebElement> l1FlyoutDisplayed = l1Flyout.stream().filter(s -> s.isDisplayed())
				.collect(Collectors.toList());
		for (WebElement l1menu : l1FlyoutDisplayed) {
			String categoryName = l1menu.getText();
			context.writeOut(categoryName);
			((JavascriptExecutor) webDriver)
			.executeScript("window.open('" + l1menu.getAttribute("href") + "', '-blank')");
			String winHandleBefore = webDriver.getWindowHandle();
			for (String winHandle : webDriver.getWindowHandles()) {
				webDriver.switchTo().window(winHandle);
			}
			pageUtils.sleepSeconds(5, "");
			String pageTitle = webDriver.getTitle();
			if (!pageTitle.isBlank() || !pageTitle.isEmpty()) {
				context.writeOut("L1 Category Name is: " + categoryName + " || Page title is: " + pageTitle);
			} else {
				flag = true;
			}
			pageUtils.sleepSeconds(5, "");
			webDriver.close();
			webDriver.switchTo().window(winHandleBefore);
		}

		return flag;
	}
	
	public boolean clickOnL1CategoryAndVerifyPageTitleMobile() {
		boolean flag = true;
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		List<WebElement> l1FlyoutDisplayed = l1Flyout.stream().filter(s -> s.isDisplayed())
				.collect(Collectors.toList());
		int size = l1FlyoutDisplayed.size();
		String categoryName ="";
		for (int i = 0; i < size; i++) {
			categoryName = l1FlyoutDisplayed.get(i).getText();
			mkMobileHamburgerMenu.clickL1Menu(l1FlyoutDisplayed.get(i).getText().trim());
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(5, "");
			String pageTitle = webDriver.getTitle();
			if (!pageTitle.isBlank() || !pageTitle.isEmpty()) {
				context.writeOut("L1 Category Name is: " + categoryName + " || Page title is: " + pageTitle);
			} else {
				flag = true;
			}
			jsExecutor.executeScript("arguments[0].click();", webDriver.findElement(By.xpath("//*[@class ='menu-link main-menu']")));
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(2, "");
			size = l1FlyoutDisplayed.size();
			l1FlyoutDisplayed = l1Flyout.stream().filter(s -> s.isDisplayed())
					.collect(Collectors.toList());
			System.out.println();
		}
		return flag;
	}
	
	public boolean clickOnL3CategoryAndVerifyPageTitle() {
		boolean flag = true;
		String cat = "";
		pageUtils.waitForPageToLoad();
		List<WebElement> l1FlyoutDisplayed = l1Flyout.stream().filter(s -> s.isDisplayed())
				.collect(Collectors.toList());
		for (WebElement l1menu : l1FlyoutDisplayed) {
			actionBuilder.moveToElement(l1menu).build().perform();
			context.writeOut("Hovering over menu : " + l1menu.getText());
			pageUtils.sleepSeconds(2, "");
			actionBuilder.moveToElement(l1FlyoutDisplayed.get(new Random().nextInt(l1FlyoutDisplayed.size()))).build().perform();
			pageUtils.sleepSeconds(2, "");
			actionBuilder.moveToElement(l1menu).build().perform();

			List<WebElement> l3Links = webDriver.findElements(By.cssSelector(
					".nav-menu-item.flyout-container.active .flyout-subcontainer .columns.link-container .inner-container > li .l3flyout"));
			List<WebElement> l3LinksDisplayed = l3Links.stream().filter(s -> s.isDisplayed())
					.collect(Collectors.toList());
			try {
				for (WebElement l3menu : l3LinksDisplayed) {
					cat = l3menu.getText();
					context.writeOut("Clicking on the L3 menu: " + cat);
					((JavascriptExecutor) webDriver)
							.executeScript("window.open('" + l3menu.getAttribute("href") + "', '-blank')");

					String winHandleBefore = webDriver.getWindowHandle();
					for (String winHandle : webDriver.getWindowHandles()) {
						webDriver.switchTo().window(winHandle);
					}
					pageUtils.sleepSeconds(5, "");
					String pageTitle = webDriver.getTitle();
					if (!pageTitle.isBlank() || !pageTitle.isEmpty() || !pageUtils.verifyIfDisplayed(errorPage)) {
						context.writeOut("L3 Category Name is: " + cat + " || Page title is: " + pageTitle);
					} else {
						flag = true;
					}
					pageUtils.sleepSeconds(5, "");
					webDriver.close();
					webDriver.switchTo().window(winHandleBefore);
				}
			} catch (IllegalArgumentException e) {
				throw new TestException(e.getMessage());
			}

		}
		return flag;
	}
	
	public boolean clickOnL3CategoryAndVerifyPageTitleMobile() {
		boolean flag = true;
		String cat = "";
		mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
		List<WebElement> l1FlyoutDisplayed = l1Flyout.stream().filter(s -> s.isDisplayed())
				.collect(Collectors.toList());
		int size = l1FlyoutDisplayed.size();
		for (int i = 1; i < size; i++) {
			String l1MenuTxt = l1FlyoutDisplayed.get(i).getText();
			context.writeOut("Clicking on the L1 menu: " + l1MenuTxt);
			try {
				mkMobileHamburgerMenu.clickL1Menu(l1MenuTxt);
			} catch (Exception e) {
				pageUtils.sleepSeconds(5, "");
				mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
				l1MenuTxt = l1Flyout.get(i).getText();
				context.writeOut("Clicking on the L1 menu: " + l1MenuTxt);
				pageUtils.sleepSeconds(5, "");
				mkMobileHamburgerMenu.clickL1Menu(l1MenuTxt);
			}
			
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(2, "");	
			List<WebElement> l2Flyout = webDriver
					.findElements(By.cssSelector(".nav-menu-item.flyout-container.open .menu-link.l2flyout"));
			List<WebElement> l2FlyoutDisplayed = l2Flyout.stream().filter(s -> s.isDisplayed())
					.collect(Collectors.toList());
			int size1 = l2FlyoutDisplayed.size();
			try {
				for (int j = 0; j < size1; j++) {
					String l2Txt= l2FlyoutDisplayed.get(j).getText();
					jsExecutor.executeScript("arguments[0].click();", webDriver.findElement(By.xpath("//*[@class ='menu-link main-menu']")));
					pageUtils.waitForPageToLoad();
					pageUtils.waitForAjaxToComplete();
					pageUtils.sleepSeconds(2, "");
					context.writeOut("Clicking on the L2 menu: " + l2Txt);
					mkMobileHamburgerMenu.clickL2Menu(l2Txt,l1MenuTxt);
					pageUtils.waitForPageToLoad();
					pageUtils.waitForAjaxToComplete();
					pageUtils.sleepSeconds(2, "");
					try {
					List<WebElement> l3Links = webDriver.findElements(By.cssSelector(
							".nav-menu-item.flyout-container.open .flyout-subcontainer .columns.link-container .inner-container > li .l3flyout"));
					List<WebElement> l3LinksDisplayed = l3Links.stream().filter(s -> s.isDisplayed())
							.collect(Collectors.toList());
					for (WebElement l3menu : l3LinksDisplayed) {
						cat = l3menu.getText();
						context.writeOut("Clicking on the L3 menu: " + cat);
						((JavascriptExecutor) webDriver)
								.executeScript("window.open('" + l3menu.getAttribute("href") + "', '-blank')");
						String winHandleBefore = webDriver.getWindowHandle();
						for (String winHandle : webDriver.getWindowHandles()) {
							webDriver.switchTo().window(winHandle);
						}
						pageUtils.sleepSeconds(5, "");
						String pageTitle = webDriver.getTitle();
						if (!pageTitle.isBlank() || !pageTitle.isEmpty() || !pageUtils.verifyIfDisplayed(errorPage)) {
							context.writeOut("L3 Category Name is: " + cat + " || Page title is: " + pageTitle);
						} else {
							flag = false;
						}
						pageUtils.sleepSeconds(2, "");
						webDriver.close();
						webDriver.switchTo().window(winHandleBefore);
					}
					}catch(Exception e) {
						System.out.println("This is not L3 category");
						mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
						pageUtils.sleepSeconds(5, "");
						l1FlyoutDisplayed = l1Flyout.stream().filter(s -> s.isDisplayed())
								.collect(Collectors.toList());
						mkMobileHamburgerMenu.clickL1Menu(l1MenuTxt);
					}
					jsExecutor.executeScript("arguments[0].click();", webDriver.findElement(By.xpath("//*[@class ='menu-link back']")));
					pageUtils.waitForPageToLoad();
					pageUtils.waitForAjaxToComplete();
					pageUtils.sleepSeconds(5, "");
					l2Flyout = webDriver
							.findElements(By.cssSelector(".nav-menu-item.flyout-container.open .menu-link.l2flyout"));
					l2FlyoutDisplayed = l2Flyout.stream().filter(s -> s.isDisplayed())
							.collect(Collectors.toList());
				}
			} catch (Exception e) {
				System.out.println("This is not L3 category");
				mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
				mkMobileHamburgerMenu.clickL1Menu(l1MenuTxt);
			}
				jsExecutor.executeScript("arguments[0].click();", webDriver.findElement(By.xpath("//*[@class ='menu-link main-menu']")));
				pageUtils.waitForPageToLoad();
				pageUtils.waitForAjaxToComplete();
				pageUtils.sleepSeconds(5, "");
				l1FlyoutDisplayed = l1Flyout.stream().filter(s -> s.isDisplayed())
						.collect(Collectors.toList());
		}
		return flag;
	}
	
	public boolean clickOnL2CategoryAndVerifyPageTitleNA(DataTable menuList) {
		List<List<String>> data = menuList.asLists();

		boolean flag = true;
		String cat = "";
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		for(int i=0; i<data.size();i++) {
			String menuitem=data.get(i).toString().trim();
			System.out.println(menuitem.replaceAll("\\[", "").replaceAll("\\]", "").trim().toLowerCase());
		String translatedMenuTitle = getTranslation(menuitem.replaceAll("\\[", "").replaceAll("\\]", "").trim().toLowerCase());
		WebElement l1MenuElement = l1Flyout.stream()
						
				.filter(s -> s.getText().toLowerCase().equals(translatedMenuTitle.toLowerCase())).findFirst().get();
		actionBuilder.moveToElement(l1MenuElement).build().perform();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(5, "");

		List<WebElement> l2Flyout = webDriver
					.findElements(By.cssSelector(".nav-menu-item.flyout-container.active .menu-link.l2flyout"));
		List<WebElement> l2FlyoutDisplayed = l2Flyout.stream().filter(s -> s.isDisplayed())
					.collect(Collectors.toList());
			try {
				for (WebElement l2menu : l2FlyoutDisplayed) {
					cat = l2menu.getText();
					context.writeOut("Clicking on the L2 menu: " + l2menu.getText());
					((JavascriptExecutor) webDriver)
							.executeScript("window.open('" + l2menu.getAttribute("href") + "', '-blank')");
					String winHandleBefore = webDriver.getWindowHandle();
					for (String winHandle : webDriver.getWindowHandles()) {
						webDriver.switchTo().window(winHandle);
					}
					pageUtils.sleepSeconds(5, "");
					String pageTitle = webDriver.getTitle();
					if (!pageTitle.isBlank() || !pageTitle.isEmpty() || !pageUtils.verifyIfDisplayed(errorPage)) {
						context.writeOut("L2 Category Name is: " + cat + " || Page title is: " + pageTitle);
					} else {
						flag = false;
					}
					pageUtils.sleepSeconds(5, "");
					webDriver.close();
					webDriver.switchTo().window(winHandleBefore);
				}
			} catch (IllegalArgumentException e) {
				throw new TestException(e.getMessage());
			}
			mkPageNavigator.goToHomePage();
		}
		return flag;
	}
	
	public boolean clickOnL3CategoryAndVerifyPageTitleNA(DataTable menuList) {
		List<List<String>> data = menuList.asLists();

		boolean flag = true;
		String cat = "";
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		for(int i=0; i<data.size();i++) {
			String menuitem=data.get(i).toString().trim();
			System.out.println(menuitem.replaceAll("\\[", "").replaceAll("\\]", "").trim().toLowerCase());
		String translatedMenuTitle = getTranslation(menuitem.replaceAll("\\[", "").replaceAll("\\]", "").trim().toLowerCase());
		WebElement l1MenuElement = l1Flyout.stream()
						
				.filter(s -> s.getText().toLowerCase().equals(translatedMenuTitle.toLowerCase())).findFirst().get();
		actionBuilder.moveToElement(l1MenuElement).build().perform();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(5, "");

		List<WebElement> l3Links = webDriver.findElements(By.cssSelector(
					".nav-menu-item.flyout-container.active .flyout-subcontainer .columns.link-container .inner-container > li .l3flyout"));
		List<WebElement> l3LinksDisplayed = l3Links.stream().filter(s -> s.isDisplayed())
					.collect(Collectors.toList());
			try {
				for (WebElement l3menu : l3LinksDisplayed) {
					cat = l3menu.getText();
					context.writeOut("Clicking on the L3 menu: " + cat);
					((JavascriptExecutor) webDriver)
							.executeScript("window.open('" + l3menu.getAttribute("href") + "', '-blank')");

					String winHandleBefore = webDriver.getWindowHandle();
					for (String winHandle : webDriver.getWindowHandles()) {
						webDriver.switchTo().window(winHandle);
					}
					pageUtils.sleepSeconds(5, "");
					String pageTitle = webDriver.getTitle();
					if (!pageTitle.isBlank() || !pageTitle.isEmpty() || !pageUtils.verifyIfDisplayed(errorPage)) {
						context.writeOut("L3 Category Name is: " + cat + " || Page title is: " + pageTitle);
					} else {
						flag = false;
					}
					pageUtils.sleepSeconds(5, "");
					webDriver.close();
					webDriver.switchTo().window(winHandleBefore);
				}
			} catch (IllegalArgumentException e) {
				throw new TestException(e.getMessage());
			}
			mkPageNavigator.goToHomePage();
		}
		return flag;
	}
	
	public void clickL1Menu(String menuTitle) {
		pageUtils.waitForAjaxToComplete();
		WebElement menuLink = l1Flyout.stream()
				.filter(s -> s.getText().toLowerCase().equals(menuTitle.toLowerCase())).findFirst().get();
		this.context.saveData("menu-href", menuLink.getAttribute("href"));
		jsExecutor.executeScript("arguments[0].click();", menuLink);
		pageUtils.waitForAjaxToComplete();
	}
	
	public boolean isPPHDisplayed() {
		return pageUtils.verifyIfDisplayed(mkPPH);
	}
	
	public boolean isSearchIconDisplayed() {
		return pageUtils.verifyIfDisplayed(searchLink);
	}
	
	public boolean isFindAStoreIconDisplayed() {
		return pageUtils.verifyIfDisplayed(storeLocatorLink);
	}
	
	public boolean isSignInLinkDisplayed() {
		boolean flag = false;
		if (signInLink.isDisplayed()) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMiniCartIconDisplayed() {
		return pageUtils.verifyIfDisplayed(shoppingBagIcon);
	}
	
	public boolean isCountrySelectorDisplayed() {
		return pageUtils.verifyIfDisplayed(countrySelector);
	}
	
	public boolean verifyCountrySelectedAndCurrency() {
		String actualCurrency = selectedCountryCurrency.getText().trim();
		boolean flag = false;
		Currency currency = Currency.getInstance(env.getCurrentLocale());
		String expectedCurrency = currency.getSymbol();
		if(actualCurrency.contains(expectedCurrency) ||actualCurrency.contains("AU$")) {
			flag = true;
			context.writeOut("Expected currency symbol: "+ env.getCountry() + " " +expectedCurrency +" Actual currency symbol: "+actualCurrency);
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

	public boolean myAccountLinkIsPresent_Test() {
		boolean flag = false;
	
		try {
			pageUtils.waitForWebElement(myAccountLink);
			pageUtils.waitTillWebElementIsVisible(myAccountLink, 10);
			pageUtils.sleepSeconds(1, "wait for page load");
			boolean linkPresent = pageUtils.verifyIfDisplayed(myAccountLink);
			if (!linkPresent) {
				flag = true;
				context.writeOut("Retrying check for my accounts link");
				pageUtils.refresh();
				pageUtils.waitForWebElement(myAccountLink);
				return pageUtils.verifyIfDisplayed(myAccountLink);
			}
		}
			 catch (Exception e) {
					// TODO: handle exception
				}
			return flag;
	
	}
	
	public void verifyEachCategoryMobile() throws IOException {
		for(String menu:excelUtils.getCellData()) {
			
			System.out.println(menu);
			List<String> menulList = Splitter.on(">").trimResults().splitToList(menu);
			mkMobileHamburgerMenu.openHamburgerMenuIfNotOpen();
			if (menulList.size() == 1) {
				mkMobileHamburgerMenu.clickMenuL1(menulList.get(0));

				try {
					pageUtils.sleepSeconds(5, "wait for page load");
					WebElement ele=webDriver.findElement(By.xpath("//div[@class='nav-menu-item flyout-container open']//ul[@class='columns content-container ']//a[@aria-label='menu principal'][normalize-space()='menu principal'] | //div[@class='nav-menu-item flyout-container open']//ul[@class='columns content-container ']//a[@aria-label='main menu'][normalize-space()='main menu'] | //div[@class='nav-menu-item open']//a[@aria-label='main menu'][normalize-space()='main menu'] | //div[@class='nav-menu-item open']//a[@aria-label='menu principal'][normalize-space()='menu principal']"));
					if(ele.isDisplayed()) {
						ele.click();
					}
				}catch(NoSuchElementException e) {
					System.out.println();
				}
			} else if (menulList.size() == 2) {
				mkMobileHamburgerMenu.clickMenuL2(menulList.get(1), menulList.get(0));
				
				try {
					pageUtils.sleepSeconds(5, "wait for page load");
					WebElement ele=webDriver.findElement(By.xpath("//div[@class='nav-menu-item flyout-container open']//ul[@class='columns content-container ']//a[@aria-label='menu principal'][normalize-space()='menu principal'] | //div[@class='nav-menu-item flyout-container open']//ul[@class='columns content-container ']//a[@aria-label='main menu'][normalize-space()='main menu'] | //div[@class='nav-menu-item open']//a[@aria-label='main menu'][normalize-space()='main menu'] | //div[@class='nav-menu-item open']//a[@aria-label='menu principal'][normalize-space()='menu principal']"));
					if(ele.isDisplayed()) {
						ele.click();
					}
				}catch(NoSuchElementException e) {
					System.out.println();
				}
			} else if (menulList.size() == 3) {
				mkMobileHamburgerMenu.clickL3Menu(menulList.get(2), menulList.get(1), menulList.get(0));
		
				try {
					pageUtils.sleepSeconds(5, "wait for page load");
					WebElement ele = webDriver.findElement(By.xpath(
							"//div[@class='nav-menu-item open']//a[@aria-label='main menu'][normalize-space()='main menu'] | //div[@class='nav-menu-item open']//a[@aria-label='menu principal'][normalize-space()='menu principal']"));
					if (ele.isDisplayed()) {
						ele.click();
					}
				} catch (NoSuchElementException e) {
					System.out.println();
				}

			} else {
				throw new TestEnvironmentException("Can't understand this menu pattern " + menu);
			}
			
		}
	}
}