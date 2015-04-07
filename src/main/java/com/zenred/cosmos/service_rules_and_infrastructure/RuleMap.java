package com.zenred.cosmos.service_rules_and_infrastructure;

import java.util.HashMap;
import java.util.Map;

import com.zenred.cosmos.domain.StarFactory;

public class RuleMap {
	
	private static String BLUE_SG_II_drl ="/BLUE_SG_II.drl";
	private static String LTBL_SG_II_drl ="/LTBL_SG_II.drl";
	private static String WHIT_SG_II_drl ="/WHIT_SG_II.drl";
	private static String PYEL_SG_II_drl ="/PYEL_SG_II.drl";
	private static String YELO_SG_II_drl ="/YELO_SG_II.drl";
	private static String ORNG_SG_II_drl ="/ORNG_SG_II.drl";
	private static String RED__SG_II_drl ="/RED__SG_II.drl";
	private static String BLUE_SG_I_drl ="/BLUE_SG_I.drl";
	private static String LTBL_SG_I_drl ="/LTBL_SG_I.drl";
	private static String WHIT_SG_I_drl ="/WHIT_SG_I.drl";
	private static String PYEL_SG_I_drl ="/PYEL_SG_I.drl";
	private static String YELO_SG_I_drl ="/YELO_SG_I.drl";
	private static String ORNG_SG_I_drl ="/ORNG_SG_I.drl";
	private static String RED__SG_I_drl ="/RED__SG_I.drl";
	private static String BLUE_GI_II_drl ="/BLUE_GI_II.drl";
	private static String LTBL_GI_II_drl ="/LTBL_GI_II.drl";
	private static String WHIT_GI_II_drl ="/WHIT_GI_II.drl";
	private static String PYEL_GI_II_drl ="/PYEL_GI_II.drl";
	private static String YELO_GI_II_drl ="/YELO_GI_II.drl";
	private static String ORNG_GI_II_drl ="/ORNG_GI_II.drl";
	private static String RED__GI_II_drl ="/RED__GI_II.drl";
	private static String BLUE_GI_I_drl ="/BLUE_GI_I.drl";
	private static String LTBL_GI_I_drl ="/LTBL_GI_I.drl";
	private static String WHIT_GI_I_drl ="/WHIT_GI_I.drl";
	private static String PYEL_GI_I_drl ="/PYEL_GI_I.drl";
	private static String YELO_GI_I_drl ="/YELO_GI_I.drl";
	private static String ORNG_GI_I_drl ="/ORNG_GI_I.drl";
	private static String RED__GI_I_drl ="/RED__GI_I.drl";
	private static String BLUE_SUBGI_drl ="/BLUE_SUBGI.drl";
	private static String LTBL_SUBGI_drl ="/LTBL_SUBGI.drl";
	private static String WHIT_SUBGI_drl ="/WHIT_SUBGI.drl";
	private static String PYEL_SUBGI_drl ="/PYEL_SUBGI.drl";
	private static String YELO_SUBGI_drl ="/YELO_SUBGI.drl";
	private static String ORNG_SUBGI_drl ="/ORNG_SUBGI.drl";
	private static String RED__SUBGI_drl ="/RED__SUBGI.drl";
	private static String BLUE_MAINS_drl ="/BLUE_MAINS.drl";
	private static String LTBL_MAINS_drl ="/LTBL_MAINS.drl";
	private static String WHIT_MAINS_drl ="/WHIT_MAINS.drl";
	private static String PYEL_MAINS_drl ="/PYEL_MAINS.drl";
	private static String YELO_MAINS_drl ="/YELO_MAINS.drl";
	private static String ORNG_MAINS_drl ="/ORNG_MAINS.drl";
	private static String RED__MAINS_drl ="/RED__MAINS.drl";
	private static String BLUE_SUBDW_drl ="/BLUE_SUBDW.drl";
	private static String LTBL_SUBDW_drl ="/LTBL_SUBDW.drl";
	private static String WHIT_SUBDW_drl ="/WHIT_SUBDW.drl";
	private static String PYEL_SUBDW_drl ="/PYEL_SUBDW.drl";
	private static String YELO_SUBDW_drl ="/YELO_SUBDW.drl";
	private static String ORNG_SUBDW_drl ="/ORNG_SUBDW.drl";
	private static String RED__SUBDW_drl ="/RED__SUBDW.drl";
	private static String BLUE_DWARF_drl ="/BLUE_DWARF.drl";
	private static String LTBL_DWARF_drl ="/LTBL_DWARF.drl";
	private static String WHIT_DWARF_drl ="/WHIT_DWARF.drl";
	private static String PYEL_DWARF_drl ="/PYEL_DWARF.drl";
	private static String YELO_DWARF_drl ="/YELO_DWARF.drl";
	private static String ORNG_DWARF_drl ="/ORNG_DWARF.drl";
	private static String RED__DWARF_drl ="/RED__DWARF.drl";
	private static String PURPLE_RED_drl ="/PURPLE_RED.drl";
	private static String BROWN_SUBS_drl ="/BROWN_SUBS.drl";
	private static String DRKBRN_SDW_drl ="/DRKBRN_SDW.drl";
	
	// drools files for each type and their rules

	private static Map<StarFactory, String> drlFileMap = new HashMap<StarFactory, String>();
	static{
		drlFileMap.put(StarFactory.YELO_MAINS, YELO_MAINS_drl);
		drlFileMap.put(StarFactory.BLUE_SG_II, BLUE_SG_II_drl);
		drlFileMap.put(StarFactory.LTBL_SG_II, LTBL_SG_II_drl);
		drlFileMap.put(StarFactory.WHIT_SG_II, WHIT_SG_II_drl);
		drlFileMap.put(StarFactory.PYEL_SG_II, PYEL_SG_II_drl);
		drlFileMap.put(StarFactory.YELO_SG_II, YELO_SG_II_drl);
		drlFileMap.put(StarFactory.ORNG_SG_II, ORNG_SG_II_drl);
		drlFileMap.put(StarFactory.RED__SG_II, RED__SG_II_drl);
		drlFileMap.put(StarFactory.BLUE_SG_I, BLUE_SG_I_drl);
		drlFileMap.put(StarFactory.LTBL_SG_I, LTBL_SG_I_drl);
		drlFileMap.put(StarFactory.WHIT_SG_I, WHIT_SG_I_drl);
		drlFileMap.put(StarFactory.PYEL_SG_I, PYEL_SG_I_drl);
		drlFileMap.put(StarFactory.YELO_SG_I, YELO_SG_I_drl);
		drlFileMap.put(StarFactory.ORNG_SG_I, ORNG_SG_I_drl);
		drlFileMap.put(StarFactory.RED__SG_I, RED__SG_I_drl);
		drlFileMap.put(StarFactory.BLUE_GI_II, BLUE_GI_II_drl);
		drlFileMap.put(StarFactory.LTBL_GI_II, LTBL_GI_II_drl);
		drlFileMap.put(StarFactory.WHIT_GI_II, WHIT_GI_II_drl);
		drlFileMap.put(StarFactory.PYEL_GI_II, PYEL_GI_II_drl);
		drlFileMap.put(StarFactory.YELO_GI_II, YELO_GI_II_drl);
		drlFileMap.put(StarFactory.ORNG_GI_II, ORNG_GI_II_drl);
		drlFileMap.put(StarFactory.RED__GI_II, RED__GI_II_drl);
		drlFileMap.put(StarFactory.BLUE_GI_I, BLUE_GI_I_drl);
		drlFileMap.put(StarFactory.LTBL_GI_I, LTBL_GI_I_drl);
		drlFileMap.put(StarFactory.WHIT_GI_I, WHIT_GI_I_drl);
		drlFileMap.put(StarFactory.PYEL_GI_I, PYEL_GI_I_drl);
		drlFileMap.put(StarFactory.YELO_GI_I, YELO_GI_I_drl);
		drlFileMap.put(StarFactory.ORNG_GI_I, ORNG_GI_I_drl);
		drlFileMap.put(StarFactory.RED__GI_I, RED__GI_I_drl);
		drlFileMap.put(StarFactory.BLUE_SUBGI, BLUE_SUBGI_drl);
		drlFileMap.put(StarFactory.LTBL_SUBGI, LTBL_SUBGI_drl);
		drlFileMap.put(StarFactory.WHIT_SUBGI, WHIT_SUBGI_drl);
		drlFileMap.put(StarFactory.PYEL_SUBGI, PYEL_SUBGI_drl);
		drlFileMap.put(StarFactory.YELO_SUBGI, YELO_SUBGI_drl);
		drlFileMap.put(StarFactory.ORNG_SUBGI, ORNG_SUBGI_drl);
		drlFileMap.put(StarFactory.RED__SUBGI, RED__SUBGI_drl);
		drlFileMap.put(StarFactory.BLUE_MAINS, BLUE_MAINS_drl);
		drlFileMap.put(StarFactory.LTBL_MAINS, LTBL_MAINS_drl);
		drlFileMap.put(StarFactory.WHIT_MAINS, WHIT_MAINS_drl);
		drlFileMap.put(StarFactory.PYEL_MAINS, PYEL_MAINS_drl);
		drlFileMap.put(StarFactory.ORNG_MAINS, ORNG_MAINS_drl);
		drlFileMap.put(StarFactory.RED__MAINS, RED__MAINS_drl);
		drlFileMap.put(StarFactory.BLUE_SUBDW, BLUE_SUBDW_drl);
		drlFileMap.put(StarFactory.LTBL_SUBDW, LTBL_SUBDW_drl);
		drlFileMap.put(StarFactory.WHIT_SUBDW, WHIT_SUBDW_drl);
		drlFileMap.put(StarFactory.PYEL_SUBDW, PYEL_SUBDW_drl);
		drlFileMap.put(StarFactory.YELO_SUBDW, YELO_SUBDW_drl);
		drlFileMap.put(StarFactory.ORNG_SUBDW, ORNG_SUBDW_drl);
		drlFileMap.put(StarFactory.RED__SUBDW, RED__SUBDW_drl);
		drlFileMap.put(StarFactory.BLUE_DWARF, BLUE_DWARF_drl);
		drlFileMap.put(StarFactory.LTBL_DWARF, LTBL_DWARF_drl);
		drlFileMap.put(StarFactory.WHIT_DWARF, WHIT_DWARF_drl);
		drlFileMap.put(StarFactory.PYEL_DWARF, PYEL_DWARF_drl);
		drlFileMap.put(StarFactory.YELO_DWARF, YELO_DWARF_drl);
		drlFileMap.put(StarFactory.ORNG_DWARF, ORNG_DWARF_drl);
		drlFileMap.put(StarFactory.RED__DWARF, RED__DWARF_drl);
		drlFileMap.put(StarFactory.PURPLE_RED, PURPLE_RED_drl);
		drlFileMap.put(StarFactory.BROWN_SUBS, BROWN_SUBS_drl);
		drlFileMap.put(StarFactory.DRKBRN_SDW, DRKBRN_SDW_drl);

	}

	public static String getDroolsFileURI(StarFactory starSignature){
		return drlFileMap.get(starSignature);
	}
}
