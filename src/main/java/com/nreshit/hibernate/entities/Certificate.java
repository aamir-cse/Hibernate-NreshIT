package com.nreshit.hibernate.entities;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_certificate")
public class Certificate {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentcert_seq")
	@SequenceGenerator(name = "studentcert_seq", sequenceName = "studentcert_seq", allocationSize = 1)
	@Column(name = "STUDENT_CERT")
	private long certificateId;
	
	public long getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(long certificateId) {
		this.certificateId = certificateId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	private String title;
	private String about;
	private String link;
	
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;

}
