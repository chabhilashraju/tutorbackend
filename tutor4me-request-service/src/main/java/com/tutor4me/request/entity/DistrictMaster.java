package com.tutor4me.request.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "district_master")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class DistrictMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1550328688373297414L;

	@Id
	private int districtId;
	private String name;

	//@JsonBackReference(value = "school-district")
	@JsonIgnore
	@OneToMany(mappedBy = "districtMaster", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SchoolMaster> schoolMasterList = new ArrayList<SchoolMaster>();

	public DistrictMaster() {
	}

	public DistrictMaster(int districtId, String name) {
		super();
		this.districtId = districtId;
		this.name = name;
	}

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SchoolMaster> getSchoolMasterList() {
		return schoolMasterList;
	}

	public void setSchoolMasterList(List<SchoolMaster> schoolMasterList) {
		this.schoolMasterList = schoolMasterList;
	}

}
