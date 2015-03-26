package com.zenred.cosmos.service_rules_and_infrastructure;

import com.zenred.cosmos.domain.PlanetConstraints;
import com.zenred.util.GenRandomRolls;

public class PlanetoidDistances {
	
	/**
	 * s = the primary radius, star for a planet, planet for moon
	 * y = a random draw where to start the sequence.  See wikipedia extra terrestrial planets for real astronomical examples.
	 * n = the planet number starting with 1 and limited by planetConstraints. 
	 * 1.5 is a Bode/Titus constant
	 * 
	 * ((1.5*s)2**(n-1)/y)
	 * 
	 * @param planetConstraints
	 * @return the answer in AU units of "Earth-to-moon" units.
	 */
	public static Double titusBodeApproximater(PlanetConstraints planetConstraints, Double radius, Integer planetNumber){
		Double starBodeSequence = planetConstraints.getStartBodeSequence();
		Double endBodeSequence = planetConstraints.getEndBodeSequence();
		Double titusBodeConstant = new Double(1.5);
		Double variableY = new Double(GenRandomRolls.Instance().getDraw(starBodeSequence + (endBodeSequence-starBodeSequence)));
		Double answer = (Math.pow(1.5*radius, planetNumber -1 ))/variableY;
		return answer;
	}

}
