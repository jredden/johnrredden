package com.zenred.cosmos.controller.json;

import com.zenred.cosmos.vizualization.RenamePlanetoidsResponse;
import com.zenred.johntredden.controller.json.AbstractJsonView;

public class RenameStarsView extends AbstractJsonView{
	
	public RenameStarsView(){
		super(RenamePlanetoidsResponse.class);
	}

}
