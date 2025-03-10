package com.example.blog.Playload;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
public class PostResponse {
	
	
	private List<PostDto> content;
	private int pageNumber;
	private int pageSize;
	private int totalPage;
	private long totalElement;
	private boolean lastPage;
	
}
