package com.jsp.theatre_management_system.exception;

public class FoodIdNotFound extends RuntimeException {

	private String message="Food Id Not Found";

	public String getMessage() {
		return message;
	}
	
	
}
