package com.cg.zmart.controller;

import java.util.List;

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

import com.cg.zmart.entity.ProductEntity;
import com.cg.zmart.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping("/showAll")
	public List<ProductEntity> listAllproducts() {
		return service.getAllProducts();
	}
	
	@PostMapping("/add")	
	public ProductEntity addProduct(@RequestBody ProductEntity prodEntity){
		return service.createProduct(prodEntity);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductEntity> getProductById(@PathVariable Long id){
		return ResponseEntity.ok().body(service.fetchProductById(id));
	}
	
	@DeleteMapping("delete/{id}")
	public List<ProductEntity> delete(@PathVariable Long id) {
		return service.destroyProduct(id);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ProductEntity> editProduct(@PathVariable Long id,@RequestBody ProductEntity prodEntity) {
		return ResponseEntity.ok(service.updateProduct(id, prodEntity));
	}

	@GetMapping("/under/{category}")
	public List<ProductEntity> fetchByCategory(@PathVariable String category) {
		return service.filterByCategory(category);
	}
}