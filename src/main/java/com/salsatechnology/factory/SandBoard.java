package com.salsatechnology.factory;

import com.salsatechnology.factory.Product;

public class SandBoard implements Product {
    @Override
    public Double userValue() {
        return 9.0;
    }

    @Override
    public Long productValue() {
        return 25L;
    }
}
