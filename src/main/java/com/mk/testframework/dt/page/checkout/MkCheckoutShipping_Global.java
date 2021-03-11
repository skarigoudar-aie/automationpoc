package com.mk.testframework.dt.page.checkout;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.dt.util.PageUtils;

/**
 * @author VThipperudrappa
 *
 */
public class MkCheckoutShipping_Global {

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
	

	private PageUtils pageUtils;
	private TestData testData;

	@Inject
	public MkCheckoutShipping_Global(WebDriver webDriver, PageUtils pageUtils, TestData testData) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.testData = testData;
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
	
	public void fillUpRequiredFieldsForSpecialChar() {
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
	
}
