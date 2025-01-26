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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.Config.AppConstants;
import com.example.blog.Playload.ApiResponse;
import com.example.blog.Playload.CategoryDto;
import com.example.blog.Playload.PostDto;
import com.example.blog.Playload.PostResponse;
import com.example.blog.Playload.UserDto;
import com.example.blog.Services.PostService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")

public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/user/{userId}/category/{categoryId}/post")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,@PathVariable Integer userId,@PathVariable Integer categoryId){
		 PostDto createdPost=this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
	}
	@PutMapping("/post/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId){
		PostDto updatedPost=this.postService.updatePost(postDto, postId);
			return ResponseEntity.ok(updatedPost);
		}
	@DeleteMapping("post/{postId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId){
		this.postService.deletePost(postId);
		return new ResponseEntity(new ApiResponse("Post deleted successfully",true),HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}/posts")
	 public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
		List<PostDto> posts=this.postService.getPostByUser(userId);
	return new ResponseEntity<>(posts,HttpStatus.OK) ;	
	
	}
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId) {
	    List<PostDto> posts = this.postService.getPostByCategory(categoryId);
	    return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}
	
@GetMapping("/posts")
public ResponseEntity<PostResponse> getAllPost(
		@RequestParam(value="pageNumber",defaultValue=AppConstants.PAGE_NUMBER,required=false)Integer pageNumber,
		@RequestParam(value="pageSize",defaultValue=AppConstants.PAGE_SIZE,required=false)Integer pageSize, 
		@RequestParam(value="sortBy",defaultValue=AppConstants.SORT_BY,required=false)String sortBy, 
		@RequestParam(value="sortDir",defaultValue=AppConstants.SORT_DIR,required=false)String sortDir){
       PostResponse allPost = this.postService.getAllPost(pageNumber, pageSize, sortBy,sortDir);
    		
             return new ResponseEntity<>(allPost,HttpStatus.OK);
	}
      
@GetMapping("/posts/")
public ResponseEntity<List<PostDto>> getAllPost(){
return ResponseEntity.ok(this.postService.getPost());
}



		@GetMapping("post/{postId}")
		public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
				 PostDto postDto=this.postService.getPostById(postId);
				 return  new ResponseEntity<>(postDto,HttpStatus.OK);
		}
}





















