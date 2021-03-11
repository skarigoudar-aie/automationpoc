package com.mk.testframework.dt.mobile;

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
import com.mk.testframework.dt.util.PageUtils;

/**
 * 
 * @author Shiva
 *
 */
public class MkMobileSearchListing {

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
	
	@FindBy(xpath = "//*[@class='facet-panel-count']")
	private WebElement productCount;
	
	private PageUtils pageUtils;
	private WebDriver webDriver;
	private Context context;
	private JavascriptExecutor jsExecutor;

	@Inject
	public MkMobileSearchListing(WebDriver webDriver, PageUtils pageUtils, Context context) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.webDriver = webDriver;
		this.context = context;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
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
		pageUtils.sleepSeconds(3, "");
		pageUtils.waitForWebElement(productCount);
		String countOfProduct = productCount.getText().replaceAll("[^0-9]", "");
		int size = Integer.parseInt(countOfProduct);
		for(int i = 0; i<size; i++) {
			int productsOnPage=productTileContainerMenu.size();
			countOfProduct = productCount.getText().replaceAll("[^0-9]", "");
			size = Integer.parseInt(countOfProduct);
			if(size>productsOnPage) {
				pageUtils.scrollToElement(productTileContainerMenu.get(productsOnPage-1).findElement(By.className("image-panel")));
				pageUtils.waitForPageToLoad();
				pageUtils.waitForAjaxToComplete();
				countOfProduct = productCount.getText().replaceAll("[^0-9]", "");
				size = Integer.parseInt(countOfProduct);
				productsOnPage=productTileContainerMenu.size();
			}
			List<WebElement> elements = productTileContainerMenu.get(i).findElements(By.cssSelector(".swatch-link"));
			for(int j=0;j<elements.size();j++) {
				WebElement element= elements.get(j);
				WebElement ele = productTileContainerMenu.get(i).findElement(By.className("image-panel"));
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", ele);
				jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
				if(!element.getAttribute("class").contains("selected")) {
					jsExecutor.executeScript("arguments[0].click();", element);
				}
				if(j==4) {
					break;
				}
			}
		}
		return true;
	}
	
	public boolean isColorSwatchDisplayedOnPLPAndClickable() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(3, "");
		String countOfProduct = productCount.getText().replaceAll("[^0-9]", "");
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
				if(j==4) {
					break;
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
		String countOfProduct = productCount.getText().replaceAll("[^0-9]", "");
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
				if(j==4) {
					break;
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
		String countOfProduct = productCount.getText().replaceAll("[^0-9]", "");
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
				if(j==4) {
					break;
				}
			}
		}
		return flag;
	}
}
