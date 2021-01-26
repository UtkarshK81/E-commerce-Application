package com.cg.zmart.service;

import java.util.List;

import com.cg.zmart.entity.Product;
import com.cg.zmart.exception.ResourceNotFoundException;

public interface ProductService {

	public List<Product> getAllProducts();
	
	public Product createProduct(Product product);
	
	public Product fetchProductById(Long id) throws ResourceNotFoundException;
	
	public List<Product> destroyProduct(Long id);
	
	public Product updateProduct(Long id, Product productDetails);

	public List<Product> filterByCategory(String category);
}
