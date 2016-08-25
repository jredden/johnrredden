package com.zenred.cosmos.domain;

public class SystemClusterSubSet {
	
	/**
	 * instead of refactoring to come up with a scheme of "multiple inheritance" 
	 * using interfaces, keep it simple.
	 */
	
	private String systemName;
	private Double ucoordinate;
	private Double vcoordinate;
	private String clustername;
	private Integer clusterRepId;
	
	public SystemClusterSubSet(){}
	
	public SystemClusterSubSet(String systemName, Double ucoordinate, Double vcoordinate, String clustername,
			Integer clusterRepId) {
		super();
		this.systemName = systemName;
		this.ucoordinate = ucoordinate;
		this.vcoordinate = vcoordinate;
		this.clustername = clustername;
		this.clusterRepId = clusterRepId;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
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

	public String getClustername() {
		return clustername;
	}

	public void setClustername(String clustername) {
		this.clustername = clustername;
	}

	public Integer getClusterRepId() {
		return clusterRepId;
	}

	public void setClusterRepId(Integer clusterRepId) {
		this.clusterRepId = clusterRepId;
	}

	@Override
	public String toString() {
		return "SystemClusterSubSet [systemName=" + systemName + ", ucoordinate=" + ucoordinate + ", vcoordinate="
				+ vcoordinate + ", clustername=" + clustername + ", clusterRepId=" + clusterRepId + "]";
	}
	
	

}
