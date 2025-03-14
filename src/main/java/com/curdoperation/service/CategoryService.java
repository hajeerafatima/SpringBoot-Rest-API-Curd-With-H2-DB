package com.curdoperation.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curdoperation.exceptions.ResourceNotFoundException;
import com.curdoperation.model.Category;
import com.curdoperation.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public void create(Category category) {
		categoryRepository.save(category);
	}
	
	public List<Category> fetchCategories() {
		return categoryRepository.findAll();
	}

	public Category fetchCategory(Integer id) {
		return categoryRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Category not found in db"));
	}

	public void deleteCategory(Integer id) {
	Category dbCategory = fetchCategory(id);
	categoryRepository.delete(dbCategory);
		
	}

	public Category update(Integer id, Category request) {
		Category dbCategory = fetchCategory(id);
		dbCategory.setName(request.getName());
		return categoryRepository.save(dbCategory);
	}
	

	
}
