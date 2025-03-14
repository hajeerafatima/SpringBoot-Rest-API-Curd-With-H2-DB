package com.curdoperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.curdoperation.model.Product;
import com.curdoperation.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Product createProduct(@RequestBody Product product) {
		return productService.create(product);
	}
	
	@GetMapping("/fetch")
	public List<Product> fetchProducts() {
		return productService.fetchProducts();
	}
		
	@GetMapping("/{id}")
	public Product fetchProduct(@PathVariable("id") Integer id) {
		return productService.fetchProduct(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") Integer id) {
		productService.deleteProduct(id);
	}
	
	@PutMapping("/{id}")
	public Product update(@PathVariable ("id") Integer id, 
		@RequestBody Product request) {
		return productService.update(id,request);
	}
	
}
