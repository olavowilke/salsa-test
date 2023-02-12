package com.salsatechnology.controller;

import com.salsatechnology.BeachProductRentalApplicationTests;
import com.salsatechnology.model.ProductType;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static com.salsatechnology.controller.ProductOrderController.PRODUCT_ORDER_RESOURCE_PATH;
import static com.salsatechnology.controller.ProductOrderController.PRODUCT_ORDER_USERNAME_PATH;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
                .andDo(print())
                .andExpect(jsonPath("$[0].productType").value(ProductType.SURFBOARD.name()))
                .andExpect(jsonPath("$[0].timeHour").value(14))
                .andExpect(jsonPath("$[0].productValue").value(5000))
                .andExpect(jsonPath("$[0].productTotal").value(60000))
                .andExpect(jsonPath("$[0].userAmount").value(9360))
                .andExpect(jsonPath("$[1].productType").value(ProductType.SURFBOARD.name()))
                .andExpect(jsonPath("$[1].timeHour").value(3))
                .andExpect(jsonPath("$[1].productValue").value(5000))
                .andExpect(jsonPath("$[1].productTotal").value(15000))
                .andExpect(jsonPath("$[1].userAmount").value(2340));
    }

    @Test
    public void shouldReturnNotFoundWhenGetProductOrderByNotExistingUsername() throws Exception {
        String uri = fromPath(PRODUCT_ORDER_USERNAME_PATH).toUriString();

        mockMvc.perform(get(uri)
                        .param("username", "wrong"))
                .andExpect(status().isNotFound());
    }
}