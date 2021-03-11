
package com.mk.testframework.stepdefs.crossPlatformSteps.na.us;

import com.google.inject.Inject;
import com.mk.testframework.dt.page.myaccount.MkMyAccountPage_US;
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
public class MyAccountPageStepDefUS {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	private MkMyAccountPage_US mkMyAccountPageUS;
	private TestData testData;
	
	
	@Inject
	public MyAccountPageStepDefUS( MkMyAccountPage_US mkMyAccountPageUS,TestData testData) {
		this.mkMyAccountPageUS = mkMyAccountPageUS;
		this.testData = testData;
	}
		
	
	@When("Profile : I click on address book link")
	public void i_click_address_book_link() {

		try {
			mkMyAccountPageUS.clickAddressBookUS();
		} catch (TestEnvironmentException e) {
			log.debug("Trying Address book link second time");
			mkMyAccountPageUS.clickAddressBookUS();
		}

	}

	@And("Profile: I click on Payment Information link")
	public void iClickOnPaymentInformationlink() {
		mkMyAccountPageUS.clickOnPaymentInformationLink();
	}

	@When("Profile: I click on Order History link")
	public void iClickOnOrderHistorynlink() {
		try {
			mkMyAccountPageUS.clickOnOrderHistoryLink();
		} catch (TestEnvironmentException e) {
			log.debug("Trying Address book link second time");
			mkMyAccountPageUS.clickOnOrderHistoryLink();
		}

	}

	@When("Profile: I click on Favorites Link")
	public void iClickOnFavoriteslink() {
		try {
			mkMyAccountPageUS.clickOnWishListLink();
		} catch (TestEnvironmentException e) {
			log.debug("Trying Address book link second time");
			mkMyAccountPageUS.clickOnWishListLink();
		}

	}

}

