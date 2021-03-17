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

import java.nio.charset.Charset;
import java.util.List;
import java.util.Set;

/**
 * @author VThipperudrappa
 *
 */
public class MkHomePage_Aswinipractice {

		
	
	@FindBy(xpath = "//a[@title='Michael Kors']//img")
	private WebElement mklogo;

	@FindBy(xpath = "//*[@title='Sign In']")
	private WebElement signinlink;
	
	@FindBy(xpath = "//*[@id='username']")
	private WebElement username;
	
	@FindBy(xpath = "//*[@id='password']")
	private WebElement password;
	
	@FindBy(xpath = "//*[@name='sign-in']")
	private WebElement signin;
	
	@Inject
	public MkHomePage_Aswinipractice(WebDriver webDriver, PageUtils pageUtils, ModalUtils modalUtils, Context context,
			Environment env, TestData testData) {
		PageFactory.initElements(webDriver, this);
		
	}

	public void clickLogo() {
		mklogo.click();		
		
	}

	public void clicksigninlink() {
		signinlink.click();
		
	}
		

	public void enterUserName(String uname) {
		username.sendKeys(uname);
		
		// TODO Auto-generated method stub
		
	}

	public void enterPssword(String pwd) {
		password.sendKeys(pwd);
	
}

	public void clicksigninbutton() {
		signin.click();
		// TODO Auto-generated method stub
		
	}
}