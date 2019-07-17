package com.tutor4me.uesr.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "core_subject_master")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CoreSubjectMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1718802539925910087L;

	@Id
	private int coreSubjectId;
	private String coreSubjectName;

	@JsonManagedReference(value = "subt_coresubt")
	@OneToMany(mappedBy = "coreSubjectMaster", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SubjectMaster> SubjectMaster;

	public CoreSubjectMaster() {
	}

	public CoreSubjectMaster(int coreSubjectId, String coreSubjectName) {
		super();
		this.coreSubjectId = coreSubjectId;
		this.coreSubjectName = coreSubjectName;
	}

	public CoreSubjectMaster(int coreSubjectId, String coreSubjectName,
			List<com.tutor4me.uesr.entity.SubjectMaster> subjectMaster) {
		super();
		this.coreSubjectId = coreSubjectId;
		this.coreSubjectName = coreSubjectName;
		SubjectMaster = subjectMaster;
	}

	public int getCoreSubjectId() {
		return coreSubjectId;
	}

	public void setCoreSubjectId(int coreSubjectId) {
		this.coreSubjectId = coreSubjectId;
	}

	public String getCoreSubjectName() {
		return coreSubjectName;
	}

	public void setCoreSubjectName(String coreSubjectName) {
		this.coreSubjectName = coreSubjectName;
	}

	public List<SubjectMaster> getSubjectMaster() {
		return SubjectMaster;
	}

	public void setSubjectMaster(List<SubjectMaster> subjectMaster) {
		SubjectMaster = subjectMaster;
	}

}
