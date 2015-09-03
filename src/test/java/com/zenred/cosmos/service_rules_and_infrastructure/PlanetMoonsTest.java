package com.zenred.cosmos.service_rules_and_infrastructure;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zenred.cosmos.domain.PlanetoidDao;
import com.zenred.cosmos.domain.StarDao;

public class PlanetMoonsTest {
	
	private static Logger logger = Logger.getLogger(PlanetMoonsTest.class);

	@Test
	public void test() {
		StarDao starDao = new StarDao();
		PlanetoidDao  planetoidDao = new PlanetoidDao();
		String starName = starDao.readNameOfRandomStar();
		String planarName = planetoidDao.readNameOfRandomPlanarWithMoon();
		String result = ToPlanetAndMoons.planetAndMoons(planarName, starName);
		logger.info("RESULT:"+result);
//		java.lang.System.out.println("RESULT:"+result);
		assertTrue(result.length() > 0);
	}

}
