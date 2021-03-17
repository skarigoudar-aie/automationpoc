package com.mk.testframework.dt.header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.inject.Inject;


public class TestStepDef {
	
	
	@FindBy(css = ".header-my-account")
	private WebElement signinlink;

	@FindBy(css = "#username")
	private WebElement uname;

	@FindBy(css = "#password")
	private WebElement pword;

	@FindBy(name = "sign-in")
	private WebElement signinbutton;

	@FindBy(xpath = "//div[@class='logo']/a/picture/img")
	private WebElement mkhomepagelogo;
	
	@FindBy(xpath="//button[@id='closekorsvipsignUpModel']")
	private WebElement korsvipoverlay;
	

	@Inject
	public TestStepDef(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		
	}
		
	public void signinlink(){
		
		signinlink.click();
	}

	public void enterUsername(String username) {
		uname.sendKeys(username);
	}

	public void enterPassword(String password) {
		pword.sendKeys(password);
	}

	public void clickOnSignin() {
		
		
		signinbutton.click();
	}

	public void clickMKLogo() {
		
		try {
			korsvipoverlay.click();
						
		} catch (Exception e) {

			mkhomepagelogo.click();
		}
				
		
	}

}