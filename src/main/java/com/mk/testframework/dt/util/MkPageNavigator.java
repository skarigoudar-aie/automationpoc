package com.mk.testframework.dt.util;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;

/**
 * @author VThipperudrappa
 *
 */
public class MkPageNavigator {

	@FindBy(css = ".mk-pdp-page")
	private WebElement customizePage;

	@FindBy(css = ".mk-pdp-page")
	private WebElement pdpPage;

	@FindBy(css = ".mk-plp-page")
	private WebElement plpPage;

	@FindBy(css = ".mk-homepage")
	private WebElement homePage;

	@FindBy(css = ".mk-search-page")
	private WebElement searchPage;

	@FindBy(css = ".mk-search-page-rfk")
	private WebElement rfk_searchPage;

	@FindBy(css = ".profile_landing")
	private WebElement profileLandingPage;

	@FindBy(css = ".create_account_container")
	private WebElement createAccountPage;

	@FindBy(tagName = "body")
	private WebElement bodyElement;

	@FindBy(css = ".shopping-bag-cart")
	private WebElement shoppingBagPage;

	@FindBy(css = ".signup-button")
	private WebElement newsletterpage;

	@FindBy(css=".newsletter_signup_btn")
	private WebElement GoShoppingButton;

	@FindBy(css=".cookies_player_display")
	private WebElement cookieMessageIsDisplaying;

	@FindBy(how = How.ID, using = "shippingContainer")
	private WebElement shippingPage;
	
	@FindBy(how = How.ID, using = "fluidConfigure")
	private WebElement isOnFluidPdp;
	
	@FindBy(css = ".payment_information_page")
	private WebElement paymentInformationPage;
	
	@FindBy(css = ".order_history_container")
	private WebElement orderHistoryPage;
	
	@FindBy(css = ".favorite_container")
	private WebElement favoritePage;
	
	@FindBy(css=".mk-giftcard-page")
	private WebElement giftCardLandingPage;
	
	@FindBy(css=".plp-category-heading h1")
	private WebElement plpPageName;
	
	
	private WebDriver webDriver;
	private Environment env;
	private PageUtils pageUtils;
	private Context context;

	@Inject
	public MkPageNavigator(WebDriver webDriver, Environment env, PageUtils pageUtils, Context context,
						   ModalUtils modalUtils) {

		this.webDriver = webDriver;
		this.env = env;
		this.pageUtils = pageUtils;
		this.context = context;
		PageFactory.initElements(webDriver, this);
	}

	public void goToHomePage() {
		try{
			context.writeOut("Navigating to : "+env.getMkUrl()+" Home Page");
			webDriver.get(env.getMkUrl());
		}
		catch(Exception e){
			pageUtils.refresh();
			pageUtils.waitForPageToLoad();
		}
	}

	public boolean onProductDetailPage() {
		boolean flag = false;
		try {
			if (pdpPage.isDisplayed() || pdpPage.isEnabled()) {
				flag = true;
			}
		} catch (Exception e) {
			try {
				pageUtils.sleepSeconds(5, "waiting for product detail page to load");
				context.writeOut("Waited for 5 seconds PDP to load");
				flag = pdpPage.isDisplayed();
			} catch (Exception e2) {
				pageUtils.sleepSeconds(10, "waiting for product detail page to load");
				context.writeOut("Waited for 10 seconds PDP to load");
				flag = pdpPage.isDisplayed();
			}
		}
		return flag;
		
	}

	public boolean onProductListingPage() {
		boolean flag = false;
		try {
			if(plpPage.isDisplayed() || plpPage.isEnabled()) {
				flag = true;
			}
		} catch (Exception e) {
			try {
				pageUtils.sleepSeconds(5, "product listing page to load");
				context.saveData("plpName", plpPageName.getText());
				context.writeOut("Waited for 5 seconds to load PLP");
				flag = plpPage.isDisplayed();
			} catch (Exception e2) {
				pageUtils.sleepSeconds(5, "waiting for product listing page to load");
				context.saveData("plpName", plpPageName.getText());
				flag = pageUtils.verifyIfDisplayed(plpPage);
			}
		}
		return flag;
	}

	public boolean onHomePage() {
		pageUtils.waitForWebElement(homePage);
		return pageUtils.verifyIfDisplayed(homePage);
	}

	public boolean onSearchPage() {
		boolean status = pageUtils.verifyIfDisplayed(searchPage);
		if (searchPage.isDisplayed() || searchPage.isEnabled() || rfk_searchPage.isDisplayed() || rfk_searchPage.isEnabled() ) {
			status = true;
		}
		return status;
	}

	public boolean onProfileLandingPage() {
		pageUtils.waitForPageToLoad();
		return pageUtils.verifyIfDisplayed(profileLandingPage);
	}

	public boolean onCreateAccountPage() {
		pageUtils.waitForPageToLoad();
		return pageUtils.verifyIfDisplayed(createAccountPage);
	}

	public String getBodyIdAttribute() {
		return bodyElement.getAttribute("id");
	}

	public boolean onShoppingBagPage() {
		boolean flag = false;
		pageUtils.waitForPageToLoad();
		try {
			if(shoppingBagPage.isDisplayed()) {
				flag = true;
			}
		} catch (Exception e) {
			try {
				pageUtils.sleepSeconds(5, "Wait for shopping bag to load");
				if(shoppingBagPage.isDisplayed()) {
					flag = true;
					context.writeOut("Waited for 5 seconds to load the shopping bag");
				}
			} catch (Exception e2) {
				pageUtils.sleepSeconds(5, "Wait for shopping bag to load");
				pageUtils.waitForWebElement(shoppingBagPage);
				flag = pageUtils.verifyIfDisplayed(shoppingBagPage);
			}
		}
		return flag;
	}

	public void goToAccountInfoPage() {
		try {
			URL currentUrl = new URL(pageUtils.getCurrentUrl());
			webDriver.get("https://" + currentUrl.getHost() + "/myaccount/accountInformation.jsp");
			pageUtils.sleepSeconds(2, "waiting for account info page load");
			pageUtils.waitForPageToLoad();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}


	public boolean onNewsLetterPage() {
		return pageUtils.verifyIfDisplayed(newsletterpage);

	}

	public boolean thanksForSignUpPage() {
		return pageUtils.verifyIfDisplayed(GoShoppingButton);
	}
	public boolean isCookiemessageDisplayed() {
		return pageUtils.waitForWebElement(cookieMessageIsDisplaying);
	}
	public boolean onShippingPage() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForWebElement(shippingPage);
		return pageUtils.verifyIfDisplayed(shippingPage);
	}
	
	public boolean onFluidPDP() {
		pageUtils.waitForPageToLoad();
		pageUtils.sleepSeconds(8, "wait");
		pageUtils.waitForWebElement(isOnFluidPdp);
		return pageUtils.verifyIfDisplayed(isOnFluidPdp);
	}
	
	public boolean onPaymentinformationPage()
	{
		pageUtils.waitForPageToLoad();
		pageUtils.waitForWebElement(paymentInformationPage);
		return pageUtils.verifyIfDisplayed(paymentInformationPage);
		
	}
	public boolean onFavouritePage()
	{
		pageUtils.waitForPageToLoad();
		pageUtils.waitForWebElement(favoritePage);
		return pageUtils.verifyIfDisplayed(favoritePage);
		
	}
	public boolean onOrderHistoryPage()
	{
		pageUtils.waitForPageToLoad();
		pageUtils.waitForWebElement(orderHistoryPage);
		return pageUtils.verifyIfDisplayed(orderHistoryPage);
		
	}

	public boolean onGiftCardLandingPage() {
		pageUtils.waitForPageToLoad();
		pageUtils.waitForWebElement(giftCardLandingPage);
		return pageUtils.verifyIfDisplayed(giftCardLandingPage);
	}
}