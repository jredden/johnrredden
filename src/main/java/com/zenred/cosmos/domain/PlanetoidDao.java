package com.zenred.cosmos.domain;

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
}
