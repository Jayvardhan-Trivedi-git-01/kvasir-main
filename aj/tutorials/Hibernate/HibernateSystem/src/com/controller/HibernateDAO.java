package com.controller;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.models.Employee;

public class HibernateDAO {

	private static SessionFactory factory;

	public void initSetup() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println(ex);
			throw new ExceptionInInitializerError(ex);
		}

	}

	public List<Employee> getAllEmployees() {
		Session session = factory.openSession();
		Transaction trans = null;

		trans = session.beginTransaction();
		List employees = session.createQuery("FROM Employee").list();
		trans.commit();
		session.close();
		return employees;

	}

	public int addEmployee(String name, int age, int d_id, int active) {
		Session session = factory.openSession();
		Transaction trans = null;
		int isOK;
		trans = session.beginTransaction();
		Employee employee = new Employee(name, age, d_id, active);
		isOK = (Integer) session.save(employee);
		trans.commit();
		session.close();
		return isOK;	
	}

	public int addEmployee(Employee emp) {
		Session session = factory.openSession();
		Transaction trans = null;
		int isOK;
		trans = session.beginTransaction();
		isOK = (Integer) session.save(emp);
		trans.commit();
		session.close();
		return isOK;	
	}

	public void updateEmployee(Employee emp) {
		Session session = factory.openSession();
		Transaction trans = null;
		trans = session.beginTransaction();
		session.update(emp);
		trans.commit();
		session.close();
	}

	public void addupdateEmployee(Employee emp) {
		Session session = factory.openSession();
		Transaction trans = null;
		trans = session.beginTransaction();
		session.saveOrUpdate(emp);
		trans.commit();
		session.close();
	}
	

}
