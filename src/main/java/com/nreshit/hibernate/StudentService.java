package com.nreshit.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import com.nreshit.hibernate.entities.Student;
import com.nreshit.hibernate.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;



public class StudentService {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	// Save
	public void saveStudent(Student student) {
		try (Session session = sessionFactory.openSession()) {

			Transaction beginTransaction = session.beginTransaction();
			session.persist(student);
			beginTransaction.commit();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public Student getById(long studentId) {
		try (Session session = sessionFactory.openSession()) {

			Student student = session.get(Student.class, studentId);
			return student;

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}

	//Update
	public Student updateStudent(long studentId, Student student) {
		try (Session session = sessionFactory.openSession()) {

			Transaction transaction = session.beginTransaction();

			Student oldStudent = session.get(Student.class, studentId);

			if (oldStudent != null) {
				oldStudent.setName(student.getName());
				oldStudent.setCollege(student.getCollege());
				oldStudent = session.merge(oldStudent);
			}
			transaction.commit();
			return oldStudent;

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}
	
	//delete Student
	public void deleteStudent(long studentId)
	{
		try(Session session = sessionFactory.openSession())
		{
			Transaction transaction = session.beginTransaction();
			Student student = session.get(Student.class, studentId);
			if(student != null)
			{
				session.remove(student);
			}
			transaction.commit();
		}
	}
	
	//HQL[JPA] --> native query
	//Database independent 
	
	//get all student using hql
	public List<Student> getAllStudentsHQL(){
		try(Session session = sessionFactory.openSession())
		{
			String getHQL = "FROM Student";
			Query<Student> query = session.createQuery(getHQL,Student.class);
			return query.list();
			
		}
		
	}
	
	//get student by name
	public Student getStudentByNameHQL(String name)
	{
		try(Session session = sessionFactory.openSession())
		{
			String getByNameHql ="FROM Student WHERE name = :studentName";
			//Dynamic query
			Query<Student> query = session.createQuery(getByNameHql,Student.class);
			query.setParameter("studentName", name); 
			return query.uniqueResult();
			
		}
	}
	
	//criteria api : 
	//get all student of same college
	
   public List<Student> getStudentByCollegeCriteria(String college)
   {
	   try(Session session = sessionFactory.openSession())
		{
		    HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		    CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
		    Root<Student> root = query.from(Student.class);
		    query.select(root).where(criteriaBuilder.equal(root.get("college"), college));
		    Query<Student> query2 = session.createQuery(query);
		    return query2.getResultList();
		}
   } 
   
   
   
   public List<Student> getStudentWithPagination(int pageNo , int pageSize)
   {
	   try(Session session = sessionFactory.openSession())
		{
		   String pagiQuery = "FROM Student";
		   Query<Student> query = session.createQuery(pagiQuery,Student.class);
		   query.setFirstResult((pageNo-1)*pageSize);
		   query.setMaxResults(pageSize);
		   
		   return query.list();
		   
		}
   }
   

}
