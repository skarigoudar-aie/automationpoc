package com.mk.testframework.core.provider;

import org.openqa.selenium.WebDriver;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

/**
 * @author VThipperudrappa
 *
 */
public final class WebDriverProviderModule extends AbstractModule {
    @Override
    public void configure() {
        bind(WebDriver.class).toProvider(WebDriverProvider.class).in(
                Scopes.SINGLETON);
    }
}