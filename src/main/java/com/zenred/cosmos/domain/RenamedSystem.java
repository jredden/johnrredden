package com.zenred.cosmos.domain;

import java.util.ArrayList;
import java.util.List;

public class RenamedSystem {
	
	private System system;
	private RenameDao renameDao;
	private SystemDao systemDao;
	private List<String> renames;
	
	public RenamedSystem(){
		systemDao = new SystemDao();
		renameDao = new RenameDao();
	}

	public void readNamedSystemByUVCoordinates(Integer i_Ucoordinate, Integer i_Vcoordinate, String genericName){
		system = systemDao.readSystemByUVCoordinates(i_Ucoordinate, i_Vcoordinate);
		List<Rename> l_renames = renameDao.fetchRenamesForGenericName(genericName);
		renames = new ArrayList<String>();
		for(int idex =0; idex <l_renames.size(); idex++ ){
			renames.add(l_renames.get(idex).getRenameName());
		}
	}
	
	public System fetchSystem(){
		return system;
	}
	
	public List<String> fetchRenames(){
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
