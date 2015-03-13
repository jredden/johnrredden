package com.zenred.cosmos.service_rules_and_infrastructure;

import org.apache.log4j.Logger;

import com.zenred.cosmos.domain.ClusterFactory;
import com.zenred.cosmos.domain.ClusterRep;
import com.zenred.util.GenRandomRolls;

public class GenCluster {
	
	private static Logger logger = Logger.getLogger(GenCluster.class);

	public static ClusterRep genCluster(com.zenred.cosmos.domain.System system){
		Integer draw = GenRandomRolls.Instance().getD1000()-1;
		
		if(draw < 0){
			logger.error("CLUSTER DRAW LT ZERO:"+draw);
			draw = 0;
		}
		else if(draw > 999){
			logger.error("CLUSTER DRAW GT MAX:"+draw);
			draw = 999;
		}
		ClusterFactory clusterFactory = ClusterFactory.fromString(ClusterFactory.evaluateChance(draw));
		String cluster_type = clusterFactory.name();

		return null;
	}
}
