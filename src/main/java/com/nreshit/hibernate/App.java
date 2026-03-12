package com.nreshit.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nreshit.hibernate.entities.Certificate;
import com.nreshit.hibernate.entities.Student;
import com.nreshit.hibernate.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Student student = new Student();
		student.setName("Shaikh Aamir");
		student.setCollege("UP");
		student.setActive(true);
		student.setPhone("6200305153");
		student.setAbout("This is dummy student");
		student.setFaterhName("Rahul verma");

		Certificate certificate1 = new Certificate();
		certificate1.setTitle("Java Certification");
		certificate1.setAbout("This is java certificate");
		certificate1.setLink("link");
		certificate1.setStudent(student);

		Certificate certificate2 = new Certificate();
		certificate2.setTitle("Python Certification");
		certificate2.setAbout("This is python certificate");
		certificate2.setLink("link");
		certificate2.setStudent(student);

		student.getCertificates().add(certificate1);
		student.getCertificates().add(certificate2);

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
