package com.hcl.swipe.exception;

public class EmployeeNotFoundException extends Exception {
		String message;

	public EmployeeNotFoundException(String message) {
		super();
		this.message = message;
	}

	public EmployeeNotFoundException() {
		super();
	}
	
}
