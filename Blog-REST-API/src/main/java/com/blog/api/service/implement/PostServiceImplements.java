package com.blog.api.service.implement;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.blog.api.bean.Post;
import com.blog.api.exception.ResourceNotFound;
import com.blog.api.payload.PageResponse;
import com.blog.api.payload.PostDto;
import com.blog.api.repository.PostRepository;
import com.blog.api.service.PostServices;

@Service
public class PostServiceImplements implements PostServices {

	private PostRepository postRepository;
	private ModelMapper mapper;

	public PostServiceImplements(PostRepository postRepository, ModelMapper mapper) {
		super();
		this.postRepository = postRepository;
		this.mapper=mapper;
	}

	private PostDto entityToDto(Post newpost) {
		return mapper.map(newpost, PostDto.class);
	}

	private Post dtoToEntity(PostDto postDto) {
		return mapper.map(postDto, Post.class);
	}

	@Override
	public PostDto createpost(PostDto postDto) {

		Post post = dtoToEntity(postDto);
		Post newpost = postRepository.save(post);
		return entityToDto(newpost);
	}

	@Override
	public PageResponse findAll(int pageno, int pagesize, String sortby, String sortdir) {

		
		Sort sort = sortdir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortby).ascending()
				: Sort.by(sortby).descending();
		Pageable pageable = PageRequest.of(pageno, pagesize, sort);
		Page<Post> posts = postRepository.findAll(pageable);
		List<Post> listpost = posts.getContent();
		List<PostDto> content = listpost.stream().map(this::entityToDto).toList();
		PageResponse pageResponse = new PageResponse();
		pageResponse.setContent(content);
		pageResponse.setPageNo(posts.getNumber());
		pageResponse.setPageSize(posts.getSize());
		pageResponse.setTotalElements(posts.getTotalElements());
		pageResponse.setTotalpages(posts.getTotalPages());
		pageResponse.setLastPage(posts.isLast());
		return pageResponse;
	}

	@Override
	public PostDto findByPostId(long id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Post", "id ", id));
		return entityToDto(post);
	}

	@Override
	public PostDto updatePost(PostDto postDto, long id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Post", "id ", id));
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());
		Post response = postRepository.save(post);
		return entityToDto(response);
	}

	@Override
	public String deletePost(long id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Post", "id", id));
		postRepository.delete(post);
		return "Deleted successfully";
	}

}
