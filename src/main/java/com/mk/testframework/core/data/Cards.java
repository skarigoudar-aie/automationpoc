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
 * @author MLinderman
 *
 */
public class Cards {

	private final Logger log = LoggerFactory.getLogger(getClass());
	private List<Card> cards = Lists.newArrayList();
	private Environment env;

	@Inject
	public Cards(Environment env) {
		this.env = env;
		load();
	}

	private void load() {
		String file = "conf" + File.separator + env.getProperty("deployment") + File.separator + "cards.json";
		try {
			log.debug("Loading card data from file {}", file);
			Type cardList = new TypeToken<List<Card>>() {
			}.getType();
			this.cards = new GsonBuilder().create().fromJson(new FileReader(file), cardList);
			log.debug("Loaded card data");
		} catch (FileNotFoundException e) {
			log.debug("Cannot find card data file {}", file);
		}
	}

	public Card findCard(String cardType) {
			try {
				return cards.stream().filter(s -> s.getCardName().toLowerCase().equalsIgnoreCase(cardType.toLowerCase()))
						.findAny().get();
			} catch (NoSuchElementException e) {
				throw new TestEnvironmentException(
						"Cannot find " + cardType + " credit card : " + e.getMessage());
			}
		}
	
	public Card findCard(String cardType, String country) {
		try {
			return cards.stream().filter(s -> s.getCardName().equals(cardType) && s.getCountry().equalsIgnoreCase(country))
					.findAny().get();
		} catch (NoSuchElementException e) {
			throw new TestEnvironmentException(
					"Cannot find " + cardType + " user for country " + country + " : " + e.getMessage());
		}
	}
	
	public Card findCard(String cardType, boolean is3Ds) {
		try {
			return cards.stream().filter(s -> s.getCardName().equals(cardType) && (s.getIs3Ds() == is3Ds))
					.findAny().get();
		} catch (NoSuchElementException e) {
			throw new TestEnvironmentException(
					"Cannot find " + cardType + " 3Ds " + e.getMessage());
		}
	}

}