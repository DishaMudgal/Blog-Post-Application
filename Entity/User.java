package com.example.blog.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.blog.Entity.Category;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class User  implements UserDetails {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
 private int id;
 private String name;
 private String email;
 private String about;
 private String password;
 
 @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
 private List<Post> post=new ArrayList<>(); 
 
 @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
 @JoinTable(name="User_Role", joinColumns = @JoinColumn(name="user", referencedColumnName = "id"),
		    inverseJoinColumns = @JoinColumn(name="role", referencedColumnName = "id")
		 )
 private Set<Role> roles=new HashSet<>();
 

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	
	  List<SimpleGrantedAuthority> authories = this.roles.stream()
            .map(role -> new SimpleGrantedAuthority(role.getName()))
            .collect(Collectors.toList());
	  return authories;
}


@Override
public String getUsername() {
	
	return this.email;
}
@Override
public boolean isAccountNonExpired() {
    return true; // Change logic if needed
}

@Override
public boolean isAccountNonLocked() {
    return true; // Change logic if needed
}

@Override
public boolean isCredentialsNonExpired() {
    return true; // Change logic if needed
}

@Override
public boolean isEnabled() {
    return true; // Change logic if needed
}
 
}
  