package com.mk.testframework.dt.mobile;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.core.env.Environment.Region;
import com.mk.testframework.dt.util.PageUtils;

import ch.qos.logback.core.read.ListAppender;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author VThipperudrappa
 *
 */
public class MkMobileHomePage {

	
	@FindBy(css = ".Column:nth-child(1) > .footer_links_heading > a")
	private WebElement mobcustomerservice;

	@FindBy(css = ".Column:nth-child(1) .footer-link:nth-child(2) > .footer-link")
	private WebElement mobtrackmyordereu;

	@FindBy(css = ".Column:nth-child(2) > .footer_links_heading > a")
	private WebElement mobmyaccountus;

	@FindBy(css = ".Column:nth-child(2) .footer-link:nth-child(3) > .footer-link")
	private WebElement mobtrackmyorderus;

	@FindBy(css = ".Column:nth-child(3) > .footer_links_heading > a")
	private WebElement mobcustomerserviceca;

	@FindBy(css = ".Column:nth-child(3) .footer-link:nth-child(2) > .footer-link")
	private WebElement mobtrackmyorderca;
	
	@FindBy(xpath = "//li[contains(@class,'footer_links_heading')]//a")
	private List<WebElement> footerColumns;
	
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
	
	@FindBy(css = "form[name=contactForm] button[type=submit]")
	private WebElement contactUsSubmit;
	
	@FindBy(css = "#contact-us-form-modal")
	private WebElement writeNow;
	
	@FindBy(xpath = "//div[@class='modalWrap success']")
	private WebElement successPopUpContactUs;
	
	@FindBy(css = "#orderNumber")
	private WebElement contactUsOrderID;	

	private WebDriver webDriver;
	private PageUtils pageUtils;
	private JavascriptExecutor jsExecutor;
	private Environment env;
	private Context context;
	private MkMobileHamburgerMenu mkMobileHamburgerMenu;
	private TestData testData;
	private Actions actionBuilder;
	
	@Inject
	public MkMobileHomePage(WebDriver webDriver, PageUtils pageUtils, Context context,
			Environment env, MkMobileHamburgerMenu mkMobileHamburgerMenu, TestData testData) {
		PageFactory.initElements(webDriver, this);
		this.webDriver = webDriver;
		this.pageUtils = pageUtils;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.env = env;
		this.context = context;
		this.mkMobileHamburgerMenu = mkMobileHamburgerMenu;
		this.testData = testData;
		this.actionBuilder = new Actions(webDriver);
	}

	public void clicktrackmyorderlink() {
		if (env.getCountry().equalsIgnoreCase("US")) {
			pageUtils.sleepSeconds(3, "link display");
			jsExecutor.executeScript("arguments[0].click();", mobmyaccountus);
			pageUtils.sleepSeconds(3, "link display");
			jsExecutor.executeScript("arguments[0].click();", mobtrackmyorderus);
			
		} else if (env.getCountry().equalsIgnoreCase("CA")) {
			pageUtils.sleepSeconds(3, "link display");
			jsExecutor.executeScript("arguments[0].click();", mobcustomerserviceca);
			pageUtils.sleepSeconds(3, "link display");
			jsExecutor.executeScript("arguments[0].click();", mobtrackmyorderca);
		}
		else 
		{
			pageUtils.sleepSeconds(3, "link display");
			jsExecutor.executeScript("arguments[0].click();", mobcustomerservice);
			pageUtils.sleepSeconds(3, "link display");
			jsExecutor.executeScript("arguments[0].click();", mobtrackmyordereu);

		}
	}
	

	public void clickOnFooterLink(String link) {
		mkMobileHamburgerMenu.closeHamburgerMenuIfOpen();
		pageUtils.sleepSeconds(2, "Wait for element to click");
		for (int i = 0; i < footerColumns.size(); i++) {
			if(footerColumns.get(i).getAttribute("aria-label").contains("expand") )
				pageUtils.waitForPageToLoad();
				pageUtils.waitTillWebElementIsClickable(footerColumns.get(i));
				jsExecutor.executeScript("arguments[0].click();" , footerColumns.get(i));
			pageUtils.sleepSeconds(1, "Wait for page to load");
			String footerList = "(//ul[@class='footer_links_list'])["+(i+1)+"]//li//a";
			List<WebElement> footerListLinks = webDriver.findElements(By.xpath(footerList));
			for (int j = 0; j < footerListLinks.size(); j++) {
				if(footerListLinks.get(j).getText().equalsIgnoreCase(pageUtils.getFooterLinksTranslation(link))) {
					context.saveData("Page Source", webDriver.getPageSource());
					pageUtils.waitForPageToLoad();
					pageUtils.sleepSeconds(5, "Wait for element to click");
					actionBuilder.moveToElement(footerListLinks.get(j)).build().perform();
					pageUtils.sleepSeconds(1, "Wait for element to click");
					jsExecutor.executeScript("arguments[0].click();" , footerListLinks.get(j));
					pageUtils.sleepSeconds(10, "Wait for page to load");
					pageUtils.waitForPageToLoad();
					pageUtils.sleepSeconds(1, "Wait for page to load");
					break;
				}	
			}			
		}
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
		boolean status = false;
		if(env.getCountryRegion() == Region.NA) {
			String footerList = "(//ul[@class='footer_links_list'])[3]//li//a[text()='"+ pageUtils.getFooterLinksTranslation("contact-us")+"']";
			if(footerColumns.get(2).getAttribute("aria-label").contains("expand") )
				footerColumns.get(2).click();
			pageUtils.sleepSeconds(2, "Wait for page to load");
			pageUtils.waitForAjaxToComplete();
			actionBuilder.moveToElement(webDriver.findElement(By.xpath(footerList))).build().perform();
			jsExecutor.executeScript("arguments[0].click();", webDriver.findElement(By.xpath(footerList)));
			pageUtils.sleepSeconds(5, "wait for page to load");
			jsExecutor.executeScript("arguments[0].click();", writeToUs);
			pageUtils.waitForAjaxToComplete();
			jsExecutor.executeScript("arguments[0].click();", writeNow);
			
		}else {
			String footerList = "(//ul[@class='footer_links_list'])[1]//li//a[text()='"+ pageUtils.getFooterLinksTranslation("contact-us")+"']";
			if(footerColumns.get(0).getAttribute("aria-label").contains("expand") )
				footerColumns.get(0).click();
			pageUtils.sleepSeconds(2, "Wait for page to load");
			pageUtils.waitForAjaxToComplete();
			
			actionBuilder.moveToElement(webDriver.findElement(By.xpath(footerList))).build().perform();
			jsExecutor.executeScript("arguments[0].click();", webDriver.findElement(By.xpath(footerList)));
			pageUtils.sleepSeconds(5, "wait for page to load");
			pageUtils.waitForAjaxToComplete();
			jsExecutor.executeScript("arguments[0].click();", writeNow);
		}
		fillContactUsForm();
		pageUtils.sleepSeconds(2, "Wait for page to load");
		if(pageUtils.verifyIfDisplayed(successPopUpContactUs))
			status = true;
		return status;
	}

}
