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
	

}
