package com.cts.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.Exception.CategoryNotFound;
import com.cts.Exception.ProductNotFound;
import com.cts.model.Product;
import com.cts.service.ProductService;

import jakarta.validation.Valid;

@RestController // @responseBody and @controller
@RequestMapping("/products") // http://localhost:8080:/products
//@AllArgsConstructor
public class ProductController {

	ProductService service;
	
//	@Autowired
	ProductController(ProductService service) {
		this.service = service;
	}

	@PostMapping("/save") // http://localhost:8080:/products/save
	public String saveProduct(@Valid @RequestBody Product product) {
		return service.addProduct(product);
	}

	@PutMapping("/update") // http://localhost:8080:/products/update
	public String editProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}

	@DeleteMapping("/delete/{pid}") // http://localhost:8080:/products/delete/123
	public String deleteProduct(@PathVariable("pid") int productId) throws ProductNotFound {
		return service.deleteProductById(productId);
	}

	@GetMapping("/fetch/{pid}") // http://localhost:8080:/products/fetch/123
	public Product getProduct(@PathVariable("pid") int productId) throws ProductNotFound {
		return service.getProductById(productId);
	}

	@GetMapping("/fetchAll") // http://localhost:8080:/products/fecthAll
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}

	@GetMapping("/fetchAllBetween/{price1}/{price2}") // http://localhost:8080:/products/fecthAllBetween/12000/14000
	public List<Product> getAllProductsBetween(@PathVariable("price1") int intialPrice,
			@PathVariable("price2") int finalPrice) {
		return service.getProductsBetweenPriceRange(intialPrice, finalPrice);
	}

	@GetMapping("/fetchAllByCategory/{category}") // http://localhost:8080:/products/fetchAllByCategory/electronics
	public List<Product> getAllProductsByCategory(@PathVariable("category") String category) throws CategoryNotFound {
		return service.getProductsByCategory(category);
	}

}
