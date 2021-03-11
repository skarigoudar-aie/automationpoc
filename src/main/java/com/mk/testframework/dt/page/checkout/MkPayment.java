package com.mk.testframework.dt.page.checkout;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.util.PageUtils;

public class MkPayment {

	@FindBy(css = "button[aria-controls='klarna_payments_pay_later-body']")
	private WebElement payLaterWithKlarna;

	@FindBy(css = "button[aria-controls='klarna_payments_pay_now-body']")
	private WebElement payNowWithKlarna;
	
	@FindBy(css = "button[aria-controls='klarna_payments_pay_over_time-body']")
	private WebElement payOverTimeWithKlarna;

	@FindBy(xpath = "//*[@name = 'installments']")
	private WebElement onlineBankTransfer;
	
	@FindBy(xpath = "(//*[@name = 'installments'])[2]")
	private WebElement bankAccount;

	@FindBy(css = ".input-field")
	private WebElement enterOTP;

	@FindBy(xpath = "//input[@class=\"button primary\" and @type=\"submit\"]")
	private WebElement submitButtonAfterOTP;

	@FindBy(css = "#klarna-klarna-payments-pay-now-cont-fullscreen")
	private WebElement klarnaSofortPopUpFrameOuter;

	@FindBy(xpath = "//*[@id='direct-bank-transfer-wizard__container']/div/span/div/iframe")
	private WebElement klarnaSofortPopUpFrameInner;

	@FindBy(xpath = "//*[@class=\"payment3DSContainer\"]/iframe")
	private WebElement purchaseAuthenticationFrameOuter;

	@FindBy(xpath = "//*[@id=\"stepUpView\"]/div[1]/iframe")
	private WebElement purchaseAuthenticationFrameInner;

	@FindBy(css = "#password")
	private WebElement password;

	@FindBy(xpath = "//*[@value=\"Submit\" and @name=\"UsernamePasswordEntry\"]")
	private WebElement submitButton;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement enterPaypalEmail;

	@FindBy(css = "#btnNext")
	private WebElement paypalNextButton;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement paypalpWD;

	@FindBy(xpath = "//button[@id='btnLogin']")
	private WebElement paypalLoginButton;

	@FindBy(xpath = "//button[@id='payment-submit-btn']")
	private WebElement paypalPayNowButton;

	@FindBy(css = "#acceptAllButton")
	private WebElement acceptCookie;
	
	@FindBy(css = "#BankCodeSearch")
	private WebElement bankNameInput;

	@FindBy(css = "#SenderBank")
	private WebElement bankNameselect;

	@FindBy(css = ".button-right")
	private WebElement nextButtonOnSofortPopUp;

	@FindBy(css = "#BackendFormLOGINNAMEUSERID")
	private WebElement sofortAccountNumber;

	@FindBy(css = "#BackendFormUSERPIN")
	private WebElement sofortUserPIN;

	@FindBy(css = "#BackendFormTan")
	private WebElement sofortTANDE;

	@FindBy(css = "#BackendFormTAN")
	private WebElement sofortTanCH;
	
	/*
	 * @FindBy(css = "#paynow-aligned-content__button__0") private WebElement
	 * continueButtonDirectDebit;
	 */
	@FindBy(css = "#mandate-review__confirmation-button")
	private WebElement continueButtonDirectDebit;
	 
	@FindBy(xpath = "//*[@name ='iban']")
	private WebElement enterIBAN;
	
	@FindBy(xpath = "//*[@name ='continue']")
	private WebElement submitIBAN;
	
	@FindBy(xpath = "//*[@id='mandate-signup-sepa-details-confirmation__footer-button-wrapper']/div/button")
	private WebElement confirmIBAN;
	
	@FindBy(css = "#button")
	private WebElement continueButton;

	private TestData testData;
	private PageUtils pageUtils;
	private WebDriver webDriver;
	private JavascriptExecutor jsExecutor;
	private Environment environment;

	@Inject
	public MkPayment(WebDriver webDriver, PageUtils pageUtils, TestData testData, Environment environment) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.testData = testData;
		this.webDriver = webDriver;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.environment = environment;
	}

	public void clickPayNowWithKlarna() {
		pageUtils.scrollToElement(payNowWithKlarna);
		pageUtils.waitTillWebElementIsClickable(payNowWithKlarna);
		jsExecutor.executeScript("arguments[0].click();", payNowWithKlarna);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(5, "klarna wait");
	}

	public void clickOnlineBankTransferWithKlarna() {
		webDriver.switchTo().frame("klarna-klarna-payments-pay-now-cont-main");
		pageUtils.waitTillWebElementIsClickable(onlineBankTransfer);
		jsExecutor.executeScript("arguments[0].click();", onlineBankTransfer);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		webDriver.switchTo().defaultContent();
		pageUtils.sleepSeconds(2, "klarna wait");
	}
	
	public void clickBankAccountWithKlarna() {
		webDriver.switchTo().frame("klarna-klarna-payments-pay-now-cont-main");
		pageUtils.waitTillWebElementIsClickable(bankAccount);
		jsExecutor.executeScript("arguments[0].click();", bankAccount);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		webDriver.switchTo().defaultContent();
		pageUtils.sleepSeconds(2, "klarna wait");
	}

	public void fillSofortPopUpInformationKlarna() {
		webDriver.switchTo().frame(klarnaSofortPopUpFrameOuter);
		webDriver.switchTo().frame(klarnaSofortPopUpFrameInner);
		if (environment.getCurrentLocale().getCountry().toLowerCase().equals("de")) {
			enterBankNameSofortKlarna();
		} else if (environment.getCurrentLocale().getCountry().toLowerCase().equals("ch")) {
			selectBankNameSofortKlarna();
		}
		clickOnNextSofortPopUp();
		enterSofortAccountNumber();
		enterSofortUserPIN();
		clickOnNextSofortPopUp();
		pageUtils.sleepSeconds(2, "wait for default account to show");
		clickOnNextSofortPopUp();
		if (environment.getCurrentLocale().getCountry().toLowerCase().equals("de")) {
			enterSofortTANDE();
		} else if (environment.getCurrentLocale().getCountry().toLowerCase().equals("ch")) {
			enterSofortTANCH();
		}
		clickOnNextSofortPopUp();
		pageUtils.waitForPageToLoad();
	}

	public void selectBankNameSofortKlarna() {
		pageUtils.waitForWebElement(bankNameselect);
		Select bankName = new Select(bankNameselect);
		bankName.selectByVisibleText(testData.getKlarnaSoforts().getBankName());
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "klarna wait");
	}

	public void enterBankNameSofortKlarna() {
		pageUtils.waitForWebElement(bankNameInput);
		bankNameInput.sendKeys(testData.getKlarnaSoforts().getBankName());
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "klarna wait");
	}

	public void clickOnNextSofortPopUp() {
		pageUtils.waitTillWebElementIsClickable(nextButtonOnSofortPopUp);
		jsExecutor.executeScript("arguments[0].click();", nextButtonOnSofortPopUp);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(5, "klarna wait");
	}

	public void enterSofortAccountNumber() {
		pageUtils.waitTillWebElementIsClickable(sofortAccountNumber);
		sofortAccountNumber.sendKeys(testData.getKlarnaSoforts().getAccountNumber());
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(2, "klarna wait");
	}

	public void enterSofortUserPIN() {
		pageUtils.waitForWebElement(sofortUserPIN);
		sofortUserPIN.sendKeys(testData.getKlarnaSoforts().getPIN());
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(2, "klarna wait");
	}

	public void enterSofortTANDE() {
		pageUtils.waitForWebElement(sofortTANDE);
		sofortTANDE.sendKeys(testData.getKlarnaSoforts().getTAN());
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(2, "klarna wait");
	}

	public void enterSofortTANCH() {
		pageUtils.waitForWebElement(sofortTanCH);
		sofortTanCH.sendKeys(testData.getKlarnaSoforts().getTAN());
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(2, "klarna wait");
	}

	public void clickPayLaterWithKlarna() {
		pageUtils.scrollToElement(payLaterWithKlarna);
		pageUtils.waitTillWebElementIsClickable(payLaterWithKlarna);
		jsExecutor.executeScript("arguments[0].click();", payLaterWithKlarna);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(5, "klarna wait");
	}

	public void clickPayIn14Days() {
		webDriver.switchTo().frame("klarna-klarna-payments-pay-later-cont-main");
		List<WebElement> l1 = webDriver.findElements(By.tagName("label"));
		l1.stream().filter(s -> s.getText().contains("14")).findAny().get().click();
		webDriver.switchTo().defaultContent();
	}

	public void clickPayIn2Months() {
		webDriver.switchTo().frame("klarna-klarna-payments-pay-later-cont-main");
		List<WebElement> l1 = webDriver.findElements(By.tagName("label"));
		l1.stream().filter(s -> s.getText().contains("2")).findAny().get().click();
		webDriver.switchTo().defaultContent();
	}

	public void clickPayIn30Days() {
		webDriver.switchTo().frame("klarna-klarna-payments-pay-later-cont-main");
		List<WebElement> l1 = webDriver.findElements(By.id("invoice-header"));
		l1.stream().filter(s -> s.getText().contains("30")).findAny().get().click();
		webDriver.switchTo().defaultContent();
	}

	public void enterOTP(String otp) {
		pageUtils.sleepSeconds(10, "wait for page load");
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		if (pageUtils.verifyIfDisplayed(enterOTP)) {
			enterOTP.sendKeys(otp);
		} else {
			password.sendKeys(otp);
		}

	}

	public void clickOnSubmitButton() {
		pageUtils.sleepSeconds(2, "wait for page load");
		if (pageUtils.verifyIfDisplayed(submitButtonAfterOTP)) {
			submitButtonAfterOTP.click();
		} else {
			submitButton.click();
		}
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(20, "wait for page load");
	}

	public void purchaseAuthenticationIfDisplaied(String otp) {
		pageUtils.sleepSeconds(5, "wait for page load");
		if (pageUtils.verifyIfDisplayed(purchaseAuthenticationFrameOuter)) {
			webDriver.switchTo().frame(purchaseAuthenticationFrameOuter);
			webDriver.switchTo().frame(purchaseAuthenticationFrameInner);
			pageUtils.sleepSeconds(15, "Wait for page to load");
			enterOTP(otp);
			clickOnSubmitButton();
		}

		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(10, "Wait for order confirmation page to load");
	}

	public void fillUpPaypalPaymentDetais_NA() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(3, "wait for page load");

		String winHandleBefore = webDriver.getWindowHandle();

		for (String winHandle : webDriver.getWindowHandles()) {
			webDriver.switchTo().window(winHandle);
		}

		pageUtils.sleepSeconds(10, "wait for page load");

		try {
			if (acceptCookie.isDisplayed()) {
				pageUtils.waitTillWebElementIsClickable(acceptCookie);
				// acceptCookie.click();
				jsExecutor.executeScript("arguments[0].click();", acceptCookie);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			enterPaypalEmail.clear();
			enterPaypalEmail.sendKeys(testData.getCard().getPayPalEmail());
			pageUtils.sleepSeconds(3, "wait for page load");

			paypalNextButton.click();

			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(5, "wait for page load");
			paypalpWD.sendKeys(testData.getCard().getPayPalPWD());
			pageUtils.waitForPageToLoad();
			jsExecutor.executeScript("arguments[0].click();", paypalLoginButton);
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(20, "wait for page load");
			pageUtils.waitForWebElement(paypalPayNowButton);
			jsExecutor.executeScript("arguments[0].click();", paypalPayNowButton);
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(10, "wait for page load");
			webDriver.switchTo().window(winHandleBefore);
			pageUtils.waitForPageToLoad();
		} catch (Exception e) {
			try {
				if (paypalpWD.isDisplayed()) {
					
					paypalpWD.sendKeys(testData.getCard().getPayPalPWD());
					pageUtils.waitForPageToLoad();
					jsExecutor.executeScript("arguments[0].click();", paypalLoginButton);
					pageUtils.waitForPageToLoad();
					pageUtils.waitForAjaxToComplete();
					pageUtils.sleepSeconds(20, "wait for page load");
					pageUtils.waitForWebElement(paypalPayNowButton);
					jsExecutor.executeScript("arguments[0].click();", paypalPayNowButton);
					pageUtils.waitForAjaxToComplete();
					pageUtils.sleepSeconds(10, "wait for page load");
					webDriver.switchTo().window(winHandleBefore);
					pageUtils.waitForPageToLoad();
				}
			} catch (Exception e2) {
				pageUtils.sleepSeconds(10, "wait for page load");
				pageUtils.waitForWebElement(paypalPayNowButton);
				jsExecutor.executeScript("arguments[0].click();", paypalPayNowButton);
				pageUtils.waitForAjaxToComplete();
				pageUtils.sleepSeconds(10, "wait for page load");
				webDriver.switchTo().window(winHandleBefore);
				pageUtils.waitForPageToLoad();
			}
		}
	}

	public void fillUpPaypalPaymentDetais() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(10, "wait for page load");

		try {
			pageUtils.waitTillWebElementIsClickable(acceptCookie);
			pageUtils.sleepSeconds(10, "wait for page load");
			acceptCookie.click();
		} catch (Exception e) {

		}
		try {
			enterPaypalEmail.clear();
			pageUtils.sleepSeconds(5, "wait for page load");
			enterPaypalEmail.sendKeys(testData.getCard().getPayPalEmail());
			pageUtils.sleepSeconds(5, "wait for page load");
			paypalNextButton.click();
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(8, "wait for page load");
			paypalpWD.sendKeys(testData.getCard().getPayPalPWD());
			pageUtils.waitForPageToLoad();
			jsExecutor.executeScript("arguments[0].click();", paypalLoginButton);
			pageUtils.sleepSeconds(10, "wait for page load");
			pageUtils.waitForAjaxToComplete();
			pageUtils.waitForWebElement(paypalPayNowButton);
			jsExecutor.executeScript("arguments[0].click();", paypalPayNowButton);
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(10, "wait for page load");
		} catch (Exception e) {
			try {
				if (paypalpWD.isDisplayed()) {
					paypalpWD.sendKeys(testData.getCard().getPayPalPWD());
					pageUtils.waitForPageToLoad();
					jsExecutor.executeScript("arguments[0].click();", paypalLoginButton);
					pageUtils.sleepSeconds(10, "wait for page load");
					pageUtils.waitForAjaxToComplete();
					pageUtils.waitForWebElement(paypalPayNowButton);
					jsExecutor.executeScript("arguments[0].click();", paypalPayNowButton);
					pageUtils.waitForAjaxToComplete();
					pageUtils.sleepSeconds(10, "wait for page load");
				}
			} catch (Exception exception) {
				
				try {

						pageUtils.sleepSeconds(10, "wait for page load");
						pageUtils.waitForWebElement(paypalPayNowButton);
						jsExecutor.executeScript("arguments[0].click();", paypalPayNowButton);
						pageUtils.waitForAjaxToComplete();
						pageUtils.sleepSeconds(10, "wait for page load");
						
				} catch (Exception exceptions) {
					continueButton.click();
					pageUtils.sleepSeconds(5, "wait for page load");
					pageUtils.waitForWebElement(continueButton);
					continueButton.click();
					pageUtils.waitForAjaxToComplete();
					pageUtils.sleepSeconds(10, "wait for page load");
				}
			}
		}

	}

	public void clickOnPayNowButton_NA() {
		pageUtils.sleepSeconds(3, "wait for page load");
		String winHandleBefore = webDriver.getWindowHandle();

		for (String winHandle : webDriver.getWindowHandles()) {
			webDriver.switchTo().window(winHandle);
		}
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(15, "wait for page load");
		pageUtils.waitForWebElement(paypalPayNowButton);
		jsExecutor.executeScript("arguments[0].click();", paypalPayNowButton);
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(30, "wait for page load");
		webDriver.switchTo().window(winHandleBefore);
		pageUtils.waitForPageToLoad();
		webDriver.switchTo().defaultContent();
	}
	
	public void filldirectDebitPopUpInformationKlarna() {
		pageUtils.waitTillWebElementIsVisible(By.id("klarna-klarna-payments-pay-now-cont-fullscreen"));
		webDriver.switchTo().frame(klarnaSofortPopUpFrameOuter);
		webDriver.findElement(By.id("purchase-approval-form-date-of-birth")).sendKeys("10101970");
		webDriver.findElement(By.id("purchase-approval-form-continue-button")).click();
		pageUtils.sleepSeconds(2, "wait for klarna direct debit");
		if(pageUtils.waitTillWebElementIsClickable(continueButtonDirectDebit)) {
			jsExecutor.executeScript("arguments[0].click();", continueButtonDirectDebit);
			pageUtils.sleepSeconds(2, "wait for klarna direct debit");
		}else {
			enterIBAN.sendKeys("DE11520513735120710131");
			jsExecutor.executeScript("arguments[0].click();", submitIBAN);
			pageUtils.sleepSeconds(2, "wait for confirm button to display");
			jsExecutor.executeScript("arguments[0].click();", confirmIBAN);		
		}	
		pageUtils.waitForPageToLoad();
		webDriver.switchTo().defaultContent();
		pageUtils.sleepSeconds(5, "wait for order completion");
	}
	
	public void clickPayOverTimeWithKlarna() {
		pageUtils.scrollToElement(payOverTimeWithKlarna);
		pageUtils.waitTillWebElementIsClickable(payOverTimeWithKlarna);
		jsExecutor.executeScript("arguments[0].click();", payOverTimeWithKlarna);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(5, "klarna pay over time wait");
	}
	
	public void clickPayIn6MonthsKlarnaSliceIt() {
		webDriver.switchTo().frame("klarna-klarna-payments-pay-over-time-cont-main");
		webDriver.findElement(By.xpath("(//*[@name='installments'])[1]")).click();
		webDriver.switchTo().defaultContent();
	}
	
	public void clickPayIn12MonthsKlarnaSliceIt() {
		webDriver.switchTo().frame("klarna-klarna-payments-pay-over-time-cont-main");
		webDriver.findElement(By.xpath("(//*[@name='installments'])[2]")).click();
		webDriver.switchTo().defaultContent();
	}
	
	public void clickPayIn24MonthsKlarnaSliceIt() {
		webDriver.switchTo().frame("klarna-klarna-payments-pay-over-time-cont-main");
		webDriver.findElement(By.xpath("(//*[@name='installments'])[3]")).click();
		webDriver.switchTo().defaultContent();
	}
	
	public void fillSliceItPopUpInformationKlarna() {
		pageUtils.waitTillWebElementIsVisible(By.id("klarna-klarna-payments-pay-over-time-cont-fullscreen"));
		webDriver.switchTo().frame("klarna-klarna-payments-pay-over-time-cont-fullscreen");
		webDriver.findElement(By.id("purchase-approval-form-date-of-birth")).sendKeys("10101970");
		webDriver.findElement(By.id("purchase-approval-form-continue-button")).click();
		pageUtils.sleepSeconds(5, "wait for klarna Slice It");
		pageUtils.waitForPageToLoad();
		webDriver.switchTo().defaultContent();
	}
	
	public void fillCardDetailsKlarnaPayIn3() {
		pageUtils.waitTillWebElementIsVisible(By.id("klarna-klarna-payments-pay-over-time-cont-main"));
		webDriver.switchTo().frame("klarna-klarna-payments-pay-over-time-cont-main");
		webDriver.switchTo().frame("payment-gateway-frame");
		webDriver.findElement(By.id("cardNumber")).sendKeys(testData.getCard().getCardNumber());
		webDriver.findElement(By.id("expire")).sendKeys(testData.getCard().getExpirationMM()+testData.getCard().getExpirationYYYY().substring(2));
		webDriver.findElement(By.id("securityCode")).sendKeys(testData.getCard().getSecurityCode());
		webDriver.switchTo().defaultContent();
	}
	
	public void fillPayIn3PopUpInformationKlarna() {
		pageUtils.waitTillWebElementIsVisible(By.id("klarna-klarna-payments-pay-over-time-cont-fullscreen"));
		webDriver.switchTo().frame("klarna-klarna-payments-pay-over-time-cont-fullscreen");
		webDriver.findElement(By.id("otp-intro-send-button")).click();
		pageUtils.sleepSeconds(2, "wait for klarna Pay in 3");
		webDriver.findElement(By.cssSelector("input[autocomplete='one-time-code']")).sendKeys("123456");
		pageUtils.sleepSeconds(5, "wait for klarna Pay in 3");
		pageUtils.waitForPageToLoad();
		webDriver.switchTo().defaultContent();
	}

	public void clickOnPayNowButton() {
		pageUtils.sleepSeconds(5, "wait for page load");
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForWebElement(paypalPayNowButton);
		jsExecutor.executeScript("arguments[0].click();", paypalPayNowButton);
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(30, "wait for page load");
	}
}
