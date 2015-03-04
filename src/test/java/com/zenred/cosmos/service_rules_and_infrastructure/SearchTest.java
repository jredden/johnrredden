package com.zenred.cosmos.service_rules_and_infrastructure;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

public class SearchTest {
	
	static private Logger logger = Logger.getLogger(SearchTest.class);


	@Test
	public void test() {
		int end = 0;
		int start = 0;
		for (int idex = 250000; idex > 0; idex--) {
			Integer[] ipipArray = GenStar.Search(idex);
			logger.info("IPIParray:" + ipipArray[0].toString() + "::"
					+ ipipArray[1].toString());
			end++;
		}
		logger.info("END:"+end);
		assertTrue(end == 250000);
	}

}
