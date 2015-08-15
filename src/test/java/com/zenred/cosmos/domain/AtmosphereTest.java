package com.zenred.cosmos.domain;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;

public class AtmosphereTest {

	static private Logger logger = Logger.getLogger(AtmosphereTest.class);
	// as they are in the database   watch out for "Trace"
	static private String[] atmos = new String[] { "Argon", "Carbon", "Helium",
			"Hydrogen", "Neon", "Nitrogen", "Oxygen", "Silicon", "Water",
			"CarbonDioxide", "Potassium", "Sodium", "Sulfur", "SulfuricAcid",
			"Methane", "Ethane", "HydrogenSulfide", "Ammonia", "Chlorine",
			"Methlacetylene", "Ozone" };
	
	@Test
	public void test() {
		for (String oneAtmos : atmos) {
			String color = AtmosphereParts.valueOf(AtmosphereParts.class,
					oneAtmos).getColor();
			logger.info("COLOR:" + color);

			java.lang.System.out.println("ATMOS:"+ oneAtmos + " COLOR:" + color);
		}
	}

}
