package com.zenred.cosmos.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.zenred.johntredden.domain.AbstractJDBCDao;
import com.zenred.util.GenRandomRolls;

public class SystemDao extends AbstractJDBCDao {
	
	public static String SYSTEM = "System";
	public static String SYSTEM_ID = "SystemId";
	public static String DISTANCE_TO_GALACTIC_CENTRE = "distance_to_galaxy_centre";
	public static String UCOORDINATE = "ucoordinate";
	public static String VCOORDINATE = "vcoordinate";
	public static String SYSTEM_NAME = "systemName";
	public static String DATESTAMP = "Datestamp";
	
	private static String lastInsertSql = "SELECT MAX("+SYSTEM_ID+") FROM "+SYSTEM;
	
	private static String readSystemById = "SELECT "
			+ " sy."+SYSTEM_ID+" "
			+ ", sy."+DISTANCE_TO_GALACTIC_CENTRE+" "
			+ ", sy."+UCOORDINATE+" "
			+ ", sy."+VCOORDINATE+" "
			+ ", sy."+SYSTEM_NAME+" "
			+ ", sy."+DATESTAMP+" "
			+ " FROM " + SYSTEM + " sy "
			+ " WHERE sy."+SYSTEM_ID+ " = ?" 
			;
			
	private static String readSystemByName = "SELECT "
			+ " sy."+SYSTEM_ID+" "
			+ ", sy."+DISTANCE_TO_GALACTIC_CENTRE+" "
			+ ", sy."+UCOORDINATE+" "
			+ ", sy."+VCOORDINATE+" "
			+ ", sy."+SYSTEM_NAME+" "
			+ ", sy."+DATESTAMP+" "
			+ " FROM " + SYSTEM + " sy "
			+ " WHERE sy."+SYSTEM_NAME+ " = ?"; 
			;

	private static String readEntireSystemByCoordinates = "SELECT "
			+ " sy."+SYSTEM_ID+" "
			+ ", sy."+DISTANCE_TO_GALACTIC_CENTRE+" "
			+ ", sy."+UCOORDINATE+" "
			+ ", sy."+VCOORDINATE+" "
			+ ", sy."+SYSTEM_NAME+" "
			+ ", sy."+DATESTAMP+" "
			+ " FROM " + SYSTEM + " sy "
			+ " WHERE sy."+UCOORDINATE+ " = ? AND sy." + VCOORDINATE + " = ? "
			;

	private static String readSystemByCoordinates = "SELECT COUNT(*) " 
			+ " FROM " + SYSTEM + " sy " + " WHERE sy." + UCOORDINATE
			+ " = ? AND sy." + VCOORDINATE + " = ? "
			;
	
	
	private static String readNumberOfSystems = "SELECT COUNT(*) "
			+  " FROM " + SYSTEM 
			;
	
	private static String updateSystemById = "UPDATE " + SYSTEM + " sy SET "
			+ " sy."+DISTANCE_TO_GALACTIC_CENTRE+" = ?  "
			+ ", sy."+UCOORDINATE+" = ?  "
			+ ", sy."+VCOORDINATE+" = ?  "
			+ ", sy."+SYSTEM_NAME+" = ?  "
			+ " WHERE sy."+SYSTEM_ID+ " = ?"; 
			;
	private static String deleteSystem = "DELETE FROM " + SYSTEM +  " WHERE "
			 + SYSTEM_ID + " = ?";
	
	private static String selectNextSectorUcoordinates = "SELECT sy."
			+ UCOORDINATE + " FROM "
			+ SYSTEM + " sy "
			+ " LIMIT " + " ? "
			+ ", ?";
	
	private static String selectNextSectorVcoordinates = "SELECT sy."
			+ VCOORDINATE + " FROM "
			+ SYSTEM + " sy "
			+ " WHERE sy." + UCOORDINATE + " = ?"
			+ " LIMIT " + " ? "
			+ ", ?";

	private static String randomSystem = 
			"SELECT "
			+ " sy."+SYSTEM_ID+" "
			+ ", sy."+DISTANCE_TO_GALACTIC_CENTRE+" "
			+ ", sy."+UCOORDINATE+" "
			+ ", sy."+VCOORDINATE+" "
			+ ", sy."+SYSTEM_NAME+" "
			+ ", sy."+DATESTAMP+" "
			+ " FROM " + SYSTEM + " sy "
			+ " LIMIT " + " ?, ?";
	
	private static String systemsWithClusters = 
			"SELECT "
			+ " sys."+SYSTEM_NAME+" "
			+ " ,sys."+UCOORDINATE+" "
			+ " ,sys."+VCOORDINATE+" "
			+ " ,clu."+ClusterRepDao.CLUSTER_NAME+" "
			+ " ,clu."+ClusterRepDao.CLUSTER_REP_ID+" "
			+ " FROM " +SYSTEM + " sys "
			+ " INNER JOIN "
			+ ClusterRepDao.CLUSTER_REP + " clu "
			+ " ON sys." + SYSTEM_ID + " = clu." + ClusterRepDao.SYSTEM_ID
			;
			
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
	 * @param uCoordinate
	 * @param vCoordinate
	 * @return system
	 */
	public System readSystemByUVCoordinates(Integer uCoordinate, Integer vCoordinate) {
		System system = new System();
		Object[] param = { uCoordinate, vCoordinate };
		Map<String, Object> systemMap = null;
		systemMap = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForMap(readEntireSystemByCoordinates, param);
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
	/**
	 * 
	 * @param ucoordinate
	 * @param vcoordinate
	 * @return true or false
	 */
	public Boolean doesSystemExist(Double ucoordinate, Double vcoordinate){
		Boolean answer = true;
		Object[] param = { ucoordinate, vcoordinate};
		
		int count  = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForInt(readSystemByCoordinates, ucoordinate, vcoordinate);
		if(0 == count ){
			answer = false;
		}
		return answer;
	}
	
	/**
	 * 
	 * @return number of systems in the database
	 */
	public Long numberOfSystems(){
		long count  = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForInt(readNumberOfSystems);
		return count;
	}
	
	/**
	 * valuable for testing
	 * 
	 * @return random system
	 */
	public System readRandomSystem(){
		System system = new System();
		Integer count =  numberOfSystems().intValue();
		Integer numberOne = GenRandomRolls.Instance().getDX(count);
		Integer numberTwo = 1;
		Object[] param = {numberOne, numberTwo};
		Map<String, Object> systemMap = null;
		systemMap = super.jdbcSetUp().getSimpleJdbcTemplate().queryForMap(randomSystem, param);
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
	 * read U coordinates in a sector 
	 * 
	 * @param start
	 * @param limit sector size
	 * @return list of Ucoordinates defining the sector
	 */
	public List<Integer> readSectorUcoordinates(Integer start, Integer limit){
		List<Integer> systemUcoordinates = new ArrayList<Integer>();
		List<Map<String, Object>> systemListMap = super.jdbcSetUp()
				.getSimpleJdbcTemplate()
				.queryForList(selectNextSectorUcoordinates, start, limit);
		for(Map<String, Object> systemMap: systemListMap){
			// Integer planetoidId = new Integer(planetoidMap.get(PLANETOID_ID).toString());
			Float uCoordinate = new Float(systemMap.get(UCOORDINATE).toString());
			systemUcoordinates.add((int)Math.floor(uCoordinate));
		}
		return systemUcoordinates;
	}
	
	/**
	 * read V coordinates in a sector
	 * 
	 * @param uCoordinate
	 * @param start
	 * @param limit sector size
	 * @return list of Vcoordinates associated with the Ucoordinate 
	 */
	public List<Integer> readSectorVcoordinates(Integer uCoordinate, Integer start, Integer limit){
		List<Integer> systemVcoordinates = new ArrayList<Integer>();
		List<Map<String, Object>> systemListMap = super.jdbcSetUp()
				.getSimpleJdbcTemplate()
				.queryForList(selectNextSectorVcoordinates, uCoordinate, start, limit);
		for(Map<String, Object> systemMap: systemListMap){
			Float vCoordinate = new Float(systemMap.get(VCOORDINATE).toString());
			systemVcoordinates.add((int)Math.floor(vCoordinate));
		}
		return systemVcoordinates;
	}
	

	/**
	 * 
	 * @return list of systems with clusters
	 */
	public List<SystemClusterSubSet> readSystemsWithClusters() {
		ParameterizedRowMapper<SystemClusterSubSet> parameterizedRowMapper = new ParameterizedRowMapper<SystemClusterSubSet>() {

			@Override
			public SystemClusterSubSet mapRow(ResultSet rs, int rowNum) throws SQLException {
				SystemClusterSubSet systemClusterSubSet = new SystemClusterSubSet();
				systemClusterSubSet.setClustername(rs.getString(ClusterRepDao.CLUSTER_NAME));
				systemClusterSubSet.setClusterRepId(rs.getInt(ClusterRepDao.CLUSTER_REP_ID));
				systemClusterSubSet.setSystemName(rs.getString(SYSTEM_NAME));
				systemClusterSubSet.setUcoordinate(rs.getDouble(UCOORDINATE));
				systemClusterSubSet.setVcoordinate(rs.getDouble(VCOORDINATE));
				return systemClusterSubSet;
			}
		};
		List<SystemClusterSubSet> systemsAndClusterData = super.jdbcSetUp().getSimpleJdbcTemplate()
				.query(systemsWithClusters, parameterizedRowMapper);
		return systemsAndClusterData;
	}
}
