package com.mk.testframework.stepdefs.desktopSteps.eu;

import org.junit.Assert;

import com.google.inject.Inject;
import com.mk.testframework.dt.page.searchlisting.MkFilterResultsPanel_Common;
import com.mk.testframework.dt.page.searchlisting.MkFilterResultsPanel_EuGlobal;
import com.mk.testframework.dt.page.searchlisting.MkProductListing;

import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class ProductListingPageStepDefEU {

	private MkFilterResultsPanel_EuGlobal mkFilterResultsPanelEU;
	private MkFilterResultsPanel_Common mkFilterResultsPanel_common;
	private MkProductListing mkProductListing;

	@Inject
	public ProductListingPageStepDefEU(MkFilterResultsPanel_EuGlobal mkFilterResultsPanelEU,
									   MkFilterResultsPanel_Common mkFilterResultsPanel_common, MkProductListing mkProductListing) {
		this.mkFilterResultsPanelEU = mkFilterResultsPanelEU;
		this.mkFilterResultsPanel_common = mkFilterResultsPanel_common;
		this.mkProductListing = mkProductListing;
	}

	@When("PLP: I select size filter {int}")
	public void plpISelectSizeFilter(int position) {
		mkFilterResultsPanel_common.openSizeFilterIfClosed();
		mkFilterResultsPanelEU.clickSizeFacetOption(position);
	}

	@When("PLP: I select color filter {int}")
	public void plpISelectColorFilter(int position) {
		mkFilterResultsPanel_common.openColorFilterIfClosed();
		mkFilterResultsPanelEU.clickColorFacetOption(position);
	}
	
	@Then("I verify the refinement clicked last size by index {int} by the shopper appear at the end of the list.")
	public void isLastSelectedFilterDisplayedAtEnd(int size) {
		mkFilterResultsPanelEU.checkSelectedFacet(size);
	}
	
	@And("PLP: I select price filter {int}")
	public void plpISelectPriceFilter(int position) {
		mkFilterResultsPanel_common.openPriceFilterIfClosed();
		mkFilterResultsPanelEU.clickPriceFacetOption(position);
	}
	
	@Then("PLP: I verify products displayed are in the applied price range")
	public void i_verify_products_are_in_applied_price_filter_range() {
			Assert.assertTrue("products displayed are not in the applied price range", mkProductListing.iVerifyProductsAreInSelectedPriceRangeEU());
	}
	
	@And("PLP: I verify Product displayed in High To Low order")
	public void iVerifyProductDisplayedInHighToLowOrder() {
		Assert.assertTrue("Products are not displayed", mkProductListing.sortingHighToLow_EU());
	}

	@And("PLP: I verify Product displayed in Low To High order")
	public void iVerifyProductDisplayedInLowToHighOrder() {
		Assert.assertTrue("Products are not displayed", mkProductListing.sortingLowToHighEU());
	}
}
