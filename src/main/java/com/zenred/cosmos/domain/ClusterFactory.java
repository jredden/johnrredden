package com.zenred.cosmos.domain;

import java.util.HashMap;
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

class DistanceDetails{
	public DistanceDetails() {
		super();
	}
	
	public DistanceDetails(Integer numberStarsToGenerate,
			Double mediumDistance, Double variance) {
		super();
		this.numberStarsToGenerate = numberStarsToGenerate;
		this.mediumDistance = mediumDistance;
		this.variance = variance;
	}

	protected Integer numberStarsToGenerate;
	protected Double mediumDistance;
	protected Double variance;
	protected Double distanceBetweenStars;
	
	
	
	public Integer getNumberStarsToGenerate() {
		return numberStarsToGenerate;
	}
	public void setNumberStarsToGenerate(Integer numberStarsToGenerate) {
		this.numberStarsToGenerate = numberStarsToGenerate;
	}
	public Double getMediumDistance() {
		return mediumDistance;
	}
	public void setMediumDistance(Double mediumDistance) {
		this.mediumDistance = mediumDistance;
	}
	public Double getVariance() {
		return variance;
	}
	public void setVariance(Double variance) {
		this.variance = variance;
	}
	
	public Double getDistanceBetweenStars() {
		return distanceBetweenStars;
	}

	public void setDistanceBetweenStars(Double distanceBetweenStars) {
		this.distanceBetweenStars = distanceBetweenStars;
	}

	@Override
	public String toString() {
		return "DistanceDetails [numberStarsToGenerate="
				+ numberStarsToGenerate + ", mediumDistance=" + mediumDistance
				+ ", variance=" + variance + ", distanceBetweenStars="
				+ distanceBetweenStars + "]";
	}
	
	
}

public enum ClusterFactory {

	SINGLESTAR("SINGLESTAR") {
		Operation get() {
			return singleStar;
		}
	},
	DOUBLESTAR_BINARY("DOUBLESTAR_BINARY") {
		Operation get() {
			return doubleStarBinary;
		}
	},
	DOUBLESTAR_SPREAD("DOUBLESTAR_SPREAD") {
		Operation get() {
			return doubleStarSpread;
		}
	},
	THREESTAR_TRINARY("THREESTAR_TRINARY") {
		Operation get() {
			return threeStarTrinary;
		}
	},
	THREESTAR_BINARYPLUSONE("THREESTAR_BINARYPLUSONE") {
		Operation get() {
			return ClusterFactory.threeStarBinaryPlusOne;
		}
	},
	THREESTAR_SPREAD("THREESTAR_SPREAD") {
		Operation get() {
			return threeStarSpread;
		}
	},
	FOURSTAR_TRINARYPLUSONE("FOURSTAR_TRINARYPLUSONE") {
		Operation get() {
			return ClusterFactory.fourStarTrinaryPlusOne;
		}
	},
	FOURSTAR_TWOBINARIES("FOURSTAR_TWOBINARIES") {
		Operation get() {
			return ClusterFactory.fourStarTwoBinaries;
		}
	},
	FOURSTAR_SPREAD("FOURSTAR_SPREAD") {
		Operation get() {
			return ClusterFactory.fourStarSpread;
		}
	},
	FIVESTAR_FOURSTARSPREADPLUSONE("FIVESTAR_FOURSTARSPREADPLUSONE") {
		Operation get() {
			return ClusterFactory.fiveStarFourStarSpreadPlusOne;
		}
	},
	FIVESTAR_SPREAD("FIVESTAR_SPREAD") {
		Operation get() {
			return ClusterFactory.fiveStarSpread;
		}
	},
	CLUSTER_N("CLUSTER_N") {
		Operation get() {
			return ClusterFactory.clusterN;
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
	
	private static Map<ClusterFactory, DistanceDetails> distanceDetailsMap = new HashMap<ClusterFactory, DistanceDetails>();
	/**
	 * can only assign delta for degenerate case, a single star or double stars.  Others are handled at calling level.
	 */
	static{
		distanceDetailsMap.put(SINGLESTAR, new DistanceDetails(new Integer(1), new Double(0), new Double(0)));
		
		DistanceDetails distanceDetails = new DistanceDetails(new Integer(2), new Double(1.0E7), new Double(0.5E6));
		Integer flipACoin = GenRandomRolls.Instance().get_D2();
		Double delta = GenRandomRolls.Instance().getDraw(distanceDetails.getVariance());
		if(1 == flipACoin){
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()+delta);
		}
		else{
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()-delta);
		}
		distanceDetailsMap.put(DOUBLESTAR_BINARY, distanceDetails);
		
		distanceDetails = new DistanceDetails(new Integer(2), new Double(1.0E9), new Double(0.5E7));
		flipACoin = GenRandomRolls.Instance().get_D2();
		delta = GenRandomRolls.Instance().getDraw(distanceDetails.getVariance());
		if(1 == flipACoin){
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()+delta);
		}
		else{
			distanceDetails.setDistanceBetweenStars(distanceDetails.getMediumDistance()-delta);
		}
		distanceDetailsMap.put(DOUBLESTAR_SPREAD, distanceDetails);
		
		distanceDetails = new DistanceDetails(new Integer(3), new Double(1.0E7), new Double(0.5E3));
		distanceDetailsMap.put(THREESTAR_TRINARY, distanceDetails);

		distanceDetails = new DistanceDetails(new Integer(3), new Double(1.0E7), new Double(0.5E3));
		distanceDetailsMap.put(THREESTAR_BINARYPLUSONE, distanceDetails);
		
		distanceDetails = new DistanceDetails(new Integer(3), new Double(1.0E9), new Double(0.5E6));
		distanceDetailsMap.put(THREESTAR_SPREAD, distanceDetails);
		
		distanceDetails = new DistanceDetails(new Integer(4), new Double(1.0E7), new Double(0.5E6));
		distanceDetailsMap.put(FOURSTAR_TRINARYPLUSONE, distanceDetails);
		
		distanceDetails = new DistanceDetails(new Integer(4), new Double(1.0E10), new Double(0.5E3));
		distanceDetailsMap.put(FOURSTAR_SPREAD, distanceDetails);
		
		distanceDetails = new DistanceDetails(new Integer(5), new Double(5.0E9), new Double(0.5E3));
		distanceDetailsMap.put(ClusterFactory.FIVESTAR_FOURSTARSPREADPLUSONE, distanceDetails);
		
		distanceDetails = new DistanceDetails(new Integer(5), new Double(5.0E9), new Double(0.5E3));
		distanceDetailsMap.put(ClusterFactory.FIVESTAR_SPREAD, distanceDetails);
		
		distanceDetails = new DistanceDetails(new Integer(Integer.MAX_VALUE), new Double(5.0E7), new Double(0.5E3));
		distanceDetailsMap.put(ClusterFactory.CLUSTER_N, distanceDetails);

	}
	
}
