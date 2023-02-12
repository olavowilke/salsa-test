package com.salsatechnology.factory;

public class SandBoardStrategy implements ProductStrategy {

    public static final double DEFAULT_USER_VALUE = 9.0;
    public static final long DEFAULT_PRODUCT_VALUE = 25L;

    @Override
    public Double userValue() {
        return DEFAULT_USER_VALUE;
    }

    @Override
    public Long productValue() {
        return DEFAULT_PRODUCT_VALUE;
    }
}
