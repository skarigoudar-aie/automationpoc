package com.mk.testframework.core.exceptions;

/**
 * @author VThipperudrappa
 * 
 */
public class TestEnvironmentException extends RuntimeException {
    private static final long serialVersionUID = -6497734885881019694L;

    public TestEnvironmentException(final String string) {
        super(string);
    }

    public TestEnvironmentException(final Throwable cause) {
        super(cause);
    }

    public TestEnvironmentException(final String string, final Throwable cause) {
        super(string, cause);
    }
}