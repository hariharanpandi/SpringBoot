package com.blog.api.payload;

import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostDto {

	
	private long id;
	@NotEmpty
	@Size(min = 3, message = "Post title should have atleast 3 characters")
	private String title;
	@NotEmpty
	@Size(min = 3, message = "Post title should have atleast 3 characters")
	private String content;
	@NotEmpty
	@Size(min = 5, message = "Post title should have atleast 5 characters")
	private String description;
	private Set<CommentDto> comments;

	public Set<CommentDto> getComment() {
		return comments;
	}

	public void setComment(Set<CommentDto> comment) {
		this.comments = comment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
