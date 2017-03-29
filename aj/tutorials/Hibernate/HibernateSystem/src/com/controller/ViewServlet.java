package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.models.Employee;

public class ViewServlet extends HttpServlet {

	private static SessionFactory factory;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		pw.println("<html><head></head><body>");

		try {
			factory = new Configuration().configure().buildSessionFactory();

			Session session = factory.openSession();
			Transaction trans = null;

			// GET ALL EMP
			trans = session.beginTransaction();
			List<Employee> emp = session.createQuery("FROM Employee").list();
			trans.commit();

			for (int i = 0; i < emp.size(); i++) {
				pw.println("Name : " + emp.get(i).getName());
				pw.println("<br>");
			}

			// ADD EMPLoyeE
			Transaction trans1 = null;
			trans1 = session.beginTransaction();
			Employee employee = new Employee("Jay888", 99, 1, 1);
			int isOK = (Integer) session.save(employee);
			trans1.commit();

			//
			// //Update Employee
			Transaction trans2 = null;
			session = null;
			session = factory.openSession();
			trans2 = session.beginTransaction();
			Employee emp1 = new Employee();
			emp1.setId(4);
			emp1.setName("Albert");
			emp1.setAge(58);
			emp1.setDepartmentID(1);
			emp1.setIsActive(0);
			session.update(emp1);
			trans2.commit();
			//
			//
			// //Delete
			Transaction trans3 = null;
			trans3 = session.beginTransaction();
			Employee emp2 = new Employee();
			emp2.setId(16);
			session.delete(emp2);
			trans3.commit();
			//
			//
			//
			//
			//
			// HQL
			pw.println("---HQL--");
			Transaction trans4 = null;
			trans4 = session.beginTransaction();
			List<Employee> emp_hql = session.createQuery("FROM Employee as em where em.isActive = 1").list();
			for (int i = 0; i < emp_hql.size(); i++) {
				pw.println("Name : " + emp_hql.get(i).getName());
				pw.println("<br>");
			}
			trans4.commit();
		} catch (Throwable ex) {
			System.err.println(ex);
			throw new ExceptionInInitializerError(ex);
		}

		pw.print("</body></html>");

	}

}
