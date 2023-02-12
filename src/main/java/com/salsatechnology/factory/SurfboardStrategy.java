package com.salsatechnology.factory;

public class SurfboardStrategy implements ProductStrategy {

    private static final double DEFAUL_USER_VALUE = 15.6;
    private static final long DEFAULT_PRODUCT_VALUE = 50L;

    @Override
    public Double userValue() {
        return DEFAUL_USER_VALUE;
    }

    @Override
    public Long productValue() {
        return DEFAULT_PRODUCT_VALUE;
    }
}
