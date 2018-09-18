package com.zenred.cosmos.domain;

import org.apache.log4j.Logger;

import com.zenred.johntredden.domain.AbstractJDBCDao;

public class RenameDao extends AbstractJDBCDao {
	
	static private Logger logger = Logger.getLogger(RenameDao.class);
	
	public static String RENAME = "`Rename`";
	public static String RENAMEID = "renameId";
	public static String OBJECTID = "objectId";
	public static String OBJECTTYPE = "objectType";
	public static String GENERICNAME = "genericName";
	public static String RENAMENAME = "renameName";
	public static String RENAMECOUNT = "renameCount";
	public static String DATESTAMP = "datestamp";
	
	// select count(renameName) from `Rename` where objectid = 999;
	
	private static String existanceCheck = "SELECT COUNT("
			+ RENAMENAME
			+") FROM " + RENAME
			+ " WHERE "
			+ OBJECTID 
			+ " = ? "
	;

}
