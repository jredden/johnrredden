package com.zenred.cosmos.service_rules_and_infrastructure;

import java.util.ArrayList;
import java.util.List;

import com.zenred.cosmos.domain.Planetoid;
import com.zenred.cosmos.domain.ReadAllPlanetoids;

public class PlanetoidRenameCandidates {
	
	List<RenameCandidates> buildList(){
		List<Planetoid> planetoidList = new ReadAllPlanetoids().get();
		List<RenameCandidates> renameCandidates = new ArrayList<RenameCandidates>();
		
		return renameCandidates;
	}

}
