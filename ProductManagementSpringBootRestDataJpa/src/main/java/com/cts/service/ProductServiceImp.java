package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.Exception.CategoryNotFound;
import com.cts.Exception.ProductNotFound;
import com.cts.model.Product;
import com.cts.repository.ProductRepository;

@Service("service")
public class ProductServiceImp implements ProductService {

	ProductRepository repo;

	@Autowired
	public ProductServiceImp(ProductRepository repo) {
		this.repo = repo;
	}

	@Override
	public String addProduct(Product product) {

		repo.save(product);
		return "Product saved successfully";
	}

	@Override
	public String updateProduct(Product product) {

		 repo.save(product);
		 return "Product updated successfully";
	}

	@Override
	public String deleteProductById(int productId) throws ProductNotFound {
		 repo.delete(getProductById(productId));
		 return "Product deleted successfylly";
	}

	@Override
	public Product getProductById(int productId)throws ProductNotFound {

		 Optional<Product> optional=repo.findById(productId);
		 if(optional.isEmpty()) {
			 throw new ProductNotFound("Product Not Found With Given Id..");
		 }
		 return optional.get();
	}

	@Override
	public List<Product> getAllProducts() {		
		return repo.findAll();
	}

	@Override
	public List<Product> getProductsByCategory(String productCategory)throws CategoryNotFound {
		List<Product>res=repo.findByProductCategory( productCategory);
		if(res.isEmpty()) {
			throw new CategoryNotFound( "product not found");
		}
		else {
			return res;
		}
	}

	@Override
	public List<Product> getProductsBetweenPriceRange(int intialPrice, int finalPrice) {

		return repo.findByProductPriceBetween(intialPrice, finalPrice);
	}

}
