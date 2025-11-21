package com.jsp.theatre_management_system.exception;

public class SeatIdNotFound extends RuntimeException{
	private String message="Seat Id Not Found";

	public String getMessage() {
		return message;
	}
	
	

}