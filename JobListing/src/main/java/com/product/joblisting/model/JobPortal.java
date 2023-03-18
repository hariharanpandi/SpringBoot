package com.product.joblisting.model;

import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Learning")
public class JobPortal {

	private int id;
	private String description;
	private String exprience;
	private String profile;
	private String[] skill;

	public JobPortal(int id, String description, String exprience, String profile, String[] skill) {
		super();
		this.id = id;
		this.description = description;
		this.exprience = exprience;
		this.profile = profile;
		this.skill = skill;
	}

	public JobPortal() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "JobPortal [id=" + id + ", description=" + description + ", exprience=" + exprience + ", profile="
				+ profile + ", skill=" + Arrays.toString(skill) + "]";
	}

}
