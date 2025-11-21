package com.jsp.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.theatre_management_system.dto.Payment;
import com.jsp.theatre_management_system.dto.Ticket;
import com.jsp.theatre_management_system.service.PaymentService;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;

@RestController
public class PaymentController {
	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/savePayment")
	        public ResponseStructure<Payment> savePayment(@RequestBody Payment Payment) {
			return	 paymentService.savePayment(Payment);
			}
	@PutMapping("/addExistingPaymentToExistingTicket")
			public ResponseStructure<Payment> addExistingPaymentToExistingTicket(@RequestParam int pamyentId,@RequestParam int ticketId) {
			return	paymentService.addExistingPaymentToExistingTicket(pamyentId, ticketId);
			}
	@PutMapping("/addExistingPaymentToAddTicket")
			public ResponseStructure<Payment> addExistingPaymentToAddTicket(@RequestParam int pamyentId,@RequestBody Ticket newTicket) {
			return	paymentService.addExistingPaymentToAddTicket(pamyentId, newTicket);
			}
	@GetMapping("/fetchPaymentById")
			public ResponseStructure<Payment> fetchPaymentById(@RequestParam int PaymentId) {
			return	 paymentService.fetchPaymentById(PaymentId);
			}
	@DeleteMapping("/deletePaymentById")
			public ResponseStructure<Payment> deletePaymentById(@RequestParam int PaymentId) {
				return paymentService.deletePaymentById(PaymentId);
			}
	@PutMapping("/updatePaymentById")
		public ResponseStructure<Payment> updatePaymentById(@RequestParam int oldPaymentId,@RequestBody Payment newPayment) {
			return	 paymentService.savePayment(newPayment);	
			}
	@GetMapping("/fetchAllPayments")
			public ResponseStructureList<Payment> fetchAllPayments(){
			return	 paymentService.fetchAllPayments();
			}

}
