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
	
}
