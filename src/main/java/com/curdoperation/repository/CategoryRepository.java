package com.curdoperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curdoperation.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
