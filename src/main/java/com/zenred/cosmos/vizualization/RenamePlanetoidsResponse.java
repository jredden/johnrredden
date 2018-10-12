package com.zenred.cosmos.vizualization;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("renamePlanetoids")
public class RenamePlanetoidsResponse {
	
	private String genericName;
	private List<String> alternateNames;

	
	public String getGenericName() {
		return genericName;
	}
	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}
	public List<String> getAlternateNames() {
		return alternateNames;
	}
	public void setAlternateNames(List<String> alternateNames) {
		this.alternateNames = alternateNames;
	}
	
	@Override
	public String toString() {
		return "RenamePlanetoidsResponse [genericName=" + genericName + ", alternateNames=" + alternateNames + "]";
	}

	
	
}
