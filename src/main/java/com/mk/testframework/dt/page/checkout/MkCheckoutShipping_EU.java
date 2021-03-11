package com.mk.testframework.dt.page.checkout;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_Common;

/**
 * @author VThipperudrappa
 *
 */
public class MkCheckoutShipping_EU {

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

	@FindBy(css = ".shipping_deliever #email")
	private WebElement email;

	@FindBy(css = ".shipping_deliever .deliverAddrBtn")
	private WebElement shipToThisAddress;

	@FindBy(css = ".shipping_deliever .dropdown-menu li")
	private List<WebElement> titleDropDownMenu;

	@FindBy(css = "label[for='set-billingAddr']")
	private WebElement makeBillingAddressLink;

	@FindBy(css = "#shippingInfo_form .continue-pay-btn a")
	private WebElement continueToReviewAndPay;

	@FindBy(css = ".pay-and-review-button-font")
	private WebElement loggedInContinueToReviewAndPay;

	@FindBy(css = ".address-edit-link")
	private WebElement editShippingAddressLink;

	@FindBy(css = ".address-edit-collection-link")
	private WebElement loggedInEditShippingAddressLink;

	@FindBy(css = ".addnewaddress a")
	private WebElement addNewAddressLink;

	@FindBy(css = ".main_dropdown_new_ay")
	private WebElement languageDropdown;

	@FindBy(css = ".dropdown_menu_new_ay li")
	private List<WebElement> LanguageDropdownMenu;

	@FindBy(css = "#addressLookUpForm .new_ay_dropdown")
	private WebElement countryDropDown;

	@FindBy(css = "#addressLookUpForm .new_ay_dropdown .dropdown_menu_new_ay li")
	private List<WebElement> countryDropDownMenu;

	@FindBy(css = "#save-countryChange")
	private WebElement yesContinueBtn;

	@FindBy(css = ".language-select")
	private WebElement contineSelectedLanguage;

	@FindBy(xpath = "//input[@id='shippingAddress']")
	private WebElement keyShippingaddress;

	@FindBy(xpath = "(//ul[@class='searchResultList']/li[2])[1]")
	private WebElement searchResultList;

	@FindBy(how = How.ID, using = "gift-wrapping-checkbox")
	private WebElement expandGiftWrap;

	@FindBy(how = How.ID, using = "desktop-toggle-note-1")
	private WebElement selectGiftWrapCheckBox;

	@FindBy(css = ".add_note_txtarea")
	private List <WebElement> noteTextField;
	
	@FindBy(xpath = "//div[@id='desktop-toggle-addnote-2']/div/div/a")
	private WebElement addNoteLink;
	
	@FindBy(xpath = "//a[@class='link-primary row--push-10 js-add-note-link translate']")
	private List <WebElement> addNoteLink2;
	
	@FindBy(xpath = "//a[@aria-expanded='true' and @data-toggle='collapse']")
	private WebElement removeNoteLink;

	@FindBy(xpath = "//input[@id='shippingAddress']")
	private WebElement KeyShippingaddress;

	@FindBy(xpath = "//div[@id='addressLookUpForm']//select[@id='checkout_country']//option")
	private List<WebElement> changeCountryOption;

	@FindBy(css = "#cancel-countryChange")
	private WebElement noIWantToStayBtn;

	@FindBy(xpath = "(//select[@id='checkout_country'])[1]/option[@value='FI']")
	private WebElement fi;
	
	@FindBy(xpath = "//input[@id='first_name']/following-sibling :: ul")
	private WebElement fNameError;

	@FindBy(xpath = "//input[@id='last_name']/following-sibling :: ul")
	private WebElement lNameError;
	
	@FindBy(xpath = "(//input[@id='first_name'])[2]")
	private WebElement addNewShippingAddressFname;
	
	@FindBy(xpath = "(//input[@id='last_name'])[2]")
	private WebElement addNewShippingAddressLname;

	@FindBy(xpath= "//*[@class='btn btn-primary full-width continue-CIS-btn translate']")
	private WebElement clickOnContinueLoggedinForCC;

	@FindBy(xpath = "//select[@id='country']/following-sibling :: div/button/span")
	private WebElement countryName;

	@FindBy(css = "#set-billingAddr")
	private WebElement verifyCheckBoxMakeBilling;

	@FindBy(css = "label[for='first_name']")
	private WebElement verifyFnameLabel;

	@FindBy(css = "label[for='last_name']")
	private WebElement verifyLnameLabel;

	@FindBy(css = "label[for='phone']")
	private WebElement verifyPhoneNumberLabel;

	@FindBy(css = "label[for='title']")
	private WebElement verifyTitle;

	@FindBy(css = "label[for='email']")
	private WebElement verifyEmailLabel;

	@FindBy(xpath = "//p[@class='field-note field_new']")
	private WebElement verifyhtmlTextPhNo;

	@FindBy(xpath = "(//p[@class='field-note field_new'])[2]")
	private WebElement verifyhtmlTextEmail;

	@FindBy(css = "#mailing-list")
	private WebElement optInCheckboxemails;

	@FindBy(css = "label[for='mailing-list']")
	private WebElement verifyPromotionEmailsText;

	@FindBy(xpath = "(//input[@id='address1'])[2]")
	private WebElement address1AddNewShipping;

	@FindBy(xpath = "(//input[@id='city'])[2]")
	private WebElement cityAddNewShipping;

	@FindBy(xpath = "(//input[@id='postalCode'])[2]")
	private WebElement postCodeAddNewShipping;

	@FindBy(xpath = "(//*[@class='btn-group bootstrap-select new_ay_dropdown form-control'])[2]")
	private WebElement titleAddNewShipping;

	@FindBy(css = "#add-shipping-address .row .row .col-sm-8 .input-validation-container .inner li")
	private List<WebElement> titleDropDownMenuAddNewShipping;

	@FindBy(xpath = "(//input[@id='first_name'])[2]")
	private WebElement fNameAddNewShipping;

	@FindBy(xpath = "(//input[@id='last_name'])[2]")
	private WebElement lastNameAddNewShipping;

	@FindBy(xpath = "(//input[@id='phone'])[2]")
	private WebElement phoneAddNewShipping;

	@FindBy(xpath = "(//label[@for='first_name'])[2]")
	private WebElement fNameLabelAddNewShipping;

	@FindBy(xpath = "(//label[@for='last_name'])[2]")
	private WebElement lastNameLabelAddNewShipping;

	@FindBy(xpath = "(//label[@for='phone'])[2]")
	private WebElement phoneLabelAddNewShipping;

	@FindBy(xpath = "(//label[@for='selectTitle'])[2]")
	private WebElement titleLabelAddNewShipping;

	@FindBy(xpath = "//p[@class='field-note field-new']")
	private WebElement phoneHtmlTextAddNewShipping;

	@FindBy(css = "#set-default-shippingAddr")
	private WebElement makeDefaultShippingCheckBox;

	@FindBy(xpath = "(//select[@id='country'])[2]/following-sibling :: div/button/span")
	private WebElement countryDropDownAddNewShipping;

	@FindBy(css = ".addNewShipppingAddrBtn")
	private WebElement saveNewShippingAddressButton;

	@FindBy(css = ".first_name")
	private WebElement getSavedAddressName;

	@FindBy(xpath = "//*[@class=\"shipping-methodPanel active\"]/div/button/div/div/p")
	private WebElement shippingOption;

	@FindBy(xpath = "//*[@class=\"no-text-transform  shipping-address-font\"]")
	private WebElement shippingAddress;

	@FindBy(xpath = "//*[@class = \"guest_address_container\"]")
	private WebElement shippingAddressGuest;

	@FindBy(xpath = "//*[@class='main_dropdown_new_ay btn dropdown-toggle btn-default' and @data-id='saved-address-dropdown']")
	private WebElement savedAddressDropDown;

	@FindBy(xpath = "(//*[@class = 'dropdown-menu open dropdown_menu_new_ay'])[1]/ul/li")
	private List<WebElement> savedAddressDropDownMenu;

	@FindBy(xpath = "//*[@data-id ='gender-select']")
	private WebElement titleDropdownEdit;
	
	@FindBy(xpath= "//a[@class='btn btn-primary full-width guest-CIS-btn translate']")
	private WebElement clickOntContinueForCC;
	
	@FindBy(xpath = "//input[@name='giftWrap']")
	private List <WebElement> giftWrapCheckbox;
	
	@FindBy(css = "#shipToAddress_form .continue-pay-btn a")
	private WebElement clickOntContinueForCC_loogedIn;
	
	//@FindBy(xpath = "(//*[contains(@class,'continue-pay-btn')])[1]//a")
	//private WebElement continueButton;
	
	@FindBy(xpath = "//a[contains(@class,'CIS-btn')]")
	private WebElement continueCISButton;
	
	@FindBy(css = "#edit-shipping-address .editAddrSave")
	private WebElement saveEditedAddress;
	
	@FindBy(xpath = "(//ul[@class='searchResultList'])[1]/li")
	private List<WebElement> resultLists;

	@FindBy(xpath = "//button[@class='btn btn-primary full-width deliverAddrBtn translate']")
	private WebElement continueButton;

	@FindBy(css = ".shipping-address-font .first_name")
	private WebElement shippingAddressFirstName;
	
	@FindBy(css = ".guest_address_container .capitalizeName")
	private WebElement shippingAddressFirstNameGuest;
	
	@FindBy(css = ".updateOrderDetails .orderSummaryDetails .edit_shopping_bag")
	private WebElement EditSHoppingBagLink;
	
	@FindBy(css = ".updateOrderDetails .order-summary .shopping-bag-order-summary-totals li .text-right p span")
	private WebElement getOrderTotal;
	
	private PageUtils pageUtils;
	private TestData testData;
	private JavascriptExecutor jsExecutor;
	private Environment env;
	private Context context;
	private Actions actionBuilder;
	private MkMyAccountPage_Common MkMyAccountPage_Common;

	@Inject
	public MkCheckoutShipping_EU(WebDriver webDriver, PageUtils pageUtils, TestData testData, Environment env,
			Context context, MkMyAccountPage_Common MkMyAccountPage_Common) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.testData = testData;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.env = env;
		this.context = context;
		this.actionBuilder = new Actions(webDriver);
		this.MkMyAccountPage_Common =MkMyAccountPage_Common;
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
		try {
			postalCode.sendKeys(userPostalCode);
		} catch (Exception e) {
		}
	}

	public void selectTitle(int titleIndex) {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "wait for page load");
		titleDropdown.click();
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "wait for page load");
		titleDropDownMenu.get(titleIndex).click();
	}

	public void selectTitleEdit(int titleIndex) {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "wait for page load");
		titleDropdown.click();
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "wait for page load");
		titleDropDownMenu.get(titleIndex).click();
	}

	public void selectLanguage() {
		pageUtils.waitForPageToLoad();
		languageDropdown.click();
		pageUtils.waitForAjaxToComplete();
		try {
			for (int i = 0; i <= LanguageDropdownMenu.size(); i++) {
				if (LanguageDropdownMenu.get(i).getText().equalsIgnoreCase("English")) {
					LanguageDropdownMenu.get(i).click();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		contineSelectedLanguage.click();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(5, "to check selected country");
	}

	public void clickYesContinueBtn() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		jsExecutor.executeScript("arguments[0].click();", yesContinueBtn);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}

	public void fillFirstName(String userFirstName) {
		firstName.sendKeys(userFirstName);
	}

	public void fillLastName(String userLastName) {
		lastName.sendKeys(userLastName);
	}

	public void fillPhone(String userPhone) {
		phone.sendKeys(userPhone);
	}

	public boolean isEmailAddressFieldDisplayed() {
		return pageUtils.verifyIfDisplayed(email);
	}

	public void fillEmail(String userEmail) {
		email.sendKeys(userEmail);
	}

	public void clickEnterAddressManually() {
		try {
		pageUtils.waitTillWebElementIsClickable(enterAddressManuallyLink);
		jsExecutor.executeScript("arguments[0].click();", enterAddressManuallyLink);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(3, "1 sec wait for ajax load");
		} catch (Exception e) {
			enterAddressManuallyLink.click();
		}
	}

	public void fillUpRequiredFields() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "1 sec wait for ajax load");

		fillAddressLine1(testData.getUser().address.getStreetAddress1());

		try {
			fillAddressLine2(testData.getUser().address.getStreetAddress2());
		} catch (Exception e) {
		}

		fillCityLine(testData.getUser().address.getCity());

		try {
			fillPostalCode(testData.getUser().address.getPostalCode());
		} catch (Exception e) {
		}

		selectTitle(3);
		fillFirstName(testData.getUser().getFirstname());
		fillLastName(testData.getUser().getLastname());
		fillPhone(testData.getUser().getPhoneNumber());
		fillEmail(testData.getUser().getEmail());
	}

	public void fillUpRequiredFields(String fname, String lname) {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "1 sec wait for ajax load");

		fillAddressLine1(testData.getUser().address.getStreetAddress1());

		try {
			fillAddressLine2(testData.getUser().address.getStreetAddress2());
		} catch (Exception e) {
		}

		fillCityLine(testData.getUser().address.getCity());

		try {
			fillPostalCode(testData.getUser().address.getPostalCode());
		} catch (Exception e) {
		}

		selectTitle(3);
		fillFirstName(context.getSavedData("FirstName"));
		context.writeOut(context.getSavedData("FirstName"));
		//context.saveData("FirstName", fname);
		fillLastName(context.getSavedData("LastName"));
		context.writeOut(context.getSavedData("LastName"));
		//context.saveData("LastName", lname);
		fillPhone(testData.getUser().getPhoneNumber());
		fillEmail(testData.getUser().getEmail());
	}
	
	public void fillUpRequiredFieldsForLoggedInUser() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();

		fillAddressLine1(testData.getUser().address.getStreetAddress1());

		try {
			fillAddressLine2(testData.getUser().address.getStreetAddress2());
		} catch (Exception e) {
		}

		fillCityLine(testData.getUser().address.getCity());

		try {
			fillPostalCode(testData.getUser().address.getPostalCode());
		} catch (Exception e) {
		}

		selectTitle(3);
		fillFirstName(testData.getUser().getFirstname());
		fillLastName(testData.getUser().getLastname());
		fillPhone(testData.getUser().getPhoneNumber());
	}
	
	public void fillUpRequiredFieldsForLoggedInUser(String fname, String lname) {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();

		fillAddressLine1(testData.getUser().address.getStreetAddress1());

		try {
			fillAddressLine2(testData.getUser().address.getStreetAddress2());
		} catch (Exception e) {
		}

		fillCityLine(testData.getUser().address.getCity());

		try {
			fillPostalCode(testData.getUser().address.getPostalCode());
		} catch (Exception e) {
		}

		selectTitle(3);
		fillFirstName(fname);
		fillLastName(lname);
		fillPhone(testData.getUser().getPhoneNumber());
	}
	
	public void fillUpRequiredFieldsForLoggedInUserWithSplChar(String fname, String lname) {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();

		fillAddressLine1(testData.getUser().address.getStreetAddress1());

		try {
			fillAddressLine2(testData.getUser().address.getStreetAddress2());
		} catch (Exception e) {
		}

		fillCityLine(testData.getUser().address.getCity());

		try {
			fillPostalCode(testData.getUser().address.getPostalCode());
		} catch (Exception e) {
		}

		selectTitle(3);
		fillFirstName(context.getSavedData("FirstName"));
		fillLastName(context.getSavedData("LastName"));
		fillPhone(testData.getUser().getPhoneNumber());
	}
	
	public void fillUpRequiredFieldsLoggedin() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();

		fillAddressLine1(testData.getUser().address.getStreetAddress1());

		try {
			fillAddressLine2(testData.getUser().address.getStreetAddress2());
		} catch (Exception e) {
		}

		fillCityLine(testData.getUser().address.getCity());

		try {
			fillPostalCode(testData.getUser().address.getPostalCode());
		} catch (Exception e) {
		}

		selectTitle(3);
		fillFirstName(testData.getUser().getFirstname());
		fillLastName(testData.getUser().getLastname());
		fillPhone(testData.getUser().getPhoneNumber());
	}

	public void fillUpRequiredFieldsForEditAnonymous() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		address1.clear();
		fillAddressLine1(testData.getUser().address2.getStreetAddress1());

		try {
			address2.clear();
			fillAddressLine2(testData.getUser().address2.getStreetAddress2());
		} catch (Exception e) {
		}
		city.clear();
		fillCityLine(testData.getUser().address2.getCity());

		try {
			postalCode.clear();
			fillPostalCode(testData.getUser().address2.getPostalCode());
		} catch (Exception e) {
		}
	}

	public void fillUpRequiredFieldsForEditLoggedin() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		address1.clear();
		fillAddressLine1(testData.getUser().address2.getStreetAddress1());

		try {
			address2.clear();
			fillAddressLine2(testData.getUser().address2.getStreetAddress2());
		} catch (Exception e) {
		}
		city.clear();
		fillCityLine(testData.getUser().address2.getCity());

		try {
			postalCode.clear();
			fillPostalCode(testData.getUser().address2.getPostalCode());
		} catch (Exception e) {
		}
	}

	public void fillUpProfileDetails() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		selectTitle(3);
		fillFirstName(testData.getUser().getFirstname());
		fillLastName(testData.getUser().getLastname());
		fillPhone(testData.getUser().getPhoneNumber());
		fillEmail(testData.getUser().getEmail());
	}

	public void clickMakeBillingAddressLink() {
		pageUtils.waitTillWebElementIsClickable(makeBillingAddressLink);
		makeBillingAddressLink.click();
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "wait for page load");
	}

	public void clickShipToThisAddress() {
		shipToThisAddress.click();
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "wait for page load");
	}

	public void clickContinueToReviewAndPay() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "wait for page load");

		try {
			loggedInContinueToReviewAndPay.click();
		} catch (Exception e) {
			continueToReviewAndPay.click();
		}

		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "wait for page load");
	}

	public boolean isEditShippingAddressLinkDisplayed() {
		boolean linkDisplayed = false;
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "wait for page load");
		try {
			if (pageUtils.verifyIfDisplayed(loggedInEditShippingAddressLink)
					|| pageUtils.verifyIfDisplayed(editShippingAddressLink)) {
				linkDisplayed = true;
			}
		} catch (Exception e) {
			pageUtils.waitForPageToLoad();
			pageUtils.sleepSeconds(5, "wait for page load");
			pageUtils.refresh();
			if (pageUtils.verifyIfDisplayed(loggedInEditShippingAddressLink)
					|| pageUtils.verifyIfDisplayed(editShippingAddressLink)) {
				linkDisplayed = true;
			}
		}
		return linkDisplayed;
	}

	public void clickAddNewAddressLink() {
		addNewAddressLink.click();
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}

	public void enterKeyForSHippingAddress(String key) {
		pageUtils.sleepSeconds(2, "wait for page load");
		KeyShippingaddress.sendKeys(key);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "wait for page load");
	}

	public void enterpostcode() {
		try {
			enterKeyForSHippingAddress(testData.getUser().address2.getPostalCode());
		}catch(Exception e) {
			KeyShippingaddress.clear();
			enterKeyForSHippingAddress(testData.getUser().address.getStreetAddress1());
		}
	}

	public void selectAddressFromQAS() {
		try {
			pageUtils.waitForPageToLoad();
			pageUtils.sleepSeconds(3, "wait for page load");
			try{
				searchResultList.click();
			}catch(Exception e) {
				resultLists.get(0).click();
			}
		} catch (Exception e) {
			KeyShippingaddress.clear();
			enterKeyForSHippingAddress(testData.getUser().address.getStreetAddress1());
			resultLists.get(0).click();
		}
	}
	
	public boolean selectGiftWrap() {
		pageUtils.waitForPageToLoad();
		boolean flag = false;
		pageUtils.sleepSeconds(5, "wait for page load");
		jsExecutor.executeScript("arguments[0].click();", expandGiftWrap);
		pageUtils.sleepSeconds(2, "wait for page load");
		try {
			int checkBox = giftWrapCheckbox.size();
			System.out.println(checkBox);
			for (int i = 0; i < checkBox; i++) {
				if (giftWrapCheckbox.get(i).isEnabled()) {
					pageUtils.waitTillWebElementIsClickable(giftWrapCheckbox.get(i));
					giftWrapCheckbox.get(i).click();
					pageUtils.sleepSeconds(2, "wait for 2 second");
					context.writeOut("Gift wrap selected");
					flag = true;
				}
			}
		} catch (Exception e) {
		}
		return flag;
	}
	
	public boolean isAddNoteLinkDisplayed() {
		return pageUtils.verifyIfDisplayed(addNoteLink);
	}
	
	public void removeGiftWrap() {
		pageUtils.sleepSeconds(2, "wait for page load");
		jsExecutor.executeScript("arguments[0].click();", selectGiftWrapCheckBox);
		pageUtils.sleepSeconds(2, "wait for page load");

	}

	public void removeGiftWrapNote() {
		try {
			jsExecutor.executeScript("arguments[0].click();", removeNoteLink);
			pageUtils.sleepSeconds(5, "wait for page load");
		} catch (Exception e) {
			removeNoteLink.click();
			pageUtils.sleepSeconds(5, "wait for page load");
		}
	}

	public boolean addGiftWrapNote() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		boolean flag = false;
		try {

			int addNoteLink = addNoteLink2.size();
			System.out.println("add note link is: " + addNoteLink);
			pageUtils.sleepSeconds(2, "wait for page load");
			for (int i = 0; i < addNoteLink; i++) {
				addNoteLink2.get(i).click();
				context.writeOut("Clicked on add note link");
				pageUtils.sleepSeconds(2, "wait for page load");
			}
			pageUtils.sleepSeconds(5, "wait for page load");
			int textFeils = noteTextField.size();
			System.out.println(textFeils);
			for (int j = 0; j < textFeils; j++) {
				pageUtils.waitForAjaxToComplete();
				noteTextField.get(j).sendKeys("Hi,This is a Gift wrap");
				pageUtils.sleepSeconds(5, "wait for page load");
				context.writeOut("Entered Gift wrap note text");
				flag = true;
			}
		} catch (Exception e) {
			try {

				int addNoteLink = addNoteLink2.size();
				System.out.println("add note link is: " + addNoteLink);
				pageUtils.sleepSeconds(2, "wait for page load");
				for (int i = 0; i < addNoteLink; i++) {
					addNoteLink2.get(i).click();
					context.writeOut("Clicked on add note link");
					pageUtils.sleepSeconds(2, "wait for page load");
				}
				pageUtils.sleepSeconds(5, "wait for page load");
				int textFeils = noteTextField.size();
				System.out.println(textFeils);
				for (int j = 0; j < textFeils; j++) {
					pageUtils.waitForAjaxToComplete();
					noteTextField.get(j).sendKeys("Hi,This is a Gift wrap");
					pageUtils.sleepSeconds(5, "wait for page load");
					context.writeOut("Entered Gift wrap note text");
					flag = true;
				}
			} catch (Exception x) {
			}
		}
		return flag;
	}
	
	public boolean isRemoveNoteLinkDisplayed() {
		return pageUtils.verifyIfDisplayed(removeNoteLink);
	}

	public boolean isResultDisplayedFromQAS() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "wait for page load");
		return pageUtils.verifyIfDisplayed(searchResultList);

	}

	public void changeCountry() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		countryDropDown.click();
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(3, "wait for page load");
		countryDropDownMenu.get(0);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(5, "wait for page load");
	}

	public String getTranslatedCountry(String currLocale, String selectedCountry) {
		String countryTranslated = null;
		if (selectedCountry.equalsIgnoreCase("France (Maroc inclus)")) {
			selectedCountry = "France";
		}
		Locale outLocale = Locale.forLanguageTag("en_GB");
		Locale inLocale = Locale.forLanguageTag(currLocale);
		for (Locale l : Locale.getAvailableLocales()) {

			if (l.getDisplayCountry(inLocale).equals(selectedCountry)) {
				System.out.println(l.getDisplayCountry(outLocale));
				countryTranslated = l.getDisplayCountry(outLocale);
				break;
			}
		}
		return countryTranslated;
	}

	public void changeCountryToRandomCountry() {
		pageUtils.sleepSeconds(3, "to check selected country");
		pageUtils.waitTillWebElementIsClickable(countryDropDown);
		pageUtils.waitForPageToLoad();
		jsExecutor.executeScript("arguments[0].click();", countryDropDown);
		pageUtils.waitForPageToLoad();
		try {
			pageUtils.sleepSeconds(3, "to check selected country");
			int randnMumber = ThreadLocalRandom.current().nextInt(0, countryDropDownMenu.size());
			System.out.println("Country is: " + countryDropDownMenu.get(randnMumber).getText());
			String selectedCountryName = countryDropDownMenu.get(randnMumber).getText();
			String currentLocale = env.getCurrentLocale().toString();
			getTranslatedCountry(currentLocale, selectedCountryName);
			Locale l = new Locale("", currentLocale.substring(3));
			System.out.println(l.getDisplayCountry());
			countryDropDownMenu.get(randnMumber).click();
			;
			pageUtils.waitForPageToLoad();
			pageUtils.sleepSeconds(5, "to check selected country");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickNoIWantToStayBtn() {
		pageUtils.sleepSeconds(3, "to check selected country");
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		jsExecutor.executeScript("arguments[0].click();", noIWantToStayBtn);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(3, "to check selected country");
	}

	public boolean isNoIWantToStayDisplayed() {
		pageUtils.waitForPageToLoad();
		return pageUtils.verifyIfDisplayed(noIWantToStayBtn);
	}
	
	public void fillUpRequiredFieldsWithNewEmail() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();

		fillAddressLine1(testData.getUser().address.getStreetAddress1());

		try {
			fillAddressLine2(testData.getUser().address.getStreetAddress2());
		} catch (Exception e) {
		}

		fillCityLine(testData.getUser().address.getCity());

		try {
			fillPostalCode(testData.getUser().address.getPostalCode());
		} catch (Exception e) {
		}

		selectTitle(3);
		fillFirstName(testData.getUser().getFirstname());
		fillLastName(testData.getUser().getLastname());
		fillPhone(testData.getUser().getPhoneNumber());
		testData.createRandomEmail();
		fillEmail(testData.getRandomEmail());
	}
	
	public void enterCheckoutFnameLnameWithSPLchar() {
		String expectedFNameError = pageUtils.getTextTranslation("first-name-error");
		String expectedLNameError = pageUtils.getTextTranslation("second-name-error");
		context.writeOut("save Fname Error is: " + expectedFNameError);
		context.writeOut("save Lname Error is: " + expectedLNameError);

		String str = "<>\\\"";
		for (int i = 0; i < str.length(); i++) {

			String name = "jon" + str.charAt(i);
			System.out.println(name);
			addNewShippingAddressFname.sendKeys(name);
			addNewShippingAddressLname.sendKeys(name);
			String actFnameError = fNameError.getText();
			addNewShippingAddressFname.clear();
			String actLnameerrorv = lNameError.getText();
			addNewShippingAddressLname.clear();
			context.writeOut("Actual Fname Error is: " + actFnameError);
			context.writeOut("Actual Lname Error is: " + actLnameerrorv);
			Assert.assertEquals("SPL character is accepted", expectedFNameError, actFnameError);
			Assert.assertEquals("SPL character is accepted", expectedLNameError, actLnameerrorv);

		}

	}
	
	public void clickOnContinueButtonLoggedinForCC()
	{
		pageUtils.waitForPageToLoad();
		pageUtils.scrollToElement(clickOnContinueLoggedinForCC);
		jsExecutor.executeScript("arguments[0].click();", clickOnContinueLoggedinForCC);
		pageUtils.waitForPageToLoad();
	}
	
	public boolean verifAddressDetailsAreNotEmpty_Guest() {
		boolean flag = false;
		pageUtils.sleepSeconds(3, "wait");
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		String actCountryName = countryName.getText();
		
		if (address1.getAttribute("value").isEmpty() && city.getAttribute("value").isEmpty()
				&& postalCode.getAttribute("value").isEmpty() && actCountryName.length() <= 1) {
			flag = true;
			context.writeOut("feild is empty");

		}
		context.writeOut("Text feild is not empty");
		return flag;

	}
	
	public String iVerifySpecialCharecterInShippingAddress(String guest) {
		String firstName="";
		if(guest.equalsIgnoreCase("guest")) {
			pageUtils.sleepSeconds(5, "wait for page load");
			pageUtils.scrollToElement(shippingAddressFirstNameGuest);
			firstName=shippingAddressFirstNameGuest.getText();
		}else if (guest.equalsIgnoreCase("loggedIn")){
		pageUtils.sleepSeconds(5, "wait for page load");
		pageUtils.scrollToElement(shippingAddressFirstName);

		firstName=shippingAddressFirstName.getText();
		}
		return firstName;
	}


	public boolean verifyPostCodeSameAsAddressLookUp_Guest() {
		boolean flag = false;
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();

		String enteredPostCode = testData.getUser().address2.postalCode;
		String enteredPostCode2= testData.getUser().address.postalCode;
		context.writeOut(enteredPostCode);
		char postCode = enteredPostCode.charAt(3);
		System.out.println(postCode);
		String[] enteredPostCode1 = enteredPostCode.split(Character.toString(postCode));
		String expectedPostCode = enteredPostCode1[0];
		context.writeOut("Expected postcode is:  " + expectedPostCode);

		String actPostalCode1 = postalCode.getAttribute("value");
		context.writeOut(actPostalCode1);

		char actPostalCode2 = actPostalCode1.charAt(3);
		String[] actPostalCode = actPostalCode1.split(Character.toString(actPostalCode2));
		String actualPostalCode = actPostalCode[0];
		context.writeOut("Actual postcode from text feild is: " + actualPostalCode);

		if (expectedPostCode.equalsIgnoreCase(actualPostalCode) ||
				actPostalCode1.contains(enteredPostCode2) ||expectedPostCode.contains(actualPostalCode)) {
			flag = true;
		}

		return flag;

	}

	public boolean verifyMandatoryLabelsAreDisplayed_Guest() {
		pageUtils.sleepSeconds(3, "wait for page load");
		String expectedtitle = pageUtils.getTextTranslation("title");
		String expectedFname = pageUtils.getTextTranslation("first-name");
		String expectedLname = pageUtils.getTextTranslation("last-name");
		String expectedPhNo = pageUtils.getTextTranslation("phone-number");
		String expectedEmail = pageUtils.getTextTranslation("email");

		String defaultbillingCheckbox = pageUtils.getTextTranslation("default-billing-checkbox");
		String expectedPhNoText = pageUtils.getTextTranslation("phone-number-htmltext");
		String expectedemailText = pageUtils.getTextTranslation("email-htmltext");

		Assert.assertTrue(expectedtitle.equalsIgnoreCase(verifyTitle.getText()));
		pageUtils.sleepSeconds(2, "wait for page load");
		Assert.assertTrue(expectedFname.equalsIgnoreCase(verifyFnameLabel.getText()));
		Assert.assertTrue(expectedLname.equalsIgnoreCase(verifyLnameLabel.getText()));
		pageUtils.sleepSeconds(2, "wait for page load");
		Assert.assertTrue(expectedPhNo.equalsIgnoreCase(verifyPhoneNumberLabel.getText()));
		Assert.assertTrue(expectedEmail.equalsIgnoreCase(verifyEmailLabel.getText()));
		pageUtils.sleepSeconds(2, "wait for page load");
		Assert.assertTrue(defaultbillingCheckbox.equalsIgnoreCase(makeBillingAddressLink.getText()));
		pageUtils.sleepSeconds(2, "wait for page load");
		Assert.assertTrue(expectedPhNoText.equalsIgnoreCase(verifyhtmlTextPhNo.getText()));
		pageUtils.sleepSeconds(2, "wait for page load");
		Assert.assertTrue(expectedemailText.equalsIgnoreCase(verifyhtmlTextEmail.getText()));
		return true;
	}

	public boolean verifyDisplayOfFormFeilds_Guest() {
		Assert.assertTrue(pageUtils.verifyIfDisplayed(titleDropdown));
		Assert.assertTrue(pageUtils.verifyIfDisplayed(firstName));
		Assert.assertTrue(pageUtils.verifyIfDisplayed(lastName));
		Assert.assertTrue(pageUtils.verifyIfDisplayed(phone));
		Assert.assertTrue(pageUtils.verifyIfDisplayed(email));
		Assert.assertTrue(pageUtils.verifyIfDisplayed(verifyCheckBoxMakeBilling));
		Assert.assertTrue(pageUtils.verifyIfDisplayed(optInCheckboxemails));
		Assert.assertTrue(pageUtils.verifyIfDisplayed(verifyPromotionEmailsText));

		return true;
	}

	public boolean selectedShippingMethod() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "waiting for shipping option to load");
		if(pageUtils.verifyIfDisplayed(shippingOption)) {
			jsExecutor.executeScript("arguments[0].click();", shippingOption);
			String shippingOptionText = shippingOption.getText().trim().replaceAll("[^a-zA-Z]", "");
			context.saveData("shippingOptionText", shippingOptionText);
			context.writeOut(shippingOptionText);
			return true;
		}
		return false;
	}

	public boolean selectedShippingAddress() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "waiting for shipping option to load");
		if(pageUtils.verifyIfDisplayed(shippingAddress)) {
			jsExecutor.executeScript("arguments[0].click();", shippingAddress);
			String shippingAddressText = shippingAddress.getText();
			context.saveData("shippingAddressText", shippingAddressText);
			context.writeOut(shippingAddressText);
			return true;
		}
		return false;
	}

	public boolean selectedShippingAddressGuestUser() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "waiting for shipping option to load");
		if (pageUtils.verifyIfDisplayed(shippingAddressGuest)) {
			jsExecutor.executeScript("arguments[0].click();", shippingAddressGuest);
			String shippingAddressText = shippingAddressGuest.getText();
			context.saveData("shippingAddressText", shippingAddressText);
			context.writeOut(shippingAddressText);
			return true;
		}
		return false;
	}
	
	public void clickOnContinueButtonForCC()
	{
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		jsExecutor.executeScript("arguments[0].click();", clickOntContinueForCC);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}
	
	public void clickOnContinueButtonForCC_loggedInUser()
	{
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForPageToLoad();
		jsExecutor.executeScript("arguments[0].click();", clickOntContinueForCC_loogedIn);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}
	
	public void clickOnContinueButton() {
		pageUtils.sleepSeconds(2, "Wait for button to display");
		continueButton.click();
		pageUtils.sleepSeconds(2, "Wait for page to load");
	}
	
	public void clickOnContinueCISButton() {
		pageUtils.sleepSeconds(2, "Wait for button to display");
		continueCISButton.click();
		pageUtils.sleepSeconds(5, "Wait for page to load");
	}
	

	public boolean verifyAddressFieldsMaxLength_Guest() {
		boolean flag = false;
		try {
			fillAddressLine1("qwertyui opasdf ghjklzxcvbnmlkjhgfdsaqwert");
			String userAddress = address1.getAttribute("value");
			context.writeOut("Entered Text is " + userAddress);

			if (userAddress.length() == 35) {
				flag = true;
				context.writeOut("AddressFieldsMaxLength is not more than 35 character");
			}
		} catch (Exception e) {

		}
		return flag;
	}

	public boolean verifAddressDetailsAreNotEmpty_Registered() {
		boolean flag = false;
		pageUtils.sleepSeconds(3, "wait");
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		String actCountryName = countryDropDownAddNewShipping.getText();
		if (address1.getAttribute("value").isEmpty() && city.getAttribute("value").isEmpty()
				&& postCodeAddNewShipping.getAttribute("value").isEmpty() && actCountryName.length() <= 1) {
			flag = true;
			context.writeOut("feild is empty");

		}
		context.writeOut("Text feild is not empty");
		return flag;

	}

	public boolean verifyPostCodeSameAsAddressLookUp_Registered() {
		boolean flag = false;
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();

		String enteredPostCode = testData.getUser().address2.postalCode;
		String enteredPostCode2 = testData.getUser().address2.postalCode;
		System.out.println(enteredPostCode);
		char postCode = enteredPostCode.charAt(3);
		System.out.println(postCode);
		String[] enteredPostCode1 = enteredPostCode.split(Character.toString(postCode));
		String expectedPostCode = enteredPostCode1[0];
		context.writeOut("Expected postcode is:  " + expectedPostCode);

		String actPostalCode1 = postCodeAddNewShipping.getAttribute("value");
		System.out.println(actPostalCode1);
		char actPostalCode2 = actPostalCode1.charAt(3);
		String[] actPostalCode = actPostalCode1.split(Character.toString(actPostalCode2));
		String actualPostalCode = actPostalCode[0];
		context.writeOut("Actual postcode from text feild is: " + actualPostalCode);

		if (expectedPostCode.equalsIgnoreCase(actualPostalCode)||testData.getUser().address.postalCode.contains(actPostalCode1)) {
			flag = true;
		}

		return flag;
	}

	public boolean verifyMandatoryLabelsAreDisplayed_Registered() {
		pageUtils.sleepSeconds(3, "wait for page load");
		String expectedFname = pageUtils.getTextTranslation("first-name");
		String expectedLname = pageUtils.getTextTranslation("last-name");
		String expectedPhNo = pageUtils.getTextTranslation("phone-number");
		String expectedPhNoText = pageUtils.getTextTranslation("phone-number-htmltext");

		Assert.assertTrue(expectedFname.equalsIgnoreCase(fNameLabelAddNewShipping.getText()));
		pageUtils.sleepSeconds(2, "wait for page load");
		Assert.assertTrue(expectedLname.equalsIgnoreCase(lastNameLabelAddNewShipping.getText()));
		pageUtils.sleepSeconds(2, "wait for page load");
		Assert.assertTrue(expectedPhNo.equalsIgnoreCase(phoneLabelAddNewShipping.getText()));
		Assert.assertTrue(expectedPhNoText.equalsIgnoreCase(phoneHtmlTextAddNewShipping.getText()));

		return true;
	}

	public boolean verifyDisplayOfFormFeilds_Registered() {
		Assert.assertTrue(pageUtils.verifyIfDisplayed(titleAddNewShipping));
		Assert.assertTrue(pageUtils.verifyIfDisplayed(fNameAddNewShipping));
		Assert.assertTrue(pageUtils.verifyIfDisplayed(lastNameAddNewShipping));
		Assert.assertTrue(pageUtils.verifyIfDisplayed(phoneAddNewShipping));
		Assert.assertTrue(pageUtils.verifyIfDisplayed(makeDefaultShippingCheckBox));
		pageUtils.sleepSeconds(2, "wait for page load");
		Assert.assertTrue(pageUtils.verifyIfDisplayed(optInCheckboxemails));
		Assert.assertTrue(pageUtils.verifyIfDisplayed(verifyPromotionEmailsText));

		return true;
	}

	public boolean verifyAddressFieldsMaxLength_Registered() {
		boolean flag = false;
		try {
			address1AddNewShipping.sendKeys("qwertyui opasdf ghjklzxcvbnmlkjhgfdsaqwert");
			String userAddress = address1AddNewShipping.getAttribute("value");
			context.writeOut("Entered Text is " + userAddress);

			if (userAddress.length() == 35) {
				flag = true;
				context.writeOut("AddressFieldsMaxLength is not more than 35 character");
			}
		} catch (Exception e) {

		}
		return flag;
	}
	
	public void clickOnEDitShoppingBagLink()
	{
		pageUtils.waitForPageToLoad();
	pageUtils.waitForAjaxToComplete();
	pageUtils.sleepSeconds(1, "wait for page load");
	EditSHoppingBagLink.click();
	pageUtils.waitForPageToLoad();
	pageUtils.waitForAjaxToComplete();
	}
	public String getOrderTotalAmount()
	{
		String getTotalAmount1 = getOrderTotal.getText();
		String getTotalAmount = getTotalAmount1.trim().replaceAll("[^0-9]", "");
		context.saveData("OrderTotalBeforeEditCArt", getTotalAmount);
		return getTotalAmount;
	}

	public void enterAddressInQASfield() {
		enterKeyForSHippingAddress(testData.getUser().address2.getStreetAddress1());
	}

	public boolean verifyEnterAddressManullayLink() {
		pageUtils.waitForPageToLoad();
		return pageUtils.verifyIfDisplayed(enterAddressManuallyLink);
	}

	public void selectTiltleForAddNewShippingAddress(int titleIndex) {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "wait for page load");
		titleAddNewShipping.click();
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "wait for page load");
		titleDropDownMenuAddNewShipping.get(titleIndex).click();
	}

	public void fillUpProfileDetailsForAddNewShippingAddress() {
		pageUtils.sleepSeconds(3, "wait for page load");
		selectTiltleForAddNewShippingAddress(3);
		pageUtils.sleepSeconds(2, "wait for page load");
		fNameAddNewShipping.sendKeys("AutoTest");
		lastNameAddNewShipping.sendKeys(testData.getUser().getLastname());
		pageUtils.sleepSeconds(2, "wait for page load");
		phoneAddNewShipping.sendKeys(testData.getUser().getPhoneNumber());
		makeDefaultShippingCheckBox.click();
		saveNewShippingAddressButton.click();
	}

	public String verifyNewShippingAddressAdded() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		String savedAddressName = getSavedAddressName.getText();
		System.out.println("Saved name is " + savedAddressName);
		context.saveData(savedAddressName, "AddedAddress");
		return savedAddressName;

	}

	public void selectShippingAddressFromDropDown() {
		pageUtils.sleepSeconds(3, "to check selected Address");
		pageUtils.waitTillWebElementIsClickable(savedAddressDropDown);
		pageUtils.waitForPageToLoad();
		jsExecutor.executeScript("arguments[0].click();", savedAddressDropDown);
		pageUtils.waitForPageToLoad();
		try {
			pageUtils.sleepSeconds(3, "to check selected Address");
			int randnMumber = ThreadLocalRandom.current().nextInt(0, savedAddressDropDownMenu.size());
			context.writeOut(savedAddressDropDownMenu.get(randnMumber).getText());
			savedAddressDropDownMenu.get(randnMumber).click();
			pageUtils.waitForPageToLoad();
			pageUtils.sleepSeconds(5, "to check selected Address");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickSaveAddressAfterEdit() {
		saveEditedAddress.click();
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "wait for page load");
	}

	public void clickEditShippingAddressLink() {

		if (pageUtils.verifyIfDisplayed(loggedInEditShippingAddressLink)) {
			jsExecutor.executeScript("arguments[0].click();", loggedInEditShippingAddressLink);
		} else if (pageUtils.verifyIfDisplayed(editShippingAddressLink)) {
			jsExecutor.executeScript("arguments[0].click();", editShippingAddressLink);
		}
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();

	}
	
	public void shipingChargeFromSelectedShippingMethod() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "waiting for shipping method to display");
		jsExecutor.executeScript("arguments[0].click();", shippingOption);
		String shippingChargeText = shippingOption.getText().toString().trim().replaceAll("[^\\d\\.\\,\\s]+","").trim().replace(",", "");
		if(shippingChargeText.isBlank()) {
			shippingChargeText = MkMyAccountPage_Common.getAmountWithCurrency(0).trim().replaceAll("[^\\d\\.\\,\\s]+","").trim().replace(",", "");
		}
		context.saveData("shippingChargeText", shippingChargeText);
		context.writeOut(shippingChargeText);
	}

}
