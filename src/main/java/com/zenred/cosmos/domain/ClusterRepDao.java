package com.zenred.cosmos.domain;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.zenred.johntredden.domain.AbstractJDBCDao;

public class ClusterRepDao extends AbstractJDBCDao{
	
	public static String CLUSTER_REP = "ClusterRep";
	public static String CLUSTER_REP_ID = "clusterRepID";
	public static String SYSTEM_ID = "systemId";
	public static String CLUSTER_NAME = "clusterName";
	public static String DISTANCE_SYS_VIRT_CENTRE = "distance_sys_virt_centre";
	public static String ANGLE_IN_RADIANS = "angle_in_radians";
	public static String CLUSTER_DESCRIPTION = "cluster_description";
	public static String DATESTAMP = "Datestamp";
	
	private static String lastInsertSql = "SELECT MAX("+CLUSTER_REP_ID+") FROM "+CLUSTER_REP;
	
	private static String readClusterRepById = "SELECT "
			+ "cr."+CLUSTER_REP_ID+" "
			+ ", cr."+SYSTEM_ID+" "
			+ ", cr."+CLUSTER_NAME+" "
			+ ", cr."+DISTANCE_SYS_VIRT_CENTRE+" "
			+ ", cr."+ANGLE_IN_RADIANS+" "
			+ ", cr."+CLUSTER_DESCRIPTION+" "
			+ ", cr."+DATESTAMP+" "
			+ " FROM " + CLUSTER_REP + " cr "
			+ " WHERE cr."+CLUSTER_REP_ID+ " = ?" 
			;
	
	private static String readClusterRepByName = "SELECT "
			+ "cr."+CLUSTER_REP_ID+" "
			+ ", cr."+SYSTEM_ID+" "
			+ ", cr."+CLUSTER_NAME+" "
			+ ", cr."+DISTANCE_SYS_VIRT_CENTRE+" "
			+ ", cr."+ANGLE_IN_RADIANS+" "
			+ ", cr."+CLUSTER_DESCRIPTION+" "
			+ ", cr."+DATESTAMP+" "
			+ " FROM " + CLUSTER_REP + " cr "
			+ " WHERE cr."+CLUSTER_NAME+ " = ?" 
			;
	
	private static String updateClusterRepById = "UPDATE "+ CLUSTER_REP + " cr SET "
			+ " cr."+SYSTEM_ID+" = ? "
			+ ", cr."+CLUSTER_NAME+" = ? "
			+ ", cr."+DISTANCE_SYS_VIRT_CENTRE+" = ? "
			+ ", cr."+ANGLE_IN_RADIANS+" = ? "
			+ ", cr."+CLUSTER_DESCRIPTION+" = ? "
			+ " WHERE cr."+CLUSTER_REP_ID+ " = ?";
			;
			
	private static String deleteClusterRep = "DELETE FROM " + CLUSTER_REP + " WHERE "
			+ CLUSTER_REP_ID + " = ?";
	
	private static String areThereStarsInTheSystem = "SELECT COUNT(*) FROM " + CLUSTER_REP 
			+ " WHERE " + SYSTEM_ID + " = ?"
			;
	
	/**
	 * create a cluster representation
	 * 
	 * @param clusterRep
	 * @return
	 */
	@Transactional
	public ClusterRep addClusterRep(ClusterRep clusterRep){
		Map<String, Object> map = clusterRep.getMap();
		super.jdbcInsertSetup().withTableName(CLUSTER_REP)
		.usingColumns(ClusterRep.csvSeparatedColumns()).execute(map);
		Integer cluster_rep_id = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForInt(lastInsertSql);
		return readClusterRepById(cluster_rep_id);
	}
	
	/**
	 * 
	 * @param clusterRep_id
	 * @return cluster rep
	 */
	public ClusterRep readClusterRepById(Integer clusterRep_id){
		ClusterRep clusterRep = new ClusterRep();
		Object[] param = { clusterRep_id };
		Map<String, Object> clusterRepMap = null;
		clusterRepMap = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForMap(readClusterRepById, param);
		String s_angleInRadians = clusterRepMap.get(ANGLE_IN_RADIANS).toString();
		clusterRep.setAngle_in_radians(new Double(s_angleInRadians));
		clusterRep.setCluster_description(clusterRepMap.get(CLUSTER_DESCRIPTION).toString());
		clusterRep.setClusterName(clusterRepMap.get(CLUSTER_NAME).toString());
		clusterRep.setDateStamp(clusterRepMap.get(DATESTAMP).toString());
		String s_distance_sys_virt_centre = clusterRepMap.get(DISTANCE_SYS_VIRT_CENTRE).toString();
		clusterRep.setDistance_sys_virt_centre(new Double(s_distance_sys_virt_centre));
		String s_systemId = clusterRepMap.get(SYSTEM_ID).toString();
		clusterRep.setSystemId(new Integer(s_systemId));
		clusterRep.setClusterRepId(clusterRep_id);
		return clusterRep;
	}
	
	/**
	 * 
	 * @param clusterRep_Name
	 * @return cluster rep
	 */
	public ClusterRep readClusterRepByName(String clusterRep_Name){
		ClusterRep clusterRep = new ClusterRep();
		Object[] param = { clusterRep_Name};
		Map<String, Object> clusterRepMap = null;
		clusterRepMap = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForMap(readClusterRepByName, param);
		String s_angleInRadians = clusterRepMap.get(ANGLE_IN_RADIANS).toString();
		clusterRep.setAngle_in_radians(new Double(s_angleInRadians));
		clusterRep.setCluster_description(clusterRepMap.get(CLUSTER_DESCRIPTION).toString());
		clusterRep.setClusterName(clusterRepMap.get(CLUSTER_NAME).toString());
		clusterRep.setDateStamp(clusterRepMap.get(DATESTAMP).toString());
		String s_distance_sys_virt_centre = clusterRepMap.get(DISTANCE_SYS_VIRT_CENTRE).toString();
		clusterRep.setDistance_sys_virt_centre(new Double(s_distance_sys_virt_centre));
		String s_systemId = clusterRepMap.get(SYSTEM_ID).toString();
		clusterRep.setSystemId(new Integer(s_systemId));
		String s_clusterRep_id = clusterRepMap.get(CLUSTER_REP_ID).toString();
		clusterRep.setClusterRepId(new Integer(s_clusterRep_id));
		return clusterRep;
	}
	
	/**
	 * 
	 * @param clusterRep
	 * @return cluster rep
	 */
	@Transactional
	public ClusterRep updateClusterRepBySystemId(ClusterRep clusterRep) {
		super.jdbcSetUp()
				.getSimpleJdbcTemplate()
				.update(updateClusterRepById,
						new Object[] { clusterRep.getSystemId(),
								clusterRep.getClusterName(),
								clusterRep.getDistance_sys_virt_centre(),
								clusterRep.getAngle_in_radians(),
								clusterRep.getCluster_description(),
								clusterRep.getClusterRepId()
								});
		return readClusterRepById(clusterRep.getClusterRepId());
	}

	/**
	 * 
	 * @param clusterRep
	 */
	public void deleteClusterRep(ClusterRep clusterRep) {
		super.jdbcSetUp()
				.getSimpleJdbcTemplate()
				.update(deleteClusterRep,
						new Object[] { clusterRep.getClusterRepId() });
	}
	
	/**
	 * 
	 * @param system
	 * @return whether there are stars in the system
	 */
	public Boolean areThereStarsInSystem(System system){
		Boolean answer = false;
		Integer numberOfClusters = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForInt(areThereStarsInTheSystem, system.getSystemId());
		if(numberOfClusters > 0){
			answer = true;
		}
		return answer;
	}
}
