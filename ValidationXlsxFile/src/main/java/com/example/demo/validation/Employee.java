package com.example.demo.validation;

public enum Employee {
	GRADEA("A", 1000, 30000), GRADEB("B", 30001, 75000), GRADEC("C", 75001, 500000);

	private String grade;

	public String getGrade() {
		return grade;
	}

	public int getMinSalary() {
		return minSalary;
	}

	public int getMaxSalary() {
		return maxSalary;
	}

	private int minSalary;
	private int maxSalary;

	Employee(String grade, int minSalary, int maxSalary) {
		this.grade = grade;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}
}
