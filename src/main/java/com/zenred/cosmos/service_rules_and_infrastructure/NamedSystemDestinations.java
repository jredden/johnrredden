package com.zenred.cosmos.service_rules_and_infrastructure;

import com.zenred.cosmos.domain.RenameObjectType;
import com.zenred.cosmos.vizualization.GenericRenameResponseForDestintion;

import java.util.ArrayList;
import java.util.List;

import com.zenred.cosmos.domain.Rename;
import com.zenred.cosmos.domain.RenameDao;

public class NamedSystemDestinations {

	public static List<GenericRenameResponseForDestintion> returnSelections(RenameObjectType renameObjectType){
		List<GenericRenameResponseForDestintion> destinationList = new ArrayList<GenericRenameResponseForDestintion>();
		RenameDao renameDao = new RenameDao();
		List<Rename> renameList = renameDao.fetchRenamesForType(renameObjectType);
		for(Rename rename : renameList){
			DecodeName.UVcoordinate uvVcoordinate = DecodeName.nameToUV(rename.getGenericName());
			GenericRenameResponseForDestintion genericRenameResponseForDestintion = new GenericRenameResponseForDestintion();
			genericRenameResponseForDestintion.setGenericName(rename.getGenericName());
			genericRenameResponseForDestintion.setRenameName(rename.getRenameName());
			genericRenameResponseForDestintion.setRenameObjectType(rename.getRenameObjectType().name());
			genericRenameResponseForDestintion.setuDimension(uvVcoordinate.getU());
			genericRenameResponseForDestintion.setvDimension(uvVcoordinate.getV());
			destinationList.add(genericRenameResponseForDestintion);
		}
		return destinationList;
	}
	
}
