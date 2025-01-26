package com.example.blog.Services.Implementation;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.blog.Entity.Category;
import com.example.blog.Entity.Post;
import com.example.blog.Entity.User;
import com.example.blog.Exceptions.ResourceNotFoundException;
import com.example.blog.Playload.CategoryDto;
import com.example.blog.Playload.PostDto;
import com.example.blog.Playload.PostResponse;
import com.example.blog.Repository.CategoryRepo;
import com.example.blog.Repository.PostRepo;
import com.example.blog.Repository.UserRepo;
import com.example.blog.Services.PostService;

@Service
public class PostServiceImple implements PostService{

	@Autowired
	private PostRepo postRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private  UserRepo userRepo;
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		           User user=this.userRepo.findById(userId).orElseThrow(() ->new ResourceNotFoundException("User","Id",userId));
		           Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
		                
		        Post post= this.modelMapper.map(postDto, Post.class);
		        post.setImageName("Default.png");
		        post.setAddeddate(new Date());
		        post.setCategory(category);
		        post.setUser(user);
		        Post CreatedPost=this.postRepo.save(post);
		        
		return this.modelMapper.map(CreatedPost,PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {	
		Post post=this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
		  post.setTitle(postDto.getTitle());
		  post.setContent(postDto.getContent());
	  
		  Post updatedpost =this.postRepo.save(post);      
         return this.modelMapper.map(updatedpost,PostDto.class);
	
	}

	@Override
	public void deletePost(Integer postId) {
		           
		  Post post=this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
		     this.postRepo.delete(post);
	}

	@Override
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
		Sort sort=(sortDir.equalsIgnoreCase("asc"))?Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();
		     
		      Pageable p=PageRequest.of(pageNumber, pageSize ,sort);
		      
		      Page<Post> pagePosts=this.postRepo.findAll(p);
		              
		    List<Post> allPosts=pagePosts.getContent();
		         List<PostDto> allposts = allPosts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		           
		         PostResponse postResponse= new PostResponse();
		         postResponse.setContent(allposts);
		         postResponse.setPageNumber(pagePosts.getNumber());
		         postResponse.setPageSize(pagePosts.getSize());
		         postResponse.setTotalPage(pagePosts.getTotalPages());
		         postResponse.setTotalElement(pagePosts.getTotalElements());
		         
		          return postResponse; 
	}
	@Override
    public 	List<PostDto> getPost() {
		  List<Post>  posts = this.postRepo.findAll();
		  List<PostDto> allPosts=posts.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
			return allPosts;
		}


	@Override
	public PostDto getPostById(Integer postId) {
	                    Post post=this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));     
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
    Category cat=this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));
     List<Post> posts =this.postRepo.findByCategory(cat);
		               
      List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

		  return postDtos;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		 User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));
			    List<Post> posts = this.postRepo.findByUser(user);
			    List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
			
			    return postDtos;
	
	}

}
