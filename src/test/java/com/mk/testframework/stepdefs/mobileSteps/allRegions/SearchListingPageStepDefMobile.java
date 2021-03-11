package com.mk.testframework.stepdefs.mobileSteps.allRegions;

import org.junit.Assert;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.mobile.MkMobileSearchListing;
import com.mk.testframework.dt.page.searchlisting.MkMobileFilterResultsPanel;

import cucumber.api.java.en.And;

/**
 * 
 * @author Shiva
 *
 */

@SuppressWarnings("deprecation")
public class SearchListingPageStepDefMobile {

	private MkMobileFilterResultsPanel mkMobileFilterResultsPanel;
	private MkMobileSearchListing mkMobileSearchListing;
	private Environment env;

	@Inject
	public SearchListingPageStepDefMobile(MkMobileFilterResultsPanel mkMobileFilterResultsPanel, MkMobileSearchListing mkMobileSearchListing, Environment env) {
		this.mkMobileFilterResultsPanel = mkMobileFilterResultsPanel;
		this.mkMobileSearchListing = mkMobileSearchListing;
		this.env = env;
	}
	
	@And("SLP: I verify product total count matches with product displayed")
	public void i_verify_product_total_matches_products_on_plp() {
		Assert.assertTrue("Product counts are not matched", mkMobileFilterResultsPanel.isProductAndProductCountMatch());
	}
	
	@And("SLP: I verify Color Swatches when multiple colors are available")
	public void i_verify_product_color_swatches_displayed_on_plp() {
		Assert.assertTrue("Product Color Swatches are not displayed", mkMobileSearchListing.isColorSwatchDisplayed());
	}
	
	@And("SLP: I verify Color Swatches are clickable")
	public void i_verify_product_color_swatches_clickable_on_plp() {
		if (env.getCountryRegion().toString().equals("NA")) {
			Assert.assertTrue("Color Swatches are not displayed",
					mkMobileSearchListing.isColorSwatchDisplayedOnPLPAndClickable());
		} else {
			Assert.assertTrue("Color Swatches are not displayed",
					mkMobileSearchListing.isColorSwatchDisplayedOnPLPAndClickable());
		}
	}
	
	@And("SLP: I verify clicking on Color Swatches changes product image")
	public void i_verify_product_image_changed_clicking_swatches_plp() {
			Assert.assertTrue("Image not displayed",
					mkMobileSearchListing.isImageChangedClickingOnColorSwatch());
	}
	
	@And("SLP: I verify product name and Price not changed after changing the color swatches")
	public void i_verify_product_name_price_not_changed_clicking_swatches_plp() {
			Assert.assertTrue("Product name and Price are changed",
					mkMobileSearchListing.isPriceAndNameNotChangedOnPLP());
	}
}

