package com.mk.testframework.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author VThipperudrappa
 * 
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.mk.testframework.core",
				"com.mk.testframework.stepdefs.crossPlatformSteps.allRegions",
				"com.mk.testframework.stepdefs.crossPlatformSteps.na.allNaRegions",
				"com.mk.testframework.stepdefs.crossPlatformSteps.na.us",
				"com.mk.testframework.stepdefs.desktopSteps.allRegions",
				"com.mk.testframework.stepdefs.desktopSteps.na.allNaRegions",
				"com.mk.testframework.stepdefs.desktopSteps.na.us",
        		"com.mk.testframework.i18n"},
        features = {"src/test/resources/features/"},
        monochrome = true,
        plugin = {
                "pretty", "html:build/cucumber-reports",
                "json:build/cucumber-reports/cucumber.json",
                "de.monochromata.cucumber.report.PrettyReports:build"},
        tags = {"@testrun001"}
)

public class RunnerUsDesktop {
	
}

