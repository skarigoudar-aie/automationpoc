package com.mk.testframework.core.injector;

import com.google.inject.AbstractModule;
import com.mk.testframework.core.provider.EnvironmentProviderModule;
import com.mk.testframework.core.provider.WebDriverProviderModule;

/**
 * @author VThipperudrappa
 * 
 */
public final class GuiceModule extends AbstractModule {
    @Override
    public void configure() {
        try {
            install(new EnvironmentProviderModule());
            install(new WebDriverProviderModule());
        } catch (Exception e) {
            addError(e.getMessage());
        }
    }
}
