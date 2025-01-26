package com.example.blog.Services.Implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.Entity.Comment;
import com.example.blog.Entity.Post;
import com.example.blog.Exceptions.ResourceNotFoundException;
import com.example.blog.Playload.CommentDto;
import com.example.blog.Repository.CommentRepo;
import com.example.blog.Repository.PostRepo;
import com.example.blog.Services.CommentService;

@Service
public class CommentServiceImple implements CommentService {
	   @Autowired
        private PostRepo postRepo;
          
	   @Autowired
        private CommentRepo commentRepo;
	   
	   @Autowired
	   private ModelMapper modelMapper;
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
	   
		  Post post = this.postRepo.findById(postId).orElseThrow(() ->new ResourceNotFoundException("Post","Id",postId));
		                        Comment comment = this.modelMapper.map(commentDto,Comment.class);
		                        comment.setPost(post);
		
		                        Comment savedComment = this.commentRepo.save(comment);
		                        
		                        
		                        
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		 Comment comment = this.commentRepo.findById(commentId).orElseThrow(() ->new ResourceNotFoundException("comment","Id",commentId));
		 this.commentRepo.delete(comment);
		 
	}

}
