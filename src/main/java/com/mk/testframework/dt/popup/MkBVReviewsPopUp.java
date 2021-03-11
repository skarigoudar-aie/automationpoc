package com.mk.testframework.dt.popup;

import com.google.inject.Inject;
import com.mk.testframework.dt.util.PageUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author MLinderman
 *
 */
public class MkBVReviewsPopUp {

    @FindBy(css = "#bv-mbox-overlay-id")
    private WebElement bvPostReviewContainer;

    @FindBy(css = ".bv-submit")
    private WebElement postReviewButton;

    private PageUtils pageUtils;

    @Inject
    public MkBVReviewsPopUp(WebDriver webDriver, PageUtils pageUtils){
        PageFactory.initElements(webDriver, this);
        this.pageUtils = pageUtils;
    }

    public boolean postReviewLightboxIsDisplayed() {
        pageUtils.waitForWebElement(bvPostReviewContainer);
        return pageUtils.verifyIfDisplayed(bvPostReviewContainer);
    }

    public boolean postReviewButtonIsDisplayed() {
        pageUtils.waitTillWebElementIsVisible(bvPostReviewContainer, 20);
        pageUtils.waitTillWebElementIsVisible(postReviewButton, 20);
        return pageUtils.verifyIfDisplayed(postReviewButton);
    }

}