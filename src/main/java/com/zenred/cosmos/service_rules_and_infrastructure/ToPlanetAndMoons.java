package com.zenred.cosmos.service_rules_and_infrastructure;

import java.util.List;

import org.apache.log4j.Logger;

import com.zenred.cosmos.domain.Atmosphere;
import com.zenred.cosmos.domain.AtmosphereDao;
import com.zenred.cosmos.domain.Planetoid;
import com.zenred.cosmos.domain.PlanetoidDao;
import com.zenred.cosmos.domain.UnifiedPlanetoidI;

public class ToPlanetAndMoons {
	private static Logger logger = Logger.getLogger(ToPlanetAndMoons.class);
	
	protected static String planetAndMoons(String planetName){
		
		PlanetoidDao planetoidDao = new PlanetoidDao();
		AtmosphereDao atmosphereDao = new AtmosphereDao(); 
		Planetoid planetoid = planetoidDao.readPlanetoidByName(planetName);
		
		StringBuilder keyValuePair = new StringBuilder();
		keyValuePair.append(PlanetoidDao.DEGREE).append("=").append(planetoid.getDegree());
		keyValuePair.append(";"+PlanetoidDao.DISTANCE_TO_PRIMARY).append("=").append(Math.abs(planetoid.getDistanceToPrimary()));
		keyValuePair.append(";"+PlanetoidDao.PERCENT_WATER).append("=").append(planetoid.getPercentWater());
		keyValuePair.append(";"+PlanetoidDao.RADIUS).append("=").append(planetoid.getRadius());
		keyValuePair.append(";"+PlanetoidDao.PLANETOID_NAME).append("=").append(planetoid.getPlanetoidName());
		keyValuePair.append(";"+PlanetoidDao.TEMPERATURE).append("=").append(planetoid.getTemperature());
		
		List<Atmosphere> atmospheres = atmosphereDao.readAtmosphereAroundPlanet(planetoid);
		
		List<UnifiedPlanetoidI> moonList = planetoidDao.readMoonsAroundPlanetoid(planetoid);
		
		return keyValuePair.toString();
	}

}
