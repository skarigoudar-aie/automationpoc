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
import org.openqa.selenium.Keys;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

public class MkMyAccountPage_Global {

    @FindBy(id = "header-back-link")
    private WebElement headerBackLink;

    @FindBy(css = ".my-account-link")
    private WebElement signInLink;

    @FindBy(css = ".shopping-bag-cart .shopping-bag-item")
    private List<WebElement> productRow;

    @FindBy(css = "#quantityCartSelector_ option[selected='true']")
    private WebElement selectedQuantity;

    @FindBy(css = "#removeItem a:nth-of-type(1)")
    private WebElement removeLink;

    @FindBy(css = ".shopping-bag-action-links .edit a")
    private WebElement editLink;

    @FindBy(css = ".customizedPrdInfo")
    private WebElement customizeSection;

    @FindBy(css = ".customizedPrdInfo .product-values")
    private WebElement customizedValue;
    
    @FindBy(css = ".welcome_msg")
	private WebElement myAccountWelcome;
    
    @FindBy(css = ".address_book_container")
   	private WebElement myAccountAddressbookTitle;
    
    @FindBy(css = ".profile_nav > li:nth-child(3) > a")
    private WebElement clickAddressBook;
    
    @FindBy(css = ".profile_nav > li:nth-child(2) > a")
    private WebElement clickAddressBookAU;
    
    @FindBy(css = ".address_btn_container .manualAddrForm")
    private WebElement clickEnterAddressManually;
    
    @FindBy(css = ".default_address:nth-child(2) > .address_delete_icons span")
    private WebElement clickEditdefaultShippingAddress;
    
    @FindBy(id="address1")
    private WebElement AddressLine1;
    
    @FindBy(id="address2")
    private WebElement AddressLine2;
    
    @FindBy(id="city")
    private WebElement City;
    
    @FindBy(id="state")
    private WebElement County;
    
    @FindBy(id="postalCode")
    private WebElement PostalCode;
    
    @FindBy(xpath="//div[14]/div/a[2]")
    private WebElement TitleAU;
    
    @FindBy(xpath="//div[8]/div/div/a[2]")
    private WebElement StateAU;

    @FindBy(id="firstName")
    private WebElement AFirstName;
        
    @FindBy(id="lastName")
    private WebElement ALastName;
    
    @FindBy(id="phoneNumber")
    private WebElement APhoneNumber;
    
    @FindBy(id="default_shipping")
    private WebElement ADefaultShippingAddress;
    
    @FindBy(id="addsubmit")
    private WebElement ASaveAddressButtonAU;
    
    @FindBy(id="editsubmit")
    private WebElement AEditSaveAddressButton;
    
    @FindBy(id="manualAddSubmit")
    private WebElement SavedAddressline1;
    
    @FindBy(css=".default_address:nth-child(2)")
    private WebElement NewAddressline1;
    
    @FindBy(css = ".delete")
    private WebElement clickDeletedefaultshippingAddress;

    @FindBy(xpath = "//button[2]/span")
    private WebElement confirmDeletedefaultshippingAddress;
    
    @FindBy(css = "#firstName-error")
    private WebElement fNameError;
    
    @FindBy(css = "#lastName-error")
    private WebElement lNameError;
    
    @FindBy(xpath = "//ul[@class='profile_nav']/ li[4]/a")
    private WebElement favoriteLink;
    
    @FindBy(xpath = "//ul[@class='profile_nav']/ li[3]/a")
    private WebElement orderHistoryLink;   
    
    private PageUtils pageUtils;
    private WebDriver webDriver;
    private JavascriptExecutor jsExecutor;
    private Actions actionBuilder;

    @Inject
    public MkMyAccountPage_Global(WebDriver webDriver, PageUtils pageUtils) {
        
    	PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        this.pageUtils = pageUtils;
        this.actionBuilder = new Actions(webDriver);
        this.jsExecutor = ((JavascriptExecutor) webDriver);
    }


    public void clickAddressBookAU() {
   	 	pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
        pageUtils.waitForWebElement(clickAddressBookAU);
        jsExecutor.executeScript("arguments[0].scrollIntoView();",clickAddressBookAU);
        jsExecutor.executeScript("arguments[0].click();", clickAddressBookAU);
            
   }
    
    
    public void SelectState(String state) {
	  	
    	  	pageUtils.sleepSeconds(2, "States expanded"); 
    	  	pageUtils.scrollToElement(City);

    	  	actionBuilder.moveToElement(StateAU).click().build().perform();
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
       			throw new TestEnvironmentException("Could not find State option {"+translatedState+"} to click : " + e.getMessage());
       		}
       	}
		
		 private String getTranslationS(String state) {
				
			    ResourceBundle titleResource = pageUtils.getResourceBundle(Resource.STATE);
				return titleResource.getString(pageUtils.buildResourceLookupKey(state));
			
		}
		 
	 
	   }
    

    public void SelectTitle(String title) {
		  
    		 	pageUtils.sleepSeconds(2, "Title expanded"); 
    		  	pageUtils.scrollToElement(TitleAU);
    		  
    		  	actionBuilder.moveToElement(TitleAU).sendKeys(Keys.TAB).build().perform();
    		  	actionBuilder.moveToElement(TitleAU).sendKeys(Keys.ENTER).build().perform();
    		  		  	  
    	   		pageUtils.waitForAjaxToComplete();
    	   		
    	   		new TitleMenu(webDriver).selectTitle(title);			
    	   		
    	  }
    	  
    	  
    	  public class TitleMenu {
    			
    	       	@FindBy(css = ".sbOptions a")
    	       	private List<WebElement> titleOptions;
    	       
    	       	       	
    	       	public TitleMenu(WebDriver webDriver) {
    	       	PageFactory.initElements(webDriver, this);
    	        
    	       	       	
    	       	}    
    	       	
    	       	 
    	     	 			   
    			public void selectTitle(String title) {
    				
    				String translatedTitle = getTranslationT(title);
    				
    	      		try {
    	       			WebElement option4 = titleOptions.stream()
    	       					.filter(s -> s.getText().equals(String.valueOf(translatedTitle))).findFirst().get();
    	       			actionBuilder.moveToElement(option4).click().build().perform();
    	       			pageUtils.waitForAjaxToComplete();
    	       			pageUtils.waitForPageToLoad();
    	       		} catch (NoSuchElementException e) {
    	       			throw new TestEnvironmentException("Could not find Title option to click : " + e.getMessage());
    	       		}
    	       	}
    			
    			 private String getTranslationT(String title) {
    					
    				    ResourceBundle titleResource = pageUtils.getResourceBundle(Resource.TITLE);
    					return titleResource.getString(pageUtils.buildResourceLookupKey(title));
    				
    			}
    			 
    		 
    	  }   
    	  
    	  public void saveAddressbuttonclick() {
    	    		
    	    		jsExecutor.executeScript("arguments[0].click();", ASaveAddressButtonAU);
    	    		pageUtils.waitForPageToLoad();
 
    		}

    	  public void clickOnOrderHistoryLink()
    	    {
    	    	pageUtils.waitForAjaxToComplete();
    	    	pageUtils.sleepSeconds(2, "wait for page load");
    	    	jsExecutor.executeScript("arguments[0].click();", orderHistoryLink);
    	    }
    	  public void clickOnFavoriteLink()
    	    {
    	    	pageUtils.waitForAjaxToComplete();
    	    	pageUtils.sleepSeconds(2, "wait for page load");
    	    	jsExecutor.executeScript("arguments[0].click();", favoriteLink);
    	    }

}
