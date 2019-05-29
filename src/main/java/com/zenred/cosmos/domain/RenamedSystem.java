package com.zenred.cosmos.domain;

import java.util.List;

public class RenamedSystem {
	
	private System system;
	private RenameDao renameDao;
	private SystemDao systemDao;
	private List<Rename> renames;
	
	public RenamedSystem(){
		systemDao = new SystemDao();
		renameDao = new RenameDao();
	}

	void readNamedSystemByUVCoordinates(Integer i_Ucoordinate, Integer i_Vcoordinate, String genericName){
		system = systemDao.readSystemByUVCoordinates(i_Ucoordinate, i_Vcoordinate);
		renames = renameDao.fetchRenamesForGenericName(genericName);
	}
	
	public System fetchSystem(){
		return system;
	}
	
	public List<Rename> fetchRenames(){
		return renames;
	}
	
	public Boolean doesSystemExist(Double d_Ucoordinate, Double d_Vcoordinate){
		return systemDao.doesSystemExist(d_Ucoordinate, d_Vcoordinate);
	}

	@Override
	public String toString() {
		return "RenamedSystem [system=" + system + ", renames=" + renames + "]";
	}
}
