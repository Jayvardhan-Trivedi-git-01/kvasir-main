package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.Employee;


public class viewEmpServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmployeeController ec = new EmployeeController();
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.println("<html><head></head><body>");
		pw.print("Adding an Employee:  <br>");
		
		Employee e1 = new Employee("Elon Musk", 42, 2, 1);
		ec.saveEmp(e1);
		pw.print("List of users : <br>");
		

		List<Employee> empList = ec.getEmp();
		for(int i=0; i<empList.size();i++){
			pw.println(empList.get(i).getName());
			pw.println("<br>");
		}
		
		pw.print("</body></html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
