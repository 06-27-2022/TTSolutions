package app.Reimbursement.Repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.Reimbursement.beans.Tickets;
import connectionUtil.ConnectionUtil;

public class TicketRepoImpl implements TicketRepo{

	@Override
	public List<Tickets> findAllTickets() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		
		List<Tickets> alltickets= new ArrayList<>();
		
		final String sql = "SELECT * FROM Tickets";
		
		try {
			conn = ConnectionUtil.getNewConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(sql);
			while(set.next()) {
				Tickets ticket = new Tickets(
						set.getInt(1),
						set.getDouble(2),
						set.getString(3),
						set.getInt(4),
						set.getInt(5),
						set.getString(6));
				alltickets.add(ticket);
										
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
				set.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return alltickets;

	}

	@Override
	public void newTicket(Tickets ticket) {
		Connection conn = null;
		
		PreparedStatement stmt = null;
		
		final String sql = "INSERT INTO Tickets VALUES(default, ?, ? , default, default, 'PENDING')";
		
		try {
			conn =ConnectionUtil.getNewConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setDouble(1,ticket.getTicketAmount());
			stmt.setString(2, ticket.getTicketDescription());
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<Tickets> findAllPending() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		
		List<Tickets> pendingTickets= new ArrayList<>();
		
		final String sql = "SELECT * FROM Tickets WHERE status = 'PENDING'";
		
		try {
			conn = ConnectionUtil.getNewConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(sql);
			while(set.next()) {
				Tickets ticket = new Tickets(
						set.getInt(1),
						set.getDouble(2),
						set.getString(3),
						set.getInt(4),
						set.getInt(5),
						set.getString(6));
				pendingTickets.add(ticket);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
				set.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return pendingTickets;
	}

	@Override
	public Tickets findByStatus(String status) {
		Tickets findTicket = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String sql = "SELECT * FROM Tickets WHERE status = ?";
		
		try {
			conn=ConnectionUtil.getNewConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, status);
			set = stmt.executeQuery();
			
			if(set.next()) {
				findTicket = new Tickets(
						set.getInt(1),
						set.getDouble(2),
						set.getString(3),
						set.getInt(4),
						set.getInt(5),
						set.getString(6));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
				set.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return findTicket;
	}

	@Override
	public void updateTicketById(int id, String status) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String sql = "UPDATE Tickets SET status = ? WHERE id = ?";
		
		try {
			conn = ConnectionUtil.getNewConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,status);
			stmt.setInt(2, id);
			stmt.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
	}

}
}
