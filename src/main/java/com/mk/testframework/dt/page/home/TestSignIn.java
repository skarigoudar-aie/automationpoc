package com.mk.testframework.dt.page.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.inject.Inject;


public class TestSignIn {
	
	@FindBy(xpath = "//a[@title='Michael Kors']//img")
	private WebElement clickonLogo;
	
	
	@FindBy(xpath = "//*[@title='Sign In']")
	private WebElement SigninLink;
	
	@FindBy(css = "#username")
	private WebElement userName;
	
	@FindBy(css = "#password")
	private WebElement passWord;
	
	@FindBy(xpath = "//*[@name='sign-in']")
	private WebElement SigninButton;

	
	@Inject
	public TestSignIn(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
		
	}
	
	public void GotoHomePage() {
		clickonLogo.click();
	}
	
	public void clickOnSigninLink() {
		SigninLink.click();
	}
	
	public void enterUserName(String usename) {
		userName.sendKeys(usename);
	}
	
	public void enterPwd(String password) {
		passWord.sendKeys(password);
	}
	
	public void signButton() {
		SigninButton.click();
	}

	
	
	
	

}
