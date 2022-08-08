package app.Reimbursement.Repos;

import java.util.List;

import app.Reimbursement.beans.Managers;

public interface ManagerRepo {
	
	List<Managers> findAll();
	
	void newMan (Managers newManager);
		
	void update(Managers manager);
		
	Managers findManagerUsername(String manager_username);
	
	Managers findManagerPassword(String manager_password);
	

}
