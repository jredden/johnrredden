package com.zenred.cosmos.service_rules_and_infrastructure.atmosphere_postprocess;

import com.zenred.cosmos.domain.Planetoid;

public class IsInMiniGasGiantRange extends IsInRange {

	public IsInMiniGasGiantRange(Planetoid planetoid) {
		super(planetoid);
	}

}
