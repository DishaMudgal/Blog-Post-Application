package com.example.blog.Entity;

import java.util.ArrayList;
import java.util.List;
import com.example.blog.Entity.Category;
import jakarta.persistence.CascadeType;
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
@Table(name="User")
@NoArgsConstructor
@Setter
@Getter
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
 private int id;
 private String name;
 private String email;
 private String about;
 private String password;
 
 @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
 private List<Post> post=new ArrayList<>(); 
 
}
  