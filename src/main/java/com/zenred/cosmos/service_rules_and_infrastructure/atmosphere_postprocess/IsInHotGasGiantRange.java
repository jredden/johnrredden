package com.zenred.cosmos.service_rules_and_infrastructure.atmosphere_postprocess;

import com.zenred.cosmos.domain.Planetoid;

public class IsInHotGasGiantRange extends IsInRange {

	public IsInHotGasGiantRange(Planetoid planetoid) {
		super(planetoid);
	}

}
