package com.zenred.cosmos.domain;

public class PlanetConstraints {
	
	protected Double startBodeSequence;
	protected Double endBodeSequence;
	protected Integer minNumberPlanets;
	protected Integer maxNumberPlanets;
	protected Boolean none = false;
	
	public Double getStartBodeSequence() {
		return startBodeSequence;
	}
	public void setStartBodeSequence(Double startBodeSequence) {
		this.startBodeSequence = startBodeSequence;
	}
	public Double getEndBodeSequence() {
		return endBodeSequence;
	}
	public void setEndBodeSequence(Double endBodeSequence) {
		this.endBodeSequence = endBodeSequence;
	}
	public Integer getMinNumberPlanets() {
		return minNumberPlanets;
	}
	public void setMinNumberPlanets(Integer minNumberPlanets) {
		this.minNumberPlanets = minNumberPlanets;
	}
	public Integer getMaxNumberPlanets() {
		return maxNumberPlanets;
	}
	public void setMaxNumberPlanets(Integer maxNumberPlanets) {
		this.maxNumberPlanets = maxNumberPlanets;
	}
	public Boolean getNone() {
		return none;
	}
	public void setNone(Boolean none) {
		this.none = none;
	}
	@Override
	public String toString() {
		return "PlanetConstraints [startBodeSequence=" + startBodeSequence
				+ ", endBodeSequence=" + endBodeSequence
				+ ", minNumberPlanets=" + minNumberPlanets
				+ ", maxNumberPlanets=" + maxNumberPlanets + ", none=" + none
				+ "]";
	}

	
}
