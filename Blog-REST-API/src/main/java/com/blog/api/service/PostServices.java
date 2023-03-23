package com.blog.api.service;

import java.util.List;

import com.blog.api.payload.PostDto;

public interface PostServices {

	// post
	PostDto createpost(PostDto postDto);

	// get all post
	List<PostDto> findAll();

	// get by id
	PostDto findByPostId(long id);
}
