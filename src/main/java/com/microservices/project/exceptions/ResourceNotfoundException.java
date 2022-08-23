package com.microservices.project.exceptions;

public class ResourceNotfoundException extends NullPointerException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotfoundException(String Message){
		super(Message);
		
	}

}
