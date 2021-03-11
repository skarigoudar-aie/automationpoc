package com.mk.testframework.dt.page.searchlisting;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.util.PageUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * @author MLinderman
 *
 */
public class MkFilterResultsPanel_NA {

	@FindBy(css = ".facet-size-options div")
	private List<WebElement> sizeFacetOptions;

	@FindBy(css = ".facet-size-label")
	private List<WebElement> sizeFacetLabels;

	@FindBy(css = ".color-swatch")
	private List<WebElement> colorFacetOptions;

	private PageUtils pageUtils;
	private JavascriptExecutor jsExecutor;
	private WebDriver webDriver;
	private Context context;

	@Inject
	public MkFilterResultsPanel_NA(WebDriver webDriver, PageUtils pageUtils, Context context) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.webDriver = webDriver;
		this.context = context;
	}

	public void clickSizeFacetOption(int position) {
		int index = (position -1);

		jsExecutor.executeScript("arguments[0].scrollIntoView();", sizeFacetLabels.get(index));
		pageUtils.waitForAjaxToComplete();
		jsExecutor.executeScript("arguments[0].click();", sizeFacetLabels.get(index));

		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.attributeContains(sizeFacetOptions.get(index),"class","selected"));

		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
	}

	public void clickColorFacetOption(int position) {
		int index = (position - 1);

		jsExecutor.executeScript("arguments[0].scrollIntoView();", colorFacetOptions.get(index));
		pageUtils.waitForAjaxToComplete();
		jsExecutor.executeScript("arguments[0].click();", colorFacetOptions.get(index));

		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.attributeContains(colorFacetOptions.get(index),"class","selected"));

		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
	}
	
	public void clickPriceFacetOption(int position) {
		int index = (position - 1);
		String price = pageUtils.getFilterTranslation("price");
		List<WebElement> priceFacetOptions = webDriver.findElements(By.xpath("//*[contains(@for,'"+price+"')]"));
		
		jsExecutor.executeScript("arguments[0].scrollIntoView();", priceFacetOptions.get(index));
		pageUtils.waitForAjaxToComplete();
		jsExecutor.executeScript("arguments[0].click();", priceFacetOptions.get(index));
		context.saveData("facetSelected", priceFacetOptions.get(index).getText());
		context.writeOut("Selected Facet is: "+priceFacetOptions.get(index).getText());
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
	}
}
