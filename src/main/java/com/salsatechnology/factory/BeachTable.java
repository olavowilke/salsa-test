package com.salsatechnology.factory;

public class BeachTable implements Product {
    @Override
    public Double userValue() {
        return 8.1;
    }

    @Override
    public Long productValue() {
        return 25L;
    }
}
