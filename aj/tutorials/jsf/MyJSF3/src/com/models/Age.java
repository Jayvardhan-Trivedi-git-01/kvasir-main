package com.models;

public class Age {

	private int dob;
	private int currentYear=2017;
	private int myAge;
	
	public String calculateAge(){
		myAge = currentYear - dob;
		return "f";
	}
	public int getDob() {
		return dob;
	}
	public void setDob(int dob) {
		this.dob = dob;
	}
	public int getCurrentYear() {
		return currentYear;
	}
	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}
	public int getMyAge() {
		return myAge;
	}
	public void setMyAge(int myAge) {
		this.myAge = myAge;
	}	
}
