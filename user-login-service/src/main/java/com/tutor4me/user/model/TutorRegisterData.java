package com.tutor4me.user.model;

import java.util.HashSet;
import java.util.Set;

import com.tutor4me.user.entity.StudentMaster;
import com.tutor4me.user.entity.SubjectMaster;
import com.tutor4me.user.entity.TutorMaster;

public class TutorRegisterData {

	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String mobile;
	private String tutortype;
	private String email;
	private String biography;
	private String masterType;

	private StudentMaster studentMaster;
	private Set<SubjectMaster> subjectMasterSet = new HashSet<>();

	public TutorRegisterData() {
	}

	public TutorRegisterData(String userName, String password, String firstName, String lastName, String mobile,
			String tutortype, String email, String biography, String masterType, StudentMaster studentMaster,
			Set<SubjectMaster> subjectMasterSet) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.tutortype = tutortype;
		this.email = email;
		this.biography = biography;
		this.masterType = masterType;
		this.studentMaster = studentMaster;
		this.subjectMasterSet = subjectMasterSet;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTutortype() {
		return tutortype;
	}

	public void setTutortype(String tutortype) {
		this.tutortype = tutortype;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getMasterType() {
		return masterType;
	}

	public void setMasterType(String masterType) {
		this.masterType = masterType;
	}

	public StudentMaster getStudentMaster() {
		return studentMaster;
	}

	public void setStudentMaster(StudentMaster studentMaster) {
		this.studentMaster = studentMaster;
	}

	public Set<SubjectMaster> getSubjectMasterSet() {
		return subjectMasterSet;
	}

	public void setSubjectMasterSet(Set<SubjectMaster> subjectMasterSet) {
		this.subjectMasterSet = subjectMasterSet;
	}

}
