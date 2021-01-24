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
	public String createProduct(Product product) {
		prodRepo.save(product);
		return "Product added successfully";
	}

	@Override
	public String updateProduct(long id, long quantity, double price) {
		if(prodRepo.existsById(id)) {
			Product product=prodRepo.getOne(id);
			product.setProductQuantity(quantity);
			product.setUnitPrice(price);
			prodRepo.saveAndFlush(product);
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
	public Product fetchProductById(long id) {
		return prodRepo.getOne(id);
	}

	@Override
	public String destroyProduct(long id) {
		prodRepo.deleteById(id);
		return "Product removed successfully";
	}

	@Override
	public List<Product> filterByCategory(String category) {
		return prodRepo.findByProductCategory(category);
	}

}
