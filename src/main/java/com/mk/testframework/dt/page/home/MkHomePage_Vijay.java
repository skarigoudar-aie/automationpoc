package com.mk.testframework.dt.page.home;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.core.env.Environment.Region;
import com.mk.testframework.dt.util.ModalUtils;
import com.mk.testframework.dt.util.PageUtils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Set;


public class MkHomePage_Vijay {

	@FindBy(xpath = "//button[@title='Sign In']")
	private WebElement signInLink;

	@FindBy(xpath = "//a[@title='Michael Kors']//img")
	private WebElement mkLogo;
	
	@FindBy(xpath = "//input[@id='username']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@name='sign-in']")
	private WebElement signInButton;
	
	@FindBy(xpath = "//li[@class='my-account']")
	private WebElement myAccountLink;
	
	private WebDriver webDriver;
	private PageUtils pageUtils;
	private JavascriptExecutor jsExecutor;
	
	@Inject
	public MkHomePage_Vijay( PageUtils pageUtils, WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
		this.webDriver=webDriver;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.pageUtils=pageUtils;
	}

	
	public void clickMKLogo() {
		mkLogo.click();
	}
	
	public void clickOnSignIn() {
		pageUtils.sleepSeconds(2, "Wait for page to load");
		signInLink.click();
	}
	
	public void enterUserName(String emailAddress) {
		pageUtils.sleepSeconds(2, "Wait for page to load");
		email.sendKeys(emailAddress);
	}
	public void enterPassword(String pass) {
		pageUtils.sleepSeconds(2, "Wait for page to load");
		password.sendKeys(pass);
	}
	
	public void clickOnSignInButton() {
		pageUtils.sleepSeconds(2, "Wait for page to load");
		signInButton.click();
	}
	
	public void verifyLogIn() {
		pageUtils.sleepSeconds(2, "Wait for page to load");
		assertTrue(pageUtils.verifyIfDisplayed(myAccountLink));
	}

}
