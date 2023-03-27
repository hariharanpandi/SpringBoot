package com.blog.api.service;

import java.util.List;

import com.blog.api.payload.CommentDto;

public interface CommentService {

	// create comment
	CommentDto createComment(long postid, CommentDto commentDto);
	
	// get by post id
	List<CommentDto> getbypostid(long postId);
	
	// get by comment id
	CommentDto getByCommentId(long commentId); 
	
	// update comment
	CommentDto updateComment(long commentId, Long postId, CommentDto commentDto);
	
	// delete comment
	void deleteComment(long commentId, long postId);
}
