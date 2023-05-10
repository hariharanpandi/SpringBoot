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
import com.blog.api.payload.PostResponse;
import com.blog.api.service.PostServices;
import com.blog.api.service.implement.PostServiceImplements;
import com.blog.api.utils.AppConstants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

	private PostServices postService;

	public BlogController(PostServiceImplements postService) {
		super();
		this.postService = postService;
	}

	@Operation(tags = "Blogs", summary = "Creating Blog post")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "The request has been succeeded", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PostResponse.class))),

			@ApiResponse(responseCode = "400", description = "The request could not be parsed or processed.", content = @Content(mediaType = "application/json")),

			@ApiResponse(responseCode = "401", description = "The client request has not been completed because it lacks valid authentication "
					+ "credentials for the requested resource.", content = @Content(mediaType = "application/json")) })

	@PostMapping
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
		return new ResponseEntity<>(postService.createpost(postDto), HttpStatus.OK);
	}

	@Operation(tags = "Blogs", summary = "Retrieving all blog post from Blog application")
	@GetMapping
	public PageResponse findAllPost(
			@RequestParam(value = "page_no", defaultValue = AppConstants.DEFAULT_PAGE_NO, required = false) int pageno,
			@RequestParam(value = "page_size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pagesize,
			@RequestParam(value = "sort_by", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortby,
			@RequestParam(value = "sort_dir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortdir) {
		return postService.findAll(pageno, pagesize, sortby, sortdir);
	}

	@Operation(tags = "Blogs", summary = "Retrieving blog post by post id")
	@GetMapping("/{id}")
	public ResponseEntity<PostDto> findByPostId(@PathVariable long id) {
		return ResponseEntity.ok(postService.findByPostId(id));
	}

	@Operation(tags = "Blogs", summary = "Updating blog post by post id")
	@PutMapping("/{id}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable long id) {
		return ResponseEntity.ok(postService.updatePost(postDto, id));
	}

	@Operation(tags = "Blogs", summary = "Deleting blog post by post id")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePost(@PathVariable long id) {
		return new ResponseEntity<>(postService.deletePost(id), HttpStatus.OK);
	}
}
