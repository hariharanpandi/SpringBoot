package com.blog.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.api.payload.PostDto;
import com.blog.api.service.implement.PostServiceImplements;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

	private PostServiceImplements postService;

	public BlogController(PostServiceImplements postService) {
		super();
		this.postService = postService;
	}
	
	@PostMapping
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
		return new ResponseEntity<> (postService.createpost(postDto),HttpStatus.OK);
	}
	
	@GetMapping
	public List<PostDto> findAllPost(){
		return postService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PostDto> findByPostId(@PathVariable long id){
		return ResponseEntity.ok( postService.findByPostId(id));
	}
}
