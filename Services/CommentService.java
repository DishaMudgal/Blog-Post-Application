package com.example.blog.Services;

import com.example.blog.Playload.CommentDto;


public interface CommentService {
	CommentDto createComment(CommentDto commentDto,Integer postId);
	void deleteComment(Integer commentId);
}
