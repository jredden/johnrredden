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
import java.util.Set;

import com.zenred.cosmos.domain.ClusterFactory;
import com.zenred.cosmos.domain.ClusterRep;
import com.zenred.cosmos.domain.DistanceDetailsIF;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.StarDao;
import com.zenred.cosmos.domain.StarFactory;
import com.zenred.cosmos.domain.StarTypeFactory;
import com.zenred.cosmos.domain.SubClusterFactory;
import com.zenred.util.GenRandomRolls;

class DecoratedStar extends Star{
	protected SubClusterFactory subClusterFactory;

	public DecoratedStar(Star star) {
		super.setAngle_in_radians_s(star.getAngle_in_radians_s());
		super.setClusterToStarId(star.getClusterToStarId());
		super.setDatestamp(star.getDatestamp());
		super.setDistance_clust_virt_centre(star.getDistance_clust_virt_centre());
		super.setLuminosity(star.getLuminosity());
		super.setName(star.getName());
		super.setNo_planets_allowed(star.no_planets_allowed);
		super.setStar_color(star.getStar_color());
		super.setStar_size(star.getStar_size());
		super.setStar_type(star.getStar_type());
		super.setStarId(star.getStarId());
	}

	public SubClusterFactory getSubClusterFactory() {
		return subClusterFactory;
	}

	public void setSubClusterFactory(SubClusterFactory subClusterFactory) {
		this.subClusterFactory = subClusterFactory;
	}

	@Override
	public String toString() {
		return "DecoratedStar [subClusterFactory=" + subClusterFactory
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}

public class GenStar {
	
	static private Logger logger = Logger.getLogger(GenStar.class);
	static private StarDao starDao = new StarDao();

	private static Map<List<Integer>, StarFactory> starProbabilityMap =new HashMap<List<Integer>, StarFactory>();
	private static Object[] intArray;
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
		integers.add(801);
		integers.add(890);
		starProbabilityMap.put(integers, StarFactory.YELO_SUBGI);

		integers = new ArrayList<Integer>();
		integers.add(891);
		integers.add(900);
		starProbabilityMap.put(integers, StarFactory.ORNG_SUBGI);

		integers = new ArrayList<Integer>();
		integers.add(901);
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

		Iterator<List<Integer>> iter = starProbabilityMap.keySet().iterator();
		List<Integer> intList = new ArrayList<Integer>();
		while(iter.hasNext()){
			List<Integer> nextInt = iter.next();
			logger.debug("NEXT:"+nextInt);
			intList.add(nextInt.get(0));
			intList.add(nextInt.get(1));
		}
		intArray = intList.toArray();
		Arrays.sort(intArray);
}
	protected static Integer[] Search(Integer draw){
		int end = GenStar.intArray.length;
		int next0 = end-2;
		int next1 = end-1;
		int first = new Integer(intArray[next0].toString());
		int second = new Integer(intArray[next1].toString());
		while(!(draw >= first && draw <= second)){
			next0 -=2;
			next1 -=2;
			first = new Integer(intArray[next0].toString());
			second = new Integer(intArray[next1].toString());
		}
		Integer [] integers = new Integer[]{new Integer(intArray[next0].toString()), new Integer(intArray[next1].toString())};
		return integers ;
	}
	
	public static final Double twoDegToRadian = Math.toRadians(2.0);
	private static List<SubClusterFactory> closeTogetherList = new ArrayList<SubClusterFactory>();
	private static List<SubClusterFactory> endTogetherList = new ArrayList<SubClusterFactory>();
	static{
		closeTogetherList.add(SubClusterFactory.DOUBLESTAR_BINARY_0);
		endTogetherList.add(SubClusterFactory.DOUBLESTAR_BINARY_1);
		closeTogetherList.add(SubClusterFactory.THREESTAR_TRINARY_0);
		closeTogetherList.add(SubClusterFactory.THREESTAR_TRINARY_1);
		endTogetherList.add(SubClusterFactory.THREESTAR_TRINARY_2);
		closeTogetherList.add(SubClusterFactory.THREESTAR_BINARYPLUSONE_BINARY_0);
		endTogetherList.add(SubClusterFactory.THREESTAR_BINARYPLUSONE_BINARY_1);
		closeTogetherList.add(SubClusterFactory.FOURSTAR_TRINARYPLUSONE_TRINARY_0);
		closeTogetherList.add(SubClusterFactory.FOURSTAR_TRINARYPLUSONE_TRINARY_1);
		endTogetherList.add(SubClusterFactory.FOURSTAR_TRINARYPLUSONE_TRINARY_2);
		closeTogetherList.add(SubClusterFactory.FOURSTAR_2BINARIES_0_BINARY_0);
		closeTogetherList.add(SubClusterFactory.FOURSTAR_2BINARIES_1_BINARY_0);
		endTogetherList.add(SubClusterFactory.FOURSTAR_2BINARIES_0_BINARY_1);
		endTogetherList.add(SubClusterFactory.FOURSTAR_2BINARIES_1_BINARY_1);
	}
	
	/**
	 * 
	 *  the angles for binary and trinary clusters are close together,  
	 *  for example a double star binary versus a double star spread
	 * 
	 * @param clusterFactory
	 * @return list of stars generated for cluster
	 */
	protected static List<DecoratedStar> generateStarsInCluster(
			ClusterFactory clusterFactory, String starName) {
		List<DecoratedStar> stars = new ArrayList<DecoratedStar>();
		Map<SubClusterFactory, List<DistanceDetailsIF>> map = ClusterFactory
				.getStarToDistanceDetails(clusterFactory);
		Set<SubClusterFactory> keys = map.keySet();
		Iterator<SubClusterFactory> iter = keys.iterator();
		Double lastAngleInRadians = null;
		int idex = 0;
		while (iter.hasNext()) {
			SubClusterFactory subClusterFactory = iter.next();
			logger.info("SUBCLUSTER_FACTORY:"+subClusterFactory);
			List<DistanceDetailsIF> detailsIFs = map.get(subClusterFactory);
			for (DistanceDetailsIF distanceDetailsIF : detailsIFs) {
				Double distance = distanceDetailsIF.getDistanceBetweenStars();
				Double angleInRadians = null;
				if (null == lastAngleInRadians) {
					angleInRadians = Math.toRadians(GenRandomRolls.Instance()
							.getD360());
				} else {
					Integer flipACoin = GenRandomRolls.Instance().get_D2();
					double draw = GenRandomRolls.Instance()
							.getDraw(100.0) + 0.05;
					if (1 == flipACoin) {
						angleInRadians = lastAngleInRadians
								+ twoDegToRadian
								+ (twoDegToRadian / draw);
					} else {
						angleInRadians = lastAngleInRadians
								- twoDegToRadian
								+ (twoDegToRadian / draw);
					}
				}
				if (closeTogetherList.contains(subClusterFactory)) {
					lastAngleInRadians = angleInRadians; // so as to keep these
															// stars in a close
															// cluster
				}
				if (endTogetherList.contains(subClusterFactory)) {
					lastAngleInRadians = null; // reset to typical mode
				}

				Star star = GenStar.generateStar(starName + idex++, distance,
						angleInRadians);
				logger.info("STAR:" + star);
				DecoratedStar decoratedStar = new DecoratedStar(star);
				decoratedStar.setSubClusterFactory(subClusterFactory);
				stars.add(decoratedStar);
			}
		}
		return stars;
	}
	
	protected static Star generateStar(String starName, Double distance, Double starAngle){
		for (Object obj: GenStar.intArray){
			logger.debug("SORT:"+new Integer(obj.toString()));
		}
		Integer draw = GenRandomRolls.Instance().getD250000();
		if(draw == 0){
			draw = new Integer(2);
		}
		logger.info("DRAW:"+draw);
		Integer [] result = Search(draw);
		List<Integer> integers = new ArrayList<Integer>();
		integers.add(result[0]);
		integers.add(result[1]);
		StarFactory starFactory = starProbabilityMap.get(integers);
		logger.info("STAR FACTORY:"+starFactory);
	
		Star star = new Star(null, new Integer(0), starName, distance,
				StarTypeFactory.genLuminsoity(StarFactory.getSubCode(starFactory), StarFactory.getStarTypeFactory(starFactory),
						starFactory, StarFactory.getSequence(starFactory)),
				null, starAngle == null ? new Double(Math.toRadians(GenRandomRolls.Instance()
						.getAngle())): starAngle, StarFactory.getRead(starFactory),
				StarFactory.getCode(starFactory), StarTypeFactory.genMass(
						StarFactory.getSubCode(starFactory), StarFactory.getStarTypeFactory(starFactory), starFactory,
						StarFactory.getSequence(starFactory)), null);
		return star;
	}
	
	public static List<Star> persistStars(ClusterFactory clusterFactory,
			ClusterRep clusterRep) {
		List<DecoratedStar> stars = generateStarsInCluster(clusterFactory,
				"Star." + clusterRep.getClusterName());
		List<Star> plainStars = new ArrayList<Star>();
		for (DecoratedStar star : stars) {
			plainStars.add(starDao.addStar(star, clusterRep, star.getSubClusterFactory().name()));
		}
		return plainStars;
	}
}
