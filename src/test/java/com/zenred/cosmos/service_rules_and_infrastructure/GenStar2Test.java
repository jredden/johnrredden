package com.zenred.cosmos.service_rules_and_infrastructure;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.apache.log4j.Logger;

import com.zenred.cosmos.domain.ClusterFactory;
import com.zenred.cosmos.domain.DistanceDetailsIF;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.SubClusterFactory;
import com.zenred.util.GenRandomRolls;

public class GenStar2Test {
	private static Logger logger = Logger.getLogger(GenStar2Test.class);
	private static int count = 1000;
	@Test
	public void test() {
		while(count != 0){
			Integer draw = GenRandomRolls.Instance().getD1000()-1;
			logger.info("CLUSTER DRAW:"+draw);
			if(draw < 0){
				draw = 0;
			}
			else if(draw > 999){
				draw = 999;
			}
			ClusterFactory clusterFactory = ClusterFactory.fromString(ClusterFactory.evaluateChance(draw));
			List<DecoratedStar> stars = GenStar.generateStarsInCluster(clusterFactory, "StarGen."+count+'.');
			for(DecoratedStar star : stars){
				logger.info("STAR:"+star);
			}
		--count;
		}
	}

}
