package com.jsp.theatre_management_system.exception;

public class PaymentIdNotFound extends RuntimeException {
	private String message="Payment Id Is Not Found";

	public String getMessage() {
		return message;
	}
	

}
