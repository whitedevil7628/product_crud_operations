package com.cts.service;

import java.util.List;

import com.cts.Exception.CategoryNotFound;
import com.cts.Exception.ProductNotFound;
import com.cts.model.Product;

public interface ProductService {
	String addProduct(Product product);

	String updateProduct(Product product);

	String deleteProductById(int productId) throws ProductNotFound;

	Product getProductById(int productId) throws ProductNotFound;

	List<Product> getAllProducts();

	List<Product> getProductsByCategory(String productCategory) throws CategoryNotFound;

	List<Product> getProductsBetweenPriceRange(int intialPrice, int finalPrice);

}
