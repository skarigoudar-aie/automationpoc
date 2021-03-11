package com.mk.testframework.dt.popup;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.page.account.MkCreateAccountPage_NA;
import com.mk.testframework.dt.util.PageUtils;

/**
 * @author MLinderman
 *
 */
public class MkSignInModal_NA {

	@FindBy(css=".sign-in-model-sub-wrapper")
	private WebElement signInContainer;

	@FindBy(id="username")
	private WebElement signInEmailAddress;

	@FindBy(id="password")
	private WebElement signInPassword;

	@FindBy(name="sign-in")
	private WebElement signInSubmit;

	private PageUtils pageUtils;
	private JavascriptExecutor jsExecutor;
	
	@FindBy(id="username")
	private WebElement LogInEmailAddress;
	
	@FindBy(css = ".global_error_msg_container")
	private WebElement invalidcredentials; 
	
	@FindBy(css = ".zipcode-model-sub-wrapper")
	private WebElement zipCodeContainer;
	
	private MkCreateAccountPage_NA mkCreateAccountPageNA;
	private Context context;


	@Inject
	public MkSignInModal_NA(WebDriver webDriver, PageUtils pageUtils, MkCreateAccountPage_NA mkCreateAccountPageNA, Context context) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.mkCreateAccountPageNA = mkCreateAccountPageNA;
		this.context = context;
	}

	public boolean verifySignInLink() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		return pageUtils.verifyIfDisplayed(signInContainer);
	}

	public void enterEmailAddress(String email) {
		signInEmailAddress.sendKeys(email);
	}

	public void enterPassword(String password) {
		pageUtils.waitForPageToLoad();
		signInPassword.sendKeys(password);
	}

	public void clickSignIn() {
		pageUtils.waitForPageToLoad();
		jsExecutor.executeScript("arguments[0].click();", signInSubmit);
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForPageToLoad();
	}
	
	 public void enterCreatedEmailAddress(String email) {
			pageUtils.waitForPageToLoad();
			pageUtils.waitForWebElement(LogInEmailAddress);
			LogInEmailAddress.sendKeys(email);
		}
	 

		public boolean unsuccessfulLoginAttemps(int numAttemps) {
			String expectedText = pageUtils.getTextTranslation("your-account-is-locked-ca");
			boolean flag = false;
			mkCreateAccountPageNA.enterCreatedEmailAddress(context.getSavedData("email"));
		
			try {
				for (int i = 1; i < numAttemps+1; i++) {
					enterPassword("wdcws");
					pageUtils.sleepSeconds(3, "wait for popUp");
					clickSignIn();
					pageUtils.sleepSeconds(3, "wait for popUp");
					if (invalidcredentials.getText().equalsIgnoreCase(expectedText))
					{
						flag = true;
						break;
					}
				}
			} catch (Exception e) {
			}
			return flag;
		}
}