package com.mk.testframework.dt.page.home;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.core.env.Environment.Region;
import com.mk.testframework.dt.util.ModalUtils;
import com.mk.testframework.dt.util.PageUtils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Set;

/**
 * @author VThipperudrappa
 *
 */
public class MkHomePage {

	@FindBy(css = ".mkwpdev")
	private List<WebElement> promoSections;

	@FindBy(css = ".footer-wrapper .mk-store-locator")
	private WebElement findAstoreSection;

	@FindBy(css = ".footer-wrapper .mk-newsletter-subs")
	private WebElement newsLetterSection;

	@FindBy(css = ".footer-wrapper .mk-social-links")
	private WebElement socialMediaSection;

	@FindBy(css = ".footer-wrapper .mk-footer-links")
	private WebElement footerLinkSection;

	@FindBy(css = ".footer-wrapper .Additional-footer-links")
	private WebElement additionalFooterLinkSection;

	@FindBy(css = ".store locator")
	private WebElement storelocatorpage;

	@FindBy(id = "footer_email")
	private WebElement footerEmailSignUp;

	@FindBy(css = ".signup-button")
	private WebElement footerSignUpButton;

	@FindBy(id = "confirm_email_address")
	private WebElement footerConfEmailAddress;

	@FindBy(id = "first_name")
	private WebElement footerSignUpFirstname;

	@FindBy(id = "last_name")
	private WebElement footerSignUpLastname;

	@FindBy(id = "postal_code")
	private WebElement signUpPostcode;

	@FindBy(id = "password")
	private WebElement signUpPassword;

	@FindBy(id = "confirm_password")
	private WebElement signUpconfirmPassword;

	@FindBy(css = ".register_account")
	private WebElement createAccountButton;

	@FindBy(id = "accept")
	private WebElement IAcceptCookies;

	@FindBy(id = "onetrust-button-group-parent")
	private WebElement IAcceptCookieBannerGroup;

	@FindBy(id = "onetrust-accept-btn-handler")
	private WebElement IAcceptCookieBanner;

	@FindBy(css = "link[rel='canonical']")
	private WebElement canonicalLink;

	@FindBy(css = ".Column:nth-child(1) .footer-link:nth-child(2) > .footer-link")
	private WebElement trackMyOrdereu;

	@FindBy(css = ".Column:nth-child(2) .footer-link:nth-child(3) > .footer-link")
	private WebElement trackmyorderus;

	@FindBy(css = ".Column:nth-child(3) .footer-link:nth-child(2) > .footer-link")
	private WebElement trackmyorderca;

	@FindBy(id = "account_email_address")
	private WebElement accountEmailId;

	@FindBy(id = "password")
	private WebElement accountPassword;

	@FindBy(css = ".account_submit")
	private WebElement Submit;

	@FindBy(css = ".order_history_header_content")
	private WebElement OrderHistory;

	@FindBy(css = ".no_orders_history_container")
	private WebElement NoOrderHistory;
	
	@FindBy(css = "#onetrust-banner-sdk:nth-child(3)")
	private WebElement cookieBanner;
	
	@FindBy(css = "button#onetrust-pc-btn-handler")
	private WebElement manageCookiePreferences;
	
	@FindBy(css = "p#onetrust-policy-text")
	private WebElement oneTrustPolicyText;
	
	@FindBy(css = "button#onetrust-accept-btn-handler")
	private WebElement acceptCookiesInBanner;
	
	@FindBy(css = "button#onetrust-pc-btn-handler")
	private WebElement managePreferences;
	
	@FindBy(css = "div#onetrust-pc-sdk")
	private WebElement oneTrustPCPanel;
	
	@FindBy(css = "#accept-recommended-btn-handler.button-theme")
	private WebElement oneTrustPCPanelAcceptAll;
	
	@FindBy(xpath = "//section[@id='cookie-preferences']//div[@class='ot-switch ot-toggle']//input")
	private WebElement targetCookiesToggle;
	
	@FindBy(xpath = "//section[@id='cookie-preferences']//div[@class='save-preference-btn-container']//button")
	private WebElement savePreferences;
	
	@FindBy(xpath = "//section[@id='cookie-preferences']//div[@class='ot-switch ot-toggle']")
	private WebElement togglePCPanel;
	
	@FindBy(css = ".SortExpandColumns ul:nth-child(3) img")
	private WebElement writeToUs;
	
	@FindBy(css = "#firstName")
	private WebElement contactUsFirstname;

	@FindBy(css = "#lastName")
	private WebElement contactUsLastname;
	
	@FindBy(css = "#emailAddress")
	private WebElement contactUsEmail;
	
	@FindBy(css = "#phoneNumber")
	private WebElement contactUsPhoneNumber;
	
	@FindBy(css = "#orderNumber")
	private WebElement contactUsOrderID;
	
	@FindBy(css = "form[name=contactForm] button[type=submit]")
	private WebElement contactUsSubmit;
	
	@FindBy(css = "#contact-us-form-modal")
	private WebElement writeNow;
	
	@FindBy(xpath = "//div[@class='modalWrap success']")
	private WebElement successPopUpContactUs;
	
	@FindBy(xpath = "//ul[@class='footer_links_list']//li//a")
	private List<WebElement> footerLinks;
	
	@FindBy(xpath = "//ul[@class='footer_links_list']/li/a[contains(@href,'/gift-cards')]")
	private WebElement clickgiftCard;
	
	@FindBy(css = ".header-my-account")
	private WebElement signinmk;
	
	@FindBy(css = "#signin_email_address")
	private WebElement username;
	
	@FindBy(css = "#signin_password")
	private WebElement pword;
	
	
	@FindBy(xpath = "//*[@name='signin_submit']")
	private WebElement signinbtn;
	
	
	@FindBy(xpath = "//*[@title='Michael Kors']//img")
	private WebElement mklogo;
	
	
	private WebDriver webDriver;

	private PageUtils pageUtils;
	private ModalUtils modalUtils;
	private JavascriptExecutor jsExecutor;
	private Context context;
	private Environment env;
	private TestData testData;
	private Actions actionBuilder;
	
	@Inject
	public MkHomePage(WebDriver webDriver, PageUtils pageUtils, ModalUtils modalUtils, Context context,
			Environment env, TestData testData) {
		PageFactory.initElements(webDriver, this);
		this.webDriver = webDriver;
		this.pageUtils = pageUtils;
		this.modalUtils = modalUtils;
		this.context = context;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.env = env;
		this.testData = testData;
		this.actionBuilder = new Actions(webDriver);
	}

	public boolean hasPromoSections() {
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForPageToLoad();
		return !promoSections.isEmpty();
	}

	public boolean hasFindAstoreSection() {
		return pageUtils.verifyIfDisplayed(findAstoreSection);
	}

	public boolean hasNewsLetterSection() {
		return pageUtils.verifyIfDisplayed(newsLetterSection);
	}

	public boolean hasSocialMediaSection() {
		return pageUtils.verifyIfDisplayed(socialMediaSection);
	}

	public boolean hasFooterLinksSection() {
		return pageUtils.verifyIfDisplayed(footerLinkSection);
	}

	public boolean hasAdditionalFooterLinkSection() {
		return pageUtils.verifyIfDisplayed(additionalFooterLinkSection);
	}

	public boolean hasStoreLocatorPage() {
		return pageUtils.verifyIfDisplayed(storelocatorpage);
	}

	public void enterEmailid(String email) {
		footerEmailSignUp.sendKeys(email);
	}

	public void clickOnfooterSignUp() {
		modalUtils.closeStayInTouchModalIfPresented();
		jsExecutor.executeScript("arguments[0].click();", footerSignUpButton);
		pageUtils.sleepSeconds(1, "page load");
		pageUtils.waitForPageToLoad();
	}

	public void footerEnterConfirmEmailId(String email) {
		footerConfEmailAddress.sendKeys(email);
	}

	public void footerEnterFirstName(String firstname) {
		footerSignUpFirstname.sendKeys(firstname);

	}

	public void footerEnterLastName(String lastname) {
		footerSignUpLastname.sendKeys(lastname);

	}

    
	public void enterNewEmailId(String email) {
		footerConfEmailAddress.sendKeys(email);
	}
          
     public void enterPostcode(String postalCode) {
		signUpPostcode.sendKeys(postalCode);
	}

	public void enterPassword(String password) {
		signUpPassword.sendKeys(password);

	}

	public void enterConfirmPassword(String password) {
		signUpconfirmPassword.sendKeys(password);

	}

	public void clickOnCreateAccountbutton() {
		createAccountButton.click();

	}

	public void acceptCookies() {
		jsExecutor.executeScript("arguments[0].click();", IAcceptCookies);
		pageUtils.sleepSeconds(1, "page load");
	}

	public boolean waitForCookieBannerPopup() {
		return pageUtils.waitForWebElement(IAcceptCookieBannerGroup);
	}

	public void acceptCookieBannerIfPresented() {
		if (this.waitForCookieBannerPopup()) {
			pageUtils.sleepSeconds(5, "page load");
			jsExecutor.executeScript("arguments[0].click();", IAcceptCookieBanner);
			pageUtils.sleepSeconds(2, "page load");

		}
	}

	public String getCanonicalLink() {
		String link = canonicalLink.getAttribute("href");
		context.writeOut("Canonical SEO URL: " + link);
		return link.substring(0, link.length() - 1);
	}

	public void clickOntrackMyOrder() {

		if (env.getCountry().equalsIgnoreCase("US")) {
			
			pageUtils.sleepSeconds(3, "link display");
			jsExecutor.executeScript("arguments[0].click();", trackmyorderus);
			

		} else if (env.getCountry().equalsIgnoreCase("CA")) {
			
			pageUtils.sleepSeconds(3, "link display");
			jsExecutor.executeScript("arguments[0].click();", trackmyorderca);
			
		} 
		else {
			pageUtils.sleepSeconds(3, "link display");
			jsExecutor.executeScript("arguments[0].click();", trackMyOrdereu);
			
		}
	}

	public void enterEmailidInAccountPage(String email) {
		pageUtils.sleepSeconds(3, "page load");
		accountEmailId.sendKeys(email);
	}

	public void enterPasswordInAccountPage(String password) {
		pageUtils.sleepSeconds(3, "page load");
		accountPassword.sendKeys(password);

	}

	public void clickOnSignInInAccountPage() {
		jsExecutor.executeScript("arguments[0].click();", Submit);
		pageUtils.sleepSeconds(3, "page load");
	}

	public boolean isOrderHistoryPageDisplayed() {
		try {
			return pageUtils.verifyIfDisplayed(OrderHistory);
		} catch (Exception e) {
			return pageUtils.verifyIfDisplayed(NoOrderHistory);
		}
	}
	
	public boolean isCookieBannerDispalyed() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitTillWebElementIsVisible(cookieBanner, 10);
		return pageUtils.verifyIfDisplayed(cookieBanner);
	}
	
	public boolean isCookieAcceptAllButtonDispalyed() {
		return pageUtils.verifyIfDisplayed(IAcceptCookieBanner);
	}
	
	public boolean isManageCookiePrefButtonDispalyed() {
		return pageUtils.verifyIfDisplayed(manageCookiePreferences);
	}
	
	public boolean verifyOneTrustPolicyText() {
		String expectedText = pageUtils.getTextTranslation("onetrust-policy-text");
		boolean flag = false;
		if(oneTrustPolicyText.getText().trim().equalsIgnoreCase(expectedText))
			flag = true;
		return flag;
	}
	
	public void iAcceptCookies() {
		pageUtils.sleepSeconds(5, "Wait for accept all button to display");
		IAcceptCookieBanner.click();		
	}
	
	public boolean verifySavedCookies() {
		return pageUtils.isCookiesSaved();
	}
	
	public boolean verifyOneTrustActiveGroupsInCookies(List<String> actualOneTrustgroups) {
		boolean status = false;
		Cookie cookie = webDriver.manage().getCookieNamed("OptanonConsent");
		String cookieGroups = String.valueOf(cookie);
		for (int i = 0; i < actualOneTrustgroups.size(); i++) {
			if(!cookieGroups.contains(actualOneTrustgroups.get(i))){
				status = false;
				break;
			}else {
				status = true;
			}
		}
		return status;		
	}
	
	public boolean clickOnManagePreferences() {
		managePreferences.click();
		return isOnetrustPCPanelDisplayed();
	}
	
	public boolean isOnetrustPCPanelDisplayed() {
		pageUtils.waitForAjaxToComplete();
		return pageUtils.verifyIfDisplayed(oneTrustPCPanel);
	}
	
	public void clickOnAcceptAllInOnetrustPCPanel() {
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "Wait for OneTrust PC panel to open");
		oneTrustPCPanelAcceptAll.click();
	}
	
	public boolean enableTargetCookiesIfNot() {
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitTillWebElementIsVisible(togglePCPanel, 2);
		togglePCPanel.click();
		pageUtils.sleepSeconds(2, "Wait for toggle to enable");
		return Boolean.valueOf(targetCookiesToggle.getAttribute("aria-checked"));
	}
	
	public boolean disableTargetCookiesIfNot() {
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitTillWebElementIsVisible(togglePCPanel, 2);
		togglePCPanel.click();
		pageUtils.sleepSeconds(2, "Wait for toggle to disable");
		return Boolean.valueOf(targetCookiesToggle.getAttribute("aria-checked"));
	}
	
	public void clickOnSavePreferences() {
		savePreferences.click();
	}
	
	public boolean verifyAcceptAllText() {
		String expectedText = pageUtils.getTextTranslation("accept-all-cookie-banner");
		boolean flag = false;
		if(acceptCookiesInBanner.getText().trim().equalsIgnoreCase(expectedText))
			flag = true;
		return flag;
	}
		
	public boolean verifyManagePreferencesText() {
		String expectedText = pageUtils.getTextTranslation("manage-preferences-cookie-banner");
		boolean flag = false;
		if(manageCookiePreferences.getText().trim().equalsIgnoreCase(expectedText))
			flag = true;
		return flag;
	}
	
	public void clickOnFooterLink(String link) {
		context.saveData("Page Source", webDriver.getPageSource());
		for (int i = 0; i < footerLinks.size(); i++) {
			if(footerLinks.get(i).getText().equalsIgnoreCase(pageUtils.getFooterLinksTranslation(link))) {
				actionBuilder.moveToElement(footerLinks.get(i)).build().perform();
				pageUtils.sleepSeconds(1, "Wait for element to click");
				jsExecutor.executeScript("arguments[0].click();" , footerLinks.get(i));
				pageUtils.waitForPageToLoad();
				pageUtils.sleepSeconds(2, "Wait for page to load");
				break;
			}			
		}
	}
	
	public boolean verifyPageRedirection() {
		boolean status = false;
		String beforeClickPageSource = context.getSavedData("Page Source");
		String afterClickPageSource = webDriver.getPageSource();
		if(!(beforeClickPageSource==afterClickPageSource))
			status = true;
		else
			status = false;
		return status;
	}
	
	public void fillContactUsForm() {
		contactUsFirstname.sendKeys(testData.getUser().getFirstname());
		contactUsLastname.sendKeys(testData.getUser().getLastname());
		contactUsEmail.sendKeys(testData.getUser().getEmail());
		contactUsPhoneNumber.sendKeys(testData.getUser().getPhoneNumber());
		if (!(env.getCountryRegion().equals(Region.NA))) {
			contactUsOrderID.sendKeys("w6612792");
		}
		contactUsSubmit.click();
	}
	
	public boolean submitContactUsForm() {
		String footerList = "//a[text()='"+ pageUtils.getFooterLinksTranslation("contact-us")+"']";
		pageUtils.sleepSeconds(3, "wait for page to load");
		actionBuilder.moveToElement(webDriver.findElement(By.xpath(footerList))).build().perform();
		jsExecutor.executeScript("arguments[0].click();", webDriver.findElement(By.xpath(footerList)));
		pageUtils.sleepSeconds(5, "wait for page to load");
		jsExecutor.executeScript("arguments[0].click();", writeNow);
		fillContactUsForm();		
		pageUtils.sleepSeconds(5, "wait for page to load");
		return pageUtils.verifyIfDisplayed(successPopUpContactUs);
	}

	public void clickBottomFooterLinks() {
		pageUtils.sleepSeconds(5, "wait for page to load");
		String privacyPolicy = "//a[text()='"+ pageUtils.getFooterLinksTranslation("privacy-policy")+"']";
		jsExecutor.executeScript("arguments[0].click();", webDriver.findElement(By.xpath(privacyPolicy)));
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "wait for page to load");
		String terms = "//a[text()='"+ pageUtils.getFooterLinksTranslation("terms-conditions")+"']";
		jsExecutor.executeScript("arguments[0].click();", webDriver.findElement(By.xpath(terms)));
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "wait for page to load");
		String cookies = "//a[text()='"+ pageUtils.getFooterLinksTranslation("cookies-choices")+"']";
		jsExecutor.executeScript("arguments[0].click();", webDriver.findElement(By.xpath(cookies)));
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(2, "wait for page to load");		
	}

	public void cliclkOnGiftCardLinkFromFooter() {
		pageUtils.scrollToBottomOfPage();
		jsExecutor.executeScript("arguments[0].click();", clickgiftCard);
	}
	
	public void signinlink() {
		signinmk.click();
	}
	
	public void enterUserName(String uname) {
		username.sendKeys(uname);
	}
	
	public void enterPword(String pwd) {
		pword.sendKeys(pwd);
	}
	
	public void clickSigninBtn() {
		signinbtn.click();}
	
	public void clickLogo() {
		mklogo.click();}
	
}



