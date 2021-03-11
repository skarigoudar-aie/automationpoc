package com.mk.testframework.core.provider;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.mk.testframework.core.env.Environment;

/**
 * @author VThipperudrappa
 * 
 */
public final class EnvironmentProviderModule extends AbstractModule {
    @Override
    public void configure() {
        bind(Environment.class).in(Scopes.SINGLETON);
    }
}
