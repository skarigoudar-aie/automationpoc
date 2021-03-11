package com.mk.testframework.dt.page.checkout;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.util.PageUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author MLinderman
 *
 */
public class MkCheckoutPage_Global {
	@FindBy(css = "#checkoutContainer")
	private WebElement checkoutPage;

	@FindBy(xpath = "//*[@id='CheckoutData_BillingFirstName']")
	private WebElement billingFirstName;
	
	@FindBy(xpath = "//*[@id='CheckoutData_BillingLastName']")
	private WebElement billingLastName;
	
	@FindBy(xpath = "//*[@id='CheckoutData_Email']") 
	private WebElement checkoutDataEmail;
	
	@FindBy(xpath = "//*[@id='CheckoutData_BillingAddress1']") 
	private WebElement checkoutDataBillingAddress1;
	
	@FindBy(xpath = "//*[@id='CheckoutData_BillingAddress2']")
	private WebElement checkoutDataBillingAddress2;
	
	@FindBy(xpath = "//*[@id='BillingCity']")
	private WebElement billingCity;
	
	@FindBy(xpath = "//*[@id='BillingCountyID']")
	private WebElement billingCountyID;
	
	@FindBy(xpath = "//*[@id='BillingZIP']")
	private WebElement billingZIP;
	
	@FindBy(xpath = "//*[@id='BillingStateID']")
	private WebElement billingStateID;
	
	@FindBy(xpath = "//*[@id='CheckoutData_BillingPhone']")
	private WebElement checkoutDataBillingPhone;
	
	@FindBy(xpath = "//*[@id='cardNum'")
	private WebElement cardNum;
	
	@FindBy(xpath = "//*[@id='cardExpiryMonth']")
	private WebElement cardExpiryMonth;
	
	@FindBy(xpath = "//*[@id='cardExpiryYear'")
	private WebElement cardExpiryYear;
	
	@FindBy(xpath = "//*[@id='cvdNumber']")
	private WebElement cvdNumber;
	
	@FindBy(xpath = "//*[@id='btnPay']")
	private WebElement btnPay;
	
	private PageUtils pageUtils;
	private TestData testData;
	private WebDriver webDriver;
	private Context context;
	private JavascriptExecutor jsExecutor;


	@Inject
	public MkCheckoutPage_Global(WebDriver webDriver, PageUtils pageUtils, TestData testData, Context context) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.testData = testData;
		this.webDriver = webDriver;
		this.context = context;
		this.jsExecutor = ((JavascriptExecutor) webDriver);

	}

	public boolean onCheckoutPage() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForWebElement(checkoutPage);
		return pageUtils.verifyIfDisplayed(checkoutPage);
	}
	
	public void fillUpRequiredFields() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		jsExecutor.executeScript("document.getElementById('checkoutDataBillingAddress1').setAttribute('value', 'new value for element')");
		pageUtils.scrollToElement(checkoutDataBillingAddress1);
		checkoutDataBillingAddress1.sendKeys(testData.getUser().address.getStreetAddress1());
		checkoutDataBillingAddress2.sendKeys(testData.getUser().address.getStreetAddress2());
		billingCity.sendKeys(testData.getUser().address.getCity());
		billingZIP.sendKeys(testData.getUser().address.getPostalCode());
		billingFirstName.sendKeys(testData.getUser().getFirstname());
		billingLastName.sendKeys(testData.getUser().getLastname());
		checkoutDataBillingPhone.sendKeys(testData.getUser().getPhoneNumber());
		checkoutDataEmail.sendKeys(testData.getUser().getEmail());
	}

}
