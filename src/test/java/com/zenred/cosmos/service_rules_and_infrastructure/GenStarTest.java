package com.zenred.cosmos.service_rules_and_infrastructure;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import org.apache.log4j.Logger;

import com.zenred.cosmos.domain.Star;

public class GenStarTest {
	private static Logger logger = Logger.getLogger(GenStarTest.class);
	private static int count = 1000;
	@Test
	public void test() {
		while(count != 0){
		Star star = GenStar.generateStar("Star_"+count, null);
		logger.info("STAR:"+star);
		--count;
		}
	}

}
