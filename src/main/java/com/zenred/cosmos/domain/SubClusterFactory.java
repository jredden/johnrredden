package com.zenred.cosmos.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 'SINGLESTAR' , 'DOUBLESTAR_BINARY_0' , 'DOUBLESTAR_BINARY_1' ,
 * 'THREESTAR_TRINARY_0' , 'THREESTAR_TRINARY_1' , 'THREESTAR_TRINARY_2' ,
 * 'THREESTAR_BINARYPLUSONE' , 'FOURSTAR_TRINARYPLUSONE' ,
 * 'FOURSTAR_2BINARIES_0' , 'FOURSTAR_2BINARIES_1' ,
 * 'FIVESTAR_FOURSTARSPREADPLUSONE', NONE
 * 
 * @author jredden
 * 
 * These are the sub cluster configurations with non-rogue planets.
 *
 */




public enum SubClusterFactory {
	
	SINGLESTAR("SINGLESTAR"){
		

		@Override
		PlanetConstraints planetConstraints() {
			PlanetConstraints planetConstraints = new PlanetConstraints();
			planetConstraints.startBodeSequence = new Double(1.0);
			planetConstraints.endBodeSequence = new Double(100.0);
			planetConstraints.minNumberPlanets = new Integer(5);
			planetConstraints.maxNumberPlanets = new Integer(12);
			return planetConstraints;
		}
		
	},
	DOUBLESTAR_BINARY_0("DOUBLESTAR_BINARY_0"){
		@Override
		PlanetConstraints planetConstraints() {
			PlanetConstraints planetConstraints = new PlanetConstraints();
			planetConstraints.startBodeSequence = new Double(30.0);
			planetConstraints.endBodeSequence = new Double(100.0);
			planetConstraints.minNumberPlanets = new Integer(0);
			planetConstraints.maxNumberPlanets = new Integer(6);
			return planetConstraints;
		}
		
	},
	DOUBLESTAR_BINARY_1("DOUBLESTAR_BINARY_1"){
		@Override
		PlanetConstraints planetConstraints() {
			PlanetConstraints planetConstraints = new PlanetConstraints();
			planetConstraints.startBodeSequence = new Double(30.0);
			planetConstraints.endBodeSequence = new Double(100.0);
			planetConstraints.minNumberPlanets = new Integer(0);
			planetConstraints.maxNumberPlanets = new Integer(6);
			return planetConstraints;
		}
		
	},
	THREESTAR_TRINARY_0("THREESTAR_TRINARY_0"){
		@Override
		PlanetConstraints planetConstraints() {
			PlanetConstraints planetConstraints = new PlanetConstraints();
			planetConstraints.startBodeSequence = new Double(50.0);
			planetConstraints.endBodeSequence = new Double(100.0);
			planetConstraints.minNumberPlanets = new Integer(0);
			planetConstraints.maxNumberPlanets = new Integer(5);
			return planetConstraints;
		}
		
	},
	THREESTAR_TRINARY_1("THREESTAR_TRINARY_1"){
		@Override
		PlanetConstraints planetConstraints() {
			PlanetConstraints planetConstraints = new PlanetConstraints();
			planetConstraints.startBodeSequence = new Double(50.0);
			planetConstraints.endBodeSequence = new Double(100.0);
			planetConstraints.minNumberPlanets = new Integer(0);
			planetConstraints.maxNumberPlanets = new Integer(5);
			return planetConstraints;
		}
		
	},
	THREESTAR_TRINARY_2("THREESTAR_TRINARY_2"){
		@Override
		PlanetConstraints planetConstraints() {
			PlanetConstraints planetConstraints = new PlanetConstraints();
			planetConstraints.startBodeSequence = new Double(50.0);
			planetConstraints.endBodeSequence = new Double(100.0);
			planetConstraints.minNumberPlanets = new Integer(0);
			planetConstraints.maxNumberPlanets = new Integer(5);
			return planetConstraints;
		}
		
	},
	THREESTAR_BINARYPLUSONE_2("THREESTAR_BINARYPLUSONE_2"){
		@Override
		PlanetConstraints planetConstraints() {
			PlanetConstraints planetConstraints = new PlanetConstraints();
			planetConstraints.startBodeSequence = new Double(1.0);
			planetConstraints.endBodeSequence = new Double(100.0);
			planetConstraints.minNumberPlanets = new Integer(0);
			planetConstraints.maxNumberPlanets = new Integer(6);
			return planetConstraints;
		}
		
	},
	THREESTAR_BINARYPLUSONE_BINARY_0("THREESTAR_BINARYPLUSONE_BINARY_0"){
		@Override
		PlanetConstraints planetConstraints() {
			PlanetConstraints planetConstraints = new PlanetConstraints();
			planetConstraints.startBodeSequence = new Double(30.0);
			planetConstraints.endBodeSequence = new Double(100.0);
			planetConstraints.minNumberPlanets = new Integer(0);
			planetConstraints.maxNumberPlanets = new Integer(6);
			return planetConstraints;
		}
		
	},
	THREESTAR_BINARYPLUSONE_BINARY_1("THREESTAR_BINARYPLUSONE_BINARY_1"){
		@Override
		PlanetConstraints planetConstraints() {
			PlanetConstraints planetConstraints = new PlanetConstraints();
			planetConstraints.startBodeSequence = new Double(30.0);
			planetConstraints.endBodeSequence = new Double(100.0);
			planetConstraints.minNumberPlanets = new Integer(0);
			planetConstraints.maxNumberPlanets = new Integer(6);
			return planetConstraints;
		}
		
	},
	FOURSTAR_TRINARYPLUSONE_1("FOURSTAR_TRINARYPLUSONE_1"){
		@Override
		PlanetConstraints planetConstraints() {
			PlanetConstraints planetConstraints = new PlanetConstraints();
			planetConstraints.startBodeSequence = new Double(1.0);
			planetConstraints.endBodeSequence = new Double(100.0);
			planetConstraints.minNumberPlanets = new Integer(0);
			planetConstraints.maxNumberPlanets = new Integer(6);
			return planetConstraints;
		}
		
	},
	FOURSTAR_TRINARYPLUSONE_TRINARY_0("FOURSTAR_TRINARYPLUSONE_TRINARY_0"){
		@Override
		PlanetConstraints planetConstraints() {
			PlanetConstraints planetConstraints = new PlanetConstraints();
			planetConstraints.startBodeSequence = new Double(50.0);
			planetConstraints.endBodeSequence = new Double(100.0);
			planetConstraints.minNumberPlanets = new Integer(0);
			planetConstraints.maxNumberPlanets = new Integer(5);
			return planetConstraints;
		}
		
	},
	FOURSTAR_TRINARYPLUSONE_TRINARY_1("FOURSTAR_TRINARYPLUSONE_TRINARY_1"){
		@Override
		PlanetConstraints planetConstraints() {
			PlanetConstraints planetConstraints = new PlanetConstraints();
			planetConstraints.startBodeSequence = new Double(50.0);
			planetConstraints.endBodeSequence = new Double(100.0);
			planetConstraints.minNumberPlanets = new Integer(0);
			planetConstraints.maxNumberPlanets = new Integer(5);
			return planetConstraints;
		}
		
	},
	FOURSTAR_TRINARYPLUSONE_TRINARY_2("FOURSTAR_TRINARYPLUSONE_TRINARY_2"){
		@Override
		PlanetConstraints planetConstraints() {
			PlanetConstraints planetConstraints = new PlanetConstraints();
			planetConstraints.startBodeSequence = new Double(50.0);
			planetConstraints.endBodeSequence = new Double(100.0);
			planetConstraints.minNumberPlanets = new Integer(0);
			planetConstraints.maxNumberPlanets = new Integer(5);
			return planetConstraints;
		}
		
	},
	FOURSTAR_2BINARIES_0_BINARY_0("FOURSTAR_2BINARIES_0_BINARY_0"){
		@Override
		PlanetConstraints planetConstraints() {
			PlanetConstraints planetConstraints = new PlanetConstraints();
			planetConstraints.startBodeSequence = new Double(30.0);
			planetConstraints.endBodeSequence = new Double(100.0);
			planetConstraints.minNumberPlanets = new Integer(0);
			planetConstraints.maxNumberPlanets = new Integer(6);
			return planetConstraints;
		}
		
	},
	FOURSTAR_2BINARIES_1_BINARY_0("FOURSTAR_2BINARIES_1_BINARY_0"){
		@Override
		PlanetConstraints planetConstraints() {
			PlanetConstraints planetConstraints = new PlanetConstraints();
			planetConstraints.startBodeSequence = new Double(30.0);
			planetConstraints.endBodeSequence = new Double(100.0);
			planetConstraints.minNumberPlanets = new Integer(0);
			planetConstraints.maxNumberPlanets = new Integer(6);
			return planetConstraints;
		}
		
	},
	FOURSTAR_2BINARIES_0_BINARY_1("FOURSTAR_2BINARIES_0_BINARY_1"){
		@Override
		PlanetConstraints planetConstraints() {
			PlanetConstraints planetConstraints = new PlanetConstraints();
			planetConstraints.startBodeSequence = new Double(30.0);
			planetConstraints.endBodeSequence = new Double(100.0);
			planetConstraints.minNumberPlanets = new Integer(0);
			planetConstraints.maxNumberPlanets = new Integer(6);
			return planetConstraints;
		}
		
	},
	FOURSTAR_2BINARIES_1_BINARY_1("FOURSTAR_2BINARIES_1_BINARY_1"){
		@Override
		PlanetConstraints planetConstraints() {
			PlanetConstraints planetConstraints = new PlanetConstraints();
			planetConstraints.startBodeSequence = new Double(30.0);
			planetConstraints.endBodeSequence = new Double(100.0);
			planetConstraints.minNumberPlanets = new Integer(0);
			planetConstraints.maxNumberPlanets = new Integer(6);
			return planetConstraints;
		}
		
	},
	FIVESTAR_FOURSTARSPREADPLUSONE("FIVESTAR_FOURSTARSPREADPLUSONE"){

		@Override
		PlanetConstraints planetConstraints() {
			PlanetConstraints planetConstraints = new PlanetConstraints();
			planetConstraints.none = true;
			return planetConstraints;
		}
		
	},
	FIVESTAR_FOURSTARSPREADPLUSONE_1("FIVESTAR_FOURSTARSPREADPLUSONE_1"){
		@Override
		PlanetConstraints planetConstraints() {
			PlanetConstraints planetConstraints = new PlanetConstraints();
			planetConstraints.startBodeSequence = new Double(1.0);
			planetConstraints.endBodeSequence = new Double(100.0);
			planetConstraints.minNumberPlanets = new Integer(0);
			planetConstraints.maxNumberPlanets = new Integer(6);
			return planetConstraints;
		}
		
	},
	NONE("NONE"){

		@Override
		PlanetConstraints planetConstraints() {
			PlanetConstraints planetConstraints = new PlanetConstraints();
			planetConstraints.none = true;
			return planetConstraints;
		}
		
	}
	;
	
	abstract PlanetConstraints planetConstraints();
	
	private String type;
	
	private SubClusterFactory (String type){
		this.type = type;
	}
	
	private static Map<String,SubClusterFactory> map = new HashMap<String, SubClusterFactory>();
	static{
		map.put("SINGLESTAR", SINGLESTAR);
		map.put("DOUBLESTAR_BINARY_0", DOUBLESTAR_BINARY_0);
		map.put("DOUBLESTAR_BINARY_1", DOUBLESTAR_BINARY_1);
		map.put("THREESTAR_TRINARY_0", THREESTAR_TRINARY_0);
		map.put("THREESTAR_TRINARY_1", THREESTAR_TRINARY_1);
		map.put("THREESTAR_TRINARY_2", THREESTAR_TRINARY_2);
		map.put("THREESTAR_BINARYPLUSONE_2", THREESTAR_BINARYPLUSONE_2);
		map.put("THREESTAR_BINARYPLUSONE_BINARY_0", THREESTAR_BINARYPLUSONE_BINARY_0);
		map.put("THREESTAR_BINARYPLUSONE_BINARY_1", THREESTAR_BINARYPLUSONE_BINARY_1);
		map.put("FOURSTAR_TRINARYPLUSONE_1", FOURSTAR_TRINARYPLUSONE_1);
		map.put("FOURSTAR_TRINARYPLUSONE_TRINARY_0", FOURSTAR_TRINARYPLUSONE_TRINARY_0);
		map.put("FOURSTAR_TRINARYPLUSONE_TRINARY_1", FOURSTAR_TRINARYPLUSONE_TRINARY_1);
		map.put("FOURSTAR_TRINARYPLUSONE_TRINARY_2", FOURSTAR_TRINARYPLUSONE_TRINARY_2);
		map.put("FOURSTAR_2BINARIES_0_BINARY_0", FOURSTAR_2BINARIES_0_BINARY_0);
		map.put("FOURSTAR_2BINARIES_1_BINARY_0", FOURSTAR_2BINARIES_1_BINARY_0);
		map.put("FOURSTAR_2BINARIES_0_BINARY_1", FOURSTAR_2BINARIES_0_BINARY_1);
		map.put("FOURSTAR_2BINARIES_1_BINARY_1", FOURSTAR_2BINARIES_1_BINARY_1);
		map.put("FIVESTAR_FOURSTARSPREADPLUSONE", FIVESTAR_FOURSTARSPREADPLUSONE);
		map.put("FIVESTAR_FOURSTARSPREADPLUSONE_1", FIVESTAR_FOURSTARSPREADPLUSONE_1);
		map.put("NONE", NONE);
	}
	/**
	 * Used to map database element to enumeration Object
	 * 
	 * @param subCluster
	 * @return SubClusterFactory
	 */
	public static SubClusterFactory mapSubCluster(String subCluster){
		return map.get(subCluster);
	}
	
	/**
	 * public accessor
	 * 
	 * @param subClusterFactory
	 * @return constraints
	 */
	public static PlanetConstraints getPlanetConstraints(SubClusterFactory subClusterFactory){
		return subClusterFactory.planetConstraints();
	}
}
