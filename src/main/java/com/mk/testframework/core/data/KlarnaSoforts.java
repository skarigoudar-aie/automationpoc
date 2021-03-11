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
 * @author Saurabh Tripathi
 *
 */
public class KlarnaSoforts {

	private final Logger log = LoggerFactory.getLogger(getClass());
	private List<KlarnaSofort> klarnaSoforts = Lists.newArrayList();
	private Environment env;

	@Inject
	public KlarnaSoforts(Environment env) {
		this.env = env;
		load();
	}

	private void load() {
		String file = "conf" + File.separator + env.getProperty("deployment") + File.separator + "klarnaSofort.json";
		try {
			log.debug("Loading Klarna Sofort data from file {}", file);
			Type klarnaSofortList = new TypeToken<List<KlarnaSofort>>() {
			}.getType();
			this.klarnaSoforts = new GsonBuilder().create().fromJson(new FileReader(file), klarnaSofortList);
			log.debug("Loaded Klarna Sofort data");
		} catch (FileNotFoundException e) {
			log.debug("Cannot find Klarna Sofort data file {}", file);
		}
	}

	public KlarnaSofort findSofortDetails(String bankName) {
			try {
				return klarnaSoforts.stream().filter(s -> s.getBankName().equalsIgnoreCase(bankName))
						.findAny().get();
			} catch (NoSuchElementException e) {
				throw new TestEnvironmentException(
						"Cannot find " + bankName + " Klarna Sofort : " + e.getMessage());
			}
		}
}