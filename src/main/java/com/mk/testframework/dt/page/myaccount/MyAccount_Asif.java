package com.mk.testframework.dt.page.myaccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.inject.Inject;

public class MyAccount_Asif {
	
	
	@FindBy(xpath = "//li[@class='mk-join']")
	private WebElement join;	
	
	@FindBy(css = ".first_name")
	private WebElement firstName;
	
	@FindBy(css = ".last_name")
	private WebElement lastName;
	
	@FindBy(css = ".email_address")
	private WebElement emailAddress;
	
	@FindBy(css = ".password")
	private WebElement password;
	
	@FindBy(css = ".confirm_password")
	private WebElement confirmPassword;
	
	@FindBy(css = ".postal_code")
	private WebElement postalCode;
	
	@FindBy(xpath = "//input[contains(@type,'submit')])[1]")
	private WebElement submitButton;
	
	@FindBy(css = ".my-account .header-my-account a")
	private WebElement myAccountLink;

	private WebDriver webDriver;
	
	@Inject
	public MyAccount_Asif(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
		this.webDriver = webDriver;
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
		return myAccountLink.isDisplayed();
	}
	 
}
