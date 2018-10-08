package com.zenred.cosmos.service_rules_and_infrastructure;

import java.util.List;

import com.zenred.cosmos.domain.RenameObjectType;

public class RenameCandidates {
	
	private String genericName;
	private List<String> renames;
	private RenameObjectType renameObjectType;
	
	public String getGenericName() {
		return genericName;
	}
	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}
	public List<String> getRenames() {
		return renames;
	}
	public void setRenames(List<String> renames) {
		this.renames = renames;
	}
	public RenameObjectType getRenameObjectType() {
		return renameObjectType;
	}
	public void setRenameObjectType(RenameObjectType renameObjectType) {
		this.renameObjectType = renameObjectType;
	}
	@Override
	public String toString() {
		return "RenameCandidates [genericName=" + genericName + ", renames=" + renames + ", renameObjectType="
				+ renameObjectType + "]";
	}
	
	

}
