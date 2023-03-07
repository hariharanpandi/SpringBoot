package com.example.course.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "COURSE")
public class AaludraCourse {

	@Id
	@GeneratedValue
	private long id;
	
	//@Column(name="course_name")
	private String name;

	private String author;

	public AaludraCourse(long id, String name, String author) {
		this.id = id;
		this.name = name;
		this.author = author;
	}
	
	public AaludraCourse() {
		
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

}
