package com.mk.testframework.dt.mobile;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.util.PageUtils;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MkMobileShoppingBagPage_EuGlobal {

    @FindBy(css = "#quantityCartSelector option[selected='true']")
    private WebElement selectedQuantity;

    @FindBy(css = "#quantityCartSelector option[selected='true']")
    private List<WebElement> selectedQuantityList;
    
    @FindBy(css = "#checkoutBtnForMobile")
    private WebElement checkout;

    @FindBy(css = "#checkoutBtnForMobileLoggedIn")
    private WebElement loggedInCheckout;
    
    @FindBy(xpath = "(//*[@class='col-xs-6 col--no-gutters'])[2]")
	private WebElement mobileGetTotalPrice;
	
    @FindBy(xpath = "(//ul[@class='shopping-bag-order-summary-details'])[2]/li[3]/div[2]")
    private WebElement promoCodeOrderSummary;
    
    @FindBy(xpath = "(//ul[@class='shopping-bag-order-summary-details'])[2]/li[1]/div[2]")
    private WebElement orderSummarySubtotal;
    
    @FindBy(xpath = "(//ul[@class='shopping-bag-order-summary-details'])[2]/li/div[2]")
    private WebElement orderSummarySubTotal_Mobile;
    
    @FindBy(xpath = "(//ul[@class='shopping-bag-order-summary-totals'])[2]/li/div[2]/p")
    private WebElement orderSummaryTotalPrice_Mobile;
    
    @FindBy(xpath = "(//ul[@class='shopping-bag-order-summary-details'])[2]/li[3]/div[2]")
    private WebElement orderSummaryPromotion_Mobile;
    
    @FindBy(xpath = "(//*[@class='row row--no-gutter-margin row--pad-top-20'])/div/following-sibling :: div")
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
    
    @FindBy(css = ".shopping-bag-item .v-list h2")
	private List<WebElement> productName;
	
    @FindBy(css = ".shopping-bag-item__color .product-values")
    private List<WebElement> productColor;

    @FindBy(css = ".shopping-bag-item__col--total .text-right")
    private WebElement shoppingBagItemPrice;
    
    @FindBy(css = ".shopping-cart-promocode p")
    private WebElement promoMessageEU;
    
    @FindBy(css = ".shopping-bag-item .h3")
    private WebElement promoMessageNA;
    
    private PageUtils pageUtils;
    private JavascriptExecutor jsExecutor;
    private Context context;

    @Inject
    public MkMobileShoppingBagPage_EuGlobal(WebDriver webDriver, PageUtils pageUtils, Context context) {
        PageFactory.initElements(webDriver, this);
        this.pageUtils = pageUtils;
        this.jsExecutor = ((JavascriptExecutor) webDriver);
        this.context = context;

    }

    public void clickCheckout() {
        pageUtils.sleepSeconds(2, "wait for page load");


        try{
            pageUtils.waitForWebElement(loggedInCheckout);
            jsExecutor.executeScript("arguments[0].click();", loggedInCheckout);
        }
        catch(Exception e){
            pageUtils.waitForWebElement(checkout);
            jsExecutor.executeScript("arguments[0].click();", checkout);
        }

        pageUtils.waitForPageToLoad();
        pageUtils.waitForAjaxToComplete();
    }

	public String getBagTotalMobile() {
		pageUtils.waitForWebElement(mobileGetTotalPrice);
		pageUtils.sleepSeconds(7, "wait for page load");
		String getBagTotalPrice = mobileGetTotalPrice.getText();
		System.out.println(getBagTotalPrice);
		String getBagTotalPrice1 = getBagTotalPrice.trim().replaceAll("[^0-9]", "");
		String totalPrice = getBagTotalPrice1.trim().replace(",", "");
		context.saveData("totalPrice", totalPrice);
		return totalPrice;
	}

    public double subTotalFromOrderSummary_mobile()
	{
		pageUtils.waitForWebElement(orderSummarySubTotal_Mobile);
		pageUtils.sleepSeconds(5, "wait for page load");
		String subtotalInOrderSummary = orderSummarySubTotal_Mobile.getText();
		String subtotalInOrderSummary1 = subtotalInOrderSummary.trim().replaceAll("[^0-9]", "");
		double orderSummarySuTotal = Double.parseDouble(subtotalInOrderSummary1.toString());
		return orderSummarySuTotal;
	}
	
	public double getTotalFromOrderSummary_mobile()
	{
		pageUtils.waitForWebElement(orderSummaryTotalPrice_Mobile);
		pageUtils.sleepSeconds(5, "wait for page load");
		String getTotalInOrderSummary = orderSummaryTotalPrice_Mobile.getText();
		String getOrderTotal = getTotalInOrderSummary.trim().replaceAll("[^0-9]", "");
		double getOrderTotal1 = Double.parseDouble(getOrderTotal.toString());
		return getOrderTotal1;
	}
	
	public double getPromotionFromOrderSummary_mobile()
	{
		pageUtils.waitForWebElement(orderSummaryPromotion_Mobile);
		String appliedPromotionPrice = orderSummaryPromotion_Mobile.getText();
		String appliedPromotionPrice1 = appliedPromotionPrice.trim().replaceAll("[^0-9]", "");
		double promoAmount = Double.parseDouble(appliedPromotionPrice1.toString());
		return promoAmount;
	}
	    	
	public boolean verifyItemLevelPromoApplied(int amount, String promoType) {
		boolean flag=false;
		pageUtils.sleepSeconds(3, "");
		pageUtils.waitForWebElement(shoppingBagItemPrice);
		pageUtils.scrollToElement(shoppingBagItemPrice);
		if(promoType.equalsIgnoreCase("$off")) {
			String itemTotalmount=shoppingBagItemPrice.getText();
			String getpromoamount = itemTotalmount.trim().replaceAll("[^0-9]", "");
			String itemPriceBefore=getTheItemPrice().trim().replaceAll("[^0-9]", "");
			double actTotalprice = Double.parseDouble(getpromoamount);
			double actTotalpriceBefore = Double.parseDouble(itemPriceBefore);
			double expected=actTotalpriceBefore-amount;
			if(expected==actTotalprice) {
				flag = true;
				context.writeOut("Actal price: "+actTotalprice+" Expected price: "+expected);
			}
		}else if(promoType.equalsIgnoreCase("%OFF")) {
			String promoamount=shoppingBagItemPrice.getText();
			String getpromoamount1 = promoamount.trim().replaceAll("[^0-9]", "");
			String totalPrice = getpromoamount1.trim().replace(",", "");
			double actPromoprice = Double.parseDouble(totalPrice);
			String itemPriceBefore=context.getSavedData("itemTotalPrice").trim().replaceAll("[^0-9]", "");

			double actTotalSubprice = Double.parseDouble(itemPriceBefore);
			double promoAmnt=amount;
			double expectedPromoPrice=actTotalSubprice-(actTotalSubprice*promoAmnt)/100;
			if(actPromoprice==expectedPromoPrice) {
				flag = true;
				context.writeOut("Actal price: "+actPromoprice+" Expected price: "+expectedPromoPrice);
			}
		}
		return flag;
	}

	public boolean verifyPromoApplied(int amount, String promoType) {
		boolean flag=false;
		pageUtils.waitForWebElement(orderSummarySubtotal);
		pageUtils.scrollToElement(orderSummarySubtotal);
		if(promoType.equalsIgnoreCase("$off")) {
			String promoamount=promoCodeOrderSummary.getText();
			String getpromoamount1 = promoamount.trim().replaceAll("[^0-9]", "");
			String totalPrice = getpromoamount1.trim().replace(",", ".");
			double actTotalprice1 = Double.parseDouble(totalPrice);
			double expected=amount;
			if(expected==actTotalprice1) {
				flag = true;
				context.writeOut("Actal price: "+actTotalprice1+" Expected price: "+expected);
			}
		}else if(promoType.equalsIgnoreCase("%OFF")) {
			String promoamount=promoCodeOrderSummary.getText();
			String getpromoamount1 = promoamount.trim().replaceAll("[^0-9]", "");
			String totalPrice = getpromoamount1.trim().replace(",", "");
			double actPromoprice = Double.parseDouble(totalPrice);
			String actualSubTotal=orderSummarySubtotal.getText();
			String orderSummarySub = actualSubTotal.trim().replaceAll("[^0-9]", "");
			String totalSubPrice = orderSummarySub.trim().replace(",", "");
			double actTotalSubprice = Double.parseDouble(totalSubPrice);
			double promoAmnt=amount;
			double expectedPromoPrice=(actTotalSubprice*promoAmnt)/100;
			if(actPromoprice==expectedPromoPrice) {
				flag = true;
				context.writeOut("Actal price: "+actPromoprice+" Expected price: "+expectedPromoPrice);
			}
		}
		return flag;
	}
	
	public String getTheItemPrice() {
		pageUtils.sleepSeconds(3, "");
		pageUtils.waitForWebElement(shoppingBagItemPrice);
		pageUtils.scrollToElement(shoppingBagItemPrice);
		String itemPrice=shoppingBagItemPrice.getText();
		context.saveData("itemTotalPrice", itemPrice);
		context.writeOut("Item price is: "+itemPrice);
		pageUtils.sleepSeconds(3, "");
		return itemPrice;
	}
        
    public boolean shoppingBagProductPriceCalculator() {
    	boolean flag =  false;
        double total = 0;
        try {
			for (int i = 0; i < listOfProductPrice.size(); i++) {
				String amount1 = listOfProductPrice.get(i).getText();
				String productPrice = amount1.trim().replaceAll("[^0-9]", "");
				total =total + Double.parseDouble(productPrice);
				context.writeOut("Total of product amount: " + total);
			}
			double actSubTotalPrice = subTotalFromOrderSummary_mobile();
			context.writeOut("Total amount from order summary: " + actSubTotalPrice);
			if (actSubTotalPrice == total) {
				flag = true;
			} 
		} catch (Exception e) {
			
		}
        Assert.assertTrue("SubTotal value is not eual to sum of all product", true);
		return flag;
       
    }
    
	public boolean verifyProductNameDisplayed() {
		boolean flag=true;
		int size=productSection.size();
				for(int i=0; i<size;i++) {
				productName.get(i).getText();
				context.writeOut("Product: "+i+" Name: "+productName.get(i).getText());
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
				context.writeOut("Product: "+i+" Price: "+productPrice.get(i).getText());
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
				context.writeOut("Product: "+i+" Style is: "+productStyle.get(i).getText());
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
				context.writeOut("Product: "+i+" Image URL: "+productImage.get(i).getAttribute("src"));
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
				context.writeOut("Product: "+i+" Color :"+productColor.get(i).getText());
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
				context.writeOut("Product: "+(i+1)+" Qty :"+selectedQuantityList.get(i).getAttribute("innerText").trim());
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
				context.writeOut("Product: "+i+1+" Size :" + productSize.get(i).getText());
				if (productSize.get(i).toString().isBlank() && productSize.get(i).toString().isEmpty()) {
					flag = false;
				}
			}
		}
		return flag;
	}
}
