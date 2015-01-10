package com.zenred.cosmos.domain;

/**
     	BLUE_SG_II,
    	LTBL_SG_II,
    	WHIT_SG_II,
    	PYEL_SG_II,
    	YELO_SG_II,
    	ORNG_SG_II,
    	RED__SG_II,
    	BLUE_SG_I,
    	LTBL_SG_I,
    	WHIT_SG_I,
    	PYEL_SG_I,
    	YELO_SG_I,
    	ORNG_SG_I,
    	RED__SG_I,
    	BLUE_GI_II,
    	LTBL_GI_II,
    	WHIT_GI_II,
    	PYEL_GI_II,
    	YELO_GI_II,
    	ORNG_GI_II,
    	RED__GI_II,
    	BLUE_GI_I,
    	LTBL_GI_I,
    	WHIT_GI_I,
    	PYEL_GI_I,
    	YELO_GI_I,
    	ORNG_GI_I,
    	RED__GI_I,
    	BLUE_SUBGI,
    	LTBL_SUBGI,
    	WHIT_SUBGI,
    	PYEL_SUBGI,
    	YELO_SUBGI,
    	ORNG_SUBGI,
    	RED__SUBGI,
    	BLUE_MAINS,
    	LTBL_MAINS,
    	WHIT_MAINS,
    	PYEL_MAINS,
    	YELO_MAINS,
    	ORNG_MAINS,
    	RED__MAINS,
    	BLUE_SUBDW,
    	LTBL_SUBDW,
    	WHIT_SUBDW,
    	PYEL_SUBDW,
    	YELO_SUBDW,
    	ORNG_SUBDW,
    	RED__SUBDW,
    	BLUE_DWARF,
    	LTBL_DWARF,
    	WHIT_DWARF,
    	PYEL_DWARF,
    	YELO_DWARF,
    	ORNG_DWARF,
    	RED__DWARF,
    	PURPLE_RED,
    	BROWN_SUBS,
    	DRKBRN_SDW
 * 
 * @author jredden
 *
 */

interface Name {
	String read();
}

public enum StarFactory {
	
	BLUE_SG_II("BLUE_SG_II"){
		Name read(){
			return blueSGII;
		}
	},
	LTBL_SG_II("LTBL_SG_II"){
		Name read(){
			return ltblSGII;
		}	
	},
	WHIT_SG_II("WHIT_SG_II"){
		Name read(){
			return whitSGII;
		}			
	},
	PYEL_SG_II("PYEL_SG_II"){
		Name read(){
			return pyrlSGII;
		}			
	},
	THREESTAR_TRINARY_1("THREESTAR_TRINARY_1"){
		Name read(){
			return null;
		}			
	},
	THREESTAR_TRINARY_2("THREESTAR_TRINARY_2"){
		Name read(){
			return null;
		}			
	},
	THREESTAR_BINARYPLUSONE("THREESTAR_BINARYPLUSONE"){
		Name read(){
			return null;
		}			
	},
	FOURSTAR_TRINARYPLUSONE("FOURSTAR_TRINARYPLUSONE"){
		Name read(){
			return null;
		}			
	},
	FOURSTAR_2BINARIES_0("FOURSTAR_2BINARIES_0"){
		Name read(){
			return null;
		}			
	},
	FOURSTAR_2BINARIES_1("FOURSTAR_2BINARIES_1"){
		Name read(){
			return null;
		}			
	},
	FIVESTAR_FOURSTARSPREADPLUSONE("FIVESTAR_FOURSTARSPREADPLUSONE"){
		Name read(){
			return null;
		}			
	},
	NONE("NONE"){
		Name read(){
			return null;
		}	
	}
	;
	
	protected static Name blueSGII = new Name(){
		public String read(){
			return "Blue Super Giant II";
		}
	};
	protected static Name ltblSGII = new Name(){
		public String read(){
			return "Light Blue Super Giant II";
		}
	};
	protected static Name whitSGII = new Name(){
		public String read(){
			return "White Super Giant II";
		}
	};
	protected static Name pyrlSGII = new Name(){
		public String read(){
			return "Pale Yellow Super Giant II";
		}
	};
	protected static Name yeloSGII = new Name(){
		public String read(){
			return "Yellow Super Giant II";
		}
	};
	protected static Name orngSGII = new Name(){
		public String read(){
			return "Orange Super Giant II";
		}
	};
	protected static Name redSGII = new Name(){
		public String read(){
			return "Red Super Giant II";
		}
	};
	protected static Name blueSGI = new Name(){
		public String read(){
			return "Blue Super Giant I";
		}
	};
	protected static Name ltblSGI = new Name(){
		public String read(){
			return "Light Blue Super Giant I";
		}
	};
	protected static Name whitSGI = new Name(){
		public String read(){
			return "White Super Giant I";
		}
	};
	protected static Name pyrlSGI = new Name(){
		public String read(){
			return "Pale Yellow Super Giant I";
		}
	};
	protected static Name yeloSGI = new Name(){
		public String read(){
			return "Yellow Super Giant I";
		}
	};
	protected static Name orngSGI = new Name(){
		public String read(){
			return "Orange Super Giant I";
		}
	};
	protected static Name redSGI = new Name(){
		public String read(){
			return "Red Super Giant I";
		}
	};
	protected static Name blueGIII = new Name(){
		public String read(){
			return "Blue Giant II";
		}
	};
	protected static Name ltblGIII = new Name(){
		public String read(){
			return "Light Blue  Giant II";
		}
	};
	protected static Name whitGIII = new Name(){
		public String read(){
			return "White Giant II";
		}
	};
	protected static Name pyrlGIII = new Name(){
		public String read(){
			return "Pale Yellow Giant II";
		}
	};
	protected static Name yeloGIII = new Name(){
		public String read(){
			return "Yellow Giant II";
		}
	};
	protected static Name orngGIII = new Name(){
		public String read(){
			return "Orange Giant II";
		}
	};
	protected static Name redGIII = new Name(){
		public String read(){
			return "Red Giant II";
		}
	};
	protected static Name blueGII = new Name(){
		public String read(){
			return "Blue Giant I";
		}
	};
	protected static Name ltblGII = new Name(){
		public String read(){
			return "Light Blue  Giant I";
		}
	};
	protected static Name whitGII = new Name(){
		public String read(){
			return "White Giant I";
		}
	};
	protected static Name pyrlGII = new Name(){
		public String read(){
			return "Pale Yellow Giant I";
		}
	};
	protected static Name yeloGII = new Name(){
		public String read(){
			return "Yellow Giant I";
		}
	};
	protected static Name orngGII = new Name(){
		public String read(){
			return "Orange Giant I";
		}
	};
	protected static Name redGII = new Name(){
		public String read(){
			return "Red Giant I";
		}
	};
	protected static Name blueSubGI = new Name(){
		public String read(){
			return "Blue Sub Giant";
		}
	};
	protected static Name ltblSubGI = new Name(){
		public String read(){
			return "Light Blue Sub Giant";
		}
	};
	protected static Name whitSubGI = new Name(){
		public String read(){
			return "White Sub Giant";
		}
	};
	protected static Name pyrlSubGI = new Name(){
		public String read(){
			return "Pale Yellow SubGiant";
		}
	};
	protected static Name yeloSubGI = new Name(){
		public String read(){
			return "Yellow Sub Giant";
		}
	};
	protected static Name orngSubGI = new Name(){
		public String read(){
			return "Orange Sub Giant";
		}
	};
	protected static Name redSubGI = new Name(){
		public String read(){
			return "Red Sub Giant";
		}
	};
	protected static Name blueMainS = new Name(){
		public String read(){
			return "Blue Main Sequence";
		}
	};
	protected static Name ltblMainS = new Name(){
		public String read(){
			return "Light Blue Main Sequence";
		}
	};
	protected static Name whitMainS = new Name(){
		public String read(){
			return "White Main Sequence";
		}
	};
	protected static Name pyrlMainS = new Name(){
		public String read(){
			return "Pale Yellow Main Sequence";
		}
	};
	protected static Name yeloMainS = new Name(){
		public String read(){
			return "Yellow Main Sequence";
		}
	};
	protected static Name orngMainS = new Name(){
		public String read(){
			return "Orange Main Sequence";
		}
	};
	protected static Name redMainS = new Name(){
		public String read(){
			return "Red Main Sequence";
		}
	};
	protected static Name blueSubDW = new Name(){
		public String read(){
			return "Blue Sub Dwarf";
		}
	};
	protected static Name ltblSubDW = new Name(){
		public String read(){
			return "Light Blue Sub Dwarf";
		}
	};
	protected static Name whitSubDW = new Name(){
		public String read(){
			return "White Sub Dwarf";
		}
	};
	protected static Name pyrlSubDW = new Name(){
		public String read(){
			return "Pale Yellow Sub Dwarf";
		}
	};
	protected static Name yeloSubDW = new Name(){
		public String read(){
			return "Yellow Sub Dwarf";
		}
	};
	protected static Name orngSubDW = new Name(){
		public String read(){
			return "Orange Sub Dwarf";
		}
	};
	protected static Name redSubDW = new Name(){
		public String read(){
			return "Red Sub Dwarf";
		}
	};
	protected static Name blueDwarf = new Name(){
		public String read(){
			return "Blue Dwarf";
		}
	};
	protected static Name ltblDwarf = new Name(){
		public String read(){
			return "Light Blue Dwarf";
		}
	};
	protected static Name whitDwarf = new Name(){
		public String read(){
			return "White Dwarf";
		}
	};
	protected static Name pyrlDwarf = new Name(){
		public String read(){
			return "Pale Yellow Dwarf";
		}
	};
	protected static Name yeloDwarf = new Name(){
		public String read(){
			return "Yellow Dwarf";
		}
	};
	protected static Name orngDwarf = new Name(){
		public String read(){
			return "Orange Dwarf";
		}
	};
	protected static Name redDwarf = new Name(){
		public String read(){
			return "Red Dwarf";
		}
	};
	protected static Name purpleRed = new Name(){
		public String read(){
			return "Purple Red Dwarf";
		}
	};
	protected static Name brownSubS = new Name(){
		public String read(){
			return "Brown Sub Star";
		}
	};
	protected static Name drkBrnSDW = new Name(){
		public String read(){
			return "Dark Brown Sub Dwarf";
		}
	};
	private String type;
	
	private StarFactory (String type){
		this.type = type;
	}
	
	abstract Name read();
}
