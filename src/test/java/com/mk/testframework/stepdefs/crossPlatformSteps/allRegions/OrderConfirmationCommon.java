package com.mk.testframework.stepdefs.crossPlatformSteps.allRegions;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.exceptions.TestException;
import com.mk.testframework.dt.header.MkCheckoutMenu;
import com.mk.testframework.dt.header.MkMyAccountMenu;
import com.mk.testframework.dt.util.ExcelUtils;
import com.mk.testframework.dt.util.PageUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Shiva
 *
 */
@SuppressWarnings("deprecation")
public class OrderConfirmationCommon {
	private ExcelUtils excelUtils;
	private Context context;

	@Inject
	public OrderConfirmationCommon(ExcelUtils excelUtils, Context context){
		this.excelUtils = excelUtils;
		this.context = context;
	}

	@And("ORDERCONFIRMATION: I write order number for {string}")
	public void checkoutMENUIClickOnTheMyAccountLink(String scriptNumber) throws IOException {
		String orderNumber = context.getSavedData("orderNumber");
		excelUtils.setCellData(orderNumber, scriptNumber);
	}
	
}	
