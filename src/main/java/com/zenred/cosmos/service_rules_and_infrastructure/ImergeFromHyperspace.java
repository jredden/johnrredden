package com.zenred.cosmos.service_rules_and_infrastructure;

import java.util.List;

import org.apache.log4j.Logger;

import com.zenred.cosmos.domain.Atmosphere;
import com.zenred.cosmos.domain.ClusterFactory;
import com.zenred.cosmos.domain.ClusterRep;
import com.zenred.cosmos.domain.ConfigurationDao;
import com.zenred.cosmos.domain.Planetoid;
import com.zenred.cosmos.domain.Star;
import com.zenred.util.GenRandomRolls;

public class ImergeFromHyperspace {
	
	private static Logger logger = Logger.getLogger(ImergeFromHyperspace.class);
	
	// 25 system matrix
	public static int uDistribution = 5;
	public static int vDistribution = 5;
		
	public static void dontKnowWhereShipIs(){
		 doesKnowWhereShipIs(GenSystem.genSystem());
	}
	
	public static void doesKnowWhereShipIs(com.zenred.cosmos.domain.System system){
		ConfigurationDao configurationDao = new ConfigurationDao();
		Double target = configurationDao.starDensity();

		
		Double startU = system.getUcoordinate()-2; // centre on initial U,V coordinate
		Double startV = system.getVcoordinate()-2;
		
		for(int scalarU = 0;  scalarU < uDistribution ; scalarU++){
			for(int scalarV = 0; scalarV < vDistribution; scalarV++){
				com.zenred.cosmos.domain.System nextSystem = GenSystem.genSystemFromOrigin(startU, startV);
				if(GenSystem.doesSystemExist(nextSystem)){
					logger.info("EXISTING SYSTEM_"+nextSystem);
					continue;
				}
				com.zenred.cosmos.domain.System readSystem = GenSystem.candidate(nextSystem);
				logger.info("NEW SYSTEM_"+readSystem);
				startV += 1.0;
				Double draw = GenRandomRolls.Instance().draw_rand();
				if(draw <= target){
					itsFullOfStars(readSystem);
				}
			}
			startV = system.getVcoordinate()-2;
			startU += 1.0;
		}
	}
	
	/**
	 * 
	 * this is where the stars and everything around them appears
	 * 
	 * @param system
	 */
	private static void itsFullOfStars(com.zenred.cosmos.domain.System system){
		ClusterRep clusterRep = GenCluster.genCluster(system);
		ClusterRep readClusterRep = GenCluster.persist(clusterRep);
		logger.info("CLUSTER_REP:" + readClusterRep);
		ClusterFactory clusterFactory = ClusterFactory
				.fromString(clusterRep.getCluster_description());
		List<Star> starsInCluster = GenStar.persistStars(clusterFactory,
				readClusterRep);
		for (Star star : starsInCluster) {
			logger.info("STAR:" + star);
			List<Planetoid> planetoids = GenPlanet.persistPlanetoids(star);
			if (!planetoids.isEmpty()) {
				GenAtmosphere genAtmosphere = new GenAtmosphere();
				List<Atmosphere> atmospheres = null;
				for (Planetoid planetoid : planetoids){
					atmospheres = genAtmosphere
						.persistAtmosphere(star, planetoid);
					for(Atmosphere atmosphere : atmospheres){
						logger.info("ATMOSPHERE_PART:"+ atmosphere);
					}
				}
			}
		}
	}
}
