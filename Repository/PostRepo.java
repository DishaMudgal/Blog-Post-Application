package com.example.blog.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.Entity.Category;
import com.example.blog.Entity.Post;
import com.example.blog.Entity.User;

public interface PostRepo extends JpaRepository<Post,Integer>{
 List<Post> findByUser(User user);
 List<Post> findByCategory(Category Category);
 
 
}
