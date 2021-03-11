package com.mk.testframework.dt.page.myaccount;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.util.PageUtils;
import com.mk.testframework.dt.util.PageUtils.Resource;

import com.mk.testframework.core.env.Context;

import org.junit.Assert;
import java.util.List;
import java.util.ResourceBundle;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

public class MkMyAccountPage_NA {

	@FindBy(css = ".profile_nav > li:nth-child(3) > a")
	private WebElement clickAddressBook;

	@FindBy(id = "city")
	private WebElement City;

	@FindBy(id = "address_line1")
	private WebElement AddressLine1;

	@FindBy(id = "address_line2")
	private WebElement AddressLine2;

	// @FindBy(xpath="//div[9]/div/a[2]")
	@FindBy(id = "state")
	private WebElement State;

	@FindBy(id = "postalCode")
	private WebElement PostalCode;

	@FindBy(id = "addsubmit")
	private WebElement ADefaultShippingAddress;

	@FindBy(id = "addsubmit")
	private WebElement ASaveAddressButton;

	@FindBy(id = "editsubmit")
	private WebElement AEditSaveAddressButton;

	@FindBy(xpath = "/html/body/div[2]/div[4]/div[3]/div[2]/div/div[1]/div/div[1]/div/a[2]/span")
	private WebElement clickEditDefaultShippingAddress;

	@FindBy(xpath = "//*[@id=\"main_account_container\"]/div[3]/div[2]/div[1]/div[1]/div/div[1]/div/a[1]")
	private WebElement clickDeletedefaultshippingAddress;

	@FindBy(xpath = "//button[2]/span")
	private WebElement confirmDeletedefaultShippingAddress;

	@FindBy(css = "#edit_profile_form #lastName")
	private WebElement editLastName;

	@FindBy(id = "card_name")
	private WebElement nameOnCard;

	@FindBy(id = "creditCardNumber")
	private WebElement cardNumber;

	@FindBy(css = "#exp_date")
	private WebElement expMM;

	@FindBy(css = "#exp_year")
	private WebElement expYYYY;

	@FindBy(css = "#default_payment")
	private WebElement makeDefaultPaymentCheckBox;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement savePaymentButton;

	@FindBy(xpath = "//ul[@class='individual_card']/li[4]/span")
	private WebElement getCardName;

	@FindBy(xpath = "//*[@class=\"order_history_table\"]/tbody/tr")
	private List<WebElement> orderList;

	@FindBy(xpath = "(//*[@class=\"order_summary_details orderSummaryDetails\"])[1]/span")
	private WebElement subtotalLabel;

	@FindBy(xpath = "(//*[@class=\"order_summary_details orderSummaryDetails\"])[2]/span")
	private WebElement shippingLabel;

	@FindBy(xpath = "(//*[@class=\"order_summary_details orderSummaryDetails\"])[3]/span")
	private WebElement giftWrapLabel;

	@FindBy(xpath = "(//*[@class=\"order_summary_details orderSummaryDetails\"])[4]/span")
	private WebElement discountLabel;

	@FindBy(xpath = "(//*[@class=\"order_summary_details orderSummaryDetails\"])[5]/span")
	private WebElement taxLabel;

	@FindBy(xpath = "(//*[@class=\"order_summary_details nobrdr ordr_total orderSummaryDetails\"])[1]/span")
	private WebElement totalLabel;

	@FindBy(xpath = "(//*[@class=\"order_summary_details orderSummaryDetails\"])[1]/span[2]")
	private WebElement subtotalAmount;

	@FindBy(xpath = "(//*[@class=\"order_summary_details orderSummaryDetails\"])[2]/span[2]")
	private WebElement shippingAmount;

	@FindBy(xpath = "(//*[@class=\"order_summary_details orderSummaryDetails\"])[3]/span[2]")
	private WebElement giftWrapAmount;

	@FindBy(xpath = "(//*[@class=\"order_summary_details orderSummaryDetails\"])[4]/span[2]")
	private WebElement discountAmount;

	@FindBy(xpath = "(//*[@class=\"order_summary_details orderSummaryDetails\"])[5]/span[2]")
	private WebElement taxAmount;

	@FindBy(xpath = "(//*[@class=\"order_summary_details nobrdr ordr_total orderSummaryDetails\"])[1]/span[2]")
	private WebElement totalAmount;

	@FindBy(xpath = "//*[@class= 'orderShippedInfo']/span[2]")
	private WebElement dateContainer;
	
	@FindBy(css = ".individual_card")
	private List<WebElement> avialbleCards;
	
	@FindBy(xpath = "//ul[@class='individual_card']/li[3]/span")
	private WebElement getExpirationDate;
	
	@FindBy(xpath = "//*[@class='address_details_customScroll']/div")
	private List<WebElement> cardList;
    
    @FindBy(xpath = "//*[@class='add-all-bag-wrapper']//a")
    private WebElement addAllToBag;
    
    @FindBy(xpath = "//*[@class='add-all-bag-wrapper']//a//span")
    private WebElement wishlistCountInProfile;
    
    @FindBy(xpath = "//*[contains(@class,'product_panel')]")
    private List<WebElement> wishlist;
    
    @FindBy(xpath = "//a[contains(@class,'remove')]")
    private List<WebElement> wishlistItems;
    
    @FindBy(xpath = "(//*[@class='ui-dialog-buttonset']//span)[2]")
    private WebElement okToRemoveWishlistItem;
    
    @FindBy(xpath = "//*[contains(@class,'favorite_container')]")
    private WebElement wishlistPageContainer;
    
    @FindBy(css = "#con-notification")
    private WebElement conNotification;
    
    @FindBy(css = ".con-x svg")
    private WebElement conCloseMark;
     
    @FindBy(xpath = "//div[@class='product_panel']")
    private List<WebElement> wishlistProductPanel;
    
    @FindBy(css = ".ui-dialog-content")
	private WebElement wishlistEditPopUp;
	
    @FindBy(xpath = "//select[@class='qvSizeDropDown']")
    private WebElement wishistEditSize;
    
    @FindBy(xpath = "//a[contains(@class,'save-changes')]")
    private WebElement saveChanges;
    
    @FindBy(xpath = "//span[@class='clr-label']//following-sibling::span")
    private List<WebElement> wishlistColorName;
    
    @FindBy(xpath = "//p[@class='fontlistA-L size']//following-sibling::span")
    private List<WebElement> wishlistSizeName;
    
    @FindBy(xpath = "(//div[@class='sbHolder']/a)[2]")
    private WebElement selectedSizeInDropDown;
    
    @FindBy(css = ".qvSizeDropDown option")
    private List<WebElement> sizeOptions;
    
    @FindBy(xpath = "//*[@class='sbToggle']")
    private WebElement editQtyDropDown;
    
    @FindBy(xpath = "(//ul[@class='sbOptions'])[1]//li//a")
	private List<WebElement> dropDownOptions;
	
    @FindBy(css = ".welcome_msg")
	private WebElement myAccountWelcome;

	@FindBy(css = ".user_profile_name")
	private WebElement getUserName;
    
    @FindBy(css = ".profile_address .address_edit")
    private WebElement editProfileAddress;
    
    @FindBy(css = ".profile_address .add_new_container .viewAllAddr")
	private WebElement viewAllProfileAddress;
	
    @FindBy(xpath = "//*[@class = 'profile_payment']/div/a")
    private WebElement editProfileBillingAddress;
    
    @FindBy(css = "#select_address")
    private WebElement selectAddress;
    
    @FindBy(css = ".delete")
    private WebElement clickDeletedefault;
    
    @FindBy(xpath = "//*[@class='default_address selectedAddress']/ul/li[2]")
    private WebElement verifySavedBillingAddress;
    
	private PageUtils pageUtils;
	private WebDriver webDriver;
	private JavascriptExecutor jsExecutor;
	private Actions actionBuilder;
	private TestData testData;
	private Environment env;
	private Context context;
	private MkMyAccountPage_Common mkMyAccountPage_Common;
    
	@Inject
	public MkMyAccountPage_NA(WebDriver webDriver, PageUtils pageUtils, TestData testData, Environment env,
			Context context, MkMyAccountPage_Common mkMyAccountPage_Common) {
		PageFactory.initElements(webDriver, this);
		this.webDriver = webDriver;
		this.pageUtils = pageUtils;
		this.actionBuilder = new Actions(webDriver);
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.testData = testData;
		this.env = env;
		this.context = context;
		this.mkMyAccountPage_Common = mkMyAccountPage_Common;
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
		jsExecutor.executeScript("arguments[0].scrollIntoView();", clickEditDefaultShippingAddress);
		jsExecutor.executeScript("arguments[0].click();", clickEditDefaultShippingAddress);

	}

	public void saveEditAddressbuttonclick() {
		jsExecutor.executeScript("arguments[0].click();", AEditSaveAddressButton);
		pageUtils.waitForPageToLoad();
	}

	public void confirmDeletedefaultShippingAddress() {
		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
		pageUtils.waitForWebElement(confirmDeletedefaultShippingAddress);
		jsExecutor.executeScript("arguments[0].scrollIntoView();", confirmDeletedefaultShippingAddress);
		jsExecutor.executeScript("arguments[0].click();", confirmDeletedefaultShippingAddress);

	}

	public void clickDeletedefaultShippingAddress() {
		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
		pageUtils.waitForWebElement(clickDeletedefaultshippingAddress);
		jsExecutor.executeScript("arguments[0].scrollIntoView();", clickDeletedefaultshippingAddress);
		jsExecutor.executeScript("arguments[0].click();", clickDeletedefaultshippingAddress);

	}

	public void clickAddressBook() {
		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
		pageUtils.waitForWebElement(clickAddressBook);
		jsExecutor.executeScript("arguments[0].scrollIntoView();", clickAddressBook);
		jsExecutor.executeScript("arguments[0].click();", clickAddressBook);
	}

	public void SelectState(String state) {

		pageUtils.sleepSeconds(3, "States expanded");
		pageUtils.scrollToElement(PostalCode);

		actionBuilder.moveToElement(State).click().build().perform();
		pageUtils.sleepSeconds(3, "States expanded");
		pageUtils.waitForAjaxToComplete();

		Select s = new Select(webDriver.findElement(By.xpath("//*[@id=\"state\"]")));
		// s.selectByVisibleText(translatedState);
		s.selectByVisibleText(state);

	}

	public void SelectTitle(String title) {
		return;
	}

	public void editLastName(String lname) {
		pageUtils.waitForWebElement(editLastName);
		pageUtils.scrollToElement(editLastName);
		pageUtils.waitForWebElement(editLastName);
		editLastName.clear();
		editLastName.sendKeys(lname);
	}

	public void resetLastName(String rlname) {
		pageUtils.scrollToElement(editLastName);
		pageUtils.sleepSeconds(5, "Edit Profile loaded");
		editLastName.clear();
		editLastName.sendKeys(rlname);
	}

	public void cardHolderName(String name) {
		pageUtils.waitForPageToLoad();
		pageUtils.waitTillWebElementIsClickable(nameOnCard);
		nameOnCard.sendKeys(name);
	}

	public void enterCardNumber() {
		pageUtils.waitTillWebElementIsClickable(cardNumber);
		cardNumber.sendKeys(testData.getCard().getCardNumber());
		pageUtils.waitForPageToLoad();
	}

	public void selectCardExpDate() {
		Select expiryMM = new Select(expMM);
		expiryMM.selectByValue("05");
		pageUtils.waitForAjaxToComplete();
		Select expiryYYYY = new Select(expYYYY);
		expiryYYYY.selectByValue("2030");
	}

	public void makeDefaultpayment() {
		pageUtils.waitForPageToLoad();
		jsExecutor.executeScript("arguments[0].click();", makeDefaultPaymentCheckBox);
	}

	public void savePaymet() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "wait for page load");
		jsExecutor.executeScript("arguments[0].click();", savePaymentButton);

	}

	public void clickOrderAtPosition(int number) {
		WebElement order = orderList.get((number - 1));
		WebElement orderNumber = order.findElement(By.xpath("//*[@class=\"order_history_table\"]/tbody/tr/td[3]/a"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", orderNumber);
		pageUtils.sleepSeconds(1, "wait for page load");
		pageUtils.waitForPageToLoad();
	}

	private boolean isOrderPriceLabelsDisplayed(String label, WebElement webElement) {
		boolean flag = false;
		String country = env.getCurrentLocale().getCountry();
		String locale = env.getLanguage();
		pageUtils.waitForPageToLoad();
		pageUtils.waitTillWebElementIsVisible(webElement, 2);
		String objectLabel = pageUtils.getTextTranslation(label);
		if (country.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("fr")) {
			objectLabel = pageUtils.getTextTranslation(label + "-ca");
		} else if ((country.equalsIgnoreCase("us") && locale.equalsIgnoreCase("en"))
				|| (country.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("en"))) {
			objectLabel = pageUtils.getTextTranslation(label + "-na");
		}
	
		WebElement element = webDriver.findElement(By.xpath("//span[contains(text(),'" + objectLabel + "')]"));
		if (element.isDisplayed()) {
			context.writeOut(objectLabel + " label displayed");
			flag = true;
		} else {
			context.writeOut("Expected was: " + objectLabel + " and Found: " + element);
		}
		return flag;
	}
	

	
	public void cardHolderNameSpecial() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitTillWebElementIsClickable(nameOnCard);
		nameOnCard.sendKeys(testData.getUser().getFirstname());
	}

	public boolean isSubtotalDisplayed() {
		return isOrderPriceLabelsDisplayed("subtotal_label", subtotalLabel);

	}

	public boolean isShippingDisplayed() {
		return isOrderPriceLabelsDisplayed("shipping_label", shippingLabel);

	}

	public boolean isGiftWrapDisplayed() {
		return isOrderPriceLabelsDisplayed("giftwrap_label", giftWrapLabel);

	}

	public boolean isDiscountDisplayed() {
		return isOrderPriceLabelsDisplayed("discount_label", discountLabel);

	}

	public boolean isTaxDisplayed() {
		return isOrderPriceLabelsDisplayed("tax_label", taxLabel);

	}

	public boolean isTotalDisplayed() {
		return isOrderPriceLabelsDisplayed("total_label", totalLabel);

	}

	private boolean verifyOrderPriceElementsValue(String label, WebElement webElement) {
		String country = env.getCurrentLocale().getCountry();
		String locale = env.getLanguage();
		String objectLabel = pageUtils.getTextTranslation(label);
		if (country.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("fr")) {
			objectLabel = pageUtils.getTextTranslation(label + "-ca");
		} else if (country.equalsIgnoreCase("us") && locale.equalsIgnoreCase("en")) {
			if ("shipping_label".equals(label) || "total_label".equals(label)) {
				objectLabel = pageUtils.getTextTranslation(label + "_inner_text-us");
			} else {
				objectLabel = pageUtils.getTextTranslation(label + "-na");
			}
		} else if (country.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("en")) {
			if ("total_label".equals(label)) {
				objectLabel = pageUtils.getTextTranslation(label + "_inner_text-us");
			} else {
				objectLabel = pageUtils.getTextTranslation(label + "-na");
			}
		}

		jsExecutor.executeScript("arguments[0].click();", webElement);
		String actual = webElement.getAttribute("innerText").trim().replace("\n", "").replace(" ", "").replace("\u00a0",
				"");
		context.writeOut(objectLabel + " From Order Details Page : " + actual);

		String priceDetailsFromOrderConfirmation = context.getSavedData("orderPrices");
		String[] orderPricesList = priceDetailsFromOrderConfirmation.split("\n\n");
		String expected = "";
		boolean found = false;
		for (int i = 0; i < orderPricesList.length; i++) {
			String[] priceBreakdown = orderPricesList[i].split("\n");
			if ("total_label".equals(label)) {
				if (priceBreakdown[1].toLowerCase().equals(objectLabel.toLowerCase())) {
					expected = priceBreakdown[0].trim().replace("\n", "").replace(" ", "").replace("\u00a0", "");
					found = true;
					break;
				}
			} else if (priceBreakdown[1].toLowerCase().contains(objectLabel.toLowerCase())) {
				expected = priceBreakdown[0].trim().replace("\n", "").replace(" ", "").replace("\u00a0", "");
				found = true;
				break;
			}
		}
		if (!found) {
			expected = mkMyAccountPage_Common.getAmountWithCurrency(0).trim().replace("\n", "").replace(" ", "")
					.replace("\u00a0", "");
		}
		if (expected.equals(actual)) {
			return true;
		}
		return false;
	}

	public boolean verifySubtotalAmount() {
		return verifyOrderPriceElementsValue("subtotal_label", subtotalAmount);

	}

	public boolean verifyShippingAmount() {
		return verifyOrderPriceElementsValue("shipping_label", shippingAmount);

	}

	public boolean verifyGiftWrapAmount() {
		return verifyOrderPriceElementsValue("giftWrap_label", giftWrapAmount);

	}

	public boolean verifyDiscountAmount() {
		return verifyOrderPriceElementsValue("discount_label", discountAmount);

	}

	public boolean verifyTaxAmount() {
		return verifyOrderPriceElementsValue("tax_label", taxAmount);

	}

	public boolean verifyTotalAmount() {
		return verifyOrderPriceElementsValue("total_label", totalAmount);
	}

	public boolean orderSubmissionDateDisplayed() {
		pageUtils.waitForPageToLoad();
		if (pageUtils.verifyIfDisplayed(dateContainer)) {
			return true;
		}
		return false;
	}
		
	public void addCardIfNotAvailable() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "Wait for element to display");
		if(!(avialbleCards.size()>0)) {
			nameOnCard.sendKeys(testData.getUser().getFirstname()+" "+testData.getUser().getLastname());
			cardNumber.sendKeys(testData.getCard().getCardNumber());
			selectCardExpDate();
			savePaymet();
			pageUtils.sleepSeconds(5, "Wait for page to load");
		}else {
			context.writeOut("Payment method available in profile");
		}
	}
	
	public boolean verifyCardIsSaved(String cardHolder) {
		boolean flag = false;
		pageUtils.sleepSeconds(10, "wait for page load");
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForWebElement(getCardName);
		for(int i=0; i<cardList.size(); i++) {
			String nameOnCard = cardList.get(i).findElement(By.cssSelector(".individual_card .card-owner .capitalizeName")).getText();
			if(nameOnCard.equalsIgnoreCase(cardHolder)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public boolean deleteSavedPayment(String cardHolder) {
		boolean flag = false;
		pageUtils.sleepSeconds(10, "wait for page load");
		pageUtils.waitForAjaxToComplete();
		pageUtils.waitForWebElement(getCardName);
		int cardSizeBeforeDelete = cardList.size();
		for(int i=0; i<cardList.size(); i++) {
			String nameOnCard = cardList.get(i).findElement(By.cssSelector(".individual_card .card-owner .capitalizeName")).getText();
			if(nameOnCard.equalsIgnoreCase(cardHolder)) {
				WebElement deleteCardLink = cardList.get(i).findElement(By.cssSelector(".payment_delete_icons .delete"));
				jsExecutor.executeScript("arguments[0].click();", deleteCardLink);
				pageUtils.sleepSeconds(2, "wait for page load");
				jsExecutor.executeScript("arguments[0].click();", webDriver.findElement(By.xpath("(//*[@type='button']/span)[2]")));
				pageUtils.waitForAjaxToComplete();
				pageUtils.waitForPageToLoad();
				break;
			}
		}
		int cardSizeAfterDelete = cardList.size();
		if(cardSizeBeforeDelete>cardSizeAfterDelete){
			flag = true;
		}
		return flag;
	}
		
	public boolean emptyMyWishlist() {
		boolean wishListEmpty = false;
		int wishlistSize = wishlist.size();
		if (wishlistSize > 0) {
			for (int i = 0; i < wishlistSize; i++) {
				try {
					pageUtils.sleepSeconds(2, "Wait for page to display");
					if (conNotification.getAttribute("class").contains("con-active"))
						conCloseMark.click();
					wishlistItems.get(0).click();
					pageUtils.sleepSeconds(2, "wait for page to display");
					okToRemoveWishlistItem.click();
					pageUtils.sleepSeconds(2, "wait for page to display");
					pageUtils.refresh();
					pageUtils.waitForPageToLoad();
					pageUtils.sleepSeconds(5, "wait for page to display");
					pageUtils.scrollToTopOfPage();
				} catch (Exception e) {
					pageUtils.refresh();
					pageUtils.sleepSeconds(2, "Wait for page to display");
					if (conNotification.getAttribute("class").contains("con-active"))
						conCloseMark.click();
					wishlistItems.get(0).click();
					pageUtils.sleepSeconds(2, "wait for page to display");
					okToRemoveWishlistItem.click();
					pageUtils.refresh();
					pageUtils.waitForPageToLoad();
					pageUtils.sleepSeconds(5, "wait for page to display");
					pageUtils.scrollToTopOfPage();
				}
			}
		}
		if (wishlistItems.size() == 0)
			wishListEmpty = true;
		else
			wishListEmpty = false;
		return wishListEmpty;
	}

	private String getTranslationT(String text) {
		ResourceBundle titleResource = pageUtils.getResourceBundle(Resource.TEXT);
		return titleResource.getString(pageUtils.buildResourceLookupKey(text));
	}

	public void clickOnWishlistLink(String text) {
		String locator = "//ul[@class='profile_nav']//a[text()='" + getTranslationT(text) + "']";
		WebElement wishListLink = webDriver.findElement(By.xpath(locator));
		pageUtils.waitForPageToLoad();
		wishListLink.click();
		pageUtils.waitForPageToLoad();
	}

	public String getWishlistCountInProfile() {
		return wishlistCountInProfile.getText().trim();
	}

	public int getWishlistCount() {
		return wishlist.size();
	}

	public boolean isWishlistPage() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(5, "wait for page to load");
		return pageUtils.verifyIfDisplayed(wishlistPageContainer);
	}

	public void clickAddAllToBagButton() {
		addAllToBag.click();
	}
		
	public void clickOnEditLinkInWishlist() {
		actionBuilder.moveToElement(wishlistProductPanel.get(0));
		List<WebElement> editLink = webDriver.findElements(
				By.xpath("//div[@class='product_panel']//a[text()='" + pageUtils.getTextTranslation("edit") + "']"));
		jsExecutor.executeScript("arguments[0].click();", editLink.get(0));
		pageUtils.sleepSeconds(10, "Wait for edit pop up to display");
		if (conNotification.getAttribute("class").contains("con-active"))
			conCloseMark.click();
	}
	
	public String changeSizeInEditWishlistPopUp() {
		String size = null;

		if (pageUtils.verifyIfDisplayed(wishistEditSize)) {
			Select qtyDropDown = new Select(wishistEditSize);
			int options = qtyDropDown.getOptions().size();
			String selectedSize ="";
			System.out.println();
			try {
				int sizeOfOption = sizeOptions.size();
				for (int i = 1; i < sizeOfOption; i++) {
					pageUtils.scrollToElement(wishistEditSize);
					jsExecutor.executeScript("arguments[0].click();", wishistEditSize);
					
					wishistEditSize.click();
					selectedSize = sizeOptions.get(i).getText();
					if((sizeOptions.get(i).getAttribute("selected").contains("true"))) {
						break;
					}
				} 
			} catch (Exception e) {
				selectedSize = selectedSize;
			}
			
			try {
				jsExecutor.executeScript("arguments[0].click();", editQtyDropDown);
				pageUtils.sleepSeconds(2, "Wait for element to display");
				for (int k = 1; k <= options; k++) {
					if (!(selectedSize.equalsIgnoreCase(dropDownOptions.get(k).getText()))) {
						dropDownOptions.get(k).click();
						pageUtils.sleepSeconds(5, "Wait for element to display");
						size = selectedSizeInDropDown.getText();
						break;
					}
				} 
			} catch (Exception e) {
				System.out.println();
			}
		} else {
			size = null;
		}
		return size;
	}

	
	public String getColorFromWishlistProduct(int position) {
		return wishlistColorName.get(position-1).getText().trim();
	}

	public String getSizeFromWishlistProduct(int position) {
		String size;
		if(pageUtils.verifyIfDisplayed(wishlistSizeName.get(position-1)))
			size = wishlistSizeName.get(position-1).getText().trim();
		else
			size = null;
		return size;
	}
	
	public void getWelcomeText() {
		String userName = getUserName.getText();
		context.writeOut("user name under welcome back is: " + userName.toLowerCase());
		String name = myAccountWelcome.getText();
		context.writeOut("user name under welcome back is: " + name.toLowerCase());

		Assert.assertTrue("Profile name not displayed", name.toLowerCase().contains(userName.toLowerCase()));

	}

	public void clickEditShippingAddressOnProfilePage() {
		pageUtils.waitForPageToLoad();
		jsExecutor.executeScript("arguments[0].click();", editProfileAddress);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}

	public void clickViewAllShippingAddressOnProfilePage() {
		pageUtils.waitForPageToLoad();
		jsExecutor.executeScript("arguments[0].click();", viewAllProfileAddress);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}

	public void clickEditBillingAddressOnProfilePage() {
		pageUtils.waitForPageToLoad();
		jsExecutor.executeScript("arguments[0].click();", editProfileBillingAddress);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}

	public void selectAddressDropDown() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(2, "wait to page load");
		Select sel = new Select(selectAddress);
		sel.selectByValue("New");
	}

	public void clickDeletedeAddress() {
		pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
		pageUtils.waitForWebElement(clickDeletedefault);
		jsExecutor.executeScript("arguments[0].scrollIntoView();", clickDeletedefault);
		jsExecutor.executeScript("arguments[0].click();", clickDeletedefault);

	}

	public String verifyBillingAddressSavedOnPaymentInfo() {
		pageUtils.sleepSeconds(5, "2 sec wait for ajax load");
		pageUtils.waitForAjaxToComplete();
		String Addressline1 = verifySavedBillingAddress.getText();
		return Addressline1;
	}

	public void clickOnSaveChanges() {
		saveChanges.click();
	}
	
	public void removeWishlistitem(int position) {
		wishlistItems.get(position-1).click();
		pageUtils.sleepSeconds(3, "wait for page to load");
		okToRemoveWishlistItem.click();
		pageUtils.sleepSeconds(3, "wait for page to load");
	}

}
