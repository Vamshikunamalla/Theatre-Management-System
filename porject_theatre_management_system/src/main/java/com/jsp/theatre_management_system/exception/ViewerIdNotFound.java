package com.jsp.theatre_management_system.exception;

public class ViewerIdNotFound extends RuntimeException {
	private String message="Viewer Id Is Not Found";

	public String getMessage() {
		return message;
	}
}
