package com.salsatechnology.factory;

public class SunshadeStrategy implements ProductStrategy {

    public static final double DEFAULT_USER_VALUE = 10.3;
    public static final long DEFAULT_PRODUCT_VALUE = 40L;

    @Override
    public Double userValue() {
        return DEFAULT_USER_VALUE;
    }

    @Override
    public Long productValue() {
        return DEFAULT_PRODUCT_VALUE;
    }
}
