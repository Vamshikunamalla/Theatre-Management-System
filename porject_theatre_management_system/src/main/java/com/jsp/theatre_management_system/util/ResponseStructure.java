package com.jsp.theatre_management_system.util;

import org.springframework.stereotype.Component;

@Component
public class ResponseStructure <T>{
	private int StatusCoad;
	private String message;
	private T data;
	public int getStatusCoad() {
		return StatusCoad;
	}
	public void setStatusCoad(int statusCoad) {
		StatusCoad = statusCoad;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
	
	

}
