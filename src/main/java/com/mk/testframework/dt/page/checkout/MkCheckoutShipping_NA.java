package com.mk.testframework.dt.page.checkout;

import java.util.List;

import org.junit.Assert;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.util.PageUtils;

import io.cucumber.datatable.DataTable;

/**
 * @author VThipperudrappa
 *
 */
public class MkCheckoutShipping_NA {

	@FindBy(css = "button[data-id='gender-select']")
	private WebElement genderSelect;

	@FindBy(css = "#first_name")
	private WebElement firstName;

	@FindBy(css = "#last_name")
	private WebElement lastName;

	@FindBy(css = "#addr-1")
	private WebElement address1;

	@FindBy(css = "#addr-2")
	private WebElement address2;

	@FindBy(css = "#zip-code")
	private WebElement postalCode;

	@FindBy(css = "#locality")
	private WebElement city;

	@FindBy(css = "#shipping-form #state")
	private WebElement state;

	@FindBy(css = "#shipping-form [data-id='state']")
	private WebElement stateAlt;

	@FindBy(css = "#shipping-form .form-control.open .dropdown-menu.open")
	private WebElement stateDropdown;

	@FindBy(css = "#shipping-form .form-control.open .dropdown-menu.open .dropdown-menu.inner li a")
	private List<WebElement> stateOptions;

	@FindBy(css = "[data-id='saved-address-dropdown'] span")
	private WebElement savedAddressesDropdown;

	@FindBy(css = "#saved-addresses .address-display .no-text-transform")
	private WebElement selectedAddress;

	@FindBy(css = ".address-display .addr_1")
	private WebElement selectedAddressAddressLine1;

	@FindBy(css = "#saved-addresses .form-control.open .dropdown-menu.open .dropdown-menu.inner li a")
	private List<WebElement> savedAddressesOptions;

	@FindBy(css = "#shipping-phone")
	private WebElement phone;

	@FindBy(id = "shippingFormSubmit")
	private WebElement continueToPayment;

	@FindBy(xpath = "//*[contains(@class,'wizard-step-link')][1]")
	private WebElement editShippingAddressLink;

	@FindBy(how = How.ID, using = "gift-wrapping-checkbox")
	private WebElement expandGiftWrap;

	@FindBy(how = How.ID, using = "desktop-toggle-note-1")
	private WebElement selectGiftWrapCheckBox;

	@FindBy(how = How.ID, using = "gift-text-1")
	private WebElement noteTextFeild;

	@FindBy(xpath = "//div[@id='desktop-toggle-addnote-2']/div/div/a")
	private WebElement addNoteLink;

	@FindBy(xpath = "//div[@class='col-md-12 wrapMsgCount' and @style='display: block;']")
	private WebElement isRemoveNoteLinkDisplayed;

	@FindBy(xpath = "//label[@class='pull-right clearNote']")
	private WebElement removeNoteLink;

	@FindBy(xpath = "(//span[contains(text(),'140')])[2]")
	private WebElement verifyUserEnterText;

	@FindBy(xpath = "//div[@class='col-md-12 wrapMsgCount' and @style='display: none;']")
	public WebElement removeNoteLinkNotDisplayed;

	@FindBy(css = ".shipping-completed .capitalize")
	private WebElement shippingAddress;
	
	@FindBy(css = "	#saved-address-dropdown")
	private WebElement selectSavedShippingAddress;

	@FindBy(css = ".shopping-bag-box a")
	private WebElement expandShoppingBagItemSection;
	
	@FindBy(css = ".shopping-bag-box ul li a")
	private WebElement editShoppingBagLink;
	
	@FindBy(css = "#order-summary ul li p span")
	private WebElement getItemSubTotal;
	
	@FindBy(css = ".address-add-collection-link")
	private WebElement addNewShippingAddressLink;
	
	@FindBy(xpath = "//input[@id='first_name']/following-sibling :: ul")
	private WebElement fNameError;

	@FindBy(xpath = "//input[@id='last_name']/following-sibling :: ul")
	private WebElement lNameError;
	
	
	@FindBy(css = "#saved-addresses .address-display")
	private WebElement shippingAddressMobile;

	@FindBy(css = ".address-edit-collection-link")
	private WebElement editThisAddressLinkShipping;
	
	@FindBy(xpath = "//*[@name='shipping' and @checked='true']/following-sibling::label")
	private WebElement slectedShippingOption;
	
	@FindBy(css = "#shippingMethodsContainer")
	private List<WebElement> shippingMethodContainer;

	@FindBy(xpath = "//div[@class='padded-content shipping-completed']/address")
	private WebElement shippingAddressSection;
	
	@FindBy(css =".first_name")
	private WebElement shippingFirstName;
	
	private PageUtils pageUtils;
	private TestData testData;
	private JavascriptExecutor jsExecutor;
	private Context context;
	private WebDriver webDriver;
	private Environment env;

	@Inject
	public MkCheckoutShipping_NA(WebDriver webDriver, PageUtils pageUtils, TestData testData, Context context, Environment env) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.testData = testData;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.context = context;
		this.webDriver = webDriver;
		this.env = env;
	}

	public void fillFirstName(String userFirstName) {
		firstName.sendKeys(userFirstName);
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

	public void selectStateOrProvince(String stateOrProvince) {
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "Wait ajax to complete");

		WebElement stateElement = state;
		pageUtils.scrollToElement(stateElement);
		pageUtils.waitTillWebElementIsClickable(stateElement);
		stateElement.click();
		stateElement.click();
		stateElement.sendKeys(stateOrProvince);

		pageUtils.waitForAjaxToComplete();
	}

	public void fillPhone(String userPhone) {
		phone.sendKeys(userPhone);
	}

	public void selectSavedAddress() {
		if (selectedAddressAddressLine1.getAttribute("innerText").length() == 0) {
			pageUtils.waitForWebElement(savedAddressesDropdown);
			savedAddressesDropdown.click();
			pageUtils.waitForAjaxToComplete();
			clickSavedAddressOption(1);
		}
	}

	public void clickSavedAddressOption(int index) {
		jsExecutor.executeScript("arguments[0].click();", savedAddressesOptions.get(index));
		pageUtils.waitForAjaxToComplete();
	}

	public void selectSavedShippingAddress() {
		if (selectedAddressAddressLine1.getAttribute("innerText").length() == 0) {
			pageUtils.waitForAjaxToComplete();
			clickSavedShippingAddressOption(1);
		}
	}

	public void clickSavedShippingAddressOption(int index) {
		Select sel = new Select(selectSavedShippingAddress);
		sel.selectByIndex(index);
		pageUtils.waitForAjaxToComplete();
	}

	public void fillUpRequiredFields() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();

		selectStateOrProvince(testData.getUser().address.getState());
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

	private List<WebElement> getStateOptions() {
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "for dropdown to load");
		return stateOptions;
	}

	public void selectUserStateOrProvinceOption(String userState) {
		List<WebElement> stateOptions = getStateOptions();

		boolean stateFound = false;
		int i = 0;
		while (!stateFound && i < stateOptions.size()) {
			stateAlt.sendKeys(Keys.ARROW_DOWN);

			if (stateOptions.get(i).getAttribute("aria-label").toLowerCase().equals(userState.toLowerCase())) {
				stateOptions.get(i).click();
				pageUtils.waitForAjaxToComplete();
				pageUtils.waitForPageToLoad();
				stateFound = true;
				break;
			} else {
				i++;
			}
		}
	}

	public boolean isEditShippingAddressLinkDisplayed() {
		pageUtils.waitForWebElement(editShippingAddressLink);
		return pageUtils.verifyIfDisplayed(editShippingAddressLink);
	}

	public void clickContinueToPayment() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(5, "wait for page load");
		pageUtils.scrollToElement(continueToPayment);
		jsExecutor.executeScript("arguments[0].click();", continueToPayment);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}
	
	public void selectGiftWrap() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "wait for page load");
		pageUtils.scrollToElement(expandGiftWrap);
		jsExecutor.executeScript("arguments[0].click();", expandGiftWrap);
		pageUtils.sleepSeconds(2, "wait for page load");
		jsExecutor.executeScript("arguments[0].click();", selectGiftWrapCheckBox);
	}

	public void removeGiftWrap() {
		pageUtils.sleepSeconds(2, "wait for page load");
		jsExecutor.executeScript("arguments[0].click();", expandGiftWrap);
		jsExecutor.executeScript("arguments[0].click();", selectGiftWrapCheckBox);
		pageUtils.sleepSeconds(2, "wait for page load");
	}

	public void enterTextInAddNote(String note) {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForWebElement(noteTextFeild);
		noteTextFeild.sendKeys(note);
		System.out.println(note);
	}

	public void addGiftWrapNote() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "wait for page load");
		noteTextFeild.sendKeys("Hi,This is a Gift wrap");
		System.out.println("I entered text");
		pageUtils.sleepSeconds(5, "wait for page load");
	}

	public boolean isRemoveNoteLinkDisplayed() {
		return pageUtils.verifyIfDisplayed(isRemoveNoteLinkDisplayed);
	}

	public boolean verifyUserEnterTextNote() {
		return pageUtils.verifyIfDisplayed(verifyUserEnterText);
	}

	public void removeGiftWrapNote() {
		jsExecutor.executeScript("arguments[0].click();", removeNoteLink);
		pageUtils.sleepSeconds(5, "wait for page load");
	}
	
	public void clickAddNewAddressLink(){
		pageUtils.sleepSeconds(5, "wait for page load");
		addNewShippingAddressLink.click();
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}
		
	public void enterCheckoutFnameLnameWithSPLchar() {
		String expectedFNameError = pageUtils.getTextTranslation("first-name-error");
		String expectedLNameError = pageUtils.getTextTranslation("second-name-error");
		context.writeOut("save Fname Error is: " + expectedFNameError);
		context.writeOut("save Lname Error is: " + expectedLNameError);

		String str = "<>Ã�Å¾Ã�Â´Ã�ÂµÃ‘ï¿½Ã‘ï¿½Ã�Â°Ã„Â±";
		for (int i = 0; i < str.length(); i++) {

			String name = "jon" + str.charAt(i);
			System.out.println(name);
			firstName.sendKeys(name);
			lastName.sendKeys(name);
			pageUtils.sleepSeconds(2, "wait for page load");
			String actFnameError = fNameError.getText();
			firstName.clear();
			pageUtils.sleepSeconds(2, "wait for page load");
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
	
	public void clickOnEDitShoppingBagLink()
	{
		pageUtils.waitForPageToLoad();
	pageUtils.waitForAjaxToComplete();
	pageUtils.sleepSeconds(1, "wait for page load");
	expandShoppingBagItemSection.click();
	pageUtils.waitForAjaxToComplete();
	jsExecutor.executeScript("arguments[0].click();", editShoppingBagLink);
	pageUtils.waitForPageToLoad();
	pageUtils.waitForAjaxToComplete();
	
	}
	public String getItemSubTotalAmount()
	{
		String getTotalAmount1 = getItemSubTotal.getText();
		String getTotalAmount = getTotalAmount1.trim().replaceAll("[^0-9]", "");
		context.saveData("OrderTotalBeforeEditCArt", getTotalAmount);
		return getTotalAmount;
	}

	public void selectedShippingAddress() {
		pageUtils.waitForPageToLoad();
		jsExecutor.executeScript("arguments[0].click();", shippingAddress);
		String shippingAddressText = shippingAddress.getText();
		context.saveData("shippingAddressText", shippingAddressText);
		context.writeOut(shippingAddressText);
	}
	
	public void selectedShippingAddressMobile() {
		pageUtils.waitForPageToLoad();
		jsExecutor.executeScript("arguments[0].click();", shippingAddressMobile);
		String shippingAddressText = shippingAddressMobile.getText();
		context.saveData("shippingAddressText", shippingAddressText);
		context.writeOut(shippingAddressText);
	}

	public void clickEditShippingAddressLink() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(8, "wait for page load");
		pageUtils.scrollToElement(editThisAddressLinkShipping);
		jsExecutor.executeScript("arguments[0].click();", editThisAddressLinkShipping);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();

	}

	public void fillUpRequiredFieldsEdit() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();

		selectStateOrProvince(testData.getUser().address2.getState());

		address1.clear();
		fillAddressLine1(testData.getUser().address2.getStreetAddress1());

		try {
			address2.clear();
			fillAddressLine2(testData.getUser().address2.getStreetAddress2());
		} catch (Exception e) {

		}

		try {
			postalCode.clear();
			fillPostalCode(testData.getUser().address2.getPostalCode());
		} catch (Exception e) {

		}
		city.clear();
		fillCityLine(testData.getUser().address2.getCity());
		phone.clear();
		fillPhone(testData.getUser().getPhoneNumber());
	}
	
	public String iVerifySpecialCharecterInShippingAddress(String guest) {
		String firstName="";
		if(guest.equalsIgnoreCase("guest")) {
			pageUtils.sleepSeconds(5, "wait for page load");
			pageUtils.scrollToElement(shippingAddressSection);
			System.out.println(shippingAddressSection.getText());
			firstName=shippingAddressSection.getText();
		}else if (guest.equalsIgnoreCase("loggedIn")){
		pageUtils.sleepSeconds(5, "wait for page load");
		pageUtils.scrollToElement(shippingFirstName);

		firstName=shippingFirstName.getText();
		}
		return firstName;
	}
	
	public void selectedShippingMethod() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "waiting for shipping method to display");
		jsExecutor.executeScript("arguments[0].click();", slectedShippingOption);
		String shippingOptionText = slectedShippingOption.getText().trim().replaceAll("[^a-zA-Z]", "");
		context.saveData("shippingOptionText", shippingOptionText);
		context.writeOut(shippingOptionText);
	}
	
	public void shipingChargeFromSelectedShippingMethod() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "waiting for shipping method to display");
		jsExecutor.executeScript("arguments[0].click();", slectedShippingOption);
		String country = env.getCurrentLocale().getCountry();
		String locale = env.getLanguage();
		String shippingChargeText = slectedShippingOption.getText().split("\n")[0];
		String[] shipOptArr = shippingChargeText.split("-");
		shippingChargeText = shipOptArr[shipOptArr.length-1].toString().trim().replaceAll("[^\\d\\.\\,\\s]+","").trim().replace(",", "");
		
		if(country.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("fr")) {
			shippingChargeText = shipOptArr[shipOptArr.length-1].toString().trim().replaceAll("[^\\d\\.\\,\\s]+","").trim().replace(",", ".");
			
		}else if(country.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("en")) {
			shippingChargeText = shipOptArr[shipOptArr.length-1].toString().trim().replaceAll("[^\\d\\.\\,\\s]+","").trim().replace(",", "");
		} else {
			shippingChargeText = shipOptArr[shipOptArr.length-1].toString().trim().replaceAll("[^\\d\\.\\,\\s]+","").trim().replace(",", "");
		}
		context.saveData("shippingChargeText", shippingChargeText);
		context.writeOut(shippingChargeText);
	}
	
	public void selectShippingOption(String shipOption) {
		pageUtils.sleepSeconds(3, "to check selected Method");
		pageUtils.waitTillWebElementIsClickable(slectedShippingOption);
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(3, "to check selected Method");
		try {
			webDriver
					.findElement(By.xpath("//*[@value='"+shipOption+"']/following-sibling::label"))
					.click();
			pageUtils.sleepSeconds(2, "to check selected Method");
			if (!pageUtils.verifyIfDisplayed(slectedShippingOption)) {
				webDriver.findElement(By.xpath("//*[@id='standard-shipping-0']/following-sibling::label")).click();
			}
		} catch (Exception e) {
			context.writeOut("Shipping Method"+ shipOption +"Not available ");
			context.embedScreenshots();
		}
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(2, "to check selected Method");
	}
}