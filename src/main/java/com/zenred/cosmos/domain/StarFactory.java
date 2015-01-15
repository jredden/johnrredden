package com.zenred.cosmos.domain;

import com.zenred.util.GenRandomRolls;

/**
 * BLUE_SG_II, LTBL_SG_II, WHIT_SG_II, PYEL_SG_II, YELO_SG_II, ORNG_SG_II,
 * RED__SG_II, BLUE_SG_I, LTBL_SG_I, WHIT_SG_I, PYEL_SG_I, YELO_SG_I, ORNG_SG_I,
 * RED__SG_I, BLUE_GI_II, LTBL_GI_II, WHIT_GI_II, PYEL_GI_II, YELO_GI_II,
 * ORNG_GI_II, RED__GI_II, BLUE_GI_I, LTBL_GI_I, WHIT_GI_I, PYEL_GI_I,
 * YELO_GI_I, ORNG_GI_I, RED__GI_I, BLUE_SUBGI, LTBL_SUBGI, WHIT_SUBGI,
 * PYEL_SUBGI, YELO_SUBGI, ORNG_SUBGI, RED__SUBGI, BLUE_MAINS, LTBL_MAINS,
 * WHIT_MAINS, PYEL_MAINS, YELO_MAINS, ORNG_MAINS, RED__MAINS, BLUE_SUBDW,
 * LTBL_SUBDW, WHIT_SUBDW, PYEL_SUBDW, YELO_SUBDW, ORNG_SUBDW, RED__SUBDW,
 * BLUE_DWARF, LTBL_DWARF, WHIT_DWARF, PYEL_DWARF, YELO_DWARF, ORNG_DWARF,
 * RED__DWARF, PURPLE_RED, BROWN_SUBS, DRKBRN_SDW
 * 
 * @author jredden
 *
 */

interface Name {
	String read();

	String code();

	short subCode();
}

class Sequence{
	StarFactory sfup;
	public Sequence(StarFactory sfup, StarFactory sfdown) {
		super();
		this.sfup = sfup;
		this.sfdown = sfdown;
	}
	StarFactory sfdown;
}

public enum StarFactory {

	BLUE_SG_II("BLUE_SG_II") {
		Name read() {
			return blueSGII;
		}

		@Override
		Name code() {
			return blueSGII;
		}

		@Override
		Name subCode() {
			return blueSGII;
		}
	},
	LTBL_SG_II("LTBL_SG_II") {
		Name read() {
			return ltblSGII;
		}

		@Override
		Name code() {

			return ltblSGII;
		}

		@Override
		Name subCode() {

			return ltblSGII;
		}
	},
	WHIT_SG_II("WHIT_SG_II") {
		Name read() {
			return whitSGII;
		}

		@Override
		Name code() {

			return whitSGII;
		}

		@Override
		Name subCode() {

			return whitSGII;
		}
	},
	PYEL_SG_II("PYEL_SG_II") {
		Name read() {
			return pyrlSGII;
		}

		@Override
		Name code() {

			return pyrlSGII;
		}

		@Override
		Name subCode() {

			return pyrlSGII;
		}
	},
	YELO_SG_II("YELO_SG_II") {
		Name read() {
			return yeloSGII;
		}

		@Override
		Name code() {

			return yeloSGII;
		}

		@Override
		Name subCode() {

			return yeloSGII;
		}
	},
	ORNG_SG_II("ORNG_SG_II") {
		Name read() {
			return orngSGII;
		}

		@Override
		Name code() {

			return orngSGII;
		}

		@Override
		Name subCode() {

			return orngSGII;
		}
	},
	RED__SG_II("RED__SG_II") {
		Name read() {
			return redSGII;
		}

		@Override
		Name code() {

			return redSGII;
		}

		@Override
		Name subCode() {

			return redSGII;
		}
	},
	BLUE_SG_I("BLUE_SG_I") {
		Name read() {
			return blueSGI;
		}

		@Override
		Name code() {

			return blueSGI;
		}

		@Override
		Name subCode() {

			return blueSGI;
		}
	},
	LTBL_SG_I("LTBL_SG_I") {
		Name read() {
			return ltblSGI;
		}

		@Override
		Name code() {

			return ltblSGI;
		}

		@Override
		Name subCode() {

			return ltblSGI;
		}
	},
	WHIT_SG_I("WHIT_SG_I") {
		Name read() {
			return whitSGI;
		}

		@Override
		Name code() {

			return whitSGI;
		}

		@Override
		Name subCode() {

			return whitSGI;
		}
	},
	PYEL_SG_I("PYEL_SG_I") {
		Name read() {
			return pyrlSGI;
		}

		@Override
		Name code() {

			return pyrlSGI;
		}

		@Override
		Name subCode() {

			return pyrlSGI;
		}
	},
	YELO_SG_I("YELO_SG_I") {
		Name read() {
			return yeloSGI;
		}

		@Override
		Name code() {

			return yeloSGI;
		}

		@Override
		Name subCode() {

			return yeloSGI;
		}
	},
	ORNG_SG_I("ORNG_SG_I") {
		Name read() {
			return orngSGI;
		}

		@Override
		Name code() {

			return orngSGI;
		}

		@Override
		Name subCode() {

			return orngSGI;
		}
	},
	RED__SG_I("RED__SG_I") {
		Name read() {
			return redSGI;
		}

		@Override
		Name code() {

			return redSGI;
		}

		@Override
		Name subCode() {

			return redSGI;
		}
	},
	BLUE_GI_II("BLUE_GI_II") {
		Name read() {
			return blueGIII;
		}

		@Override
		Name code() {

			return blueGIII;
		}

		@Override
		Name subCode() {

			return blueGIII;
		}
	},
	LTBL_GI_II("LTBL_GI_II") {
		Name read() {
			return ltblGIII;
		}

		@Override
		Name code() {

			return ltblGIII;
		}

		@Override
		Name subCode() {

			return ltblGIII;
		}
	},
	WHIT_GI_II("WHIT_GI_II") {
		Name read() {
			return whitGIII;
		}

		@Override
		Name code() {

			return whitGIII;
		}

		@Override
		Name subCode() {

			return whitGIII;
		}
	},
	PYEL_GI_II("PYEL_GI_II") {
		Name read() {
			return pyrlGIII;
		}

		@Override
		Name code() {

			return pyrlGIII;
		}

		@Override
		Name subCode() {

			return pyrlGIII;
		}
	},
	YELO_GI_II("YELO_GI_II") {
		Name read() {
			return yeloGIII;
		}

		@Override
		Name code() {

			return yeloGIII;
		}

		@Override
		Name subCode() {

			return yeloGIII;
		}
	},
	ORNG_GI_II("ORNG_GI_II") {
		Name read() {
			return orngGIII;
		}

		@Override
		Name code() {

			return orngGIII;
		}

		@Override
		Name subCode() {

			return orngGIII;
		}
	},
	RED__GI_II("RED__GI_II") {
		Name read() {
			return redGIII;
		}

		@Override
		Name code() {

			return redGIII;
		}

		@Override
		Name subCode() {

			return redGIII;
		}
	},
	BLUE_GI_I("BLUE_GI_I") {
		Name read() {
			return blueGII;
		}

		@Override
		Name code() {

			return blueGII;
		}

		@Override
		Name subCode() {

			return blueGII;
		}
	},
	LTBL_GI_I("LTBL_GI_I") {
		Name read() {
			return ltblGII;
		}

		@Override
		Name code() {

			return ltblGII;
		}

		@Override
		Name subCode() {

			return ltblGII;
		}
	},
	WHIT_GI_I("WHIT_GI_I") {
		Name read() {
			return whitGII;
		}

		@Override
		Name code() {

			return whitGII;
		}

		@Override
		Name subCode() {

			return whitGII;
		}
	},
	PYEL_GI_I("PYEL_GI_I") {
		Name read() {
			return pyrlGII;
		}

		@Override
		Name code() {

			return pyrlGII;
		}

		@Override
		Name subCode() {

			return pyrlGII;
		}
	},
	YELO_GI_I("YELO_GI_I") {
		Name read() {
			return yeloGII;
		}

		@Override
		Name code() {

			return yeloGII;
		}

		@Override
		Name subCode() {

			return yeloGII;
		}
	},
	ORNG_GI_I("ORNG_GI_I") {
		Name read() {
			return orngGII;
		}

		@Override
		Name code() {

			return orngGII;
		}

		@Override
		Name subCode() {

			return orngGII;
		}
	},
	RED__GI_I("RED__GI_I") {
		Name read() {
			return redGII;
		}

		@Override
		Name code() {

			return redGII;
		}

		@Override
		Name subCode() {

			return redGII;
		}
	},
	BLUE_SUBGI("BLUE_SUBGI") {
		Name read() {
			return blueSubGI;
		}

		@Override
		Name code() {

			return blueSubGI;
		}

		@Override
		Name subCode() {

			return blueSubGI;
		}
	},
	LTBL_SUBGI("LTBL_SUBGI") {
		Name read() {
			return ltblSubGI;
		}

		@Override
		Name code() {

			return ltblSubGI;
		}

		@Override
		Name subCode() {

			return ltblSubGI;
		}
	},
	WHIT_SUBGI("WHIT_SUBGI") {
		Name read() {
			return whitSubGI;
		}

		@Override
		Name code() {

			return whitSubGI;
		}

		@Override
		Name subCode() {

			return whitSubGI;
		}
	},
	PYEL_SUBGI("PYEL_SUBGI") {
		Name read() {
			return pyrlSubGI;
		}

		@Override
		Name code() {

			return pyrlSubGI;
		}

		@Override
		Name subCode() {

			return pyrlSubGI;
		}
	},
	YELO_SUBGI("YELO_SUBGI") {
		Name read() {
			return yeloSubGI;
		}

		@Override
		Name code() {

			return yeloSubGI;
		}

		@Override
		Name subCode() {

			return yeloSubGI;
		}
	},
	ORNG_SUBGI("ORNG_SUBGI") {
		Name read() {
			return orngSubGI;
		}

		@Override
		Name code() {

			return orngSubGI;
		}

		@Override
		Name subCode() {

			return orngSubGI;
		}
	},
	RED__SUBGI("RED__SUBGI") {
		Name read() {
			return redSubGI;
		}

		@Override
		Name code() {

			return redSubGI;
		}

		@Override
		Name subCode() {

			return redSubGI;
		}
	},
	BLUE_MAINS("BLUE_MAINS") {
		Name read() {
			return blueMainS;
		}

		@Override
		Name code() {

			return blueMainS;
		}

		@Override
		Name subCode() {

			return blueMainS;
		}
	},
	LTBL_MAINS("LTBL_MAINS") {
		Name read() {
			return ltblMainS;
		}

		@Override
		Name code() {

			return ltblMainS;
		}

		@Override
		Name subCode() {

			return ltblMainS;
		}
	},
	WHIT_MAINS("WHIT_MAINS") {
		Name read() {
			return whitMainS;
		}

		@Override
		Name code() {

			return whitMainS;
		}

		@Override
		Name subCode() {

			return whitMainS;
		}
	},
	PYEL_MAINS("PYEL_MAINS") {
		Name read() {
			return pyrlMainS;
		}

		@Override
		Name code() {

			return pyrlMainS;
		}

		@Override
		Name subCode() {

			return pyrlMainS;
		}
	},
	YELO_MAINS("YELO_MAINS") {
		Name read() {
			return yeloMainS;
		}

		@Override
		Name code() {

			return yeloMainS;
		}

		@Override
		Name subCode() {

			return yeloMainS;
		}
	},
	ORNG_MAINS("ORNG_MAINS") {
		Name read() {
			return orngMainS;
		}

		@Override
		Name code() {

			return orngMainS;
		}

		@Override
		Name subCode() {

			return orngMainS;
		}
	},
	RED__MAINS("RED__MAINS") {
		Name read() {
			return redMainS;
		}

		@Override
		Name code() {

			return redMainS;
		}

		@Override
		Name subCode() {

			return redMainS;
		}
	},
	BLUE_SUBDW("BLUE_SUBDW") {
		Name read() {
			return blueSubDW;
		}

		@Override
		Name code() {

			return blueSubDW;
		}

		@Override
		Name subCode() {

			return blueSubDW;
		}
	},
	LTBL_SUBDW("LTBL_SUBDW") {
		Name read() {
			return ltblSubDW;
		}

		@Override
		Name code() {

			return ltblSubDW;
		}

		@Override
		Name subCode() {

			return ltblSubDW;
		}
	},
	WHIT_SUBDW("WHIT_SUBDW") {
		Name read() {
			return whitSubDW;
		}

		@Override
		Name code() {

			return whitSubDW;
		}

		@Override
		Name subCode() {

			return whitSubDW;
		}
	},
	PYEL_SUBDW("PYEL_SUBDW") {
		Name read() {
			return pyrlSubDW;
		}

		@Override
		Name code() {

			return pyrlSubDW;
		}

		@Override
		Name subCode() {

			return pyrlSubDW;
		}
	},
	YELO_SUBDW("YELO_SUBDW") {
		Name read() {
			return yeloSubDW;
		}

		@Override
		Name code() {

			return yeloSubDW;
		}

		@Override
		Name subCode() {

			return yeloSubDW;
		}
	},
	ORNG_SUBDW("ORNG_SUBDW") {
		Name read() {
			return orngSubDW;
		}

		@Override
		Name code() {

			return orngSubDW;
		}

		@Override
		Name subCode() {

			return orngSubDW;
		}
	},
	RED__SUBDW("RED__SUBDW") {
		Name read() {
			return redSubDW;
		}

		@Override
		Name code() {

			return redSubDW;
		}

		@Override
		Name subCode() {

			return redSubDW;
		}
	},
	BLUE_DWARF("BLUE_DWARF") {
		Name read() {
			return blueDwarf;
		}

		@Override
		Name code() {

			return blueDwarf;
		}

		@Override
		Name subCode() {

			return blueDwarf;
		}
	},
	LTBL_DWARF("LTBL_DWARF") {
		Name read() {
			return ltblDwarf;
		}

		@Override
		Name code() {

			return ltblDwarf;
		}

		@Override
		Name subCode() {

			return ltblDwarf;
		}
	},
	WHIT_DWARF("WHIT_DWARF") {
		Name read() {
			return whitDwarf;
		}

		@Override
		Name code() {

			return whitDwarf;
		}

		@Override
		Name subCode() {

			return whitDwarf;
		}
	},
	PYEL_DWARF("PYEL_DWARF") {
		Name read() {
			return pyrlDwarf;
		}

		@Override
		Name code() {

			return pyrlDwarf;
		}

		@Override
		Name subCode() {

			return pyrlDwarf;
		}
	},
	YELO_DWARF("YELO_DWARF") {
		Name read() {
			return yeloDwarf;
		}

		@Override
		Name code() {

			return yeloDwarf;
		}

		@Override
		Name subCode() {

			return yeloDwarf;
		}
	},
	ORNG_DWARF("ORNG_DWARF") {
		Name read() {
			return orngDwarf;
		}

		@Override
		Name code() {

			return orngDwarf;
		}

		@Override
		Name subCode() {

			return orngDwarf;
		}
	},
	RED__DWARF("RED__DWARF") {
		Name read() {
			return redDwarf;
		}

		@Override
		Name code() {

			return redDwarf;
		}

		@Override
		Name subCode() {

			return redDwarf;
		}
	},
	PURPLE_RED("PURPLE_RED") {
		Name read() {
			return purpleRed;
		}

		@Override
		Name code() {

			return purpleRed;
		}

		@Override
		Name subCode() {

			return purpleRed;
		}
	},
	BROWN_SUBS("BROWN_SUBS") {
		Name read() {
			return brownSubS;
		}

		@Override
		Name code() {

			return brownSubS;
		}

		@Override
		Name subCode() {

			return brownSubS;
		}
	},
	DRKBRN_SDW("DRKBRN_SDW") {
		Name read() {
			return drkBrnSDW;
		}

		@Override
		Name code() {

			return drkBrnSDW;
		}

		@Override
		Name subCode() {

			return drkBrnSDW;
		}
	};

	protected static Name blueSGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(null, LTBL_SG_II);

		public String read() {
			return "Blue Super Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sg2o" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name ltblSGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(BLUE_SG_II, WHIT_SG_II);

		public String read() {
			return "Light Blue Super Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sg2b" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name whitSGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(LTBL_SG_II, PYEL_SG_II);

		public String read() {
			return "White Super Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sg2a" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name pyrlSGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(WHIT_SG_II, YELO_SG_II);

		public String read() {
			return "Pale Yellow Super Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sg2f" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name yeloSGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(PYEL_SG_II, ORNG_SG_II);

		public String read() {
			return "Yellow Super Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sg2g" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name orngSGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(YELO_SG_II, RED__SG_II);

		public String read() {
			return "Orange Super Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sg2k" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name redSGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(ORNG_SG_II, BLUE_SG_I);

		public String read() {
			return "Red Super Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sg2m" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name blueSGI = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(RED__SG_II, LTBL_SG_I);

		public String read() {
			return "Blue Super Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sg1o" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name ltblSGI = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(BLUE_SG_I, WHIT_SG_I);

		public String read() {
			return "Light Blue Super Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sg1b" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name whitSGI = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(LTBL_SG_I, PYEL_SG_I);

		public String read() {
			return "White Super Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sg1a" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name pyrlSGI = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(WHIT_SG_I, YELO_SG_I);

		public String read() {
			return "Pale Yellow Super Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sg1f" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name yeloSGI = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(PYEL_SG_I, ORNG_SG_I);

		public String read() {
			return "Yellow Super Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sg1g" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name orngSGI = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(YELO_SG_I, RED__SG_I);

		public String read() {
			return "Orange Super Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sg1k" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name redSGI = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(ORNG_SG_I, BLUE_GI_II);

		public String read() {
			return "Red Super Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sg1m" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name blueGIII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(ORNG_SG_I, LTBL_GI_II);

		public String read() {
			return "Blue Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sg2o" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name ltblGIII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(BLUE_GI_II, WHIT_GI_II);

		public String read() {
			return "Light Blue  Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sg2b" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name whitGIII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(LTBL_GI_II, PYEL_GI_II);

		public String read() {
			return "White Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sg2a" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name pyrlGIII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(WHIT_GI_II, YELO_GI_II);

		public String read() {
			return "Pale Yellow Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sg2f" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name yeloGIII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(PYEL_GI_II, ORNG_GI_II);

		public String read() {
			return "Yellow Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sg2g" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name orngGIII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(YELO_GI_II, RED__GI_II);

		public String read() {
			return "Orange Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sg2k" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name redGIII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(ORNG_GI_II, BLUE_GI_I);

		public String read() {
			return "Red Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sg2m" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name blueGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(RED__GI_II, LTBL_GI_I);

		public String read() {
			return "Blue Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "g1o" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name ltblGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(BLUE_GI_II, WHIT_GI_I);

		public String read() {
			return "Light Blue  Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "g1b" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name whitGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(LTBL_GI_II, PYEL_GI_I);

		public String read() {
			return "White Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "g1a" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name pyrlGII = new Name() {
		private short subCode = -1;

		public String read() {
			return "Pale Yellow Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "g1f" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name yeloGII = new Name() {
		private short subCode = -1;

		public String read() {
			return "Yellow Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "g1g" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name orngGII = new Name() {
		private short subCode = -1;

		public String read() {
			return "Orange Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "g1k" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name redGII = new Name() {
		private short subCode = -1;

		public String read() {
			return "Red Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "g1m" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name blueSubGI = new Name() {
		private short subCode = -1;

		public String read() {
			return "Blue Sub Giant";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sbgo" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name ltblSubGI = new Name() {
		private short subCode = -1;

		public String read() {
			return "Light Blue Sub Giant";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sbgb" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name whitSubGI = new Name() {
		private short subCode = -1;

		public String read() {
			return "White Sub Giant";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sbga" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name pyrlSubGI = new Name() {
		private short subCode = -1;

		public String read() {
			return "Pale Yellow SubGiant";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sbgf" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name yeloSubGI = new Name() {
		private short subCode = -1;

		public String read() {
			return "Yellow Sub Giant";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sbgg" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name orngSubGI = new Name() {
		private short subCode = -1;

		public String read() {
			return "Orange Sub Giant";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sbgk" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name redSubGI = new Name() {
		private short subCode = -1;

		public String read() {
			return "Red Sub Giant";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sbgm" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name blueMainS = new Name() {
		private short subCode = -1;

		public String read() {
			return "Blue Main Sequence";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "o" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name ltblMainS = new Name() {
		private short subCode = -1;

		public String read() {
			return "Light Blue Main Sequence";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "b" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name whitMainS = new Name() {
		private short subCode = -1;

		public String read() {
			return "White Main Sequence";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "a" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name pyrlMainS = new Name() {
		private short subCode = -1;

		public String read() {
			return "Pale Yellow Main Sequence";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "f" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name yeloMainS = new Name() {
		private short subCode = -1;

		public String read() {
			return "Yellow Main Sequence";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "g" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name orngMainS = new Name() {
		private short subCode = -1;

		public String read() {
			return "Orange Main Sequence";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "k" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name redMainS = new Name() {
		private short subCode = -1;

		public String read() {
			return "Red Main Sequence";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "m" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name blueSubDW = new Name() {
		private short subCode = -1;

		public String read() {
			return "Blue Sub Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sdo" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name ltblSubDW = new Name() {
		private short subCode = -1;

		public String read() {
			return "Light Blue Sub Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sdb" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name whitSubDW = new Name() {
		private short subCode = -1;

		public String read() {
			return "White Sub Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sda" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name pyrlSubDW = new Name() {
		private short subCode = -1;

		public String read() {
			return "Pale Yellow Sub Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sdf" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name yeloSubDW = new Name() {
		private short subCode = -1;

		public String read() {
			return "Yellow Sub Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sdg" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name orngSubDW = new Name() {
		private short subCode = -1;

		public String read() {
			return "Orange Sub Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sdk" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name redSubDW = new Name() {
		private short subCode = -1;

		public String read() {
			return "Red Sub Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "sdm" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name blueDwarf = new Name() {
		private short subCode = -1;

		public String read() {
			return "Blue Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "do" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name ltblDwarf = new Name() {
		private short subCode = -1;

		public String read() {
			return "Light Blue Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "db" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name whitDwarf = new Name() {
		private short subCode = -1;

		public String read() {
			return "White Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "da" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name pyrlDwarf = new Name() {
		private short subCode = -1;

		public String read() {
			return "Pale Yellow Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "df" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name yeloDwarf = new Name() {
		private short subCode = -1;

		public String read() {
			return "Yellow Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "dg" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name orngDwarf = new Name() {
		private short subCode = -1;

		public String read() {
			return "Orange Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "dk" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name redDwarf = new Name() {
		private short subCode = -1;

		public String read() {
			return "Red Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "dm" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name purpleRed = new Name() {
		private short subCode = -1;

		public String read() {
			return "Purple Red Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "pmd" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name brownSubS = new Name() {
		private short subCode = -1;

		public String read() {
			return "Brown Sub Star";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "bs" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	protected static Name drkBrnSDW = new Name() {
		private short subCode = -1;

		public String read() {
			return "Dark Brown Sub Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D9();
			return "dbs" + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D9();
			}
			return subCode;
		}
	};
	private String type;

	private StarFactory(String type) {
		this.type = type;
	}

	abstract Name read();

	abstract Name code();

	abstract Name subCode();
}
