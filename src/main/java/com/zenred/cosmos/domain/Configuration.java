package com.zenred.cosmos.domain;

public class Configuration {
	
	private Integer configurationId;
	private Double starDensity;
	private String Datestamp;
	
	public Integer getConfigurationId() {
		return configurationId;
	}
	public void setConfigurationId(Integer configurationId) {
		this.configurationId = configurationId;
	}
	public Double getStarDensity() {
		return starDensity;
	}
	public void setStarDensity(Double starDensity) {
		this.starDensity = starDensity;
	}
	public String getDatestamp() {
		return Datestamp;
	}
	public void setDatestamp(String datestamp) {
		Datestamp = datestamp;
	}
	@Override
	public String toString() {
		return "Configuration [configurationId=" + configurationId
				+ ", starDensity=" + starDensity + ", Datestamp=" + Datestamp
				+ "]";
	}


}
