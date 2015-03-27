package com.zenred.cosmos.service_rules_and_infrastructure;

import java.util.List;

import com.zenred.cosmos.domain.AstronomicalUnits;
import com.zenred.cosmos.domain.PlanetConstraints;
import com.zenred.cosmos.domain.Planetoid;
import com.zenred.cosmos.domain.PlanetoidDao;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.StarDao;
import com.zenred.cosmos.domain.SubClusterFactory;
import com.zenred.util.GenRandomRolls;

public class GenPlanet {
	
	private static PlanetoidDao planetoidDao = new PlanetoidDao();
	private static StarDao starDao = new StarDao();

	public static List<Planetoid> persistPlanetoids(Star star){
		
		String starsSubCluster = starDao.readStarsSubClusterDescription(star);
		SubClusterFactory subClusterFactory = SubClusterFactory.mapSubCluster(starsSubCluster);
		PlanetConstraints planetConstraints = subClusterFactory.getPlanetConstraints(subClusterFactory);
		Integer minNumberPlanets = planetConstraints.getMinNumberPlanets();
		Integer maxNumberPlanets = planetConstraints.getMaxNumberPlanets();
		Integer delta = maxNumberPlanets - minNumberPlanets;
		Integer numberPlanets = GenRandomRolls.Instance().getDX(delta) + minNumberPlanets;
		for(int idex = 0 ; idex < numberPlanets; idex++){
			Planetoid planetoid = new Planetoid();
			planetoid.setDegree(Math.toRadians(GenRandomRolls.Instance().getD360()));
			Double distanceInAUs = PlanetoidDistances.titusBodeApproximater(planetConstraints, star.getStar_size(), idex);
			Double distanceKloms = distanceInAUs * AstronomicalUnits.AstronomicalUnit;
			planetoid.setDistanceToPrimary(distanceKloms);
		}
		return null;
	}
}
