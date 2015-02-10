package com.zenred.cosmos.domain;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

public class PlanetoidDao {
	
	public static  String PLANETOID = "Planetoid";
	public static  String PLANETOID_ID = "planetoidId"; 
	public static  String REP_ID = "repId";
	public static  String RADIUS = "Radius";
	public static  String DISTANCE_TO_PRIMARY = "DistanceToPrimary";
	public static  String DEGREE = "Degree";
	public static  String TEMPERATURE = "Temperature";
	public static  String PERCENT_WATER = "PercentWater";
	public static  String DATESTAMP = "Datestamp";
	
	public static String PLANETOID_REP = "PlanetoidRep";
	public static String PLANETOID_REP_ID = "planetoidrepId";
	public static String DOMAIN = "domain";
	public static String OWNER_ID = "ownerId";
	public static  String PLANETOID_ID2 = "planetoidId"; 
	public static  String DATESTAMP2 = "Datestamp";
	
	private static String lastPlanetoidInsertSql = "SELECT MAX("+PLANETOID_ID+") FROM " + PLANETOID;
	private static String lastPlwnetoidRepInsertSql = "SELECT MAX("+PLANETOID_REP_ID+") FROM "+ PLANETOID_REP;
	
	private static String readPlanetoidById = "SELECT "
			+ "plt." + PLANETOID_ID + " "
			+ ", plt." + REP_ID + " "
			+ ", plt." + RADIUS + " "
			+ ", plt." + DISTANCE_TO_PRIMARY + " "
			+ ", plt." + DEGREE + " "
			+ ", plt." + TEMPERATURE + " "
			+ ", plt." + PERCENT_WATER + " "
			+ ", plt." + DATESTAMP + " "
			+ " FROM " + PLANETOID + " plt "
			+ " WHERE plt." + PLANETOID_ID + " = ? "
			;
	
	private static String updatePlanetoidById = "UPDATE " + PLANETOID + "plt SET "
			+ " plt." + REP_ID + " = ? "
			+ ", plt." + RADIUS + " "
			+ ", plt." + DISTANCE_TO_PRIMARY + " = ? "
			+ ", plt." + DEGREE + " = ? "
			+ ", plt." + TEMPERATURE + " = ? "
			+ ", plt." + PERCENT_WATER + " = ? "
			+ " WHERE plt." + PLANETOID_ID + " = ? "
			;
	
	@Transactional
	public void addClusterPlanetoid(Planetoid planetoid, ClusterRep clusterRep){
		String domain = PlanetoidDomainFactory.planetoidDomain(clusterRep.getClass());
		Map<String, Object> planetoidRepMap = Planetoid.getPlanetoidRepMap(domain, clusterRep.getClusterRepId());
	}
}
