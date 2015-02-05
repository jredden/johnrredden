package com.zenred.cosmos.domain;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

public class StarTypeFactoryMassTest {
	static private Logger logger = Logger.getLogger(StarTypeFactoryMassTest.class);

	@Test
	public void test() {
		Double mass0 = StarTypeFactory.genMass((short) 0, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("MASS.G0:"+mass0);
		Double mass3 = StarTypeFactory.genMass((short) 1, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("MASS.G1:"+mass3);
		Double mass4 = StarTypeFactory.genMass((short) 2, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("MASS.G2:"+mass4);
		Double mass5 = StarTypeFactory.genMass((short) 3, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("MASS.G3:"+mass5);
		Double mass6 = StarTypeFactory.genMass((short) 4, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("MASS.G4:"+mass6);
		Double mass1 = StarTypeFactory.genMass((short) 5, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("MASS.G5:"+mass1);
		Double mass6x = StarTypeFactory.genMass((short) 6, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("MASS.G6:"+mass6x);
		Double mass7x = StarTypeFactory.genMass((short) 7, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("MASS.G7:"+mass7x);
		Double mass8x = StarTypeFactory.genMass((short) 8, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("MASS.G8:"+mass8x);
		Double mass2 = StarTypeFactory.genMass((short) 9, StarTypeFactory.g, StarFactory.YELO_MAINS, StarFactory.yeloMainS.sequence());
		logger.info("MASS.G9:"+mass2);
	}

	@Test
	public void test2() {
		Double mass0f = StarTypeFactory.genMass((short) 0, StarTypeFactory.f, StarFactory.PYEL_MAINS, StarFactory.pyrlMainS.sequence());
		logger.info("MASS.F0:"+mass0f);
		Double mass3f = StarTypeFactory.genMass((short) 1, StarTypeFactory.f, StarFactory.PYEL_MAINS, StarFactory.pyrlMainS.sequence());
		logger.info("MASS.F1:"+mass3f);
		Double mass4f = StarTypeFactory.genMass((short) 2, StarTypeFactory.f, StarFactory.PYEL_MAINS, StarFactory.pyrlMainS.sequence());
		logger.info("MASS.F2:"+mass4f);
		Double mass5f = StarTypeFactory.genMass((short) 3, StarTypeFactory.f, StarFactory.PYEL_MAINS, StarFactory.pyrlMainS.sequence());
		logger.info("MASS.F3:"+mass5f);
		Double mass6f = StarTypeFactory.genMass((short) 4, StarTypeFactory.f, StarFactory.PYEL_MAINS, StarFactory.pyrlMainS.sequence());
		logger.info("MASS.F4:"+mass6f);
		Double mass1f = StarTypeFactory.genMass((short) 5, StarTypeFactory.f, StarFactory.PYEL_MAINS, StarFactory.pyrlMainS.sequence());
		logger.info("MASS.F5:"+mass1f);
		Double mass6xf = StarTypeFactory.genMass((short) 6, StarTypeFactory.f, StarFactory.PYEL_MAINS, StarFactory.pyrlMainS.sequence());
		logger.info("MASS.F6:"+mass6xf);
		Double mass7xf = StarTypeFactory.genMass((short) 7, StarTypeFactory.f, StarFactory.PYEL_MAINS, StarFactory.pyrlMainS.sequence());
		logger.info("MASS.F7:"+mass7xf);
		Double mass8xf = StarTypeFactory.genMass((short) 8, StarTypeFactory.f, StarFactory.PYEL_MAINS, StarFactory.pyrlMainS.sequence());
		logger.info("MASS.F8:"+mass8xf);
		Double mass2f = StarTypeFactory.genMass((short) 9, StarTypeFactory.f, StarFactory.PYEL_MAINS, StarFactory.pyrlMainS.sequence());
		logger.info("MASS.F9:"+mass2f);

	}
	
	@Test
	public void test3() {
		Double mass0m=StarTypeFactory.genMass((short) 0, StarTypeFactory.m, StarFactory.RED__MAINS, StarFactory.redMainS.sequence());
		logger.info("MASS.M0:"+mass0m);
		Double mass3m=StarTypeFactory.genMass((short) 1, StarTypeFactory.m, StarFactory.RED__MAINS, StarFactory.redMainS.sequence());
		logger.info("MASS.M1:"+mass3m);
		Double mass4m=StarTypeFactory.genMass((short) 2, StarTypeFactory.m, StarFactory.RED__MAINS, StarFactory.redMainS.sequence());
		logger.info("MASS.M2:"+mass4m);
		Double mass5m=StarTypeFactory.genMass((short) 3, StarTypeFactory.m, StarFactory.RED__MAINS, StarFactory.redMainS.sequence());
		logger.info("MASS.M3:"+mass5m);
		Double mass6m=StarTypeFactory.genMass((short) 4, StarTypeFactory.m, StarFactory.RED__MAINS, StarFactory.redMainS.sequence());
		logger.info("MASS.M4:"+mass6m);
		Double mass1m=StarTypeFactory.genMass((short) 5, StarTypeFactory.m, StarFactory.RED__MAINS, StarFactory.redMainS.sequence());
		logger.info("MASS.M5:"+mass1m);
		Double mass6xm=StarTypeFactory.genMass((short) 6, StarTypeFactory.m, StarFactory.RED__MAINS, StarFactory.redMainS.sequence());
		logger.info("MASS.M6:"+mass6xm);
		Double mass7xm=StarTypeFactory.genMass((short) 7, StarTypeFactory.m, StarFactory.RED__MAINS, StarFactory.redMainS.sequence());
		logger.info("MASS.M7:"+mass7xm);
		Double mass8xm=StarTypeFactory.genMass((short) 8, StarTypeFactory.m, StarFactory.RED__MAINS, StarFactory.redMainS.sequence());
		logger.info("MASS.M8:"+mass8xm);
		Double mass2m=StarTypeFactory.genMass((short) 9, StarTypeFactory.m, StarFactory.RED__MAINS, StarFactory.redMainS.sequence());
		logger.info("MASS.M9:"+mass2m);

	}
}
