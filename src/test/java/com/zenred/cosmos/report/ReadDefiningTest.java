package com.zenred.cosmos.report;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zenred.cosmos.vizualization.SectorsResponse;
import com.zenred.util.GenRandomRolls;

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
		String [] sectors = response.getSectors().split(";");
		int numberSectors = sectors.length;
		int sectorIndex = GenRandomRolls.Instance().getDX(numberSectors-1);
		String sector = sectors[sectorIndex];
		String [] indexAndUV = sector.split("=");
		String [] uv = indexAndUV[1].split(":");
		GenCSV.selectSector(uv[0], uv[1], uv[2], uv[3]);
	}

}
