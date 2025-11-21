package com.jsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.theatre_management_system.Repo.PaymentRepo;
import com.jsp.theatre_management_system.dto.Payment;
import com.jsp.theatre_management_system.dto.Ticket;
@Repository
public class PaymentDao {
	@Autowired
	PaymentRepo paymentRepo;

	@Autowired
	TicketDao ticketDao;
	
	public Payment savePayment( Payment payment) {
		return	paymentRepo.save(payment);
		}
	public Payment addExistingPaymentToExistingTicket(int pamyentId,int ticketId) {
		Payment payment =fetchPaymentById(pamyentId);
		Ticket ticket=ticketDao.fetchTicketById(ticketId);
		payment.getTicket();
		payment.setTicket(ticket);
		return savePayment(payment);	
	}
	public Payment addExistingPaymentToAddTicket( int pamyentId, Ticket newTicket) {
	 Payment payment =fetchPaymentById(pamyentId);
	 ticketDao.saveTicket(newTicket);
	 payment.getTicket();
	 payment.setTicket(newTicket);
	 return payment;
	}
		public Payment fetchPaymentById(int paymentId) {
			Optional<Payment> payment=paymentRepo.findById(paymentId);
			if(payment.isPresent()) {
				return payment.get();
			}else {
				return null;
			}
	
		}
		
		public Payment deletePaymentById(int paymentId) {
		  Payment payment=fetchPaymentById(paymentId);
			paymentRepo.delete(payment);
			return payment;
		}
		public Payment updatePaymentById(int oldPaymentId, Payment newPayment) {
			newPayment.setPaymentId(oldPaymentId);
		return	paymentRepo.save(newPayment);	
		}
		public List<Payment> fetchAllPayments(){
		return	paymentRepo.findAll();
			
		}
}
