package com.zenred.cosmos.service_rules_and_infrastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.zenred.cosmos.domain.AstronomicalUnits;
import com.zenred.cosmos.domain.PlanetConstraints;
import com.zenred.cosmos.domain.Planetoid;
import com.zenred.cosmos.domain.PlanetoidDao;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.UnifiedPlanetoidI;
import com.zenred.util.GenRandomRolls;

public class GenMoon {
	static private Logger logger = Logger.getLogger(GenMoon.class);

	private static PlanetoidDao planetoidDao = new PlanetoidDao();

	private static Double maxMoonRadiusS = new Double(
			AstronomicalUnits.MINIMUM_RADIUS_FOR_MOONS * 6);
	private static Double maxMoonRadiusM = new Double(
			AstronomicalUnits.MINIMUM_RADIUS_FOR_MOONS * 4);
	private static Double maxMoonRadiusT = new Double(
			AstronomicalUnits.MINIMUM_RADIUS_FOR_MOONS * 2);
	private static Double maxMoonRadiusB = new Double(
			AstronomicalUnits.MINIMUM_RADIUS_FOR_MOONS);
	private static Map<Integer, Double> moonOrbitSpread = new HashMap<Integer, Double>();
	static {
		moonOrbitSpread.put(new Integer(100), maxMoonRadiusS);
		moonOrbitSpread.put(new Integer(90), maxMoonRadiusM);
		moonOrbitSpread.put(new Integer(30), maxMoonRadiusT);
		moonOrbitSpread.put(new Integer(0), maxMoonRadiusB);
	}

	private static Map<Double, Integer> numberOfMoons = new HashMap<Double, Integer>();
	static {
		numberOfMoons.put(2000.0, 2);
		numberOfMoons.put(3000.0, 3);
		numberOfMoons.put(5000.0, 4);
		numberOfMoons.put(10000.0, 10);
		numberOfMoons.put(50000.0, 15);
		numberOfMoons.put(100000.0, 20);
		numberOfMoons.put(1000000.0, 0);
	}

	public static List<Planetoid> persistPlanetoids(Star star,
			Planetoid planetoid) {
		List<Planetoid> planetoids = new ArrayList<Planetoid>();
		if (planetoid.getRadius() < AstronomicalUnits.MINIMUM_RADIUS_FOR_MOONS) {
			return planetoids; // no moons
		}
		Set<Double> keys = numberOfMoons.keySet();
		Double[] dKeys = new Double[keys.size()];
		Iterator<Double> iter = keys.iterator();
		int idexi = 0;
		while(iter.hasNext()){
			dKeys[idexi++] = iter.next();
		}
		Integer numberOfMoonz = 0;
		for (int idex = 0; idex < dKeys.length - 1; idex++) {
			if (planetoid.getRadius() >= dKeys[idex]
					&& planetoid.getRadius() < dKeys[idex + 1]) {
				numberOfMoonz = numberOfMoons.get(dKeys[idex]);
			}
		}
		numberOfMoonz = GenRandomRolls.Instance().getDX(numberOfMoonz);

		// start point for bode-titus approximation
		Integer range = GenRandomRolls.Instance().getD100();
		if (range <= 100 && range > 90) {
			range = 100;
		} else if (range <= 90 && range > 30) {
			range = 90;
		} else if (range <= 30 && range > 10) {
			range = 30;
		} else {
			range = 0;
		}
		Double start = moonOrbitSpread.get(range)
				+ GenRandomRolls.Instance().getDraw(
						AstronomicalUnits.MINIMUM_RADIUS_FOR_MOONS);
		PlanetConstraints planetConstraints = new PlanetConstraints();
		planetConstraints.setMinNumberPlanets(0);
		planetConstraints.setMaxNumberPlanets(numberOfMoonz);
		planetConstraints.setStartBodeSequence(start);
		planetConstraints.setEndBodeSequence(start
				+ GenRandomRolls.Instance().getDraw(
						AstronomicalUnits.MINIMUM_RADIUS_FOR_MOONS));

		for (int idex = 0; idex < numberOfMoonz; idex++) {
			Planetoid planetoid2 = new Planetoid();
			planetoid2.setDegree(Math.toRadians(GenRandomRolls.Instance()
					.getD360()));
			planetoid2.setDistanceToPrimary(
					planetoid.getRadius() * (idex +1) +				// scale in terms of moons planets radius
					PlanetoidDistances
					.titusBodeApproximater(planetConstraints,
							planetoid.getRadius(), idex)
					* AstronomicalUnits.MINIMUM_RADIUS_FOR_MOONS);  // scale in terms of minimum radius for moons
			planetoid2.setRadius(AstronomicalUnits.SMALL_MOON_RADIUS
					+ GenRandomRolls.Instance().getDraw(
							planetoid.getRadius() * 0.75));
			String name = planetoid.getPlanetoidName() + ".moon." + idex;
			planetoid2.setPlanetoidName(name);
			planetoid2.setTemperature(planetoid.getTemperature());
			planetoid2.setPercentWater(0.0); // evaluate when generating
												// atmosphere
			logger.info("PLANET BEFORE READ:" + planetoid);
			UnifiedPlanetoidI readPlanetI = planetoidDao.addPlanetoidPlanetoid(
					planetoid2, planetoid);
			logger.info("UNIFIED MOON:" + readPlanetI);
			planetoids.add(readPlanetI.getPlanetoid());
		}

		return planetoids;
	}

}
