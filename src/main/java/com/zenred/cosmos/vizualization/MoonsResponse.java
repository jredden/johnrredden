package com.zenred.cosmos.vizualization;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("planets")
public class MoonsResponse {

	private String planetAndMoons;

	public String getPlanetAndMoons() {
		return planetAndMoons;
	}

	public void setPlanetAndMoons(String planetAndMoons) {
		this.planetAndMoons = planetAndMoons;
	}

	@Override
	public String toString() {
		return "PlanetsResponse [planetAndMoons=" + planetAndMoons + "]";
	}
	
	
}
