package com.tutor4me.uesr.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "student_master")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class StudentMaster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6772878427523797759L;
	
	@Id
	private String studentId;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	
	
	@JsonManagedReference(value = "student_school")
	@ManyToOne
	@JoinColumn(name = "school_id")
	private SchoolMaster schoolMaster;
	
	@JsonManagedReference(value = "student_grade")
	@ManyToOne
	@JoinColumn(name = "grade_id")
	private GradeMaster gradeMaster;
	
	public StudentMaster() {}

	public StudentMaster(String studentId, String firstName, String lastName, String phone, String email,
			SchoolMaster schoolMaster, GradeMaster gradeMaster) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.schoolMaster = schoolMaster;
		this.gradeMaster = gradeMaster;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SchoolMaster getSchoolMaster() {
		return schoolMaster;
	}

	public void setSchoolMaster(SchoolMaster schoolMaster) {
		this.schoolMaster = schoolMaster;
	}

	public GradeMaster getGradeMaster() {
		return gradeMaster;
	}

	public void setGradeMaster(GradeMaster gradeMaster) {
		this.gradeMaster = gradeMaster;
	}
	
}
