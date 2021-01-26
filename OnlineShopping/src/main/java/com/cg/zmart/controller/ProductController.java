package com.cg.zmart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.zmart.entity.Product;
import com.cg.zmart.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping("/showAll")
	public List<Product> listAllproducts() {
		List<Product> products=new ArrayList<>();
		products=service.getAllProducts();
		return products;
	}
	
	@PostMapping("/add")	
	public Product addProduct(@RequestBody Product product) {	
		Product newProduct=service.createProduct(product);
		return newProduct;
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return service.fetchProductById(id).get();
	}
	
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable Long id) {
		return service.destroyProduct(id);
		
	}
	
	@PutMapping("/update/{id}")
	public Product UpdateProduct(@PathVariable Long id,@RequestBody Product product) {
		Product updated=service.updateProduct(id,product);
		return updated;
	}

	@GetMapping("/under/{category}")
	public List<Product> fetchByCategory(@PathVariable String category) {
		return service.filterByCategory(category);
	}
}
