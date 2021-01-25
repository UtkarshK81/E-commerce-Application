package com.cg.zmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<List<Product>> listAllproducts() {
		List<Product> list=service.getAllProducts();
		return new ResponseEntity<List<Product>>(list,new HttpHeaders(),HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Product> createOrupdateProduct(@RequestBody Product product) {
		Product updated=service.createOrupdateProduct(product);
		return new ResponseEntity<Product>(updated,new HttpHeaders(),HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Product product=service.fetchProductById(id);
		return new ResponseEntity<Product>(product,new HttpHeaders(),HttpStatus.OK);
}

	@GetMapping("/under/{category}")
	public List<Product> fetchByCategory(@PathVariable String category) {
		return service.filterByCategory(category);
	}

	@DeleteMapping("delete/{id}")
	public HttpStatus delete(@PathVariable long id) {
		service.destroyProduct(id);
		return HttpStatus.OK;
		
	}
}
