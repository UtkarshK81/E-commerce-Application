package com.cg.zmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.zmart.entity.ProductEntity;
import com.cg.zmart.exception.ResourceNotFoundException;
import com.cg.zmart.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository prodRepo;

	// FETCHING ALL PRODUCTS FROM THE DB
	@Override
	public List<ProductEntity> getAllProducts() {
		return prodRepo.findAll();
	}

	// SAVE NEW PRODUCT TO DB
	@Override
	public ProductEntity createProduct(ProductEntity product) {
		return prodRepo.save(product);
	}

	// FETCH BY ID
	@Override
	public ProductEntity fetchProductById(Long id){
		return prodRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product not found for the id:"+id));
	}

	// DELETE BY ID
	@Override
	public List<ProductEntity> destroyProduct(Long id) {
		ProductEntity product=prodRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found for this id:"+id));
		prodRepo.delete(product);
		return prodRepo.findAll();
	}

	//UPDATE OPERATION
	@Override
	public ProductEntity updateProduct(Long id, ProductEntity productDetails) {
		ProductEntity product=prodRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product not found for id"+id));
		product.setImageUrl(productDetails.getImageUrl());
		product.setProductCategory(productDetails.getProductCategory());
		product.setProductDescription(productDetails.getProductDescription());
		product.setProductName(productDetails.getProductName());
		product.setProductQuantity(productDetails.getProductQuantity());
		product.setUnitPrice(productDetails.getUnitPrice());
		
		return prodRepo.save(product);
	}

	@Override
	public List<ProductEntity> filterByCategory(String category) {
		return prodRepo.findByProductCategory(category);
	}

}