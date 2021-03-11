package com.mk.testframework.dt.page.searchlisting;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.dt.util.PageUtils.Resource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.ResourceBundle;

/**
 * @author MLinderman
 *
 */
public class MkFilterResultsPanel_Common {

	@FindBy(css = ".facet_section_heading a")
	private List<WebElement> filterHeaders;
	 
	@FindBy(css = "#sort-select .selected-sort-item")
	private WebElement sortOpt;

	@FindBy(css = "#sort-select")
	private WebElement sortOption;

	@FindBy(css = "#sort-select option")
	private List<WebElement> sortOptions;

	private PageUtils pageUtils;
	private JavascriptExecutor jsExecutor;
	private Context context;

	@Inject
	public MkFilterResultsPanel_Common(WebDriver webDriver, PageUtils pageUtils, Context context) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.context = context;
	}

	public boolean isFilterHeaderCollapsed(String headerTitle) {
		boolean filterHeaderCollapsed = false;
		String translatedMenuTitle = getTranslation(headerTitle).toLowerCase();

		WebElement menuLink = filterHeaders.stream().filter(s -> s.getAttribute("aria-label").toLowerCase().contains(translatedMenuTitle)).findFirst().get();

		jsExecutor.executeScript("arguments[0].scrollIntoView();", menuLink);
		pageUtils.waitForAjaxToComplete();

		if (menuLink.getAttribute("aria-label").toLowerCase().contains("expand")) {
			filterHeaderCollapsed = true;
		}

		return filterHeaderCollapsed;
	}

	public void clickFilterHeader(String headerTitle) {
		String translatedMenuTitle = getTranslation(headerTitle).toLowerCase();

		WebElement menuLink = filterHeaders.stream().filter(s -> s.getAttribute("aria-label").toLowerCase().contains(translatedMenuTitle)).findFirst().get();
		jsExecutor.executeScript("arguments[0].scrollIntoView();", menuLink);
		pageUtils.waitForAjaxToComplete();
		jsExecutor.executeScript("arguments[0].click();", menuLink);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(1, "Wait for menu to open");
	}

	public void clickSizeFilterHeader() {
		clickFilterHeader("size");
	}

	public void openSizeFilterIfClosed() {
		String headerTitle = "size";

		if (isFilterHeaderCollapsed(headerTitle)) {
			clickFilterHeader(headerTitle);
		}
	}

	public void openColorFilterIfClosed() {
		String headerTitle = "color";

		if (isFilterHeaderCollapsed(headerTitle)) {
			clickFilterHeader(headerTitle);
		}
	}

	public void openPriceFilterIfClosed() {
		String headerTitle = "price";

		if (isFilterHeaderCollapsed(headerTitle)) {
			clickFilterHeader(headerTitle);
		}
	}
	
	public void clickPriceFilterHeader() {
		clickFilterHeader("price");
	}

	public void clickColorFilterHeader() {
		clickFilterHeader("color");
	}

	public void clickCategoryFilterHeader() {
		clickFilterHeader("category");
	}

	private String getTranslation(String filterHeader) {
		ResourceBundle countryResource = pageUtils.getResourceBundle(PageUtils.Resource.FILTERS);
		return countryResource.getString(pageUtils.buildResourceLookupKey(filterHeader));
	}
	
	public String getsorttext() {
		pageUtils.sleepSeconds(3, "wait for page load");
		String Sorttext = sortOpt.getText().strip();
		return Sorttext;
	}
	
	public String getTranslationSORT(String sOption) {
		ResourceBundle sortResource = pageUtils.getResourceBundle(Resource.SORT);
		return sortResource.getString(pageUtils.buildResourceLookupKey(sOption));
	}
	
	public void SelectSortOption(String sOption) {
		pageUtils.sleepSeconds(5, "Wait for page load");
		String option = getTranslationSORT(sOption).strip();
		pageUtils.waitForWebElement(sortOption);
		Select sel = new Select(sortOption);
		sel.selectByVisibleText(option);
		context.setSortOptions(option);
		pageUtils.waitForAjaxToComplete();
	}

}