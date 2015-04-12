package com.zenred.cosmos.service_rules_and_infrastructure;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.zenred.cosmos.domain.Atmosphere;

public class GenAtmosphereTest {

	@Test
	public void test() {
		GenAtmosphere genAtmosphere = new GenAtmosphere();
		
		List<Atmosphere> atmospheres = genAtmosphere.persistAtmosphere(null, null);
	}

}
