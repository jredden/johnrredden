package com.zenred.cosmos.domain;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Test;

public class ReadAllStarsTest {
	
	static private Logger logger = Logger.getLogger(ReadAllStarsTest.class);

	@Test
	public void test() {
		StarDao starDao = new StarDao();
		List<Star> allStars = new ArrayList<Star>();
		allStars = starDao.readAllStars();
		for(Star aStar : allStars){
			logger.info("StarName:" + aStar.getName() + " StarId:" + aStar.getStarId());
		}
		
	}

}
