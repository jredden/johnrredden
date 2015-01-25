package com.zenred.cosmos.domain;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

public class StarTypeFactoryTest {
	static private Logger logger = Logger.getLogger(StarTypeFactoryTest.class);

	@Test
	public void test() {
		Double lumen0 = StarTypeFactory.genLuminsoity((short) 0, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("LUMEN0:"+lumen0);
	}

}
