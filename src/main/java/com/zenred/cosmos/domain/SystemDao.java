package com.zenred.cosmos.domain;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.zenred.johntredden.domain.AbstractJDBCDao;

public class SystemDao extends AbstractJDBCDao {
	
	public static String SYSTEM = "System";
	public static String SYSTEM_ID = "SystemId";
	public static String DISTANCE_TO_GALACTIC_CENTRE = "distance_to_galaxy_centre";
	public static String UCOORDINATE = "ucoordinate";
	public static String VCOORDINATE = "vcoordinate";
	public static String SYSTEM_NAME = "systemName";
	public static String DATESTAMP = "Datestamp";
	
	private String lastInsertSql = "SELECT MAX("+SYSTEM_ID+") FROM "+SYSTEM;
	
	private String readSystemById = "SELECT "
			+ " sy."+SYSTEM_ID+" "
			+ ", sy."+DISTANCE_TO_GALACTIC_CENTRE+" "
			+ ", sy."+UCOORDINATE+" "
			+ ", sy."+VCOORDINATE+" "
			+ ", sy."+SYSTEM_NAME+" "
			+ ", sy."+DATESTAMP+" "
			+ " FROM " + SYSTEM + " sy "
			+ " WHERE sy."+SYSTEM_ID+ " = ?"; 
			;
			
	private String readSystemByName = "SELECT "
			+ " sy."+SYSTEM_ID+" "
			+ ", sy."+DISTANCE_TO_GALACTIC_CENTRE+" "
			+ ", sy."+UCOORDINATE+" "
			+ ", sy."+VCOORDINATE+" "
			+ ", sy."+SYSTEM_NAME+" "
			+ ", sy."+DATESTAMP+" "
			+ " FROM " + SYSTEM + " sy "
			+ " WHERE sy."+SYSTEM_NAME+ " = ?"; 
			;

	private String updateSystemById = "UPDATE " + SYSTEM + " sy SET "
			+ " sy."+DISTANCE_TO_GALACTIC_CENTRE+" = ?  "
			+ ", sy."+UCOORDINATE+" = ?  "
			+ ", sy."+VCOORDINATE+" = ?  "
			+ ", sy."+SYSTEM_NAME+" = ?  "
			+ " WHERE sy."+SYSTEM_ID+ " = ?"; 
			;
	private String deleteSystem = "DELETE FROM " + SYSTEM +  " WHERE "
			 + SYSTEM_ID + " = ?";
			
	/**
	 * create a system
	 * 
	 * @param system
	 * @return created system
	 */
	@Transactional
	public System addSystem(System system) {
		Map<String, Object> map = system.getMap();
		super.jdbcInsertSetup().withTableName(SYSTEM)
				.usingColumns(System.csvSeparatedColumns()).execute(map);
		Integer system_id = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForInt(lastInsertSql);
		return readSystemById(system_id);
	}

	/**
	 * 
	 * @param system_id
	 * @return system
	 */
	public System readSystemById(Integer system_id) {
		System system = new System();
		Object[] param = { system_id };
		Map<String, Object> systemMap = null;
		systemMap = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForMap(readSystemById, param);
		system.setDatestamp((String) systemMap.get(DATESTAMP).toString());
		String s_distance_to_galaxy_centre = systemMap.get(
				DISTANCE_TO_GALACTIC_CENTRE).toString();
		system.setDistance_to_galaxy_centre(new Double(
				s_distance_to_galaxy_centre));
		String s_ucoordinate = systemMap.get(UCOORDINATE).toString();
		system.setUcoordinate(new Double(s_ucoordinate));
		String s_vcoordinate = systemMap.get(VCOORDINATE).toString();
		system.setVcoordinate(new Double(s_vcoordinate));
		system.setSystemName(systemMap.get(SYSTEM_NAME).toString());
		system.setSystemId(system_id);
		return system;
	}
	
	/**
	 * 
	 * @param systemName
	 * @return system
	 */
	public System readSystemByName(String systemName) {
		System system = new System();
		Object[] param = { systemName };
		Map<String, Object> systemMap = null;
		systemMap = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForMap(readSystemByName, param);
		system.setDatestamp((String) systemMap.get(DATESTAMP).toString());
		String s_distance_to_galaxy_centre = systemMap.get(
				DISTANCE_TO_GALACTIC_CENTRE).toString();
		system.setDistance_to_galaxy_centre(new Double(
				s_distance_to_galaxy_centre));
		String s_ucoordinate = systemMap.get(UCOORDINATE).toString();
		system.setUcoordinate(new Double(s_ucoordinate));
		String s_vcoordinate = systemMap.get(VCOORDINATE).toString();
		system.setVcoordinate(new Double(s_vcoordinate));
		system.setSystemName(systemMap.get(SYSTEM_NAME).toString());
		String s_systemId = systemMap.get(SYSTEM_ID).toString();
		system.setSystemId(new Integer(s_systemId));
		return system;
	}
	
	/**
	 * 
	 * @param system
	 * @return updated system
	 */
	public System updateSystemBySystemId(System system) {
		super.jdbcSetUp()
				.getSimpleJdbcTemplate()
				.update(updateSystemById,
						new Object[] {
								system.getDistance_to_galaxy_centre(),
								system.getUcoordinate(),
								system.getVcoordinate(),
								system.getSystemName(), system.getSystemId() });
		return readSystemById(system.getSystemId());
	}
	
	/**
	 * 
	 * @param system to be deleted.
	 */
	public void deleteSystem(System system) {
		super.jdbcSetUp().getSimpleJdbcTemplate()
				.update(deleteSystem, new Object[] { system.getSystemId() });
	}
}