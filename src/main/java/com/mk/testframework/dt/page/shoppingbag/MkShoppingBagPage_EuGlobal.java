package com.mk.testframework.dt.page.shoppingbag;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.util.PageUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class MkShoppingBagPage_EuGlobal {

	@FindBy(css = "#quantityCartSelector option[selected='true']")
	private WebElement selectedQuantity;

	@FindBy(css = "#quantityCartSelector option[selected='true']")
	private List<WebElement> selectedQuantityList;

	@FindBy(css = ".itemUpdated")
	private WebElement itemUpdatedMessage;

	@FindBy(css = ".checkoutForm a")
	private WebElement checkout;

	@FindBy(css = "#checkoutBtnLoggedIn")
	private WebElement checkoutLoggedIn;

	@FindBy(css = "#checkoutBtnLoggedIn")
	private WebElement loggedInCheckout;

	@FindBy(css = ".klarna--onsite--messaging")
	private WebElement klarnaWidget;

	@FindBy(css = ".shopping_cart_sub_total")
	private WebElement bagSubTotalPrice;
	
	@FindBy(css = "#shopping-bag-promo")
    private WebElement promoTextFeild;

    @FindBy(css = "#orderPromotionForm .v-list button")
	private WebElement promoApplyButton;
	
	@FindBy(xpath = "(//*[@class='promocodediscounttable'])[5]")
	private WebElement appliedPromoSection;

	@FindBy(css = ".promocodediscounttable")
	private WebElement promoCodeAppliedsection;

	@FindBy(xpath = "(//ul[@class='shopping-bag-order-summary-details']/li/div)[6]")
	private WebElement promoCodeOrderSummary;

	@FindBy(xpath = "(//*[@class='shopping-bag-order-summary-totals']/li/div)[2]")
	private WebElement orderSummaryTotal;

	@FindBy(xpath = "(//*[@class='promocodediscounttable'])")
	private WebElement verifyPromotionApplied;

	@FindBy(xpath = "(//ul[@class='shopping-bag-order-summary-details'])[1]/li[3]/div[2]")
	private WebElement orderSummaryPromotion;

	@FindBy(xpath = "(//ul[@class='shopping-bag-order-summary-totals'])[1]/li/div[2]/p")
	private WebElement orderSummaryTotalPrice;

	@FindBy(css = ".shopping-bag-cart .shopping-bag-item .pull-right .h5")
	private List<WebElement> listOfProductPrice;
        
    @FindBy(css = "#shoppingCartItems .shopping-bag-item img")
    private List<WebElement> productImage;
    
    @FindBy(css = ".shopping-bag-item")
	private List<WebElement> productSection;
    
    @FindBy(css = ".shopping-bag-item .storeStyle")
    private List<WebElement> productStyle;
    
    @FindBy(css = ".shopping-bag-item__size")
    private List<WebElement> productSize;
    
    @FindBy(css = ".row--table .product-values")
    private List<WebElement> productPrice;
    
    @FindBy(css = ".quantity-container")
	private List<WebElement> productQty;
		
    @FindBy(xpath = "(//ul[@class='shopping-bag-order-summary-details'])[1]/li/div[2]")
    private WebElement orderSummarySubTotal;
    
    @FindBy(xpath = "(//*[@class='promocodediscounttable'])")
    private WebElement isPromotionApplied;
    
    @FindBy(css = ".shopping-bag-item .v-list h2")
	private List<WebElement> productName;
    
    @FindBy(css = ".shopping-bag-item__color .product-values")
    private List<WebElement> productColor;
    
    private PageUtils pageUtils;
	private JavascriptExecutor jsExecutor;
	private TestData testData;
	private Context context;
	
    @Inject
    public MkShoppingBagPage_EuGlobal(WebDriver webDriver, PageUtils pageUtils, TestData testData, Context context) {
        PageFactory.initElements(webDriver, this);
        this.pageUtils = pageUtils;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.testData = testData;
		this.context = context;
    }

	public Integer getSelectedQuantity() {
		return Integer.parseInt(selectedQuantity.getAttribute("value"));
	}

	public boolean verifyItemUpdatedMessage() {
		return itemUpdatedMessage.isDisplayed();
	}

	public void clickCheckout() {
		pageUtils.sleepSeconds(2, "wait for page load");

		try {
			loggedInCheckout.click();
		} catch (Exception e) {
			checkout.click();
		}

		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "1 sec wait for ajax load");
	}

	public void clickLoggedInCheckout() {
		jsExecutor.executeScript("arguments[0].click();", checkoutLoggedIn);
		pageUtils.sleepSeconds(2, "wait for page load");
		pageUtils.waitForPageToLoad();
	}

	public int getTotalShoppingBagCount() {
		int sum = 0;

		for (int i = 0; i < selectedQuantityList.size(); i++) {
			WebElement qty = selectedQuantityList.get(i);
			sum += Integer.parseInt(qty.getAttribute("innerText").trim());
		}
		return sum;
	}

	public boolean isKlarnaWidgetDisplayed() {
		pageUtils.waitForWebElement(klarnaWidget);
		return pageUtils.verifyIfDisplayed(klarnaWidget);
	}

	public String bagSubTotalPrice() {
		pageUtils.waitForWebElement(bagSubTotalPrice);
		String bagTotal = bagSubTotalPrice.getText();
		System.out.println(bagTotal);
		return bagTotal;
	}
       
	public boolean isPromoTextAndApplyButtonDisplayed() {
		pageUtils.sleepSeconds(5, "wait for page load");
		pageUtils.verifyIfDisplayed(promoTextFeild);
		return pageUtils.verifyIfDisplayed(promoApplyButton);
	}

	public void applyPromotion() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		promoTextFeild.sendKeys(testData.getPromotion().getcouponCode());
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "wait for page load");
		jsExecutor.executeScript("arguments[0].click();", promoApplyButton);
		pageUtils.sleepSeconds(2, "wait for page load");
	}

	public boolean verifyPromotionApplied() {
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForWebElement(verifyPromotionApplied);
		return pageUtils.verifyIfDisplayed(verifyPromotionApplied);
	}

	public double subTotalFromOrderSummary() {
		pageUtils.waitForWebElement(orderSummarySubTotal);
		pageUtils.sleepSeconds(5, "wait for page load");
		String subtotalInOrderSummary = orderSummarySubTotal.getText();
		String subtotalInOrderSummary1 = subtotalInOrderSummary.trim().replaceAll("[^0-9]", "");
		double orderSummarySuTotal = Double.parseDouble(subtotalInOrderSummary1.toString());
		return orderSummarySuTotal;
	}

	public double getTotalFromOrderSummary() {
		pageUtils.waitForWebElement(orderSummarySubTotal);
		pageUtils.sleepSeconds(5, "wait for page load");
		String getTotalInOrderSummary = orderSummaryTotalPrice.getText();
		context.saveData("OrderTotalPrice", getTotalInOrderSummary);
		context.writeOut("Total amount in Cart is: "+ getTotalInOrderSummary);
		String getOrderTotal = getTotalInOrderSummary.trim().replaceAll("[^0-9]", "");
		double getOrderTotal1 = Double.parseDouble(getOrderTotal.toString());
		return getOrderTotal1;
	}

	public double getPromotionFromOrderSummary() {
		pageUtils.waitForWebElement(orderSummaryPromotion);
		String appliedPromotionPrice = orderSummaryPromotion.getText();
		String appliedPromotionPrice1 = appliedPromotionPrice.trim().replaceAll("[^0-9]", "");
		double promoAmount = Double.parseDouble(appliedPromotionPrice1.toString());
		return promoAmount;
	}

	public boolean verify5PromoApplied() {
		pageUtils.waitForWebElement(appliedPromoSection);
		return pageUtils.verifyIfDisplayed(appliedPromoSection);

	}
	
	public boolean verifyPromoApplied(int amount, String promoType) {
		boolean flag=false;
		pageUtils.waitForWebElement(promoCodeAppliedsection);
        pageUtils.waitForWebElement(orderSummarySubTotal);
		pageUtils.scrollToElement(orderSummarySubTotal);
		if (promoType.equalsIgnoreCase("$off")) {
			String promoamount = promoCodeOrderSummary.getText();
			String getpromoamount1 = promoamount.trim().replaceAll("[^\\d\\.\\,\\s]+", "");
			String totalPrice = getpromoamount1.trim().replace(",", ".");
			double actTotalprice1 = Double.parseDouble(totalPrice);
			double expected = amount;
			if (expected == actTotalprice1) {
				flag = true;
				context.writeOut("Actal price: " + actTotalprice1 + " Expected price: " + expected);
			}
		} else if (promoType.equalsIgnoreCase("%OFF")) {
			String promoamount = promoCodeOrderSummary.getText();
			String getpromoamount1 = promoamount.trim().replaceAll("[^\\d\\.\\,\\s]+", "");
			String totalPrice = getpromoamount1.trim().replace(",", "");
			double actPromoprice = Double.parseDouble(totalPrice);

			String actualSubTotal = orderSummarySubTotal.getText();
			String orderSummarySub = actualSubTotal.trim().replaceAll("[^\\d\\.\\,\\s]+", "");
			String totalSubPrice = orderSummarySub.trim().replace(",", "");
			double actTotalSubprice = Double.parseDouble(totalSubPrice);
			double promoAmnt = amount;
			double promoAmntpercent = (promoAmnt / 100);
			double expectedPromoPrice = (actTotalSubprice * promoAmnt) / 100;
			if (actPromoprice == expectedPromoPrice) {
				flag = true;
				context.writeOut("Actal price: " + actPromoprice + " Expected price: " + expectedPromoPrice);
			}
		}
		return flag;
	}
	
	public boolean shoppingBagProductPriceCalculator() {
		boolean flag = false;
		double total = 0;
		try {
			for (int i = 0; i < listOfProductPrice.size(); i++) {
				String amount1 = listOfProductPrice.get(i).getText();
				String productPrice = amount1.trim().replaceAll("[^0-9]", "");
				total = total + Double.parseDouble(productPrice);
				context.writeOut("Total of product amount: " + total);
			}
			double actSubTotalPrice = subTotalFromOrderSummary();
			context.writeOut("Total amount from order summary: " + actSubTotalPrice);
			if (actSubTotalPrice == total) {
				flag = true;
			}
		} catch (Exception e) {

		}
		Assert.assertTrue("SubTotal value is not equal to sum of all product", true);
		return flag;

	}
    
	public boolean verifyProductNameDisplayed() {
		boolean flag=true;
		int size=productSection.size();
				for(int i=0; i<size;i++) {
				context.writeOut("Product Name: "+productName.get(i).getText());
				if(productName.get(i).toString().isBlank()&&productName.get(i).toString().isEmpty()) {
					flag = false;
				}
		}
		return flag;
	}
	
	public boolean verifyProductPriceDisplayed() {
		boolean flag=true;
		int size=productSection.size();
				for(int i=0; i<size;i++) {
				productPrice.get(i).getText();
				context.writeOut("Product Price: "+productPrice.get(i).getText());
				if(productName.get(i).toString().isBlank()&&productName.get(i).toString().isEmpty()) {
					flag = false;
				}
			}
		return flag;
	}
	
	public boolean verifyProductStyleDisplayed() {
		boolean flag=true;
		int size=productSection.size();

			for(int i=0; i<size;i++) {
				productStyle.get(i).getText();
				context.writeOut("Product Style is: "+productStyle.get(i).getText());
				if(productStyle.get(i).toString().isBlank()&&productStyle.get(i).toString().isEmpty()) {
					flag = false;
				}
			}
		
		return flag;
	}
	
	public boolean verifyProductImageDisplayed() {
		boolean flag=true;
		int size=productSection.size();
		
			for(int i=0; i<size;i++) {
				productImage.get(i).getText();
				context.writeOut("Product Image URL: "+productImage.get(i).getAttribute("src"));
				if(productImage.get(i).getAttribute("src").isBlank()&&productImage.get(i).getAttribute("src").isEmpty()) {
					flag = false;
				}
			}
		
		return flag;
	}
	
	public boolean verifyProductColorDisplayed() {
		boolean flag=true;
		int size=productSection.size();
		
			for(int i=0; i<size;i++) {
				productColor.get(i).getText();
				context.writeOut("Product Color :"+productColor.get(i).getText());
				if(productColor.get(i).toString().isBlank()&&productColor.get(i).toString().isEmpty()) {
					flag = false;
				}
			}
		
		return flag;
	}
	
	public boolean verifyProductQtyDisplayed() {
		boolean flag=true;
		int size=productSection.size();
			for(int i=0; i<size;i++) {
				selectedQuantityList.get(i).getText();
				context.writeOut("Product Qty :"+selectedQuantityList.get(i).getAttribute("innerText").trim());
				if(selectedQuantityList.get(i).toString().isBlank()&&selectedQuantityList.get(i).toString().isEmpty()) {
					flag = false;
				}
			}
		
		return flag;
	}
	
	public boolean verifyProductSizeDisplayed() {
		boolean flag=true;
		if (productSize.isEmpty()) {
			context.writeOut("This is not an sized item hence skipping the step");
		} else {
			int size = productSize.size();
			for (int i = 0; i < size; i++) {
				productSize.get(i).getText();
				context.writeOut("Product Size :" + productSize.get(i).getText());
				if (productSize.get(i).toString().isBlank() && productSize.get(i).toString().isEmpty()) {
					flag = false;
				}
			}
		}
		return flag;
	}
}
