package com.homeloan.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandller {

	@ExceptionHandler(InvalidLoginException.class)
	public ResponseEntity<String> responceForInvalidLogin(InvalidLoginException in){
		
		return   new ResponseEntity<String>(in.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidApplication.class)
	public ResponseEntity<String> invlidApp(InvalidApplication in){
		
		return   new ResponseEntity<String>(in.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidEnquiry.class)
	public ResponseEntity<String> invalidEnquiry(InvalidEnquiry in){
		
		return   new ResponseEntity<String>(in.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidEmailAddress.class)
	public ResponseEntity<String> invalidEmail(InvalidEmailAddress in){
		
		return   new ResponseEntity<String>(in.getMessage(), HttpStatus.BAD_REQUEST);
		
	} 
	
	@ExceptionHandler(InvalidIdClassException.class)
	public ResponseEntity<String> invalidclass(InvalidIdClassException in){
		
		return   new ResponseEntity<String>(in.getMessage(), HttpStatus.BAD_REQUEST);
		
	} 
	
	
	
	
	
	
}
