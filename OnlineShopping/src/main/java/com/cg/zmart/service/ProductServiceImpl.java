package com.cg.zmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.zmart.entity.Product;
import com.cg.zmart.exception.ResourceNotFoundException;
import com.cg.zmart.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository prodRepo;

	// FETCHING ALL PRODUCTS FROM THE DB
	@Override
	public List<Product> getAllProducts() {
		return prodRepo.findAll();
	}

	// SAVE NEW PRODUCT TO DB
	@Override
	public Product createProduct(Product product) {
		return prodRepo.save(product);
	}

	// FETCH BY ID
	@Override
	public Product fetchProductById(Long id){
		return prodRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product not found for the id:"+id));
	}

	// DELETE BY ID
	@Override
	public List<Product> destroyProduct(Long id) {
		Product product=prodRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found for this id:"+id));
		prodRepo.delete(product);
		return prodRepo.findAll();
	}

	//UPDATE OPERATION
	@Override
	public Product updateProduct(Long id, Product productDetails) {
		Product product=prodRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product not found for id"+id));
		product.setImageUrl(productDetails.getImageUrl());
		product.setProductCategory(productDetails.getProductCategory());
		product.setProductDescription(productDetails.getProductDescription());
		product.setProductName(productDetails.getProductName());
		product.setProductQuantity(productDetails.getProductQuantity());
		product.setUnitPrice(productDetails.getUnitPrice());
		
		return prodRepo.save(product);
	}

	@Override
	public List<Product> filterByCategory(String category) {
		return prodRepo.findByProductCategory(category);
	}

}
