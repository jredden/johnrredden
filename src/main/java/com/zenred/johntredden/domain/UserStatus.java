package com.zenred.johntredden.domain;

public enum UserStatus {
	
	/**
	 * must match the enum in the database schema
	 */
	
	candidate1, candidate2, registered;
	
	public static String whichOne(String status){
		String theOne= null;
		if(UserStatus.candidate1.name().equals(status)){
			theOne = UserStatus.candidate1.name();
		}
		else if(UserStatus.candidate2.name().equals(status)){
			theOne = UserStatus.candidate2.name();
		}
		else if(UserStatus.registered.name().equals(status)){
			theOne = UserStatus.registered.name();
		}
		return theOne;
	}

	public static UserStatus whichStatus(String status){
		UserStatus theOne= null;
		if(UserStatus.candidate1.name().equals(status)){
			theOne = UserStatus.candidate1;
		}
		else if(UserStatus.candidate2.name().equals(status)){
			theOne = UserStatus.candidate2;
		}
		else if(UserStatus.registered.name().equals(status)){
			theOne = UserStatus.registered;
		}
		return theOne;
	}
}
