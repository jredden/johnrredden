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

public class ReadAllStars {
	
	static private Logger logger = Logger.getLogger(ReadAllStars.class);
	
	RenameObjectType renameObjectType = RenameObjectType.STAR;
	
	List<Star> get(){
		ObjectList objectListEncap =  renameObjectType.getObjectList();
		List<Star> allStars = new ArrayList<Star>();
		List<Object> objectList = objectListEncap.getObjectList();
		for(Object nextStar : objectList){
			allStars.add((Star) nextStar);
		}
		return allStars;
	}

}
