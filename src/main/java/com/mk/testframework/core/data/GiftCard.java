package com.mk.testframework.core.data;

/**
 * @author Shiva
 *
 */
public class GiftCard {

	private String scripNumber;
	private String cardNumber;
	private String securityCode;
	private String device;
	private boolean isUsed;
	private String amount;

	public String getScriptNumber() {
		return scripNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public String getDevice() {
		return device;
	}
	
	public boolean getUsedStatus() {
		return isUsed;
	}
	
	public String getAmount() {
		return amount;
	}
}
