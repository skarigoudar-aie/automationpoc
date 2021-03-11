package com.mk.testframework.stepdefs.crossPlatformSteps.na.allNaRegions;

import com.google.inject.Inject;
import com.mk.testframework.dt.page.product.MkGiftCardsProduct;

import cucumber.api.java.en.And;

@SuppressWarnings("deprecation")
public class vgcPgcStepDefNA {
	
	private MkGiftCardsProduct mkGiftCardsProduct;

    @Inject
    public vgcPgcStepDefNA(MkGiftCardsProduct mkGiftCardsProduct) {
        this.mkGiftCardsProduct = mkGiftCardsProduct;
    }

    @And("I select Gift card amount as {string}")
	public void iSelectGiftCardAmount(String giftCardAmount) {
		mkGiftCardsProduct.selectVgcAndPgcAmount(giftCardAmount);
	}

	@And("I select {string} Gift Card")
	public void iSelectGiftCard(String text) {
		mkGiftCardsProduct.addGiftCard_NA(text);
	}

}
