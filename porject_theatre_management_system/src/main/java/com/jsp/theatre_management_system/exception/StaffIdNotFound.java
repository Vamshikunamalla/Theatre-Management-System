package com.jsp.theatre_management_system.exception;

public class StaffIdNotFound extends RuntimeException  {
	private String message="Staff Id Is Not Found";

	public String getMessage() {
		return message;
	}
}
