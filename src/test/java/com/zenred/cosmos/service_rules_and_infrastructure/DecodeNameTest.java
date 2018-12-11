package com.zenred.cosmos.service_rules_and_infrastructure;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zenred.cosmos.service_rules_and_infrastructure.DecodeName.UVcoordinate;

public class DecodeNameTest {
	
	static private Logger logger = Logger.getLogger(DecodeNameTest.class);

	@Test
	public void test() {
		String val_0 = "Cluster.DOUBLESTAR_BINARY.76974.79975";
		UVcoordinate uvCoordinate = DecodeName.nameToUV(val_0);
		logger.info("U:" + uvCoordinate.getU() + " V:" + uvCoordinate.getV() );
		String val_1 = "Star.Cluster.DOUBLESTAR_BINARY.76974.79975.0";
		uvCoordinate = DecodeName.nameToUV(val_1);
		logger.info("U:" + uvCoordinate.getU() + " V:" + uvCoordinate.getV() );
		String val_2 = "Star.Cluster.SINGLESTAR.62549.79644.0.planet.0";
		uvCoordinate = DecodeName.nameToUV(val_2);
		logger.info("U:" + uvCoordinate.getU() + " V:" + uvCoordinate.getV() );
		
	}

}
