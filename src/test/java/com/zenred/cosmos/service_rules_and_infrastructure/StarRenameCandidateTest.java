package com.zenred.cosmos.service_rules_and_infrastructure;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

public class StarRenameCandidateTest {
	
	static private Logger logger = Logger.getLogger(StarRenameCandidateTest.class);

	@Test
	public void testStarRenameCandidate() {
		
		StarRenameCandidates StarRenameCandidates = new StarRenameCandidates();
		List<RenameCandidates>  renameCandidastes = StarRenameCandidates.buildList();
		for(RenameCandidates renameCandidate : renameCandidastes){
			logger.info(renameCandidate);
		}
		
	}

}
