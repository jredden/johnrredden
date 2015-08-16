package com.zenred.cosmos.service_rules_and_infrastructure;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.zenred.cosmos.domain.Atmosphere;
import com.zenred.cosmos.domain.AtmosphereParts;
import com.zenred.cosmos.domain.Planetoid;
import com.zenred.cosmos.domain.PlanetoidColor;
import com.zenred.cosmos.domain.PlanetoidDao;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.StarDao;
import com.zenred.cosmos.domain.UnifiedPlanetoidI;
import com.zenred.cosmos.vizualization.PlanetsResponse;

public class ToStarsPlanets {

	private static Logger logger = Logger.getLogger(ToStarsPlanets.class);
	private static final String ATMOSPHERE_COLOR = "Color";
	private static final String ATMOSPHERE_PERCENTAGE = "Percent";
	
	/**
	 * 
	 * @param starsName
	 * @return single string of star and all its planets
	 */
	protected static String starsPlanets(String starsName){
		
		
		StarDao starDao = new StarDao();
		PlanetoidDao planetoidDao = new PlanetoidDao();
		Star star = starDao.readStarByName(starsName);
		
		// build star detail response first
		StringBuilder keyValuePair = new StringBuilder();
		keyValuePair.append(StarDao.ANGLE_IN_RADIANS_S).append("=").append(star.getAngle_in_radians_s());
		keyValuePair.append(";"+StarDao.DISTANCE_CLUST_VIRT_CENTRE).append("=").append(Math.abs(star.getDistance_clust_virt_centre()));
		keyValuePair.append(";"+StarDao.LUMINOSITY).append("=").append(star.getLuminosity());
		keyValuePair.append(";"+StarDao.NAME).append("=").append(star.getName());
		keyValuePair.append(";"+StarDao.STAR_COLOR).append("=").append(star.getStar_color());
		keyValuePair.append(";"+StarDao.STAR_SIZE).append("=").append(star.getStar_size());
		keyValuePair.append(";"+StarDao.STAR_TYPE).append("=").append(star.getStar_type());
		

		
		List<UnifiedPlanetoidI> planetoids = planetoidDao.readPlanetoidsAroundStar(star);
		for (UnifiedPlanetoidI unifiedOlanetoid : planetoids){
			Planetoid planetoid = unifiedOlanetoid.getPlanetoid();
			List<PlanetoidColor> planetoidColors = PlanetoidColor.planarColors(planetoid);
			keyValuePair.append(";"+PlanetoidDao.PLANETOID_NAME).append("=").append(planetoid.getPlanetoidName());
			keyValuePair.append(";"+PlanetoidDao.DEGREE).append("=").append(planetoid.getDegree());
			keyValuePair.append(";"+PlanetoidDao.DISTANCE_TO_PRIMARY).append("=").append(planetoid.getDistanceToPrimary());
			keyValuePair.append(";"+PlanetoidDao.TEMPERATURE).append("=").append(planetoid.getTemperature());
			for(PlanetoidColor planetoidColor : planetoidColors){
				keyValuePair.append(";"+ATMOSPHERE_COLOR).append("=").append(planetoidColor.getColor());
				keyValuePair.append(";"+ATMOSPHERE_PERCENTAGE).append("=").append(planetoidColor.getPercentage());
			}

		}
		return keyValuePair.toString();
		
	}

	/**
	 * 
	 * @param starName
	 * @return respoonse to controller
	 */
	public static PlanetsResponse starAndPlanets(String starName){
		PlanetsResponse planetsResponse = new PlanetsResponse();
		planetsResponse.setStarAndPlanets(starsPlanets(starName));
		return planetsResponse;
	}
}
