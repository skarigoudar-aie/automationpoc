package com.mk.testframework.dt.popup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.google.inject.Inject;
import com.mk.testframework.dt.util.PageUtils;

/**
 * @author Raja
 *
 */
public class MkEditProfileModal_NA {

	@FindBy(css=".edit_profile_popup")
	private WebElement editProfileContainer;

	@FindBy(css = "#edit_profile_form div #lastName")
	private WebElement editLastNameNA;
	
	@FindBy(id = "edit_profile_popup")
	private WebElement editProfileModelNA;

	private Actions actionBuilder;
	private PageUtils pageUtils;

	@Inject
	public MkEditProfileModal_NA(WebDriver webDriver, PageUtils pageUtils) {
		PageFactory.initElements(webDriver, this);
		this.pageUtils = pageUtils;
		this.actionBuilder = new Actions(webDriver);
	}

	
	
	 public void editLastNameNA(String lnamena) {
		 
			pageUtils.waitForWebElement(editLastNameNA);
		 	actionBuilder.moveToElement(editLastNameNA).build().perform();
		   	editLastNameNA.clear();
	  		editLastNameNA.sendKeys(lnamena);
	  		  		
	  	}
	 
	 
	 public boolean myAccountEditProfileModelIsPresent() {
	        return this.waitForEditProfileModel();
	    }
	 

	 public boolean waitForEditProfileModel() {
		return pageUtils.waitForWebElement(editProfileModelNA);
		
	}


}