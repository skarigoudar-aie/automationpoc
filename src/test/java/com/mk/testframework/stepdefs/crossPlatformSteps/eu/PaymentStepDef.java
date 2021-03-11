package com.mk.testframework.stepdefs.crossPlatformSteps.eu;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.dt.page.checkout.MkPayment;
import cucumber.api.java.en.And;

/**
 * @author MLinderman
 *
 */
@SuppressWarnings("deprecation")
public class PaymentStepDef {

	private MkPayment mkPayment;
	private Environment environment;

	@Inject
	public PaymentStepDef(MkPayment mkPayment, Environment environment) {
		this.mkPayment = mkPayment;
		this.environment = environment;
	}

	@And("Payment: I select pay later with klarna")
	public void i_select_pay_later_with_klarna() {
		mkPayment.clickPayLaterWithKlarna();
	}

	@And("Payment: I select pay now with klarna Sofort")
	public void i_select_pay_now_with_klarna() {
		mkPayment.clickPayNowWithKlarna();
		if (environment.getCurrentLocale().getCountry().toLowerCase().equals("de")) {
			mkPayment.clickOnlineBankTransferWithKlarna();
		}
	}
	
	@And("Payment: I select pay now with klarna Direct Debit")
	public void i_select_pay_now_with_klarna_direct_debit() {
		mkPayment.clickPayNowWithKlarna();
		mkPayment.clickBankAccountWithKlarna();
	}
	
	@And("Payment: I select pay over time with klarna")
	public void i_select_pay_over_time_with_klarna() {
		mkPayment.clickPayOverTimeWithKlarna();
	}

	@And("Payment: I choose pay in 14 days")
	public void i_choose_pay_in_14_days() {
		mkPayment.clickPayIn14Days();
	}

	@And("Payment: I choose pay in 2 months")
	public void i_choose_pay_in_2_months() {
		mkPayment.clickPayIn2Months();
	}

	@And("Payment: I choose pay in 30 days")
	public void i_choose_pay_in_30_days() {
		mkPayment.clickPayIn30Days();
	}
	
	@And("Payment klarna Slice It: I choose pay in 6 months")
	public void i_choose_pay_in_6_months_klarna_slice_it() {
		mkPayment.clickPayIn6MonthsKlarnaSliceIt();
	}
	
	@And("Payment klarna Slice It: I choose pay in 12 months")
	public void i_choose_pay_in_12_months_klarna_slice_it() {
		mkPayment.clickPayIn12MonthsKlarnaSliceIt();
	}
	
	@And("Payment klarna Slice It: I choose pay in 24 months")
	public void i_choose_pay_in_24_months_klarna_slice_it() {
		mkPayment.clickPayIn24MonthsKlarnaSliceIt();
	}
	
	@And("Payment: I fill card information on Pay in 3 klarna")
	public void i_fill_card_information_on_pay_in_3_klarna() {
		mkPayment.fillCardDetailsKlarnaPayIn3();
	}
}
