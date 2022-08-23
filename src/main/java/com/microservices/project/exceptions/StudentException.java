package com.microservices.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentException{
	
	

	@ExceptionHandler(value=ResourceNotfoundException.class)
	public ResponseEntity<String> exception (ResourceNotfoundException studentNotfoundException) {
		return new ResponseEntity<String>(studentNotfoundException.getMessage(), HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyException(EmptyInputException emptyInputException){
		return new ResponseEntity<String>(emptyInputException.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
}
