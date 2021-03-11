
package com.mk.testframework.stepdefs.crossPlatformSteps.na.ca;

import com.google.inject.Inject;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_CA;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.exceptions.TestEnvironmentException;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

/**
 * @author Raja
 *
 */
@SuppressWarnings("deprecation")
public class MyAccountPageStepDefCA {

	private final Logger log = LoggerFactory.getLogger(getClass());
	private MkMyAccountPage_CA mkMyAccountPageCA;
	private TestData testData;
	
	
	
	@Inject
	public MyAccountPageStepDefCA(MkMyAccountPage_CA mkMyAccountPageCA,TestData testData) {
		this.mkMyAccountPageCA = mkMyAccountPageCA;
		this.testData = testData;
	
	}

	@When("Profile : I click on address book link")
	public void i_click_address_book_link() {

		try {
			mkMyAccountPageCA.clickAddressBook();
		} catch (TestEnvironmentException e) {
			log.debug("Trying Address book link second time");
			mkMyAccountPageCA.clickAddressBook();
		}

	}

	@And("Profile: I click on Payment Information link")
	public void iClickOnPaymentInformationlink() {
		mkMyAccountPageCA.clickOnPaymentInformationLink();
	}
	
	@And("Order Details: I verify gst or hst is displayed and amount is same as Order Confirmation Page")
	public void i_verify_gst_details_displayed() {
		Assert.assertTrue("GST tax is not present", mkMyAccountPageCA.isGST_HSTDisplayed());
		Assert.assertTrue("GST tax Value is not matched with Order Confirmation Page", mkMyAccountPageCA.verifyGstHstAmount());
	}
	
	@When("Profile: I click on Order History link")
	public void iClickOnOrderHistorynlink() {
		try {
			mkMyAccountPageCA.clickOnOrderHistoryLink();
		} catch (TestEnvironmentException e) {
			log.debug("Trying Address book link second time");
			mkMyAccountPageCA.clickOnOrderHistoryLink();
		}

	}

	@When("Profile: I click on Favorites Link")
	public void iClickOnFavoriteslink() {
		try {
			mkMyAccountPageCA.clickOnWishListLink();
		} catch (TestEnvironmentException e) {
			log.debug("Trying Address book link second time");
			mkMyAccountPageCA.clickOnWishListLink();
		}

	}

	@And("Order Details: I verify pst or qst is displayed and amount is same as Order Confirmation Page")
	public void i_verify_pst_details_displayed() {
		Assert.assertTrue("PST tax is not present", mkMyAccountPageCA.isPst_qstDisplayed());
		Assert.assertTrue("PST tax Value is not matched with Order Confirmation Page", mkMyAccountPageCA.verifyPstQstAmount());
	}

}
