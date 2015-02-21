package com.zenred.cosmos.domain;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

public class PlanetoidDaoTest {
	static private Logger logger = Logger.getLogger(PlanetoidDaoTest.class);
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

		Planetoid planetoidMoon0 = new Planetoid(null, null,
				systemRead.getSystemName() + planetoidStar.getPlanetoidName()
						+ "_moon_0", new Double(2000), new Double(17000.0),
				new Double(3.1416 * 1.25), new Double(290.0), new Double(0.1),
				null);
		unifiedPlanetoidI = planetoidDao.addPlanetoidPlanetoid(planetoidMoon0,
				unifiedPlanetoidI.getPlanetoid());
		logger.info("MOON 0:" + unifiedPlanetoidI);

		Planetoid planetoidMoon1 = new Planetoid(null, null,
				systemRead.getSystemName() + planetoidStar.getPlanetoidName()
						+ "_Phobos", new Double(1000), new Double(14000.0),
				new Double(3.1416 * 0.65), new Double(290.0), new Double(0.01),
				null);
		unifiedPlanetoidI = planetoidDao.addPlanetoidPlanetoid(planetoidMoon1,
				unifiedPlanetoidI.getPlanetoid());
		logger.info("MOON 1:" + unifiedPlanetoidI);

		planetoidDao.deletePlanetoid(planetoidMoon0);
		planetoidDao.deletePlanetoid(planetoidMoon1);
		planetoidDao.deletePlanetoid(planetoidStar);		
		planetoidDao.deletePlanetoid(planetoid);
		starDao.deleteStar(starUpdate);
		clusterRepDao.deleteClusterRep(clusterRepUpdate);
		systemDao.deleteSystem(systemRead);
	}

}
