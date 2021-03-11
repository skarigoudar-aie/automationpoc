package com.mk.testframework.dt.page.shoppingbag;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.core.exceptions.TestEnvironmentException;
import com.mk.testframework.dt.util.PageUtils;

public class MkEditProductLightbox {
    private PageUtils pageUtils;
    private WebDriver webDriver;
	private Actions actionBuilder;
	private JavascriptExecutor jsExecutor;
	private Environment env;
	private Context context;

    @Inject
    public MkEditProductLightbox(WebDriver webDriver, PageUtils pageUtils, Environment env, Context context) {
        PageFactory.initElements(webDriver, this);
        this.actionBuilder = new Actions(webDriver);
        this.pageUtils = pageUtils;
        this.webDriver = webDriver;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.env = env;
		this.context = context;
    }

    public QuantityMenu quantityMenu() {
        return new QuantityMenu(webDriver);
    }

    public class QuantityMenu {

        @FindBy(css = ".qvModelUpdate .dropdown-menu li a")
        private List<WebElement> quantityOptions;

        public QuantityMenu(WebDriver webDriver) {
            PageFactory.initElements(webDriver, this);
        }

        public void clickQuantity(int quantity) {
            try {
                WebElement option = quantityOptions.stream()
                        .filter(s -> s.getText().equals(String.valueOf(quantity))).findFirst().get();
	        	actionBuilder.moveToElement(option).click().build().perform();
                pageUtils.waitForAjaxToComplete();
                pageUtils.waitForPageToLoad();
            } catch (NoSuchElementException e) {
                throw new TestEnvironmentException("Could not find menu option to click : " + e.getMessage());

            }
        }
    }

    @FindBy(id = "shopping-bag-edit-item-modal")
    private WebElement editContainer;

    @FindBy(id = "updateBag_Cart")
    private WebElement updateBagButton;

    @FindBy(css = ".qvModelUpdate .dropdown-toggle")
    private WebElement quantitySelector;
    
    @FindBy(css = ".qvModelUpdate .dropdown-toggle")
    private List<WebElement> quantitySelectorList;

    @FindBy(css = ".dropup .dropdown-menu.open")
    private WebElement quantitySelectorMenu;

    @FindBy(css = ".h-list--right .product-values")
    private WebElement selectedColorName;
    
    @FindBy(css = ".selectedColorName")
    private WebElement selectedColorNameNA;
    
    @FindBy(xpath = "//*[@class='h-list--inline']/li/a")
    private List<WebElement> selectedColor;
    
    @FindBy(css = ".change_size li")
    private List<WebElement> sizeList;
    
    @FindBy(id = "qvChangeSizeValue")
    private WebElement changeSize;
    
    @FindBy(css = ".dropdown-menu .open")
    private WebElement sizeDropDownMenu;
    
    @FindBy(css = ".change_size .dropdown-toggle")
    private WebElement sizeSelector;
    
    public boolean waitForEditContainer(){
        return pageUtils.waitForWebElement(editContainer);
    }

    public boolean waitForQuantitySelector(){
        return pageUtils.waitForWebElement(quantitySelector);
    }

    public void clickUpdateBagButton(){
        updateBagButton.click();
        pageUtils.sleepSeconds(5, "wait for page load");
        pageUtils.waitForPageToLoad();
    }

    public void selectQuantityValue(int value) {
		pageUtils.sleepSeconds(2, "wait for page load");
        if(waitForQuantitySelector()){
        	int size = quantitySelectorList.size();
        	if(size>1) {
        		quantitySelectorList.get(1).click();
            	pageUtils.waitForAjaxToComplete();

        	}else {
        		jsExecutor.executeScript("arguments[0].click();", quantitySelector);
            	pageUtils.waitForAjaxToComplete();
        	}
            quantityMenu().clickQuantity(value);
            pageUtils.waitForAjaxToComplete();
            pageUtils.waitForPageToLoad();
        }
    }
        
	public void selectSizeValue() {
		pageUtils.sleepSeconds(2, "wait for page load");
		int size = 0;
		if (waitForQuantitySelector()) {
			List<WebElement> ele = webDriver.findElements(By.cssSelector(".change_size a"));
			if (env.getCountryRegion().toString().equalsIgnoreCase("NA")) {
				size = sizeList.size();
				for (int i = 0; i < size; i++) {
					jsExecutor.executeScript("arguments[0].click();", sizeSelector);
					pageUtils.waitForAjaxToComplete();
					WebElement el = sizeList.get(i).findElement(By.cssSelector("a"));
					String si = el.getText();
					if (!sizeList.get(i).getAttribute("class").contains("selected") && !si.contains("Sold Out")) {
						pageUtils.sleepSeconds(3, "wait for page load");
						el.click();
						pageUtils.waitForAjaxToComplete();
						pageUtils.waitForPageToLoad();
						break;
					}
				}
			} else {
				size = ele.size();
				for (int i = 0; i < size; i++) {
					pageUtils.waitForAjaxToComplete();
					String si = ele.get(i).getText();
					if (!ele.get(i).getAttribute("class").contains("itemSelected")) {
						pageUtils.sleepSeconds(3, "wait for page load");
						ele.get(i).click();
						pageUtils.waitForAjaxToComplete();
						pageUtils.waitForPageToLoad();
						break;
					}
				}
			}
		}
	}
    
    public void selectColorValue(){
		pageUtils.sleepSeconds(2, "wait for page load");
    	int size = selectedColor.size();
    	for(int i =0; i<size; i++) {
    		if (!selectedColor.get(i).getAttribute("class").contains("active")) {
    			if(env.getCountryRegion().toString().equalsIgnoreCase("NA")){
        			String sBefore = selectedColorName.getText();
        			selectedColor.get(i).click();
        	        pageUtils.sleepSeconds(2, "wait for page load");
        			String sAfter= selectedColorName.getText();;
        			break;
    			}else {
        			String sBefore = selectedColorNameNA.getText();
        			selectedColor.get(i).click();
        	        pageUtils.sleepSeconds(2, "wait for page load");
        			String sAfter= selectedColorNameNA.getText();
        			break;
    			}

    		}
    	}
        pageUtils.sleepSeconds(2, "wait for page load");
        pageUtils.waitForPageToLoad();
    }
    
	public boolean isEditProductLabelDisplayed() {
		boolean flag = false;
		WebElement ele = editContainer.findElement(By.id("shopping-bag-edit-item-modal__label"));
		if (ele.isDisplayed()) {
			context.writeOut("Label is: " + ele.getText());
			flag = true;
		}
		return flag;
	}

	public boolean isProductImageDisplayed() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(3, "");
		boolean flag = false;
		WebElement ele = editContainer.findElement(By.cssSelector("#s7container"));
		if (ele.isDisplayed()) {
			flag = true;
		}
		return flag;
	}
	
	public boolean isMobileProductImageDisplayed() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(3, "");
		boolean flag = false;
		WebElement ele = editContainer.findElement(By.cssSelector(".shopping-bag-item__product-img"));
		if (ele.isDisplayed()) {
			flag = true;
		}
		return flag;
	}

	public boolean isProductImageChangedOnClickingThumbnilImages() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(3, "");
		boolean flag = false;
		List<WebElement> ele = editContainer.findElements(By.cssSelector("#thumbnailWrapper div"));
		int size = ele.size();
		for (int i = 0; i < size; i++) {
			if (!ele.get(i).getAttribute("class").contains("active")) {
				ele.get(i).click();
				pageUtils.sleepSeconds(3, "");
				context.writeOut("Image selected is: " + i + " " + ele.get(i).getAttribute("class").contains("active"));
				flag = true;
			}
		}
		return flag;
	}

	public boolean isProductTitleDisplayed() {
		boolean flag = false;
		WebElement ele = editContainer.findElement(By.cssSelector("h1"));
		if (ele.isDisplayed()) {
			context.writeOut("Product Title is: " + ele.getText());
			flag = true;
		}
		return flag;
	}

	public boolean isStoreStyleDisplayed() {
		boolean flag = false;
		WebElement ele;
		if (env.getCountryRegion().toString().equalsIgnoreCase("NA")) {
			ele = editContainer.findElement(By.xpath("(//*[@class='v-list--all']/div)[7]"));
		} else {
			ele = editContainer.findElement(By.xpath("(//*[@class='v-list--all']/div)[8]"));
			String text=ele.getText();
		}
		if (ele.isDisplayed()) {
			context.writeOut("Store Style is: " + ele.getText());
			flag = true;
		}
		return flag;
	}

	public boolean isStyleColorDisplayed() {
		boolean flag = false;
		WebElement ele;
		if (env.getCountryRegion().toString().equalsIgnoreCase("NA")) {
			ele = editContainer.findElement(By.cssSelector(".h-list--right .product-values"));
		} else {
			ele = editContainer.findElement(By.cssSelector(".selectedColorName"));
		}
		if (ele.isDisplayed()) {
			context.writeOut("Style Color is: " + ele.getText());
			flag = true;
		}
		return flag;
	}

	public boolean isSizeGuideDisplayed() {
		boolean flag = false;
		WebElement ele = editContainer.findElement(By.cssSelector(".size_guide_link"));
		if (ele.isDisplayed()) {
			context.writeOut("Size Guide is: " + ele.getText());
			flag = true;
		}
		return flag;
	}

	public boolean isSizeGuideWithSelectedIsHighlighted() {
		boolean flag = false;
		WebElement ele;
		if (env.getCountryRegion().toString().equalsIgnoreCase("NA")) {
			ele = editContainer.findElement(By.cssSelector(".select-container .change_size button span"));
			context.writeOut("Size selected is: " + ele.getText());
			flag = true;
		} else {
			List<WebElement> elements = editContainer.findElements(By.cssSelector("#qvChangeSizeValue a"));
			for (int i = 0; i < elements.size(); i++) {
				if (elements.get(i).getAttribute("class").contains("itemSelected")) {
					context.writeOut("Title is: " + elements.get(i).getText());
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

	public boolean isQuantiTyDropDownDisplayedWithSelectedQty() {
		boolean flag = false;
		WebElement ele = editContainer.findElement(By.cssSelector(".select-container button[data-id^='productQty']"));
		if (ele.isDisplayed()) {
			context.writeOut("Qty selected is: " + ele.getText());
			flag = true;
		}
		return flag;
	}

	public boolean isShipToAddressRadiobuttonDisplayed() {
		boolean flag = false;
		WebElement ele;
		if (env.getCountryRegion().toString().equalsIgnoreCase("NA")) {
			ele = editContainer.findElement(By.cssSelector("#shiptoAddress"));
			if (ele.getAttribute("type").contains("radio")&&ele.getAttribute("checked").contains("true")) {
				context.writeOut("Shipt to address is selected by default: " + ele.getAttribute("checked").contains("true"));
				flag = true;
			}
		} else {
			ele = editContainer.findElement(By.cssSelector("#shipTo_address"));
			if (ele.getAttribute("type").contains("radio")&&ele.getAttribute("checked").contains("true")) {
				context.writeOut("Shipt to address is selected by default:: " + ele.getAttribute("checked").contains("true"));
				flag = true;
			}
		}
		return flag;
	}

	public boolean isCollectInStoreDetailsWithDetailsLinkClickable() {
		boolean flag = false;
		WebElement ele;
		WebElement link;
		if (env.getCountryRegion().toString().equalsIgnoreCase("NA")) {
			ele = editContainer.findElement(By.cssSelector("#pickupinstore"));
			link = editContainer.findElement(By.cssSelector(".selected-pickup-instore a"));
			if (ele.getAttribute("type").contains("radio") && pageUtils.waitTillWebElementIsClickable(link)) {
				context.writeOut("Detail link is: " + link.getText()+" And Collect in store is radio button: "+ele.getAttribute("type").contains("radio"));
				flag = true;
			}
		} else {
			ele = editContainer.findElement(By.cssSelector("#collectIn_store"));
			link = editContainer.findElement(By.cssSelector(".CISDetails-link"));
			if (ele.getAttribute("type").contains("radio") && pageUtils.waitTillWebElementIsClickable(link)) {
				context.writeOut("Detail link is: " + link.getText()+" And Collect in store is radio button: "+ele.getAttribute("type").contains("radio"));
				flag = true;
			}
		}
		return flag;
	}

	public boolean isUpdateShoppingBagButtonDisplayed() {
		boolean flag = false;
		WebElement ele = editContainer.findElement(By.cssSelector("#updateBag_Cart"));
		if (ele.isDisplayed()) {
			context.writeOut("Update Shopping Bag button is displayed: " + ele.isDisplayed());
			flag = true;
		}
		return flag;
	}

	public boolean isCancelLinkDisplayed() {
		boolean flag = false;
		WebElement ele;
		String cancelText=pageUtils.getSBPEditPopUpTextTranslation("cancel-text");
			ele = editContainer.findElement(By.xpath("//a[normalize-space()='"+cancelText+"']"));
		if (ele.isDisplayed()) {
			context.writeOut("Cancel link is displayed: " + ele.isDisplayed());
			flag = true;
		}
		return flag;
	}

	public boolean isFullDetailsLinkDisplayed() {
		boolean flag = false;
		WebElement ele;
		String viewDetailsText=pageUtils.getSBPEditPopUpTextTranslation("view-full-details");
			ele = editContainer.findElement(By.linkText(viewDetailsText));
		if (ele.isDisplayed()) {
			context.writeOut("View Full details link is displayed: " + ele.isDisplayed());
			flag = true;
		}
		return flag;
	}
    
	public boolean isCloseOptionDisplayed() {
		boolean flag = false;
		WebElement ele = editContainer.findElement(By.cssSelector(".modal-header .close "));
		if (ele.isDisplayed()) {
			flag = true;
		}
		return flag;
	}
    
	public boolean isPopUpClosedOnClickingClose() {
		boolean flag = false;
		WebElement ele = editContainer.findElement(By.cssSelector(".modal-header .close "));
		if (ele.isDisplayed()) {
			ele.click();
			pageUtils.sleepSeconds(2, "");
			if (!isEditProductLabelDisplayed()) {
				flag = true;
			}
		}
		return flag;
	}   
}
