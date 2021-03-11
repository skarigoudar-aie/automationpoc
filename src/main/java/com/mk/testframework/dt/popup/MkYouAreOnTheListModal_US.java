package com.mk.testframework.dt.popup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.google.inject.Inject;
import com.mk.testframework.dt.util.PageUtils;

/**
 * @author RSingh
 *
 */
public class MkYouAreOnTheListModal_US {

	@FindBy(css = ".signup-modal-header")
	private WebElement YouAreOnTheListModalIsDisplaying;

	private PageUtils pageUtils;

	@Inject
	public MkYouAreOnTheListModal_US(WebDriver webDriver, PageUtils pageUtils) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
	}

	public boolean youAreOnTheSignUPList() {
		return pageUtils.verifyIfDisplayed(YouAreOnTheListModalIsDisplaying);

	}
}
