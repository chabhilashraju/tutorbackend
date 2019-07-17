package com.tutor4me.uesr.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_login")
public class UserLogin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3721193609500927454L;

	@Id
	private String userName;
	private String password;
	private String masterId;
	private String masterType;
	private Date createdDate;

	public UserLogin() {
	}

	public UserLogin(String userName, String password, String masterId, String masterType, Date createdDate) {
		super();
		this.userName = userName;
		this.password = password;
		this.masterId = masterId;
		this.masterType = masterType;
		this.createdDate = createdDate;
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

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public String getMasterType() {
		return masterType;
	}

	public void setMasterType(String masterType) {
		this.masterType = masterType;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
