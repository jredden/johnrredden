package com.zenred.cosmos.controller.json;

import com.zenred.cosmos.vizualization.RenamePlanetoidsResponse;
import com.zenred.johntredden.controller.json.AbstractJsonView;


// Rename Planetoid Response should be the shared rename view
public class IsRenameView extends AbstractJsonView{
	
	public IsRenameView(){
		super(RenamePlanetoidsResponse.class);
	}

}
