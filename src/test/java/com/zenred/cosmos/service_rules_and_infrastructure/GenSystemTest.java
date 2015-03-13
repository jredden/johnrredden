package com.zenred.cosmos.service_rules_and_infrastructure;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zenred.cosmos.domain.SystemDao;

public class GenSystemTest {

	private static Logger logger = Logger.getLogger(GenSystemTest.class);
	private static SystemDao systemDao = new SystemDao();

	@Test
	public void test() {
		List<com.zenred.cosmos.domain.System> systems = new ArrayList<com.zenred.cosmos.domain.System>();
		for (int vbl = 0; vbl < 1000; vbl++) {
			com.zenred.cosmos.domain.System system = GenSystem.genSystem();
			com.zenred.cosmos.domain.System readSystem = GenSystem
					.candidate(system);
			logger.info("SYSTEM_" + vbl + ":" + readSystem);
			systems.add(readSystem);
		}

		// cleanup
		for (com.zenred.cosmos.domain.System system : systems) {
			systemDao.deleteSystem(system);
		}
	}

}
