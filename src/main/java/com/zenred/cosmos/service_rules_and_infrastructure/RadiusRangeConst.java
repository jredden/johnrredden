package com.zenred.cosmos.service_rules_and_infrastructure;

public class RadiusRangeConst {
	
	public static final Double DWARF_PLANETOID = new Double(0.0);
	public static final Double MINI_PLANETOID = new Double(1500.0);
	public static final Double EARTH_PLANETOID = new Double(2500.0);
	public static final Double SUPER_EARTH_PLANETOID = new Double(6000.0);
	public static final Double MINI_GAS_GIANT_PLANETOID = new Double(10000.0);
	public static final Double GAS_GIANT_PLANETOID = new Double(30000.0);
	public static final Double SUPER_GAS_GIANT_PLANETOID = new Double(65000.0);
	public static final Double THE_END = Double.MAX_VALUE;
	
	public static Double getDwarfPlanetoid() {
		return DWARF_PLANETOID;
	}
	public static Double getMiniPlanetoid() {
		return MINI_PLANETOID;
	}
	public static Double getEarthPlanetoid() {
		return EARTH_PLANETOID;
	}
	public static Double getSuperEarthPlanetoid() {
		return SUPER_EARTH_PLANETOID;
	}
	public static Double getMiniGasGiantPlanetoid() {
		return MINI_GAS_GIANT_PLANETOID;
	}
	public static Double getGasGiantPlanetoid() {
		return GAS_GIANT_PLANETOID;
	}
	public static Double getSuperGasGiantPlanetoid() {
		return SUPER_GAS_GIANT_PLANETOID;
	}
	public static Double getTheEnd() {
		return THE_END;
	}
	
	

}
