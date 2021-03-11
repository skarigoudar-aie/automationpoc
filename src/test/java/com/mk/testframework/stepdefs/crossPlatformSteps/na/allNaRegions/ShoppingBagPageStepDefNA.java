package com.mk.testframework.stepdefs.crossPlatformSteps.na.allNaRegions;

import com.google.inject.Inject;
import com.mk.testframework.dt.page.shoppingbag.MkShoppingBagPage_Common;
import com.mk.testframework.dt.page.shoppingbag.MkShoppingBagPage_NA;
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
public class ShoppingBagPageStepDefNA {

	private MkShoppingBagPage_NA mkShoppingBagPageNA;
	private MkPageNavigator mkPageNavigator;
	private MkShoppingBagPage_Common mkShoppingBagPageCommon;

	@Inject
	public ShoppingBagPageStepDefNA(MkShoppingBagPage_NA mkShoppingBagPageNA, MkPageNavigator mkPageNavigator, MkShoppingBagPage_Common mkShoppingBagPageCommon) {
		this.mkShoppingBagPageNA = mkShoppingBagPageNA;
		this.mkPageNavigator = mkPageNavigator;
		this.mkShoppingBagPageCommon = mkShoppingBagPageCommon;
	}

	@And("SBP: I can verify quantity updated message")
	public void sbpICanVerifyQuantityUpdatedMessage() {
		Assert.assertTrue("Quantity update message not shown", mkShoppingBagPageNA.verifyItemUpdatedMessage());
	}

	@And("SBP: I can verify the number of quantity is {int}")
	public void sbpICanVerifyTheNumberOfQuantityIs(Integer quantity) {
		Assert.assertEquals("Item quantity incorrect", quantity, mkShoppingBagPageNA.getSelectedQuantity());
	}

	@And("SBP: I can see a Shopping Bag total quantity of {int}")
	public void sbpICanSeeAShoppingBagTotalQuantityOf(int expectedQty) {
		if(mkPageNavigator.onShoppingBagPage()){
			int actualProductCount = mkShoppingBagPageNA.getTotalShoppingBagCount();
			Assert.assertEquals("Expected total quantity of items in the bag wrong", expectedQty,
					actualProductCount);
		}
	}
	
	@And("SBP: I apply promo code {string}")
	public void iApplyPromoCode(String promo) {
		mkShoppingBagPageNA.clickOnPromoCodeLink();
		mkShoppingBagPageNA.enterPromoCode(promo);
		mkShoppingBagPageNA.clickOnApplyPromo();
	}
	
	@And("SBP: I verified promo is applied succesfully") 
	   public void I_verified_promo_is_applied_succesfully() {
	   Assert.assertTrue("Expected Display Promotions Container",mkShoppingBagPageNA.PromoApplied());
	 }
	
	@And("SBP: I verify Employee discount amount for sale item {string}")
	 public void iVerifyEmployeeDiscountAmountForSaleItem(String product) {
   	 Assert.assertTrue("Employee discount not matched for sale item", mkShoppingBagPageNA.verifyAppliedSaleItemEMPCouponName(product));
	 }
    
    @And("SBP: I verify Employee discount amount for non sale item {string}")
	 public void iVerifyEmployeeDiscountAmountForNonSaleItem(String product) {
   	 Assert.assertTrue("Employee discount not matched for non sale item", mkShoppingBagPageNA.verifyAppliedNonSaleItemEMPCouponName(product));
	 }
	         
	@Then("I verify the {int} {string} promotion got applied")
	public void iVerifyAllThePromotionGotApplied(int amount, String promoType) {
		Assert.assertTrue("promotion not applied", mkShoppingBagPageNA.verifyPromoApplied(amount, promoType));
	}
    
    @Then("SBP: I verify max product limit for {string} in the quantity dropdown is {int} after applying Employee promo")
 	public void iVerifyMaxProductLimitInTheQuantityDropdownAfterApplyingEmployeePromo(String product, int qty) {
 		Assert.assertEquals("Expected quantity not macted", qty, mkShoppingBagPageCommon.verifyQuantityLimitAfterEmployeePromoApplied(product));
 	}
	
	@When("I apply a PromoCode on shopping bag page")
	public void iApplyPromoCodeOnShoppingBagPage() {
		mkShoppingBagPageNA.applyPromotion();
	}

	@Then("I verify Promotion is applied in shopping bag")
	public void iVerifyAllThePromotionGotAppliedSBP() {
		Assert.assertTrue("Promotion not applied", mkShoppingBagPageNA.verifyPromoApplied());
	}

	@Then("I verify All the promotion got applied")
	public void iVerifyAllThePromotionGotApplied() {
		Assert.assertTrue("5 promotion not applied", mkShoppingBagPageNA.verify5PromoApplied());
	}

	@Then("I verify Apply Promo Code section expanded")
	public void iVerifyApplyPromoCodeSectionExpanded() {
		Assert.assertTrue("Promo code section is expanded", mkShoppingBagPageNA.isPromoTextAndApplyButtonDisplayed());
	}
	
	@Then("SBP: I verify promotion got applied")
	public void iVerifyPromotionGotApplied() {
		Assert.assertTrue("Promotion not applied", mkShoppingBagPageNA.verifyPromoApplied());
	}
}