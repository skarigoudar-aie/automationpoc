package com.mk.testframework.dt.page.checkout;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.util.ExcelUtils;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.util.PageUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

/**
 * @author VThipperudrappa
 *
 */

public class MkCheckoutConfirmation {

	@FindBy(css = ".dontKnowPostCodeLink a")
	private WebElement enterAddressManuallyLink;

	@FindBy(css = "#address1")
	private WebElement address1;

	@FindBy(css = "#address2")
	private WebElement address2;

	@FindBy(css = "#city")
	private WebElement city;

	@FindBy(css = "#postalCode")
	private WebElement postalCode;

	@FindBy(css = ".shipping_deliever .dropdown-toggle")
	private WebElement titleDropdown;

	@FindBy(css = "#first_name")
	private WebElement firstName;

	@FindBy(css = "#last_name")
	private WebElement lastName;

	@FindBy(css = "#phone")
	private WebElement phone;

	@FindBy(css = "#email")
	private WebElement email;

	@FindBy(css = ".shipping_deliever .deliverAddrBtn")
	private WebElement shipToThisAddress;

	@FindBy(css = ".shipping_deliever .dropdown-menu li")
	List<WebElement> titleDropDownMenu;

	@FindBy(css = "#shippingInfo_form .continue-pay-btn a")
	private WebElement continueToReviewAndPay;

	@FindBy(css = "#confirmOrderContainer")
	private WebElement orderConfirmation;

	@FindBy(css = "#klarna-klarna-payments-pay-later-cont-fullscreen")
	private WebElement klarnaModal;

	@FindBy(css = ".confirmation-number")
	private WebElement confirmationNumber;
	
	@FindBy(xpath = "//input[@id=\"signInPassword\"]")
	private WebElement passwordOnOrderConfirmtion;
	
	@FindBy(xpath = "//input[@data-parsley-equalto=\"#signInPassword\"]")
	private WebElement confirmPasswordOnOrderConfirmtion;
	
	@FindBy(css = "#create-account-confirm")
	private WebElement createAccountOnOrderConfirmation;
	
	@FindBy(xpath = "//*[@id=\"act-created-succuss\"]/h2[test()=\"ACCOUNT CREATED!\"]")
	private WebElement accountCreationMessage;
	
	@FindBy(xpath = "//*[@class=\"p--no-margin orderNumber\"]")
	private WebElement orderConfirmationNARegion;
	
	@FindBy(css = "#signUpPassword")
	private WebElement passwordNARegion;
	
	@FindBy(css = "#confirmPassword")
	private WebElement confirmPasswordNARegion;
	
	@FindBy(css = "#korsvip-join-button")
	private WebElement joinKorsVIPButton;
	
	@FindBy(css = ".korsvip-welcome")
	private WebElement accountCreationMessageNA;
	
	@FindBy(xpath = "//*[@id=\"act-created-succuss\"]/a")
	private WebElement signInOnOrderConfirmation;
	
	@FindBy(css = ".shipping-details address.capitalize")
	private WebElement shipAddressOnOrderConfirmationPageNA;
	
	@FindBy(css = ".paypal-confirm-right p")
	private WebElement paypalPaymentText_NA;
	
	@FindBy(xpath = "//*[@class='payment-details relative']/div/div/ul/ul/li")
	private WebElement paymentTextFor_NA;
	
	@FindBy(xpath = "(//*[@id='billing-summary'])[3]/div/div/div[2]/p[3]")
	private WebElement secondPaymentText_EU;
	
	@FindBy(xpath = "(//*[@id='billing-summary'])[3]/div/div/div[2]/p[2]")
	private WebElement firstPaymentTextFor_EU;
	
	@FindBy(xpath = "(//a[@class = 'orderSummaryToggle link--block collapsed'])[3]")
	private WebElement clickViewDetails;
	
	@FindBy(css = ".payment-details address.capitalize")
	private WebElement billingAddressOnOrderConfirmationPageNA;
	
	@FindBy(xpath = "//*[@id=\"order-summary\"]/ul")
	private WebElement orderSummaryPricesNA;
	
	@FindBy(xpath = "//*[@class ='payment-details relative']/div/div/ul/ul/li")
	private WebElement paymentMethodNA;
	
	 @FindBy(xpath = "(//*[@id = \"billing-summary\"])[3]/div/div/div/ul")
	 private WebElement billingAddressOnOrderConfirmationPageEU;
	 
	 @FindBy(xpath = "(//*[@class = \"shipping-summary-details\"])[9]/ul")
	 private WebElement shipAddressOnOrderConfirmationPageEU;
	 
	 @FindBy(xpath = "(//*[@id = \"billing-summary\"])[3]/div/div/div[2]/p[2]")
	 private WebElement paymentMethodEU;
	 
	 @FindBy(xpath = "(//*[@class = \"orderSummaryDetails orderSummary-collapse\"])/div/div[3]")
	 private WebElement orderSummaryPricesEU;
	 
	 @FindBy(xpath = "(//*[@class = \"orderSummaryDetails orderSummary-collapse\"])/div/div[4]")
	 private WebElement orderSummaryTotalEU;
	 
	 @FindBy(xpath = "(//*[@class = \"shopping-bag-order-summary-priceList\"])[2]/div/div/div")
	 private WebElement orderSummaryPricesEUMobile;
	 
	 @FindBy(xpath = "(//*[@class = \"shopping-bag-order-summary-totals\"])[2]/li")
	 private WebElement orderSummaryTotalEUMobile;
	 
	 @FindBy(css = ".order_confirm_title")
	 private WebElement orderConfirmationTitleEU;
	 
	 @FindBy(xpath = "//*[@class = 'p--no-margin confirmation-label']")
	 private WebElement thanksMessageOnOrderConfirmationEU;
	 
	 @FindBy(css = "#create-account-box")
	 private WebElement createAccountContainer;
	 
	 @FindBy(xpath = "(//*[@class = 'shipping-summary-details'])[11]/p[2]")
	 private WebElement shipMethodOnOrderConfirmationPageEU;
	 
	 @FindBy(xpath = "(//*[@class = 'shipping-summary-details'])[12]/p[2]")
	 private WebElement expectedDeliveryDateOnOrderConfirmationPageEU;
	 
	 @FindBy(xpath = "(//*[@class ='shopping-bag-item__product-img'])[7]")
	 private WebElement STHProductImageEU;
	 
	 @FindBy(xpath = "(//*[@class ='col-xs-8 col-sm-10 col-md-8 col--no-gutters ordersummary_text'])[5]/div/div/div/div/div/h3/a")
	 private WebElement STHProductTitle;
	 
	 @FindBy(xpath = "(//*[@class ='shopping-bag-item__description'])[5]/div/div/p")
	 private WebElement STHProductstoreStyle;
	 
	 @FindBy(xpath = "(//*[@class ='shopping-bag-item__color'])[9]/div/div/p/span[2]")
	 private WebElement STHProductColor;
	 
	 @FindBy(xpath = "(//*[@class ='shopping-bag-item__color'])[7]/div/div/p/span[2]")
	 private WebElement STHProductColorLoggedin;
	 
	 @FindBy(xpath = "(//*[@class ='shopping-bag-item__color'])[9]/following-sibling::div/div/p/span[2]")
	 private WebElement STHProductSize;
	 
	 @FindBy(xpath = "(//*[@class ='shopping-bag-item__qty'])[9]/div/div/p/span[2]")
	 private WebElement STHProductQuantity;
	 
	 @FindBy(xpath = "(//*[@class ='shopping-bag-item__price'])[5]/div/div/p/span")
	 private WebElement STHProductWasPriceOnOrderSummary;
	 
	 @FindBy(xpath = "(//*[@class ='shopping-bag-item__price'])[5]/div/div/p[2]/span")
	 private WebElement STHProductNowPriceOnOrderSummary;
	 
	 @FindBy(xpath = "(//*[@class ='shopping-bag-item__product-img'])[8]")
	 private WebElement cNcProductImageEU;
	 
	 @FindBy(xpath = "(//*[@class ='col-xs-8 col-sm-10 col-md-8 col--no-gutters ordersummary_text'])[6]/div/div/div/div/div/h3/a")
	 private WebElement cNcProductTitle;
	 
	 @FindBy(xpath = "(//*[@class ='shopping-bag-item__description'])[6]/div/div/p")
	 private WebElement cNcProductstoreStyle;
	 
	 @FindBy(xpath = "(//*[@class ='shopping-bag-item__color'])[11]/div/div/p/span[2]")
	 private WebElement cNcProductColor;
	 
	 @FindBy(xpath = "(//*[@class ='shopping-bag-item__color'])[8]/div/div/p/span[2]")
	 private WebElement cNcProductColorLoggedin;
	 
	 @FindBy(xpath = "(//*[@class ='shopping-bag-item__color'])[11]/following-sibling::div/div/p/span[2]")
	 private WebElement cNcProductSize;
	 
	 @FindBy(xpath = "(//*[@class ='shopping-bag-item__qty'])[11]/div/div/p/span[2]")
	 private WebElement cNcProductQuantity;
	 
	 @FindBy(xpath = "(//*[@class ='shopping-bag-item__price'])[6]/div/div/p/span")
	 private WebElement cNcProductWasPriceOnOrderSummary;
	 
	 @FindBy(xpath = "(//*[@class ='shopping-bag-item__price'])[6]/div/div/p[2]/span")
	 private WebElement cNcProductNowPriceOnOrderSummary;
	 
	 @FindBy(xpath = "(//*[@class='orderConfirmationLabel'])[1]")
	 private WebElement thanksMessageOrderConfirmationNA;
	 
	 @FindBy(css = ".shipping-method")
	 private WebElement shippingMethodContainerNARegion;
	 
	 @FindBy(xpath = "//*[@class='shipping-details mobDetails']/div/div/address[3]")
	 private WebElement selectedStoreContainerNARegion;
	 
	 @FindBy(xpath = "(//*[@class='shopping-bag-item nonMonoItem'])[1]/div/div/div/div")
	 private WebElement sthProductImageNA;
	 
	 @FindBy(xpath = "(//*[@class='row gift-purchase-header'])[1]")
	 private WebElement sthProductTitleNA;
	 
	 @FindBy(xpath = "(//*[@class='shopping-bag-item__description'])[1]")
	 private WebElement sthProductstoreStyleNA;
	 
	 @FindBy(xpath = "(//*[@class='shopping-bag-item__color margin-top20'])[1]")
	 private WebElement sthProductColorNA;
	 
	 @FindBy(xpath = "(//*[@class='shopping-bag-item nonMonoItem'])[1]/div/div[2]/div/div[2]/div/p")
	 private WebElement sthProductQuantityNA;
	 
	 @FindBy(xpath = "(//*[@class='shopping-bag-item nonMonoItem'])[1]/div/div[2]/div/div/div")
	 private WebElement sthProductPriceOnOrderSummaryNA;
	 
	 @FindBy(xpath = "(//*[@class='shopping-bag-item__color margin-top20'])[1]/following-sibling::div")
	 private WebElement sthProductSizeNA;
	 
	 @FindBy(xpath = "(//*[@class='shopping-bag-item nonMonoItem'])[2]/div/div/div/div")
	 private WebElement cncProductImageNA;
	 
	 @FindBy(xpath = "(//*[@class='row gift-purchase-header'])[2]")
	 private WebElement cncProductTitleNA;
	 
	 @FindBy(xpath = "(//*[@class='shopping-bag-item__description'])[2]")
	 private WebElement cncProductstoreStyleNA;
	 
	 @FindBy(xpath = "(//*[@class='shopping-bag-item__color margin-top20'])[2]")
	 private WebElement cncProductColorNA;
	 
	 @FindBy(xpath = "(//*[@class='shopping-bag-item nonMonoItem'])[2]/div/div[2]/div/div[2]/div/p")
	 private WebElement cncProductQuantityNA;
	 
	 @FindBy(xpath = "(//*[@class='shopping-bag-item nonMonoItem'])[2]/div/div[2]/div/div/div")
	 private WebElement cncProductPriceOnOrderSummaryNA;
	 
	 @FindBy(xpath = "(//*[@class='shopping-bag-item__color margin-top20'])[2]/following-sibling::div")
	 private WebElement cncProductSizeNA;
	 
	@FindBy(css = ".updateOrderDetails .shopping-bag-order-summary-totals li .text-right p")
	private WebElement getOrderTotalAmount_EU;

	@FindBy(css = ".updateOrderDetails .shopping-bag-box__summary-items .shopping-bag-item .ordersummary_text .itemCustomizedSpec")
	private List<WebElement> verifyCustomProductInSummary;
	
	@FindBy(css = ".customizedPrdInfo")
	private List<WebElement> customProduct_NA;
	
	@FindBy(css = "#order-summary ul li .pull-right")
	private WebElement getOrderSubTotalAmount;
	
	@FindBy(css = "#confirmPage")
	private WebElement verifyConfirmationPageGlobal;
	
	@FindBy(css = ".orderDetailsRow")
	private WebElement orderNumberGlobal;
	
	private PageUtils pageUtils;
	private TestData testData;
	private WebDriver webDriver;
	private Context context;
	private JavascriptExecutor jsExecutor;

	@Inject
	public MkCheckoutConfirmation(WebDriver webDriver, PageUtils pageUtils, TestData testData, Context context) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.testData = testData;
		this.webDriver = webDriver;
		this.context = context;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
	}

	public void fillUpRequiredFields() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();

		address1.sendKeys(testData.getUser().address.getStreetAddress1());

		try {
			address2.sendKeys(testData.getUser().address.getStreetAddress2());
		}
		catch(Exception e){
		}

		city.sendKeys(testData.getUser().address.getCity());

		try {
			postalCode.sendKeys(testData.getUser().address.getPostalCode());
		}
		catch(Exception e){
		}

		titleDropdown.click();
		titleDropDownMenu.get(3).click();
		firstName.sendKeys(testData.getUser().getFirstname());
		lastName.sendKeys(testData.getUser().getLastname());
		phone.sendKeys(testData.getUser().getPhoneNumber());
		email.sendKeys(testData.getUser().getEmail());
	}
	
	public void clickShipToThisAddress() {
		shipToThisAddress.click();
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}

	public void clickContinueToReviewAndPay() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "wait for page load");
		continueToReviewAndPay.click();
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}

	public boolean isOrderConfirmed() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(20, "wait for page load");
		try {
			WebDriverWait wait = new WebDriverWait(webDriver, 20);
			wait.until(ExpectedConditions.visibilityOf(orderConfirmation));
			pageUtils.waitTillWebElementIsVisible(By.cssSelector(".confirmation-number"));
			String orderNumber="";
			if (pageUtils.verifyIfDisplayed(confirmationNumber)) {
				orderNumber = confirmationNumber.getAttribute("innerText");
				orderNumber = (orderNumber.split(":")[1]).trim().toLowerCase();
				context.saveData("orderNumber", orderNumber);
				context.writeOut(orderNumber);
				context.embedScreenshots();
			}
			if (orderNumber.isBlank()||orderNumber.isEmpty()) {
				pageUtils.sleepSeconds(10, "wait for page load");
				orderNumber = confirmationNumber.getAttribute("innerText");
				orderNumber = (orderNumber.split(":")[1]).trim().toLowerCase();
				context.saveData("orderNumber", orderNumber);
				context.writeOut(orderNumber);
				context.writeOut("I verify Order Number displayed");
			}
		} catch (Exception e) {
			pageUtils.waitTillWebElementIsVisible(By.cssSelector(".confirmation-number"));
			if (pageUtils.verifyIfDisplayed(confirmationNumber)) {
				String orderNumber = confirmationNumber.getAttribute("innerText");
				orderNumber = (orderNumber.split(":")[1]).trim().toLowerCase();
				context.saveData("orderNumber", orderNumber);
				context.writeOut(orderNumber);
			}
		}
		return pageUtils.verifyIfDisplayed(orderConfirmation);
	}

	public void switchFocusToCheckoutFrame(){
		webDriver.switchTo().frame(webDriver.findElement(By.cssSelector("iframe[id=\"Intrnl_CO_Container\"]")));
	}
	
	public boolean isOrderConfirmed_global() {
		switchFocusToCheckoutFrame();
		boolean flag = false;
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(15, "wait for page load");
		try {
			WebDriverWait wait = new WebDriverWait(webDriver, 20);
			wait.until(ExpectedConditions.visibilityOf(verifyConfirmationPageGlobal));
			pageUtils.waitTillWebElementIsVisible(By.cssSelector(".orderDetailsRow"));
			String orderNumber ="";
			if (pageUtils.verifyIfDisplayed(orderNumberGlobal)) {
				orderNumber = orderNumberGlobal.getAttribute("innerText");
				orderNumber = (orderNumber.split(":")[1]).trim().toLowerCase();
				context.saveData("orderNumber", orderNumber);
				context.writeOut(orderNumber);
				flag = true;
			}
			if (orderNumber.isBlank()||orderNumber.isEmpty()) {
				pageUtils.refresh();
				pageUtils.sleepSeconds(15, "wait for page load");
				orderNumber = orderNumberGlobal.getAttribute("innerText");
				orderNumber = (orderNumber.split(":")[1]).trim().toLowerCase();
				context.saveData("orderNumber", orderNumber);
				context.writeOut(orderNumber);
				flag = true;
			}
		} catch (Exception e) {
			pageUtils.sleepSeconds(10, "wait for page load");
			pageUtils.waitTillWebElementIsVisible(By.cssSelector(".orderDetailsRow"));
			if (pageUtils.verifyIfDisplayed(orderNumberGlobal)) {
				String orderNumber = orderNumberGlobal.getAttribute("innerText");
				orderNumber = (orderNumber.split(":")[1]).trim().toLowerCase();
				context.saveData("orderNumber", orderNumber);
				context.writeOut(orderNumber);
				flag = true;
			}
		}
		return flag;
	}
	
	public boolean isOrderConfirmedForNARegion() {
		boolean flag = false;
		try {
			pageUtils.sleepSeconds(10, "Wait for page to load");
			pageUtils.waitForPageToLoad();
			pageUtils.waitTillWebElementIsVisible(By.cssSelector("//*[@class=\"p--no-margin orderNumber\"]"));
			if (pageUtils.verifyIfDisplayed(orderConfirmationNARegion)) {
				String orderNumber = orderConfirmationNARegion.getAttribute("innerText");
				orderNumber = (orderNumber.split(":")[1]).trim().toLowerCase();
				context.saveData("orderNumber", orderNumber);
				context.writeOut(orderNumber);
				if(orderNumber.isBlank()||orderNumber.isEmpty()) {
					pageUtils.refresh();
					orderNumber = orderConfirmationNARegion.getAttribute("innerText");
					orderNumber = (orderNumber.split(":")[1]).trim().toLowerCase();
					context.saveData("orderNumber", orderNumber);
					context.writeOut(orderNumber);
				}
				flag = true;
			}
		} catch (Exception e) {
			pageUtils.refresh();
			pageUtils.sleepSeconds(10, "Wait for page to load");
			if (pageUtils.verifyIfDisplayed(orderConfirmationNARegion)) {
				String orderNumber = orderConfirmationNARegion.getAttribute("innerText");
				orderNumber = (orderNumber.split(":")[1]).trim().toLowerCase();
				context.saveData("orderNumber", orderNumber);
				context.writeOut(orderNumber);
				flag = true;
			}
		}

		return flag;
	}

	public void enterAdditionalDetailsAndContinue() {
		pageUtils.waitTillWebElementIsVisible(By.id("klarna-klarna-payments-pay-later-cont-fullscreen"));
		webDriver.switchTo().frame("klarna-klarna-payments-pay-later-cont-fullscreen");
		webDriver.findElement(By.id("purchase-approval-date-of-birth")).sendKeys("10101970");
		webDriver.findElement(By.id("purchase-approval-continue")).click();
		webDriver.switchTo().defaultContent();
		pageUtils.sleepSeconds(5, "wait for order completion");
	}
	
	public void enterPasswordOnConfirmation(String password) {
		pageUtils.waitForWebElement(passwordOnOrderConfirmtion);
		passwordOnOrderConfirmtion.sendKeys(password);
	}
	
	public void enterConfirmPasswordOnConfirmation(String password) {
		pageUtils.waitForWebElement(confirmPasswordOnOrderConfirmtion);
		confirmPasswordOnOrderConfirmtion.sendKeys(password);
	}
	
	public void clickOnCreateAccountOnOrderConfirmationButton() {
		jsExecutor.executeScript("arguments[0].click();", createAccountOnOrderConfirmation);
		pageUtils.sleepSeconds(5, "Create Account Clicked"); 
		pageUtils.waitForPageToLoad();
	}
	
	public boolean isAccountCreated() {
		pageUtils.waitForPageToLoad();
		pageUtils.verifyIfDisplayed(accountCreationMessage);
		return true;
	}
	
	public void enterPasswordNARegion(String password) {
		pageUtils.waitForWebElement(passwordNARegion);
		passwordNARegion.sendKeys(password);
	}
	
	public void enterConfirmPasswordNARegion(String password) {
		pageUtils.waitForWebElement(confirmPasswordNARegion);
		confirmPasswordNARegion.sendKeys(password);
	}
	
	public void clickOnJoinKorsVIPButton() {
		jsExecutor.executeScript("arguments[0].click();", joinKorsVIPButton);
		pageUtils.sleepSeconds(5, "Join Kors VIP Clicked"); 
		pageUtils.waitForPageToLoad();
	}
	
	public boolean isAccountCreationMessageDesplayedForNA() {
		pageUtils.waitForPageToLoad();
		pageUtils.verifyIfDisplayed(accountCreationMessageNA);
		return true;
	}
	
	public void clickOnSigninOrderConfirmation() {
		jsExecutor.executeScript("arguments[0].click();", signInOnOrderConfirmation);
		pageUtils.sleepSeconds(5, "SignIn Clicked"); 
		pageUtils.waitForPageToLoad();
	}
	
	public boolean verifyShippingAddressOnOrderConfirmationNA() {
		pageUtils.waitForPageToLoad();
		if(pageUtils.verifyIfDisplayed(shipAddressOnOrderConfirmationPageNA)) {
			jsExecutor.executeScript("arguments[0].click();", shipAddressOnOrderConfirmationPageNA);
			String shippingAddressText = shipAddressOnOrderConfirmationPageNA.getText();
			shippingAddressText = shippingAddressText.substring(shippingAddressText.indexOf('\n')).toLowerCase().replace("\n", "").replace(" ", "").replace("\u00a0", "");
			context.saveData("shipAddressTextOnOrderConfirmation", shippingAddressText);
			context.writeOut(shippingAddressText);
			return true;
		}
		return false;
	}
	
	public boolean verifyBillingAddressOnOrderConfirmationNA() {
		pageUtils.waitForPageToLoad();
		if(pageUtils.verifyIfDisplayed(billingAddressOnOrderConfirmationPageNA)) {
			jsExecutor.executeScript("arguments[0].click();", billingAddressOnOrderConfirmationPageNA);
			String billingAddressText = billingAddressOnOrderConfirmationPageNA.getText();
			billingAddressText = billingAddressText.substring(billingAddressText.indexOf('\n')).toLowerCase().replace("\n", "").replace(" ", "").replace("\u00a0", "");
			context.saveData("billingAddressTextOnOrderConfirmation", billingAddressText);
			context.writeOut(billingAddressText);
			return true;
		}
		return false;
	}
	
	public boolean verifyPaymentMethodOnOrderConfirmationNA() {
		pageUtils.waitForPageToLoad();
		if(pageUtils.verifyIfDisplayed(paymentMethodNA)) {
			jsExecutor.executeScript("arguments[0].click();", paymentMethodNA);
			String paymentMethodText = paymentMethodNA.getAttribute("innerText");
			context.saveData("PaymentMethodTextOnOrderConfirmation", paymentMethodText);
			context.writeOut(paymentMethodText);
			return true;
		}
		return false;
	}
	
	public boolean verifyOrderSummaryPricesOnConfirmationNA() {
		pageUtils.waitForPageToLoad();
		if(pageUtils.verifyIfDisplayed(orderSummaryPricesNA)) {
			jsExecutor.executeScript("arguments[0].click();", orderSummaryPricesNA);
			String orderPrices = orderSummaryPricesNA.getAttribute("innerText");
			context.writeOut(orderPrices);
			context.saveData("orderPrices", orderPrices);
			return true;
		}
		return false;
	}
	
	public boolean verifyShippingAddressOnOrderConfirmationEU(){
		pageUtils.waitForPageToLoad();
		if (pageUtils.verifyIfDisplayed(shipAddressOnOrderConfirmationPageEU)) {
			String shipAddress  = shipAddressOnOrderConfirmationPageEU.getAttribute("innerText");
			shipAddress = shipAddress.substring(shipAddress.indexOf('\n')).toLowerCase().replace("\n", "").replace(" ", "").replace("\u00a0", "");
			pageUtils.sleepSeconds(2, "wait for page load");
			context.saveData("shipAddressTextOnOrderConfirmation", shipAddress);
			context.writeOut(shipAddress);
			return true;
		}
		return false;
	}
	
	public boolean verifyBillingAddressOnOrderConfirmationEU(){
		pageUtils.waitForPageToLoad();
		if (pageUtils.verifyIfDisplayed(billingAddressOnOrderConfirmationPageEU)) {
			String billAddress  = billingAddressOnOrderConfirmationPageEU.getAttribute("innerText");
			billAddress = billAddress.substring(billAddress.indexOf('\n')).toLowerCase().replace("\n", "").replace(" ", "").replace("\u00a0", "");
			pageUtils.sleepSeconds(2, "wait for page load");
			context.saveData("billingAddressTextOnOrderConfirmation", billAddress);
			context.writeOut(billAddress);
			return true;
		}
		return false;
	}
	
	public boolean verifyPaymentMethodOnOrderConfirmationEU() {
		pageUtils.waitForPageToLoad();
		if(pageUtils.verifyIfDisplayed(paymentMethodEU)) {
			jsExecutor.executeScript("arguments[0].click();", paymentMethodEU);
			String paymentMethodText = paymentMethodEU.getAttribute("innerText");
			context.saveData("PaymentMethodTextOnOrderConfirmation", paymentMethodText);
			context.writeOut(paymentMethodText);
			return true;
		}
		return false;
	}
	
	public boolean verifyOrderSummaryPricesOnConfirmationEU() {
		pageUtils.waitForPageToLoad();
		if(pageUtils.verifyIfDisplayed(orderSummaryPricesEU) && pageUtils.verifyIfDisplayed(orderSummaryTotalEU)) {
			jsExecutor.executeScript("arguments[0].click();", orderSummaryPricesEU);
			String orderPrices = orderSummaryPricesEU.getAttribute("innerText");
			String orderSummaryTotal = orderSummaryTotalEU.getAttribute("innerText");
			orderPrices = orderPrices+"\n\n"+orderSummaryTotal;
			context.writeOut(orderPrices);
			context.saveData("orderPrices", orderPrices);
			return true;
		}
		return false;
	}
	
	public boolean verifyOrderSummaryPricesOnConfirmationEUMobile() {
		pageUtils.waitForPageToLoad();
		if(pageUtils.verifyIfDisplayed(orderSummaryPricesEUMobile) && pageUtils.verifyIfDisplayed(orderSummaryTotalEUMobile)) {
			jsExecutor.executeScript("arguments[0].click();", orderSummaryPricesEUMobile);
			String orderPrices = orderSummaryPricesEUMobile.getAttribute("innerText");
			String orderSummaryTotal = orderSummaryTotalEUMobile.getAttribute("innerText");
			orderPrices = orderPrices+"\n\n"+orderSummaryTotal;
			context.writeOut(orderPrices);
			context.saveData("orderPrices", orderPrices);
			return true;
		}
		return false;
	}
	
	public boolean isPaypalPaymentDisplayed_NA() {
		String getPaymentName = paypalPaymentText_NA.getText();
		context.writeOut("payment method is: " + getPaymentName);
		return pageUtils.verifyIfDisplayed(paypalPaymentText_NA);
	}

	public boolean isPaymentDisplayed_NA() {
		String getPaymentName = paymentTextFor_NA.getText();
		context.writeOut("payment method is: " + getPaymentName);
		return pageUtils.verifyIfDisplayed(paymentTextFor_NA);

	}

	public void clickOnViewFullDetails() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "wait for page load");
		jsExecutor.executeScript("arguments[0].click();", clickViewDetails);
	}

	public boolean isSecondPaymentDisplayed_EU() {
        String getPaymentName = secondPaymentText_EU.getAttribute("innerText");
        context.writeOut("payment method is: " + getPaymentName);
        return pageUtils.verifyIfDisplayed(secondPaymentText_EU);
    }

    public boolean isFirstlPaymentDisplayed_EU() {
        String getPaymentName = firstPaymentTextFor_EU.getAttribute("innerText");
        context.writeOut("payment method is: " + getPaymentName);
        return pageUtils.verifyIfDisplayed(firstPaymentTextFor_EU);
    }
	
	public boolean verifyConfirmationTitleOnOrderConfirmationEU() {
		boolean flag = false;
		pageUtils.waitForPageToLoad();
		pageUtils.waitTillWebElementIsClickable(orderConfirmationTitleEU);
		String orderConfirmationTitleLabel = pageUtils.getTextTranslation("order_confirmation_title_label");
		WebElement orderTitle = webDriver.findElement(By.xpath("//div[contains(text(),'" + orderConfirmationTitleLabel + "')]"));
		if (orderTitle.isDisplayed()) {
			context.writeOut("Order Confirmation Title label displayed");
			flag = true;
		} else {
			context.writeOut("Expected was: " + orderConfirmationTitleLabel + " and Found: " + orderTitle);
		}
		return flag;
	}
	
	public boolean verifyThanksMessageOnOrderConfirmationEU() {
		boolean flag = true;
		pageUtils.waitForPageToLoad();
		pageUtils.waitTillWebElementIsClickable(thanksMessageOnOrderConfirmationEU);
		String thanksMessageTitleLabel = pageUtils.getTextTranslation("thanks_message_confirmation_title_label");
		String thanksMessageTitleLabel1 = pageUtils.getTextTranslation("thanks_message_confirmation_title_label1");
		WebElement thanksMessageTitle = webDriver.findElement(By.xpath("//p[contains(text(),\"" + thanksMessageTitleLabel + "\")]"));
		String thanksMessageTitle1 = webDriver.findElement(By.xpath("//p[@class='p--no-margin confirmation-label']")).getText();
		String email =webDriver.findElement(By.xpath("//*[@class = 'p--no-margin confirmation-label']/span")).getText();
		if (thanksMessageTitle.isDisplayed() && thanksMessageTitle1.contains(thanksMessageTitleLabel1)) {
			context.writeOut("Thanks Title label displayed");
		} else {
			context.writeOut("Expected was: " + thanksMessageTitleLabel+thanksMessageTitleLabel1 + " and Found: " + thanksMessageTitle + thanksMessageTitle1);
			flag = false;
		}

		if(email.equalsIgnoreCase(testData.getUser().getEmail())) {
			context.writeOut("email is displayed");
		}
		return flag;
	}
	
	public boolean verifyCreateAccountOnOrderConfirmationEU() {
			pageUtils.waitForPageToLoad();
			if (pageUtils.verifyIfDisplayed(createAccountContainer)) {
				return true;
			}
			return false;
	}
	
	public boolean verifyPasswordConfirmPasswordAndCreateAccountButtonEU() {
		pageUtils.waitForPageToLoad();
		if (pageUtils.verifyIfDisplayed(passwordOnOrderConfirmtion) && pageUtils.verifyIfDisplayed(confirmPasswordOnOrderConfirmtion) && pageUtils.verifyIfDisplayed(createAccountOnOrderConfirmation)) {
			return true;
		}
		return false;
	}
	
	public boolean verifyShippingMethodOnOrderConfirmationEU() {
		pageUtils.waitForPageToLoad();
		if(pageUtils.verifyIfDisplayed(shipMethodOnOrderConfirmationPageEU)) {
			return true;
		}
		return false;
	}
	
	public boolean verifyExpectedDeliveryOnOrderConfirmationEU() {
		pageUtils.waitForPageToLoad();
		if(pageUtils.verifyIfDisplayed(expectedDeliveryDateOnOrderConfirmationPageEU)) {
			return true;
		}
		return false;
	}
	
	public boolean verifyDetailsForSTHProductOnOrderConfirmationEU() {
		boolean flag = true;
		pageUtils.waitForPageToLoad();
		if (pageUtils.verifyIfDisplayed(STHProductImageEU) && pageUtils.verifyIfDisplayed(STHProductTitle)
				&& pageUtils.verifyIfDisplayed(STHProductstoreStyle)
				&& pageUtils.verifyIfDisplayed(STHProductQuantity)
				&& pageUtils.verifyIfDisplayed(STHProductWasPriceOnOrderSummary)
				&& pageUtils.verifyIfDisplayed(STHProductNowPriceOnOrderSummary)
				|| pageUtils.verifyIfDisplayed(STHProductSize)) {
			context.writeOut(
					"Product Image, Title, store style, size(optional), product color, quantity, was and now prize is displayed");
		} else if(pageUtils.verifyIfDisplayed(STHProductColor)) {
			context.writeOut("product color for guest user displayed");
		} else if(pageUtils.verifyIfDisplayed(STHProductColorLoggedin)) {
			context.writeOut("product color for Loggedin user displayed");
		} else {
			flag = false;
		}
		return flag;
	}
	
	public boolean verifyDetailsForCnCProductOnOrderConfirmationEU() {
		boolean flag = true;
		pageUtils.waitForPageToLoad();
		if (pageUtils.verifyIfDisplayed(cNcProductImageEU) && pageUtils.verifyIfDisplayed(cNcProductTitle)
				&& pageUtils.verifyIfDisplayed(cNcProductstoreStyle)
				&& pageUtils.verifyIfDisplayed(cNcProductQuantity)
				&& pageUtils.verifyIfDisplayed(cNcProductWasPriceOnOrderSummary)
				&& pageUtils.verifyIfDisplayed(cNcProductNowPriceOnOrderSummary)
				|| pageUtils.verifyIfDisplayed(cNcProductSize)) {
			context.writeOut(
					"Product Image, Title, store style, size(optional), product color, quantity, was and now prize is displayed");
		} else if(pageUtils.verifyIfDisplayed(cNcProductColor)) {
			context.writeOut("product color for guest user displayed");
		} else if(pageUtils.verifyIfDisplayed(cNcProductColorLoggedin)) {
			context.writeOut("product color for Loggedin user displayed");
		} else {
			flag = false;
		}
		return flag;
	}
	
	public boolean verifyOrderConfirmedMessageForNARegion() {
		boolean flag = true;
		pageUtils.waitForPageToLoad();
		pageUtils.waitTillWebElementIsClickable(thanksMessageOrderConfirmationNA);
		String thanksMessageTitleLabel = pageUtils.getTextTranslation("thanks_message_confirmation_title_label");
		String thanksMessageTitleLabel1 = pageUtils.getTextTranslation("thanks_message_confirmation_title_label1");
		WebElement thanksMessageTitle = webDriver.findElement(By.xpath("//p[contains(text(),\"" + thanksMessageTitleLabel + "\")]"));
		WebElement thanksMessageTitle1 = webDriver.findElement(By.xpath("//p[contains(text(),\"" + thanksMessageTitleLabel1 + "\")]"));
		String email =webDriver.findElement(By.xpath("//*[@class='emailAddress notranslate']")).getText();
		if (thanksMessageTitle.isDisplayed() && thanksMessageTitle1.isDisplayed()) {
			context.writeOut("Thanks Title label displayed");
		} else {
			context.writeOut("Expected was: " + thanksMessageTitleLabel+thanksMessageTitleLabel1 + " and Found: " + thanksMessageTitle + thanksMessageTitle1);
			flag = false;
		}

		if(email.equalsIgnoreCase(testData.getUser().getEmail())) {
			context.writeOut("email is displayed");
		}
		return flag;
	}

	public double getOrderTotal_EU() {
		pageUtils.waitForWebElement(getOrderTotalAmount_EU);
		pageUtils.sleepSeconds(5, "wait for page load");
		String getTotalInOrderSummary = getOrderTotalAmount_EU.getText();
		context.saveData("OrderTotalPrice", getTotalInOrderSummary);
		String getOrderTotal = getTotalInOrderSummary.trim().replaceAll("[^0-9]", "");
		double getOrderTotal1 = Double.parseDouble(getOrderTotal.toString());
		return getOrderTotal1;
	}
	
	public double getOrderSubTotal_NA() {
		pageUtils.waitForWebElement(getOrderSubTotalAmount);
		pageUtils.sleepSeconds(5, "wait for page load");
		String getTotalInOrderSummary = getOrderSubTotalAmount.getText();
		context.saveData("OrderTotalPrice", getTotalInOrderSummary);
		String getOrderTotal = getTotalInOrderSummary.trim().replaceAll("[^0-9]", "");
		double getOrderTotal1 = Double.parseDouble(getOrderTotal.toString());
		return getOrderTotal1;
	}

	public boolean verifyCustomaProductInOrderSummary() {
		pageUtils.waitForPageToLoad();
		boolean flag = false;
		int CustomProducts = verifyCustomProductInSummary.size();
		if (CustomProducts > 1)
			flag = true;
		return flag;
	}

	public boolean verifyCustomaProduct_NA() {
		pageUtils.waitForPageToLoad();
		boolean flag = false;
		int CustomProducts = customProduct_NA.size();
		if (CustomProducts > 1)
			flag = true;
		return flag;
	}
	
	public boolean verifyPasswordConfirmPasswordAndJOINKorsVIPButtonNA() {
		pageUtils.waitForPageToLoad();
		if (pageUtils.verifyIfDisplayed(passwordNARegion) && pageUtils.verifyIfDisplayed(confirmPasswordNARegion) && pageUtils.verifyIfDisplayed(joinKorsVIPButton)) {
			return true;
		}
		return false;
	}
	
	public boolean verifyShippingMethodForNARegion() {
		pageUtils.waitForPageToLoad();
		if (pageUtils.verifyIfDisplayed(shippingMethodContainerNARegion)) {
			return true;
		}
		return false;
	}
	
	public boolean verifySelectedStoreForNARegion() {
		pageUtils.waitForPageToLoad();
		if (pageUtils.verifyIfDisplayed(selectedStoreContainerNARegion)) {
			return true;
		}
		return false;
	}
	
	public boolean verifySTHDetailsForNARegion() {
		boolean flag = true;
		pageUtils.waitForPageToLoad();
		if (pageUtils.verifyIfDisplayed(sthProductImageNA) && pageUtils.verifyIfDisplayed(sthProductTitleNA)
				&& pageUtils.verifyIfDisplayed(sthProductstoreStyleNA) && pageUtils.verifyIfDisplayed(sthProductColorNA)
				&& pageUtils.verifyIfDisplayed(sthProductQuantityNA)
				&& pageUtils.verifyIfDisplayed(sthProductPriceOnOrderSummaryNA)
				|| pageUtils.verifyIfDisplayed(sthProductSizeNA)) {
			context.writeOut(
					"Product Image, Title, store style, size(optional), product color, quantity, was and now prize is displayed");
		} else {
			flag = false;
		}
		return flag;
	}
	
	public boolean verifyCNCDetailsForNARegion() {
		boolean flag = true;
		pageUtils.waitForPageToLoad();
		if (pageUtils.verifyIfDisplayed(cncProductImageNA) && pageUtils.verifyIfDisplayed(cncProductTitleNA)
				&& pageUtils.verifyIfDisplayed(cncProductstoreStyleNA) && pageUtils.verifyIfDisplayed(cncProductColorNA)
				&& pageUtils.verifyIfDisplayed(cncProductQuantityNA)
				&& pageUtils.verifyIfDisplayed(cncProductPriceOnOrderSummaryNA)
				|| pageUtils.verifyIfDisplayed(cncProductSizeNA)) {
			context.writeOut(
					"Product Image, Title, store style, size(optional), product color, quantity, was and now prize is displayed");
		} else {
			flag = false;
		}
		return flag;
	}
}
