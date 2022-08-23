package com.microservices.project.exceptions;

public class EmptyInputException extends RuntimeException{
	
	public EmptyInputException(String message) {
	super(message);
	}

}
