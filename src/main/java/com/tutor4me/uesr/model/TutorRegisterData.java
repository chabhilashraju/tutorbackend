package com.tutor4me.uesr.model;

public class TutorRegisterData {

	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String mobile;
	private String tutortype;
	private String email;
	private String studentId;
	private String biography;
	private String masterType;
	private int coreSubjectId;
	private int subjectId[];

	public TutorRegisterData() {
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

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public int getCoreSubjectId() {
		return coreSubjectId;
	}

	public void setCoreSubjectId(int coreSubjectId) {
		this.coreSubjectId = coreSubjectId;
	}

	public int[] getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int[] subjectId) {
		this.subjectId = subjectId;
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

	public String getMasterType() {
		return masterType;
	}

	public void setMasterType(String masterType) {
		this.masterType = masterType;
	}

}
