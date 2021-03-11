package com.mk.testframework.stepdefs.crossPlatformSteps.global;

import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.dt.page.home.MkStoreLocatorPage_EuGlobal;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * @author RSingh
 *
 */
@SuppressWarnings("deprecation")
public class StoreLocatorPageStepDefGlobal {

	private MkStoreLocatorPage_EuGlobal mkStoreLocatorPageEuGlobal;
	private TestData testData;

	@Inject
	public StoreLocatorPageStepDefGlobal(MkStoreLocatorPage_EuGlobal mkStoreLocatorPageEuGlobal, TestData testData) {
		this.mkStoreLocatorPageEuGlobal = mkStoreLocatorPageEuGlobal;
		this.testData = testData;
	}

	@When("STORE LOCATOR: I enter postcode")
	public void I_enter_postcode() {
		mkStoreLocatorPageEuGlobal.enterPostcode(testData.getUser().address.getPostalCode());
	}

	@When("STORE LOCATOR: I enter city")
	public void I_enter_city() {
		mkStoreLocatorPageEuGlobal.enterCity(testData.getUser().address.getCity());
	}

	@When("STORE LOCATOR: I enter state or region")
	public void storeLOCATORIEnterStateOrRegion() {
		mkStoreLocatorPageEuGlobal.enterStateOrRegion(testData.getUser().address.province);
	}

	@And("STORE LOCATOR: I click on search button")
	public void I_click_on_search_button() {
		mkStoreLocatorPageEuGlobal.clickOnSearchButton();
	}

	@And("STORE LOCATOR: I verify there are at least 1 store displayed")
	public void I_verify_there_are_at_least_1_store_displayed() {
		Assert.assertTrue(mkStoreLocatorPageEuGlobal.getResultCount() >= 1);
	}

	@And("STORE LOCATOR: I verify map is displaying")
	public void I_verify_map_is_displaying() {
		Assert.assertTrue(mkStoreLocatorPageEuGlobal.isMapImageDisplaying());
	}

	@When("STORE LOCATOR: I input all required fields")
	public void storeLOCATORIInputAllRequiredFields() {
		try{
			I_enter_postcode();
		}
		catch(Exception e){
			I_enter_city();
		}
	}

	@And("I am on store locator page")
	public void I_am_on_store_locator_page() {
		Assert.assertTrue("Store Locator page missing", mkStoreLocatorPageEuGlobal.onStoreLocatorPage());
	}

}