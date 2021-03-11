package com.mk.testframework.dt.mobile;

import com.google.inject.Inject;
import com.mk.testframework.dt.util.PageUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MkMobileCustomizePage {
    @FindBy(css = ".fc-pager-prev")
    private WebElement navPrev;

    @FindBy(css = ".fc-pager-next")
    private WebElement navNext;

    @FindBy(css = ".fc-pager-alias-colorway")
    private WebElement colorwayTab;
    
    @FindBy(css = ".fc-attribute-value-swatch .fc-swatch")
    private WebElement colorSwatches;

    @FindBy(css = ".fc-label input")
    private WebElement monogramInputField;

    @FindBy(css = ".fc-nav-flyout-active .fc-attribute-header .fc-attribute-header-swatch-name")
    private WebElement inputtedMonogramText;
    
    private PageUtils pageUtils;

    @Inject
    public MkMobileCustomizePage(WebDriver webDriver, PageUtils pageUtils){
        PageFactory.initElements(webDriver, this);
        this.pageUtils = pageUtils;
    }

    public boolean verifyNavigationButtonPrev(){
        pageUtils.waitForWebElement(navPrev);
        return pageUtils.verifyIfDisplayed(navPrev);
    }

    public boolean verifyNavigationButtonNext(){
        pageUtils.waitForWebElement(navNext);
        return pageUtils.verifyIfDisplayed(navNext);
    }

    public void clickNavigationPrev() {
        pageUtils.waitForWebElement(navPrev);
        navPrev.click();
        pageUtils.waitForPageToLoad();
        pageUtils.waitForAjaxToComplete();
    }

	public void clickNavigationNext() {
		try {
			pageUtils.sleepSeconds(5, "wait for page load");
			pageUtils.waitForWebElement(navNext);
			navNext.click();
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
		} catch (Exception e) {
			pageUtils.sleepSeconds(5, "wait for page load");
			pageUtils.waitForWebElement(navNext);
			navNext.click();
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();		}
	}

    public boolean verifyColorwayTab(){
        return pageUtils.verifyIfDisplayed(colorwayTab);
    }
    
    public boolean verifyColorSwatchesTab(){
        return pageUtils.verifyIfDisplayed(colorSwatches);
    }
    
    public boolean verifyCustomMessageField(){
        return pageUtils.verifyIfDisplayed(monogramInputField);
    }

    public void typeIntoCustomMessageField(String message) {
        monogramInputField.sendKeys(message);
    }

    public void pressEnter(){
        monogramInputField.sendKeys(Keys.RETURN);
        pageUtils.sleepSeconds(2, "wait for page load");
        pageUtils.waitForPageToLoad();
        pageUtils.waitForAjaxToComplete();
    }

    public void pressTab(){
        monogramInputField.sendKeys(Keys.TAB);
        pageUtils.sleepSeconds(2, "wait for page load");
        pageUtils.waitForPageToLoad();
        pageUtils.waitForAjaxToComplete();
    }

    public boolean verifyMonogramCharacters(String monogram_chars){
        pageUtils.waitForWebElement(monogramInputField);
        return monogramInputField.getAttribute("value").toLowerCase().equals(monogram_chars.toLowerCase());
    }
}