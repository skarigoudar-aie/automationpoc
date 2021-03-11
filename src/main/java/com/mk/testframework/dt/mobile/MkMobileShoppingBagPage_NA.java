package com.mk.testframework.dt.mobile;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.page.shoppingbag.MkShoppingBagPage_NA;
import com.mk.testframework.dt.util.PageUtils;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MkMobileShoppingBagPage_NA {


    @FindBy(css = ".sticky-footer .shoppingCartCheckoutBtn")
    private WebElement checkout;
    
    @FindBy(xpath = "(//*[@class='col-xs-6 col--no-gutters'])[2]")
    private WebElement mobileGetTotalPrice;
    
    @FindBy(xpath = "(//*[@class='row row--no-gutter-margin row--pad-top-20 row--border-top m--border'])/div/following-sibling :: div")
	private List<WebElement> listOfProductPrice;
	
    @FindBy(css = "#quantityCartSelector_ option[selected='true']")
    private WebElement selectedQuantity;

    @FindBy(css = "#quantityCartSelector_ option[selected='true']")
    private List<WebElement> selectedQuantityList;
    
    @FindBy(css = "#shoppingCartItems .shopping-bag-item img")
    private List<WebElement> productImage;
    
    @FindBy(css = ".shopping-bag-item")
    private List<WebElement> productSection;
    
    @FindBy(css = ".shopping-bag-item__description span")
    private List<WebElement> productStyle;
    
    @FindBy(css = ".shopping-bag-item__size")
    private List<WebElement> productSize;
    
    @FindBy(css = ".shopping-bag-item__price .product-values")
    private List<WebElement> productPrice;
    
    @FindBy(css = ".quantity-container")
    private List<WebElement> productQty;
    
    @FindBy(css = ".shopping-bag-item .v-list h2")
    private List<WebElement> productName;

    @FindBy(css = ".shopping-bag-item__color .product-values")
    private List<WebElement> productColor;

    private PageUtils pageUtils;
    private JavascriptExecutor jsExecutor;
    private Context context;
    private MkShoppingBagPage_NA MkShoppingBagPageNA;

    @Inject
    public MkMobileShoppingBagPage_NA(WebDriver webDriver, PageUtils pageUtils, Context context, MkShoppingBagPage_NA MkShoppingBagPageNA) {
        PageFactory.initElements(webDriver, this);
        this.pageUtils = pageUtils;
        this.jsExecutor = ((JavascriptExecutor) webDriver);
        this.context = context;
        this.MkShoppingBagPageNA = MkShoppingBagPageNA;
    }

    public void clickCheckout() {
        pageUtils.waitForAjaxToComplete();
        pageUtils.sleepSeconds(5, "wait for page load");
        jsExecutor.executeScript("arguments[0].click();", checkout);
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
			double actSubTotalPrice = MkShoppingBagPageNA.subTotalFromOrderSummary();
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
		boolean flag = true;

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
