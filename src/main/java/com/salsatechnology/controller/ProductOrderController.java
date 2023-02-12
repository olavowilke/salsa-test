package com.salsatechnology.controller;

import com.salsatechnology.assembler.ProductOrderAssembler;
import com.salsatechnology.dto.ProductOrderByUsernameDTO;
import com.salsatechnology.dto.ProductOrderDTO;
import com.salsatechnology.model.ProductOrder;
import com.salsatechnology.service.ProductOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

import static com.salsatechnology.exception.CustomExceptionHandler.PRODUCT_ORDER_NOT_FOUND_FOR_THIS_USERNAME;

@RestController
@RequiredArgsConstructor
public class ProductOrderController {

    public static final String PRODUCT_ORDER_RESOURCE_PATH = "/orders";
    public static final String PRODUCT_ORDER_USERNAME_PATH = PRODUCT_ORDER_RESOURCE_PATH + "/username";
    private final ProductOrderService productOrderService;
    private final ProductOrderAssembler productAssembler;

    @PostMapping(PRODUCT_ORDER_RESOURCE_PATH)
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody @Valid ProductOrderDTO productOrderDTO) {
        ProductOrder productOrder = productAssembler.toEntity(productOrderDTO);
        productOrderService.createOrder(productOrder);
    }

    @GetMapping(PRODUCT_ORDER_USERNAME_PATH)
    @ResponseStatus(HttpStatus.OK)
    public List<ProductOrderByUsernameDTO> getOrderByUsername(@RequestParam String username) {
        List<ProductOrder> productOrderByUsername = productOrderService.getByUsername(username);

        if (productOrderByUsername.isEmpty()) {
            throw new EntityNotFoundException(String.format(PRODUCT_ORDER_NOT_FOUND_FOR_THIS_USERNAME, username));
        } else {
            return productAssembler.toModel(productOrderByUsername);
        }
    }
}