package com.mk.testframework.stepdefs.crossPlatformSteps.allRegions;

import java.util.Map;
import cucumber.api.java.en.And;
import org.apache.commons.lang3.RandomStringUtils;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import com.mk.testframework.core.data.TestData;
import com.mk.testframework.core.data.User;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.core.env.Environment;
import cucumber.api.java.en.Given;

/**
 * @author VThipperudrappa
 *
 */
@SuppressWarnings("deprecation")
public class TestDataStepDef {
	private TestData testData;
	private Context context;
	private Environment env;

	@Inject
	public TestDataStepDef(TestData testData, Context context, Environment env) {
		this.testData = testData;
		this.context = context;
		this.env = env;
	}


@Given("I am a new mk customer")
       public void i_am_a_new_mk_customer() {
             String userJson = "{\n" + 
                          "            \"firstname\": \"DyFName\",\n" + 
                          "            \"lastname\": \"DyLName\",\n" + 
                          "            \"password\": \"Tester1*\",\n" + 
                          "            \"email\": \"DyEmail."+RandomStringUtils.randomAlphabetic(10)+"@gmail.com\",\n" + 
                          "            \"language\" : \""+env.getLanguage()+"\",\n" + 
                          "            \"country\": \""+env.getCurrentLocale().getCountry().toLowerCase()+"\",\n" + 
                          "            \"phoneNumber\":  \"9876543210\",\n" + 
                          "          \"birthMonth\": \"02\",\n" +
                          "          \"birthDay\": \"06\",\n" +
                          "          \"gender\": \"Male\",\n" +
                          "            \"type\": \"new user\",\n" + 
                     "       \"address\": {\n" + 
                          "          \"postalCode\": \"T6H4M6\"\n" +
                          "      }}";
             User user = new GsonBuilder().create().fromJson(userJson, User.class);
             testData.addUser(user);
             context.writeOut(testData.getUserInfo());
       }


	@Given("I am interested in following mk products")
	public void the_mk_store_has_following_products(Map<String, String> productMap) {
		testData.addProducts(productMap);
		context.writeOut(testData.getProductInfo());
		
	}

	@And("I hold a {string} credit card")
	public void iHoldACreditCard(String cardType) {
		testData.addCard(cardType);
		context.writeOut(testData.getCardInfo());
	}
	
	@And("I hold a {string} gift card")
	public void iHoldAGiftitCard(String cardType) {
		testData.addGiftCard(cardType);
		context.writeOut(testData.getGiftCardInfo());
	}
	
	@And("I hold a {string} gift card to place order")
	public void iHoldAGiftitCardToPlaceOrder(String cardType) {
		testData.addGiftCard(cardType);
		context.writeOut(testData.getGiftCardInfo());
	}
	
	@And("I hold a {string} card type {string} credit card")
	public void iHoldACreditCard(String cardType, String is3Ds) {
		boolean is3DsCard = is3Ds.equalsIgnoreCase("3Ds");
		testData.addCard(cardType, is3DsCard);
	}

	@And("I hold a {string} Promotion type")
	public void iHoldAPromotion(String promotionType) {
		testData.addPromotion(promotionType);
		context.writeOut(testData.getPromoInfo());
	}
	@And("I hold a {string} Payment type")
	public void iHoldAPayment(String cardType) {
		testData.addCard(cardType);
	}
	
	@And("I hold a item level {string} Promotion")
	public void iHoldAItemLevelPromotion(String promotionType) {
		testData.addItemLevelPromotion(promotionType);
		context.writeOut(testData.getPromoInfo());
	}
	
	@And("I hold klarna Sofort account with {string}")
	public void iHoldAKlarnaSofortAccount(String bankName) {
		testData.addKlarnaSofort(bankName);
	}
	
}
