package com.zenred.cosmos.service_rules_and_infrastructure;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zenred.cosmos.domain.ClusterRep;
import com.zenred.cosmos.domain.ClusterRepDao;
import com.zenred.cosmos.domain.SystemDao;

public class GenClusterRepTest {

	private static Logger logger = Logger.getLogger(GenClusterRepTest.class);
	private static SystemDao systemDao = new SystemDao();
	private static ClusterRepDao clusterRepDao = new ClusterRepDao();

	@Test
	public void test() {
		List<com.zenred.cosmos.domain.System> systems = new ArrayList<com.zenred.cosmos.domain.System>();
		List<ClusterRep> clusterReps = new ArrayList<ClusterRep>();
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
		}

		// cleanup
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
