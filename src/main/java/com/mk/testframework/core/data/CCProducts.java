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

/**
 * 
 * @author Shiva
 *
 */
public class CCProducts {

	private final Logger log = LoggerFactory.getLogger(getClass());
	private List<CCProduct> ccProduct = Lists.newArrayList();
	private Environment env;

	@Inject
	public CCProducts(Environment env) {
		this.env = env;
		load();
	}

	private void load() {
		String file = "conf" + File.separator+"clicAndCollectProduct"+File.separator + env.getProperty("deployment") + File.separator +env.getCurrentLocale().toString()+ "_ccproduct.json";
		try {
			log.debug("Loading CCProduct data from file {}", file);
			Type ccProductList = new TypeToken<List<CCProduct>>() {
			}.getType();
			this.ccProduct = new GsonBuilder().create().fromJson(new FileReader(file), ccProductList);
			log.debug("Loaded CCProduct data");
		} catch (FileNotFoundException e) {
			log.debug("Cannot find CCProduct data file {}", file);
		}
	}

	public CCProduct findCCProduct(boolean sizedProduct) {
		try {
			return ccProduct.stream().filter(s -> s.getSize() == (sizedProduct)).findAny().get();
		} catch (NoSuchElementException e) {
			throw new TestEnvironmentException("Cannot find Sized CCProduct data : " + e.getMessage());
		}
	}
}
