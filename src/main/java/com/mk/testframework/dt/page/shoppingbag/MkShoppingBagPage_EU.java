package com.mk.testframework.dt.page.shoppingbag;

import com.google.inject.Inject;
import com.mk.testframework.dt.util.PageUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MkShoppingBagPage_EU {

    private PageUtils pageUtils;
	private WebDriver webDriver;
    
    @Inject
    public MkShoppingBagPage_EU(WebDriver webDriver, PageUtils pageUtils) {
        PageFactory.initElements(webDriver, this);
        this.pageUtils = pageUtils;
		this.webDriver = webDriver;
    }

    public String getAppliedCouponName(String product) {
    	String couponName = "(//p[contains(text(),'"+product+"')]//ancestor::div[@class='row'])[1]/../../following-sibling::div[contains(@class,'shop-bag-actions')]//p";
    	return webDriver.findElement(By.xpath(couponName)).getText().trim().replaceAll("nbsp;", " ");
    }
    
    public boolean verifyAppliedNonSaleItemEMPCouponName(String product) {
    	String expectedCouponName = pageUtils.getTextTranslation("employee-discount-non-sale-eu");
    	String actualAppliedCouponName = getAppliedCouponName(product);
    	if(actualAppliedCouponName.equals(expectedCouponName))
    		return true;
    	else
    		return false;
    }
    
    public boolean verifyAppliedSaleItemEMPCouponName(String product) {
    	String expectedCouponName = pageUtils.getTextTranslation("employee-discount-sale-eu");
    	String actualAppliedCouponName = getAppliedCouponName(product);
    	if(actualAppliedCouponName.equals(expectedCouponName))
    		return true;
    	else
    		return false;
    }
    
}
