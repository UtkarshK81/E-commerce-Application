package com.cg.zmart.service;

import java.util.List;
import com.cg.zmart.entity.Product;

public interface ProductService {

	public String createProduct(Product product);
	
	public String updateProduct(long id, long quantity, double price);
	
	public List<Product> getAllProducts();
	
	public Product fetchProductById(long id);
	
	public String destroyProduct(long id);
	
	public List<Product> filterByCategory(String category);
}
