package com.jsp.theatre_management_system.exception;

public class TicketIdNotFound extends ReviewIdNotFound {
	private String message="Ticket Id Is Not Found";

	public String getMessage() {
		return message;
	}
}
