package com.mk.testframework.core.env;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import com.google.common.collect.Maps;
import com.google.inject.Inject;

import cucumber.runtime.java.guice.ScenarioScoped;
import io.cucumber.core.api.Scenario;

/**
 * @author VThipperudrappa
 * 
 */
@ScenarioScoped
public class Context {
	private static final String BUILD_LOGS = "build/logs";
	private final Logger log = LoggerFactory.getLogger(getClass());
	private Scenario scenario;
	private Map<String, String> data = Maps.newHashMap();
	private static boolean popUpDismissed;
	private int listingPageProductCount;
	private String pdpProductName;
	private String sortOptions;
	private int lookProductCount;
	private String sbpProductName;
	private static boolean orderFilesZipped;
	private static boolean changeCountryPopUpDismissed;
	private static boolean stayInTouchPopUpDismissed;
	private static boolean cookieBannerAccepted;

	@Inject
	WebDriver webDriver;

	/**
	 * writes to cucumber report
	 */
	public void writeOut(final String s) {
		log.debug(s);
		this.scenario.write(s);
	}

	public void initilizeLogFile(Scenario scenario) {
		this.scenario = scenario;
		final String dateStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		final String pid = java.lang.management.ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
		final String logFileName = BUILD_LOGS + File.separator + getScenarioName() + "-" + dateStamp + "-P" + pid;
		MDC.put("logFileName", logFileName);
	}

	private String getScenarioName() {
		final String scenarioId = this.scenario.getId();

		// split and pick the last element of either path delimeter
		String featureId = lastOf(scenarioId.split("/"));
		featureId = lastOf(featureId.split("\\\\"));
		// remove extension and colon symbol:
		featureId = featureId.replace(".feature:", "-");

		return featureId + "__" + this.scenario.getName().replaceAll("\\s|;|\\.|\\:,", "_").toLowerCase().trim();
	}

	private String lastOf(String[] arr) {
		return arr[arr.length - 1];
	}

	public void embedScreenshots() {
		TakesScreenshot scrShot = ((TakesScreenshot) webDriver);
		this.scenario.embed(scrShot.getScreenshotAs(OutputType.BYTES), "image/png");
	}

	public void saveData(String key, String value) {
		data.put(key, value);
	}

	public String getSavedData(String key) {
		return data.get(key);
	}

	public boolean getpopUpDismissedStatus() {
		return popUpDismissed;
	}

	public void setpopUpDismissedStatus(boolean dismissalStatus) {
		popUpDismissed = dismissalStatus;
	}

	public boolean getCookieBannerAcceptedStatus() {
		return cookieBannerAccepted;
	}

	public void setcookieBannerAcceptedStatus(boolean cookieBannerAcceptedStatus) {
		cookieBannerAccepted = cookieBannerAcceptedStatus;
	}

	public boolean getStayInTouchPopUpDismissedStatus() {
		return stayInTouchPopUpDismissed;
	}

	public void setStayInTouchPopUpDismissedStatus(boolean stayInTouchPopUpDismissedDismissalStatus) {
		stayInTouchPopUpDismissed = stayInTouchPopUpDismissedDismissalStatus;
	}

	public boolean getOrderZipStatus() {
		return orderFilesZipped;
	}

	public void setOrderZipStatus(boolean orderFilesZippedStatus) {
		orderFilesZipped = orderFilesZippedStatus;
	}

	public boolean getChangeCountryPopUpDismissedStatus() {
		return changeCountryPopUpDismissed;
	}

	public void setChangeCountryPopUpDismissedStatus(boolean changeCountryPopUpDismissedStatus) {
		changeCountryPopUpDismissed = changeCountryPopUpDismissedStatus;
	}

	public int getListingPageProductCount() {
		return this.listingPageProductCount;
	}

	public void setListingPageProductCount(int productCount) {
		this.listingPageProductCount = productCount;
	}

	public String getPdpProductName() {
		return pdpProductName;
	}

	public void setPdpProductName(String pdpProductName) {
		this.pdpProductName = pdpProductName;
	}

	public String getSortOptions() {
		return sortOptions;
	}

	public void setSortOptions(String sortOptions) {
		this.sortOptions = sortOptions;
	}

	public int getLookProductCount() {
		return lookProductCount;
	}

	public void setLookProductCount(int lookProductCount) {
		this.lookProductCount = lookProductCount;
	}

	public String getSbpProductName() {
		return sbpProductName;
	}

	public void setSbpProductName(String sbpProductName) {
		this.sbpProductName = sbpProductName;
	}

}
