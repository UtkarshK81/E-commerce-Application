package com.cg.zmart.service;

import java.util.List;
import com.cg.zmart.entity.Product;

public interface ProductService {
	
	public Product updateProduct(Long id,Product product);
	public Product createProduct(Product product);
	public List<Product> getAllProducts();
	
	public Product fetchProductById(Long id);
	
	public List<Product> destroyProduct(Long id);
	
	public List<Product> filterByCategory(String category);
}
