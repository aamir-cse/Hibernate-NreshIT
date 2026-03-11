package com.nreshit.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nreshit.hibernate.entities.Student;
import com.nreshit.hibernate.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Student student = new Student();
		student.setName("Ankit Kumar");

		student.setCollege("IIT Kanpur");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.persist(student);
			transaction.commit();
			System.out.println("Student data saved successfully");

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

	}
}
