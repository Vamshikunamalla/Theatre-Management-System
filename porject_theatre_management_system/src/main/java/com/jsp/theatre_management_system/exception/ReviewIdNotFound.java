package com.jsp.theatre_management_system.exception;

public class ReviewIdNotFound extends RuntimeException {

	public String message="Review Id Is Not Found";

	public String getMessage() {
		return message;
	}
	
}
