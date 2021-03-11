package com.mk.testframework.dt.header;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import com.google.inject.Inject;
import com.mk.testframework.core.exceptions.TestEnvironmentException;
import com.mk.testframework.core.exceptions.TestException;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.dt.util.PageUtils.Resource;

/**
 * @author VThipperudrappa
 *
 */
public class MkMyAccountMenu {

	@FindBy(css = ".my-account .header-my-account")
	private WebElement myAccountLink;

	@FindBy(css = ".my-account-link span")
	private WebElement sbpMyAccountLink;
	
	@FindBy(css = ".welcome_msg")
	private WebElement myAccountWelcome;

	private Actions actionBuilder;
	private WebDriver webDriver;
	private PageUtils pageUtils;

	@Inject
	public MkMyAccountMenu(WebDriver webDriver, PageUtils pageUtils) {
		PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 5), this);
		this.actionBuilder = new Actions(webDriver);
		this.webDriver = webDriver;
		this.pageUtils = pageUtils;
	}

	public FlyoutMenu flyOutMenu() {
		pageUtils.waitForWebElement(myAccountLink);
		actionBuilder.moveToElement(myAccountLink).build().perform();
		return new FlyoutMenu(webDriver);
	}

	public void clickSignOut() {
		pageUtils.waitForWebElement(sbpMyAccountLink);
		actionBuilder.moveToElement(sbpMyAccountLink).build().perform();
		pageUtils.waitForAjaxToComplete();
		new SbpFlyoutMenu().clickSignOut();
	}

	public class FlyoutMenu {
		@FindBy(css = ".signout-link")
		private WebElement signoutLink;

		public FlyoutMenu(WebDriver webDriver) {
			PageFactory.initElements(webDriver, this);
		}

		public void clickSignOut() { 
			try {
				pageUtils.waitTillWebElementIsClickable(signoutLink);
				((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", signoutLink);
				pageUtils.waitForPageToLoad();
				pageUtils.waitForAjaxToComplete();
				pageUtils.sleepSeconds(5, "SignOut clicked");
			} catch (NoSuchElementException e) {
				throw new TestEnvironmentException("Could not find menu option to click : " + e.getMessage());
			}
		}
	}

	public class SbpFlyoutMenu {
		public void clickSignOut() {
			List<WebElement> menuList = webDriver
					.findElements(By.cssSelector(".tooltip .tooltip-inner .header-account-tooltip li a"));
			ResourceBundle linksResource = pageUtils.getResourceBundle(Resource.LINKS);
			try {
				WebElement signOutLink = menuList.stream().filter(
						s -> s.getText().toLowerCase().equals(linksResource.getString("sign-out").toLowerCase()))
						.findFirst().get();
				((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", signOutLink);
				pageUtils.waitForAjaxToComplete();
				pageUtils.waitForPageToLoad();
			} catch (Exception e) {
				throw new TestException("Could not find menu option to click : " + e.getMessage());
			}
		}
	}

	public boolean waitForMyAccountLink() {
		return pageUtils.waitForWebElement(myAccountLink);
	}
	
	public boolean waitForMyAccountWelcome() {
		return pageUtils.waitForWebElement(myAccountWelcome);
	}
	
}