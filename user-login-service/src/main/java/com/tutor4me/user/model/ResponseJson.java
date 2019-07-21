package com.tutor4me.user.model;

public class ResponseJson {
	
	private String message;
	private String status;
	
	public ResponseJson() {
	}
	
	public ResponseJson(String message, String status) {
		super();
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
