package com.mk.testframework.dt.util;


import java.time.Duration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.core.exceptions.TestEnvironmentException;


/**
 * @author VThipperudrappa
 *
 */
public class PageUtils {
	private final Logger log = LoggerFactory.getLogger(getClass());
	private WebDriver webDriver;
	private Environment env;
	private FluentWait<WebDriver> waitForElement;
	private JavascriptExecutor jsExecutor;

	public enum Resource {
		MENU("i18n.menu.MkHambergerMenu"),
		COUNTRIES("i18n.menu.MkCountriesMenu"),
		LINKS("i18n.links.MkLinks"),
		MONTHS("i18n.months.MkMonths"),
		GENDER("i18n.gender.MkGender"),
		FILTERS("i18n.filters.MkFilters"),
		TEXT("i18n.text.MkText"),
		TITLE("i18n.title.MkTitle"),
		SORT("i18n.sort.MkSort"),
		STATE("i18n.state.MkStates"),
		CURRENCYFORMAT("i18n.currencyFormat.MkCurrencyFormat"),
		FOOTERLINKS("i18n.footerLinks.MKFooterLinks"),
		CCPOPUP("i18n.ccpopup.Mkccpopup"),
		SBPEDITPOPUP("i18n.sbpeditpopup.Mksbpeditpopup"),
		COLOR("i18n.color.MkColor"),
		GIFTCARDS("i18n.giftcards.MkGiftcard"),
		SPECIALCHAR("i18n.specialchar.MkSpecialChar");
		

		public final String basename;

		Resource(String basename) {
			this.basename = basename;
		}

		public String getBasename() {
			return this.basename;
		}
	}

	@Inject
	public PageUtils(WebDriver webDriver, Environment env) {
		this.waitForElement = new FluentWait<WebDriver>(webDriver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);
		this.webDriver = webDriver;
		this.env = env;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
	}

	public void waitForPageToLoad() {
		(new WebDriverWait(webDriver, 20)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(final WebDriver d) {
				log.debug("Waiting for document load");
				return (((JavascriptExecutor) webDriver).executeScript("return document.readyState")
						.equals("complete"));
			}
		});
	}

	public boolean waitForAjaxToComplete() {
		WebDriverWait wait = new WebDriverWait(webDriver, 20);
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					log.debug("Waiting for ajax load");
					return ((Long) ((JavascriptExecutor) webDriver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};
		return wait.until(jQueryLoad);
	}

	public boolean waitForWebElement(WebElement webElement) {
		try {
			return this.waitForElement.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					log.debug("Waiting for element {} to be displyed", webElement.toString());
					return webElement.isDisplayed()||webElement.isEnabled();
				}
			});
		} catch (TimeoutException te) {
			log.debug("Element {} never appeared", webElement.toString());
			return false;
		}
	}

	public void sleepSeconds(int seconds, String message) {
		log.debug(message);
		try {
			Thread.sleep(1000*seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean verifyIfDisplayed(WebElement webElement) {
		try {
			return webElement.isDisplayed()||webElement.isEnabled();
		} catch (NoSuchElementException e) {
			log.debug("Not on expected web page");
			return false;
		}
	}

	public void clickBrowserBackButton() {
		webDriver.navigate().back();
		waitForPageToLoad();
		waitForAjaxToComplete();
	}

	public void clickBrowserForwardButton() {
		webDriver.navigate().forward();
		waitForPageToLoad();
		waitForAjaxToComplete();
	}

	public ResourceBundle getResourceBundle(Resource resource) {
		try {
			return ResourceBundle.getBundle(resource.getBasename(), env.getCurrentLocale());
		} catch (MissingResourceException e) {
			throw new TestEnvironmentException("Issue with resource bundle : " + e.getMessage());
		}
	}

	public String buildResourceLookupKey(String lookupString) {
		log.debug("building lookup key for {}", lookupString);
		lookupString = lookupString.toLowerCase().replaceAll("(�|,|&|\\?)", "").replaceAll("\\s+", "-").trim();
		log.debug("lookup key {}", lookupString);
		return lookupString;
	}
	
	public void refresh() {
		webDriver.navigate().refresh();
		waitForPageToLoad();
	}

	public String getCurrentUrl() {
		return webDriver.getCurrentUrl();
	}

	public boolean waitTillWebElementIsClickable(WebElement webElement) {
		try {
			WebDriverWait wait = new WebDriverWait(webDriver, 5);
			return wait.until(ExpectedConditions.elementToBeClickable(webElement)).isDisplayed();
		} catch (NoSuchElementException e) {
			log.debug("Web element not clickable yet");
			return false;
		}
		catch (TimeoutException e) {
			log.debug("Web element not clickable yet");
			return false;
		}
	}

	public boolean waitTillWebElementIsVisible(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(webDriver, 20);
			return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
		} catch (Exception e) {
			log.debug("Web element not visible yet");
			return false;
		}
	}

	public boolean waitTillWebElementIsVisible(WebElement webElement, int seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(webDriver, seconds);
			return wait.until(ExpectedConditions.visibilityOf(webElement)).isDisplayed();
		} catch (Exception e) {
			log.debug("Web element not visible yet");
			return false;
		}
	}

	public void scrollToElement(WebElement webElement){
		jsExecutor.executeScript("arguments[0].scrollIntoView();", webElement);
	}

	public void scrollToBottomOfPage(){
		((JavascriptExecutor) webDriver)
				.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	public void scrollToTopOfPage(){
		((JavascriptExecutor) webDriver)
	
	.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	}

	public void type_in_field(WebElement selector, String keyword) {
		selector.clear();

		for (int i = 0; i < keyword.length(); i++){
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			char c = keyword.charAt(i);
			String s = new StringBuilder().append(c).toString();
			selector.sendKeys(s);
		}
	}



	public void deleteAllCookies() {
		webDriver.manage().deleteAllCookies();
		
	}

	public String getTextTranslation(String text) {
		ResourceBundle textResource = getResourceBundle(PageUtils.Resource.TEXT);
		return textResource.getString(buildResourceLookupKey(text));
	}
	
	public void webElementHighLighterMethod(WebElement element) {
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}
	
	public boolean isCookiesSaved() {
		boolean flag = false;
		Set<Cookie> cookies  = webDriver.manage().getCookies();
		if(!cookies.isEmpty())
			flag=true;
		return flag;
	}
	
	public String getFilterTranslation(String filterHeader) {
		ResourceBundle filterResource = getResourceBundle(PageUtils.Resource.FILTERS);
		return filterResource.getString(buildResourceLookupKey(filterHeader));
	}
	
	public String getCurrencyFormat(String filterHeader) {
		ResourceBundle filterResource = getResourceBundle(PageUtils.Resource.CURRENCYFORMAT);
		return filterResource.getString(buildResourceLookupKey(filterHeader));
	}
	
	public String getFooterLinksTranslation(String footerLinks) {
		ResourceBundle textResource = getResourceBundle(PageUtils.Resource.FOOTERLINKS);
		return textResource.getString(buildResourceLookupKey(footerLinks));
	}
	
	public String getCCPopupStoreText(String storeText) {
		ResourceBundle filterResource = getResourceBundle(PageUtils.Resource.CCPOPUP);
		return filterResource.getString(buildResourceLookupKey(storeText));
	}
	
	public String getCCPopupHeadingText(String ccPopUpHeading) {
		ResourceBundle filterResource = getResourceBundle(PageUtils.Resource.CCPOPUP);
		return filterResource.getString(buildResourceLookupKey(ccPopUpHeading));
	}
	
	public String getSBPEditPopUpTextTranslation(String text) {
		ResourceBundle textResource = getResourceBundle(PageUtils.Resource.SBPEDITPOPUP);
		return textResource.getString(buildResourceLookupKey(text));
	}
	public String getColorTranslation(String color) {
		ResourceBundle textResource = getResourceBundle(PageUtils.Resource.COLOR);
		return textResource.getString(buildResourceLookupKey(color));
	}
	
	public String getTGiftcards(String giftCardAmount) {
		ResourceBundle textResource = getResourceBundle(PageUtils.Resource.GIFTCARDS);
		return textResource.getString(buildResourceLookupKey(giftCardAmount));
	}
	
	public String getFirstNameSpecialChar(String fname) {
		ResourceBundle textResource = getResourceBundle(PageUtils.Resource.SPECIALCHAR);
		return textResource.getString(buildResourceLookupKey(fname));
	}
	
	public String getLastNameSpecialChar(String lname) {
		ResourceBundle textResource = getResourceBundle(PageUtils.Resource.SPECIALCHAR);
		return textResource.getString(buildResourceLookupKey(lname));
	}
	
}
