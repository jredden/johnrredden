package com.zenred.cosmos.domain;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

public class ConfiguratioinDaoTest {
	
	private static Logger logger = Logger.getLogger(ConfiguratioinDaoTest.class);

	@Test
	public void test() {
		ConfigurationDao configurationDao = new ConfigurationDao();
		Double density = configurationDao.starDensity();
		assertTrue(density != null);
		logger.info("STAR DENSITY:"+density);
	}

}
