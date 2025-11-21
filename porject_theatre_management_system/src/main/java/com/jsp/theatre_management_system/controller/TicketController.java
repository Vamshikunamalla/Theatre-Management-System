package com.jsp.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.theatre_management_system.dto.Ticket;
import com.jsp.theatre_management_system.dto.Viewer;
import com.jsp.theatre_management_system.service.TicketService;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;

@RestController
public class TicketController {
	@Autowired
	TicketService ticketService;
@PostMapping("/saveTicket")	
	    public ResponseStructure<Ticket> saveTicket(@RequestBody Ticket ticket) {
		 return	ticketService.saveTicket(ticket);
		}
@PutMapping("/addExistingTicketToExistingViewer")
		public ResponseStructure<Ticket> addExistingTicketToExistingViewer(@RequestParam int ticketId,@RequestParam int viewerId ) {
        return	ticketService.addExistingTicketToExistingViewer(ticketId, viewerId);
        }
@PutMapping("/addExistingTicketToAddViewer")
public ResponseStructure<Ticket> addExistingTicketToAddViewer(int ticketId,Viewer newViewer ) {
 return	ticketService.addExistingTicketToAddViewer(ticketId, newViewer);
	
}
@GetMapping("/fetchTicketById")
		public ResponseStructure<Ticket> fetchTicketById(@RequestParam int ticketId) {
		return	ticketService.deletetTicketById(ticketId);
		}
@DeleteMapping("/deletetTicketById")
		public ResponseStructure<Ticket> deletetTicketById(@RequestParam int ticketId) {
		 return	ticketService.deletetTicketById(ticketId);
	    }
@PutMapping("/updateTicketById")		
		public ResponseStructure<Ticket> updateTicketById(@RequestParam int oldTicketId,@RequestBody Ticket newTicket) {
	    newTicket.setTicketId(oldTicketId);
		return	ticketService.saveTicket(newTicket);
		}
@GetMapping("/fetchAll")	
		public ResponseStructureList<Ticket> fetchAllTickets(){
	  return ticketService.fetchAllTickets();
			
		}

}
