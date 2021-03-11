package com.mk.testframework.dt.mobile;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
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
public class MkMobileCheckoutPage_EU {

	@FindBy(css = ".checkout-pph")
	private WebElement checkoutPage;
	
	@FindBy(xpath = "((//*[@class='v-list--sm'])[2]/div/div)/following-sibling :: div/p")
	private List<WebElement> orderSummary;
	
	@FindBy(xpath ="(//*[@class='shopping-bag-order-summary-totals'])[1]/li/div[2]/p")
	private WebElement orderTotalAmount;
	
	@FindBy(xpath = "(//a[@class='btn btn-primary full-width collapsed ladda-button kor-button translate'])")
	private WebElement clickPlaceOrderButton;
	
	@FindBy(xpath = "(//*[@id='billing-summary'])[1]/div/div/div[2]/p[3]")
	private WebElement secondPaymentText_EU;
	
	@FindBy(xpath = "(//*[@id='billing-summary'])[1]/div/div/div[2]/p[2]")
	private WebElement firstPaymentTextFor_EU;
	
	@FindBy(xpath = "(//a[@class = 'orderSummaryToggle link--block collapsed'])")
	private WebElement clickViewDetails;

	@FindBy(xpath = " (//*[contains(@class, 'edit_shopping_bag')])[1]")
	private WebElement editShoppingBag;
	
	@FindBy(css = ".updateorderFinal .orderSummaryDetails .shopping-bag-order-summary-totals .text-right p")
	private WebElement getOrderTotal;
	
	@FindBy(css = ".updateorderFinal .shopping-bag-box__summary-items .shopping-bag-item .ordersummary_text .itemCustomizedSpec")
	private List<WebElement> verifyCustomProductInSummary;
	
	@FindBy(xpath = "(//ul[@class='shopping-bag-order-summary-totals'])/li/div[2]/p")
	private WebElement orderSummaryTotalPrice_Mobile;
	
	@FindBy(xpath = "(//*[contains(@class,'total_order_summary total_label')]//..//following-sibling::div)[1]//span")
	private WebElement orderTotal;
	
	private Context context;
	private PageUtils pageUtils;
	private WebDriver webDriver;
	private JavascriptExecutor jsExecutor;

	@Inject
	public MkMobileCheckoutPage_EU(WebDriver webDriver, PageUtils pageUtils, Context context) {
		PageFactory.initElements(webDriver, this);
		this.webDriver = webDriver;
		this.pageUtils = pageUtils;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.context = context;
	}

	public boolean onCheckoutPage() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(2, "wait for page load");
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForWebElement(checkoutPage);
		return pageUtils.verifyIfDisplayed(checkoutPage);
	}
	
	 public void editShoppingBag() {
		   pageUtils.verifyIfDisplayed(editShoppingBag);
		   pageUtils.sleepSeconds(5, "wait for promo conatiner");
		   pageUtils.waitForPageToLoad();
		
	}

	public boolean isOrderSummaryPricingDetailsDisplayed() throws Exception {
		boolean flag = false;
		pageUtils.sleepSeconds(10, "Wait for page to load");
		context.writeOut("Getting order summary details");
		String itemSubtotal = (orderSummary.get(0).getText()).toString().trim().replaceAll("[^\\d\\s]+", "")
				.trim().replace(",", "");
		String shipping = (orderSummary.get(1).getText()).toString().trim().replaceAll("[^\\d\\s]+", "").trim()
				.replace(",", "");
		String giftWrap = (orderSummary.get(2).getText()).toString().trim().replaceAll("[^\\d\\s]+", "").trim()
				.replace(",", "");
		String promotion = (orderSummary.get(3).getText()).toString().trim().replaceAll("[^\\d\\s]+", "").trim()
				.replace(",", "");
		String orderTotal = (orderTotalAmount.getText()).toString().trim().replaceAll("[^\\d\\s]+", "").trim()
				.replace(",", "");
		double itemTotalPrice = Double.parseDouble(itemSubtotal);
		double shippingAmount = Double.parseDouble(shipping);
		double giftWrapPrice = Double.parseDouble(giftWrap);
		double promotionPrice = Double.parseDouble(promotion);
		double orderTotalPrice = Double.parseDouble(orderTotal);
		double sum = (itemTotalPrice + shippingAmount + giftWrapPrice) - promotionPrice;
		context.writeOut("Item Subtotal: " + itemSubtotal);
		context.writeOut("Shipping: " + shipping);
		context.writeOut("Gift Wrap: " + giftWrap);
		context.writeOut("Promotion: " + promotion);
		context.writeOut("Order Total: " + orderTotal);

		if (sum == orderTotalPrice) {
			flag = true;
			System.out.println("Order total is: " + orderTotalPrice + " Sum of all the prices is: " + sum);
		}
		return flag;
	}

	public String getGiftWrapAmount() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "Wait for page to load");
		String locator = "(//div[contains(@class,'priceList')])[1]//p[contains(text(),'"
				+ pageUtils.getTextTranslation("gift-wrap") + "')]//..//following-sibling::div//span";
		return webDriver.findElement(By.xpath(locator)).getText().trim();
	}
	
	public void clickOnpalceOrderButton() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.scrollToElement(clickPlaceOrderButton);
		pageUtils.waitTillWebElementIsClickable(clickPlaceOrderButton);
		jsExecutor.executeScript("arguments[0].click();", clickPlaceOrderButton);
		pageUtils.sleepSeconds(5, "wait for page load");
	}
	
	public void clickOnViewFullDetails() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "wait for page load");
		jsExecutor.executeScript("arguments[0].click();", clickViewDetails);
	}
	
	public boolean isShippingChargesInOrderSummaryMatchesAccordingToShippingMethod(){
		String shipping = (orderSummary.get(1).getText()).toString().trim().replaceAll("[^\\d\\.\\,\\s]+","").trim().replace(",", "");
		context.writeOut("Shipping: "+shipping);
		String expectedShippingCharge = context.getSavedData("shippingChargeText");
		if (expectedShippingCharge.equals(shipping)) {
			return true;
		}
		return false;
	}

	public double getOrderTotalFromOrderSummary_Confirmation() {
		pageUtils.waitForWebElement(getOrderTotal);
		pageUtils.sleepSeconds(5, "wait for page load");
		String subtotalInOrderSummary = getOrderTotal.getText();
		String subtotalInOrderSummary1 = subtotalInOrderSummary.trim().replaceAll("[^0-9]", "");
		double orderSummarySuTotal = Double.parseDouble(subtotalInOrderSummary1.toString());
		return orderSummarySuTotal;
	}

	public boolean verifyCustomaProductInOrderSummary() {
		pageUtils.waitForPageToLoad();
		boolean flag = false;
		int CustomProducts = verifyCustomProductInSummary.size();
		if (CustomProducts > 1)
			flag = true;
		return flag;
	}

	public boolean isSecondPaymentDisplayed_EU() {
		String getPaymentName = secondPaymentText_EU.getAttribute("innerText");
		context.writeOut("payment method is: " + getPaymentName);
		pageUtils.sleepSeconds(5, "wait for page load");
		return pageUtils.verifyIfDisplayed(secondPaymentText_EU);
	}

	public boolean isFirstlPaymentDisplayed_EU() {
		String getPaymentName = firstPaymentTextFor_EU.getAttribute("innerText");
		context.writeOut("payment method is: " + getPaymentName);
		return pageUtils.verifyIfDisplayed(firstPaymentTextFor_EU);
	}

	public double getTotalFromOrderSummary_billing() {
		pageUtils.waitForWebElement(orderSummaryTotalPrice_Mobile);
		pageUtils.sleepSeconds(5, "wait for page load");
		String getTotalInOrderSummary = orderSummaryTotalPrice_Mobile.getText();
		String getOrderTotal = getTotalInOrderSummary.trim().replaceAll("[^0-9]", "");
		context.writeOut("Total maount in Billing page is: " + getOrderTotal);
		context.saveData("OrderTotal", getOrderTotal);
		double getOrderTotal1 = Double.parseDouble(getOrderTotal.toString());
		return getOrderTotal1;
	}
	
	public boolean isOrderTotalZero() {
		boolean flag = false;
		pageUtils.sleepSeconds(5, "wait for page to load");
		if(orderTotal.getText().trim().contains(pageUtils.getTextTranslation("zero-order-total")))
			flag = true;
		return flag;	
	}
			
}
