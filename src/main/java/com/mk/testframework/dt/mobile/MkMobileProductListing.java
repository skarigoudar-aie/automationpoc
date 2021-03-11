package com.mk.testframework.dt.mobile;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.core.exceptions.TestEnvironmentException;
import com.mk.testframework.dt.util.PageUtils.Resource;

/**
 * 
 * @author Shiva
 *
 */
public class MkMobileProductListing {

	@FindBy(css = ".tile-listing .product-tile")
	private List<WebElement> productTileContainerMenu;
	
	@FindBy(css = ".facet-panel-count")
	private WebElement PLPproductTotalCount;

	@FindBy(xpath = "//div[@class='PromoContainer css-190zu5z ee3xg964']//a[@class='css-sfjdjv e17gzf6l0']//img")
	private WebElement heroBanner;
	
	@FindBy(xpath = "(//div[contains(@class,'wpCta')])[1]//a")
	private List<WebElement> heroBannerLinks;
	
	@FindBy(css = ".plp-category-heading")
	private WebElement plpCategoryHeading;
	
	@FindBy(xpath = "//a[@aria-label='shop the sale']")
	private WebElement shopNowHeroBanner;
	
	@FindBy(css = ".PromoContainer .wpCta a[data-icid=\"SHOP NOW\"]")
	private WebElement shopNowBanner;
	
	 private WebDriver webDriver;
	 private PageUtils pageUtils;
	 private Actions actionBuilder;
	 private Environment env;
	 private JavascriptExecutor jsExecutor;
	 public Context context;
	 
	 @Inject
	 public MkMobileProductListing(WebDriver webDriver, PageUtils pageUtils, Context context, Environment env) {
	  PageFactory.initElements(webDriver, this);
	  PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 5), this);
	  this.webDriver = webDriver;
	  this.pageUtils = pageUtils;
	  this.context = context;
	  this.actionBuilder = new Actions(webDriver);
	  this.env = env;
	  this.jsExecutor = ((JavascriptExecutor) webDriver);
	}

		public boolean sortingLowToHighNA() {
			boolean flag = false;
			pageUtils.sleepSeconds(5, "wait for page load");
			String productFirstPrice1="";
			List<Double> priceList1 = new ArrayList<>();
			WebElement ele = webDriver.findElement(By.cssSelector(".product-tile-view a"));
			try {
				if (!ele.getAttribute("class").contains("active")) {
					ele.click();
				} 
			} catch (Exception e) {
			}
			loadAllProducts();
			List<WebElement> priceOfProduct = webDriver.findElements(By.xpath(
					"//*[@class='salePrice']/span[2]/span[1] | //*[@class='Price']/span/span[1]"));
			String productFirstPrice =priceOfProduct.get(0).getText();
			if (productFirstPrice.contains("-")) {
				String[] str = productFirstPrice.split("-");
				productFirstPrice1 = str[0].replaceAll("[^0-9]+", "").replace(",", ".").trim();
			} else {
				productFirstPrice1 = productFirstPrice.replaceAll("[^0-9]+", "").replaceAll(",", ".").trim();
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
				priceList1.add(Double.parseDouble(productPrice1));
				pageUtils.scrollToElement(productTileContainerMenu.get(i).findElement(By.className("image-panel")));
				jsExecutor.executeScript(
						"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						priceOfProduct.get(i));
			}
			System.out.println("Size of full price item: " + priceList1.size());
			double productPriceFirst = Double.parseDouble(productFirstPrice1);
			for (double d : priceList1) {
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
			List<Double> priceList1 = new ArrayList<>();
			WebElement ele = webDriver.findElement(By.cssSelector(".product-tile-view a"));
			try {
				if (!ele.getAttribute("class").contains("active")) {
					ele.click();
				} 
			} catch (Exception e) {
			}
			loadAllProducts();
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
				priceList1.add(Double.parseDouble(productPrice1));
				pageUtils.scrollToElement(productTileContainerMenu.get(i).findElement(By.className("image-panel")));
				jsExecutor.executeScript(
						"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						priceOfProduct.get(i));
			}
			System.out.println("Size of full price item: " + priceList1.size());
			double productPriceFirst = Double.parseDouble(productFirstPrice);
			for (double d : priceList1) {
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
			loadAllProducts();
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
			loadAllProducts();
			List<WebElement> priceOfProduct = webDriver.findElements(By.xpath(
					"//*[@class='salePrice']/span[2]/span[1] | //*[@class='Price']/span/span[1]"));
			String productPrice =priceOfProduct.get(0).getText().replaceAll("[^0-9]+", "").replaceAll(",", ".").trim();
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
		
		public void loadAllProducts() {
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(5, "");
			int size = productTileContainerMenu.size();
			int totalProduct=Integer.parseInt(PLPproductTotalCount.getText().replaceAll("\\D+", "").replace(" ", "").trim());
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


	public boolean isHeroBannerDisplayed() {
		boolean flag = false;
		pageUtils.waitForPageToLoad();
		try {
			if(shopNowHeroBanner.isDisplayed()) {
				shopNowHeroBanner.click();
				flag = true;
			}			
		}catch (Exception e) {
			if(shopNowBanner.isDisplayed()) {
				shopNowBanner.click();
				flag = true;
			}else {
				flag = pageUtils.verifyIfDisplayed(heroBanner);
			}
		}
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForPageToLoad();
		return flag;
	}
	
	public boolean isHeroBannerLinksDisplayed() {
		boolean status = false;
		List<WebElement> locators =webDriver.findElements(By.xpath("(//div[contains(@class,'wpCta')])[1]//a"));
		for(WebElement ele: locators) {
			ele.isDisplayed();
			status = true;
			break;
		}
		return status;
	}
	

}




		
	

