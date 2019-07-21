package com.tutor4me.request.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

	//@JsonBackReference(value = "tutor-subjects")
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, mappedBy = "subjectMasterSet")
	private Set<TutorMaster> tutorMasterSet = new HashSet<>();

	public SubjectMaster() {
	}

	public SubjectMaster(int subjectId, String subjectName, CoreSubjectMaster coreSubjectMaster,
			Set<TutorMaster> tutorMasterSet) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.coreSubjectMaster = coreSubjectMaster;
		this.tutorMasterSet = tutorMasterSet;
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

	public Set<TutorMaster> getTutorMasterSet() {
		return tutorMasterSet;
	}

	public void setTutorMasterSet(Set<TutorMaster> tutorMasterSet) {
		this.tutorMasterSet = tutorMasterSet;
	}

}
