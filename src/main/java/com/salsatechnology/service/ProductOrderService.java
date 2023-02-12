package com.salsatechnology.service;

import com.salsatechnology.model.ProductOrder;
import com.salsatechnology.repository.ProductOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductOrderService {

	private final ProductOrderRepository productOrderRepository;

	@Transactional
	public ProductOrder createOrder(ProductOrder productOrder) {

		return productOrderRepository.save(productOrder);
	}

	public List<ProductOrder> getByUsername(String username) {
		return productOrderRepository.findByUserNameIgnoreCase(username);
	}
}