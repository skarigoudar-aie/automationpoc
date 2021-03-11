package com.mk.testframework.stepdefs.crossPlatformSteps.global;

import java.text.ParseException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.google.inject.Inject;
import com.mk.testframework.dt.page.searchlisting.MkProductListing;
import cucumber.api.java.en.And;

/**
 * 
 * @author Shiva
 *
 */
@SuppressWarnings("deprecation")
public class ProductListingPageStepDefGlobal {

	private MkProductListing mkProductListing;
	
	@Inject
	public ProductListingPageStepDefGlobal(WebDriver webDriver, MkProductListing mkProductListing) {
		this.mkProductListing = mkProductListing;
	}
	
	@And("PLP: I verify Color Swatches are clickable")
	public void i_verify_product_color_swatches_clickable_on_plp() {
		Assert.assertTrue("Product Price filters are not displayed",
				mkProductListing.isColorSwatchDisplayedOnPLPAndClickable());
	}

	@And("PLP: I verify clicking on Color Swatches changes product image")
	public void i_verify_product_image_changed_clicking_swatches_plp() {
		Assert.assertTrue("Product Price filters are not displayed",
				mkProductListing.isColorSwatchDisplayedOnPLPAndClickable());
	}

	@And("PLP: I verify product name and Price not changed after changing the color swatches")
	public void i_verify_product_name_price_not_changed_clicking_swatches_plp() {
		Assert.assertTrue("Product Price filters are not displayed", 
				mkProductListing.isPriceAndNameNotChangedOnPLP());
	}

	@And("PLP: I verify Product Price in the country currency")
	public void i_verify_product_price_displayed_for_all_products_on_plp() throws ParseException {
			Assert.assertTrue("Product price are not displayed",
					mkProductListing.priceFormatValidationForEU());
	}
}
