package com.mk.testframework.stepdefs.crossPlatformSteps.global;

import com.google.inject.Inject;
import com.mk.testframework.dt.page.shoppingbag.MkShoppingBagPage_EuGlobal;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.page.shoppingbag.MkShoppingBagPage_Common;
import com.mk.testframework.dt.popup.MkCheckoutSignInModal_EuGlobal;
import com.mk.testframework.dt.util.MkPageNavigator;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class ShoppingBagPageStepDefGlobal {
	private MkShoppingBagPage_EuGlobal mkShoppingBagPageEUGlobal;
	private MkCheckoutSignInModal_EuGlobal mkCheckoutSignInModalEU;
	private MkPageNavigator mkPageNavigator;
	private MkShoppingBagPage_Common mkShoppingBagPageCommon;
	private Context context;

	@Inject
	public ShoppingBagPageStepDefGlobal(MkCheckoutSignInModal_EuGlobal mkCheckoutSignInModalEU,
			MkPageNavigator mkPageNavigator, MkShoppingBagPage_EuGlobal mkShoppingBagPageEUGlobal,
			MkShoppingBagPage_Common mkShoppingBagPageCommon, Context context) {
		this.mkShoppingBagPageEUGlobal = mkShoppingBagPageEUGlobal;
		this.mkCheckoutSignInModalEU = mkCheckoutSignInModalEU;
		this.mkShoppingBagPageCommon = mkShoppingBagPageCommon;
		this.mkPageNavigator = mkPageNavigator;
		this.context = context;
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

	@Then("I verify the {int} {string} promotion got applied")
	public void iVerifyAllThePromotionGotApplied(int amount, String promoType) {
		Assert.assertTrue("promotion not applied", mkShoppingBagPageEUGlobal.verifyPromoApplied(amount, promoType));
	}

	@And("I verify product detail on SBP page is same as on Favourite page")
	public void I_verify_product_detail_on_Favourite_page() {
		Assert.assertEquals(context.getSbpProductName().toLowerCase(),
				mkShoppingBagPageCommon.productNameFav().toLowerCase());
	}

	@Then("I verify All the promotion got applied")
	public void iVerifyAllThePromotionGotApplied() {
		Assert.assertTrue("5 promotion not applied", mkShoppingBagPageEUGlobal.verify5PromoApplied());
	}

	@Then("I verify Apply Promo Code section expanded")
	public void iVerifyApplyPromoCodeSectionExpanded() {
		Assert.assertTrue("Promo code section is expanded",
				mkShoppingBagPageEUGlobal.isPromoTextAndApplyButtonDisplayed());
	}

	@When("I apply a PromoCode on shopping bag page")
	public void iApplyPromoCodeOnShoppingBagPage() {
		mkShoppingBagPageEUGlobal.applyPromotion();
	}

	@Then("I verify Promotion is applied in shopping bag")
	public void iVerifyPromotionIsAppliedInShoppingBag() {
		Assert.assertTrue("5 promotion not applied", mkShoppingBagPageEUGlobal.verifyPromotionApplied());
	}

	@When("SBP: I click on Checkout Securely button for loggedIn user")
	public void IClickOnCheckoutSecurelyButtonForLoggedInUser() {
		mkShoppingBagPageEUGlobal.clickLoggedInCheckout();
	}

}
