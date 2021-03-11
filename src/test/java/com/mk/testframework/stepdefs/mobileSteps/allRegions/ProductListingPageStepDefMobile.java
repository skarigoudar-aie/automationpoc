package com.mk.testframework.stepdefs.mobileSteps.allRegions;

import org.junit.Assert;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.mobile.MkMobileProductListing;
import com.mk.testframework.dt.page.searchlisting.MkProductListing;
import com.mk.testframework.dt.page.searchlisting.MkMobileFilterResultsPanel;
import cucumber.api.java.en.And;


/**
 * @author Nagarjuna Polisetty
 *
 */
@SuppressWarnings("deprecation")
public class ProductListingPageStepDefMobile {

	private MkMobileProductListing mkMobileProductListing;
	private Context context;
	private MkMobileFilterResultsPanel mkMobileFilterResultsPanel;


	@Inject
	public ProductListingPageStepDefMobile(MkProductListing mkProductListing, Context context,
			MkMobileProductListing mkMobileProductListing, MkMobileFilterResultsPanel mkMobileFilterResultsPanel) {
		this.mkMobileProductListing = mkMobileProductListing;
		this.context = context;
		this.mkMobileFilterResultsPanel = mkMobileFilterResultsPanel;

	}

	@And("PLP: I verify hero banner")
	public void plpIVerifyHeroBanner() {
		Assert.assertTrue("Hero banner not displayed", mkMobileProductListing.isHeroBannerDisplayed());
	}

	@And("PLP: I verify the links displayed in the hero banner")
	public void plpIVerifyTheLinksDisplayedInTheHeroBanner() {
		Assert.assertTrue("Links not displayed in the hero banner", mkMobileProductListing.isHeroBannerLinksDisplayed());
	}

	@And("PLP: I verify Price Range Filters in the Country currency")
	public void i_verify_product_price_Range_filters_displayed_in_country_currency_on_plp() {
		Assert.assertTrue("Product Price filters are not displayed",
				mkMobileFilterResultsPanel.isPriceFilterCurrencyFormatProper());
	}
	
	
	@And("PLP: I verify product total count matches with product displayed")
	public void i_verify_product_total_matches_products_on_plp() {
		Assert.assertTrue("Product total count not matched", mkMobileFilterResultsPanel.isProductAndProductCountMatch());
	}	

}
