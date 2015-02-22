package com.zenred.cosmos.domain;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.zenred.johntredden.domain.AbstractJDBCDao;

public class PlanetoidDao extends AbstractJDBCDao{
	
	static private Logger logger = Logger.getLogger(PlanetoidDao.class);
	
	public static  String PLANETOID = "Planetoid";
	public static  String PLANETOID_ID = "planetoidId"; 
	public static  String REP_ID = "repId";
	public static  String PLANETOID_NAME = "planetoidName";
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
			+ ", plt." + PLANETOID_NAME + " "
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
			+ ", pltr." + DOMAIN + " "
			+ ", pltr." + OWNER_ID + " "
			+ ", pltr." + PLANETOID_ID2 + " "
			+ ", pltr." + DATESTAMP2 + " "
			+ " FROM " + PLANETOID_REP + " pltr "
			+ " WHERE pltr." + PLANETOID_REP_ID + " = ? "
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
	private static String deletePlanetoidRep = "DELETE FROM " + PLANETOID_REP + " WHERE "
			+ PLANETOID_REP_ID + " = ?";
			;
	private static String deletePlanetoid = "DELETE FROM " + PLANETOID + " WHERE "
			+ PLANETOID_ID + " = ?";
			;
	/**
	 * 
	 * @param planetoid
	 * @param clusterRep
	 * @return unified planetoid
	 */
	@Transactional
	public UnifiedPlanetoidI addClusterPlanetoid(Planetoid planetoid,
			ClusterRep clusterRep) {
		String domain = PlanetoidDomainFactory.planetoidDomain(clusterRep
				.getClass());
		Map<String, Object> planetoidRepMap = Planetoid.getPlanetoidRepMap(
				domain, clusterRep.getClusterRepId());
		return addPlanetoid(planetoid, planetoidRepMap);
	}
	/**
	 * 
	 * @param planetoid
	 * @param star
	 * @return unified planetoid
	 */
	@Transactional
	public UnifiedPlanetoidI addStarPlanetoid(Planetoid planetoid, Star star) {
		String domain = PlanetoidDomainFactory.planetoidDomain(star.getClass());
		Map<String, Object> planetoidRepMap = Planetoid.getPlanetoidRepMap(
				domain, star.getStarId());
		return addPlanetoid(planetoid, planetoidRepMap);
	}
	/**
	 * add a "moon" or a moon's moon
	 * 
	 * @param planetoid
	 * @param star
	 * @return
	 */
	@Transactional
	public UnifiedPlanetoidI addPlanetoidPlanetoid(Planetoid planetoid, Planetoid moon) {
		String domain = PlanetoidDomainFactory.planetoidDomain(moon.getClass());
		Map<String, Object> planetoidRepMap = Planetoid.getPlanetoidRepMap(
				domain, moon.getPlanetoidId());
		return addPlanetoid(planetoid, planetoidRepMap);
	}

	@Transactional
	private UnifiedPlanetoidI addPlanetoid(Planetoid planetoid,
			Map<String, Object> planetoidMap) {
		super.jdbcInsertSetup().withTableName(PLANETOID_REP)
				.usingColumns(Planetoid.csvPlanetoidRep())
				.execute(planetoidMap);
		Integer planetoidRepId = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForInt(lastPlwnetoidRepInsertSql);
		planetoid.setRepId(planetoidRepId);
		Map<String, Object> planetoidNewMap = Planetoid.getPlanetoidMap(
				planetoidRepId, planetoid.getPlanetoidName(), planetoid.getRadius(),
				planetoid.getDistanceToPrimary(), planetoid.getDegree(),
				planetoid.getTemperature(), planetoid.getPercentWater());
		super.jdbcInsertSetup().withTableName(PLANETOID)
				.usingColumns(Planetoid.csvPlanetoid()).execute(planetoidNewMap);
		Integer planetoidId = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForInt(lastPlanetoidInsertSql);
		super.jdbcSetUp()
				.getSimpleJdbcTemplate()
				.update(updatePlanetoidIdPlanetoidRepById,
						new Object[] { planetoidId, planetoidRepId });
		planetoid.setPlanetoidId(planetoidId);
		return readPlanetoidUnified(planetoid);

	}
	
	/**
	 * 
	 * @param planetoid
	 * @return UnifiedPlanetoidI interface
	 */
	public UnifiedPlanetoidI readPlanetoidUnified(Planetoid planetoid){
		UnifiedPlanetoidI.PlanetoidRep uPlanetoidRep = readPlanetoidRepById(planetoid.getRepId());
		Planetoid planetoid2 = readPlanetoidById(planetoid.getPlanetoidId());
		UnifiedPlanetoidI.UnifiedPlanetoidImpl unifiedPlanetoidImpl = new UnifiedPlanetoidI.UnifiedPlanetoidImpl();
		unifiedPlanetoidImpl.setPlanetoid(planetoid2);
		unifiedPlanetoidImpl.setPlanetoidRep(uPlanetoidRep);
		return unifiedPlanetoidImpl;
	}
	/**
	 * 
	 * @param planetoidRepId
	 * @return Planetoid Rep
	 */
	public UnifiedPlanetoidI.PlanetoidRep readPlanetoidRepById(Integer planetoidRepId){
		Object[] param = {planetoidRepId};
		Map<String, Object> planetoidRepMap = super.jdbcSetUp().getSimpleJdbcTemplate().queryForMap(readPlanetoidRepId, param);
		UnifiedPlanetoidI.PlanetoidRep unPlanetoidRep_PlanetoidRep = new UnifiedPlanetoidI.PlanetoidRep();
		unPlanetoidRep_PlanetoidRep.setPlanetoidrepId(planetoidRepId);
		unPlanetoidRep_PlanetoidRep.setDatestamp(planetoidRepMap.get(DATESTAMP2).toString());
		String s_ownerId = planetoidRepMap.get(OWNER_ID).toString();
		unPlanetoidRep_PlanetoidRep.setOwnerId(new Integer(s_ownerId));
		unPlanetoidRep_PlanetoidRep
				.setPlanetoidDomainFactory(PlanetoidDomainFactory.databaseMap
						.get(planetoidRepMap.get(DOMAIN).toString()));
		String s_planetoidId = planetoidRepMap.get(PLANETOID_ID2).toString();
		unPlanetoidRep_PlanetoidRep.setPlanetoidId(new Integer(s_planetoidId));
		unPlanetoidRep_PlanetoidRep.setDatestamp(planetoidRepMap.get(DATESTAMP2).toString());
		return unPlanetoidRep_PlanetoidRep;
	}
	/**
	 * 
	 * @param planetoidId
	 * @return Planetoid
	 */
	public Planetoid readPlanetoidById(Integer planetoidId){
		Object[] param = {planetoidId};
		logger.debug("SQL:"+readPlanetoidById);
		Map<String, Object> planetoidMap = super.jdbcSetUp().getSimpleJdbcTemplate().queryForMap(readPlanetoidById, param);
		Planetoid planetoid = new Planetoid();
		planetoid.setDatestamp(planetoidMap.get(DATESTAMP).toString());
		String s_degree = planetoidMap.get(DEGREE).toString();
		planetoid.setDegree(new Double(s_degree));
		String s_distanceToPrimary = planetoidMap.get(DISTANCE_TO_PRIMARY).toString();
		planetoid.setDistanceToPrimary(new Double(s_distanceToPrimary));
		String s_percentWater = planetoidMap.get(PERCENT_WATER).toString();
		planetoid.setPercentWater(new Double(s_percentWater));
		planetoid.setPlanetoidId(planetoidId);
		String s_radius = planetoidMap.get(RADIUS).toString();
		planetoid.setRadius(new Double(s_radius));
		String s_temperature = planetoidMap.get(TEMPERATURE).toString();
		planetoid.setTemperature(new Double(s_temperature));
		if (null != planetoidMap.get(REP_ID)) {
			String s_repId = planetoidMap.get(REP_ID).toString();
			planetoid.setRepId(new Integer(s_repId));
		}
		planetoid.setDatestamp(planetoidMap.get(DATESTAMP).toString());
		planetoid.setPlanetoidName(planetoidMap.get(PLANETOID_NAME).toString());
		return planetoid;
	}
	/**
	 * deletes planetoid and planetoid rep
	 * @param planetoid
	 */
	public void deletePlanetoid(Planetoid planetoid) {
		super.jdbcSetUp()
				.getSimpleJdbcTemplate()
				.update(deletePlanetoidRep,
						new Object[] { planetoid.getRepId() });
		super.jdbcSetUp()
				.getSimpleJdbcTemplate()
				.update(deletePlanetoid,
						new Object[] { planetoid.getPlanetoidId() });
	}
}
