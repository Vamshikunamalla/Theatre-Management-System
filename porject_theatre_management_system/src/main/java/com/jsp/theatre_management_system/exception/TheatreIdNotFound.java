package com.jsp.theatre_management_system.exception;

public class TheatreIdNotFound extends RuntimeException {

	private String message="Theatre Id Is Not Found";

	public String getMessage() {
		return message;
	}
	
}
