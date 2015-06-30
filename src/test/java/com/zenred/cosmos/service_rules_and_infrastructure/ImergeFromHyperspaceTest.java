package com.zenred.cosmos.service_rules_and_infrastructure;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * this test does NOT clean up the database.  For a clean room test, re-init the 
 * database.
 * 
 * @author jredden
 *
 */
public class ImergeFromHyperspaceTest {

	@Test
	public void test() {
		ImergeFromHyperspace.dontKnowWhereShipIs();
	}

}
