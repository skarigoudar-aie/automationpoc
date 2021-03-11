package com.mk.testframework.dt.mobile;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.core.env.Environment.Region;
import com.mk.testframework.dt.util.ModalUtils;
import com.mk.testframework.dt.util.PageUtils;
import org.apache.commons.lang3.LocaleUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.ResourceBundle;

/**
 * @author MLinderman
 *
 */
public class MkMobileCountrySelectorMenu {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@FindBy(how = How.CSS, using = ".country-selector-panel")
	private WebElement countrySelector;

	@FindBy(how = How.CSS, using = ".country-selector-listing.open .country-region-items button")
	private List<WebElement> countryRegionLinks;

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

	@Inject
	public MkMobileCountrySelectorMenu(WebDriver webDriver, PageUtils pageUtils, ModalUtils modalUtils, Environment env) {
		this.pageUtils = pageUtils;
		this.env = env;
		this.modalUtils = modalUtils;
		PageFactory.initElements(webDriver, this);
		this.jsExecutor = ((JavascriptExecutor) webDriver);
	}

	public void typeIntoSearchBox(String searchTerm) {
		searchBox.clear();
		searchBox.sendKeys(searchTerm);
	}

	public void selectCountry(String countryLocale) {
		log.debug("switching to locale {} ", countryLocale);
		WebElement countryRegion = null;

		if(env.getCountryRegion(LocaleUtils.toLocale(countryLocale)) == Region.EU){
			countryRegion = countryRegionLinks.stream()
					.filter(s -> s.getAttribute("aria-label").equals(
							getTranslation("europe"))).findFirst().get();
		}
		else if(env.getCountryRegion(LocaleUtils.toLocale(countryLocale)) == Region.NA){
			 countryRegion = countryRegionLinks.stream()
					.filter(s -> s.getAttribute("aria-label").equals(
							getTranslation("north america"))).findFirst().get();
		}
		else if(env.getCountryRegion(LocaleUtils.toLocale(countryLocale)) == Region.MIDDLE_EAST){
			 countryRegion = countryRegionLinks.stream()
					.filter(s -> s.getAttribute("aria-label").equals(
							getTranslation("middle east"))).findFirst().get();
		}
		else if(env.getCountryRegion(LocaleUtils.toLocale(countryLocale)) == Region.ASIA_PACIFIC){
			 countryRegion = countryRegionLinks.stream()
					.filter(s -> s.getAttribute("aria-label").equals(
							getTranslation("asia pacific"))).findFirst().get();
		}
		else if(env.getCountryRegion(LocaleUtils.toLocale(countryLocale)) == Region.AFRICA){
			 countryRegion = countryRegionLinks.stream()
					.filter(s -> s.getAttribute("aria-label").equals(
							getTranslation("africa"))).findFirst().get();
		}

		jsExecutor.executeScript("arguments[0].click();", countryRegion);
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForPageToLoad();

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
			modalUtils.acceptCountryChangePopupIfPresented();
		}
	}

	private String getTranslation(String link) {
		ResourceBundle menuResource = pageUtils.getResourceBundle(PageUtils.Resource.COUNTRIES);
		return menuResource.getString(pageUtils.buildResourceLookupKey(link));
	}
	
	public String getCountrySelected() {
		return countrySelected.getText();
	}

}
