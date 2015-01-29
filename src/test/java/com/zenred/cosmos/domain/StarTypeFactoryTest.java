package com.zenred.cosmos.domain;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

public class StarTypeFactoryTest {
	static private Logger logger = Logger.getLogger(StarTypeFactoryTest.class);

	@Test
	public void test() {
		Double lumen0 = StarTypeFactory.genLuminsoity((short) 0, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("LUMEN.G0:"+lumen0);
		Double lumen3 = StarTypeFactory.genLuminsoity((short) 1, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("LUMEN.G1:"+lumen3);
		Double lumen4 = StarTypeFactory.genLuminsoity((short) 2, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("LUMEN.G2:"+lumen4);
		Double lumen5 = StarTypeFactory.genLuminsoity((short) 3, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("LUMEN.G3:"+lumen5);
		Double lumen6 = StarTypeFactory.genLuminsoity((short) 4, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("LUMEN.G4:"+lumen6);
		Double lumen1 = StarTypeFactory.genLuminsoity((short) 5, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("LUMEN.G5:"+lumen1);
		Double lumen6x = StarTypeFactory.genLuminsoity((short) 6, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("LUMEN.G6:"+lumen6x);
		Double lumen7x = StarTypeFactory.genLuminsoity((short) 7, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("LUMEN.G7:"+lumen7x);
		Double lumen8x = StarTypeFactory.genLuminsoity((short) 8, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("LUMEN.G8:"+lumen8x);
		Double lumen2 = StarTypeFactory.genLuminsoity((short) 9, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("LUMEN.G9:"+lumen2);
	}

	@Test
	public void test2() {
		Double lumen0f = StarTypeFactory.genLuminsoity((short) 0, StarTypeFactory.f, StarFactory.PYEL_MAINS, StarFactory.redMainS.sequence());
		logger.info("LUMEN.F0:"+lumen0f);
		Double lumen3f = StarTypeFactory.genLuminsoity((short) 1, StarTypeFactory.f, StarFactory.PYEL_MAINS, StarFactory.redMainS.sequence());
		logger.info("LUMEN.F1:"+lumen3f);
		Double lumen4f = StarTypeFactory.genLuminsoity((short) 2, StarTypeFactory.f, StarFactory.PYEL_MAINS, StarFactory.redMainS.sequence());
		logger.info("LUMEN.F2:"+lumen4f);
		Double lumen5f = StarTypeFactory.genLuminsoity((short) 3, StarTypeFactory.f, StarFactory.PYEL_MAINS, StarFactory.redMainS.sequence());
		logger.info("LUMEN.F3:"+lumen5f);
		Double lumen6f = StarTypeFactory.genLuminsoity((short) 4, StarTypeFactory.f, StarFactory.PYEL_MAINS, StarFactory.redMainS.sequence());
		logger.info("LUMEN.F4:"+lumen6f);
		Double lumen1f = StarTypeFactory.genLuminsoity((short) 5, StarTypeFactory.f, StarFactory.PYEL_MAINS, StarFactory.redMainS.sequence());
		logger.info("LUMEN.F5:"+lumen1f);
		Double lumen6xf = StarTypeFactory.genLuminsoity((short) 6, StarTypeFactory.f, StarFactory.PYEL_MAINS, StarFactory.redMainS.sequence());
		logger.info("LUMEN.F6:"+lumen6xf);
		Double lumen7xf = StarTypeFactory.genLuminsoity((short) 7, StarTypeFactory.f, StarFactory.PYEL_MAINS, StarFactory.redMainS.sequence());
		logger.info("LUMEN.F7:"+lumen7xf);
		Double lumen8xf = StarTypeFactory.genLuminsoity((short) 8, StarTypeFactory.f, StarFactory.PYEL_MAINS, StarFactory.redMainS.sequence());
		logger.info("LUMEN.F8:"+lumen8xf);
		Double lumen2f = StarTypeFactory.genLuminsoity((short) 9, StarTypeFactory.f, StarFactory.PYEL_MAINS, StarFactory.redMainS.sequence());
		logger.info("LUMEN.F9:"+lumen2f);

	}
	
	@Test
	public void test3() {
		Double lumen0m=StarTypeFactory.genLuminsoity((short) 0, StarTypeFactory.m, StarFactory.RED__MAINS, StarFactory.pyrlMainS.sequence());
		logger.info("LUMEN.M0:"+lumen0m);
		Double lumen3m=StarTypeFactory.genLuminsoity((short) 1, StarTypeFactory.m, StarFactory.RED__MAINS, StarFactory.pyrlMainS.sequence());
		logger.info("LUMEN.M1:"+lumen3m);
		Double lumen4m=StarTypeFactory.genLuminsoity((short) 2, StarTypeFactory.m, StarFactory.RED__MAINS, StarFactory.pyrlMainS.sequence());
		logger.info("LUMEN.M2:"+lumen4m);
		Double lumen5m=StarTypeFactory.genLuminsoity((short) 3, StarTypeFactory.m, StarFactory.RED__MAINS, StarFactory.pyrlMainS.sequence());
		logger.info("LUMEN.M3:"+lumen5m);
		Double lumen6m=StarTypeFactory.genLuminsoity((short) 4, StarTypeFactory.m, StarFactory.RED__MAINS, StarFactory.pyrlMainS.sequence());
		logger.info("LUMEN.M4:"+lumen6m);
		Double lumen1m=StarTypeFactory.genLuminsoity((short) 5, StarTypeFactory.m, StarFactory.RED__MAINS, StarFactory.pyrlMainS.sequence());
		logger.info("LUMEN.M5:"+lumen1m);
		Double lumen6xm=StarTypeFactory.genLuminsoity((short) 6, StarTypeFactory.m, StarFactory.RED__MAINS, StarFactory.pyrlMainS.sequence());
		logger.info("LUMEN.M6:"+lumen6xm);
		Double lumen7xm=StarTypeFactory.genLuminsoity((short) 7, StarTypeFactory.m, StarFactory.RED__MAINS, StarFactory.pyrlMainS.sequence());
		logger.info("LUMEN.M7:"+lumen7xm);
		Double lumen8xm=StarTypeFactory.genLuminsoity((short) 8, StarTypeFactory.m, StarFactory.RED__MAINS, StarFactory.pyrlMainS.sequence());
		logger.info("LUMEN.M8:"+lumen8xm);
		Double lumen2m=StarTypeFactory.genLuminsoity((short) 9, StarTypeFactory.m, StarFactory.RED__MAINS, StarFactory.pyrlMainS.sequence());
		logger.info("LUMEN.M9:"+lumen2m);

	}
}
