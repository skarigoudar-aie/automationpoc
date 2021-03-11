package com.mk.testframework.dt.page.product;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.util.PageUtils;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MkProductQuickView {

	@FindBy(css = "#quick-view-container")
	private WebElement productQuickView;

	@FindBy(xpath = "//ul[@class='color-swatch-list']//ul[@class='facet-section']//li")
	private List<WebElement> colorFacetsList;

	@FindBy(css = ".color-container .selected-color")
	private WebElement selectedColor;

	@FindBy(xpath = "//div[@class='Select-control']")
	private WebElement qtyDropDown;

	@FindBy(css = ".add-to-cart-sticky")
	private WebElement addToCartQV;

	@FindBy(css = ".click-and-collect-container")
	private WebElement clickAndCollect;

	@FindBy(css = ".wishlist-section")
	private WebElement addToWishList;

	@FindBy(css = ".favorites-section")
	private WebElement addToFavorites;

	@FindBy(css = ".qv-arrow-container button")
	private List<WebElement> arrowPrevandNext;

	@FindBy(css = ".thumbnail-list li")
	private List<WebElement> thumbnilImageList;

	@FindBy(css = ".product-details-container li")
	private List<WebElement> productDetailContainer;

	@FindBy(css = ".commerce-area-wrapper .product-price-container")
	private WebElement productPriceContainer;

	@FindBy(css = ".commerce-area-wrapper .product-price-container .productAmount")
	private WebElement listPrice;

	@FindBy(css = "#quickViewCloseBtn")
	private WebElement quickViewCloseBtn;

	@FindBy(xpath = "//div[@class='commerce-area-wrapper']//div")
	private List<WebElement> commerceArea;

	@FindBy(css = ".qv-arrow-container .slick-prev")
	private WebElement prevArrow;

	@FindBy(css = ".qv-arrow-container .slick-next")
	private WebElement nextArrow;

	private PageUtils pageUtils;
	private Environment env;

	@Inject
	public MkProductQuickView(WebDriver webDriver, PageUtils pageUtils, Environment env) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.env = env;
	}

	public boolean waitForProductQuickview() {
		return pageUtils.waitForWebElement(productQuickView);
	}

	public boolean isProductNameDisplayed() {
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

	public boolean isBrandNameDisplayed() {
		pageUtils.sleepSeconds(2, "Waiting for Brand Name");
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

	public boolean isQuickViewProductPriceDisplayed() {
		pageUtils.sleepSeconds(2, "Waiting for price to display");
		boolean flag = false;

		if (productPriceContainer.isDisplayed()) {
			flag = true;
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

	public boolean isQuickViewFavoriteLinkDisplayed() {

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
		pageUtils.waitForWebElement(addToCartQV);
		boolean flag = false;
		if (addToCartQV.isDisplayed()) {
			flag = true;
		}
		return flag;
	}

	public boolean isPickupInStoreButtonDisplayed() {
		pageUtils.waitForWebElement(clickAndCollect);
		boolean flag = false;
		if (clickAndCollect.isDisplayed()) {
			flag = true;
		}
		return flag;
	}

	public boolean isPrevNextButtonDisplayed() {
		pageUtils.sleepSeconds(2, "Waiting for prev and next arrow to display");
		nextArrow.click();
		boolean flag = false;
		boolean nextFlag = false;
		boolean previousFlag = false;
		for (int i = 0; i <= arrowPrevandNext.size() - 1; i++) {
			if (arrowPrevandNext.get(i).getAttribute("class").contains("slick-prev")) {
				previousFlag = true;
				System.out.println("Previous arrow exist");
			}
			if (arrowPrevandNext.get(i).getAttribute("class").contains("slick-next")) {
				nextFlag = true;
				System.out.println("Next arrow exist");
			}
			if (previousFlag || nextFlag) {
				flag = true;
			}
		}

		return flag;
	}

	public boolean qtyDropDown() {
		boolean flag = false;
		if (qtyDropDown.isDisplayed()) {
			flag = true;
		}
		return flag;
	}

	public boolean isStyleNumberDisplayed() {
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

	public boolean isCloseOption() {
		boolean flag = false;
		if (quickViewCloseBtn.isDisplayed()) {
			flag = true;
		}
		return flag;
	}

	public void closeOption() {
		quickViewCloseBtn.click();
		pageUtils.waitForPageToLoad();
	}

	public boolean clickOnNextArrow() {
		boolean flag = false;
		int thumbnilImages = thumbnilImageList.size();
		pageUtils.sleepSeconds(1, "waiting to get selected image");
		if (thumbnilImages > 1) {
			for (int i = 0; i <= thumbnilImages; i++) {
				System.out.println(thumbnilImageList.get(i).getAttribute("class").contains("focused"));
				if (thumbnilImageList.get(i).getAttribute("class").contains("focused")) {

					if (nextArrow.isDisplayed()) {
						prevArrow.click();
						flag = true;
						break;
					} else {
						nextArrow.click();
						flag = true;
						break;
					}
				}
			}
		} else {
			System.out.println("Only one image exist");
			flag = true;
		}
		return flag;
	}

	public boolean isFindInStoreLinkDisplayed() {
		boolean flag = false;
		for (int i = 0; i <= commerceArea.size() - 1; i++) {
			boolean status = commerceArea.get(i).getText().contains("Find In Store");
			if (status) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}
}
