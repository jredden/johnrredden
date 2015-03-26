package com.zenred.cosmos.service_rules_and_infrastructure;

import java.util.List;

import com.zenred.cosmos.domain.PlanetConstraints;
import com.zenred.cosmos.domain.Planetoid;
import com.zenred.cosmos.domain.PlanetoidDao;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.StarDao;
import com.zenred.cosmos.domain.SubClusterFactory;

public class GenPlanet {
	
	private static PlanetoidDao planetoidDao = new PlanetoidDao();
	private static StarDao starDao = new StarDao();

	public static List<Planetoid> persistPlanetoids(Star star){
		
		String starsSubCluster = starDao.readStarsSubClusterDescription(star);
		SubClusterFactory subClusterFactory = SubClusterFactory.mapSubCluster(starsSubCluster);
		PlanetConstraints planetConstraints = subClusterFactory.getPlanetConstraints(subClusterFactory);
		return null;
	}
}
