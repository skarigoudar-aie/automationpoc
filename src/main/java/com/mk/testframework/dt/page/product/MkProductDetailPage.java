package com.mk.testframework.dt.page.product;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.util.PageUtils;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MkProductDetailPage {

	@FindBy(css = ".klarna--messaging--container")
	private WebElement klarnaWidget;

	@FindBy(xpath = "//*[@class='bv-primarySummary-rating-container']/*//button | //*[@class='bv-primarySummary-rating-container']")
	private WebElement ratingsContainer;

	@FindBy(css = ".bv-primarySummary-rating-container .bv-rating-stars-on.bv-rating-stars")
	private WebElement ratingStars;

	@FindBy(css = ".bv-primarySummary-rating-container .bv-write-review")
	private WebElement ratingsWriteReviewLink;

	@FindBy(css = "#BVRRContainer")
	private WebElement reviewsContainer;

	@FindBy(css = "#BVRRContainer .bv-write-review")
	private WebElement reviewsWriteReviewButton;

	@FindBy(css = "#BVRRContainer .bv-write-review-label")
	private WebElement reviewsWriteReviewLink;

	@FindBy(css = ".recommended-container")
	private WebElement recommendationContainer;

	@FindBy(css = ".recommended-container .swiper-container .swiper-button-next")
	private WebElement sliderRecommendationsNext;

	@FindBy(css = ".recommended-container .swiper-container .swiper-button-prev")
	private WebElement sliderRecommendationsPrev;

	@FindBy(xpath = "(//*[@class='swiper-wrapper'])[1]/div")
	private List<WebElement> recommendationContainerMenu;
	
    @FindBy(css = ".detail")
	private WebElement productDetails;
	
	@FindBy(xpath = "//ul[@class='breadcrumbs-listing']/li[2]")
	private WebElement clickOnbreadCrumb;
	
	@FindBy(xpath = "//ul[@class='breadcrumbs-listing']/li[3]")
	private WebElement getbreadCrumbtext;
	
	@FindBy(css = ".navigation-panel .nav-category-list .highlight")
	private WebElement getProductListPageName;
	
	@FindBy(css = ".plp-category-heading h1")
	private WebElement pageName;
	
	@FindBy(css = ".mk-search-page")
	private WebElement searchPage;

	@FindBy(css = ".mk-search-page-rfk")
	private WebElement rfk_searchPage;
	
	@FindBy(css = ".breadcrumbs-listing li")
    private List<WebElement> breadCrumbList;
	
	@FindBy(css = ".mk-plp-page")
	private WebElement plpPageList;

	private PageUtils pageUtils;
	private WebDriver webDriver;
	private Context context;
	private JavascriptExecutor jsExecutor;

	@Inject
	public MkProductDetailPage(WebDriver webDriver, PageUtils pageUtils, Context context) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.webDriver = webDriver;
		this.context = context;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
	}

	public boolean isKlarnaWidgetDisplayed() {
		pageUtils.waitForWebElement(klarnaWidget);
		return pageUtils.verifyIfDisplayed(klarnaWidget);
	}

	public boolean isRatingsContainerDisplayed() {
		boolean flag = true;
		try {
			pageUtils.waitForAjaxToComplete();
			WebDriverWait wait = new WebDriverWait(webDriver, 5);
			wait.until(ExpectedConditions.visibilityOf(ratingsContainer));
			pageUtils.scrollToElement(ratingsContainer);

		} catch (Exception e) {
			try {
				webDriver.findElement(By.tagName("body")).sendKeys(Keys.ARROW_DOWN);
				WebDriverWait wait = new WebDriverWait(webDriver, 10);
				wait.until(ExpectedConditions.visibilityOf(ratingsContainer));
			} catch (Exception e2) {
				webDriver.findElement(By.tagName("body")).sendKeys(Keys.ARROW_DOWN);
				WebDriverWait wait = new WebDriverWait(webDriver, 5);
				wait.until(ExpectedConditions.visibilityOf(ratingsContainer));
			}
		}
		return flag;
	}

	public void clickRatingStars() {
		pageUtils.waitTillWebElementIsClickable(ratingStars);
		ratingStars.click();
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "1 sec wait for ajax load");
	}

	public void clickRatingWriteReviewLink() {
	try {
		pageUtils.scrollToElement(ratingsContainer);
		ratingsWriteReviewLink.click();
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(5, "10 sec wait for ajax load");
	} catch (Exception e) {
		try {
			if (ratingsWriteReviewLink.isDisplayed()) {
				jsExecutor.executeScript("arguments[0].click();", ratingsWriteReviewLink);
			} 
		} catch (Exception e2) {
			pageUtils.sleepSeconds(5, "10 sec wait for ajax load");
		}
		
	}
	}

	public void clickReviewsWriteReviewButton() {

		try {
			pageUtils.scrollToBottomOfPage();
			pageUtils.scrollToElement(reviewsContainer);
			pageUtils.waitForWebElement(reviewsWriteReviewButton);
			reviewsWriteReviewButton.click();
		} catch (Exception e) {
			pageUtils.scrollToBottomOfPage();
			pageUtils.scrollToElement(reviewsContainer);
			pageUtils.waitForWebElement(reviewsWriteReviewLink);
			reviewsWriteReviewLink.click();
		}

		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "1 sec wait for ajax load");
	}

	public boolean productRecommendationRFKIsDisplayed() {
		pageUtils.scrollToBottomOfPage();
		pageUtils.sleepSeconds(10, "wait for recommendation");
		pageUtils.scrollToElement(productDetails);
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
		for (int i = 0; i < recommendationContainerMenu.size(); i++) {
			try {
				WebElement productName = recommendationContainerMenu.get(i)
						.findElement(By.cssSelector(".product-tile-rfk .product-name-container a"));
				Assert.assertTrue("Product name on " + i + " position is not displaying",
						pageUtils.verifyIfDisplayed(productName));
				if (!pageUtils.waitTillWebElementIsClickable(productName)) {
					jsExecutor.executeScript("arguments[0].click();", sliderRecommendationsNext);
				}
				Assert.assertTrue("Product name on " + i + " position is not Clickable",
						pageUtils.waitTillWebElementIsClickable(productName));
			} catch (Exception e) {
				// TODO: handle exception
			}	
			
		}
	}

	public void verifyQuickViewInRecommendationContainer() {
		pageUtils.waitForPageToLoad();
		moveSliderToFirstElement();
		for (int i = 0; i < recommendationContainerMenu.size(); i++) {
			try {
				WebElement quickView = recommendationContainerMenu.get(i)
						.findElement(By.cssSelector(".product-tile-rfk .quickview-container .quickview-btn"));
				Assert.assertTrue("Quick view on " + i + " position is not displaying",
						pageUtils.verifyIfDisplayed(quickView));
				if (!pageUtils.waitTillWebElementIsClickable(quickView)) {
					jsExecutor.executeScript("arguments[0].click();", sliderRecommendationsNext);
				}
				Assert.assertTrue("Quick view on " + i + " position is not Clickable",
						pageUtils.waitTillWebElementIsClickable(quickView));
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}

	public void verifyColorOptionInRecommendationContainer() {
		pageUtils.waitForPageToLoad();
		for (int i = 0; i < recommendationContainerMenu.size(); i++) {
			try {
				WebElement color = recommendationContainerMenu.get(i)
						.findElement(By.cssSelector(".product-tile-rfk .product-color-container a"));
				Assert.assertTrue("Color option on " + i + " position is not displaying",
						pageUtils.verifyIfDisplayed(color));
				WebElement productName = recommendationContainerMenu.get(i)
						.findElement(By.cssSelector(".product-tile-rfk .product-name-container a"));
				pageUtils.scrollToElement(productName);
				context.saveData("Product-Name", productName.getText());
				pageUtils.scrollToElement(color);
				jsExecutor.executeScript(
						"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						color);
				String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
				color.sendKeys(selectLinkOpeninNewTab);
				String winHandleBefore = webDriver.getWindowHandle();
				for(String winHandle : webDriver.getWindowHandles()){
					webDriver.switchTo().window(winHandle);
				}
				pageUtils.sleepSeconds(5, "");
				WebElement productNamePDP=webDriver.findElement(By.cssSelector(".product-name"));
				WebElement colorSwathes=webDriver.findElement(By.cssSelector(".facet-color-options"));
				Assert.assertTrue("Product Name matched", context.getSavedData("Product-Name").equalsIgnoreCase(productNamePDP.getText()));
				pageUtils.verifyIfDisplayed(colorSwathes);
				webDriver.close();
				webDriver.switchTo().window(winHandleBefore);

				Assert.assertTrue("Color option on " + i + " position is not Clickable",
						pageUtils.waitTillWebElementIsClickable(color));
			} catch (Exception e) {

			}
		}
	}

	public void verifyProductPriceInRecommendationContainer() {
		pageUtils.waitForPageToLoad();
		moveSliderToFirstElement();
		for (int i = 0; i < recommendationContainerMenu.size(); i++) {
			try {
				WebElement normalPrice = recommendationContainerMenu.get(i)
						.findElement(By.cssSelector(".product-tile-rfk .product-price-container .Price"));
				Assert.assertTrue("Normal price on " + i + " position is not displaying",
						pageUtils.verifyIfDisplayed(normalPrice));
			} catch (Exception e) {
				//context.writeOut("There is no full price item");
			}
			try {
				WebElement priceWas = recommendationContainerMenu.get(i)
						.findElement(By.cssSelector(".product-tile-rfk .product-price-container .listPrice"));
				WebElement priceNow = recommendationContainerMenu.get(i)
						.findElement(By.cssSelector(".product-tile-rfk .product-price-container .salePrice"));
				Assert.assertTrue("Was price on " + i + " position is not displaying",
						pageUtils.verifyIfDisplayed(priceWas));
				Assert.assertTrue("Now price on " + i + " position is not displaying",
						pageUtils.verifyIfDisplayed(priceNow));
			} catch (Exception e) {
				//context.writeOut("There is no sale price item");
			}
		}
	}
    
	public boolean verifyBreadCrumbNavigation() {
		boolean flag = false;
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(2, "wait for page load");

		try {
			String currentUrl1 = pageUtils.getCurrentUrl();
			context.writeOut("url before is: " + currentUrl1);
			int breadCrumbSize = breadCrumbList.size() - 1;
			System.out.println(breadCrumbSize);
			for (int i = 0; i < breadCrumbSize; i++) {
				String s = breadCrumbList.get(i).getText();
				context.writeOut(s);

				if (i == (breadCrumbSize - 1)) {

					breadCrumbList.get(i).click();
					break;
				}
			}

			pageUtils.waitForAjaxToComplete();
			pageUtils.waitForPageToLoad();
			pageUtils.sleepSeconds(2, "wait for page load");
			String breadcrumbTextafter = getbreadCrumbtext.getText();
			context.writeOut("breadCrumb link is after: " + breadcrumbTextafter);

			String plpPage = getProductListPageName.getText();
			context.writeOut("PLP page is: " + plpPage);

			String currentUrl = pageUtils.getCurrentUrl();
			context.writeOut("url after is: " + currentUrl);

			if (plpPage.equalsIgnoreCase(breadcrumbTextafter) && currentUrl1 != currentUrl) {
				flag = true;
				context.writeOut("Breadcrumb link navigated to Respective page");
				pageUtils.sleepSeconds(5, "wait for page load");
			}
		} catch (Exception e) {

		}
		return flag;
	}
	
	public boolean verifyBreadCrumbNavigationPDP() {
		boolean flag = false;
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "wait for page load");
		String plpBefore = "";

		try {
			  String currentUrl1 = pageUtils.getCurrentUrl();
			  context.writeOut("url before is: " + currentUrl1);
			 
			int breadCrumbSize = breadCrumbList.size() - 1;
			System.out.println(breadCrumbSize);
			for (int i = 0; i < breadCrumbSize; i++) {
				String s = breadCrumbList.get(i).getText();
				context.writeOut(s);

				if (i == (breadCrumbSize - 1)) {

					breadCrumbList.get(i).click();
					 plpBefore = breadCrumbList.get(i).getText().replaceAll("[^aA-zZ]", "");
					break;
				}
			}

			pageUtils.waitForAjaxToComplete();
			pageUtils.waitForPageToLoad();
			pageUtils.sleepSeconds(10, "wait for page load");

			String plpPage = context.getSavedData("plpName");
			context.writeOut("PLP page is: " + plpPage);

			String currentUrl = pageUtils.getCurrentUrl();
			context.writeOut("url after is: " + currentUrl);

			if (plpPage.equalsIgnoreCase(plpBefore) ||pageUtils.verifyIfDisplayed(plpPageList) ) {
				flag = true;
				context.writeOut("Breadcrumb link navigated to Respective page");
				pageUtils.sleepSeconds(5, "wait for page load");
			}
		} catch (Exception e) {

		}
		return flag;
	}
	
	public boolean verifyBreadCrumbNavigationToSLP() { 
		boolean flag = false;
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(10, "wait for page load");
		try {
			clickOnbreadCrumb.click();
			pageUtils.waitForAjaxToComplete();
			pageUtils.waitForPageToLoad();
			pageUtils.sleepSeconds(5, "wait for page load");
			boolean status = pageUtils.verifyIfDisplayed(searchPage);
			if (!status) {
				flag = pageUtils.verifyIfDisplayed(rfk_searchPage);
							context.writeOut("Breadcrumb link navigated to Respective page");
				pageUtils.sleepSeconds(5, "wait for page load");
			}else {
				flag =pageUtils.verifyIfDisplayed(searchPage);
			}
		} catch (Exception e) {

		}
		return flag;
	}
}
