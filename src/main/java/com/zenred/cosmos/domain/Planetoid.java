package com.zenred.cosmos.domain;

public class Planetoid {
	private Integer planetoidId;
	private Integer repId;
	private Double radius;
	private Double distanceToPrimary;
	private Double degree;  // current degree position in radians
	private Double temperature; 
	private Double percentWater;
	private String datestamp;
	
	public Planetoid(){
		
	}

	public Planetoid(Integer planetoidId, Integer repId, Double radius,
			Double distanceToPrimary, Double degree, Double temperature,
			Double percentWater, String datestamp) {
		super();
		this.planetoidId = planetoidId;
		this.repId = repId;
		this.radius = radius;
		this.distanceToPrimary = distanceToPrimary;
		this.degree = degree;
		this.temperature = temperature;
		this.percentWater = percentWater;
		this.datestamp = datestamp;
	}

	public Integer getPlanetoidId() {
		return planetoidId;
	}

	public void setPlanetoidId(Integer planetoidId) {
		this.planetoidId = planetoidId;
	}

	public Integer getRepId() {
		return repId;
	}

	public void setRepId(Integer repId) {
		this.repId = repId;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	public Double getDistanceToPrimary() {
		return distanceToPrimary;
	}

	public void setDistanceToPrimary(Double distanceToPrimary) {
		this.distanceToPrimary = distanceToPrimary;
	}

	public Double getDegree() {
		return degree;
	}

	public void setDegree(Double degree) {
		this.degree = degree;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getPercentWater() {
		return percentWater;
	}

	public void setPercentWater(Double percentWater) {
		this.percentWater = percentWater;
	}

	public String getDatestamp() {
		return datestamp;
	}

	public void setDatestamp(String datestamp) {
		this.datestamp = datestamp;
	}

	@Override
	public String toString() {
		return "Planetoid [planetoidId=" + planetoidId + ", repId=" + repId
				+ ", radius=" + radius + ", distanceToPrimary="
				+ distanceToPrimary + ", degree=" + degree + ", temperature="
				+ temperature + ", percentWater=" + percentWater
				+ ", datestamp=" + datestamp + "]";
	}
	

}
