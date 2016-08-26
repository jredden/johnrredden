package com.zenred.cosmos.domain;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

public class SystemsWithClustersTest {
	
	private static Logger logger = Logger.getLogger(SystemsWithClustersTest.class);

	@Test
	public void test() {
		SystemDao systemDao = new SystemDao();
		List<SystemClusterSubSet> list = systemDao.readSystemsWithClusters();
		for(SystemClusterSubSet systemClusterSubSet : list){
			logger.info(systemClusterSubSet);
		}
	}

}
