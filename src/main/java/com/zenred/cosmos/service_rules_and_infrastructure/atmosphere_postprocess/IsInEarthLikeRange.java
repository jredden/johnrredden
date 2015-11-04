package com.zenred.cosmos.service_rules_and_infrastructure.atmosphere_postprocess;

import com.zenred.cosmos.domain.Planetoid;

public class IsInEarthLikeRange extends IsInRange {

	public IsInEarthLikeRange(Planetoid planetoid) {
		super(planetoid);
	}

}
