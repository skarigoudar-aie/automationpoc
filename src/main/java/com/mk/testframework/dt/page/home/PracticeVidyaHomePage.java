package com.mk.testframework.dt.page.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.util.ModalUtils;
import com.mk.testframework.dt.util.PageUtils;

import ch.qos.logback.core.Context;

public class PracticeVidyaHomePage {
	
	@FindBy(css = ".mklogo.mk-static-logo")
	private WebElement clickonLogo;
	
	@FindBy(css = ".header-my-account")
	private WebElement clickonSignInlink;
	
	@FindBy(css = "#signin_email_address")
	private WebElement enterusername;
	
	@FindBy(css = "#signin_password")
	private WebElement enterpassword;
	
	@FindBy(css = ".signin_submit.mrt.translate")
	private WebElement clickonsigninbtn;
	
	private WebDriver webDriver;
	
	@Inject
	public PracticeVidyaHomePage(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}
	
	
	
	
	public void clickonMklogo() {
		clickonLogo.click();
	}
	
	public void clickonSigninlink() {
		clickonSignInlink.click();
	}
	
	public void enterusername(String username) {
		enterusername.sendKeys(username);
	}
	
	public void enterpassword(String password) {
		enterpassword.sendKeys(password);
	}

	public void clickonsigninbtn() {
		clickonsigninbtn.click();
		
		
	}
	
	

}
