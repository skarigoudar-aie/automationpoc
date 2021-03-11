package com.mk.testframework.dt.page.checkout;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.util.PageUtils;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author MLinderman
 *
 */
public class MkCheckoutPage_EU {
	@FindBy(css = ".rfk_wbh")
	private WebElement checkoutPage;
	
	@FindBy(xpath = "((//*[@class='v-list--sm'])[6]/div/div)/following-sibling :: div/p")
	private List<WebElement> orderSummarySectionShipping;
	
	@FindBy(xpath ="(//*[@class='shopping-bag-order-summary-totals'])[3]/li/div[2]/p")
	private WebElement orderTotalAmount;
	
	private PageUtils pageUtils;
	private Context context;

	@Inject
	public MkCheckoutPage_EU(WebDriver webDriver, PageUtils pageUtils, Context context) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.context = context;
	}

	public boolean onCheckoutPage() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "wait for page load");
		pageUtils.waitForWebElement(checkoutPage);
		return pageUtils.verifyIfDisplayed(checkoutPage);
	}
	
	public boolean isOrderSummaryPricingDetailsDisplayed() throws Exception {
		boolean flag = false;
		
		String itemSubtotal=(orderSummarySectionShipping.get(0).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", "");
		String shipping = (orderSummarySectionShipping.get(1).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", "");
		String giftWrap=(orderSummarySectionShipping.get(2).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", "");
		String promotion=(orderSummarySectionShipping.get(3).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", "");
		String orderTotal =(orderTotalAmount.getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", "");
		double itemTotalPrice=Double.parseDouble(itemSubtotal);
		
		double shippingAmount=Double.parseDouble(shipping);
		double giftWrapPrice=Double.parseDouble(giftWrap);
		double promotionPrice=Double.parseDouble(promotion);
		double orderTotalPrice = Double.parseDouble(orderTotal);
		double sum=(itemTotalPrice+shippingAmount+giftWrapPrice)-promotionPrice;
		context.writeOut("Item Subtotal: "+itemSubtotal);
		context.writeOut("Shipping: "+shipping);
		context.writeOut("Gift Wrap: "+giftWrap);
		context.writeOut("Promotion: "+promotion);
		context.writeOut("Order Total: "+orderTotal);
		
		if(sum==orderTotalPrice) {
			flag = true;
			System.out.println("Order total is: "+orderTotalPrice+" Sum of all the prices is: "+sum);
		}
		return flag;
	}
	
	public boolean isShippingChargesInOrderSummaryMatchesAccordingToShippingMethod(){
		String shipping = (orderSummarySectionShipping.get(1).getText()).toString().trim().replaceAll("[^\\d\\.\\,\\s]+","").trim().replace(",", "");
		context.writeOut("Shipping: "+shipping);
		String expectedShippingCharge = context.getSavedData("shippingChargeText");
		if (expectedShippingCharge.equals(shipping)) {
			return true;
		}
		return false;
	}
}
