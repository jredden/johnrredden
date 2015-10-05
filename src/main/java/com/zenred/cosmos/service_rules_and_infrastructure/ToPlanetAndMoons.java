package com.zenred.cosmos.service_rules_and_infrastructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.zenred.cosmos.domain.Atmosphere;
import com.zenred.cosmos.domain.AtmosphereDao;
import com.zenred.cosmos.domain.AtmosphereParts;
import com.zenred.cosmos.domain.Planetoid;
import com.zenred.cosmos.domain.PlanetoidColor;
import com.zenred.cosmos.domain.PlanetoidDao;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.StarDao;
import com.zenred.cosmos.domain.UnifiedPlanetoidI;
import com.zenred.cosmos.vizualization.MoonsResponse;

public class ToPlanetAndMoons {
	private static Logger logger = Logger.getLogger(ToPlanetAndMoons.class);
	private final static String CHEM_COLOR = "Chem_Color";
	private static final String TEMPERATURE_TYPE = "TempType";
	private static final String SIZE_TYPE = "SizeType";

	
	protected static String planetAndMoons(String planetName, String starsName){
		
		
		StarDao starDao = new StarDao();
		Star star = starDao.readStarByName(starsName);
		
		PlanetoidDao planetoidDao = new PlanetoidDao();
		AtmosphereDao atmosphereDao = new AtmosphereDao(); 
		Planetoid planetoid = planetoidDao.readPlanetoidByName(planetName);
		
		List<Atmosphere> atmospheres = atmosphereDao.readAtmosphereAroundPlanet(planetoid);
		String water = AtmosphereParts.Water.name();
		for(Atmosphere atmosphere : atmospheres){
			if(atmosphere.getChem_name().equals(water)){
				planetoid.setPercentWater(atmosphere.getPercentage());
			}
		}
		String temperatureType = GenAtmosphere.temperatureType(planetoid.getTemperature());
		String sizeType = GenAtmosphere.sizeType(planetoid.getRadius());

		StringBuilder keyValuePair = new StringBuilder();
		keyValuePair.append(PlanetoidDao.DEGREE).append("=").append(planetoid.getDegree());
		keyValuePair.append(";"+PlanetoidDao.DISTANCE_TO_PRIMARY).append("=").append(Math.abs(planetoid.getDistanceToPrimary()));
		keyValuePair.append(";"+TEMPERATURE_TYPE).append("=").append(temperatureType);
		keyValuePair.append(";"+SIZE_TYPE).append("=").append(sizeType);
		keyValuePair.append(";"+PlanetoidDao.PERCENT_WATER).append("=").append(planetoid.getPercentWater());
		keyValuePair.append(";"+PlanetoidDao.RADIUS).append("=").append(planetoid.getRadius());
		keyValuePair.append(";"+PlanetoidDao.PLANETOID_NAME).append("=").append(planetoid.getPlanetoidName());
		keyValuePair.append(";"+PlanetoidDao.TEMPERATURE).append("=").append(planetoid.getTemperature());
		
		keyValuePair.append(";"+"ACTION").append("=").append("ATMOSPHERE");
		List<PlanetoidColor> planetoidColors = new ArrayList<PlanetoidColor>();
		for(Atmosphere atmosphere : atmospheres){
			String color = AtmosphereParts.valueOf(AtmosphereParts.class,
					atmosphere.getChem_name()).getColor();
			if(color.equals("none")){
				color = PlanetoidColor.fetchPureColor(star.getStar_color());  // reflects stars color
			}
			PlanetoidColor planetoidColor = new PlanetoidColor(color,
					atmosphere.getChem_name(), atmosphere.getPercentage());
			planetoidColors.add(planetoidColor);

		}
		Collections.sort(planetoidColors);
		for (PlanetoidColor planetoidColor : planetoidColors) {
			keyValuePair.append(";" + AtmosphereDao.CHEM_NAME).append("=")
					.append(planetoidColor.getChemicalName());
			keyValuePair.append(";" + AtmosphereDao.PERCENTAGE).append("=")
					.append(planetoidColor.getPercentage());
			keyValuePair.append(";" + CHEM_COLOR).append("=").append(planetoidColor.getColor());
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
