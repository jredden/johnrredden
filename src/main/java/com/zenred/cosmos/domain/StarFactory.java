package com.zenred.cosmos.domain;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.zenred.cosmos.service_rules_and_infrastructure.GenAtmosphere;
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
	
	Sequence sequence();
	
	StarTypeFactory starTypeFactory();
}

class Sequence{
	StarTypeFactory sfup;
	StarTypeFactory sfdown;

	public Sequence(StarTypeFactory sfup, StarTypeFactory sfdown) {
		super();
		this.sfup = sfup;
		this.sfdown = sfdown;
	}
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
		@Override
		Sequence sequence(){
			return blueSGII.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sg2o;
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
		@Override
		Sequence sequence(){
			return ltblSGII.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sg2b;
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
		@Override
		Sequence sequence(){
			return whitSGII.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sg2a;
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
		@Override
		Sequence sequence(){
			return pyrlSGII.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sg2f;
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
		@Override
		Sequence sequence(){
			return yeloSGII.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sg2g;
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
		@Override
		Sequence sequence(){
			return orngSGII.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sg2k;
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
		@Override
		Sequence sequence(){
			return redSGII.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sg2m;
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
		@Override
		Sequence sequence(){
			return blueSGI.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sg1o;
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
		@Override
		Sequence sequence(){
			return ltblSGI.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sg1b;
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
		@Override
		Sequence sequence(){
			return whitSGI.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sg1a;
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
		@Override
		Sequence sequence(){
			return pyrlSGI.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sg1f;
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
		@Override
		Sequence sequence(){
			return yeloSGI.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sg1g;
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
		@Override
		Sequence sequence(){
			return orngSGI.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sg1k;
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
		@Override
		Sequence sequence(){
			return redSGI.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sg1m;
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
		@Override
		Sequence sequence(){
			return blueGIII.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.g2o;
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
		@Override
		Sequence sequence(){
			return ltblGIII.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.g2b;
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
		@Override
		Sequence sequence(){
			return whitGIII.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.g2a;
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
		@Override
		Sequence sequence(){
			return pyrlGIII.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.g2f;
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
		@Override
		Sequence sequence(){
			return yeloGIII.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.g2g;
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
		@Override
		Sequence sequence(){
			return orngGIII.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.g2k;
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
		@Override
		Sequence sequence(){
			return redGIII.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.g2m;
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
		@Override
		Sequence sequence(){
			return blueGII.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.g1o;
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
		@Override
		Sequence sequence(){
			return blueGII.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.g1b;
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
		@Override
		Sequence sequence(){
			return whitGII.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.g1a;
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
		@Override
		Sequence sequence(){
			return pyrlGII.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.g1f;
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
		@Override
		Sequence sequence(){
			return yeloGII.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.g1g;
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
		@Override
		Sequence sequence(){
			return orngGII.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.g1k;
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
		@Override
		Sequence sequence(){
			return redGII.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.g1m;
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
		@Override
		Sequence sequence(){
			return blueSubGI.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sbgo;
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
		@Override
		Sequence sequence(){
			return ltblSubGI.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sbgb;
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
		@Override
		Sequence sequence(){
			return whitSubGI.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sbga;
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
		@Override
		Sequence sequence(){
			return pyrlSubGI.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sbgf;
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
		@Override
		Sequence sequence(){
			return yeloSubGI.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sbgg;
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
		@Override
		Sequence sequence(){
			return blueSubGI.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sbgk;
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
		@Override
		Sequence sequence(){
			return redSubGI.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sbgm;
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
		@Override
		Sequence sequence(){
			return blueMainS.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.o;
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
		@Override
		Sequence sequence(){
			return ltblMainS.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.b;
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
		@Override
		Sequence sequence(){
			return whitMainS.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.a;
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
		@Override
		Sequence sequence(){
			return pyrlMainS.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.f;
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
		@Override
		Sequence sequence(){
			return yeloMainS.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.g;
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
		@Override
		Sequence sequence(){
			return orngMainS.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.k;
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
		@Override
		Sequence sequence(){
			return redMainS.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.m;
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
		@Override
		Sequence sequence(){
			return blueSubDW.sequence();
		}
		@Override
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sdo;
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
		@Override
		Sequence sequence(){
			return ltblSubDW.sequence();
		}
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sdb;
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
		@Override
		Sequence sequence(){
			return whitSubDW.sequence();
		}
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sda;
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
		@Override
		Sequence sequence(){
			return pyrlSubDW.sequence();
		}
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sdf;
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
		@Override
		Sequence sequence(){
			return yeloSubDW.sequence();
		}
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sdg;
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
		@Override
		Sequence sequence(){
			return orngSubDW.sequence();
		}
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sdk;
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
		@Override
		Sequence sequence(){
			return redSubDW.sequence();
		}
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.sdm;
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
		@Override
		Sequence sequence(){
			return blueDwarf.sequence();
		}
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.dwo;
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
		@Override
		Sequence sequence(){
			return ltblDwarf.sequence();
		}
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.db;
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
		@Override
		Sequence sequence(){
			return whitDwarf.sequence();
		}
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.da;
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
		@Override
		Sequence sequence(){
			return pyrlDwarf.sequence();
		}
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.df;
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
		@Override
		Sequence sequence(){
			return yeloDwarf.sequence();
		}
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.dg;
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
		@Override
		Sequence sequence(){
			return orngDwarf.sequence();
		}
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.dk;
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
		@Override
		Sequence sequence(){
			return redDwarf.sequence();
		}
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.dm;
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
		@Override
		Sequence sequence(){
			return purpleRed.sequence();
		}
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.pmd;
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
		@Override
		Sequence sequence(){
			return brownSubS.sequence();
		}
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.bs;
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
		@Override
		Sequence sequence(){
			return drkBrnSDW.sequence();
		}
		StarTypeFactory starTypeFactory(){
			return StarTypeFactory.dbs;
		}
	};

	protected static Name blueSGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(null, StarTypeFactory.sg2b);
		
		public String read() {
			return "Blue Super Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sg2o.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}
		
		public Sequence sequence() {

			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			
			return StarTypeFactory.sg2o;
		}
	};
	protected static Name ltblSGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sg2o, StarTypeFactory.sg2a);

		public String read() {
			return "Light Blue Super Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sg2b.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
 
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sg2b;
		}
	};
	protected static Name whitSGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sg2b, StarTypeFactory.sg2f);

		public String read() {
			return "White Super Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sg2a.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
 
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sg2a;
		}
	};
	protected static Name pyrlSGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sg2a, StarTypeFactory.sg2g);

		public String read() {
			return "Pale Yellow Super Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sg2f.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sg2f;
		}
	};
	protected static Name yeloSGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sg2f, StarTypeFactory.sg2k);

		public String read() {
			return "Yellow Super Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sg2g.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sg2g;
		}
	};
	protected static Name orngSGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sg2g, StarTypeFactory.sg2m);

		public String read() {
			return "Orange Super Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sg2k.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sg2k;
		}
	};
	protected static Name redSGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sg2k, StarTypeFactory.sg1o);

		public String read() {
			return "Red Super Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sg2m.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sg2m;
		}
	};
	protected static Name blueSGI = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sg2m, StarTypeFactory.sg1b);

		public String read() {
			return "Blue Super Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sg1o.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sg1o;
		}
	};
	protected static Name ltblSGI = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sg1o, StarTypeFactory.sg1a);

		public String read() {
			return "Light Blue Super Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sg1b.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sg1b;
		}
	};
	protected static Name whitSGI = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sg1b, StarTypeFactory.sg1f);

		public String read() {
			return "White Super Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sg1a.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sg1a;
		}
	};
	protected static Name pyrlSGI = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sg1a, StarTypeFactory.sg1g);

		public String read() {
			return "Pale Yellow Super Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sg1f.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sg1f;
		}
	};
	protected static Name yeloSGI = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sg1f, StarTypeFactory.sg1k);

		public String read() {
			return "Yellow Super Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sg1g.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sg1g;
		}
	};
	protected static Name orngSGI = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sg1g, StarTypeFactory.sg1m);

		public String read() {
			return "Orange Super Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sg1k.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sg1k;
		}
	};
	protected static Name redSGI = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sg1k, StarTypeFactory.g2o);

		public String read() {
			return "Red Super Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sg1m.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sg1m;
		}
	};
	protected static Name blueGIII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sg1m, StarTypeFactory.g2b);

		public String read() {
			return "Blue Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.g2o.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.g2o;
		}
	};
	protected static Name ltblGIII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.g2o, StarTypeFactory.g2a);

		public String read() {
			return "Light Blue  Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.g2b.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.g2b;
		}
	};
	protected static Name whitGIII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.g2b, StarTypeFactory.g2f);

		public String read() {
			return "White Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.g2a.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.g2a;
		}
	};
	protected static Name pyrlGIII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.g2a, StarTypeFactory.g2g);

		public String read() {
			return "Pale Yellow Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.g2f.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.g2f;
		}
	};
	protected static Name yeloGIII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.g2f, StarTypeFactory.g2k);

		public String read() {
			return "Yellow Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.g2g.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.g2g;
		}
	};
	protected static Name orngGIII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.g2g, StarTypeFactory.g2m);

		public String read() {
			return "Orange Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.g2k.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.g2k;
		}
	};
	protected static Name redGIII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.g2k, StarTypeFactory.g1o);

		public String read() {
			return "Red Giant II";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.g2m.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.g2m;
		}
	};
	protected static Name blueGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.g2m, StarTypeFactory.g1b);

		public String read() {
			return "Blue Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.g1o.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.g1o;
		}
	};
	protected static Name ltblGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.g1o, StarTypeFactory.g1a);

		public String read() {
			return "Light Blue  Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.g1b.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.g1b;
		}
	};
	protected static Name whitGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.g1b, StarTypeFactory.g1f);

		public String read() {
			return "White Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.g1a.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.g1a;
		}
	};
	protected static Name pyrlGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.g1a, StarTypeFactory.g1g);

		public String read() {
			return "Pale Yellow Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.g1f.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.g1f;
		}
	};
	protected static Name yeloGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.g1f, StarTypeFactory.g1k);

		public String read() {
			return "Yellow Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.g1g.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.g1g;
		}
	};
	protected static Name orngGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.g1g, StarTypeFactory.g1m);

		public String read() {
			return "Orange Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.g1k.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.g1k;
		}
	};
	protected static Name redGII = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.g1k, StarTypeFactory.sbgo);

		public String read() {
			return "Red Giant I";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.g1m.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.g1m;
		}
	};
	protected static Name blueSubGI = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.g1m, StarTypeFactory.sbgb);

		public String read() {
			return "Blue Sub Giant";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sbgo.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sbgo;
		}
	};
	protected static Name ltblSubGI = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sbgo, StarTypeFactory.sbga);

		public String read() {
			return "Light Blue Sub Giant";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sbgb.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sbgb;
		}
	};
	protected static Name whitSubGI = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sbgb, StarTypeFactory.sbgf);

		public String read() {
			return "White Sub Giant";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sbga.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sbga;
		}
	};
	protected static Name pyrlSubGI = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sbga, StarTypeFactory.sbgg);

		public String read() {
			return "Pale Yellow SubGiant";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sbgf.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sbgf;
		}
	};
	protected static Name yeloSubGI = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sbgf, StarTypeFactory.sbgk);

		public String read() {
			return "Yellow Sub Giant";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sbgg.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sbgg;
		}
	};
	protected static Name orngSubGI = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sbgg, StarTypeFactory.sbgm);

		public String read() {
			return "Orange Sub Giant";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sbgk.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sbgk;
		}
	};
	protected static Name redSubGI = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sbgk, StarTypeFactory.o);

		public String read() {
			return "Red Sub Giant";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sbgm.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sbgm;
		}
	};
	protected static Name blueMainS = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sbgm, StarTypeFactory.a);

		public String read() {
			return "Blue Main Sequence";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.o.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.o;
		}
	};
	protected static Name ltblMainS = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.o, StarTypeFactory.a);

		public String read() {
			return "Light Blue Main Sequence";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.b.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.b;
		}
	};
	protected static Name whitMainS = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.b, StarTypeFactory.f);

		public String read() {
			return "White Main Sequence";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.a.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.a;
		}
	};
	protected static Name pyrlMainS = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.a, StarTypeFactory.g);

		public String read() {
			return "Pale Yellow Main Sequence";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.f.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.f;
		}
	};
	protected static Name yeloMainS = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.f, StarTypeFactory.k);

		public String read() {
			return "Yellow Main Sequence";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.g.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.g;
		}
	};
	protected static Name orngMainS = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.g, StarTypeFactory.m);

		public String read() {
			return "Orange Main Sequence";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.k.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.k;
		}
	};
	protected static Name redMainS = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.k, StarTypeFactory.sdo);

		public String read() {
			return "Red Main Sequence";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.m.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.m;
		}
	};
	protected static Name blueSubDW = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.m, StarTypeFactory.sdb);

		public String read() {
			return "Blue Sub Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sdo.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sdo;
		}
	};
	protected static Name ltblSubDW = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sdo, StarTypeFactory.sda);

		public String read() {
			return "Light Blue Sub Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sdb.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sdb;
		}
	};
	protected static Name whitSubDW = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sdb, StarTypeFactory.sdf);

		public String read() {
			return "White Sub Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sda.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sda;
		}
	};
	protected static Name pyrlSubDW = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sda, StarTypeFactory.sdg);

		public String read() {
			return "Pale Yellow Sub Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sdf.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sdf;
		}
	};
	protected static Name yeloSubDW = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sdf, StarTypeFactory.sdk);

		public String read() {
			return "Yellow Sub Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sdg.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sdg;
		}
	};
	protected static Name orngSubDW = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sdg, StarTypeFactory.sdm);

		public String read() {
			return "Orange Sub Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sdk.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sdk;
		}
	};
	protected static Name redSubDW = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sdk, StarTypeFactory.dwo);

		public String read() {
			return "Red Sub Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.sdm.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.sdm;
		}
	};
	protected static Name blueDwarf = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.sdm, StarTypeFactory.db);

		public String read() {
			return "Blue Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.dwo.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.dwo;
		}
	};
	protected static Name ltblDwarf = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.dwo, StarTypeFactory.da);

		public String read() {
			return "Light Blue Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.db.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.db;
		}
	};
	protected static Name whitDwarf = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.db, StarTypeFactory.df);

		public String read() {
			return "White Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.da.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.da;
		}
	};
	protected static Name pyrlDwarf = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.da, StarTypeFactory.dg);

		public String read() {
			return "Pale Yellow Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.df.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.df;
		}
	};
	protected static Name yeloDwarf = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.df, StarTypeFactory.dk);

		public String read() {
			return "Yellow Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.dg.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.dg;
		}
	};
	protected static Name orngDwarf = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.dg, StarTypeFactory.dm);

		public String read() {
			return "Orange Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.dk.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.dk;
		}
	};
	protected static Name redDwarf = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.dk, StarTypeFactory.pmd);

		public String read() {
			return "Red Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.dm.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.dm;
		}
	};
	protected static Name purpleRed = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.dm, StarTypeFactory.bs);

		public String read() {
			return "Purple Red Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.pmd.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.pmd;
		}
	};
	protected static Name brownSubS = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.pmd, StarTypeFactory.dbs);

		public String read() {
			return "Brown Sub Star";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.bs.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.bs;
		}
	};
	protected static Name drkBrnSDW = new Name() {
		private short subCode = -1;
		private Sequence sequence = new Sequence(StarTypeFactory.bs, null);

		public String read() {
			return "Dark Brown Sub Dwarf";
		}

		public String code() {
			subCode = (short) GenRandomRolls.Instance().get_D10zero();
			return StarTypeFactory.dbs.name() + subCode;
		}

		public short subCode() {
			if (subCode == -1) {
				subCode = (short) GenRandomRolls.Instance().get_D10zero();
			}
			return subCode;
		}

		public Sequence sequence() {
			return sequence;
		}

		public StarTypeFactory starTypeFactory() {
			return StarTypeFactory.dbs;
		}
	};
	private String type;

	private StarFactory(String type) {
		this.type = type;
	}

	abstract Sequence sequence();

	abstract Name read();

	abstract Name code();

	abstract Name subCode();
	
	abstract StarTypeFactory starTypeFactory();
	
	/**
	 * public accessors
	 * @param starFactory
	 * @return Sequence ot Name
	 */
	
	public static Sequence getSequence(StarFactory starFactory){
		return starFactory.sequence();
	}
	
	public static String getRead(StarFactory starFactory){
		return starFactory.read().read();
	}
	
	public static String getCode(StarFactory starFactory){
		return starFactory.code().code();
	}
	
	public static Short getSubCode(StarFactory starFactory){
		return starFactory.subCode().subCode();
	}
	
	public static StarTypeFactory getStarTypeFactory(StarFactory starFactory){
		return starFactory.starTypeFactory();
	}
	private static Logger logger = Logger.getLogger(StarFactory.class);
	private static StarFactory[] starColors = StarFactory.values();
	private static Map<String, StarFactory> normalizedStarColors = new HashMap<String, StarFactory>();
	static{
		for (int idex = 0; idex < starColors.length; idex ++){
			normalizedStarColors.put(starColors[idex].name(), starColors[idex]);
		}
		logger.info("NORMALIZED STAR COLORS:"+normalizedStarColors);
	}
	public static StarFactory accessByString(String starColor){
		return normalizedStarColors.get(starColor);
	}
}
