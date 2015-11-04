package com.zenred.cosmos.service_rules_and_infrastructure;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zenred.cosmos.domain.Atmosphere;
import com.zenred.cosmos.domain.Planetoid;

public class PostProcessAtmosphereTest {
	
	private static Logger logger = Logger.getLogger(PostProcessAtmosphereTest.class);

	@Test
	public void test() {
		List<Atmosphere> atmospheres = new ArrayList<Atmosphere>();
		Planetoid planetoid = new Planetoid();
		Atmosphere atmosphere = new Atmosphere();
		planetoid.setRadius(17000.0);
		planetoid.setTemperature(100.0);
		atmosphere.setChem_name("Hydrogen");
		atmosphere.setPercentage(0.5);
		atmospheres.add(atmosphere);
		PostProcessAtmosphere.processByRules(atmospheres, planetoid);
		logger.info("Atmospheres:"+atmospheres);
		
	}

}
