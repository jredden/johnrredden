package com.zenred.cosmos.service_rules_and_infrastructure;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


import com.zenred.cosmos.domain.Atmosphere;
import com.zenred.cosmos.domain.Planetoid;

public class PostProcessAtmosphereTest {

	@Test
	public void test() {
		List<Atmosphere> atmospheres = new ArrayList<Atmosphere>();
		Planetoid planetoid = new Planetoid();
		Atmosphere atmosphere = new Atmosphere();
		atmosphere.setChem_name("Hydrogen");
		atmosphere.setPercentage(0.5);
		atmospheres.add(atmosphere);
		PostProcessAtmosphere.processByRules(atmospheres, planetoid);
		
	}

}
