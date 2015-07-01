package com.zenred.cosmos.service_rules_and_infrastructure;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zenred.cosmos.vizualization.SystemResponse;

/**
 * this test does NOT clean up the database.  For a clean room test, re-init the 
 * database.
 * 
 * @author jredden
 *
 */
public class ImergeFromHyperspaceTest {
	
	private static Logger logger = Logger.getLogger(ImergeFromHyperspaceTest.class);

	@Test
	public void test() {
		SystemResponse  systemResponse = ImergeFromHyperspace.dontKnowWhereShipIs();
		logger.info("SYSTEM_RESPONSE:"+systemResponse);
		assertTrue(systemResponse != null);
	}

}
