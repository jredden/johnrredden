package com.zenred.cosmos.domain;

import java.util.HashMap;
import java.util.Map;

/**
 *   'SINGLESTAR'
  , 'DOUBLESTAR_BINARY'
  , 'DOUBLESTAR_SPREAD'
  , 'THREESTAR_TRINARY'
  , 'THREESTAR_BINARYPLUSONE'
  , 'THREESTAR_SPREAD'
  , 'FOURSTAR_TRINARYPLUSONE'
  , 'FOURSTAR_TWOBINARIES'
  , 'FOURSTAR_SPREAD'
  , 'FIVESTAR_FOURSTARSPREADPLUSONE'
  , 'FIVESTAR_SPREAD'
  , 'CLUSTER_N'
 * 
 * @author jredden
 *
 */

interface Operation{
	void process(ClusterRep clusterRep);
}

public enum ClusterFactory {
	
	SINGLESTAR("SINGLESTAR"){ Operation get() {return singleStar;}},
	DOUBLESTAR_BINARY("DOUBLESTAR_BINARY"){ Operation get() {return doubleStarBinary;}},
	DOUBLESTAR_SPREAD("DOUBLESTAR_SPREAD"){ Operation get() {return doubleStarSpread;}},
	THREESTAR_TRINARY("THREESTAR_TRINARY"){ Operation get() {return threeStarTrinary;}},
	THREESTAR_BINARYPLUSONE("THREESTAR_BINARYPLUSONE"){ Operation get() {return ClusterFactory.threeStarBinaryPlusOne;}},
	THREESTAR_SPREAD("THREESTAR_TRINARY"){ Operation get() {return threeStarSpread;}},
	;
	
	private String type;
	private static Map<String, ClusterFactory> operationMap = new HashMap<String, ClusterFactory>();
	
	private ClusterFactory (String type){
		this.type = type;
	}

	static{
		for(ClusterFactory operation: values()){
			operationMap.put(operation.toString(), operation);
		}
	}
	
	public static ClusterFactory fromString(String type){
		return operationMap.get(type);
	}
	
	@Override
	public String toString(){
		return type;
	}
	
	abstract Operation get();

	protected static Operation singleStar = new Operation() {
		public void process(ClusterRep clusterRep){
			
		}
	};
	protected static Operation doubleStarBinary = new Operation() {
		public void process(ClusterRep clusterRep){
			
		}
	};
	protected static Operation doubleStarSpread = new Operation() {
		public void process(ClusterRep clusterRep){
			
		}
	};
	protected static Operation threeStarTrinary = new Operation() {
		public void process(ClusterRep clusterRep){
			
		}
	};
	protected static Operation threeStarBinaryPlusOne = new Operation() {
		public void process(ClusterRep clusterRep){
			
		}
	};
	protected static Operation threeStarSpread = new Operation() {
		public void process(ClusterRep clusterRep){
			
		}
	};
	protected static Operation fourStarTrinaryPlusOne = new Operation() {
		public void process(ClusterRep clusterRep){
			
		}
	};
	protected static Operation fourStarTwoBinaries = new Operation() {
		public void process(ClusterRep clusterRep){
			
		}
	};
	protected static Operation fourStarSpread = new Operation() {
		public void process(ClusterRep clusterRep){
			
		}
	};
	protected static Operation fiveStarFourStarSpreadPlusOne = new Operation() {
		public void process(ClusterRep clusterRep){
			
		}
	};
	protected static Operation fiveStarSpread = new Operation() {
		public void process(ClusterRep clusterRep){
			
		}
	};
	protected static Operation clusterN = new Operation() {
		public void process(ClusterRep clusterRep){
			
		}
	};
}
