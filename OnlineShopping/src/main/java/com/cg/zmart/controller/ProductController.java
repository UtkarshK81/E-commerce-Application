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
import com.cg.zmart.model.ProductModel;
import com.cg.zmart.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping("/showAll")
	public List<ProductModel> listAllproducts() {
		return service.getAllProducts();
	}
	
	@PostMapping("/add")	
	public ProductModel addProduct(@RequestBody ProductModel prodModel){
		return service.createProduct(prodModel);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductModel> getProductById(@PathVariable Long id){
		return ResponseEntity.ok().body(service.fetchProductById(id));
	}
	
	@DeleteMapping("delete/{id}")
	public List<ProductModel> delete(@PathVariable Long id) {
		return service.destroyProduct(id);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ProductModel> editProduct(@PathVariable Long id,@RequestBody ProductModel prodModel) {
		return ResponseEntity.ok(service.updateProduct(id, prodModel));
	}

	@GetMapping("/under/{category}")
	public List<ProductModel> fetchByCategory(@PathVariable String category) {
		return service.filterByCategory(category);
	}
}