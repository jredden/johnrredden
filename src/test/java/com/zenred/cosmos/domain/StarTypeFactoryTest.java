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
		Double lumen3 = StarTypeFactory.genLuminsoity((short) 1, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("LUMEN1:"+lumen3);
		Double lumen4 = StarTypeFactory.genLuminsoity((short) 2, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("LUMEN2:"+lumen4);
		Double lumen5 = StarTypeFactory.genLuminsoity((short) 3, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("LUMEN3:"+lumen5);
		Double lumen6 = StarTypeFactory.genLuminsoity((short) 4, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("LUMEN4:"+lumen6);
		Double lumen1 = StarTypeFactory.genLuminsoity((short) 5, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("LUMEN5:"+lumen1);
		Double lumen6x = StarTypeFactory.genLuminsoity((short) 6, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("LUMEN6:"+lumen6x);
		Double lumen7x = StarTypeFactory.genLuminsoity((short) 7, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("LUMEN7:"+lumen7x);
		Double lumen8x = StarTypeFactory.genLuminsoity((short) 8, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("LUMEN8:"+lumen8x);
		Double lumen2 = StarTypeFactory.genLuminsoity((short) 9, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("LUMEN9:"+lumen2);

	}

}
