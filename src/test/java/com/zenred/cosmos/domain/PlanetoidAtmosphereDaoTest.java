package com.zenred.cosmos.domain;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

public class PlanetoidAtmosphereDaoTest {
	static private Logger logger = Logger.getLogger(PlanetoidAtmosphereDaoTest.class);
	private static System system;
	private static ClusterRep clusterRep;
	private static Star star;
	


	@Test
	public void test0() {
		Double ucoord = new Double(999999);
		Double vcoord = new Double(0);
		Double dist = new Double(999999);
		SystemDao systemDao = new SystemDao();
		ClusterRepDao clusterRepDao = new ClusterRepDao();
		StarDao starDao = new StarDao();
		PlanetoidDao planetoidDao = new PlanetoidDao();

		Integer singStar = new Integer(249);
		String type = ClusterFactory.evaluateChance(singStar);

		system = new System(null, dist, ucoord, vcoord, null);
		System.genSystemName(system);
		System systemRead = systemDao.addSystem(system);
		clusterRep = new ClusterRep(null, systemRead.getSystemId(),
				system.getSystemName() + "_CLUSTER", null, null, null, null);
		ClusterFactory.fromString(type).get().process(clusterRep);
		logger.info("CLUSTER_REP_0:" + clusterRep);
		ClusterRep clusterRepAdd = clusterRepDao.addClusterRep(clusterRep);
		ClusterRep clusterRepRead = clusterRepDao
				.readClusterRepById(clusterRepAdd.getClusterRepId());
		logger.info("CLUSTER_REP_READ:" + clusterRepRead);
		clusterRepRead.setClusterName("Tattooine_CLUSTER");
		ClusterRep clusterRepUpdate = clusterRepDao
				.updateClusterRepBySystemId(clusterRepRead);
		logger.info("CLUSTER_REP_UPDATE:" + clusterRepUpdate);
		
		Planetoid planetoid = new Planetoid(null, null,
				systemRead.getSystemName() + clusterRepRead.getClusterName()
						+ "_planetoid_0", new Double(9000), new Double(
						1200000.0), new Double(3.1416), new Double(24.0),
				new Double(.05), null);
		UnifiedPlanetoidI unifiedPlanetoidI =  planetoidDao.addClusterPlanetoid(planetoid, clusterRepUpdate);
		logger.info("PLANETOID_IN_CLUSTER:"+unifiedPlanetoidI);
		
		Atmosphere atmosphere = new Atmosphere(null, unifiedPlanetoidI.getPlanetoid().getPlanetoidId(), "Ammonia", new Double(50), null);
		AtmosphereDao atmosphereDao = new AtmosphereDao();
		Atmosphere atmosphere0 = atmosphereDao.addAtmosphere(atmosphere);
		
		logger.info("ATMOSPHERE_0:"+atmosphere0);
		
		atmosphere = new Atmosphere(null, unifiedPlanetoidI.getPlanetoid().getPlanetoidId(), "Water", new Double(1), null);
		Atmosphere atmosphere002 = atmosphereDao.addAtmosphere(atmosphere);
		
		logger.info("ATMOSPHERE_002:"+atmosphere002);

		
		atmosphere = new Atmosphere(null, unifiedPlanetoidI.getPlanetoid().getPlanetoidId(), "Ozone", new Double(30), null);
		Atmosphere atmosphere1 = atmosphereDao.addAtmosphere(atmosphere);
		
		logger.info("ATMOSPHERE_1:"+atmosphere1);
		
		atmosphere = new Atmosphere(null, unifiedPlanetoidI.getPlanetoid().getPlanetoidId(), "Nitrogen", new Double(19), null);
		Atmosphere atmosphere2 = atmosphereDao.addAtmosphere(atmosphere);
		
		logger.info("ATMOSPHERE_2:"+atmosphere2);
		
		List<PlanetoidColor> planetoidColors = PlanetoidColor.planarColors(unifiedPlanetoidI.getPlanetoid());
		logger.info("PLANETOID COLORS:"+planetoidColors);

		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_0",
				new Double(160), StarTypeFactory.genLuminsoity((short) 0,
						StarTypeFactory.m, StarFactory.RED__MAINS,
						StarFactory.redMainS.sequence()), null, new Double(2),
				StarFactory.RED__MAINS.read().read(), StarFactory.RED__MAINS
						.code().code(), StarTypeFactory.genMass((short) 0,
						StarTypeFactory.m, StarFactory.RED__MAINS,
						StarFactory.redMainS.sequence()), null);
		Star starAdd = starDao.addStar(star, clusterRepUpdate, SubClusterFactory.SINGLESTAR.name());
		logger.info("STAR_READ_0:"+starAdd);
		starAdd.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate = starDao.updateStarByStarId(starAdd);
		logger.info("STAR_UPDATE_0:"+starUpdate);
	

		Planetoid planetoidStar = new Planetoid(null, null,
				systemRead.getSystemName() + starUpdate.getName()
						+ "_planetoid_0", new Double(6000), new Double(
						1500000.0), new Double(3.1416 * 0.75),
				new Double(290.0), new Double(45.0), null);
		unifiedPlanetoidI = planetoidDao.addStarPlanetoid(planetoidStar,
				starUpdate);
		logger.info("PLANETOID_AROUND_STAR:" + unifiedPlanetoidI);
		
		atmosphere = new Atmosphere(null, unifiedPlanetoidI.getPlanetoid().getPlanetoidId(), "O", new Double(20), null);
		Atmosphere atmosphere01 = atmosphereDao.addAtmosphere(atmosphere);
		logger.info("ATMOSPHERE_01:"+atmosphere01);
		
		
		atmosphere = new Atmosphere(null, unifiedPlanetoidI.getPlanetoid().getPlanetoidId(), "N", new Double(80), null);
		Atmosphere atmosphere02 = atmosphereDao.addAtmosphere(atmosphere);
		logger.info("ATMOSPHERE_02:"+atmosphere02);
		
		Planetoid planetoidMoon0 = new Planetoid(null, null,
				systemRead.getSystemName() + planetoidStar.getPlanetoidName()
						+ "_moon_0", new Double(2000), new Double(17000.0),
				new Double(3.1416 * 1.25), new Double(290.0), new Double(0.1),
				null);
		unifiedPlanetoidI = planetoidDao.addPlanetoidPlanetoid(planetoidMoon0,
				unifiedPlanetoidI.getPlanetoid());
		logger.info("MOON 0:" + unifiedPlanetoidI);
		
		atmosphere = new Atmosphere(null, unifiedPlanetoidI.getPlanetoid().getPlanetoidId(), "CO2", new Double(.5), null);
		Atmosphere atmosphere3 = atmosphereDao.addAtmosphere(atmosphere);
		logger.info("ATMOSPHERE_3:"+atmosphere3);
		
		
		atmosphere = new Atmosphere(null, unifiedPlanetoidI.getPlanetoid().getPlanetoidId(), "TRACE", new Double(95.5), null);
		Atmosphere atmosphere4 = atmosphereDao.addAtmosphere(atmosphere);
		logger.info("ATMOSPHERE_4:"+atmosphere4);
		
		List<Atmosphere> atmospheres =  atmosphereDao.readAtmosphereAroundPlanet(unifiedPlanetoidI.getPlanetoid());
		logger.info("ATMOSPHERE_4_LIST:"+atmospheres);
		
		Planetoid planetoidMoon1 = new Planetoid(null, null,
				systemRead.getSystemName() + planetoidStar.getPlanetoidName()
						+ "_Phobos", new Double(1000), new Double(14000.0),
				new Double(3.1416 * 0.65), new Double(290.0), new Double(0.01),
				null);
		unifiedPlanetoidI = planetoidDao.addPlanetoidPlanetoid(planetoidMoon1,
				unifiedPlanetoidI.getPlanetoid());
		logger.info("MOON 1:" + unifiedPlanetoidI);

		atmosphere = new Atmosphere(null, unifiedPlanetoidI.getPlanetoid().getPlanetoidId(), "TRACE", new Double(100.0), null);
		Atmosphere atmosphere5 = atmosphereDao.addAtmosphere(atmosphere);
		logger.info("ATMOSPHERE_5:"+atmosphere5);

		atmosphereDao.deleteAtmosphere(atmosphere0);
		atmosphereDao.deleteAtmosphere(atmosphere1);
		atmosphereDao.deleteAtmosphere(atmosphere2);
		atmosphereDao.deleteAtmosphere(atmosphere3);
		atmosphereDao.deleteAtmosphere(atmosphere4);
		atmosphereDao.deleteAtmosphere(atmosphere5);
		
		planetoidDao.deletePlanetoid(planetoidMoon0);
		planetoidDao.deletePlanetoid(planetoidMoon1);
		planetoidDao.deletePlanetoid(planetoidStar);		
		planetoidDao.deletePlanetoid(planetoid);
		starDao.deleteStar(starUpdate);
		clusterRepDao.deleteClusterRep(clusterRepUpdate);
		systemDao.deleteSystem(systemRead);
	}

}
