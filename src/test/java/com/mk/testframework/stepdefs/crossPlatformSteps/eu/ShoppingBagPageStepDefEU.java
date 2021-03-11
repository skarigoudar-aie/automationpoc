package com.mk.testframework.stepdefs.crossPlatformSteps.eu;

import com.mk.testframework.dt.util.MkPageNavigator;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.page.shoppingbag.MkShoppingBagPage_EuGlobal;
import com.mk.testframework.dt.popup.MkCheckoutSignInModal_EuGlobal;
import com.mk.testframework.dt.page.shoppingbag.MkShoppingBagPage_Common;
import com.mk.testframework.dt.page.shoppingbag.MkShoppingBagPage_EU;

import cucumber.api.java.en.And;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class ShoppingBagPageStepDefEU {

	private MkShoppingBagPage_EuGlobal mkShoppingBagPageEUGlobal;
	private MkCheckoutSignInModal_EuGlobal mkCheckoutSignInModalEU;
	private MkPageNavigator mkPageNavigator;
	private MkShoppingBagPage_Common mkShoppingBagPageCommon;
	private Context context;
	private MkShoppingBagPage_EU mkShoppingBagPage_EU;

	@Inject
	public ShoppingBagPageStepDefEU(MkCheckoutSignInModal_EuGlobal mkCheckoutSignInModalEU, MkPageNavigator mkPageNavigator,
									MkShoppingBagPage_EuGlobal mkShoppingBagPageEUGlobal, MkShoppingBagPage_Common mkShoppingBagPageCommon, Context context, MkShoppingBagPage_EU mkShoppingBagPage_EU) {
		this.mkShoppingBagPageEUGlobal = mkShoppingBagPageEUGlobal;
		this.mkCheckoutSignInModalEU = mkCheckoutSignInModalEU;
		this.mkPageNavigator = mkPageNavigator;
		this.mkShoppingBagPageCommon = mkShoppingBagPageCommon;
		this.context = context;
		this.mkShoppingBagPage_EU = mkShoppingBagPage_EU;
	}

	@And("SBP: I can verify quantity updated message")
	public void sbpICanVerifyQuantityUpdatedMessage() {
		Assert.assertTrue("Failed verifying message", mkShoppingBagPageEUGlobal.verifyItemUpdatedMessage());
	}

	@And("SBP: I can verify the number of quantity is {int}")
	public void sbpICanVerifyTheNumberOfQuantityIs(Integer quantity) {
		Assert.assertEquals("Incorrect product quantity", quantity, mkShoppingBagPageEUGlobal.getSelectedQuantity());
	}

	@And("SBP: I click Checkout as guest")
	public void i_click_checkout_as_guest() {
		mkCheckoutSignInModalEU.clickCheckoutAsGuest();
	}

	@And("SBP: I can see a Shopping Bag total quantity of {int}")
	public void sbpICanSeeAShoppingBagTotalQuantityOf(int expectedQty) {
		if (mkPageNavigator.onShoppingBagPage()) {
			int actualProductCount = mkShoppingBagPageEUGlobal.getTotalShoppingBagCount();
			Assert.assertEquals("Expected total quantity of items in the bag wrong", expectedQty, actualProductCount);
		}
	}

	@Then("SBP: I verify Klarna widget is displayed on Shopping bag page")
	public void sbpIVerifyKlarnaWidgetIsDisplayedOnShoppingBagPage() {
		Assert.assertTrue("Klarna widget not displayed on Shopping bag page",
				mkShoppingBagPageEUGlobal.isKlarnaWidgetDisplayed());
	}

	@And("SBP: I click on Add To Favorite")
	public void i_click_add_to_favorite() {
		mkShoppingBagPageCommon.sbpAddToFavorite();
	}

	@And("SBP: I can verify item added to favorite message")
	public void sbpICanVerifyItemAddedToFavoriteMessage() {
		Assert.assertTrue("Failed verifying message", mkShoppingBagPageCommon.verifyItemAddedToFavoriteMessage());
	}

	@And("SBP: I capture Product Details")
	public void sbpICaptureProductDetails() {
		String sbpProductName = mkShoppingBagPageCommon.getProductDetails().toLowerCase();
		context.setSbpProductName(sbpProductName);
	}

	@And("I verify product detail on SBP page is same as on Favourite page")
	public void I_verify_product_detail_on_Favourite_page() {
		Assert.assertEquals(context.getSbpProductName().toLowerCase(),
				mkShoppingBagPageCommon.productNameFav().toLowerCase());
	}

	@When("SBP: I click on checkout Securely button")
	public void iClickOnCheckoutSecurelyButton() {
		mkShoppingBagPageCommon.clikcOncechckoutForGuest();
	}

	@And("SBP: I verify {string} [Selected Country] message is displayed")
	public void i_Verify_Order_To_Be_Delivered_To_Country(String message) {
		String actualMessage = mkShoppingBagPageCommon.getdeliveryMsg();
		Assert.assertTrue("Expected message is wrong", actualMessage.contains(message));
	}

	@And("SBP: I verify {string} [Selected Country]. {string} [former country]. message is displayed at order summary")
	public void i_Verify_Checkout_Securely_To_Proceed_With_Shipping_To_Selected_Country_Message(String Message1,
			String Message2) {
		String actualMessage = mkShoppingBagPageCommon.getbasketPortingInfo();
		Assert.assertTrue("Expected message is wrong", actualMessage.contains(Message1));
	}

	@Then("SBP: I click on checkout as guest button")
	public void iClickOnChecoutAsGuestButton() {
		mkShoppingBagPageCommon.clickCheckoutAsGuest();
	}

	@When("SBP: I click on Checkout Securely button for loggedIn user")
	public void IClickOnCheckoutSecurelyButtonForLoggedInUser() {
		mkShoppingBagPageEUGlobal.clickLoggedInCheckout();
	}

	@And("SBP: I verified promo is applied succesfully")
	public void I_verified_promo_is_applied_succesfully() {
		Assert.assertTrue("Expected Display Promotions Container", mkShoppingBagPageCommon.PromoApplied());
	}

	@And("SBP: I apply promo code {string}")
	public void IClickOnCheckoutSecurelyButtonForLoggedInUser(String promo) {
		mkShoppingBagPageCommon.clickOnPromoCodeLink();
		mkShoppingBagPageCommon.enterPromoCode(promo);
		mkShoppingBagPageCommon.clickOnApplyPromo();
	}
		      
     @And("SBP: I verify Employee discount amount for sale item {string}")
	 public void iVerifyEmployeeDiscountAmountForSaleItem(String product) {
    	 Assert.assertTrue("Employee discount not matched for sale item", mkShoppingBagPage_EU.verifyAppliedSaleItemEMPCouponName(product));
	 }
	 
 		@And("SBP: I verify Employee discount amount for non sale item {string}")
		public void iVerifyEmployeeDiscountAmountForNonSaleItem(String product) {
			Assert.assertTrue("Employee discount not matched for non sale item",
					mkShoppingBagPage_EU.verifyAppliedNonSaleItemEMPCouponName(product));
		}

		@Then("SBP: I verify max product limit for {string} in the quantity dropdown is {int} after applying Employee promo")
		public void iVerifyMaxProductLimitInTheQuantityDropdownAfterApplyingEmployeePromo(String product, int qty) {
			Assert.assertEquals("Expected quantity not macted", qty,
					mkShoppingBagPageCommon.verifyQuantityLimitAfterEmployeePromoApplied(product) - 1);
		}
		
	@Then("I verify Apply Promo Code section expanded")
	public void iVerifyApplyPromoCodeSectionExpanded() {
		Assert.assertTrue("Promo code section is expanded",
		mkShoppingBagPageEUGlobal.isPromoTextAndApplyButtonDisplayed());
	}

		@Then("SBP: I verify promotion got applied")
		public void iVerifyPromotionGotApplied() {
			Assert.assertTrue("Promotion not applied", mkShoppingBagPageEUGlobal.verifyPromotionApplied());
		}
		
			
	@When("I apply a PromoCode on shopping bag page")
	public void iApplyPromoCodeOnShoppingBagPage() {
		mkShoppingBagPageEUGlobal.applyPromotion();
	}
	
	@Then("I verify Promotion is applied in shopping bag")
	public void iVerifyPromotionIsAppliedInShoppingBag()
	{
		Assert.assertTrue("5 promotion not applied", mkShoppingBagPageEUGlobal.verifyPromotionApplied());
	}

		@Then("I verify All the promotion got applied")
		public void iVerifyAllThePromotionGotApplied() {
			Assert.assertTrue("5 promotion not applied", mkShoppingBagPageEUGlobal.verify5PromoApplied());
		}

}
