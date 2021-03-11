package com.mk.testframework.stepdefs.desktopSteps.eu;

import org.junit.Assert;

import com.google.inject.Inject;
import com.mk.testframework.dt.page.searchlisting.MkFilterResultsPanel_Common;
import com.mk.testframework.dt.page.searchlisting.MkFilterResultsPanel_EuGlobal;
import com.mk.testframework.dt.page.searchlisting.MkProductListing;
import com.mk.testframework.dt.page.searchlisting.MkSearchListing;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class SearchListingPageStepDefEU {

	private MkFilterResultsPanel_EuGlobal mkFilterResultsPanelEU;
	private MkFilterResultsPanel_Common mkFilterResultsPanel_common;
	private MkProductListing mkProductListing;
	private MkSearchListing mkSearchListing;

	@Inject
	public SearchListingPageStepDefEU(MkFilterResultsPanel_EuGlobal mkFilterResultsPanelEU,
									  MkFilterResultsPanel_Common mkFilterResultsPanel_common, MkProductListing mkProductListing, MkSearchListing mkSearchListing) {
		this.mkFilterResultsPanelEU = mkFilterResultsPanelEU;
		this.mkFilterResultsPanel_common = mkFilterResultsPanel_common;
		this.mkProductListing = mkProductListing;
		this.mkSearchListing = mkSearchListing;
	}

	@When("SLP: I select size filter {int}")
	public void plpISelectSizeFilter(int position) {
		mkFilterResultsPanel_common.openSizeFilterIfClosed();
		mkFilterResultsPanelEU.clickSizeFacetOption(position);
	}

	@When("SLP: I select color filter {int}")
	public void plpISelectColorFilter(int position) {
		mkFilterResultsPanel_common.openColorFilterIfClosed();
		mkFilterResultsPanelEU.clickColorFacetOption(position);
	}
	
	@And("SLP: I select price filter {int}")
	public void plpISelectPriceFilter(int position) {
		mkFilterResultsPanel_common.openPriceFilterIfClosed();
		mkFilterResultsPanelEU.clickPriceFacetOption(position);
	}
	
	@And("SLP: I verify Product displayed in High To Low order")
	public void iVerifyProductDisplayedInHighToLowOrder() {
		Assert.assertTrue("Products are not displayed", mkSearchListing.sortingHighToLow_EU());
	}

	@And("SLP: I verify Product displayed in Low To High order")
	public void iVerifyProductDisplayedInLowToHighOrder() {
		Assert.assertTrue("Products are not displayed", mkSearchListing.sortingLowToHighEU());
	}
}
