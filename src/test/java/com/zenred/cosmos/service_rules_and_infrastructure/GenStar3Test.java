package com.zenred.cosmos.service_rules_and_infrastructure;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zenred.cosmos.domain.ClusterFactory;
import com.zenred.cosmos.domain.ClusterRep;
import com.zenred.cosmos.domain.ClusterRepDao;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.StarDao;
import com.zenred.cosmos.domain.SystemDao;

public class GenStar3Test {

	private static Logger logger = Logger.getLogger(GenStar3Test.class);
	private static SystemDao systemDao = new SystemDao();
	private static ClusterRepDao clusterRepDao = new ClusterRepDao();
	private static StarDao starDao = new StarDao();

	@Test
	public void test() {
		List<com.zenred.cosmos.domain.System> systems = new ArrayList<com.zenred.cosmos.domain.System>();
		List<ClusterRep> clusterReps = new ArrayList<ClusterRep>();
		List<Star> stars = new ArrayList<Star>();
		for (int vbl = 0; vbl < 1000; vbl++) {
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
			for(Star star : stars){
				logger.info("STAR:"+starsInCluster);
			}
			stars.addAll(starsInCluster);
		}

		// cleanup
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
