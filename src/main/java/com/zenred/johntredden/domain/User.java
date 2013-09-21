package com.zenred.johntredden.domain;

public class User {
	
	private Integer user_id;
	private UserStatus user_Status;
	private String firstName;
	private String lastName;
	private String emailAddress;
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public UserStatus getUser_Status() {
		return user_Status;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setUser_Status(UserStatus user_Status) {
		this.user_Status = user_Status;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	

}
