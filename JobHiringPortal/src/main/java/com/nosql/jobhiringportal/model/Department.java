package com.nosql.jobhiringportal.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Department {

	@Field(name = "department_name")
	private String departmentname;
	@Field(name = "department_code")
	private String departmentcode;

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String getDepartmentcode() {
		return departmentcode;
	}

	public void setDepartmentcode(String departmentcode) {
		this.departmentcode = departmentcode;
	}

	@Override
	public String toString() {
		return "Department [departmentname=" + departmentname + ", departmentcode=" + departmentcode + "]";
	}

}
