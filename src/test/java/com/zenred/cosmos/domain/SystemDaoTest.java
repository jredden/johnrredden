package com.zenred.cosmos.domain;

import static org.junit.Assert.assertTrue;
import org.apache.log4j.Logger;

import org.junit.Test;

public class SystemDaoTest {
	
	static private Logger logger = Logger.getLogger(SystemDaoTest.class);
	private static System system;

	@Test
	public void testCRUD() {
		
		Double ucoord = new Double(999999);
		Double vcoord = new Double(0);
		Double dist = new Double(999999);
		SystemDao systemDao = new SystemDao();

		system = new System(null, dist, ucoord, vcoord, null);
		System.genSystemName(system);
		System systemRead = systemDao.addSystem(system);
		logger.info("CREATE:"+systemRead);
		systemRead.setSystemName("Tatooeine");
		System systemUpdated = systemDao.updateSystemBySystemId(systemRead);
		logger.info("UPDATE:"+systemUpdated);
		System systemReadId = systemDao.readSystemById(systemUpdated.getSystemId());
		logger.info("READ_ID:"+systemReadId);
		System systemReadName = systemDao.readSystemByName(systemReadId.getSystemName());
		logger.info("READ_NAME:"+systemReadName);
		systemDao.deleteSystem(systemReadName);
	}

}
