package com.zenred.cosmos.service_rules_and_infrastructure;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.zenred.cosmos.domain.Atmosphere;
import com.zenred.cosmos.domain.AtmosphereParts;
import com.zenred.cosmos.domain.ClusterFactory;
import com.zenred.cosmos.domain.ClusterRep;
import com.zenred.cosmos.domain.ConfigurationDao;
import com.zenred.cosmos.domain.Planetoid;
import com.zenred.cosmos.domain.RenamedSystem;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.SystemDao;
import com.zenred.cosmos.vizualization.NamedSystemResponse;
import com.zenred.cosmos.vizualization.NamedSystemVizCentric;
import com.zenred.cosmos.vizualization.SystemResponse;
import com.zenred.cosmos.vizualization.SystemVizCentric;
import com.zenred.util.GenRandomRolls;

public class ImergeFromHyperspace {
	
	private static Logger logger = Logger.getLogger(ImergeFromHyperspace.class);
	
	// 25 system matrix
	public static int uDistribution = 5;
	public static int vDistribution = 5;
		
	public static SystemResponse dontKnowWhereShipIs(){
		 return doesKnowWhereShipIs(GenSystem.genSystem());
	}
	
	public static SystemResponse reEntry(String starSystemName){
		SystemDao systemDao = new SystemDao();
		com.zenred.cosmos.domain.System existingSystem = systemDao.readSystemByName(starSystemName);
		return doesKnowWhereShipIs(existingSystem);
	}
	
	public static SystemResponse doesKnowWhereShipIs(com.zenred.cosmos.domain.System system){
		ConfigurationDao configurationDao = new ConfigurationDao();
		Double target = configurationDao.starDensity();
		SystemDao systemDao = new SystemDao();
		
		List<SystemVizCentric> systemVizCentrics = new ArrayList<SystemVizCentric>();

		
		Double startU = system.getUcoordinate()-2; // centre on initial U,V coordinate
		Double startV = system.getVcoordinate()-2;
		
		for(int scalarU = 0;  scalarU < uDistribution ; scalarU++){
			for(int scalarV = 0; scalarV < vDistribution; scalarV++){
				com.zenred.cosmos.domain.System nextSystem = GenSystem.genSystemFromOrigin(startU, startV);
				if(GenSystem.doesSystemExist(nextSystem)){
					logger.info("EXISTING SYSTEM_"+nextSystem);
					com.zenred.cosmos.domain.System existingSystem = systemDao.readSystemByName(nextSystem.getSystemName());
					addVizCentricSystem(systemVizCentrics, existingSystem);
					startV += 1.0;
					continue;
				}
				com.zenred.cosmos.domain.System readSystem = GenSystem.candidate(nextSystem);
				logger.info("NEW SYSTEM_"+readSystem);
				addVizCentricSystem(systemVizCentrics, readSystem);
				startV += 1.0;
				Double draw = GenRandomRolls.Instance().draw_rand();
				if(draw <= target){
					itsFullOfStars(readSystem);
				}
			}
			startV = system.getVcoordinate()-2;
			startU += 1.0;
		}
		
		return buildSystemResponse(systemVizCentrics);
	}
	
	public static NamedSystemResponse shipInNamedSystem(RenamedSystem renamedSystem){
		SystemDao systemDao = new SystemDao();
		NamedSystemVizCentric namedSystemVizCentric = new NamedSystemVizCentric();
		NamedSystemResponse namedSystemResponse = new NamedSystemResponse();
		com.zenred.cosmos.domain.System system = renamedSystem.fetchSystem();
		com.zenred.cosmos.domain.System existingSystem = systemDao.readSystemByName(system.getSystemName());
		namedSystemVizCentric.setDistance_to_galaxy_centre(system.getDistance_to_galaxy_centre());
		namedSystemVizCentric.setSystemName(system.getSystemName());
		namedSystemVizCentric.setUcoordinate(system.getUcoordinate());
		namedSystemVizCentric.setVcoordinate(system.getVcoordinate());
		namedSystemVizCentric.setRenames(renamedSystem.fetchRenames());
		namedSystemResponse.setNamedSystemVizCentric(namedSystemVizCentric);
		return namedSystemResponse;
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
						if(atmosphere.getChem_name().equals(AtmosphereParts.Water.getText())){
							planetoid.setPercentWater(atmosphere.getPercentage());
						}
						logger.info("PLANETOID ATMOSPHERE_PART:"+ atmosphere);
					}
					List<Planetoid> moonsList = new ArrayList<Planetoid>();	// for debugging
					List<Planetoid>moons = GenMoon.persistPlanetoids(star, planetoid);
					if(!moons.isEmpty()){
						moonsList.addAll(moons);
					}
					List<Atmosphere> moonAtmospheres = null;
					for(Planetoid moon : moons){
						moonAtmospheres = genAtmosphere.persistAtmosphere(star, moon);
						for(Atmosphere 	atmosphere : moonAtmospheres){
							logger.info("MOON ATMOSPHERE_PART:"+ atmosphere);
						}
					}
				}
			}
		}
	}
	
	private static void addVizCentricSystem(List<SystemVizCentric> systemVizCentrics, com.zenred.cosmos.domain.System system){
		SystemVizCentric systemVizCentric = new SystemVizCentric();
		systemVizCentric.setDistance_to_galaxy_centre(system.getDistance_to_galaxy_centre());
		systemVizCentric.setSystemName(system.getSystemName());
		systemVizCentric.setUcoordinate(system.getUcoordinate());
		systemVizCentric.setVcoordinate(system.getVcoordinate());
		systemVizCentrics.add(systemVizCentric);
	}
	
	
	private static SystemResponse buildSystemResponse( List<SystemVizCentric> systemVizCentrics){
		SystemResponse systemResponse = new SystemResponse();
		Object[] stuff =  systemVizCentrics.toArray();
		SystemVizCentric [] systemVizCentricArray = new SystemVizCentric[stuff.length];
		int idex = 0;
		for(Object thingie : stuff){
			systemVizCentricArray[idex] = (SystemVizCentric) stuff[idex];
			++idex;
		}
		systemResponse.setSystemVizCentrics(systemVizCentricArray);
		return systemResponse;
	}
	
}
