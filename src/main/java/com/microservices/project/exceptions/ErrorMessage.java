package com.microservices.project.exceptions;

import java.util.Date;

public class ErrorMessage {
	
	private String message;
	
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorMessage(String message, Date date) {
		super();
		this.message = message;
		this.date = date;
	}

	private Date date;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ErrorMessage [message=" + message + ", date=" + date + "]";
	}
	

}
