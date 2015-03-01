package com.zenred.cosmos.service_rules_and_infrastructure;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.zenred.cosmos.domain.StarFactory;

public class GenStar {
	
	static private Logger logger = Logger.getLogger(GenStar.class);

	private static Map<List<Integer>, StarFactory> starProbabilityMap =new HashMap<List<Integer>, StarFactory>();
	static{
		List<Integer> integers = new ArrayList<Integer>();
		integers.add(1);
		integers.add(5);
		starProbabilityMap.put(integers, StarFactory.BLUE_SG_II);
		
		integers = new ArrayList<Integer>();
		integers.add(6);
		integers.add(10);
		starProbabilityMap.put(integers, StarFactory.LTBL_SG_II);
		
		integers = new ArrayList<Integer>();
		integers.add(11);
		integers.add(15);
		starProbabilityMap.put(integers, StarFactory.WHIT_SG_II);
		
		integers = new ArrayList<Integer>();
		integers.add(16);
		integers.add(20);
		starProbabilityMap.put(integers, StarFactory.PYEL_SG_II);

		integers = new ArrayList<Integer>();
		integers.add(21);
		integers.add(25);
		starProbabilityMap.put(integers, StarFactory.YELO_SG_II);
		
		integers = new ArrayList<Integer>();
		integers.add(26);
		integers.add(30);
		starProbabilityMap.put(integers, StarFactory.ORNG_SG_II);

		integers = new ArrayList<Integer>();
		integers.add(31);
		integers.add(40);
		starProbabilityMap.put(integers, StarFactory.RED__SG_II);
		
		integers = new ArrayList<Integer>();
		integers.add(41);
		integers.add(50);
		starProbabilityMap.put(integers, StarFactory.BLUE_SG_I);
		
		integers = new ArrayList<Integer>();
		integers.add(51);
		integers.add(60);
		starProbabilityMap.put(integers, StarFactory.LTBL_SG_I);
		
		integers = new ArrayList<Integer>();
		integers.add(61);
		integers.add(70);
		starProbabilityMap.put(integers, StarFactory.WHIT_SG_I);
		
		integers = new ArrayList<Integer>();
		integers.add(71);
		integers.add(80);
		starProbabilityMap.put(integers, StarFactory.PYEL_SG_I);

		integers = new ArrayList<Integer>();
		integers.add(81);
		integers.add(90);
		starProbabilityMap.put(integers, StarFactory.YELO_SG_I);
		
		integers = new ArrayList<Integer>();
		integers.add(91);
		integers.add(110);
		starProbabilityMap.put(integers, StarFactory.ORNG_SG_I);

		integers = new ArrayList<Integer>();
		integers.add(111);
		integers.add(140);
		starProbabilityMap.put(integers, StarFactory.RED__SG_I);
		
		integers = new ArrayList<Integer>();
		integers.add(141);
		integers.add(170);
		starProbabilityMap.put(integers, StarFactory.BLUE_GI_II);

		integers = new ArrayList<Integer>();
		integers.add(171);
		integers.add(200);
		starProbabilityMap.put(integers, StarFactory.LTBL_GI_II);

		integers = new ArrayList<Integer>();
		integers.add(201);
		integers.add(230);
		starProbabilityMap.put(integers, StarFactory.WHIT_GI_II);

		integers = new ArrayList<Integer>();
		integers.add(231);
		integers.add(260);
		starProbabilityMap.put(integers, StarFactory.PYEL_GI_II);
		
		integers = new ArrayList<Integer>();
		integers.add(261);
		integers.add(280);
		starProbabilityMap.put(integers, StarFactory.YELO_GI_II);

		integers = new ArrayList<Integer>();
		integers.add(281);
		integers.add(300);
		starProbabilityMap.put(integers, StarFactory.ORNG_GI_II);

		integers = new ArrayList<Integer>();
		integers.add(301);
		integers.add(340);
		starProbabilityMap.put(integers, StarFactory.RED__GI_II);

		integers = new ArrayList<Integer>();
		integers.add(341);
		integers.add(380);
		starProbabilityMap.put(integers, StarFactory.BLUE_GI_I);

		integers = new ArrayList<Integer>();
		integers.add(381);
		integers.add(420);
		starProbabilityMap.put(integers, StarFactory.LTBL_GI_I);

		integers = new ArrayList<Integer>();
		integers.add(421);
		integers.add(460);
		starProbabilityMap.put(integers, StarFactory.WHIT_GI_I);

		integers = new ArrayList<Integer>();
		integers.add(461);
		integers.add(500);
		starProbabilityMap.put(integers, StarFactory.PYEL_GI_I);
		
		integers = new ArrayList<Integer>();
		integers.add(501);
		integers.add(540);
		starProbabilityMap.put(integers, StarFactory.YELO_GI_I);

		integers = new ArrayList<Integer>();
		integers.add(541);
		integers.add(570);
		starProbabilityMap.put(integers, StarFactory.ORNG_GI_I);

		integers = new ArrayList<Integer>();
		integers.add(571);
		integers.add(600);
		starProbabilityMap.put(integers, StarFactory.RED__GI_I);

		integers = new ArrayList<Integer>();
		integers.add(601);
		integers.add(650);
		starProbabilityMap.put(integers, StarFactory.BLUE_SUBGI);

		integers = new ArrayList<Integer>();
		integers.add(651);
		integers.add(700);
		starProbabilityMap.put(integers, StarFactory.LTBL_SUBGI);

		integers = new ArrayList<Integer>();
		integers.add(701);
		integers.add(750);
		starProbabilityMap.put(integers, StarFactory.WHIT_SUBGI);
		
		integers = new ArrayList<Integer>();
		integers.add(751);
		integers.add(800);
		starProbabilityMap.put(integers, StarFactory.PYEL_SUBGI);

		integers = new ArrayList<Integer>();
		integers.add(751);
		integers.add(790);
		starProbabilityMap.put(integers, StarFactory.YELO_SUBGI);

		integers = new ArrayList<Integer>();
		integers.add(791);
		integers.add(850);
		starProbabilityMap.put(integers, StarFactory.ORNG_SUBGI);

		integers = new ArrayList<Integer>();
		integers.add(851);
		integers.add(920);
		starProbabilityMap.put(integers, StarFactory.RED__SUBGI);

		integers = new ArrayList<Integer>();
		integers.add(921);
		integers.add(1020);
		starProbabilityMap.put(integers, StarFactory.BLUE_MAINS);

		integers = new ArrayList<Integer>();
		integers.add(1021);
		integers.add(2000);
		starProbabilityMap.put(integers, StarFactory.LTBL_MAINS);

		integers = new ArrayList<Integer>();
		integers.add(2001);
		integers.add(3000);
		starProbabilityMap.put(integers, StarFactory.WHIT_MAINS);
		
		integers = new ArrayList<Integer>();
		integers.add(3001);
		integers.add(5000);
		starProbabilityMap.put(integers, StarFactory.PYEL_MAINS);

		integers = new ArrayList<Integer>();
		integers.add(5001);
		integers.add(8000);
		starProbabilityMap.put(integers, StarFactory.YELO_MAINS);

		integers = new ArrayList<Integer>();
		integers.add(8001);
		integers.add(10000);
		starProbabilityMap.put(integers, StarFactory.ORNG_MAINS);

		integers = new ArrayList<Integer>();
		integers.add(10001);
		integers.add(30000);
		starProbabilityMap.put(integers, StarFactory.RED__MAINS);

		integers = new ArrayList<Integer>();
		integers.add(30001);
		integers.add(40000);
		starProbabilityMap.put(integers, StarFactory.BLUE_SUBDW);

		integers = new ArrayList<Integer>();
		integers.add(40001);
		integers.add(50000);
		starProbabilityMap.put(integers, StarFactory.LTBL_SUBDW);

		integers = new ArrayList<Integer>();
		integers.add(50001);
		integers.add(60000);
		starProbabilityMap.put(integers, StarFactory.WHIT_SUBDW);
		
		integers = new ArrayList<Integer>();
		integers.add(60001);
		integers.add(65000);
		starProbabilityMap.put(integers, StarFactory.PYEL_SUBDW);

		integers = new ArrayList<Integer>();
		integers.add(65001);
		integers.add(70000);
		starProbabilityMap.put(integers, StarFactory.YELO_SUBDW);

		integers = new ArrayList<Integer>();
		integers.add(70001);
		integers.add(80000);
		starProbabilityMap.put(integers, StarFactory.ORNG_SUBDW);

		integers = new ArrayList<Integer>();
		integers.add(80001);
		integers.add(90000);
		starProbabilityMap.put(integers, StarFactory.RED__SUBDW);

		integers = new ArrayList<Integer>();
		integers.add(90001);
		integers.add(95000);
		starProbabilityMap.put(integers, StarFactory.BLUE_DWARF);

		integers = new ArrayList<Integer>();
		integers.add(95001);
		integers.add(100000);
		starProbabilityMap.put(integers, StarFactory.LTBL_DWARF);

		integers = new ArrayList<Integer>();
		integers.add(100001);
		integers.add(150000);
		starProbabilityMap.put(integers, StarFactory.WHIT_DWARF);
		
		integers = new ArrayList<Integer>();
		integers.add(150001);
		integers.add(155000);
		starProbabilityMap.put(integers, StarFactory.PYEL_DWARF);

		integers = new ArrayList<Integer>();
		integers.add(155001);
		integers.add(200000);
		starProbabilityMap.put(integers, StarFactory.YELO_DWARF);

		integers = new ArrayList<Integer>();
		integers.add(200001);
		integers.add(210000);
		starProbabilityMap.put(integers, StarFactory.ORNG_DWARF);

		integers = new ArrayList<Integer>();
		integers.add(210001);
		integers.add(220000);
		starProbabilityMap.put(integers, StarFactory.RED__DWARF);

		integers = new ArrayList<Integer>();
		integers.add(220001);
		integers.add(225000);
		starProbabilityMap.put(integers, StarFactory.PURPLE_RED);
		
		integers = new ArrayList<Integer>();
		integers.add(225001);
		integers.add(250000);
		starProbabilityMap.put(integers, StarFactory.BROWN_SUBS);

		integers = new ArrayList<Integer>();
		integers.add(225001);
		integers.add(250000);
		starProbabilityMap.put(integers, StarFactory.DRKBRN_SDW);

}
	
	protected static void generateStar(){
		List<Integer> integersKey = new ArrayList<Integer>();
//		integersKey.add(11);
//		integersKey.add(15);
//		logger.info("KEY:"+starProbabilityMap.get(integersKey));
//		logger.info("KEYS:"+starProbabilityMap.keySet());
		Iterator<List<Integer>> iter = starProbabilityMap.keySet().iterator();
		List<Integer> intList = new ArrayList<Integer>();
		while(iter.hasNext()){
			List<Integer> nextInt = iter.next();
			logger.debug("NEXT:"+nextInt);
			intList.add(nextInt.get(0));
			intList.add(nextInt.get(1));
		}
		Object[] intArray = intList.toArray();
		Arrays.sort(intArray);
//		List sortedList = new ArrayList(starProbabilityMap.keySet());
//		Collections.sort(sortedList);
		for (Object obj: intArray){
			logger.info("SORT:"+new Integer(obj.toString()));
		}
		
	}
}
