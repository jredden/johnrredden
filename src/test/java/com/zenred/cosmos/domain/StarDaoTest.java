package com.zenred.cosmos.domain;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

public class StarDaoTest {

	static private Logger logger = Logger.getLogger(StarDaoTest.class);
	private static System system;
	private static ClusterRep clusterRep;
	private static Star star;
	

	@Test
	public void testCRUD_0() {

		Double ucoord = new Double(999999);
		Double vcoord = new Double(0);
		Double dist = new Double(999999);
		SystemDao systemDao = new SystemDao();
		ClusterRepDao clusterRepDao = new ClusterRepDao();
		StarDao starDao = new StarDao();

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
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_0",
				new Double(160), new Double(1), null, new Double(2), StarFactory.RED__MAINS.read().read(),
				StarFactory.RED__MAINS.code().code(), new Double(7000), null);
		Star starAdd = starDao.addStar(star, clusterRepUpdate, SubClusterFactory.SINGLESTAR.name());
		logger.info("STAR_READ_0:"+starAdd);
		starAdd.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate = starDao.updateStarByStarId(starAdd);
		logger.info("STAR_UPDATE_0:"+starUpdate);
		
		starDao.deleteStar(starUpdate);
		clusterRepDao.deleteClusterRep(clusterRepUpdate);
		systemDao.deleteSystem(systemRead);
	}

	@Test
	public void testCRUD_1() {

		Double ucoord = new Double(999999);
		Double vcoord = new Double(0);
		Double dist = new Double(999999);
		SystemDao systemDao = new SystemDao();
		ClusterRepDao clusterRepDao = new ClusterRepDao();
		StarDao starDao = new StarDao();

		Integer singStar = new Integer(251);
		String type = ClusterFactory.evaluateChance(singStar);

		system = new System(null, dist, ucoord, vcoord, null);
		System.genSystemName(system);
		System systemRead = systemDao.addSystem(system);
		clusterRep = new ClusterRep(null, systemRead.getSystemId(),
				system.getSystemName() + "_CLUSTER", null, null, null, null);
		ClusterFactory.fromString(type).get().process(clusterRep);
		logger.info("CLUSTER_REP_1:" + clusterRep);
		ClusterRep clusterRepAdd = clusterRepDao.addClusterRep(clusterRep);
		ClusterRep clusterRepRead = clusterRepDao
				.readClusterRepById(clusterRepAdd.getClusterRepId());
		logger.info("CLUSTER_REP_READ_1:" + clusterRepRead);
		clusterRepRead.setClusterName("Tattooine2_CLUSTER");
		ClusterRep clusterRepUpdate = clusterRepDao
				.updateClusterRepBySystemId(clusterRepRead);
		logger.info("CLUSTER_REP_UPDATE_1:" + clusterRepUpdate);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_1",
				new Double(161), new Double(1), null, new Double(2), "red",
				"m2", new Double(7001), null);
		Star starAdd = starDao.addStar(star, clusterRepUpdate, SubClusterFactory.DOUBLESTAR_BINARY_0.name());
		logger.info("STAR_READ_1:"+starAdd);
		starAdd.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate = starDao.updateStarByStarId(starAdd);
		logger.info("STAR_UPDATE_1:"+starUpdate);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_2",
				new Double(161), new Double(1), null, new Double(2), "red",
				"m3", new Double(7002), null);
		Star starAdd2 = starDao.addStar(star, clusterRepUpdate, SubClusterFactory.DOUBLESTAR_BINARY_1.name());
		logger.info("STAR_READ_2:"+starAdd2);
		starAdd2.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate2 = starDao.updateStarByStarId(starAdd2);
		logger.info("STAR_UPDATE_2:"+starUpdate2);
		
		List<Star> starList = starDao.readStarsInCluster(clusterRepUpdate);
		short count = 0;
		for (Star star: starList){
			logger.info("STAR"+count+":" + star);
			++count;
		}
		String s_type  = starDao.readStarsSubClusterDescription(starUpdate2);
		logger.info("STAR_SUB_CLUSTER_DESCRIPTION:"+s_type);

		starDao.deleteStar(starUpdate);
		starDao.deleteStar(starUpdate2);
			
		clusterRepDao.deleteClusterRep(clusterRepUpdate);
		systemDao.deleteSystem(systemRead);
	}

	@Test
	public void testCRUD_2() {

		Double ucoord = new Double(999999);
		Double vcoord = new Double(0);
		Double dist = new Double(999999);
		SystemDao systemDao = new SystemDao();
		ClusterRepDao clusterRepDao = new ClusterRepDao();
		StarDao starDao = new StarDao();

		Integer singStar = new Integer(603);
		String type = ClusterFactory.evaluateChance(singStar);

		system = new System(null, dist, ucoord, vcoord, null);
		System.genSystemName(system);
		System systemRead = systemDao.addSystem(system);
		clusterRep = new ClusterRep(null, systemRead.getSystemId(),
				system.getSystemName() + "_CLUSTER", null, null, null, null);
		ClusterFactory.fromString(type).get().process(clusterRep);
		logger.info("CLUSTER_REP_2:" + clusterRep);
		ClusterRep clusterRepAdd = clusterRepDao.addClusterRep(clusterRep);
		ClusterRep clusterRepRead = clusterRepDao
				.readClusterRepById(clusterRepAdd.getClusterRepId());
		logger.info("CLUSTER_REP_READ_2:" + clusterRepRead);
		clusterRepRead.setClusterName("Tattooine3_CLUSTER");
		ClusterRep clusterRepUpdate = clusterRepDao
				.updateClusterRepBySystemId(clusterRepRead);
		logger.info("CLUSTER_REP_UPDATE_2:" + clusterRepUpdate);
		clusterRepDao.deleteClusterRep(clusterRepUpdate);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_3",
				new Double(162), new Double(1), null, new Double(2), "red",
				"m4", new Double(7003), null);
		Star starAdd = starDao.addStar(star, clusterRepUpdate, SubClusterFactory.NONE.name());
		logger.info("STAR_READ_3:"+starAdd);
		starAdd.setNo_planets_allowed(Boolean.FALSE);
		Star starUpdate = starDao.updateStarByStarId(starAdd);
		logger.info("STAR_UPDATE_3:"+starUpdate);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_4",
				new Double(162), new Double(1), null, new Double(3), "red",
				"m4", new Double(7003), null);
		Star starAdd2 = starDao.addStarToNonSubCluster(star, star.getClusterToStarId());
		logger.info("STAR_READ_4:"+starAdd2);
		starAdd2.setNo_planets_allowed(Boolean.FALSE);
		Star starUpdate2 = starDao.updateStarByStarId(starAdd2);
		logger.info("STAR_UPDATE_4:"+starUpdate2);
		
		starDao.deleteStar(starUpdate);
		starDao.deleteStar(starUpdate2);
		clusterRepDao.deleteClusterRep(clusterRepUpdate);
		systemDao.deleteSystem(systemRead);
	}

	@Test
	public void testCRUD_3() {

		Double ucoord = new Double(999999);
		Double vcoord = new Double(0);
		Double dist = new Double(999999);
		SystemDao systemDao = new SystemDao();
		ClusterRepDao clusterRepDao = new ClusterRepDao();
		StarDao starDao = new StarDao();

		Integer singStar = new Integer(702);
		String type = ClusterFactory.evaluateChance(singStar);
		logger.info("TYPE:"+type);
		system = new System(null, dist, ucoord, vcoord, null);
		System.genSystemName(system);
		System systemRead = systemDao.addSystem(system);
		clusterRep = new ClusterRep(null, systemRead.getSystemId(),
				system.getSystemName() + "_CLUSTER", null, null, null, null);
		logger.info("CLUSTER_REP:"+type);
		ClusterFactory.fromString(type).get().process(clusterRep);
		logger.info("CLUSTER_REP_3:" + clusterRep);
		ClusterRep clusterRepAdd = clusterRepDao.addClusterRep(clusterRep);
		ClusterRep clusterRepRead = clusterRepDao
				.readClusterRepById(clusterRepAdd.getClusterRepId());
		logger.info("CLUSTER_REP_READ_3:" + clusterRepRead);
		clusterRepRead.setClusterName("Tattooine4_CLUSTER");
		ClusterRep clusterRepUpdate = clusterRepDao
				.updateClusterRepBySystemId(clusterRepRead);
		logger.info("CLUSTER_REP_UPDATE_3:" + clusterRepUpdate);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_5",
				new Double(163), new Double(1), null, new Double(2), "red",
				"m5", new Double(7004), null);
		Star starAdd = starDao.addStar(star, clusterRepUpdate, SubClusterFactory.THREESTAR_TRINARY_0.name());
		logger.info("STAR_READ_5:"+starAdd);
		starAdd.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate = starDao.updateStarByStarId(starAdd);
		logger.info("STAR_UPDATE_5:"+starUpdate);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_6",
				new Double(164), new Double(1), null, new Double(3), "red",
				"m6", new Double(7005), null);
		Star starAdd2 = starDao.addStar(star, clusterRepUpdate, SubClusterFactory.THREESTAR_TRINARY_1.name());
		logger.info("STAR_READ_6:"+starAdd2);
		starAdd2.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate2 = starDao.updateStarByStarId(starAdd2);
		logger.info("STAR_UPDATE_6:"+starUpdate2);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_7",
				new Double(165), new Double(1), null, new Double(3.5), "red",
				"m7", new Double(7006), null);
		Star starAdd3 = starDao.addStar(star, clusterRepUpdate, SubClusterFactory.THREESTAR_TRINARY_2.name());
		logger.info("STAR_READ_7:"+starAdd3);
		starAdd3.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate3 = starDao.updateStarByStarId(starAdd3);
		logger.info("STAR_UPDATE_7:"+starUpdate3);

		starDao.deleteStar(starUpdate);
		starDao.deleteStar(starUpdate2);
		starDao.deleteStar(starUpdate3);
		
		clusterRepDao.deleteClusterRep(clusterRepUpdate);
		systemDao.deleteSystem(systemRead);
	}

	@Test
	public void testCRUD_4() {

		Double ucoord = new Double(999999);
		Double vcoord = new Double(0);
		Double dist = new Double(999999);
		SystemDao systemDao = new SystemDao();
		ClusterRepDao clusterRepDao = new ClusterRepDao();
		StarDao starDao = new StarDao();

		Integer singStar = new Integer(825);
		String type = ClusterFactory.evaluateChance(singStar);
		logger.info("TYPE:"+type);
		system = new System(null, dist, ucoord, vcoord, null);
		System.genSystemName(system);
		System systemRead = systemDao.addSystem(system);
		clusterRep = new ClusterRep(null, systemRead.getSystemId(),
				system.getSystemName() + "_CLUSTER", null, null, null, null);
		logger.info("CLUSTER_REP:"+type);
		ClusterFactory.fromString(type).get().process(clusterRep);
		logger.info("CLUSTER_REP_4:" + clusterRep);
		ClusterRep clusterRepAdd = clusterRepDao.addClusterRep(clusterRep);
		ClusterRep clusterRepRead = clusterRepDao
				.readClusterRepById(clusterRepAdd.getClusterRepId());
		logger.info("CLUSTER_REP_READ_4:" + clusterRepRead);
		clusterRepRead.setClusterName("Tattooine4_CLUSTER");
		ClusterRep clusterRepUpdate = clusterRepDao
				.updateClusterRepBySystemId(clusterRepRead);
		logger.info("CLUSTER_REP_UPDATE_4:" + clusterRepUpdate);

		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_8",
				new Double(160), new Double(1), null, new Double(2), "red",
				"m8", new Double(7007), null);
		Star starAdd = starDao.addStar(star, clusterRepUpdate, SubClusterFactory.THREESTAR_BINARYPLUSONE.name());
		logger.info("STAR_READ_8:"+starAdd);
		starAdd.setNo_planets_allowed(Boolean.FALSE);
		Star starUpdate = starDao.updateStarByStarId(starAdd);
		logger.info("STAR_UPDATE_8:"+starUpdate);

		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_25x",
				new Double(295), new Double(1), null, new Double(2), "red",
				"m6", new Double(7295), null);
		Star starAddx = starDao.addStar(star, clusterRepUpdate, SubClusterFactory.NONE.name());
		logger.info("STAR_READ_25:"+starAddx);
		starAddx.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdateX = starDao.updateStarByStarId(starAddx);
		logger.info("STAR_UPDATE_25:"+starUpdateX);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_26x",
				new Double(296), new Double(1), null, new Double(3), "red",
				"m7", new Double(7096), null);
		Star starAddx2 = starDao.addStarToNonSubCluster(star, starUpdateX.getClusterToStarId());
		logger.info("STAR_READ_26:"+starAddx2);
		starAddx2.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdateX2 = starDao.updateStarByStarId(starAddx2);
		logger.info("STAR_UPDATE_26:"+starUpdateX2);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_27x",
				new Double(297), new Double(1), null, new Double(3.5), "red",
				"m8", new Double(7097), null);
		Star starAddx3 = starDao.addStarToNonSubCluster(star, starUpdateX.getClusterToStarId());
		logger.info("STAR_READ_27:"+starAddx3);
		starAddx3.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdateX3 = starDao.updateStarByStarId(starAddx3);
		logger.info("STAR_UPDATE_27:"+starUpdateX3);

		starDao.deleteStar(starUpdate);
		starDao.deleteStar(starUpdateX);
		starDao.deleteStar(starUpdateX2);
		starDao.deleteStar(starUpdateX3);
		clusterRepDao.deleteClusterRep(clusterRepUpdate);
		systemDao.deleteSystem(systemRead);
	}

	@Test
	public void testCRUD_5() {

		Double ucoord = new Double(999999);
		Double vcoord = new Double(0);
		Double dist = new Double(999999);
		SystemDao systemDao = new SystemDao();
		ClusterRepDao clusterRepDao = new ClusterRepDao();
		StarDao starDao = new StarDao();

		Integer singStar = new Integer(826);
		String type = ClusterFactory.evaluateChance(singStar);
		logger.info("TYPE:"+type);
		system = new System(null, dist, ucoord, vcoord, null);
		System.genSystemName(system);
		System systemRead = systemDao.addSystem(system);
		clusterRep = new ClusterRep(null, systemRead.getSystemId(),
				system.getSystemName() + "_CLUSTER", null, null, null, null);
		logger.info("CLUSTER_REP:"+type);
		ClusterFactory.fromString(type).get().process(clusterRep);
		logger.info("CLUSTER_REP_5:" + clusterRep);
		ClusterRep clusterRepAdd = clusterRepDao.addClusterRep(clusterRep);
		ClusterRep clusterRepRead = clusterRepDao
				.readClusterRepById(clusterRepAdd.getClusterRepId());
		logger.info("CLUSTER_REP_READ_5:" + clusterRepRead);
		clusterRepRead.setClusterName("Tattooine5_CLUSTER");
		ClusterRep clusterRepUpdate = clusterRepDao
				.updateClusterRepBySystemId(clusterRepRead);
		logger.info("CLUSTER_REP_UPDATE_5:" + clusterRepUpdate);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_9",
				new Double(169), new Double(1), null, new Double(2), "red",
				"m9", new Double(7009), null);
		Star starAdd = starDao.addStar(star, clusterRepUpdate, SubClusterFactory.NONE.name());
		logger.info("STAR_READ_9:"+starAdd);
		starAdd.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate = starDao.updateStarByStarId(starAdd);
		logger.info("STAR_UPDATE_9:"+starUpdate);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_10",
				new Double(164), new Double(1), null, new Double(3), "red",
				"k1", new Double(7010), null);
		Star starAdd2 = starDao.addStarToNonSubCluster(star, starUpdate.getClusterToStarId());
		logger.info("STAR_READ_10:"+starAdd2);
		starAdd2.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate2 = starDao.updateStarByStarId(starAdd2);
		logger.info("STAR_UPDATE_10:"+starUpdate2);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_11",
				new Double(165), new Double(1), null, new Double(3.5), "red",
				"k2", new Double(7011), null);
		Star starAdd3 = starDao.addStarToNonSubCluster(star, starUpdate.getClusterToStarId());
		logger.info("STAR_READ_11:"+starAdd3);
		starAdd3.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate3 = starDao.updateStarByStarId(starAdd3);
		logger.info("STAR_UPDATE_11:"+starUpdate3);

		starDao.deleteStar(starUpdate);
		starDao.deleteStar(starUpdate2);
		starDao.deleteStar(starUpdate3);

		
		clusterRepDao.deleteClusterRep(clusterRepUpdate);
		systemDao.deleteSystem(systemRead);
	}

	@Test
	public void testCRUD_6() {

		Double ucoord = new Double(999999);
		Double vcoord = new Double(0);
		Double dist = new Double(999999);
		SystemDao systemDao = new SystemDao();
		ClusterRepDao clusterRepDao = new ClusterRepDao();
		StarDao starDao = new StarDao();

		Integer singStar = new Integer(875);
		String type = ClusterFactory.evaluateChance(singStar);
		logger.info("TYPE:"+type);
		system = new System(null, dist, ucoord, vcoord, null);
		System.genSystemName(system);
		System systemRead = systemDao.addSystem(system);
		clusterRep = new ClusterRep(null, systemRead.getSystemId(),
				system.getSystemName() + "_CLUSTER", null, null, null, null);
		logger.info("CLUSTER_REP:"+type);
		ClusterFactory.fromString(type).get().process(clusterRep);
		logger.info("CLUSTER_REP_6:" + clusterRep);
		ClusterRep clusterRepAdd = clusterRepDao.addClusterRep(clusterRep);
		ClusterRep clusterRepRead = clusterRepDao
				.readClusterRepById(clusterRepAdd.getClusterRepId());
		logger.info("CLUSTER_REP_READ_6:" + clusterRepRead);
		clusterRepRead.setClusterName("Tattooine6_CLUSTER");
		ClusterRep clusterRepUpdate = clusterRepDao
				.updateClusterRepBySystemId(clusterRepRead);
		logger.info("CLUSTER_REP_UPDATE_6:" + clusterRepUpdate);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_12",
				new Double(172), new Double(1), null, new Double(2), "red",
				"k3", new Double(7012), null);
		Star starAdd = starDao.addStar(star, clusterRepUpdate, SubClusterFactory.FOURSTAR_TRINARYPLUSONE.name());
		logger.info("STAR_READ_12:"+starAdd);
		starAdd.setNo_planets_allowed(Boolean.FALSE);
		Star starUpdate = starDao.updateStarByStarId(starAdd);
		logger.info("STAR_UPDATE_12:"+starUpdate);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_25x",
				new Double(295), new Double(1), null, new Double(2), "red",
				"m6", new Double(7295), null);
		Star starAddx = starDao.addStar(star, clusterRepUpdate, SubClusterFactory.NONE.name());
		logger.info("STAR_READ_25:"+starAddx);
		starAddx.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdateX = starDao.updateStarByStarId(starAddx);
		logger.info("STAR_UPDATE_25:"+starUpdateX);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_26x",
				new Double(296), new Double(1), null, new Double(3), "red",
				"m7", new Double(7096), null);
		Star starAddx2 = starDao.addStarToNonSubCluster(star, starUpdateX.getClusterToStarId());
		logger.info("STAR_READ_26:"+starAddx2);
		starAddx2.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdateX2 = starDao.updateStarByStarId(starAddx2);
		logger.info("STAR_UPDATE_26:"+starUpdateX2);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_27x",
				new Double(297), new Double(1), null, new Double(3.5), "red",
				"m8", new Double(7097), null);
		Star starAddx3 = starDao.addStarToNonSubCluster(star, starUpdateX.getClusterToStarId());
		logger.info("STAR_READ_27:"+starAddx3);
		starAddx3.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdateX3 = starDao.updateStarByStarId(starAddx3);
		logger.info("STAR_UPDATE_27:"+starUpdateX3);

		starDao.deleteStar(starUpdateX);
		starDao.deleteStar(starUpdateX2);
		starDao.deleteStar(starUpdateX3);
		starDao.deleteStar(starUpdate);
		clusterRepDao.deleteClusterRep(clusterRepUpdate);
		systemDao.deleteSystem(systemRead);
	}


	@Test
	public void testCRUD_7() {

		Double ucoord = new Double(999999);
		Double vcoord = new Double(0);
		Double dist = new Double(999999);
		SystemDao systemDao = new SystemDao();
		ClusterRepDao clusterRepDao = new ClusterRepDao();
		StarDao starDao = new StarDao();

		Integer singStar = new Integer(876);
		String type = ClusterFactory.evaluateChance(singStar);
		logger.info("TYPE:"+type);
		system = new System(null, dist, ucoord, vcoord, null);
		System.genSystemName(system);
		System systemRead = systemDao.addSystem(system);
		clusterRep = new ClusterRep(null, systemRead.getSystemId(),
				system.getSystemName() + "_CLUSTER", null, null, null, null);
		logger.info("CLUSTER_REP:"+type);
		ClusterFactory.fromString(type).get().process(clusterRep);
		logger.info("CLUSTER_REP_7:" + clusterRep);
		ClusterRep clusterRepAdd = clusterRepDao.addClusterRep(clusterRep);
		ClusterRep clusterRepRead = clusterRepDao
				.readClusterRepById(clusterRepAdd.getClusterRepId());
		logger.info("CLUSTER_REP_READ_7:" + clusterRepRead);
		clusterRepRead.setClusterName("Tattooine7_CLUSTER");
		ClusterRep clusterRepUpdate = clusterRepDao
				.updateClusterRepBySystemId(clusterRepRead);
		logger.info("CLUSTER_REP_UPDATE_7:" + clusterRepUpdate);

		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_13",
				new Double(173), new Double(1), null, new Double(2), "red",
				"k4", new Double(7013), null);
		Star starAdd = starDao.addStar(star, clusterRepUpdate, SubClusterFactory.FOURSTAR_2BINARIES_0.name());
		logger.info("STAR_READ_13:"+starAdd);
		starAdd.setNo_planets_allowed(Boolean.FALSE);
		Star starUpdate = starDao.updateStarByStarId(starAdd);
		logger.info("STAR_UPDATE_13:"+starUpdate);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_25x",
				new Double(295), new Double(1), null, new Double(2), "red",
				"m6", new Double(7295), null);
		Star starAddx = starDao.addStar(star, clusterRepUpdate, SubClusterFactory.FOURSTAR_2BINARIES_0.name());
		logger.info("STAR_READ_25:"+starAddx);
		starAddx.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdateX = starDao.updateStarByStarId(starAddx);
		logger.info("STAR_UPDATE_25:"+starUpdateX);

		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_14",
				new Double(174), new Double(1), null, new Double(3), "red",
				"k5", new Double(7014), null);
		Star starAdd2 = starDao.addStar(star, clusterRepUpdate, SubClusterFactory.FOURSTAR_2BINARIES_1.name());
		logger.info("STAR_READ_14:"+starAdd2);
		starAdd2.setNo_planets_allowed(Boolean.FALSE);
		Star starUpdate2 = starDao.updateStarByStarId(starAdd2);
		logger.info("STAR_UPDATE_14:"+starUpdate2);

		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_26x",
				new Double(296), new Double(1), null, new Double(3), "red",
				"m7", new Double(7096), null);
		Star starAddx2 = starDao.addStar(star, clusterRepUpdate, SubClusterFactory.FOURSTAR_2BINARIES_1.name());
		logger.info("STAR_READ_26:"+starAddx2);
		starAddx2.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdateX2 = starDao.updateStarByStarId(starAddx2);
		logger.info("STAR_UPDATE_26:"+starUpdateX2);

		starDao.deleteStar(starUpdate);
		starDao.deleteStar(starUpdate2);
		starDao.deleteStar(starUpdateX);
		starDao.deleteStar(starUpdateX2);
		clusterRepDao.deleteClusterRep(clusterRepUpdate);
		systemDao.deleteSystem(systemRead);
	}


	@Test
	public void testCRUD_8() {

		Double ucoord = new Double(999999);
		Double vcoord = new Double(0);
		Double dist = new Double(999999);
		SystemDao systemDao = new SystemDao();
		ClusterRepDao clusterRepDao = new ClusterRepDao();
		StarDao starDao = new StarDao();

		Integer singStar = new Integer(930);
		String type = ClusterFactory.evaluateChance(singStar);
		logger.info("TYPE:"+type);
		system = new System(null, dist, ucoord, vcoord, null);
		System.genSystemName(system);
		System systemRead = systemDao.addSystem(system);
		clusterRep = new ClusterRep(null, systemRead.getSystemId(),
				system.getSystemName() + "_CLUSTER", null, null, null, null);
		logger.info("CLUSTER_REP:"+type);
		ClusterFactory.fromString(type).get().process(clusterRep);
		logger.info("CLUSTER_REP_8:" + clusterRep);
		ClusterRep clusterRepAdd = clusterRepDao.addClusterRep(clusterRep);
		ClusterRep clusterRepRead = clusterRepDao
				.readClusterRepById(clusterRepAdd.getClusterRepId());
		logger.info("CLUSTER_REP_READ_8:" + clusterRepRead);
		clusterRepRead.setClusterName("Tattooine8_CLUSTER");
		ClusterRep clusterRepUpdate = clusterRepDao
				.updateClusterRepBySystemId(clusterRepRead);
		logger.info("CLUSTER_REP_UPDATE_8:" + clusterRepUpdate);

		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_15",
				new Double(175), new Double(1), null, new Double(2), "red",
				"k6", new Double(7015), null);
		Star starAdd = starDao.addStar(star, clusterRepUpdate, SubClusterFactory.NONE.name());
		logger.info("STAR_READ_15:"+starAdd);
		starAdd.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate = starDao.updateStarByStarId(starAdd);
		logger.info("STAR_UPDATE_15:"+starUpdate);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_16",
				new Double(176), new Double(1), null, new Double(3), "red",
				"k7", new Double(7016), null);
		Star starAdd2 = starDao.addStarToNonSubCluster(star, starUpdate.getClusterToStarId());
		logger.info("STAR_READ_16:"+starAdd2);
		starAdd2.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate2 = starDao.updateStarByStarId(starAdd2);
		logger.info("STAR_UPDATE_16:"+starUpdate2);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_17",
				new Double(177), new Double(1), null, new Double(3.5), "red",
				"k8", new Double(7017), null);
		Star starAdd3 = starDao.addStarToNonSubCluster(star, starUpdate.getClusterToStarId());
		logger.info("STAR_READ_17:"+starAdd3);
		starAdd3.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate3 = starDao.updateStarByStarId(starAdd3);
		logger.info("STAR_UPDATE_17:"+starUpdate3);

		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_18",
				new Double(178), new Double(1), null, new Double(3.5), "red",
				"k8", new Double(7017), null);
		Star starAdd4 = starDao.addStarToNonSubCluster(star, starUpdate.getClusterToStarId());
		logger.info("STAR_READ_18:"+starAdd4);
		starAdd4.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate4 = starDao.updateStarByStarId(starAdd4);
		logger.info("STAR_UPDATE_18:"+starUpdate4);

		starDao.deleteStar(starUpdate);
		starDao.deleteStar(starUpdate2);
		starDao.deleteStar(starUpdate3);
		starDao.deleteStar(starUpdate4);		
		
		clusterRepDao.deleteClusterRep(clusterRepUpdate);
		systemDao.deleteSystem(systemRead);
	}


	@Test
	public void testCRUD_9() {

		Double ucoord = new Double(999999);
		Double vcoord = new Double(0);
		Double dist = new Double(999999);
		SystemDao systemDao = new SystemDao();
		ClusterRepDao clusterRepDao = new ClusterRepDao();
		StarDao starDao = new StarDao();

		Integer singStar = new Integer(951);
		String type = ClusterFactory.evaluateChance(singStar);
		logger.info("TYPE:"+type);
		system = new System(null, dist, ucoord, vcoord, null);
		System.genSystemName(system);
		System systemRead = systemDao.addSystem(system);
		clusterRep = new ClusterRep(null, systemRead.getSystemId(),
				system.getSystemName() + "_CLUSTER", null, null, null, null);
		logger.info("CLUSTER_REP:"+type);
		ClusterFactory.fromString(type).get().process(clusterRep);
		logger.info("CLUSTER_REP_9:" + clusterRep);
		ClusterRep clusterRepAdd = clusterRepDao.addClusterRep(clusterRep);
		ClusterRep clusterRepRead = clusterRepDao
				.readClusterRepById(clusterRepAdd.getClusterRepId());
		logger.info("CLUSTER_REP_READ_9:" + clusterRepRead);
		clusterRepRead.setClusterName("Tattooine9_CLUSTER");
		ClusterRep clusterRepUpdate = clusterRepDao
				.updateClusterRepBySystemId(clusterRepRead);
		logger.info("CLUSTER_REP_UPDATE_9:" + clusterRepUpdate);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_19",
				new Double(179), new Double(1), null, new Double(2), "red",
				"k9", new Double(7029), null);
		Star starAdd = starDao.addStar(star, clusterRepUpdate, SubClusterFactory.FIVESTAR_FOURSTARSPREADPLUSONE.name());
		logger.info("STAR_READ_19:"+starAdd);
		starAdd.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate = starDao.updateStarByStarId(starAdd);
		logger.info("STAR_UPDATE_19:"+starUpdate);

		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_25x",
				new Double(295), new Double(1), null, new Double(2), "red",
				"m6", new Double(7295), null);
		Star starAddx = starDao.addStar(star, clusterRepUpdate, SubClusterFactory.NONE.name());
		logger.info("STAR_READ_25:"+starAddx);
		starAddx.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdateX = starDao.updateStarByStarId(starAddx);
		logger.info("STAR_UPDATE_25:"+starUpdateX);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_26x",
				new Double(296), new Double(1), null, new Double(3), "red",
				"m7", new Double(7096), null);
		Star starAddx2 = starDao.addStarToNonSubCluster(star, starUpdateX.getClusterToStarId());
		logger.info("STAR_READ_26:"+starAddx2);
		starAddx2.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdateX2 = starDao.updateStarByStarId(starAddx2);
		logger.info("STAR_UPDATE_26:"+starUpdateX2);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_27x",
				new Double(297), new Double(1), null, new Double(3.5), "red",
				"m8", new Double(7097), null);
		Star starAddx3 = starDao.addStarToNonSubCluster(star, starUpdateX.getClusterToStarId());
		logger.info("STAR_READ_27:"+starAddx3);
		starAddx3.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdateX3 = starDao.updateStarByStarId(starAddx3);
		logger.info("STAR_UPDATE_27:"+starUpdateX3);

		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_28x",
				new Double(298), new Double(1), null, new Double(3.2), "red",
				"m9", new Double(7098), null);
		Star starAddx4 = starDao.addStarToNonSubCluster(star, starUpdateX.getClusterToStarId());;
		logger.info("STAR_READ_28:"+starAddx4);
		starAddx4.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdateX4 = starDao.updateStarByStarId(starAddx4);
		logger.info("STAR_UPDATE_28:"+starUpdateX4);

		starDao.deleteStar(starUpdateX);
		starDao.deleteStar(starUpdateX2);
		starDao.deleteStar(starUpdateX3);
		starDao.deleteStar(starUpdateX4);		
		starDao.deleteStar(starUpdate);
		clusterRepDao.deleteClusterRep(clusterRepUpdate);
		systemDao.deleteSystem(systemRead);
	}

	@Test
	public void testCRUD_10() {

		Double ucoord = new Double(999999);
		Double vcoord = new Double(0);
		Double dist = new Double(999999);
		SystemDao systemDao = new SystemDao();
		ClusterRepDao clusterRepDao = new ClusterRepDao();
		StarDao starDao = new StarDao();

		Integer singStar = new Integer(985);
		String type = ClusterFactory.evaluateChance(singStar);
		logger.info("TYPE:"+type);
		system = new System(null, dist, ucoord, vcoord, null);
		System.genSystemName(system);
		System systemRead = systemDao.addSystem(system);
		clusterRep = new ClusterRep(null, systemRead.getSystemId(),
				system.getSystemName() + "_CLUSTER", null, null, null, null);
		logger.info("CLUSTER_REP:"+type);
		ClusterFactory.fromString(type).get().process(clusterRep);
		logger.info("CLUSTER_REP_10:" + clusterRep);
		ClusterRep clusterRepAdd = clusterRepDao.addClusterRep(clusterRep);
		ClusterRep clusterRepRead = clusterRepDao
				.readClusterRepById(clusterRepAdd.getClusterRepId());
		logger.info("CLUSTER_REP_READ_10:" + clusterRepRead);
		clusterRepRead.setClusterName("Tattooine10_CLUSTER");
		ClusterRep clusterRepUpdate = clusterRepDao
				.updateClusterRepBySystemId(clusterRepRead);
		logger.info("CLUSTER_REP_UPDATE_10:" + clusterRepUpdate);


		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_20",
				new Double(195), new Double(1), null, new Double(2), "red",
				"m1", new Double(7095), null);
		Star starAdd = starDao.addStar(star, clusterRepUpdate, SubClusterFactory.NONE.name());
		logger.info("STAR_READ_20:"+starAdd);
		starAdd.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate = starDao.updateStarByStarId(starAdd);
		logger.info("STAR_UPDATE_20:"+starUpdate);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_21",
				new Double(196), new Double(1), null, new Double(3), "red",
				"m2", new Double(7096), null);
		Star starAdd2 = starDao.addStarToNonSubCluster(star, starUpdate.getClusterToStarId());
		logger.info("STAR_READ_21:"+starAdd2);
		starAdd2.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate2 = starDao.updateStarByStarId(starAdd2);
		logger.info("STAR_UPDATE_21:"+starUpdate2);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_22",
				new Double(197), new Double(1), null, new Double(3.5), "red",
				"m3", new Double(7097), null);
		Star starAdd3 = starDao.addStarToNonSubCluster(star, starUpdate.getClusterToStarId());
		logger.info("STAR_READ_22:"+starAdd3);
		starAdd3.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate3 = starDao.updateStarByStarId(starAdd3);
		logger.info("STAR_UPDATE_22:"+starUpdate3);

		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_23",
				new Double(198), new Double(1), null, new Double(3.2), "red",
				"m4", new Double(7098), null);
		Star starAdd4 = starDao.addStarToNonSubCluster(star, starUpdate.getClusterToStarId());
		logger.info("STAR_READ_23:"+starAdd4);
		starAdd4.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate4 = starDao.updateStarByStarId(starAdd4);
		logger.info("STAR_UPDATE_23:"+starUpdate4);

		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_24",
				new Double(199), new Double(1), null, new Double(3.2), "red",
				"m5", new Double(7099), null);
		Star starAdd5 = starDao.addStarToNonSubCluster(star, starUpdate.getClusterToStarId());
		logger.info("STAR_READ_24:"+starAdd5);
		starAdd5.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate5 = starDao.updateStarByStarId(starAdd5);
		logger.info("STAR_UPDATE_24:"+starUpdate5);

		starDao.deleteStar(starUpdate);
		starDao.deleteStar(starUpdate2);
		starDao.deleteStar(starUpdate3);
		starDao.deleteStar(starUpdate4);		
		starDao.deleteStar(starUpdate5);	
		
		clusterRepDao.deleteClusterRep(clusterRepUpdate);
		systemDao.deleteSystem(systemRead);
	}

	@Test
	public void testCRUD_11() {

		Double ucoord = new Double(999999);
		Double vcoord = new Double(0);
		Double dist = new Double(999999);
		SystemDao systemDao = new SystemDao();
		ClusterRepDao clusterRepDao = new ClusterRepDao();
		StarDao starDao = new StarDao();

		Integer singStar = new Integer(998);
		String type = ClusterFactory.evaluateChance(singStar);
		logger.info("TYPE:"+type);
		system = new System(null, dist, ucoord, vcoord, null);
		System.genSystemName(system);
		System systemRead = systemDao.addSystem(system);
		clusterRep = new ClusterRep(null, systemRead.getSystemId(),
				system.getSystemName() + "_CLUSTER", null, null, null, null);
		logger.info("CLUSTER_REP:"+type);
		ClusterFactory.fromString(type).get().process(clusterRep);
		logger.info("CLUSTER_REP_11:" + clusterRep);
		ClusterRep clusterRepAdd = clusterRepDao.addClusterRep(clusterRep);
		ClusterRep clusterRepRead = clusterRepDao
				.readClusterRepById(clusterRepAdd.getClusterRepId());
		logger.info("CLUSTER_REP_READ_11:" + clusterRepRead);
		clusterRepRead.setClusterName("Tattooine11_CLUSTER");
		ClusterRep clusterRepUpdate = clusterRepDao
				.updateClusterRepBySystemId(clusterRepRead);
		logger.info("CLUSTER_REP_UPDATE_11:" + clusterRepUpdate);

		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_25",
				new Double(295), new Double(1), null, new Double(2), "red",
				"m6", new Double(7295), null);
		Star starAdd = starDao.addStar(star, clusterRepUpdate, SubClusterFactory.NONE.name());
		logger.info("STAR_READ_25:"+starAdd);
		starAdd.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate = starDao.updateStarByStarId(starAdd);
		logger.info("STAR_UPDATE_25:"+starUpdate);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_26",
				new Double(296), new Double(1), null, new Double(3), "red",
				"m7", new Double(7096), null);
		Star starAdd2 = starDao.addStarToNonSubCluster(star, starUpdate.getClusterToStarId());
		logger.info("STAR_READ_26:"+starAdd2);
		starAdd2.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate2 = starDao.updateStarByStarId(starAdd2);
		logger.info("STAR_UPDATE_26:"+starUpdate2);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_27",
				new Double(297), new Double(1), null, new Double(3.5), "red",
				"m8", new Double(7097), null);
		Star starAdd3 = starDao.addStarToNonSubCluster(star, starUpdate.getClusterToStarId());
		logger.info("STAR_READ_27:"+starAdd3);
		starAdd3.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate3 = starDao.updateStarByStarId(starAdd3);
		logger.info("STAR_UPDATE_27:"+starUpdate3);

		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_28",
				new Double(298), new Double(1), null, new Double(3.2), "red",
				"m9", new Double(7098), null);
		Star starAdd4 = starDao.addStarToNonSubCluster(star, starUpdate.getClusterToStarId());
		logger.info("STAR_READ_28:"+starAdd4);
		starAdd4.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate4 = starDao.updateStarByStarId(starAdd4);
		logger.info("STAR_UPDATE_28:"+starUpdate4);

		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_29",
				new Double(199), new Double(1), null, new Double(3.2), "red",
				"f1", new Double(7099), null);
		Star starAdd5 = starDao.addStarToNonSubCluster(star, starUpdate.getClusterToStarId());
		logger.info("STAR_READ_29:"+starAdd5);
		starAdd5.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate5 = starDao.updateStarByStarId(starAdd5);
		logger.info("STAR_UPDATE_29:"+starUpdate5);

		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_30",
				new Double(199), new Double(1), null, new Double(3.2), "red",
				"f2", new Double(7199), null);
		Star starAdd6 = starDao.addStarToNonSubCluster(star, starUpdate.getClusterToStarId());
		logger.info("STAR_READ_29:"+starAdd6);
		starAdd6.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdate6 = starDao.updateStarByStarId(starAdd6);
		logger.info("STAR_UPDATE_29:"+starUpdate6);

		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_25x",
				new Double(295), new Double(1), null, new Double(2), "red",
				"m6", new Double(7295), null);
		Star starAddx = starDao.addStarToNonSubCluster(star, starUpdate.getClusterToStarId());
		logger.info("STAR_READ_25:"+starAddx);
		starAddx.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdateX = starDao.updateStarByStarId(starAddx);
		logger.info("STAR_UPDATE_25:"+starUpdateX);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_26x",
				new Double(296), new Double(1), null, new Double(3), "red",
				"m7", new Double(7096), null);
		Star starAddx2 = starDao.addStarToNonSubCluster(star, starUpdate.getClusterToStarId());
		logger.info("STAR_READ_26:"+starAddx2);
		starAddx2.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdateX2 = starDao.updateStarByStarId(starAddx2);
		logger.info("STAR_UPDATE_26:"+starUpdateX2);
		
		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_27x",
				new Double(297), new Double(1), null, new Double(3.5), "red",
				"m8", new Double(7097), null);
		Star starAddx3 = starDao.addStarToNonSubCluster(star, starUpdate.getClusterToStarId());
		logger.info("STAR_READ_27:"+starAddx3);
		starAddx3.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdateX3 = starDao.updateStarByStarId(starAddx3);
		logger.info("STAR_UPDATE_27:"+starUpdateX3);

		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_28x",
				new Double(298), new Double(1), null, new Double(3.2), "red",
				"m9", new Double(7098), null);
		Star starAddx4 = starDao.addStarToNonSubCluster(star, starUpdate.getClusterToStarId());
		logger.info("STAR_READ_28:"+starAddx4);
		starAddx4.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdateX4 = starDao.updateStarByStarId(starAddx4);
		logger.info("STAR_UPDATE_28:"+starUpdateX4);

		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_29x",
				new Double(199), new Double(1), null, new Double(3.2), "red",
				"f1", new Double(7099), null);
		Star starAddx5 = starDao.addStarToNonSubCluster(star, starUpdate.getClusterToStarId());
		logger.info("STAR_READ_29:"+starAddx5);
		starAddx5.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdateX5 = starDao.updateStarByStarId(starAddx5);
		logger.info("STAR_UPDATE_29:"+starUpdateX5);

		star = new Star(null, 0, clusterRepUpdate.getClusterName() + "_STAR_30x",
				new Double(199), new Double(1), null, new Double(3.2), "red",
				"f2", new Double(7199), null);
		Star starAddx6 = starDao.addStarToNonSubCluster(star, starUpdate.getClusterToStarId());
		logger.info("STAR_READ_29:"+starAddx6);
		starAddx6.setNo_planets_allowed(Boolean.TRUE);
		Star starUpdateX6 = starDao.updateStarByStarId(starAddx6);
		logger.info("STAR_UPDATE_29:"+starUpdateX6);
		
		List<Star> starList = starDao.readStarsInCluster(clusterRepUpdate);
		short count = 0;
		for (Star star: starList){
			logger.info("STAR"+count+":" + star);
			++count;
		}

		String s_type  = starDao.readStarsSubClusterDescription(starUpdateX6);
		logger.info("STAR_SUB_CLUSTER_DESCRIPTION:"+s_type);

		starDao.deleteStar(starUpdateX);
		starDao.deleteStar(starUpdateX2);
		starDao.deleteStar(starUpdateX3);
		starDao.deleteStar(starUpdateX4);		
		starDao.deleteStar(starUpdateX5);			
		starDao.deleteStar(starUpdateX6);			
		starDao.deleteStar(starUpdate);
		starDao.deleteStar(starUpdate2);
		starDao.deleteStar(starUpdate3);
		starDao.deleteStar(starUpdate4);		
		starDao.deleteStar(starUpdate5);			
		starDao.deleteStar(starUpdate6);			
		
		clusterRepDao.deleteClusterRep(clusterRepUpdate);
		systemDao.deleteSystem(systemRead);
	}

}
