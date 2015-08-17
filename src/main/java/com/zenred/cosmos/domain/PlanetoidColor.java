package com.zenred.cosmos.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlanetoidColor implements Comparable<PlanetoidColor>{
	private static Map<String, String> pureStarColors = new HashMap<String, String>();
	static{
		pureStarColors.put("Blue Super Giant II", "blue" );
		pureStarColors.put("Light Blue Super Giant II", "lightblue" );
		pureStarColors.put("White Super Giant II", "white");
		pureStarColors.put("Pale Yellow Super Giant II", "lightyellow");
		pureStarColors.put("Yellow Super Giant II", "yellow");
		pureStarColors.put("Orange Super Giant II", "orange");
		pureStarColors.put("Red Super Giant II", "red");
		pureStarColors.put("Blue Super Giant I", "blue");
		pureStarColors.put("Light Blue Super Giant I", "lightblue");
		pureStarColors.put("White Super Giant I", "white");
		pureStarColors.put("Pale Yellow Super Giant I", "lightyellow");
		pureStarColors.put("Yellow Super Giant I", "yellow");
		pureStarColors.put("Orange Super Giant I", "orange");
		pureStarColors.put("Red Super Giant I", "red");
		pureStarColors.put("Blue Giant II", "blue");
		pureStarColors.put("Light Blue  Giant II", "lightblue");
		pureStarColors.put("White Giant II", "white");
		pureStarColors.put("Pale Yellow Giant II", "lightyellow");
		pureStarColors.put("Yellow Giant II", "yellow");
		pureStarColors.put("Orange Giant II", "orange");
		pureStarColors.put("Red Giant II", "red");
		pureStarColors.put("Blue Giant I", "blue");
		pureStarColors.put("Light Blue  Giant I", "lightblue");
		pureStarColors.put("White Giant I", "white");
		pureStarColors.put("Pale Yellow Giant I", "lightyellow");
		pureStarColors.put("Yellow Giant I", "yellow");
		pureStarColors.put("Orange Giant I", "orange");
		pureStarColors.put("Red Giant I", "red");
		pureStarColors.put("Blue Sub Giant", "blue");
		pureStarColors.put("Light Blue Sub Giant", "lightblue");
		pureStarColors.put("White Sub Giant", "white");
		pureStarColors.put("Pale Yellow SubGiant", "lightyellow");
		pureStarColors.put("Yellow Sub Giant", "yellow");
		pureStarColors.put("Orange Sub Giant", "orange");
		pureStarColors.put("Red Sub Giant", "red");
		pureStarColors.put("Blue Main Sequence", "blue");
		pureStarColors.put("Light Blue Main Sequence", "lightblue");
		pureStarColors.put("White Main Sequence", "white");
		pureStarColors.put("Pale Yellow Main Sequence", "lightyellow");
		pureStarColors.put("Yellow Main Sequence", "yellow");
		pureStarColors.put("Orange Main Sequence", "orange");
		pureStarColors.put("Red Main Sequence", "red");
		pureStarColors.put("Blue Sub Dwarf", "blue");
		pureStarColors.put("Light Blue Sub Dwarf", "lightblue");
		pureStarColors.put("White Sub Dwarf", "white");
		pureStarColors.put("Pale Yellow Sub Dwarf", "lightyellow");
		pureStarColors.put("Yellow Sub Dwarf", "yellow");
		pureStarColors.put("Orange Sub Dwarf", "orange");
		pureStarColors.put("Red Sub Dwarf", "red");
		pureStarColors.put("Blue Dwarf", "blue");
		pureStarColors.put("Light Blue Dwarf", "lightblue");
		pureStarColors.put("White Dwarf", "white");
		pureStarColors.put("Pale Yellow Dwarf", "lightyellow");
		pureStarColors.put("Yellow Dwarf", "yellow");
		pureStarColors.put("Orange Dwarf", "orange");
		pureStarColors.put("Red Dwarf", "red");
		pureStarColors.put("Purple Red Dwarf", "lightpurple" );
		pureStarColors.put("Brown Sub Star", "lightbrown");
		pureStarColors.put("Dark Brown Sub Dwarf", "brown");

	}
	
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
	 * maps a stars astronomical color into a graphic color
	 * 
	 * @param starColor
	 * @return
	 */
	public static String fetchPureColor(String starColor){
		return pureStarColors.get(starColor);
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
