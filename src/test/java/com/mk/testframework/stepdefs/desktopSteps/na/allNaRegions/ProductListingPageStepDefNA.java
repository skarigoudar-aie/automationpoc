package com.mk.testframework.stepdefs.desktopSteps.na.allNaRegions;

import org.junit.Assert;

import com.google.inject.Inject;
import com.mk.testframework.dt.page.searchlisting.MkFilterResultsPanel_Common;
import com.mk.testframework.dt.page.searchlisting.MkFilterResultsPanel_EuGlobal;
import com.mk.testframework.dt.page.searchlisting.MkProductListing;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import com.mk.testframework.dt.page.searchlisting.MkFilterResultsPanel_NA;
import com.mk.testframework.dt.page.searchlisting.MkProductListing;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class ProductListingPageStepDefNA {
	private MkFilterResultsPanel_Common mkFilterResultsPanel_common;
	private MkFilterResultsPanel_EuGlobal mkFilterResultsPanel_euGlobal;
	private MkProductListing mkProductListing;
	private MkFilterResultsPanel_NA mkFilterResultsPanelNA;

	@Inject
	public ProductListingPageStepDefNA(MkFilterResultsPanel_NA mkFilterResultsPanelNA,
									   MkFilterResultsPanel_Common mkFilterResultsPanel_common,
									   MkFilterResultsPanel_EuGlobal mkFilterResultsPanel_euGlobal, 
									   MkProductListing mkProductListing) {
		this.mkFilterResultsPanelNA = mkFilterResultsPanelNA;
		this.mkFilterResultsPanel_common = mkFilterResultsPanel_common;
		this.mkFilterResultsPanel_euGlobal = mkFilterResultsPanel_euGlobal;
		this.mkProductListing = mkProductListing;
	}

	@When("PLP: I select size filter {int}")
	public void plpISelectSizeFilter(int position) {
		mkFilterResultsPanel_common.openSizeFilterIfClosed();
		mkFilterResultsPanel_euGlobal.clickSizeFacetOption(position);
	}

	@When("PLP: I select color filter {int}")
	public void plpISelectColorFilter(int position) {
		mkFilterResultsPanel_common.openColorFilterIfClosed();
		mkFilterResultsPanel_euGlobal.clickColorFacetOption(position);
	}
	
	@And("PLP: I select price filter {int}")
	public void plpISelectPriceFilter(int position) {
		mkFilterResultsPanel_common.openPriceFilterIfClosed();
		mkFilterResultsPanel_euGlobal.clickPriceFacetOption(position);
	}
	
	@Then("PLP: I verify products displayed are in the applied price range")
	public void i_verify_products_are_in_applied_price_filter_range() {
			Assert.assertTrue("products displayed are not in the applied price range", mkProductListing.iVerifyProductsAreInSelectedPriceRangeNA());
	}
	
	@And("PLP: I verify Product displayed in High To Low order")
	public void iVerifyProductDisplayedInHighToLowOrder() {
		Assert.assertTrue("Products are not displayed", mkProductListing.sortingHighToLow_NA());
	}

	@And("PLP: I verify Product displayed in Low To High order")
	public void iVerifyProductDisplayedInLowToHighOrder() {
		Assert.assertTrue("Products are not displayed", mkProductListing.sortingLowToHighNA());
	}

}
