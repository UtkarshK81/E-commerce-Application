package com.cg.zmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.zmart.entity.Product;
import com.cg.zmart.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository prodRepo;
	
	@Override
	public Product createProduct(Product product) {
		return prodRepo.save(product);
	}

	@Override
	public String updateProduct(Product product) {
		if(prodRepo.existsById(product.getId())) {
			prodRepo.save(product);
			return "Successfully Updated";
		}
		return "Updation cannot occur! Enter valid ProductId";
	}

	// FETCHING ALL PRODUCTS IN THE DB
	
	@Override
	public List<Product> getAllProducts() {
		return prodRepo.findAll();
	}

	@Override
	public Product fetchProductById(Long id) {
		return prodRepo.getOne(id);
	}

	@Override
	public String destroyProduct(Long id) {
		prodRepo.deleteById(id);
		return "Product removed successfully";
	}

	@Override
	public List<Product> filterByCategory(String category) {
		return prodRepo.findByProductCategory(category);
	}

}
