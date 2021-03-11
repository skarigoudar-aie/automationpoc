package com.mk.testframework.stepdefs.crossPlatformSteps.eu;

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
public class ProductDetailPageStepDefEU {
	private final Logger log = LoggerFactory.getLogger(getClass());
	private PageUtils pageUtils;
	private MkProductDetailPageEU mkProductDetailpageEU;
	private MkProductContainer mkProductContainer;

    @Inject
    public ProductDetailPageStepDefEU(MkProductDetailPageEU mkProductDetailpageEU, PageUtils pageUtils, MkProductContainer mkProductContainer) {
        this.mkProductDetailpageEU = mkProductDetailpageEU;
		this.pageUtils = pageUtils;
		this.mkProductContainer = mkProductContainer;
    }

    @And("PDP: I click on Sign up link in favorites message section")
    public void iClickOnSignUpLinkInfavoritesMessageSection() {
        mkProductDetailpageEU.clickOnSignUpLink();
    }
    
    @And("PDP: I click on Sign In link in favorites message section")
    public void iClickOnSignInLinkInfavoritesMessageSection() {
    	mkProductDetailpageEU.clickOnSignInLink();
	}
		
	@And("PDP: I verify Product Price in the country currency")
	public void i_verify_product_price_in_the_country_currency_on_pdp() throws ParseException {
			Assert.assertTrue("Product price are not displayed", mkProductContainer.priceFormatValidationEU());
		}
}
