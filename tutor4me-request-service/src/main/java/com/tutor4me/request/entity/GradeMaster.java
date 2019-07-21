package com.tutor4me.request.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "grade_master")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class GradeMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -408798289018870058L;

	@Id
	private int gradeId;
	private String gradeName;

	@JsonBackReference(value = "student_grade")		
	@OneToOne(mappedBy = "gradeMaster")
	private StudentMaster studentMaster;

	@JsonManagedReference(value = "subt_grade")
	@OneToMany(mappedBy = "gradeMaster", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SubjectGrade> subjectGrade;

	public GradeMaster() {
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}	

	public StudentMaster getStudentMaster() {
		return studentMaster;
	}

	public void setStudentMaster(StudentMaster studentMaster) {
		this.studentMaster = studentMaster;
	}

	public List<SubjectGrade> getSubjectGrade() {
		return subjectGrade;
	}

	public void setSubjectGrade(List<SubjectGrade> subjectGrade) {
		this.subjectGrade = subjectGrade;
	}

	
}
