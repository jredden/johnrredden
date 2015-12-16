package com.zenred.cosmos.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.zenred.cosmos.domain.ClusterRepDao;
import com.zenred.cosmos.domain.SystemDao;
import com.zenred.cosmos.service_rules_and_infrastructure.ImergeFromHyperspace;
import com.zenred.cosmos.vizualization.SectorsResponse;
import com.zenred.cosmos.domain.System;

public class GenCSV {
	// public static String X = "";
	public static String SYSTEM = "System";
	public static String CLUSTER = "Cluster";
	public static String SUB_CLUSTER = "Sub Cluster";
	public static String DESCRIPTION = "Description";
	public static String STAR_NAME = "Star Name";
	public static String STAR_COLOR = "Star Color";
	public static String STAR_SIZE = "Star Size";
	public static String LUMINOSITY = "Luminosity";
	public static String STAR_TYPE = "Star Type";
	public static String DISTANCE_TO_CLUSTER_CENTRE = "Distance to Cluster Centre";
	public static String ANGLE_IN_CLUSTER = "Angle in Cluster";
	public static String PLANET_NAME = "Planet Name";
	public static String POSITION_IN_DEGREES = "Position In Degrees";
	public static String DISTANCE_TO_STAR = "Distance to Star";
	public static String TEMPERATURE_KELVIN = "Temperature Kelvin";
	public static String RADIUS_KILOMETERS = "Radius Kilometers";
	public static String TEMPERATURE_TYPE = "Temperature Type";
	public static String SIZE_TYPE = "Size Type";
	public static String ATMOSPHERE_COMPONENT = "Atmosphere component";
	public static String ATMOSPHERE_PERCENTAGE = "Atmosphere percentage";
	public static String MOON_NAME = "Moon Name";
	public static String ANGLE_FROM_PLANET = "Angle from Planet";
	public static String DISTANCE_FROM_PLANET = "Distance from Planet";
	public static String TEMPERATURE_KELVIN_PLANET = "Temperature Kelvin";
	public static String RADIUS_KILOMETERS_PLANET = "Radius Kilometers";
	public static String TEMPERATURE_TYPE_PLANET = "Temperature Type";
	public static String SIZE_TYPE_PLANET = "Size Type";
	public static String ATMOSPHERE_COMPONENT_PLANET = "Atmosphere component";
	public static String ATMOSPHERE_PERCENTAGE_PLANET = "Atmosphere percentage";
	
	
	
	static private Logger logger = Logger
			.getLogger(GenCSV.class);
	
	enum Columns{
		a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,aa,ab
	}
	
	Map<Columns,List<String>> columns;
	
	private void initColumns(){
		columns.put(Columns.a, new ArrayList<String>());
		columns.get(Columns.a).add(SYSTEM);
		columns.put(Columns.b, new ArrayList<String>());
		columns.get(Columns.b).add(CLUSTER);
		columns.put(Columns.c, new ArrayList<String>());
		columns.get(Columns.c).add(SUB_CLUSTER);
		columns.put(Columns.d, new ArrayList<String>());
		columns.get(Columns.d).add(DESCRIPTION);
		columns.put(Columns.e, new ArrayList<String>());
		columns.get(Columns.e).add(STAR_NAME);
		columns.put(Columns.f, new ArrayList<String>());
		columns.get(Columns.f).add(STAR_COLOR);
		columns.put(Columns.g, new ArrayList<String>());
		columns.get(Columns.g).add(STAR_SIZE);
		columns.put(Columns.h, new ArrayList<String>());
		columns.put(Columns.i, new ArrayList<String>());
		columns.put(Columns.j, new ArrayList<String>());
		columns.put(Columns.k, new ArrayList<String>());
		columns.put(Columns.l, new ArrayList<String>());
		columns.put(Columns.m, new ArrayList<String>());
		columns.put(Columns.n, new ArrayList<String>());
		columns.put(Columns.o, new ArrayList<String>());
		columns.put(Columns.p, new ArrayList<String>());
		columns.put(Columns.q, new ArrayList<String>());
		columns.put(Columns.r, new ArrayList<String>());
		columns.put(Columns.s, new ArrayList<String>());
		columns.put(Columns.t, new ArrayList<String>());
		columns.put(Columns.u, new ArrayList<String>());
		columns.put(Columns.v, new ArrayList<String>());
		columns.put(Columns.w, new ArrayList<String>());
		columns.put(Columns.x, new ArrayList<String>());
		columns.put(Columns.y, new ArrayList<String>());
		columns.put(Columns.z, new ArrayList<String>());
		columns.put(Columns.aa, new ArrayList<String>());
		columns.put(Columns.ab, new ArrayList<String>());


	}
	
	public static Integer numberSystemsUatATime = ImergeFromHyperspace.uDistribution * ImergeFromHyperspace.vDistribution;
	
	/**
	 * 
	 * @return defining sectors
	 */
	protected static List<String> readDefiningUVCoordinatesOfAllSectors(){
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
			String upperU = currentUs.get(0).toString();
			String lowerU = currentUs.get(currentUs.size()-1).toString();
			String upperV = currentVs.get(0).toString();
			String lowerV = currentVs.get(currentVs.size()-1).toString();
			sectors.add(upperU+":"+upperV+":"+lowerU+":"+lowerV);
			start += GenCSV.numberSystemsUatATime;
			nextV = Boolean.TRUE;
			currentUs.clear();
			currentVs.clear();
		}
		logger.info("start:"+start + " number systems:" + numberOfSystems);
		
		return sectors;
	}
	
	/**
	 * 
	 * @return sector response encapsulation
	 */
	public static SectorsResponse sectorsResponse(){
		StringBuilder keyValuePair = new StringBuilder();
		List<String> sectors = readDefiningUVCoordinatesOfAllSectors();
		Integer key = new Integer(0);
		for(String sector : sectors){
			if(key.equals(0)){
				keyValuePair.append(key).append("=").append(sector);
			}
			else{
				keyValuePair.append(";").append(key).append("=").append(sector);
			}
			++key;
		}
		SectorsResponse sectorsResponse = new SectorsResponse();
		sectorsResponse.setSectors(keyValuePair.toString());
		return sectorsResponse;
	}
	
	/**
	 * 
	 * @param s_Ucoordinate_top
	 * @param s_Vcoordinate_top
	 * @param s_Ucoordinate_bottom
	 * @param s_Vcoordinate_bottom
	 * @return CSV_url
	 */
	public static SectorsResponse selectSector(String s_Ucoordinate_top, String s_Vcoordinate_top, String s_Ucoordinate_bottom, String s_Vcoordinate_bottom ){
		String csv_file = "";
		StringBuilder keyValuePair = new StringBuilder();

		SystemDao systemDao = new SystemDao();
		ClusterRepDao clusterRepDao = new ClusterRepDao();
		System system = null;
		
		Integer i_Utop = new Integer(s_Ucoordinate_top);
		Integer i_Vtop = new Integer(s_Vcoordinate_top);
		Integer i_Ubot = new Integer(s_Ucoordinate_bottom);
		Integer i_Vbot = new Integer(s_Vcoordinate_bottom);
		
		for(int idex = i_Utop ; idex <= i_Ubot; idex++){
			
			for(int idex2 = i_Vtop; idex2 <= i_Vbot; idex2++){
				system = systemDao.readSystemByUVCoordinates(idex, idex2);
				if(clusterRepDao.areThereStarsInSystem(system)){
					
				}
			}
			
		}
		
		SectorsResponse sectorsResponse = new SectorsResponse();
		sectorsResponse.setSectors(keyValuePair.toString());
		return sectorsResponse;
	}
}
