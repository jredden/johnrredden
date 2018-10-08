package com.zenred.cosmos.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * used in conjuction with rename operation
 * 
 * @author johnredden
 *
 */

public class ReadAllPlanetoids {
	
	static private Logger logger = Logger.getLogger(ReadAllPlanetoids.class);
	
	RenameObjectType renameObjectType = RenameObjectType.PLANETOID;
	
	public List<Planetoid> get(){
		ObjectList objectListEncap =  renameObjectType.getObjectList();
		List<Planetoid> allPlanetoids = new ArrayList<Planetoid>();
		List<Object> objectList = objectListEncap.getObjectList();
		for(Object nextPlanetoid : objectList){
			allPlanetoids.add((Planetoid) nextPlanetoid);
		}
		return allPlanetoids;
	}

}
