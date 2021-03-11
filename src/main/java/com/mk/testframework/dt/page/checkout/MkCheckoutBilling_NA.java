package com.mk.testframework.dt.page.checkout;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.util.PageUtils;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * @author MLinderman
 *
 */
public class MkCheckoutBilling_NA {

	@FindBy(css = "button[data-id='gender-select']")
	private WebElement genderSelect;

	@FindBy(css = "#first-name")
	private WebElement firstName;

	@FindBy(css = "#last-name")
	private WebElement lastName;

	@FindBy(css = "#addr-1")
	private WebElement address1;

	@FindBy(css = "#addr-2")
	private WebElement address2;

	@FindBy(css = "#zip-code")
	private WebElement postalCode;

	@FindBy(css = "#locality")
	private WebElement city;

	@FindBy(css = "button[data-id='state']")
	private WebElement state;

	@FindBy(css = "#shipping-phone")
	private WebElement phone;

	@FindBy(css = "#shippingFormSubmit")
	private WebElement continueToPayment;

	@FindBy(css = "#cc-payment")
	private WebElement creditCardOption;

	@FindBy(css = "#payment-form #credit-card-form")
	private WebElement creditCardPanelOpen;

	@FindBy(css = "#card-name")
	private WebElement cardHolderName;

	@FindBy(css = ".payment-card-number")
	private WebElement cardNumber;

	@FindBy(css = "#payment-card-expiration")
	private WebElement cardExpirationDate;

	@FindBy(css = ".payment-card-ccv")
	private WebElement cardSecurityCode;

	@FindBy(css = "#email")
	private WebElement email;

	@FindBy(css = "#confirmEmail")
	private WebElement confirmEmail;

	@FindBy(css = ".billing-edit-collection-link")
	private WebElement editBillingAddressLink;

	@FindBy(css = ".billing-add-collection-link")
	private WebElement addNewBillingAddressLink;

	@FindBy(css = "#cc-continue-button")
	private WebElement continueToReviewButton;

	@FindBy(css = "#credit-card-form #payment-shipping-info")
	private WebElement shippingAddress;

	@FindBy(id = "applyPromotion")
	private WebElement PromoLink;

	@FindBy(css = "#orderPromotionForm #shopping-bag-promo")
	private WebElement promoCodeContainer;

	@FindBy(css = "#orderPromotionForm #claimCode")
	private WebElement applyPromo;

	@FindBy(id = "removeCoupon_0")
	private WebElement promoScuccessContainer;

	@FindBy(css = ".promotionSectionForMobileBilling")
	private WebElement promoLinkMob;

	@FindBy(css = "#billingPromotion .promo-code-form #shopping-bag-promo")
	private WebElement promoCodeContainerMob;

	@FindBy(css = "#billingPromotion .promo-code-form .btn")
	private WebElement applyPromoMob;

	@FindBy(css = ".apply-giftcard-box .gift-card-link .icon-open")
	private WebElement applyGiftCardLink;

	@FindBy(id = "apply-giftcard-form")
	private WebElement applyGiftCardPopUp;

	@FindBy(id = "js-applygiftCard-cancel")
	private WebElement closeOptionOnApplyGiftCardPopUp;

	@FindBy(xpath = "//form[@id='apply-giftcard-form']//input[@type='submit']")
	private WebElement applyGiftCardbtn;

	@FindBy(xpath = "//form[@id='apply-giftcard-form']//input[@name='gift-card']")
	private WebElement giftCardNumberPlaceHolder;

	@FindBy(xpath = "//input[@id='gift-card-pin']")
	private WebElement giftCardPinNumber;

	@FindBy(xpath = "//div[@id='apply-giftcard-success-container']//div[@class='alert-message__text']")
	private WebElement giftCardAplliedSuccessMessage;

	@FindBy(xpath = "//div[@id='gift-cards-container']//li[2]")
	private WebElement removeGiftCardLink;

	@FindBy(xpath = "//li[@class='font-3r-12px dark-grey']")
	private WebElement appliedGiftCardNumber;

	@FindBy(css = ".check-balance-link")
	private WebElement checkGCBalanceLink;
	
	@FindBy(xpath = "//div[@class='padded-content billing-completed']/address")
	private WebElement userBillingAddressFirsNameGuest;
	
	@FindBy(css = "#billing-address .first_name")
	private WebElement billingFirstName;
	
	@FindBy(css ="#payment-shipping-info .no-text-transform")
	private WebElement sameAsShippingAddressSection;

	@FindBy(xpath = "//p[@class='product-values'][contains(text(),'Gift Wrap')]")
	private WebElement giftWrapContainer;

	@FindBy(xpath = "//p[contains(text(),'Gift Wrap')]//span")
	private WebElement giftWrapAmount;

	@FindBy(xpath = "//p[contains(text(),'Emballage cadeau')]//span")
	private WebElement giftWrapAmountFR;

	@FindBy(css = "#place-order-button")
	private WebElement placeOrderButton;

	@FindBy(css = "#saved-cards-dropdown")
	private List<WebElement> savedCardDropDown;

	@FindBy(css = "#state")
	private WebElement selectState;
	
	@FindBy(css = "#order-summary ul .row--last-skinny-margin p span")
	private WebElement getTotalPrice;

	@FindBy(css = "#paypal-payment")
	private WebElement paypalPaymentOption;

	@FindBy(css = "#paypalcustimage")
	private WebElement continueToPaypalButton;

	@FindBy(xpath = "(//*[@id='headingTwo']/div/a)[3]")
	private WebElement editPaymentLink;

	@FindBy(css = ".recaptcha-checkbox-checkmark")
	private WebElement captcha;

	@FindBy(xpath = "//div[contains(@id,'order-summary')]//span[contains(@class,'pull-right total')]")
	private WebElement orderTotal;

	@FindBy(xpath = "//div[@id='saved-cards-container']//h4[@class='h3 row--smallest-margin']")
	private WebElement savedCardsLabel;

	@FindBy(css = ".credit-add-collection-link")
	private WebElement addNewCardLink;

	@FindBy(xpath = "(//*[@name='cvv'])[2]")
	private WebElement cardSecurityCodeAddNew;

	@FindBy(xpath = "//*[@class=\"btn btn-primary full-width ladda-button order-review-dummy-button translate mouseFocusUnActive\"]")
	private WebElement placeOrderMobile;
	
	@FindBy(xpath = "//input[@id='first-name']/following-sibling :: ul")
	private WebElement fNameError;

	@FindBy(xpath = "//input[@id='last-name']/following-sibling :: ul")
	private WebElement lNameError;

	@FindBy(xpath = "//select[@id='saved-cards-dropdown']")
	private WebElement savedCard_loggedIn;

	@FindBy(css = ".address-display .addr_1")
	private WebElement savedBillingAddress1;

	@FindBy(css = "#billing-address-dropdown")
	private WebElement selectBillingAddressOption;

	@FindBy(xpath = "//*[@class='applied-gift-cards']/ul/li[1]")
	private List<WebElement> appliedGiftCardNumbers;

	@FindBy(xpath = "(//*[@id='order-summary']/ul/li/p/span)[4]")
	private WebElement giftCardAmount;

	@FindBy(css = ".remove-gift-card-Link")
	private List<WebElement> removeGiftCardLinks;
	
	@FindBy(css = "#shippingContainer .panel-title .no-text-transform")
	private WebElement editShippingSection;
	
	@FindBy(css = ".mobile-nav .arrow-container .mobile-nav-button")
	private WebElement editShippingSectionMobile;

	private PageUtils pageUtils;
	private TestData testData;
	private JavascriptExecutor jsExecutor;
	private Environment env;
	private WebDriver webDriver;
	private Context context;

	@Inject
	public MkCheckoutBilling_NA(WebDriver webDriver, PageUtils pageUtils, TestData testData, Environment env,
			Context context) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.testData = testData;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.env = env;
		this.webDriver = webDriver;
		this.context = context;
	}

	public void clickCardPaymentOption() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "wait for page load");

		try {
			pageUtils.waitTillWebElementIsClickable(creditCardOption);
			jsExecutor.executeScript("arguments[0].click();", creditCardOption);
		} catch (StaleElementReferenceException e) {
			pageUtils.waitTillWebElementIsClickable(creditCardOption);
			jsExecutor.executeScript("arguments[0].click();", creditCardOption);
		}

		pageUtils.sleepSeconds(1, "wait for page load");
		pageUtils.waitForAjaxToComplete();
	}

	public boolean isCardPaymentPanelOpen() {
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForWebElement(creditCardPanelOpen);
		return pageUtils.verifyIfDisplayed(creditCardOption);
	}

	public boolean isApplyAGiftcardDisplayed() {
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(5, "1 sec wait for ajax load");
		return pageUtils.verifyIfDisplayed(applyGiftCardLink);
	}
	
	public String iVerifySpecialCharecterInBillingAddress(String guest) {
		String firstName="";
		if(guest.equalsIgnoreCase("guest")) {
			pageUtils.sleepSeconds(5, "wait for page load");
			pageUtils.waitForWebElement(userBillingAddressFirsNameGuest);
			System.out.println(userBillingAddressFirsNameGuest.getText());
			firstName=userBillingAddressFirsNameGuest.getText();
		}else {
			pageUtils.sleepSeconds(5, "wait for page load");
			pageUtils.waitForWebElement(billingFirstName);

			firstName=billingFirstName.getText();
		}
		return firstName;
	}
	
	public void clickApplyGiftCardHeader() {
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(5, "1 sec wait for ajax load");
		applyGiftCardLink.click();
		pageUtils.waitForAjaxToComplete();
	}

	public void closeGiftCardPopUp() {
		pageUtils.sleepSeconds(2, "wait for page load");
		closeOptionOnApplyGiftCardPopUp.click();
		pageUtils.sleepSeconds(2, "wait for page load");
	}

	public boolean isApplyAGiftcardpopUpOpen() {
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(3, "wait for page load");
		applyGiftCardLink.click();
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(1, "wait for page load");
		return pageUtils.verifyIfDisplayed(applyGiftCardPopUp);
	}

	public boolean isCloseLinkDisplayedOnApplyGiftCardPanel() {
		pageUtils.sleepSeconds(2, "wait for page load");
		return pageUtils.verifyIfDisplayed(closeOptionOnApplyGiftCardPopUp);
	}

	public void enterGiftCardNumber() {
		pageUtils.sleepSeconds(5, "wait for page load");
		String giftCardNumber = testData.getGiftCard().getCardNumber();
		giftCardNumberPlaceHolder.sendKeys(giftCardNumber);
		pageUtils.sleepSeconds(2, "wait for page load");
	}

	public void enterGiftCardPin() {
		String giftCardNumber = testData.getGiftCard().getSecurityCode();
		giftCardPinNumber.sendKeys(giftCardNumber);
		pageUtils.sleepSeconds(2, "wait for page load");
	}

	public void clickOnUseItBtn() {
		pageUtils.sleepSeconds(2, "wait for page load");
		applyGiftCardbtn.click();
		pageUtils.waitForAjaxToComplete();
	}

	public boolean isGiftCardAppliedMessageDisplayed() {
		pageUtils.sleepSeconds(2, "wait for page load");
		return pageUtils.verifyIfDisplayed(giftCardAplliedSuccessMessage);
	}

	public boolean isRemoveGiftCardLinkDisplayed() {
		pageUtils.sleepSeconds(2, "wait for page load");
		return pageUtils.verifyIfDisplayed(removeGiftCardLink);
	}

	public void clickOnRemoveGiftCardLink() {
		pageUtils.sleepSeconds(2, "wait for page load");
		removeGiftCardLink.click();
		pageUtils.sleepSeconds(5, "wait for page load");
	}

	public boolean isGiftCardCheckBalanceLinkDisplayed() {
		pageUtils.sleepSeconds(2, "wait for page load");
		System.out.println(pageUtils.verifyIfDisplayed(checkGCBalanceLink));
		return pageUtils.verifyIfDisplayed(checkGCBalanceLink);
	}

	public boolean isEditBillingAddressLinkDisplayed() {
		pageUtils.waitForWebElement(editBillingAddressLink);
		return pageUtils.verifyIfDisplayed(editBillingAddressLink);
	}
	
	public void clickOnEditBillingAddress()
	{
		pageUtils.sleepSeconds(3, "wait for page load");
		pageUtils.waitForWebElement(editBillingAddressLink);
		jsExecutor.executeScript("arguments[0].click();", editBillingAddressLink);
		
	}
	public boolean isAddNewBillingAddressLinkDisplayed() {
		pageUtils.waitForWebElement(addNewBillingAddressLink);
		return pageUtils.verifyIfDisplayed(addNewBillingAddressLink);
	}

	public void fillCardholderNameField(String userName) {
		pageUtils.waitTillWebElementIsClickable(cardHolderName);
		cardHolderName.sendKeys(userName);
	}

	public void fillCardNumberField(String number) {
		pageUtils.waitTillWebElementIsClickable(cardNumber);
		cardNumber.sendKeys(number);
	}

	public void clickCardExpirationDate() {
		pageUtils.scrollToElement(cardExpirationDate);
		cardExpirationDate.click();
		pageUtils.waitForAjaxToComplete();
	}

	public void fillExpirationDate(String expirationDate) {
		pageUtils.type_in_field(cardExpirationDate, expirationDate);
	}

	public void fillCardSecurityCodeField(String code) {
		cardSecurityCode.sendKeys(code);
	}

	public void fillEmailField(String userEmail) {
		email.sendKeys(userEmail);
	}

	public void fillConfirmationEmailField(String userEmail) {
		confirmEmail.sendKeys(userEmail);
	}

	public void fillUpRequiredFields() {
		try {
			fillCardholderNameField(testData.getUser().getFirstname() + " " + testData.getUser().getLastname());
			fillCardNumberField(testData.getCard().getCardNumber());

			String expirationYYYY = testData.getCard().getExpirationYYYY();
			String expirationYY = expirationYYYY.substring(expirationYYYY.length() - 2);
			String expirationDate = testData.getCard().getExpirationMM() + "/" + expirationYY;
			fillExpirationDate(expirationDate);

			fillEmailField(testData.getUser().getEmail());
			fillConfirmationEmailField(testData.getUser().getEmail());
		} catch (Exception e) {
		}

		fillCardSecurityCodeField(testData.getCard().getSecurityCode());
	}
	
	public void fillUpRequiredFields(String fname, String lname) {
		try {
			fillCardholderNameField(fname + " " + lname);
			fillCardNumberField(testData.getCard().getCardNumber());

			String expirationYYYY = testData.getCard().getExpirationYYYY();
			String expirationYY = expirationYYYY.substring(expirationYYYY.length() - 2);
			String expirationDate = testData.getCard().getExpirationMM() + "/" + expirationYY;
			fillExpirationDate(expirationDate);

			fillEmailField(testData.getUser().getEmail());
			fillConfirmationEmailField(testData.getUser().getEmail());
		} catch (Exception e) {
		}

		fillCardSecurityCodeField(testData.getCard().getSecurityCode());
	}

	public void fillUpRequiredFieldsWithNewEmail() {
		try {
			fillCardholderNameField(testData.getUser().getFirstname() + " " + testData.getUser().getLastname());
			fillCardNumberField(testData.getCard().getCardNumber());

			String expirationYYYY = testData.getCard().getExpirationYYYY();
			String expirationYY = expirationYYYY.substring(expirationYYYY.length() - 2);
			String expirationDate = testData.getCard().getExpirationMM() + "/" + expirationYY;
			fillExpirationDate(expirationDate);
			testData.createRandomEmail();
			fillEmailField(testData.getRandomEmail());
			fillConfirmationEmailField(testData.getRandomEmail());
			try {
				captcha.click();
			} catch (Exception s) {
				jsExecutor.executeScript("arguments[0].click();", captcha);
			}
		} catch (Exception e) {
		}

		fillCardSecurityCodeField(testData.getCard().getSecurityCode());
	}

	public void clickContinueToReviewButton() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		continueToReviewButton.click();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(5, "wait for page load");
	}

	public boolean isEmailAddressFieldDisplayed() {
		boolean emailDisplayed = pageUtils.verifyIfDisplayed(email);
		return emailDisplayed;
	}

	public String getShippingAddress() {
		return shippingAddress.getAttribute("innerText");
	}

	public void clickOnPromoCodeLink() {
		pageUtils.sleepSeconds(5, "wait for promo to be applied");
		PromoLink.click();
	}

	public void enterPromoCode(String promocode) {
		pageUtils.waitForWebElement(promoCodeContainer);
		promoCodeContainer.sendKeys(promocode);
		pageUtils.sleepSeconds(5, "wait for promo to be applied");
	}

	public void clickOnApplyPromo() {
		applyPromo.click();

	}

	public boolean PromoApplied() {
		boolean status = false;
		pageUtils.sleepSeconds(10, "wait for promo conatiner");
		if (pageUtils.verifyIfDisplayed(promoScuccessContainer)) {
			status = true;
		}
		return status;
	}
	
	public void clickOnPromoCodeLinkMob() {
		promoLinkMob.click();
	}

	public void enterPromoCodeOnMob(String promocode) {
		pageUtils.waitForWebElement(promoCodeContainerMob);
		promoCodeContainerMob.sendKeys(promocode);
		pageUtils.sleepSeconds(5, "wait for promo to be applied");
	}

	public void clickOnApplyPromoMob() {
		applyPromoMob.click();
	}

	public Boolean isGiftWrapApplied() {
		pageUtils.waitForPageToLoad();
		return pageUtils.verifyIfDisplayed(giftWrapContainer);
	}
	    	
		public String getGiftWrapAmountBeforePromoApplied(){
			String gWAmount;
			pageUtils.waitForPageToLoad();
			pageUtils.sleepSeconds(5, "Wait for page to load");
			if(env.getCurrentLocale().toString().equals("en_US")) {
				String locator = "//span[contains(@class,'total')]//ancestor::ul//li[4]//span";	
				gWAmount = webDriver.findElement(By.xpath(locator)).getText();
			}else {
				String locator = "//span[contains(@class,'total')]//ancestor::ul//li[5]//span";	
				gWAmount = webDriver.findElement(By.xpath(locator)).getText();
			}
			return gWAmount;
		}
		
		public void fillFirstName(String userFirstName){
			firstName.sendKeys(userFirstName);
		}


	public String getGiftWrapAmountAfterPromoApplied() {
		String gWAmount;
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "Wait for page to load");
		if (env.getCurrentLocale().toString().equals("en_US")) {
			String locator = "//span[contains(@class,'total')]//ancestor::ul//li[5]//span";
			gWAmount = webDriver.findElement(By.xpath(locator)).getText();
		} else {
			String locator = "//span[contains(@class,'total')]//ancestor::ul//li[6]//span";
			gWAmount = webDriver.findElement(By.xpath(locator)).getText();
		}
		return gWAmount;
	}

	public void clickOnPlaceOrderButton() {
		try {
			pageUtils.waitForWebElement(placeOrderButton);
			pageUtils.sleepSeconds(10, "waiting for place order");
			pageUtils.waitForPageToLoad();
			pageUtils.waitTillWebElementIsClickable(placeOrderButton);
			jsExecutor.executeScript("arguments[0].click();", placeOrderButton);
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(5, "wait for page load");
		} catch (Exception e) {
			WebElement ele = webDriver.findElement(By.xpath("//*[@class=\\\"p--no-margin orderNumber\\\"]"));
			try {
				pageUtils.sleepSeconds(10, "waiting for place order");
				if (ele.isDisplayed()) {
					context.writeOut("On confirmation page");
				}else if(placeOrderButton.isDisplayed()){
					pageUtils.waitTillWebElementIsClickable(placeOrderButton);
					jsExecutor.executeScript("arguments[0].click();", placeOrderButton);
					pageUtils.waitForPageToLoad();
					pageUtils.waitForAjaxToComplete();
					pageUtils.sleepSeconds(5, "wait for page load");
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}
	}

	public void placeOrderMobile() {

		try {
			pageUtils.waitForPageToLoad();
			pageUtils.waitTillWebElementIsClickable(placeOrderMobile);
			jsExecutor.executeScript("arguments[0].click();", placeOrderMobile);
			pageUtils.waitForPageToLoad();
		} catch (Exception e) {
			pageUtils.sleepSeconds(5, "wait for page load");
			if(placeOrderMobile.isDisplayed()) {
				jsExecutor.executeScript("arguments[0].click();", placeOrderMobile);
				pageUtils.waitForPageToLoad();
			}
		}
	}

	public void selectPaypalPaymentOption() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "wait for page load");
		pageUtils.waitForWebElement(paypalPaymentOption);
		jsExecutor.executeScript("arguments[0].click();", paypalPaymentOption);
	}

	public void continueWithPaypalButton() {
		pageUtils.sleepSeconds(5, "wait for page load");
		pageUtils.waitForWebElement(continueToPaypalButton);
		pageUtils.waitForPageToLoad();
		continueToPaypalButton.click();
	}

	public void enterEmmialAndConfirmEmail() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "wait for page load");
		testData.createRandomEmail();
		testData.createRandomEmail();
		fillEmailField(testData.getRandomEmail());
		fillConfirmationEmailField(testData.getRandomEmail());
	}

	public void clickOnEditPaymentLink() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForWebElement(editPaymentLink);
		jsExecutor.executeScript("arguments[0].click();", editPaymentLink);
		pageUtils.waitForAjaxToComplete();
	}

	public void fillLastName(String userLastName) {
		lastName.sendKeys(userLastName);
	}

	public void fillAddressLine1(String userAddress1) {
		address1.sendKeys(userAddress1);
	}

	public void fillAddressLine2(String userAddress2) {
		try {
			address2.sendKeys(userAddress2);
		} catch (Exception e) {
		}
	}

	public void fillCityLine(String userCity) {
		city.sendKeys(userCity);
	}

	public void fillPostalCode(String userPostalCode) {
		postalCode.sendKeys(userPostalCode);
	}

	public void fillPhone(String userPhone) {
		phone.sendKeys(userPhone);
	}

	public void selectStateOrProvince() {
		Select sel = new Select(selectState);
		if (env.getCurrentLocale().getCountry().equalsIgnoreCase("us")) {
			sel.selectByVisibleText("NJ - New Jersey");
		} else {
			sel.selectByValue("ON");
		}
	}

	public void fillUpBillingAddress() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();

		selectStateOrProvince();
		pageUtils.sleepSeconds(3, "wait for state selected");
		fillFirstName(testData.getUser().getFirstname());
		fillLastName(testData.getUser().getLastname());
		fillAddressLine1(testData.getUser().address.getStreetAddress1());

		try {
			fillAddressLine2(testData.getUser().address.getStreetAddress2());
		} catch (Exception e) {

		}

		try {
			fillPostalCode(testData.getUser().address.getPostalCode());
		} catch (Exception e) {

		}

		fillCityLine(testData.getUser().address.getCity());
		fillPhone(testData.getUser().getPhoneNumber());
	}

	public void fillUpEmployeeCardDetails() {
		try {
			fillCardholderNameField("Tester" + " " + "Mk");
			fillCardNumberField(testData.getCard().getCardNumber());

			String expirationYYYY = testData.getCard().getExpirationYYYY();
			String expirationYY = expirationYYYY.substring(expirationYYYY.length() - 2);
			String expirationDate = testData.getCard().getExpirationMM() + "/" + expirationYY;
			fillExpirationDate(expirationDate);

			fillEmailField(testData.getUser().getEmail());
			fillConfirmationEmailField(testData.getUser().getEmail());
		} catch (Exception e) {
		}
	}

	public void selectSavedBillingAddress() {
		pageUtils.waitForPageToLoad();
		System.out.println(savedBillingAddress1.getAttribute("innerText"));
		if (savedBillingAddress1.getAttribute("innerText").length() == 0) {
			clickSavedBillingAddressOption(1);
		}
	}

	public void clickSavedBillingAddressOption(int index) {
		Select sel = new Select(selectBillingAddressOption);
		sel.selectByIndex(index);
		pageUtils.waitForAjaxToComplete();
	}

	public void selectSavedCard() {
		pageUtils.waitForAjaxToComplete();
		Select sel = new Select(savedCard_loggedIn);
		sel.selectByValue("visa - 1111");
		System.out.println("dfsfa");
		fillCardSecurityCodeField(testData.getCard().getSecurityCode());
	}

	public void enterCVV() {
		fillCardSecurityCodeField(testData.getCard().getSecurityCode());
	}

	public void enterCVVIfCardAvailableElseAddCard() {
		if (!pageUtils.verifyIfDisplayed(savedCardsLabel))
			fillCardSecurityCodeField(testData.getCard().getSecurityCode());
		else {
			fillUpRequiredFieldsWithNewEmail();
		}
		
	}

	public void enterCheckoutFnameLnameWithSPLchar() {
		pageUtils.sleepSeconds(3, "wait for page load");
		String expectedFNameError = pageUtils.getTextTranslation("first-name-error");
		String expectedLNameError = pageUtils.getTextTranslation("second-name-error");
		context.writeOut("save Fname Error is: " + expectedFNameError);
		context.writeOut("save Lname Error is: " + expectedLNameError);

		String str = "<>\\\"";
		for (int i = 0; i < str.length(); i++) {

			String name = "jon" + str.charAt(i);
			System.out.println(name);
			firstName.sendKeys(name);
			pageUtils.sleepSeconds(1, "wait for page load");
			lastName.sendKeys(name);
			pageUtils.sleepSeconds(3, "wait for page load");
			String actFnameError = fNameError.getText();
			firstName.clear();
			pageUtils.sleepSeconds(3, "wait for page load");
			String actLnameerror = lNameError.getText();
			lastName.clear();
			if (env.getCurrentLocale().getCountry().equalsIgnoreCase("fr_ca")) {
				String expectedFNameError_CA = pageUtils.getTextTranslation("ca-first-name-error");
				String expectedLNameError_CA = pageUtils.getTextTranslation("ca-second-name-error");
				context.writeOut("save Fname Error is: " + expectedFNameError_CA);
				context.writeOut("save Lname Error is: " + expectedLNameError_CA);
				Assert.assertEquals("SPL character is accepted", expectedFNameError_CA, actFnameError);
				Assert.assertEquals("SPL character is accepted", expectedLNameError_CA, actLnameerror);
				
			} else {

				context.writeOut("save Fname Error is: " + actFnameError);
				context.writeOut("save Lname Error is: " + actLnameerror);
				Assert.assertEquals("SPL character is accepted", expectedFNameError, actFnameError);
				Assert.assertEquals("SPL character is accepted", expectedLNameError, actLnameerror);
				
			}
			

		}

	}
	public void clickOnAddNewCardLink() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		jsExecutor.executeScript("arguments[0].click();", addNewCardLink);
		pageUtils.waitForAjaxToComplete();
	}

	public String getBagTotal() {
		pageUtils.waitForWebElement(getTotalPrice);
		pageUtils.sleepSeconds(7, "wait for page load");
		String getBagTotalPrice1 = getTotalPrice.getText();
		System.out.println(getBagTotalPrice1);
		String getBagTotalPrice2 = getBagTotalPrice1.trim().replaceAll("[^0-9]", "");
		String totalPrice = getBagTotalPrice2.trim().replace(",", "");
		context.saveData("totalPrice", totalPrice);
		context.writeOut("Total price on Billing page is: " + totalPrice);
		return totalPrice;
	}

	public boolean isOrderTotalZero() {
		boolean flag = false;
		pageUtils.sleepSeconds(5, "wait for page to load");
		if (orderTotal.getText().trim().contains(pageUtils.getTextTranslation("zero-order-total")))
			flag = true;
		return flag;
	}

	public void fillCardSecurityCodeFieldAddNew(String code) {
		cardSecurityCodeAddNew.sendKeys(code);
	}


	public boolean isLastFourDigitsOfAppliedGiftCardDisplayed(String card1, String card2) {
		boolean flag = false;
		int size = appliedGiftCardNumbers.size();
		for (int i = 0; i < size; i++) {
			String appliedGC = appliedGiftCardNumbers.get(i).getText().replaceAll("[^0-9]", "");
			int length = appliedGC.length();
			if (length == 4) {
				flag = true;
			}
			String cardNum1 = testData.getGiftCardDetails(card1).getCardNumber()
					.substring(testData.getGiftCardDetails(card1).getCardNumber().length() - 4);
			testData.addGiftCard(card2);
			String cardNum2 = testData.getGiftCardDetails(card2).getCardNumber()
					.substring(testData.getGiftCardDetails(card2).getCardNumber().length() - 4);
			if (appliedGC.equalsIgnoreCase(cardNum1) || appliedGC.equalsIgnoreCase(cardNum2)) {
				flag = true;
			}

		}

		return flag;
	}

	public boolean isAppliedGiftAmountDisplayed() {
		pageUtils.sleepSeconds(2, "wait for page load");
		return pageUtils.verifyIfDisplayed(giftCardAmount);

	}

	public boolean isAllGiftCardsRemoved() {
		pageUtils.sleepSeconds(2, "wait for page load");
		for (WebElement s : removeGiftCardLinks) {
			int size = removeGiftCardLinks.size();
			removeGiftCardLink.click();
			pageUtils.sleepSeconds(3, "wait for page load");
		}

		return true;

	}

	public void clickEditShippingSection() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "wait for page load");
		jsExecutor.executeScript("arguments[0].click();", editShippingSection);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}
	
	public void clickEditShippingSectionMobile() {
		pageUtils.sleepSeconds(5, "wait for payment page");
		pageUtils.waitForWebElement(editShippingSectionMobile);
		jsExecutor.executeScript("arguments[0].click();", editShippingSectionMobile);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}

}
