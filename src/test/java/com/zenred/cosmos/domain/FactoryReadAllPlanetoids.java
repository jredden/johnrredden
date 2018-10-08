package com.zenred.cosmos.domain;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.zenred.cosmos.domain.RenameObjectType;

public class FactoryReadAllPlanetoids {
	
	static private Logger logger = Logger.getLogger(FactoryReadAllPlanetoids.class);
	
	RenameObjectType renameObjectType = RenameObjectType.PLANETOID;
	

	@Test
	public void test() {
		ObjectList objectListEncap =  renameObjectType.getObjectList();
		List<Planetoid> allPlanetoids = new ArrayList<Planetoid>();
		List<Object> objectList = objectListEncap.getObjectList();
		for(Object nextPlanetoid : objectList){
			allPlanetoids.add((Planetoid) nextPlanetoid);
		}
		for (Planetoid aPlanetoid : allPlanetoids) {
			logger.info(
					"Planetoid Name:" + aPlanetoid.getPlanetoidName() + " PlanetoidId:" + aPlanetoid.getPlanetoidId());
		}

	}

}
