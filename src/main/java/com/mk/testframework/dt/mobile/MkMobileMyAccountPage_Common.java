package com.mk.testframework.dt.mobile;

import com.google.inject.Inject;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.dt.util.PageUtils.Resource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ResourceBundle;

public class MkMobileMyAccountPage_Common {

   @FindBy(xpath = "//*[contains(@class,'accountMenuHeading')]//a")
   private WebElement mkMyAccountMenu;
     
   private PageUtils pageUtils;
   private WebDriver webDriver;
   private JavascriptExecutor jsExecutor;
   
    @Inject
    public MkMobileMyAccountPage_Common(WebDriver webDriver, PageUtils pageUtils) {
        PageFactory.initElements(webDriver, this);
        this.jsExecutor = ((JavascriptExecutor) webDriver);
        this.pageUtils = pageUtils;
        this.webDriver = webDriver;
    }
    
    private String getTranslationT(String text) {
	    ResourceBundle titleResource = pageUtils.getResourceBundle(Resource.TEXT);
		return titleResource.getString(pageUtils.buildResourceLookupKey(text));
    }
    
    public void clickOnWishlistOrFavoritesLink(String text) {
    	pageUtils.waitForPageToLoad();
    	pageUtils.sleepSeconds(3, "Wait for page to load");
    	String state = mkMyAccountMenu.getAttribute("aria-label");
    	if(state.contains("expand"))
    		mkMyAccountMenu.click();
    	pageUtils.sleepSeconds(3, "Wait for page to load");
    	String locator="//ul[@class='profile_nav']//a[text()='"+getTranslationT(text)+"']";
    	WebElement wishlistOrFavoritesLink = webDriver.findElement(By.xpath(locator));
    	pageUtils.waitForPageToLoad();
    	jsExecutor.executeScript("arguments[0].click();", wishlistOrFavoritesLink);
		pageUtils.waitForPageToLoad();
	} 
    
}



