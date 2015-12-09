package com.zenred.cosmos.domain;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zenred.cosmos.report.GenCSV;

public class SectorUVcoordinateTest {

	static private Logger logger = Logger
			.getLogger(SectorUVcoordinateTest.class);

	@Test
	public void testUVCoordinateSet() {
		SystemDao systemDao = new SystemDao();
		Integer start = 0;
		List<Integer> uCoordinates = systemDao.readSectorUcoordinates(start,
				GenCSV.numberSystemsUatATime);
		for (Integer uCoordinate : uCoordinates) {
			logger.info("UCOORDINATE:" + uCoordinate);
		}
		start += GenCSV.numberSystemsUatATime;

		uCoordinates = systemDao.readSectorUcoordinates(start,
				GenCSV.numberSystemsUatATime);
		for (Integer uCoordinate : uCoordinates) {
			logger.info("UCOORDINATE2:" + uCoordinate);
		}
	}
}
