package com.zenred.cosmos.domain;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.zenred.cosmos.domain.RenameObjectType;

public class FactoryReadAllClusterReps {
	
	static private Logger logger = Logger.getLogger(FactoryReadAllClusterReps.class);
	
	RenameObjectType renameObjectType = RenameObjectType.CLUSTER;
	

	@Test
	public void test() {
		ObjectList objectListEncap =  renameObjectType.getObjectList();
		List<ClusterRep> allClusters = new ArrayList<ClusterRep>();
		List<Object> objectList = objectListEncap.getObjectList();
		for(Object nextCluster : objectList){
			allClusters.add((ClusterRep) nextCluster);
		}
		for (ClusterRep aCluster : allClusters) {
			logger.info(
					"Cluster Name:" + aCluster.getClusterName() + " ClusterId:" + aCluster.getClusterRepId());
		}

	}

}
