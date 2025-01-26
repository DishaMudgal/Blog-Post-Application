package com.example.blog.Services;

import java.util.List;
import com.example.blog.Playload.PostDto;
import com.example.blog.Playload.PostResponse;


public interface PostService {
	
	PostDto createPost(PostDto postDto,  Integer userId, Integer categoryId);
	
	PostDto updatePost(PostDto postDto,Integer postId);

	 void deletePost(Integer postId);
	 
	 PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
	 PostDto getPostById(Integer postId);
	
    List<PostDto> getPostByCategory(Integer categoryId);
  
    List<PostDto> getPostByUser(Integer userId);

	List<PostDto> getPost();
  
}
