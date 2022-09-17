package com.microservices.project.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentException{
	
	
  
	@ExceptionHandler(value=ResourceNotfoundException.class)
	public ResponseEntity<ErrorMessage> exception (ResourceNotfoundException studentNotfoundException) {
		
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(studentNotfoundException.getMessage(), new Date()), HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyException(EmptyInputException emptyInputException){
		return new ResponseEntity<String>(emptyInputException.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorMessage> handleRunTimeException(RuntimeException RuntimeException){
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(RuntimeException.getMessage(),new Date()), HttpStatus.BAD_REQUEST);
	}
}
