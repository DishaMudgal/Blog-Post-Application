package com.example.blog.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.blog.Playload.ApiResponse;
import com.example.blog.Playload.UserDto;
import com.example.blog.Services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	

	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto createUserDto=this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
		@PutMapping("/{userId}")
		public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId){
		UserDto updatedUser=this.userService.updateUser(userDto, userId);
			return ResponseEntity.ok(updatedUser);
		}
		@DeleteMapping("/{userId}")
		public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
			this.userService.deleteUser(userId);
			return new ResponseEntity(new ApiResponse("User deleted successfully",true),HttpStatus.OK);
		}
			@GetMapping("/")
			public ResponseEntity<List<UserDto>> getAllUsers(){
			 return ResponseEntity.ok(this.userService.getAllUser());
			}
			
			@GetMapping("/{UserId}")
			public ResponseEntity<UserDto> getAllUsers(@PathVariable Integer UserId){
			 return ResponseEntity.ok(this.userService.getUserById(UserId));
			}
	} 

 