package com.salsatechnology.factory;

import com.salsatechnology.dto.ProductOrderDTO;
import com.salsatechnology.model.ProductType;

public class ProductFactory {
    public static Product getFactory(ProductOrderDTO productOrderDTO) {
        ProductType productType = productOrderDTO.getProductType();

        switch (productType){
            case SURFBOARD:
                return new Surfboard();
            case BEACH_CHAIR:
                return new BeachChair();
            case SUNSHADE:
                return new Sunshade();
            case SAND_BOARD:
                return new SandBoard();
            case BEACH_TABLE:
                return new BeachTable();
            default:
                return null;
        }
    }
}
