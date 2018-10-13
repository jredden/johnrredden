package com.zenred.cosmos.service_rules_and_infrastructure;

import java.util.ArrayList;
import java.util.List;

import com.zenred.cosmos.domain.ClusterRep;
import com.zenred.cosmos.domain.ReadAllClusters;
import com.zenred.cosmos.domain.Rename;
import com.zenred.cosmos.domain.RenameDao;
import com.zenred.cosmos.domain.RenameObjectType;

public class ClusterRenameCandidates {
	
	/**
	 * 
	 * Existing aliases are returned with the generic name
	 * 
	 * @return a list of ClusterReps to give alternate names
	 */
	
	public List<RenameCandidates> buildList(){
		List<ClusterRep> ClusterRepList = new ReadAllClusters().get();
		List<RenameCandidates> renameCandidates = new ArrayList<RenameCandidates>();
		RenameDao renameDao = new RenameDao();
		for(ClusterRep ClusterRep : ClusterRepList){
			RenameCandidates renameCandidate = new RenameCandidates();
			renameCandidate.setGenericName(ClusterRep.getClusterName());
			renameCandidate.setRenameObjectType(RenameObjectType.CLUSTER);
			Integer count = renameDao.allreadyThere(ClusterRep.getClusterRepId());
			if(count > 0){
				List<Rename> renames = renameDao.fetchRenamesForGenericName(ClusterRep.getClusterName());
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
