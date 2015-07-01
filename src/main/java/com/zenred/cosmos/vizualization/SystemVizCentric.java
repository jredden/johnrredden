package com.zenred.cosmos.vizualization;

public class SystemVizCentric {
	
	// one instance of a visualization centric star system that may or may not have stars.
	
	private Double distance_to_galaxy_centre;
	private Double ucoordinate;
	private Double vcoordinate;
	private String systemName;
	
	public Double getDistance_to_galaxy_centre() {
		return distance_to_galaxy_centre;
	}
	public void setDistance_to_galaxy_centre(Double distance_to_galaxy_centre) {
		this.distance_to_galaxy_centre = distance_to_galaxy_centre;
	}
	public Double getUcoordinate() {
		return ucoordinate;
	}
	public void setUcoordinate(Double ucoordinate) {
		this.ucoordinate = ucoordinate;
	}
	public Double getVcoordinate() {
		return vcoordinate;
	}
	public void setVcoordinate(Double vcoordinate) {
		this.vcoordinate = vcoordinate;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	@Override
	public String toString() {
		return "SystemVizCentric [distance_to_galaxy_centre="
				+ distance_to_galaxy_centre + ", ucoordinate=" + ucoordinate
				+ ", vcoordinate=" + vcoordinate + ", systemName=" + systemName
				+ "]";
	}
	
	

}
