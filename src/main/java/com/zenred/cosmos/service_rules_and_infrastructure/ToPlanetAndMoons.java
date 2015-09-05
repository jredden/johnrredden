package com.zenred.cosmos.service_rules_and_infrastructure;

import java.util.List;

import org.apache.log4j.Logger;

import com.zenred.cosmos.domain.Atmosphere;
import com.zenred.cosmos.domain.AtmosphereDao;
import com.zenred.cosmos.domain.Planetoid;
import com.zenred.cosmos.domain.PlanetoidDao;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.StarDao;
import com.zenred.cosmos.domain.UnifiedPlanetoidI;
import com.zenred.cosmos.vizualization.MoonsResponse;

public class ToPlanetAndMoons {
	private static Logger logger = Logger.getLogger(ToPlanetAndMoons.class);
	
	protected static String planetAndMoons(String planetName, String starsName){
		
		StarDao starDao = new StarDao();
		Star star = starDao.readStarByName(starsName);
		
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
		keyValuePair.append(";"+"ACTION").append("=").append("ATMOSPHERE");
		for(Atmosphere atmosphere : atmospheres){
			keyValuePair.append(";"+AtmosphereDao.CHEM_NAME).append("=").append(atmosphere.getChem_name());
			keyValuePair.append(";"+AtmosphereDao.PERCENTAGE).append("=").append(atmosphere.getPercentage());
		}
		
		List<UnifiedPlanetoidI> moonList = planetoidDao.readMoonsAroundPlanetoid(planetoid);
		if(moonList.size() == 0){
			keyValuePair.append(";"+"ACTION").append("=").append("NO_MOON");
		}
		else{
			keyValuePair.append(";"+"ACTION").append("=").append("MOON");
		}
		return ToStarsPlanets.completePlanetoid(moonList, star, keyValuePair).toString();
	}
	
	public static MoonsResponse planarAndMoons(String planetName, String starName){
		MoonsResponse moonsResponse = new MoonsResponse();
		moonsResponse.setPlanetAndMoons(planetAndMoons(planetName, starName));
		return moonsResponse;
	}

}
