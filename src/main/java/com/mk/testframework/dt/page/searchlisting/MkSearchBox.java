package com.mk.testframework.dt.page.searchlisting;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.google.inject.Inject;
import com.mk.testframework.dt.util.PageUtils;

/**
 * @author VThipperudrappa
 *
 */
public class MkSearchBox {

	@FindBy(id = "search-box")
	private WebElement searchBox;

	@FindBy(css = ".search-message-panel")
	private WebElement searchMessage;

	@FindBy(css = ".search-panel")
	private WebElement searchBoxDisplay;

	@FindBy(css = ".search-close-btn")
	private WebElement closeButtonDisplay;

	private PageUtils pageUtils;

	@Inject
	public MkSearchBox(WebDriver webDriver, PageUtils pageUtils) {
		this.pageUtils = pageUtils;
		PageFactory.initElements(webDriver, this);
	}

	public void waitForSearchBox() {
		pageUtils.waitForWebElement(searchBox);
	}

	public void typeIntoSearchBox(String searchTerm) {
		searchBox.clear();
		searchBox.sendKeys(searchTerm);
	}

	public void pressEnter() {
		try {
			searchBox.sendKeys(Keys.ENTER);
			pageUtils.waitForAjaxToComplete();
			pageUtils.waitForPageToLoad();
		} catch (Exception e) {
			searchBox.sendKeys(Keys.RETURN);
		}
	}

	public void getSearchResultMessage() {
		pageUtils.verifyIfDisplayed(searchMessage);
	}

	public void searchBoxIsDisplaying() {
		pageUtils.verifyIfDisplayed(searchBoxDisplay);

	}

	public void closeButtonIsDisplaying() {
		pageUtils.verifyIfDisplayed(closeButtonDisplay);

	}
}