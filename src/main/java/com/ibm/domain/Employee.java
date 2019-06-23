package com.ibm.domain;

public class Employee {
	private String id;
	private String name;
	private String location;
	private String role;
	private String department;
	private String interests;

	public Employee(String id, String name, String location, String role, String department, String interests) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.role = role;
		this.department = department;
		this.interests = interests;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", location=" + location + ", role=" + role + ", department="
				+ department + ", interests=" + interests + "]";
	}

}
