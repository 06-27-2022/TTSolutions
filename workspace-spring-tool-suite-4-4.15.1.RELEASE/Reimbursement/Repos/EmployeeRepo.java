package app.Reimbursement.Repos;

import java.util.List;

import app.Reimbursement.beans.Employees;

public interface EmployeeRepo {
	List<Employees> findAllEmployees();
	
	boolean checkLogin(String username, String password);
	
	Employees findByUsername (String username);
	
	void newEmpoloyee(Employees employee);
	

}
