package com.zenred.cosmos.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlanetoidColor implements Comparable<PlanetoidColor>{
	
	private String color; // has color
	private Double percentage;
	private String chemicalName;
	
	public PlanetoidColor(String color, String chemicalName, Double percentage) {
		super();
		this.color = color;
		this.percentage = percentage;
		this.chemicalName = chemicalName;
	}


	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getChemicalName() {
		return chemicalName;
	}


	public void setChemicalName(String chemicalName) {
		this.chemicalName = chemicalName;
	}

	/**
	 * 	
	 * @param planar
	 * @return list of atmosphere colors sorted by percentages 
	 */
	public static List<PlanetoidColor> planarColors(Planetoid planar){
		AtmosphereDao atmosphereDao = new AtmosphereDao();
		List<PlanetoidColor> planetoidColors = new ArrayList<PlanetoidColor>();
		List<Atmosphere> atmospheres = atmosphereDao.readAtmosphereAroundPlanet(planar);
		for (Atmosphere atmosphere : atmospheres){
			String color = "";
			if(atmosphere.getChem_name().equals("Trace")){
				color = "None";  // old test code
			}
			else{
				color = AtmosphereParts.valueOf(AtmosphereParts.class,
						atmosphere.getChem_name()).getColor();
			}
			PlanetoidColor planetoidColor = new PlanetoidColor(color, atmosphere.getChem_name(), atmosphere.getPercentage());
			planetoidColors.add(planetoidColor);

		}
		Collections.sort(planetoidColors);
		return planetoidColors;
	}
	

	/**
	 * recursive
	 */
	@Override
	public int compareTo(PlanetoidColor planetoidColor) {
		Double percentage1 = planetoidColor.getPercentage();
		Double percentage2 = this.percentage;
		return percentage2.compareTo(percentage1);
	}


	@Override
	public String toString() {
		return "PlanetoidColor [color=" + color + ", percentage=" + percentage
				+ ", chemicalName=" + chemicalName + "]";
	}


	
	

}
