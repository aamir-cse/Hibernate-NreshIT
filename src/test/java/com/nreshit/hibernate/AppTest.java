package com.nreshit.hibernate;

import com.nreshit.hibernate.entities.Student;

import junit.framework.TestCase;


public class AppTest 
    extends TestCase
{
	
	StudentService studentService = new StudentService();
	
	public void getStudentTest() {

	    Student s = studentService.getById(37);
	    System.out.println(s.getName());
	    System.out.println(s.getCollege());
	    System.out.println(s.getCertificates());

	    
	}
}
