package com.blog.api.service.implement;

import java.util.List;

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
