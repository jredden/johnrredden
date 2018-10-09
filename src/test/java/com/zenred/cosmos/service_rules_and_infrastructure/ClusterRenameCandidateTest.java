package com.zenred.cosmos.service_rules_and_infrastructure;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

public class ClusterRenameCandidateTest {
	
	static private Logger logger = Logger.getLogger(ClusterRenameCandidateTest.class);

	@Test
	public void testClusterRenameCandidate() {
		
		ClusterRenameCandidates clusterRenameCandidates = new ClusterRenameCandidates();
		List<RenameCandidates>  renameCandidastes = clusterRenameCandidates.buildList();
		for(RenameCandidates renameCandidate : renameCandidastes){
			logger.info(renameCandidate);
		}
		
	}

}
