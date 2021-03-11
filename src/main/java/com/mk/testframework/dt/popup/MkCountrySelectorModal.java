package com.mk.testframework.dt.popup;

import java.util.List;

import org.apache.commons.lang3.LocaleUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.core.env.Environment.Region;
import com.mk.testframework.dt.util.ModalUtils;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.dt.page.home.MkHomePage;

/**
 * @author VThipperudrappa
 *
 */
public class MkCountrySelectorModal {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@FindBy(how = How.CSS, using = ".country-selector-panel")
	private WebElement countrySelector;

	@FindBy(how = How.CSS, using = ".language-container .multi-language-list-item a:nth-of-type(1)")
	private List<WebElement> countryAnchorLinks;

	@FindBy(how = How.CSS, using = ".country-search-text-box")
	private WebElement searchBox;
	
	@FindBy(how = How.CSS, using = ".country-selector .language-selected")
	private WebElement countrySelected;
	
	private JavascriptExecutor jsExecutor;
	private PageUtils pageUtils;
	private Environment env;
	private ModalUtils modalUtils;
	private MkHomePage mkHomePage;

	@Inject
	public MkCountrySelectorModal(WebDriver webDriver, PageUtils pageUtils, ModalUtils modalUtils, Environment env, MkHomePage mkHomePage) {
		this.pageUtils = pageUtils;
		this.env = env;
		this.modalUtils = modalUtils;
		PageFactory.initElements(webDriver, this);
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.mkHomePage = mkHomePage;
	}

	public void typeIntoSearchBox(String searchTerm) {
		searchBox.clear();
		searchBox.sendKeys(searchTerm);
	}

	public void selectCountry(String countryLocale) {
		log.debug("switching to locale {} ", countryLocale);
		WebElement countryLink = countryAnchorLinks.stream()
				.filter(s -> s.getAttribute("data-locale").equals(countryLocale)).findFirst().get();
		jsExecutor.executeScript("arguments[0].click();", countryLink);
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForPageToLoad();
		if(env.getCountryRegion(LocaleUtils.toLocale(countryLocale)) == Region.NA){
			modalUtils.closeKorsVIPFlashNoticeModalIfPresented();
			modalUtils.closeNeverMissABeatPopupIfPresented();
		}
		else{
			mkHomePage.acceptCookieBannerIfPresented();
			modalUtils.acceptCountryChangePopupIfPresented();
		}
	}
	
	public String getCountrySelected() {
		return countrySelected.getText();
	}

}
