package com.mk.testframework.stepdefs.desktopSteps.allRegions;

import org.junit.Assert;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.page.searchlisting.MkProductListing;
import com.mk.testframework.dt.page.searchlisting.MkSearchListing;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * 
 * @author Shiva
 *
 */
@SuppressWarnings("deprecation")
public class SearchListingPageStepDef {
	private MkProductListing mkProductListing;
	private MkSearchListing mkSearchListing;
	private Environment env;

	private Context context;

	@Inject
	public SearchListingPageStepDef(MkProductListing mkProductListing, MkSearchListing mkSearchListing, Environment env, Context context) {
		this.mkProductListing = mkProductListing;
		this.mkSearchListing = mkSearchListing;
		this.env = env;
		this.context = context;
	}

	@Then("SLP: I select Sort Option {string}")
	public void I_select_Sort_Option(String sortoption) {
		mkProductListing.SelectSortOption(sortoption);
	}
	
	@Then("SLP: I Verify selected sort option displayed")
	public void I_Verify_selected_sort_option_displayed() {
		String expected = context.getSortOptions().toLowerCase();
		String actual = mkProductListing.getsorttext().toLowerCase();
		Assert.assertTrue("Sort opiton is not dispalyed", expected.equalsIgnoreCase(actual));
	}		

	@Then("SLP: I verify product total count matches with product displayed")
	public void i_verify_product_total_matches_products_on_plp() {
		Assert.assertTrue("Product counts are not matched", mkProductListing.isProductAndProductCountMatch());
	}
	
	@And("SLP: I verify Color Swatches when multiple colors are available")
	public void i_verify_product_color_swatches_displayed_on_plp() {
		Assert.assertTrue("Product Color Swatches are not displayed", mkSearchListing.isColorSwatchDisplayed());
	}
	
	@And("SLP: I verify Color Swatches are clickable")
	public void i_verify_product_color_swatches_clickable_on_plp() {
		if (env.getCountryRegion().toString().equals("NA")) {
			Assert.assertTrue("Color Swatches are not displayed",
					mkSearchListing.isColorSwatchDisplayedOnPLPAndClickable());
		} else {
			Assert.assertTrue("Color Swatches are not displayed",
					mkSearchListing.isColorSwatchDisplayedOnPLPAndClickable());
		}
	}
	
	@And("SLP: I verify clicking on Color Swatches changes product image")
	public void i_verify_product_image_changed_clicking_swatches_plp() {
			Assert.assertTrue("Image not displayed",
					mkSearchListing.isImageChangedClickingOnColorSwatch());
	}
	
	@And("SLP: I verify product name and Price not changed after changing the color swatches")
	public void i_verify_product_name_price_not_changed_clicking_swatches_plp() {
			Assert.assertTrue("Product name and Price are changed",
					mkSearchListing.isPriceAndNameNotChangedOnPLP());
	}
}
