package com.zenred.cosmos.domain;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.zenred.johntredden.domain.AbstractJDBCDao;

public class PlanetoidDao extends AbstractJDBCDao{
	
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
	
	private static String readPlanetoidRepId = "SELECT "
			+ " pltr." + PLANETOID_REP_ID + " "
			+ " pltr." + DOMAIN + " "
			+ " pltr." + OWNER_ID + " "
			+ " pltr." + PLANETOID_ID2 + " "
			+ " pltr." + DATESTAMP2 + " "
		;
	private static String updatePlanetoidById = "UPDATE " + PLANETOID + " plt SET "
			+ " plt." + REP_ID + " = ? "
			+ ", plt." + RADIUS + " "
			+ ", plt." + DISTANCE_TO_PRIMARY + " = ? "
			+ ", plt." + DEGREE + " = ? "
			+ ", plt." + TEMPERATURE + " = ? "
			+ ", plt." + PERCENT_WATER + " = ? "
			+ " WHERE plt." + PLANETOID_ID + " = ? "
			;
	private static String updatePlanetoidIdPlanetoidRepById = "UPDATE " + PLANETOID_REP + " pltr SET "
			+ " pltr." + PLANETOID_ID2 + " = ?"
			+ " WHERE pltr." + PLANETOID_REP_ID + " = ? "
			;
	
	@Transactional
	public void addClusterPlanetoid(Planetoid planetoid, ClusterRep clusterRep) {
		String domain = PlanetoidDomainFactory.planetoidDomain(clusterRep
				.getClass());
		Map<String, Object> planetoidRepMap = Planetoid.getPlanetoidRepMap(
				domain, clusterRep.getClusterRepId());
		super.jdbcInsertSetup().withTableName(PLANETOID_REP)
				.usingColumns(Planetoid.csvPlanetoidRep())
				.execute(planetoidRepMap);
		Integer planetoidRepId = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForInt(lastPlwnetoidRepInsertSql);
		planetoid.setRepId(planetoidRepId);
		Map<String, Object> planetoidMap = Planetoid.getPlanetoidMap(
				planetoidRepId, planetoid.getRadius(),
				planetoid.getDistanceToPrimary(), planetoid.getDegree(),
				planetoid.getTemperature(), planetoid.getPercentWater());
		super.jdbcInsertSetup().withTableName(PLANETOID)
				.usingColumns(Planetoid.csvPlanetoid()).execute(planetoidMap);
		Integer planetoidId = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForInt(lastPlanetoidInsertSql);
		super.jdbcSetUp()
		.getSimpleJdbcTemplate()
		.update(updatePlanetoidIdPlanetoidRepById,new Object[]{planetoidId, planetoidRepId
		});
	}
	
	public UnifiedPlanetoidI.PlanetoidRep readPlanetoidRepById(Integer planetoidRepId){
		Object[] param = {planetoidRepId};
		Map<String, Object> planetoidRepMap = super.jdbcSetUp().getSimpleJdbcTemplate().queryForMap(readPlanetoidRepId, param);
		UnifiedPlanetoidI.PlanetoidRep unPlanetoidRep_PlanetoidRep = new UnifiedPlanetoidI.PlanetoidRep();
		unPlanetoidRep_PlanetoidRep.setDatestamp(planetoidRepMap.get(DATESTAMP2).toString());
		String s_ownerId = planetoidRepMap.get(OWNER_ID).toString();
		unPlanetoidRep_PlanetoidRep.setOwnerId(new Integer(s_ownerId));
		return unPlanetoidRep_PlanetoidRep;
	}
}
