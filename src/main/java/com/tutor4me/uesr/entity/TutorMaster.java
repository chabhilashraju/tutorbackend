package com.tutor4me.uesr.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tutor_master")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TutorMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7871762933356170550L;

	@Id
	private String tutorId;
	private String firstName;
	private String lastName;
	private String tutorType;
	private String phone;
	private String email;
	private String biography;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tutor_subject", joinColumns = { @JoinColumn(name = "tutorId") }, inverseJoinColumns = {
			@JoinColumn(name = "subject_id") })
	private List<SubjectMaster> subjectMasterList;

	@OneToOne
	@JoinColumn(name = "student_id")
	private StudentMaster studentMaster;

	public TutorMaster() {
	}

	public TutorMaster(String tutorId, String firstName, String lastName, String tutorType, String phone, String email,
			String biography, StudentMaster studentMaster) {
		super();
		this.tutorId = tutorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.tutorType = tutorType;
		this.phone = phone;
		this.email = email;
		this.biography = biography;
		this.studentMaster = studentMaster;
	}

	public String getTutorId() {
		return tutorId;
	}

	public void setTutorId(String tutorId) {
		this.tutorId = tutorId;
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

	public String getTutorType() {
		return tutorType;
	}

	public void setTutorType(String tutorType) {
		this.tutorType = tutorType;
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

	public StudentMaster getStudentMaster() {
		return studentMaster;
	}

	public void setStudentMaster(StudentMaster studentMaster) {
		this.studentMaster = studentMaster;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public List<SubjectMaster> getSubjectMasterList() {
		return subjectMasterList;
	}

	public void setSubjectMasterList(List<SubjectMaster> subjectMasterList) {
		this.subjectMasterList = subjectMasterList;
	}

}
