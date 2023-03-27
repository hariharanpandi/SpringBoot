package com.blog.api.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.blog.api.payload.ErrorDetails;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ErrorDetails> resourseNotFoundExceptionHandler(ResourceNotFound resourceNotFound,
			WebRequest request) {
		ErrorDetails details = new ErrorDetails(new Date(), resourceNotFound.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BlogApiException.class)
	public ResponseEntity<ErrorDetails> blogApiExceptionHandler(BlogApiException blogApiException, WebRequest request) {
		ErrorDetails details = new ErrorDetails(new Date(), blogApiException.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> globalExceptionhandler(Exception exception, WebRequest request){
		ErrorDetails details= new ErrorDetails(new Date(), exception.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
