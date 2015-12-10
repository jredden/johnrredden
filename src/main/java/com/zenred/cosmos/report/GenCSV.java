package com.zenred.cosmos.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.zenred.cosmos.domain.SystemDao;
import com.zenred.cosmos.service_rules_and_infrastructure.ImergeFromHyperspace;

public class GenCSV {
	
	static private Logger logger = Logger
			.getLogger(GenCSV.class);
	
	enum Columns{
		a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,aa,ab
	}
	
	Map<Columns,String> row;
	
	public static Integer numberSystemsUatATime = ImergeFromHyperspace.uDistribution * ImergeFromHyperspace.vDistribution;
	
	public List<String> readDefiningUVCoordinatesOfAllSectors(){
		List<String> sectors = new ArrayList<String>();
		SystemDao systemDao = new SystemDao();
		Integer start = 0;
		Integer lastU = -1;
		Boolean nextV = Boolean.TRUE;
		List<Integer> vCoordinates = null;
		Integer numberOfSystems = systemDao.numberOfSystems().intValue();
		List<Integer> currentUs = new ArrayList<Integer>();
		List<Integer> currentVs = new ArrayList<Integer>();
		while (!numberOfSystems.equals(start)
				|| !(numberOfSystems.compareTo(start) <= 0)) {
			List<Integer> uCoordinates = systemDao.readSectorUcoordinates(
					start, GenCSV.numberSystemsUatATime);
			for (Integer uCoordinate : uCoordinates) {
				if (!uCoordinate.equals(lastU)) {
					logger.info(start + " UCOORDINATE:" + uCoordinate);
					currentUs.add(uCoordinate);
					if (nextV) {
						vCoordinates = systemDao.readSectorVcoordinates(
								uCoordinate, 0,
								ImergeFromHyperspace.vDistribution);
						for (Integer vCoordinate : vCoordinates) {
							logger.info(start + " VCOORDINATE:" + vCoordinate);
							currentVs.add(vCoordinate);

						}
						nextV = Boolean.FALSE;
					}
					lastU = uCoordinate;
				}
			}
			// to do load up defining u,v of sector corners
			start += GenCSV.numberSystemsUatATime;
			nextV = Boolean.TRUE;
			currentUs.clear();
			currentVs.clear();
		}
		logger.info("start:"+start + " number systems:" + numberOfSystems);
		
		return sectors;
	}
	

}
