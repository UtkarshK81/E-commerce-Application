package com.cg.zmart.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.zmart.entity.ProductEntity;
import com.cg.zmart.exception.ResourceNotFoundException;
import com.cg.zmart.model.ProductModel;
import com.cg.zmart.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository prodRepo;
	
	@Autowired
	private ConverterService cService;

	// FETCHING ALL PRODUCTS FROM THE DB
	@Override
	public List<ProductModel> getAllProducts() {
		return prodRepo.findAll().stream().map(cService::convertToModel).collect(Collectors.toList());
	}

	// SAVE NEW PRODUCT TO DB
	@Override
	public ProductModel createProduct(ProductModel productModel) {
		ProductEntity productEntity=cService.convertToEntity(productModel);
		prodRepo.save(productEntity);
		return cService.convertToModel(productEntity);
	}

	// FETCH BY ID
	@Override
	public ProductModel fetchProductById(Long id){
		ProductEntity prodEntity= prodRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product not found for the id:"+id));
		return cService.convertToModel(prodEntity);
	}

	// DELETE BY ID
	@Override
	public List<ProductModel> destroyProduct(Long id) {
		ProductEntity product=prodRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found for this id:"+id));
		prodRepo.delete(product);
		return prodRepo.findAll().stream().map(cService::convertToModel).collect(Collectors.toList());
	}

	//UPDATE OPERATION
	@Override
	public ProductModel updateProduct(Long id, ProductModel productModel) {
		ProductEntity productEntity=cService.convertToEntity(productModel);
		productEntity=prodRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product not found for id"+id));
		productEntity.setProdImageUrl(productModel.getImageUrl());
		productEntity.setProdCategory(productModel.getProductCategory());
		productEntity.setProdDescription(productModel.getProductDescription());
		productEntity.setProdName(productModel.getProductName());
		productEntity.setProdQuantity(productModel.getProductQuantity());
		productEntity.setProdPrice(productModel.getUnitPrice());
		
		prodRepo.save(productEntity);
		return cService.convertToModel(productEntity);
	}

	@Override
	public List<ProductModel> filterByCategory(String category) {
		return prodRepo.findByProdCategory(category).stream().map(cService::convertToModel).collect(Collectors.toList());
	}

}