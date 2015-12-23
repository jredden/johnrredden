package com.zenred.cosmos.domain;

import java.util.List;

public class ExistingSystemWithStars {
	
	private static StarDao starDao;
	private static PlanetoidDao planetoidDao;
	private static ClusterRepDao clusterRepDao;
	static{
		starDao = new StarDao();
		planetoidDao = new PlanetoidDao();
		clusterRepDao = new ClusterRepDao();
	}
	
	/**
	 * 
	 * @param system
	 * @return cluster rep
	 */
	public static ClusterRep readCluster(System system){
		return clusterRepDao.readClusterRepBySystemId(system);
	}
	
	/**
	 * 
	 * @param system
	 * @return true or false 
	 */
	public static Boolean areThereStars(System system){
		return clusterRepDao.areThereStarsInSystem(system);
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
	
	/**
	 * 
	 * @param planetoid
	 * @return list of moons
	 */
	public static List<UnifiedPlanetoidI> readMoonsAroundPlanet(Planetoid planetoid){
		return planetoidDao.readMoonsAroundPlanetoid(planetoid);
	}

}
