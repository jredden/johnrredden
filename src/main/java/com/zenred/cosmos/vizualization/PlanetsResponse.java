package com.zenred.cosmos.vizualization;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("planets")
public class PlanetsResponse {

	private String starAndPlanets;

	public String getStarAndPlanets() {
		return starAndPlanets;
	}

	public void setStarAndPlanets(String starAndPlanets) {
		this.starAndPlanets = starAndPlanets;
	}

	@Override
	public String toString() {
		return "PlanetsResponse [starAndPlanets=" + starAndPlanets + "]";
	}
	
	
}
