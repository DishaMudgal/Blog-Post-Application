package com.example.blog.Playload;

import lombok.Data;

@Data
public class JwtAuthRequest {
	
   private String Username;
   
   private String Password;
}
