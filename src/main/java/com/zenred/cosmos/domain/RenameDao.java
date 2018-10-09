package com.zenred.cosmos.domain;

import java.util.ArrayList;
import java.util.List;
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
	
	private static String renamesForAGenericName = "SELECT "
			+ "rn." + RENAMEID
			+ ",rn." + OBJECTID
			+ ",rn." + OBJECTTYPE
			+ ",rn." + GENERICNAME
			+ ",rn." + RENAMENAME
			+ ",rn." + RENAMECOUNT
			+ ",rn." + DATESTAMP
			+ " FROM " + RENAME + " rn "
			+ " WHERE rn." + GENERICNAME + " = ? "
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

		Integer renameCount = allreadyThere(objectId);
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
	public Integer allreadyThere(Integer objectId){
		Object[] param = {objectId};
		Integer renameCount = super.jdbcSetUp().getSimpleJdbcTemplate().queryForInt(existanceCheck, param);
		return renameCount;
	}
	/*
	 * fetches a list of aliases for a renamed entity
	 */
	public List<Rename> fetchRenamesForGenericName(String genericName){
		List<Rename> renameList = new ArrayList<Rename>();
		Object[] param = {genericName};
		List<Map<String, Object>> renameListMap = super.jdbcSetUp().getSimpleJdbcTemplate().queryForList(renamesForAGenericName, param);
		for(Map<String, Object> renameMap : renameListMap){
			Rename rename = new Rename();
			rename.setDatestamp(renameMap.get(DATESTAMP).toString());
			rename.setGenericName(renameMap.get(GENERICNAME).toString());
			rename.setObjectId(new Integer(renameMap.get(OBJECTID).toString()));
			rename.setRenameCount(new Integer(renameMap.get(RENAMECOUNT).toString()));
			rename.setRenameId(new Integer(renameMap.get(RENAMEID).toString()));
			rename.setRenameName(renameMap.get(RENAMENAME).toString());
			rename.setRenameObjectType(RenameObjectType.valueOf(renameMap.get(OBJECTTYPE).toString()));
			renameList.add(rename);
		}
		return renameList;
		
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
