package com.zenred.cosmos.domain;

import static org.junit.Assert.assertTrue;
import org.apache.log4j.Logger;

import org.junit.Test;

public class RenameDaoTest {
	
	static private Logger logger = Logger.getLogger(RenameDaoTest.class);

	@Test
	public void testCRUD_0() {
		
		RenameDao renameDao = new RenameDao();
		StarDao starDao = new StarDao();
		String genericName = starDao.readNameOfRandomStar();
		Integer renameId = renameDao.addNewName(RenameObjectType.STAR, 999999, "froBozz", genericName);
		Integer renameCount = renameDao.allreadyThere(999999);
		logger.info("rename count:" + renameCount + " renameId:" + renameId);
		renameDao.deleteRename(renameId);
		
	}

}
