package com.jsp.theatre_management_system.exception;

public class BranchIdNotFound extends RuntimeException {

	private String message="Branch Id Not Found";

	public String getMessage() {
		return message;
	}
	
	
}
