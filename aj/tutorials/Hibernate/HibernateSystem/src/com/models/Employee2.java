package com.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee2 {

	@Column(name = "employee_name")
	public String name;
	
	@Id
	@Column(name = "idemployee")
	@GeneratedValue
	public int id;
	
	@Column(name = "employee_age")
	public int age;
	
	@Column(name = "employee_department")
	public int departmentID;
	
	@Column(name = "employee_isactive")
	public int isActive;
	
	//for one2one shared PK
	@OneToOne(cascade = CascadeType.MERGE)
	@PrimaryKeyJoinColumn
	public Department department;
	
	
	//121 FK
	@OneToOne
	@MapsId
	@JoinColumn(name = "iddepartment")
	public Department departmentFK;
	
	
	//m21 Join Table
	@ManyToOne
	@JoinColumn(name = "iddepartment")
	public List<Department> departmentMO;
	
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

	
	
}
