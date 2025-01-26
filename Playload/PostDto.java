package com.example.blog.Playload;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.example.blog.Entity.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class PostDto {

	 private Integer Id;

	  
	  private String title;
		
		private String content;
		
		private String imageName;;

		private Date Addeddate;
		
		 private  CategoryDto category;
		 
		 
		 private  UserDto user;
		 
		 private Set<CommentDto> comment=new HashSet<>();
}
