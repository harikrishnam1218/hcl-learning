package com.hcl.swipe.exception;

public class EmployeeNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
		String message;

	public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	public EmployeeNotFoundException(String message) {
		super();
		this.message = message;
	}

	public EmployeeNotFoundException() {
		super();
	}
	
}
