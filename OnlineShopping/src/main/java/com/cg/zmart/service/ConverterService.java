package com.cg.zmart.service;

import org.springframework.stereotype.Component;

import com.cg.zmart.entity.ProductEntity;
import com.cg.zmart.model.ProductModel;

@Component
public class ConverterService {
	
	public ProductModel convertToModel(ProductEntity entity) {
		ProductModel productModel=new ProductModel();
		productModel.setId(entity.getProdId());
		productModel.setImageUrl(entity.getProdImageUrl());
		productModel.setProductCategory(entity.getProdCategory());
		productModel.setProductDescription(entity.getProdDescription());
		productModel.setProductName(entity.getProdName());
		productModel.setProductQuantity(entity.getProdQuantity());
		productModel.setUnitPrice(entity.getProdPrice());
		
		return productModel;
	}
	
	public ProductEntity convertToEntity(ProductModel model) {
		ProductEntity entity=new ProductEntity();
		entity.setProdId(model.getId());
		entity.setProdImageUrl(model.getImageUrl());
		entity.setProdCategory(model.getProductCategory());
		entity.setProdDescription(model.getProductDescription());
		entity.setProdName(model.getProductName());
		entity.setProdQuantity(model.getProductQuantity());
		entity.setProdPrice(model.getUnitPrice());
		
		return entity;
	}

}
