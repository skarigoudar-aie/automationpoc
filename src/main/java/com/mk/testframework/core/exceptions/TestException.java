package com.mk.testframework.core.exceptions;

/**
 * @author VThipperudrappa
 * 
 */
public class TestException extends RuntimeException {

    private static final long serialVersionUID = 6174949149469086226L;

    public TestException(final String string) {
        super(string);
    }

    public TestException(final Throwable cause) {
        super(cause);
    }

    public TestException(final String string, final Throwable cause) {
        super(string, cause);
    }
}