package com.example.blog.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.Playload.ApiResponse;
import com.example.blog.Playload.CategoryDto;

import com.example.blog.Services.CategoryService;


import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService; 
	
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto createdCategory=this.categoryService.createCategory(categoryDto);
		 return new ResponseEntity<>(createdCategory,HttpStatus.CREATED);
		
         	}
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId){
	CategoryDto updatedCategory=this.categoryService.updateCategory(categoryDto, categoryId);
	return new ResponseEntity<>(updatedCategory,HttpStatus.OK);
	//return ResponseEntity.ok(updatedCategory);
	   }
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
		this.categoryService.deleteCategory(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted successfully",true),HttpStatus.OK);
	   }
	
		@GetMapping("/")
		public ResponseEntity<List<CategoryDto>> getCategories(){
		 return ResponseEntity.ok(this.categoryService.getCategories());
		}
		
		  
		@GetMapping("/{categoryId}")
		public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer categoryId){
				 CategoryDto categoryDto=this.categoryService.getCategoryById(categoryId);
				 return  new ResponseEntity<>(categoryDto,HttpStatus.OK);
		}
	
	
	
	
	
}
