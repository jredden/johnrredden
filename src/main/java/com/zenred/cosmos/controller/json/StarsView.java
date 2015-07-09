package com.zenred.cosmos.controller.json;

import com.zenred.cosmos.vizualization.ClusterResponse;
import com.zenred.johntredden.controller.json.AbstractJsonView;

public class StarsView extends AbstractJsonView {

	public StarsView(){
		super(ClusterResponse.class);
	}
}
