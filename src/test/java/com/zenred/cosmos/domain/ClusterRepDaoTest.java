package com.zenred.cosmos.domain;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

public class ClusterRepDaoTest {

	static private Logger logger = Logger.getLogger(ClusterRepDaoTest.class);
	private static System system;
	private static ClusterRep clusterRep;

	@Test
	public void testCRUD_0() {

		Double ucoord = new Double(999999);
		Double vcoord = new Double(0);
		Double dist = new Double(999999);
		SystemDao systemDao = new SystemDao();
		ClusterRepDao clusterRepDao = new ClusterRepDao();

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
		systemDao.deleteSystem(systemRead);
	}

	@Test
	public void testCRUD_3() {

		Double ucoord = new Double(999999);
		Double vcoord = new Double(0);
		Double dist = new Double(999999);
		SystemDao systemDao = new SystemDao();
		ClusterRepDao clusterRepDao = new ClusterRepDao();

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
		clusterRepDao.deleteClusterRep(clusterRepUpdate);
		systemDao.deleteSystem(systemRead);
	}

}
