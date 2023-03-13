package com.aaludra.restapi.controller;

public class RestEntity {

	private String name;
	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMessage() {
		return name;
	}

	public void setMessage(String message) {
		this.name = message;
		
	}

	public RestEntity(String message, String date) {
		super();
		this.name = message;
		this.date=date;
	}

	@Override
	public String toString() {
		return "RestEntity [name=" + name + ", date=" + date + "]";
	}
	
}
