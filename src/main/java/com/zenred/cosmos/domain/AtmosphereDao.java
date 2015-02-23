package com.zenred.cosmos.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.zenred.johntredden.domain.AbstractJDBCDao;

public class AtmosphereDao extends AbstractJDBCDao {
	
	public static final String ATMOSPHERE = "Atmosphere";
	public static final String ATMOSPHERE_ID = "atmosphereId";
	public static final String PLANETOID_ID = "planetoidId";
	public static final String CHEM_NAME = "chem_name";
	public static final String PERCENTAGE = "percentage";
	public static final String DATESTAMP = "datestamp";
	
	private static String lastAtmosphereInsertSql = "SELECT MAX("+ATMOSPHERE_ID+") FROM " + ATMOSPHERE;
	
	private static String readAtmosphereById = "SELECT "
			+ "atm." + ATMOSPHERE_ID + " "  
			+ ", atm." + PLANETOID_ID + " "  
			+ ", atm." + CHEM_NAME + " "  
			+ ", atm." + PERCENTAGE + " "  
			+ ", atm." + DATESTAMP + " "  
			+ " FROM " + ATMOSPHERE + " atm "
			+ " WHERE atm." + ATMOSPHERE_ID + " = ? "
			;
	
	private static String deleteAtmosphere = "DELETE FROM " + ATMOSPHERE + " WHERE "
			+ ATMOSPHERE_ID + " = ? "
			;
	
	private static String readAtmosphereAroundPlanet = "SELECT "
			+ "atm." + ATMOSPHERE_ID + " "  
			+ ", atm." + PLANETOID_ID + " "  
			+ ", atm." + CHEM_NAME + " "  
			+ ", atm." + PERCENTAGE + " "  
			+ ", atm." + DATESTAMP + " "  
			+ " FROM " + ATMOSPHERE + " atm "
			+ " INNER JOIN "
			+ PlanetoidDao.PLANETOID + " plt "
			+ " ON atm." + PLANETOID_ID + " =  plt." + PLANETOID_ID
			+ " WHERE plt." + PLANETOID_ID + " = ? "
			;
	
	/**
	 * 
	 * @param atmosphere
	 * @return Atmosphere
	 */
	@Transactional
	public Atmosphere addAtmosphere(Atmosphere atmosphere) {
		Map<String, Object> atmosphereMap = Atmosphere.getAtmosphereMap(
				atmosphere.getPlanetoidId(), atmosphere.getChem_name(),
				atmosphere.getPercentage());
		super.jdbcInsertSetup().withTableName(ATMOSPHERE)
				.usingColumns(Atmosphere.csvAtmosphere())
				.execute(atmosphereMap);
		Integer atmosphereId = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForInt(lastAtmosphereInsertSql);
		atmosphere.setAtmosphereId(atmosphereId);
		return readAtmosphereById(atmosphere.getAtmosphereId());
	}
	/**
	 * 
	 * @param atmosphereId
	 * @return Atmosphere
	 */
	public Atmosphere readAtmosphereById(Integer atmosphereId){
		Object[] param = {atmosphereId};
		Map<String, Object> atmosphereMap = super.jdbcSetUp().getSimpleJdbcTemplate().queryForMap(readAtmosphereById, param);
		return buildAtmosphere(atmosphereMap);
	}
	
	/**
	 * 
	 * @param atmosphere
	 * @return list of planets atmospheres
	 */
	public List<Atmosphere> readAtmosphereAroundPlanet(Planetoid planetoid){
		List<Atmosphere> atmospheres = new ArrayList<Atmosphere>();
		List<Map<String, Object>> atmosphereListMap = super.jdbcSetUp()
				.getSimpleJdbcTemplate()
				.queryForList(readAtmosphereAroundPlanet, planetoid.getPlanetoidId());
		for(Map<String, Object> atmosphereMap: atmosphereListMap){
			Atmosphere atmosphere2 = buildAtmosphere(atmosphereMap);
			atmospheres.add(atmosphere2);
		}
		return atmospheres;
	}
	/**
	 * 
	 * @param atmosphereMap
	 * @return Atmosphere
	 */
	private Atmosphere buildAtmosphere(Map<String, Object> atmosphereMap){
		Atmosphere atmosphere = new Atmosphere();
		String s_atmosphere = atmosphereMap.get(ATMOSPHERE_ID).toString();
		atmosphere.setAtmosphereId(new Integer(s_atmosphere));
		String s_planetoidId = atmosphereMap.get(PLANETOID_ID).toString();
		atmosphere.setPlanetoidId(new Integer(s_planetoidId));
		atmosphere.setChem_name(atmosphereMap.get(CHEM_NAME).toString());
		String s_percenetage = atmosphereMap.get(PERCENTAGE).toString();
		atmosphere.setPercentage(new Double(s_percenetage));
		atmosphere.setDatestamp(atmosphereMap.get(DATESTAMP).toString());
		return atmosphere;

		
	}
	/**
	 * 
	 * @param atmosphere
	 */
	public void deleteAtmosphere(Atmosphere atmosphere){
		super.jdbcSetUp()
		.getSimpleJdbcTemplate()
		.update(deleteAtmosphere,
				new Object[] {atmosphere.getAtmosphereId()});
	}
}
