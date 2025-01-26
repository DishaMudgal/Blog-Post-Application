package com.example.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.Entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{


} 
