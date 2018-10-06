package com.zenred.cosmos.domain;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Test;

public class ReadAllClustersTest {
	
	static private Logger logger = Logger.getLogger(ReadAllClustersTest.class);

	@Test
	public void test() {
		ClusterRepDao clusterRepDao = new ClusterRepDao();
		List<ClusterRep> allClusterReps = new ArrayList<ClusterRep>();
		allClusterReps = clusterRepDao.readAllClusterReps();
		for (ClusterRep aClusterRep : allClusterReps) {
			logger.info("ClusterRep name:" + aClusterRep.getClusterName() + " ClusterRepId:"
					+ aClusterRep.getClusterRepId());
		}

	}

}
