package com.zenred.cosmos.domain;

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
class PlanetConstraints{
	Double startBodeSequence;
	Double endBodeSequence;
	Integer minNumberPlanets;
	Integer maxNumberPlanets;
	public Double getStartBodeSequence() {
		return startBodeSequence;
	}
	public void setStartBodeSequence(Double startBodeSequence) {
		this.startBodeSequence = startBodeSequence;
	}
	public Double getEndBodeSequence() {
		return endBodeSequence;
	}
	public void setEndBodeSequence(Double endBodeSequence) {
		this.endBodeSequence = endBodeSequence;
	}
	public Integer getMinNumberPlanets() {
		return minNumberPlanets;
	}
	public void setMinNumberPlanets(Integer minNumberPlanets) {
		this.minNumberPlanets = minNumberPlanets;
	}
	public Integer getMaxNumberPlanets() {
		return maxNumberPlanets;
	}
	public void setMaxNumberPlanets(Integer maxNumberPlanets) {
		this.maxNumberPlanets = maxNumberPlanets;
	}
	@Override
	public String toString() {
		return "PlanetConstraints [startBodeSequence=" + startBodeSequence
				+ ", endBodeSequence=" + endBodeSequence
				+ ", minNumberPlanets=" + minNumberPlanets
				+ ", maxNumberPlanets=" + maxNumberPlanets + "]";
	}
	
	
}


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
			// TODO Auto-generated method stub
			return null;
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
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	;
	
	abstract PlanetConstraints planetConstraints();
	
	private String type;
	
	private SubClusterFactory (String type){
		this.type = type;
	}
}
