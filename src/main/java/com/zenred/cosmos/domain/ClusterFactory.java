package com.zenred.cosmos.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.zenred.util.GenRandomRolls;

/**
 * 'SINGLESTAR' , 'DOUBLESTAR_BINARY' , 'DOUBLESTAR_SPREAD' ,
 * 'THREESTAR_TRINARY' , 'THREESTAR_BINARYPLUSONE' , 'THREESTAR_SPREAD' ,
 * 'FOURSTAR_TRINARYPLUSONE' , 'FOURSTAR_TWOBINARIES' , 'FOURSTAR_SPREAD' ,
 * 'FIVESTAR_FOURSTARSPREADPLUSONE' , 'FIVESTAR_SPREAD' , 'CLUSTER_N'
 * 
 * @author jredden
 *
 */


interface Operation {
	ClusterRep process(ClusterRep clusterRep);

}

interface NormalizedName{
	String normalizedName();
}

public enum ClusterFactory {

	SINGLESTAR("SINGLESTAR") {
		Operation get() {
			return singleStar;
		}
		
		NormalizedName getName(){
			return singleStarName;
		}
	},
	DOUBLESTAR_BINARY("DOUBLESTAR_BINARY") {
		Operation get() {
			return doubleStarBinary;
		}

		NormalizedName getName() {
			return doubleStarBinaryName;
		}
	},
	DOUBLESTAR_SPREAD("DOUBLESTAR_SPREAD") {
		Operation get() {
			return doubleStarSpread;
		}

		NormalizedName getName() {
			return doubleStarSpreadName;
		}
	},
	THREESTAR_TRINARY("THREESTAR_TRINARY") {
		Operation get() {
			return threeStarTrinary;
		}

		NormalizedName getName() {
			return threeStarTrinaryName;
		}
	},
	THREESTAR_BINARYPLUSONE("THREESTAR_BINARYPLUSONE") {
		Operation get() {
			return ClusterFactory.threeStarBinaryPlusOne;
		}

		NormalizedName getName() {
			return threeStarBinaryPlusOneName;
		}
	},
	THREESTAR_SPREAD("THREESTAR_SPREAD") {
		Operation get() {
			return threeStarSpread;
		}

		NormalizedName getName() {
			return ClusterFactory.threeStarSpreadName;
		}
	},
	FOURSTAR_TRINARYPLUSONE("FOURSTAR_TRINARYPLUSONE") {
		Operation get() {
			return ClusterFactory.fourStarTrinaryPlusOne;
		}

		@Override
		NormalizedName getName() {
			return fourStarTrinaryPlusOneName;
		}
	},
	FOURSTAR_TWOBINARIES("FOURSTAR_TWOBINARIES") {
		Operation get() {
			return ClusterFactory.fourStarTwoBinaries;
		}

		NormalizedName getName() {
			return fourStarTwoBinariesName;
		}
	},
	FOURSTAR_SPREAD("FOURSTAR_SPREAD") {
		Operation get() {
			return ClusterFactory.fourStarSpread;
		}

		NormalizedName getName() {
			return fourStarSpreadName;
		}
	},
	FIVESTAR_FOURSTARSPREADPLUSONE("FIVESTAR_FOURSTARSPREADPLUSONE") {
		Operation get() {
			return ClusterFactory.fiveStarFourStarSpreadPlusOne;
		}

		NormalizedName getName() {
			return fiveStarFourStarSpreadPlusOneName;
		}
	},
	FIVESTAR_SPREAD("FIVESTAR_SPREAD") {
		Operation get() {
			return ClusterFactory.fiveStarSpread;
		}

		NormalizedName getName() {
			return fiveStarSpreadName;
		}
	},
	CLUSTER_N("CLUSTER_N") {
		Operation get() {
			return ClusterFactory.clusterN;
		}

		NormalizedName getName() {
			return clusterNname;
		}
	},
	;

	static private Logger logger = Logger.getLogger(ClusterFactory.class);
	private String type;
	private static Map<String, ClusterFactory> operationMap = new HashMap<String, ClusterFactory>();
	private static Map<String, Integer[]> chanceMap = new HashMap<String, Integer[]>();

	private ClusterFactory(String type) {
		this.type = type;
	}

	static {
		for (ClusterFactory operation : values()) {
			operationMap.put(operation.toString(), operation);
		}
		chanceMap.put("SINGLESTAR", new Integer[] { 0, 250 });
		chanceMap.put("DOUBLESTAR_BINARY", new Integer[] { 251, 600 });
		chanceMap.put("DOUBLESTAR_SPREAD", new Integer[] { 601, 700 });
		chanceMap.put("THREESTAR_TRINARY", new Integer[] { 701, 800 });
		chanceMap.put("THREESTAR_BINARYPLUSONE", new Integer[] { 801, 825 });
		chanceMap.put("THREESTAR_SPREAD", new Integer[] { 826, 850 });
		chanceMap.put("FOURSTAR_TRINARYPLUSONE", new Integer[] { 851, 875 });
		chanceMap.put("FOURSTAR_TWOBINARIES", new Integer[] { 876, 925 });
		chanceMap.put("FOURSTAR_SPREAD", new Integer[] { 926, 950 });
		chanceMap.put("FIVESTAR_FOURSTARSPREADPLUSONE", new Integer[] { 951, 970 });
		chanceMap.put("FIVESTAR_SPREAD", new Integer[] { 971, 985 });
		chanceMap.put("CLUSTER_N", new Integer[] { 986, 999 });
	}

	public static ClusterFactory fromString(String type) {
		return operationMap.get(type);
	}

	@Override
	public String toString() {
		return type;
	}

	abstract Operation get();
	
	abstract NormalizedName getName();

	protected static Operation singleStar = new Operation() {
		public ClusterRep process(ClusterRep clusterRep) {
			Double distance = GenRandomRolls.Instance().draw_rand()*AstronomicalUnits.HALFPSEC;
			Double distance_sys_virt_centre = new Double(distance);
			clusterRep.setDistance_sys_virt_centre(distance_sys_virt_centre);
			clusterRep.setAngle_in_radians(Math.toRadians(GenRandomRolls.Instance().getD360()));
			clusterRep.setClusterName(clusterRep.getClusterName());
			clusterRep.setCluster_description(ClusterFactory.SINGLESTAR.name());
			return clusterRep;
		}
	};
	
	protected static NormalizedName singleStarName = new NormalizedName() {		
		@Override
		public String normalizedName() {
			return "Single Star";
		}
	};
	protected static Operation doubleStarBinary = new Operation() {
		public ClusterRep process(ClusterRep clusterRep) {
			Double distance = GenRandomRolls.Instance().draw_rand()*AstronomicalUnits.HALFPSEC;
			Double distance_sys_virt_centre = new Double(distance);
			clusterRep.setDistance_sys_virt_centre(distance_sys_virt_centre);
			clusterRep.setAngle_in_radians(Math.toRadians(GenRandomRolls.Instance().getD360()));
			clusterRep.setClusterName(clusterRep.getClusterName());
			clusterRep.setCluster_description(ClusterFactory.DOUBLESTAR_BINARY.name());
			return clusterRep;
		}
	};
	protected static NormalizedName doubleStarBinaryName = new NormalizedName() {		
		@Override
		public String normalizedName() {
			return "Double Star BInary";
		}
	};
	
	
	protected static Operation doubleStarSpread = new Operation() {
		public ClusterRep process(ClusterRep clusterRep) {
			Double distance = GenRandomRolls.Instance().draw_rand()*AstronomicalUnits.THIRD_PARSEC;
			Double distance_sys_virt_centre = new Double(distance);
			clusterRep.setDistance_sys_virt_centre(distance_sys_virt_centre);
			clusterRep.setAngle_in_radians(Math.toRadians(GenRandomRolls.Instance().getD360()));
			clusterRep.setClusterName(clusterRep.getClusterName());
			clusterRep.setCluster_description(ClusterFactory.DOUBLESTAR_SPREAD.name());
			return clusterRep;
		}
	};
	
	protected static NormalizedName doubleStarSpreadName = new NormalizedName() {
		@Override
		public String normalizedName() {
			return "Two Stars Random Spread";
		}
	};
	
	protected static Operation threeStarTrinary = new Operation() {
		public ClusterRep process(ClusterRep clusterRep) {
			Double distance = GenRandomRolls.Instance().draw_rand()*AstronomicalUnits.HALFPSEC;
			Double distance_sys_virt_centre = new Double(distance);
			clusterRep.setDistance_sys_virt_centre(distance_sys_virt_centre);
			clusterRep.setAngle_in_radians(Math.toRadians(GenRandomRolls.Instance().getD360()));
			clusterRep.setClusterName(clusterRep.getClusterName());
			clusterRep.setCluster_description(ClusterFactory.THREESTAR_TRINARY.name());
			logger.info("THREE STAR TRINARY:"+clusterRep);
			return clusterRep;
		}
	};
	
	protected static NormalizedName threeStarTrinaryName = new NormalizedName() {
		
		@Override
		public String normalizedName() {
			return "Three Star Trinary";
		}
	};
	
	protected static Operation threeStarBinaryPlusOne = new Operation() {
		public ClusterRep process(ClusterRep clusterRep) {
			Double distance = GenRandomRolls.Instance().draw_rand()*AstronomicalUnits.FOURTH_PARSEC;
			Double distance_sys_virt_centre = new Double(distance);
			clusterRep.setDistance_sys_virt_centre(distance_sys_virt_centre);
			clusterRep.setAngle_in_radians(Math.toRadians(GenRandomRolls.Instance().getD360()));
			clusterRep.setClusterName(clusterRep.getClusterName());
			clusterRep.setCluster_description(ClusterFactory.DOUBLESTAR_SPREAD.name());

			return clusterRep;
		}
	};
	
	protected static NormalizedName threeStarBinaryPlusOneName = new NormalizedName() {
		
		@Override
		public String normalizedName() {
			return "Two Binary Stars and One Random Star";
		}
	};
	
	protected static Operation threeStarSpread = new Operation() {
		public ClusterRep process(ClusterRep clusterRep) {
			Double distance = GenRandomRolls.Instance().draw_rand()*AstronomicalUnits.HALFPSEC;
			Double distance_sys_virt_centre = new Double(distance);
			clusterRep.setDistance_sys_virt_centre(distance_sys_virt_centre);
			clusterRep.setAngle_in_radians(Math.toRadians(GenRandomRolls.Instance().getD360()));
			clusterRep.setClusterName(clusterRep.getClusterName());
			clusterRep.setCluster_description(ClusterFactory.THREESTAR_SPREAD.name());

			return clusterRep;
		}
	};
	
	protected static NormalizedName threeStarSpreadName = new NormalizedName() {
		
		@Override
		public String normalizedName() {
			return "Three Random Stars";
		}
	};
	
	protected static Operation fourStarTrinaryPlusOne = new Operation() {
		public ClusterRep process(ClusterRep clusterRep) {
			Double distance = GenRandomRolls.Instance().draw_rand()*AstronomicalUnits.FOURTH_PARSEC;
			Double distance_sys_virt_centre = new Double(distance);
			clusterRep.setDistance_sys_virt_centre(distance_sys_virt_centre);
			clusterRep.setAngle_in_radians(Math.toRadians(GenRandomRolls.Instance().getD360()));
			clusterRep.setClusterName(clusterRep.getClusterName());
			clusterRep.setCluster_description(ClusterFactory.FOURSTAR_TRINARYPLUSONE.name());

			return clusterRep;
		}
	};
	
	protected static NormalizedName fourStarTrinaryPlusOneName = new NormalizedName() {
		
		@Override
		public String normalizedName() {
			return "Trinary Stars and Random Star";
		}
	};
	
	protected static Operation fourStarTwoBinaries = new Operation() {
		public ClusterRep process(ClusterRep clusterRep) {
			Double distance = GenRandomRolls.Instance().draw_rand()*AstronomicalUnits.HALFPSEC;
			Double distance_sys_virt_centre = new Double(distance);
			clusterRep.setDistance_sys_virt_centre(distance_sys_virt_centre);
			clusterRep.setAngle_in_radians(Math.toRadians(GenRandomRolls.Instance().getD360()));
			clusterRep.setClusterName(clusterRep.getClusterName());
			clusterRep.setCluster_description(ClusterFactory.FOURSTAR_TWOBINARIES.name());

			return clusterRep;
		}
	};
	
	protected static NormalizedName fourStarTwoBinariesName = new NormalizedName() {
		
		@Override
		public String normalizedName() {
			return "Two Sets of Binary Stars";
		}
	};
	
	protected static Operation fourStarSpread = new Operation() {
		public ClusterRep process(ClusterRep clusterRep) {
			Double distance = GenRandomRolls.Instance().draw_rand()*AstronomicalUnits.FOURTH_PARSEC;
			Double distance_sys_virt_centre = new Double(distance);
			clusterRep.setDistance_sys_virt_centre(distance_sys_virt_centre);
			clusterRep.setAngle_in_radians(Math.toRadians(GenRandomRolls.Instance().getD360()));
			clusterRep.setClusterName(clusterRep.getClusterName());
			clusterRep.setCluster_description(ClusterFactory.FOURSTAR_SPREAD.name());

			return clusterRep;
		}
	};
	
	protected static NormalizedName fourStarSpreadName = new NormalizedName() {
		
		@Override
		public String normalizedName() {
			return "Four Random Stars";
		}
	};
	
	protected static Operation fiveStarFourStarSpreadPlusOne = new Operation() {
		public ClusterRep process(ClusterRep clusterRep) {
			Double distance = GenRandomRolls.Instance().draw_rand()*AstronomicalUnits.FOURTH_PARSEC;
			Double distance_sys_virt_centre = new Double(distance);
			clusterRep.setDistance_sys_virt_centre(distance_sys_virt_centre);
			clusterRep.setAngle_in_radians(Math.toRadians(GenRandomRolls.Instance().getD360()));
			clusterRep.setClusterName(clusterRep.getClusterName());
			clusterRep.setCluster_description(ClusterFactory.FIVESTAR_FOURSTARSPREADPLUSONE.name());

			return clusterRep;
		}
	};
	
	protected static NormalizedName fiveStarFourStarSpreadPlusOneName = new NormalizedName() {
		
		@Override
		public String normalizedName() {
			return "Four Random Stars and One Random Star";
		}
	};
	
	protected static Operation fiveStarSpread = new Operation() {
		public ClusterRep process(ClusterRep clusterRep) {
			Double distance = GenRandomRolls.Instance().draw_rand()*AstronomicalUnits.FOURTH_PARSEC;
			Double distance_sys_virt_centre = new Double(distance);
			clusterRep.setDistance_sys_virt_centre(distance_sys_virt_centre);
			clusterRep.setAngle_in_radians(Math.toRadians(GenRandomRolls.Instance().getD360()));
			clusterRep.setClusterName(clusterRep.getClusterName());
			clusterRep.setCluster_description(ClusterFactory.FIVESTAR_SPREAD.name());

			return clusterRep;
		}
	};
	
	protected static NormalizedName fiveStarSpreadName = new NormalizedName() {
		
		@Override
		public String normalizedName() {
			return "Five Random Stars";
		}
	};
	
	protected static Operation clusterN = new Operation() {
		public ClusterRep process(ClusterRep clusterRep) {
			Double distance = GenRandomRolls.Instance().draw_rand()*AstronomicalUnits.FOURTH_PARSEC;
			Double distance_sys_virt_centre = new Double(distance);
			clusterRep.setDistance_sys_virt_centre(distance_sys_virt_centre);
			clusterRep.setAngle_in_radians(Math.toRadians(GenRandomRolls.Instance().getD360()));
			clusterRep.setClusterName(clusterRep.getClusterName());
			clusterRep.setCluster_description(ClusterFactory.CLUSTER_N.name());

			return clusterRep;
		}
	};
	
	protected static NormalizedName clusterNname = new NormalizedName() {
		
		@Override
		public String normalizedName() {
			return "Number of Random Stars";
		}
	};
	
	/**
	 * choose a cluster type based on a random chance.
	 * 
	 * @param draw
	 * @return
	 */
	public static String evaluateChance(Integer draw){
		String answer = null;
		if(draw < 0 || draw > 999){
			logger.error("DRAW Out of range:"+draw);
			answer = "ERROR, see log";
		}
		else{
			for (String key : chanceMap.keySet()){
				if(draw >= chanceMap.get(key)[0] && draw <= chanceMap.get(key)[1]){
					answer = key;
				}
			}
		}
		logger.info("draw:"+draw+" answer:"+answer);
		return answer;
	}
	
	private static Map<ClusterFactory, Map<SubClusterFactory,List<DistanceDetailsIF>>> distanceDetailsMap = new HashMap<ClusterFactory, Map<SubClusterFactory,List<DistanceDetailsIF>>>();
	/**
	 * A separate Distance Detail for each SubClusterFactor enumeration.
	 * 
	 * @Refactor remove D.R.Y. violations
	 */
	static{
		// S I N G L E    S T A R
		DistanceDetails distanceDetails = new DistanceDetails(new Integer(1), new Double(1.0), new Double(new Double(1.0E7)));

		Map<SubClusterFactory,List<DistanceDetailsIF>> subClusterMap = new HashMap<SubClusterFactory, List<DistanceDetailsIF>>();
		List<DistanceDetailsIF> detailList = new ArrayList<DistanceDetailsIF>();
		Integer flipACoin = GenRandomRolls.Instance().get_D2();
		Double delta = GenRandomRolls.Instance().getDraw(distanceDetails.getVariance());
		if(1 == flipACoin){
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()+delta);
		}
		else{
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()-delta);
		}
		detailList.add(distanceDetails);
		subClusterMap.put(SubClusterFactory.SINGLESTAR, detailList);
		distanceDetailsMap.put(SINGLESTAR, subClusterMap);
		
		// D O U B L E   S T A R   B I N A R Y
		distanceDetails = new DistanceDetails(new Integer(1), new Double(1.0E7), new Double(0.5E6));
		flipACoin = GenRandomRolls.Instance().get_D2();
		delta = GenRandomRolls.Instance().getDraw(distanceDetails.getVariance());
		if(1 == flipACoin){
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()+delta);
		}
		else{
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()-delta);
		}
		subClusterMap = new HashMap<SubClusterFactory, List<DistanceDetailsIF>>();
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		subClusterMap.put(SubClusterFactory.DOUBLESTAR_BINARY_0, detailList);
		
		distanceDetails = new DistanceDetails(new Integer(1), new Double(1.0E7), new Double(0.5E6));
		flipACoin = GenRandomRolls.Instance().get_D2();
		delta = GenRandomRolls.Instance().getDraw(distanceDetails.getVariance());
		if(1 == flipACoin){
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()+delta);
		}
		else{
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()-delta);
		}
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		subClusterMap.put(SubClusterFactory.DOUBLESTAR_BINARY_1, detailList);
		distanceDetailsMap.put(DOUBLESTAR_BINARY, subClusterMap);
		
		// T H R E E   S T A R   T R I N A R Y
		
		distanceDetails = new DistanceDetails(new Integer(1), new Double(1.0E7), new Double(0.5E6));
		flipACoin = GenRandomRolls.Instance().get_D2();
		delta = GenRandomRolls.Instance().getDraw(distanceDetails.getVariance());
		if(1 == flipACoin){
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()+delta);
		}
		else{
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()-delta);
		}
		subClusterMap = new HashMap<SubClusterFactory, List<DistanceDetailsIF>>();
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		subClusterMap.put(SubClusterFactory.THREESTAR_TRINARY_0, detailList);
		
		distanceDetails = new DistanceDetails(new Integer(1), new Double(1.0E7), new Double(0.5E6));
		flipACoin = GenRandomRolls.Instance().get_D2();
		delta = GenRandomRolls.Instance().getDraw(distanceDetails.getVariance());
		if(1 == flipACoin){
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()+delta);
		}
		else{
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()-delta);
		}
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		subClusterMap.put(SubClusterFactory.THREESTAR_TRINARY_1, detailList);
		
		distanceDetails = new DistanceDetails(new Integer(1), new Double(1.0E7), new Double(0.5E6));
		flipACoin = GenRandomRolls.Instance().get_D2();
		delta = GenRandomRolls.Instance().getDraw(distanceDetails.getVariance());
		if(1 == flipACoin){
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()+delta);
		}
		else{
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()-delta);
		}
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		subClusterMap.put(SubClusterFactory.THREESTAR_TRINARY_2, detailList);

		distanceDetailsMap.put(THREESTAR_TRINARY, subClusterMap);

		// THREE STAR BINARY PLUS ONE
		
		distanceDetails = new DistanceDetails(new Integer(1), new Double(1.0E7), new Double(0.5E6));
		flipACoin = GenRandomRolls.Instance().get_D2();
		delta = GenRandomRolls.Instance().getDraw(distanceDetails.getVariance());
		if(1 == flipACoin){
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()+delta);
		}
		else{
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()-delta);
		}
		subClusterMap = new HashMap<SubClusterFactory, List<DistanceDetailsIF>>();
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		subClusterMap.put(SubClusterFactory.THREESTAR_BINARYPLUSONE_BINARY_0, detailList);
		
		distanceDetails = new DistanceDetails(new Integer(1), new Double(1.0E9), new Double(0.5E5));
		flipACoin = GenRandomRolls.Instance().get_D2();
		delta = GenRandomRolls.Instance().getDraw(distanceDetails.getVariance());
		if(1 == flipACoin){
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()+delta);
		}
		else{
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()-delta);
		}
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		subClusterMap.put(SubClusterFactory.THREESTAR_BINARYPLUSONE_BINARY_1, detailList);
		
		distanceDetails = new DistanceDetails(new Integer(1), new Double(1.0E7), new Double(0.5E6));
		flipACoin = GenRandomRolls.Instance().get_D2();
		delta = GenRandomRolls.Instance().getDraw(distanceDetails.getVariance());
		if(1 == flipACoin){
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()+delta);
		}
		else{
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()-delta);
		}
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		subClusterMap.put(SubClusterFactory.THREESTAR_BINARYPLUSONE_2, detailList);

		distanceDetailsMap.put(THREESTAR_BINARYPLUSONE, subClusterMap);
		
		// F O U R   S T A R   T W O  B I N A R I E S
		
		distanceDetails = new DistanceDetails(new Integer(1), new Double(1.0E7), new Double(0.5E6));
		flipACoin = GenRandomRolls.Instance().get_D2();
		delta = GenRandomRolls.Instance().getDraw(distanceDetails.getVariance());
		if(1 == flipACoin){
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()+delta);
		}
		else{
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()-delta);
		}
		subClusterMap = new HashMap<SubClusterFactory, List<DistanceDetailsIF>>();
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		subClusterMap.put(SubClusterFactory.FOURSTAR_2BINARIES_0_BINARY_0, detailList);
		
		distanceDetails = new DistanceDetails(new Integer(1), new Double(1.0E9), new Double(0.5E5));
		flipACoin = GenRandomRolls.Instance().get_D2();
		delta = GenRandomRolls.Instance().getDraw(distanceDetails.getVariance());
		if(1 == flipACoin){
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()+delta);
		}
		else{
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()-delta);
		}
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		subClusterMap.put(SubClusterFactory.FOURSTAR_2BINARIES_1_BINARY_0, detailList);
		
		distanceDetails = new DistanceDetails(new Integer(1), new Double(1.0E7), new Double(0.5E6));
		flipACoin = GenRandomRolls.Instance().get_D2();
		delta = GenRandomRolls.Instance().getDraw(distanceDetails.getVariance());
		if(1 == flipACoin){
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()+delta);
		}
		else{
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()-delta);
		}
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		subClusterMap.put(SubClusterFactory.FOURSTAR_2BINARIES_0_BINARY_1, detailList);

		distanceDetails = new DistanceDetails(new Integer(1), new Double(1.0E9), new Double(0.5E5));
		flipACoin = GenRandomRolls.Instance().get_D2();
		delta = GenRandomRolls.Instance().getDraw(distanceDetails.getVariance());
		if(1 == flipACoin){
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()+delta);
		}
		else{
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()-delta);
		}
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		subClusterMap.put(SubClusterFactory.FOURSTAR_2BINARIES_1_BINARY_0, detailList);
		
		distanceDetails = new DistanceDetails(new Integer(1), new Double(1.0E7), new Double(0.5E6));
		flipACoin = GenRandomRolls.Instance().get_D2();
		delta = GenRandomRolls.Instance().getDraw(distanceDetails.getVariance());
		if(1 == flipACoin){
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()+delta);
		}
		else{
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()-delta);
		}
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		subClusterMap.put(SubClusterFactory.FOURSTAR_2BINARIES_0_BINARY_1, detailList);
		
		distanceDetails = new DistanceDetails(new Integer(1), new Double(1.0E7), new Double(0.5E6));
		flipACoin = GenRandomRolls.Instance().get_D2();
		delta = GenRandomRolls.Instance().getDraw(distanceDetails.getVariance());
		if(1 == flipACoin){
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()+delta);
		}
		else{
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()-delta);
		}
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		subClusterMap.put(SubClusterFactory.FOURSTAR_2BINARIES_1_BINARY_1, detailList);

		distanceDetailsMap.put(FOURSTAR_TWOBINARIES, subClusterMap);
		
		//  F O U R   S T A R   T R I N A R Y    P L U S    O N E 
		
		distanceDetails = new DistanceDetails(new Integer(1), new Double(1.0E7), new Double(0.5E6));
		flipACoin = GenRandomRolls.Instance().get_D2();
		delta = GenRandomRolls.Instance().getDraw(distanceDetails.getVariance());
		if(1 == flipACoin){
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()+delta);
		}
		else{
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()-delta);
		}
		subClusterMap = new HashMap<SubClusterFactory, List<DistanceDetailsIF>>();
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		subClusterMap.put(SubClusterFactory.FOURSTAR_TRINARYPLUSONE_TRINARY_0, detailList);
		
		distanceDetails = new DistanceDetails(new Integer(1), new Double(1.0E7), new Double(0.5E5));
		flipACoin = GenRandomRolls.Instance().get_D2();
		delta = GenRandomRolls.Instance().getDraw(distanceDetails.getVariance());
		if(1 == flipACoin){
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()+delta);
		}
		else{
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()-delta);
		}
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		subClusterMap.put(SubClusterFactory.FOURSTAR_TRINARYPLUSONE_TRINARY_1, detailList);
		
		distanceDetails = new DistanceDetails(new Integer(1), new Double(1.0E7), new Double(0.5E6));
		flipACoin = GenRandomRolls.Instance().get_D2();
		delta = GenRandomRolls.Instance().getDraw(distanceDetails.getVariance());
		if(1 == flipACoin){
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()+delta);
		}
		else{
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()-delta);
		}
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		subClusterMap.put(SubClusterFactory.FOURSTAR_TRINARYPLUSONE_TRINARY_2, detailList);

		distanceDetails = new DistanceDetails(new Integer(1), new Double(1.0E9), new Double(0.5E5));
		flipACoin = GenRandomRolls.Instance().get_D2();
		delta = GenRandomRolls.Instance().getDraw(distanceDetails.getVariance());
		if(1 == flipACoin){
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()+delta);
		}
		else{
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()-delta);
		}
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		subClusterMap.put(SubClusterFactory.FOURSTAR_TRINARYPLUSONE_1, detailList);
		
		distanceDetailsMap.put(FOURSTAR_TRINARYPLUSONE, subClusterMap);

		// F I V E    S T A R     F O U R    S T A R   S P R E A D   P L U S   O N E
		
		distanceDetails = new DistanceDetails(new Integer(1), new Double(5.0E9), new Double(0.5E3));
		subClusterMap = new HashMap<SubClusterFactory, List<DistanceDetailsIF>>();
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		flipACoin = GenRandomRolls.Instance().get_D2();
		delta = GenRandomRolls.Instance().getDraw(distanceDetails.getVariance());
		if(1 == flipACoin){
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()+delta);
		}
		else{
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()-delta);
		}
		subClusterMap.put(SubClusterFactory.FIVESTAR_FOURSTARSPREADPLUSONE, detailList);
		
		subClusterMap = new HashMap<SubClusterFactory, List<DistanceDetailsIF>>();
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		for (int idex = 0; idex < 4; idex++) {
			distanceDetails = new DistanceDetails(new Integer(1), new Double(
					5.0E9), new Double(0.5E7));
			flipACoin = GenRandomRolls.Instance().get_D2();
			delta = GenRandomRolls.Instance().getDraw(
					distanceDetails.getVariance());
			if (1 == flipACoin) {
				distanceDetails.setDistanceBetweenStars(distanceDetails
						.getMediumDistance() + delta);
			} else {
				distanceDetails.setDistanceBetweenStars(distanceDetails
						.getMediumDistance() - delta);
			}
			detailList.add(distanceDetails);
		}
		subClusterMap.put(SubClusterFactory.NONE, detailList);
		distanceDetailsMap.put(ClusterFactory.FIVESTAR_FOURSTARSPREADPLUSONE,
				subClusterMap);
		
		// D O U B L E   S T A R   S P R E A D
		
		subClusterMap = new HashMap<SubClusterFactory, List<DistanceDetailsIF>>();
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		for (int idex = 0; idex < 2; idex++) {
			distanceDetails = new DistanceDetails(new Integer(1), new Double(
					5.0E9), new Double(0.5E7));
			flipACoin = GenRandomRolls.Instance().get_D2();
			delta = GenRandomRolls.Instance().getDraw(
					distanceDetails.getVariance());
			if (1 == flipACoin) {
				distanceDetails.setDistanceBetweenStars(distanceDetails
						.getMediumDistance() + delta);
			} else {
				distanceDetails.setDistanceBetweenStars(distanceDetails
						.getMediumDistance() - delta);
			}
			detailList.add(distanceDetails);
		}
		subClusterMap.put(SubClusterFactory.NONE, detailList);
		distanceDetailsMap.put(ClusterFactory.DOUBLESTAR_SPREAD, subClusterMap);

		// T H R E E   S T A R   S P R E A D
		
		subClusterMap = new HashMap<SubClusterFactory, List<DistanceDetailsIF>>();
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		for (int idex = 0; idex < 3; idex++) {
			distanceDetails = new DistanceDetails(new Integer(1), new Double(
					5.0E9), new Double(0.5E7));
			flipACoin = GenRandomRolls.Instance().get_D2();
			delta = GenRandomRolls.Instance().getDraw(
					distanceDetails.getVariance());
			if (1 == flipACoin) {
				distanceDetails.setDistanceBetweenStars(distanceDetails
						.getMediumDistance() + delta);
			} else {
				distanceDetails.setDistanceBetweenStars(distanceDetails
						.getMediumDistance() - delta);
			}
			detailList.add(distanceDetails);
		}
		subClusterMap.put(SubClusterFactory.NONE, detailList);
		distanceDetailsMap.put(ClusterFactory.THREESTAR_SPREAD, subClusterMap);

		// F O U R   S T A R   S P R E A D
		
		subClusterMap = new HashMap<SubClusterFactory, List<DistanceDetailsIF>>();
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		for (int idex = 0; idex < 4; idex++) {
			distanceDetails = new DistanceDetails(new Integer(1), new Double(
					5.0E9), new Double(0.5E7));
			flipACoin = GenRandomRolls.Instance().get_D2();
			delta = GenRandomRolls.Instance().getDraw(
					distanceDetails.getVariance());
			if (1 == flipACoin) {
				distanceDetails.setDistanceBetweenStars(distanceDetails
						.getMediumDistance() + delta);
			} else {
				distanceDetails.setDistanceBetweenStars(distanceDetails
						.getMediumDistance() - delta);
			}
			detailList.add(distanceDetails);
		}
		subClusterMap.put(SubClusterFactory.NONE, detailList);		
		distanceDetailsMap.put(ClusterFactory.FOURSTAR_SPREAD, subClusterMap);

		// F I V E   S T A R   S P R E A D
		
		subClusterMap = new HashMap<SubClusterFactory, List<DistanceDetailsIF>>();
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);
		for (int idex = 0; idex < 5; idex++) {
			distanceDetails = new DistanceDetails(new Integer(1), new Double(5.0E9), new Double(0.5E7));
			flipACoin = GenRandomRolls.Instance().get_D2();
			delta = GenRandomRolls.Instance().getDraw(
					distanceDetails.getVariance());
			if (1 == flipACoin) {
				distanceDetails.setDistanceBetweenStars(distanceDetails
						.getMediumDistance() + delta);
			} else {
				distanceDetails.setDistanceBetweenStars(distanceDetails
						.getMediumDistance() - delta);
			}
			detailList.add(distanceDetails);
		}
		subClusterMap.put(SubClusterFactory.NONE, detailList);		
		distanceDetailsMap.put(ClusterFactory.FIVESTAR_SPREAD, subClusterMap);

		// C L U S T E R   N
		
		int numberStars = new Integer(5 + GenRandomRolls
				.Instance().get_D10());
		subClusterMap = new HashMap<SubClusterFactory, List<DistanceDetailsIF>>();
		detailList = new ArrayList<DistanceDetailsIF>();
		detailList.add(distanceDetails);

		for (int idex = 0; idex < numberStars; idex++) {
			distanceDetails = new DistanceDetails(1, new Double(5.0E9), new Double(0.5E7));
			flipACoin = GenRandomRolls.Instance().get_D2();
			delta = GenRandomRolls.Instance().getDraw(
					distanceDetails.getVariance());
			if (1 == flipACoin) {
				distanceDetails.setDistanceBetweenStars(distanceDetails
						.getMediumDistance() + delta);
			} else {
				distanceDetails.setDistanceBetweenStars(distanceDetails
						.getMediumDistance() - delta);
			}
			detailList.add(distanceDetails);
			
		}
		subClusterMap.put(SubClusterFactory.NONE, detailList);
		distanceDetailsMap.put(ClusterFactory.CLUSTER_N, subClusterMap);
	}
	/**
	 * 
	 * list has one or more subtypes.
	 * 
	 * @param clusterFactory
	 * @return map and list selected by cluster type.
	 */
	public static Map<SubClusterFactory,List<DistanceDetailsIF>> getStarToDistanceDetails(ClusterFactory clusterFactory){
		Map<SubClusterFactory,List<DistanceDetailsIF>> subClusterMap = ClusterFactory.distanceDetailsMap.get(clusterFactory);
		return subClusterMap;
	}
}
