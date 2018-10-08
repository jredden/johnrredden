package com.zenred.cosmos.domain;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.zenred.cosmos.domain.RenameObjectType;

public class FactoryReadAllStars {
	
	static private Logger logger = Logger.getLogger(FactoryReadAllStars.class);
	
	RenameObjectType renameObjectType = RenameObjectType.STAR;
	

	@Test
	public void test() {
		ObjectList objectListEncap =  renameObjectType.getObjectList();
		List<Star> allStars = new ArrayList<Star>();
		List<Object> objectList = objectListEncap.getObjectList();
		for(Object nextStar : objectList){
			allStars.add((Star) nextStar);
		}
		for (Star aStar : allStars) {
			logger.info(
					"Star Name:" + aStar.getName() + " StarId:" + aStar.getStarId());
		}

	}

}
