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
public class MkStoreLocatorPage_US {

   @FindBy(css = ".SearchBox-wrapper")
   private WebElement storeLocatorPage;

   @FindBy(css = ".search-button")
   private WebElement searchButton;

   @FindBy(css = ".Search-resultsCount")
   private WebElement resultCount;

   @FindBy(css = ".Search-desktopMap")
   private WebElement mapImageIsDisplaying;

   @FindBy(css = ".search-input")
   private WebElement storeCityPostcode;

   private PageUtils pageUtils;
   private JavascriptExecutor jsExecutor;

   @Inject
   public MkStoreLocatorPage_US(WebDriver webDriver, PageUtils pageUtils) {
      PageFactory.initElements(webDriver, this);
      this.pageUtils = pageUtils;
      this.jsExecutor = ((JavascriptExecutor) webDriver);
   }

   public void enterCity(String city) {
      storeCityPostcode.sendKeys(city);
   }

   public void enterStateOrRegion(String stateOrRegion) {
      storeCityPostcode.sendKeys(stateOrRegion);
   }

   public void enterPostcode(String postalCode) {
      storeCityPostcode.clear();
      storeCityPostcode.sendKeys(postalCode);
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