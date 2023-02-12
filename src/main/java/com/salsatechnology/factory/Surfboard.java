package com.salsatechnology.factory;

import com.salsatechnology.factory.Product;

public class Surfboard implements Product {
    @Override
    public Double userValue() {
        return 15.6;
    }

    @Override
    public Long productValue() {
        return 50L;
    }
}
