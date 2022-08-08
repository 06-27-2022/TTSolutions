package app.Reimbursement.beans;

import java.util.Objects;

public class Managers {
	private int managerId;
	private String managerName;
	private String managerUsername;
	private String managerPassword;
	
	
	
	public Managers() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Managers(int managerId, String managerName, String managerUsername, String managerPassword) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.managerUsername = managerUsername;
		this.managerPassword = managerPassword;
	}



	/**
	 * @return the managerId
	 */
	public int getManagerId() {
		return managerId;
	}



	/**
	 * @param managerId the managerId to set
	 */
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}



	/**
	 * @return the managerName
	 */
	public String getManagerName() {
		return managerName;
	}



	/**
	 * @param managerName the managerName to set
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}



	/**
	 * @return the managerUsername
	 */
	public String getManagerUsername() {
		return managerUsername;
	}



	/**
	 * @param managerUsername the managerUsername to set
	 */
	public void setManagerUsername(String managerUsername) {
		this.managerUsername = managerUsername;
	}



	/**
	 * @return the managerPassword
	 */
	public String getManagerPassword() {
		return managerPassword;
	}



	/**
	 * @param managerPassword the managerPassword to set
	 */
	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}



	@Override
	public int hashCode() {
		return Objects.hash(managerId, managerName, managerPassword, managerUsername);
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
		Managers other = (Managers) obj;
		return managerId == other.managerId && Objects.equals(managerName, other.managerName)
				&& Objects.equals(managerPassword, other.managerPassword)
				&& Objects.equals(managerUsername, other.managerUsername);
	}



	@Override
	public String toString() {
		return "Managers [managerId=" + managerId + ", managerName=" + managerName + ", managerUsername="
				+ managerUsername + ", managerPassword=" + managerPassword + "]";
	}
	
	
	
	
	

}
