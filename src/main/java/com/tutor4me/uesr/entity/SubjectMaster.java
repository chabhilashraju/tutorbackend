package com.tutor4me.uesr.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "subject_master")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SubjectMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9027792668863233902L;

	@Id
	private int subjectId;
	private String subjectName;

	@JsonBackReference(value = "subt_coresubt")
	@ManyToOne
	@JoinColumn(name = "core_subject_id")
	private CoreSubjectMaster coreSubjectMaster;

	public SubjectMaster() {
	}

	public SubjectMaster(int subjectId, String subjectName, CoreSubjectMaster coreSubjectMaster) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.coreSubjectMaster = coreSubjectMaster;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public CoreSubjectMaster getCoreSubjectMaster() {
		return coreSubjectMaster;
	}

	public void setCoreSubjectMaster(CoreSubjectMaster coreSubjectMaster) {
		this.coreSubjectMaster = coreSubjectMaster;
	}

}
