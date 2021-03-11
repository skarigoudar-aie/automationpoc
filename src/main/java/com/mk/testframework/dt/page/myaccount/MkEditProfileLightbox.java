package com.mk.testframework.dt.page.myaccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.google.inject.Inject;
import com.mk.testframework.dt.util.PageUtils;

public class MkEditProfileLightbox {
    private PageUtils pageUtils;

    @Inject
    public MkEditProfileLightbox(WebDriver webDriver, PageUtils pageUtils) {
        PageFactory.initElements(webDriver, this);
        this.pageUtils = pageUtils;
    }

       

    @FindBy(id = "shopping-bag-edit-item-modal")
    private WebElement editContainer;

    @FindBy(id = "edit_profile_popup")
    private WebElement editprofileContainer;
    
       
    @FindBy(id = "updateBag_Cart")
    private WebElement updateBagButton;

    @FindBy(css = ".qvModelUpdate .dropdown-toggle")
    private WebElement quantitySelector;

    @FindBy(css = ".dropup .dropdown-menu.open")
    private WebElement quantitySelectorMenu;
        
    @FindBy(id = "phoneNumber")
    private WebElement editPhoneNumber;
    
   
    public boolean waitForEditContainer(){
        return pageUtils.waitForWebElement(editContainer);
    }

    
    public boolean waitForEditProfileContainer(){
        return pageUtils.waitForWebElement(editprofileContainer);
    }

    
    public boolean waitForQuantitySelector(){
        return pageUtils.waitForWebElement(quantitySelector);
    }


 }
