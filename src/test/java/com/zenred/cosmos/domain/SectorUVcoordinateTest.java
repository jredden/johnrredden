package com.zenred.cosmos.domain;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zenred.cosmos.report.GenCSV;
import com.zenred.cosmos.service_rules_and_infrastructure.ImergeFromHyperspace;

public class SectorUVcoordinateTest {

	static private Logger logger = Logger
			.getLogger(SectorUVcoordinateTest.class);

	@Test
	public void testUVCoordinateSet() {
		SystemDao systemDao = new SystemDao();
		Integer start = 0;
		Integer lastU = -1;
		List<Integer> vCoordinates = null;
		List<Integer> uCoordinates = systemDao.readSectorUcoordinates(start,
				GenCSV.numberSystemsUatATime);
		for (Integer uCoordinate : uCoordinates) {
			logger.info("UCOORDINATE:" + uCoordinate);
			if(! uCoordinate.equals(lastU)){
				vCoordinates = systemDao.readSectorVcoordinates(uCoordinate, 0, ImergeFromHyperspace.vDistribution);
				for(Integer vCoordinate: vCoordinates){
					logger.info("VCOORDINATE:"+vCoordinate);
					lastU = uCoordinate;
				}
			}
		}
		start += GenCSV.numberSystemsUatATime;

		uCoordinates = systemDao.readSectorUcoordinates(start,
				GenCSV.numberSystemsUatATime);
		for (Integer uCoordinate : uCoordinates) {
			logger.info("UCOORDINATE2:" + uCoordinate);
			if(! uCoordinate.equals(lastU)){
				vCoordinates = systemDao.readSectorVcoordinates(uCoordinate, 0, ImergeFromHyperspace.vDistribution);
				for(Integer vCoordinate: vCoordinates){
					logger.info("VCOORDINATE2:"+vCoordinate);
					lastU = uCoordinate;
				}
			}
		}
		assertTrue(uCoordinates.size() == GenCSV.numberSystemsUatATime );
	}
	
	@Test
	public void minimalOutputTest() {
		SystemDao systemDao = new SystemDao();
		Integer start = 0;
		Integer lastU = -1;
		List<Integer> vCoordinates = null;
		List<Integer> uCoordinates = systemDao.readSectorUcoordinates(start,
				GenCSV.numberSystemsUatATime);
		for (Integer uCoordinate : uCoordinates) {
			if (!uCoordinate.equals(lastU)) {
				logger.info("UCOORDINATE:" + uCoordinate);
				if (lastU.equals(-1)) {
					vCoordinates = systemDao.readSectorVcoordinates(
							uCoordinate, 0, ImergeFromHyperspace.vDistribution);
					for (Integer vCoordinate : vCoordinates) {
						logger.info("VCOORDINATE:" + vCoordinate);

					}
				}
				lastU = uCoordinate;
			}
		}
		assertTrue(vCoordinates.size() == ImergeFromHyperspace.vDistribution );
	}
	
	@Test
	public void longRunTest() {
		SystemDao systemDao = new SystemDao();
		Integer start = 0;
		Integer lastU = -1;
		Boolean nextV = Boolean.TRUE;
		List<Integer> vCoordinates = null;
		Integer numberOfSystems = systemDao.numberOfSystems().intValue();
		logger.info("BEGIN:"+start+" NUMBER OF SYSTEMS:"+numberOfSystems);
		// numberOfSystems -= GenCSV.numberSystemsUatATime;
		while ( numberOfSystems.compareTo(start) >= 0) {
			List<Integer> uCoordinates = systemDao.readSectorUcoordinates(
					start, GenCSV.numberSystemsUatATime);
			for (Integer uCoordinate : uCoordinates) {
				if (!uCoordinate.equals(lastU)) {
					logger.info(start + " UCOORDINATE:" + uCoordinate);
					if (nextV) {
						vCoordinates = systemDao.readSectorVcoordinates(
								uCoordinate, 0,
								ImergeFromHyperspace.vDistribution);
						for (Integer vCoordinate : vCoordinates) {
							logger.info(start + " VCOORDINATE:" + vCoordinate);

						}
						nextV = Boolean.FALSE;
					}
					lastU = uCoordinate;
				}
			}
			start += GenCSV.numberSystemsUatATime;
			logger.info("START:"+start+" NUMBER OF SYSTEMS:"+numberOfSystems);
			nextV = Boolean.TRUE;
		}
		logger.info("start:"+start + " number systems:" + numberOfSystems);
		
	}
}
