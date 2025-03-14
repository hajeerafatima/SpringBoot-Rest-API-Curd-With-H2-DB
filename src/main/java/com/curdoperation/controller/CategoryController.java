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

import com.curdoperation.model.Category;
import com.curdoperation.service.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/create")
	@ResponseStatus( code = HttpStatus.CREATED)
	public void createCategory(@RequestBody Category category) {
		categoryService.create(category);
	}
	
	@GetMapping("/fetch")
	public List<Category> fetch(){
		return categoryService.fetchCategories();
	}
	
	@GetMapping("/{id}")
	public Category fetchCategory(@PathVariable("id") Integer id) {
		return categoryService.fetchCategory(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable("id") Integer id) {
		categoryService.deleteCategory(id);
	}
	
	@PutMapping("/{id}")
	public Category update(@PathVariable("id") Integer id,
			@RequestBody Category request) {
		return categoryService.update(id,request);
	}

}
