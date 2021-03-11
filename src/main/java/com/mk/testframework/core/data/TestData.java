package com.mk.testframework.core.data;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.velocity.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.core.env.Context;
import cucumber.runtime.java.guice.ScenarioScoped;

/**
 * @author VThipperudrappa
 *
 */
@ScenarioScoped
public class TestData {
	private final Logger log = LoggerFactory.getLogger(getClass());
	private List<Product> productsUnderTest = Lists.newArrayList();
	private User userUnderTest;
	private Card cardUnderTest;
	private GiftCard giftCardUnderTest;
	private Cards cards;
	private Environment env;
	private Users users;
	private Products products;
	private Context context;
	private Promotion promotionUnderTest;
	private Promotions promotions;
	private CCProduct ccProductUnderTest;
	private CCProducts ccProducts;
	private KlarnaSofort klarnaSofortUnderTest;
	private KlarnaSoforts klarnaSoforts;
	private GiftCards giftCards;

	@Inject
	public TestData(Users users, Products products, Environment env, Cards cards, Context context,
			Promotions promotions, KlarnaSoforts klarnaSoforts, GiftCards giftCards, CCProducts ccProducts) {
		this.env = env;
		this.products = products;
		this.users = users;
		this.cards = cards;
		this.context = context;
		this.promotions = promotions;
		this.ccProducts = ccProducts;
		this.giftCards = giftCards;
		this.klarnaSoforts = klarnaSoforts;
	}

	public void addUser(String type) {
		if (env.getCurrentLocale().getCountry().toLowerCase().equals("ca")) {
			userUnderTest = users.findUser(type, env.getCurrentLocale().getCountry(),
					env.getCurrentLocale().getLanguage());
		} else {
			userUnderTest = users.findUser(type, env.getCurrentLocale().getCountry());
		}
	}

	public void addCard(String cardType) {
		if (cardType.equalsIgnoreCase("Visa")) {
			cardUnderTest = cards.findCard(cardType);
		}
		else if(cardType.equalsIgnoreCase("Paypal"))
		{
				cardUnderTest = cards.findCard(cardType);
		}
		
		else {
			cardUnderTest = cards.findCard(cardType,env.getCountryRegion().toString());
		}
	}
	
	public void addGiftCard(String cardType) {
		
		giftCardUnderTest = giftCards.findCard(cardType);
	}
	
	public void addCard(String cardType, boolean is3Ds) {
		cardUnderTest = cards.findCard(cardType, is3Ds);
	}

	public void addPromotion(String promotionType) {
		promotionUnderTest = promotions.findPromotion(promotionType, env.getCurrentLocale().getCountry());

	}
	
	public void addItemLevelPromotion(String promotionType) {
		promotionUnderTest = promotions.findPromotion(promotionType);
	}

	public Promotion getPromotion() {
		return promotionUnderTest;

	}

	public Card getCard() {
		return cardUnderTest;
	}
	
	public GiftCard getGiftCard() {
		return giftCardUnderTest;
	}

	public User getUser() {
		return userUnderTest;
	}

	public void setRandomLastName() {

		String RandomString = "lname:MOD" + RandomStringUtils.randomAlphabetic(5);
		String[] arrOfStrs = RandomString.split(":", 2);
		context.saveData(arrOfStrs[0], arrOfStrs[1]);
	}

	public String getRandomLastName() {
		return context.getSavedData("lname");
	}

	public void createRandomEmail() {

		String userEmail = "email:DyEmail." + RandomStringUtils.randomAlphabetic(10) + "@gmail.com";

		String[] arrOfStr = userEmail.split(":", 2);
		context.saveData(arrOfStr[0], arrOfStr[1]);
	}

	public String getRandomEmail() {
		return context.getSavedData("email");
	}

	public void addProducts(Map<String, String> productMap) {
		productsUnderTest.clear();
		productsUnderTest.addAll(products.findProducts(productMap));
	}

	public Product getProduct(String alias) {
		return productsUnderTest.stream().filter(s -> s.getAlias().equals(alias)).findAny().get();
	}

	public String getProductInfo() {
		StringBuilder sb = new StringBuilder();
		productsUnderTest.stream().filter(p -> !p.getAlias().equals("UNDEFINED"))
				.forEach(p -> buildProductInfo(p, sb, env.getLanguage()));
		return sb.toString();
	}

	private void buildProductInfo(Product p, StringBuilder sb, String language) {
		sb.append("Style : " + p.getStyleName());
		sb.append("\nProduct Name : " + p.getProductName());
		sb.append("\n--------------\n");
	}

	public String getProductProperty(String testDataLookup) {
		String[] split = testDataLookup.split(":");
		if (split.length != 2) {
			log.debug("Seems the term is not a alias:property lookup, so returning as is");
			return testDataLookup;
		}
		String methodName = "get" + StringUtils.capitalizeFirstLetter(split[1]);
		String value = null;
		try {
			Method method = Product.class.getMethod(methodName);
			Product interestedProduct = productsUnderTest.stream().filter(s -> s.getAlias().equals(split[0])).findAny()
					.get();
			value = (String) method.invoke(interestedProduct);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public String getUserInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("username : " + userUnderTest.getFirstname() + " " + userUnderTest.getLastname());
		sb.append("\nemail : " + userUnderTest.getEmail());
		sb.append("\ncountry : " + userUnderTest.getCountry());
		sb.append("\ntype : " + userUnderTest.getType());
		sb.append("\n--------------\n");
		return sb.toString();
	}
	
	public String getCardInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("username : " + cardUnderTest.getCardName());
		sb.append("\nemail : " + cardUnderTest.getCardNumber());
		sb.append("\ncountry : " + cardUnderTest.getCountry());
		sb.append("\n--------------\n");
		return sb.toString();
	}

	public String getGiftCardInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("GiftCard Number : " + giftCardUnderTest.getCardNumber());
		sb.append("\npinNumber : " + giftCardUnderTest.getSecurityCode());
		sb.append("\nScriptNumber : " + giftCardUnderTest.getScriptNumber());
		sb.append("\nAmount : " + giftCardUnderTest.getAmount());
		sb.append("\n--------------\n");
		return sb.toString();
	}
	
	public String getPromoInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("PromoCode : " + promotionUnderTest.getcouponCode());
		sb.append("\nPromoName : " + promotionUnderTest.getcouponDisplayName());
		sb.append("\n--------------\n");
		return sb.toString();
	}

	public void addUser(User user) {
		this.userUnderTest = user;
	}
	
	public Card getCardDetails(String cardType) {
		cardUnderTest = cards.findCard(cardType,env.getCountryRegion().toString());
		return cardUnderTest;
	}

	public void addKlarnaSofort(String bankName) {
		klarnaSofortUnderTest = klarnaSoforts.findSofortDetails(bankName);
	}

	public KlarnaSofort getKlarnaSoforts() {
		return klarnaSofortUnderTest;
	}

	public void addCCProduct(String sizedProduct) {
		boolean isSizedProduct = sizedProduct.equalsIgnoreCase("sized");
		if (sizedProduct.equalsIgnoreCase("sized")) {
			ccProductUnderTest = ccProducts.findCCProduct(true);
		} else if(sizedProduct.equalsIgnoreCase("non sized")){
			isSizedProduct = false;
			ccProductUnderTest = ccProducts.findCCProduct(isSizedProduct);
		}

	}

	public CCProduct getCCProduct() {
		return ccProductUnderTest;

	}
	
	public GiftCard getGiftCardDetails(String cardType) {
		giftCardUnderTest = giftCards.findCard(cardType);
		return giftCardUnderTest;
	}
}
