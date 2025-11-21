package com.jsp.theatre_management_system.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.theatre_management_system.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@Autowired
	ResponseStructure<String> responseStructure;
	@ExceptionHandler(OwnerIdNotFound.class)
	public ResponseStructure<String> ownerIdNotFound(OwnerIdNotFound ownerIdNotFound) {
		responseStructure.setStatusCoad(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Owner id is not found in db");
		responseStructure.setData(ownerIdNotFound.getMessage());
		return responseStructure;
	}
	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseStructure<String> AddressIdNotFound( AddressIdNotFound addressIdNotFound) {
		responseStructure.setStatusCoad(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Addrees id is not found in db");
		responseStructure.setData(addressIdNotFound.getMessage());
		return responseStructure;
	}
	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseStructure<String> BranchIdNotFound(BranchIdNotFound branchNotFound) {
		responseStructure.setStatusCoad(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("branch id is not found in db");
		responseStructure.setData(branchNotFound.getMessage());
		return responseStructure;
	}
	@ExceptionHandler(FoodIdNotFound.class)
	public ResponseStructure<String> FoodIdNotFound(FoodIdNotFound foodIdNotFound) {
		responseStructure.setStatusCoad(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("food id is not found in db");
		responseStructure.setData(foodIdNotFound.getMessage());
		return responseStructure;
		
	}
	@ExceptionHandler(ManagerIdNotFound.class)
	public ResponseStructure<String> ManagerIdNotFound(ManagerIdNotFound managerIdNotFound) {
		responseStructure.setStatusCoad(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("manager id is not found in db");
		responseStructure.setData(managerIdNotFound.getMessage());
		return responseStructure;
	}
	@ExceptionHandler(MovieIdNotFound.class)
	public ResponseStructure<String> MovieIdNotFound(MovieIdNotFound movieIdNotFound) {
		responseStructure.setStatusCoad(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("movie id is not found in db");
		responseStructure.setData(movieIdNotFound.getMessage());
		return responseStructure;
	}
	@ExceptionHandler(PaymentIdNotFound.class)
	public ResponseStructure<String> PaymentIdNotFound(PaymentIdNotFound paymentIdNotFound) {
		responseStructure.setStatusCoad(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("payment id is not found in db");
		responseStructure.setData(paymentIdNotFound.getMessage());
		return responseStructure;
	}
	@ExceptionHandler(ReviewIdNotFound.class)
	public ResponseStructure<String> ReviewIdNotFound(ReviewIdNotFound reviewIdNotFound) {
		responseStructure.setStatusCoad(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("review id is not found in db");
		responseStructure.setData(reviewIdNotFound.getMessage());
		return responseStructure;
	}
	@ExceptionHandler(SeatIdNotFound.class)
	public ResponseStructure<String> SeatIdNotFound(SeatIdNotFound seatIdNotFound) {
		responseStructure.setStatusCoad(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("seat id is not found in db");
		responseStructure.setData(seatIdNotFound.getMessage());
		return responseStructure;
	}
	@ExceptionHandler(TheatreIdNotFound.class)
		public ResponseStructure<String> TheatreIdNotFound(TheatreIdNotFound theatreIdNotFound) {
		responseStructure.setStatusCoad(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("theatre id is not found in db");
		responseStructure.setData(theatreIdNotFound.getMessage());
		return responseStructure;
	}@ExceptionHandler(TicketIdNotFound.class)
	public ResponseStructure<String>TicketIdNotFound (TicketIdNotFound ticketIdNotFound) {
		responseStructure.setStatusCoad(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("theatre id is not found in db");
		responseStructure.setData(ticketIdNotFound.getMessage());
		return responseStructure;
	}
	@ExceptionHandler(ViewerIdNotFound.class)
	public ResponseStructure<String>ViewerIdNotFound (ViewerIdNotFound viewerIdNotFound) {
		responseStructure.setStatusCoad(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("theatre id is not found in db");
		responseStructure.setData(viewerIdNotFound.getMessage());
		return responseStructure;
	}
	@ExceptionHandler(StaffIdNotFound.class)
	public ResponseStructure<String>StaffIdNotFound (StaffIdNotFound staffIdNotFound) {
		responseStructure.setStatusCoad(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("theatre id is not found in db");
		responseStructure.setData(staffIdNotFound.getMessage());
		return responseStructure;
	}
}
