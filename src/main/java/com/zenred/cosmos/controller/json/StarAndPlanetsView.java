package com.zenred.cosmos.controller.json;

import com.zenred.cosmos.vizualization.PlanetsResponse;
import com.zenred.johntredden.controller.json.AbstractJsonView;

public class StarAndPlanetsView extends AbstractJsonView {
	public StarAndPlanetsView(){
		super(PlanetsResponse.class);
	}
}
