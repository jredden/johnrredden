package com.zenred.cosmos.service_rules_and_infrastructure;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zenred.cosmos.domain.StarDao;

public class ToStarsPlanetsTest {
	
	private static Logger logger = Logger.getLogger(ToStarsPlanetsTest.class);

	@Test
	public void test() {
		StarDao starDao = new StarDao();
		String starName = starDao.readNameOfRandomStar();
		String result = ToStarsPlanets.starsPlanets(starName);
		logger.info("RESULT:"+result);
		java.lang.System.out.println("RESULT:"+result);
		assertTrue(result.length() > 0);
	}

}
