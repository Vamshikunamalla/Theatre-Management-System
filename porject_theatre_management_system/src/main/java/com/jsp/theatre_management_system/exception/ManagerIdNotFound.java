package com.jsp.theatre_management_system.exception;

public class ManagerIdNotFound extends RuntimeException {

	private String message="Manager Id Not Found";

	public String getMessage() {
		return message;
	}
	
	
}
