package com.mk.testframework.core.data;

import com.google.common.collect.Lists;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.core.exceptions.TestEnvironmentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Shiva
 *
 */
public class GiftCards {

	private final Logger log = LoggerFactory.getLogger(getClass());
	private List<GiftCard> giftcards = Lists.newArrayList();
	private Environment env;
	private String device;

	@Inject
	public GiftCards(Environment env) {
		this.env = env;
		load();
	}

	private void load() {
		String file = "conf" + File.separator +"giftCards" +File.separator + env.getProperty("deployment") + File.separator + env.getCurrentLocale().toString()+ "_gift_cards.json";
		try {
			log.debug("Loading card data from file {}", file);
			Type cardList = new TypeToken<List<GiftCard>>() {
			}.getType();
			this.giftcards = new GsonBuilder().create().fromJson(new FileReader(file), cardList);
			log.debug("Loaded gift card data");
		} catch (FileNotFoundException e) {
			log.debug("Cannot find gift card data file {}", file);
		}
	}
	
	public GiftCard findCard(String cardType) {
		try {
			return giftcards.stream().filter(s -> s.getScriptNumber().equals(cardType) && s.getDevice().equalsIgnoreCase(device()))
					.findAny().get();
		} catch (NoSuchElementException e) {
			throw new TestEnvironmentException(
					"Cannot find " + cardType + " for device " + device() + " : " + e.getMessage());
		}
	}
	
	public GiftCard findCard(String cardType, boolean usedStatus) {
		try {
			return giftcards.stream().filter(s -> s.getScriptNumber().equals(cardType) && (s.getUsedStatus() == true))
					.findAny().get();
		} catch (NoSuchElementException e) {
			throw new TestEnvironmentException(
					"Cannot update " + cardType + " : " +usedStatus+" "+ e.getMessage());
		}
	}

	public String device() {
		boolean mobile = env.isSysPropsSpecified(Environment.SysProps.MOBILE);
		if(mobile) {
			device = "mobile";
		}else {
			device = "desktop";
		}
		return device;
	}
}