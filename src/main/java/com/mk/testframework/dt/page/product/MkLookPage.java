package com.mk.testframework.dt.page.product;


import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.util.PageUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class MkLookPage {

   

   
 @FindBy(id="buy-all-button")
    private WebElement ProductCountAtLook;
    
    @FindBy(id="buy-all-button")
    private WebElement buyAllButton;
    
    @FindBy(css = ".modalWrap")
    private WebElement shopThisLookWindow;
    
    @FindBy(css = ".size-container")
    private WebElement sizeContainer;
    
    @FindBy(id="navigation-button-next")
    private WebElement clickNext;
    
    @FindBy(xpath="//span[@class='cart-counter']")
    private WebElement lookAddBagCountInBasket;
    
    
    private PageUtils pageUtils;
    private WebDriver webDriver;
    private JavascriptExecutor jsExecutor;
    private Context context;

    @Inject
    public MkLookPage(WebDriver webDriver, PageUtils pageUtils, Context context){
        PageFactory.initElements(webDriver, this);
        this.pageUtils = pageUtils;
        this.webDriver = webDriver;
        this.jsExecutor = ((JavascriptExecutor) webDriver);
        this.context = context;
        
    } 
    
 public int getlookProductCount() {
  pageUtils.waitTillWebElementIsClickable(ProductCountAtLook);
  String pCount = ProductCountAtLook.getAttribute("innerText");
  
  
  String[] arrOfPcount = pCount.split("\\(", 2);
  
  String[] arrOfPcount2 = arrOfPcount[1].split("\\)", 2);
  
  String pCountvalue = arrOfPcount2[0].strip();
  
  int pCnt = Integer.parseInt(pCountvalue);
  
  return pCnt;
  

 }

 public void clickOnBuyAll() {
   jsExecutor.executeScript("arguments[0].click();", buyAllButton);
         pageUtils.waitForPageToLoad();
         pageUtils.waitForAjaxToComplete();
        
  
 }

 public boolean shopThisLook() {
  pageUtils.waitForPageToLoad();
  pageUtils.waitForAjaxToComplete();
  return pageUtils.verifyIfDisplayed(shopThisLookWindow);
  
  
 }


 public void addallLookItemsToBag() {
  
  
  try {
   int lookProCount= context.getLookProductCount();
   
      for (int i = 0; i < lookProCount; i++) 
      {
       List<WebElement> size_Set=webDriver.findElements(By.cssSelector(".commerce-area-wrapper:nth-child(2) .size-container .facet-size-options"));
       
       for (int j = 0; j < size_Set.size(); j++) 
       {
        boolean flag=size_Set.get(j).isEnabled();
        if (flag) {
         size_Set.get(j).click();
         break;
        }
       }
       try {
        webDriver.findElement(By.id("navigation-button-next")).click();
       } catch (Exception e) {
       webDriver.findElement(By.xpath("(//button[@name='select-items-button'])[2]")).click();

       }
      }
     } catch (Exception e) {
     }

 }

 public int getlookProductCountInBasket() {
  pageUtils.waitForWebElement(lookAddBagCountInBasket);
 
  String lookBasket=lookAddBagCountInBasket.getText();
  int LokCount = Integer.parseInt((lookBasket.replace("(", "")).replace(")", ""));

  return LokCount;
 }
    

}
