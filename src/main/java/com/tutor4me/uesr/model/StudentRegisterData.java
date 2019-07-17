package com.tutor4me.uesr.model;

public class StudentRegisterData {

	private String userName;
	private String password;
	private String masterType;
	private String studentId;
	private int coreSubjId;
	private int subjId;
	private String otherAreas;

	public StudentRegisterData() {
	}

	public StudentRegisterData(String userName, String password, int coreSubjId, int subjId, String otherAreas) {
		super();
		this.userName = userName;
		this.password = password;
		this.coreSubjId = coreSubjId;
		this.subjId = subjId;
		this.otherAreas = otherAreas;
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

	public int getCoreSubjId() {
		return coreSubjId;
	}

	public void setCoreSubjId(int coreSubjId) {
		this.coreSubjId = coreSubjId;
	}

	public int getSubjId() {
		return subjId;
	}

	public void setSubjId(int subjId) {
		this.subjId = subjId;
	}

	public String getOtherAreas() {
		return otherAreas;
	}

	public void setOtherAreas(String otherAreas) {
		this.otherAreas = otherAreas;
	}

	public String getMasterType() {
		return masterType;
	}

	public void setMasterType(String masterType) {
		this.masterType = masterType;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

}
