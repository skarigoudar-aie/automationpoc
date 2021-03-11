package com.mk.testframework.dt.mobile;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.util.PageUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MkMobileShoppingBagPage_EU {

    @FindBy(css = "#quantityCartSelector option[selected='true']")
    private WebElement selectedQuantity;

    @FindBy(css = "#quantityCartSelector option[selected='true']")
    private List<WebElement> selectedQuantityList;

    @FindBy(css = ".itemUpdated")
    private WebElement itemUpdatedMessage;

    @FindBy(css = ".sticky-footer #checkoutBtnForMobile")
    private WebElement checkout;

    @FindBy(css = "#checkoutBtnForMobileLoggedIn")
    private WebElement loggedInCheckout;
    
    @FindBy(css = "#shoppingCartItems .shopping-bag-item img")
    private List<WebElement> productImage;
    
    @FindBy(css = ".shopping-bag-item")
    private List<WebElement> productSection;
    
    @FindBy(css = ".shopping-bag-item .storeStyle")
    private List<WebElement> productStyle;
    
    @FindBy(css = ".shopping-bag-item__size .prd-size-value")
    private List<WebElement> productSize;
    
    @FindBy(css = ".shopping-bag-item__price")
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

    @Inject
    public MkMobileShoppingBagPage_EU(WebDriver webDriver, PageUtils pageUtils, Context context) {
        PageFactory.initElements(webDriver, this);
        this.pageUtils = pageUtils;
        this.jsExecutor = ((JavascriptExecutor) webDriver);
        this.context = context;
    }

    public Integer getSelectedQuantity(){
        return Integer.parseInt(selectedQuantity.getAttribute("value"));
    }

    public boolean verifyItemUpdatedMessage(){
        return itemUpdatedMessage.isDisplayed();
    }

    public int getTotalShoppingBagCount(){
        int sum =0;

        for (int i=0;i<selectedQuantityList.size();i++){
            WebElement qty = selectedQuantityList.get(i);
            sum += Integer.parseInt(qty.getAttribute("innerText").trim());
        }
        return sum;
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
