package com.blog.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String resourcename;
	private final String fieldname;
	private final long fieldvalue;

	public ResourceNotFound(String resourcename, String fieldname, long fieldvalue) {
		super(String.format("%s not found with %s :'%s'", resourcename, fieldname, fieldvalue));
		this.resourcename = resourcename;
		this.fieldname = fieldname;
		this.fieldvalue = fieldvalue;
	}

	public String getResourcename() {
		return resourcename;
	}

	public String getFieldname() {
		return fieldname;
	}

	public long getFieldvalue() {
		return fieldvalue;
	}
}
