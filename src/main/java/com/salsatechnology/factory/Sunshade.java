package com.salsatechnology.factory;

import com.salsatechnology.factory.Product;

public class Sunshade implements Product {
    @Override
    public Double userValue() {
        return 10.3;
    }

    @Override
    public Long productValue() {
        return 40L;
    }
}
