package com.zenred.cosmos.domain;

import java.util.ArrayList;
import java.util.List;
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
			+ " st."+CLUSTER_TO_STAR_ID_2+" = ? "
			+ ", st."+NAME+" = ? "
			+ ", st."+DISTANCE_CLUST_VIRT_CENTRE+" = ? "
			+ ", st."+LUMINOSITY+" = ? "
			+ ", st."+NO_PLANETS_ALLOWED+" = ? "
			+ ", st."+ANGLE_IN_RADIANS_S+" = ? "
			+ ", st."+STAR_COLOR+" = ? "
			+ ", st."+STAR_TYPE+" = ? "
			+ ", st."+STAR_SIZE+" = ? "		
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
	/**
	 * 
	 * @param star
	 * @param clusterRep
	 * @param subClusterFactoryType
	 * @return fully built star with primary key of cluster to star join table.
	 */
	@Transactional
	public Star addStar(Star star, ClusterRep clusterRep,
			String subClusterFactoryType) {
		String subClusterType = SubClusterFactory.valueOf(subClusterFactoryType).name();
		Map<String, Object> clusterToStarMap = star.getClusterToStarMap(
				clusterRep.getClusterRepId(), subClusterType);
		super.jdbcInsertSetup().withTableName(CLUSTER_TO_STAR)
				.usingColumns(Star.csvClusterToStarSeparatedColumns())
				.execute(clusterToStarMap);
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
	
	/**
	 * 
	 * @param starId
	 * @return star
	 */
	public Star readStarById(Integer starId){
		Star star = new Star();
		Object[] param = {starId};
		Map<String, Object> starMap = null;
		starMap = super.jdbcSetUp().getSimpleJdbcTemplate().queryForMap(readStarById, param);
		String s_clusterToStarId = starMap.get(CLUSTER_TO_STAR_ID_2).toString();
		star.setClusterToStarId(new Integer(s_clusterToStarId));
		star.setName(starMap.get(NAME).toString());
		String s_distance_clust_virt_centre = starMap.get(DISTANCE_CLUST_VIRT_CENTRE).toString();
		star.setDistance_clust_virt_centre(new Double(s_distance_clust_virt_centre));
		String s_luminosity = starMap.get(LUMINOSITY).toString();
		star.setLuminosity(new Double(s_luminosity));
		String s_angle_in_radians_s = starMap.get(ANGLE_IN_RADIANS_S).toString();
		star.setAngle_in_radians_s(new Double(s_angle_in_radians_s));
		star.setStar_color(starMap.get(STAR_COLOR).toString());
		star.setStar_type(starMap.get(STAR_TYPE).toString());
		String s_star_size = starMap.get(STAR_SIZE).toString();
		star.setStar_size(new Double(s_star_size));
		String s_no_planets_allowed = null;
		if(null == starMap.get(NO_PLANETS_ALLOWED)){
			s_no_planets_allowed = "0";
		}
		else{
			s_no_planets_allowed = starMap.get(NO_PLANETS_ALLOWED).toString();
		}
		if(s_no_planets_allowed.equals("0")){
			star.setNo_planets_allowed(Boolean.FALSE);
		}
		else{
			star.setNo_planets_allowed(Boolean.TRUE);
		}
		star.setDatestamp((String) starMap.get(DATESTAMP).toString());
		String s_starId = starMap.get(STAR_ID).toString();
		star.setStarId(new Integer(s_starId));
		return star;
	}
	
	/**
	 * 
	 * @param star
	 * @return updated star
	 */
	@Transactional
	public Star updateStarByStarId(Star star){
		super.jdbcSetUp()
		.getSimpleJdbcTemplate()
		.update(updateStarById,new Object[]{
				star.getClusterToStarId(),
				star.getName(),
				star.getDistance_clust_virt_centre(),
				star.getLuminosity(),
				star.getNo_planets_allowed(),
				star.getAngle_in_radians_s(),
				star.getStar_color(),
				star.getStar_type(),
				star.getStar_size(),
				star.getStarId()
		});
		return readStarById(star.getStarId());
	}

	/**
	 * deletes the star and the cluster to star row associated with it.
	 * 
	 * @param star
	 */
	@Transactional
	public void deleteStar(Star star) {
		super.jdbcSetUp()
				.getSimpleJdbcTemplate()
				.update(deleteClusterToStar,
						new Object[] { star.getClusterToStarId() });
		super.jdbcSetUp().getSimpleJdbcTemplate()
				.update(deleteStar, new Object[] { star.getStarId() });
	}
	
	/**
	 * refactor out common method later.
	 * 
	 * @param clusterRep
	 * @return list of stars
	 */
	public List<Star> readStarsInCluster(ClusterRep clusterRep){
		List<Star> starList = new ArrayList<Star>();
		List<Map<String, Object>> starListMap =  super.jdbcSetUp()
				.getSimpleJdbcTemplate()
				.queryForList(readStarsInCluster, clusterRep.getClusterRepId());
		for (Map<String, Object> starMap: starListMap){
			Star star = new Star();
			String s_angle_in_radians_s = starMap.get(ANGLE_IN_RADIANS_S).toString();
			star.setAngle_in_radians_s(new Double(s_angle_in_radians_s));
			String s_clusterToStarId = starMap.get(CLUSTER_TO_STAR_ID_2).toString();
			star.setClusterToStarId(new Integer(s_clusterToStarId));
			star.setDatestamp((String) starMap.get(DATESTAMP).toString());
			String s_distance_clust_virt_centre = starMap.get(DISTANCE_CLUST_VIRT_CENTRE).toString();
			star.setDistance_clust_virt_centre(new Double(s_distance_clust_virt_centre));
			String s_luminosity = starMap.get(LUMINOSITY).toString();
			star.setLuminosity(new Double(s_luminosity));
			star.setName(starMap.get(NAME).toString());
			String s_no_planets_allowed = null;
			if(null == starMap.get(NO_PLANETS_ALLOWED)){
				s_no_planets_allowed = "0";
			}
			else{
				s_no_planets_allowed = starMap.get(NO_PLANETS_ALLOWED).toString();
			}
			if(s_no_planets_allowed.equals("0")){
				star.setNo_planets_allowed(Boolean.FALSE);
			}
			else{
				star.setNo_planets_allowed(Boolean.TRUE);
			}
			star.setStar_color(starMap.get(STAR_COLOR).toString());
			String s_star_size = starMap.get(STAR_SIZE).toString();
			star.setStar_size(new Double(s_star_size));
			star.setStar_type(starMap.get(STAR_TYPE).toString());
			String s_starId = starMap.get(STAR_ID).toString();
			star.setStarId(new Integer(s_starId));
			starList.add(star);
		}
		return starList;
	}
}
