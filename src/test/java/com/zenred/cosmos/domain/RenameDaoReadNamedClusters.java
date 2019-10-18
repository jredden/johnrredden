package com.zenred.cosmos.domain;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import org.junit.Test;

public class RenameDaoReadNamedClusters {
	
	static private Logger logger = Logger.getLogger(RenameDaoReadNamedClusters.class);

	@Test
	public void testCRUD_Clusters() {
		
		RenameDao renameDao = new RenameDao();
		List<Rename> renameList;
		renameList = renameDao.fetchRenamesForType(RenameObjectType.CLUSTER);
		for(Rename renameListInstance : renameList){
			logger.info("rename-object"+renameListInstance);
		}
	}

}
