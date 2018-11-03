package com.zenred.cosmos.domain;

public class AddNewName {
	
	public static Boolean doIt(RenameObjectType renameObjectType, String reName, String genericName){
		
		return renameObjectType.renameEntity(genericName, reName);
	}

}
