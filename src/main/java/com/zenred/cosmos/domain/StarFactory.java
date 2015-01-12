package com.zenred.cosmos.domain;

import com.zenred.util.GenRandomRolls;

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
	String code();
}

public enum StarFactory {
	
	BLUE_SG_II("BLUE_SG_II"){
		Name read(){
			return blueSGII;
		}

		@Override
		Name code() {
			return blueSGII;
		}
	},
	LTBL_SG_II("LTBL_SG_II"){
		Name read(){
			return ltblSGII;
		}

		@Override
		Name code() {

			return ltblSGII;
		}	
	},
	WHIT_SG_II("WHIT_SG_II"){
		Name read(){
			return whitSGII;
		}

		@Override
		Name code() {

			return whitSGII;
		}			
	},
	PYEL_SG_II("PYEL_SG_II"){
		Name read(){
			return pyrlSGII;
		}

		@Override
		Name code() {

			return pyrlSGII;
		}			
	},
	YELO_SG_II("YELO_SG_II"){
		Name read(){
			return yeloSGII;
		}

		@Override
		Name code() {

			return yeloSGII;
		}			
	},
	ORNG_SG_II("ORNG_SG_II"){
		Name read(){
			return orngSGII;
		}

		@Override
		Name code() {

			return orngSGII;
		}			
	},
	RED__SG_II("RED__SG_II"){
		Name read(){
			return redSGII;
		}

		@Override
		Name code() {

			return redSGII;
		}			
	},
	BLUE_SG_I("BLUE_SG_I"){
		Name read(){
			return blueSGI;
		}

		@Override
		Name code() {

			return blueSGI;
		}			
	},
	LTBL_SG_I("LTBL_SG_I"){
		Name read(){
			return ltblSGI;
		}

		@Override
		Name code() {

			return ltblSGI;
		}			
	},
	WHIT_SG_I("WHIT_SG_I"){
		Name read(){
			return whitSGI;
		}

		@Override
		Name code() {

			return whitSGI;
		}			
	},
	PYEL_SG_I("PYEL_SG_I"){
		Name read(){
			return pyrlSGI;
		}

		@Override
		Name code() {

			return pyrlSGI;
		}			
	},
	YELO_SG_I("YELO_SG_I"){
		Name read(){
			return yeloSGI;
		}

		@Override
		Name code() {

			return yeloSGI;
		}	
	},
	ORNG_SG_I("ORNG_SG_I"){
		Name read(){
			return orngSGI;
		}

		@Override
		Name code() {

			return orngSGI;
		}	
	},
	RED__SG_I("RED__SG_I"){
		Name read(){
			return redSGI;
		}

		@Override
		Name code() {

			return redSGI;
		}	
	},
	BLUE_GI_II("BLUE_GI_II"){
		Name read(){
			return blueGIII;
		}

		@Override
		Name code() {

			return blueGIII;
		}	
	},
	LTBL_GI_II("LTBL_GI_II"){
		Name read(){
			return ltblGIII;
		}

		@Override
		Name code() {

			return ltblGIII;
		}	
	},
	WHIT_GI_II("WHIT_GI_II"){
		Name read(){
			return whitGIII;
		}

		@Override
		Name code() {

			return whitGIII;
		}	
	},
	PYEL_GI_II("PYEL_GI_II"){
		Name read(){
			return pyrlGIII;
		}

		@Override
		Name code() {

			return pyrlGIII;
		}	
	},
	YELO_GI_II("YELO_GI_II"){
		Name read(){
			return yeloGIII;
		}

		@Override
		Name code() {

			return yeloGIII;
		}	
	},
	ORNG_GI_II("ORNG_GI_II"){
		Name read(){
			return orngGIII;
		}

		@Override
		Name code() {

			return orngGIII;
		}	
	},
	RED__GI_II("RED__GI_II"){
		Name read(){
			return redGIII;
		}

		@Override
		Name code() {

			return redGIII;
		}	
	},
	BLUE_GI_I("BLUE_GI_I"){
		Name read(){
			return blueGII;
		}

		@Override
		Name code() {

			return blueGII;
		}	
	},
	LTBL_GI_I("LTBL_GI_I"){
		Name read(){
			return ltblGII;
		}

		@Override
		Name code() {

			return ltblGII;
		}	
	},
	WHIT_GI_I("WHIT_GI_I"){
		Name read(){
			return whitGII;
		}

		@Override
		Name code() {

			return whitGII;
		}	
	},
	PYEL_GI_I("PYEL_GI_I"){
		Name read(){
			return pyrlGII;
		}

		@Override
		Name code() {

			return pyrlGII;
		}	
	},
	YELO_GI_I("YELO_GI_I"){
		Name read(){
			return yeloGII;
		}

		@Override
		Name code() {

			return yeloGII;
		}	
	},
	ORNG_GI_I("ORNG_GI_I"){
		Name read(){
			return orngGII;
		}

		@Override
		Name code() {

			return orngGII;
		}	
	},
	RED__GI_I("RED__GI_I"){
		Name read(){
			return redGII;
		}

		@Override
		Name code() {

			return redGII;
		}	
	},
	BLUE_SUBGI("BLUE_SUBGI"){
		Name read(){
			return blueSubGI;
		}

		@Override
		Name code() {

			return blueSubGI;
		}	
	},
	LTBL_SUBGI("LTBL_SUBGI"){
		Name read(){
			return ltblSubGI;
		}

		@Override
		Name code() {

			return ltblSubGI;
		}	
	},
	WHIT_SUBGI("WHIT_SUBGI"){
		Name read(){
			return whitSubGI;
		}

		@Override
		Name code() {

			return whitSubGI;
		}	
	},
	PYEL_SUBGI("PYEL_SUBGI"){
		Name read(){
			return pyrlSubGI;
		}

		@Override
		Name code() {

			return pyrlSubGI;
		}	
	},
	YELO_SUBGI("YELO_SUBGI"){
		Name read(){
			return yeloSubGI;
		}

		@Override
		Name code() {

			return yeloSubGI;
		}	
	},
	ORNG_SUBGI("ORNG_SUBGI"){
		Name read(){
			return orngSubGI;
		}

		@Override
		Name code() {

			return orngSubGI;
		}	
	},
	RED__SUBGI("RED__SUBGI"){
		Name read(){
			return redSubGI;
		}

		@Override
		Name code() {

			return redSubGI;
		}	
	},
	BLUE_MAINS("BLUE_MAINS"){
		Name read(){
			return blueMainS;
		}

		@Override
		Name code() {

			return blueMainS;
		}	
	},
	LTBL_MAINS("LTBL_MAINS"){
		Name read(){
			return ltblMainS;
		}

		@Override
		Name code() {

			return ltblMainS;
		}	
	},
	WHIT_MAINS("WHIT_MAINS"){
		Name read(){
			return whitMainS;
		}

		@Override
		Name code() {

			return whitMainS;
		}	
	},
	PYEL_MAINS("PYEL_MAINS"){
		Name read(){
			return pyrlMainS;
		}

		@Override
		Name code() {

			return pyrlMainS;
		}	
	},
	YELO_MAINS("YELO_MAINS"){
		Name read(){
			return yeloMainS;
		}

		@Override
		Name code() {

			return yeloMainS;
		}	
	},
	ORNG_MAINS("ORNG_MAINS"){
		Name read(){
			return orngMainS;
		}

		@Override
		Name code() {

			return orngMainS;
		}	
	},
	RED__MAINS("RED__MAINS"){
		Name read(){
			return redMainS;
		}

		@Override
		Name code() {

			return redMainS;
		}	
	},
	BLUE_SUBDW("BLUE_SUBDW"){
		Name read(){
			return blueSubDW;
		}

		@Override
		Name code() {

			return blueSubDW;
		}	
	},
	LTBL_SUBDW("LTBL_SUBDW"){
		Name read(){
			return ltblSubDW;
		}

		@Override
		Name code() {

			return ltblSubDW;
		}	
	},
	WHIT_SUBDW("WHIT_SUBDW"){
		Name read(){
			return whitSubDW;
		}

		@Override
		Name code() {

			return whitSubDW;
		}	
	},
	PYEL_SUBDW("PYEL_SUBDW"){
		Name read(){
			return pyrlSubDW;
		}

		@Override
		Name code() {

			return pyrlSubDW;
		}	
	},
	YELO_SUBDW("YELO_SUBDW"){
		Name read(){
			return yeloSubDW;
		}

		@Override
		Name code() {

			return yeloSubDW;
		}	
	},
	ORNG_SUBDW("ORNG_SUBDW"){
		Name read(){
			return orngSubDW;
		}

		@Override
		Name code() {

			return orngSubDW;
		}	
	},
	RED__SUBDW("RED__SUBDW"){
		Name read(){
			return redSubDW;
		}

		@Override
		Name code() {

			return redSubDW;
		}	
	},
	BLUE_DWARF("BLUE_DWARF"){
		Name read(){
			return blueDwarf;
		}

		@Override
		Name code() {

			return blueDwarf;
		}	
	},
	LTBL_DWARF("LTBL_DWARF"){
		Name read(){
			return ltblDwarf;
		}

		@Override
		Name code() {

			return ltblDwarf;
		}	
	},
	WHIT_DWARF("WHIT_DWARF"){
		Name read(){
			return whitDwarf;
		}

		@Override
		Name code() {

			return whitDwarf;
		}	
	},
	PYEL_DWARF("PYEL_DWARF"){
		Name read(){
			return pyrlDwarf;
		}

		@Override
		Name code() {

			return pyrlDwarf;
		}	
	},
	YELO_DWARF("YELO_DWARF"){
		Name read(){
			return yeloDwarf;
		}

		@Override
		Name code() {

			return yeloDwarf;
		}	
	},
	ORNG_DWARF("ORNG_DWARF"){
		Name read(){
			return orngDwarf;
		}

		@Override
		Name code() {

			return orngDwarf;
		}	
	},
	RED__DWARF("RED__DWARF"){
		Name read(){
			return redDwarf;
		}

		@Override
		Name code() {

			return redDwarf;
		}	
	},
	PURPLE_RED("PURPLE_RED"){
		Name read(){
			return purpleRed;
		}

		@Override
		Name code() {

			return purpleRed;
		}	
	},
	BROWN_SUBS("BROWN_SUBS"){
		Name read(){
			return brownSubS;
		}

		@Override
		Name code() {

			return brownSubS;
		}	
	},
	DRKBRN_SDW("DRKBRN_SDW"){
		Name read(){
			return drkBrnSDW;
		}

		@Override
		Name code() {

			return drkBrnSDW;
		}	
	}
	;
	
	protected static Name blueSGII = new Name(){
		public String read(){
			return "Blue Super Giant II";
		}

		public String code() {
			return "sg2o"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name ltblSGII = new Name(){
		public String read(){
			return "Light Blue Super Giant II";
		}

		public String code() {
			return "sg2b"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name whitSGII = new Name(){
		public String read(){
			return "White Super Giant II";
		}
		public String code() {
			return "sg2a"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name pyrlSGII = new Name(){
		public String read(){
			return "Pale Yellow Super Giant II";
		}

		public String code() {
			return "sg2f"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name yeloSGII = new Name(){
		public String read(){
			return "Yellow Super Giant II";
		}

		public String code() {
			return "sg2g"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name orngSGII = new Name(){
		public String read(){
			return "Orange Super Giant II";
		}

		public String code() {
			// TODO Auto-generated method stub
			return "sg2k"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name redSGII = new Name(){
		public String read(){
			return "Red Super Giant II";
		}

		public String code() {
			return "sg2m"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name blueSGI = new Name(){
		public String read(){
			return "Blue Super Giant I";
		}

		public String code() {
			return "sg1o"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name ltblSGI = new Name(){
		public String read(){
			return "Light Blue Super Giant I";
		}

		public String code() {
			return "sg1b"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name whitSGI = new Name(){
		public String read(){
			return "White Super Giant I";
		}

		public String code() {
			return "sg1a"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name pyrlSGI = new Name(){
		public String read(){
			return "Pale Yellow Super Giant I";
		}

		public String code() {
			return "sg1f"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name yeloSGI = new Name(){
		public String read(){
			return "Yellow Super Giant I";
		}

		public String code() {
			return "sg1g"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name orngSGI = new Name(){
		public String read(){
			return "Orange Super Giant I";
		}

		public String code() {
			return "sg1k"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name redSGI = new Name(){
		public String read(){
			return "Red Super Giant I";
		}

		public String code() {
			return "sg1m"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name blueGIII = new Name(){
		public String read(){
			return "Blue Giant II";
		}

		public String code() {
			return "sg2o"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name ltblGIII = new Name(){
		public String read(){
			return "Light Blue  Giant II";
		}

		public String code() {
			return "sg2b"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name whitGIII = new Name(){
		public String read(){
			return "White Giant II";
		}

		public String code() {
			return "sg2a"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name pyrlGIII = new Name(){
		public String read(){
			return "Pale Yellow Giant II";
		}

		public String code() {
			return "sg2f"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name yeloGIII = new Name(){
		public String read(){
			return "Yellow Giant II";
		}

		public String code() {
			return "sg2g"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name orngGIII = new Name(){
		public String read(){
			return "Orange Giant II";
		}

		public String code() {
			return "sg2k"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name redGIII = new Name(){
		public String read(){
			return "Red Giant II";
		}

		public String code() {
			return "sg2m"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name blueGII = new Name(){
		public String read(){
			return "Blue Giant I";
		}

		public String code() {
			return "g1o"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name ltblGII = new Name(){
		public String read(){
			return "Light Blue  Giant I";
		}

		public String code() {
			return "g1b"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name whitGII = new Name(){
		public String read(){
			return "White Giant I";
		}

		public String code() {
			return "g1a"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name pyrlGII = new Name(){
		public String read(){
			return "Pale Yellow Giant I";
		}

		public String code() {
			return "g1f"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name yeloGII = new Name(){
		public String read(){
			return "Yellow Giant I";
		}

		public String code() {
			return "g1g"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name orngGII = new Name(){
		public String read(){
			return "Orange Giant I";
		}

		public String code() {
			return "g1k"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name redGII = new Name(){
		public String read(){
			return "Red Giant I";
		}

		public String code() {
			return "g1m"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name blueSubGI = new Name(){
		public String read(){
			return "Blue Sub Giant";
		}

		public String code() {
			return "sbgo"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name ltblSubGI = new Name(){
		public String read(){
			return "Light Blue Sub Giant";
		}

		public String code() {
			return "sbgb"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name whitSubGI = new Name(){
		public String read(){
			return "White Sub Giant";
		}

		public String code() {
			return "sbga"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name pyrlSubGI = new Name(){
		public String read(){
			return "Pale Yellow SubGiant";
		}

		public String code() {
			return "sbgf"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name yeloSubGI = new Name(){
		public String read(){
			return "Yellow Sub Giant";
		}

		public String code() {
			return "sbgg"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name orngSubGI = new Name(){
		public String read(){
			return "Orange Sub Giant";
		}

		public String code() {
			return "sbgk"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name redSubGI = new Name(){
		public String read(){
			return "Red Sub Giant";
		}

		public String code() {
			return "sbgm"+GenRandomRolls.Instance().get_D9();
		}
	};
	protected static Name blueMainS = new Name(){
		public String read(){
			return "Blue Main Sequence";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	protected static Name ltblMainS = new Name(){
		public String read(){
			return "Light Blue Main Sequence";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	protected static Name whitMainS = new Name(){
		public String read(){
			return "White Main Sequence";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	protected static Name pyrlMainS = new Name(){
		public String read(){
			return "Pale Yellow Main Sequence";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	protected static Name yeloMainS = new Name(){
		public String read(){
			return "Yellow Main Sequence";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	protected static Name orngMainS = new Name(){
		public String read(){
			return "Orange Main Sequence";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	protected static Name redMainS = new Name(){
		public String read(){
			return "Red Main Sequence";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	protected static Name blueSubDW = new Name(){
		public String read(){
			return "Blue Sub Dwarf";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	protected static Name ltblSubDW = new Name(){
		public String read(){
			return "Light Blue Sub Dwarf";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	protected static Name whitSubDW = new Name(){
		public String read(){
			return "White Sub Dwarf";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	protected static Name pyrlSubDW = new Name(){
		public String read(){
			return "Pale Yellow Sub Dwarf";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	protected static Name yeloSubDW = new Name(){
		public String read(){
			return "Yellow Sub Dwarf";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	protected static Name orngSubDW = new Name(){
		public String read(){
			return "Orange Sub Dwarf";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	protected static Name redSubDW = new Name(){
		public String read(){
			return "Red Sub Dwarf";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	protected static Name blueDwarf = new Name(){
		public String read(){
			return "Blue Dwarf";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	protected static Name ltblDwarf = new Name(){
		public String read(){
			return "Light Blue Dwarf";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	protected static Name whitDwarf = new Name(){
		public String read(){
			return "White Dwarf";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	protected static Name pyrlDwarf = new Name(){
		public String read(){
			return "Pale Yellow Dwarf";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	protected static Name yeloDwarf = new Name(){
		public String read(){
			return "Yellow Dwarf";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	protected static Name orngDwarf = new Name(){
		public String read(){
			return "Orange Dwarf";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	protected static Name redDwarf = new Name(){
		public String read(){
			return "Red Dwarf";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	protected static Name purpleRed = new Name(){
		public String read(){
			return "Purple Red Dwarf";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	protected static Name brownSubS = new Name(){
		public String read(){
			return "Brown Sub Star";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	protected static Name drkBrnSDW = new Name(){
		public String read(){
			return "Dark Brown Sub Dwarf";
		}

		public String code() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	private String type;
	
	private StarFactory (String type){
		this.type = type;
	}
	
	abstract Name read();	
	abstract Name code();
}
