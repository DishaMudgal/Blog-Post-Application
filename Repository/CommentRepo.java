package com.example.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.Entity.Comment;

public interface CommentRepo extends JpaRepository<Comment,Integer> {
        
}
