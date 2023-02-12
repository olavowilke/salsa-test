package com.salsatechnology.factory;

public class BeachChairStrategy implements ProductStrategy {

    public static final double DEFAULT_USER_VALUE = 5.0;
    public static final long DEFAULT_PRODUCT_VALUE = 35L;

    @Override
    public Double userValue() {
        return DEFAULT_USER_VALUE;
    }

    @Override
    public Long productValue() {
        return DEFAULT_PRODUCT_VALUE;
    }
}
