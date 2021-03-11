package com.mk.testframework.stepdefs.crossPlatformSteps.na.us;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.dt.page.home.MkStoreLocatorPage_US;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * @author RSingh
 *
 */
@SuppressWarnings("deprecation")
public class StoreLocatorPageStepDefUS {

	private MkStoreLocatorPage_US mkStoreLocatorPageUS;
	private TestData testData;

	@Inject
	public StoreLocatorPageStepDefUS(MkStoreLocatorPage_US mkStoreLocatorPageUS, TestData testData) {
		this.mkStoreLocatorPageUS = mkStoreLocatorPageUS;
		this.testData = testData;
	}

	@When("STORE LOCATOR: I enter postcode")
	public void I_enter_postcode() {
		mkStoreLocatorPageUS.enterPostcode(testData.getUser().address.getPostalCode());
	}

	@When("STORE LOCATOR: I enter state or region")
	public void storeLOCATORIEnterStateOrRegion() {
		mkStoreLocatorPageUS.enterStateOrRegion(testData.getUser().address.state);
	}

	@When("STORE LOCATOR: I enter city")
	public void I_enter_city() {
		mkStoreLocatorPageUS.enterCity(testData.getUser().address.getCity());
	}

	@And("STORE LOCATOR: I click on search button")
	public void I_click_on_search_button() {
		mkStoreLocatorPageUS.clickOnSearchButton();
	}

	@And("STORE LOCATOR: I verify there are at least 1 store displayed")
	public void I_verify_there_are_at_least_1_store_displayed() {
		Assert.assertTrue(mkStoreLocatorPageUS.getResultCount() >= 1);
	}

	@And("STORE LOCATOR: I verify map is displaying")
	public void I_verify_map_is_displaying() {
		Assert.assertTrue(mkStoreLocatorPageUS.isMapImageDisplaying());
	}

	@When("STORE LOCATOR: I input all required fields")
	public void storeLOCATORIInputAllRequiredFields() {
		I_enter_postcode();
	}

	@And("I am on store locator page")
	public void I_am_on_store_locator_page() {
		Assert.assertTrue("Store Locator page missing", mkStoreLocatorPageUS.onStoreLocatorPage());
	}
}
