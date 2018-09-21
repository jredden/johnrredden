package com.zenred.cosmos.domain;

import java.util.Map;

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
	
	private static String nameAlreadyStored = "SELECT "
			+ RENAMECOUNT 
			+ " FROM "
			+ RENAME
			+ " WHERE "
			+ RENAMENAME 
			+ " = ?"
	;
	
	
	/**
	 * Add a name associated to the generic generated name of the planar, star or cluster
	 * 
	 * @param renameObjectType
	 * @param objectId
	 * @param Rename
	 * @return
	 */
	public String addNewName(RenameObjectType renameObjectType, Integer objectId, String Rename){
		
		
		return null;
	}
	
	/**
	 * 
	 * @param reNameName
	 * @return 0 if not there else != 0 if there
	 */
	public Integer alreadyThere(String reNameName){
		Object[] param = {reNameName};
		Map<String, Object> renameMap = super.jdbcSetUp().getSimpleJdbcTemplate().queryForMap(nameAlreadyStored, param);
		String s_renameCount = renameMap.get(RENAMECOUNT).toString();
		Integer renameCount = new Integer(s_renameCount);
		return renameCount;
	}

}
