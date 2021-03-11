package com.mk.testframework.core.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.core.exceptions.TestEnvironmentException;

public class Promotions {


	private final Logger log = LoggerFactory.getLogger(getClass());
	private List<Promotion> promotions = Lists.newArrayList();
	private Environment env;

	@Inject
	public Promotions(Environment env) {
		this.env = env;
		load();
	}

	private void load() {
		String file = "conf" + File.separator + env.getProperty("deployment") + File.separator + "promotions.json";
		try {
			log.debug("Loading promotion data from file {}", file);
			Type promotionList = new TypeToken<List<Promotion>>() {
			}.getType();
			this.promotions = new GsonBuilder().create().fromJson(new FileReader(file), promotionList);
			log.debug("Loaded promotion data");
		} catch (FileNotFoundException e) {
			log.debug("Cannot find promotion data file {}", file);
		}
	}

	public Promotion findPromotion(String promotionType) {
			try {
				return promotions.stream().filter(s -> s.getPromotionType().toLowerCase().equalsIgnoreCase(promotionType.toLowerCase()))
						.findAny().get();
			} catch (NoSuchElementException e) {
				throw new TestEnvironmentException(
						"Cannot find " + promotionType + " promotionType : " + e.getMessage());
			}
		}
	
	public Promotion findPromotion(String promotionType, String country) {
		try {
			return promotions.stream().filter(s -> s.getPromotionType().equals(promotionType) && s.getCountry().equalsIgnoreCase(country))
					.findAny().get();
		} catch (NoSuchElementException e) {
			throw new TestEnvironmentException(
					"Cannot find " + promotionType + " user for country " + country + " : " + e.getMessage());
		}
	}

}
