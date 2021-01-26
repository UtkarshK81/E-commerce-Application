package com.cg.zmart.service;

import java.util.List;
import java.util.Optional;

import com.cg.zmart.entity.Product;

public interface ProductService {

	public List<Product> getAllProducts();
	
	public Product createProduct(Product product);
	
	public Optional<Product> fetchProductById(Long id);
	
	public String destroyProduct(Long id);
	
	public Product updateProduct(Long id, Product product);

	public List<Product> filterByCategory(String category);
}
