package com.example.blog.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Category")
@NoArgsConstructor
@Setter
@Getter
public class Category {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  Integer categoryId;
   @Column(name="Title",length=100,nullable=false)
	private String categoryTitle;
   @Column(name="Description")
	private  String Description;
	  
   @OneToMany(mappedBy="category",cascade=CascadeType.ALL)
    private List<Post> posts=new ArrayList<>(); 
   
}
