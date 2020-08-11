package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	//add exception handling code here
	
	//the code that was in the controller now is centralized here, so that if there are exceptions in various controllers
	//there won't be code duplication, so it's global
	
	//Actually we have throw the exception but not added something to handle it, whis is why we have to set up some 
	//@ExceptionHandler so that we can handle it
	//Here in this following code we are saying that this code can catch StudentNotFoundExceptions
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException (StudentNotFoundException exc) {
		
		//create a StudentErrorResponse
		
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	//Add another exception handler, we can do this for wny type of exception that is being thrown
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException (Exception exc) {
		
		
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
}
