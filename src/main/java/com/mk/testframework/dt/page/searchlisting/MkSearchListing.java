package com.mk.testframework.dt.page.searchlisting;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.mobile.MkMobileProductListing;
import com.mk.testframework.dt.util.PageUtils;

/**
 * 
 * @author Shiva
 *
 */
public class MkSearchListing {

	@FindBy(css = ".recommended-container")
	private WebElement recommendationContainer;

	@FindBy(css = ".recommended-container .swiper-container .swiper-button-next")
	private WebElement sliderRecommendationsNext;

	@FindBy(css = ".recommended-container .swiper-container .swiper-button-prev")
	private WebElement sliderRecommendationsPrev;

	@FindBy(xpath = "(//*[@class='swiper-wrapper'])[1]/div")
	private List<WebElement> recommendationContainerMenu;
	
	@FindBy(css = ".tile-listing .product-tile")
	private List<WebElement> productTileContainerMenu;
	
	@FindBy(css = ".product-count")
	private WebElement productCount;
	
	private PageUtils pageUtils;
	private Context context;
	private JavascriptExecutor jsExecutor;
	public WebDriver webDriver;
	public MkMobileProductListing mkMobileProductListing;
	public String device;
	private Environment env;

	@Inject
	public MkSearchListing(WebDriver webDriver, PageUtils pageUtils, Context context, MkMobileProductListing mkMobileProductListing, Environment env) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.context = context;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.webDriver = webDriver;
		this.mkMobileProductListing = mkMobileProductListing;
		this.env = env;
	}
	
	public boolean productRecommendationRFKIsDisplayed() {
		pageUtils.scrollToBottomOfPage();
		pageUtils.sleepSeconds(10, "wait for recommendation");
		pageUtils.waitForWebElement(recommendationContainer);
		pageUtils.scrollToElement(recommendationContainer);
		return pageUtils.verifyIfDisplayed(recommendationContainer);
	}

	public boolean sliderRecommendationsIsDisplayed() {
		pageUtils.waitForWebElement(sliderRecommendationsNext);
		pageUtils.waitForWebElement(sliderRecommendationsPrev);
		if (pageUtils.verifyIfDisplayed(sliderRecommendationsPrev)
				&& pageUtils.verifyIfDisplayed(sliderRecommendationsNext)) {
			return true;
		}
		return false;
	}

	public boolean sliderRecommendationsIsFunctional() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "waiting for slider");
		if (pageUtils.waitTillWebElementIsClickable(sliderRecommendationsNext)) {
			jsExecutor.executeScript("arguments[0].click();", sliderRecommendationsNext);
			pageUtils.sleepSeconds(2, "waiting for slider");
			if (pageUtils.waitTillWebElementIsClickable(sliderRecommendationsPrev)) {
				jsExecutor.executeScript("arguments[0].click();", sliderRecommendationsPrev);
				return true;
			}
		}
		return false;
	}

	public void moveSliderToFirstElement() {
		if (!pageUtils.waitTillWebElementIsClickable(sliderRecommendationsNext)) {
			while (pageUtils.waitTillWebElementIsClickable(sliderRecommendationsPrev)) {
				jsExecutor.executeScript("arguments[0].click();", sliderRecommendationsPrev);
			}
		}
	}

	public void verifyProductsNameInRecommendationContainer() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForWebElement(recommendationContainer);
		moveSliderToFirstElement();
		int size = recommendationContainerMenu.size();
		for (int i = 0; i < size; i++) {
			pageUtils.sleepSeconds(3, "");
			WebElement productName = recommendationContainerMenu.get(i)
					.findElement(By.cssSelector(".product-tile-rfk .product-name-container a"));
			List<WebElement> productNameS = recommendationContainerMenu.get(i)
					.findElements(By.cssSelector(".product-tile-rfk .product-name-container a"));
			size = productNameS.size();
			Assert.assertTrue("Product name on " + i + " position is not displaying",
					pageUtils.verifyIfDisplayed(productName));
			if (!pageUtils.waitTillWebElementIsClickable(productName)) {
				jsExecutor.executeScript("arguments[0].click();", sliderRecommendationsNext);
				pageUtils.sleepSeconds(2, "");
			}
			Assert.assertTrue("Product name on " + i + " position is not Clickable",
					pageUtils.waitTillWebElementIsClickable(productName));
		}
	}

	public void verifyQuickViewInRecommendationContainer() {
		pageUtils.waitForPageToLoad();
		moveSliderToFirstElement();
		int size = recommendationContainerMenu.size();

		for (int i = 0; i < size; i++) {
			WebElement quickView = recommendationContainerMenu.get(i)
					.findElement(By.cssSelector(".product-tile-rfk .quickview-container .quickview-btn"));
			List<WebElement> quickViews = recommendationContainerMenu.get(i)
					.findElements(By.cssSelector(".product-tile-rfk .quickview-container .quickview-btn"));
			size = quickViews.size();
			Assert.assertTrue("Quick view on " + i + " position is not displaying",
					pageUtils.verifyIfDisplayed(quickView));
			if (!pageUtils.waitTillWebElementIsClickable(quickView)) {
				jsExecutor.executeScript("arguments[0].click();", sliderRecommendationsNext);
				pageUtils.sleepSeconds(2, "");
			}
			Assert.assertTrue("Quick view on " + i + " position is not Clickable",
					pageUtils.waitTillWebElementIsClickable(quickView));
		}
	}

	public void verifyColorOptionInRecommendationContainer() {
		pageUtils.waitForPageToLoad();
		moveSliderToFirstElement();
		int size = recommendationContainerMenu.size();

		for (int i = 0; i < size; i++) {
			try {
				WebElement color = recommendationContainerMenu.get(i)
						.findElement(By.cssSelector(".product-tile-rfk .product-color-container a"));
				List<WebElement> colors = recommendationContainerMenu.get(i)
						.findElements(By.cssSelector(".product-tile-rfk .product-color-container a"));
				size = colors.size();
				Assert.assertTrue("Color option on " + i + " position is not displaying",
						pageUtils.verifyIfDisplayed(color));
				if (!pageUtils.waitTillWebElementIsClickable(color)) {
					jsExecutor.executeScript("arguments[0].click();", sliderRecommendationsNext);
					pageUtils.sleepSeconds(2, "");

				}
				Assert.assertTrue("Color option on " + i + " position is not Clickable",
						pageUtils.waitTillWebElementIsClickable(color));
			} catch (Exception e) {
				context.writeOut("Color Option is not available for product in " + i + " position");
			}
		}
	}

	public void verifyProductPriceInRecommendationContainer() {
		pageUtils.waitForPageToLoad();
		moveSliderToFirstElement();
		int size = recommendationContainerMenu.size();

		for (int i = 0; i < size; i++) {
			try {
				WebElement normalPrice = recommendationContainerMenu.get(i)
						.findElement(By.cssSelector(".product-tile-rfk .product-price-container .Price"));
				List<WebElement> normalPrices = recommendationContainerMenu.get(i)
						.findElements(By.cssSelector(".product-tile-rfk .product-price-container"));
				size = normalPrices.size();
				Assert.assertTrue("Normal price on " + i + " position is not displaying",
						pageUtils.verifyIfDisplayed(normalPrice));
			} catch (Exception e) {
				WebElement priceWas = recommendationContainerMenu.get(i)
						.findElement(By.cssSelector(".product-tile-rfk .product-price-container .listPrice"));
				WebElement priceNow = recommendationContainerMenu.get(i)
						.findElement(By.cssSelector(".product-tile-rfk .product-price-container .salePrice"));
				Assert.assertTrue("Was price on " + i + " position is not displaying",
						pageUtils.verifyIfDisplayed(priceWas));
				Assert.assertTrue("Now price on " + i + " position is not displaying",
						pageUtils.verifyIfDisplayed(priceNow));
			}
		}
	}
	
	public boolean isColorSwatchDisplayed() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(10, "");
		if(device().equalsIgnoreCase("mobile")) {
			mkMobileProductListing.loadAllProducts();
		}else {
			loadAllProducts();
		}
		String countOfProduct = productCount.getText();
		int size = Integer.parseInt(countOfProduct);
		
		for(int i = 0; i<size; i++) {
			countOfProduct = productCount.getText();
			size = Integer.parseInt(countOfProduct);
			
			List<WebElement> elements = productTileContainerMenu.get(i).findElements(By.cssSelector(".swatch-link"));
			int size1 = elements.size();
			for(int j=0;j<elements.size();j++) {
				WebElement element= elements.get(j);
				WebElement ele = productTileContainerMenu.get(i).findElement(By.className("image-panel"));
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", ele);
				jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
				if(!element.getAttribute("class").contains("selected")) {
					jsExecutor.executeScript("arguments[0].click();", element);
				}
			}
		}
		return true;
	}
	
	public boolean isColorSwatchDisplayedOnPLPAndClickable() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(3, "");
		String countOfProduct = productCount.getText();
		int size = Integer.parseInt(countOfProduct);
		for(int i = 0; i<size; i++) {
			List<WebElement> elements = productTileContainerMenu.get(i).findElements(By.cssSelector(".swatch-link"));
			for(int j=0;j<elements.size();j++) {
				WebElement element= elements.get(j);
				WebElement ele = productTileContainerMenu.get(i).findElement(By.className("image-panel"));
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", ele);
				jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
				if(!element.getAttribute("class").contains("selected")) {
					jsExecutor.executeScript("arguments[0].click();", element);
				}
			}
		}
		return true;
	}
	
	public boolean isPriceAndNameNotChangedOnPLP() {
		boolean flag = false;
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(3, "");
		String countOfProduct = productCount.getText();
		int size = Integer.parseInt(countOfProduct);
		for(int i = 0; i<size; i++) {
			WebElement productContainer = productTileContainerMenu.get(i);
			List<WebElement> elements = productTileContainerMenu.get(i).findElements(By.cssSelector(".swatch-link"));
			for(int j=0;j<elements.size();j++) {
				WebElement element= elements.get(j);
				WebElement ele = productTileContainerMenu.get(i).findElement(By.className("image-panel"));
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", ele);
				jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
				String nameBefore =productContainer.findElement(By.cssSelector(".product-name-container a")).getText();
				String priceBefore = productContainer.findElement(By.cssSelector(".product-price-container a")).getText();
				if(!element.getAttribute("class").contains("selected")) {
					jsExecutor.executeScript("arguments[0].click();", element);
					String name =productContainer.findElement(By.cssSelector(".product-name-container a")).getText();
					String price = productContainer.findElement(By.cssSelector(".product-price-container a")).getText();
					if(name.equalsIgnoreCase(nameBefore)&&price.equalsIgnoreCase(priceBefore)) {
						flag = true;
					}
				}
			}
		}
		return flag;
	}
	
	public boolean isImageChangedClickingOnColorSwatch() {
		boolean flag = false;
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(3, "");
		String countOfProduct = productCount.getText();
		int size = Integer.parseInt(countOfProduct);
		for(int i = 0; i<size; i++) {
			WebElement productContainer = productTileContainerMenu.get(i);
			List<WebElement> elements = productTileContainerMenu.get(i).findElements(By.cssSelector(".swatch-link"));
			for(int j=0;j<elements.size();j++) {
				WebElement element= elements.get(j);
				WebElement ele = productTileContainerMenu.get(i).findElement(By.className("image-panel"));
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", ele);
				jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
				if(!element.getAttribute("class").contains("selected")) {
					jsExecutor.executeScript("arguments[0].click();", element);
					String image =productContainer.findElement(By.cssSelector(".product-image-container img")).getAttribute("src");
					String colorid = productContainer.findElement(By.cssSelector(".swatch-link")).getAttribute("data-colorid");
					if(image.contains(colorid)) {
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
		pageUtils.sleepSeconds(5, "");
		int size = productTileContainerMenu.size();
		int totalProduct=Integer.parseInt(productCount.getText());
		for (int i=0;i<totalProduct;i++) {
			WebElement productContainer = productTileContainerMenu.get(size-1);
			pageUtils.scrollToElement(productContainer.findElement(By.className("image-panel")));
			jsExecutor.executeScript(
					"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
					productContainer);
			jsExecutor.executeScript("return document.body.scrollHeight");
			pageUtils.scrollToElement(productTileContainerMenu.get(0));
			pageUtils.scrollToBottomOfPage();
			pageUtils.sleepSeconds(5, "");
			pageUtils.scrollToElement(productContainer.findElement(By.className("image-panel")));
			size = productTileContainerMenu.size();
			if(size>=totalProduct) {
				pageUtils.sleepSeconds(5, "");
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
	
	public boolean sortingLowToHighNA() {
		boolean flag = false;
		pageUtils.sleepSeconds(5, "wait for page load");
		String productFirstPrice="";
		List<Double> priceList = new ArrayList<>();
		/*
		 * WebElement ele =
		 * webDriver.findElement(By.cssSelector(".product-tile-view a")); try { if
		 * (!ele.getAttribute("class").contains("active")) { ele.click(); } } catch
		 * (Exception e) { // TODO: handle exception }
		 */
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
