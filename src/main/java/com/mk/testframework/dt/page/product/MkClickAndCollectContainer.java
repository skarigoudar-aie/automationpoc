package com.mk.testframework.dt.page.product;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.util.PageUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class MkClickAndCollectContainer {

    @FindBy(css = ".click-collect-panel")
    private WebElement clickAndCollectContainer;

    @FindBy(id = "search-location")
    private WebElement searchLocation;

    @FindBy(css = ".search-store button")
    private WebElement searchButton;

    @FindBy(css = ".store-list-section")
    private WebElement storeListSection;
    
    @FindBy(css = "#CIS-item-collect-prodId11")
    private WebElement checkBoxToCollectOption;
    
    @FindBy(css = "#gift-wrapping-CIS-prodId11")
    private WebElement checkBoxGoftwrap;

    @FindBy(css = "button[name='add-and-pickup']")
    private List<WebElement> addCollectButton;
    
    private PageUtils pageUtils;
    private Actions actionBuilder;
    private Context context;
	private JavascriptExecutor jsExecutor;
	private Environment env;
	private WebDriver webDriver;

    @Inject
    public MkClickAndCollectContainer(WebDriver webDriver, PageUtils pageUtils, Context context, Environment env){
        PageFactory.initElements(webDriver, this);
        this.pageUtils = pageUtils;
        this.actionBuilder = new Actions(webDriver);
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.context = context;
		this.env = env;
		this.webDriver = webDriver;
    }

    public boolean waitForClickAndCollectContainer() {
        return pageUtils.waitForWebElement(clickAndCollectContainer);
    }

    public boolean waitForStoreListSection() {
    	pageUtils.sleepSeconds(7, "wait for result displayed");
        return pageUtils.waitForWebElement(storeListSection);
    }

    public void enterSearchLocation(String location) {
        searchLocation.sendKeys(location);
    }

    public void clickSearchButton() {
        actionBuilder.moveToElement(searchButton).build().perform();
		jsExecutor.executeScript("arguments[0].click();", searchButton);
        pageUtils.sleepSeconds(5, "wait for search to render");
        pageUtils.waitForPageToLoad();
    }

    public boolean canBeCollected() {
    	pageUtils.sleepSeconds(5, "Wait for stores to display");
        return !addCollectButton.isEmpty();
    }

    public void clickFirstAvailableStoreForCollection() {
    	pageUtils.waitForAjaxToComplete();
    	pageUtils.sleepSeconds(5, "wait for option display");
    	jsExecutor.executeScript("arguments[0].click();", addCollectButton.get(0));
        pageUtils.sleepSeconds(1, "click and collect to complete");
        pageUtils.waitForPageToLoad();
    }

    public void iSelectCheckboxToCollectItem() {
        pageUtils.waitForPageToLoad();
        pageUtils.sleepSeconds(5, "wait for option display");
        checkBoxToCollectOption.click();
        pageUtils.waitForAjaxToComplete();
    }
  
    public void clickSecondAvailableStoreForCollection() {
    	pageUtils.waitForAjaxToComplete();
    	pageUtils.sleepSeconds(5, "wait for option display");
    	jsExecutor.executeScript("arguments[0].click();", addCollectButton.get(1));
        pageUtils.sleepSeconds(1, "click and collect to complete");
        pageUtils.waitForPageToLoad();
    }

    public void iApplyCnCGiftWrap() {
        pageUtils.waitForAjaxToComplete();
        checkBoxGoftwrap.click();
        pageUtils.waitForAjaxToComplete();
    }
    
	public boolean isStoreKeyTextDisplayed() {
		boolean flag = false;
		if(env.getCountryRegion().toString().equalsIgnoreCase("NA")) {
			flag = isCCHeadlineTextDisplayed();
		}else {
			WebElement ele = clickAndCollectContainer.findElement(By.cssSelector(".click-collect-subtitle"));
			context.writeOut("Store Key Text is: " + ele.getText());
			flag = ele.isDisplayed();
		}
		
		return flag;
	}

	public boolean isCCHeadlineTextDisplayed() {
		WebElement ele = clickAndCollectContainer.findElement(By.cssSelector(".click-collect-title"));
		context.writeOut("Headline Text is: " + ele.getText());
		return pageUtils.verifyIfDisplayed(ele);
	}

	public boolean isProductImageDisplayed() {
		WebElement ele = clickAndCollectContainer.findElement(By.cssSelector(".product-image-panel img"));
		context.writeOut("Image URL is: " + ele.getAttribute("src"));
		return pageUtils.verifyIfDisplayed(ele);
	}

	public boolean isProductTitleDisplayed() {
		WebElement ele = clickAndCollectContainer.findElement(By.cssSelector(".product-name"));
		context.writeOut("Product Title is: " + ele.getText());
		return pageUtils.verifyIfDisplayed(ele);
	}

	public boolean isStyleNumberDisplayed() {
		WebElement ele = clickAndCollectContainer.findElement(By.cssSelector(".product-style"));
		context.writeOut("StyleNumber is: " + ele.getText());
		return pageUtils.verifyIfDisplayed(ele);
	}

	public boolean isPriceCurrencyFormatDisplayedInCountrySelectedCurrency() {
		boolean flag = false;
		try {
			WebElement fullPrice = clickAndCollectContainer.findElement(By.xpath("(//*[@class='Price']/span/span)[1]"));

			if (fullPrice.getText().matches(pageUtils.getCurrencyFormat("currency_format"))) {
				context.writeOut("Price is: " + fullPrice.getText());
				flag = true;
			}
		} catch (Exception e) {
			WebElement listPrice = clickAndCollectContainer
					.findElement(By.cssSelector(".click-collect-panel .listPrice span span"));
			WebElement salePrice = clickAndCollectContainer
					.findElement(By.cssSelector(".click-collect-panel .salePrice span span"));
			context.writeOut("list price is: " + listPrice.getText());
			context.writeOut("sale price is: " + salePrice.getText());
			if (listPrice.getText().matches(pageUtils.getCurrencyFormat("currency_format"))
					&& salePrice.getText().matches(pageUtils.getCurrencyFormat("currency_format"))) {
				flag = true;
			}
		}

		return flag;
	}

	public boolean isProductSaleAndListPriceDisplayed() {
		boolean flag = false;
		try {
			WebElement wasLabel = clickAndCollectContainer
					.findElement(By.cssSelector(".click-collect-panel .listPrice span"));
			WebElement nowLabel = clickAndCollectContainer
					.findElement(By.cssSelector(".click-collect-panel .salePrice span"));
			if (wasLabel.isDisplayed() && nowLabel.isDisplayed()) {
				flag = true;
				context.writeOut("Was label: "+wasLabel.getText());
				context.writeOut("Was label: "+nowLabel.getText());
			}
		} catch (Exception e) {
			WebElement fullPrice = clickAndCollectContainer.findElement(By.xpath("(//*[@class='Price']/span/span)[1]"));
			if (fullPrice.isDisplayed()) {
				flag = true;
				context.writeOut("price :"+fullPrice.getText());
			}
		
		}
		
		return flag;
	}

	public boolean isProductColorDisplayed() {
		WebElement ele = webDriver.findElement(By.xpath("(//*[@class='product-attributes']/span)[1]"));
		context.writeOut("Color is: "+ele.getText());
		return pageUtils.verifyIfDisplayed(ele);
	}

	public boolean isQtyDisplayed() {
		boolean flag = false;
		try {
			WebElement ele = webDriver.findElement(By.xpath("(//*[@class='product-attributes']/span)[2]"));
			context.writeOut("Qty is: "+ele.getText());
			flag =ele.isDisplayed();
		} catch (Exception e) {
			WebElement ele = webDriver.findElement(By.xpath("(//*[@class='product-attributes']/span)[2]"));
			context.writeOut("Qty is: "+ele.getText());
			flag =ele.isDisplayed();
			}
		return flag;
	}

	public boolean isDistanceDropdownDisplayed() {
		WebElement ele = clickAndCollectContainer.findElement(By.cssSelector(".Select-value"));
		return pageUtils.verifyIfDisplayed(ele);
	}

	public boolean isStoreSearchTextBoxDisplayed() {
		WebElement ele = clickAndCollectContainer.findElement(By.id("search-location"));
		return pageUtils.verifyIfDisplayed(ele);
	}

	public boolean isFindStoresButtonDisplayed() {
		WebElement ele = clickAndCollectContainer.findElement(By.cssSelector(".search-store button"));
		return pageUtils.verifyIfDisplayed(ele);
	}

	public boolean isExitOptionDisplayed() {
		WebElement ele = clickAndCollectContainer.findElement(By.cssSelector(".close-button"));
		return pageUtils.verifyIfDisplayed(ele);
	}

	public boolean isTextAreInCountrySpecificLanguage() {
		boolean flag =false;
		
		if(env.getCountryRegion().toString().equals("NA")) {
			WebElement ccLabel = clickAndCollectContainer.findElement(By.cssSelector(".click-collect-title"));
			flag = ccLabel.getText().equalsIgnoreCase(pageUtils.getCCPopupHeadingText("click-collect-title"));
			context.writeOut("From the site: "+ccLabel.getText());
			context.writeOut("From translation: "+pageUtils.getCCPopupHeadingText("click-collect-title"));

		}else {
			WebElement ccLabel = clickAndCollectContainer.findElement(By.cssSelector(".click-collect-title"));
			WebElement storeText = clickAndCollectContainer.findElement(By.cssSelector(".click-collect-subtitle"));
			context.writeOut("From the site: "+storeText.getText());
			context.writeOut("From translation: "+pageUtils.getCCPopupHeadingText("click-collect-subtitle"));
			context.writeOut("From the site: "+ccLabel.getText());
			context.writeOut("From translation: "+pageUtils.getCCPopupHeadingText("click-collect-title"));

			if(storeText.getText().equalsIgnoreCase(pageUtils.getCCPopupHeadingText("click-collect-subtitle"))&&ccLabel.getText().equalsIgnoreCase(pageUtils.getCCPopupHeadingText("click-collect-title"))) {
				flag = true;
			}
		}
		return flag;
	}
    
}
