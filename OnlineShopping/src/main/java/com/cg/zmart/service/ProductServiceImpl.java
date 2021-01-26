package com.cg.zmart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.zmart.entity.Product;
import com.cg.zmart.exception.NotFoundException;
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
	
	//SAVE NEW PRODUCT TO DB
	@Override
	public Product createProduct(Product product) {
		return prodRepo.save(product);
	}
	
	//FETCH BY ID
	@Override
	public Optional<Product> fetchProductById(Long id) {
		return prodRepo.findById(id);
	}
	
	//DELETE BY ID
	@Override
	public String destroyProduct(Long id) {
		if(id!=null) {
		prodRepo.deleteById(id);
		return "Product deleted successfully";
		}else {
			throw new NotFoundException("Invalid Id!");
		}
	}

	@Override
	public Product updateProduct(Long id,Product product) {
		return prodRepo.saveAndFlush(product);
	}

	@Override
	public List<Product> filterByCategory(String category) {
		return prodRepo.findByProductCategory(category);
	}

}
