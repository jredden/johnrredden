package com.zenred.cosmos.service_rules_and_infrastructure;

import com.zenred.cosmos.domain.System;
import com.zenred.cosmos.domain.SystemDao;
import com.zenred.util.GenRandomRolls;

public class GenSystem {

	private static final Double galacticCentre = new Double(50000);
	private static long long_galacticCentre = galacticCentre.longValue();
	private static long dataBaseFull = long_galacticCentre
			* long_galacticCentre * long_galacticCentre * long_galacticCentre;
	private static SystemDao systemDao = new SystemDao();

	public static System genSystem() {
		Double ucoordinate = new Double(GenRandomRolls.Instance().getD100000());
		Double vcoordinate = new Double(GenRandomRolls.Instance().getD100000());
		System system = genSystemFromOrigin(ucoordinate, vcoordinate);
		return system;
	}
	
	// generate a system from a distinct origin
	public static System genSystemFromOrigin(Double ucoordinate, Double vcoordinate){
		Double distance_rel = Math.sqrt(Math.pow(ucoordinate, 2.0)
				+ Math.pow(vcoordinate, 2.0));
		Double distance_abs = Math.abs(galacticCentre - distance_rel);
		System system = new System(null, distance_abs, ucoordinate,
				vcoordinate, null);
		system.setSystemName("System." + ucoordinate.intValue() + '.'
				+ vcoordinate.intValue());
		return system;		
	}

	/**
	 * generates a system where one does not exist
	 * 
	 * @param system
	 * @return
	 */
	public static System candidate(System system) {
		System candidate = system;
		long checkForFull = 0;
		while (systemDao.doesSystemExist(candidate.getUcoordinate(),
				candidate.getVcoordinate())) {
			if (checkForFull++ >= dataBaseFull) {
				throw new RuntimeException("All Systems generated");
			}
			candidate = genSystem();
		}
		return systemDao.addSystem(candidate);
	}

}
