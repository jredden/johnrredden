package com.zenred.cosmos.domain;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

public class StarTypeFactoryEdgeTest {
	static private Logger logger = Logger.getLogger(StarTypeFactoryEdgeTest.class);

	@Test
	public void test() {
		Double lumen0 = StarTypeFactory.genLuminsoity((short) 0, StarTypeFactory.sg2o, StarFactory.BLUE_SG_II, StarFactory.blueSGII.sequence());
		logger.info("LUMEN.SG2O:"+lumen0);
		Double lumen3 = StarTypeFactory.genLuminsoity((short) 1, StarTypeFactory.sg2o,StarFactory.BLUE_SG_II, StarFactory.blueSGII.sequence());
		logger.info("LUMEN.SG21:"+lumen3);
		Double lumen4 = StarTypeFactory.genLuminsoity((short) 2, StarTypeFactory.sg2o, StarFactory.BLUE_SG_II, StarFactory.blueSGII.sequence());
		logger.info("LUMEN.SG22:"+lumen4);
		Double lumen5 = StarTypeFactory.genLuminsoity((short) 3, StarTypeFactory.sg2o, StarFactory.BLUE_SG_II, StarFactory.blueSGII.sequence());
		logger.info("LUMEN.SG23:"+lumen5);
		Double lumen6 = StarTypeFactory.genLuminsoity((short) 4, StarTypeFactory.sg2o, StarFactory.BLUE_SG_II, StarFactory.blueSGII.sequence());
		logger.info("LUMEN.SG24:"+lumen6);
		Double lumen1 = StarTypeFactory.genLuminsoity((short) 5, StarTypeFactory.sg2o, StarFactory.BLUE_SG_II, StarFactory.blueSGII.sequence());
		logger.info("LUMEN.SG25:"+lumen1);
		Double lumen6x = StarTypeFactory.genLuminsoity((short) 6, StarTypeFactory.sg2o, StarFactory.BLUE_SG_II, StarFactory.blueSGII.sequence());
		logger.info("LUMEN.SG26:"+lumen6x);
		Double lumen7x = StarTypeFactory.genLuminsoity((short) 7, StarTypeFactory.sg2o, StarFactory.BLUE_SG_II, StarFactory.blueSGII.sequence());
		logger.info("LUMEN.SG27:"+lumen7x);
		Double lumen8x = StarTypeFactory.genLuminsoity((short) 8, StarTypeFactory.sg2o, StarFactory.BLUE_SG_II, StarFactory.blueSGII.sequence());
		logger.info("LUMEN.SG28:"+lumen8x);
		Double lumen2 = StarTypeFactory.genLuminsoity((short) 9, StarTypeFactory.sg2o, StarFactory.BLUE_SG_II, StarFactory.blueSGII.sequence());
		logger.info("LUMEN.SG29:"+lumen2);
	}
	
	@Test
	public void test2() {
		Double lumen0m=StarTypeFactory.genLuminsoity((short) 0, StarTypeFactory.pmd, StarFactory.PURPLE_RED, StarFactory.purpleRed.sequence());
		logger.info("LUMEN.PMD0:"+lumen0m);
		Double lumen3m=StarTypeFactory.genLuminsoity((short) 1, StarTypeFactory.pmd, StarFactory.PURPLE_RED, StarFactory.purpleRed.sequence());
		logger.info("LUMEN.PMD1:"+lumen3m);
		Double lumen4m=StarTypeFactory.genLuminsoity((short) 2, StarTypeFactory.pmd, StarFactory.PURPLE_RED, StarFactory.purpleRed.sequence());
		logger.info("LUMEN.PMD2:"+lumen4m);
		Double lumen5m=StarTypeFactory.genLuminsoity((short) 3, StarTypeFactory.pmd, StarFactory.PURPLE_RED, StarFactory.purpleRed.sequence());
		logger.info("LUMEN.PMD3:"+lumen5m);
		Double lumen6m=StarTypeFactory.genLuminsoity((short) 4, StarTypeFactory.pmd, StarFactory.PURPLE_RED, StarFactory.purpleRed.sequence());
		logger.info("LUMEN.PMD4:"+lumen6m);
		Double lumen1m=StarTypeFactory.genLuminsoity((short) 5, StarTypeFactory.pmd, StarFactory.PURPLE_RED, StarFactory.purpleRed.sequence());
		logger.info("LUMEN.PMD5:"+lumen1m);
		Double lumen6xm=StarTypeFactory.genLuminsoity((short) 6, StarTypeFactory.pmd, StarFactory.PURPLE_RED, StarFactory.purpleRed.sequence());
		logger.info("LUMEN.PMD6:"+lumen6xm);
		Double lumen7xm=StarTypeFactory.genLuminsoity((short) 7, StarTypeFactory.pmd, StarFactory.PURPLE_RED, StarFactory.purpleRed.sequence());
		logger.info("LUMEN.PMD7:"+lumen7xm);
		Double lumen8xm=StarTypeFactory.genLuminsoity((short) 8, StarTypeFactory.pmd, StarFactory.PURPLE_RED, StarFactory.purpleRed.sequence());
		logger.info("LUMEN.PMD8:"+lumen8xm);
		Double lumen2m=StarTypeFactory.genLuminsoity((short) 9, StarTypeFactory.pmd, StarFactory.PURPLE_RED, StarFactory.purpleRed.sequence());
		logger.info("LUMEN.PMD9:"+lumen2m);

	}
	
	@Test
	public void test3() {
		Double lumen0m=StarTypeFactory.genLuminsoity((short) 0, StarTypeFactory.dbs, StarFactory.DRKBRN_SDW, StarFactory.drkBrnSDW.sequence());
		logger.info("LUMEN.DBS0:"+lumen0m);
		Double lumen3m=StarTypeFactory.genLuminsoity((short) 1, StarTypeFactory.dbs, StarFactory.DRKBRN_SDW, StarFactory.drkBrnSDW.sequence());
		logger.info("LUMEN.DBS1:"+lumen3m);
		Double lumen4m=StarTypeFactory.genLuminsoity((short) 2, StarTypeFactory.dbs, StarFactory.DRKBRN_SDW, StarFactory.drkBrnSDW.sequence());
		logger.info("LUMEN.DBS2:"+lumen4m);
		Double lumen5m=StarTypeFactory.genLuminsoity((short) 3, StarTypeFactory.dbs, StarFactory.DRKBRN_SDW, StarFactory.drkBrnSDW.sequence());
		logger.info("LUMEN.DBS3:"+lumen5m);
		Double lumen6m=StarTypeFactory.genLuminsoity((short) 4, StarTypeFactory.dbs, StarFactory.DRKBRN_SDW, StarFactory.drkBrnSDW.sequence());
		logger.info("LUMEN.DBS4:"+lumen6m);
		Double lumen1m=StarTypeFactory.genLuminsoity((short) 5, StarTypeFactory.dbs, StarFactory.DRKBRN_SDW, StarFactory.drkBrnSDW.sequence());
		logger.info("LUMEN.DBS5:"+lumen1m);
		Double lumen6xm=StarTypeFactory.genLuminsoity((short) 6, StarTypeFactory.dbs, StarFactory.DRKBRN_SDW, StarFactory.drkBrnSDW.sequence());
		logger.info("LUMEN.DBS6:"+lumen6xm);
		Double lumen7xm=StarTypeFactory.genLuminsoity((short) 7, StarTypeFactory.dbs, StarFactory.DRKBRN_SDW, StarFactory.drkBrnSDW.sequence());
		logger.info("LUMEN.DBS7:"+lumen7xm);
		Double lumen8xm=StarTypeFactory.genLuminsoity((short) 8, StarTypeFactory.dbs, StarFactory.DRKBRN_SDW, StarFactory.drkBrnSDW.sequence());
		logger.info("LUMEN.DBS8:"+lumen8xm);
		Double lumen2m=StarTypeFactory.genLuminsoity((short) 9, StarTypeFactory.dbs, StarFactory.DRKBRN_SDW, StarFactory.drkBrnSDW.sequence());
		logger.info("LUMEN.DBS9:"+lumen2m);

	}
}
