package com.mk.testframework.stepdefs.crossPlatformSteps.na.ca;

import org.junit.Assert;

import com.google.inject.Inject;
import com.mk.testframework.dt.page.shoppingbag.MkShoppingBagPage_NA;
import cucumber.api.java.en.And;

/***
 * 
 * @author AIE
 *
 */
@SuppressWarnings("deprecation")
public class ShoppingBagPageStepDefCA {

	private MkShoppingBagPage_NA mkShoppingBagPageNA;

	@Inject
	public ShoppingBagPageStepDefCA(MkShoppingBagPage_NA mkShoppingBagPageNA) {
		this.mkShoppingBagPageNA = mkShoppingBagPageNA;

	}

	@And("SBP: I verify SubTotal and Total amount in Order summary detail")
	public void iVerifySubTotalAndTotalAmountInOrderSummaryDetail() {
		boolean flag = false;
		try {
			mkShoppingBagPageNA.selectShiipingMethod();
			double orderSummarySuTotal = mkShoppingBagPageNA.subTotalFromOrderSummary();
			System.out.println(orderSummarySuTotal+" SubTotal price ");
			double getOrderTotal1 = mkShoppingBagPageNA.getTotalFromOrderSummaryCA();
			System.out.println(getOrderTotal1 + "Total price");
			if (getOrderTotal1 == orderSummarySuTotal) {
				flag = true;
			}
		} catch (Exception e) {

		}
		Assert.assertTrue("Order Total and SubTotal not matched", flag);
	}
	@And("SBP: I verify Order Summary details after applying promotion")
	public void iVerifyOrderSummaryDetailsAfterApplyingPromotion()
	{
		boolean flag = false;
		try {
			double orderSummarySuTotal = mkShoppingBagPageNA.subTotalFromOrderSummary();
			double getPromotion1 = mkShoppingBagPageNA.getPromotionFromOrderSummary();
			double expectedTotalAmount = orderSummarySuTotal - getPromotion1;
			System.out.println("expected amount "+ expectedTotalAmount);
			double actTotalAmount = mkShoppingBagPageNA.getTotalFromOrderSummaryCA();
			System.out.println("actual amount " + actTotalAmount);
			if(expectedTotalAmount == actTotalAmount)
				flag = true;
		} catch (Exception e) {
			
		}
		Assert.assertTrue("Order Total and SubTotal amount not matched after applying Promotion", flag);
	}
}