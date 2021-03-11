package com.mk.testframework.stepdefs.desktopSteps.allRegions;

import org.junit.Assert;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.page.searchlisting.MkProductListing;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * @author RSingh
 *
 */
@SuppressWarnings("deprecation")
public class ProductListingPageStepDef {

	private MkProductListing mkProductListing;
	private Context context;

	@Inject
	public ProductListingPageStepDef(MkProductListing mkProductListing, Context context) {
		this.mkProductListing = mkProductListing;
		this.context = context;
	}

	@Then("PLP: I select Sort Option {string}")
	public void I_select_Sort_Option(String sortoption) {
		mkProductListing.SelectSortOption(sortoption);
	}

	@Then("PLP: I Verify selected sort option displayed")
	public void I_Verify_selected_sort_option_displayed() {
		String expected = context.getSortOptions().toLowerCase();
		String actual = mkProductListing.getsorttext().toLowerCase();
		Assert.assertTrue("Sort opiton is not dispalyed", expected.equalsIgnoreCase(actual));
	}

	@And("PLP: I verify Price Range Filters in the Country currency")
	public void i_verify_product_price_Range_filters_displayed_in_country_currency_on_plp() {
		Assert.assertTrue("Product Price filters are not displayed",
				mkProductListing.isPriceFilterCurrencyFormatProper());
	}

	@And("PLP: I verify product total count matches with product displayed")
	public void i_verify_product_total_matches_products_on_plp() {
		Assert.assertTrue("product total count not matched", mkProductListing.isProductAndProductCountMatch());
	}

	@And("PLP: I verify hero banner")
	public void plpIVerifyHeroBanner() {
		Assert.assertTrue("Hero banner not displayed", mkProductListing.isHeroBannerDisplayed());
	}
	
	@And("PLP: I verify the links displayed in the hero banner")
	public void plpIVerifyTheLinksDisplayedInTheHeroBanner() {
		Assert.assertTrue("Links not displayed in the hero banner", mkProductListing.isHeroBannerLinksDisplayed());
	}

  @And("PLP: I click on breadcrumb link and verify the breadcrumb link navigation")
	public void iClickOnBreadcrumbLinkAndVerifyNavigation()
	{
		Assert.assertTrue("Breadcrumb link not navigated to respective page", mkProductListing.verifyBreadCrumbNavigation());
	}
}
