package com.cg.zmart.service;

import java.util.List;
import com.cg.zmart.entity.ProductEntity;

public interface ProductService {

	public List<ProductEntity> getAllProducts();
	
	public ProductEntity createProduct(ProductEntity productEntity);
	
	public ProductEntity fetchProductById(Long id);
	
	public List<ProductEntity> destroyProduct(Long id);
	
	public ProductEntity updateProduct(Long id, ProductEntity productDetails);

	public List<ProductEntity> filterByCategory(String category);
}
