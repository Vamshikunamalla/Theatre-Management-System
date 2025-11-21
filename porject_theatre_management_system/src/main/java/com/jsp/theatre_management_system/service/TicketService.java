package com.jsp.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.theatre_management_system.dao.TicketDao;
import com.jsp.theatre_management_system.dto.Ticket;
import com.jsp.theatre_management_system.dto.Viewer;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;

@Service
public class TicketService {
	@Autowired
	TicketDao ticketDao;
	@Autowired
	ResponseStructure<Ticket> responseStructure;
	@Autowired
	ResponseStructureList<Ticket> responseStructureList;
	
	   public ResponseStructure<Ticket> saveTicket(Ticket ticket) {
		   responseStructure.setStatusCoad(HttpStatus.CREATED.value());
	    	responseStructure.setMessage("Succesfully save Theatre   the  into db");
	    	responseStructure.setData(ticketDao.saveTicket(ticket));
		 return	responseStructure;
		}
	   
	   public ResponseStructure<Ticket> addExistingTicketToExistingViewer(int ticketId,int viewerId ) {
		   responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully addExistingTicketToExistingViewer   the  into db");
	    	responseStructure.setData(ticketDao.addExistingTicketToExistingViewer(ticketId, viewerId));
		  return responseStructure;
	   }
	   
	   public ResponseStructure<Ticket> addExistingTicketToAddViewer(int ticketId,Viewer newViewer ) {
		   responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully addExistingTicketToAddViewer   the  into db");
	    	responseStructure.setData(ticketDao.addExistingTicketToAddViewer(ticketId, newViewer));
		return responseStructure  ;	 
		   }
		public ResponseStructure<Ticket> fetchTicketById(int ticketId) {
			responseStructure.setStatusCoad(HttpStatus.FOUND.value());
	    	responseStructure.setMessage("Succesfully fetchTicketById   the  into db");
	    	responseStructure.setData(ticketDao.deletetTicketById(ticketId));
		return	responseStructure;
		}
		
		public ResponseStructure<Ticket> deletetTicketById(int ticketId) {
			responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully deletetTicketById   the  into db");
	    	responseStructure.setData(ticketDao.deletetTicketById(ticketId));
		 return responseStructure	;
	    }
		
		public ResponseStructure<Ticket> updateTicketById(int oldTicketId, Ticket newTicket) {
			responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully  updateTicketById  the  into db");
	    	responseStructure.setData(ticketDao.saveTicket(newTicket));
		return responseStructure	;
		}
		
		public ResponseStructureList<Ticket> fetchAllTickets(){
			responseStructureList.setStatusCode(HttpStatus.FOUND.value());
			responseStructureList.setMessage("Succesfully fetchAllTickets from db");
			responseStructureList.setData(ticketDao.fetchAllTickets());
	  return responseStructureList ;
			
		}
	

}
