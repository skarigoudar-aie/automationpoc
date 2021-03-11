package com.mk.testframework.dt.popup;

import com.google.inject.Inject;
import com.mk.testframework.dt.util.PageUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MkNeverMissABeatModal {

	@FindBy(how = How.CSS, using = ".promo-signup-content-wrapper")
	private WebElement neverMissABeatModal;

	@FindBy(how = How.CSS, using = ".promo-signup-content-wrapper #closePromotionalSignup")
	private WebElement closeModalButton;

	@FindBy(how = How.CSS, using = "#fName")
	private WebElement input__first_name;

	@FindBy(how = How.CSS, using = "#lName")
	private WebElement input__last_name;

	@FindBy(how = How.CSS, using = "#emailId")
	private WebElement input__email_address;

	@FindBy(how = How.CSS, using = "#birthMonth")
	private WebElement input__birth_month;

	@FindBy(how = How.CSS, using = "#birthDate")
	private WebElement input__birth_date;

	@FindBy(how = How.CSS, using = "#gender")
	private WebElement radio__gender;

	@FindBy(how = How.CSS, using = "#password")
	private WebElement input__password;

	@FindBy(how = How.CSS, using = "#confirmPassword")
	private WebElement input__password_confirmation;

	@FindBy(how = How.XPATH, using = "//*[@class='signup-marketing-label']//parent::div[@id='joinNowCheckbox']//label")
	private WebElement checkbox__join_kors_checkbox;

	@FindBy(how = How.XPATH, using = "//*[@id='joinNowCheckbox']//parent::input")
	private WebElement checkbox__join_kors;

	@FindBy(how = How.XPATH, using = "//*[@id='signupMarketingCheckbox']//parent::div[@class='signup-marketing-checkbox']")
	private WebElement checkbox__subscribe_checkbox;

	@FindBy(how = How.XPATH, using = "//*[@id='signupMarketingCheckbox']//parent::div[@class='signup-marketing-checkbox']//label")
	private WebElement checkbox__subscribe;

	@FindBy(how = How.CSS, using = ".sign-in-btn")
	private WebElement btn__join_korsvip;

	@FindBy(how = How.CSS, using = ".form-level-error.global_error_msg_container")
	private WebElement text__form_error;

	private Actions actionBuilder;
	private PageUtils pageUtils;

	@Inject
	public MkNeverMissABeatModal(WebDriver webDriver, PageUtils pageUtils) {
		PageFactory.initElements(webDriver, this);
		this.actionBuilder = new Actions(webDriver);
		this.pageUtils = pageUtils;
	}

	public boolean waitForNeverMissABeatModal() {
		return pageUtils.waitForWebElement(neverMissABeatModal);
	}

	public void close() {
		actionBuilder.moveToElement(closeModalButton).click().build().perform();
	}
}