package com.nosql.jobhiringportal.model;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Learning")
public class ListOfJob {

	@Id
	private int id;
	@Field(name = "name")
	private String name;
	private Department department;
	private String description;
	private String exprience;
	private String profile;
	private String[] skill;

	public ListOfJob(int id, String name, Department department, String description, String exprience, String profile,
			String[] skill) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.description = description;
		this.exprience = exprience;
		this.profile = profile;
		this.skill = skill;
	}

	public ListOfJob() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExprience() {
		return exprience;
	}

	public void setExprience(String exprience) {
		this.exprience = exprience;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String[] getSkill() {
		return skill;
	}

	public void setSkill(String[] skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "ListOfJob [id=" + id + ", name=" + name + ", department=" + department + ", description=" + description
				+ ", exprience=" + exprience + ", profile=" + profile + ", skill=" + Arrays.toString(skill) + "]";
	}

}
