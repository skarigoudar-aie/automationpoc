package com.mk.testframework.dt.popup;

import com.google.inject.Inject;
import com.mk.testframework.dt.util.PageUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author MLinderman
 *
 */
public class MkZipCodePopup {

	@FindBy(css = ".zipcode-model-sub-wrapper")
	private WebElement zipCodeContainer;

	@FindBy(id = "closeSignInModel")
	private WebElement closeZipCodeContainer;

	private PageUtils pageUtils;
	private Actions actionBuilder;

	@Inject
	public MkZipCodePopup(WebDriver webDriver, PageUtils pageUtils){
		PageFactory.initElements(webDriver, this);
		this.actionBuilder = new Actions(webDriver);
		this.pageUtils = pageUtils;
	}

	public boolean waitForZipCodePopup() {
		return pageUtils.waitForWebElement(zipCodeContainer);
	}


	public void close(){
		actionBuilder.moveToElement(closeZipCodeContainer).click().build().perform();
	}
	
}
