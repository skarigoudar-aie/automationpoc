package com.mk.testframework.dt.page.searchlisting;

import com.mk.testframework.dt.util.PageUtils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.google.inject.Inject;

/**
 * @author VThipperudrappa
 *
 */
public class MkSortResultCountPanel {

	@FindBy(css = ".sort-result-count-panel .product-count")
	private WebElement productCount;
	
	@FindBy(xpath = "//*[@class='facet-panel-count']")
	private WebElement productCountMobile;
	
	@FindBy(id = "search-box")
	private WebElement searchBox;
	
	private PageUtils pageUtils;

	@Inject
	public MkSortResultCountPanel(WebDriver webDriver, PageUtils pageUtils) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
	}

	public boolean waitForProductCount() {
		boolean flag = false;
		try {
			if(productCount.isDisplayed() || productCountMobile.isDisplayed()) {
				flag =true;
			}
		} catch (Exception e) {
			pageUtils.sleepSeconds(5, "2 sec wait for ajax load");
			flag = pageUtils.waitForWebElement(productCount);
		}
		return flag;
	}

	public int getProductCount() {
		int count = 0;

		waitForProductCount();

		try {
			count = Integer.parseInt(productCount.getAttribute("innerText"));
		} catch (Exception e) {
			try {
				pageUtils.sleepSeconds(5, "5 sec wait for ajax load");
				count = Integer.parseInt(productCountMobile.getText());
			} catch (Exception e2) {
				pageUtils.refresh();
				pageUtils.sleepSeconds(10, "2 sec wait for ajax load");
				count = Integer.parseInt(productCount.getAttribute("innerText"));
			}
		}

		return count;
	}

}
