package com.mk.testframework.dt.page.home;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.util.ModalUtils;
import com.mk.testframework.dt.util.PageUtils;

public class TestSignIn {
	
	@FindBy(xpath = "//*[@title='Sign In']")
	private WebElement SigninLink;
	
	@FindBy(css = "#username")
	private WebElement userName;
	
	@FindBy(css = "#password")
	private WebElement PassWord;
	
	@FindBy(xpath = "//*[@name='sign-in']")
	private WebElement SigninButton;
	
	
	
	private WebDriver webDriver;

	private PageUtils pageUtils;
	private ModalUtils modalUtils;
	private JavascriptExecutor jsExecutor;
	private Context context;
	private Environment env;
	private TestData testData;
	private Actions actionBuilder;
	
	
	@Inject
	public TestSignIn(WebDriver webDriver, PageUtils pageUtils, ModalUtils modalUtils, Context context,
			Environment env, TestData testData) {
		PageFactory.initElements(webDriver, this);
		this.webDriver = webDriver;
		this.pageUtils = pageUtils;
		this.modalUtils = modalUtils;
		this.context = context;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.env = env;
		this.testData = testData;
		this.actionBuilder = new Actions(webDriver);
	}
	
	public void clickOnSigninLink() {
		SigninLink.click();
	}

}
