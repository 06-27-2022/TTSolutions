package app.Reimbursement.beans;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import javax.servlet.http.HttpServletRequest;
//
//import javax.servlet.http.HttpServletResponse;


public class Tickets {
		
		public int id;
		public double ticketAmount;
		public String ticketDescription;
		public int employeeId;
		public int managerId;
		public String ticketStatus;
		
		public Tickets(){
			
			
		}
		
		
		public Tickets(int id, 
				Double ticketAmount, 
				String ticketDescription,
				int employeeId,
				int managerId,
				String ticketStatus ){
			this.id = id;
			this.ticketAmount = ticketAmount;
			this.ticketDescription = ticketDescription;
			this.employeeId =employeeId;
			this.managerId = managerId;
			this.ticketStatus = ticketStatus;
		}
		public Tickets(double amount, String ticketDescription) {
			this.ticketAmount = amount;
			this.ticketDescription = ticketDescription;
			this.ticketStatus = "Pending";
		}


		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}


		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}


		/**
		 * @return the ticketAmount
		 */
		public double getTicketAmount() {
			return ticketAmount;
		}


		/**
		 * @param ticketAmount the ticketAmount to set
		 */
		public void setTicketAmount(double ticketAmount) {
			this.ticketAmount = ticketAmount;
		}


	
		/**
		 * @return the ticketDescription
		 */
		public String getTicketDescription() {
			return ticketDescription;
		}


		/**
		 * @param ticketDescription the ticketDescription to set
		 */
		public void setTicketDescription(String ticketDescription) {
			this.ticketDescription = ticketDescription;
		}


		/**
		 * @return the ticketEmployee
		 */
		public int getEmployeeId() {
			return employeeId;
		}


		/**
		 * @param ticketEmployee the ticketEmployee to set
		 */
		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}


		/**
		 * @return the ticketManager
		 */
		public int getManagerId() {
			return managerId;
		}


		/**
		 * @param ticketManager the ticketManager to set
		 */
		public void setManagerId (int managerId) {
			this.managerId = managerId;
		}


		/**
		 * @return the ticketStatus
		 */
		public String getTicketStatus() {
			return ticketStatus;
		}


		/**
		 * @param ticketStatus the ticketStatus to set
		 */
		public void setTicketStatus(String ticketStatus) {
			this.ticketStatus = ticketStatus;
		}



		@Override
		public String toString() {
			return "Tickets [id=" + id + ", ticketAmount=" + ticketAmount +  ", ticketDescription=" + ticketDescription
					+ ", employeeId=" + employeeId + ", managerId=" + managerId + 
					"]";
		}


		public void pending(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			
		}


		public void approved(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			
		}


		public void declined(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			
		}
		
//		
		
	
		
		 
	}
	

