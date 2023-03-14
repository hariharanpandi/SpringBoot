package com.aaludra.restapi.users;

import java.util.List;

import com.aaludra.restapi.h2database.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Size;

@Entity(name = "users")
public class Users {

	@Size(min = 3, max = 20, message = "name should have atleast 3 characters")
	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "my_entity_seq")
	@SequenceGenerator(name = "my_entity_seq", sequenceName = "my_entity_seq", initialValue = 1004)
	private int id;
	@Size(min = 3, max = 30, message = "role should have atleast 3 characters")
	private String role;
	@OneToMany(mappedBy = "users")
	@JsonIgnore
	private List<Post> post;

	public Users() {

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

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Users [name=" + name + ", id=" + id + ", role=" + role + "]";
	}
}
