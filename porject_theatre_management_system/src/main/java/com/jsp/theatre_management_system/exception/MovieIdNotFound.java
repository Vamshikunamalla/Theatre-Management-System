package com.jsp.theatre_management_system.exception;

public class MovieIdNotFound extends RuntimeException {
	private String message="Movie Id Is Not Found";

	public String getMessage() {
		return message;
	}
	

}
