package com.mk.testframework.dt.page.home;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.google.inject.Inject;
import com.mk.testframework.dt.util.PageUtils;

/**
 * @author RSingh
 *
 */
public class MkStoreLocatorPage_EuGlobal {

	@FindBy(css = ".store-page-inner")
	private WebElement storeLocatorPage;

	@FindBy(css = ".input")
	private WebElement storeCityPostcode;

	@FindBy(css = ".store-page-inner button")
	private WebElement searchButton;

	@FindBy(css = ".count")
	private WebElement resultCount;

	@FindBy(css = ".map-canvas")
	private WebElement mapImageIsDisplaying;
	
	private PageUtils pageUtils;
	private JavascriptExecutor jsExecutor;

	@Inject
	public MkStoreLocatorPage_EuGlobal(WebDriver webDriver, PageUtils pageUtils) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
	}

	public void enterPostcode(String postalCode) {
		storeCityPostcode.sendKeys(postalCode);
	}

	public void enterCity(String city) {
		storeCityPostcode.sendKeys(city);
	}

	public void enterStateOrRegion(String stateOrRegion) {
		storeCityPostcode.sendKeys(stateOrRegion);
	}
	
	public void clickOnSearchButton() {

		jsExecutor.executeScript("arguments[0].click();", searchButton);
		pageUtils.waitForPageToLoad();


	}

	public int getResultCount() {
		return Integer.parseInt(resultCount.getText().split(" ")[0].strip());
	}

	public boolean isMapImageDisplaying() {
		return pageUtils.verifyIfDisplayed(mapImageIsDisplaying);

	}

	public boolean onStoreLocatorPage() {
		return pageUtils.waitForWebElement(storeLocatorPage);
	}

}
