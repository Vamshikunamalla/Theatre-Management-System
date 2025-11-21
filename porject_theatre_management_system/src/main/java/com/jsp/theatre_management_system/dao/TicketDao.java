package com.jsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.theatre_management_system.Repo.TicketRepo;
import com.jsp.theatre_management_system.dto.Ticket;
import com.jsp.theatre_management_system.dto.Viewer;

@Repository
public class TicketDao {
	@Autowired
	TicketRepo ticketRepo;
	@Autowired
	ViewerDao viewerDao;
	
	public Ticket saveTicket(Ticket ticket) {
		 return	ticketRepo.save(ticket);
		}
	public Ticket addExistingTicketToExistingViewer(int ticketId,int viewerId ) {
		Ticket ticket=fetchTicketById(ticketId);
		Viewer viewer =viewerDao.fetchViewerById(viewerId);
//		ticket.getViewer();
		ticket.setViewer(viewer);
		return saveTicket(ticket);	
	}
	public Ticket addExistingTicketToAddViewer(int ticketId,Viewer newViewer ) {
	      Ticket ticket= fetchTicketById(ticketId);
	    viewerDao.saveViewer(newViewer);
//	     ticket.getViewer();
	     ticket.setViewer(newViewer);
	     return saveTicket(ticket);
	    }
		public Ticket fetchTicketById(int ticketId) {
			Optional<Ticket> ticket=ticketRepo.findById(ticketId);
			if(ticket.isPresent()) {
				return ticket.get();
			}else {
				return null;}
		}
		
		public Ticket deletetTicketById(int ticketId) {
		Ticket	ticket=fetchTicketById(ticketId);
		ticketRepo.delete(ticket);
		return ticket;
		}
		
		public Ticket updateTicketById(int oldTicketId, Ticket newTicket) {
			newTicket.setTicketId(oldTicketId);
		return	ticketRepo.save(newTicket);
		}
		
		public List<Ticket> fetchAllTickets(){
	  return ticketRepo.findAll();
			
		}

}
