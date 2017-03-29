package com.controller;

import java.util.List;

import com.models.Department;
import com.models.Employee;
import com.models.Employee2;

public class EmployeeController {

	Department d = new Department();

	
	
	public List<Employee> getEmp() {
		HibernateDAO hdao = new HibernateDAO();

		d.setDepartmentID(2);
		Employee2 em = new Employee2();
		em.departmentFK = d;
		
		hdao.initSetup();
		List<Employee> empList = hdao.getAllEmployees();
		return empList;
	}

	public int saveEmp(Employee emp) {
		HibernateDAO hdao = new HibernateDAO();
		hdao.initSetup();
		int a = hdao.addEmployee(emp);
		return a;
	}

}
