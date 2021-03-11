package com.mk.testframework.core.data;

/**
 * @author MLinderman
 *
 */
public class Card {

	private String cardName;
	private String cardNumber;
	private String expirationMM;
	private String expirationYYYY;
	private String securityCode;
	private String country;
	private boolean is3Ds;
	private String paypalEmail;
	private String paypalPassword;
	
	public String getCardName() {
		return cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getExpirationMM() {
		return expirationMM;
	}

	public String getExpirationYYYY() {
		return expirationYYYY;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public String getCountry() {
		return country;
	}
	
	public boolean getIs3Ds() {
		return is3Ds;
	}
	
	public String getPayPalPWD() {
		return paypalPassword;
	}
	
	public String getPayPalEmail()
	{
		return paypalEmail;
	}
}
