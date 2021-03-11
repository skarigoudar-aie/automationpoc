package com.mk.testframework.core.provider;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import com.google.inject.Inject;
import com.google.inject.Provider;

import io.cucumber.java.Before;

/**
 * @author VThipperudrappa
 *
 */
public class WebDriverProvider implements Provider<WebDriver> {

    private static volatile WebDriver webDriver;
    private static boolean webDriverNotRunning = true;

    public static class BrowserName {
        public static final String FIREFOX = "firefox";
        public static final String CHROME = "chrome";
        public static final String IE = "ie";
    }

    @Inject
    private Config seleniumConfig;

    @Before
    public static void beforeAll() {
        if (webDriverNotRunning) {
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    if (null != webDriver) {
                        try {
                            webDriver.close();
                            webDriver.quit();
                        } catch (UnreachableBrowserException e) {
                        }

                    }
                }
            });
            webDriverNotRunning = false;
        }
    }

    public WebDriver get() {
        synchronized (WebDriverProvider.class) {
            if (webDriver == null) {
                try {
                    final String userAgent = seleniumConfig.getBrowserUserAgent();
                    final Dimension d = seleniumConfig.getWindowDimension();
                    final WebDriver webDriver = seleniumConfig.getWebDriver(userAgent);

                    if (d==null){
                        webDriver.manage().window().maximize();
                    }
                    else{
                        webDriver.manage().window().setSize(d);
                    }

                    WebDriverProvider.webDriver = webDriver;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return webDriver;
    }

}