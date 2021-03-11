package com.mk.testframework.dt.page.checkout;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.util.PageUtils;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author MLinderman
 *
 */

public class MkCheckoutPage_NA {

	@FindBy(css = ".rfk_wbh")
	private WebElement checkoutPage;
	
	@FindBy(css = "#order-summary .product-values span")
	private List<WebElement> orderSummary;

	
	private PageUtils pageUtils;
	private Context context;
	private Environment env;

	@Inject
	public MkCheckoutPage_NA(WebDriver webDriver, PageUtils pageUtils, Context context, Environment env) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.context = context;
		this.env = env;
	}

	public boolean onCheckoutPage() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(2, "wait for page load");
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForWebElement(checkoutPage);
		return pageUtils.verifyIfDisplayed(checkoutPage);
	}
	
	public boolean isOrderSummaryPricingDetailsDisplayed() throws Exception {
		boolean flag = false;
		String contry = env.getCurrentLocale().getCountry();
		String locale = env.getLanguage();
		double sum = 0.0;
		double orderTotal = 0.0;
		if(contry.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("fr")) {
			double itemSubtotal=Double.parseDouble((orderSummary.get(0).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", ""));
			double shipping = Double.parseDouble((orderSummary.get(1).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", ""));
			double tax1 = Double.parseDouble((orderSummary.get(2).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", ""));
			double tax2 = Double.parseDouble((orderSummary.get(3).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", ""));
			double giftWrap=Double.parseDouble((orderSummary.get(4).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", ""));
			orderTotal = Double.parseDouble((orderSummary.get(5).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", ""));
			sum=(itemSubtotal+shipping+tax1+tax2+giftWrap);
			context.writeOut("itemSubtotal: "+itemSubtotal);
			context.writeOut("shipping: "+shipping);
			context.writeOut("tax: "+tax1+" "+tax2 );
			context.writeOut("giftWrap: "+giftWrap);
			context.writeOut("orderTotal: "+orderTotal);
		}else if(contry.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("en")) {
			double itemSubtotal=Double.parseDouble((orderSummary.get(0).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", ""));
			double shipping = Double.parseDouble((orderSummary.get(1).getText()).toString().trim().replaceAll("[^\\d\\s]+","").trim().replace(",", ""));
			double tax1 = Double.parseDouble((orderSummary.get(2).getText()).toString().trim().replaceAll("[^[^\\d\\s]+","").trim().replace(",", ""));
			double tax2 = Double.parseDouble((orderSummary.get(3).getText()).toString().trim().replaceAll("[^[^\\d\\s]+","").trim().replace(",", ""));
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
	
	public boolean isShippingChargesInOrderSummaryMatchesAccordingToShippingMethod(){
		boolean flag = false;
		String shipping;
		String contry = env.getCurrentLocale().getCountry();
		String locale = env.getLanguage();
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

}
