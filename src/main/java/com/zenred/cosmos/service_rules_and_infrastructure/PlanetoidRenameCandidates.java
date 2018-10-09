package com.zenred.cosmos.service_rules_and_infrastructure;

import java.util.ArrayList;
import java.util.List;

import com.zenred.cosmos.domain.Planetoid;
import com.zenred.cosmos.domain.ReadAllPlanetoids;
import com.zenred.cosmos.domain.Rename;
import com.zenred.cosmos.domain.RenameDao;
import com.zenred.cosmos.domain.RenameObjectType;

public class PlanetoidRenameCandidates {
	
	/**
	 * 
	 * Existing aliases are returned with the generic name
	 * 
	 * @return a list of planetoids to give alternate names
	 */
	
	List<RenameCandidates> buildList(){
		List<Planetoid> planetoidList = new ReadAllPlanetoids().get();
		List<RenameCandidates> renameCandidates = new ArrayList<RenameCandidates>();
		RenameDao renameDao = new RenameDao();
		for(Planetoid planetoid : planetoidList){
			RenameCandidates renameCandidate = new RenameCandidates();
			renameCandidate.setGenericName(planetoid.getPlanetoidName());
			renameCandidate.setRenameObjectType(RenameObjectType.PLANETOID);
			Integer count = renameDao.allreadyThere(planetoid.getPlanetoidId());
			if(count > 0){
				List<Rename> renames = renameDao.fetchRenamesForGenericName(planetoid.getPlanetoidName());
				List<String> s_renames = new ArrayList<String>();
				for (Rename rename : renames){
					s_renames.add(rename.getRenameName());
				}
				renameCandidate.setRenames(s_renames);
			}
			renameCandidates.add(renameCandidate);
		}
		return renameCandidates;
	}

}
