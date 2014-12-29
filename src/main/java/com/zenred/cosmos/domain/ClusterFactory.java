package com.zenred.cosmos.domain;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

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
	THREESTAR_SPREAD("THREESTAR_TRINARY") {
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
			Double distance_sys_virt_centre = new Double(0.0);
			clusterRep.setDistance_sys_virt_centre(distance_sys_virt_centre);
			clusterRep.setAngle_in_radians(Math.toRadians(0.0));
			clusterRep.setClusterName(clusterRep.getClusterName());
			clusterRep.setCluster_description(ClusterFactory.SINGLESTAR.name());
			return clusterRep;
		}
	};
	protected static Operation doubleStarBinary = new Operation() {
		public ClusterRep process(ClusterRep clusterRep) {
			
			
			return clusterRep;
		}
	};
	protected static Operation doubleStarSpread = new Operation() {
		public ClusterRep process(ClusterRep clusterRep) {

			return clusterRep;
		}
	};
	protected static Operation threeStarTrinary = new Operation() {
		public ClusterRep process(ClusterRep clusterRep) {

			return clusterRep;
		}
	};
	protected static Operation threeStarBinaryPlusOne = new Operation() {
		public ClusterRep process(ClusterRep clusterRep) {

			return clusterRep;
		}
	};
	protected static Operation threeStarSpread = new Operation() {
		public ClusterRep process(ClusterRep clusterRep) {

			return clusterRep;
		}
	};
	protected static Operation fourStarTrinaryPlusOne = new Operation() {
		public ClusterRep process(ClusterRep clusterRep) {

			return clusterRep;
		}
	};
	protected static Operation fourStarTwoBinaries = new Operation() {
		public ClusterRep process(ClusterRep clusterRep) {

			return clusterRep;
		}
	};
	protected static Operation fourStarSpread = new Operation() {
		public ClusterRep process(ClusterRep clusterRep) {

			return clusterRep;
		}
	};
	protected static Operation fiveStarFourStarSpreadPlusOne = new Operation() {
		public ClusterRep process(ClusterRep clusterRep) {

			return clusterRep;
		}
	};
	protected static Operation fiveStarSpread = new Operation() {
		public ClusterRep process(ClusterRep clusterRep) {

			return clusterRep;
		}
	};
	protected static Operation clusterN = new Operation() {
		public ClusterRep process(ClusterRep clusterRep) {

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
}
