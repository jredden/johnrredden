package com.zenred.cosmos.service_rules_and_infrastructure;

public class ImergeFromHyperspace {
	
	// 25 system matrix
	public static int uDistribution = 5;
	public static int vDistribution = 5;
		
	public static void dontKnowWhereShipIs(){
		 doesKnowWhereShipIs(GenSystem.genSystem());
	}
	
	public static void doesKnowWhereShipIs(com.zenred.cosmos.domain.System system){
		Double startU = system.getUcoordinate()-2; // centre on initial U,V coordinate
		Double startV = system.getVcoordinate()-2;
		
		for(int scalarU = 0;  scalarU < uDistribution ; scalarU++){
			for(int scalarV = 0; scalarV < vDistribution; scalarV++){
				
			}
		}
	}
}
