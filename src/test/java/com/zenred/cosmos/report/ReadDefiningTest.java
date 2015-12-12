package com.zenred.cosmos.report;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zenred.cosmos.vizualization.SectorsResponse;

public class ReadDefiningTest {
	static private Logger logger = Logger
			.getLogger(ReadDefiningTest.class);

	@Test
	public void readDefiningSectorsTest() {
		List<String> sectors = GenCSV.readDefiningUVCoordinatesOfAllSectors();
		logger.info("SECTORS:"+sectors);
		assertTrue(sectors != null);
	}
	
	@Test
	public void sectorResponseTest(){
		SectorsResponse response = GenCSV.sectorsResponse();
		logger.info("RESPONSE:"+response.getSectors());
		assertTrue(response != null);
	}

}
