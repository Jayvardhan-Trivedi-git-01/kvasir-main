package com.database;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import com.models.Employee;

public class DAO {
	String driverString = "com.mysql.jdbc.Driver";
	String dbConString = "jdbc:mysql://localhost:3306/mycollegedatabase";
	String username = "root";
	String password = "admin";

	Connection con;

	public void connect() {
		try {
			Class.forName(driverString);
			con = DriverManager.getConnection(dbConString, username, password);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public int updateEmployee(Employee e){
		Statement stmt;
		try {
			stmt = con.createStatement();
			int rowsAffected = 
					stmt.executeUpdate
					("update  employee set " +
							" employee.employee_name =\"" 
							+ e.name + 
							"\", employee.employee_department = "
							+ e.departmentID + 
							", employee.employee_age = "
							+ e.age + 
							", employee.employee_isactive = "
							+ e.isActive + 
							" where idemployee = " + e.id);
			
			return rowsAffected;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
	public Employee getEmployeeBasedOnID(Employee e){
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select  * from employee where idemployee = " + e.id);
			while(rs.next()){
				e.name = rs.getString("employee_name");
				e.age= rs.getInt("employee_age");
				e.departmentID =  rs.getInt("employee_department");
				e.isActive =  rs.getInt("employee_isactive");				
			}
			return e;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
	
	public List<Employee> getAllData_employee() {
		Statement stmt;
		LinkedList<Employee> listEmp = new LinkedList<Employee>();
			
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee");
			while(rs.next()){
				Employee e1 = new Employee();
				e1.id = rs.getInt("idemployee");
				e1.name = rs.getString("employee_name");
				e1.age= rs.getInt("employee_age");
				e1.departmentID =  rs.getInt("employee_department");
				e1.isActive =  rs.getInt("employee_isactive");	
				listEmp.add(e1);
			}
			return listEmp;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ResultSet getAllData_department() {
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from department");
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int deleteEmployee(Employee e) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			int rowsAffected = stmt.executeUpdate("delete from employee where idemployee = " + e.id);
			return rowsAffected;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return -1;
		}
	}

	public int insertEmployee(Employee e) {

		Statement stmt;
		try {
			stmt = con.createStatement();
			int rowsAffected = stmt
					.executeUpdate("insert into employee " + "(employee.employee_name, employee.employee_department,"
							+ "employee.employee_age,employee.employee_isactive)" + " values " + "( \"" + e.name + "\","
							+ e.departmentID + "," + e.age + "," + e.isActive + ");");
			return rowsAffected;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return -1;
		}

	}

	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
