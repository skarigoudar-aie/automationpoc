package com.mk.testframework.dt.page.myaccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.inject.Inject;
import com.mk.testframework.dt.util.PageUtils;

public class MyAccount_Asif {
	
	
	@FindBy(xpath = "//li[@class='mk-join']")
	private WebElement join;	
	
	@FindBy(xpath = "//input[@id='first_name']")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@id='last_name']")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@id='email_address']")
	private WebElement emailAddress;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@id='confirm_password']")
	private WebElement confirmPassword;
	
	@FindBy(xpath = "//input[@id='postal_code']")
	private WebElement postalCode;
	
	@FindBy(xpath = "//input[@title='JOIN KORSVIP']")
	private WebElement submitButton;
	
	@FindBy(xpath = "//span[@class='back_msg']")
	//(css = ".my-account .header-my-account a")
	private WebElement myAccountLink;

	private WebDriver webDriver;
	private PageUtils pageUtils;
	
	@Inject
	public MyAccount_Asif(WebDriver webDriver, PageUtils pageUtils) {
		PageFactory.initElements(webDriver, this);
		this.webDriver = webDriver;
		this.pageUtils = pageUtils;
	}

	
	
	public void clickJoin() {
		join.click();
	}
	
	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	
	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	
	public void enterEmailAddress(String email) {
		emailAddress.sendKeys(email);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	
	public void enterConfirmPassword(String cpwd) {
		confirmPassword.sendKeys(cpwd);
	}
	
	public void enterPostalCode(String zipcode) {
		postalCode.sendKeys(zipcode);
	}
	
	public void clickOnCreateAccountSubmitButton() {
		submitButton.click();
	}
	
	
	public boolean displayMyAccountLink() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(6, "Profile page load");
		//return myAccountLink.isDisplayed();
		return pageUtils.verifyIfDisplayed(myAccountLink);
	}
	 
	
	
}
