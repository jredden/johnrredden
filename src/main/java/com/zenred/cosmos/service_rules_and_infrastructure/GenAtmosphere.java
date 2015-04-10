package com.zenred.cosmos.service_rules_and_infrastructure;

import java.util.ArrayList;
import java.util.List;

import com.zenred.cosmos.domain.Atmosphere;
import com.zenred.cosmos.domain.Planetoid;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.StarFactory;

/**
 * 
 * @author jredden
 *
 *
 array with three dimensions
 Star color
 Planetoid Temperature
 Planetoid Radius in kilometers
 *
 *
 */

public class GenAtmosphere {
	
	class RadiusRange{
		Double radius;		// planetoid start range
		String description;	// planetoid description 
		
		public RadiusRange(Double radius, String description){
			this.radius = radius;
			this.description = description;
		}
	}
	
	private Integer numberStarColors = StarFactory.values().length;
	private static GenAtmosphere genAtmosphere = new GenAtmosphere();
	private static List<RadiusRange> planetsRadius = new ArrayList<RadiusRange>();
	static{
		planetsRadius.add(genAtmosphere.new RadiusRange(new Double(300), "dwarf planetoid"));		// dwarf planetoid start range
		planetsRadius.add(genAtmosphere.new RadiusRange(new Double(1500.0), "mini planetoid"));	// mini planetoid start range
		planetsRadius.add(genAtmosphere.new RadiusRange(new Double(2500.0), "terran planetoid"));	// terran planetoid start range
		planetsRadius.add(genAtmosphere.new RadiusRange(new Double(6000.0), "super terran planetoid"));	// super terran planetoid start range
		planetsRadius.add(genAtmosphere.new RadiusRange(new Double(10000.0), "mini gas giant planetoid"));	// mini gas giant planetoid start range
		planetsRadius.add(genAtmosphere.new RadiusRange(new Double(30000.0), "gas giant planetoid"));	// gas giant planetoid start range
		planetsRadius.add(genAtmosphere.new RadiusRange(new Double(65000.0), "super gas giant planetoid"));	// super gas giant  planetoid start range
	}

	List<Atmosphere> persistAtmosphere(Star star, Planetoid planetoid){
		List<Atmosphere> atmospheres = new ArrayList<Atmosphere>();
		
		return atmospheres;
	}
}
