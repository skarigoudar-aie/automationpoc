
package com.mk.testframework.dt.page.shoppingbag;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.core.exceptions.TestEnvironmentException;
import com.mk.testframework.dt.header.MkMyAccountMenu;
import com.mk.testframework.dt.util.PageUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class MkShoppingBagPage_Common {

	@FindBy(id = "header-back-link")
	private WebElement headerBackLink;

	@FindBy(css = ".shopping-bag-cart .shopping-bag-item")
	private List<WebElement> productRow;

	@FindBy(css = ".shopping-bag-cart .shopping-bag-item .remove")
	private WebElement removeLink;

	@FindBy(css = ".shopping-bag-action-links .edit a")
	private WebElement editLink;

	@FindBy(css = ".customizedPrdInfo")
	private WebElement customizeSection;

	@FindBy(css = ".customizedPrdInfo .product-values")
	private WebElement customizedValue;

	@FindBy(css = ".rfk-container")
	private WebElement rfkSection;

	@FindBy(css = ".rfk-container .carousel-img-container a")
	private List<WebElement> rfkProducts;

	@FindBy(css = ".addToFavorites")
	private WebElement sbpAddToFavorite;

	@FindBy(css = ".alert-message .addedToFavorites")
	private WebElement itemAddedToFavoriteMessage;

	@FindBy(css = ".link--clean-h2")
	private WebElement productdetails;

	@FindBy(css = ".fontlistA-D a")
	private WebElement favProdDetail;

	@FindBy(css = ".deliveryMsg")
	private WebElement deliveryMsg;

	@FindBy(css = ".basketPorting-info")
	private WebElement basketPortingInfo;
	@FindBy(xpath = "//a[@id='checkoutBtn']")
	private WebElement checkoutbutton;

	@FindBy(xpath = "//input[@name='Checkout As Guest']")
	private WebElement checkoutAsGuest;

    @FindBy(css = ".new-price")
    private WebElement salePriceEU;
    
    @FindBy(xpath = "//*[@class='table-cols']/following-sibling :: a")
    private WebElement applyPromoLink;
    
    @FindBy(xpath = "(//*[@class='col--table col--table-md-4'])[3]/div")
    private WebElement getTotalPrice;
    
    @FindBy(xpath = "(//*[@class='col-xs-6 col--no-gutters'])[2]")
    private WebElement mobileGetTotalPrice;
    
	@FindBy(css = "input[id=shopping-bag-promo]")
	private WebElement promoCodeContainer;
	
	@FindBy(css = "form[id=orderPromotionForm] button")
	private WebElement applyPromo;

	@FindBy(css = ".old-price")
	private WebElement listPriceEU;

	@FindBy(xpath = "//p[@class='p--no-margin product-values hidden-for-ipad'][contains(text(),'Now')]")
	private WebElement salePriceUS;

	@FindBy(xpath = "//p[@class='p--no-margin product-values hidden-for-ipad'][contains(text(),'Was')]")
	private WebElement listPriceUS;

	@FindBy(xpath = "//p[@class='p--no-margin product-values visible-for-ipad']")
	private WebElement salePriceCAF;

	@FindBy(css = ".shopping-bag-item__price .product-values")
	private List<WebElement> mobilePriceList;
	
	@FindBy(css = "#shopping-bag-edit-item-modal .modal-body")
	private WebElement shoppingBagEditModel;

	@FindBy(css = ".shopping-bag-item .h5")
    private WebElement shoppingBagItemPrice;
    
    @FindBy(css = ".shopping-cart-promocode p")
    private WebElement promoMessageEU;
    
	@FindBy(css = ".removeCoupon")
	private WebElement promoScuccessContainer;
	
	@FindBy(css = ".shopping-bag-item .h3")
	private WebElement promoMessageNA;
	
    @FindBy(id = "shiptoAddress")
    private WebElement shiptoAddressNA;
    
    @FindBy(id = "shipTo_address")
    private WebElement shipToaddressEU;
    
    @FindBy(css = ".shipto-address-link")
    private WebElement shiptoAddressLinkNA;
    
    @FindBy(css = ".shipToAddressItem")
    private WebElement shiptoAddressItemEU;
    
    @FindBy(css = ".collectInStoreItem")
    private WebElement collectInStoreItemEU;
    
    @FindBy(css = ".cnc-shoppingcart")
    private WebElement collectInStoreItemNA;
    
    @FindBy(id = "pickupinstore")
    private WebElement pickupinstoreNA;
    
    @FindBy(id = "collectIn_store")
    private WebElement pickupinstoreEU;
    
    @FindBy(id = "find_store_field")
    private WebElement findStoreNA;
    
    @FindBy(id = "store-search-value")
    private WebElement findStoreEU;
    
    @FindBy(id = "findInCIS")
    private WebElement findButtonEU;
    
    @FindBy(css = ".find-instore")
    private WebElement findButtonNA;
    
    @FindBy(css = ".cart-modal-storeSearchRange li")
    private List<WebElement> storeSerachDistanceMenu;
	
    @FindBy(xpath = "//*[@href='.shopping-bag-promo']")
	private WebElement promoLink;

    @FindBy(css = ".cart-modal-storeSearchRange button")
    private WebElement storeSerachDistance;
    
    @FindBy(css = ".store_distance button")
    private WebElement storeDistanceNA;
    
    @FindBy(css = ".store_distance li")
    private List<WebElement> storeDistanceNAMenu;
        
    private PageUtils pageUtils;
    private MkMyAccountMenu mkMyAccountMenu;
    private MkEditProductLightbox mkEditProductLightbox;
    private JavascriptExecutor jsExecutor;
    private final Logger log = LoggerFactory.getLogger(getClass());
    private Environment env;
    private WebDriver webDriver;
    private Context context;
    private TestData testData;

    @Inject
    public MkShoppingBagPage_Common(WebDriver webDriver, PageUtils pageUtils, MkMyAccountMenu mkMyAccountMenu,
                                    MkEditProductLightbox mkEditProductLightbox, Environment env, Context context, TestData testData) {
                              
        PageFactory.initElements(webDriver, this);
        this.pageUtils = pageUtils;
        this.mkMyAccountMenu = mkMyAccountMenu;
        this.mkEditProductLightbox = mkEditProductLightbox;
        this.jsExecutor = ((JavascriptExecutor) webDriver);
        this.env = env;
        this.webDriver = webDriver;
        this.context = context;
        this.testData = testData;
    }

	public void clickHeaderBackLink() {
		headerBackLink.click();
	}

	public String getdeliveryMsg() {
		String sbpProdName = deliveryMsg.getText();
		return sbpProdName;
	}

	public String getbasketPortingInfo() {
		String sbpProdName = basketPortingInfo.getText();
		return sbpProdName;
	}

    public int getProductCount() {
        pageUtils.waitForPageToLoad();
        pageUtils.waitForAjaxToComplete();
        return productRow.size();
    }

	public void clickRemoveLink() {
		try {
			pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
			pageUtils.waitForAjaxToComplete();
			pageUtils.waitForWebElement(removeLink);
			jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", removeLink);
			removeLink.click();
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(5, "1 sec wait for ajax load");
		} catch (Exception e) {
			pageUtils.waitForWebElement(removeLink);
			pageUtils.scrollToElement(removeLink);
			WebElement ele =webDriver.findElement(By.xpath("//*[@class='remove']/form/a"));
			jsExecutor.executeScript("arguments[0].click();", ele);
			pageUtils.waitForPageToLoad();
			pageUtils.waitForAjaxToComplete();
			pageUtils.sleepSeconds(5, "1 sec wait for ajax load");
		}
	}

    public void clickEditLink(){
        pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
        pageUtils.waitForWebElement(removeLink);
        jsExecutor.executeScript("arguments[0].scrollIntoView();",editLink);
        jsExecutor.executeScript("arguments[0].click();", editLink);
        pageUtils.waitForPageToLoad();
        pageUtils.waitForAjaxToComplete();
        pageUtils.sleepSeconds(1, "1 sec wait for ajax load");
        mkEditProductLightbox.waitForEditContainer();
        pageUtils.sleepSeconds(3, "Wait for edit modal to fully load");
    }

    public boolean myAccountWelcomeIsPresent() {
        return mkMyAccountMenu.waitForMyAccountWelcome();
    }

    public boolean rfkSectionIsPresent(){
        return pageUtils.waitForWebElement(rfkSection);
    }

    public boolean monogramSectionIsPresent(){
        return pageUtils.waitForWebElement(customizedValue);
    }

    public void selectRfkItem(int position) {
        try{
            WebElement rfkProduct = rfkProducts.get((position-1));
            jsExecutor.executeScript("arguments[0].click();", rfkProduct);
            pageUtils.waitForAjaxToComplete();
            pageUtils.waitForPageToLoad();
        }
        catch (IndexOutOfBoundsException e) {
            log.debug("Unable to access product "+position+" of "+rfkProducts.size());
        }
	}

	public void sbpAddToFavorite() {
		try {
			pageUtils.sleepSeconds(3, "Wait for add to favorite to be displayed");
			jsExecutor.executeScript("arguments[0].scrollIntoView();", sbpAddToFavorite);
			jsExecutor.executeScript("arguments[0].click();", sbpAddToFavorite);
		} catch (TestEnvironmentException e) {
			log.debug("Couldn't add to favourite");
		}
	}
	
	public boolean verifyItemAddedToFavoriteMessage() {
		pageUtils.waitForAjaxToComplete();
		return itemAddedToFavoriteMessage.isDisplayed();
	}
	
	public String getProductDetails() {
		String sbpProdName = productdetails.getText();
		return sbpProdName;
	}

	public boolean PromoApplied() {
		boolean status = false;
		pageUtils.sleepSeconds(10, "wait for promo conatiner");
		if (pageUtils.verifyIfDisplayed(promoScuccessContainer)) {
			status = true;
		}
		return status;
	}
    		
    public int verifyQuantityLimitAfterEmployeePromoApplied(String product) {
    	String qtyDropDown = "//*[contains(text(),'"+product+"')]//ancestor::div[contains(@class, 'shopping-bag-item')]//div[@class='quantity-container']//select";
    	Select dropdown= new Select(webDriver.findElement(By.xpath(qtyDropDown)));
    	return dropdown.getOptions().size();
    }
    
	public String productNameFav() {
		String favProdName = favProdDetail.getText();
		return favProdName;
	}

	public void clikcOncechckoutForGuest() {
		pageUtils.waitForPageToLoad();
		jsExecutor.executeScript("arguments[0].click();", checkoutbutton);
		pageUtils.sleepSeconds(5, "SignIn modal");
	}

	public void clickCheckoutAsGuest() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForWebElement(checkoutAsGuest);
		jsExecutor.executeScript("arguments[0].click();", checkoutAsGuest);
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}
	
	public String getBagTotalMobile() {
		pageUtils.waitForWebElement(mobileGetTotalPrice);
		pageUtils.sleepSeconds(7, "wait for page load");
		String getBagTotalPrice = mobileGetTotalPrice.getText();
		System.out.println(getBagTotalPrice);
		String getBagTotalPrice1 = getBagTotalPrice.trim().replaceAll("[^0-9]", "");
		String totalPrice = getBagTotalPrice1.trim().replace(",", "");
		context.saveData("totalPrice", totalPrice);
		return totalPrice;
	}
       	 
	public String getBagTotal() {
		pageUtils.waitForWebElement(getTotalPrice);
		pageUtils.sleepSeconds(7, "wait for page load");
		String getBagTotalPrice = getTotalPrice.getText();
		System.out.println(getBagTotalPrice);
		String getBagTotalPrice1 = getBagTotalPrice.trim().replaceAll("[^0-9]", "");
		String totalPrice = getBagTotalPrice1.trim().replace(",", "");
		context.saveData("totalPrice", totalPrice);
		return totalPrice;

	}

	public void clickOnPromoCodeLink() {
		try {
			pageUtils.waitForPageToLoad();
			pageUtils.sleepSeconds(5, "Wait for promo panel");
			jsExecutor.executeScript("arguments[0].click();", promoLink);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void enterPromoCode(String promocode) {
		try {
			pageUtils.sleepSeconds(5, "Wait for promo field to display");
			promoCodeContainer.sendKeys(promocode);
			pageUtils.sleepSeconds(5, "wait for promo to be applied");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void clickOnApplyPromo() {
		applyPromo.click();
	}

	public void clickOnApplyPromoCodeLink() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(10, "wait for page load");
		pageUtils.waitForWebElement(applyPromoLink);
		jsExecutor.executeScript("arguments[0].click();", applyPromoLink);
		pageUtils.sleepSeconds(5, "wait for page load");
	}
    	
	public boolean isSalePriceDisplayed() {
		boolean flag = false;
		String contry = env.getCurrentLocale().getCountry();
		String locale = env.getLanguage();
		System.out.println(contry);
		System.out.println(locale);
		String wasText = pageUtils.getTextTranslation("was-price-label").toLowerCase();
		String nowText = pageUtils.getTextTranslation("now-price-label").toLowerCase();

		priceDisplayBlock: {

			if (contry.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("fr")) {
				salePriceCAF.getText();
				System.out.println("Now Price is: " + salePriceCAF.getText());
				flag = true;
				break priceDisplayBlock;
			} else if (contry.equalsIgnoreCase("ca") || contry.equalsIgnoreCase("us")) {
				boolean now = listPriceUS.getText().toLowerCase().contains("was");
				boolean sale = salePriceUS.getText().toLowerCase().contains("now");

				if (now && sale) {
					flag = true;
				} else {
					context.embedScreenshots();
					context.writeOut("Was and now labels not displayed");
					context.writeOut("Expected Was: " + wasText + " and Found: " + listPriceEU.getText());
					context.writeOut("Expected Now: " + nowText + "and Found: " + salePriceEU.getText());
				}
				break priceDisplayBlock;

			} else {
				System.out.println("Was Price is: " + listPriceEU.getText());
				boolean eleWas = listPriceEU.getText().toLowerCase().contains(wasText);
				System.out.println(salePriceEU.getText());
				boolean eleNow = salePriceEU.getText().toLowerCase().contains(nowText);
				System.out.println("Now Price is: " + salePriceEU.getText());
				if (eleWas && eleNow) {

					flag = true;
				} else {
					context.embedScreenshots();
					context.writeOut("Was and Now label not displayed");
					context.writeOut("Expected Was: " + wasText + " and Found: " + listPriceEU.getText());
					context.writeOut("Expected Now: " + nowText + "and Found: " + salePriceEU.getText());
				}

				break priceDisplayBlock;
			}
		}
		return flag;
	}

	public boolean verifyItemLevelPromoApplied(int amount, String promoType) {
		boolean flag = false;
		pageUtils.sleepSeconds(3, "");
		pageUtils.waitForWebElement(shoppingBagItemPrice);
		pageUtils.scrollToElement(shoppingBagItemPrice);
		if (promoType.equalsIgnoreCase("$off")) {
			String itemTotalmount = shoppingBagItemPrice.getText();
			String getpromoamount = itemTotalmount.trim().replaceAll("[^0-9]", "");
			String itemPriceBefore = getTheItemPrice().trim().replaceAll("[^0-9]", "");
			double actTotalprice = Double.parseDouble(getpromoamount);
			double actTotalpriceBefore = Double.parseDouble(itemPriceBefore);
			double expected = actTotalpriceBefore - amount;
			if (expected == actTotalprice) {
				flag = true;
				context.writeOut("Actal price: " + actTotalprice + " Expected price: " + expected);
			}
		} else if (promoType.equalsIgnoreCase("%OFF")) {
			String promoamount = shoppingBagItemPrice.getText();
			String getpromoamount1 = promoamount.trim().replaceAll("[^0-9]", "");
			String totalPrice = getpromoamount1.trim().replace(",", "");
			double actPromoprice = Double.parseDouble(totalPrice);
			String itemPriceBefore = context.getSavedData("itemTotalPrice").trim().replaceAll("[^0-9]", "");

			double actTotalSubprice = Double.parseDouble(itemPriceBefore);
			double promoAmnt = amount;
			double expectedPromoPrice = actTotalSubprice - (actTotalSubprice * promoAmnt) / 100;
			if (actPromoprice == expectedPromoPrice) {
				flag = true;
				context.writeOut("Actal price: " + actPromoprice + " Expected price: " + expectedPromoPrice);
			}
		}
		return flag;
	}

	public String getTheItemPrice() {
		pageUtils.sleepSeconds(3, "");
		pageUtils.waitForWebElement(shoppingBagItemPrice);
		pageUtils.scrollToElement(shoppingBagItemPrice);
		String itemPrice = shoppingBagItemPrice.getText();
		context.saveData("itemTotalPrice", itemPrice);
		context.writeOut("Item price is: " + itemPrice);
		pageUtils.sleepSeconds(3, "");
		return itemPrice;
	}

	public boolean isPromoMessageDisplayed() {
		boolean flag = false;
		if (env.getCountryRegion().toString().equalsIgnoreCase("NA")) {
			if (promoMessageNA.isDisplayed()) {
				flag = true;
				context.writeOut("Promo Message is: " + promoMessageNA.getText());
			}
		} else {
			if (promoMessageEU.isDisplayed()) {
				flag = true;
				context.writeOut("Promo Message is: " + promoMessageEU.getText());
			}
		}
		return flag;
	}
	
	public boolean isSalePriceDisplayedMobile() {
		boolean flag = false;
		String contry = env.getCurrentLocale().getCountry();

		if (contry.equalsIgnoreCase("ca")) {
			System.out.println("Was price is: " + mobilePriceList.get(0).getText());
			flag = true;
		} else {
			System.out.println("Was price is: " + mobilePriceList.get(0).getText());
			System.out.println("Now price is: " + mobilePriceList.get(1).getText());
			flag = true;
		}

		return flag;
	}
	
	public void changeShippingOption(String shipToOption) {
		if (shipToOption.equalsIgnoreCase("ship to address")) {
			if (env.getCountryRegion().toString().equalsIgnoreCase("NA")) {
				shiptoAddressNA.click();
				pageUtils.sleepSeconds(2, "wait for page load");
			} else {
				shipToaddressEU.click();
				pageUtils.sleepSeconds(2, "wait for page load");
			}
		} else if (shipToOption.equalsIgnoreCase("pick up in store")) {
			if (env.getCountryRegion().toString().equalsIgnoreCase("NA")) {
				pageUtils.scrollToElement(pickupinstoreNA);
				pickupinstoreNA.click();
				pageUtils.sleepSeconds(2, "wait for page load");
			} else {
				pageUtils.sleepSeconds(2, "wait for page load");
				pageUtils.scrollToElement(pickupinstoreEU);
				pickupinstoreEU.click();
				pageUtils.sleepSeconds(2, "wait for page load");
			}
		} else {
			context.writeOut("Invalid option: " + shipToOption);
		}
	}

	public boolean ischangeShippingOptionChanged(String shipTo) {
		boolean flag = false;
		if (shipTo.equalsIgnoreCase("SHIP TO AN ADDRESS")) {
			if (env.getCountryRegion().toString().equalsIgnoreCase("NA")) {
				pageUtils.sleepSeconds(2, "wait for page load");
				flag = pageUtils.verifyIfDisplayed(shiptoAddressLinkNA);
			} else {
				pageUtils.sleepSeconds(2, "wait for page load");
				flag = pageUtils.verifyIfDisplayed(shiptoAddressItemEU);
			}
		} else {
			if (env.getCountryRegion().toString().equalsIgnoreCase("NA")) {
				pageUtils.sleepSeconds(2, "wait for page load");
				flag = pageUtils.verifyIfDisplayed(collectInStoreItemNA);
			} else {
				pageUtils.sleepSeconds(2, "wait for page load");
				flag = pageUtils.verifyIfDisplayed(collectInStoreItemEU);
			}
		}
		return flag;
	}
	
	public  MkShoppingBagPage_Common enterPickUpInStoreDetails() {
		pageUtils.sleepSeconds(2, "wait for page load");
		if (env.getCountryRegion().toString().equalsIgnoreCase("NA")) {
			pageUtils.sleepSeconds(2, "wait for page load");
			context.writeOut(testData.getUser().address.getStoreId());
			findStoreNA.sendKeys(testData.getUser().address.getStoreId());
		} else {
			pageUtils.sleepSeconds(2, "wait for page load");
			context.writeOut(testData.getUser().address.getStoreId());
			findStoreEU.sendKeys(testData.getUser().address.getStoreId());
		}
		return this;
	}

	public boolean isShippingOptionBopisOptionDisplayed(String bopis, String shipTo) {
	boolean flag = false;
	if (shipTo.equalsIgnoreCase("SHIP TO AN ADDRESS")) {
		if (env.getCountryRegion().toString().equalsIgnoreCase("NA")) {
			pageUtils.sleepSeconds(2, "wait for page load");
			flag = pageUtils.verifyIfDisplayed(shiptoAddressLinkNA);
			context.writeOut(shipTo+" displayed");
		} else {
			pageUtils.sleepSeconds(2, "wait for page load");
			flag = pageUtils.verifyIfDisplayed(shiptoAddressItemEU);
			context.writeOut(shipTo+" displayed");
		}
	} else if (shipTo.equalsIgnoreCase("COLLECT IN STORE")){
		if (env.getCountryRegion().toString().equalsIgnoreCase("NA")) {
			pageUtils.sleepSeconds(2, "wait for page load");
			flag = pageUtils.verifyIfDisplayed(collectInStoreItemNA);
			context.writeOut(bopis+" displayed");
		} else {
			pageUtils.sleepSeconds(2, "wait for page load");
			flag = pageUtils.verifyIfDisplayed(collectInStoreItemEU);
			context.writeOut(bopis+" displayed");
		}
	}
	return flag;
}

    public void clickEditLink(int position, String shipType){
        pageUtils.sleepSeconds(2, "2 sec wait for ajax load");
        int size = productRow.size();
        for(int i=0; i<size; i++) {
        	WebElement shipingType=productRow.get(i).findElement(By.cssSelector(".shipto-address-link or h5"));
        	String typeOfShip = shipingType.getText();
        	if(typeOfShip.equalsIgnoreCase("")) {
        		shipingType=productRow.get(i).findElement(By.cssSelector(".edit a"));
        		shipingType.click();
        		pageUtils.waitForPageToLoad();
                pageUtils.waitForAjaxToComplete();
                pageUtils.sleepSeconds(1, "1 sec wait for ajax load");
                mkEditProductLightbox.waitForEditContainer();
                pageUtils.sleepSeconds(3, "Wait for edit modal to fully load");
        	}else {
        		shipingType=productRow.get(i).findElement(By.cssSelector(".edit a"));
        		shipingType.click();
        		pageUtils.waitForPageToLoad();
                pageUtils.waitForAjaxToComplete();
                pageUtils.sleepSeconds(1, "1 sec wait for ajax load");
                mkEditProductLightbox.waitForEditContainer();
                pageUtils.sleepSeconds(3, "Wait for edit modal to fully load");
        	}
        }
        
    }
    
	public MkShoppingBagPage_Common selectStoreDistance() {
		pageUtils.sleepSeconds(2, "wait for page load");
		if (env.getCountryRegion().toString().equalsIgnoreCase("NA")) {
			storeDistanceNA.click();
			int size = storeDistanceNAMenu.size();
			storeDistanceNAMenu.get(size-1).click();
			pageUtils.sleepSeconds(8, "wait for page load");
		} else {
			storeSerachDistance.click();
			int size = storeSerachDistanceMenu.size();
			String s=storeSerachDistanceMenu.get(size-1).getText();
			storeSerachDistanceMenu.get(size-1).click();
			pageUtils.sleepSeconds(8, "wait for page load");
		}
		return this;
	}
	
	public MkShoppingBagPage_Common clickOnFindStoreButton() {
		pageUtils.sleepSeconds(2, "wait for page load");
		if (env.getCountryRegion().toString().equalsIgnoreCase("NA")) {
			findButtonNA.click();
			pageUtils.sleepSeconds(8, "wait for page load");
		} else {
			findButtonEU.click();
			pageUtils.sleepSeconds(4, "wait for page load");
		}
		return this;
	}
}
