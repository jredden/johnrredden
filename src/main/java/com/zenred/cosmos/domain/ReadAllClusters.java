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

public class ReadAllClusters {
	
	static private Logger logger = Logger.getLogger(ReadAllClusters.class);
	
	RenameObjectType renameObjectType = RenameObjectType.CLUSTER;
	
	List<ClusterRep> get(){
		ObjectList objectListEncap =  renameObjectType.getObjectList();
		List<ClusterRep> allClusterReps = new ArrayList<ClusterRep>();
		List<Object> objectList = objectListEncap.getObjectList();
		for(Object nextClusterRep : objectList){
			allClusterReps.add((ClusterRep) nextClusterRep);
		}
		return allClusterReps;
	}

}
