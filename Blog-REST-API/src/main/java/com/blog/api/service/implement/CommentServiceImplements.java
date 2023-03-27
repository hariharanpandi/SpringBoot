package com.blog.api.service.implement;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.blog.api.bean.Comment;
import com.blog.api.bean.Post;
import com.blog.api.exception.BlogApiException;
import com.blog.api.exception.ResourceNotFound;
import com.blog.api.payload.CommentDto;
import com.blog.api.repository.CommentRepository;
import com.blog.api.repository.PostRepository;
import com.blog.api.service.CommentService;

@Service
public class CommentServiceImplements implements CommentService {

	private CommentRepository commentRepository;
	private PostRepository postRepository;
	private ModelMapper mapper;

	public CommentServiceImplements(CommentRepository commentRepository, PostRepository postRepository,
			ModelMapper mapper) {
		this.commentRepository = commentRepository;
		this.postRepository = postRepository;
		this.mapper = mapper;
	}

	private Comment commentDtoToEntity(CommentDto commentDto) {

		return mapper.map(commentDto, Comment.class);
	}

	private CommentDto entityToCommentDto(Comment comment) {
		return mapper.map(comment, CommentDto.class);
	}

	@Override
	public CommentDto createComment(long postid, CommentDto commentDto) {
		Comment comment = commentDtoToEntity(commentDto);

		Post post = postRepository.findById(postid).orElseThrow(() -> new ResourceNotFound("Post", "id ", postid));
		comment.setPost(post);

		Comment newComment = commentRepository.save(comment);
		return entityToCommentDto(newComment);
	}

	@Override
	public List<CommentDto> getbypostid(long postId) {
		List<Comment> comment = commentRepository.findByPostId(postId);
		return comment.stream().map(this::entityToCommentDto).toList();
	}

	@Override
	public CommentDto getByCommentId(long commentId) {

		Comment comment = commentRepository.findById(commentId)
				.orElseThrow(() -> new ResourceNotFound("comment", "id", commentId));
		return entityToCommentDto(comment);
	}

	@Override
	public CommentDto updateComment(long commentId, Long postId, CommentDto commentDto) {

		Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFound("Post", "id", postId));

		Comment comment = commentRepository.findById(commentId)
				.orElseThrow(() -> new ResourceNotFound("Comment", "id", commentId));
		if (comment.getPost().getId() != post.getId()) {
			throw new BlogApiException(HttpStatus.BAD_REQUEST, "comment does not belongs to post");
		}

		comment.setName(commentDto.getName());
		comment.setBody(commentDto.getBody());
		comment.setEmail(commentDto.getEmail());

		Comment updateComment = commentRepository.save(comment);
		return entityToCommentDto(updateComment);
	}

	@Override
	public void deleteComment(long commentId, long postId) {

		Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFound("Post", "id", postId));
		Comment comment = commentRepository.findById(commentId)
				.orElseThrow(() -> new ResourceNotFound("Comment", "id", commentId));
		if (comment.getPost().getId() != post.getId()) {
			throw new BlogApiException(HttpStatus.BAD_REQUEST, "comment does not belongs to post");
		}
		commentRepository.delete(comment);
	}

}
