package com.mk.testframework.stepdefs.mobileSteps.global;

import org.junit.Assert;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.mobile.MkMobileProductListing;
import com.mk.testframework.dt.page.searchlisting.MkFilterResultsPanel_Common;
import com.mk.testframework.dt.page.searchlisting.MkFilterResultsPanel_EuGlobal;
import com.mk.testframework.dt.page.searchlisting.MkMobileFilterResultsPanel;
import com.mk.testframework.dt.page.searchlisting.MkProductListing;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class ProductListingPageStepMobileGlobal {
	private MkMobileFilterResultsPanel mkMobileFilterResultsPanel;
	private MkFilterResultsPanel_EuGlobal mkFilterResultsPanelEU;
	private MkFilterResultsPanel_Common mkFilterResultsPanel_common;
	private MkProductListing mkProductListing;
	private Context context;
	private MkMobileProductListing mkMobileProductListing;

	@Inject
	public ProductListingPageStepMobileGlobal(MkMobileFilterResultsPanel mkMobileFilterResultsPanel,
											  MkFilterResultsPanel_EuGlobal mkFilterResultsPanelEU,
											  MkFilterResultsPanel_Common mkFilterResultsPanel_common, MkProductListing mkProductListing, Context context, MkMobileProductListing mkMobileProductListing) {
		this.mkMobileFilterResultsPanel = mkMobileFilterResultsPanel;
		this.mkFilterResultsPanelEU = mkFilterResultsPanelEU;
		this.mkFilterResultsPanel_common = mkFilterResultsPanel_common;
		this.mkProductListing = mkProductListing;
		this.context = context;
		this.mkMobileProductListing = mkMobileProductListing;
	}

	@When("PLP: I select size filter {int}")
	public void plpISelectSizeFilter(int position) {
		mkMobileFilterResultsPanel.openFiltersIfClosed();
		mkFilterResultsPanel_common.openSizeFilterIfClosed();
		mkFilterResultsPanelEU.clickSizeFacetOption(position);
		mkMobileFilterResultsPanel.clickApplyFilterButton();
	}

	@When("PLP: I select color filter {int}")
	public void plpISelectColorFilter(int position) {
		mkMobileFilterResultsPanel.openFiltersIfClosed();
		mkFilterResultsPanel_common.openColorFilterIfClosed();
		mkFilterResultsPanelEU.clickColorFacetOption(position);
		mkMobileFilterResultsPanel.clickApplyFilterButton();
	}
	
	@When("PLP: I select price filter {int}")
	public void plpISelectPriceFilter(int position) {
		mkMobileFilterResultsPanel.openFiltersIfClosed();
		mkFilterResultsPanel_common.clickPriceFilterHeader();
		mkFilterResultsPanelEU.clickPriceFacetOption(position);
		mkMobileFilterResultsPanel.clickApplyFilterButton();
	}
	
	@Then("PLP: I verify products displayed are in the applied price range")
	public void i_verify_products_are_in_applied_price_filter_range() {
			Assert.assertTrue("Product names are not displayed", mkProductListing.iVerifyProductsAreInSelectedPriceRangeEU());
	}
	
	@Then("PLP: I select Sort Option {string}")
	public void I_select_Sort_Option(String sOption) {
		mkFilterResultsPanel_common.SelectSortOption(sOption);
	}

	@Then("PLP: I Verify selected sort option displayed")
	public void I_Verify_selected_sort_option_displayed() {
		String expected = context.getSortOptions().toLowerCase();
		String actual = mkFilterResultsPanel_common.getsorttext().toLowerCase();
		Assert.assertTrue("Sort opiton is not dispalyed", expected.equalsIgnoreCase(actual));
	}

	@And("PLP: I verify Product displayed in High To Low order")
	public void iVerifyProductDisplayedInHighToLowOrder() {
		Assert.assertTrue("Products are not displayed", mkMobileProductListing.sortingHighToLow_EU());
	}

	@And("PLP: I verify Product displayed in Low To High order")
	public void iVerifyProductDisplayedInLowToHighOrder() {
		Assert.assertTrue("Products are not displayed", mkMobileProductListing.sortingLowToHighEU());
	}
}
