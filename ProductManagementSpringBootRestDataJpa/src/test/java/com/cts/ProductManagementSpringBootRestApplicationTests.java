package com.cts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.model.Product;
import com.cts.service.ProductService;

@SpringBootTest
class ProductManagementSpringBootRestApplicationTests {
	@Autowired
	ProductService service;

	@Test
	void testAddProduct() {
		Product product = new Product(9000,"samsung","electronics");
		
		assertEquals("Product Saved Successfully",service.addProduct(product));
		
	}

}
