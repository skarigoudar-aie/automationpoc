package com.mk.testframework.dt.mobile;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.util.PageUtils;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author MLinderman
 *
 */
public class MkMobileCheckoutPage_NA {
	@FindBy(css = ".checkout-pph")
	private WebElement checkoutPage;
	
	@FindBy(css = "#order-summary .product-values span")
	private List<WebElement> orderSummary;
	
	@FindBy(xpath = "//a[@id='paypalcustmobileimage']")
	private WebElement continueToPaypalButton;
	
	@FindBy(xpath = "(//*[@class='padded-box'])[3]/div/div[2]/a")
	private WebElement editPaymentLink;
	
	@FindBy(css = ".order-summary__prices-toggle")
	private WebElement expandShoppingBagItemSection;
	
	@FindBy(css = ".order-summary .row--table a")
	private WebElement editShoppingBagLink;
	
	@FindBy(css = "#order-summary ul li p span")
	private WebElement getItemSubTotal;

	@FindBy(xpath = "//div[@class='order-summary__prices-toggle']")
	private WebElement orderSummaryToggleLink;

	@FindBy(css = ".order-summary a")
	private WebElement orderSummarylink;
	
	@FindBy(xpath = "//*[@id='billingPromotion']/..")
	private WebElement promoLink;
	
	@FindBy(xpath = "(//*[@id='shopping-bag-promo'])[2]")
	private WebElement promoCodeContainer;
	
	@FindBy(xpath = "(//*[@id='claimCode'])[2]")
	private WebElement applyPromo;
	
	@FindBy(xpath = "(//*[@id='totalOrderSummary']//div[contains(@class, 'js-orderSummary')])[2]")
	private WebElement orderSummaryExpanded;
	
	@FindBy(xpath = "//*[@class ='col-md-12 order-summary-items-count']/div/span[2]")
	private WebElement getTotalPrice;
	
	@FindBy(xpath = "//div[contains(@class,'order-summary-items-count')]//../span[2]")
	private WebElement orderTotal;
	
	@FindBy(xpath = "//*[@class ='col-md-12 order-summary-items-count']/div/span[2]")
	private WebElement getTotalPriceOnBilling;
	
	@FindBy(css = "#order-summary ul li .p--no-margin span")
	private WebElement getTotalPriceOnConfirmation;
		
	private PageUtils pageUtils;
	private JavascriptExecutor jsExecutor;
	private Environment env;
	private WebDriver webDriver;
	private Context context;

	@Inject
	public MkMobileCheckoutPage_NA(WebDriver webDriver,Environment env, PageUtils pageUtils, Context context) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.env = env;
		this.webDriver = webDriver;
		this.context = context;
	}

	public boolean onCheckoutPage() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForWebElement(checkoutPage);
		return pageUtils.verifyIfDisplayed(checkoutPage);
	}
	
	public void expandOrderSummary() {
		try {
			Boolean status=Boolean.valueOf(orderSummarylink.getAttribute("aria-expanded"));
			if(!status) {
				pageUtils.sleepSeconds(5, "Given wait time to load order summary");
				pageUtils.waitForPageToLoad();
				orderSummarylink.click();
				pageUtils.waitForAjaxToComplete();
			}
			
		} catch (Exception e) {
			System.out.println("Exception : "+ e);
		}
	}
		
	public void enterPromoCode(String promocode) {
		pageUtils.sleepSeconds(5, "Wait for promo field to display");
		promoCodeContainer.sendKeys(promocode);
		pageUtils.sleepSeconds(5, "wait for promo to be applied");
	}
	
	public void clickOnApplyPromo() { 
	    applyPromo.click();
	}

	public void clickOnOrderSummary() {
		pageUtils.waitForWebElement(orderSummaryToggleLink);
		pageUtils.scrollToElement(orderSummaryToggleLink);
		jsExecutor.executeScript("arguments[0].click();", orderSummaryToggleLink);
		pageUtils.sleepSeconds(10, "");
	}
	

	public boolean isShippingChargesInOrderSummaryMatchesAccordingToShippingMethod(){
		boolean flag = false;
		String shipping;
		String contry = env.getCurrentLocale().getCountry();
		String locale = env.getLanguage();
		pageUtils.waitForWebElement(orderSummaryToggleLink);
		pageUtils.scrollToElement(orderSummaryToggleLink);
		pageUtils.sleepSeconds(10, "");

		orderSummaryToggleLink.click();
		pageUtils.sleepSeconds(10, "");
		String expectedShippingCharge = context.getSavedData("shippingChargeText");
		if(contry.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("fr")) {
			shipping = orderSummary.get(1).getText().toString().trim().replaceAll("[^\\d\\.\\,\\s]+","").trim().replace(",", ".");
			context.writeOut("shipping: "+shipping);
			
		}else if(contry.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("en")) {
			shipping = orderSummary.get(1).getText().toString().trim().replaceAll("[^\\d\\.\\,\\s]+","").trim().replace(",", "");
			context.writeOut("shipping: "+shipping);
		} else {
			shipping = orderSummary.get(1).getText().toString().trim().replaceAll("[^\\d\\.\\,\\s]+","").trim().replace(",", "");
			context.writeOut("shipping: "+shipping);
		}
		if (expectedShippingCharge.equals(shipping)) {
			flag = true;
		}
		return flag;
	}
	
public boolean isOrderSummaryPricingDetailsDisplayed() throws Exception {
	boolean flag = false;
	String contry = env.getCurrentLocale().getCountry();
	String locale = env.getLanguage();
	pageUtils.waitForWebElement(orderSummaryToggleLink);
	pageUtils.scrollToElement(orderSummaryToggleLink);
	pageUtils.sleepSeconds(10, "");
	orderSummaryToggleLink.click();
	pageUtils.sleepSeconds(10, "");
		double sum = 0.0;
		double orderTotal = 0.0;
		if(contry.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("fr")) {
			double itemSubtotal=Double.parseDouble((orderSummary.get(0).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", "."));
			double shipping = Double.parseDouble((orderSummary.get(1).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", "."));
			double tax1 = Double.parseDouble((orderSummary.get(2).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", "."));
			double tax2 = Double.parseDouble((orderSummary.get(3).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", "."));
			double giftWrap=Double.parseDouble((orderSummary.get(4).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", "."));
			orderTotal = Double.parseDouble((orderSummary.get(5).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", "."));
			sum=(itemSubtotal+shipping+tax1+tax2+giftWrap);
			context.writeOut("itemSubtotal: "+itemSubtotal);
			context.writeOut("shipping: "+shipping);
			context.writeOut("tax: "+tax1+" "+tax2 );
			context.writeOut("giftWrap: "+giftWrap);
			context.writeOut("orderTotal: "+orderTotal);
		}else if(contry.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("en")) {
			double itemSubtotal=Double.parseDouble((orderSummary.get(0).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", ""));
			double shipping = Double.parseDouble((orderSummary.get(1).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", ""));
			double tax1 = Double.parseDouble((orderSummary.get(2).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", ""));
			double tax2 = Double.parseDouble((orderSummary.get(3).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", ""));
			double giftWrap=Double.parseDouble((orderSummary.get(4).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", ""));
			orderTotal = Double.parseDouble((orderSummary.get(5).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", ""));
			sum=(itemSubtotal+shipping+tax1+tax2+giftWrap);
			context.writeOut("itemSubtotal: "+itemSubtotal);
			context.writeOut("shipping: "+shipping);
			context.writeOut("tax: "+tax1+" "+tax2);
			context.writeOut("giftWrap: "+giftWrap);
			context.writeOut("orderTotal: "+orderTotal);
		}else {
		
		double itemSubtotal=Double.parseDouble((orderSummary.get(0).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", ""));
		double shipping = Double.parseDouble((orderSummary.get(1).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", ""));
		double tax = Double.parseDouble((orderSummary.get(2).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", ""));
		double giftWrap=Double.parseDouble((orderSummary.get(3).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", ""));
		orderTotal = Double.parseDouble((orderSummary.get(4).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", ""));
		sum=(itemSubtotal+shipping+tax+giftWrap);
		context.writeOut("itemSubtotal: "+itemSubtotal);
		context.writeOut("shipping: "+shipping);
		context.writeOut("tax: "+tax);
		context.writeOut("giftWrap: "+giftWrap);
		context.writeOut("orderTotal: "+orderTotal);
		}
		if(sum==orderTotal) {
			flag = true;
			System.out.println("Order total is: "+orderTotal+" Sum of all the prices is: "+sum);
		}
		return flag;
	}

	public void clickOnPromoCodeLink() {
		try {
			pageUtils.sleepSeconds(10, "Wait for promo code panel");
			promoLink.click();
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
	}
		
	public String getGiftWrapAmountBeforePromoApplied(){
		String gWAmount;
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "Wait for page to load");
		expandOrderSummary();
		pageUtils.waitForAjaxToComplete();
		if(env.getCurrentLocale().toString().equals("en_US")) {
			String locator = "//span[contains(@class,'total')]//ancestor::ul//li[4]//span";	
			gWAmount = webDriver.findElement(By.xpath(locator)).getText();
		}else {
			String locator = "//span[contains(@class,'total')]//ancestor::ul//li[5]//span";	
			gWAmount = webDriver.findElement(By.xpath(locator)).getText();
		}
		return gWAmount;
	}
	
	public String getGiftWrapAmountAfterPromoApplied(){
		String gWAmount;
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "Wait for page to load");
		expandOrderSummary();
		pageUtils.waitForAjaxToComplete();
		if(env.getCurrentLocale().toString().equals("en_US")) {
			String locator = "//span[contains(@class,'total')]//ancestor::ul//li[5]//span";	
			gWAmount = webDriver.findElement(By.xpath(locator)).getText();
		}else {
			String locator = "//span[contains(@class,'total')]//ancestor::ul//li[6]//span";	
			gWAmount = webDriver.findElement(By.xpath(locator)).getText();
		}
		return gWAmount;
	}
	
	public void continueWithPaypalButton() {
		pageUtils.sleepSeconds(5, "wait for page load");
		pageUtils.waitForPageToLoad();
		pageUtils.scrollToElement(continueToPaypalButton);
		pageUtils.waitTillWebElementIsClickable(continueToPaypalButton);
		jsExecutor.executeScript("arguments[0].click();", continueToPaypalButton);
	}

	public void clickOnEditPaymentLink() {
		pageUtils.waitForPageToLoad();
		pageUtils.scrollToElement(editPaymentLink);
		pageUtils.waitForWebElement(editPaymentLink);
		jsExecutor.executeScript("arguments[0].click();", editPaymentLink);
		pageUtils.waitForAjaxToComplete();
	}

	public String getBagTotal() {
		pageUtils.waitForWebElement(getTotalPrice);
		pageUtils.sleepSeconds(7, "wait for page load");
		String getBagTotalPrice1 = getTotalPrice.getText();
		System.out.println(getBagTotalPrice1);
		String getBagTotalPrice2 = getBagTotalPrice1.trim().replaceAll("[^0-9]", "");
		String totalPrice = getBagTotalPrice2.trim().replace(",", "");
		context.saveData("totalPrice", totalPrice);
		context.writeOut("Total price on Billing page is: " + totalPrice);
		return totalPrice;

	}
	
	public String getBagTotal_Billing() {
		pageUtils.waitForWebElement(getTotalPriceOnBilling);
		pageUtils.sleepSeconds(7, "wait for page load");
		String getBagTotalPrice1 = getTotalPriceOnBilling.getText();
		System.out.println(getBagTotalPrice1);
		String getBagTotalPrice2 = getBagTotalPrice1.trim().replaceAll("[^0-9]", "");
		String totalPrice = getBagTotalPrice2.trim().replace(",", "");
		context.saveData("totalPrice", totalPrice);
		context.writeOut("Total price on Billing page is: " + totalPrice);
		return totalPrice;
	}

	public boolean isOrderTotalZero() {
		boolean flag = false;
		pageUtils.sleepSeconds(5, "wait for page to load");
		if(orderTotal.getText().trim().contains(pageUtils.getTextTranslation("zero-order-total")))
			flag = true;		
		return flag;			

	}
	
	public double getBagTotal_Confirmation() {
		pageUtils.waitForWebElement(getTotalPriceOnConfirmation);
		pageUtils.sleepSeconds(7, "wait for page load");
		String getBagTotalPrice1 = getTotalPriceOnConfirmation.getText();
		System.out.println(getBagTotalPrice1);
		String getBagTotalPrice2 = getBagTotalPrice1.trim().replaceAll("[^0-9]", "");
		String totalPrice = getBagTotalPrice2.trim().replace(",", "");
		double getTotalAmountonConfirmation = Double.parseDouble(totalPrice.toString());
		context.writeOut("Total price on Billing page is: " + getTotalAmountonConfirmation);
		return getTotalAmountonConfirmation;
	}

	public void clickOnEDitShoppingBagLink() {
		pageUtils.waitForPageToLoad();
		jsExecutor.executeScript("arguments[0].click();", editShoppingBagLink);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();

	}

	public String getItemSubTotalAmount() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "wait for page load");
		expandShoppingBagItemSection.click();
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		String getTotalAmount1 = getItemSubTotal.getText();
		String getTotalAmount = getTotalAmount1.trim().replaceAll("[^0-9]", "");
		context.saveData("OrderTotalBeforeEditCArt", getTotalAmount);
		return getTotalAmount;
	}
}
