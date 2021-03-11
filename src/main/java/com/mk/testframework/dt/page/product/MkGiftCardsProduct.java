package com.mk.testframework.dt.page.product;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.page.shoppingbag.MkShoppingBagPage_Common;
import com.mk.testframework.dt.util.PageUtils;

public class MkGiftCardsProduct {
	
	@FindBy(css = ".grid-options .grid-deselected label")
	private List<WebElement> productAmountList;
	
	@FindBy(css = ".Select-value")
    private WebElement clickOnsendBy;
	
	@FindBy(css = "#react-select-2--value-item")
    private WebElement getGiftCardText;
	
	@FindBy(xpath = "//button[@name='add-to-cart']")
	private WebElement addGcToCart;
	
	@FindBy(css = "#from")
    private WebElement fromName;
	
	@FindBy(css = "#to")
    private WebElement recipientName;
	
	@FindBy(css = "#recipientsEmail")
    private WebElement recipientEmail;
	
	@FindBy(css = "#recipientsEmailConfirmation")
    private WebElement recipientConfirmEmail;
	
	@FindBy(css = "#sendby")
	private WebElement selectGC_NA;
	
	 @FindBy(css = "#sendby option")
	 private WebElement getGcOption_NA;
	 
	 @FindBy(css = ".cart-counter")
	 private WebElement populatedBagCounter;
	 
	 @FindBy(xpath = "//button[@data-id='send_by_dropdown']")
	 private WebElement clickOnSendBy;
	 
	 @FindBy(xpath = "//ul[@class='dropdown-menu inner']/li[2]/a")
	 private WebElement selectPgc_EU;
	 
	 @FindBy(css = "#continue-gift-card-edit")
	 private WebElement clcikOnContinue;
	 
	 @FindBy(css = ".giftCardUpdated")
	 private WebElement giftCardUpdatedMsg;
	 
	private PageUtils pageUtils;
	private JavascriptExecutor jsExecutor;
	private WebDriver webDriver;
	private TestData testData;
	private MkHamburgerMenu mkHamburgerMenu;
	private MkShoppingBagPage_Common mkShoppingBagPage_Common;
	 
    @Inject
    public MkGiftCardsProduct(WebDriver webDriver, PageUtils pageUtils,TestData testData, MkHamburgerMenu mkHamburgerMenu,MkShoppingBagPage_Common mkShoppingBagPage_Common){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        this.pageUtils = pageUtils;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.testData = testData;
		this.mkHamburgerMenu = mkHamburgerMenu;
		this.mkShoppingBagPage_Common = mkShoppingBagPage_Common;
    }

	public void selectVgcAndPgcAmount(String giftCardAmount) {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(2, "wait");
		String giftCardAmount1 = pageUtils.getTGiftcards(giftCardAmount);
		System.out.println(giftCardAmount1);
		webDriver.findElement(By.xpath("//label[@for='grid-element-" + giftCardAmount1 + "']")).click();
	}
    
	public void enterFromName(String text) {
		pageUtils.waitForWebElement(fromName);
		fromName.sendKeys(text);
	}

	public void enterToName(String text) {
		pageUtils.waitForWebElement(recipientName);
		recipientName.sendKeys(text);
	}

	public void enterRecipientEmail(String text) {
		pageUtils.waitForWebElement(recipientEmail);
		recipientEmail.sendKeys(text);
	}

	public void enterRecipientConfirmEmail(String text) {
		pageUtils.waitForWebElement(recipientConfirmEmail);
		recipientConfirmEmail.sendKeys(text);
	}

	public boolean verifyGiftCardUpdatedMessage() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "wait");
		return giftCardUpdatedMsg.isDisplayed();
	}

	public void addGiftCard_EU(String text) {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(2, "wait");
		if (text.equalsIgnoreCase("pgc")) {
			enterFromName(testData.getUser().getFirstname());
			enterToName(testData.getUser().getLastname());
			pageUtils.sleepSeconds(2, "wait");
			testData.createRandomEmail();
			String email = testData.getRandomEmail();
			enterRecipientEmail(email);
			enterRecipientConfirmEmail(email);
			pageUtils.sleepSeconds(2, "wait");
			jsExecutor.executeScript("arguments[0].click();", addGcToCart);

			mkHamburgerMenu.shoppingBagHasItems();
			mkHamburgerMenu.clickShoppingBagIcon();
			mkShoppingBagPage_Common.clickEditLink();
			pageUtils.waitForPageToLoad();
			pageUtils.sleepSeconds(2, "wait");
			jsExecutor.executeScript("arguments[0].click();", clickOnSendBy);
			
			if (clickOnSendBy.getAttribute("aria-expanded").equalsIgnoreCase("true")) {
				selectPgc_EU.click();
				pageUtils.sleepSeconds(2, "wait");
				jsExecutor.executeScript("arguments[0].click();", clcikOnContinue);
				verifyGiftCardUpdatedMessage();
			}

		} else {
			enterFromName(testData.getUser().getFirstname());
			enterToName(testData.getUser().getLastname());
			pageUtils.sleepSeconds(2, "wait");
			testData.createRandomEmail();
			String email = testData.getRandomEmail();
			enterRecipientEmail(email);
			enterRecipientConfirmEmail(email);
			pageUtils.sleepSeconds(2, "wait");
			jsExecutor.executeScript("arguments[0].click();", addGcToCart);
		}
	}

	public void addGiftCard_NA(String text) {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(2, "wait");
		if (text.equalsIgnoreCase("pgc")) {
			Select sel = new Select(selectGC_NA);
			sel.selectByValue("mail");
			pageUtils.sleepSeconds(2, "wait");
			jsExecutor.executeScript("arguments[0].click();", addGcToCart);
			pageUtils.sleepSeconds(2, "wait");

		} else {
			enterFromName(testData.getUser().getFirstname());
			enterToName(testData.getUser().getLastname());
			pageUtils.sleepSeconds(2, "wait");
			testData.createRandomEmail();
			String email = testData.getRandomEmail();
			enterRecipientEmail(email);
			enterRecipientConfirmEmail(email);
			pageUtils.sleepSeconds(2, "wait");
			jsExecutor.executeScript("arguments[0].click();", addGcToCart);
		}

	}

}
