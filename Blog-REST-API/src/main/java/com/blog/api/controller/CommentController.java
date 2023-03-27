package com.blog.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.api.payload.CommentDto;
import com.blog.api.service.implement.CommentServiceImplements;

@RestController
@RequestMapping("/api/blog/comment")
public class CommentController {

	private CommentServiceImplements commentServiceImplements;

	public CommentController(CommentServiceImplements commentServiceImplements) {
		this.commentServiceImplements = commentServiceImplements;
	}

	@PostMapping("/{postId}")
	public ResponseEntity<CommentDto> createComment(@PathVariable long postId, @RequestBody CommentDto commentDto) {
		return new ResponseEntity<>(commentServiceImplements.createComment(postId, commentDto), HttpStatus.CREATED);
	}

	@GetMapping("/post/{postId}")
	public ResponseEntity<List<CommentDto>> findByPostid(@PathVariable long postId) {
		return ResponseEntity.ok(commentServiceImplements.getbypostid(postId));
	}

	@GetMapping("/{commentId}")
	public ResponseEntity<CommentDto> findByCommentId(@PathVariable long commentId) {
		return new ResponseEntity<>(commentServiceImplements.getByCommentId(commentId), HttpStatus.OK);
	}

	@PutMapping("/{commentId}/post/{postId}")
	public ResponseEntity<CommentDto> updatecomment(@PathVariable long commentId, @PathVariable long postId,
			@RequestBody CommentDto commentDto) {
		return new ResponseEntity<> (commentServiceImplements.updateComment(commentId, postId, commentDto),
				HttpStatus.OK);
	}

	@DeleteMapping("/{commentId}/post/{postId}")
	public ResponseEntity<String> deleteComment(@PathVariable long commentId, @PathVariable long postId) {
		commentServiceImplements.deleteComment(commentId, postId);
		return ResponseEntity.ok("Comment deleted");
	}
}
