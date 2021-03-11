package com.mk.testframework.stepdefs.crossPlatformSteps.na.allNaRegions;

import java.text.ParseException;

import org.junit.Assert;

import com.google.inject.Inject;
import com.mk.testframework.dt.page.searchlisting.MkProductListing;

import cucumber.api.java.en.And;

@SuppressWarnings("deprecation")
public class SearchListingPageStepDefNA {
	private MkProductListing mkProductListing;
	
	@Inject
	public SearchListingPageStepDefNA(MkProductListing mkProductListing) {
		this.mkProductListing = mkProductListing;
	}
	
	@And("SLP: I verify Product Price in the country currency")
	public void i_verify_product_price_displayed_for_all_products_on_plp() throws ParseException {
			Assert.assertTrue("Product price are not displayed", mkProductListing.priceFormatValidationForNA());
		}
}

