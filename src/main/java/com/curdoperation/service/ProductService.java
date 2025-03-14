package com.curdoperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curdoperation.exceptions.ResourceNotFoundException;
import com.curdoperation.model.Category;
import com.curdoperation.model.Product;
import com.curdoperation.model.Status;
import com.curdoperation.repository.ProductRepository;
import com.curdoperation.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	public Product create(Product product) {
		//first it check category exist or not
		//if not then set dbCategory to productentity
		//save the record into db
		Category dbCategory = categoryService.fetchCategory(product.getCategory().getId());
		product.setCategory(dbCategory);  //it will insert into category_id
		product.setStatus(Status.NEW);
		
		return productRepository.save(product);
	}
	public List<Product> fetchProducts() {
		return productRepository.findAll();
	}

	public Product fetchProduct(Integer id) {
		return productRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Product not found in db"));
	}
	
	public void deleteProduct(Integer id) {
	Product dbProduct = fetchProduct(id);
	productRepository.delete(dbProduct);
	}
	
	public Product update(Integer id, Product request) {
		Product dbProduct = fetchProduct(id);
		
		if(request.getName() != null) {
			dbProduct.setName(request.getName());
		}
		
		if(request.getDescription() != null){
			dbProduct.setDescription(request.getDescription());
		}
		
//		dbProduct.setName(request.getName());
//		dbProduct.setPrice(request.getPrice());
//		dbProduct.setDescription(request.getDescription());
		return productRepository.save(dbProduct);
	}
	
	
}
