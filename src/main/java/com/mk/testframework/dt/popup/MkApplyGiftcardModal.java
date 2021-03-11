package com.mk.testframework.dt.popup;

import com.mk.testframework.dt.util.PageUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MkApplyGiftcardModal {

    @FindBy(how = How.CSS, using = "#apply-gift-card-modal")
    private WebElement applyGiftcardModal;

    @FindBy(how = How.CSS, using = ".kor-modal__content #js-applygiftCard-cancel")
    private WebElement giftCardCancelButton;

    @FindBy(how = How.CSS, using = "#apply-gift-card-modal input[name='gift-card']")
    private WebElement giftCardField;

    @FindBy(how = How.CSS, using = "#apply-gift-card-modal input[name='pin']")
    private WebElement giftCardPinField;

    @FindBy(how = How.CSS, using = "#apply-gift-card-modal input[type='submit']")
    private WebElement giftCardSubmitButton;

    @FindBy(how = How.CSS, using = "#apply-giftcard-error-message")
    private WebElement giftCardErrorMessage;

    @FindBy(how = How.CSS, using = "#apply-giftcard-form .alert-message--success")
    private WebElement giftCardSuccessMessage;

    private PageUtils pageUtils;

    public MkApplyGiftcardModal(WebDriver webDriver, PageUtils pageUtils){
        PageFactory.initElements(webDriver, this);
        this.pageUtils = pageUtils;
    }
    
    public boolean waitForApplyGiftCardModal() {
        return pageUtils.waitForWebElement(applyGiftcardModal);
    }

    public boolean verifyApplyGiftcardModal(){
        return applyGiftcardModal.isDisplayed();
    }

    public void clickCancelButton(){
    	giftCardCancelButton.click();
    }

    public void typeInGiftCardInputField(String giftCardNumber){
    	giftCardField.sendKeys(giftCardNumber);
    }

    public void typeInPinInputField(String pinNumber){
    	giftCardPinField.sendKeys(pinNumber);
    }

    public void clickSubmitButton(){
    	giftCardSubmitButton.click();
    }

    public String getErrorMessage(){
    	return giftCardErrorMessage.getText();
    }

    public String getSuccessMessage(){
        return giftCardSuccessMessage.getText();
    }

}
