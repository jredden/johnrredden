package com.zenred.cosmos.service_rules_and_infrastructure;

public class RadiusRange {
	
	public static String s_DWARF_PLANETOID = "dwarf planetoid";
	public static String s_MINI_PLANETOID = "mini planetoid";
	public static String s_EARTH_PLANETOID = "terran planetoid";
	public static String s_SUPER_EARTH_PLANETOID = "super terran planetoid";
	public static String s_MINI_GAS_GIANT_PLANETOID = "mini gas giant planetoid";
	public static String s_GAS_GIANT_PLANETOID = "gas giant planetoid";
	public static String s_SUPER_GAS_GIANT_PLANETOID = "super gas giant planetoid";
	
	Double radius; // planetoid start range
	String description; // planetoid description
	Integer key; // used later in triple key

	public RadiusRange(Double radius, String description, Integer key) {
		this.radius = radius;
		this.description = description;
		this.key = key;
	}
}
