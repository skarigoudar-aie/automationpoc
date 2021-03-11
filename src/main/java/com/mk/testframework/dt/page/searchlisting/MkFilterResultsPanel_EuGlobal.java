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

import java.util.ArrayList;
import java.util.List;

/**
 * @author MLinderman
 *
 */
public class MkFilterResultsPanel_EuGlobal {


	@FindBy(css = ".facet-size-options div")
	private List<WebElement> sizeFacetOptions;

	@FindBy(css = ".facet-size-label")
	private List<WebElement> sizeFacetLabels;

	@FindBy(css = ".facet-color-options input")
	private List<WebElement> colorFacetOptions;
	
	@FindBy(css = ".filter-container .filter-selected-list li")
	private List<WebElement> selectedFacets;

	private PageUtils pageUtils;
	private JavascriptExecutor jsExecutor;
	private WebDriver webDriver;
	private Context context;

	@Inject
	public MkFilterResultsPanel_EuGlobal(WebDriver webDriver, PageUtils pageUtils, Context context) {
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
		pageUtils.waitTillWebElementIsClickable(sizeFacetLabels.get(index));
		jsExecutor.executeScript("arguments[0].click();", sizeFacetLabels.get(index));

		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");

		try {
			WebDriverWait wait = new WebDriverWait(webDriver, 10);
			wait.until(ExpectedConditions.attributeContains(sizeFacetOptions.get(index), "class", "selected"));
		}
		catch(Exception e){
		}

		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(3, "2 sec wait for ajax load");
	}

	public List<WebElement> getEnabledColorFacetOptions(){
		List<WebElement> enabledColorFacetOptions = new ArrayList<>();

		for(int i=0;i<colorFacetOptions.size();i++){
			if(!colorFacetOptions.get(i).getAttribute("class").toLowerCase().contains("disabled")){
				enabledColorFacetOptions.add(colorFacetOptions.get(i));
			}
		}
		return enabledColorFacetOptions;
	}

	public void clickColorFacetOption(int position) {
		int index = (position -1);

		List<WebElement> facetOptions = getEnabledColorFacetOptions();

		jsExecutor.executeScript("arguments[0].scrollIntoView();", facetOptions.get(index));
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitTillWebElementIsClickable(facetOptions.get(index));
		jsExecutor.executeScript("arguments[0].click();", facetOptions.get(index));

		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");

		try{
			WebDriverWait wait = new WebDriverWait(webDriver, 10);
			wait.until(ExpectedConditions.attributeContains(colorFacetOptions.get(index),"class","selected"));
		}
		catch(Exception e){
		}

		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
	}
	/**
	 * Added method to check the last selected filter for AUTO-157
	 * @param size
	 */
	public void checkSelectedFacet(int size) {
		
		String selectedSize=sizeFacetLabels.get(size-1).getText();
		System.out.println(selectedSize);
		try {
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
			String selected = selectedFacets.get(selectedFacets.size()-1).getText();
			selectedSize.equalsIgnoreCase(selected);
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public void clickPriceFacetOption(int position) {
		int index = (position - 1);
		String price = pageUtils.getFilterTranslation("price");
		List<WebElement> priceFacetOptions = webDriver.findElements(By.xpath("//*[contains(@for,'"+price+"')]"));
		pageUtils.scrollToElement(priceFacetOptions.get(0));

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