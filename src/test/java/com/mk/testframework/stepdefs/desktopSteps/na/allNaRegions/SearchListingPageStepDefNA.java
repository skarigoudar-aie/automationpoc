package com.mk.testframework.stepdefs.desktopSteps.na.allNaRegions;

import org.junit.Assert;

import com.google.inject.Inject;
import com.mk.testframework.dt.page.searchlisting.MkFilterResultsPanel_Common;
import com.mk.testframework.dt.page.searchlisting.MkFilterResultsPanel_EuGlobal;
import com.mk.testframework.dt.page.searchlisting.MkFilterResultsPanel_NA;

import com.mk.testframework.dt.page.searchlisting.MkProductListing;
import com.mk.testframework.dt.page.searchlisting.MkSearchListing;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class SearchListingPageStepDefNA {
	private MkFilterResultsPanel_Common mkFilterResultsPanel_common;
	private MkFilterResultsPanel_EuGlobal mkFilterResultsPanel_euGlobal;
	private MkProductListing mkProductListing;
	private MkSearchListing mkSearchListing;

	@Inject
	public SearchListingPageStepDefNA(MkFilterResultsPanel_Common mkFilterResultsPanel_common,
									  MkFilterResultsPanel_EuGlobal mkFilterResultsPanel_euGlobal, MkProductListing mkProductListing, MkSearchListing mkSearchListing) {
		this.mkFilterResultsPanel_common = mkFilterResultsPanel_common;
		this.mkFilterResultsPanel_euGlobal = mkFilterResultsPanel_euGlobal;
		this.mkProductListing = mkProductListing;
		this.mkSearchListing = mkSearchListing;
	}

	@When("SLP: I select size filter {int}")
	public void plpISelectSizeFilter(int position) {
		mkFilterResultsPanel_common.openSizeFilterIfClosed();
		mkFilterResultsPanel_euGlobal.clickSizeFacetOption(position);
	}

	@When("SLP: I select color filter {int}")
	public void plpISelectColorFilter(int position) {
		mkFilterResultsPanel_common.openColorFilterIfClosed();
		mkFilterResultsPanel_euGlobal.clickColorFacetOption(position);
	}
	
	@And("SLP: I select price filter {int}")
	public void plpISelectPriceFilter(int position) {
		mkFilterResultsPanel_common.openPriceFilterIfClosed();
		mkFilterResultsPanel_euGlobal.clickPriceFacetOption(position);
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
