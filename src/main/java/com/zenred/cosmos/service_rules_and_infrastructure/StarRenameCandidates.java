package com.zenred.cosmos.service_rules_and_infrastructure;

import java.util.ArrayList;
import java.util.List;

import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.ReadAllStars;
import com.zenred.cosmos.domain.Rename;
import com.zenred.cosmos.domain.RenameDao;
import com.zenred.cosmos.domain.RenameObjectType;

public class StarRenameCandidates {
	
	/**
	 * 
	 * Existing aliases are returned with the generic name
	 * 
	 * @return a list of Stars to give alternate names
	 */
	
	public List<RenameCandidates> buildList(){
		List<Star> StarList = new ReadAllStars().get();
		List<RenameCandidates> renameCandidates = new ArrayList<RenameCandidates>();
		RenameDao renameDao = new RenameDao();
		for(Star Star : StarList){
			RenameCandidates renameCandidate = new RenameCandidates();
			renameCandidate.setGenericName(Star.getName());
			renameCandidate.setRenameObjectType(RenameObjectType.STAR);
			Integer count = renameDao.allreadyThere(Star.getStarId());
			if(count > 0){
				List<Rename> renames = renameDao.fetchRenamesForGenericName(Star.getName());
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
