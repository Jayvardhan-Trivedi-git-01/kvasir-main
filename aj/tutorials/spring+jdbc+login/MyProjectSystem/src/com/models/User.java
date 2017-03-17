package com.models;

public class User {
	
	 int id;
	 String name;
	 String pass;

	public String getName(){
		return this.name;
	}
	public String getPass(){
		return this.pass;
	}
	public int getId(){
		return this.id;
	}
	
	public void setName(String name){
		 this.name= name;
	}
	public void setPass(String pass){
		this.pass = pass;
	}
	public void setId(int id){
		 this.id = id;
	}
	
	
	
}
