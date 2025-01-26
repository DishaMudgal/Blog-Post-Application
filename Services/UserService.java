package com.example.blog.Services;

import java.util.List;


import com.example.blog.Playload.UserDto;

public interface UserService {
   UserDto createUser(UserDto user);
   UserDto updateUser(UserDto user,Integer userId);
   UserDto getUserById(Integer UserId);
   List<UserDto> getAllUser();
   void deleteUser(Integer userId);
	   
   
}
