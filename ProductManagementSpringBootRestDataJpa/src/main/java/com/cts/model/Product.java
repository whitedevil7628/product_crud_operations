package com.cts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "products_info")
public class Product {
	@Id
	@Column(name = "pid", length = 3, nullable = false)
	@GeneratedValue
	private int productId;
	@Min(value=1000,message="price cannot be less than 1000")
	private int productPrice;
	@Size(min=6,max=15,message="Product name length should be between 6 and 15")
	private String productName;
	private String productCategory;

	
	public Product() {

	}

	public Product( int productPrice, String productName, String productCategory) {
		super();
	
		this.productPrice = productPrice;
		this.productName = productName;
		this.productCategory = productCategory;
	}

}
