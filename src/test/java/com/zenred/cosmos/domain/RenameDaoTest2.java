package com.zenred.cosmos.domain;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;

import org.junit.Test;

public class RenameDaoTest2 {
	
	static private Logger logger = Logger.getLogger(RenameDaoTest2.class);

	@Test
	public void testCRUD_1() {
		
		RenameDao renameDao = new RenameDao();
		StarDao starDao = new StarDao();
		String genericName_0 = starDao.readNameOfRandomStar();
		Integer renameId_0 = renameDao.addNewName(RenameObjectType.STAR, 999999, "froBozz_0", genericName_0);
		Integer renameCount_0 = renameDao.allreadyThere(999999);
		logger.info("rename count:" + renameCount_0 + " renameId:" + renameId_0);
		Integer renameId_1 = renameDao.addNewName(RenameObjectType.STAR, 999999, "froBozz_1", genericName_0);
		Integer renameCount_1 = renameDao.allreadyThere(999999);
		logger.info("rename count:" + renameCount_1 + " renameId:" + renameId_1);
		Integer renameId_2 = renameDao.addNewName(RenameObjectType.STAR, 999999, "froBozz_2", genericName_0);
		Integer renameCount_2 = renameDao.allreadyThere(999999);
		logger.info("rename count:" + renameCount_2 + " renameId:" + renameId_2);
		Integer renameId_3 = renameDao.addNewName(RenameObjectType.STAR, 999999, "froBozz_3", genericName_0);
		Integer renameCount_3 = renameDao.allreadyThere(999999);
		logger.info("rename count:" + renameCount_3 + " renameId:" + renameId_3);
		
		List<Rename> renames = renameDao.fetchRenamesForGenericName(genericName_0);
		for (Rename rename : renames){
			logger.info(rename);
		}
		renameDao.deleteRename(renameId_0);
		renameDao.deleteRename(renameId_1);
		renameDao.deleteRename(renameId_2);
		renameDao.deleteRename(renameId_3);
		
	}

}
