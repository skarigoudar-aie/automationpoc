package com.mk.testframework.dt.page.checkout;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.dt.util.PageUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * @author MLinderman
 *
 */
public class MkCheckoutBilling_Global {

	@FindBy(css = "#CheckoutData_BillingFirstName")
	private WebElement firstName;

	@FindBy(css = "#CheckoutData_BillingLastName")
	private WebElement lastName;

	@FindBy(css = "#CheckoutData_BillingAddress1")
	private WebElement address1;

	@FindBy(css = "#CheckoutData_BillingAddress2")
	private WebElement address2;

	@FindBy(css = "#BillingCity")
	private WebElement city;

	@FindBy(css = "#BillingZIP")
	private WebElement postalCode;

	@FindBy(css = "#BillingStateID")
	private WebElement state;

	@FindBy(css = "#CheckoutData_BillingPhone")
	private WebElement phone;

	@FindBy(css = "#CheckoutData_Email")
	private WebElement email;

	@FindBy(css = "#new-card-container .payment--method--tab")
	private WebElement newCardPaymentOption;

	@FindBy(css = "#payment-form .panel-open")
	private WebElement newCardPaymentPanelOpen;

	@FindBy(css = "#creditCardName")
	private WebElement cardHolderName;

	@FindBy(css = "#payment-card-number")
	private WebElement cardNumber;

	@FindBy(css = "button[data-id='month-select']")
	private WebElement cardExpirationMM;

	@FindBy(how = How.XPATH, using = "//*[@data-id='month-select']//parent::div[contains(@class,open)]//li//a")
	private List<WebElement> cardExpirationMMList;

	@FindBy(css = "button[data-id='year-select']")
	private WebElement cardExpirationYYYY;

	@FindBy(how = How.XPATH, using = "//*[@data-id='year-select']//parent::div[contains(@class,open)]//li//a")
	private List<WebElement> cardExpirationYYYYList;

	@FindBy(css = "#cardCVV")
	private WebElement cardSecurityCode;
	
	@FindBy(xpath = "//*[@id='btnPay']")
	private WebElement btnPay;

	@FindBy(css = "#cardNum")
	private WebElement cardNum1;
	
	@FindBy(css = "#cardExpiryMonth")
	private WebElement cardExpiryMonth1;
	
	@FindBy(css = "#cardExpiryYear")
	private WebElement cardExpiryYear1;
	
	@FindBy(css = "#cvdNumber")
	private WebElement cvdNumber1;
		
	@FindBy(css = "#cardsShowPM_1")
	private WebElement cardNum;
	
	@FindBy(css = "//*[@id='cardExpiryMonth']")
	private WebElement cardExpiryMonth;
	
	@FindBy(xpath = "//*[@id='cardExpiryYear'")
	private WebElement cardExpiryYear;
	
	@FindBy(xpath = "//*[@id='cvdNumber']")
	private WebElement cvdNumber;
	
	@FindBy(css = "#pmContainer div")
	private List<WebElement> paymentTypes;
	
	@FindBy(css = "#BillingStateID")
	private WebElement billingStateID;
	
	@FindBy(css = "#avpBtnUseOrig")
	private WebElement useThisButton;
	
	@FindBy(css = "#BillingSalutationID")
	private WebElement titleDropdown;
	
	@FindBy(xpath = "//span[@title='PayPal']")
	private WebElement paypal;
	
	
	private PageUtils pageUtils;
	private JavascriptExecutor jsExecutor;
	private TestData testData;
	private WebDriver webDriver;

	@Inject
	public MkCheckoutBilling_Global(WebDriver webDriver, PageUtils pageUtils, TestData testData) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.testData = testData;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.webDriver = webDriver;
	}

	public void switchFocusToCheckoutFrame(){
		webDriver.switchTo().frame(webDriver.findElement(By.cssSelector("iframe[id=\"Intrnl_CO_Container\"]")));
	}

	public void switchFocusToCheckoutPaymentFrame(){
		webDriver.switchTo().frame(webDriver.findElement(By.cssSelector("iframe[id=\"secureWindow\"]")));
	}
	
	public void switchFocusFromFrameToMain(){
		webDriver.switchTo().defaultContent();
	}

	public void fillFirstName(String userFirstName){
		switchFocusToCheckoutFrame();
		firstName.sendKeys(userFirstName);
		switchFocusFromFrameToMain();
	}

	public void fillLastName(String userLastName){
		switchFocusToCheckoutFrame();
		lastName.sendKeys(userLastName);
		switchFocusFromFrameToMain();
	}

	public void fillEmail(String userEmail){
		switchFocusToCheckoutFrame();
		email.sendKeys(userEmail);
		switchFocusFromFrameToMain();
	}

	public void fillAddressLine1(String userAddress1){
		switchFocusToCheckoutFrame();
		address1.sendKeys(userAddress1);
		switchFocusFromFrameToMain();
	}

	public void fillAddressLine2(String userAddress2){
		switchFocusToCheckoutFrame();
		try{
			address2.sendKeys(userAddress2);
		}
		catch(Exception e){
		}
		switchFocusFromFrameToMain();
	}

	public void fillCityLine(String userCity){
		switchFocusToCheckoutFrame();
		city.sendKeys(userCity);
		switchFocusFromFrameToMain();
	}

	public void fillPostalCode(String userPostalCode){
		switchFocusToCheckoutFrame();
		try{
			postalCode.sendKeys(userPostalCode);
		}
		catch(Exception e){
		}
		switchFocusFromFrameToMain();
	}

	public void selectStateOrProvince(String stateOrProvince){
		switchFocusToCheckoutFrame();
		try{
			selectStateOption(stateOrProvince);
			pageUtils.waitForAjaxToComplete();
		}
		catch(Exception e){
		}
		switchFocusFromFrameToMain();
	}

	public void fillPhone(String userPhone){
		switchFocusToCheckoutFrame();
		phone.sendKeys(userPhone);
		switchFocusFromFrameToMain();
	}


	public boolean isEmailAddressFieldDisplayed(){
		switchFocusToCheckoutFrame();
		boolean emailDisplayed = pageUtils.verifyIfDisplayed(email);
		switchFocusFromFrameToMain();

		return emailDisplayed;
	}

	public void selectTitle() {
		pageUtils.sleepSeconds(5, "wait for page load");
		switchFocusToCheckoutFrame();
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(1, "wait for page load");
		Select sel = new Select(titleDropdown);
		sel.selectByVisibleText(testData.getUser().getTitle());
		switchFocusFromFrameToMain();
	}
	
	public void fillUpRequiredFields() {
		selectTitle();
		fillFirstName(testData.getUser().getFirstname());
		fillLastName(testData.getUser().getLastname());
		fillEmail(testData.getUser().getEmail());
		fillAddressLine1(testData.getUser().address.getStreetAddress1());

		try{
			fillAddressLine2(testData.getUser().address.getStreetAddress2());
		}
		catch(Exception e){
		}

		fillCityLine(testData.getUser().address.getCity());

		try{
			fillPostalCode(testData.getUser().address.getPostalCode());
		}
		catch(Exception e){
		}

		selectStateOrProvince(testData.getUser().address.getProvince());
		fillPhone(testData.getUser().getPhoneNumber());
	}

	private List<WebElement> getStateOptions() {
		pageUtils.waitForAjaxToComplete();
		pageUtils.scrollToElement(state);
		state.click();
		pageUtils.sleepSeconds(1, "for popup to load");
		List<WebElement> selectDropdown = webDriver
				.findElements(By.cssSelector("#BillingStateID option"));
		return selectDropdown;
	}

	public void selectStateOption(String stateName){
		boolean stateFound= false;
		int i=0;
		while (!stateFound && i<getStateOptions().size()){
			state.sendKeys(Keys.ARROW_DOWN);
			WebElement option = getStateOptions().get(i);
			if(option.getAttribute("innerText").toLowerCase().equals(stateName.toLowerCase())){
				state.sendKeys(Keys.TAB);
				pageUtils.waitForAjaxToComplete();
				pageUtils.waitForPageToLoad();
				stateFound = true;
				break;
			}
			else{
				i++;
			}
		}
	}

	public void clickCardPaymentOption() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(1, "wait for page load");
		pageUtils.waitForAjaxToComplete();

		pageUtils.waitForWebElement(newCardPaymentOption);
		newCardPaymentOption.click();

		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(1, "wait for page load");
		pageUtils.waitForAjaxToComplete();
	}

	public boolean isCardPaymentPanelOpen() {
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForWebElement(newCardPaymentPanelOpen);
		return pageUtils.verifyIfDisplayed(newCardPaymentOption);
	}

	public void fillCardholderNameField() {
		switchFocusToCheckoutFrame();
		pageUtils.waitTillWebElementIsClickable(cardHolderName);
		cardHolderName.sendKeys(testData.getUser().getFirstname()+" "+testData.getUser().getLastname());
		switchFocusFromFrameToMain();
	}

	public void fillCardNumberField() {
		switchFocusToCheckoutFrame();
		pageUtils.scrollToElement(paymentTypes.get(0));
		switchFocusToCheckoutPaymentFrame();
		try {
			pageUtils.waitTillWebElementIsClickable(cardNum1);
			String card = testData.getCard().getCardNumber();
			pageUtils.scrollToElement(cardNum1);
			cardNum1.sendKeys(testData.getCard().getCardNumber());
		} catch (Exception e) {
		}
		switchFocusFromFrameToMain();
	}

	public void clickCardExpirationMM() {
		switchFocusToCheckoutFrame();
		switchFocusToCheckoutPaymentFrame();
		pageUtils.scrollToElement(cardExpiryMonth1);
		cardExpiryMonth1.click();
		pageUtils.waitForAjaxToComplete();
		switchFocusFromFrameToMain();
	}

	public void selectCardExpirationMM() {
		clickCardExpirationMM();
		String expectedExpirationMM = testData.getCard().getExpirationMM();
		WebElement expirationMM = cardExpirationMMList.stream()
				.filter(s -> s.getAttribute("innerText").equals(expectedExpirationMM)).findFirst().get();
		jsExecutor.executeScript("arguments[0].click();", expirationMM);
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForPageToLoad();
	}

	public void clickCardExpirationYYYY() {
		switchFocusToCheckoutFrame();
		switchFocusToCheckoutPaymentFrame();
		pageUtils.scrollToElement(cardExpiryYear1);
		cardExpiryYear1.click();
		pageUtils.waitForAjaxToComplete();
		switchFocusFromFrameToMain();
	}

	public void selectCardExpirationYYYY() {
		clickCardExpirationYYYY();
		String expectedExpirationYYYY = testData.getCard().getExpirationYYYY();
		WebElement expirationYYYY = cardExpirationYYYYList.stream()
				.filter(s -> s.getAttribute("innerText").equals(expectedExpirationYYYY)).findFirst().get();
		jsExecutor.executeScript("arguments[0].click();", expirationYYYY);
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForPageToLoad();
	}

	public void fillCardSecurityCodeField() {
		switchFocusToCheckoutFrame();
		switchFocusToCheckoutPaymentFrame();
		pageUtils.sleepSeconds(1, "wait");
		pageUtils.waitTillWebElementIsClickable(cvdNumber1);
		cvdNumber1.sendKeys(testData.getCard().getSecurityCode());
		switchFocusFromFrameToMain();
	}

	public void fillCardDetails() {
		fillCardNumberField();
		selectExpiryYear();
		selectExpiryMonth();
		fillCardSecurityCodeField();
	}
	
	public void selectPaypal() {
		switchFocusToCheckoutFrame();
		pageUtils.sleepSeconds(2, "wait");
		paypal.click();
		switchFocusFromFrameToMain();
	}
	
	public void clickOnPay() {
		switchFocusToCheckoutFrame();
		try {
			pageUtils.sleepSeconds(2, "wait");
			pageUtils.scrollToElement(btnPay);
			btnPay.click();
		} catch (Exception e) {
			pageUtils.sleepSeconds(2, "wait");
			pageUtils.scrollToElement(btnPay);
			btnPay.click();
		}
		switchFocusFromFrameToMain();
	}
	
	public void clickOnUseThisButton() {
		switchFocusToCheckoutFrame();
		try {
			pageUtils.waitForPageToLoad();
			pageUtils.sleepSeconds(5, "wait");
			useThisButton.click();
			switchFocusFromFrameToMain();
		} catch (Exception e) {
			pageUtils.sleepSeconds(5, "wait");
			useThisButton.click();
			switchFocusFromFrameToMain();
		}
	}
	
	public void selectExpiryYear() {
		switchFocusToCheckoutFrame();
		switchFocusToCheckoutPaymentFrame();
		Select dropdown = new Select(cardExpiryYear1);
		dropdown.selectByValue(testData.getCard().getExpirationYYYY());
		switchFocusFromFrameToMain();
	}
	
	public void selectExpiryMonth() {
		switchFocusToCheckoutFrame();
		switchFocusToCheckoutPaymentFrame();
		pageUtils.sleepSeconds(1, "wait");
		Select dropdown = new Select(cardExpiryMonth1);
		dropdown.selectByValue(testData.getCard().getExpirationMM());
		switchFocusFromFrameToMain();
	}
	
	public void selectState(String stateName) {
		switchFocusToCheckoutFrame();
		try{
			Select dropdown = new Select(billingStateID);
			dropdown.selectByValue(stateName);
			pageUtils.waitForAjaxToComplete();
		}
		catch(Exception e){
		}
		switchFocusFromFrameToMain();
	}
}
