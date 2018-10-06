package com.zenred.cosmos.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Test;

public class ReadAllPlanetoidsTest {

	static private Logger logger = Logger.getLogger(ReadAllPlanetoidsTest.class);
			
	@Test
	public void testReadAllPlanetoids() {
		PlanetoidDao planetoidDao = new PlanetoidDao();
		List<Planetoid> allPlanetoids = new ArrayList<Planetoid>();
		allPlanetoids = planetoidDao.readAllPlanetoids();
		for (Planetoid aPlanetoid : allPlanetoids) {
			logger.info(
					"Planetoid Name:" + aPlanetoid.getPlanetoidName() + " PlanetoidId:" + aPlanetoid.getPlanetoidId());
		}
	}

}
