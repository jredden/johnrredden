package com.zenred.cosmos.domain;

public class PlanetoidColor {
	
	private AtmosphereParts atmospherePart; // has color
	private Double percentage;
	
	public PlanetoidColor(AtmosphereParts atmospherePart, Double percentage) {
		super();
		this.atmospherePart = atmospherePart;
		this.percentage = percentage;
	}

	public AtmosphereParts getAtmospherePart() {
		return atmospherePart;
	}

	public void setAtmospherePart(AtmosphereParts atmospherePart) {
		this.atmospherePart = atmospherePart;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	
	/*	
	public static List<PlanetoidColor> planarColors(Planetoid planar){
		List<>
	}
	*/

	@Override
	public String toString() {
		return "PlanetoidColor [atmospherePart=" + atmospherePart
				+ ", percentage=" + percentage + "]";
	}
	
	

}
