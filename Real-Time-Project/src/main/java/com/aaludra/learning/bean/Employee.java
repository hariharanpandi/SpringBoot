package com.aaludra.learning.bean;

public class Employee {

	private int id;
	private String name;
	private String empcode;
	private String domain;

	public Employee(int id, String name, String empcode, String domain) {
		this.id = id;
		this.name = name;
		this.empcode = empcode;
		this.domain = domain;
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

	public String getEmpcode() {
		return empcode;
	}

	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

}
