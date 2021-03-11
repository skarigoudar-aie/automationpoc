package com.mk.testframework.dt.header;

import com.google.inject.Inject;
import com.mk.testframework.dt.util.PageUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MkCheckoutMenu {

    @FindBy(css = ".icon-account")
    private WebElement signInLink;

    private PageUtils pageUtils;

    @Inject
    public MkCheckoutMenu(WebDriver webDriver, PageUtils pageUtils) {
        PageFactory.initElements(webDriver, this);
        this.pageUtils = pageUtils;
    }

    public boolean myAccountLinkIsPresent() {
        pageUtils.waitForWebElement(signInLink);
        return pageUtils.verifyIfDisplayed(signInLink);
    }

    public void clickMyAccountLink(){
        signInLink.click();
        pageUtils.waitForPageToLoad();
        pageUtils.waitForAjaxToComplete();
    }
}
