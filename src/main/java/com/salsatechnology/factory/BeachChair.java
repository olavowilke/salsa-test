package com.salsatechnology.factory;

public class BeachChair implements Product {
    @Override
    public Double userValue() {
        return 5.0;
    }

    @Override
    public Long productValue() {
        return 35L;
    }
}
