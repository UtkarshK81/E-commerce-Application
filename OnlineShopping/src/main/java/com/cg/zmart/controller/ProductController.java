package com.cg.zmart.controller;

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
@CrossOrigin()
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping("/showAll")
	public List<Product> listAllproducts(){
		return service.getAllProducts();
	}
	
	@PostMapping("/add")
	public String addProduct(@RequestBody Product product) {
		return service.createProduct(product);
	}
	
	@PutMapping("/update/{id}/{quantity}/{price}")
	public String updateProduct(@PathVariable long id,@PathVariable long quantity, @PathVariable double price) {
		return service.updateProduct(id, quantity, price);
	}
	
	/*
	 * @GetMapping("/{id}") public Product getProductById(@PathVariable long id) {
	 * return service.fetchProductById(id); }
	 */
	
	@GetMapping("/under/{category}")
	public List<Product> fetchByCategory(@PathVariable String category) {
		return service.filterByCategory(category);
	}
	
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable long id) {
		return service.destroyProduct(id);
	}
}
