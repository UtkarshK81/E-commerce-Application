package com.cg.zmart.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.cg.zmart.entity.ProductEntity;
import com.cg.zmart.model.ProductModel;
@Component
public class ProductConverter {

	public ProductModel entityTomodel(ProductEntity productEntity) {
		ModelMapper mapper=new ModelMapper();
		return mapper.map(productEntity, ProductModel.class);
	}
	
	public ProductEntity modelToentity(ProductModel productModel) {
		ModelMapper mapper=new ModelMapper();
		return mapper.map(productModel, ProductEntity.class);
	}
}
