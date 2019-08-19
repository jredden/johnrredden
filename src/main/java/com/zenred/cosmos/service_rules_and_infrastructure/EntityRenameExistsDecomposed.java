package com.zenred.cosmos.service_rules_and_infrastructure;

import java.util.HashMap;
import java.util.Map;

import com.zenred.cosmos.domain.Rename;
import com.zenred.cosmos.domain.RenameDao;

import java.util.List;

public class EntityRenameExistsDecomposed {
	
	private static RenameDao renameDAO = new RenameDao();
	
	interface RenameType{
		List<Rename> invokeDomain(String genericName);
	}
	public static String CLUSTER = new String("CLUSTER");
	public static String STAR = new String("STAR");
	public static String PLANAR = new String("PLANAR");
	
	private static Map<String, RenameType> typeMap = new HashMap<String, RenameType>();
	private static RenameType clusterType = new RenameType() {
		
		@Override
		public List<Rename> invokeDomain(String genericName) {
			return renameDAO.fetchRenamesForGenericName(genericName);
		}
	};
	private static RenameType starType = new RenameType() {
		
		@Override
		public List<Rename> invokeDomain(String genericName) {
			return renameDAO.fetchRenamesForGenericName(genericName);
		}
	};
	private static RenameType planarType = new RenameType() {
		
		@Override
		public List<Rename> invokeDomain(String genericName) {
			return renameDAO.fetchRenamesForGenericName(genericName);
		}
	};

	static{
		typeMap.put(CLUSTER, clusterType);
		typeMap.put(STAR, starType);
		typeMap.put(PLANAR, planarType);
	}
	
	public static List<Rename> doesEntryExist(String type, String genericName){
		RenameType renameType = typeMap.get(type);
		return renameType.invokeDomain(genericName);
	}
}
