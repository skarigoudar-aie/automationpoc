package com.mk.testframework.dt.page.myaccount;


import com.google.inject.Inject;
import com.mk.testframework.dt.header.MkMyAccountMenu;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.core.exceptions.TestEnvironmentException;
import com.mk.testframework.dt.page.shoppingbag.MkEditProductLightbox;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.dt.util.PageUtils.Resource;
import com.mk.testframework.core.env.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;


public class MkMyAccountPage_Common {

	@FindBy(id = "header-back-link")
	private WebElement headerBackLink;

	@FindBy(css = ".my-account-link")
	private WebElement signInLink;

	@FindBy(css = ".mk-sign-in .header-my-account a")
	private WebElement signInLinkNA;

	@FindBy(css = ".header-my-account")
	private WebElement signInToLink;

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
	    
    @FindBy(css = ".name_block .user_profile_name")
    private WebElement firstName;
   
   @FindBy(css = ".default_address:nth-child(2) > .address_delete_icons span")
   private WebElement clickEditdefaultAddress;
   
   @FindBy(id="editsubmit")
   private WebElement AEditSaveAddressButton;
   
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
   
   @FindBy(xpath = "//*[contains(@class,'panel')]/..//a[contains(@class,'add')]")
   private List<WebElement> addToBagWishlitOrFav;
   
   @FindBy(xpath = "//div[@class='swatch_container']//li")
   private List<WebElement> colorSwatch;
   
   @FindBy(xpath = "//div[@class='save-preference-btn-container']")
   private WebElement saveChanges;

   @FindBy(css = ".profile_address .add_new_container a")
   private WebElement addNewProfileAddress;
   
   @FindBy(css = ".default_address")
   private List<WebElement> verifySavedAddres;
 
	@FindBy(xpath = "//div[4]/div/a[2]")
	private WebElement Title;

	@FindBy(css = ".profile_payment .add_new_container a")
	private WebElement addNewProfileBillingAddress;

	@FindBy(css = ".profile_payment .View-all")
	private WebElement viewAllProfileBillingAddress;

	@FindBy(xpath = "//*[contains(@class,'product_panel')]")
	private List<WebElement> wishlist;
	
	@FindBy(xpath = "//div[9]/div/a[2]")
	private WebElement State;

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

	@FindBy(id = "manualAddSubmit")
	private WebElement SavedAddressline1;

	@FindBy(css = ".default_address:nth-child(2)")
	private WebElement NewAddressline1;
	
	@FindBy(css = ".default_address:nth-child(3) h2")
	private WebElement defaultShippingAddressLabel;
	
	@FindBy(css = ".default_address:nth-child(3)")
	private WebElement defaultNewAddressline1;

	@FindBy(css = ".delete")
	private WebElement clickDeletedefaultshippingAddress;

	@FindBy(xpath = "//button[2]/span")
	private WebElement confirmDeletedefaultshippingAddress;

	@FindBy(css = ".name_mail_container .profile_edit")
	private WebElement editProfileLink;

	@FindBy(id = "phoneNumber")
	private WebElement editPhoneNumber;

	@FindBy(css = ".fields_container #lastName")
	private WebElement editLastName;

	@FindBy(css = "#edit_profile_form .save_changes")
	private WebElement saveChangesButton;

	@FindBy(css = ".user_profile_name.capitalizeName")
	private WebElement accountFullName;

	@FindBy(css = ".my-account .header-my-account a")
	private WebElement myAccountsLink;

	@FindBy(css = ".change_password_link")
	private WebElement changePasswordink;

	@FindBy(css = ".forgot-password")
	private WebElement ForgotPasswordLink;

	@FindBy(css = "#login")
	private WebElement Email;

	@FindBy(css = "#resetByEmail")
	private WebElement SendMeAnEmailButton;

	@FindBy(css = ".email_sentmsg")
	private WebElement EmailSentMessageElement;

	@FindBy(css = ".reset_heading")
	private WebElement ForgotPasswordPage;

	@FindBy(css = "a.sbToggle")
	private WebElement SBToggleElement;

	@FindBy(css = "ul.sbOptions > li")
	private WebElement SBToggleOptionsList;

	@FindBy(id = "savePrefrence")
	private WebElement SavePreference;

	@FindBy(css = "a.sbSelector")
	private WebElement SBSelector;

	@FindBy(css = ".profile_nav > li:nth-child(5) > a")
	private WebElement favoritesTab;

	@FindBy(css = ".profile_nav > li:nth-child(4) > a")
	private WebElement favoritesTabGlobale;

	@FindBy(css = ".fav_list")
	private WebElement favproductdetails;

	@FindBy(css = ".remove_favorit")
	private WebElement favRemoveLink;

	@FindBy(css = ".link--clean-h2")
	private WebElement productdetails;

	@FindBy(css = ".fontlistA-D a ")
	private WebElement prodNameOnFav;

	@FindBy(css = ".payment_delete_icons a")
	private WebElement deletePayment;

	@FindBy(xpath = "(//button[@type='button']/span)[2]")
	private WebElement yesButton;

	@FindBy(xpath = "//ul[@class='individual_card']/following-sibling::label")
	private boolean isCardDeleted;

	@FindBy(css = ".orderdetails")
	private WebElement orderHistoryLink;

	@FindBy(css = ".orderHistoryHeading1")
	private WebElement orderNumberLabel;

	@FindBy(xpath = "//*[@class='orderHistoryHeading1']/span")
	private WebElement orderNumber;

	@FindBy(css = ".orderShipping .orderHistoryHeading5")
	private WebElement shippingAddressLabel;

	@FindBy(css = ".orderShipping .orderCardDetails")
	private WebElement shippingAddress;

	@FindBy(css = ".orderPayment .orderHistoryHeading5")
	private WebElement billingAddressLabel;

	@FindBy(css = ".orderPayment .orderCardDetails")
	private WebElement billingAddress;

	@FindBy(css = ".order_summary")
	private WebElement orderSummaryContainer;

	@FindBy(css = ".order_summary .orderHistoryHeading5")
	private WebElement orderSummaryLabel;
	
	@FindBy(css = ".order_header_one")
	private WebElement orderHistoryTitle;
	
	@FindBy(css = "#orderHistory")
	private WebElement orderHistoryTableContainer;
	
	@FindBy(xpath = "//*[@id= 'orderHistory']/tbody/tr")
	private List<WebElement> ordersList;
	
	@FindBy(css = ".acc_breadcrumb ul li a")
	private WebElement breadCrumbLink;

	@FindBy(css = ".profile_nav > li:nth-child(1) > a")
	private WebElement profileLink;
	
	@FindBy(css = "#signin_email_address")
	private WebElement enterusername;
	
	@FindBy(css = "#signin_password")
	private WebElement enterpassword;
	
	@FindBy(css = ".signin_submit.mrt.translate")
	private WebElement clickonsigninbtn;
	
	
	

	private final Logger log = LoggerFactory.getLogger(getClass());
	private PageUtils pageUtils;
	private MkMyAccountMenu mkMyAccountMenu;
	private MkEditProductLightbox mkEditProductLightbox;
	private JavascriptExecutor jsExecutor;
	private Context context;
	private WebDriver webDriver;
	private Actions actionBuilder;
	private Environment env;

	@Inject
	public MkMyAccountPage_Common(WebDriver webDriver, PageUtils pageUtils, MkMyAccountMenu mkMyAccountMenu,
			MkEditProductLightbox mkEditProductLightbox, Context context, Environment env) {

		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.mkMyAccountMenu = mkMyAccountMenu;
		this.mkEditProductLightbox = mkEditProductLightbox;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.context = context;
		this.webDriver = webDriver;
		this.actionBuilder = new Actions(webDriver);
		this.env = env;
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

	public boolean myAccountWelcomeIsPresent() {
		return mkMyAccountMenu.waitForMyAccountWelcome();
	}

	public boolean waitForMyAccountWelcome() {
		pageUtils.waitTillWebElementIsVisible(myAccountWelcome, 5);
		return pageUtils.waitForWebElement(myAccountWelcome);

	}

	public boolean waitForAddressBookTitle() {
		return pageUtils.waitForWebElement(myAccountAddressbookTitle);
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

	public void enterAddressFirstName(String Afname) {
		context.saveData("FirstName", Afname);
		pageUtils.waitForWebElement(AFirstName);
		AFirstName.clear();
		AFirstName.sendKeys(Afname);
	}

	public void enterAddressLastName(String Alname) {
		context.saveData("LastName", Alname);
		pageUtils.waitForWebElement(ALastName);
		ALastName.clear();
		ALastName.sendKeys(Alname);
	}

	public void enterAddressPhoneNumber(String Apnumber) {
		pageUtils.waitForWebElement(APhoneNumber);
		APhoneNumber.clear();
		APhoneNumber.sendKeys(Apnumber);
	}

	public void defaultShippingAddress() {
		jsExecutor.executeScript("arguments[0].click();", ADefaultShippingAddress);
		pageUtils.waitForPageToLoad();
	}
        
    public String verifyAddressSaved(){
        pageUtils.sleepSeconds(5, "2 sec wait for ajax load");
        pageUtils.waitForAjaxToComplete();
        String Addressline1 = NewAddressline1.getText();
        return Addressline1;
    }
	
	public String verifyDefaultShippingAddressSaved() {
		String Addressline1 = "";
			pageUtils.sleepSeconds(5, "2 sec wait for ajax load");
			pageUtils.waitForAjaxToComplete();
			Addressline1 = NewAddressline1.getText();

		return Addressline1;
	}
    
    public String verifyAddressFirstNameSaved(){
        pageUtils.sleepSeconds(5, "2 sec wait for ajax load");
        pageUtils.waitForAjaxToComplete();
        String Addressline1 = NewAddressline1.getText();
        return Addressline1;
    }
   
    public String verifyAddressLastNameSaved(){
        pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
        pageUtils.waitForAjaxToComplete();
        String Addressline1 = NewAddressline1.getText();
        return Addressline1;
    }
    
    public void clickEditdefaultShippingAddress() {
      	 pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
           pageUtils.waitForWebElement(clickEnterAddressManually);
           jsExecutor.executeScript("arguments[0].scrollIntoView();",clickEnterAddressManually);
           jsExecutor.executeScript("arguments[0].click();", clickEnterAddressManually);
               
      }
       
    
    public void clickEditProfile() {
        pageUtils.sleepSeconds(5, "Edit Profile clicked");
        pageUtils.waitTillWebElementIsClickable(editProfileLink);
        jsExecutor.executeScript("arguments[0].click();", editProfileLink);
        pageUtils.waitForPageToLoad();
        pageUtils.waitForAjaxToComplete();
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


	public void clickMyAccountLink() {
		jsExecutor.executeScript("arguments[0].click();", myAccountsLink);
		pageUtils.waitForPageToLoad();
	}

    public String getLastName() {
        pageUtils.scrollToElement(accountFullName);
    	pageUtils.webElementHighLighterMethod(accountFullName);
    	pageUtils.waitTillWebElementIsClickable(accountFullName);
        pageUtils.scrollToElement(accountFullName);

    	pageUtils.sleepSeconds(3, "Wait for First Name");
        String pname = accountFullName.getText();
        String[] arrOfStr = pname.split(" ", 2);
        System.out.println(arrOfStr[1]);
        return arrOfStr[1];
    }

	public String getName() {
		String pname = "";
		try {
			pageUtils.sleepSeconds(3, "Wait for First Name");
			pageUtils.webElementHighLighterMethod(firstName);
			pname = firstName.getText();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String[] arrOfStr = pname.split(" ", 2);

		return arrOfStr[0];
	}
    
    public void resetLastName(String rlname) {
        pageUtils.scrollToElement(editLastName);
        pageUtils.sleepSeconds(5, "Edit Profile loaded");
        editLastName.clear();
        editLastName.sendKeys(rlname);
        pageUtils.sleepSeconds(5, "Edit Profile loaded");
        context.writeOut("Last name reseted");
    }
	
	public void editPhoneNumber(String pnumber) {
		pageUtils.waitForWebElement(editPhoneNumber);
		editPhoneNumber.clear();
		editPhoneNumber.sendKeys(pnumber);
	}

	public void editLastName(String lname) {
		pageUtils.waitForWebElement(editLastName);
		pageUtils.scrollToElement(editLastName);
		pageUtils.waitForWebElement(editLastName);
		editLastName.clear();
		editLastName.sendKeys(lname);
	}

	public void clickSaveChangesButton() {
		jsExecutor.executeScript("arguments[0].click();", saveChangesButton);
		context.writeOut("Clicked on Save Link");
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(5, "Edit Profile loaded");
	}

	public void clickChangePassword() {
		pageUtils.sleepSeconds(5, "Change Password clicked");
		pageUtils.waitTillWebElementIsClickable(changePasswordink);
		jsExecutor.executeScript("arguments[0].click();", changePasswordink);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}

	public void ActionOnSignInLink() {

		if (env.getCountry().equalsIgnoreCase("US") || env.getCountry().equalsIgnoreCase("CA")) {

			pageUtils.waitForWebElement(signInLink);
			jsExecutor.executeScript("arguments[0].click();", signInLinkNA);
			pageUtils.waitForPageToLoad();
		} else {
			pageUtils.sleepSeconds(5, "Mousehover on Sign In link");
			pageUtils.waitTillWebElementIsClickable(signInToLink);
			actionBuilder.moveToElement(signInToLink).build().perform();
			pageUtils.sleepSeconds(5, "Mousehover on Sign In link");

		}
	}

	public void clickOnForgotPassword() {
		pageUtils.sleepSeconds(5, "Forgot Password clicked");
		pageUtils.waitTillWebElementIsClickable(ForgotPasswordLink);
		jsExecutor.executeScript("arguments[0].click();", ForgotPasswordLink);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}

	public void verifyForgotPasswordPageConfirmation() {
		pageUtils.sleepSeconds(5, "Waiting for forgot password page");
		pageUtils.verifyIfDisplayed(ForgotPasswordPage);

	}

	public void verifySelectedLanguage(String language) {
		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
		pageUtils.waitTillWebElementIsClickable(SBSelector);
		pageUtils.scrollToElement(SBSelector);
		if (language.equalsIgnoreCase("CountrySpecificPreferredLanguage")) {
			language = context.getSavedData("PreferredLanguage");
		}
		SBSelector.getText().equalsIgnoreCase(language);
	}

	public void SelectLanguage(String language) {

		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
		pageUtils.waitTillWebElementIsClickable(SBToggleElement);
		pageUtils.scrollToElement(SBToggleElement);
		jsExecutor.executeScript("arguments[0].click();", SBToggleElement);
		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
		pageUtils.waitTillWebElementIsClickable(SBToggleOptionsList);
		List<WebElement> elementList = webDriver.findElements(By.cssSelector("ul.sbOptions > li > a"));
		String locale = System.getProperty("locale");
		if (language.equalsIgnoreCase("CountrySpecificPreferredLanguage")) {
			if (locale.equalsIgnoreCase("en_FR")) {
				language = "French";
			} else if (locale.equalsIgnoreCase("fr_FR")) {
				language = "FranÃƒÂ¯Ã‚Â¿Ã‚Â½ais";
			} else if (locale.equalsIgnoreCase("en_ES")) {
				language = "Spanish";
			} else if (locale.equalsIgnoreCase("es_ES")) {
				language = "EspaÃƒÂ¯Ã‚Â¿Ã‚Â½ol";
			} else if (locale.equalsIgnoreCase("en_DE")) {
				language = "German";
			} else if (locale.equalsIgnoreCase("de_DE")) {
				language = "Deutsch";
			} else if (locale.equalsIgnoreCase("en_IT")) {
				language = "Italian";
			} else if (locale.equalsIgnoreCase("it_IT")) {
				language = "Italiano";
			} else if (locale.equalsIgnoreCase("en_CH")) {
				language = "German";
			} else if (locale.equalsIgnoreCase("fr_CH")) {
				language = "FranÃƒÂ¯Ã‚Â¿Ã‚Â½ais";
			} else {
				language = "English";
			}
		}
		for (WebElement element : elementList) {
			if (element.getText().equalsIgnoreCase(language)) {
				context.saveData("PreferredLanguage", language);
				jsExecutor.executeScript("arguments[0].click();", element);
				break;
			}
		}
		pageUtils.waitForAjaxToComplete();
		jsExecutor.executeScript("arguments[0].click();", SavePreference);
	}

	public void clickFavorites() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		jsExecutor.executeScript("arguments[0].click();", favoritesTab);
	}

	public void clickFavoritesGlobale() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		jsExecutor.executeScript("arguments[0].click();", favoritesTabGlobale);

	}

	public void getfavProductDetails() {
		Assert.assertSame(productdetails, favproductdetails);

	}

	public void favClickRemove() {
		try {
			pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
			pageUtils.waitForAjaxToComplete();
			pageUtils.waitForWebElement(favRemoveLink);
			jsExecutor.executeScript("arguments[0].click();", favRemoveLink);
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(1, "1 sec wait for ajax load");

		} catch (TestEnvironmentException e) {
			log.debug("Trying second time");

		}

	}

	public String productDetailOnFav() {
		return prodNameOnFav.getText();
	}

	public void selectDateOfCardExpiration() {
		jsExecutor.executeScript("arguments[0].click();", SBSelector);
	}

	public void deleteSavedPayment() {
		jsExecutor.executeScript("arguments[0].click();", deletePayment);
		pageUtils.sleepSeconds(2, "wait for page load");
		jsExecutor.executeScript("arguments[0].click();", yesButton);
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForPageToLoad();
	}

	public void verifyCardisDeleted() {
		pageUtils.waitForPageToLoad();
		Assert.assertFalse("Card is not delected", isCardDeleted);
	}

	public void clickOrderHistoryLink() {
		jsExecutor.executeScript("arguments[0].click();", orderHistoryLink);
		pageUtils.waitForPageToLoad();
	}

	public boolean isOrderNumberLabelDisplayed() {

		boolean flag = false;
		String contry = env.getCurrentLocale().getCountry();
		String locale = env.getLanguage();
		pageUtils.waitForPageToLoad();
		pageUtils.waitTillWebElementIsClickable(orderNumberLabel);
		String orderNumLabel = pageUtils.getTextTranslation("order_number_label");
		if (contry.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("fr")) {
			orderNumLabel = pageUtils.getTextTranslation("order_number_label-ca");
		}
		WebElement orderNum = webDriver.findElement(By.xpath("//h2[contains(text(),'" + orderNumLabel + "')]"));
		if (orderNum.isDisplayed()) {
			context.writeOut("Order Number label displayed");
			flag = true;
		} else {
			context.writeOut("Expected was: " + orderNumLabel + " and Found: " + orderNum);
		}
		return flag;

	}

	public boolean isShippingAddressLabelDisplayed() {

		boolean flag = false;
		String contry = env.getCurrentLocale().getCountry();
		String locale = env.getLanguage();
		pageUtils.waitForPageToLoad();
		pageUtils.waitTillWebElementIsVisible(shippingAddressLabel, 2);
		String shipAddLabel = pageUtils.getTextTranslation("shipping_address_label");
		if (contry.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("fr")) {
			shipAddLabel = pageUtils.getTextTranslation("shipping_address_label-ca");
		}
		WebElement shippingAdd = webDriver.findElement(By.xpath("//h3[contains(text(),'" + shipAddLabel + "')]"));
		if (shippingAdd.isDisplayed()) {
			context.writeOut("Shipping Address label displayed");
			flag = true;
		} else {
			context.writeOut("Expected was: " + shipAddLabel + " and Found: " + shippingAdd);
		}
		return flag;

	}

	public boolean isBillingAddressLabelDisplayed() {
		boolean flag = false;
		String contry = env.getCurrentLocale().getCountry();
		String locale = env.getLanguage();
		pageUtils.waitForPageToLoad();
		pageUtils.waitTillWebElementIsVisible(billingAddressLabel, 2);
		String billAddLabel = pageUtils.getTextTranslation("billing_address_label");
		if (contry.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("fr")) {
			billAddLabel = pageUtils.getTextTranslation("billing_address_label-ca");
		}
		WebElement billingAdd = webDriver.findElement(By.xpath("//h3[contains(text(),'" + billAddLabel + "')]"));
		if (billingAdd.isDisplayed()) {
			context.writeOut("Billing Address label displayed");
			flag = true;
		} else {
			context.writeOut("Expected was: " + billAddLabel + " and Found: " + billingAdd);
		}
		return flag;
	}

	public boolean isOrderSummaryContainerDisplayed() {
		boolean flag = false;
		String contry = env.getCurrentLocale().getCountry();
		String locale = env.getLanguage();
		pageUtils.waitForPageToLoad();
		Assert.assertTrue("Order Summary container is not displayed",
				pageUtils.verifyIfDisplayed(orderSummaryContainer));
		pageUtils.waitTillWebElementIsVisible(orderSummaryLabel, 2);
		String orderSumLabel = pageUtils.getTextTranslation("order_summary_label");
		if (contry.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("fr")) {
			orderSumLabel = pageUtils.getTextTranslation("order_summary_label-ca");
		}
		WebElement odrSummary = webDriver.findElement(By.xpath("//h3[contains(text(),'" + orderSumLabel + "')]"));
		if (odrSummary.isDisplayed()) {
			context.writeOut("Order Summary label displayed");
			flag = true;
		} else {
			context.writeOut("Expected was: " + orderSumLabel + " and Found: " + odrSummary);
		}
		return flag;
	}

	public String getAmountWithCurrency(double amount) {
		Locale currentLocale = env.getCurrentLocale();
		String language = env.getLanguage();
		String country = env.getCountry();
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);
		String amountWithCurrency = currencyFormatter.format(amount);
		if (language.equalsIgnoreCase("en") && country.equalsIgnoreCase("PT")) {
			currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("fr", "PT"));
			amountWithCurrency = currencyFormatter.format(amount);
		}
		context.writeOut(currentLocale.getDisplayName() + " : " + amountWithCurrency);
		return amountWithCurrency;
	}
	
	public String getCurrencySymbol() {
		Locale currentLocale = env.getCurrentLocale();
		Currency cur1 = Currency.getInstance(currentLocale);
		String symbol = cur1.getSymbol(currentLocale);
		context.writeOut(currentLocale.getDisplayName() + " : " + symbol);
		return symbol;
	}

	public String verifyOrderNumber() {
		jsExecutor.executeScript("arguments[0].click();", orderNumber);
		String orderNum = orderNumber.getText().trim().toLowerCase();
		context.writeOut(orderNum);
		pageUtils.sleepSeconds(2, "wait for page load");
		return orderNum;
	}

	public boolean verifyShippingAddress() {
		jsExecutor.executeScript("arguments[0].click();", shippingAddress);
		String shippingAdd = shippingAddress.getAttribute("innerText");
		shippingAdd = shippingAdd.split("\n")[1].toLowerCase().trim().replace("\n", "").replace(" ", "")
				.replace("\u00a0", "");
		context.writeOut(shippingAdd);
		pageUtils.sleepSeconds(2, "wait for page load");
		return context.getSavedData("shipAddressTextOnOrderConfirmation").contains(shippingAdd);
	}

	public boolean verifyBillingAddress() {
		jsExecutor.executeScript("arguments[0].click();", billingAddress);
		String billingAdd = billingAddress.getAttribute("innerText");
		billingAdd = billingAdd.split("\n")[1].toLowerCase().trim().replace("\n", "").replace(" ", "").replace("\u00a0",
				"");
		context.writeOut(billingAdd);
		pageUtils.sleepSeconds(2, "wait for page load");
		return context.getSavedData("billingAddressTextOnOrderConfirmation").contains(billingAdd);
	}
	
	private String getTranslation(String text) {
	    ResourceBundle titleResource = pageUtils.getResourceBundle(Resource.TEXT);
		return titleResource.getString(pageUtils.buildResourceLookupKey(text));
    }
	
	public void clickOnWishlistOrFavoritesLink(String text) {
    	String locator="//ul[@class='profile_nav']//a[text()='"+ getTranslation(text)+"']";
    	WebElement link = webDriver.findElement(By.xpath(locator));
    	pageUtils.waitForPageToLoad();
    	link.click();
		pageUtils.waitForPageToLoad();
	}
	
	public boolean isOrderHistoryTitleDisplayed() {
		boolean flag = false;
		pageUtils.waitForPageToLoad();
		pageUtils.waitTillWebElementIsClickable(orderHistoryTitle);
		String orderHistoryLabel = pageUtils.getTextTranslation("order_history_label");
		WebElement orderHistory = webDriver.findElement(By.xpath("//h1[contains(text(),'" + orderHistoryLabel + "')]"));
		if (orderHistory.isDisplayed()) {
			context.writeOut("Order History title displayed");
			flag = true;
		} else {
			context.writeOut("Expected was: " + orderHistoryLabel + " and Found: " + orderHistory);
		}
		return flag;

	}
	
	public boolean isDateDisplayedInOrderHistory() {
		boolean flag = false;
		pageUtils.waitForPageToLoad();
		pageUtils.waitTillWebElementIsClickable(orderHistoryTableContainer);
		for(int i=0; i<=ordersList.size()-1;i++) {
			WebElement orderRow = ordersList.get(i);
			List<WebElement> orderRowData = orderRow.findElements(By.tagName("td"));
			if(pageUtils.verifyIfDisplayed(orderRowData.get(0))) {
				context.writeOut(orderRowData.get(0).getText());
				flag = true;
			}
		}
		return flag;
	}

			public void clickAccountEditdefaultShippingAddress()
			{
				pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
				 pageUtils.waitForWebElement(clickEditdefaultAddress);
		           jsExecutor.executeScript("arguments[0].scrollIntoView();",clickEditdefaultAddress);
		           jsExecutor.executeScript("arguments[0].click();", clickEditdefaultAddress);
			}
			public void saveEditAddressbuttonclick()
			{
				jsExecutor.executeScript("arguments[0].click();", AEditSaveAddressButton);
	    		pageUtils.waitForPageToLoad();
			}
			
			
			public void enterAccountFnameLnameWithSPLchar() {
				String expectedFNameError = pageUtils.getTextTranslation("first-name-error");
				String expectedLNameError = pageUtils.getTextTranslation("second-name-error");
				context.writeOut("save Fname Error is: " + expectedFNameError);
				context.writeOut("save Lname Error is: " + expectedLNameError);
				
				if(env.getCurrentLocale().getCountry().equalsIgnoreCase("us") || env.getCurrentLocale().getCountry().equalsIgnoreCase("ca"))
				{
					clickAccountEditdefaultShippingAddress();
					pageUtils.sleepSeconds(3, "2 sec wait for ajax load");
					String str = "<>\\\"";
					for (int i = 0; i < str.length()-1; i++) {
						String name = "jon" + str.charAt(i);
						System.out.println(name);
						context.writeOut(name);
						AFirstName.sendKeys(name);
						ALastName.sendKeys(name);
						saveEditAddressbuttonclick();
						pageUtils.sleepSeconds(5, "wait for page load");
						String actFnameError = fNameError.getText();
						String actLnameerror = lNameError.getText();
						context.writeOut("Actual Fname Error is: " + actFnameError);
						context.writeOut("Actual Lname Error is: " + actLnameerror);

						if (env.getCurrentLocale().getCountry().equalsIgnoreCase("fr_ca")) {
							String expectedFNameError_CA = pageUtils.getTextTranslation("ca-first-name-error");
							String expectedLNameError_CA = pageUtils.getTextTranslation("ca-second-name-error");
							context.writeOut("save Fname Error is: " + expectedFNameError_CA);
							context.writeOut("save Lname Error is: " + expectedLNameError_CA);
							Assert.assertEquals("SPL character is accepted", expectedFNameError_CA, actFnameError);
							Assert.assertEquals("SPL character is accepted", expectedLNameError_CA, actLnameerror);
							AFirstName.clear();
							ALastName.clear();
						} else {

							Assert.assertEquals("SPL character is accepted", expectedFNameError, actFnameError);
							Assert.assertEquals("SPL character is accepted", expectedLNameError, actLnameerror);
							AFirstName.clear();
							ALastName.clear();
						}

					}

				}
				else if (env.getCurrentLocale().getCountry().equalsIgnoreCase("au")) {
					clickAccountEditdefaultShippingAddress();
					pageUtils.sleepSeconds(3, "2 sec wait for ajax load");
					String str = "<>";
					for (int i = 0; i < str.length(); i++) {

						AFirstName.clear();
						ALastName.clear();
						String name = "jon" + str.charAt(i);
						context.writeOut("name with spl char: " + name);
						AFirstName.sendKeys(name);
						ALastName.sendKeys(name);
						saveEditAddressbuttonclick();
						pageUtils.sleepSeconds(3, "wait for page load");
						String actFnameError = fNameError.getText();
						System.out.println(actFnameError);
						String actLnameerror = lNameError.getText();
						System.out.println(actLnameerror);
						Assert.assertEquals("SPL character is accepted", expectedFNameError, actFnameError);
						Assert.assertEquals("SPL character is accepted", expectedLNameError, actLnameerror);

					}
					String expectedNameError_AU = pageUtils.getTextTranslation("au_splcharacter_error");
					context.writeOut("Actual Fname Error is: " + expectedNameError_AU);
					String str1 = "<>\\\"";
					for (int j = 0; j < str1.length(); j++) {
						AFirstName.clear();
						ALastName.clear();
						String nameau = "jon" + str1.charAt(j);
						context.writeOut("name with spl char: " + nameau);
						AFirstName.sendKeys(nameau);
						ALastName.sendKeys(nameau);
						saveEditAddressbuttonclick();
						pageUtils.sleepSeconds(2, "wait for page load");
						String actFnameError_AU = fNameError.getText();
						context.writeOut("Actual Fname Error is: " + actFnameError_AU);
						Assert.assertEquals("SPL character is accepted", expectedNameError_AU, actFnameError_AU);
						String actLnameerror_AU = lNameError.getText();
						context.writeOut("Actual Lname Error is: " + actLnameerror_AU);
						Assert.assertEquals("SPL character is accepted", expectedNameError_AU, actLnameerror_AU);

					}

				} else {
					String str = "<>\\\"";
					for (int i = 0; i < str.length(); i++) {

						String name = "jon" + str.charAt(i);
						context.writeOut(name);
						AFirstName.sendKeys(name);
						ALastName.sendKeys(name);
						pageUtils.sleepSeconds(2, "wait for page load");
						String actFnameError = fNameError.getText();
						AFirstName.clear();
						pageUtils.sleepSeconds(2, "wait for page load");
						String actLnameerror = lNameError.getText();
						ALastName.clear();
						context.writeOut("Actual Fname Error is: " + actFnameError);
						context.writeOut("Actual Lname Error is: " + actLnameerror);
						Assert.assertEquals("SPL character is accepted", expectedFNameError, actFnameError);
						Assert.assertEquals("SPL character is accepted", expectedLNameError, actLnameerror);
					}
				}

	}

	public boolean isOrderNumberDisplayedInOrderHistory() {
		boolean flag = false;
		String contry = env.getCurrentLocale().getCountry();
		pageUtils.waitForPageToLoad();
		pageUtils.waitTillWebElementIsClickable(orderHistoryTableContainer);
		for(int i=0; i<=ordersList.size()-1;i++) {
			WebElement orderRow = ordersList.get(i);
			List<WebElement> orderRowData = orderRow.findElements(By.tagName("td"));
			if (contry.equalsIgnoreCase("ca") || contry.equalsIgnoreCase("us")) {
				if(pageUtils.verifyIfDisplayed(orderRowData.get(2)) && pageUtils.waitTillWebElementIsClickable(orderRowData.get(2))) {
					context.writeOut(orderRowData.get(2).getText());
					flag = true;
				}
			} else {
				if(pageUtils.verifyIfDisplayed(orderRowData.get(1))&& pageUtils.waitTillWebElementIsClickable(orderRowData.get(1))) {
					context.writeOut(orderRowData.get(1).getText());
					flag = true;
				}
			}
		}
		return flag;
	}

	
	public void addWishlitOrFavProductToCartFromProfile(int position) {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "Wait for page to load");
		jsExecutor.executeScript("arguments[0].click();", addToBagWishlitOrFav.get(position-1));
	}
	
	public boolean isOrderStatusDisplayedInOrderHistory() {
		boolean flag = false;
		String contry = env.getCurrentLocale().getCountry();
		pageUtils.waitForPageToLoad();
		pageUtils.waitTillWebElementIsClickable(orderHistoryTableContainer);
		for(int i=0; i<=ordersList.size()-1;i++) {
			WebElement orderRow = ordersList.get(i);
			List<WebElement> orderRowData = orderRow.findElements(By.tagName("td"));
			if (contry.equalsIgnoreCase("ca") || contry.equalsIgnoreCase("us")) {
				if(pageUtils.verifyIfDisplayed(orderRowData.get(3)) && pageUtils.waitTillWebElementIsClickable(orderRowData.get(3))) {
					context.writeOut(orderRowData.get(3).getText());
					flag = true;
				}
			} else {
				if(pageUtils.verifyIfDisplayed(orderRowData.get(2))&& pageUtils.waitTillWebElementIsClickable(orderRowData.get(2))) {
					context.writeOut(orderRowData.get(2).getText());
					flag = true;
				}
			}
		}
		return flag;
	}
	
	public void addWishlitOrFavProductToCartFromWishlist(int position) {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "Wait for page to load");
		jsExecutor.executeScript("arguments[0].click();", addToBagWishlitOrFav.get(position-1));
	}
	
	public int getWishlistOrFavProductsCount() {
		pageUtils.sleepSeconds(5, "wait for page to load");
		return addToBagWishlitOrFav.size();
	}
	
	public String changeColorInEditWishlistOrFavPopUp() {
		String color = null ;

		int colorSwatchSize = colorSwatch.size(); 
		if (colorSwatchSize!=1) {
			for (int j = 0; j < colorSwatchSize; j++) {
				if (!(colorSwatch.get(j).getAttribute("class").equals("selected"))) {
					pageUtils.sleepSeconds(2, "wait for color to select");
					colorSwatch.get(j).click();
					pageUtils.sleepSeconds(2, "wait for color to select");
					color = colorSwatch.get(j).getText().trim();
					break;
				}
			}
		}else {
			color = null;
		}		
		return color;
	}
	
	public void clickOnSaveChanges() {
		saveChanges.click();
	}
	
	public boolean isStoreDisplayedInOrderHistory() {
		boolean flag = false;
		String contry = env.getCurrentLocale().getCountry();
		pageUtils.waitForPageToLoad();
		pageUtils.waitTillWebElementIsClickable(orderHistoryTableContainer);
		for(int i=0; i<=ordersList.size()-1;i++) {
			WebElement orderRow = ordersList.get(i);
			List<WebElement> orderRowData = orderRow.findElements(By.tagName("td"));
			if (contry.equalsIgnoreCase("ca") || contry.equalsIgnoreCase("us")) {
				if(pageUtils.verifyIfDisplayed(orderRowData.get(1)) && pageUtils.waitTillWebElementIsClickable(orderRowData.get(1))) {
					context.writeOut(orderRowData.get(1).getText());
					flag = true;
				}
			} else {
				if(pageUtils.verifyIfDisplayed(orderRowData.get(3))&& pageUtils.waitTillWebElementIsClickable(orderRowData.get(3))) {
					context.writeOut(orderRowData.get(3).getText());
					flag = true;
				}
			}
		}
		return flag;

	}
	
	public boolean isOrderTotalDisplayedInOrderHistory() {
		boolean flag = false;
		pageUtils.waitForPageToLoad();
		pageUtils.waitTillWebElementIsClickable(orderHistoryTableContainer);
		for(int i=0; i<=ordersList.size()-1;i++) {
			WebElement orderRow = ordersList.get(i);
			List<WebElement> orderRowData = orderRow.findElements(By.tagName("td"));
			if(pageUtils.verifyIfDisplayed(orderRowData.get(orderRowData.size()-1))&& pageUtils.waitTillWebElementIsClickable(orderRowData.get(orderRowData.size()-1))) {
				context.writeOut(orderRowData.get(orderRowData.size()-1).getText());
				flag = true;
			}
		}
		return flag;

	}
	
	public boolean isOrderdetailsDisplayedInOrderHistory() {
		boolean flag = true;
		pageUtils.waitForPageToLoad();
		pageUtils.waitTillWebElementIsClickable(orderHistoryTableContainer);
		for(int i=0; i<=ordersList.size()-1;i++) {
			WebElement orderRow = ordersList.get(i);
			List<WebElement> orderRowData = orderRow.findElements(By.tagName("td"));
			for(int j=0; j<=orderRowData.size()-1;j++) {
				try {
					if(orderRowData.get(j).findElement(By.tagName("a")).isDisplayed()) {
						if(pageUtils.waitTillWebElementIsClickable(orderRowData.get(j))) {
							context.writeOut(orderRowData.get(j).getText());
						} else {
							flag =false;
							context.writeOut("-------------Order Number Validation failed: Not Clickable---------------");
							break;
						}
					} else {
						flag =false;
						context.writeOut("-------------Order Number Validation failed: Not displayed---------------");
						break;
					}
				} catch (Exception e) {
					if(j == orderRowData.size()-1) {
						String expected = orderRowData.get(j).getText();
						String symbol = getCurrencySymbol();
						if(expected.contains(symbol)) {
							context.writeOut(orderRowData.get(j).getText());
						} else {
							flag = false;
							context.writeOut("-------------Currency Validation failed---------------");
							break;
						}
					} else if(pageUtils.verifyIfDisplayed(orderRowData.get(j))) {
						context.writeOut(orderRowData.get(j).getText());
					} else {
						flag =false;
						context.writeOut("-------------"+orderRowData.get(j)+" Validation failed---------------");
						break;
					}
				}
			}
			if(!flag) {
				break;
			}
			context.writeOut("---------------------------------------------------");
		}
		context.writeOut("=============Order History Table Validation Completed================");
		return flag;
	}
	
	public void enterAddressFirstNameSpeci(String Afname) {
		pageUtils.waitForWebElement(AFirstName);
		AFirstName.clear();
		AFirstName.sendKeys(context.getSavedData("FirstName"));
	}

	public void enterAddressLastNameSpecial(String Alname) {
		pageUtils.waitForWebElement(ALastName);
		ALastName.clear();
		ALastName.sendKeys(context.getSavedData("LastName"));
	}
	
	public void saveFnameSpecialChar(String fname) {
		context.saveData("FirstName", pageUtils.getFirstNameSpecialChar(fname).trim());
	}
	
	public void saveLnameSpecialChar(String lname) {
		context.saveData("LastName", pageUtils.getFirstNameSpecialChar(lname).trim());
	}
	
	public void clickOnProfileLink() {
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "wait for page load");
		jsExecutor.executeScript("arguments[0].click();", profileLink);
	}

	public void clickAddNewShippingAddressOnProfilePage() {
		pageUtils.waitForPageToLoad();
		jsExecutor.executeScript("arguments[0].click();", addNewProfileAddress);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}

	public boolean verifySavedAddress() {
		boolean flag = false;
		int allSavedAddress = verifySavedAddres.size();
		System.out.println(allSavedAddress);
		if (allSavedAddress <= 3) {
			flag = true;
		}
		return flag;
	}

	public boolean isBreadCrumLinkDisplayed() {
		pageUtils.waitForAjaxToComplete();
		return pageUtils.verifyIfDisplayed(breadCrumbLink);
	}

	public void clickOnBreadCrumbLink() {
		
		jsExecutor.executeScript("arguments[0].click();", breadCrumbLink);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}

	public int getWishlistCount() {
		pageUtils.waitForPageToLoad();
		return wishlist.size();
	}

	public void clickAddNewBillingAddressOnProfilePage() {
		pageUtils.waitForPageToLoad();
		jsExecutor.executeScript("arguments[0].click();", addNewProfileBillingAddress);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}

	public void clickViewAllBillingAddressOnProfilePage() {
		pageUtils.waitForPageToLoad();
		jsExecutor.executeScript("arguments[0].click();", viewAllProfileBillingAddress);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}
	
	
	public void enterusername(String username) {
		enterusername.sendKeys(username);
	}
	
	public void enterpassword(String password) {
		enterpassword.sendKeys(password);
	}

	public void clickonsigninbtn() {
		clickonsigninbtn.click();
		
		
	}
}
