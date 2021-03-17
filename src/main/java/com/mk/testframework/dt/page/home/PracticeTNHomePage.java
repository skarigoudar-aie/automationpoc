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



public class PracticeTNHomePage {

	@FindBy(css = ".header-my-account")
	private WebElement signinmk;

	@FindBy(css = "#signin_email_address")
	private WebElement username;

	@FindBy(css = "#signin_password")
	private WebElement pword;

	@FindBy(xpath = "//*[@name='signin_submit']")
	private WebElement signinbtn;

	@FindBy(xpath = "//*[@title='Michael Kors']//img")
	private WebElement mklogo;

	

	@Inject
	public PracticeTNHomePage(WebDriver webDriver, PageUtils pageUtils, ModalUtils modalUtils, Context context,
			Environment env, TestData testData) {

		
		
		PageFactory.initElements(webDriver, this);



	}

	public void signinlink() {
		signinmk.click();
	}

	public void enterUserName(String uname) {
		username.sendKeys(uname);
	}

	public void enterPword(String pwd) {
		pword.sendKeys(pwd);
	}

	public void clickSigninBtn() {
		signinbtn.click();
	}

	public void clickLogo() {
		mklogo.click();
	}
}
