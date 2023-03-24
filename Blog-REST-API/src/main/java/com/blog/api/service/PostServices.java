package com.blog.api.service;

import com.blog.api.payload.PageResponse;
import com.blog.api.payload.PostDto;

public interface PostServices {

	// post
	PostDto createpost(PostDto postDto);

	// get all post
	PageResponse findAll(int pageno, int pagesize, String sortby, String sortdir);

	// get by id
	PostDto findByPostId(long id);
	
	// update
	PostDto updatePost(PostDto postDto, long id);
	
	//delete
	String deletePost(long id);
	
}
