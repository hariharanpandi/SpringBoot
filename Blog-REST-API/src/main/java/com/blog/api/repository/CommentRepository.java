package com.blog.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.api.bean.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByPostId(long postId);
}
