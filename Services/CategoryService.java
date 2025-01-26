package com.example.blog.Services;

import java.util.List;

import com.example.blog.Playload.CategoryDto;

public interface CategoryService {
	
	 public CategoryDto createCategory(CategoryDto  categoryDto);
	 public CategoryDto updateCategory(CategoryDto  categoryDto,Integer categoryId);
	 public void deleteCategory(Integer categoryId);
	 public  List<CategoryDto> getCategories();
	 public CategoryDto getCategoryById(Integer categoryId);

}
