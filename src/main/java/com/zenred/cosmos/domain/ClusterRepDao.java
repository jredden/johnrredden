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
			+ " WHERE sy."+CLUSTER_REP_ID+ " = ?";
			;
			
	private static String deleteClusterRep = "DELETE FROM " + CLUSTER_REP + " WHERE "
			+ CLUSTER_REP_ID + " = ?";
	
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
		
		return clusterRep;
	}
}
