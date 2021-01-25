package com.cg.zmart.service;

import java.util.List;
import com.cg.zmart.entity.Product;

public interface ProductService {

	public Product createProduct(Product product);
	
	public String updateProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public Product fetchProductById(Long id);
	
	public String destroyProduct(Long id);
	
	public List<Product> filterByCategory(String category);
}
