package com.blog.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.api.payload.PageResponse;
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
	public PageResponse findAllPost(
			@RequestParam(value="pageno", defaultValue = "0", required = false) int pageno,
			@RequestParam(value = "pagesize", defaultValue = "5", required = false) int pagesize,
			@RequestParam(value = "sortby", defaultValue = "id", required = false) String sortby,
			@RequestParam(value = "sortdir", defaultValue = "asc",required = false) String sortdir){
		return postService.findAll(pageno, pagesize, sortby, sortdir);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PostDto> findByPostId(@PathVariable long id){
		return ResponseEntity.ok( postService.findByPostId(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable long id){
		return ResponseEntity.ok(postService.updatePost(postDto, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePost(@PathVariable long id){
		return new ResponseEntity<> (postService.deletePost(id), HttpStatus.OK);
	}
}
