package com.zenred.cosmos.service_rules_and_infrastructure;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zenred.cosmos.domain.ClusterFactory;
import com.zenred.cosmos.domain.ClusterRep;
import com.zenred.cosmos.domain.ClusterRepDao;
import com.zenred.cosmos.domain.Planetoid;
import com.zenred.cosmos.domain.PlanetoidDao;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.StarDao;
import com.zenred.cosmos.domain.SystemDao;

public class GenPlanetTest {

	private static Logger logger = Logger.getLogger(GenPlanetTest.class);
	private static SystemDao systemDao = new SystemDao();
	private static ClusterRepDao clusterRepDao = new ClusterRepDao();
	private static StarDao starDao = new StarDao();
	private static PlanetoidDao PlanetoidDao = new PlanetoidDao();

	@Test
	public void test() {
		List<com.zenred.cosmos.domain.System> systems = new ArrayList<com.zenred.cosmos.domain.System>();
		List<ClusterRep> clusterReps = new ArrayList<ClusterRep>();
		List<Star> stars = new ArrayList<Star>();
		List<Planetoid> planetoidsList = new ArrayList<Planetoid>();
		for (int vbl = 0; vbl < 100; vbl++) {
			com.zenred.cosmos.domain.System system = GenSystem.genSystem();
			com.zenred.cosmos.domain.System readSystem = GenSystem
					.candidate(system);
			logger.info("SYSTEM_" + vbl + ":" + readSystem);
			ClusterRep clusterRep = GenCluster.genCluster(readSystem);
			ClusterRep readClusterRep = GenCluster.persist(clusterRep);
			logger.info("CLUSTER_REP:"+readClusterRep);
			clusterReps.add(readClusterRep);
			systems.add(readSystem);
			ClusterFactory clusterFactory = ClusterFactory.fromString(clusterRep.getCluster_description());
			List<Star> starsInCluster = GenStar.persistStars(clusterFactory, readClusterRep);
			for(Star star : starsInCluster){
				logger.info("STAR:"+star);
				List<Planetoid> planetoids = GenPlanet.persistPlanetoids(star);
				if(!planetoids.isEmpty()){
					planetoidsList.addAll(planetoids);
				}
			}
			stars.addAll(starsInCluster);
		}

		// cleanup
		logger.info("Cleaning up Planets");
		for(Planetoid planetoid : planetoidsList){
			PlanetoidDao.deletePlanetoid(planetoid);
		}
		logger.info("Cleaning up stars");
		for(Star star : stars){
			starDao.deleteStar(star);
		}

		logger.info("Cleaning up cluster reps");
		for(ClusterRep clusterRep : clusterReps){
			clusterRepDao.deleteClusterRep(clusterRep);
		}
		logger.info("Cleaning up systems");
		for (com.zenred.cosmos.domain.System system : systems) {
			systemDao.deleteSystem(system);
		}
	}

}
