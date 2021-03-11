package com.mk.testframework.dt.page.product;

import com.google.inject.Inject;
import com.mk.testframework.dt.util.PageUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Nagarjuna Polisetty
 *
 */
public class MkProductDetailPageEU {

    @FindBy(xpath = "//*[@class='favorites-msg uppercase-favourite-message']//a[2]")
    private WebElement signUpLinkInMsgSection;
    
    @FindBy(xpath = "//*[@class='favorites-msg uppercase-favourite-message']//a[1]")
    private WebElement signInLinkInMsgSection;
    
    @FindBy(css = ".logo img")
    private WebElement mkLogo;
    
    private PageUtils pageUtils;
    private WebDriver webDriver;
    private Actions actionBuilder;

    @Inject
    public MkProductDetailPageEU(WebDriver webDriver, PageUtils pageUtils){
        PageFactory.initElements(webDriver, this);
        this.actionBuilder = new Actions(webDriver);
        this.pageUtils = pageUtils;
        this.webDriver = webDriver;
    }
    
    public void clickOnSignUpLink() {
    	pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(3, "wait for page to load");
		signUpLinkInMsgSection.click();
    	pageUtils.waitForPageToLoad();
    	pageUtils.sleepSeconds(5, "Wait for page to load");
    }
    public void clickOnSignInLink() {
    	pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(3, "wait for page to load");
		signInLinkInMsgSection.click();
    	pageUtils.waitForPageToLoad();
    	pageUtils.sleepSeconds(5, "Wait for page to load");
    }
}
