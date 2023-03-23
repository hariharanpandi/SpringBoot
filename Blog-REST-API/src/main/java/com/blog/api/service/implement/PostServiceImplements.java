package com.blog.api.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.blog.api.bean.Post;
import com.blog.api.exception.ResourceNotFound;
import com.blog.api.payload.PostDto;
import com.blog.api.repository.PostRepository;
import com.blog.api.service.PostServices;

@Service
public class PostServiceImplements implements PostServices {

	private PostRepository postRepository;

	public PostServiceImplements(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}

	private PostDto entityToDto(Post newpost) {
		PostDto response = new PostDto();
		response.setId(newpost.getId());
		response.setTitle(newpost.getTitle());
		response.setDescription(newpost.getDescription());
		response.setContent(newpost.getContent());
		return response;
	}

	private Post dtoToEntity(PostDto postDto) {
		Post post = new Post();
		post.setId(postDto.getId());
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());
		return post;
	}
	
	@Override
	public PostDto createpost(PostDto postDto) {

		Post post = dtoToEntity(postDto);
		Post newpost = postRepository.save(post);

		PostDto response = entityToDto(newpost);
		return response;
	}

	@Override
	public List<PostDto> findAll() {
		List<Post> posts = postRepository.findAll();
		return posts.stream().map(post -> entityToDto(post)).collect(Collectors.toList());
	}

	@Override
	public PostDto findByPostId(long id) {
		Post post =postRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Post","id ", id));
		return entityToDto(post);
	}

}
