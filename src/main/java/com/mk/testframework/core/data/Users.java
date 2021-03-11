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
 * @author VThipperudrappa
 *
 */
public class Users {

	private final Logger log = LoggerFactory.getLogger(getClass());
	private List<User> users = Lists.newArrayList();
	private Environment env;

	@Inject
	public Users(Environment env) {
		this.env = env;
		load();
	}

	private void load() {
		String file = "conf" + File.separator + env.getProperty("deployment") + File.separator + "users.json";
		try {
			log.debug("Loading user data from {}", file);
			Type userList = new TypeToken<List<User>>() {
			}.getType();
			this.users = new GsonBuilder().create().fromJson(new FileReader(file), userList);
			log.debug("Loaded user data");
		} catch (FileNotFoundException e) {
			log.debug("Cannot find users data from {}", file);
		}
	}

	
	public User findUser(String country) {
		try {
			return users.stream().filter(s -> s.getCountry().equalsIgnoreCase(country))
					.findAny().get();
		} catch (NoSuchElementException e) {
			throw new TestEnvironmentException(
					"Cannot find guest user for country " + country + " : " + e.getMessage());
		}
	}
	
	public User findUser(String userType, String country) {
		try {
			return users.stream().filter(s -> s.getType().equals(userType) && s.getCountry().equalsIgnoreCase(country))
					.findAny().get();
		} catch (NoSuchElementException e) {
			throw new TestEnvironmentException(
					"Cannot find " + userType + " user for country " + country + " : " + e.getMessage());
		}
	}

	public User findUser(String userType, String country, String language) {
		try {
			return users.stream().filter(s -> s.getType().equals(userType) && s.getCountry().equalsIgnoreCase(country)
					&& s.getLanguage().equalsIgnoreCase(language)).findAny().get();
		} catch (NoSuchElementException e) {
			throw new TestEnvironmentException(
					"Cannot find " + userType + " user for country " + country + " : " + e.getMessage());
		}
	}
}