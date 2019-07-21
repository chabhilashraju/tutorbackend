package com.tutor4me.request.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "comment")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2569738353699158981L;

	@Id
	private String commentId;

	private String commentText;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdDate = LocalDateTime.now();

	@JsonBackReference(value = "request-comment")
	@ManyToOne
	@JoinColumn(name = "request_id")	
	private Request request;

	@JsonBackReference(value = "comment-tutor")
	@OneToOne
	@JoinColumn(name = "tutor_id")
	private TutorMaster tutorMaster;

	public Comment() {
	}

	public Comment(String commentId, String commentText, LocalDateTime createdDate, Request request,
			TutorMaster tutorMaster) {
		super();
		this.commentId = commentId;
		this.commentText = commentText;
		this.createdDate = createdDate;
		this.request = request;
		this.tutorMaster = tutorMaster;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public TutorMaster getTutorMaster() {
		return tutorMaster;
	}

	public void setTutorMaster(TutorMaster tutorMaster) {
		this.tutorMaster = tutorMaster;
	}

}
