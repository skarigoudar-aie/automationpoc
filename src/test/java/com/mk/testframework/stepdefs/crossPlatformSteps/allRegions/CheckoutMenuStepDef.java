package com.mk.testframework.stepdefs.crossPlatformSteps.allRegions;

import com.google.inject.Inject;
import com.mk.testframework.core.exceptions.TestException;
import com.mk.testframework.dt.header.MkCheckoutMenu;
import com.mk.testframework.dt.header.MkMyAccountMenu;
import com.mk.testframework.dt.util.PageUtils;
import cucumber.api.java.en.And;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class CheckoutMenuStepDef {
	private MkCheckoutMenu mkCheckoutMenu;
	private MkMyAccountMenu mkMyAccountMenu;
	private PageUtils pageUtils;
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Inject
	public CheckoutMenuStepDef(MkCheckoutMenu mkCheckoutMenu, MkMyAccountMenu mkMyAccountMenu,
							   PageUtils pageUtils){
		this.mkCheckoutMenu = mkCheckoutMenu;
		this.mkMyAccountMenu = mkMyAccountMenu;
		this.pageUtils = pageUtils;
	}



	@And("CHECKOUT MENU: I click on the My Account link")
	public void checkoutMENUIClickOnTheMyAccountLink() {
		mkCheckoutMenu.clickMyAccountLink();
	}
	
	@And("CHECKOUT MENU: I click Sign Out link")
	public void sbp_i_click_Sign_Out_link() {
		try {
			mkMyAccountMenu.clickSignOut();
		} catch (TestException e) {
			pageUtils.refresh();
			log.debug("Re-trying logout");
			mkMyAccountMenu.clickSignOut();
		}
	}
}	
