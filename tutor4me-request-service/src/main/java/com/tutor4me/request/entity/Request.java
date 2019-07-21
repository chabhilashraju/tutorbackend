package com.tutor4me.request.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "request")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Request implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1175318210245585932L;

	@Id
	private String requestId;

	private String requestBody;
	private String requestType;
	private String priority;
	private String status;

	@Column(name="available_date")
	@JsonFormat
	  (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd 'T'HH:mm:ss'Z'")
	//@JsonFormat(pattern="yyyy-MM-dd 'T'HH:mm:ss")
	private String availableDate;
	
	private String startTime;
	private String endTime;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdDate = LocalDateTime.now();

	@OneToOne
	@JoinColumn(name = "subject_id")
	private SubjectMaster subjectMaster;

	@JsonBackReference(value = "studentmaster-request")
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="student_id")
	private StudentMaster studentMaster;

	@JsonManagedReference(value = "request-comment")
	@OneToMany(mappedBy = "request")
	private Set<Comment> commentSet;
	
	public Request() {
	}

	public Request(String requestId, String requestBody, String requestType, String priority, String status,
			String availableDate, String startTime, String endTime, LocalDateTime createdDate,
			SubjectMaster subjectMaster, StudentMaster studentMaster, Set<Comment> commentSet) {
		super();
		this.requestId = requestId;
		this.requestBody = requestBody;
		this.requestType = requestType;
		this.priority = priority;
		this.status = status;
		this.availableDate = availableDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.createdDate = createdDate;
		this.subjectMaster = subjectMaster;
		this.studentMaster = studentMaster;
		this.commentSet = commentSet;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(String availableDate) {
		this.availableDate = availableDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public SubjectMaster getSubjectMaster() {
		return subjectMaster;
	}

	public void setSubjectMaster(SubjectMaster subjectMaster) {
		this.subjectMaster = subjectMaster;
	}

	public StudentMaster getStudentMaster() {
		return studentMaster;
	}

	public void setStudentMaster(StudentMaster studentMaster) {
		this.studentMaster = studentMaster;
	}

	public Set<Comment> getCommentSet() {
		return commentSet;
	}

	public void setCommentSet(Set<Comment> commentSet) {
		this.commentSet = commentSet;
	}


}
