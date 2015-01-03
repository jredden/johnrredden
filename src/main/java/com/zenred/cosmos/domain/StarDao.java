package com.zenred.cosmos.domain;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.zenred.johntredden.domain.AbstractJDBCDao;

public class StarDao extends AbstractJDBCDao {
	
	public static String STAR = "Star";
	public static String STAR_ID = "starId";
	public static String CLUSTER_TO_STAR_ID_2 = "clusterToStarId";
	public static String NAME = "Name";
	public static String DISTANCE_CLUST_VIRT_CENTRE ="distance_clust_virt_centre";
	public static String LUMINOSITY = "luminosity";
	public static String NO_PLANETS_ALLOWED = "no_planets_allowed";
	public static String ANGLE_IN_RADIANS_S = "angle_in_radians_s";
	public static String STAR_COLOR = "star_color";
	public static String STAR_TYPE = "star_type";
	public static String STAR_SIZE = "star_size";
	public static String DATESTAMP = "Datestamp";

	public static String CLUSTER_TO_STAR = "ClusterToStar";
	public static String CLUSTER_TO_STAR_ID = "clusterToStarId";
	public static String CLUSTER_REP_ID = "clusterRepId";
	public static String SUB_CLUSTER_DESCRIPTION = "sub_cluster_description";
	public static String DATESTAMP2 = "Datestamp";
	
	public static String CLUSTER_REP = "ClusterRep";
	
	private static String lastStarInsertSql = "SELECT MAX("+STAR_ID+") FROM "+STAR;
	private static String lastClusterToStarInsertSql = "SELECT MAX("+CLUSTER_TO_STAR_ID+") FROM "+CLUSTER_TO_STAR;
	
	private static String readStarById = "SELECT "
			+ "st."+STAR_ID+" "
			+ ", st."+CLUSTER_TO_STAR_ID_2+" "
			+ ", st."+NAME+" "
			+ ", st."+DISTANCE_CLUST_VIRT_CENTRE+" "
			+ ", st."+LUMINOSITY+" "
			+ ", st."+NO_PLANETS_ALLOWED+" "
			+ ", st."+ANGLE_IN_RADIANS_S+" "
			+ ", st."+STAR_COLOR+" "
			+ ", st."+STAR_TYPE+" "
			+ ", st."+STAR_SIZE+" "
			+ ", st."+DATESTAMP+" "
			+ " FROM "+ STAR + " st "
			+ " WHERE st."+STAR_ID+ " = ?" 
		;

	private static String updateStarById = "UPDATE " + STAR + " st SET "
			+ " st."+CLUSTER_TO_STAR_ID_2+" "
			+ ", st."+NAME+" "
			+ ", st."+DISTANCE_CLUST_VIRT_CENTRE+" "
			+ ", st."+LUMINOSITY+" "
			+ ", st."+NO_PLANETS_ALLOWED+" "
			+ ", st."+ANGLE_IN_RADIANS_S+" "
			+ ", st."+STAR_COLOR+" "
			+ ", st."+STAR_TYPE+" "
			+ ", st."+STAR_SIZE+" "		
			+ " WHERE st."+STAR_ID+ " = ?"
			;
	
	private static String deleteStar = "DELETE FROM " + STAR + " WHERE "
			+ STAR_ID + " = ?";

	private static String deleteClusterToStar = "DELETE FROM " + CLUSTER_TO_STAR + " WHERE "
			+ CLUSTER_TO_STAR_ID + " = ?";
	
	private static String readStarsInCluster = "SELECT "
			+ "st."+STAR_ID+" "
			+ ", st."+CLUSTER_TO_STAR_ID_2+" "
			+ ", st."+NAME+" "
			+ ", st."+DISTANCE_CLUST_VIRT_CENTRE+" "
			+ ", st."+LUMINOSITY+" "
			+ ", st."+NO_PLANETS_ALLOWED+" "
			+ ", st."+ANGLE_IN_RADIANS_S+" "
			+ ", st."+STAR_COLOR+" "
			+ ", st."+STAR_TYPE+" "
			+ ", st."+STAR_SIZE+" "
			+ ", st."+DATESTAMP+" "
			+ " FROM "+ STAR + " st "
			+ " INNER JOIN "
			+ CLUSTER_TO_STAR + " cts "
			+ " ON st." + CLUSTER_TO_STAR_ID_2 + " = cts." + CLUSTER_TO_STAR_ID
			+ " INNER JOIN "
			+ CLUSTER_REP + " cr "
			+ " ON cts." + CLUSTER_REP_ID + " = " + "cr." + CLUSTER_REP_ID
			+ " WHERE cr." + CLUSTER_REP_ID + " = ?"
			;
	
	private static String readStarsSubCluster = "SELECT "
			+ "cts." + SUB_CLUSTER_DESCRIPTION+ " "
			+ " FROM " + CLUSTER_TO_STAR + " cts "
			+ " INNER JOIN "
			+ STAR + " st "
			+ " ON cts." + CLUSTER_TO_STAR_ID + " = st." + CLUSTER_TO_STAR_ID_2
			+ " WHERE st." + STAR_ID + " = ?"
			;
	
	@Transactional
	public Star addStar(Star star, ClusterRep clusterRep,
			String subClusterFactoryType) {
		Map<String, Object> clusterToStarMap = star.getClusterToStarMap(
				clusterRep.getClusterRepId(),
				SubClusterFactory.valueOf(subClusterFactoryType).name());
		super.jdbcInsertSetup().withTableName(CLUSTER_TO_STAR)
				.usingColumns(Star.csvClusterToStarSeparatedColumns())
				.equals(clusterToStarMap);
		Integer clusterToStarId = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForInt(lastClusterToStarInsertSql);
		star.setClusterToStarId(clusterToStarId);
		Map<String, Object> starMap = star.getStarMap();
		super.jdbcInsertSetup().withTableName(STAR)
				.usingColumns(Star.csvStarSeparatedColumns()).execute(starMap);
		Integer starId = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForInt(lastStarInsertSql);
		return readStarById(starId);
	}
	
	public Star readStarById(Integer starId){
		Star star = new Star();
		
		return star;
	}
}
