package com.zenred.cosmos.service_rules_and_infrastructure.atmosphere_postprocess;

import com.zenred.cosmos.domain.Planetoid;

public class IsInSuperEarthRange extends IsInRange {

	public IsInSuperEarthRange(Planetoid planetoid) {
		super(planetoid);
	}

}
