package app.Reimbursement.beans;

import java.sql.Connection;
import java.util.List;
import java.util.Objects;

public class Employees {
/**
 * Fields for class Employees
 * 
 */
	private int id;
	private String fullName;
	private String username;
	private String password;
	
	public Employees(Connection conn) {
		super();
	}
	
	public Employees (int id, 
			String fullName, 
			String username, 
			String password) {
//		super();
		/**
		 * Object Employees parameters
		 */
		this.id = id;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
	}

	public Employees() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Get/Set methods
	 * @return
	 */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public int hashCode() {
		return Objects.hash(fullName, id, password, username);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Employees other = (Employees) obj;
		return Objects.equals(fullName, other.fullName) && id == other.id
				&& Objects.equals(password, other.password) 
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", fullName=" + fullName + ", username=" + username
				+ ", password=" + password + "]";
	}

	public void newEmployee(String full_name, String username, String password) {
		// TODO Auto-generated method stub
		
	}

//	public void register(String full_name, String username, String password) {
//		// TODO Auto-generated method stub
//		
//	}
	
	public void checkLogin(String full_name, String username, String password) {
		// TODO Auto-generated method stub
		
	}

	public Employees findByUsername(String username2) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employees> findAllEmployees(Employees employee) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	

}