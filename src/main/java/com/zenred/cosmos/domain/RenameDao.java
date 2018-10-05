package com.zenred.cosmos.domain;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

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
	
	private static String lastRenameInsertSql = "SELECT MAX(" + RENAMEID + ") FROM " + RENAME
	;
	
	private static String deleteRename = "DELETE FROM " + RENAME + " WHERE " + RENAMEID + " = ?"
	;
	
	
	/**
	 * Add a name associated to the generic generated name of the planar, star or cluster
	 * 
	 * @param renameObjectType
	 * @param objectId
	 * @param Rename
	 * @return
	 */
	@Transactional
	public Integer addNewName(RenameObjectType renameObjectType, Integer objectId, String rename, String genericName) {

		Integer renameCount = allreadyThere(rename);
		renameCount += 1;
		Map<String, Object> newNameMap = Rename.getRenameMap(renameObjectType.getName().objectName(), genericName,
				rename, renameCount, objectId);
		super.jdbcInsertSetup().withTableName(RENAME).usingColumns(Rename.csvRename()).execute(newNameMap);
		Integer renameId = super.jdbcSetUp().getSimpleJdbcTemplate().queryForInt(lastRenameInsertSql);
		return renameId;
	}
	
	/**
	 * 
	 * @param reNameName
	 * @return 0 if not there else != 0 if there
	 */
	@Transactional
	public Integer allreadyThere(String reNameName){
		Object[] param = {reNameName};
		Integer renameCount = super.jdbcSetUp().getSimpleJdbcTemplate().queryForInt(existanceCheck, param);
		if(renameCount > 0){
			Map<String, Object> renameMap = super.jdbcSetUp().getSimpleJdbcTemplate().queryForMap(nameAlreadyStored, param);
			String s_renameCount = renameMap.get(RENAMECOUNT).toString();
			renameCount = new Integer(s_renameCount);
		}
		return renameCount;
	}
	
	@Transactional
	/**
	 * 
	 * @param renameId
	 */
	public void deleteRename(Integer renameId){
		super.jdbcSetUp()
		.getSimpleJdbcTemplate()
		.update(deleteRename, new Object[] {renameId}
		);
	}

}
