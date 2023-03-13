package com.aaludra.restapi.learning;

public class Users {

	private String name;
	private int id;
	private String role;

	@Override
	public String toString() {
		return "Users [name=" + name + ", id=" + id + ", role=" + role + "]";
	}

	public Users(String name, int id, String role) {
		super();
		this.name = name;
		this.id = id;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
