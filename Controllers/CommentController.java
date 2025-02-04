package com.example.blog.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.blog.Services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.blog.Playload.ApiResponse;
import com.example.blog.Playload.CommentDto;

@RestController
@RequestMapping("/api/") 
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	
	 @PostMapping("/post/{postId}/comment/")
	 public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,@PathVariable Integer postId){
		     CommentDto createdComment = this.commentService.createComment(commentDto, postId);
		                
		    return new ResponseEntity<CommentDto>(createdComment,HttpStatus.CREATED); 
	 }
	 
	 @DeleteMapping("/comment/{commentId}/")
	 public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commenntId) {
		  this.commentService.deleteComment(commenntId);
		  return new ResponseEntity(new ApiResponse("Comment deleted successfully",true),HttpStatus.OK);
	 }
}

