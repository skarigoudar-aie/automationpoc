package com.mk.testframework.dt.popup;

import com.google.inject.Inject;
import com.mk.testframework.dt.util.PageUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author MLinderman
 *
 */
public class MkCheckoutSignInModal_NA {

	@FindBy(id="checkout-sign-in-modal")
	private WebElement signInContainer;

	@FindBy(id="sign-in-email-address")
	private WebElement signInEmailAddress;

	@FindBy(id="sign-in-password")
	private WebElement signInPassword;

	@FindBy(name="sign-in-submit")
	private WebElement signInSubmit;

	private PageUtils pageUtils;
	private JavascriptExecutor jsExecutor;
	private WebDriver webDriver;

	@Inject
	public MkCheckoutSignInModal_NA(WebDriver webDriver, PageUtils pageUtils) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.webDriver = webDriver;
	}

	public boolean verifySignInModal() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		WebElement loginWindow = signInContainer;

		pageUtils.waitForWebElement(loginWindow);
		return pageUtils.verifyIfDisplayed(loginWindow);
	}

	public void enterEmailAddress(String email) {
		WebDriverWait wait = new WebDriverWait(webDriver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(signInEmailAddress));
		signInEmailAddress.click();
		pageUtils.type_in_field(signInEmailAddress, email);
	}

	public void enterPassword(String password) {
		WebDriverWait wait = new WebDriverWait(webDriver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(signInPassword));
		signInPassword.click();
		pageUtils.type_in_field(signInPassword, password);
	}

	public void clickSignIn() {
		jsExecutor.executeScript("arguments[0].click();", signInSubmit);
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForPageToLoad();
	}
}