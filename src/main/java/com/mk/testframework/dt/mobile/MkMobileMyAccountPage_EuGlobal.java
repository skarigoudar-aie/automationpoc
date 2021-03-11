package com.mk.testframework.dt.mobile;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.core.exceptions.TestEnvironmentException;
import com.mk.testframework.dt.header.MkMyAccountMenu;
import com.mk.testframework.dt.page.shoppingbag.MkEditProductLightbox;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.dt.util.PageUtils.Resource;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

public class MkMobileMyAccountPage_EuGlobal {
    
    @FindBy(xpath = "//div[@class='color_edit_mobile_section']//*[contains(text(),'Edit')]")
    private List<WebElement> favEdit;
    
    private PageUtils pageUtils;
    private WebDriver webDriver;
    private JavascriptExecutor jsExecutor;
    private Actions actionBuilder;

    @Inject
    public MkMobileMyAccountPage_EuGlobal(WebDriver webDriver, PageUtils pageUtils) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        this.pageUtils = pageUtils;
        this.actionBuilder = new Actions(webDriver);
        this.jsExecutor = ((JavascriptExecutor) webDriver);
    }

	public void clickOnEditLinkInFavorites() {
		actionBuilder.moveToElement(favEdit.get(0));
		jsExecutor.executeScript("arguments[0].click();", favEdit.get(0));
		pageUtils.sleepSeconds(10, "Wait for edit pop up to display");
	}
}
