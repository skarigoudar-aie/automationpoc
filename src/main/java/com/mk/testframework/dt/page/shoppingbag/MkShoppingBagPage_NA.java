package com.mk.testframework.dt.page.shoppingbag;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.util.PageUtils;
import org.openqa.selenium.By;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MkShoppingBagPage_NA {

	@FindBy(css = "#quantityCartSelector_ option[selected='true']")
	private WebElement selectedQuantity;

	@FindBy(css = "#quantityCartSelector_ option[selected='true']")
	private List<WebElement> selectedQuantityList;

	@FindBy(css = ".itemUpdate")
	private WebElement itemUpdatedMessage;

	@FindBy(css = "#cartCheckoutButton")
	private WebElement checkout;

	@FindBy(xpath = "//ul[@class='shopping-bag-order-summary-details']/li/div[2]/p")
	private WebElement bagTotalNA;

	@FindBy(css = "#shopping-bag-promo")
	private WebElement promoTextFeild;

	@FindBy(xpath = "(//input[@type='submit'])[3]")
	private WebElement promoApplyButton;

	@FindBy(css = "#removeCoupon_4")
	private WebElement appliedPromoSection;

	@FindBy(css = "#promocodediscounttable")
	private WebElement promoCodeAppliedsection;

	@FindBy(xpath = "(//*[@class='shopping-bag-order-summary-details']/li/div)[2]")
	private WebElement orderSummarySubtotal;

	@FindBy(xpath = "(//*[@class='shopping-bag-order-summary-details']/li/div)[4]")
	private WebElement promoCodeOrderSummary;
    
    @FindBy(css = "#removeCoupon_0")
    private WebElement verifyPromotionApplied;
    
    @FindBy(xpath = "(//ul[@class='shopping-bag-order-summary-details'])[1]/li/div[2]")
    private WebElement orderSummarySubTotal;

    @FindBy(xpath = "//*[@href='#cartPromotion']")
	private WebElement promoLink;
	
	@FindBy(xpath = "//*[@id='shopping-bag-promo']")
	private WebElement promoCodeContainer;
	
	@FindBy(xpath = "//*[@id='claimCode']")
	private WebElement applyPromo;
	
	@FindBy(css = ".promoCodeMsgContainer")
	private WebElement promoScuccessContainer;

	@FindBy(xpath = "(//ul[@class='shopping-bag-order-summary-totals'])[3]/li/div[2]/p")
	private WebElement orderSummaryTotalPriceUS;

	@FindBy(xpath = "(//ul[@class='shopping-bag-order-summary-totals'])/li/div[2]/p")
	private WebElement orderSummaryTotalPriceCA;

	@FindBy(xpath = "(//ul[@class='shopping-bag-order-summary-details'])[1]/li[2]/div[2]")
	private WebElement orderSummaryGetPromotion;

	@FindBy(xpath = "//button[@class ='btn dropdown-toggle btn-default']")
	private WebElement shipingDropDown;

	@FindBy(xpath = "//ul[@class ='dropdown-menu inner']/li[2]")
	private WebElement selectShippingCharge_CA;

	@FindBy(css = "row row--no-gutter-margin shipping-message-container")
	private WebElement verifyShippingMethod;

	@FindBy(css = ".shopping-bag-cart .shopping-bag-item .text-center .h5")
	private List<WebElement> listOfProductPrice;
    
    @FindBy(css = "#shoppingCartItems .shopping-bag-item img")
    private List<WebElement> productImage;
    
    @FindBy(css = ".shopping-bag-item")
    private List<WebElement> productSection;
    
    @FindBy(css = ".shopping-bag-item__description span")
	private List<WebElement> productStyle;
	    
    @FindBy(css = ".shopping-bag-item__size")
    private List<WebElement> productSize;
    
    @FindBy(css = ".row--table .product-values")
    private List<WebElement> productPrice;
    
    @FindBy(css = ".quantity-container")
    private List<WebElement> productQty;
    
    @FindBy(css = ".shopping-bag-item .v-list h2")
    private List<WebElement> productName;
    
    @FindBy(css = "#removeCoupon_0")
    private WebElement verifyPromotionapplied;
    

    @FindBy(css = ".shopping-bag-item__color .product-values")
    private List<WebElement> productColor;

		
	private PageUtils pageUtils;
	private JavascriptExecutor jsExecutor;
	private TestData testData;
	private Context context;
	private Environment env;
	private WebDriver webDriver;
    
	@Inject
	public MkShoppingBagPage_NA(WebDriver webDriver, PageUtils pageUtils, TestData testData, Context context, Environment env) {
		PageFactory.initElements(webDriver, this);
		this.jsExecutor = ((JavascriptExecutor) webDriver);
		this.pageUtils = pageUtils;
		this.env = env;
		this.testData = testData;
		this.context = context;
		this.webDriver = webDriver;
	}

    public Integer getSelectedQuantity(){
        return Integer.parseInt(selectedQuantity.getAttribute("value"));
    }

    public boolean verifyItemUpdatedMessage(){
        return itemUpdatedMessage.isDisplayed();
    }
    
	public void clickCheckout() {
		pageUtils.sleepSeconds(3, "wait for page load");
		pageUtils.waitTillWebElementIsClickable(checkout);
		checkout.click();
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
	}

	public int getTotalShoppingBagCount() {
		int sum = 0;

		for (int i = 0; i < selectedQuantityList.size(); i++) {
			WebElement qty = selectedQuantityList.get(i);

            if(qty.isDisplayed()){
                sum += Integer.parseInt(qty.getAttribute("innerText").trim());
            }
        }
        return sum;
    }
    
    public String getAppliedCouponName(String product) {
    	String couponName = "//span[contains(text(),'"+product+"')]//ancestor::div[@class='v-list']/..//p[contains(@class,'h3')]";
    	return webDriver.findElement(By.xpath(couponName)).getText().trim().replaceAll("nbsp;", " ");
    }
    
    public boolean verifyAppliedNonSaleItemEMPCouponName(String product) {
    	String expectedCouponName = pageUtils.getTextTranslation("employee-discount-non-sale-na");
    	String actualAppliedCouponName = getAppliedCouponName(product);
    	if(actualAppliedCouponName.equals(expectedCouponName))
    		return true;
    	else
    		return false;
    }
    
    public boolean verifyAppliedSaleItemEMPCouponName(String product) {
    	String expectedCouponName = pageUtils.getTextTranslation("employee-discount-sale-na");
    	String actualAppliedCouponName = getAppliedCouponName(product);
    	if(actualAppliedCouponName.equals(expectedCouponName))
    		return true;
    	else
    		return false;
    }
    
    public void clickOnPromoCodeLink() {
		try {
			pageUtils.sleepSeconds(10, "Wait for promo code panel");
			jsExecutor.executeScript("arguments[0].click();", promoLink);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void enterPromoCode(String promocode) {
		pageUtils.sleepSeconds(5, "Wait for promo field to display");
		promoCodeContainer.sendKeys(promocode);
		pageUtils.sleepSeconds(5, "wait for promo to be applied");
	}
	
	public void clickOnApplyPromo() { 
	    applyPromo.click();
	}

	public boolean PromoApplied() {
		boolean status = false;
		pageUtils.sleepSeconds(10, "wait for promo conatiner");
	    if(pageUtils.verifyIfDisplayed(promoScuccessContainer)) {
	    	status = true;
	    }
	    return status;     		   
	 }

	public String bagSubTotalPrice() {
		pageUtils.waitForWebElement(bagTotalNA);
		pageUtils.sleepSeconds(2, "wait for pageload");
		String bagTotalprice1 = bagTotalNA.getText();
		System.out.println(bagTotalprice1);
		String bagTotalprice = bagTotalprice1.trim().replace(" $", "");
		return bagTotalprice;
	}

	public void applyPromotion() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForAjaxToComplete();
		promoTextFeild.sendKeys(testData.getPromotion().getcouponCode());
		pageUtils.waitForAjaxToComplete();
		pageUtils.sleepSeconds(2, "wait for page load");
		jsExecutor.executeScript("arguments[0].click();", promoApplyButton);
		pageUtils.sleepSeconds(2, "wait for page load");
	}

	public boolean isPromoTextAndApplyButtonDisplayed() {
		pageUtils.sleepSeconds(5, "wait for page load");
		pageUtils.verifyIfDisplayed(promoTextFeild);
		return pageUtils.verifyIfDisplayed(promoApplyButton);

	}

	public boolean verifyPromoApplied() {
		pageUtils.sleepSeconds(5, "wait for page load");
		return pageUtils.verifyIfDisplayed(verifyPromotionApplied);

	}

	public double subTotalFromOrderSummary() {
		pageUtils.waitForWebElement(orderSummarySubTotal);
		pageUtils.sleepSeconds(3, "wait for page load");
		String subtotalInOrderSummary = orderSummarySubTotal.getText();
		String subtotalInOrderSummary1 = subtotalInOrderSummary.trim().replaceAll("[^0-9]", "");
		double orderSummarySuTotal = Double.parseDouble(subtotalInOrderSummary1.toString());
		return orderSummarySuTotal;
	}

	public double getTotalFromOrderSummaryUS() {
		pageUtils.waitForWebElement(orderSummaryTotalPriceUS);
		pageUtils.sleepSeconds(3, "wait for page load");
		String getTotalInOrderSummary = orderSummaryTotalPriceUS.getText();
		String getOrderTotal = getTotalInOrderSummary.trim().replaceAll("[^0-9]", "");
		double getOrderTotal1 = Double.parseDouble(getOrderTotal.toString());
		return getOrderTotal1;
	}

	public double getTotalFromOrderSummaryCA() {
		pageUtils.sleepSeconds(3, "wait for page load");
		pageUtils.waitForWebElement(orderSummaryTotalPriceCA);
		String getTotalInOrderSummary = orderSummaryTotalPriceCA.getText();
		String getOrderTotal = getTotalInOrderSummary.trim().replaceAll("[^0-9]", "");
		double getOrderTotal1 = Double.parseDouble(getOrderTotal.toString());
		return getOrderTotal1;
	}

	public double getPromotionFromOrderSummary() {
		pageUtils.waitForWebElement(orderSummaryGetPromotion);
		pageUtils.sleepSeconds(3, "wait for page load");
		String getPromotionInOrderSummary = orderSummaryGetPromotion.getText();
		String getPromotion = getPromotionInOrderSummary.trim().replaceAll("[^0-9]", "");
		double getPromotion1 = Double.parseDouble(getPromotion.toString());
		return getPromotion1;
	}

	public void selectShiipingMethod() {
		pageUtils.sleepSeconds(5, "wait for page load");
		pageUtils.scrollToElement(shipingDropDown);
		shipingDropDown.click();
		selectShippingCharge_CA.click();
		Assert.assertFalse("Shipping method not selected", pageUtils.verifyIfDisplayed(verifyShippingMethod));

	}

	public boolean verify5PromoApplied() {
		pageUtils.sleepSeconds(2, "wait for page load");
		return pageUtils.verifyIfDisplayed(appliedPromoSection);
	}
	
	public boolean verifyPromoApplied(int amount, String promoType) {
		boolean flag = false;
		String contry = env.getCurrentLocale().getCountry();
		String locale = env.getLanguage();
		String totalPrice = "";
		String totalSubPrice = "";
		pageUtils.sleepSeconds(2, "Waiting for the element to visible");
		pageUtils.scrollToElement(orderSummarySubtotal);
		pageUtils.waitForWebElement(orderSummarySubtotal);
		if (promoType.equalsIgnoreCase("$off")) {
			pageUtils.scrollToElement(orderSummarySubtotal);
			String promoamount = promoCodeOrderSummary.getText();
			String getpromoamount1 = promoamount.trim().replaceAll("[^0-9]", "");
			if (contry.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("fr")) {
				totalPrice = getpromoamount1.trim().replace(",", ".");
			} else {
				totalPrice = getpromoamount1.trim().replace(",", "");
			}
			double actTotalprice1 = Double.parseDouble(totalPrice);
			double expected = amount;
			if (expected == actTotalprice1) {
				flag = true;
				context.writeOut("Actal price: " + actTotalprice1 + " Expected price: " + expected);
			}
		} else if (promoType.equalsIgnoreCase("%OFF")) {
			String promoamount = promoCodeOrderSummary.getText();
			String getpromoamount1 = promoamount.trim().replaceAll("[^0-9]", "");
			if (contry.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("fr")) {
				totalPrice = getpromoamount1.trim().replace(",", ".");
			} else {
				totalPrice = getpromoamount1.trim().replace(",", "");
			}
			double actPromoprice = Double.parseDouble(totalPrice);
			String actualSubTotal = orderSummarySubtotal.getText();
			String orderSummarySub = actualSubTotal.trim().replaceAll("[^0-9]", "");
			if (contry.equalsIgnoreCase("ca") && locale.equalsIgnoreCase("fr")) {
				totalSubPrice = orderSummarySub.trim().replace(",", ".");
			} else {
				totalSubPrice = orderSummarySub.trim().replace(",", "");
			}
			double actTotalSubprice = Double.parseDouble(totalSubPrice);
			double promoAmnt = amount;
			double expectedPromoPrice = (actTotalSubprice * promoAmnt) / 100;
			if (actPromoprice == expectedPromoPrice) {
				flag = true;
				context.writeOut("Actal price: " + actPromoprice + " Expected price: " + expectedPromoPrice);
			}
		}
		return flag;
	}
	
	public boolean shoppingBagProductPriceCalculator() {
		boolean flag = false;
		double total = 0;
		try {
			for (int i = 0; i < listOfProductPrice.size(); i++) {
				String amount1 = listOfProductPrice.get(i).getText();
				String productPrice = amount1.trim().replaceAll("[^0-9]", "");
				System.out.println(productPrice);
				total = total + Double.parseDouble(productPrice);
				context.writeOut("Total of product amount: " + total);
			}
			double actSubTotalPrice = subTotalFromOrderSummary();
			context.writeOut("Total amount from order summary: " + actSubTotalPrice);
			if (actSubTotalPrice == total) {
				flag = true;
			}
		} catch (Exception e) {

		}
		Assert.assertTrue("SubTotal value is not eual to sum of all product", true);
		return flag;
	}
	
	public boolean verifyProductNameDisplayed() {
		boolean flag=true;
		int size=productSection.size();
				for(int i=0; i<size;i++) {
				productName.get(i).getText();
				context.writeOut("Product Name: "+productName.get(i).getText());
				if(productName.get(i).toString().isBlank()&&productName.get(i).toString().isEmpty()) {
					flag = false;
				}
			
		}
		return flag;
	}
	
	public boolean verifyProductPriceDisplayed() {
		boolean flag=true;
		int size=productSection.size();
				for(int i=0; i<size;i++) {
				productPrice.get(i).getText();
				context.writeOut("Product Price: "+productPrice.get(i).getText());
				if(productName.get(i).toString().isBlank()&&productName.get(i).toString().isEmpty()) {
					flag = false;
				}
			}
		
		return flag;
	}
	
	public boolean verifyProductStyleDisplayed() {
		boolean flag=true;
		int size=productSection.size();

			for(int i=0; i<size;i++) {
				productStyle.get(i).getText();
				context.writeOut("Product Style is: "+productStyle.get(i).getText());
				if(productStyle.get(i).toString().isBlank()&&productStyle.get(i).toString().isEmpty()) {
					flag = false;
				}
			}
		
		return flag;
	}
	
	public boolean verifyProductImageDisplayed() {
		boolean flag=true;
		int size=productSection.size();
		
			for(int i=0; i<size;i++) {
				productImage.get(i).getText();
				context.writeOut("Product Image URL: "+productImage.get(i).getAttribute("src"));
				if(productImage.get(i).getAttribute("src").isBlank()&&productImage.get(i).getAttribute("src").isEmpty()) {
					flag = false;
				}
			}
		
		return flag;
	}
	
	public boolean verifyProductColorDisplayed() {
		boolean flag=true;
		int size=productSection.size();
		
			for(int i=0; i<size;i++) {
				productColor.get(i).getText();
				context.writeOut("Product Color :"+productColor.get(i).getText());
				if(productColor.get(i).toString().isBlank()&&productColor.get(i).toString().isEmpty()) {
					flag = false;
				}
			}
		
		return flag;
	}
	
	public boolean verifyProductQtyDisplayed() {
		boolean flag=true;
		int size=productSection.size();
			for(int i=0; i<size;i++) {
				selectedQuantityList.get(i).getText();
				context.writeOut("Product Qty :"+selectedQuantityList.get(i).getAttribute("innerText").trim());
				if(selectedQuantityList.get(i).toString().isBlank()&&selectedQuantityList.get(i).toString().isEmpty()) {
					flag = false;
				}
			}
		
		return flag;
	}
	
	public boolean verifyProductSizeDisplayed() {
		boolean flag=true;
		if (productSize.isEmpty()) {
			context.writeOut("This is not an sized item hence skipping the step");
		} else {
			int size = productSize.size();
			for (int i = 0; i < size; i++) {
				productSize.get(i).getText();
				context.writeOut("Product Size :" + productSize.get(i).getText());
				if (productSize.get(i).toString().isBlank() && productSize.get(i).toString().isEmpty()) {
					flag = false;
				}
			}
		}
		return flag;
	}
	       
	 public boolean verifyPromotionApplied() {
			pageUtils.waitForWebElement(verifyPromotionapplied);
			return pageUtils.verifyIfDisplayed(verifyPromotionapplied);

		}
}
