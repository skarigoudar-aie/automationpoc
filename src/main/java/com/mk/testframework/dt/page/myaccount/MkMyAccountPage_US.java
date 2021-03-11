package com.mk.testframework.dt.page.myaccount;

import com.google.inject.Inject;
import com.mk.testframework.core.exceptions.TestEnvironmentException;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.dt.util.PageUtils.Resource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

public class MkMyAccountPage_US {

	@FindBy(css = ".profile_nav > li:nth-child(4) > a")
	private WebElement clickAddressBookUS;

    @FindBy(id="city")
    private WebElement City;
    
    @FindBy(id="address_line1")
    private WebElement AddressLine1;

    @FindBy(id="address_line2")
    private WebElement AddressLine2;

    @FindBy(xpath="//div[9]/div/a[2]")
    private WebElement State;

    @FindBy(id="postalCode")
    private WebElement PostalCode;
  
    @FindBy(id="addsubmit")
    private WebElement ADefaultShippingAddress;
    
    @FindBy(id="addsubmit")
    private WebElement ASaveAddressButton;
    
    @FindBy(id="editsubmit")
    private WebElement AEditSaveAddressButton;
    
    @FindBy(xpath="/html/body/div[2]/div[4]/div[3]/div[2]/div/div[1]/div/div[1]/div/a[2]/span")
    private WebElement clickEditDefaultShippingAddress;
    
    @FindBy(xpath="//*[@id=\"main_account_container\"]/div[3]/div[2]/div[1]/div[1]/div/div[1]/div/a[1]")
    private WebElement clickDeletedefaultshippingAddress;

    @FindBy(xpath = "//button[2]/span")
    private WebElement confirmDeletedefaultShippingAddress;
    
    @FindBy(xpath = "//ul[@class='profile_nav']/li[3]/a")
    private WebElement paymentInformatinLink;
    
    @FindBy(css = ".profile_nav > li:nth-child(5) > a")
    private WebElement orderHistoryLink;
    
    @FindBy(css = ".profile_nav > li:nth-child(7) > a")
    private WebElement wishListLink;
 
    private PageUtils pageUtils;
    private WebDriver webDriver;
    private JavascriptExecutor jsExecutor;
    private Actions actionBuilder;

    @Inject
    public MkMyAccountPage_US(WebDriver webDriver, PageUtils pageUtils) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        this.pageUtils = pageUtils;
        this.actionBuilder = new Actions(webDriver);
        this.jsExecutor = ((JavascriptExecutor) webDriver);
    }

    public void enterAddressLine1(String Addline1) { 
		pageUtils.waitForWebElement(AddressLine1);
		AddressLine1.clear();
		AddressLine1.sendKeys(Addline1);
	}
    
    
    public void enterAddressLine2(String Addline2) { 
  		pageUtils.waitForWebElement(AddressLine2);
  		AddressLine2.clear();
  		AddressLine2.sendKeys(Addline2);
  	}
    
     
    public void saveAddressbuttonclick() {
  		jsExecutor.executeScript("arguments[0].click();", ASaveAddressButton);
  		pageUtils.waitForPageToLoad();
  	}
    
    
    public void clickEditdefaultShippingAddress() {
     	 pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
          pageUtils.waitForWebElement(clickEditDefaultShippingAddress);
          jsExecutor.executeScript("arguments[0].scrollIntoView();",clickEditDefaultShippingAddress);
          jsExecutor.executeScript("arguments[0].click();", clickEditDefaultShippingAddress);
              
     }
    
    public void saveEditAddressbuttonclick() {
		jsExecutor.executeScript("arguments[0].click();", AEditSaveAddressButton);
		pageUtils.waitForPageToLoad();
	}

    
    
    public void confirmDeletedefaultShippingAddress() {
   	 pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
        pageUtils.waitForWebElement(confirmDeletedefaultShippingAddress);
        jsExecutor.executeScript("arguments[0].scrollIntoView();",confirmDeletedefaultShippingAddress);
        jsExecutor.executeScript("arguments[0].click();", confirmDeletedefaultShippingAddress);
            
   }

    
    public void clickDeletedefaultShippingAddress() {
    	 pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
         pageUtils.waitForWebElement(clickDeletedefaultshippingAddress);
         jsExecutor.executeScript("arguments[0].scrollIntoView();",clickDeletedefaultshippingAddress);
         jsExecutor.executeScript("arguments[0].click();", clickDeletedefaultshippingAddress);
             
    }
    
    
    public void clickAddressBookUS() {
   	 	pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
        pageUtils.waitForWebElement(clickAddressBookUS);
        jsExecutor.executeScript("arguments[0].scrollIntoView();",clickAddressBookUS);
        jsExecutor.executeScript("arguments[0].click();", clickAddressBookUS);
            
   }
    
     
    public void SelectState(String state) {
	  	
       
        	pageUtils.sleepSeconds(6, "States expanded"); 
    		pageUtils.scrollToElement(PostalCode);
    	  	
    	  	actionBuilder.moveToElement(State).click().build().perform();
    	  	pageUtils.sleepSeconds(3, "States expanded"); 
       		pageUtils.waitForAjaxToComplete();
               
       		new StateMenu(webDriver).selectState(state);			
       		
        
      }
	  
	  
	  public class StateMenu {
			
	       	@FindBy(css = ".sbOptions a")
	       	private List<WebElement> stateOptions;
	       
	       	       	
	       	public StateMenu(WebDriver webDriver) {
	       	PageFactory.initElements(webDriver, this);
	        
	       	       	
	       	}    
	       	
	       	 
	     	 			   
			public void selectState(String state) {
				
				String translatedState = getTranslationS(state);
				
	      		try {
	       			WebElement option5 = stateOptions.stream()
	       					.filter(s -> s.getText().equals(String.valueOf(translatedState))).findFirst().get();
	       			actionBuilder.moveToElement(option5).click().build().perform();
	       			pageUtils.waitForAjaxToComplete();
	       			pageUtils.waitForPageToLoad();
	       		} catch (NoSuchElementException e) {
	       			throw new TestEnvironmentException("Could not find State option to click : " + e.getMessage());
	       		}
	       	}
			
			 private String getTranslationS(String state) {
					
				    ResourceBundle titleResource = pageUtils.getResourceBundle(Resource.STATE);
					return titleResource.getString(pageUtils.buildResourceLookupKey(state));
				
			}
			 
			 
		 
		   }
	   
	  public void SelectTitle(String title) {
				 return;
	  		}
	  
	  public void clickOnPaymentInformationLink()
	    {
		  pageUtils.waitForPageToLoad();
		  pageUtils.sleepSeconds(5, "wait for page load");
	    	jsExecutor.executeScript("arguments[0].click();", paymentInformatinLink);
	    	pageUtils.waitForPageToLoad();
		}
		
	  public void clickOnOrderHistoryLink()
	    {
		  pageUtils.waitForPageToLoad();
		  pageUtils.sleepSeconds(5, "wait for page load");
	    	jsExecutor.executeScript("arguments[0].click();", orderHistoryLink);
	    	pageUtils.waitForPageToLoad();
		}
		
	  public void clickOnWishListLink()
	    {
		  pageUtils.waitForPageToLoad();
		  pageUtils.sleepSeconds(5, "wait for page load");
	    	jsExecutor.executeScript("arguments[0].click();", wishListLink);
	    	pageUtils.waitForPageToLoad();
	    }
}
