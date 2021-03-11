package com.mk.testframework.dt.page.account;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.google.inject.Inject;
import com.mk.testframework.dt.util.ModalUtils;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.core.env.Environment;


/**
 * @author Raja
 *
 */

public class MkCreateAccountPage_Global {
    
	@FindBy(id="signin_email_address")
    private WebElement signInEmailAddress;
	
	@FindBy(id="signin_password")
    private WebElement Password;
	
	@FindBy(id = "signin_email_address-error")
	private WebElement invalidcredentials;

	@FindBy(name="signin_submit")
	private WebElement signInSubmit;
	
	private PageUtils pageUtils;
	private JavascriptExecutor jsExecutor;

			
	@Inject
	public MkCreateAccountPage_Global(ModalUtils modalUtils, WebDriver webDriver, PageUtils pageUtils, Environment env) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.jsExecutor = ((JavascriptExecutor) webDriver);	
	}

	
	public void enterCreatedEmailAddress(String email) {
				
			pageUtils.waitForWebElement(signInEmailAddress);
			signInEmailAddress.sendKeys(email);
		}
	
	
	public void enterPassword(String password) {
			pageUtils.waitForWebElement(Password);
			Password.sendKeys(password);
		  }
	
	public void clickSignIn() {
		jsExecutor.executeScript("arguments[0].click();", signInSubmit);
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForPageToLoad();
	}
	
	public boolean unsuccessfulLoginSteps(int numAttemps) {
		String expectedText = pageUtils.getTextTranslation("your-account-is-locked");
		boolean flag = false;

		try {
			for (int i = 1; i < numAttemps+1; i++) {
				enterPassword("wdcws");
				clickSignIn();

				if (invalidcredentials.getText().equalsIgnoreCase(expectedText)) {
					flag = true;
					break;
				}

			}
		} catch (Exception e) {

		}
		return flag;
	}
			
}
