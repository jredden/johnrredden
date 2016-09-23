package com.zenred.cosmos.service_rules_and_infrastructure;

public class TemperatureRange {
		
	public static String CRYOGENIC = "cyrogenic";
	public static String ICE = "ice";
	public static String TEMPERATE = "temperate";
	public static String HOT = "hot";
	public static String MOLTEN = "molten";
	
	Double temperature;
	String description;
	Integer key;

	public TemperatureRange(Double temperature, String description,
			Integer key) {
		this.temperature = temperature;
		this.description = description;
		this.key = key;
	}

}
