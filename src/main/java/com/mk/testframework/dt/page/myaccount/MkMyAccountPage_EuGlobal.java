package com.mk.testframework.dt.page.myaccount;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.core.exceptions.TestEnvironmentException;
import com.mk.testframework.dt.header.MkMyAccountMenu;
import com.mk.testframework.dt.page.shoppingbag.MkEditProductLightbox;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.dt.util.PageUtils.Resource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

public class MkMyAccountPage_EuGlobal {

	@FindBy(id = "header-back-link")
	private WebElement headerBackLink;

	@FindBy(css = ".my-account-link")
	private WebElement signInLink;

	@FindBy(css = ".shopping-bag-cart .shopping-bag-item")
	private List<WebElement> productRow;

	@FindBy(css = "#quantityCartSelector_ option[selected='true']")
	private WebElement selectedQuantity;

	@FindBy(css = "#removeItem a:nth-of-type(1)")
	private WebElement removeLink;

	@FindBy(css = ".shopping-bag-action-links .edit a")
	private WebElement editLink;

	@FindBy(css = ".customizedPrdInfo")
	private WebElement customizeSection;

	@FindBy(css = ".customizedPrdInfo .product-values")
	private WebElement customizedValue;

	@FindBy(css = ".welcome_msg")
	private WebElement myAccountWelcome;
	
    @FindBy(css = "#firstName-error")
    private WebElement fNameError;
    
    @FindBy(css = "#lastName-error")
    private WebElement lNameError;

	@FindBy(css = ".address_book_container")
	private WebElement myAccountAddressbookTitle;

	@FindBy(css = ".profile_nav > li:nth-child(3) > a")
	private WebElement clickAddressBook;

	@FindBy(css = ".address_btn_container .manualAddrForm")
	private WebElement clickEnterAddressManually;

	@FindBy(css = ".default_address:nth-child(2) > .address_delete_icons span")
	private WebElement clickEditdefaultShippingAddress;

	@FindBy(id = "address1")
	private WebElement AddressLine1;

	@FindBy(id = "address2")
	private WebElement AddressLine2;

	@FindBy(id = "city")
	private WebElement City;

	@FindBy(id = "state")
	private WebElement County;

	@FindBy(id = "postalCode")
	private WebElement PostalCode;

	@FindBy(xpath = "//div[4]/div/a[2]")
	private WebElement Title;

	@FindBy(id = "firstName")
	private WebElement AFirstName;

	@FindBy(id = "lastName")
	private WebElement ALastName;

	@FindBy(id = "phoneNumber")
	private WebElement APhoneNumber;

	@FindBy(id = "default_shipping")
	private WebElement ADefaultShippingAddress;

	@FindBy(id = "manualAddSubmit")
	private WebElement ASaveAddressButton;

	@FindBy(id = "addsubmit")
	private WebElement ASaveAddressButtonAU;

	@FindBy(id = "editsubmit")
	private WebElement AEditSaveAddressButton;

	@FindBy(id = "manualAddSubmit")
	private WebElement SavedAddressline1;

	@FindBy(css = ".default_address:nth-child(2)")
	private WebElement NewAddressline1;

	@FindBy(css = ".delete")
	private WebElement clickDeletedefaultshippingAddress;

	@FindBy(xpath = "//button[2]/span")
	private WebElement confirmDeletedefaultshippingAddress;

	@FindBy(css = "#lastName")
	private WebElement editLastName;

	@FindBy(xpath = "//ul[@class='profile_nav']/ li[2]/a")
	private WebElement paymentLink;

	@FindBy(id = "creditCardName")
	private WebElement cardName;

	@FindBy(id = "creditCardNumber")
	private WebElement cardNumber;

	@FindBy(xpath = "(//ul[@class='sbOptions']/li[4]/a)[1]")
	private WebElement selectMonth;

	@FindBy(id = "creditCardCVV")
	private WebElement enterCVV;

	@FindBy(xpath = "(//ul[@class='sbOptions']/li[12]/a)[2]")
	private WebElement selectYear;

	@FindBy(css = ".custom-checkbox label")
	private WebElement checkDeafaultPaymentCheckbox;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement savePaymentButton;

	@FindBy(xpath = "//ul[@class='individual_card']/li[3]/span")
	private WebElement getCardName;

	@FindBy(id = "username")
	private WebElement signInFlyoutEmailAddress;

	@FindBy(id = "login-password")
	private WebElement signInFlyoutPassword;

	@FindBy(xpath = "//*[@class=\"order_history_table\"]/tbody/tr")
	private List<WebElement> orderList;

	@FindBy(xpath = "(//*[@class=\"order_summary_details orderSummaryDetails\"])[1]/span")
	private WebElement subtotalLabel;

	@FindBy(xpath = "(//*[@class=\"order_summary_details orderSummaryDetails\"])[2]/span")
	private WebElement shippingLabel;

	@FindBy(xpath = "(//*[@class=\"order_summary_details orderSummaryDetails\"])[3]/span")
	private WebElement giftWrapLabel;

	@FindBy(xpath = "(//*[@class=\"order_summary_details orderSummaryDetails\"])[4]/span")
	private WebElement discountLabel;

	@FindBy(xpath = "(//*[@class=\"order_summary_details orderSummaryDetails\"])[5]/span")
	private WebElement taxLabel;

	@FindBy(xpath = "(//*[@class=\"order_summary_details nobrdr ordr_total orderSummaryDetails\"])[1]/span")
	private WebElement totalLabel;

	@FindBy(xpath = "(//*[@class=\"order_summary_details orderSummaryDetails\"])[1]/span[2]")
	private WebElement subtotalAmount;

	@FindBy(xpath = "(//*[@class=\"order_summary_details orderSummaryDetails\"])[2]/span[2]")
	private WebElement shippingAmount;

	@FindBy(xpath = "(//*[@class=\"order_summary_details orderSummaryDetails\"])[3]/span[2]")
	private WebElement giftWrapAmount;

	@FindBy(xpath = "(//*[@class=\"order_summary_details orderSummaryDetails\"])[4]/span[2]")
	private WebElement discountAmount;

	@FindBy(xpath = "(//*[@class=\"order_summary_details nobrdr ordr_total orderSummaryDetails\"])[1]/span[2]")
	private WebElement totalAmount;

	@FindBy(xpath = "//*[@class= 'orderShippedInfo']/span[1]")
	private WebElement dateContainer;
	
	@FindBy(css = ".individual_card")
	private List<WebElement> avialbleCards;

	@FindBy(xpath = "//ul[@class='individual_card']/li[2]")
	private WebElement getExpirationDate;
	
	@FindBy(xpath = "//*[@class = 'jspPane']/div")
	private List<WebElement> cardList;
	 
    @FindBy(xpath = "//div[contains(@class,'button_addtobag')]")
    private WebElement addAllToBag;
    
    @FindBy(css = "#favoritesCount")
	private WebElement favCountInProfile;
	
	@FindBy(xpath = "//p[@class='fontlistA-L color']//span[@class='descr_main_text']")
    private List<WebElement> favColorName;
    
    @FindBy(xpath = "//p[@class='fontlistA-L size']//span[@class='descr_main_text']")
    private List<WebElement> favSizeName;
    
    @FindBy(xpath = "//div[@class='box_options']//a[@class='fav_edit']")
    private List<WebElement> favEdit;
    
    @FindBy(xpath = "//ul[@id='qvChangeSizeValue']")
    private WebElement favSizeContainer;
    
    @FindBy(xpath = "//ul[@id='qvChangeSizeValue']//li//div")
    private List<WebElement> sizeFacets;
    
    @FindBy(xpath = "//ul[@id='qvChangeSizeValue']//li//div//label")
	private List<WebElement> sizeFacetValue;
	
    @FindBy(name="sign-in")
    private WebElement signInFlyoutSubmit;
    
    @FindBy(xpath = "//*[contains(@class,'product_panel')]")
    private List<WebElement> favorites;
    
    @FindBy(xpath = "//a[contains(@class,'remove')]")
    private List<WebElement> favoriteItems;
    
    @FindBy(xpath = "(//*[@class='ui-dialog-buttonset']//span)[1]")
    private WebElement okToRemoveFavItem;
    
    @FindBy(xpath = "//*[@class='account_favorite_content']//a[contains(@class,'View-all ')]")
    private WebElement viewAllLink;
    
    @FindBy(xpath = "//*[contains(@class,'favorite_container')]")
	private WebElement favoritesPageContainer;
	
	@FindBy(xpath = "//ul[@class='profile_nav']/ li[4]/a")
    private WebElement orderHistortLink;
    
    @FindBy(xpath = "//*[@class = 'welcome_msg']/span[2]")
	private WebElement isProfileNameDisplayed;
    
    @FindBy(css = ".user_profile_name")
	private WebElement getUserName;

	@FindBy(css = ".profile_address .add_new_container .View-all-new")
    private WebElement viewAllProfileAddress;
    
    @FindBy(css = ".profile_address .edit_user_address")
	private WebElement editProfileAddress;
		    
    @FindBy(css = ".new-bill-address a")
    private WebElement newBillingAddress;
    
    @FindBy(css = ".profile_payment .payment_edit")
    private WebElement editProfileBillingAddress;
    
    @FindBy(css=".saved_payment .sbSelector")
    private WebElement billingNewAddressline1;
	
	private PageUtils pageUtils;
	private WebDriver webDriver;
	private MkMyAccountMenu mkMyAccountMenu;
	private MkEditProductLightbox mkEditProductLightbox;
	private JavascriptExecutor jsExecutor;
	private Actions actionBuilder;
	private Environment environment;
	private TestData testData;
	private Context context;
	private MkMyAccountPage_Common mkMyAccountPage_Common;

	@Inject
	public MkMyAccountPage_EuGlobal(WebDriver webDriver, PageUtils pageUtils, MkMyAccountMenu mkMyAccountMenu,
			MkEditProductLightbox mkEditProductLightbox, Environment environment, TestData testData, Context context,
			MkMyAccountPage_Common mkMyAccountPage_Common) {
		PageFactory.initElements(webDriver, this);
		this.webDriver = webDriver;
		this.pageUtils = pageUtils;
		this.actionBuilder = new Actions(webDriver);
		this.mkMyAccountMenu = mkMyAccountMenu;
		this.mkEditProductLightbox = mkEditProductLightbox;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.environment = environment;
		this.testData = testData;
		this.context = context;
		this.mkMyAccountPage_Common = mkMyAccountPage_Common;

	}

	public void clickHeaderBackLink() {
		headerBackLink.click();

	}

	public int getProductCount() {
		return productRow.size();
	}

	public void clickRemoveLink() {
		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForWebElement(removeLink);
		jsExecutor.executeScript("arguments[0].scrollIntoView();", removeLink);
		jsExecutor.executeScript("arguments[0].click();", removeLink);
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForPageToLoad();
	}

	public void clickEditLink() {
		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
		pageUtils.waitForWebElement(removeLink);
		jsExecutor.executeScript("arguments[0].scrollIntoView();", editLink);
		jsExecutor.executeScript("arguments[0].click();", editLink);
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForPageToLoad();
		mkEditProductLightbox.waitForEditContainer();
		pageUtils.sleepSeconds(3, "Wait for edit modal to fully load");
	}

	public boolean myAccountLinkIsPresent() {
		return mkMyAccountMenu.waitForMyAccountLink();
	}

	public void clickAddressBook() {
		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
		pageUtils.waitForWebElement(clickAddressBook);
		jsExecutor.executeScript("arguments[0].scrollIntoView();", clickAddressBook);
		jsExecutor.executeScript("arguments[0].click();", clickAddressBook);

	}
	
	public void clickAddNewBillingAddress() {
		try {
			pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
			pageUtils.waitForWebElement(newBillingAddress);
			jsExecutor.executeScript("arguments[0].scrollIntoView();", newBillingAddress);
			jsExecutor.executeScript("arguments[0].click();", newBillingAddress);
			pageUtils.waitForAjaxToComplete();
			pageUtils.waitForPageToLoad();
			pageUtils.sleepSeconds(3, "Wait for edit modal to fully load");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public boolean waitForMyAccountWelcome() {
		return pageUtils.waitForWebElement(myAccountWelcome);
	}

	public boolean waitForAddressBookTitle() {
		return pageUtils.waitForWebElement(myAccountAddressbookTitle);
	}

	public void clickEnterAddressManually() {
		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
		pageUtils.waitForWebElement(clickEnterAddressManually);
		// clickEnterAddressManually.click();
		jsExecutor.executeScript("arguments[0].click();", clickEnterAddressManually);

	}

	public void enterAddressLine1(String Addline1) {
		pageUtils.waitForWebElement(AddressLine1);
		AddressLine1.clear();
		AddressLine1.sendKeys(Addline1);
	}

	public void enterAddressLine2(String Addline2) {
		return;
	}

	public void enterCity(String city) {
		pageUtils.waitForWebElement(City);
		City.clear();
		City.sendKeys(city);
	}

	public void enterCountyState(String county) {
		pageUtils.waitForWebElement(County);
		County.clear();
		County.sendKeys(county);
	}

	public void enterPostalCode(String pcode) {
		pageUtils.waitForWebElement(PostalCode);
		PostalCode.clear();
		PostalCode.sendKeys(pcode);
	}

	public void SelectTitle(String title) {

		pageUtils.sleepSeconds(2, "Title expanded");
		pageUtils.scrollToElement(PostalCode);

		actionBuilder.moveToElement(Title).sendKeys(Keys.TAB).build().perform();
		actionBuilder.moveToElement(Title).sendKeys(Keys.ENTER).build().perform();

		pageUtils.waitForAjaxToComplete();

		new TitleMenu(webDriver).selectTitle(title);

	}

	public class TitleMenu {

		@FindBy(css = ".sbOptions a")
		private List<WebElement> titleOptions;

		public TitleMenu(WebDriver webDriver) {
			PageFactory.initElements(webDriver, this);

		}

		public void selectTitle(String title) {

			String translatedTitle = getTranslationT(title);

			try {
				WebElement option4 = titleOptions.stream()
						.filter(s -> s.getText().equals(String.valueOf(translatedTitle))).findFirst().get();
				actionBuilder.moveToElement(option4).click().build().perform();
				pageUtils.waitForAjaxToComplete();
				pageUtils.waitForPageToLoad();
			} catch (NoSuchElementException e) {
				throw new TestEnvironmentException("Could not find Title option to click : " + e.getMessage());
			}
		}

		private String getTranslationT(String title) {

			ResourceBundle titleResource = pageUtils.getResourceBundle(Resource.TITLE);
			return titleResource.getString(pageUtils.buildResourceLookupKey(title));

		}

	}

	public void enterAddressFirstName(String Afname) {
		pageUtils.waitForWebElement(AFirstName);
		AFirstName.sendKeys(Afname);
	}

	public void enterAddressLastName(String Alname) {
		pageUtils.waitForWebElement(ALastName);
		ALastName.sendKeys(Alname);
	}

	public void enterAddressPhoneNumber(String Apnumber) {
		pageUtils.waitForWebElement(APhoneNumber);
		APhoneNumber.sendKeys(Apnumber);
	}

	public void defaultShippingAddress() {
		jsExecutor.executeScript("arguments[0].click();", ADefaultShippingAddress);
		pageUtils.waitForPageToLoad();
	}

	public void saveAddressbuttonclick() {

		if (environment.getCountry().equalsIgnoreCase("AU")) {

			jsExecutor.executeScript("arguments[0].click();", ASaveAddressButtonAU);
			pageUtils.waitForPageToLoad();
		} else {
			jsExecutor.executeScript("arguments[0].click();", ASaveAddressButton);
			pageUtils.waitForPageToLoad();
		}
	}

	public void saveEditAddressbuttonclick() {
		jsExecutor.executeScript("arguments[0].click();", AEditSaveAddressButton);
		pageUtils.waitForPageToLoad();
	}

	public String verifyAddressSaved() {
		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
		pageUtils.waitForAjaxToComplete();
		String Addressline1 = NewAddressline1.getText();
		return Addressline1;
	}

	public void clickEditdefaultShippingAddress() {
		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
		pageUtils.waitForWebElement(clickEditdefaultShippingAddress);
		jsExecutor.executeScript("arguments[0].scrollIntoView();", clickEditdefaultShippingAddress);
		jsExecutor.executeScript("arguments[0].click();", clickEditdefaultShippingAddress);

	}

	public void clickDeletedefaultShippingAddress() {
		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
		pageUtils.waitForWebElement(clickDeletedefaultshippingAddress);
		jsExecutor.executeScript("arguments[0].scrollIntoView();", clickDeletedefaultshippingAddress);
		jsExecutor.executeScript("arguments[0].click();", clickDeletedefaultshippingAddress);

	}

	public void confirmDeletedefaultShippingAddress() {
		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
		pageUtils.waitForWebElement(confirmDeletedefaultshippingAddress);
		jsExecutor.executeScript("arguments[0].scrollIntoView();", confirmDeletedefaultshippingAddress);
		jsExecutor.executeScript("arguments[0].click();", confirmDeletedefaultshippingAddress);

	}

	public void editLastName(String lname) {
		pageUtils.waitForWebElement(editLastName);
		pageUtils.scrollToElement(editLastName);
		pageUtils.waitForWebElement(editLastName);
		editLastName.clear();
		editLastName.sendKeys(lname);
	}

	public void resetLastName(String rlname) {
		pageUtils.scrollToElement(editLastName);
		pageUtils.sleepSeconds(5, "Edit Profile loaded");
		editLastName.clear();
		editLastName.sendKeys(rlname);
	}

	public void clickOnPaymentInformationLink() {
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "wait for page load");
		jsExecutor.executeScript("arguments[0].click();", paymentLink);
	}

	public void cardHolderName(String name) {
		pageUtils.waitForPageToLoad();
		pageUtils.waitTillWebElementIsClickable(cardName);
		cardName.sendKeys(name);
	}
    
    public void cardHolderNameWitSpecialChar() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitTillWebElementIsClickable(cardName);
		cardName.sendKeys(testData.getUser().getFirstname());
	}
	
	public void enterCardNumber() {
		try {
			pageUtils.waitTillWebElementIsClickable(cardNumber);
			pageUtils.scrollToElement(cardNumber);
			String cardNumberIs = testData.getCard().getCardNumber();
			cardNumber.sendKeys(testData.getCard().getCardNumber());
			System.out.println("card number is: " + cardNumberIs);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
    
    public void selectDateOfCardExpiration()
    {
		jsExecutor.executeScript("arguments[0].click();", selectMonth);
		pageUtils.sleepSeconds(2, "wait for 5 min");
		jsExecutor.executeScript("arguments[0].click();", selectYear);
	}

	public void enterSecurityCode() {
		pageUtils.waitTillWebElementIsClickable(enterCVV);
		enterCVV.sendKeys(testData.getCard().getSecurityCode());
	}

	public void makeDefaultPayment() {
		jsExecutor.executeScript("arguments[0].click();", checkDeafaultPaymentCheckbox);

	}

	public void clickSavePayment() {
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(3, "wait for page load");
		jsExecutor.executeScript("arguments[0].click();", savePaymentButton);

	}

	public void enterFlyoutEmailAddress(String email) {
		pageUtils.waitForWebElement(signInFlyoutEmailAddress);
		pageUtils.waitTillWebElementIsClickable(signInFlyoutEmailAddress);
		pageUtils.sleepSeconds(4, "signin page loaded");
		signInFlyoutEmailAddress.sendKeys(email);
	}

	public void enterFlyoutPassword(String password) {
		pageUtils.waitForWebElement(signInFlyoutPassword);
		signInFlyoutPassword.sendKeys(password);

	}

	public void clickSignIn() {
		pageUtils.waitForPageToLoad();
		jsExecutor.executeScript("arguments[0].click();", signInFlyoutSubmit);
		pageUtils.waitForPageToLoad();
	}

	public void clickOrderAtPosition(int number) {
		WebElement order = orderList.get((number - 1));
		WebElement orderNumber = order.findElement(By.xpath("//*[@class=\"order_history_table\"]/tbody/tr/td[2]/a"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", orderNumber);
		pageUtils.sleepSeconds(1, "wait for page load");
		pageUtils.waitForPageToLoad();
	}

	public boolean isSubtotalDisplayed() {
		return isOrderPriceLabelsDisplayed("subtotal_label", subtotalLabel);

	}

	public boolean isShippingDisplayed() {
		return isOrderPriceLabelsDisplayed("shipping_label", shippingLabel);

	}

	public boolean isGiftWrapDisplayed() {
		return isOrderPriceLabelsDisplayed("giftwrap_label", giftWrapLabel);

	}

	public boolean isDiscountDisplayed() {
		return isOrderPriceLabelsDisplayed("discount_label", discountLabel);
	}

	public boolean isTotalDisplayed() {
		return isOrderPriceLabelsDisplayed("total_label", totalLabel);
	}

	private boolean isOrderPriceLabelsDisplayed(String label, WebElement webElement) {
		boolean flag = false;
		String country = environment.getCurrentLocale().getCountry();
		String locale = environment.getLanguage();
		pageUtils.waitForPageToLoad();
		pageUtils.waitTillWebElementIsVisible(webElement, 2);
		String objectLabel = pageUtils.getTextTranslation(label);
		if (country.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("fr")) {
			objectLabel = pageUtils.getTextTranslation(label + "-ca");
		} else if ((country.equalsIgnoreCase("us") && locale.equalsIgnoreCase("en"))
				|| (country.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("en"))) {
			objectLabel = pageUtils.getTextTranslation(label + "-na");
		}

		WebElement element = webDriver.findElement(By.xpath("//span[contains(text(),'" + objectLabel + "')]"));
		if (element.isDisplayed()) {
			context.writeOut(objectLabel + " label displayed");
			flag = true;
		} else {
			context.writeOut("Expected was: " + objectLabel + " and Found: " + element);
		}
		return flag;
	}

	public boolean verifySubtotalAmount() {
		return verifyOrderPriceElementsValue("subtotal_label", subtotalAmount);

	}

	public boolean verifyShippingAmount() {
		return verifyOrderPriceElementsValue("shipping_label", shippingAmount);

	}

	public boolean verifyGiftWrapAmount() {
		return verifyOrderPriceElementsValue("giftWrap_label", giftWrapAmount);

	}

	public boolean verifyDiscountAmount() {

		return verifyOrderPriceElementsValue("discount_label", discountAmount);
	}

	public boolean verifyTotalAmount() {
		return verifyOrderPriceElementsValue("total_label", totalAmount);
	}

	private boolean verifyOrderPriceElementsValue(String label, WebElement webElement) {
		String contry = environment.getCurrentLocale().getCountry();
		String locale = environment.getLanguage();
		String objectLabel = pageUtils.getTextTranslation(label);
		if (contry.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("fr")) {
			objectLabel = pageUtils.getTextTranslation(label + "-ca");
		} else if (contry.equalsIgnoreCase("us") && locale.equalsIgnoreCase("en")) {
			objectLabel = pageUtils.getTextTranslation(label + "-na");
		}

		jsExecutor.executeScript("arguments[0].click();", webElement);
		String actual = webElement.getAttribute("innerText").trim().replace("\n", "").replace(" ", "").replace("\u00a0","");
		context.writeOut(objectLabel + " From Order Details Page : " + actual);

		String priceDetailsFromOrderConfirmation = context.getSavedData("orderPrices");
		String[] orderPricesList = priceDetailsFromOrderConfirmation.split("\n\n");
		String expected = "";
		boolean found = false;
		for (int i = 0; i < orderPricesList.length; i = i + 2) {
			if (objectLabel.equalsIgnoreCase("total")) {
				if (orderPricesList[i].toLowerCase().equals(objectLabel.toLowerCase())) {
					expected = orderPricesList[i + 1].trim().replace("\n", "").replace(" ", "").replace("\u00a0","");
					found = true;
					break;
				}
			} else if (orderPricesList[i].toLowerCase().contains(objectLabel.toLowerCase())) {
				expected = orderPricesList[i + 1].trim().replace("\n", "").replace(" ", "").replace("\u00a0","");
				found = true;
				break;
			}
		}
		if (!found) {
			expected = mkMyAccountPage_Common.getAmountWithCurrency(0).trim().replace("\n", "").replace(" ", "").replace("\u00a0","");
		}
		if (expected.equals(actual)) {
			return true;
		}
		return false;
	}

	public boolean orderSubmissionDateDisplayed() {
		pageUtils.waitForPageToLoad();
		if (pageUtils.verifyIfDisplayed(dateContainer)) {
			return true;
		}
		return false;
	}
	
		public void addCardIfNotAvailable() {
			pageUtils.waitForPageToLoad();
			pageUtils.sleepSeconds(5, "Wait for element to display");
			if(!(avialbleCards.size()>0)) {
				cardName.sendKeys(testData.getUser().getFirstname()+" "+testData.getUser().getLastname());
				cardNumber.sendKeys(testData.getCard().getCardNumber());
				selectDateOfCardExpiration();
				clickSavePayment();
				pageUtils.sleepSeconds(5, "Wait for page to load");
			}else {
				context.writeOut("Payment method available in profile");
			}
		}

	public boolean verifyCardIsSaved(String cardHolder) {
		boolean flag = false;
		pageUtils.sleepSeconds(10, "wait for page load");
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForWebElement(getCardName);
		for(int i=0; i<cardList.size(); i++) {
			String nameOnCard = cardList.get(i).findElement(By.cssSelector(".individual_card .name_card_holder .capitalizeName")).getText();
			if(nameOnCard.equalsIgnoreCase(cardHolder)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public boolean deleteSavedPayment(String cardHolder) {
		boolean flag = false;
		pageUtils.sleepSeconds(10, "wait for page load");
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForWebElement(getCardName);
		int cardSizeBeforeDelete = cardList.size();
		for(int i=0; i<cardList.size(); i++) {
			String nameOnCard = cardList.get(i).findElement(By.cssSelector(".individual_card .name_card_holder .capitalizeName")).getText();
			if(nameOnCard.equalsIgnoreCase(cardHolder)) {
				WebElement deleteCardLink = cardList.get(i).findElement(By.cssSelector(".payment_delete_icons a"));
				jsExecutor.executeScript("arguments[0].click();", deleteCardLink);
				pageUtils.sleepSeconds(2, "wait for page load");
				jsExecutor.executeScript("arguments[0].click();", webDriver.findElement(By.xpath("(//*[@type='button']/span)[2]")));
				pageUtils.waitForAjaxToComplete();
				pageUtils.waitForPageToLoad();
				break;
			}
		}
		int cardSizeAfterDelete = cardList.size();
		if(cardSizeBeforeDelete>cardSizeAfterDelete){
			flag = true;
		}
		return flag;
	}
	
	public int getFavoritesCount() {
		return favorites.size();
	}

	
	public boolean emptyMyFavorites() {
		boolean favoritesEmpty = false;
		int favSize = favorites.size();
		try {
			if(favSize>0){
				for (int i = 0; i < favSize; i++) {
					pageUtils.sleepSeconds(2, "Wait for page to display");
					favoriteItems.get(0).click();
					pageUtils.sleepSeconds(2, "wait for page to display");
					okToRemoveFavItem.click();
					pageUtils.waitForPageToLoad();
					pageUtils.sleepSeconds(5, "wait for page to display");
				}
			}
			if(favoriteItems.size()==0)
				favoritesEmpty=true;
			else
				favoritesEmpty=false;
		} catch (Exception e) {
			System.out.println("");
		}		
		return favoritesEmpty;
	}
	
	public void clickOnViewAllLink() {
		 viewAllLink.click();
	}
	
	public boolean isFavoritesPage() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5,"wait for page to load");
		return pageUtils.verifyIfDisplayed(favoritesPageContainer);
	}
	
	public int isProductsDisplayedInFavorites() {
		return favorites.size();
	}
	
	
	public void clickAddAllToBagButton() {
		pageUtils.sleepSeconds(2, "Wait for element to display");
		actionBuilder.moveToElement(addAllToBag);
		pageUtils.sleepSeconds(2, "Wait for element to display");
		addAllToBag.click();
		pageUtils.sleepSeconds(5, "Wait for element to display");
	}

	public String getActiveFavCountInProfile() {
		pageUtils.sleepSeconds(5, "Wait for element to display");
		return favCountInProfile.getAttribute("value");
	}
	
	public String changeSizeInEditFavPopUp() {
		String size = null;

		if (pageUtils.verifyIfDisplayed(favSizeContainer)) {
			int facetsSize= sizeFacets.size();
			for (int i = 0; i < facetsSize; i++) {
				if(!(sizeFacets.get(i).getAttribute("class").contains("disabled") || sizeFacets.get(i).getAttribute("class").contains("size-selected"))) {
					sizeFacets.get(i).click();
					pageUtils.sleepSeconds(5, "Wait fo for element to display");
					size = sizeFacetValue.get(i).getText();
					break;
				}	
			}			
		}else {
			size = null;
		}		
		return size;
	}

	
	public String getColorFromWishlistProduct(int position) {
		return favColorName.get(position-1).getText().trim();
	}

	public String getSizeFromWishlistProduct(int position) {
		String size;
		if(pageUtils.verifyIfDisplayed(favSizeName.get(position-1)))
			size = favSizeName.get(position-1).getText().trim();
		else
			size = null;
		return size;
	}
	
	public void clickOnEditLinkInFavorites() {
		actionBuilder.moveToElement(favEdit.get(0));
		jsExecutor.executeScript("arguments[0].click();", favEdit.get(0));
		pageUtils.sleepSeconds(10, "Wait for edit pop up to display");
	}
	
	public void removeFavoriteItem(int position) {
		actionBuilder.moveToElement(favoriteItems.get(position-1));
		jsExecutor.executeScript("arguments[0].click();", favoriteItems.get(position-1));
		pageUtils.sleepSeconds(2, "wait for page to display");
		okToRemoveFavItem.click();
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(2, "wait for page to display");
	}
	
	public void clickOnOrderHistoryLink() {
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "wait for page load");
		jsExecutor.executeScript("arguments[0].click();", orderHistortLink);
	}

	public boolean getWelcomeText() {
		pageUtils.waitForPageToLoad();
		  boolean flag = false;
		  
		  try { 
			  String userName = getUserName.getText(); 
		  String[] str = userName.split(" "); 
		  for (String userName1 : str) 
			  context.writeOut(userName1);
		  
		  String name = isProfileNameDisplayed.getText(); 
		  String[] str1 = name.split(" ");
		  for (String name1 : str1)
			  context.writeOut(name1);
		  
		  if (str1[0].strip().equalsIgnoreCase(str[0].strip())) {
		  
		  flag = true; 
		  context.writeOut("User name is displayed under Welcome Back heading");
		  }
		  
		  } catch (Exception e) { // TODO: handle exception }
		  
		  }
		return flag;
	}
	

	
	public void clickEditShippingAddressOnProfilePage() {
		pageUtils.waitForPageToLoad();
		jsExecutor.executeScript("arguments[0].click();", editProfileAddress);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}

	public void clickViewAllShippingAddressOnProfilePage() {
		pageUtils.waitForPageToLoad();
		jsExecutor.executeScript("arguments[0].click();", viewAllProfileAddress);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}

	
	public void clickEditBillingAddressOnProfilePage() {
		pageUtils.waitForPageToLoad();
		jsExecutor.executeScript("arguments[0].click();", editProfileBillingAddress);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}
	
	public String verifyBillingAddressSavedOnPaymentInfo() {
		pageUtils.sleepSeconds(5, "2 sec wait for ajax load");
		pageUtils.waitForAjaxToComplete();
		String Addressline1 = billingNewAddressline1.getText();
		return Addressline1;
	}
}
