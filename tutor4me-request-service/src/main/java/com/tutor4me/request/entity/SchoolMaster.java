package com.tutor4me.request.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "school_master")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SchoolMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6594158574605299421L;

	@Id
	private String schoolId;
	private String name;

	//@JsonManagedReference(value = "school-district")
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "district_id")
	private DistrictMaster districtMaster;

	private String email;
	private String phone;

	@JsonBackReference(value = "student_school")
	@OneToMany(mappedBy = "schoolMaster", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<StudentMaster> studentMasterList;

	public SchoolMaster() {
	}

	public SchoolMaster(String schoolId, String name, DistrictMaster districtMaster, String email, String phone,
			List<StudentMaster> studentMasterList) {
		super();
		this.schoolId = schoolId;
		this.name = name;
		this.districtMaster = districtMaster;
		this.email = email;
		this.phone = phone;
		this.studentMasterList = studentMasterList;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DistrictMaster getDistrictMaster() {
		return districtMaster;
	}

	public void setDistrictMaster(DistrictMaster districtMaster) {
		this.districtMaster = districtMaster;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<StudentMaster> getStudentMasterList() {
		return studentMasterList;
	}

	public void setStudentMasterList(List<StudentMaster> studentMasterList) {
		this.studentMasterList = studentMasterList;
	}

}
