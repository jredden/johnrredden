package com.zenred.cosmos.domain;

public class StarToChemicalProfile {
	private AtmosphereParts atmosphereParts;
	private Double weightDuringAnalysis;  // given star type, how prominent?
	private Double ultraVioletReducingScale;  // 0.0 extreme UV, 99.9 extreme reducing
	
	public AtmosphereParts getAtmosphereParts() {
		return atmosphereParts;
	}
	public void setAtmosphereParts(AtmosphereParts atmosphereParts) {
		this.atmosphereParts = atmosphereParts;
	}
	public Double getWeightDuringAnalysis() {
		return weightDuringAnalysis;
	}
	public void setWeightDuringAnalysis(Double weightDuringAnalysis) {
		this.weightDuringAnalysis = weightDuringAnalysis;
	}
	public Double getUltraVioletReducingScale() {
		return ultraVioletReducingScale;
	}
	public void setUltraVioletReducingScale(Double ultraVioletReducingScale) {
		this.ultraVioletReducingScale = ultraVioletReducingScale;
	}

}
