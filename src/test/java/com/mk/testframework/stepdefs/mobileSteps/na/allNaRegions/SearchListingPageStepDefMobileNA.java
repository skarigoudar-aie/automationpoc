package com.mk.testframework.stepdefs.mobileSteps.na.allNaRegions;

import org.junit.Assert;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.page.searchlisting.MkFilterResultsPanel_Common;
import com.mk.testframework.dt.page.searchlisting.MkFilterResultsPanel_NA;
import com.mk.testframework.dt.page.searchlisting.MkMobileFilterResultsPanel;
import com.mk.testframework.dt.page.searchlisting.MkProductListing;
import com.mk.testframework.dt.page.searchlisting.MkSearchListing;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class SearchListingPageStepDefMobileNA {
	private MkMobileFilterResultsPanel mkMobileFilterResultsPanel;
	private MkFilterResultsPanel_NA mkFilterResultsPanelNA;
	private MkFilterResultsPanel_Common mkFilterResultsPanel_common;
	private Context context;
	private MkProductListing mkProductListing;
	private MkSearchListing mkSearchListing;

	@Inject
	public SearchListingPageStepDefMobileNA(MkMobileFilterResultsPanel mkMobileFilterResultsPanel,
                                            MkFilterResultsPanel_NA mkFilterResultsPanelNA,
											MkFilterResultsPanel_Common mkFilterResultsPanel_common,
											Context context, MkProductListing mkProductListing, MkSearchListing mkSearchListing) {
		this.mkMobileFilterResultsPanel = mkMobileFilterResultsPanel;
		this.mkFilterResultsPanelNA = mkFilterResultsPanelNA;
		this.mkFilterResultsPanel_common = mkFilterResultsPanel_common;
		this.context = context;
		this.mkProductListing = mkProductListing;
		this.mkSearchListing = mkSearchListing;
	}

	@When("SLP: I select size filter {int}")
	public void plpISelectSizeFilter(int position) {
		mkMobileFilterResultsPanel.openFiltersIfClosed();
		mkFilterResultsPanel_common.openSizeFilterIfClosed();
		mkFilterResultsPanelNA.clickSizeFacetOption(position);
		mkMobileFilterResultsPanel.clickApplyFilterButton();
	}

	@When("SLP: I select color filter {int}")
	public void plpISelectColorFilter(int position) {
		mkMobileFilterResultsPanel.openFiltersIfClosed();
		mkFilterResultsPanel_common.clickColorFilterHeader();
		mkFilterResultsPanelNA.clickColorFacetOption(position);
		mkMobileFilterResultsPanel.clickApplyFilterButton();
	}
	
	@And("SLP: I select price filter {int}")
	public void plpISelectPriceFilter(int position) {
		mkMobileFilterResultsPanel.openFiltersIfClosed();
		mkFilterResultsPanel_common.clickPriceFilterHeader();
		mkFilterResultsPanelNA.clickPriceFacetOption(position);
		mkMobileFilterResultsPanel.clickApplyFilterButton();
	}
	
	@Then("SLP: I select Sort Option {string}")
	public void I_select_Sort_Option(String sOption) {
		mkFilterResultsPanel_common.SelectSortOption(sOption);
	}

	@Then("SLP: I Verify selected sort option displayed")
	public void I_Verify_selected_sort_option_displayed() {
		String expected = context.getSortOptions().toLowerCase();
		String actual = mkFilterResultsPanel_common.getsorttext().toLowerCase();
		Assert.assertTrue("Sort opiton is not dispalyed", expected.equalsIgnoreCase(actual));
	}

	@And("SLP: I verify Product displayed in High To Low order")
	public void iVerifyProductDisplayedInHighToLowOrder() {
		Assert.assertTrue("Products are not displayed", mkSearchListing.sortingHighToLow_NA());
	}

	@And("SLP: I verify Product displayed in Low To High order")
	public void iVerifyProductDisplayedInLowToHighOrder() {
		Assert.assertTrue("Products are not displayed", mkSearchListing.sortingLowToHighNA());
	}
}
