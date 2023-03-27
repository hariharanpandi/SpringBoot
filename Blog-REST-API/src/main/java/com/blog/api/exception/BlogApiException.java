package com.blog.api.exception;

import org.springframework.http.HttpStatus;

public class BlogApiException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final HttpStatus httpstatus;
	private final String messages;

	public BlogApiException(HttpStatus httpstatus, String message) {
		super();
		this.httpstatus = httpstatus;
		this.messages = message;
	}

	public BlogApiException(String message, HttpStatus httpstatus, String message1) {
		super(message);
		this.httpstatus = httpstatus;
		this.messages = message1;
	}

	public HttpStatus getHttpstatus() {
		return httpstatus;
	}

	public String getMessages() {
		return messages;
	}
}
