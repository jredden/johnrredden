package com.zenred.cosmos.service_rules_and_infrastructure;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zenred.cosmos.domain.SystemDao;
import com.zenred.cosmos.domain.System;
import com.zenred.cosmos.vizualization.ClusterResponse;
import com.zenred.cosmos.vizualization.MoonsResponse;
import com.zenred.cosmos.vizualization.PlanetsResponse;
import com.zenred.cosmos.vizualization.SystemResponse;

public class ReEnterSystemTest {
	
	private static Logger logger = Logger.getLogger(ReEnterSystemTest.class);

	@Test
	public void randomSystmeTest() {
		SystemDao systemDao = new SystemDao();
		System system = systemDao.readRandomSystem();
		SystemResponse result = ImergeFromHyperspace.doesKnowWhereShipIs(system);
		logger.info("RESULT:"+result);
		java.lang.System.out.println("RESULT:"+result);
		assertTrue(result != null);
		ClusterResponse clusterResponse = ExamineSystems.starsInCluster(system.getSystemName());
		logger.info("CLUSTER RESPONSE:"+clusterResponse);
		for (String star :clusterResponse.getStars()){
			PlanetsResponse planetsResponse = ToStarsPlanets.starAndPlanets(star);
			logger.info("STAR:"+star+" PLANETSRESPONSE:"+planetsResponse);
		}

	}

}
