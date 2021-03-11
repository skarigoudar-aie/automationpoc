package com.mk.testframework.dt.popup;

import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.util.PageUtils;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.google.inject.Inject;

public class MkMiniBagMenuPopup {

    @FindBy(how = How.CSS, using = ".mini-cart-flyout")
    private WebElement miniBagMenu;
    
    @FindBy(how = How.CSS, using = ".header-cart")
    private WebElement miniBagIcon;
    
    @FindBy(css = ".product-list p")
    private List<WebElement> productNames;
    
    @FindBy(xpath = "//li[@class='mini-cart-price']/span[3]")
    private WebElement miniBagProductPrice;
    
    @FindBy(css = ".sub-total")
	private WebElement miniBagSubTotal;
	
    @FindBy(css = ".mini-cart-items-desc li")
    private List<WebElement> productDetails;
    
    @FindBy(css = ".mini-cart-price .was-price")
    private WebElement wasPrice;
    
    @FindBy(css = ".mini-cart-price .now-price")
    private WebElement nowPrice;
    
    @FindBy(css = ".item-desc a")
    private WebElement miniCartImage;
    
    @FindBy(css = ".display-name")
    private WebElement miniCartProductName;
    
    @FindBy(css = ".mini-cart-price")
    private WebElement price;

    private PageUtils pageUtils;
    private Actions actionBuilder;
    private Context context;

    @Inject
    public MkMiniBagMenuPopup(WebDriver webDriver, PageUtils pageUtils, Context context) {
        PageFactory.initElements(webDriver, this);
        this.actionBuilder = new Actions(webDriver);
        this.pageUtils = pageUtils;
        this.context = context;
    }

    public boolean waitForMiniBagMenuPopup() {
        return pageUtils.waitForWebElement(miniBagMenu);
    }
    
    public String getFirstProductNameInMinCart() {
    	actionBuilder.moveToElement(miniBagIcon).build().perform();
    	pageUtils.sleepSeconds(3, "waiting for mini cart pop up");
    	String productName = productNames.get(0).getText();
    	return productName;       
    }
    
    public String miniBagSubTotalPriceEU() {
    	actionBuilder.moveToElement(miniBagIcon).build().perform();
    	pageUtils.sleepSeconds(2, "waiting for mini cart pop up");
    	String miniSubTotalprice = miniBagSubTotal.getText();
    	System.out.println(miniSubTotalprice);
    	context.saveData("minisubtotal", miniSubTotalprice);
		return miniSubTotalprice;
    }
    
    public String miniBagSubTotalPriceNA() {
    	actionBuilder.moveToElement(miniBagIcon).build().perform();
    	pageUtils.sleepSeconds(3, "waiting for mini cart pop up");
    	String miniSubTotalprice = miniBagSubTotal.getText();
    	System.out.println(miniSubTotalprice);
    	String[] miniToatlPrice = miniSubTotalprice.split(" ");
    	String minisubTotal = miniToatlPrice[1];
    	context.saveData("minisubtotal", minisubTotal);
		return minisubTotal;
	}
	
	public boolean isWasAndNowLabelDisplayed() {
		boolean flag = false;
		pageUtils.sleepSeconds(3, "waiting for mini cart pop up");

			if(wasPrice.isDisplayed() && nowPrice.isDisplayed()) {
				flag=true;
				context.writeOut("Was price is: "+wasPrice.getText());
				context.writeOut("Now price is: "+nowPrice.getText());
			}
		return flag;
	}
    
	public boolean isPriceDisplayed() {
		boolean flag = false;
		pageUtils.sleepSeconds(3, "waiting for mini cart pop up");

		System.out.println(price.getText());
			if(price.isDisplayed()) {
				flag=true;
				context.writeOut("Sale price is: "+price.getText());
			}else if(wasPrice.isDisplayed() && nowPrice.isDisplayed()) {
				flag=true;
				context.writeOut("Was price is: "+wasPrice.getText());
				context.writeOut("Now price is: "+nowPrice.getText());
			}
		return flag;
	}
	
    public boolean isImageDisplayed() {
    	actionBuilder.moveToElement(miniBagIcon).build().perform();
    	pageUtils.sleepSeconds(3, "waiting for mini cart pop up");

    	return pageUtils.verifyIfDisplayed(miniCartImage);
    }
    
    public boolean isProductNameDisplayed() {
    	actionBuilder.moveToElement(miniBagIcon).build().perform();
    	pageUtils.sleepSeconds(3, "waiting for mini cart pop up");

    	context.writeOut("Product Name is: "+miniCartProductName.getText());
    	context.writeOut(productNames.get(0).getText());
    	return pageUtils.verifyIfDisplayed(productNames.get(0));
    }
    
    public boolean isProductSizeDisplayed() {
    	actionBuilder.moveToElement(miniBagIcon).build().perform();
    	pageUtils.sleepSeconds(3, "waiting for mini cart pop up");

    	boolean flag=false;
    	String size=productDetails.get(1).getText();
    	System.out.println("Size: "+size);
    	String sizeTranslation=pageUtils.getTextTranslation("size");
    	if(size.toLowerCase().contains(pageUtils.getTextTranslation("size").toLowerCase())||productDetails.get(1).isDisplayed()) {
    		flag = true;
    		context.writeOut("Size is: "+size);
    	}
    	return flag;
    }
    
    public boolean isProductColorDisplayed() {
    	actionBuilder.moveToElement(miniBagIcon).build().perform();
    	pageUtils.sleepSeconds(3, "waiting for mini cart pop up");

    	boolean flag=false;
    	String color=productDetails.get(0).getText();
    	if(color.toLowerCase().contains(pageUtils.getTextTranslation("color").toLowerCase())||productDetails.get(0).isDisplayed()) {
    		flag = true;
    		context.writeOut("Color is: "+color);
    	}
    	return flag;
    }
    public boolean isProductQuantityDisplayed() {
    	actionBuilder.moveToElement(miniBagIcon).build().perform();
    	pageUtils.sleepSeconds(3, "waiting for mini cart pop up");

    	boolean flag=false;
    	String qty = productDetails.get(2).getText();
    	if(qty.toLowerCase().contains(pageUtils.getTextTranslation("qty").toLowerCase())||productDetails.get(2).isDisplayed()) {
    		flag = true;
    		context.writeOut("Qty is: "+qty);
    	}
    	return flag;
    }

}
