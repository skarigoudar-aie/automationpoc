package com.mk.testframework.dt.page.product;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.core.env.Environment.Region;
import com.mk.testframework.core.exceptions.TestException;
import com.mk.testframework.dt.util.PageUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MkProductContainer {

    @FindBy(css = ".commerce-area-wrapper")
    private WebElement commerceArea;

    @FindBy(css = ".Select-arrow-zone")
    private WebElement quantitySelector;

    @FindBy(css = ".product-custom-description a")
    private WebElement customizeLink;

    @FindBy(css = ".mk-pdp-page .product-details-container .pdp-button-container")
    private WebElement buttonsContainer;

    @FindBy(css = ".add-to-cart-sticky button")
    private WebElement addToBagButton;

    @FindBy(css = ".click-and-collect-container button")
    private WebElement clickAndCollectButton;

    @FindBy(css = ".product-name")
	private WebElement productNameElement;

    @FindBy(css = ".style-name")
	private WebElement productStyleIdElement;

    @FindBy(css = ".product-price-container .Price")
	private WebElement productPriceElement;

    @FindBy(css = ".color-swatch-list")
	private WebElement productColorElement;
    
	@FindBy(xpath = "//ul[@class='color-swatch-list']//ul[@class='facet-section']//li")
	private List<WebElement> colorFacetsList;
    
    @FindBy(css = ".brand-desc-container .product-name")
    private WebElement productNameElementPdp;
    
    @FindBy(css = ".size-link>a")
    private WebElement sizeGuideLink;
    
    @FindBy(css = ".size-guide-panel")
	private WebElement sizeGuidPopUpElement;
    
    @FindBy(xpath = "//input[@name='country-list-dropdown']/..//span[@class='Select-value-label']")
	private WebElement sizeGuideDefaultRegion;
    
    @FindBy(css = ".units a:nth-child(1)")
	private WebElement inchesLink;
       
    @FindBy(css = ".units a:nth-child(2)")
	private WebElement centimetersLink;
    
    @FindBy(css = "#collapse")
    private WebElement sizeGuideCloseMark;
    
    @FindBy(css = ".size-chart-table th")
   	private List<WebElement> sizeCharRegions;
    
    @FindBy(css = ".price-list .listPrice")
    private WebElement listPrice;
    
    @FindBy(css = ".price-list .salePrice")
    private WebElement salePrice;
    
    @FindBy(css = ".price-list .Price")
    private WebElement price;
    
    @FindBy(css = ".price-list")
    private WebElement priceList;
    
    @FindBy(css = ".sale-price-section .facet-section li")
    private List<WebElement> salePriceSkuList;
    
    @FindBy(css = ".sale-price-section .facet-section")
    private WebElement salePriceColorSKU;
    
    @FindBy(css = ".product-price-container .price-list")
    private WebElement priceListOfProduct;
    
    @FindBy(css = ".member-product-list>li")
   	private List<WebElement> memberProducts;
    
    @FindBy(xpath = " //div[contains(@class, 'add-to-cart-sticky')]//button")
    private List<WebElement> addToBagMemberProduct;
    
    @FindBy(xpath = "//*[@class='pdp-error-msg']")
    private WebElement errorMsg;  
    
    @FindBy(xpath = "//div[@class='size-container']//ul[@class='facet-section']")
    private List<WebElement> sizeFacetContainer;  
    
    @FindBy(css = ".Select-arrow-zone")
	private List<WebElement> quantitySelectorMemberProduct;
	
    @FindBy(css = ".facet-size-options")
    private WebElement isSizeOptionDisplayed;
    
    @FindBy(css = ".gallery-images-item>img")
    private WebElement isProductImageDisplayed;
    
    @FindBy(css = ".product-details-container li")
	private List<WebElement> productDetailContainer;
    
    @FindBy(css = ".commerce-area-wrapper .product-price-container")
	private WebElement productPriceContainer;
    
    @FindBy(css = ".color-container .selected-color")
	private WebElement selectedColor;
    
    @FindBy(css = ".wishlist-section")
	private WebElement addToWishList;
    
    @FindBy(css = ".favorites-section")
	private WebElement addToFavorites;

    @FindBy(css = ".size-container")
    private WebElement sizeContainer;
    
    @FindBy(css = ".facet-section .facet-size-options div")
	private List<WebElement> sizeList;
	
    @FindBy(css = ".size-container .facet-section .facet-size-options .size-deselected label")
    private WebElement selectProductSize;
    
    @FindBy(css = ".size-container .facet-section .facet-size-options .size-deselected label")
    private List<WebElement> productSizeList;
    
    @FindBy(css = ".facet-section .deselected")
	private List<WebElement> getProductColour;
	
    @FindBy(xpath = "//div[contains(@class,'social-share')]//a")
    private WebElement addToWishlitOrFavoritesLink;
     
    @FindBy(css = ".size-container .facet-section")
    private WebElement sizeFacetPanel;
    
    @FindBy(css = ".size-container .facet-section li label")
    private List<WebElement> sizeFacets;
    
    @FindBy(css = ".commerce-area-wrapper .product-price-container .listPrice .productAmount")
	private WebElement listPriceEU;
    
    @FindBy(css = ".commerce-area-wrapper .product-price-container .salePrice .productAmount")
    private WebElement salePriceEU;
    
    @FindBy(css = ".commerce-area-wrapper .product-price-container .productAmount")
    private WebElement productPriceEU;
    
    @FindBy(xpath = "(//*[@class='price-list']/div/span/span)[1]")
	private WebElement listPriceNA;
    
    @FindBy(xpath = "(//*[@class='price-list']/div[2]/span[2]/span)[1]")
    private WebElement salePriceNA;
    
    @FindBy(xpath = "(//*[@class='Price']/span/span)[1]")
    private WebElement productPriceNA;
    
    @FindBy(xpath = "//*[@class='inner']/button")
	private List<WebElement> thumbnilImageList;
    
    private PageUtils pageUtils;
    private Actions actionBuilder;
    private WebDriver webDriver;
    private JavascriptExecutor jsExecutor;
    private Context context;
    private Environment env;

    @Inject
    public MkProductContainer(WebDriver webDriver, PageUtils pageUtils, Context context, Environment env){
        PageFactory.initElements(webDriver, this);
        this.actionBuilder = new Actions(webDriver);
        this.pageUtils = pageUtils;
        this.webDriver = webDriver;
        this.jsExecutor = ((JavascriptExecutor) webDriver);
        this.context = context;
        this.env = env;
    }

    public class QuantityMenu {
        @FindBy(css = ".Select-menu .Select-option")
        private List<WebElement> quantityOptions;

        public QuantityMenu(WebDriver webDriver) {
            PageFactory.initElements(webDriver, this);
        }

		public void selectQuantity(int quantity) {
			try {
				WebElement option = quantityOptions.stream()
						.filter(s -> s.getText().equals(String.valueOf(quantity))).findFirst().get();
	        	actionBuilder.moveToElement(option).click().build().perform();
				pageUtils.waitForAjaxToComplete();
				pageUtils.waitForPageToLoad();
			} catch (NoSuchElementException e) {
				throw new TestException("Could not find menu option to click : " + e.getMessage());
			}
		}
    }

    public boolean waitForCommerceArea() {
    	pageUtils.waitForPageToLoad();
        return pageUtils.waitForWebElement(commerceArea);
    }

    public boolean waitForButtonsContainer() {
        return pageUtils.waitForWebElement(buttonsContainer);
    }

    public void clickOnAddToBag() {
		try {
			if (sizeContainer.isDisplayed() == true) {
				clickOnAddToBagForSizedItems();
			}
		} catch (Exception e) {
			pageUtils.sleepSeconds(5, "wait for page load");
			pageUtils.waitTillWebElementIsClickable(addToBagButton);
			jsExecutor.executeScript("arguments[0].click();", addToBagButton);
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(5, "waiting for shopping bag to update");
		}
    }

    public void clickOnClickAndCollect() {
       
        try {
	    	pageUtils.waitTillWebElementIsClickable(clickAndCollectButton);
			jsExecutor.executeScript("arguments[0].click();", clickAndCollectButton);
	        pageUtils.waitForPageToLoad();
			
		} catch (Exception e) {
	    	pageUtils.waitTillWebElementIsClickable(clickAndCollectButton);
			clickAndCollectButton.click();
	        pageUtils.waitForPageToLoad();
		}
    }

    public void selectQuantityValue(int value) {
        if(waitForCommerceArea()){
        	pageUtils.waitTillWebElementIsClickable(quantitySelector);
        	actionBuilder.moveToElement(quantitySelector).click().build().perform();
        	pageUtils.waitForAjaxToComplete();
        	pageUtils.sleepSeconds(2, "For fluid load to complete");
        	new QuantityMenu(webDriver).selectQuantity(value);
        }
    }

    public void clickCustomizeLink(){
        if(waitForCommerceArea()){
        	pageUtils.waitForPageToLoad();
        	 pageUtils.sleepSeconds(2, "For Customize link");
        	 pageUtils.waitTillWebElementIsClickable(customizeLink);
    		jsExecutor.executeScript("arguments[0].click();", customizeLink);
            pageUtils.waitForAjaxToComplete();
            pageUtils.waitForPageToLoad();
            pageUtils.sleepSeconds(8, "For fluid load to complete");
        }
    }

	public boolean isNameDisplayed() {
		pageUtils.sleepSeconds(2, "Waiting for product Name");
		boolean flag = false;
		for (int i = 0; i <= productDetailContainer.size(); i++) {
			if (productDetailContainer.get(i).getAttribute("class").contains("product-name")) {
				System.out.println("Product Name is:" + productDetailContainer.get(i).getText());
				flag = true;
				break;
			}
		}

		return flag;
	}

	public boolean isStyleIdDisplayed() {
		pageUtils.sleepSeconds(2, "Wait for style to displayed");
		boolean flag = false;
		for (int i = 0; i <= productDetailContainer.size(); i++) {
			if (productDetailContainer.get(i).getAttribute("class").contains("style-name")) {
				System.out.println("Style Name is:" + productDetailContainer.get(i).getText());
				flag = true;
				break;
			}

		}

		return flag;
	}
	public boolean isPriceDisplayed() {
		pageUtils.sleepSeconds(2, "Waiting for price to display");
		boolean flag = false;

		if (productPriceContainer.isDisplayed()) {
			flag = true;
		}

		return flag;
	}
	
	public boolean isSaleAndListPriceDisplayed() {
		boolean flag = false;
		String contry = env.getCurrentLocale().getCountry();
		String locale = env.getLanguage();
		pageUtils.waitForWebElement(priceListOfProduct);
		pageUtils.scrollToElement(priceListOfProduct);
		
		pageUtils.sleepSeconds(8, "to click on color");

		String wasText = pageUtils.getTextTranslation("was-price-label");
		String nowText = pageUtils.getTextTranslation("now-price-label");

		try {
			if(contry.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("fr")) {
				wasText = pageUtils.getTextTranslation("was-price-label-ca");
				nowText = pageUtils.getTextTranslation("now-price-label-ca");
			}
			pageUtils.sleepSeconds(2, "to click on color");
			if (salePriceSkuList.get(0).getAttribute("class").contains("deselected")) {
				salePriceSkuList.get(0).click();
				pageUtils.sleepSeconds(2, "to click on color");
				WebElement eleWas=webDriver.findElement(By.xpath("//div[@class='price-list']//span[contains(text(),'"+wasText+"')]"));
				WebElement eleNow=webDriver.findElement(By.xpath("//div[@class='price-list']//span[contains(text(),'"+nowText+"')]"));

				context.writeOut("Clicked on: " + salePriceSkuList.get(0).getAttribute("title"));
				context.writeOut("Was Price is: " + listPrice.getText());
				context.writeOut("Now Price is: " + salePrice.getText());
				pageUtils.sleepSeconds(2, "to click on color");
				if(eleWas.isDisplayed()&&eleNow.isDisplayed()) {
					flag = true;
				}else {
					context.writeOut("Was and Now price label not displayed");
					context.embedScreenshots();
				}
			} else if(salePriceSkuList.get(0).getAttribute("class").contains("selected")){
				pageUtils.scrollToElement(salePriceSkuList.get(0));
				pageUtils.sleepSeconds(5, "to click on color");
				context.writeOut("Was Price is: " + listPrice.getText());
				context.writeOut("Now Price is: " + salePrice.getText());
				WebElement eleWas=webDriver.findElement(By.xpath("//div[@class='price-list']//span[contains(text(),'"+wasText+"')]"));
				WebElement eleNow=webDriver.findElement(By.xpath("//div[@class='price-list']//span[contains(text(),'"+nowText+"')]"));

				if(eleWas.isDisplayed()&&eleNow.isDisplayed()) {
					flag = true;
				}else {
					context.writeOut("Was and Now price label not displayed");
					context.embedScreenshots();
					context.writeOut("Expected Was: "+wasText+" and Found: "+eleWas);
					context.writeOut("Expected Now: " +nowText+"and Found: "+eleNow);
				}
			}else {
				context.writeOut("There is no sale price for selected product");

			}
		} catch (Exception e) {

		}
		return flag;
	}
	
	public String PDPSaleAndListPrice() {
		String nowPrice="";
		pageUtils.waitForWebElement(priceListOfProduct);
		pageUtils.scrollToElement(priceListOfProduct);
		if(!listPrice.getText().equals(null)&& !salePrice.getText().equals(null)) {
	        System.out.println(listPrice.getText());
	        System.out.println(salePrice.getText());
	        nowPrice=salePrice.getText();
		}
		return nowPrice;
	}

	public boolean isColorDisplayed() {
		return pageUtils.verifyIfDisplayed(productColorElement);
	}
	

	 public String captureProductNameOnPdp() {
	   pageUtils.waitForPageToLoad();
	   pageUtils.waitTillWebElementIsClickable(productNameElementPdp);
	   String ProNamePdp = productNameElementPdp.getText();
	   context.setPdpProductName(ProNamePdp);
	   return ProNamePdp; 
	 }
	 
	public void clickOnSizeGuide() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitTillWebElementIsClickable(sizeGuideLink);
		jsExecutor.executeScript("arguments[0].click();", sizeGuideLink);
		pageUtils.sleepSeconds(5, "waiting for size gudie pop up to display");
	}
	
	public boolean isSizeGuidePopUpDisplayed() {
		return pageUtils.verifyIfDisplayed(sizeGuidPopUpElement);
	}
	
	public boolean verifyDefaultSelectedRegionInSizeGuide() {
		boolean flag = false;
		String region = sizeGuideDefaultRegion.getText();
		if (env.getCountryRegion() == Region.NA || env.getCountryRegion() == Region.ASIA_PACIFIC) {
			if (env.getCurrentLocale().toString().equals("fr_CA") && region.contains("TATS-UNIS"))
				flag = true;
			if (env.getCurrentLocale().toString().equals("en_US") || env.getCurrentLocale().toString().equals("en_CA")
					|| env.getCurrentLocale().toString().equals("en_AU") && region.equalsIgnoreCase("UNITED STATES"))
				flag = true;
		} else if (env.getCountryRegion() == Region.EU) {
			if (env.getCurrentLocale().toString().equals("en_PT") && region.equalsIgnoreCase("EUROPEAN"))
				flag = true;
			if (env.getCurrentLocale().toString().equals("es_ES") && region.contains("EUROPA"))
				flag = true;
			if (env.getCurrentLocale().toString().equals("it_IT") && region.equalsIgnoreCase("ITALIANO"))
				flag = true;
			if (env.getCurrentLocale().toString().equals("en_GB") && region.equalsIgnoreCase("UNITED KINGDOM"))
				flag=true;
			if (env.getCurrentLocale().toString().equals("de_CH")
					|| env.getCurrentLocale().toString().equals("de_DE") && region.contains("EUROP"))
				flag = true;
			if (env.getCurrentLocale().toString().equals("fr_FR") && region.contains("FRAN"))
				flag = true;
		}
		return flag;
	}
	
	public boolean verifyChangeSizeMeasureFromDefault() {
		boolean flag = false;
		String defaultSelectedUnit = inchesLink.getAttribute("class");
		String size = sizeCharRegions.get(1).getText();

		if (defaultSelectedUnit.contains("selected")) {
			jsExecutor.executeScript("arguments[0].click();", centimetersLink);
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(1, "waiting for shopping bag update");
			if (size.contains("IN")) {
				flag = true;
			}

		} else {
			jsExecutor.executeScript("arguments[0].click();", inchesLink);
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(1, "waiting for shopping bag update");
			System.out.println(size);
			if (size.contains("CM")) {
				flag = true;
			}
		}
		return flag;
	}

	public boolean verifyChangeSizeMeasureToDefault() {
		boolean flag = false;
		String defaultSelectedUnit = inchesLink.getAttribute("class");
		String size = sizeCharRegions.get(1).getText();

		if (defaultSelectedUnit.contains("selected")) {
			jsExecutor.executeScript("arguments[0].click();", centimetersLink);
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(1, "waiting for shopping bag update");
			if (size.contains("IN")) {
				flag = true;
			}

		} else {
			jsExecutor.executeScript("arguments[0].click();", inchesLink);
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(1, "waiting for shopping bag update");
			if (size.contains("CM")) {
				flag = true;
			}
		}
		return flag;
	}
	
	public boolean verifyDefaultsizeMeasure() {
		boolean flag = false;
		if (env.getCountryRegion() == Region.NA || env.getCountryRegion() == Region.EU || env.getCountryRegion() == Region.ASIA_PACIFIC) {
			String defaultSelectedUnit = inchesLink.getAttribute("class");
			if (env.getCurrentLocale().toString().equals("en_GB") || env.getCurrentLocale().toString().equals("en_US")
					|| env.getCurrentLocale().toString().equals("en_CA") || env.getCurrentLocale().toString().equals("en_AU")
					|| env.getCurrentLocale().toString().equals("fr_CA") && defaultSelectedUnit.contains("selected"))
				flag = true;
		} 
		if (env.getCountryRegion() == Region.EU) {
			String defaultSelectedUnit = centimetersLink.getAttribute("class");
			if (env.getCurrentLocale().toString().equals("fr_FR") || env.getCurrentLocale().toString().equals("en_PT")
					|| env.getCurrentLocale().toString().equals("es_ES")
					|| env.getCurrentLocale().toString().equals("de_CH")
					|| env.getCurrentLocale().toString().equals("it_IT")
					|| env.getCurrentLocale().toString().equals("de_DE")
					|| env.getCurrentLocale().toString().equals("it_IT") && defaultSelectedUnit.contains("selected"))
				flag = true;
		}
		return flag;
	}
	
	public boolean isSizeGuideCloseMarkDisplayed() {
		return pageUtils.verifyIfDisplayed(sizeGuideCloseMark);
	}
	
	public void closeSizeGuide() {
		pageUtils.waitTillWebElementIsClickable(sizeGuideCloseMark);
		jsExecutor.executeScript("arguments[0].click();", sizeGuideCloseMark);
        pageUtils.waitForPageToLoad();
	}
	
	public List<String> verifySizeGuidePopUpForShoes() {
		pageUtils.waitForAjaxToComplete();
        pageUtils.waitForPageToLoad();
		List<String> actualRegionsInChart = new ArrayList<String>();
		for (int i = 0; i <=sizeCharRegions.size()-1; i++) {
			actualRegionsInChart.add(sizeCharRegions.get(i).getText());
		}
		return actualRegionsInChart;
	}
	
	public int getMemberProductsCount() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(30, "Wait for member products to load");
		return memberProducts.size();
	}
	
	public void addMemberProductToCart(int i) {
		int index=i+1;
		boolean status;
		String sizeFacetCont = "(//div[@class='color-container'])["+index+"]/following-sibling::div[@class='size-container']";
		try {
			 webDriver.findElement(By.xpath(sizeFacetCont)).isDisplayed();
			 status=true;
		} catch (Exception e) {
			status=false;
		}
		if(status) {
			String element = "(//div[@class='color-container'])["+index+"]/following-sibling::div[@class='size-container']//ul[@class='facet-section'][1]//li";
			if (webDriver.findElement(By.xpath(element)).isDisplayed()) {
				pageUtils.scrollToElement(webDriver.findElement(By.xpath("//li[@class='clearfix']["+index+"]")));
				actionBuilder.moveToElement( webDriver.findElements(By.xpath(element)).get(0)).click().build().perform();
			}
		}
		pageUtils.sleepSeconds(2, "Wait for product to add");
		addToBagMemberProduct.get(index-1).click();
		pageUtils.sleepSeconds(5, "Wait for product to add");
	}
	
	public boolean getErrorMsgForMaxLimit() {
		pageUtils.sleepSeconds(2, "Wait for error message to display");
		boolean flag = false;
		String errorMessage = errorMsg.getText();
		String expectedErrorMsgText = pageUtils.getTextTranslation("max-quantity-error-msg");
		if (errorMessage.equals(expectedErrorMsgText)||errorMsg.isDisplayed()) {
			flag = true;
		}
		return flag;
	}
	
	public boolean isBrandNameDisplayed() {
		pageUtils.sleepSeconds(10, "Waiting for Brand Name");
		boolean flag = false;
		for (int i = 0; i <= productDetailContainer.size(); i++) {

			if (productDetailContainer.get(i).getAttribute("class").contains("collection-name")) {
				System.out.println("Brand Name is:" + productDetailContainer.get(i).getText());
				flag = true;
				break;
			}
		}

		return flag;
	}

	public boolean defaultColorSwatchSelected() {
		pageUtils.sleepSeconds(2, "Waiting for color swatchs to display");
		boolean flag = false;
		String selectedColorQv = selectedColor.getText();
		String colorSelected = "";

		for (int i = 0; i <= colorFacetsList.size()-1; i++) {
			if (colorFacetsList.get(i).getAttribute("class").contains("selected")) {
				colorSelected = colorFacetsList.get(i).getAttribute("title");
				if (colorSelected.equalsIgnoreCase(selectedColorQv)) {
					flag = true;
					System.out.println("Selected color is: " + colorSelected);
					System.out.println("color is: " + selectedColorQv);
					break;
				}
			}

		}

		return flag;
	}

	public boolean changeColorSwatch() {
		pageUtils.sleepSeconds(1, "Waiting for color to change");
		boolean flag = false;
		String selectedColorQv = selectedColor.getText();
		if (colorFacetsList.size() > 1) {
			for (int i = 0; i <= colorFacetsList.size()-1; i++) {
				System.out.println(colorFacetsList.get(i).getAttribute("class").contains("deselected"));
				if (colorFacetsList.get(i).getAttribute("class").contains("deselected")) {
					colorFacetsList.get(i).click();
					pageUtils.sleepSeconds(1, "Waiting for color change");
					String colorSelected = colorFacetsList.get(i).getAttribute("title");
					pageUtils.sleepSeconds(1, "Waiting for color change");
					selectedColorQv = selectedColor.getText();
					pageUtils.sleepSeconds(1, "Waiting for color change");
					if (selectedColorQv.equalsIgnoreCase(colorSelected)) {
						System.out.println(colorSelected);
						flag = true;
						break;
					}
				}

			}
		} else if (selectedColorQv.equalsIgnoreCase(colorFacetsList.get(0).getAttribute("title"))) {
			flag = true;
		}

		return flag;
	}

	public boolean isFavoriteLinkDisplayed() {

		boolean flag = false;

		if (env.getCurrentLocale().getCountry().equalsIgnoreCase("US")
				|| env.getCurrentLocale().getCountry().equalsIgnoreCase("CA")) {
			pageUtils.waitForWebElement(addToWishList);
			if (addToWishList.isDisplayed()) {
				flag = true;
			}
		} else {
			pageUtils.waitForWebElement(addToFavorites);
			if (addToFavorites.isDisplayed()) {
				flag = true;
			}
		}
		return flag;
	}

	public boolean isAddToCartButtonDisplayed() {
		pageUtils.waitForWebElement(addToBagButton);
		boolean flag = false;
		if (addToBagButton.isDisplayed()) {
			flag = true;
		}
		return flag;
	}

	public boolean isPickupInStoreButtonDisplayed() {
		pageUtils.waitForWebElement(clickAndCollectButton);
		boolean flag = false;
		if (clickAndCollectButton.isDisplayed()) {
			flag = true;
		}
		return flag;
	}
	public boolean qtyDropDown() {
		boolean flag = false;
		if (quantitySelector.isDisplayed()) {
			flag = true;
		}
		return flag;
	}

	public boolean verifySizeGuideLinkDisplayed()
	{
		pageUtils.waitForWebElement(sizeGuideLink);
		boolean flag = false;
		if (sizeGuideLink.isDisplayed()) {
			flag = true;
		}
		return flag;
	}
	
	public boolean verifyZiseOptionIsDisplayed()
	{
		pageUtils.waitForWebElement(sizeGuideLink);
		boolean flag = false;
		if (sizeGuideLink.isDisplayed()) {
			flag = true;
		}
		return flag;
	}
	
	public void selectMemberProductQuantityValue(int value, int index) {
        if(waitForCommerceArea()){
        	pageUtils.waitTillWebElementIsClickable(quantitySelectorMemberProduct.get(index));
        	actionBuilder.moveToElement(quantitySelectorMemberProduct.get(index)).click().build().perform();
        	pageUtils.waitForAjaxToComplete();
        	pageUtils.sleepSeconds(2, "For fluid load to complete");
        	new QuantityMenu(webDriver).selectQuantity(value);
		}
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
	
	public boolean verifyCustomizeSection()
	{
		pageUtils.waitForWebElement(customizeLink);
		boolean flag = false;
		if (customizeLink.isDisplayed()) {
			flag = true;
		}
		return flag;
	}
	
    public void clickOnAddToBagForSizedItems() {
    	pageUtils.sleepSeconds(2, "wait for page load");
    	pageUtils.waitTillWebElementIsClickable(sizeContainer);
    	for(int i=0;i<sizeList.size();i++) {
        	System.out.println("Size is: "+sizeList.get(i).getText());
        	context.saveData("size", sizeList.get(i).getText());
            sizeList.get(i).click();
        	pageUtils.sleepSeconds(2, "wait for page load");
            if(sizeList.get(i).getAttribute("class").contains("size-selected")) {
            	pageUtils.sleepSeconds(2, "wait for page load");
            	if(!sizeList.get(i).getAttribute("class").contains("size-selected")) {
                    sizeList.get(i).click();
            	}
                break;
            }
		}
        pageUtils.waitForPageToLoad();
        pageUtils.waitForAjaxToComplete();
    	pageUtils.waitTillWebElementIsClickable(addToBagButton);
        jsExecutor.executeScript("arguments[0].click();", addToBagButton);
        pageUtils.sleepSeconds(5, "waiting for shopping bag update");
    }
    
	public boolean clickOnNextArrow() {
		boolean flag = false;
		int thumbnilImages = thumbnilImageList.size() - 2;
		pageUtils.sleepSeconds(1, "waiting to get selected image");
		
		if (thumbnilImages > 1) {
			for (int i = 0; i < thumbnilImages; i++) {

				pageUtils.sleepSeconds(2, "waiting to get selected image");

				if (thumbnilImageList.get(i).getAttribute("class").contains("selected")) {

					thumbnilImageList.get(thumbnilImages - 1).click();
					flag = true;
				}
			}

		} else {
			System.out.println("Only one image exist");
			flag = true;
		}

		return flag;
	}

	public boolean clickOnPrevArrow() {
		boolean flag = false;
		int thumbnilImages = thumbnilImageList.size() - 2;
		pageUtils.sleepSeconds(1, "waiting to get selected image");
		if (thumbnilImages > 1) {
			for (int i = thumbnilImages; i > 0; i--) {

				pageUtils.sleepSeconds(2, "waiting to get selected image");

				if (thumbnilImageList.get(i).getAttribute("class").contains("selected")) {

					thumbnilImageList.get(thumbnilImages).click();
					flag = true;
				}
			}
		} else {
			System.out.println("Only one image exist");
			flag = true;
		}

		return flag;
	}

	public boolean verifyImageNavigationViachevrons() {
		boolean flag = false;
		if (clickOnNextArrow() && clickOnPrevArrow()) {
			flag = true;
		}
		return flag;
	}

	public boolean listPriceValidationEU() {

		boolean flag = false;
		String actualAmnt = listPriceEU.getText();
		context.writeOut("Product list price is: " + actualAmnt);

		if (actualAmnt.contains("-")) {
			String[] actualAmnt1 = actualAmnt.split(" - ");
			String actualAmnt2 = actualAmnt1[0];
			System.out.println(actualAmnt2);

			if (actualAmnt2.matches(pageUtils.getCurrencyFormat("currency_format"))) {
				context.writeOut("product price is Matched");
				flag = true;
			}
		} else {
			if (actualAmnt.matches(pageUtils.getCurrencyFormat("currency_format"))) {
				context.writeOut("product price is Matched");
				flag = true;
			}
		}

		return flag;
	}

	public boolean salePriceValidationEU() {
		boolean flag = false;
		String actualAmnt = salePriceEU.getText();
		context.writeOut("Product Sale price is: " + actualAmnt);

		if (actualAmnt.contains("-")) {
			String[] actualAmnt1 = actualAmnt.split(" - ");
			String actualAmnt2 = actualAmnt1[0];
			System.out.println(actualAmnt2);

			if (actualAmnt2.matches(pageUtils.getCurrencyFormat("currency_format"))) {
				context.writeOut("product price is Matched");
				flag = true;
			}
		} else {
			if (actualAmnt.matches(pageUtils.getCurrencyFormat("currency_format"))) {
				context.writeOut("product price is Matched");
				flag = true;
			}
		}

		return flag;
	}

	public boolean productPriceValidationEU() {

		boolean flag = false;
		String actualAmnt = productPriceEU.getText();
		context.writeOut("Product price is: " + actualAmnt);

		if (actualAmnt.contains("-")) {
			String[] actualAmnt1 = actualAmnt.split(" - ");
			String actualAmnt2 = actualAmnt1[0];
			System.out.println(actualAmnt2);

			if (actualAmnt2.matches(pageUtils.getCurrencyFormat("currency_format"))) {
				context.writeOut("product price is Matched");
				flag = true;
			}
		} else {
			if (actualAmnt.matches(pageUtils.getCurrencyFormat("currency_format"))) {
				context.writeOut("product price is Matched");
				flag = true;
			}
		}
		return flag;
	}

	public boolean priceFormatValidationEU() throws ParseException {
		boolean flag = false;
		try {

			if (listPrice.isDisplayed()) {
				if (listPriceValidationEU() && salePriceValidationEU()) {
					flag = true;
				}
			}
		} catch (Exception e) {
			if (productPriceValidationEU()) {
				flag = true;
			}
		}

		return flag;
	}
	
	public boolean listPriceValidationNA() {

		boolean flag = false;
		String actualAmnt = listPriceNA.getText();
		context.writeOut("Product list price is: " + actualAmnt);
		
		if(actualAmnt.contains("-"))
		{
			String[] actualAmnt1 = actualAmnt.split(" - ");
			String actualAmnt2 = actualAmnt1[0];
			System.out.println(actualAmnt2);
			
			if (actualAmnt2.matches(pageUtils.getCurrencyFormat("currency_format"))) {
				context.writeOut("product price is Matched");
				flag = true;
			}
		}
		
		else {
		if (actualAmnt.matches(pageUtils.getCurrencyFormat("currency_format"))) {
			context.writeOut("product price is Matched");
			flag = true;
		}
		}
		

		return flag;
	}

	public boolean salePriceValidationNA() {

		boolean flag = false;
			String actualAmnt = salePriceNA.getText();
			context.writeOut("Product Sale price is: " + actualAmnt);
			
			if(actualAmnt.contains("-"))
			{
				String[] actualAmnt1 = actualAmnt.split(" - ");
				String actualAmnt2 = actualAmnt1[0];
				System.out.println(actualAmnt2);
				
				if (actualAmnt2.matches(pageUtils.getCurrencyFormat("currency_format"))) {
					context.writeOut("product price is Matched");
					flag = true;
				}
			}
			else {
			if (actualAmnt.matches(pageUtils.getCurrencyFormat("currency_format"))) {
				context.writeOut("product price is Matched");
				flag = true;
			}
		}
		return flag;
	}

	public boolean productPriceValidationNA() {

		boolean flag = false;
		String actualAmnt = productPriceNA.getText();
		context.writeOut("Product price is: " + actualAmnt);


		if(actualAmnt.contains("-"))
		{
			String[] actualAmnt1 = actualAmnt.split(" - ");
			String actualAmnt2 = actualAmnt1[0];
			System.out.println(actualAmnt2);
			
			if (actualAmnt2.matches(pageUtils.getCurrencyFormat("currency_format"))) {
				context.writeOut("product price is Matched");
				flag = true;
			}
		}
		else {
		if (actualAmnt.matches(pageUtils.getCurrencyFormat("currency_format"))) {
			context.writeOut("product price is Matched");
			flag = true;
		}
		}
		return flag;
	}

	public boolean priceFormatValidationNA() throws ParseException {
		boolean flag = false;
		try {

			if (listPrice.isDisplayed()) {
				if (listPriceValidationNA() && salePriceValidationNA()) {
					flag = true;
				}
			}
		} catch (Exception e) {
			if (productPriceValidationNA()) {
				flag = true;
			}
		}

		return flag;
	}
	
    public void clickOnCCForSizedItems() {
    	pageUtils.sleepSeconds(2, "wait for page load");
    	pageUtils.waitTillWebElementIsClickable(sizeContainer);
    	for(int i=0;i<sizeList.size();i++) {
        	System.out.println("Size is: "+sizeList.get(i).getText());
        	context.saveData("size", sizeList.get(i).getText());
            sizeList.get(i).click();
            if(sizeList.get(i).getAttribute("class").contains("size-selected")) {
                break;
            }
    	}
        pageUtils.waitForPageToLoad();
        pageUtils.waitForAjaxToComplete();
    	pageUtils.waitTillWebElementIsClickable(clickAndCollectButton);
        jsExecutor.executeScript("arguments[0].click();", clickAndCollectButton);
        pageUtils.sleepSeconds(5, "waiting for shopping bag update");
    }
	
	public void selectSize(String size) {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(3, "wait");
		pageUtils.waitTillWebElementIsClickable(selectProductSize);
		for (int i = 0; i < productSizeList.size(); i++) {
			String productSize = productSizeList.get(i).getText();
			if (productSize.equalsIgnoreCase(size)) {
				jsExecutor.executeScript("arguments[0].click();", productSizeList.get(i));
				String s=sizeList.get(i).getText();
				boolean status=sizeList.get(i).getAttribute("class").contains("size-deselected");
				if (status) {
					productSizeList.get(i).click();
					break;
				}
				break;
			}
		}
	}
	
	public void selectColor(String colorName)
	{
		pageUtils.waitForPageToLoad();
		int allColor = getProductColour.size();
		for(int i=0; i<allColor; i++)
		{
			getProductColour.get(i);
			System.out.println(getProductColour.get(i).getAttribute("title"));
			System.out.println(getProductColour.get(i).getAttribute("title").contains(colorName));
		if(getProductColour.get(i).getAttribute("title").contains(colorName))
		{
			jsExecutor.executeScript("arguments[0].click();", getProductColour);
			System.out.println("hsdbjhb");
			break;
		}
		}
	}
	
	public void clickOnAddToWishlistOrFavoritesLink() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitTillWebElementIsClickable(addToWishlitOrFavoritesLink);
		actionBuilder.moveToElement(addToWishlitOrFavoritesLink).build().perform();
		jsExecutor.executeScript("arguments[0].click();", addToWishlitOrFavoritesLink);
		pageUtils.sleepSeconds(5, "");
	}
	
	public void selectSize(int position) {
		try {
			System.out.println();
			pageUtils.waitTillWebElementIsVisible(sizeFacetPanel, 5);
			actionBuilder.moveToElement(sizeFacets.get(position - 1)).build().perform();
			jsExecutor.executeScript("arguments[0].click();", sizeFacets.get(position - 1));
			context.writeOut("Size selected: " + sizeFacets.get(position - 1).getText());
		} catch (Exception e) {
			int size = sizeFacets.size();
			for (int i = 0; i < size; i++) {
				sizeFacets.get(position - 1).click();
				if (!sizeFacets.get(position - 1).getAttribute("class").contains("size-selected")) {
					jsExecutor.executeScript("arguments[0].click();", sizeFacets.get(position - 1));
					context.writeOut("Size selected: " + sizeFacets.get(position - 1).getText());
				} else {
					context.writeOut("Size selected: " + sizeFacets.get(position - 1).getText());
				}
			}
		}
	}
}
