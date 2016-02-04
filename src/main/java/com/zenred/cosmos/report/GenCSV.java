package com.zenred.cosmos.report;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.commons.io.FileUtils;

import com.zenred.cosmos.domain.Atmosphere;
import com.zenred.cosmos.domain.ClusterFactory;
import com.zenred.cosmos.domain.ClusterRep;
import com.zenred.cosmos.domain.ClusterRepDao;
import com.zenred.cosmos.domain.ConfigurationDao;
import com.zenred.cosmos.domain.ExistingSystemWithStars;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.SystemDao;
import com.zenred.cosmos.domain.UnifiedPlanetoidI;
import com.zenred.cosmos.service_rules_and_infrastructure.GenAtmosphere;
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
	public static String TEMPERATURE_KELVIN_MOON = "Temperature Kelvin";
	public static String RADIUS_KILOMETERS_MOON = "Radius Kilometers";
	public static String TEMPERATURE_TYPE_MOON = "Temperature Type";
	public static String SIZE_TYPE_MOON = "Size Type";
	public static String ATMOSPHERE_COMPONENT_MOON = "Atmosphere component";
	public static String ATMOSPHERE_PERCENTAGE_MOON = "Atmosphere percentage";
	
	public static String SEPERATOR = ",";
	public static String BLANK = "";
	
	
	
	static private Logger logger = Logger
			.getLogger(GenCSV.class);
	
	enum Columns{
		a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,aa,ab,ac
	}
	
	private static Map<Columns,List<String>> columns;
	/**
	 * csv header
	 */
	private static void initColumns(){
		columns = new HashMap<GenCSV.Columns, List<String>>();
		columns.put(Columns.a, new ArrayList<String>());
		columns.get(Columns.a).add(SYSTEM);
		columns.put(Columns.b, new ArrayList<String>());
		columns.get(Columns.b).add(SEPERATOR+CLUSTER);
		columns.put(Columns.c, new ArrayList<String>());
		columns.get(Columns.c).add(SEPERATOR+SUB_CLUSTER);
		columns.put(Columns.d, new ArrayList<String>());
		columns.get(Columns.d).add(SEPERATOR+DESCRIPTION);
		columns.put(Columns.e, new ArrayList<String>());
		columns.get(Columns.e).add(SEPERATOR+STAR_NAME);
		columns.put(Columns.f, new ArrayList<String>());
		columns.get(Columns.f).add(SEPERATOR+STAR_COLOR);
		columns.put(Columns.g, new ArrayList<String>());
		columns.get(Columns.g).add(SEPERATOR+STAR_SIZE);
		columns.put(Columns.h, new ArrayList<String>());
		columns.get(Columns.h).add(SEPERATOR+STAR_TYPE);
		columns.put(Columns.i, new ArrayList<String>());
		columns.get(Columns.i).add(SEPERATOR+LUMINOSITY);
		columns.put(Columns.j, new ArrayList<String>());
		columns.get(Columns.j).add(SEPERATOR+DISTANCE_TO_CLUSTER_CENTRE);
		columns.put(Columns.k, new ArrayList<String>());
		columns.get(Columns.k).add(SEPERATOR+ANGLE_IN_CLUSTER);
		columns.put(Columns.l, new ArrayList<String>());
		columns.get(Columns.l).add(SEPERATOR+PLANET_NAME);
		columns.put(Columns.m, new ArrayList<String>());
		columns.get(Columns.m).add(SEPERATOR+POSITION_IN_DEGREES);
		columns.put(Columns.n, new ArrayList<String>());
		columns.get(Columns.n).add(SEPERATOR+DISTANCE_TO_STAR);
		columns.put(Columns.o, new ArrayList<String>());
		columns.get(Columns.o).add(SEPERATOR+TEMPERATURE_KELVIN);
		columns.put(Columns.p, new ArrayList<String>());
		columns.get(Columns.p).add(SEPERATOR+RADIUS_KILOMETERS);
		columns.put(Columns.q, new ArrayList<String>());
		columns.get(Columns.q).add(SEPERATOR+TEMPERATURE_TYPE);
		columns.put(Columns.r, new ArrayList<String>());
		columns.get(Columns.r).add(SEPERATOR+SIZE_TYPE);
		columns.put(Columns.s, new ArrayList<String>());
		columns.get(Columns.s).add(SEPERATOR+ATMOSPHERE_COMPONENT);
		columns.put(Columns.t, new ArrayList<String>());
		columns.get(Columns.t).add(SEPERATOR+ATMOSPHERE_PERCENTAGE);
		columns.put(Columns.u, new ArrayList<String>());
		columns.get(Columns.u).add(SEPERATOR+MOON_NAME);
		columns.put(Columns.v, new ArrayList<String>());
		columns.get(Columns.v).add(SEPERATOR+ANGLE_FROM_PLANET);
		columns.put(Columns.w, new ArrayList<String>());
		columns.get(Columns.w).add(SEPERATOR+DISTANCE_FROM_PLANET);
		columns.put(Columns.x, new ArrayList<String>());
		columns.get(Columns.x).add(SEPERATOR+TEMPERATURE_KELVIN_MOON);
		columns.put(Columns.y, new ArrayList<String>());
		columns.get(Columns.y).add(SEPERATOR+RADIUS_KILOMETERS_MOON);
		columns.put(Columns.z, new ArrayList<String>());
		columns.get(Columns.z).add(SEPERATOR+TEMPERATURE_TYPE_MOON);
		columns.put(Columns.aa, new ArrayList<String>());
		columns.get(Columns.aa).add(SEPERATOR+SIZE_TYPE_MOON);
		columns.put(Columns.ab, new ArrayList<String>());
		columns.get(Columns.ab).add(SEPERATOR+ATMOSPHERE_COMPONENT_MOON);
		columns.put(Columns.ac, new ArrayList<String>());
		columns.get(Columns.ac).add(SEPERATOR+ATMOSPHERE_PERCENTAGE_MOON);
		logger.info("1.COMMACOUNT:"+28);
	}
	
	private static void systemName(String systemName){
		columns.get(Columns.a).add(systemName);
		logger.info("2.COMMACOUNT:"+0);

	}
	
	private static void clusterName(String clusterName, String clusterDescription){
		columns.get(Columns.b).add(SEPERATOR+clusterName);
		columns.get(Columns.c).add(SEPERATOR+clusterDescription);
		columns.get(Columns.d).add(SEPERATOR+ClusterFactory.getNormalizedName(clusterDescription));
		logger.info("3.COMMACOUNT:"+3);

	}
	
	private static void firstOrNextStar(Star star){
		columns.get(Columns.e).add(SEPERATOR+star.getName());
		columns.get(Columns.f).add(SEPERATOR+star.getStar_color());
		columns.get(Columns.g).add(SEPERATOR+star.getStar_size().toString());
		columns.get(Columns.h).add(SEPERATOR+star.getLuminosity().toString());
		columns.get(Columns.i).add(SEPERATOR+star.getStar_type());
		columns.get(Columns.j).add(SEPERATOR+star.getDistance_clust_virt_centre().toString());
		double degrees = Math.toDegrees(star.getAngle_in_radians_s());
		columns.get(Columns.k).add(SEPERATOR+new Double(degrees).toString());
		logger.info("4.COMMACOUNT:"+7);
	}
	
	private static void firstOrNextPlanetoid(UnifiedPlanetoidI unifiedPlanetoidI){
		columns.get(Columns.l).add(SEPERATOR+unifiedPlanetoidI.getPlanetoid().getPlanetoidName());
		columns.get(Columns.m).add(SEPERATOR+unifiedPlanetoidI.getPlanetoid().getDegree().toString());
		columns.get(Columns.n).add(SEPERATOR+unifiedPlanetoidI.getPlanetoid().getDistanceToPrimary().toString());
		columns.get(Columns.o).add(SEPERATOR+unifiedPlanetoidI.getPlanetoid().getTemperature().toString());
		columns.get(Columns.p).add(SEPERATOR+unifiedPlanetoidI.getPlanetoid().getRadius().toString());
		columns.get(Columns.q).add(SEPERATOR+
				GenAtmosphere.temperatureType(unifiedPlanetoidI.getPlanetoid()
						.getTemperature()));
		columns.get(Columns.r).add(SEPERATOR+
				GenAtmosphere.sizeType(unifiedPlanetoidI.getPlanetoid()
						.getRadius()));
		logger.info("5.COMMACOUNT:"+7);
	}
	
	private static void firstOrNextMoon(UnifiedPlanetoidI unifiedPlanetoidI){
		columns.get(Columns.u).add(SEPERATOR+unifiedPlanetoidI.getPlanetoid().getPlanetoidName());
		columns.get(Columns.v).add(SEPERATOR+unifiedPlanetoidI.getPlanetoid().getDegree().toString());
		columns.get(Columns.w).add(SEPERATOR+unifiedPlanetoidI.getPlanetoid().getDistanceToPrimary().toString());
		columns.get(Columns.x).add(SEPERATOR+unifiedPlanetoidI.getPlanetoid().getTemperature().toString());
		columns.get(Columns.y).add(SEPERATOR+unifiedPlanetoidI.getPlanetoid().getRadius().toString());
		columns.get(Columns.z).add(SEPERATOR+
				GenAtmosphere.temperatureType(unifiedPlanetoidI.getPlanetoid()
						.getTemperature()));
		columns.get(Columns.aa).add(SEPERATOR+
				GenAtmosphere.sizeType(unifiedPlanetoidI.getPlanetoid()
						.getRadius()));
		logger.info("6.COMMACOUNT:"+8);
	}

	private static void firstOrNextPlanetoidAtmosphere(Atmosphere atmosphere){
		columns.get(Columns.s).add(SEPERATOR+atmosphere.getChem_name());
		columns.get(Columns.t).add(SEPERATOR+atmosphere.getPercentage().toString());
		logger.info("7.COMMACOUNT:"+2);
	}
	
	private static void firstOrNextMoonAtmosphere(Atmosphere atmosphere){
		columns.get(Columns.ab).add(SEPERATOR+atmosphere.getChem_name());
		columns.get(Columns.ac).add(SEPERATOR+atmosphere.getPercentage().toString());
		logger.info("8.COMMACOUNT:"+2);
	}

	private static void noSystem(){
		columns.get(Columns.a).add(SEPERATOR);
		logger.info("9.COMMACOUNT:"+1);
	}
	
	private static void noCluster(){
		columns.get(Columns.b).add(SEPERATOR);
		columns.get(Columns.c).add(SEPERATOR);
		columns.get(Columns.d).add(SEPERATOR);
		logger.info("10.COMMACOUNT:"+3);
	}

	
	private static void noStars(){
		columns.get(Columns.b).add(SEPERATOR);
		columns.get(Columns.c).add(SEPERATOR);
		columns.get(Columns.d).add(SEPERATOR);
		columns.get(Columns.e).add(SEPERATOR);
		columns.get(Columns.f).add(SEPERATOR);
		columns.get(Columns.g).add(SEPERATOR);
		columns.get(Columns.h).add(SEPERATOR);
		columns.get(Columns.i).add(SEPERATOR);
		columns.get(Columns.j).add(SEPERATOR);
		columns.get(Columns.k).add(SEPERATOR);
		logger.info("11.COMMACOUNT:"+7);
	}
	
	private static void noPlanets(){
		columns.get(Columns.l).add(SEPERATOR);
		columns.get(Columns.m).add(SEPERATOR);
		columns.get(Columns.n).add(SEPERATOR);
		columns.get(Columns.o).add(SEPERATOR);
		columns.get(Columns.p).add(SEPERATOR);
		columns.get(Columns.q).add(SEPERATOR);
		columns.get(Columns.r).add(SEPERATOR);
		logger.info("12.COMMACOUNT:"+7);
	}
	
	private static void noPlanetAtmosphere(){
		columns.get(Columns.s).add(SEPERATOR);
		columns.get(Columns.t).add(SEPERATOR);
		logger.info("13.COMMACOUNT:"+2);
	}
	
	private static void noMoons(){
		columns.get(Columns.u).add(SEPERATOR);
		columns.get(Columns.v).add(SEPERATOR);
		columns.get(Columns.w).add(SEPERATOR);
		columns.get(Columns.x).add(SEPERATOR);
		columns.get(Columns.y).add(SEPERATOR);
		columns.get(Columns.z).add(SEPERATOR);
		columns.get(Columns.aa).add(SEPERATOR);
		logger.info("14.COMMACOUNT:"+7);
	}
	
	private static void noMoonsAndNoMoonAtmosphere(){
		columns.get(Columns.u).add(BLANK);
		columns.get(Columns.v).add(SEPERATOR);
		columns.get(Columns.w).add(SEPERATOR);
		columns.get(Columns.x).add(SEPERATOR);
		columns.get(Columns.y).add(SEPERATOR);
		columns.get(Columns.z).add(SEPERATOR);
		columns.get(Columns.aa).add(SEPERATOR);
		columns.get(Columns.ab).add(SEPERATOR);
		columns.get(Columns.ac).add(BLANK); 
		logger.info("14.5.COMMACOUNT:"+7);
	}

	private static void noMoonAtmosphere(){
		columns.get(Columns.ab).add(SEPERATOR);
//		columns.get(Columns.ac).add(SEPERATOR);  
		columns.get(Columns.ac).add(BLANK); 
		logger.info("15.COMMACOUNT:"+2);		
	}
	
	private static void starBlankLine(){
		columns.get(Columns.a).add(BLANK);
		columns.get(Columns.b).add(SEPERATOR);
		columns.get(Columns.c).add(SEPERATOR);
		columns.get(Columns.d).add(SEPERATOR);	
		logger.info("16.COMMACOUNT:"+3);

	}
	
	private static void planetAtmosphereBlankLine(){
		columns.get(Columns.a).add(BLANK);
		columns.get(Columns.b).add(SEPERATOR);
		columns.get(Columns.c).add(SEPERATOR);
		columns.get(Columns.d).add(SEPERATOR);
		columns.get(Columns.e).add(SEPERATOR);
		columns.get(Columns.f).add(SEPERATOR);
		columns.get(Columns.g).add(SEPERATOR);
		columns.get(Columns.h).add(SEPERATOR);
		columns.get(Columns.i).add(SEPERATOR);
		columns.get(Columns.j).add(SEPERATOR);
		columns.get(Columns.k).add(SEPERATOR);
		columns.get(Columns.l).add(SEPERATOR);
		columns.get(Columns.m).add(SEPERATOR);
		columns.get(Columns.n).add(SEPERATOR);
		columns.get(Columns.o).add(SEPERATOR);
		columns.get(Columns.p).add(SEPERATOR);
		columns.get(Columns.q).add(SEPERATOR);
		columns.get(Columns.r).add(SEPERATOR);
		logger.info("17.COMMACOUNT:"+18);
	}
	
	private static void moonAtmosphereBlankLine(){
		columns.get(Columns.a).add(BLANK);
		columns.get(Columns.b).add(SEPERATOR);
		columns.get(Columns.c).add(SEPERATOR);
		columns.get(Columns.d).add(SEPERATOR);
		columns.get(Columns.e).add(SEPERATOR);
		columns.get(Columns.f).add(SEPERATOR);
		columns.get(Columns.g).add(SEPERATOR);
		columns.get(Columns.h).add(SEPERATOR);
		columns.get(Columns.i).add(SEPERATOR);
		columns.get(Columns.j).add(SEPERATOR);
		columns.get(Columns.k).add(SEPERATOR);
		columns.get(Columns.l).add(SEPERATOR);
		columns.get(Columns.m).add(SEPERATOR);
		columns.get(Columns.n).add(SEPERATOR);
		columns.get(Columns.o).add(SEPERATOR);
		columns.get(Columns.p).add(SEPERATOR);
		columns.get(Columns.q).add(SEPERATOR);
		columns.get(Columns.r).add(SEPERATOR);
		columns.get(Columns.s).add(SEPERATOR);
		columns.get(Columns.t).add(SEPERATOR);
		columns.get(Columns.u).add(SEPERATOR);
		columns.get(Columns.v).add(SEPERATOR);
		columns.get(Columns.w).add(SEPERATOR);
		columns.get(Columns.x).add(SEPERATOR);
		columns.get(Columns.y).add(SEPERATOR);
		columns.get(Columns.z).add(SEPERATOR);
		columns.get(Columns.aa).add(SEPERATOR);

		logger.info("18.COMMACOUNT:"+26);
	}
	
	private static void planetBlankLine(){
		columns.get(Columns.a).add(BLANK);
		columns.get(Columns.b).add(SEPERATOR);
		columns.get(Columns.c).add(SEPERATOR);
		columns.get(Columns.d).add(SEPERATOR);
		columns.get(Columns.e).add(SEPERATOR);
		columns.get(Columns.f).add(SEPERATOR);
		columns.get(Columns.g).add(SEPERATOR);
		columns.get(Columns.h).add(SEPERATOR);
		columns.get(Columns.i).add(SEPERATOR);
		columns.get(Columns.j).add(SEPERATOR);
		columns.get(Columns.k).add(SEPERATOR);
		logger.info("19.COMMACOUNT:"+11);
	}

	private static void moonBlankLine(){
		columns.get(Columns.a).add(BLANK);
		columns.get(Columns.b).add(SEPERATOR);
		columns.get(Columns.c).add(SEPERATOR);
		columns.get(Columns.d).add(SEPERATOR);
		columns.get(Columns.e).add(SEPERATOR);
		columns.get(Columns.f).add(SEPERATOR);
		columns.get(Columns.g).add(SEPERATOR);
		columns.get(Columns.h).add(SEPERATOR);
		columns.get(Columns.i).add(SEPERATOR);
		columns.get(Columns.j).add(SEPERATOR);
		columns.get(Columns.k).add(SEPERATOR);
		columns.get(Columns.l).add(SEPERATOR);
		columns.get(Columns.m).add(SEPERATOR);
		columns.get(Columns.n).add(SEPERATOR);
		columns.get(Columns.o).add(SEPERATOR);
		columns.get(Columns.p).add(SEPERATOR);
		columns.get(Columns.q).add(SEPERATOR);
		columns.get(Columns.r).add(SEPERATOR);
		columns.get(Columns.s).add(SEPERATOR);
		columns.get(Columns.t).add(SEPERATOR);
//		columns.get(Columns.u).add(SEPERATOR);
		logger.info("20.COMMACOUNT:"+19);
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
			if(currentUs.size() == 0 || currentVs.size() == 0){
				break;
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
		Collections.sort(sectors);
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
		String reportDirectory = new ConfigurationDao().reportDirectory();
		String csv_file = reportDirectory + File.separator + s_Ucoordinate_top+"_"+s_Ucoordinate_bottom+"_"+s_Vcoordinate_top+"_"+s_Vcoordinate_bottom+".csv";
		StringBuilder keyValuePair = new StringBuilder();
		int lineCount= 0;

		SystemDao systemDao = new SystemDao();
		System system = null;
		initColumns();
		
		
		Integer i_Utop = new Integer(s_Ucoordinate_top);
		Integer i_Vtop = new Integer(s_Vcoordinate_top);
		Integer i_Ubot = new Integer(s_Ucoordinate_bottom);
		Integer i_Vbot = new Integer(s_Vcoordinate_bottom);
		
		for(int idex = i_Utop ; idex <= i_Ubot; idex++){
			
			for(int idex2 = i_Vtop; idex2 <= i_Vbot; idex2++){
				logger.info("U:"+idex+" V:"+idex2);
				if(!systemDao.doesSystemExist(new Double(idex), new Double(idex2))){
					logger.warn("U:"+idex+" V:"+idex2+" Does Not Exist");
					break;
				}
				system = systemDao.readSystemByUVCoordinates(idex, idex2);
				genASystem(system);

				if(ExistingSystemWithStars.areThereStars(system)){
					ClusterRep clusterRep = ExistingSystemWithStars.readCluster(system);
					genClusterAndStars(clusterRep);
					List<Star> stars = ExistingSystemWithStars.readStarsInCluster(clusterRep);
					int numStars = stars.size();
					oneStar(stars.get(0));
					for(int idexStars = 1; idexStars < numStars; idexStars++){
						starBlankLine();
						oneStar(stars.get(idexStars));
					}
				}
				else{
					noStars();
					noPlanets();
					noPlanetAtmosphere();
					noMoons();
					noMoonAtmosphere();
				}
				audit("EndSystem:");
				++lineCount;
			}
			
		}
		int linecount = Integer.MAX_VALUE;
		logger.info("A SIZE:"+columns.get(Columns.a).size());
		if(columns.get(Columns.a).size() < linecount){
			linecount = columns.get(Columns.a).size();
		}
		logger.info("B SIZE:"+columns.get(Columns.b).size());
		if(columns.get(Columns.b).size() < linecount){
			linecount = columns.get(Columns.b).size();
		}
		logger.info("C SIZE:"+columns.get(Columns.c).size());
		if(columns.get(Columns.c).size() < linecount){
			linecount = columns.get(Columns.c).size();
		}
		logger.info("D SIZE:"+columns.get(Columns.d).size());
		if(columns.get(Columns.d).size() < linecount){
			linecount = columns.get(Columns.d).size();
		}
		logger.info("E SIZE:"+columns.get(Columns.e).size());
		if(columns.get(Columns.e).size() < linecount){
			linecount = columns.get(Columns.e).size();
		}
		logger.info("F SIZE:"+columns.get(Columns.f).size());
		if(columns.get(Columns.f).size() < linecount){
			linecount = columns.get(Columns.f).size();
		}
		logger.info("G SIZE:"+columns.get(Columns.g).size());
		if(columns.get(Columns.g).size() < linecount){
			linecount = columns.get(Columns.g).size();
		}
		logger.info("H SIZE:"+columns.get(Columns.h).size());
		if(columns.get(Columns.h).size() < linecount){
			linecount = columns.get(Columns.h).size();
		}
		logger.info("I SIZE:"+columns.get(Columns.i).size());
		if(columns.get(Columns.i).size() < linecount){
			linecount = columns.get(Columns.i).size();
		}
		logger.info("J SIZE:"+columns.get(Columns.j).size());
		if(columns.get(Columns.j).size() < linecount){
			linecount = columns.get(Columns.j).size();
		}
		logger.info("K SIZE:"+columns.get(Columns.k).size());
		if(columns.get(Columns.k).size() < linecount){
			linecount = columns.get(Columns.k).size();
		}
		logger.info("L SIZE:"+columns.get(Columns.l).size());
		if(columns.get(Columns.l).size() < linecount){
			linecount = columns.get(Columns.l).size();
		}
		logger.info("M SIZE:"+columns.get(Columns.m).size());
		if(columns.get(Columns.m).size() < linecount){
			linecount = columns.get(Columns.m).size();
		}
		logger.info("N SIZE:"+columns.get(Columns.n).size());
		if(columns.get(Columns.n).size() < linecount){
			linecount = columns.get(Columns.n).size();
		}
		logger.info("O SIZE:"+columns.get(Columns.o).size());
		if(columns.get(Columns.o).size() < linecount){
			linecount = columns.get(Columns.o).size();
		}
		logger.info("P SIZE:"+columns.get(Columns.p).size());
		if(columns.get(Columns.p).size() < linecount){
			linecount = columns.get(Columns.p).size();
		}
		logger.info("Q SIZE:"+columns.get(Columns.q).size());
		if(columns.get(Columns.q).size() < linecount){
			linecount = columns.get(Columns.q).size();
		}
		logger.info("R SIZE:"+columns.get(Columns.r).size());
		if(columns.get(Columns.r).size() < linecount){
			linecount = columns.get(Columns.r).size();
		}
		logger.info("S SIZE:"+columns.get(Columns.s).size());
		if(columns.get(Columns.s).size() < linecount){
			linecount = columns.get(Columns.s).size();
		}
		logger.info("T SIZE:"+columns.get(Columns.t).size());
		if(columns.get(Columns.t).size() < linecount){
			linecount = columns.get(Columns.t).size();
		}
		logger.info("U SIZE:"+columns.get(Columns.u).size());
		if(columns.get(Columns.u).size() < linecount){
			linecount = columns.get(Columns.u).size();
		}
		logger.info("V SIZE:"+columns.get(Columns.v).size());
		if(columns.get(Columns.v).size() < linecount){
			linecount = columns.get(Columns.v).size();
		}
		logger.info("W SIZE:"+columns.get(Columns.w).size());
		if(columns.get(Columns.w).size() < linecount){
			linecount = columns.get(Columns.w).size();
		}
		logger.info("X SIZE:"+columns.get(Columns.x).size());
		if(columns.get(Columns.x).size() < linecount){
			linecount = columns.get(Columns.x).size();
		}
		logger.info("Y SIZE:"+columns.get(Columns.y).size());
		if(columns.get(Columns.y).size() < linecount){
			linecount = columns.get(Columns.y).size();
		}
		logger.info("Z SIZE:"+columns.get(Columns.z).size());
		if(columns.get(Columns.z).size() < linecount){
			linecount = columns.get(Columns.z).size();
		}
		logger.info("AA SIZE:"+columns.get(Columns.aa).size());
		if(columns.get(Columns.aa).size() < linecount){
			linecount = columns.get(Columns.aa).size();
		}
		logger.info("AB SIZE:"+columns.get(Columns.ab).size());
		if(columns.get(Columns.ab).size() < linecount){
			linecount = columns.get(Columns.ab).size();
		}
		logger.info("AC SIZE:"+columns.get(Columns.ac).size());
		if(columns.get(Columns.ac).size() < linecount){
			linecount = columns.get(Columns.ac).size();
		}

		keyValuePair.append(buildAndWriteReport(linecount, csv_file));
		SectorsResponse sectorsResponse = new SectorsResponse();
		sectorsResponse.setSectors(keyValuePair.toString());
		return sectorsResponse;
	}
	
	private static String buildAndWriteReport(int lineCount, String csv_file){
		StringBuilder fileContents = new StringBuilder();
		for (int idex = 0; idex < lineCount; idex++){
			fileContents.append(columns.get(Columns.a).get(idex))
			.append(columns.get(Columns.b).get(idex))
			.append(columns.get(Columns.c).get(idex))
			.append(columns.get(Columns.d).get(idex))
			.append(columns.get(Columns.e).get(idex))
			.append(columns.get(Columns.f).get(idex))
			.append(columns.get(Columns.g).get(idex))
			.append(columns.get(Columns.h).get(idex))
			.append(columns.get(Columns.i).get(idex))
			.append(columns.get(Columns.j).get(idex))
			.append(columns.get(Columns.k).get(idex))
			.append(columns.get(Columns.l).get(idex))
			.append(columns.get(Columns.m).get(idex))
			.append(columns.get(Columns.n).get(idex))
			.append(columns.get(Columns.o).get(idex))
			.append(columns.get(Columns.p).get(idex))
			.append(columns.get(Columns.q).get(idex))
			.append(columns.get(Columns.r).get(idex))
			.append(columns.get(Columns.s).get(idex))
			.append(columns.get(Columns.t).get(idex))
			.append(columns.get(Columns.u).get(idex))
			.append(columns.get(Columns.v).get(idex))
			.append(columns.get(Columns.w).get(idex))
			.append(columns.get(Columns.x).get(idex))
			.append(columns.get(Columns.y).get(idex))
			.append(columns.get(Columns.z).get(idex))
			.append(columns.get(Columns.aa).get(idex))
			.append(columns.get(Columns.ab).get(idex))
			.append(columns.get(Columns.ac).get(idex))
			.append("\n");	// one row in csv file
			;
		}
		File file = new File(csv_file);
		try {
			FileUtils.writeStringToFile(file, fileContents.toString());
		} catch (IOException ioe) {
			ioe.printStackTrace();
			throw new RuntimeException("File IO Error:"+ioe.getMessage());
		}
		logger.info("WROTE file:"+file.getAbsolutePath()+file.getName());
		return file.getAbsolutePath()+file.getName();
	}
	
	/**
	 * 
	 * @param star
	 */
	private static void oneStar(Star star){
		firstOrNextStar(star);
		List<UnifiedPlanetoidI> unifiedPlanetoidIs = ExistingSystemWithStars.readPlanetsAroundStar(star);
		if(unifiedPlanetoidIs.isEmpty()){
			noPlanets();
			noPlanetAtmosphere();
			noMoons();
			noMoonAtmosphere();
			audit("NoPlanets:");
		}
		else{
			List<Atmosphere> atmospheres = null;
			for (int planetoidIndex = 0; planetoidIndex < unifiedPlanetoidIs.size(); planetoidIndex++){
				if(planetoidIndex != 0){
					planetBlankLine();
					audit("PlanetNthLine:");
				}
				firstOrNextPlanetoid(unifiedPlanetoidIs.get(planetoidIndex));
				audit("PlanetMain:");
				atmospheres = ExistingSystemWithStars.readPlanarsAtmosphere(unifiedPlanetoidIs.get(planetoidIndex).getPlanetoid());
				fillPlanetAtmospheres(atmospheres);
				audit("PlanetAtmosphere:");
				List<UnifiedPlanetoidI> unifiedMoonsIs = ExistingSystemWithStars.readMoonsAroundPlanet(unifiedPlanetoidIs.get(planetoidIndex).getPlanetoid());
				for(int moonIdex = 0; moonIdex < unifiedMoonsIs.size(); moonIdex++){
					moonOrNoMoons(unifiedMoonsIs, moonIdex);
					audit("MoonMain:");
				}
			}
		}
	}
	
	/**
	 * 
	 * @param unifiedMoonsIs
	 * @param idex
	 */
	private static void moonOrNoMoons(List<UnifiedPlanetoidI> unifiedMoonsIs, int idex){
		if(unifiedMoonsIs.isEmpty()){
			noMoonsAndNoMoonAtmosphere();
			audit("NoMoons:");
		}
		else{
			moonBlankLine();
			firstOrNextMoon(unifiedMoonsIs.get(idex));
			audit("NthMoon:");
			List<Atmosphere> moonAtmospheres = ExistingSystemWithStars.readPlanarsAtmosphere(unifiedMoonsIs.get(idex).getPlanetoid());
			fillMoonAtmospheres(moonAtmospheres);
			audit("MoonAmosphere:");
		}
		
	}
	
	/**
	 * 
	 * @param atmospheres
	 */
	private static void fillPlanetAtmospheres(List<Atmosphere> atmospheres) {
		for (int atmosIndex = 0; atmosIndex < atmospheres.size(); atmosIndex++) {
			if (atmosIndex != 0) {
				planetAtmosphereBlankLine();
				audit("NthPlanetAtmosphere:");
			}
			firstOrNextPlanetoidAtmosphere(atmospheres.get(atmosIndex));
			audit("planetAtmosphereMain:");
			noMoonsAndNoMoonAtmosphere();
			audit("MoonMain:");
		}
	}
	
	/**
	 * 
	 * @param atmospheresq
	 */
	private static void fillMoonAtmospheres(List<Atmosphere> atmospheres) {
		for (int atmosIndex = 0; atmosIndex < atmospheres.size(); atmosIndex++) {
			if (atmosIndex != 0) {
				moonAtmosphereBlankLine();
				audit("NthMoonAtmosphere:");
			}
			firstOrNextMoonAtmosphere(atmospheres.get(atmosIndex));
			audit("MoonAtmosphereMain:");
		}
	}
	
	private static void audit(String prefix){
		logger.info(prefix+"Audit_A SIZE:"+columns.get(Columns.a).size());
		logger.info(prefix+"Audit_B SIZE:"+columns.get(Columns.b).size());
		logger.info(prefix+"Audit_C SIZE:"+columns.get(Columns.c).size());
		logger.info(prefix+"Audit_D SIZE:"+columns.get(Columns.d).size());
		logger.info(prefix+"Audit_E SIZE:"+columns.get(Columns.e).size());
		logger.info(prefix+"Audit_F SIZE:"+columns.get(Columns.f).size());
		logger.info(prefix+"Audit_G SIZE:"+columns.get(Columns.g).size());
		logger.info(prefix+"Audit_H SIZE:"+columns.get(Columns.h).size());
		logger.info(prefix+"Audit_I SIZE:"+columns.get(Columns.i).size());
		logger.info(prefix+"Audit_J SIZE:"+columns.get(Columns.j).size());
		logger.info(prefix+"Audit_K SIZE:"+columns.get(Columns.k).size());
		logger.info(prefix+"Audit_L SIZE:"+columns.get(Columns.l).size());
		logger.info(prefix+"Audit_M SIZE:"+columns.get(Columns.m).size());
		logger.info(prefix+"Audit_N SIZE:"+columns.get(Columns.n).size());
		logger.info(prefix+"Audit_O SIZE:"+columns.get(Columns.o).size());
		logger.info(prefix+"Audit_P SIZE:"+columns.get(Columns.p).size());
		logger.info(prefix+"Audit_Q SIZE:"+columns.get(Columns.q).size());
		logger.info(prefix+"Audit_R SIZE:"+columns.get(Columns.r).size());
		logger.info(prefix+"Audit_S SIZE:"+columns.get(Columns.s).size());
		logger.info(prefix+"Audit_T SIZE:"+columns.get(Columns.t).size());
		logger.info(prefix+"Audit_U SIZE:"+columns.get(Columns.u).size());
		logger.info(prefix+"Audit_V SIZE:"+columns.get(Columns.v).size());
		logger.info(prefix+"Audit_W SIZE:"+columns.get(Columns.w).size());
		logger.info(prefix+"Audit_X SIZE:"+columns.get(Columns.x).size());
		logger.info(prefix+"Audit_Y SIZE:"+columns.get(Columns.y).size());
		logger.info(prefix+"Audit_Z SIZE:"+columns.get(Columns.z).size());
		logger.info(prefix+"Audit_AA SIZE:"+columns.get(Columns.aa).size());
		logger.info(prefix+"Audit_AB SIZE:"+columns.get(Columns.ab).size());
		logger.info(prefix+"Audit_AC SIZE:"+columns.get(Columns.ac).size());
	}

	/**
	 * 
	 * @param system
	 */
	private static void genASystem(System system){
		systemName(system.getSystemName());
	}
	
	/**
	 * 
	 * @param clusterRep
	 */
	private static void genClusterAndStars(ClusterRep clusterRep){
		clusterName(clusterRep.getClusterName(), clusterRep.getCluster_description());
	}
}
