package com.mk.testframework.dt.page.product;

import com.google.inject.Inject;
import com.mk.testframework.dt.util.PageUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Nagarjuna Polisetty
 *
 */
public class MkProductDetailPageNA {

    @FindBy(css = ".wish-list-msg span span a")
    private WebElement joinLinkInMsgSection;
    
    @FindBy(xpath = "(//*[@class='wish-list-msg']//a)[1]")
    private WebElement signInLinkInMsgSection;
    
    @FindBy(xpath = "(//*[@class='wish-list-msg']//span)[3]//a")
    private WebElement wishlistLink;
    
    private PageUtils pageUtils;
    private WebDriver webDriver;
    private Actions actionBuilder;
    private JavascriptExecutor jsExecutor;

    @Inject
    public MkProductDetailPageNA(WebDriver webDriver, PageUtils pageUtils){
        PageFactory.initElements(webDriver, this);
        this.pageUtils = pageUtils;
        this.webDriver = webDriver;
        this.jsExecutor = ((JavascriptExecutor) webDriver);
        this.actionBuilder = new Actions(webDriver);
    }
    
    public void clickOnJoinLink() {
    	pageUtils.waitForPageToLoad();
		pageUtils.waitTillWebElementIsClickable(joinLinkInMsgSection);
		actionBuilder.moveToElement(joinLinkInMsgSection).build().perform();
        jsExecutor.executeScript("arguments[0].click();", joinLinkInMsgSection);
        pageUtils.waitForPageToLoad();
    	pageUtils.sleepSeconds(5, "Wait for page to load");
    }
    
    public void clickOnSignInLink() {
    	pageUtils.waitForPageToLoad();
		pageUtils.waitTillWebElementIsClickable(signInLinkInMsgSection);
		actionBuilder.moveToElement(signInLinkInMsgSection).build().perform();
		jsExecutor.executeScript("arguments[0].click();", signInLinkInMsgSection);
    	pageUtils.waitForPageToLoad();
    	pageUtils.sleepSeconds(5, "Wait for page to load");
    }
    
    public void clickOnWishlistLink() {
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(5, "Wait for wishlist link to display");
		pageUtils.waitTillWebElementIsClickable(wishlistLink);
		actionBuilder.moveToElement(wishlistLink).build().perform();
		jsExecutor.executeScript("arguments[0].click();", wishlistLink);
	}
}
