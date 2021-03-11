package com.mk.testframework.dt.page.checkout;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.util.PageUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author VThipperudrappa
 *
 */
public class MkCheckoutBilling_EU {

	@FindBy(css = "div[id='billingAddressLookUpForm'] p[class='field-note dontKnowPostCodeLink']")
	private WebElement enterAddressManuallyLink;

	@FindBy(css = "#billingDynamicAddressForm #address1")
	private WebElement address1;

	@FindBy(css = "#address2")
	private WebElement address2;

	@FindBy(css = "#billingDynamicAddressForm  #city")
	private WebElement city;

	@FindBy(css = "#billingDynamicAddressForm  #postalCode")
	private WebElement postalCode;

	@FindBy(css = ".billing_deliever .dropdown-toggle")
	private WebElement titleDropdown;

	@FindBy(css = ".billing_deliever  #first_name")
	private WebElement firstName;

	@FindBy(css = ".billing_deliever  #last_name")
	private WebElement lastName;

	@FindBy(css = ".billing_deliever  #phone")
	private WebElement phone;

	@FindBy(css = ".shipping_deliever .deliverAddrBtn")
	private WebElement shipToThisAddress;

	@FindBy(css = ".billing_deliever .dropdown-menu li")
	List<WebElement> titleDropDownMenu;

	@FindBy(css = ".billing_deliever .billingDeliverAddrBtn")
	private WebElement save;

	@FindBy(css = ".billing-address-display .guest_billing_address")
	private WebElement shippingAddress;

	@FindBy(css = "#continueToReview")
	private WebElement payNowButton;

	@FindBy(xpath = "(//a[@class=\"btn btn-primary full-width placeOrder translate\"])[3]")
	private WebElement payNowButtonDesktop;

	@FindBy(css = ".billing-add-collection-link")
	private WebElement loggedInaddBillingAddressLink;

	@FindBy(css = ".billing-address-add-link")
	private WebElement guestaddBillingAddressLink;
	
	@FindBy(css = ".billing-address-add-link")
	private WebElement addBillingAddressLink;

	@FindBy(css = ".billing-address-edit-link")
	private WebElement editBillingAddressLink;

	@FindBy(css = ".billing-edit-collection-link")
	private WebElement loggedInEditBillingAddressLink;

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

	@FindBy(xpath = "(//*[@id = 'cardCVV'])[2]")
	private WebElement cardSecurityCodeLoggedin;

	@FindBy(css = "#cardCVV")
	private WebElement cardSecurityCodeXPATH;

	@FindBy(css = "#giftCardsContainer .card_details_text")
	private WebElement applyGiftCardHeader;

	@FindBy(css = "#giftCardsContainer .payment-panel-body-container")
	private WebElement giftCardContainer;

	@FindBy(css = "#giftCardsContainer .payment-panel-body-container a")
	private List<WebElement> giftCardContainerButtons;

	@FindBy(css = "#giftCardsContainer .payment-panel-body-container a")
	private WebElement giftCardContainerCancel;

	@FindBy(css = "#giftCardsContainer .payment-panel-body-container button")
	private List<WebElement> giftCardContainerLinks;

	@FindBy(name = "gift-card")
	private WebElement giftCardNumberPlaceHolder;

	@FindBy(id = "giftCardPin")
	private WebElement giftCardPinNumber;

	@FindBy(id = "applyGiftCard")
	private WebElement applyGiftCardbtn;

	@FindBy(css = ".manageGiftCard")
	private WebElement manageGiftCardPanel;

	@FindBy(css = ".showGiftCardApplied")
	private WebElement showAppliedGiftCard;

	@FindBy(css = ".remove-giftCard")
	private WebElement removeGiftCardLink;

	@FindBy(id = "promotionsContainer")
	 private WebElement PromoLink;
	 
	 @FindBy(css = "#new-card-container #cardCVV")
	 private WebElement cardCvv_loggedIn;
	 
	 @FindBy(css = "#email")
	 private WebElement email;
	
	@FindBy(xpath = "//*[@id=\"shopping-bag-promo\"]")
	private WebElement promoCodeContainer;

	@FindBy(xpath = "//*[@id=\"orderPromotionForm\"]/div/div[2]/div/button")
	private WebElement applyPromo;

	@FindBy(id = "displayPromotionsContainer")
	private WebElement promoScuccessContainer;

	@FindBy(xpath = "(//*[@class = 'orderSummaryToggle link--block collapsed'])[3]")
	private WebElement viewOrderDetails;

	@FindBy(xpath = "(//*[@class = 'orderSummaryToggle link--block collapsed'])[1]")
	private WebElement viewOrderDetailsMobile;

	@FindBy(xpath = "(//*[@class = \"shipping-summary-details\"])[9]/ul")
	private WebElement shippingTo;

	@FindBy(xpath = "(//*[@class = \"shipping-summary-details\"])[1]/ul")
	private WebElement shippingToMobile;

	@FindBy(xpath = "(//*[@class = 'shipping-summary-details'])[11]/p[2]")
	private WebElement shippingMethod;

	@FindBy(xpath = "(//*[@class = 'shipping-summary-details'])[3]/p[2]")
	private WebElement shippingMethodMobile;
	
	@FindBy(xpath = " (//*[contains(@class, 'edit_shopping_bag')])[3]")
    private WebElement editShoppingBag;
	 	 
	@FindBy(css = ".paypal-payment")
	 private WebElement paypalPayment;
	 
	 @FindBy(xpath = "(//a[@class='btn btn-primary full-width placeOrder translate'])[3]")
	 private WebElement PlaceOrderButton;
	 
	 @FindBy(xpath = "(//ul[@class='shopping-bag-order-summary-totals'])[3]/li/div[2]/p")
	 private WebElement orderSummaryTotalPrice;
	 
	 @FindBy(css = "#saved-cc-payment")
	 private WebElement savedCardsLabel;
	 	
	@FindBy(xpath = "(//*[contains(@class,'total_order_summary total_label')]//..//following-sibling::div)[3]//span")
    private WebElement orderTotal;
	
	@FindBy(xpath = "//a[@id='manage-giftcard']//following-sibling::a")
    private WebElement addGiftCardLink;
	 
	 @FindBy(css = ".user_billing_address .first_name")
	 private WebElement userBillingAddressFirsName;
	 
	 @FindBy(css = "ul[class='guest_billing_address'] li[class='capitalizeName']")
	 private WebElement userBillingAddressFirsNameGuest;
	 
    @FindBy(xpath = "//input[@id='first_name']/following-sibling :: ul")
	private WebElement fNameError;

	@FindBy(xpath = "//input[@id='last_name']/following-sibling :: ul")
	private WebElement lNameError;
	 
	@FindBy(xpath = "(//input[@id='first_name'])[4]")
	private WebElement addNewBillingAddressFname;
		
	@FindBy(xpath = "(//input[@id='last_name'])[4]")
	private WebElement addNewBillinigAddressLname;
	 
	@FindBy(css = ".updateOrderDetails #editShippingAddr")
	private WebElement editShippingAddress;
	
	@FindBy(css = "#shipping-summary #editShippingAddr")
	private WebElement editShippingAddressMobile;

	@FindBy(css = ".updateOrderDetails #changeShippingMthd")
	private WebElement changeShippingMethod;
	
	@FindBy(css = "#shipping-summary #changeShippingMthd")
	private WebElement changeShippingMethodMobile;

	@FindBy(xpath = "//*[@class=\"shipping-methodPanel active\"]/div/button/div/div/p")
	private WebElement shippingOption;

	@FindBy(xpath = "//*[@id=\"shippingDeliveryOptions\"]/div")
	private List<WebElement> shippingOptionContainer;
	
	@FindBy(css = "#saveCardDetails")
	private WebElement saveCardDetails;

	@FindBy(id = "add-giftcard")
	private WebElement addANewGiftCardLink;

	@FindBy(css = ".gift-card-label span")
	private List<WebElement> appliedGiftCardNumbers;

	@FindBy(css = ".gift-card-amount span")
	private List<WebElement> giftCardAmount;

	@FindBy(css = ".remove-giftCard")
	private List<WebElement> removeGiftCardLinks;

	private PageUtils pageUtils;
	private JavascriptExecutor jsExecutor;
	private WebDriver webDriver;
	private TestData testData;
	private Context context;

	@Inject
	public MkCheckoutBilling_EU(WebDriver webDriver, PageUtils pageUtils, TestData testData, Context context) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.testData = testData;
		this.webDriver = webDriver;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.context = context;
	}

	public void addNewBillingAddress() {
		try {
			pageUtils.waitForWebElement(loggedInaddBillingAddressLink);
			pageUtils.sleepSeconds(3, "wait for page load");
			jsExecutor.executeScript("arguments[0].click();", loggedInaddBillingAddressLink);
			pageUtils.waitForWebElement(enterAddressManuallyLink);
			pageUtils.scrollToElement(enterAddressManuallyLink);
			pageUtils.webElementHighLighterMethod(enterAddressManuallyLink);
			pageUtils.sleepSeconds(5, "wait for page load");
			enterAddressManuallyLink.click();
			pageUtils.sleepSeconds(5, "wait for page load");
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			address1.sendKeys(testData.getUser().address.getStreetAddress1());
			city.sendKeys(testData.getUser().address.getCity());
			postalCode.sendKeys(testData.getUser().address.getPostalCode());
			titleDropdown.click();
			titleDropDownMenu.get(2).click();
			firstName.sendKeys(testData.getUser().getFirstname());
			lastName.sendKeys(testData.getUser().getLastname());
			phone.sendKeys(testData.getUser().getPhoneNumber());

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void addNewBillingAddressGuest() {
		try {
			pageUtils.waitForWebElement(enterAddressManuallyLink);
			pageUtils.sleepSeconds(3, "wait for page load");
			pageUtils.waitForWebElement(enterAddressManuallyLink);
			pageUtils.scrollToElement(enterAddressManuallyLink);
			pageUtils.webElementHighLighterMethod(enterAddressManuallyLink);
			pageUtils.sleepSeconds(5, "wait for page load");
			enterAddressManuallyLink.click();
			pageUtils.sleepSeconds(5, "wait for page load");
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			address1.sendKeys(testData.getUser().address.getStreetAddress1());
			city.sendKeys(testData.getUser().address.getCity());
			postalCode.sendKeys(testData.getUser().address.getPostalCode());
			titleDropdown.click();
			titleDropDownMenu.get(2).click();
			firstName.sendKeys(testData.getUser().getFirstname());
			lastName.sendKeys(testData.getUser().getLastname());
			phone.sendKeys(testData.getUser().getPhoneNumber());

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void addNewBillingAddressGuest(String fname, String lname) {
		try {
			pageUtils.waitForWebElement(enterAddressManuallyLink);
			pageUtils.sleepSeconds(3, "wait for page load");
			pageUtils.waitForWebElement(enterAddressManuallyLink);
			pageUtils.scrollToElement(enterAddressManuallyLink);
			pageUtils.webElementHighLighterMethod(enterAddressManuallyLink);
			pageUtils.sleepSeconds(5, "wait for page load");
			enterAddressManuallyLink.click();
			pageUtils.sleepSeconds(5, "wait for page load");
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			address1.sendKeys(testData.getUser().address.getStreetAddress1());
			city.sendKeys(testData.getUser().address.getCity());
			postalCode.sendKeys(testData.getUser().address.getPostalCode());
			titleDropdown.click();
			titleDropDownMenu.get(2).click();
			firstName.sendKeys(context.getSavedData("FirstName"));
			context.writeOut(context.getSavedData("FirstName"));
			lastName.sendKeys(context.getSavedData("LastName"));
			context.writeOut(context.getSavedData("LastName"));
			phone.sendKeys(testData.getUser().getPhoneNumber());

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String iVerifySpecialCharecterInBillingAddress(String guest) {
		String firstName="";
		if(guest.equalsIgnoreCase("guest")) {
			pageUtils.sleepSeconds(5, "wait for page load");
			pageUtils.waitForWebElement(userBillingAddressFirsNameGuest);

			firstName=userBillingAddressFirsNameGuest.getText();
		}else {
			pageUtils.sleepSeconds(5, "wait for page load");
			pageUtils.waitForWebElement(userBillingAddressFirsName);

			firstName=userBillingAddressFirsName.getText();
		}
		return firstName;
	}
	
	public void clickSave() {
		pageUtils.sleepSeconds(3, "wait for page load");
		save.click();
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "wait for page load");
	}

	public String getShippingAddress() {
		return shippingAddress.getAttribute("innerText");
	}

	public void clickPayNow() {
		pageUtils.scrollToElement(payNowButton);
		pageUtils.waitForPageToLoad();
		jsExecutor.executeScript("arguments[0].click();", payNowButton);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(30, "wait for page load");
	}

	public void clickPayNowButton() {
		pageUtils.scrollToElement(payNowButtonDesktop);
		pageUtils.waitForPageToLoad();
		jsExecutor.executeScript("arguments[0].click();", payNowButtonDesktop);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(40, "wait for page load");
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

	public boolean isApplyAGiftcardDisplayed() {
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(3, "wait for page load");

		return pageUtils.verifyIfDisplayed(applyGiftCardHeader);
	}

	public boolean isApplyAGiftcardPanelOpen() {
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "wait for page load");
		applyGiftCardHeader.click();
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(1, "wait for page load");
		return pageUtils.verifyIfDisplayed(giftCardContainerCancel);
	}

	public boolean isCancelLinkDisplayedOnApplyGiftCardPanel() {
		isApplyAGiftcardPanelOpen();
		pageUtils.sleepSeconds(2, "wait for page load");
		return pageUtils.verifyIfDisplayed(giftCardContainerCancel);
	}

	public boolean isEditBillingAddressLinkDisplayed() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "wait for page load");

		boolean linkDisplayed = false;

		if (pageUtils.verifyIfDisplayed(loggedInEditBillingAddressLink)
				|| pageUtils.verifyIfDisplayed(editBillingAddressLink)) {
			linkDisplayed = true;
		}

		return linkDisplayed;
	}

	public boolean isAddNewBillingAddressLinkDisplayed() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		boolean linkDisplayed = false;
		if (pageUtils.verifyIfDisplayed(loggedInaddBillingAddressLink)
				|| pageUtils.verifyIfDisplayed(addBillingAddressLink)) {
			linkDisplayed = true;
		}
		return linkDisplayed;
	}

	public void fillCardholderNameField() {
		pageUtils.waitTillWebElementIsClickable(cardHolderName);
		cardHolderName.sendKeys(testData.getUser().getFirstname() + " " + testData.getUser().getLastname());
	}

	public void fillCardholderNameField(String cardHolder) {
		pageUtils.waitTillWebElementIsClickable(cardHolderName);
		cardHolderName.sendKeys(cardHolder);
	}

	public void fillCardNumberField() {
		pageUtils.waitTillWebElementIsClickable(cardNumber);
		cardNumber.sendKeys(testData.getCard().getCardNumber());
	}

	public void clickCardExpirationMM() {
		pageUtils.scrollToElement(cardExpirationMM);
		cardExpirationMM.click();
		pageUtils.waitForAjaxToComplete();
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
		pageUtils.scrollToElement(cardExpirationYYYY);
		cardExpirationYYYY.click();
		pageUtils.waitForAjaxToComplete();
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
		pageUtils.waitTillWebElementIsClickable(cardSecurityCode);
		cardSecurityCode.sendKeys(testData.getCard().getSecurityCode());
	}

	public void fillCardSecurityCodeFieldLoggedin() {
		pageUtils.waitTillWebElementIsClickable(cardSecurityCodeLoggedin);
		cardSecurityCodeLoggedin.sendKeys(testData.getCard().getSecurityCode());
	}

	public void fillNewCardSecurityCodeField() {
		pageUtils.waitTillWebElementIsClickable(cardCvv_loggedIn);
		cardCvv_loggedIn.sendKeys(testData.getCard().getSecurityCode());
	}
	
	public void fillUpRequiredCreditCardFields() {
		fillCardholderNameField();
		fillCardNumberField();
		selectCardExpirationMM();
		selectCardExpirationYYYY();
		fillCardSecurityCodeField();
	}
	
public void fillUpRequiredCreditCardFieldsLoggedin() {
	fillCardholderNameField();
	fillCardNumberField();
	selectCardExpirationMM();
	selectCardExpirationYYYY();
	fillCardSecurityCodeFieldLoggedin();
}

	public void fillUpRequiredNewCreditCardFields_loggedIn() {
		fillCardholderNameField();
		fillCardNumberField();
		selectCardExpirationMM();
		selectCardExpirationYYYY();
		fillNewCardSecurityCodeField();
	}

	public void clickApplyGiftCardHeader() {
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "1 sec wait for ajax load");
		applyGiftCardHeader.click();
		pageUtils.waitForAjaxToComplete();
	}

	public boolean isCloseLinkDisplayedOnApplyGiftCardPanel() {
		pageUtils.sleepSeconds(2, "wait for page load");
		return pageUtils.verifyIfDisplayed(giftCardContainerCancel);
	}

	public void closeGiftCardPopUp() {
		pageUtils.sleepSeconds(2, "wait for page load");
		giftCardContainerCancel.click();
		pageUtils.sleepSeconds(2, "wait for page load");
	}

	public void enterGiftCardNumber() {
		pageUtils.sleepSeconds(5, "wait for page load");
		
		String giftCardNumber = testData.getGiftCard().getCardNumber();
		//String giftCardNumber=testData.getCard().getCardNumber();
		giftCardNumberPlaceHolder.sendKeys(giftCardNumber);
		pageUtils.sleepSeconds(2, "wait for page load");
	}

	public void enterGiftCardPin() {
		String giftCardNumber=testData.getGiftCard().getSecurityCode();
		//String giftCardNumber=testData.getCard().getSecurityCode();
		giftCardPinNumber.sendKeys(giftCardNumber);
		pageUtils.sleepSeconds(2, "wait for page load");
	}

	public void clickOnUseItBtn() {
		pageUtils.sleepSeconds(2, "wait for page load");
		applyGiftCardbtn.click();
		pageUtils.waitForAjaxToComplete();
	}

	public boolean isGiftCardManagePanelDisplayed() {
		pageUtils.sleepSeconds(2, "wait for page load");
		return pageUtils.verifyIfDisplayed(manageGiftCardPanel);
	}

	public boolean isRemoveGiftCardLinkDisplayed() {
		pageUtils.sleepSeconds(2, "wait for page load");
		if (showAppliedGiftCard.isDisplayed()) {
			showAppliedGiftCard.click();
		}
		pageUtils.sleepSeconds(2, "wait for page load");
		return pageUtils.verifyIfDisplayed(removeGiftCardLink);
	}

	public void clickOnRemoveGiftCardLink() {
		pageUtils.sleepSeconds(2, "wait for page load");
		showAppliedGiftCard.click();
		pageUtils.sleepSeconds(10, "wait for page load");
		removeGiftCardLink.click();
		pageUtils.sleepSeconds(2, "wait for page load");
	}

	public String getGiftCardContainerText() {
		return giftCardContainer.getAttribute("innerText");
	}

	public boolean doesGiftCardCheckBalanceLinkExist() {
		boolean checkBalanceLinkExists = false;

		String checkBalanceText = "check the balance";

		List<WebElement> linksList = giftCardContainerLinks;

		int i = 0;
		while (!checkBalanceLinkExists && i < linksList.size()) {
			if (linksList.get(i).getAttribute("innerText").toLowerCase()
					.contains(pageUtils.getTextTranslation(checkBalanceText))) {
				checkBalanceLinkExists = true;
				break;
			} else {
				i++;
			}
		}
		return checkBalanceLinkExists;
	}

	public boolean doesGiftCardCheckBalanceButtonExist() {
		boolean checkBalanceButtonExists = false;

		String checkBalanceText = "check the balance";

		List<WebElement> linksList = giftCardContainerButtons;

		int i = 0;
		while (!checkBalanceButtonExists && i < linksList.size()) {
			if (linksList.get(i).getAttribute("innerText").toLowerCase()
					.contains(pageUtils.getTextTranslation(checkBalanceText))) {
				checkBalanceButtonExists = true;
				break;
			} else {
				i++;
			}
		}
		return checkBalanceButtonExists;
	}

	public void enterAdditionalDetailsAndContinue() {
		pageUtils.waitTillWebElementIsVisible(By.id("klarna-klarna-payments-pay-later-cont-fullscreen"));
		webDriver.switchTo().frame("klarna-klarna-payments-pay-later-cont-fullscreen");

		try {
			webDriver.findElement(By.id("purchase-approval-title")).click();
			webDriver.findElements(By.cssSelector("#purchase-approval-title option")).get(1).click();
		} catch (Exception e) {
		}

		webDriver.findElement(By.id("purchase-approval-date-of-birth")).sendKeys("10101970");
		webDriver.findElement(By.id("purchase-approval-continue")).click();
		webDriver.switchTo().defaultContent();
		pageUtils.sleepSeconds(5, "wait for order completion");
	}

	public void clickOnPromoCodeLink() {
		PromoLink.click();
	}
		  
	public void applyPromocode(String promo) {
		try {
			pageUtils.sleepSeconds(5, "wait for page to load");
			PromoLink.click();
			enterPromoCode(promo);
			applyPromo.click();		
		} catch (Exception e) {
			System.out.println("asfa");
		}
	}
	
	public String getGiftWrapAmount() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(2, "Wait for page to load");
		String locator = "(//div[contains(@class,'priceList')])[3]//p[contains(text(),'"+pageUtils.getTextTranslation("gift-wrap")+"')]//..//following-sibling::div//span";	
		return webDriver.findElement(By.xpath(locator)).getText();
	}

	public void enterAdditionalDetailsAndContinueKlarnaPayLater() {
		pageUtils.waitTillWebElementIsVisible(By.id("klarna-klarna-payments-pay-later-cont-fullscreen"));
		webDriver.switchTo().frame("klarna-klarna-payments-pay-later-cont-fullscreen");

		try {
			webDriver.findElement(By.id("purchase-approval-form-user-title")).click();
			webDriver.findElements(By.cssSelector("#purchase-approval-form-user-title option")).get(1).click();
		} catch (Exception e) {
		}

		webDriver.findElement(By.id("purchase-approval-form-date-of-birth")).sendKeys("10101970");
		webDriver.findElement(By.id("purchase-approval-form-continue-button")).click();
		webDriver.switchTo().defaultContent();
		pageUtils.sleepSeconds(5, "wait for order completion");
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
		pageUtils.verifyIfDisplayed(promoScuccessContainer);
		pageUtils.sleepSeconds(5, "wait for promo conatiner");
		return true;

	}
		
	public void fillUpEmployeeCardDetails() {
		try{
			pageUtils.waitTillWebElementIsClickable(cardHolderName);
			cardHolderName.sendKeys("Tester"+" "+"Mk");
			fillCardNumberField();
			selectCardExpirationMM();
			selectCardExpirationYYYY();
			fillCardSecurityCodeField();
		}
		catch(Exception e){
		}
	}
	
	public void clickOnpalceOrderButton()
	{
		pageUtils.sleepSeconds(5, "wait for page load");
		pageUtils.waitTillWebElementIsClickable(PlaceOrderButton);
		jsExecutor.executeScript("arguments[0].click();", PlaceOrderButton);
		//PlaceOrderButton.click();
	}

	public void clickOnViewOrderDetailsMobile() {
		try {
			pageUtils.sleepSeconds(2, "wait for page load");
			viewOrderDetailsMobile.click();
			pageUtils.waitForAjaxToComplete();
		} catch (Exception e) {
			context.embedScreenshots();
		}

	}

	public void clickOnViewOrderDetails() {
		try {
			pageUtils.sleepSeconds(2, "wait for page load");
			viewOrderDetails.click();
			pageUtils.waitForAjaxToComplete();
		} catch (Exception e) {
			context.embedScreenshots();
		}
	}

	public void verifyShippingAddressInOrderSummary() {
		pageUtils.waitForPageToLoad();
		String expected = context.getSavedData("shippingAddressText").replaceAll("[^A-Za-z0-9]", "");
		String actualAddress = shippingTo.getAttribute("innerText").replaceAll("[^A-Za-z0-9]", "");
		pageUtils.sleepSeconds(2, "wait for page load");
		context.writeOut(actualAddress);
		Assert.assertEquals("Shipping Address doesn't match", expected, actualAddress);
	}

	public void verifyShippingAddressInOrderSummaryMobile() {
		pageUtils.waitForPageToLoad();
		String expected = context.getSavedData("shippingAddressText").replaceAll("[^A-Za-z0-9]", "");
		String actualAddress = shippingToMobile.getAttribute("innerText").replaceAll("[^A-Za-z0-9]", "");
		pageUtils.sleepSeconds(2, "wait for page load");
		context.writeOut(actualAddress);
		Assert.assertEquals("Shipping Address doesn't match", expected, actualAddress);
	}

	public void verifyShippingMethodInOrderSummary() {
		pageUtils.waitForPageToLoad();
		jsExecutor.executeScript("arguments[0].click();", shippingMethod);
		pageUtils.sleepSeconds(5, "wait for page load");
		String shippingMethodOrderSummary = shippingMethod.getText().trim().replaceAll("[^a-zA-Z]", "");
		context.writeOut(shippingMethodOrderSummary);
		Assert.assertEquals("Shipping Method doesn't match", context.getSavedData("shippingOptionText"),
				shippingMethodOrderSummary);
	}

	public void verifyShippingMethodInOrderSummaryMobile() {
		pageUtils.waitForPageToLoad();
		jsExecutor.executeScript("arguments[0].click();", shippingMethodMobile);
		pageUtils.sleepSeconds(5, "wait for page load");
		String shippingMethodOrderSummary = shippingMethodMobile.getText().trim().replaceAll("[^a-zA-Z]", "");
		context.writeOut(shippingMethodOrderSummary);
		Assert.assertEquals("Shipping Method doesn't match", context.getSavedData("shippingOptionText"),
				shippingMethodOrderSummary);
	}
	
	public void selectPaypalPaymemntOption()
	{
	pageUtils.waitForPageToLoad();
	pageUtils.sleepSeconds(5, "wait for page load");
	jsExecutor.executeScript("arguments[0].click();", paypalPayment);
	}
	
		  public void editShoppingBag() {
			   pageUtils.verifyIfDisplayed(editShoppingBag);
			   pageUtils.sleepSeconds(5, "wait for promo conatiner");
			   pageUtils.waitForPageToLoad();
			
		}
	
	public double getTotalFromOrderSummary() {
		pageUtils.waitForWebElement(orderSummaryTotalPrice);
		pageUtils.sleepSeconds(5, "wait for page load");
		String getTotalInOrderSummary = orderSummaryTotalPrice.getText();
		context.saveData("OrderTotalPrice", getTotalInOrderSummary);
		context.writeOut("Total amount in Cart is: "+ getTotalInOrderSummary);
		String getOrderTotal = getTotalInOrderSummary.trim().replaceAll("[^0-9]", "");
		double getOrderTotal1 = Double.parseDouble(getOrderTotal.toString());
		return getOrderTotal1;
	}
		  public void clickAddNewBillingAddressLink(){
				pageUtils.sleepSeconds(5, "wait for page load");
				loggedInaddBillingAddressLink.click();
				pageUtils.waitForPageToLoad();
				pageUtils.waitForAjaxToComplete();
			}
		  
	public void enterCheckoutBillingFnameLnameWithSPLchar() {
				String expectedFNameError = pageUtils.getTextTranslation("first-name-error");
				String expectedLNameError = pageUtils.getTextTranslation("billing-second-name-error");
				context.writeOut("save Fname Error is: " + expectedFNameError);
				context.writeOut("save Lname Error is: " + expectedLNameError);

				String str = "<>\\\"";
				for (int i = 0; i < str.length(); i++) {

					String name = "jon" + str.charAt(i);
					System.out.println(name);
					addNewBillingAddressFname.sendKeys(name);
					addNewBillinigAddressLname.sendKeys(name);
					String actFnameError = fNameError.getText();
					addNewBillingAddressFname.clear();
					String actLnameerrorv = lNameError.getText();
					addNewBillinigAddressLname.clear();
					context.writeOut("Actual Fname Error is: " + actFnameError);
					context.writeOut("Actual Lname Error is: " + actLnameerrorv);
					Assert.assertEquals("SPL character is accepted", expectedFNameError, actFnameError);
					Assert.assertEquals("SPL character is accepted", expectedLNameError, actLnameerrorv);
					pageUtils.sleepSeconds(3, "Wait");

				}
	}

	public boolean isNewGiftCardPanelOpen() {
		pageUtils.sleepSeconds(2, "wait for page load");
		addANewGiftCardLink.click();
		pageUtils.sleepSeconds(2, "wait for page load");
		return pageUtils.verifyIfDisplayed(giftCardContainer);
	}

	public boolean isLastFourDigitsOfAppliedGiftCardDisplayed(String card1, String card2) {
		boolean flag = false;
		pageUtils.sleepSeconds(2, "wait for page load");
		showAppliedGiftCard.click();
		pageUtils.sleepSeconds(2, "wait for page load");
		int size = appliedGiftCardNumbers.size();
		for (int i = 0; i < size; i++) {
			String appliedGC = appliedGiftCardNumbers.get(i).getText().replaceAll("[^0-9]", "");
			testData.addGiftCard(card1);
			String cardNum1 = testData.getGiftCard().getCardNumber();
			testData.addGiftCard(card2);
			String cardNum2 = testData.getGiftCard().getCardNumber();
			if (cardNum1.equals(appliedGC) || cardNum2.equals(appliedGC)) {
				flag = true;
			}
		}

		return flag;
	}

	public boolean isAppliedGiftAmountDisplayed() {
		boolean flag = false;
		pageUtils.sleepSeconds(2, "wait for page load");
		for (int i = 0; i < giftCardAmount.size(); i++) {
			flag = pageUtils.verifyIfDisplayed(giftCardAmount.get(i));
			context.writeOut("Gift card Amount: " + giftCardAmount.get(i).getText());
		}
		return flag;

	}

	public void clickOnRemoveGiftCardsLink() {
		pageUtils.sleepSeconds(2, "wait for page load");
		int size = removeGiftCardLinks.size();
		context.writeOut("There are total: "+size+" gift cards to remove");
		try {
			for (WebElement s : removeGiftCardLinks) {
				if (showAppliedGiftCard.isDisplayed()) {
					showAppliedGiftCard.click();
				}
				removeGiftCardLink.click();
				context.writeOut("Clicked on "+s.getText());
				pageUtils.sleepSeconds(5, "wait for page load");
			}
		} catch (Exception e) {
			try {
				for (WebElement s : removeGiftCardLinks) {
					if (showAppliedGiftCard.isDisplayed()) {
						showAppliedGiftCard.click();
					}
					jsExecutor.executeScript("arguments[0].click();", removeGiftCardLink);
					context.writeOut("Clicked on "+s.getText());
					pageUtils.sleepSeconds(5, "wait for page load");
				}
			} catch (Exception e2) {
				try {
					for (WebElement s : removeGiftCardLinks) {
						if (showAppliedGiftCard.isDisplayed()) {
							showAppliedGiftCard.click();
						}
						s.click();
						pageUtils.sleepSeconds(5, "wait for page load");
					}
				} catch (Exception e3) {
					for (WebElement s : removeGiftCardLinks) {
						if (showAppliedGiftCard.isDisplayed()) {
							showAppliedGiftCard.click();
						}
						jsExecutor.executeScript("arguments[0].click();", s);
						pageUtils.sleepSeconds(5, "wait for page load");
					}
				}
			}
		}
		pageUtils.sleepSeconds(5, "wait for page load");
	}

	public boolean isOrderTotalZero() {
		boolean flag = false;
		pageUtils.sleepSeconds(5, "wait for page to load");
		if(orderTotal.getText().trim().contains(pageUtils.getTextTranslation("zero-order-total")))
			flag = true;
		return flag;			
	}
	
	public void clickOnAddNewGiftCard() {
		pageUtils.sleepSeconds(2, "wait for page to load");
		addGiftCardLink.click();
	}
	
	public void enterCVVIfCardAvailableElseAddCard() {
		if(pageUtils.verifyIfDisplayed(savedCardsLabel)) {
			savedCardsLabel.click();
			pageUtils.sleepSeconds(1, "Wait for card panel to open");
			fillCardSecurityCodeField();
		}
		else {
			fillCardholderNameField();
			fillCardNumberField();
			selectCardExpirationMM();
			selectCardExpirationYYYY();
			WebElement cardSecurityCode = webDriver.findElement(By.xpath("(//input[@id='cardCVV'])[2]"));
			cardSecurityCode.sendKeys(testData.getCard().getSecurityCode());
		}	
	}
	
	public boolean verifyEditShippingAddressLink() {
		pageUtils.waitForPageToLoad();
		if (pageUtils.verifyIfDisplayed(editShippingAddress)) {
			return true;
		}

		return false;
	}
	
	public boolean verifyEditShippingAddressLinkMobile() {
		pageUtils.waitForPageToLoad();
		if (pageUtils.verifyIfDisplayed(editShippingAddressMobile)) {
			return true;
		}

		return false;
	}

	public boolean verifyChangeShippingMethodLink() {
		pageUtils.waitForPageToLoad();
		if (pageUtils.verifyIfDisplayed(changeShippingMethod)) {
			return true;
		}

		return false;
	}
	
	public boolean verifyChangeShippingMethodLinkMobile() {
		pageUtils.waitForPageToLoad();
		if (pageUtils.verifyIfDisplayed(changeShippingMethodMobile)) {
			return true;
		}

		return false;
	}

	public void clickOnChangeShippingMethodLink() {
		pageUtils.waitForWebElement(changeShippingMethod);
		jsExecutor.executeScript("arguments[0].click();", changeShippingMethod);
		pageUtils.waitForPageToLoad();
	}
	
	public void clickOnChangeShippingMethodLinkMobile() {
		pageUtils.waitForWebElement(changeShippingMethodMobile);
		jsExecutor.executeScript("arguments[0].click();", changeShippingMethodMobile);
		pageUtils.waitForPageToLoad();
	}

	public void selectShippingOption() {
		pageUtils.sleepSeconds(3, "to check selected Method");
		pageUtils.waitTillWebElementIsClickable(shippingOption);
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(3, "to check selected Method");
		int max = shippingOptionContainer.size() - 2;
		int randnMumber = ThreadLocalRandom.current().nextInt(0, max);
		try {
			webDriver
					.findElement(By.xpath("//*[@id='standard-shipping-" + randnMumber + "']/following-sibling::button"))
					.click();
			pageUtils.sleepSeconds(2, "to check selected Method");
			if (!pageUtils.verifyIfDisplayed(shippingOption)) {
				webDriver.findElement(By.xpath("//*[@id='standard-shipping-0']/following-sibling::button")).click();
			}
		} catch (Exception e) {

		}
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(2, "to check selected Method");
	}

	public void selectShippingOptionAnonymous() {
		pageUtils.sleepSeconds(3, "to check selected Method");
		pageUtils.waitTillWebElementIsClickable(shippingOption);
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(3, "to check selected Method");
		webDriver.findElement(By.xpath("//*[@id='SLOW-shipping']/following-sibling::button")).click();
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(10, "to check selected Method");
	}

	public void clickOnEditShippingAddressLink() {
		pageUtils.waitForWebElement(editShippingAddress);
		jsExecutor.executeScript("arguments[0].click();", editShippingAddress);
		pageUtils.waitForPageToLoad();
	}
	
	public void clickOnEditShippingAddressLinkMobile() {
		pageUtils.waitForWebElement(editShippingAddressMobile);
		jsExecutor.executeScript("arguments[0].click();", editShippingAddressMobile);
		pageUtils.waitForPageToLoad();
	}
	
	public void fillEmail(String userEmail) {
		email.sendKeys(userEmail);
	}

	public void clickSaveCardDetails() {
		pageUtils.waitTillWebElementIsClickable(saveCardDetails);
		jsExecutor.executeScript("arguments[0].click();", saveCardDetails);
	}
	
	public void addNewBillingAddressWithNewEmail() {
		enterAddressManuallyLink.click();
		pageUtils.waitForAjaxToComplete();
		address1.sendKeys(testData.getUser().address.getStreetAddress1());
		city.sendKeys(testData.getUser().address.getCity());
		postalCode.sendKeys(testData.getUser().address.getPostalCode());
		titleDropdown.click();
		titleDropDownMenu.get(2).click();
		firstName.sendKeys(testData.getUser().getFirstname());
		lastName.sendKeys(testData.getUser().getLastname());
		phone.sendKeys(testData.getUser().getPhoneNumber());
		testData.createRandomEmail();
		fillEmail(testData.getRandomEmail());
	}
	
	public void addNewBillingAddressWithSplChar() {
		try {
			pageUtils.waitForWebElement(loggedInaddBillingAddressLink);
			pageUtils.sleepSeconds(3, "wait for page load");
			jsExecutor.executeScript("arguments[0].click();", loggedInaddBillingAddressLink);
			pageUtils.waitForWebElement(enterAddressManuallyLink);
			pageUtils.scrollToElement(enterAddressManuallyLink);
			pageUtils.webElementHighLighterMethod(enterAddressManuallyLink);
			pageUtils.sleepSeconds(5, "wait for page load");
			enterAddressManuallyLink.click();
			pageUtils.sleepSeconds(5, "wait for page load");
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			address1.sendKeys(testData.getUser().address.getStreetAddress1());
			city.sendKeys(testData.getUser().address.getCity());
			postalCode.sendKeys(testData.getUser().address.getPostalCode());
			titleDropdown.click();
			titleDropDownMenu.get(2).click();
			firstName.sendKeys(context.getSavedData("FirstName"));
			lastName.sendKeys(context.getSavedData("LastName"));
			phone.sendKeys(testData.getUser().getPhoneNumber());

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void selectShippingOption(String shipOption) {
		pageUtils.sleepSeconds(3, "to check selected Method");
		pageUtils.waitTillWebElementIsClickable(shippingOption);
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(3, "to check selected Method");
		try {
			webDriver
					.findElement(By.xpath("//*[@value='"+shipOption+"']/following-sibling::button"))
					.click();
			pageUtils.sleepSeconds(2, "to check selected Method");
			if (!pageUtils.verifyIfDisplayed(shippingOption)) {
				webDriver.findElement(By.xpath("//*[@id='standard-shipping-0']/following-sibling::button")).click();
			}
		} catch (Exception e) {
			context.writeOut("Shipping Method"+ shipOption +"Not available ");
			context.embedScreenshots();
		}
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(2, "to check selected Method");
	}
}
