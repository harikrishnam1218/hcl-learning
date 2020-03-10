package com.hcl.swipe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@RestControllerAdvice
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler {
	
@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(EmployeeNotFoundException exception){
		ErrorResponse er=new ErrorResponse();
		er.setCode("EMP-400");
		er.setMessgae(exception.getMessage());
		return new ResponseEntity(er,HttpStatus.BAD_REQUEST);
	}
}
