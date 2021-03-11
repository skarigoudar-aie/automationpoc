package com.mk.testframework.dt.page.account;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.google.inject.Inject;
import com.mk.testframework.dt.util.PageUtils;

/**
 * @author Raja
 *
 */
public class MkCreateAccountPage_NA {

	@FindBy(id = "birth_month")
	private WebElement birthMonth;

	@FindBy(id = "birth_date")
	private WebElement birthDay;

	@FindBy(id = "fields_container")
	private WebElement Gender;

	@FindBy(id = "gender_male")
	private WebElement Male;

	@FindBy(id = "gender_female")
	private WebElement Female;

	@FindBy(id = "prefer_notToAns")
	private WebElement PreferNSay;

	@FindBy(id = "subscribe1")
	private WebElement OptoutMrktg;

	@FindBy(css = ".register_account")
	private WebElement clickCreateAccount;

	@FindBy(css = ".sbSelector")
	private WebElement selectCountry;

	@FindBy(id = "username")
	private WebElement LogInEmailAddress;

	@FindBy(id = "password")
	private WebElement NPassword;

	@FindBy(css = ".form-level-error")
	private WebElement invalidcredentials;

	private PageUtils pageUtils;
	private JavascriptExecutor jsExecutor;

	@Inject
	public MkCreateAccountPage_NA(WebDriver webDriver, PageUtils pageUtils) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
	}

	public void EnterBirthMonth(String bmonth) {
		pageUtils.waitForWebElement(birthMonth);
		birthMonth.sendKeys(bmonth);
	}

	public void EnterBirthDay(String bday) {
		pageUtils.waitForWebElement(birthDay);
		birthDay.sendKeys(bday);
	}

	public void optOutMktgComms() {
		jsExecutor.executeScript("arguments[0].click();", OptoutMrktg);
		pageUtils.waitForPageToLoad();
	}

	public void clickCreateAccount() {
		try {
			jsExecutor.executeScript("arguments[0].click();", clickCreateAccount);
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
		} catch (Exception e) {
		}
	}

	public void ChooseGender(String gender) {

		if (gender.equals("Male")) {
			pageUtils.waitForWebElement(Male);
			jsExecutor.executeScript("arguments[0].click();", Male);
			pageUtils.waitForPageToLoad();
		} else if (gender.equals("Female")) {
			pageUtils.waitForWebElement(Female);
			jsExecutor.executeScript("arguments[0].click();", Female);
			pageUtils.waitForPageToLoad();

		}

		else {

			pageUtils.waitForWebElement(PreferNSay);
			jsExecutor.executeScript("arguments[0].click();", PreferNSay);
			pageUtils.waitForPageToLoad();

		}

	}

	public void enterCreatedEmailAddress(String email) {
		pageUtils.sleepSeconds(2, "waitr for page load");
		pageUtils.waitForWebElement(LogInEmailAddress);
		LogInEmailAddress.sendKeys(email);
	}

	public void enterPassword(String password) {
		pageUtils.waitForWebElement(NPassword);
		NPassword.sendKeys(password);

	}

	public void validateErrorMessage() {
		Assert.assertNotNull(invalidcredentials);
	}

}
