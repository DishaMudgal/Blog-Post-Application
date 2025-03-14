package com.example.blog.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.blog.Entity.User;
import com.example.blog.Exceptions.ResourceNotFoundException;
import com.example.blog.Repository.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {
	  @Autowired
    private  UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= this.userRepo.findByEmail(username)
                .orElseThrow(() -> new ResourceNotFoundException("User","email :"+username,0));
               
        return user;
    }
}
