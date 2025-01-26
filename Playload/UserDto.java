package com.example.blog.Playload;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
 
public class UserDto {
	 private int id;
	 @NotEmpty
	 @Size(min=4,message="Username must be minimum of 4 characters")
	 private String name;
	 @Email(message="Email is invalid !!")
	 private String email;
	 @NotEmpty
	 private String about;
	 @NotEmpty
	 @Size(min=3,max=10,message="Password must be more than two character and less than 10 characters")
	 private String password; 
	
	 
	
}

