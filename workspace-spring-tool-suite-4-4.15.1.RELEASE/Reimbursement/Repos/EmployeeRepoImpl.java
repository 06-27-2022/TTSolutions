package app.Reimbursement.Repos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.Reimbursement.beans.Employees;
import connectionUtil.ConnectionUtil;

public class EmployeeRepoImpl implements EmployeeRepo{
		
	
	public List<Employees> findAllEmployees() {
		Connection conn = null;
		Statement stmt =null;
		ResultSet set = null;
	
		List<Employees> allEmployees = new ArrayList<>();
	
		final String sql = "SELECT * FROM Employees";
		try {
		conn = ConnectionUtil.getNewConnection();
		stmt = conn.createStatement();
		set = stmt.executeQuery(sql);
		while(set.next()) {
			Employees employee = new Employees(
					set.getInt(1),
					set.getString(1),
					set.getString(3),
					set.getString(4)
					);
			
			allEmployees.add(employee);
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			conn.close();
			stmt.close();
			set.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		return allEmployees;
	}

	
	@Override
	public boolean checkLogin(String username, String password) {
		
		EmployeeRepo empRepo = new EmployeeRepoImpl();
		
		return empRepo.findByUsername(username).getPassword().equals(password);
}

	@Override
	public Employees findByUsername(String username) {
		Employees findEmployee = null;
		
		Connection conn = null;
		PreparedStatement stmt =null;
		ResultSet set = null;
		
		final String sql = "SELECT * FROM Employees WHERE username= ?";
		try {
		conn = ConnectionUtil.getNewConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, username);
		set = stmt.executeQuery();
		if(set.next()) {
			findEmployee = new Employees(
					set.getInt(1),
					set.getString(1),
					set.getString(3),
					set.getString(4)
					);
			
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			conn.close();
			stmt.close();
			set.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		return findEmployee;
	}

	

	@Override
	public void newEmpoloyee(Employees employees) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		final String sql = "INSERT INTO Employees VALUES (default, ?, ?, ?)";
		
		try {
			conn = ConnectionUtil.getNewConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "Employees.getUsername()");
			stmt.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	

}

