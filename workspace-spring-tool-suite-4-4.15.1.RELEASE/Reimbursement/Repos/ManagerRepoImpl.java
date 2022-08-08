package app.Reimbursement.Repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.Reimbursement.beans.Managers;
import connectionUtil.ConnectionUtil;

public class ManagerRepoImpl implements ManagerRepo {

	
	public List<Managers> findAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		
		List<Managers> managers = new ArrayList<>();
		
		final String sql = "SELECT * FROM Managers";
		
			try {
				conn = ConnectionUtil.getNewConnection();
				stmt = conn.createStatement();
				set = stmt.executeQuery(sql);
			
			
				while(set.next()) {
					Managers manager = new Managers(
						set.getInt(1),
						set.getString(2),
						set.getString(3),
						set.getString(4));
				
				managers.add(manager);
				
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
		return managers;
	}
	
	@Override
	public void newMan(Managers newManager) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		final String sql = "INSERT INTO Managers VALUES (default, ?, ?, ?) ";
		try {
			conn = ConnectionUtil.getNewConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(2, newManager.getManagerName());
			stmt.setString(3, newManager.getManagerUsername());
			stmt.setString(4, newManager.getManagerPassword());
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
	public void update(Managers manager) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		final String sql = "UPDATE Managers SET manager_username = ? WHERE manager_id = ?";
		
		try {
			conn = ConnectionUtil.getNewConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(3, manager.getManagerUsername());
			stmt.setInt(1, manager.getManagerId());
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
	public Managers findManagerUsername(String manager_username) {
		Managers savedMan = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		
		final String sql = "SELECT * FROM managers WHERE manager_username = ?";
		
		try {
			conn = ConnectionUtil.getNewConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, manager_username);
			set = stmt.executeQuery();
			
			if(set.next()) {
				savedMan = new Managers(
						set.getInt(1),
						set.getString(2),
						set.getString(3),
						set.getString(4));
				
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
		
		return savedMan;
	
	}

	@Override
	public Managers findManagerPassword(String manager_password) {
		Managers manCred = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		
		final String sql = "SELECT * FROM Managers WHERE manager_password = ?";
		
		try {
			conn = ConnectionUtil.getNewConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, manager_password);
			set = stmt.executeQuery();
			
			if(set.next()) {
				manCred = new Managers(
						set.getInt(1),
						set.getString(2),
						set.getString(3),
						set.getString(4));
				
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
		
		return manCred;
	}
	
	


}
