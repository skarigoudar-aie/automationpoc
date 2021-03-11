package com.mk.testframework.dt.popup;

import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.util.PageUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

/**
 * @author VThipperudrappa
 *
 */
public class MkCountryChangePopup {

	@FindBy(css = ".country-change-warning .country-button.first")
	private WebElement countryChangeAcceptButton;

	@FindBy(css = ".country-change-warning")
	private WebElement countryChangeDialog;

	@FindBy(css = ".country-change-warning .country-button.second")
	private WebElement countryChangeDeclineButton;
	
	@FindBy(id = "onetrust-button-group-parent")
	private WebElement IAcceptCookieBannerGroup;

	@FindBy(id = "onetrust-accept-btn-handler")
	private WebElement IAcceptCookieBanner;

	private PageUtils pageUtils;
	private JavascriptExecutor jsExecutor;
	private final Logger log = LoggerFactory.getLogger(getClass());
	private Context context;

	@Inject
	public MkCountryChangePopup(WebDriver webDriver, PageUtils pageUtils, Context context) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.context = context;
	}

	public boolean waitForCountryChangeDialog() {
		return pageUtils.waitForWebElement(countryChangeDialog);
	}

	public void acceptCountryChange() {
		jsExecutor.executeScript("arguments[0].click();", countryChangeAcceptButton);
		log.info("--clicked on country change popup ---");
		context.setChangeCountryPopUpDismissedStatus(true);
	}

	public void declineCountryChange() {
		jsExecutor.executeScript("arguments[0].click();", countryChangeAcceptButton);
	}
	
	public boolean waitForCookieBannerPopup() {
		return pageUtils.waitForWebElement(IAcceptCookieBannerGroup);
	}

	public void acceptCookieBannerIfPresented() {
		if (this.waitForCookieBannerPopup()) {
			pageUtils.sleepSeconds(5, "page load");
			jsExecutor.executeScript("arguments[0].click();", IAcceptCookieBanner);
			pageUtils.sleepSeconds(2, "page load");
			log.info("accepted cookie banner");
			context.setpopUpDismissedStatus(true);
		}
	}

}
