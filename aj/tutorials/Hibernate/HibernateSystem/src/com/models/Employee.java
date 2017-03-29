package com.models;

public class Employee {

	public String name;
	public int id;
	public int age;
	public int departmentID;
	public int isActive;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public Employee(){}
	public Employee(String name, int age, int d_id, int isAct) {
	      this.name = name;
	      this.age = age;
	      this.departmentID = d_id;
	      this.isActive = isAct;
	   }
}
