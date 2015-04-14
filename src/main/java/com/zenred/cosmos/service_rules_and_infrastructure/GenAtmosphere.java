package com.zenred.cosmos.service_rules_and_infrastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.zenred.cosmos.domain.Atmosphere;
import com.zenred.cosmos.domain.Planetoid;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.StarFactory;

/**
 * 
 * @author jredden
 *
 *
 key with three dimensions
 Star color
 Planetoid Temperature
 Planetoid Radius in kilometers
 *
 *
 */

public class GenAtmosphere {
	
	private static Logger logger = Logger.getLogger(GenAtmosphere.class);
	
	class AtmosphereResolution{
		List<Atmosphere> resolve(StarFactory starFactory, Integer radiusKey, Integer temperatureKey){
			
			return null;
		}
	}
	

	
	class RadiusRange{
		Double radius;		// planetoid start range
		String description;	// planetoid description 
		Integer key;		// used later in triple key
		
		public RadiusRange(Double radius, String description, Integer key){
			this.radius = radius;
			this.description = description;
			this.key = key;
		}
	}
	
	class TemperatureRange {
		Double temperature;
		String description;
		Integer key;
		
		public TemperatureRange (Double temperature, String description, Integer key){
			this.temperature = temperature;
			this.description = description;
			this.key = key;
		}
	}
	private static GenAtmosphere genAtmosphere = new GenAtmosphere();
	
	private static List<RadiusRange> planetsRadius = new ArrayList<RadiusRange>();
	static{
		planetsRadius.add(genAtmosphere.new RadiusRange(new Double(300.0), "dwarf planetoid", 0));		// dwarf planetoid start range
		planetsRadius.add(genAtmosphere.new RadiusRange(new Double(1500.0), "mini planetoid", 1));	// mini planetoid start range
		planetsRadius.add(genAtmosphere.new RadiusRange(new Double(2500.0), "terran planetoid", 2));	// terran planetoid start range
		planetsRadius.add(genAtmosphere.new RadiusRange(new Double(6000.0), "super terran planetoid", 3));	// super terran planetoid start range
		planetsRadius.add(genAtmosphere.new RadiusRange(new Double(10000.0), "mini gas giant planetoid", 4));	// mini gas giant planetoid start range
		planetsRadius.add(genAtmosphere.new RadiusRange(new Double(30000.0), "gas giant planetoid", 5));	// gas giant planetoid start range
		planetsRadius.add(genAtmosphere.new RadiusRange(new Double(65000.0), "super gas giant planetoid", 6));	// super gas giant  planetoid start range
		planetsRadius.add(genAtmosphere.new RadiusRange(new Double(Double.MAX_VALUE), "end", 7));
	}
	
	private static List<TemperatureRange> temperaturesRange = new ArrayList<TemperatureRange>();
	static{
		temperaturesRange.add(genAtmosphere.new TemperatureRange(new Double(0.0), "cyrogenic", 0)); 	// cryogenic start range
		temperaturesRange.add(genAtmosphere.new TemperatureRange(new Double(41.0), "ice", 1));			// ice start range 
		temperaturesRange.add(genAtmosphere.new TemperatureRange(new Double(101.0), "rock", 2));		// rock, terran like range
		temperaturesRange.add(genAtmosphere.new TemperatureRange(new Double(701.0), "hot", 3));			// cythian, or hot gas 
		temperaturesRange.add(genAtmosphere.new TemperatureRange(new Double(900.0), "molten", 4));		// gaseous metals ...
		temperaturesRange.add(genAtmosphere.new TemperatureRange(Double.MAX_VALUE, "end", 5));
	}
	List<Atmosphere> persistAtmosphere(Star star, Planetoid planetoid){
		List<Atmosphere> atmospheres = new ArrayList<Atmosphere>();
		
		StarFactory starFactory = StarFactory.accessByString(star.getStar_color());
		Double planetoidTemperature = planetoid.getTemperature();
		Double planetoidRadius = planetoid.getRadius();
		Integer radiusKey = null;
		for (int idex = 0; ;idex++){
			if(planetoidRadius >= planetsRadius.get(idex).radius && planetoidRadius < planetsRadius.get(idex+1).radius ){
				radiusKey = planetsRadius.get(idex).key;
				break;
			}
		}
		Integer temperatureKey = null;
		for(int idex = 0;  ; idex++){
			if(planetoidTemperature >= temperaturesRange.get(idex).temperature && planetoidTemperature < temperaturesRange.get(idex+1).temperature){
				temperatureKey = temperaturesRange.get(idex).key;
				break;
			}
		}
		
		
		
		return atmospheres;
	}
}
