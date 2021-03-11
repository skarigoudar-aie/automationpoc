package com.mk.testframework.core.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.velocity.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.core.exceptions.TestEnvironmentException;
import com.mk.testframework.core.exceptions.TestException;

/**
 * @author VThipperudrappa
 *
 */
public class Products {
	private final Logger log = LoggerFactory.getLogger(getClass());
	private List<Product> products = Lists.newArrayList();
	private Environment env;

	@Inject
	public Products(Environment env) {
		this.env = env;
		load();
	}
	
	private void load() {
		String file = "conf" + File.separator + env.getProperty("deployment") + File.separator + "products.json";
		try {
			log.debug("Loading skus data from file {}", file);
			Type productList = new TypeToken<List<Product>>() {
			}.getType();
			this.products = new GsonBuilder().create().fromJson(new FileReader(file), productList);
			log.debug("Loaded skus data");
		} catch (FileNotFoundException e) {
			log.debug("Cannot find skus data file {}", file);
		}
	}
	
	public List<Product> findProducts(Map<String, String> productMap) {
		List<Product> matchedProducts = Lists.newArrayList();
		productMap.forEach((k, v) -> matchedProducts.add(getMatchedProduct(k, v)));
		return matchedProducts;
	}
	
	private Product getMatchedProduct(String alias, String criteria) {
		try {
			Product product = products.stream().filter(s -> matches(s, criteria)).findAny().get();
			product.setAlias(alias);
			product.setLanguage(env.getLanguage());
			return product;
		} catch (NoSuchElementException e) {
			throw new TestEnvironmentException(
					"Cannot find product with criteria " + criteria + " : " + e.getMessage());
		}
	}
	
	private boolean matches(Product product, String criteria) {
		boolean result = true;
		for (Entry<String, String> entry : process(criteria).entrySet()) {
			try {
				String methodName = "get" + StringUtils.capitalizeFirstLetter(entry.getKey());
				Method method = Product.class.getMethod(methodName);
				String value = (String) method.invoke(product);
				result = value.equals(entry.getValue()) && result;
			} catch (Exception e) {
				log.debug("No criteria named {} defined", entry.getKey());
				throw new TestException(e.getMessage());
			} 
		}
		return result;
	}
	
	private Map<String, String> process(String criteria) {
		return Pattern.compile("\\s*,\\s*").splitAsStream(criteria.trim()).map(s -> s.split(":", 2))
				.collect(Collectors.toMap(a -> a[0], a -> a.length > 1 ? a[1] : ""));
	}
}
