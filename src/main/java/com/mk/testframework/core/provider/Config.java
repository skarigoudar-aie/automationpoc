package com.mk.testframework.core.provider;

import java.io.File;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.google.inject.Inject;
import com.mk.testframework.core.env.Environment;
import com.mk.testframework.core.exceptions.TestEnvironmentException;

/**
 * @author VThipperudrappa
 *
 */
public class Config {
	private static final String OPERATING_SYSTEM = System.getProperty("os.name").toLowerCase();
	private static final String BROWSER_NAME = "browser-name";
	private final Environment environment;
	private boolean headless;
	private boolean mobile;
	private WebDriver driver;
	private String user_agent_suffix = " MKQA_AutomationTest";


	@Inject
	public Config(final Environment environment) {
		this.environment = environment;
		this.headless = environment.isSysPropsSpecified(Environment.SysProps.HEADLESS);
		this.mobile = environment.isSysPropsSpecified(Environment.SysProps.MOBILE);
	}

	public String getBrowserName() {
		final String browserName = environment.getProperty(BROWSER_NAME);
		return browserName;
	}

	public Dimension getWindowDimension(){
		if(mobile) {
			return new Dimension(414, 896);
		}
		else{
			return new Dimension(1400, 900);
		}
	}

	public String getBrowserUserAgent() {
		final String browserName = getBrowserName();
		if (browserName.equalsIgnoreCase(WebDriverProvider.BrowserName.FIREFOX)) {
			return getFirefoxAgent();
		} else if (browserName.equalsIgnoreCase(WebDriverProvider.BrowserName.CHROME)) {
			return getChromeAgent();
		}
		else {
			throw new TestEnvironmentException("Unsupported browser [" + browserName + "].");
		}
	}

	public String getFirefoxAgent() {
		final FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setHeadless(headless);
		setGeckoDriver();

		driver = new FirefoxDriver(firefoxOptions);
		String userAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
		driver.quit();

		return userAgent+user_agent_suffix;
	}

	public String getChromeAgent() {
		final ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setHeadless(headless);
		setChromeDriver();

		driver = new ChromeDriver(chromeOptions);
		String userAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
		driver.quit();

		return userAgent+user_agent_suffix;
	}

	public WebDriver getWebDriver(String userAgent) {
		final String browserName = getBrowserName();
		if (browserName.equalsIgnoreCase(WebDriverProvider.BrowserName.FIREFOX)) {
			return getFirefoxDriver(userAgent);
		} else if (browserName.equalsIgnoreCase(WebDriverProvider.BrowserName.CHROME)) {
			return getChromeDriver(userAgent);
		} else {
			throw new TestEnvironmentException("Unsupported browser [" + browserName + "].");
		}
	}

	public WebDriver getFirefoxDriver(String userAgent) {
		final FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setHeadless(headless);
		firefoxOptions.addPreference("general.useragent.override",userAgent);
		firefoxOptions.addPreference("media.wmf.enabled", true);
		setGeckoDriver();
		return new FirefoxDriver(firefoxOptions);
	}

	public WebDriver getIeDriver() {
		final InternetExplorerOptions expectedInternetExplorerOptions = new InternetExplorerOptions();
		setIeDriver();
		return new InternetExplorerDriver(expectedInternetExplorerOptions);
	}

	public WebDriver getChromeDriver(String userAgent) {
		final ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setHeadless(headless);
		chromeOptions.addArguments("--user-agent="+userAgent);
		setChromeDriver();
		return new ChromeDriver(chromeOptions);
	}

	private void setIeDriver() {
		final File file = new File(System.getProperty("user.home") + File.separator + "drivers" + File.separator
				+ "IEDriverServer_Win32_3.14.0" + File.separator + "IEDriverServer.exe");
		file.setExecutable(true);
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
	}

	private void setChromeDriver() {
		File driverPath = null;
		if (isWindows()) {
			driverPath = new File(
					System.getProperty("user.home") + File.separator + "drivers" + File.separator + "chromedriver.exe");
			driverPath.setExecutable(true);
		} else if (isMac() || isUnix()) {
			driverPath = new File(
					System.getProperty("user.home") + File.separator + "drivers" + File.separator + "chromedriver");
		}
		System.setProperty("webdriver.chrome.driver", driverPath.getAbsolutePath());
	}

	private void setGeckoDriver() {
		File driverPath = null;
		if (isWindows()) {
			driverPath = new File(
					System.getProperty("user.home") + File.separator + "drivers" + File.separator + "geckodriver.exe");

		} else if (isMac() || isUnix()) {
			driverPath = new File(
					System.getProperty("user.home") + File.separator + "drivers" + File.separator + "geckodriver");
		}
		System.setProperty("webdriver.gecko.driver", driverPath.getAbsolutePath());
	}

	private boolean isWindows() {
		return (OPERATING_SYSTEM.indexOf("win") >= 0);
	}

	private boolean isMac() {
		return (OPERATING_SYSTEM.indexOf("mac") >= 0);
	}

	private boolean isUnix() {
		return (OPERATING_SYSTEM.indexOf("nix") >= 0 || OPERATING_SYSTEM.indexOf("nux") >= 0
				|| OPERATING_SYSTEM.indexOf("aix") > 0);
	}
}
