package com.mk.testframework.core.env;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mk.testframework.core.exceptions.TestEnvironmentException;
import org.apache.commons.lang3.LocaleUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YAMLException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author VThipperudrappa
 *
 */
public class Environment {
	private final Logger log = LoggerFactory.getLogger(getClass());
	public static final String FRAMEWORK_DIR = ".";
	private Map<String, Object> environment = Maps.newHashMap();
	private HashMap<SysProps, String> sysProps = Maps.newHashMap();
	Map<String, List<String>> countryLanguageMapping = Maps.newHashMap();

	private List<String> standAloneEuropeanCountries = Lists.newArrayList("GB", "FR", "DE", "IT", "ES", "CH");

	private List<String> catchAllEuropeanCountries = Lists.newArrayList("AT", "BE", "CZ", "DK", "FI", "HU", "LV", "LT", "LU",
			"NL", "NO", "PL", "PT", "IE", "RO", "SE");

	private List<String> globalEuropeanCountries = Lists.newArrayList("HR", "GR", "RU", "SK", "TR", "UA");

	private List<String> europeanCountries = Stream.of(standAloneEuropeanCountries, catchAllEuropeanCountries, globalEuropeanCountries)
			.flatMap(x -> x.stream()).collect(Collectors.toList());

	private List<String> northAmericanCountries = Lists.newArrayList("US", "CA");

	private List<String> middleEasternCountries = Lists.newArrayList("BH", "IL", "KW", "LB", "QA", "SA", "AE", "UA");

	private List<String> asianPacificCountries = Lists.newArrayList("AU", "HK", "IN", "ID",
			"MY", "NZ", "PK", "PH", "SG", "TW", "TH"); // "VN" excluded NA on production

	private List<String> africanCountries = Lists.newArrayList("EG", "GH", "NG", "SA");

	private List<String> globalCountries = Stream.of(middleEasternCountries, asianPacificCountries, africanCountries)
			.flatMap(x -> x.stream()).collect(Collectors.toList());

	private Locale currentLocale;

	public enum Region {
		EU, NA, MIDDLE_EAST, ASIA_PACIFIC, AFRICA
	}

	public enum SysProps {
		ENV, LOCALE, HEADLESS, MOBILE
	}

	{
		readSysProps();
		init();
	}

	private void readSysProps() {
		this.sysProps.put(SysProps.ENV, System.getProperty("env"));
		this.sysProps.put(SysProps.LOCALE, System.getProperty("locale"));
		this.sysProps.put(SysProps.HEADLESS, System.getProperty("headless"));
		this.sysProps.put(SysProps.MOBILE, System.getProperty("mobile"));
	}

	public String getSysProps(final SysProps key) {
		return sysProps.get(key);
	}

	public boolean isSysPropsSpecified(SysProps property) {
		return sysProps.get(property) != null;
	}

	public String getProperty(final String key) {
		final String property = (String) environment.get(key);
		if (property == null) {
			log.error("Error getting property: {}", key);
			throw new TestEnvironmentException("Cannot find property for '" + key + "' in env.yaml");
		}
		return property;
	}

	public String getLanguage() {
		return this.currentLocale.getLanguage();
	}

	public String getCountry() {
		return this.currentLocale.getCountry();
	}

	public Locale getCurrentLocale() {
		return this.currentLocale;
	}

	public String getMkUrl() {
		return getMkUrl(this.currentLocale);
	}

	public String getMkUrl(Locale locale) {
		if (standAloneEuropeanCountries.contains(locale.getCountry())) {
			return computeStandAloneUrl(locale);
		} else if (catchAllEuropeanCountries.contains(locale.getCountry())) {
			return computeCatchAllUrl(locale);
		} else if (globalEuropeanCountries.contains(locale.getCountry())) {
			return computeGlobalUrl(locale);
		} else if (globalCountries.contains(locale.getCountry())) {
			return computeGlobalUrl(locale);
		} else if (northAmericanCountries.contains(locale.getCountry())) {
			return computeNaUrl(locale);
		} else {
			throw new TestEnvironmentException(
					"Country does not fall under categorized region: " + locale.getCountry());
		}
	}

	private String computeGlobalUrl(Locale locale) {
		String domain = "https://" + getProperty("domain");
		return domain + ".global/" + locale;
	}

	private String computeCatchAllUrl(Locale locale) {
		String domain = "https://" + getProperty("domain");
		return domain + ".eu/" + locale;
	}

	private String computeStandAloneUrl(Locale locale) {
		String domain = "https://" + getProperty("domain");
		if (locale.getCountry().equals("GB")) {
			return domain + ".co.uk";
		} else {
			return domain + "." + locale.getCountry().toLowerCase() + "/" + locale;
		}
	}

	private String computeNaUrl(Locale locale) {
		String domain = "https://" + getProperty("domain");
		if (locale.getCountry().equals("US")) {
			return domain + ".com";
		} else {
			return domain + "." + locale.getCountry().toLowerCase() + "/" + locale;
		}
	}

	public Region getCountryRegion() {
		return getCountryRegion(this.currentLocale);
	}

	public Region getCountryRegion(Locale locale) {
		String country = locale.getCountry();
		if (europeanCountries.contains(country)) {
			return Region.EU;
		} else if (middleEasternCountries.contains(country)) {
			return Region.MIDDLE_EAST;
		} else if (asianPacificCountries.contains(country)) {
			return Region.ASIA_PACIFIC;
		} else if (africanCountries.contains(country)) {
			return Region.AFRICA;
		} else if (northAmericanCountries.contains(country)) {
			return Region.NA;
		} else {
			throw new TestEnvironmentException(
					"Country does not fall under categorized region: " + country);
		}
	}

	@SuppressWarnings("unchecked")
	private void init() {
		log.debug("Initilizing test environment file env.yml");
		final File file = getEnvironmentFile();
		final String targetEnv = getSysProps(SysProps.ENV);
		if (targetEnv == null) {
			throw new TestEnvironmentException("Environment must be defined [-Denv=<xxxx>]");
		}
		try {
			final InputStream inputStream = new FileInputStream(file);
			final Map<String, Map<String, Object>> data = new Yaml()
					.load(inputStream);
			environment = data.get(targetEnv);
			if (environment == null) {
				throw new TestEnvironmentException("The environment [" + targetEnv + "] does not exist in the file ["
						+ file.getAbsolutePath() + "].");
			}
			inputStream.close();
		} catch (YAMLException e) {
			throw new TestEnvironmentException(e);
		} catch (IOException e) {
			throw new TestEnvironmentException(e);
		}
		this.currentLocale = LocaleUtils.toLocale(getSysProps(SysProps.LOCALE));
		this.countryLanguageMapping = buildCountryLanguageMapping();
	}

	private Map<String, List<String>> buildCountryLanguageMapping() {
		Map<String, List<String>> countryLanguageMap = Maps.newHashMap();
		countryLanguageMap.put("FR", Lists.newArrayList("fr", "en"));
		countryLanguageMap.put("DE", Lists.newArrayList("de", "en"));
		countryLanguageMap.put("IT", Lists.newArrayList("it", "en"));
		countryLanguageMap.put("ES", Lists.newArrayList("es", "en"));
		countryLanguageMap.put("CH", Lists.newArrayList("de", "fr", "it", "en"));
		countryLanguageMap.put("AT", Lists.newArrayList("de", "en"));
		countryLanguageMap.put("CA", Lists.newArrayList("fr", "en"));
		return countryLanguageMap;
	}

	public String getRandomDedicatedCountryLocale() {
		List<String> countriesList = standAloneEuropeanCountries.stream()
				.filter(s -> !s.contains(this.currentLocale.getCountry())).collect(Collectors.toList());
		String country = countriesList.get(new Random().nextInt(countriesList.size()));
		String language = getRandomLanguage(country);
		return language + "_" + country;
	}

	public String getRandomCatchAllCountryLocale() {
		List<String> countriesList = catchAllEuropeanCountries.stream()
				.filter(s -> !s.contains(this.currentLocale.getCountry())).collect(Collectors.toList());
		String country = countriesList.get(new Random().nextInt(countriesList.size()));
		String language = getRandomLanguage(country);
		return language + "_" + country;
	}

	public String getRandomGlobalCountryLocale() {
		List<String> countriesList = globalCountries.stream()
				.filter(s -> !s.contains(this.currentLocale.getCountry())).collect(Collectors.toList());
		String country = countriesList.get(new Random().nextInt(countriesList.size()));
		String language = getRandomLanguage(country);
		return language + "_" + country;
	}

	public String getRandomNaCountryLocale() {
		List<String> countriesList = northAmericanCountries.stream()
				.filter(s -> !s.contains(this.currentLocale.getCountry())).collect(Collectors.toList());
		String country = countriesList.get(new Random().nextInt(countriesList.size()));
		String language = getRandomLanguage(country);
		return language + "_" + country;
	}

	private String getRandomLanguage(String country) {
		List<String> languages = countryLanguageMapping.get(country);
		try {
			return languages.get(new Random().nextInt(languages.size()));
		} catch (NullPointerException e) {
			log.debug("Defaulting to english language");
			return "en";
		}
	}

	private File getEnvironmentFile() {
		final File[] files = listFiles(new File(FRAMEWORK_DIR), "^env.ya?ml$");
		if (files.length == 0) {
			log.error("A filename matching either env.yml or env.yaml could not be found");
			throw new TestEnvironmentException("A filename matching either env.yml or env.yaml could not be found.");
		}
		return files[0];
	}

	private File[] listFiles(final File parentDirectory, final String regex) {
		final List<File> matchedFiles = new ArrayList<File>();
		listFiles(parentDirectory, regex, matchedFiles);
		return matchedFiles.toArray(new File[matchedFiles.size()]);
	}

	private void listFiles(final File parentDirectory, final String regex, final List<File> files) {
		final File[] listFiles = parentDirectory.listFiles();
		if (files != null) {
			for (int i = 0; i < listFiles.length; i++) {
				if (listFiles[i].isDirectory()) {
					listFiles(listFiles[i], regex, files);
				} else {
					if (listFiles[i].getName().matches(regex)) {
						files.add(listFiles[i]);
					}
				}
			}
		}
	}
}
