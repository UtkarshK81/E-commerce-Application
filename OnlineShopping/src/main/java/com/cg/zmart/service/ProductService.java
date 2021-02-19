package com.cg.zmart.service;

import java.util.List;
import com.cg.zmart.model.ProductModel;

public interface ProductService {

	public List<ProductModel> getAllProducts();
	
	public ProductModel createProduct(ProductModel productModel);
	
	public ProductModel fetchProductById(Long id);
	
	public List<ProductModel> destroyProduct(Long id);
	
	public ProductModel updateProduct(Long id, ProductModel productModel);

	public List<ProductModel> filterByCategory(String category);
}
