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



public enum SubClusterFactory {
	
	SINGLESTAR("SINGLESTAR"){
		
	},
	DOUBLESTAR_BINARY_0("DOUBLESTAR_BINARY_0"){
		
	},
	DOUBLESTAR_BINARY_1("DOUBLESTAR_BINARY_1"){
		
	},
	THREESTAR_TRINARY_0("THREESTAR_TRINARY_0"){
		
	},
	THREESTAR_TRINARY_1("THREESTAR_TRINARY_1"){
		
	},
	THREESTAR_TRINARY_2("THREESTAR_TRINARY_2"){
		
	},
	THREESTAR_BINARYPLUSONE_2("THREESTAR_BINARYPLUSONE_2"){
		
	},
	THREESTAR_BINARYPLUSONE_BINARY_0("THREESTAR_BINARYPLUSONE_BINARY_0"){
		
	},
	THREESTAR_BINARYPLUSONE_BINARY_1("THREESTAR_BINARYPLUSONE_BINARY_1"){
		
	},
	FOURSTAR_TRINARYPLUSONE_1("FOURSTAR_TRINARYPLUSONE_1"){
		
	},
	FOURSTAR_TRINARYPLUSONE_TRINARY_0("FOURSTAR_TRINARYPLUSONE_TRINARY_0"){
		
	},
	FOURSTAR_TRINARYPLUSONE_TRINARY_1("FOURSTAR_TRINARYPLUSONE_TRINARY_1"){
		
	},
	FOURSTAR_TRINARYPLUSONE_TRINARY_2("FOURSTAR_TRINARYPLUSONE_TRINARY_2"){
		
	},
	FOURSTAR_2BINARIES_0_BINARY_0("FOURSTAR_2BINARIES_0_BINARY_0"){
		
	},
	FOURSTAR_2BINARIES_1_BINARY_0("FOURSTAR_2BINARIES_1_BINARY_0"){
		
	},
	FOURSTAR_2BINARIES_0_BINARY_1("FOURSTAR_2BINARIES_0_BINARY_1"){
		
	},
	FOURSTAR_2BINARIES_1_BINARY_1("FOURSTAR_2BINARIES_1_BINARY_1"){
		
	},
	FIVESTAR_FOURSTARSPREADPLUSONE("FIVESTAR_FOURSTARSPREADPLUSONE"){
		
	},
	FIVESTAR_FOURSTARSPREADPLUSONE_1("FIVESTAR_FOURSTARSPREADPLUSONE_1"){
		
	},
	NONE("NONE"){
		
	}
	;
	
	private String type;
	
	private SubClusterFactory (String type){
		this.type = type;
	}
}
