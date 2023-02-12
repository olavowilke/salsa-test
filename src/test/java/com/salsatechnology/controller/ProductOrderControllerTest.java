package com.salsatechnology.controller;

import com.salsatechnology.BeachProductRentalApplicationTests;
import com.salsatechnology.model.ProductType;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.net.URI;

import static com.salsatechnology.controller.ProductOrderController.PRODUCT_ORDER_RESOURCE_PATH;
import static com.salsatechnology.controller.ProductOrderController.PRODUCT_ORDER_USERNAME_PATH;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.util.UriComponentsBuilder.fromPath;

public class ProductOrderControllerTest extends BeachProductRentalApplicationTests {

    @Test
    public void shouldReturnCreatedWhenCreateProductOrder() throws Exception {
        String uri = fromPath(PRODUCT_ORDER_RESOURCE_PATH).toUriString();

        mockMvc.perform(post(uri)
                        .content(getContentFromResource("/json/create-product-order.json"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldReturnOkWhenGetProductOrderByUsername() throws Exception {
        String uri = fromPath(PRODUCT_ORDER_USERNAME_PATH).toUriString();


        mockMvc.perform(get(uri)
                .param("username", "tico"))
                .andExpect(status().isOk())
                .andDo(print());
                .andExpect(jsonPath("$[0].productType").value(ProductType.SUNSHADE))
                .andExpect(jsonPath("$.timeHour").value())
                .andExpect(jsonPath("$.productValue"))
                .andExpect(jsonPath("$.productTotal"))
                .andExpect(jsonPath("$.userAmount"))

    }
}