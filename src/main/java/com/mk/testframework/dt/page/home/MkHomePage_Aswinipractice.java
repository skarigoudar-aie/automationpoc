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
	
	@FindBy(xpath = "//a[@title='Michael Kors']//img")
	private WebElement mklogoo;
	
	@FindBy(xpath = "//*[@class='mk-join']")
	private WebElement join;
	
	@FindBy(xpath = "//*[@name='firstName']")
	private WebElement firstname;
	
	@FindBy(xpath = "//*[@name='lastName']")
	private WebElement lastname;
		
	@FindBy(xpath = "//*[@id='email_address']")
	private WebElement emailaddress;
	
	@FindBy(xpath = "(//*[@type='password'])[1]")
	private WebElement passsword;
	
	@FindBy(xpath = "//*[@id='confirm_password']")
	private WebElement comfirmpasssword;
	
	@FindBy(xpath = "//*[@id='postal_code']")
	private WebElement zipcode;
	
	@FindBy(xpath = "//*[@title='JOIN KORSVIP']")
	private WebElement joinkorsvip;
	
	private WebDriver webDriver;
	
	@Inject
	public MkHomePage_Aswinipractice( WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
		
	}

	
	  public void clickLogo() { mklogo.click();
	  
	  }
	  
	  public void clicksigninlink() { signinlink.click();
	  
	  }
	  
	  
	  public void enterUserName(String uname) { username.sendKeys(uname);
	  
	  // TODO Auto-generated method stub
	  
	  }
	  
	  public void enterPssword(String pwd) { password.sendKeys(pwd);
	 
	  }
	  

		public void clicksigninbutton() {
			signin.click();
			
		}
	  
	public void clickLogoo() {
		mklogo.click();		
		
	}
	
	public void clickjoinlink() {
		join.click();
				
	}

	public void enterFirstName(String fname) {
		firstname.sendKeys(fname);
	}	


	public void enterLastName(String lname) {
		lastname.sendKeys(lname);
	
	}

	public void enterEmailaddress(String eaddress) {
		emailaddress.sendKeys(eaddress);		
	}


	public void enterPasssword(String pwdd) {
		passsword.sendKeys(pwdd);		
	}


	public void enterConfirmPasssword(String pwddd) {
		comfirmpasssword.sendKeys(pwddd);		
	}


	public void enterZipcode (int zcode) {
        zipcode.sendKeys(Integer.toString(zcode));
       
    }
	
	public void clickjoinKorsVipButton() {
		joinkorsvip.click();		
	}
	}