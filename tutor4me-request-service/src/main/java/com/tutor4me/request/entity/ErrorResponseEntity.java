package com.tutor4me.request.entity;

import java.util.Date;

public class ErrorResponseEntity {
	private Date timestamp;
	private String message;
	private String details;

	public ErrorResponseEntity(Date timestamp, String message, String details) {
	        super();
	        this.timestamp = timestamp;
	        this.message = message;
	        this.details = details;
	    }

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}
