package com.zenred.cosmos.domain;

import java.util.List;

public class ExistingSystemWithStars {
	
	private static StarDao starDao;
	private static PlanetoidDao planetoidDao;
	static{
		starDao = new StarDao();
		planetoidDao = new PlanetoidDao();
	}
	
	/**
	 * 
	 * @param system
	 * @return cluster rep
	 */
	public static ClusterRep readCluster(System system){
		ClusterRepDao clusterRepDao = new ClusterRepDao();
		return clusterRepDao.readClusterRepBySystemId(system);
	}

	/**
	 * 
	 * @param clusterRep
	 * @return list of stars
	 */
	public static List<Star> readStarsInCluster(ClusterRep clusterRep){
		return starDao.readStarsInCluster(clusterRep);
		
	}
	
	/**
	 * 
	 * @param star
	 * @return sub cluster description
	 */
	public static String readSubClusterDesdcription(Star star){
		return starDao.readStarsSubClusterDescription(star);
	}
	
	/**
	 * 
	 * @param star
	 * @return collated planetoid list
	 */
	public static List<UnifiedPlanetoidI> readPlanetsAroundStar(Star star){
		return planetoidDao.readPlanetoidsAroundStar(star);
	}

}
