package com.example.blog.Playload;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDto {
	    
	       private  Integer categoryId;
	       @NotBlank
	       @Size(min=4,max=200)
		   private String categoryTitle;
	       @Size(min=8,max=800)
		   private  String Description;
}
