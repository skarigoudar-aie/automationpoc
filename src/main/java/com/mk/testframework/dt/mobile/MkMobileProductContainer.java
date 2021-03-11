package com.mk.testframework.dt.mobile;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.exceptions.TestException;
import com.mk.testframework.dt.util.PageUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.NoSuchElementException;

public class MkMobileProductContainer {

    @FindBy(css = ".commerce-area-wrapper")
    private WebElement commerceArea;

    @FindBy(css = ".pdp-quantity-container")
    private WebElement quantityContainer;

    @FindBy(css = ".Select-arrow-zone")
    private WebElement quantitySelector;

    @FindBy(css = ".Select-input")
    private WebElement selectValue;

    @FindBy(css = ".pdp-button-container .add-to-cart-sticky button")
    private WebElement addToBagButton;
    
    @FindBy(css = ".pdp-gallery .pdp-gallery-item")
    private WebElement isProductImageDisplayed;

    @FindBy(css = ".size-container")
    private WebElement sizeContainer;
    
    @FindBy(css = ".facet-section .facet-size-options div")
    private List<WebElement> sizeList;
    
    private PageUtils pageUtils;
    private Actions actionBuilder;
    private WebDriver webDriver;
    private JavascriptExecutor jsExecutor;
    private Context context;

    @Inject
    public MkMobileProductContainer(WebDriver webDriver, PageUtils pageUtils, Context context){
        PageFactory.initElements(webDriver, this);
        this.actionBuilder = new Actions(webDriver);
        this.pageUtils = pageUtils;
        this.webDriver = webDriver;
        this.jsExecutor = ((JavascriptExecutor) webDriver);
        this.context = context;
    }

    public class QuantityMenu {
        @FindBy(css = ".Select-control .Select-input")
        private List<WebElement> quantityOptions;

        public QuantityMenu(WebDriver webDriver) {
            PageFactory.initElements(webDriver, this);
        }

        public void selectQuantity(int quantity) {
            boolean qtyFound= false;
            int i=0;
            while (!qtyFound && i<5){
            	selectValue.sendKeys(Keys.ARROW_DOWN);
                WebElement option = quantityOptions.get(i);
                if(option.getAttribute("aria-activedescendant").equals("react-select-2--option-"+ (quantity - 1))){
                    selectValue.sendKeys(Keys.TAB);
                    pageUtils.waitForAjaxToComplete();
                    pageUtils.waitForPageToLoad();
                    qtyFound = true;
                    break;
                }
                else{
                    i++;
                }
            }
        }
        
        public void selectQuantity_PDP_Page(int quantity) {
            boolean qtyFound= false;
            int i=0;
            WebElement option = quantityOptions.get(0);
            while (!qtyFound && i<5){
            	selectValue.sendKeys(Keys.ARROW_DOWN);
                if(option.getAttribute("aria-activedescendant").equals("react-select-2--option-"+ (quantity - 1))){
                    selectValue.sendKeys(Keys.TAB);
                    pageUtils.waitForAjaxToComplete();
                    pageUtils.waitForPageToLoad();
                    qtyFound = true;
                    break;
                }
                else{
                    i++;
                }
            }
        }
    }

    public boolean waitForCommerceArea() {
        return pageUtils.waitForWebElement(commerceArea);
    }

    public void selectQuantityValue(int value) {
        if(waitForCommerceArea()){
            pageUtils.scrollToElement(quantityContainer);
            actionBuilder.moveToElement(quantitySelector).click().build().perform();
            pageUtils.waitForAjaxToComplete();
            try{
                new QuantityMenu(webDriver).selectQuantity(value);
            } catch (NoSuchElementException e) {
                throw new TestException("Could not find menu option to click : " + e.getMessage());
            }
        }
    }
    
    public void selectQuantityValue_PDP_Page(int value) {
        if(waitForCommerceArea()){
            pageUtils.scrollToElement(quantityContainer);
            actionBuilder.moveToElement(quantitySelector).click().build().perform();
            pageUtils.waitForAjaxToComplete();
            try{
                new QuantityMenu(webDriver).selectQuantity_PDP_Page(value);
            } catch (NoSuchElementException e) {
                throw new TestException("Could not find menu option to click : " + e.getMessage());
            }
        }
    }

    public void clickOnAddToBag() {
		try {
			if (sizeContainer.isDisplayed() == true) {
				clickOnAddToBagForSizedItems();
			}
		} catch (Exception e) {
	        pageUtils.scrollToBottomOfPage();
	        pageUtils.sleepSeconds(3, "wait for page load");
	        jsExecutor.executeScript("arguments[0].click();", addToBagButton);
	        pageUtils.waitForPageToLoad();
	        pageUtils.waitForAjaxToComplete();
	        pageUtils.sleepSeconds(2, "waiting for shopping bag update");
		}
    }

    public void clickOnAddToBagForSizedItems() {
    	pageUtils.sleepSeconds(2, "wait for page load");
    	pageUtils.scrollToElement(sizeContainer);
    	pageUtils.waitTillWebElementIsClickable(sizeContainer);
    	for(int i =0; i<sizeList.size();i++) {
    		System.out.println("Size is: "+sizeList.get(i).getText());
        	context.saveData("size", sizeList.get(i).getText());
            sizeList.get(i).click();
        	pageUtils.sleepSeconds(2, "wait for page load");
            if(sizeList.get(i).getAttribute("class").contains("size-selected")) {
                break;
            }
    	}
        pageUtils.waitForPageToLoad();
        pageUtils.waitForAjaxToComplete();
    	pageUtils.waitTillWebElementIsClickable(addToBagButton);
        jsExecutor.executeScript("arguments[0].click();", addToBagButton);
        pageUtils.sleepSeconds(5, "waiting for shopping bag update");
    }
    public boolean verifyProductImageDisplayed()
	{
		pageUtils.waitForWebElement(isProductImageDisplayed);
		boolean flag = false;
		if (isProductImageDisplayed.isDisplayed()) {
			flag = true;
		}
		return flag;
	}
	
}
