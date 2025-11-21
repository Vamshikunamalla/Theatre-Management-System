package com.jsp.theatre_management_system.exception;

public class OwnerIdNotFound extends RuntimeException{
	
	private String message="Owner Id Not Found";

	public String getMessage() {
		return message;
	}

}
