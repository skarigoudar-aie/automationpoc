package com.mk.testframework.dt.page.product;

import com.google.inject.Inject;
import com.mk.testframework.dt.util.PageUtils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


public class MkCustomizePage {
    @FindBy(css = ".fc-ca-alias-monogram")
    private WebElement monogramTabLink;

    @FindBy(css = ".fc-facet-no-values-label")
    private WebElement noValuesLabel;

    @FindBy(css = ".fc-ca-alias-monogram .fc-label input")
    private WebElement monogramInputField;

    @FindBy(css = ".fc-add-to-cart-button")
    private WebElement addToBagButton;

    @FindBy(css = ".fc-nav-flyout-active .fc-attribute-header .fc-attribute-header-swatch-name")
    private WebElement inputtedMonogramText;
    
    private PageUtils pageUtils;
	private JavascriptExecutor jsExecutor;

	private FluentWait<WebDriver> wait;

    @Inject
    public MkCustomizePage(WebDriver webDriver, PageUtils pageUtils){
        PageFactory.initElements(webDriver, this);
        this.pageUtils = pageUtils;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.wait = new FluentWait<WebDriver>(webDriver).withTimeout(Duration.ofSeconds(20))
		.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class);
    }

    public boolean monogramTabDisplayed(){
    	pageUtils.waitForPageToLoad();
    	pageUtils.sleepSeconds(8, "wait");
    	wait.until(ExpectedConditions.visibilityOf(monogramTabLink));
        return pageUtils.waitForWebElement(monogramTabLink);
    }

    public void clickMonogramTabLink() {
    	pageUtils.waitForPageToLoad();
        if (monogramTabDisplayed()){
            monogramTabLink.click();
            pageUtils.waitForPageToLoad();
            pageUtils.waitForAjaxToComplete();
        }
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

    public void clickAddToBagButton(){
    	pageUtils.sleepSeconds(8, "wait for page load");
    	jsExecutor.executeScript("arguments[0].click();", addToBagButton);
        pageUtils.sleepSeconds(8, "wait for page load");
        pageUtils.waitForPageToLoad();
        pageUtils.waitForAjaxToComplete();
    }

    public boolean verifyMonogramCharacters(String monogram_chars){
        pageUtils.waitForWebElement(inputtedMonogramText);
        return inputtedMonogramText.getAttribute("innerText").toLowerCase().equals(monogram_chars.toLowerCase());
    }

    public boolean verifyNoValuesLabel(){
        return pageUtils.waitForWebElement(noValuesLabel);
    }
}

