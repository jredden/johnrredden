package com.zenred.cosmos.service_rules_and_infrastructure;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

public class PlanetoidRenameCandidateTest {
	
	static private Logger logger = Logger.getLogger(PlanetoidRenameCandidateTest.class);

	@Test
	public void testPlanetoidRenameCandidate() {
		
		PlanetoidRenameCandidates planetoidRenameCandidates = new PlanetoidRenameCandidates();
		List<RenameCandidates>  renameCandidastes = planetoidRenameCandidates.buildList();
		for(RenameCandidates renameCandidate : renameCandidastes){
			logger.info(renameCandidate);
		}
		
	}

}
