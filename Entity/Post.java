package com.example.blog.Entity;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.example.blog.Entity.Category;
import com.example.blog.Entity.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer Id;
	
	
	@Column(length=100, nullable=false)
    private String title;
	
	
    @Column(length=10000)
    private String content;

     private String ImageName;
 
     private Date Addeddate;
 
    @ManyToOne
    @JoinColumn(name="category_Id")
     private  Category category;
 
    @ManyToOne
    private User user;

    @OneToMany(mappedBy="post",cascade=CascadeType.ALL)
    private Set<Comment> comment=new HashSet<>();


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
