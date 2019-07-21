package com.tutor4me.user.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "subject_grade")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SubjectGrade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3593931000550848089L;

	@Id
	private int subjectGradeId;

	@JsonBackReference(value = "subt_grade")
	@ManyToOne
	@JoinColumn(name = "grade_id")
	private GradeMaster gradeMaster;

	@OneToOne
	@JoinColumn(name = "subject_id")
	private SubjectMaster subjectMaster;

	public SubjectGrade() {
	}

	public SubjectGrade(int subjectGradeId, GradeMaster gradeMaster, SubjectMaster subjectMaster) {
		super();
		this.subjectGradeId = subjectGradeId;
		this.gradeMaster = gradeMaster;
		this.subjectMaster = subjectMaster;
	}

	public int getSubjectGradeId() {
		return subjectGradeId;
	}

	public void setSubjectGradeId(int subjectGradeId) {
		this.subjectGradeId = subjectGradeId;
	}

	public GradeMaster getGradeMaster() {
		return gradeMaster;
	}

	public void setGradeMaster(GradeMaster gradeMaster) {
		this.gradeMaster = gradeMaster;
	}

	public SubjectMaster getSubjectMaster() {
		return subjectMaster;
	}

	public void setSubjectMaster(SubjectMaster subjectMaster) {
		this.subjectMaster = subjectMaster;
	}

}
