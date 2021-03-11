package com.mk.testframework.stepdefs.crossPlatformSteps.na.allNaRegions;

import com.google.inject.Inject;
import com.mk.testframework.core.exceptions.TestException;
import com.mk.testframework.dt.header.MkHamburgerMenu;
import com.mk.testframework.dt.page.product.MkProductContainer;
import com.mk.testframework.dt.page.product.MkProductDetailPageEU;
import com.mk.testframework.dt.page.product.MkProductDetailPageNA;
import com.mk.testframework.dt.util.PageUtils;
import cucumber.api.java.en.And;

import java.text.ParseException;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Nagarjuna Polisetty
 *
 */
@SuppressWarnings("deprecation")
public class ProductDetailPageStepDefNA {
	private final Logger log = LoggerFactory.getLogger(getClass());
	private PageUtils pageUtils;
	private MkProductDetailPageNA mkProductDetailpageNA;
	private MkProductContainer mkProductContainer;

    @Inject
    public ProductDetailPageStepDefNA(MkProductDetailPageNA mkProductDetailpageNA, PageUtils pageUtils, MkProductContainer mkProductContainer) {
        this.mkProductDetailpageNA = mkProductDetailpageNA;
		this.pageUtils = pageUtils;
		this.mkProductContainer = mkProductContainer;
    }

    @And("PDP: I click on Join link in wishlist message section")
    public void iClickOnJoinLinkInWishlistMessageSection() {
        mkProductDetailpageNA.clickOnJoinLink();
    }
    
    @And("PDP: I click on Sign In link in wishlist message section")
    public void iClickOnSignInLinkInWishlistMessageSection() {
    	mkProductDetailpageNA.clickOnSignInLink();
    }
    
    @And("PDP : I navigate to the wishlist page")
	public void iNavigateToTheWishlistPage() {
    	mkProductDetailpageNA.clickOnWishlistLink();
	}

	@And("PDP: I verify Product Price in the country currency")
	public void i_verify_product_price_in_the_country_currency_on_pdp() throws ParseException {
			Assert.assertTrue("Product price are not displayed", mkProductContainer.priceFormatValidationNA());
		}
}
