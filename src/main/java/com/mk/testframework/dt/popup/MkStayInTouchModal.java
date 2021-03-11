package com.mk.testframework.dt.popup;

import com.mk.testframework.dt.util.PageUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.google.inject.Inject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author VThipperudrappa
 *
 */
public class MkStayInTouchModal {

    @FindBy(css = "#overlay-container-id")
    private WebElement stayInTouchContainer;

    @FindBy(css = "#overlay-container-id .modal-close-wrapper")
    private WebElement closeStayInTouchModal;

    private PageUtils pageUtils;
    private JavascriptExecutor jsExecutor;
    private WebDriver webDriver;

    @Inject
    public MkStayInTouchModal(WebDriver webDriver, PageUtils pageUtils){
        PageFactory.initElements(webDriver, this);
        this.pageUtils = pageUtils;
        this.jsExecutor = ((JavascriptExecutor) webDriver);
        this.webDriver = webDriver;
    }

    public boolean waitForStayInTouchModal() {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 20);
            wait.until(ExpectedConditions.visibilityOf(stayInTouchContainer));
        }
        catch(Exception e){
        }

        return pageUtils.waitForWebElement(stayInTouchContainer);
    }

    public void close(){
        jsExecutor.executeScript("arguments[0].click();", closeStayInTouchModal);
        pageUtils.waitForPageToLoad();
        pageUtils.sleepSeconds(2, "wait for page load");
        pageUtils.waitForAjaxToComplete();
    }
}