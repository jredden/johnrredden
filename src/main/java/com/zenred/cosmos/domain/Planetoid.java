package com.zenred.cosmos.domain;

import java.util.HashMap;
import java.util.Map;

public class Planetoid {
	private Integer planetoidId;
	private Integer repId;
	private String planetoidName;
	private Double radius;	// in kilometers
	private Double distanceToPrimary;
	private Double degree;  // current degree position in radians
	private Double temperature; 
	private Double percentWater;
	private String datestamp;
	
	public Planetoid(){
		
	}

	public Planetoid(Integer planetoidId, Integer repId, String planetoidName, Double radius,
			Double distanceToPrimary, Double degree, Double temperature,
			Double percentWater, String datestamp) {
		super();
		this.planetoidId = planetoidId;
		this.repId = repId;
		this.planetoidName = planetoidName;
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
	
	public String getPlanetoidName() {
		return planetoidName;
	}

	public void setPlanetoidName(String planetoidName) {
		this.planetoidName = planetoidName;
	}

	
	/**
	 * useed for database mapping of planetoid rep
	 * 
	 * @param domain
	 * @param ownerId
	 * @return map of attributes
	 */
	public static Map<String, Object> getPlanetoidRepMap(String domain, Integer ownerId){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(PlanetoidDao.DOMAIN, domain);
		map.put(PlanetoidDao.OWNER_ID, ownerId);
		return map;
	}
	
	public static String[] csvPlanetoidRep(){
		return new String[] {PlanetoidDao.DOMAIN, PlanetoidDao.OWNER_ID};
	}
	
	/**
	 * 
	 * @param repId
	 * @param planetoidName
	 * @param radius
	 * @param distanceToPrimary
	 * @param degree
	 * @param temperature
	 * @param percentWater
	 * @return map of planetoid attributes
	 */
	public static Map<String, Object> getPlanetoidMap(Integer repId, String planetoidName,
			Double radius, Double distanceToPrimary, Double degree,
			Double temperature, Double percentWater) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(PlanetoidDao.REP_ID, repId);
		map.put(PlanetoidDao.PLANETOID_NAME, planetoidName);
		map.put(PlanetoidDao.RADIUS, radius);
		map.put(PlanetoidDao.DISTANCE_TO_PRIMARY, distanceToPrimary);
		map.put(PlanetoidDao.DEGREE, degree);
		map.put(PlanetoidDao.TEMPERATURE, temperature);
		map.put(PlanetoidDao.PERCENT_WATER, percentWater);
		return map;
	}


	public static String[] csvPlanetoid() {
		return new String[] { PlanetoidDao.REP_ID, PlanetoidDao.PLANETOID_NAME, PlanetoidDao.RADIUS,
				PlanetoidDao.DISTANCE_TO_PRIMARY, PlanetoidDao.DEGREE,
				PlanetoidDao.TEMPERATURE, PlanetoidDao.PERCENT_WATER };
	}
	
	@Override
	public String toString() {
		return "Planetoid [planetoidId=" + planetoidId + ", repId=" + repId
				+ ", planetoidName=" + planetoidName + ", radius=" + radius
				+ ", distanceToPrimary=" + distanceToPrimary + ", degree="
				+ degree + ", temperature=" + temperature + ", percentWater="
				+ percentWater + ", datestamp=" + datestamp + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((datestamp == null) ? 0 : datestamp.hashCode());
		result = prime * result + ((degree == null) ? 0 : degree.hashCode());
		result = prime
				* result
				+ ((distanceToPrimary == null) ? 0 : distanceToPrimary
						.hashCode());
		result = prime * result
				+ ((percentWater == null) ? 0 : percentWater.hashCode());
		result = prime * result
				+ ((planetoidId == null) ? 0 : planetoidId.hashCode());
		result = prime * result
				+ ((planetoidName == null) ? 0 : planetoidName.hashCode());
		result = prime * result + ((radius == null) ? 0 : radius.hashCode());
		result = prime * result + ((repId == null) ? 0 : repId.hashCode());
		result = prime * result
				+ ((temperature == null) ? 0 : temperature.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planetoid other = (Planetoid) obj;
		if (datestamp == null) {
			if (other.datestamp != null)
				return false;
		} else if (!datestamp.equals(other.datestamp))
			return false;
		if (degree == null) {
			if (other.degree != null)
				return false;
		} else if (!degree.equals(other.degree))
			return false;
		if (distanceToPrimary == null) {
			if (other.distanceToPrimary != null)
				return false;
		} else if (!distanceToPrimary.equals(other.distanceToPrimary))
			return false;
		if (percentWater == null) {
			if (other.percentWater != null)
				return false;
		} else if (!percentWater.equals(other.percentWater))
			return false;
		if (planetoidId == null) {
			if (other.planetoidId != null)
				return false;
		} else if (!planetoidId.equals(other.planetoidId))
			return false;
		if (planetoidName == null) {
			if (other.planetoidName != null)
				return false;
		} else if (!planetoidName.equals(other.planetoidName))
			return false;
		if (radius == null) {
			if (other.radius != null)
				return false;
		} else if (!radius.equals(other.radius))
			return false;
		if (repId == null) {
			if (other.repId != null)
				return false;
		} else if (!repId.equals(other.repId))
			return false;
		if (temperature == null) {
			if (other.temperature != null)
				return false;
		} else if (!temperature.equals(other.temperature))
			return false;
		return true;
	}
	

}
