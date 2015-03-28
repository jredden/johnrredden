package com.zenred.cosmos.service_rules_and_infrastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.zenred.cosmos.domain.AstronomicalUnits;
import com.zenred.cosmos.domain.PlanetConstraints;
import com.zenred.cosmos.domain.Planetoid;
import com.zenred.cosmos.domain.PlanetoidDao;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.StarDao;
import com.zenred.cosmos.domain.SubClusterFactory;
import com.zenred.cosmos.domain.UnifiedPlanetoidI;
import com.zenred.util.GenRandomRolls;

public class GenPlanet {
	
	static private Logger logger = Logger.getLogger(GenPlanet.class);
	
	private static PlanetoidDao planetoidDao = new PlanetoidDao();
	private static StarDao starDao = new StarDao();
	private static Double maxPlanetRadiusS = new Double(700.0);  // super Jupiters, almost brown dwarfs
	private static Double maxPlanetRadiusM = new Double(80.0);	// Jupiters
	private static Double maxPlanetRadiusT = new Double(50.0);	// dwarf gas giants
	private static Map<Integer, Double> planetSizeSpread = new HashMap<Integer, Double>();
	static{
		planetSizeSpread.put(new Integer(100), maxPlanetRadiusS);
		planetSizeSpread.put(new Integer(90), maxPlanetRadiusM);
		planetSizeSpread.put(new Integer(30), maxPlanetRadiusT);
	}
	
	/**
	 * 
	 * @param star
	 * @param distanceKloms
	 * @return average temperature
	 */
	public static Double temperature(Double luminosity, Double distanceInAUs){
		Double scalar = (Math.pow(luminosity/(distanceInAUs * distanceInAUs), 0.25));
		logger.info("SCALAR:"+scalar+":::"+distanceInAUs+":::"+luminosity+":::");
		Double temp = 295.0 * scalar;
		return temp;
	}

	public static List<Planetoid> persistPlanetoids(Star star){
		List<Planetoid> planetoids = new ArrayList<Planetoid>();
		String starsSubCluster = starDao.readStarsSubClusterDescription(star);
		SubClusterFactory subClusterFactory = SubClusterFactory.mapSubCluster(starsSubCluster);
		@SuppressWarnings("static-access")
		PlanetConstraints planetConstraints = subClusterFactory.getPlanetConstraints(subClusterFactory);
		if(planetConstraints.getNone()){
			star.setNo_planets_allowed(true);
			starDao.updateStarByStarId(star);
			return planetoids;  // NONE
		}
		else{
			star.setNo_planets_allowed(false);
			starDao.updateStarByStarId(star);
			
		}
		Double luminosity = star.getLuminosity();
		logger.info("LUMINOSITY:"+luminosity+"::");
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
			Integer range = GenRandomRolls.Instance().getD100();
			if(range <= 100 && range > 90){
				range = 100;
			}
			else if(range <= 90 && range > 30){
				range = 90;
			}
			else{
				range = 30;
			}
			Double planetRadiusBase = GenRandomRolls.Instance().getDraw(planetSizeSpread.get(range));
			Double planetRadius = GenRandomRolls.Instance().getDraw(planetRadiusBase)*1000.0;
			planetoid.setRadius(planetRadius);
			String name = star.getName()+".planet."+idex;
			planetoid.setPlanetoidName(name);
			planetoid.setTemperature(temperature(luminosity, distanceInAUs));
			planetoid.setPercentWater(0.0);  // evaluate when generating atmosphere
			logger.info("PLANET BEFORE READ:"+planetoid);
			UnifiedPlanetoidI readPlanetI = planetoidDao.addStarPlanetoid(planetoid, star);
			logger.info("UNIFIED PLANET:"+readPlanetI);
			planetoids.add(readPlanetI.getPlanetoid());
		}
		return planetoids;
	}
}
