package com.mk.testframework.dt.header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.inject.Inject;
import com.mk.testframework.dt.util.PageUtils;

/**
 * @author VThipperudrappa
 *
 */
public class MkBanner {
	
	private PageUtils pageUtils;

	@FindBy(css=".header-container")
    private WebElement header;
	
	@FindBy(css=".pphMessageContent")
    private WebElement bannerMessage;

	@FindBy(css=".header-container .pphMessageLink")
    private WebElement bannerMessageLink;
	
	@FindBy(css=".header-container .close-icon")
    private WebElement bannerExpandMessage;

	private Actions actionBuilder;
	
	@Inject
	public MkBanner(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
		this.actionBuilder = new Actions(webDriver);
	}

	public String getBannerMessage() {
		return bannerMessage.getText();
	}
	
	public void clickBannerMessageLink() {
		bannerMessageLink.click(); 
		pageUtils.waitForPageToLoad();
	}
	
	public void expandBannerMessage() {
		bannerExpandMessage.click();
	}

	public void moveToBanner() {
		actionBuilder.moveToElement(header).build().perform();
	}
}
