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
public class MkKorsVIPModal {

	@FindBy(css = ".mk-korsvip-signUp-column")
	private WebElement korsVIPContainer;

	@FindBy(css = "#closekorsvipsignUpModel")
	private WebElement closeKorsVIPModal;

	private PageUtils pageUtils;
	private Actions actionBuilder;

	@Inject
	public MkKorsVIPModal(WebDriver webDriver, PageUtils pageUtils){
		PageFactory.initElements(webDriver, this);
		this.actionBuilder = new Actions(webDriver);
		this.pageUtils = pageUtils;
	}

	public boolean waitForKorsVIPModal() {
		return pageUtils.waitForWebElement(korsVIPContainer);
	}

	public void close(){
		actionBuilder.moveToElement(closeKorsVIPModal).click().build().perform();
	}
}
