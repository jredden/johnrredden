package com.zenred.cosmos.service_rules_and_infrastructure;

import java.util.List;

import org.apache.log4j.Logger;

import com.zenred.cosmos.domain.Atmosphere;
import com.zenred.cosmos.domain.AtmosphereParts;
import com.zenred.cosmos.domain.Planetoid;
import com.zenred.cosmos.domain.PlanetoidDao;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.StarDao;
import com.zenred.cosmos.domain.UnifiedPlanetoidI;

public class ToStarsPlanets {

	private static Logger logger = Logger.getLogger(ToStarsPlanets.class);
	
	public static void starsPlanets(String starsName){
		StarDao starDao = new StarDao();
		PlanetoidDao planetoidDao = new PlanetoidDao();
		Star star = starDao.readStarByName(starsName);
		List<UnifiedPlanetoidI> planetoids = planetoidDao.readPlanetoidsAroundStar(star);
		for (UnifiedPlanetoidI unifiedOlanetoid : planetoids){
			Planetoid planetoid = unifiedOlanetoid.getPlanetoid();
			
		}
	}

}
