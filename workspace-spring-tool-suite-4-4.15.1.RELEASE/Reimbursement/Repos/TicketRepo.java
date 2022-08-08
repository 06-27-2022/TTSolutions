package app.Reimbursement.Repos;

import java.util.List;

import app.Reimbursement.beans.Tickets;

public interface TicketRepo {
	List<Tickets> findAllTickets();
	
	void newTicket (Tickets ticket);
	
	List<Tickets> findAllPending();
	
	Tickets findByStatus (String status);
	
	void updateTicketById (int id, String status);
}
