package com.zenred.cosmos.service_rules_and_infrastructure;

import org.apache.log4j.Logger;

import com.zenred.cosmos.domain.PlanetConstraints;
import com.zenred.util.GenRandomRolls;

public class PlanetoidDistances {

	static private Logger logger = Logger.getLogger(PlanetoidDistances.class);
	/**
	 * s = the primary radius, star for a planet, planet for moon y = a random
	 * draw where to start the sequence. See wikipedia extra terrestrial planets
	 * for real astronomical examples. n = the planet number starting with 1 and
	 * limited by planetConstraints. 1.5 is a Bode/Titus constant
	 * 
	 * ((1.5*s)2**(n-1)/y)
	 * 
	 * @param planetConstraints
	 * @return the answer in AU units of "Earth-to-moon" units.
	 */
	public static Double titusBodeApproximater(
			PlanetConstraints planetConstraints, Double radius,
			Integer planetNumber) {
		Double starBodeSequence = planetConstraints.getStartBodeSequence();
		Double endBodeSequence = planetConstraints.getEndBodeSequence();
		Double titusBodeConstant = new Double(1.5);
		Double variableY = new Double(GenRandomRolls.Instance().getDraw(
				starBodeSequence + (endBodeSequence - starBodeSequence)));
		logger.info("BODE:"+variableY+":::"+starBodeSequence+":::"+endBodeSequence+":::"+radius);
		if(variableY == 0.0){
			variableY = 1.0;
		}
		Double answer = (Math.pow(1.5 * radius, planetNumber - 1)) / variableY;
		return answer;
	}
	
	/**
	 * 
	 * @param radiusPrimary
	 * @param radiusSecondary
	 * @return roache radius approximation
	 */
	public static Double approxRoacheRadius(Double radiusPrimary, Double radiusSecondary){
		return 1.26*radiusPrimary*(Math.pow(radiusPrimary/radiusSecondary,1.0/3.0));
	}

}
