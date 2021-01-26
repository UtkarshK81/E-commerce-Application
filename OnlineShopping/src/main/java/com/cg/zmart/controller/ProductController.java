package com.cg.zmart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
		return service.getAllProducts();
	}
	
	@PostMapping("/add")	
	public Product addProduct(@Valid @RequestBody Product product) {	
		return service.createProduct(product);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id){
		return ResponseEntity.ok().body(service.fetchProductById(id));
	}
	
	@DeleteMapping("delete/{id}")
	public List<Product> delete(@PathVariable Long id) {
		return service.destroyProduct(id);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> UpdateProduct(@PathVariable Long id,@Valid @RequestBody Product product) {
		return ResponseEntity.ok(service.updateProduct(id, product));
	}

	@GetMapping("/under/{category}")
	public List<Product> fetchByCategory(@PathVariable String category) {
		return service.filterByCategory(category);
	}
}
