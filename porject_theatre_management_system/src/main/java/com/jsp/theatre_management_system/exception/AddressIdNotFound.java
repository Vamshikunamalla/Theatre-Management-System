package com.jsp.theatre_management_system.exception;

public class AddressIdNotFound extends RuntimeException{

	private String message="Address Id Not Found";

	public String getMessage() {
		return message;
	}
	
}
