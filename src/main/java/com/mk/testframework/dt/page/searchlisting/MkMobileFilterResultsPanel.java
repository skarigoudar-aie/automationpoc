package com.mk.testframework.dt.page.searchlisting;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.util.PageUtils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author MLinderman
 *
 */
public class MkMobileFilterResultsPanel {

	@FindBy(css = ".filter-mobile-heading")
	private WebElement filterButton;

	@FindBy(css = ".filter-container-open")
	private WebElement openFilterContainer;

	@FindBy(css = ".apply-button-container button")
	private WebElement applyFilterButton;
	
	@FindBy(css = ".filter-container-close-button")
	private WebElement closeFilter;
	
	@FindBy(xpath = "//*[@class='facet-panel-count']/text()[1]")
	private WebElement productTotalCount;
	
	@FindBy(css = ".facet-panel-count")
	private WebElement PLPproductTotalCount;
		
	@FindBy(css = ".product-name-container")
	private List<WebElement> productNamePLP;
	
	@FindBy(css = ".product-price-container")
	private List<WebElement> productPricePLP;
	
	@FindBy(css = ".product-price-container .Price .productAmount")
	private List<WebElement> priceOfProductEU;
	
	@FindBy(css = ".Price .productAmount")
	private List<WebElement> ListpriceOfProductEU;
	
	@FindBy(css = ".description-panel .product-price-container a .salePrice .productAmount")
	public WebElement salePriceEU;
	
	@FindBy(css = ".description-panel .product-price-container a .listPrice .productAmount")
	public List<WebElement> listPriceEU;

	@FindBy(css = ".description-panel .product-price-container a .listPrice .ada-link [aria-hidden='true']")
	public List<WebElement> listPriceNA;
		
	@FindBy(css = ".product-price-container .Price [aria-hidden=\"true\"]")
	private List<WebElement> priceOfProductNA;
	
	@FindBy(xpath = "//*[@id='/result/totalProducts']/td[2]")
	private WebElement totalProducts;
	
	@FindBy(css = ".product-color-swatches-container")
	private List<WebElement> productSwatchContainer;
	
	@FindBy(css = ".product-color-swatches-container li")
	private WebElement productSwatchColor;

	@FindBy(css = ".tile-listing .product-tile")
	private List<WebElement> productTileContainerMenu;
	
	private PageUtils pageUtils;
	private JavascriptExecutor jsExecutor;
	private WebDriver webDriver;
	private Context context;

	@Inject
	public MkMobileFilterResultsPanel(WebDriver webDriver, PageUtils pageUtils, Context context) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.webDriver = webDriver;
		this.context = context;
	}

	public void clickFilterButton() {
		jsExecutor.executeScript("arguments[0].click();", filterButton);
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
	}

	public void openFiltersIfClosed() {
		if(!pageUtils.verifyIfDisplayed(openFilterContainer)){
			clickFilterButton();
		}
	}

	public void clickApplyFilterButton(){
		jsExecutor.executeScript("arguments[0].click();", applyFilterButton);
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
	}
	
	public void clickOnCloseFilter() {
		jsExecutor.executeScript("arguments[0].click();", closeFilter);
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
	}
	
	public boolean isPriceFilterCurrencyFormatProper() {
		boolean flag=false;
		clickFilterButton();
		String Price=pageUtils.getFilterTranslation("price");
		WebElement element=webDriver.findElement(By.xpath("//a[contains(text(),'"+Price+"')]"));
		element.click();
		List<WebElement> ele=webDriver.findElements(By.xpath("//*[contains(@for,'"+Price+"')]"));
		int size=ele.size();
		
		for(int i=0;i<size;i++) {
			System.out.println(ele.get(i).getText());
			String[] str=ele.get(i).getText().split("-");
			String s= str[1];
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
		clickOnCloseFilter();
		return flag;
	}

	  public boolean isProductAndProductCountMatch() {
		  boolean flag=false;
		  pageUtils.waitForPageToLoad();
		  pageUtils.sleepSeconds(3, "");
		  loadAllProducts();
		   List<String> currentOptions = new ArrayList<>();
		   context.writeOut(PLPproductTotalCount.getText().replaceAll("\\D+", "").replace(" ", "").trim());
		   int productCount=productNamePLP.size();
		   int count=Integer.parseInt(PLPproductTotalCount.getText().replaceAll("\\D+", "").replace(" ", "").trim());
		  for(int i=0; i<productCount;i++) {
			  WebElement row=productNamePLP.get(i);
			  if(row.getText().isBlank()||row.getText().isEmpty()) {
				  flag=false;
			  }else if(!row.getText().isBlank()||!row.getText().isEmpty()) {
				  currentOptions.add(row.getText());
			  }
			  productCount = productNamePLP.size();
			  pageUtils.sleepSeconds(1, "");
			  if(count==currentOptions.size()) {
				  flag=true;
			  }
		  }
		  context.writeOut("Total products count displayed on the Page: "+count+" Total Products available: "+currentOptions.size());
		  return flag;
	  }
	  
		public void loadAllProducts() {
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(3, "");
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
					WebElement element = webDriver.findElement(By.tagName("header"));
					jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
					pageUtils.sleepSeconds(3, "");
				break;
				}
			}	
		}
}
