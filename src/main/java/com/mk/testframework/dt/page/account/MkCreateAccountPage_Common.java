package com.mk.testframework.dt.page.account;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.interactions.Actions;
import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.exceptions.TestEnvironmentException;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.header.MkMyAccountMenu;
import com.mk.testframework.dt.mobile.MkMobileHamburgerMenu;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_Common;
import com.mk.testframework.dt.util.MkPageNavigator;
import com.mk.testframework.dt.util.ModalUtils;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.dt.util.PageUtils.Resource;

import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

/**
 * @author Raja
 *
 */
public class MkCreateAccountPage_Common {

	@FindBy(id="signin_email_address")
	private WebElement signInEmailAddress;

	@FindBy(id="signin_password")
	private WebElement signInPassword;

	@FindBy(name="signin_submit")
	private WebElement signInSubmit;

	@FindBy(id="email_address")
	private WebElement signUpEmailAddress;

	@FindBy(id="confirm_email_address")
	private WebElement ConfirmEmailAddress;

	@FindBy(id="first_name")
	private WebElement FirstName;

	@FindBy(id="last_name")
	private WebElement LastName;

	@FindBy(id="phone_number")
	private WebElement PhoneNumber;

	@FindBy(id="postal_code")
	private WebElement PostalCode;

	@FindBy(xpath = "//a[contains(text(),'MM')]")
	private WebElement BirthMM;

	@FindBy(xpath = "//div[2]/a[2]")
	private WebElement BirthDD;

	@FindBy(css = ".month_date .sbToggle")
	private WebElement BirthDay;

	@FindBy(xpath = "//div[9]/div/a[2]")
	private WebElement Gender;

	@FindBy(id="signin_password")
	private WebElement Password;

	@FindBy(id="password")
	private WebElement NPassword;

	@FindBy(id="confirm_password")
	private WebElement CPassword;

	@FindBy(id="terms-conditions")
	private WebElement AgreeTermsConditions;

	@FindBy(css=".register_account")
	private WebElement clickRegister;

	@FindBy(css = ".sbSelector")
	private WebElement selectCountry;
	
	@FindBy(id="current_password")
	private WebElement CurPassword;
	
	@FindBy(id="new_password")
    private WebElement NCPassword;
	
	@FindBy(css=".save_pword")
	private WebElement clickSavePassword;
	
	@FindBy(id="signin_email_address-error")
	private WebElement IncorrectEmail;
	
	@FindBy(id="email_address")
	private WebElement createacc_email;
	
	@FindBy(id="confirm_email_address")
	private WebElement createacc_confirmemail;
	
	@FindBy(id="first_name")
	private WebElement createacc_firstname;
	
	@FindBy(id="last_name")
	private WebElement createacc_lastname;
	
	@FindBy(id="password")
	private WebElement createacc_password;
	
	@FindBy(id="confirm_password")
	private WebElement createacc_confirmpassword;
	
	
	@FindBy(css="#termsAndConditionslabel")
	private WebElement createacc_tandc_checkbox;
	

	@FindBy(css=".register_submit")
	private WebElement createacc_registerbutton;
	
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	private PageUtils pageUtils;
	private JavascriptExecutor jsExecutor;
	private ModalUtils modalUtils;
	private WebDriver webDriver;
	private Actions actionBuilder;
	private TestData testData;
	private MkPageNavigator mkPageNavigator;
	private MkMyAccountMenu mkMyAccountMenu;
	private MkHamburgerMenu mkHamburgerMenu;
	private Context context;
	private MkMyAccountPage_Common mkMyAccountPageCommon;

	@Inject
	public MkCreateAccountPage_Common(ModalUtils modalUtils, WebDriver webDriver, PageUtils pageUtils, TestData testData, MkPageNavigator mkPageNavigator,
			MkMyAccountMenu mkMyAccountMenu, MkHamburgerMenu mkHamburgerMenu, Context context, MkMyAccountPage_Common mkMyAccountPageCommon) {
		PageFactory.initElements(webDriver, this);
		this.actionBuilder = new Actions(webDriver);
		this.webDriver = webDriver;
		this.pageUtils = pageUtils;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.modalUtils = modalUtils;
		this.testData = testData;
		this.mkPageNavigator = mkPageNavigator;
		this.mkMyAccountMenu = mkMyAccountMenu;
		this.mkHamburgerMenu = mkHamburgerMenu;
		this.context = context;
		this.mkMyAccountPageCommon = mkMyAccountPageCommon;

	}

	public void enterEmailAddress(String email) {
		try {
			pageUtils.waitForWebElement(signInEmailAddress);
			pageUtils.waitTillWebElementIsClickable(signInEmailAddress);
			pageUtils.sleepSeconds(4, "signin page loaded");
			signInEmailAddress.sendKeys(email);
		} catch (Exception e) {
			try {
				pageUtils.waitForWebElement(signInEmailAddress);
				pageUtils.waitTillWebElementIsClickable(signInEmailAddress);
				pageUtils.sleepSeconds(4, "signin page loaded");
				signInEmailAddress.sendKeys(email);
			} catch (Exception e2) {
				pageUtils.refresh();
				pageUtils.waitForWebElement(signInEmailAddress);
				pageUtils.waitTillWebElementIsClickable(signInEmailAddress);
				pageUtils.sleepSeconds(4, "signin page loaded");
				signInEmailAddress.sendKeys(email);
			}
		}
	}


	public void clickSignIn() {
		try {
			jsExecutor.executeScript("arguments[0].click();", signInSubmit);
			pageUtils.sleepSeconds(5, "waiting for page loaded");
			pageUtils.waitForPageToLoad();
		} catch (Exception e) {
			jsExecutor.executeScript("arguments[0].click();", signInSubmit);
			pageUtils.sleepSeconds(5, "waiting for page loaded");
			pageUtils.waitForPageToLoad();
		}
	}
	
	 
  	public void enterSignUpEmailAddress(String email) {
		pageUtils.waitForWebElement(signUpEmailAddress);
		signUpEmailAddress.sendKeys(email);
	}


	public void enterConfirmEmailAddress(String email) {
		pageUtils.waitForWebElement(ConfirmEmailAddress);
		ConfirmEmailAddress.sendKeys(email);
	}


	public void enterFirstName(String fname) {
		pageUtils.waitForWebElement(FirstName);
		FirstName.sendKeys(fname);
	}

	public void enterFirstNameWithSplChar(String fname) {
		pageUtils.waitForWebElement(FirstName);
		FirstName.sendKeys(context.getSavedData("FirstName"));
	}

	public void enterLastNameWithSplChar(String lname) {
		pageUtils.waitForWebElement(LastName);
		LastName.sendKeys(context.getSavedData("LastName"));
	}
	
	public void enterLastName(String lname) {
		pageUtils.waitForWebElement(LastName);
		LastName.sendKeys(lname);
	}


	public void enterPhoneNumber(String string) {
		pageUtils.waitForWebElement(PhoneNumber);
		PhoneNumber.sendKeys(string);

	}

	public void enterPostalCode(String pcode) {
		pageUtils.waitForWebElement(PostalCode);
		PostalCode.sendKeys(pcode);

	}


	public void SelectBirthMonth(String bmonth) {

		actionBuilder.moveToElement(BirthMM).sendKeys(Keys.TAB).build().perform();
		actionBuilder.moveToElement(BirthMM).sendKeys(Keys.ENTER).build().perform();
		pageUtils.waitForAjaxToComplete();
		new BirthMonthMenu(webDriver).selectMonth(bmonth);
	}




	public void SelectBirthDay(String bday) {

		actionBuilder.moveToElement(BirthDD).click().build().perform();
		pageUtils.waitForAjaxToComplete();
		new BirthDayMenu(webDriver).selectDay(bday);
	}


	public void SelectGender(String gender) {

		actionBuilder.moveToElement(Gender).click().build().perform();
		pageUtils.waitForAjaxToComplete();
		new GenderMenu(webDriver).selectGender(gender);

	}


	public void enterPassword(String password) {
		pageUtils.waitForWebElement(Password);
		Password.sendKeys(password);

	}

	public void enterNPassword(String password) {
		pageUtils.waitForWebElement(NPassword);
		NPassword.sendKeys(password);

	}


	public void enterConfirmPassword(String password) {
		pageUtils.waitForWebElement(CPassword);
		CPassword.sendKeys(password);

	}

	public void agreeTermsAndConditions() {
		jsExecutor.executeScript("arguments[0].click();", AgreeTermsConditions);
		pageUtils.waitForPageToLoad();
	}


	public void clickRegister() {
		pageUtils.sleepSeconds(5, "Waiting for register button");
		pageUtils.scrollToElement(clickRegister);
		jsExecutor.executeScript("arguments[0].click();", clickRegister);
		pageUtils.sleepSeconds(5, "Register Clicked"); 
		pageUtils.waitForPageToLoad();
	}


	public class CountryMenu {

		@FindBy(css = ".sbOptions a")
		private List<WebElement> countryOptions;

		public CountryMenu(WebDriver webDriver) {
			PageFactory.initElements(webDriver, this);

		}



		public void selectCountry(String country) {

			String translatedCountryTitle = getTranslation(country);

			try {
				WebElement option = countryOptions.stream()
						.filter(s -> s.getText().equals(String.valueOf(translatedCountryTitle))).findFirst().get();
				actionBuilder.moveToElement(option).click().build().perform();
				pageUtils.waitForAjaxToComplete();
				pageUtils.waitForPageToLoad();
			} catch (NoSuchElementException e) {
				throw new TestEnvironmentException("Could not find country option to click : " + e.getMessage());
			}
		}


	}





	public void SelectCountryName(String country) {

		actionBuilder.moveToElement(selectCountry).click().build().perform();
		pageUtils.waitForAjaxToComplete();
		new CountryMenu(webDriver).selectCountry(country);
	}




	private String getTranslation(String country) {

		ResourceBundle countryResource = pageUtils.getResourceBundle(Resource.COUNTRIES);
		return countryResource.getString(pageUtils.buildResourceLookupKey(country));

	}


	public class BirthMonthMenu {

		@FindBy(css = ".sbOptions a")
		private List<WebElement> monthOptions;


		public BirthMonthMenu(WebDriver webDriver) {
			PageFactory.initElements(webDriver, this);


		}



		public void selectMonth(String bmonth) {

			String translatedMonth = getTranslationM(bmonth);

			try {
				WebElement option2 = monthOptions.stream()
						.filter(s -> s.getText().contains(String.valueOf(translatedMonth))).findFirst().get();
				actionBuilder.moveToElement(option2).click().build().perform();
				pageUtils.waitForAjaxToComplete();
				pageUtils.waitForPageToLoad();
			} catch (NoSuchElementException e) {
				throw new TestEnvironmentException("Could not find my Month option "+translatedMonth+" to click : " + e.getMessage());
			}
		}

	}


	private String getTranslationM(String month) {

		ResourceBundle monthResource = pageUtils.getResourceBundle(Resource.MONTHS);
		return monthResource.getString(pageUtils.buildResourceLookupKey(month));

	}



	public class BirthDayMenu {

		@FindBy(css = ".sbOptions a")
		private List<WebElement> dayOptions;


		public BirthDayMenu(WebDriver webDriver) {
			PageFactory.initElements(webDriver, this);


		}



		public void selectDay(String bday) {
			try {
				WebElement option3 = dayOptions.stream()
						.filter(s -> s.getText().equals(bday)).findFirst().get();
				actionBuilder.moveToElement(option3).click().build().perform();
				pageUtils.waitForAjaxToComplete();
				pageUtils.waitForPageToLoad();
			} catch (NoSuchElementException e) {
				throw new TestEnvironmentException("Could not find Day option to click : " + e.getMessage());
			}
		}

	}


	public class GenderMenu {

		@FindBy(css = ".sbOptions a")
		private List<WebElement> genderOptions;


		public GenderMenu(WebDriver webDriver) {
			PageFactory.initElements(webDriver, this);


		}



		public void selectGender(String gender) {

			String translatedGender = getTranslationG(gender);

			try {
				WebElement option3 = genderOptions.stream()
						.filter(s -> s.getText().equals(String.valueOf(translatedGender))).findFirst().get();

				actionBuilder.moveToElement(option3).click().build().perform();
				pageUtils.waitForAjaxToComplete();
				pageUtils.waitForPageToLoad();
			} catch (NoSuchElementException e) {
				throw new TestEnvironmentException("Could not find Gender option to click : " + e.getMessage());
			}
		}

		private String getTranslationG(String gender) {

			ResourceBundle monthResource = pageUtils.getResourceBundle(Resource.GENDER);
			return monthResource.getString(pageUtils.buildResourceLookupKey(gender));

		}

	}
	
	public void enterCreatedEmailAddress(String email) {
		
		pageUtils.waitForWebElement(signInEmailAddress);
		signInEmailAddress.sendKeys(email);
	}
	
	   public void enterCurrentPassword(String password) {
				pageUtils.waitForWebElement(CurPassword);
				CurPassword.sendKeys(password);
				
			}
	   
	   public void enterNewChangePassword(String password) {
			pageUtils.waitForWebElement(NCPassword);
			NCPassword.sendKeys(password);
			
		}
	   
	   public void clickSavePassword() {
			jsExecutor.executeScript("arguments[0].click();", clickSavePassword);
			pageUtils.waitForPageToLoad();
			pageUtils.sleepSeconds(5, "Password saved"); 
			
		}
	   
		public void createAccountWithSplCharacter(DataTable table) {
			List<List<String>> data = table.asLists();
			pageUtils.waitForPageToLoad();
			for (int i = 0; i < data.size(); i++) {
				String data1 = data.get(i).toString().replaceAll("\\[", "").replaceAll("\\]", "").trim();
				FirstName.sendKeys("fisrst" +  data1);
				String expectedFname = FirstName.getAttribute("value");
				System.out.println("Fname is " + expectedFname);
				context.saveData("fname", expectedFname);
				LastName.sendKeys("last"+ data.get(i).toString().replaceAll("\\[", "").replaceAll("\\]", "").trim());
				String expectedLname = LastName.getAttribute("value");
				System.out.println("Lname is " + expectedLname);
				context.saveData("lname", expectedLname);
				testData.createRandomEmail();
				enterSignUpEmailAddress(testData.getRandomEmail());
				enterConfirmEmailAddress(testData.getRandomEmail());
				enterPhoneNumber(testData.getUser().getPhoneNumber());
				enterPostalCode(testData.getUser().address.getPostalCode());
				enterNPassword(testData.getUser().getPassword());
				enterConfirmPassword(testData.getUser().getPassword());
				agreeTermsAndConditions();
				clickRegister();
				mkPageNavigator.onProfileLandingPage();
				pageUtils.waitForPageToLoad();
				pageUtils.sleepSeconds(2, "Password saved");
				verifyFnameSavedWithSPLCahr();
				verifyLnameSavedWithSPLCahr();

				try {
					mkMyAccountMenu.flyOutMenu().clickSignOut();
				} catch (TestEnvironmentException e) {
					mkPageNavigator.goToHomePage();
					log.debug("Trying log out second time");
					mkMyAccountMenu.flyOutMenu().clickSignOut();
				}
				pageUtils.waitForPageToLoad();
				pageUtils.sleepSeconds(5, "Password saved");
				mkHamburgerMenu.clickSignInLink();

				}
			}

		public void verifyFnameSavedWithSPLCahr() {

			String actual = mkMyAccountPageCommon.getName().toLowerCase().strip();
			System.out.println("Actual Fname is " + actual);
			String expected = context.getSavedData("fname");
			System.out.println(expected);
			Assert.assertTrue("First name is expected to be updated; expected: " + expected + "| actual: " + actual,
					actual.equalsIgnoreCase(expected));
		}

		public void verifyLnameSavedWithSPLCahr() {

			String actual = mkMyAccountPageCommon.getLastName().toLowerCase().strip();
			System.out.println("Actual Lname is " + actual);
			String expected = context.getSavedData("lname");
			System.out.println(expected);
			Assert.assertTrue("Last name is expected to be updated; expected: " + expected + "| actual: " + actual,
					actual.equalsIgnoreCase(expected));
		}

		public void createAccountEmail(String email) {
			createacc_email.sendKeys(email);
			
		}

		public void comfirmemail(String confemail) {
			createacc_confirmemail.sendKeys(confemail);
			
		}

		public void enterFName(String fname) {
			createacc_firstname.sendKeys(fname);
			
		}

		public void enterLName(String Lname) {
			createacc_lastname.sendKeys(Lname);
			
		}

		public void createAccountPwd(String pwd) {
			createacc_password.sendKeys(pwd);
			
		}

		public void createAccountconfrmPwd(String confmpwd) {
			createacc_confirmpassword.sendKeys(confmpwd);
			
		}

		public void clickTandC() {
			createacc_tandc_checkbox.click();
			
		}

		public void clickRegiter() {
			createacc_registerbutton.click();
			
		}

		
	}
	

