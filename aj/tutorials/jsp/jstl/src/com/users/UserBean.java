package com.users;

public class UserBean implements java.io.Serializable {
	private String firstName = null;
	private String lastName = null;
	private String rights = null;
	private int no=0;
	public UserBean() {
	}

	public int getNo(){
		return no;
	}
	public void setNo(int nu){
		this.no = nu;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public String getRights() {
		return rights;
	}
	public void setRights(String rights) {
		this.rights = rights;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}