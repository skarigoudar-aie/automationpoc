package com.mk.testframework.dt.popup;

import com.mk.testframework.dt.util.PageUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.google.inject.Inject;

public class MkKorsVIPSignupModal {

	@FindBy(how = How.CSS, using = ".korsvip-signUp-model-main-wrapper")
	private WebElement korsvipSignupModalWrapper;

	@FindBy(how = How.CSS, using = ".mk-korsvip-signUp-column")
	private WebElement korsvipSignupColumn;

	@FindBy(how = How.CSS, using = "#closekorsvipsignUpModel")
	private WebElement closekorsvipsignUpModelButton;

	@FindBy(how = How.CSS, using = "#fName")
	private WebElement firstnameInput;

	@FindBy(how = How.CSS, using = "#lName")
	private WebElement lastnameInput;

	@FindBy(how = How.CSS, using = "#emailId")
	private WebElement emailaddressInput;

	@FindBy(how = How.CSS, using = ".korsvip-signUp-model-main-wrapper #korsSignUpForm #zipcode")
	private WebElement zipPostalcodeInput;

	@FindBy(how = How.CSS, using = "#birthMonth")
	private WebElement birthmonthInput;

	@FindBy(how = How.CSS, using = "#birthDate")
	private WebElement birthdateInput;

	@FindBy(how = How.CSS, using = "#gender")
	private WebElement genderRadio;

	@FindBy(how = How.CSS, using = "#password")
	private WebElement passwordInput;

	@FindBy(how = How.CSS, using = "#confirmPassword")
	private WebElement confirmPasswordInput;

	@FindBy(how = How.XPATH, using = "//*[@class='signup-marketing-label']//parent::div[@id='joinNowCheckbox']//label")
	private WebElement checkbox__join_kors_checkbox;

	@FindBy(how = How.XPATH, using = "//*[@id='joinNowCheckbox']//parent::input")
	private WebElement checkbox__join_kors;

	@FindBy(how = How.XPATH, using = "//*[@id='signupMarketingCheckbox']//parent::div[@class='signup-marketing-checkbox']")
	private WebElement checkbox__subscribe_checkbox;

	@FindBy(how = How.XPATH, using = "//*[@id='signupMarketingCheckbox']//parent::div[@class='signup-marketing-checkbox']//label")
	private WebElement checkbox__subscribe;

	@FindBy(how = How.CSS, using = ".mk-korsvip-signUp-column .join-now-btn.hide-desktop")
	private WebElement btn__join_korsvip;

	@FindBy(how = How.CSS, using = ".form-level-error.global_error_msg_container")
	private WebElement text__form_error;

	@FindBy(how = How.CSS, using = ".birthday-reward.visible")
	private WebElement container_join_confirmation_panel;

	@FindBy(how = How.CSS, using = ".birthday-reward.visible .learn-kors")
	private WebElement link__confirmation_skip_link;

	private Actions actionBuilder;
	private PageUtils pageUtils;

	@Inject
	public MkKorsVIPSignupModal(WebDriver webDriver, PageUtils pageUtils) {
		PageFactory.initElements(webDriver, this);
		this.actionBuilder = new Actions(webDriver);
		this.pageUtils = pageUtils;
	}

	public boolean waitForKorsVIPSignupModalModal() {
		return pageUtils.waitForWebElement(korsvipSignupModalWrapper);
	}

	public void close() {
		actionBuilder.moveToElement(closekorsvipsignUpModelButton).click().build().perform();
	}
}