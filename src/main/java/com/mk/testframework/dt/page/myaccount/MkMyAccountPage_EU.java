package com.mk.testframework.dt.page.myaccount;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.exceptions.TestEnvironmentException;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.dt.util.PageUtils.Resource;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;


public class MkMyAccountPage_EU {
	    
    private PageUtils pageUtils;
    private WebDriver webDriver;

    @Inject
    public MkMyAccountPage_EU(WebDriver webDriver, PageUtils pageUtils,TestData testData) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        this.pageUtils = pageUtils;       
    }
    
    private String getTranslationT(String text) {
	    ResourceBundle titleResource = pageUtils.getResourceBundle(Resource.TEXT);
		return titleResource.getString(pageUtils.buildResourceLookupKey(text));
    }
    
    public void clickOnFavoritesLink(String text) {
    	String locator="//ul[@class='profile_nav']//a[text()='"+getTranslationT(text)+"']";
    	WebElement favoritesLink = webDriver.findElement(By.xpath(locator));
    	pageUtils.waitForPageToLoad();
		favoritesLink.click();
		pageUtils.waitForPageToLoad();
	} 
}
