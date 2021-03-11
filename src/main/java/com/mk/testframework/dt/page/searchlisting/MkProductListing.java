package com.mk.testframework.dt.page.searchlisting;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.core.exceptions.TestEnvironmentException;
import com.mk.testframework.dt.mobile.MkMobileProductListing;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.dt.util.PageUtils.Resource;


public class MkProductListing {

	@FindBy(css = ".tile-listing .product-wrapper .product-tile")
	private List<WebElement> productList;

	@FindBy(css = ".product-tile")
	private WebElement productTile;

	@FindBy(css = ".mkwpdev")
	private List<WebElement> promoSections;

	@FindBy(css = ".mkwped .mka-m-product-grid__container div")
	private List<WebElement> mkAccessPromoSections;
	
	@FindBy(css = ".product-name-container")
	private WebElement productName;
	
	@FindBy(css = ".header")
	private WebElement sortOpt;
	
	@FindBy(css = ".product-count")
	private WebElement productTotalCount;
	
	@FindBy(css = ".product-name-container")
	private List<WebElement> productNamePLP;
	
	@FindBy(css = ".product-price-container")
	private List<WebElement> productPricePLP;
	
	@FindBy(css = ".product-price-container .Price .productAmount")
	private List<WebElement> priceOfProductEU;
	
	@FindBy(css = ".Price .productAmount")
	private List<WebElement> ListpriceOfProductEU;
	
	@FindBy(css = ".description-panel .product-price-container a .salePrice .productAmount")
	public List<WebElement> salePriceEU;
	
	@FindBy(css = ".description-panel .product-price-container a .listPrice .productAmount")
	public List<WebElement> listPriceEU;

	@FindBy(css = ".description-panel .product-price-container a .listPrice .ada-link [aria-hidden='true']")
	public List<WebElement> listPriceNA;
	
	@FindBy(css = ".description-panel .product-price-container a .salePrice .ada-link [aria-hidden='true']")
	public List<WebElement> salePriceNA;
		
	@FindBy(css = ".product-price-container .Price [aria-hidden=\"true\"]")
	private List<WebElement> priceOfProductNA;
	
	@FindBy(css = ".description-panel .product-price-container a .salePrice .ada-link [aria-hidden='true']")
	private List<WebElement> salePricePLP;
	
	@FindBy(xpath = "//*[@id='/result/totalProducts']/td[2]")
	private WebElement totalProducts;
	
	@FindBy(css = ".product-color-swatches-container")
	private List<WebElement> productSwatchContainer;
	
	@FindBy(css = ".product-color-swatches-container li")
	private WebElement productSwatchColor;
	
	@FindBy(css = ".product-color-swatches-container li")
	private List<WebElement> productSwatchColors;

	@FindBy(css = ".product-color-swatches-container .swatch-link .swatch-image")
	private List<WebElement> productSwatchColorList;
	
	@FindBy(css = ".facet-size-label")
	private List<WebElement> sizeFacetLabels;
	
	@FindBy(css = ".filter-container .filter-selected-list li a span")
	private List<WebElement> selectedFacets;
	
	@FindBy(xpath = "//*[@class='product-color-swatches-container']/preceding-sibling::li[2]")
	private List<WebElement> colorSwatchProductNames;
	
	@FindBy(xpath = "//*[@class='product-color-swatches-container']/preceding-sibling::li[2]")
	private WebElement colorSwatchProductName;
	
	@FindBy(xpath = "//*[@class='product-color-swatches-container']/preceding-sibling::li[1]")
	private List<WebElement> colorSwatchProductPrices;
	
	@FindBy(xpath = "//*[@class='product-color-swatches-container']/preceding-sibling::li[1]")
	private WebElement colorSwatchProductPrice;
	
	@FindBy(css = ".product-color-swatches-container .swatch-image")
	private List<WebElement> swatchImages;
	
	@FindBy(css = ".product-color-swatches-container .swatch-link input")
	private List<WebElement> swatchImagesNA;
	
	@FindBy(css = ".product-color-swatches-container .swatch-link")
	private List<WebElement> swatchColorIDNA;
	
	@FindBy(css = ".tile-listing .product-tile")
	private List<WebElement> productTileContainerMenu;
	
	@FindBy(xpath = "//*[@class='facet-panel-count']")
	private WebElement productCount;
	
	@FindBy(css = ".plp-category-heading")
	private WebElement heading;
	
	@FindBy(xpath = "//div[@class='PromoContainer css-190zu5z ee3xg964']//a[@class='css-sfjdjv e17gzf6l0']//img")
	private WebElement heroBanner;
	
	@FindBy(xpath = "(//div[contains(@class,'wpCta')])[1]//a")
	private List<WebElement> heroBannerLinks;
	
	@FindBy(css = ".plp-category-heading")
	private WebElement plpCategoryHeading;
	
	@FindBy(xpath = "//ul[@class='breadcrumbs-listing']/li[2]")
	private WebElement clickOnbreadCrumb;
	
	@FindBy(xpath = "//ul[@class='breadcrumbs-listing']/li[3]")
	private WebElement getbreadCrumbtext;
	
	@FindBy(css = ".navigation-panel .nav-category-list .highlight")
	private WebElement getProductListPageName;
	
	@FindBy(id = "errorPageContainer")
	private WebElement errorPage;
	
	@FindBy(css = ".plp-category-heading h1")
	private WebElement headingPLP;
	
	@FindBy(css = ".plp-category-heading h1")
	private WebElement pageName;

	@FindBy(css = ".product-color-swatches-container li div input")
	private List<WebElement> inputColorSwatch;
	
	@FindBy(css = ".product-color-swatches-container li div")
	private List<WebElement> selectedColorSwatch;
	
	@FindBy(xpath = "//*[@class='product-price-container']/a/div[@class='Price']/span/span[1] | //*[@class='salePrice']/span[2]/span[1]")
	private List<WebElement> allPriceNA;
	
	@FindBy(xpath ="//*[@class='product-price-container']/a/div[@class='Price']/span/span[1] | //*[@class='product-price-container']/a/div[@class='salePrice']/span/span[1]")
	private List<WebElement> allPriceEU;

	@FindBy(css = ".card-buy .mk-button")
	private WebElement gcPurchaseNowButton;
 
	 private WebDriver webDriver;
	 private PageUtils pageUtils;
	 private Actions actionBuilder;
	 private Environment env;
	 private JavascriptExecutor jsExecutor;
	 public Context context;
	 private MkFilterResultsPanel_Common mkFilterResultsPanel_common;
	 private MkMobileProductListing mkMobileProductListing;
	 public String device;

	 @Inject
	 public MkProductListing(WebDriver webDriver, PageUtils pageUtils, Context context, Environment env, MkFilterResultsPanel_Common mkFilterResultsPanel_common, MkMobileProductListing mkMobileProductListing) {
	  PageFactory.initElements(webDriver, this);
	  PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 5), this);
	  this.webDriver = webDriver;
	  this.pageUtils = pageUtils;
	  this.context = context;
	  this.actionBuilder = new Actions(webDriver);
	  this.env = env;
	  this.jsExecutor = ((JavascriptExecutor) webDriver);
	  this.mkFilterResultsPanel_common = mkFilterResultsPanel_common;
	  this.mkMobileProductListing = mkMobileProductListing;
	}

	public DescriptionPanel descriptionPanel() {
		return new DescriptionPanel(webDriver);
	}

	public boolean hasPromoSections() {
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForPageToLoad();
		return !promoSections.isEmpty();
	}

	public boolean hasMkAccessPromoSections() {
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForPageToLoad();
		return !mkAccessPromoSections.isEmpty();
	}

	public boolean waitForProductTile() {
		return pageUtils.waitForWebElement(productTile);
	}

	public class DescriptionPanel {
		@FindBy(css = ".description-panel .product-name-container a")
		private WebElement productName;

		@FindBy(css = ".description-panel .product-price-container a")
		private WebElement productPrice;
		
		@FindBy(css = ".description-panel .product-price-container a")
		public List<WebElement> productPriceList;
		
		@FindBy(css = ".product-tile-container .product-image-container img")
		private WebElement productImage;

		@FindBy(css = ".product-tile-container .quickview-container button")
		private WebElement productQuickView;
		
		@FindBy(css = ".description-panel .product-price-container a .salePrice")
		public WebElement salePrice;
		
		@FindBy(xpath = "//span[contains(text(),'Prix initial')]")
		private WebElement wasPriceLabel;
		
		@FindBy(css = ".description-panel .product-price-container a .listPrice")
		public WebElement listPrice;
		
		public DescriptionPanel(WebDriver webDriver) {
			PageFactory.initElements(webDriver, this);
		}

		public String getProductName() {
			return productName.getText();
		}

		public void clickOnProductName() {
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(8, "wait for page load");
			pageUtils.waitTillWebElementIsClickable(productName);
			((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", productName);
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
		}

		public void clickOnProductPrice() {
			pageUtils.waitTillWebElementIsClickable(productPrice);
			((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", productPrice);
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
		}

		public void clickOnProductImage() {
			pageUtils.waitTillWebElementIsClickable(productImage);
			((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", productImage);
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
		}

		public void clickOnProductQuickView() {
			((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", productQuickView);
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
		}
		
		public boolean checkProductPrice() {
			boolean flag=false;
			pageUtils.waitTillWebElementIsClickable(salePrice);

					if(salePrice.isDisplayed()) {
						System.out.println(salePrice.getText());
						System.out.println("************************");
						System.out.println(listPrice.getText());
						flag=true;
					}
				
			return flag;
		}
		
		public boolean isPriceLabelDisplayed() {
			boolean flag = false;
			String contry = env.getCurrentLocale().getCountry();
			String locale = env.getLanguage();
			pageUtils.waitForPageToLoad();
			pageUtils.waitTillWebElementIsClickable(salePrice);
			String wasText = pageUtils.getTextTranslation("was-price-label");
			String nowText = pageUtils.getTextTranslation("now-price-label");

			if (contry.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("fr")) {
				wasText = pageUtils.getTextTranslation("was-price-label-ca");
				nowText = pageUtils.getTextTranslation("now-price-label-ca");
			}
			WebElement eleWas = webDriver.findElement(By.xpath("//span[contains(text(),'" + wasText + "')]"));
			System.out.println("Was is: " + eleWas.getText());

			WebElement eleNow = webDriver.findElement(By.xpath("//span[contains(text(),'" + nowText + "')]"));
			System.out.println("Was is: " + eleNow.getText());

			if (eleWas.isDisplayed() && eleNow.isDisplayed()) {
				context.writeOut("Was and Now label displayed");

				flag = true;
			} else {
				context.writeOut("Expected Was: " + wasText + " and Found: " + eleWas.getText());
				context.writeOut("Expected Now: " + nowText + " and Found: " + eleNow.getText());
			}
			return flag;
		}
				
		public void clickOnProductWhichHasSalePrice() {
			pageUtils.waitTillWebElementIsClickable(salePrice);
			salePrice.click();
			pageUtils.waitForPageToLoad();
			pageUtils.sleepSeconds(3, "wait for page load");

		}
	}
	
	public void clickRandomProduct() {
		WebElement product = productList.get(new Random().nextInt(productList.size()));
		WebElement img = product.findElement(By.cssSelector(".product-image-container"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", img);
		pageUtils.sleepSeconds(1, "wait for page load");
		pageUtils.waitForPageToLoad();
	}

	public void clickProductAtPosition(int number) {
		WebElement product = productList.get((number - 1));
		WebElement img = product.findElement(By.cssSelector(".product-image-container"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", img);
		pageUtils.sleepSeconds(1, "wait for page load");
		pageUtils.waitForPageToLoad();
	}

	public String captureProductName() {
		return productName.getText();

	}

	public void SelectSortOption(String sOption) {
		try{
			WebElement logo=webDriver.findElement(By.id("back-to-top"));
			logo.click();
			pageUtils.sleepSeconds(5, "Scrolling to top");
			pageUtils.waitForWebElement(sortOpt);
			actionBuilder.moveToElement(sortOpt).click().build().perform();
			pageUtils.waitForAjaxToComplete();
			new SortOptionsMenu(webDriver).selectOption(sOption);
		}catch(Exception e) {
			pageUtils.waitForWebElement(sortOpt);
			actionBuilder.moveToElement(sortOpt).click().build().perform();
			pageUtils.waitForAjaxToComplete();
			new SortOptionsMenu(webDriver).selectOption(sOption);
		}
	}
	  
	 public class SortOptionsMenu {
	    
	      @FindBy(css = ".dropdown-menu .menu-option a")
	      private List<WebElement> sortOptions;
	     
	              
	      public SortOptionsMenu(WebDriver webDriver) {
	      PageFactory.initElements(webDriver, this);
	              
	      }    
	      
	        public void selectOption(String sOption) {
	         
	         String translatedsOption = getTranslation(sOption);
	         context.setSortOptions(translatedsOption);
	         
	      try {
	        WebElement option3 = sortOptions.stream()
	          .filter(s -> s.getText().toLowerCase().contains(String.valueOf(translatedsOption).toLowerCase())).findFirst().get();
	        actionBuilder.moveToElement(option3).click().build().perform();
	        pageUtils.waitForAjaxToComplete();
	        pageUtils.waitForPageToLoad();
	       } catch (NoSuchElementException e) {
	        throw new TestEnvironmentException("Could not find Sort option to click : " + e.getMessage());
	       }
	      
	     
	      }

	  public String getTranslation(String sOption) {
	   ResourceBundle sortResource = pageUtils.getResourceBundle(Resource.SORT);
	      return sortResource.getString(pageUtils.buildResourceLookupKey(sOption));
	      
	  }
	 }
	   
	  public String getsorttext() {
	   
	   String Sorttext = sortOpt.getText();
	   
	   return Sorttext;
	   
	  }
	  
	  
	  public void ReloadPage() {
		  pageUtils.refresh();
		  pageUtils.waitForAjaxToComplete();
	      pageUtils.waitForPageToLoad();
	  }
	  
	  public boolean isProductNameDisplayedForAllProduct() {
		  boolean flag=false;
			if(device().equalsIgnoreCase("mobile")) {
				mkMobileProductListing.loadAllProducts();
			}else {
				loadAllProducts();
			}
		  List<WebElement> l2FlyoutDisplayed = productNamePLP.stream().filter(s -> s.isDisplayed())
					.collect(Collectors.toList());
		   List<String> currentOptions = new ArrayList<>();
		   int productCount=l2FlyoutDisplayed.size();
		   
		  for(WebElement ele:l2FlyoutDisplayed) {
			pageUtils.scrollToElement(ele);
			  jsExecutor.executeScript(
						"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						ele);
			  if(ele.getText().isBlank()||ele.getText().isEmpty()) {
				  flag=false;
				  context.writeOut(ele+" at this point product name is not displayed");
			  }
			  currentOptions.add(ele.getText());
			  if(productCount==currentOptions.size()) {
				  flag=true;
			  }
		  }
		  context.writeOut("Total products on the Page: "+productCount+" Products having names: "+currentOptions.size());
		  return flag;
	  }
	  
	  public boolean isHeroBannerDisplayed() {
			 pageUtils.waitForAjaxToComplete();
			 pageUtils.waitForPageToLoad();
			 return pageUtils.verifyIfDisplayed(heroBanner);
		 }

		public String getTranslation(String text) {
			ResourceBundle menuResource = pageUtils.getResourceBundle(Resource.TEXT);
			return menuResource.getString(pageUtils.buildResourceLookupKey(text));
		}
		
		public boolean isHeroBannerLinksDisplayed() {
			boolean status = false;
			List<WebElement> locators =webDriver.findElements(By.xpath("(//div[contains(@class,'wpCta')])[2]//a"));
			for(WebElement ele: locators) {
				ele.isDisplayed();
				break;
			}
				status=true;
			return status;
		}
		
		public boolean isLinksFunctionalInHeroBanner() {
			boolean status = false;

			List<WebElement> elements = webDriver
					.findElements(By.xpath("(//div[contains(@class,'wpCta')])[1]//a"));
			int size=elements.size();
			for (int i=1;i<=size;i++) {	
				WebElement ele=webDriver
						.findElement(By.xpath("(//div[contains(@class,'wpCta')])[1]//a["+(i)+"]"));
					String categoryName=ele.getText();
					ele.click();
					pageUtils.waitForPageToLoad();
					pageUtils.waitForAjaxToComplete();
					pageUtils.sleepSeconds(5, "Wait for category page to display");
					if ((pageUtils.getCurrentUrl().toLowerCase().contains(categoryName.toLowerCase()) || pageUtils.getCurrentUrl().toLowerCase().contains(getTranslation("view-all").toLowerCase()) ||pageUtils.verifyIfDisplayed(headingPLP))) {
						status = true;
					} else {
						status = false;
						break;
					}
				}
			
			return status;
		}

		public boolean isProductPriceDisplayedForAllProductsEU() throws ParseException {
			boolean flag = false;
			String actualAmnt;
			
			List<String> currentOptions = new ArrayList<>();
			try {
				int productCount = priceOfProductEU.size();

				for (int i = 0; i < productCount; i++) {
					WebElement row = priceOfProductEU.get(i);
					currentOptions.add(row.getText());
					actualAmnt = priceOfProductEU.get(i).getText();
					if (!actualAmnt.matches(pageUtils.getCurrencyFormat("currency_format"))) {
						context.writeOut(i + " at this point product price is not Matched");
						flag = false;
						break;
					}
					if (row.getText().isBlank() || row.getText().isEmpty()) {
						flag = false;
						context.writeOut(i + " at this point product price is not displayed");
					}
					productCount = priceOfProductEU.size();
					if (productCount == currentOptions.size()) {
						flag = true;
					}
				}
				context.writeOut("Total products on the Page: " + productCount + " Products having prices: "
						+ currentOptions.size());
			} catch (Exception e) {
				context.writeOut("There are no Full price items");
				flag = true;
			}
			return flag;
		}

		public boolean listPriceValidationEU() {
			boolean flag = false;
			String actualAmnt;
			List<String> currentOptions = new ArrayList<>();
			try {
				int productCount = listPriceEU.size();

				for (int i = 0; i < productCount; i++) {

					WebElement row = listPriceEU.get(i);
					currentOptions.add(row.getText());

					actualAmnt = listPriceEU.get(i).getText();

					if (!actualAmnt.matches(pageUtils.getCurrencyFormat("currency_format"))) {
						context.writeOut(i + " at this point product price is not Matched");
						flag = false;
						break;
					}

					if (row.getText().isBlank() || row.getText().isEmpty()) {
						flag = false;
						context.writeOut(i + " at this point product price is not displayed");
					}
					productCount = listPriceEU.size();
					if (productCount == currentOptions.size()) {
						flag = true;
					}

				}
				context.writeOut("Total products on the Page: " + productCount + " Products having prices: "
						+ currentOptions.size());
				pageUtils.waitForPageToLoad();
			} catch (Exception e) {
				context.writeOut("There are no Sale price items");
				flag = true;
			}

			return flag;
		}
		
		public boolean isProductPriceDisplayedForAllProductsNA() throws ParseException {
			boolean flag = false;
			List<String> currentOptions = new ArrayList<>();
			try {
				int productCount = priceOfProductNA.size();

				for (int i = 0; i < productCount; i++) {
					WebElement row = priceOfProductNA.get(i);
					currentOptions.add(row.getText());

					String actualAmnt = priceOfProductNA.get(i).getText();

					if (!actualAmnt.matches(pageUtils.getCurrencyFormat("currency_format"))) {
						context.writeOut(i + " at this point product price is not Matched");
						flag = false;

						break;
					}
					if (row.getText().isBlank() || row.getText().isEmpty()) {
						flag = false;
						context.writeOut(i + " at this point product price is not displayed");
					}
					productCount = priceOfProductNA.size();
					if (productCount == currentOptions.size()) {
						flag = true;
					}
				}
				context.writeOut("Total products having only list price the Page: " + productCount
						+ " Products having only list prices: " + currentOptions.size());
				pageUtils.waitForPageToLoad();
			} catch (Exception e) {
				context.writeOut("There are no Full price items");
				flag = true;
			}

			return flag;
		}
		
		public boolean listPriceValidationNA() {
			boolean flag = false;
			String actualAmnt;
			List<String> currentOptions = new ArrayList<>();
			try {
				int productCount = listPriceNA.size();

				for (int i = 0; i < productCount; i++) {
					WebElement row = listPriceNA.get(i);
					currentOptions.add(row.getText());
					actualAmnt = listPriceNA.get(i).getText();
					if (!actualAmnt.matches(pageUtils.getCurrencyFormat("currency_format"))) {
						context.writeOut(i + " at this point product price is not Matched");
						flag = false;
					}
					if (row.getText().isBlank() || row.getText().isEmpty()) {
						flag = false;
						context.writeOut(i + " at this point product price is not displayed");
					}
					productCount = listPriceNA.size();
					if (productCount == currentOptions.size()) {
						flag = true;
					}

				}
				context.writeOut("Total products having Sale price on the Page: " + productCount
						+ " Products having sale prices: " + currentOptions.size());
				pageUtils.waitForPageToLoad();
			} catch (Exception e) {
				context.writeOut("There are no List price items");
				flag = true;
			}

			return flag;
		}
		
		public boolean priceFormatValidationEU() throws ParseException {
			boolean flag=false;
			if(listPriceValidationEU() && isProductPriceDisplayedForAllProductsEU()) {
				flag = true;
			}
			return flag;
		}
		
		public boolean priceFormatValidationNA() throws ParseException {
			boolean flag=false;
			if(listPriceValidationNA() && isProductPriceDisplayedForAllProductsNA()) {
				flag = true;
			}
			return flag;
		}
		
		public boolean isPriceFilterCurrencyFormatProper() {
			boolean flag=false;
			String Price=pageUtils.getFilterTranslation("price");
			WebElement element=webDriver.findElement(By.xpath("//a[contains(text(),'"+Price+"')]"));
			pageUtils.scrollToElement(element);
			mkFilterResultsPanel_common.openPriceFilterIfClosed();
			List<WebElement> ele=webDriver.findElements(By.xpath("//*[contains(@for,'"+Price+"')]"));
			int size=ele.size();
			
			for(int i=0;i<size;i++) {
				System.out.println(ele.get(i).getText());
				String s="";
				try {
					String[] str = ele.get(i).getText().split("-");
					s = str[1];
				} catch (Exception e) {
					if(ele.get(i).getText().contains(pageUtils.getTextTranslation("under"))) {
						String[] arrStr = ele.get(i).getText().split("de");
						s = arrStr[1];
					}
				}
				String[] str1=s.split("\\(");
				System.out.println(str1[0].trim());
				String actual=new String(str1[0].trim());
				boolean status=actual.matches(pageUtils.getCurrencyFormat("currency_format"));
				if(status) {
					flag = true;
					break;
				}
				
			}
			pageUtils.waitForPageToLoad();

			return flag;
		}
		
		public boolean isProductAndProductCountMatch() {
			boolean flag = false;
			pageUtils.waitForPageToLoad();
			pageUtils.sleepSeconds(3, "");
			WebElement ele = webDriver.findElement(By.cssSelector(".product-tile-view a"));
			if (!ele.getAttribute("class").contains("active")) {
				ele.click();
				pageUtils.sleepSeconds(3, "");
			}
			if(device().equalsIgnoreCase("mobile")) {
				mkMobileProductListing.loadAllProducts();
			}else {
				loadAllProducts();
			}
			List<String> currentOptions = new ArrayList<>();
			int productCount = productTileContainerMenu.size();
			String count = productTotalCount.getText();
			context.writeOut("Total Product count on Page: " + count);
			int size = Integer.parseInt(count);
			  for(int i=0; i<productCount;i++) {
				  WebElement row=productNamePLP.get(i);
				  if(row.getText().isBlank()||row.getText().isEmpty()) {
					  flag=false;
				  }else if(!row.getText().isBlank()||!row.getText().isEmpty()) {
					  currentOptions.add(row.getText());
				  }
				  productCount = productNamePLP.size();
				  count=productTotalCount.getText();
				  pageUtils.sleepSeconds(1, "");
				  if(size==currentOptions.size()) {
					  flag=true;
				  }
			  }
			
			context.writeOut("Total products count displayed on the Page: " + currentOptions.size() + " Total Products available: "
					+ size);
			return flag;
		}

		public boolean isColorSwatchDisplayedOnPLP() {
			boolean flag = false;
			if(device().equalsIgnoreCase("mobile")) {
				mkMobileProductListing.loadAllProducts();
			}else {
				loadAllProducts();
			}
			 int size = productTileContainerMenu.size();
				for (int i = 0; i < size; i++) {
					WebElement productContainer = productTileContainerMenu.get(i);
					pageUtils.scrollToElement(productContainer.findElement(By.className("image-panel")));
					List<WebElement> elements = productTileContainerMenu.get(i)
							.findElements(By.cssSelector(".swatch-link"));
				
					for(int j = 0; j<elements.size(); j++) {
						if (elements.get(j).isDisplayed()) {
							flag = true;
							break;
						}
					}
					
				}
				
					
			/*if(productSwatchContainer.get(0).isDisplayed()) {
				flag = true;
			}else {
				context.writeOut("There is no color swatches on the page");
			}
			*/
			return flag;
		}		


		public boolean sortingLowToHigh() {
			boolean flag = false;
			pageUtils.sleepSeconds(5, "wait for page load");
			String s = salePricePLP.get(0).getText();
			String productPrice = s.replaceAll("[^0-9]+", "").replaceAll(",", ".").trim();

			int x = salePricePLP.size();

			for (int i = 0; i < x; i++) {
				if (salePricePLP.get(i).isDisplayed()) {
					String s1 = salePricePLP.get(i).getText();
					
					String productPrice1 = s1.replaceAll("[^0-9]+", "").replaceAll(",", ".").trim();

					if (Double.parseDouble(productPrice) <= Double.parseDouble(productPrice1)) {
						flag = true;

					} else {
						flag = false;
						
					}
					x = salePricePLP.size();
				}
			}

			return flag;
		}

		
		public boolean iVerifyProductsAreInSelectedPriceRangeEU() {
			boolean flag = false;
			String country = env.getCurrentLocale().getCountry();
			String locale = env.getLanguage();
			List<Double> priceList = new ArrayList<>();
			try {
				if (priceOfProductEU.get(0).isDisplayed()) {
					for (WebElement s : priceOfProductEU) {
						if (s.getText().contains("-")) {
							String[] str = s.getText().split("-");
							double firstPrice = Double
									.parseDouble(str[0].replaceAll("[^0-9]+", "").replace(",", ".").trim());
							priceList.add(firstPrice);
						} else {
							if (country.equalsIgnoreCase("de") || country.equalsIgnoreCase("fr")
									|| country.equalsIgnoreCase("it") || country.equalsIgnoreCase("es")
									|| country.equalsIgnoreCase("au") || country.equalsIgnoreCase("at")) {
								double listPrice = Double
										.parseDouble(s.getText().replaceAll("[^0-9]+", "").replace(",", "."));
								priceList.add(listPrice);
							} else {
								double listPrice = Double.parseDouble(s.getText().replaceAll("[^0-9]+", ""));
								priceList.add(listPrice);
							}
						}
					}
				}
			} catch (Exception e) {
				context.writeOut("There is no full price items");
			}
			try {
				if (salePriceEU.get(0).isDisplayed()) {
					for (WebElement s : salePriceEU) {
						if (s.getText().contains("-")) {
							String[] str = s.getText().split("-");
							double firstPrice = Double
									.parseDouble(str[0].replaceAll("[^0-9]+", "").replace(",", ".").trim());
							priceList.add(firstPrice);
						} else {
							if (country.equalsIgnoreCase("de") || country.equalsIgnoreCase("fr")
									|| country.equalsIgnoreCase("it") || country.equalsIgnoreCase("es")
									|| country.equalsIgnoreCase("au") || country.equalsIgnoreCase("at")
									|| locale.equalsIgnoreCase("en_FR")) {
								double listPrice = Double
										.parseDouble(s.getText().replaceAll("[^0-9]+", "").replace(",", "."));
								priceList.add(listPrice);
							} else {
								double listPrice = Double.parseDouble(s.getText().replaceAll("[^0-9]+", ""));
								priceList.add(listPrice);
							}
						}
					}
				}
			} catch (Exception e) {
				context.writeOut("There is no sale price items");
			}
			String facetSelected = context.getSavedData("facetSelected");
			String[] arrStr = facetSelected.split("-");
			if (arrStr[0].contains(pageUtils.getTextTranslation("under"))) {
				arrStr[0] = "0.0";
			}
			double arrStrLowerAmount = Double
					.parseDouble(arrStr[0].replaceAll("[^0-9]+", "").replace(",", ".").trim());
			String[] t1 = arrStr[1].split("\\(");
			String s1 = t1[0].replaceAll("[^0-9]+", "").replace(",", ".").trim();
			double arrStrHigherAmount = Double.parseDouble(s1);
			context.writeOut("Total products: "+priceList.size());
			for (double d : priceList) {
				if (arrStrLowerAmount <= d && arrStrHigherAmount >= d) {
					flag = true;
				}
			}
			return flag;
		}
    
    public void getPageNameAndURL() {
    	pageUtils.waitForAjaxToComplete();
	    pageUtils.waitForPageToLoad();
    	String currentUrl = pageUtils.getCurrentUrl();
    	context.saveData("PLPName", pageName.getText());
    	context.saveData("PLPUrl", currentUrl);
    }

		public boolean iVerifyProductsAreInSelectedPriceRangeNA() {
			boolean flag = false;
			String country = env.getCurrentLocale().getCountry();
			List<Double> priceList = new ArrayList<>();
			try {
				pageUtils.scrollToElement(productPricePLP.get(productPricePLP.size() - 1));
				pageUtils.sleepSeconds(2, "");
				if (priceOfProductNA.get(0).isDisplayed()) {
					for (WebElement s : priceOfProductNA) {
						if (s.getText().contains("-")) {
							String[] str = s.getText().split("-");
							double firstPrice = Double
									.parseDouble(str[0].replaceAll("[^0-9]+", "").replace(",", ".").trim());
							priceList.add(firstPrice);
						} else {
							if (country.equalsIgnoreCase("ca") && env.getLanguage().equalsIgnoreCase("fr")) {
								double listPrice = Double
										.parseDouble(s.getText().replaceAll("[^0-9]+", "").replace(",", "."));
								priceList.add(listPrice);
							} else {
								double listPrice = Double.parseDouble(s.getText().replaceAll("[^0-9]++", ""));
								priceList.add(listPrice);
							}
						}
					}
				}
			} catch (Exception e) {
				context.writeOut("There is no full price items");
			}
			try {
				if (salePriceNA.get(0).isDisplayed()) {
					for (WebElement s : salePriceNA) {
						if (s.getText().contains("-")) {
							String[] str = s.getText().split("-");
							double firstPrice = Double
									.parseDouble(str[0].replaceAll("[^0-9]+", "").replace(",", ".").trim());
							priceList.add(firstPrice);
						} else {
							if (country.equalsIgnoreCase("ca") && env.getLanguage().equalsIgnoreCase("fr")) {
								double listPrice = Double
										.parseDouble(s.getText().replaceAll("[^0-9]+", "").replace(",", "."));
								priceList.add(listPrice);
							} else {
								double listPrice = Double.parseDouble(s.getText().replaceAll("[^0-9]+", ""));
								priceList.add(listPrice);
							}
						}
					}
				}
			}catch (Exception e){
				context.writeOut("There is no Sale price item");
			}
			
			String facetSelected = context.getSavedData("facetSelected");
			String[] arrStr=null;
			try {
				arrStr = facetSelected.split("-");
				if (arrStr[0].contains("Under")) {
					arrStr[0] = "0.0";
				}
			}catch (Exception e){
				if(facetSelected.contains(pageUtils.getTextTranslation("under"))) {
					arrStr = facetSelected.split("de");
					arrStr[0]="0.0";
				}
			}

			double arrStrLowerAmount = Double
					.parseDouble(arrStr[0].replaceAll("[^0-9]+", "").replace(",", ".").trim());
			String[] t1 = arrStr[1].split("\\(");
			String s1 = t1[0].replaceAll("[^0-9]+", "").replace(",", ".").trim();
			double arrStrHigherAmount = Double.parseDouble(s1);
			context.writeOut("Total products: "+priceList.size());
			for (double d : priceList) {
				if (arrStrLowerAmount <= d && arrStrHigherAmount >= d) {
					flag = true;
				}
			}
			return flag;
		}
		
		public boolean isColorSwatchDisplayedOnPLPAndClickable() {
			boolean flag = false;
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(3, "");
			int size = productTileContainerMenu.size();
			for (int i = 0; i < size; i++) {
				WebElement productContainer = productTileContainerMenu.get(i);
				pageUtils.scrollToElement(productContainer.findElement(By.className("image-panel")));
				List<WebElement> elements = productTileContainerMenu.get(i)
						.findElements(By.cssSelector(".swatch-link"));
				//int sizeColor = elements.size();
				for (int j = 0; j < elements.size(); j++) {
					WebElement element = elements.get(j);
					WebElement ele = productTileContainerMenu.get(i).findElement(By.className("image-panel"));
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", ele);
					jsExecutor.executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
							element);
					if (!element.getAttribute("class").contains("selected")) {
						jsExecutor.executeScript("arguments[0].click();", element);
						if (!element.getAttribute("class").contains("selected")) {
							element.click();
						}
						pageUtils.sleepSeconds(2, "");
						String image = productContainer.findElement(By.cssSelector(".product-image-container img"))
								.getAttribute("src");
						boolean status = element.getAttribute("class").contains("selected");
						String colorid = element.getAttribute("data-colorid");
						if (image.contains(colorid)||status) {
							flag = true;
						}
					}
				}
			}
			return flag;
		}
		
		public boolean isPriceAndNameNotChangedOnPLP() {
			boolean flag = false;
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(3, "");
			int size = productTileContainerMenu.size();
			for (int i = 0; i < size; i++) {
				WebElement productContainer = productTileContainerMenu.get(i);
				List<WebElement> elements = productTileContainerMenu.get(i)
						.findElements(By.cssSelector(".swatch-link"));
				for (int j = 0; j < elements.size(); j++) {
					WebElement element = elements.get(j);
					WebElement ele = productTileContainerMenu.get(i).findElement(By.className("image-panel"));
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", ele);
					jsExecutor.executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
							element);
					String nameBefore = productContainer.findElement(By.cssSelector(".product-name-container a"))
							.getText();
					String priceBefore = productContainer.findElement(By.cssSelector(".product-price-container a"))
							.getText();
					if (!element.getAttribute("class").contains("selected")) {
						jsExecutor.executeScript("arguments[0].click();", element);
						pageUtils.sleepSeconds(2, "");
						String name = productContainer.findElement(By.cssSelector(".product-name-container a"))
								.getText();
						String price = productContainer.findElement(By.cssSelector(".product-price-container a"))
								.getText();
						if (name.equalsIgnoreCase(nameBefore) && price.equalsIgnoreCase(priceBefore)) {
							flag = true;
						}
					}
				}
			}
			return flag;
		}
		
		
		public boolean isColorSwatchDisplayedOnPLPAndClickableNA() {
			boolean flag = false;
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(3, "");
			int size = productTileContainerMenu.size();
			for (int i = 0; i < size; i++) {
				WebElement productContainer = productTileContainerMenu.get(i);
				pageUtils.scrollToElement(productContainer.findElement(By.className("image-panel")));
				List<WebElement> elements = productTileContainerMenu.get(i)
						.findElements(By.cssSelector(".swatch-link"));
				//int sizeColor = elements.size();
				for (int j = 0; j < elements.size(); j++) {
					WebElement element = elements.get(j);
					WebElement ele = productTileContainerMenu.get(i).findElement(By.className("image-panel"));
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", ele);
					jsExecutor.executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
							element);
					if (!element.getAttribute("class").contains("selected")) {
						jsExecutor.executeScript("arguments[0].click();", element);
						pageUtils.sleepSeconds(2, "");
						String image = productContainer.findElement(By.cssSelector(".product-image-container img"))
								.getAttribute("src");
						String colorid = productContainer.findElement(By.cssSelector(".swatch-link"))
								.getAttribute("data-colorid");
						if (image.contains(colorid)) {
							flag = true;
						}
					}
				}
			}
			return flag;
		}
		
		public boolean isPriceAndNameNotChangedOnPLPNA() {
			boolean flag = false;
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(3, "");
			int size = productTileContainerMenu.size();
			for (int i = 0; i < size; i++) {
				WebElement productContainer = productTileContainerMenu.get(i);
				List<WebElement> elements = productTileContainerMenu.get(i)
						.findElements(By.cssSelector(".swatch-link"));
				for (int j = 0; j < elements.size(); j++) {
					WebElement element = elements.get(j);
					WebElement ele = productTileContainerMenu.get(i).findElement(By.className("image-panel"));
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", ele);
					jsExecutor.executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
							element);
					String nameBefore = productContainer.findElement(By.cssSelector(".product-name-container a"))
							.getText();
					String priceBefore = productContainer.findElement(By.cssSelector(".product-price-container a"))
							.getText();
					if (!element.getAttribute("class").contains("selected")) {
						jsExecutor.executeScript("arguments[0].click();", element);
						if (!element.getAttribute("class").contains("selected")) {
							element.click();
						}
						pageUtils.sleepSeconds(2, "");
						String name = productContainer.findElement(By.cssSelector(".product-name-container a"))
								.getText();
						String price = productContainer.findElement(By.cssSelector(".product-price-container a"))
								.getText();
						if (name.equalsIgnoreCase(nameBefore) && price.equalsIgnoreCase(priceBefore)) {
							flag = true;
						}
					}
				}
			}
			return flag;
		}
		
		public void loadAllProducts() {
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(3, "");
			int size = productTileContainerMenu.size();
			int totalProduct=Integer.parseInt(productTotalCount.getText());
			for (int i=0;i<totalProduct;i++) {
				WebElement productContainer = productTileContainerMenu.get(size-1);
				pageUtils.scrollToElement(productContainer.findElement(By.className("image-panel")));
				jsExecutor.executeScript(
						"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						productContainer);
				jsExecutor.executeScript("return document.body.scrollHeight");
				pageUtils.scrollToElement(productTileContainerMenu.get(0));
				pageUtils.scrollToBottomOfPage();
				pageUtils.sleepSeconds(3, "");
				pageUtils.scrollToElement(productContainer.findElement(By.className("image-panel")));
				size = productTileContainerMenu.size();
				if(size>=totalProduct) {
					pageUtils.sleepSeconds(3, "");
					WebElement element = webDriver.findElement(By.id("back-to-top"));
					try {
						if(element.isDisplayed()) {
							element.click();
						}
					}catch(Exception e) {
						if(element.isDisplayed()) {
							jsExecutor.executeScript("arguments[0].click();", element);
						}
					}
					pageUtils.sleepSeconds(3, "");
				break;
				}
			}	
		}
		
		public String getFirstProductPriceEU() {
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(3, "");
			List<WebElement> productPriceList =productTile.findElements(By.cssSelector(".product-price-container"));
			try {
				WebElement salePriceProduct=productPriceList.get(0).findElement(By.cssSelector(".salePrice"));
				return salePriceProduct.getText();
			} catch (Exception e) {
				WebElement fullPriceProduct=productPriceList.get(0).findElement(By.cssSelector(".Price .productAmount"));
				return fullPriceProduct.getText();
			}
		}
		
		public String getFirstProductPriceNA() {
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(3, "");
			List<WebElement> productPriceList =productTile.findElements(By.cssSelector(".product-price-container"));
			try {
				WebElement salePriceProduct=productPriceList.get(0).findElement(By.cssSelector("a .salePrice .ada-link [aria-hidden='true']"));
				return salePriceProduct.getText();
			} catch (Exception e) {
				WebElement fullPriceProduct=productPriceList.get(0).findElement(By.cssSelector(".Price [aria-hidden='true']"));
				return fullPriceProduct.getText();
			}
		}
		
		public boolean sortingLowToHighNA() {
			boolean flag = false;
			pageUtils.sleepSeconds(5, "wait for page load");
			String productFirstPrice="";
			List<Double> priceList = new ArrayList<>();
			WebElement ele = webDriver.findElement(By.cssSelector(".product-tile-view a"));
			try {
				if (!ele.getAttribute("class").contains("active")) {
					ele.click();
				} 
			} catch (Exception e) {
				// TODO: handle exception
			}
			if(device().equalsIgnoreCase("mobile")) {
				mkMobileProductListing.loadAllProducts();
			}else {
				loadAllProducts();
			}
			List<WebElement> priceOfProduct = webDriver.findElements(By.xpath(
					"//*[@class='salePrice']/span[2]/span[1] | //*[@class='Price']/span/span[1]"));
			String productPrice =priceOfProduct.get(0).getText();
			if (productPrice.contains("-")) {
				String[] str = productPrice.split("-");
				productFirstPrice = str[0].replaceAll("[^0-9]+", "").replace(",", ".").trim();
			} else {
				productFirstPrice = productPrice.replaceAll("[^0-9]+", "").replaceAll(",", ".").trim();
			}
			int x = priceOfProduct.size();
			System.out.println(x);
			for (int i = 0; i < x; i++) {
				String productPrice1 = "";
				String s1 = priceOfProduct.get(i).getText();
				if (s1.contains("-")) {
					String[] str = s1.split("-");
					productPrice1 = str[0].replaceAll("[^0-9]+", "").replace(",", ".").trim();
				} else {
					productPrice1 = s1.replaceAll("[^0-9]+", "").replaceAll(",", ".").trim();
				}
				priceList.add(Double.parseDouble(productPrice1));
				pageUtils.scrollToElement(productTileContainerMenu.get(i).findElement(By.className("image-panel")));
				jsExecutor.executeScript(
						"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						priceOfProduct.get(i));
			}
			System.out.println("Size of full price item: " + priceList.size());
			double productPriceFirst = Double.parseDouble(productFirstPrice);
			for (double d : priceList) {
				if (productPriceFirst <= d) {
					productPriceFirst = d;
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
			pageUtils.sleepSeconds(5, "wait for page load");
			return flag;
		}
		
		public boolean sortingLowToHighEU() {
			boolean flag = false;
			pageUtils.sleepSeconds(5, "wait for page load");
			String productFirstPrice="";
			List<Double> priceList = new ArrayList<>();
			WebElement ele = webDriver.findElement(By.cssSelector(".product-tile-view a"));
			try {
				if (!ele.getAttribute("class").contains("active")) {
					ele.click();
				} 
			} catch (Exception e) {
				// TODO: handle exception
			}
			if(device().equalsIgnoreCase("mobile")) {
				mkMobileProductListing.loadAllProducts();
			}else {
				loadAllProducts();
			}
			List<WebElement> priceOfProduct = webDriver.findElements(By.xpath(
					"//*[@class='salePrice']/span[2]/span[contains(@class,'productAmount')] | //*[@class='Price']/span/span[contains(@class,'productAmount')]"));
			String productPrice =priceOfProduct.get(0).getText();
			if (productPrice.contains("-")) {
				String[] str = productPrice.split("-");
				productFirstPrice = str[0].replaceAll("[^0-9]+", "").replace(",", ".").trim();
			} else {
				productFirstPrice = productPrice.replaceAll("[^0-9]+", "").replaceAll(",", ".").trim();
			}
			int x = priceOfProduct.size();
			System.out.println(x);
			for (int i = 0; i < x; i++) {
				String productPrice1 = "";
				String s1 = priceOfProduct.get(i).getText();
				if (s1.contains("-")) {
					String[] str = s1.split("-");
					productPrice1 = str[0].replaceAll("[^0-9]+", "").replace(",", ".").trim();
				} else {
					productPrice1 = s1.replaceAll("[^0-9]+", "").replaceAll(",", ".").trim();
				}
				priceList.add(Double.parseDouble(productPrice1));
				pageUtils.scrollToElement(productTileContainerMenu.get(i).findElement(By.className("image-panel")));
				jsExecutor.executeScript(
						"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						priceOfProduct.get(i));
			}
			System.out.println("Size of full price item: " + priceList.size());
			double productPriceFirst = Double.parseDouble(productFirstPrice);
			for (double d : priceList) {
				if (productPriceFirst <= d) {
					productPriceFirst = d;
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
			pageUtils.sleepSeconds(5, "wait for page load");
			return flag;
		}
				
		public boolean sortingHighToLow_EU() {
			boolean flag = false;
			pageUtils.sleepSeconds(5, "wait for page load");
			String productFirstPrice="";
			List<Double> priceList = new ArrayList<>();
			WebElement ele = webDriver.findElement(By.cssSelector(".product-tile-view a"));
			try {
				if (!ele.getAttribute("class").contains("active")) {
					ele.click();
				} 
			} catch (Exception e) {
			}
			if(device().equalsIgnoreCase("mobile")) {
				mkMobileProductListing.loadAllProducts();
			}else {
				loadAllProducts();
			}
			List<WebElement> priceOfProduct = webDriver.findElements(By.xpath(
					"//*[@class='salePrice']/span[2]/span[contains(@class,'productAmount')] | //*[@class='Price']/span/span[contains(@class,'productAmount')]"));
			String productPrice =priceOfProduct.get(0).getText();
			if (productPrice.contains("-")) {
				String[] str = productPrice.split("-");
				productFirstPrice = str[1].replaceAll("[^0-9]+", "").replace(",", ".").trim();
			} else {
				productFirstPrice = productPrice.replaceAll("[^0-9]+", "").replaceAll(",", ".").trim();
			}
			int x = priceOfProduct.size();
			System.out.println(x);
			for (int i = 0; i < x; i++) {
					String productPrice1 = "";
					String s1 = priceOfProduct.get(i).getText();
					if (s1.contains("-")) {
						String[] str = s1.split("-");
						productPrice1 = str[1].replaceAll("[^0-9]+", "").replace(",", ".").trim();
					} else {
						productPrice1 = s1.replaceAll("[^0-9]+", "").replaceAll(",", ".").trim();
					}
					priceList.add(Double.parseDouble(productPrice1));
					pageUtils.scrollToElement(productTileContainerMenu.get(i).findElement(By.className("image-panel")));
					jsExecutor.executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
							priceOfProduct.get(i));
			}
			double productPriceFirst = Double.parseDouble(productFirstPrice);
			System.out.println("Size of full price item: " + priceList.size());
			for (double d : priceList) {
				if (productPriceFirst >= d) {
					productPriceFirst = d;
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
			pageUtils.sleepSeconds(5, "wait for page load");
			return flag;
		}
		
		public boolean sortingHighToLow_NA() {
			boolean flag = false;
			pageUtils.sleepSeconds(5, "wait for page load");
			String productFirstPrice="";
			List<Double> priceList = new ArrayList<>();
			WebElement ele = webDriver.findElement(By.cssSelector(".product-tile-view a"));
			try {
				if (!ele.getAttribute("class").contains("active")) {
					ele.click();
				} 
			} catch (Exception e) {
			}
			if(device().equalsIgnoreCase("mobile")) {
				mkMobileProductListing.loadAllProducts();
			}else {
				loadAllProducts();
			}
			List<WebElement> priceOfProduct = webDriver.findElements(By.xpath(
					"//*[@class='salePrice']/span[2]/span[1] | //*[@class='Price']/span/span[1]"));
			String productPrice =priceOfProduct.get(0).getText();
			if (productPrice.contains("-")) {
				String[] str = productPrice.split("-");
				productFirstPrice = str[1].replaceAll("[^0-9]+", "").replace(",", ".").trim();
			} else {
				productFirstPrice = productPrice.replaceAll("[^0-9]+", "").replaceAll(",", ".").trim();
			}
			int x = priceOfProduct.size();
			System.out.println(x);
			for (int i = 0; i < x; i++) {
					String productPrice1 = "";
					String s1 = priceOfProduct.get(i).getText();
					if (s1.contains("-")) {
						String[] str = s1.split("-");
						productPrice1 = str[1].replaceAll("[^0-9]+", "").replace(",", ".").trim();
					} else {
						productPrice1 = s1.replaceAll("[^0-9]+", "").replaceAll(",", ".").trim();
					}
					priceList.add(Double.parseDouble(productPrice1));
					pageUtils.scrollToElement(productTileContainerMenu.get(i).findElement(By.className("image-panel")));
					jsExecutor.executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
							priceOfProduct.get(i));
			}
			double productPriceFirst = Double.parseDouble(productFirstPrice);
			System.out.println("Size of full price item: " + priceList.size());
			for (double d : priceList) {
				if (productPriceFirst >= d) {
					productPriceFirst = d;
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
			pageUtils.sleepSeconds(5, "wait for page load");
			return flag;
		}

		public boolean verifyBreadCrumbNavigation()
		{
		   boolean flag = false;
		   pageUtils.waitForPageToLoad();
		   pageUtils.sleepSeconds(2, "wait for page load");
		   try {
			   String currentUrl1 = pageUtils.getCurrentUrl();
			   context.writeOut("url before is: "+currentUrl1);
			   String breadcrumbTextBefore = getbreadCrumbtext.getText();
			   context.writeOut("breadCrumb link is before: "+breadcrumbTextBefore);
			   
			   clickOnbreadCrumb.click();
			   pageUtils.waitForAjaxToComplete();
			   pageUtils.waitForPageToLoad();
			   pageUtils.sleepSeconds(5, "wait for page load");
			   String breadcrumbTextafter = getbreadCrumbtext.getText();
			   context.writeOut("breadCrumb link is after: "+breadcrumbTextafter);		   
			   String plpPage = getProductListPageName.getText();
			   context.writeOut("PLP page is: "+plpPage);
			   
			   String currentUrl = pageUtils.getCurrentUrl();
			   context.writeOut("url after is: "+currentUrl);
			   
			   if (plpPage.equalsIgnoreCase(breadcrumbTextafter) || currentUrl1!=currentUrl) {
				   flag = true;
				   context.writeOut("Breadcrumb link navigated to Respective page");
				   pageUtils.sleepSeconds(5, "wait for page load");
			   } 
		   } catch (Exception e) {
			   
		   }
		   return flag;
		}
		
		public boolean priceFormatValidationForEU() {
			
			if(device().equalsIgnoreCase("mobile")) {
				mkMobileProductListing.loadAllProducts();
			}else {
				loadAllProducts();
			}
			List<WebElement> allPriceDisplayed = allPriceEU.stream().filter(s -> s.isDisplayed())
					.collect(Collectors.toList());
			List<String> currentOptions = new ArrayList<>();
			int productCount = allPriceDisplayed.size();

			boolean flag = false;
			String actualAmnt = "";
			try {

				for (WebElement ele : allPriceDisplayed) {
					pageUtils.scrollToElement(ele);
					  jsExecutor.executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
								ele);
					if (ele.getText().contains("-")) {
						if(ele.getText().isBlank()||ele.getText().isEmpty()) {
							pageUtils.refresh();
							pageUtils.sleepSeconds(3, "");	
						}
						String[] str = ele.getText().split("-");
						actualAmnt = str[0].trim();
						currentOptions.add(str[0]);
					} else {
						if(ele.getText().isBlank()||ele.getText().isEmpty()) {
							pageUtils.refresh();
							pageUtils.sleepSeconds(3, "");	
						}
						actualAmnt = ele.getText();
						currentOptions.add(actualAmnt);
					}
					if (!actualAmnt.matches(pageUtils.getCurrencyFormat("currency_format"))) {
						context.writeOut(ele.getText() + " at this point product price is not Matched");
						flag = false;
						break;
					}
					if (ele.getText().isBlank() || ele.getText().isEmpty()) {
						flag = false;
						context.writeOut(ele + " at this point product price is not displayed");
					}
					if (productCount == currentOptions.size()) {
						flag = true;
					}
				}
				context.writeOut("Total products on the Page: " + productCount + " Products having prices: "
						+ currentOptions.size());
				pageUtils.waitForPageToLoad();
			} catch (Exception e) {
				context.writeOut("There are no Sale price items");
				flag = true;
			}
			return flag;
		}

		public boolean priceFormatValidationForNA() {
			if(device().equalsIgnoreCase("mobile")) {
				mkMobileProductListing.loadAllProducts();
			}else {
				loadAllProducts();
			}
			List<WebElement> allPriceDisplayed = allPriceNA.stream().filter(s -> s.isDisplayed())
					.collect(Collectors.toList());
			List<String> currentOptions = new ArrayList<>();
			int productCount = allPriceDisplayed.size();
			boolean flag = false;
			String actualAmnt;
			try {

				for (WebElement ele : allPriceDisplayed) {
					pageUtils.scrollToElement(ele);
					  jsExecutor.executeScript(
								"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
								ele);
					if (ele.getText().contains("-")) {
						String[] str = ele.getText().split("-");
						actualAmnt = str[0].trim();
						currentOptions.add(str[0]);
					} else {
						actualAmnt = ele.getText();
						currentOptions.add(actualAmnt);
					}
					if (!actualAmnt.matches(pageUtils.getCurrencyFormat("currency_format"))) {
						context.writeOut(ele + " at this point product price is not Matched");
						flag = false;
						break;
					}

					if (ele.getText().isBlank() || ele.getText().isEmpty()) {
						flag = false;
						context.writeOut(ele + " at this point product price is not displayed");
					}
					if (productCount == currentOptions.size()) {
						flag = true;
					}
				}
				context.writeOut("Total products on the Page: " + productCount + " Products having prices: "
						+ currentOptions.size());
				pageUtils.waitForPageToLoad();
			} catch (Exception e) {
				context.writeOut("There are no Sale price items");
				flag = true;
			}
			return flag;
		}

		public void clickOnPurchaseNowButton_Gc() {
			pageUtils.waitTillWebElementIsClickable(gcPurchaseNowButton);
			((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", gcPurchaseNowButton);
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
		}
		
		public String device() {
			
			boolean mobile = env.isSysPropsSpecified(Environment.SysProps.MOBILE);
			if(mobile) {
				device = "mobile";
			}else {
				device = "desktop";
			}
			return device;
		}
}
